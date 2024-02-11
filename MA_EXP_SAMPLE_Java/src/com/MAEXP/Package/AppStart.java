package com.MAEXP.Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.audium.server.AudiumException;
import com.audium.server.global.ApplicationStartAPI;
import com.audium.server.proxy.StartApplicationInterface;
 
public class AppStart implements StartApplicationInterface {

	private static Logger log = Logger.getLogger("MA_EXP_SAMPLE" + AppStart.class.getName());       // creating object fr logger
	
	
	public void onStartApplication(ApplicationStartAPI appStart) throws AudiumException
	{
		FileInputStream fin = null;
		
		String strConfigLocation = "D:/Cisco/eclipse/plugins/com.audiumcorp.studio.debug.runtime/CATALINA_HOME/webapps/CVP/Config/";
		Properties propLog4j = new Properties();
		Properties propAppData = new Properties();
		log.info("\n\n***********************************************************************************************************************************************************************************");
		log.info("\n\n****************************************"+ "Log initialized for the APPStart ......!!!!!!!!!!! "+"**********************************************************");
		
		try {

			fin = new FileInputStream(strConfigLocation + "log4j.properties");  // Creates new object (fin) for FileInputStream and get Log4j values from the path.(from D drive cisco)
			log.info("****************"+propAppData);
			propLog4j.load(fin);
			
			PropertyConfigurator.configure(propLog4j);

			fin = new FileInputStream(strConfigLocation + "AppData.properties");  // Creates new object for FileInputStream and get AppData values from the path.
			propAppData.load(fin);
			setToAppData(propAppData, appStart);
			
			log.debug("AppData.properties loaded into Application data successfully");

			JaxbUnmarsh dynParserer = new JaxbUnmarsh();     
			dynParserer.loadDyanmicMenu(appStart);

			log.info("****************  "+" Log initialized "+"  ****************");
			
		} catch (Exception e) {
			log.error("Error in AppStart : "+e);
			e.printStackTrace();
		} 
			finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fin = null;
			}
		}
	}

	private void setToAppData(Properties prop, ApplicationStartAPI applicationStartAPI) {
		String strVal = null;
		try {
			for (String strKey : prop.stringPropertyNames()) {             //foreach loop
				strVal = prop.getProperty(strKey).trim();
				applicationStartAPI.setApplicationData(strKey, strVal);     // setting each key with each value seperately(Key value pair)
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}







