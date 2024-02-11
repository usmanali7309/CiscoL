package com.MAEXP.Package;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.audium.server.AudiumException;
import com.audium.server.proxy.StartCallInterface;
import com.audium.server.session.CallStartAPI;

public class StartCall implements StartCallInterface {

	public void onStartCall(CallStartAPI callStart) throws AudiumException {

		String strMediaPath = (String) callStart.getApplicationAPI().getApplicationData("MediaPathURL");

		String AudioURL = (String) callStart.getApplicationAPI().getApplicationData("AudioURL");
		callStart.setDefaultAudioPath(strMediaPath);
		callStart.addToLog("Default Audio Path set: ", strMediaPath);
		Date startDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = sdf.format(startDate);
		callStart.setSessionData("startTime", startTime);
		callStart.setSessionData("AudioURL", AudioURL);
	}
}
