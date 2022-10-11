package com.cucumber.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.driverManager.DriverManager;
import com.cucumber.utilities.CommonUtils;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Def {

	

	
	private static String scenarioName =null;
	
	
	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Def.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		LOGGER.info("Excetion started");

		try {
			//CommonUtils.loadProperties();
			//create object for CommonUtils
			 scenarioName = scenario.getName();
			LOGGER.info("Instanciating the CommonUtils class.");
			
			LOGGER.info("Loading properties file.");
			CommonUtils.getInstance().loadProperties();
			/**the below condition tells us open the one browser instance no need to open the multiple instance.
			In the single instance cover all the scenarios
			*/
			LOGGER.info("Checking the driver instance null");
			if(DriverManager.getDriver() == null) {
				LOGGER.info("If the driver instance is null then the open the one browser instance ");	
			DriverManager.launchbrowser();
			CommonUtils.getInstance().waituntillLoadWebElement();
			CommonUtils.getInstance().initWebElement();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	
	
}
