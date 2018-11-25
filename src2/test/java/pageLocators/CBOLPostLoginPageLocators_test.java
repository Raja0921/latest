package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CBOLPostLoginPageLocators_test {

	@FindBy(xpath="//a[@class='dropdown-toggle'][text()='Accounts ']")
	public WebElement Cbol_brandingAccounts;
	
	@FindBy(xpath="//button[@class='btn btn-link ng-star-inserted'][text()='Accounts']")
	public WebElement Cbol_brandingAccounts_ag;
	
	@FindBy(xpath="//a[text()='Overview'][@class='subMenuLink overviewLink'][contains(@href,'/US/JPS/portal/Home.do')]")
	public WebElement Cbol_subbrandingAcctOverview;
	
	@FindBy(xpath="(//a[text()='Overview'][@class='btn btn-link ng-star-inserted'][contains(@href,'/US/JPS/portal/Home.do')])[1]")
	public WebElement Cbol_subbrandingAcctOverview_ag;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Off')][contains(@href, '/US/JSO/signoff')][@class='dropdown-toggle']")
	public WebElement Cbol_ctaSignOff;
	
	@FindBy(xpath="(//a[contains(text(), 'Sign Off')][contains(@href, '/US/JSO/signoff')])[4]")
	public WebElement Cbol_ctaAgSignOff;
	
}
