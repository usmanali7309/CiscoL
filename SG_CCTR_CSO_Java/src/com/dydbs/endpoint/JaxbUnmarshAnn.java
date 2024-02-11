package com.dydbs.endpoint;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;



import com.audium.server.global.ApplicationStartAPI;

public class JaxbUnmarshAnn {

	void loadDyanmicMenu(ApplicationStartAPI appStart) {

		try {

			Map<String, HashMap<String, String>> objMapDynamicXml = new HashMap<>();
			String key;

			File file = new File(
					"D:/Cisco/eclipse/plugins/com.audiumcorp.studio.debug.runtime/CATALINA_HOME/webapps/CVP/Config/CSO_Ann.xml");
			System.out.println("File path: " + file);

			JAXBContext jaxbContext = JAXBContext.newInstance(DynamicAnn.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			DynamicAnn dynamic = (DynamicAnn) unmarshaller.unmarshal(file);

			for (DynamicAnn.Entry entry : dynamic.getEntry()) {
				key = entry.getKey();

				System.out.println("Key: " + key);

				DynamicAnn.Entry.Value value = entry.getValue();
				HashMap<String, String> loadxml = new HashMap<>();
				System.out.println("Entered");
				loadxml.put("PROMPTS", value.getPrompts().getValue().trim());
				loadxml.put("BARGEIN", value.getPrompts().getBargein().trim());
				loadxml.put("NEXT_NODE", value.getNextNode().trim());

				objMapDynamicXml.put(key, loadxml);

				System.out.println("loadxml------" + loadxml);
				key = "";

			}
			appStart.setApplicationData("csoAnnMap", objMapDynamicXml);   // Setting "objMapDynamicXml" values in  "csoAnnMap" variable
//			System.out.println("Hashmap------" + objMapDynamicXml);
		} catch (Exception e) {
		}
	}

}
