package stepDef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageActions.MKTLinkvalActions;

public class MKT {
	final Log log = LogFactory.getLog(MKT.class.getName());
	MKTLinkvalActions MKTLinkvalactions = new MKTLinkvalActions();
	
	
	@Given("^I am on the Home Page \"([^\"]*)\"$")
	public void i_am_on_the_Home_Page(String url) throws Throwable {
		MKTLinkvalactions.homepage(url);
	}

	@When("^I click search card$")
	public void i_click_search_card() throws Throwable {
		MKTLinkvalactions.clicksearchcard();
		
	}

	@And("^I enter and select \"([^\"]*)\"$")
	public void i_enter(String Cardname) throws Throwable {
		MKTLinkvalactions.enterandselectcardname(Cardname);
		
	}

	@And("^I get PDP page$")
	public void i_get_PDP_page() throws Throwable {
		MKTLinkvalactions.PDPpage();
	}
	
	@And("^I validate apply now link$")
	public void i_validate_apply_now_link() throws Throwable {
		MKTLinkvalactions.applynowlinkvalidation();
	}

	@And("^I validate pricing info link$")
	public void i_validate_pricing_info_link() throws Throwable {
		MKTLinkvalactions.pricinginfolinkvalidation();
	}

	@Then("^I validate additional info link$")
	public void i_validate_additional_info_link() throws Throwable {
		MKTLinkvalactions.additionalinfolinkvalidation();
	}

}
