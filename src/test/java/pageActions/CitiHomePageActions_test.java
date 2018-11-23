package pageActions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;

import pageLocators.CitiHomePageLocators_test;
import utils.SeleniumDriver;


public class CitiHomePageActions_test {
		CitiHomePageLocators_test citiHomePageLocators=null;
		CBOL_CommonActions_test cbolCommonActions = new CBOL_CommonActions_test();
		final Log log = LogFactory.getLog(CitiHomePageActions_test.class.getName());
		
		//Constructor
		public  CitiHomePageActions_test()
		{
			this.citiHomePageLocators = new CitiHomePageLocators_test();
			PageFactory.initElements(SeleniumDriver.getDriver(), citiHomePageLocators);
		}
		
		public void enterUID(String UID, String Pwd)
		{
			log.info(">> Sign On - Start");
		
			//cbolCommonActions.CBOLPerformClick(citiHomePageLocators.loginUIDDiv);
			
			log.info(">> Entering User ID");
			cbolCommonActions.CBOLPerformClick(citiHomePageLocators.loginDiv);
			cbolCommonActions.CBOLPerformClick(citiHomePageLocators.loginUID);
			cbolCommonActions.CBOLPerformSendKeys(citiHomePageLocators.loginUID, UID);

			log.info(">> Entering Password");
			cbolCommonActions.CBOLPerformClick(citiHomePageLocators.loginPWD);
			cbolCommonActions.CBOLPerformSendKeys(citiHomePageLocators.loginPWD, Pwd);;
			
			
			
		
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			log.info(">> Clicking Sign on Button");
			cbolCommonActions.CBOLPerformClick(citiHomePageLocators.SignOnBtn);
			
			log.info(">> Sign On - End");
		}
		
		public void SignOnCBOL()
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


}

