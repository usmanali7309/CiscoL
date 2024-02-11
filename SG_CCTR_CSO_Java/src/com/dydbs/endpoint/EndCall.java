package com.dydbs.endpoint;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.audium.server.AudiumException;
import com.audium.server.proxy.EndCallInterface;
import com.audium.server.session.CallEndAPI;

public class EndCall implements EndCallInterface {

	public void onEndCall(CallEndAPI callEndAPI) throws AudiumException {

		try {
			Date endDate = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String endTime = sdf1.format(endDate);

			callEndAPI.setSessionData("endTime", endTime);

			String uniqueid = (String) callEndAPI.getSessionData("callid");
			String ani = callEndAPI.getAni();
			String dnis = callEndAPI.getDnis();
			String accountNumber = "";
			String callstart = (String) callEndAPI.getSessionData("startTime");
			String callend = (String) callEndAPI.getSessionData("endTime");
			String disconnectedby = "";
			String xferorDisc = "";
			String xferReason = "NA";
			String pq = "";
			String ct = "";
			String mobileNum = "";
			String idealOrgID = "";
			String idealUserID = "";
			String cin = "";
			String cinSuffix = "";
			String authStatus = "";
			String authError = "";
//			String PrecisionQueueName=(String) callEndAPI.getSessionData("PQ");
//			String CallTypeName="";

			// InsertMainReport.insertMainReport(uniqueid, ani, dnis, callstart, callend,
			// accountNumber, disconnectedby, xferorDisc, xferReason, pq, ct, mobileNum,
			// idealOrgID, idealUserID, cin, cinSuffix, authStatus, authError);
			// CallEndAPI.addToLog("enter end time", dataValue)
		} catch (Exception e) {

		}

	}

}
