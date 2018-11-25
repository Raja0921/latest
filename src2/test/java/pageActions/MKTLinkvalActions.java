package pageActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageLocators.MKTLinkvalLocators;
import utils.SeleniumDriver;

public class MKTLinkvalActions {
	MKTLinkvalLocators MKTlinkvalLocators = new MKTLinkvalLocators();
	

	
	public  MKTLinkvalActions()
	{
		this.MKTlinkvalLocators= new MKTLinkvalLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), MKTlinkvalLocators);
	}
	
	public void homepage(String url) throws InterruptedException {
		SeleniumDriver.getDriver().get(url);
		Thread.sleep(9000);
		
	}

	public void clicksearchcard() {
		MKTlinkvalLocators.Searchcardclick.click();
		
	}

	public void enterandselectcardname(String CardName) {
		MKTlinkvalLocators.Enterandselectcardname.click();
		MKTlinkvalLocators.Enterandselectcardname.sendKeys(CardName);
		MKTlinkvalLocators.Enterandselectcardname.sendKeys(Keys.RETURN);
	}


	public void PDPpage(String Cardname) {
		switch (Cardname){
		
		case "Simplicity":
			MKTlinkvalLocators.SimplicityPDPpage.isDisplayed();
			System.out.println("Simplicity PDP page get displayed");
			break;
			
		case "Doublecash":
			MKTlinkvalLocators.DoublecashPDPpage.isDisplayed();
			System.out.println("Doublecash PDP page get displayed");
			break;
			
		case "Platinum":
			MKTlinkvalLocators.AAPlatinumPDPpage.isDisplayed();
			System.out.println("AAPlatinum PDP page get displayed");
			break;
			
		case "Citibusiness":
			MKTlinkvalLocators.CitibusinessAAPlatinumPDPpage.isDisplayed();
			System.out.println("Citibusiness AAPlatinum PDP page get displayed");
			break;
			
		case "Executive":
			MKTlinkvalLocators.AAExecutivePDPpage.isDisplayed();
			System.out.println("AAExecutive PDP page get displayed");
			break;
			
		case "Costco Visa":
			MKTlinkvalLocators.CostcovisaPDPpage.isDisplayed();
			System.out.println("Costco Visa PDP page get displayed");
			break;
			
		case "Costco Business":
			MKTlinkvalLocators.CostcobusinessPDPpage.isDisplayed();
			System.out.println("Costco Business PDP page get displayed");
			break;
			
		case "ATT Access":
			MKTlinkvalLocators.ATTaccessPDPpage.isDisplayed();
			System.out.println("ATT Access PDP page get displayed");
			break;
			
		case "Secured":
			MKTlinkvalLocators.SecuredPDPpage.isDisplayed();
			System.out.println("Secured PDP page get displayed");
			break;
			
		case "College":
			MKTlinkvalLocators.TYPcollegePDPpage.isDisplayed();
			System.out.println("TYPcollege PDP page get displayed");
			break;
			
		case "Preferred":
			MKTlinkvalLocators.TYpreferredPDPpage.isDisplayed();
			System.out.println("TYpreferred PDP page get displayed");
			break;
			
		case "Premier":
			MKTlinkvalLocators.TYpremierPDPpage.isDisplayed();
			System.out.println("TYpremier PDP page get displayed");
			break;
			
		case "Expedia":
			MKTlinkvalLocators.ExpediaPDPpage.isDisplayed();
			System.out.println("Expedia PDP page get displayed");
			break;
			
		case "Voyager":
			MKTlinkvalLocators.ExpediavoyagerPDPpage.isDisplayed();
			System.out.println("Expedia Voyager PDP page get displayed");
			break;
			
		default:
			System.out.println("Given Cardname is an invlid one");
		}	
		
	}

	public void applynowlinkvalidation(String Cardname) throws InterruptedException {
		  String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
          System.out.println("First Parent Window window handle  "+ parentwindow);
          MKTlinkvalLocators.Applynowclick.click();
		  Thread.sleep(5000);
		
		 Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
         Iterator<String> it = handles.iterator();
         String parent = it.next();
         System.out.println("Second Parent Window window handle  "+ parent);
         String child = it.next();
         System.out.println("Child" + child);
         SeleniumDriver.getDriver().switchTo().window(child);
         Thread.sleep(3000);
 
		switch (Cardname){

 		case "Simplicity":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Doublecash":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Platinum":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Citibusiness":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Executive":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Costco Visa":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Costco Business":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "ATT Access":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Secured":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "College":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Preferred":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Premier":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Expedia":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;
 			
 		case "Voyager":
 			MKTlinkvalLocators.ACQ_Simplicitycardart.isDisplayed();
 			System.out.println("Simplicity Card Art is displayed");
 			break;

 		default:
 			System.out.println("Displayed Card Art is not expected");
         }
		MKTlinkvalLocators.TellusaboutYourselfText.isDisplayed();
		System.out.println("Tell about yourself is displayed");
		SeleniumDriver.getDriver().switchTo().window(parent);
		System.out.println("Switched to PDP page");
	}
	
	public void pricinginfolinkvalidation() throws InterruptedException {
		if(MKTlinkvalLocators.Simplicitypricinginfolink.isDisplayed())
		{
		Thread.sleep(6000);
		String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
        System.out.println("First Parent Window window handle  "+ parentwindow);
        WebElement element_pricinginfo = MKTlinkvalLocators.Simplicitypricinginfolink;
        JavascriptExecutor executor = (JavascriptExecutor)SeleniumDriver.getDriver();
        executor.executeScript("arguments[0].click();", element_pricinginfo);
        System.out.println("pricinginfolink is clicked");     
        Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parent = it.next();
        System.out.println("Second Parent Window window handle  "+ parent);
        Thread.sleep(5000);
        String child=it.next();
        String Grandchild=it.next();
        System.out.println("Child" + child);
        SeleniumDriver.getDriver().switchTo().window(Grandchild);
        Thread.sleep(3000);
        System.out.println("Citi Disclosure text is displayed " + MKTlinkvalLocators.Pricinginfopage.isDisplayed());
        System.out.println("pricinginfopage is clicked");
        SeleniumDriver.getDriver().switchTo().window(parent);
       // System.out.println("Back to PDP Page");
		//MKTLinkvallocators.pricinginfopage.sendKeys(Keys.chord(Keys.CONTROL,"w"));
		}
		else
		{
			Thread.sleep(6000);
			String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
	        System.out.println("First Parent Window window handle  "+ parentwindow);
	        WebElement element_pricinginfo = MKTlinkvalLocators.Pricinginfolink;
	        JavascriptExecutor executor = (JavascriptExecutor)SeleniumDriver.getDriver();
	        executor.executeScript("arguments[0].click();", element_pricinginfo);
	        System.out.println("Pricinginfolink is clicked");     
	        Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
	        Iterator<String> it = handles.iterator();
	        String parent = it.next();
	        System.out.println("Second Parent Window window handle  "+ parent);
	        Thread.sleep(5000);
	        String child=it.next();
	        String Grandchild=it.next();
	        System.out.println("Child" + child);
	        SeleniumDriver.getDriver().switchTo().window(Grandchild);
	        Thread.sleep(3000);
	        System.out.println("Citi Disclosure text is displayed " + MKTlinkvalLocators.Pricinginfopage.isDisplayed());
	        System.out.println("pricinginfopage is clicked");
	        SeleniumDriver.getDriver().switchTo().window(parent);
		}
		}

	public void additionalinfolinkvalidation() throws InterruptedException {
		if(MKTlinkvalLocators.Simplicityadditionalinfolink.isDisplayed())
		{
		String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
        System.out.println("First Parent Window window handle  "+ parentwindow);
		WebElement element_addinfo = MKTlinkvalLocators.Simplicityadditionalinfolink;
        JavascriptExecutor executor = (JavascriptExecutor)SeleniumDriver.getDriver();
        executor.executeScript("arguments[0].click();", element_addinfo);
        System.out.println("Additional info link is clicked");
        Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parent = it.next();
        String child = it.next();
        String Grandchild=it.next();
        String GreatGrandchild=it.next();
        System.out.println("Second Parent Window window handle  "+ parent);
        System.out.println("Child" + child);
        SeleniumDriver.getDriver().switchTo().window(GreatGrandchild);
        Thread.sleep(3000);
		MKTlinkvalLocators.Additionalinfopage.isDisplayed();
		System.out.println("Additional info page is clicked");
		SeleniumDriver.getDriver().switchTo().window(parent);
		//MKTLinkvallocators.additionalinfopage.sendKeys(Keys.chord(Keys.CONTROL,"w"));
		}
		else
		{
			String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
	        System.out.println("First Parent Window window handle  "+ parentwindow);
			WebElement element_addinfo = MKTlinkvalLocators.Additionalinfolink;
	        JavascriptExecutor executor = (JavascriptExecutor)SeleniumDriver.getDriver();
	        executor.executeScript("arguments[0].click();", element_addinfo);
	        System.out.println("Additional info link is clicked");
	        Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
	        Iterator<String> it = handles.iterator();
	        String parent = it.next();
	        String child = it.next();
	        String Grandchild=it.next();
	        String GreatGrandchild=it.next();
	        System.out.println("Second Parent Window window handle  "+ parent);
	        System.out.println("Child" + child);
	        SeleniumDriver.getDriver().switchTo().window(GreatGrandchild);
	        Thread.sleep(3000);
			MKTlinkvalLocators.Additionalinfopage.isDisplayed();
			System.out.println("Additional info page is clicked");
			SeleniumDriver.getDriver().switchTo().window(parent);
		}
		}


	}
	