package com.test;

import com.audium.server.AudiumException;
import com.audium.server.proxy.StartCallInterface;
import com.audium.server.session.CallStartAPI;

public class OnCallStart implements StartCallInterface{

	@Override
	public void onStartCall(CallStartAPI callStartAPI) throws AudiumException {
		
		
		callStartAPI.setSessionData("DayOfWeek", "Monday");
		callStartAPI.setSessionData("Test", 1);
		
		String ani = callStartAPI.getAni();
		String dnis = callStartAPI.getDnis();
		callStartAPI.getStartDate();
	    
		
	}

}
