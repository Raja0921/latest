package pageActions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import pageLocators.CBOLPostLoginPageLocators_test;
import utils.SeleniumDriver;
import utils.SeleniumHelper;


public class CBOLPostLoginPageActions_test {
	CBOLPostLoginPageLocators_test cbolPostLoginPageLocators=null;
	CBOL_CommonActions_test cbolCommonActions = new CBOL_CommonActions_test();
	final Log log = LogFactory.getLog(CBOLPostLoginPageActions_test.class.getName());
		
		public  CBOLPostLoginPageActions_test()
		{
			this.cbolPostLoginPageLocators = new CBOLPostLoginPageLocators_test();
			PageFactory.initElements(SeleniumDriver.getDriver(), cbolPostLoginPageLocators);
		}
		
		public void VerifyDashboard(String acct) {

			if(System.getProperty("lgcag").equalsIgnoreCase("ag")){
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_brandingAccounts_ag);
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_subbrandingAcctOverview_ag);
			} else {
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_brandingAccounts);
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_subbrandingAcctOverview);
			}
							
			String tmpxpath = "//a[contains(text(), '"+acct+"')][contains(@href, 'TTC=742')]";
			SeleniumHelper.waitForVisibilityofElement(SeleniumDriver.driver.findElement(By.xpath(tmpxpath)), 30);
			System.out.println(">> Account Number ending with - "+ acct + " is displayed on Dashboard");
			log.info(">> Account Number ending with - "+ acct + " is displayed on Dashboard");
		}

		public void SignOff(String pageType) {
			if(pageType.equalsIgnoreCase("lgc")){
				SeleniumHelper.waitForVisibilityofElement(cbolPostLoginPageLocators.Cbol_ctaSignOff, 30);
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_ctaSignOff);	
			}
			else if(pageType.equalsIgnoreCase("ag")){
				SeleniumHelper.waitForVisibilityofElement(cbolPostLoginPageLocators.Cbol_ctaAgSignOff, 30);
				cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_ctaAgSignOff);
			}
			else {
					SeleniumHelper.waitForVisibilityofElement(cbolPostLoginPageLocators.Cbol_ctaSignOff, 30);
					cbolCommonActions.CBOLPerformClick(cbolPostLoginPageLocators.Cbol_ctaSignOff);	
				}
		System.out.println(">> Signing Off");
		log.info(">> Signing Off");	
		}


		public void verifySignOffLink(String pageType) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(pageType.equalsIgnoreCase("lgc")){
				assertTrue(cbolCommonActions.verifyElementAvailability(cbolPostLoginPageLocators.Cbol_ctaSignOff));
			}
			else if(pageType.equalsIgnoreCase("ag")){
				assertTrue(cbolCommonActions.verifyElementAvailability(cbolPostLoginPageLocators.Cbol_ctaAgSignOff));
			}
			else {
				assertTrue(cbolCommonActions.verifyElementAvailability(cbolPostLoginPageLocators.Cbol_ctaSignOff));
			}	
		}

		
}

