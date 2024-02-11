package com.test;

import java.util.logging.Logger;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;
import com.audium.server.xml.DecisionElementConfig;

public class CheckOptions extends DecisionElementBase{

	@Override
	public String doDecision(String arg0, DecisionElementData arg1) throws Exception {
				
		String langSel = arg1.getElementData("LangSel", "value");
		arg1.addToLog("LAngauage seleection number : ", langSel);
		  
		int val = Integer.parseInt(langSel);
		  
		String nextNode = "";
		  
		if(val==1) {
			nextNode = "English";
		}
		
		else if(val==2) {
			nextNode = "Spanish";
		}
		
		else if(val==3) {
			nextNode = "Arabic";
		}
		else {
			
		}
		
		
		return nextNode;
	}
}
