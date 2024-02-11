package com.test;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckInputFromCustomer extends DecisionElementBase {

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {

		int emailOtp = 0;
		int smsOtp = 0;

		String nextNode = "";

		String sms = data.getElementData("SmsOtp", "value");
		
		data.addToLog("Entered sms otp is : ", sms);

		if (sms != null) {
			String valueOf = String.valueOf(sms.length());
			data.addToLog("Entered sms Check : ", valueOf);
			smsOtp = Integer.parseInt(sms);
		}

//		data.addToLog("Entered sms Check : ", valueOf);
		String email = data.getElementData("EmailOtp", "value");
		data.addToLog("Entered email otp is  : ", email);

		if (email != null) {
			String valueOf1 = String.valueOf(email.length());
			data.addToLog("Entered email check  : ", valueOf1);
			emailOtp = Integer.parseInt(email);

		}

		if ((sms != null && smsOtp == 123456) || (email != null && emailOtp == 123456)) {
			nextNode = "yes";
		} else if (sms==null) {
			nextNode = "noSmsOtp";
		}
		else if(email==null) {
			nextNode="noEmailOtp";
		}

		return nextNode;
	}

}
