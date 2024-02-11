package com.test;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckInputRe extends DecisionElementBase {

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {

		int emailOtp = 0;
		int smsOtp = 0;
		int smsOtpLen = 0;
		int emailOtpLen = 0;

		String nextNode = "";

		String sms = data.getElementData("SmsOtp1", "value");
		data.addToLog("Entered sms otp is : ", sms);
		if (sms != null) {
			smsOtpLen = sms.length();
			smsOtp = Integer.parseInt(sms);

		}

		String email = data.getElementData("EmailOtp1", "value");
		data.addToLog("Entered email otp is : ", email);
		if (email != null) {
			emailOtpLen = email.length();
			emailOtp = Integer.parseInt(email);
		}

		if (smsOtpLen == 6 || emailOtpLen == 6) {

			nextNode = "Yes";

		} else if (sms == null || email == null) {

			nextNode = "No";

		}

		return nextNode;
	}

}
