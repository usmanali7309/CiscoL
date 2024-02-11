package com.test;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckDigiteOfCurrentA extends DecisionElementBase{

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {
		
		String cAccount = data.getElementData("CAcInput", "value");
		data.addToLog("Current account number is : ", cAccount);
		
		int length = cAccount.length();
		data.addToLog("Length of current Account: ", length+" ");
		
//		int currentAccount = Integer.parseInt(cAccount);
			
		String nextNode = "";
		
		 if(length==12) {
			 nextNode="valid";
		 }
		 else {
			 nextNode="No match";
		 }
		
		return nextNode;
	}
	
	
	
	

}
