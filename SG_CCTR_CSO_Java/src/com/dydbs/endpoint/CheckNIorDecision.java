package com.dydbs.endpoint;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckNIorDecision extends DecisionElementBase {

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {
		String NoInput_NextNode = (String) data.getSessionData("noInputPrompt");

		if (NoInput_NextNode.contains(":")) {
			String Arr[] = NoInput_NextNode.split(":");
			data.setSessionData("nextNode", Arr[0]);

			data.setSessionData("nextKey", Arr[1]);
			return "Decision";
		} else {
			return "NI";
		}
	}

}
