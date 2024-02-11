package com.dydbs.endpoint;

import java.util.HashMap;

import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.ActionElementBase;

public class LoadAnn extends ActionElementBase {

	@Override
	public void doAction(String arg0, ActionElementData data) throws Exception {
		try {
			HashMap<String, HashMap<String, String>> strAnnMap = (HashMap<String, HashMap<String, String>>) data
					.getApplicationAPI().getApplicationData("csoAnnMap");      // getting "csoAnnMap" values from JAXB class

			String nextKey = (String) data.getSessionData("nextKey");
			System.out.println("nextKey------" + nextKey);
			HashMap<String, String> xKeyValues = strAnnMap.get(nextKey);

			if (xKeyValues != null) {
				String prompts = xKeyValues.get("PROMPTS");
				String bargein = xKeyValues.get("BARGEIN");
				String next_node = xKeyValues.get("NEXT_NODE");

				data.setSessionData("prompts", prompts);
				data.setSessionData("bargein", bargein);
				data.setSessionData("nextNode", next_node);

				System.out.println("prompts------" + prompts);
				System.out.println("Bargein------" + bargein);
				System.out.println("nextNode------" + next_node);

			} else {
				System.out.println("Key not found: " + nextKey);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
