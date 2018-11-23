package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MKTLinkvalLocators {

	
	@FindBy(xpath="(//span[@class='cA-DD-smallTriangle'])[2]")
	public WebElement searchcardclick;
	
	//@FindBy(id="cA-DD-cardsSearchInput")
	@FindBy (xpath="(//input[@id='cA-DD-cardsSearchInput'])")
	public WebElement enterandselectcardname;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-simplicity-credit-card.jpg'])[1]")
	public WebElement simplicityPDPpage;

	@FindBy(xpath="(//div[@class='cA-DD-apply-now'])[1]//a[@type='button']")
	public WebElement applynowclick;
	
	@FindBy(xpath="//*[contains(text(),'Tell Us About Yourself')]")
	public WebElement TellusaboutYourselfText;
	
	@FindBy(xpath="//h1[contains(text(),'Citi Simplicity')]")
	public WebElement ACQpage_SimplicityCardtext;
	
	@FindBy(xpath="(//a[@class='cA-DD-cards-details-small-link'])[2]")
	public WebElement pricinginfolink;
	
	@FindBy (xpath="(//td[contains(text(),'CITI DISCLOSURES')])")
	public WebElement pricinginfopage;
	
	@FindBy(xpath="(//a[contains(text(),'Additional Information')])[2]")
	public WebElement additionalinfolink;
	
	@FindBy(xpath="(//h1[contains(text(),'Additional Information')])")
	public WebElement additionalinfopage;	
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-double-cash-credit-card.jpg'])[1]")
	public WebElement doublecashPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID142')])")
	public WebElement ACQ_Doublecashcardart;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-aadvantage-platinum-elite-credit-card.jpg'])[1]")
	public WebElement AAPlatinumPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID056')])")
	public WebElement ACQ_AAPlatinumcardart;
	
	@FindBy(xpath="(//img[@src='CRD/images/card_no_reflection/citibusiness-aadvantage-platinum-select-credit-card.jpg'])[1]")
	public WebElement AAPlatinumworldPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID051')])")
	public WebElement ACQ_AAPlatinumworldcardart;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-aadvantage-executive-credit-card.jpg'])[1]")
	public WebElement AAExecutivePDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID093')])")
	public WebElement ACQ_AAExecutivecardart;
	
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/Citi-costco-anywhere-visa-credit-card.jpg'])[1]")
	public WebElement CostcovisaPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID520')])")
	public WebElement ACQ_Costcovisacardart;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/Citi-costco-anywhere-visa-business-credit-card.jpg'])[1]")
	public WebElement CostcobusinessPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID522')])")
	public WebElement ACQ_Costcobusinesscardart;
	
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-att-access-credit-card.jpg'])[1]")
	public WebElement ATTaccessPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID457')])")
	public WebElement ACQ_ATTaccesscardart;
	
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-secured-credit-card.jpg'])[1]")
	public WebElement SecuredPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID009')])")
	public WebElement Securedcardart;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-thankyou-preferred-credit-cards-for-college-students.jpg'])[1]")
	public WebElement TYPcollegePDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID083')])")
	public WebElement TYPcollegecardart;

	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-thankyou-credit-card-preferred-card.jpg'])[1]")
	public WebElement TYpreferredPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID084')])")
	public WebElement TYpreferredcardart;
	
	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/citi-thankyou-premier-credit-card.jpg'])[1]")
	public WebElement TYpremierPDPpage;
	
	@FindBy(xpath="(//div[contains(@class,'ddCardImg large PID089')])")
	public WebElement TYpremiercardart;

	@FindBy(xpath="(//img[@src='/CRD/images/card_no_reflection/expedia-plus.jpg'])[1]")
	public WebElement ExpediaPDPpage;
	
	@FindBy(xpath="(//a[@href='/cards/credit/application/TakeMeOutSide.action?ACCEPT=SpeedBumpYes']")
	public WebElement Expediainterdictionpage;
	
	@FindBy(xpath="(//div[contains(text(),' create an Expedia account')]")
	public WebElement Expediapage;

	@FindBy(xpath="(/img[@src='/CRD/images/card_no_reflection/expedia-plus-voyager.jpg'])[1]")
	public WebElement ExpediavoyagerPDPpage;



}
 
