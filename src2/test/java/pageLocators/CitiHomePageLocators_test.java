package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CitiHomePageLocators_test {
	@FindBy(how=How.XPATH,using="//form[@id='logInForm']/div[1]/div[1]/div[1]")
	public WebElement loginDiv;
	
	/* CBOL Login */
	
	@FindBy(id="credentialsRow")
	public WebElement loginUIDDiv;
	
	
	//@FindBy(how=How.XPATH,using="//*[@id='usernameMasked']")
	@FindBy(how=How.XPATH,using="//*[@id='username']")
	public WebElement loginUID;
	//@FindBy(how=How.XPATH,using="//*[@id='username']")
	
	
	@FindBy(how=How.XPATH,using="//*[@id='password']")
	public WebElement loginPWD;
	
	@FindBy(how=How.XPATH,using="//*[@id='signInBtn']")
	public WebElement SignOnBtn;
	
	
}
