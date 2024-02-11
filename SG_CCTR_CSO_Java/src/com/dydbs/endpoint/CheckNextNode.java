package com.dydbs.endpoint;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckNextNode extends DecisionElementBase {

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {
		String nextNode = (String) data.getSessionData("nextNode");

		return nextNode;

	}
}
