package stepDef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pageActions.CBOLPostLoginPageActions_test;
import pageActions.CBOL_CommonActions_test;
import pageActions.CitiHomePageActions_test;
import utils.ConfigFileReader;
import utils.SeleniumDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;



public class CBOLDashboard_Bank_Angular_test {

	final Log log = LogFactory.getLog(CBOLDashboard_Bank_Angular_test.class.getName());
	CitiHomePageActions_test citiHomePageActions = new CitiHomePageActions_test();
	CBOLPostLoginPageActions_test cbolPostLoginPageActions = new CBOLPostLoginPageActions_test();
	CBOL_CommonActions_test cbolCommonActions = new CBOL_CommonActions_test();
	ConfigFileReader configFileReader;
	
	public CBOLDashboard_Bank_Angular_test() {
		
	}


@Given("^I am on the Home Page \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_am_on_the_Home_Page(String url, String lgcag)  {
	configFileReader= new ConfigFileReader();
	log.info(">>> Opening the home page");
	System.out.println("From POM Excel Type to be used id - "+ System.getProperty("custType"));
	System.setProperty("lgcag", lgcag);
	
	if(System.getProperty("custType") == null) {
		System.setProperty("custType", "Blue"); 
	}
	
	//fetch data from excel with # row
	System.setProperty("Data", "");
	System.setProperty("Iteration", "");
	System.out.println("URL - " + url);
	System.setProperty("Data", "URL - "+url+"; ");		
	SeleniumDriver.openPage(url);

}

@When("^I enter a valid User ID and Password \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_enter_a_valid_User_ID_and_Password_and(String uid, String pwd)  {
	log.info(">>> Entering User ID and Password");
	System.out.println("Credential - " + uid + " - " + pwd);
	citiHomePageActions.enterUID(uid, pwd);
	System.setProperty("Data", System.getProperty("Data")+"User ID - "+uid+"; Password - "+ pwd + "; ");
}

@And("^If I click on Sign on button$")
public void if_I_click_on_Sign_on_button()  {
	citiHomePageActions.SignOnCBOL();
}

@Then("^I see CBOL dashboard Page \"([^\"]*)\"$")
public void i_see_CBOL_dashboard_Page_and(String acct)  {
	configFileReader= new ConfigFileReader();	
	System.out.println("Account - " + acct);
	System.setProperty("Data", System.getProperty("Data")+"Account to be verified - "+acct+"; ");
	cbolPostLoginPageActions.VerifyDashboard(acct.substring(acct.length()-4));
}


}
