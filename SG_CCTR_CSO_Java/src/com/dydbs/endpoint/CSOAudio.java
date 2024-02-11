package com.dydbs.endpoint;

import com.audium.server.AudiumException;
import com.audium.server.proxy.VoiceElementInterface;
import com.audium.server.session.ElementAPI;
import com.audium.server.xml.VoiceElementConfig;

public class CSOAudio implements VoiceElementInterface {

	@Override
	public VoiceElementConfig getConfig(String arg0, ElementAPI data, VoiceElementConfig voElmtDefaults)
			throws AudiumException {

		voElmtDefaults = new VoiceElementConfig();

		VoiceElementConfig.AudioGroup initialAudioGroup = voElmtDefaults.new AudioGroup("initial_audio_group",
				Boolean.parseBoolean((String) data.getSessionData("bargein")));

		String vs = ((String) data.getSessionData("prompts"));
		System.out.println(vs);
		if (vs.contains(",")) {

			String[] arrPrompt = vs.split(",");

			System.out.println(arrPrompt);

			// String strMediaSysPath = (String) data.getSessionData("language")
			// ;strMediaSysPath +

			for (int i = 0; i < arrPrompt.length; i++) {

				VoiceElementConfig.StaticAudio promptFor = voElmtDefaults.new StaticAudio("", arrPrompt[i] + ".wav");
				initialAudioGroup.addAudioItem(promptFor);

			}
		} else {
			VoiceElementConfig.StaticAudio promptFor = voElmtDefaults.new StaticAudio("", vs + ".wav");
			initialAudioGroup.addAudioItem(promptFor);
		}

		voElmtDefaults.setAudioGroup(initialAudioGroup);

		String vd = ((String) data.getSessionData("nextNode"));
		System.out.println(vd);

		if (vd.contains(":")) {
			String[] node = vd.split(":");
			System.out.println(node);

			for (int i = 0; i < node.length; i++) {
				data.setSessionData("nextNode", node[i]);
				i++;
				data.setSessionData("nextKey", node[i]);
			}
		} else {
			data.setSessionData("nextNode", vd);
		}

		return voElmtDefaults;

	}

}
