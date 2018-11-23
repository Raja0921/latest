package stepDef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import utils.SeleniumDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BeforeActions  {

	public static Scenario scenario;
	
	@Before
    public static void setUp(Scenario scenario) throws Exception {
		final Log log = LogFactory.getLog(BeforeActions.class.getName());

		if(System.getProperty("os.name").contains("Windows")){
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		}
		
		System.out.println("setting up driver..");
		log.info("setting up driver..");
		SeleniumDriver.setUpDriver();
		System.out.println("driver initialized.");
		log.info("driver initialized.");
		BeforeActions.scenario = scenario;
    }
}
