package com.MAEXP.Package;

import java.util.HashMap;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckGrammar2 extends DecisionElementBase {

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {
		//Getting M0001 audio node value
		String menuValue = (String) data.getElementData("MAForm2", "value");

		String[] gram = ((String) data.getSessionData("grammar")).split(",");
		String[] node = ((String) data.getSessionData("nextNode")).split(",");
		
//		String message = "Failure";
		String message = null;
		HashMap<String, String> keyAndNode = new HashMap<>();

		for (int i = 0; i < gram.length; i++) {
			keyAndNode.put(gram[i], node[i]);            // setting grammer and nextnode as key, value pair . eg - for "grammer 1" -> "NM:IBCSO"         
		}

		for (String grammarElement : gram) {        
			if (grammarElement.equalsIgnoreCase(menuValue)) {

				String vs = keyAndNode.get(menuValue);

				String Arr[] = vs.split(":");
				data.setSessionData("nextNode", Arr[0]);
				data.setSessionData("nextKey", Arr[1]);
				
				message = menuValue.toString();
			
				break;
			}
			
		}
		return message;

	}

}
