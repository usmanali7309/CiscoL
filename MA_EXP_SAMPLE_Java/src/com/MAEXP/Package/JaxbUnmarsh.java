package com.MAEXP.Package;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.audium.server.global.ApplicationStartAPI;

public class JaxbUnmarsh {

	void loadDyanmicMenu(ApplicationStartAPI appStart) {

		try {
			HashMap<String, String> loadxml = new HashMap<>();
			Map<String, HashMap<String, String>> objMapDynamicXml = new HashMap<>();

			String key;

			File file = new File(
					"D:/Cisco/eclipse/plugins/com.audiumcorp.studio.debug.runtime/CATALINA_HOME/webapps/CVP/Config/MaExp.xml");
			
			System.out.println("File path: " + file);

			JAXBContext jaxbContext = JAXBContext.newInstance(DynamicMenu.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			DynamicMenu dynamic = (DynamicMenu) unmarshaller.unmarshal(file);

			for (DynamicMenu.Entry entry : dynamic.getEntry()) {
				key = entry.getKey();

				System.out.println("Key: " + key);

				DynamicMenu.Entry.Value value = entry.getValue();
				loadxml = new HashMap<>();
				System.out.println("Reading XML values from property file");
				loadxml.put("PROMPTS",   value.getPrompts().getValue().trim());
				loadxml.put("BARGEIN",   value.getPrompts().getBargein().trim());
				loadxml.put("GRAMMARS",  value.getGrammars().trim());
				loadxml.put("NEXT_NODE", value.getNextNode().trim());
				loadxml.put("MENU_ID",   value.getMenuID().trim());
				loadxml.put("NI_PROMPT", value.getNoInput().getValue().trim());
				loadxml.put("NM_PROMPT", value.getNoMatch().getValue().trim());
				loadxml.put("RETRY",     value.getRetry().trim());
				loadxml.put("MAX_TRIES", value.getMaxTries().trim());

				objMapDynamicXml.put(key, loadxml);
				
				System.out.println("loadxml------" + loadxml);
				// System.out.println("objMapDynamicXml------" + objMapDynamicXml);
				key = "";
			}
			System.out.println("objMapDynamicXml------" + objMapDynamicXml);
			appStart.setApplicationData("MASampleMap", objMapDynamicXml);               // setting all the xml values in csoMenuMap
		} catch (Exception e) {

		}

	}

}
