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
	MKTLinkvalLocators MKTLinkvallocators = new MKTLinkvalLocators();
	

	
	public  MKTLinkvalActions()
	{
		this.MKTLinkvallocators= new MKTLinkvalLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), MKTLinkvallocators);
	}
	
	public void homepage(String url) throws InterruptedException {
		SeleniumDriver.getDriver().get(url);
		Thread.sleep(9000);
		
	}

	public void clicksearchcard() {
		MKTLinkvallocators.searchcardclick.click();
		
	}

	public void enterandselectcardname(String CardName) {
		MKTLinkvallocators.enterandselectcardname.click();
		MKTLinkvallocators.enterandselectcardname.sendKeys(CardName);
		MKTLinkvallocators.enterandselectcardname.sendKeys(Keys.RETURN);
	}


	public void PDPpage() {
		MKTLinkvallocators.simplicityPDPpage.isDisplayed();
		
		
	}

	public void applynowlinkvalidation() throws InterruptedException {
		  String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
          System.out.println("First Parent Window window handle  "+ parentwindow);
         
         
		MKTLinkvallocators.applynowclick.click();
		Thread.sleep(5000);
		
		 Set<String> handles = SeleniumDriver.getDriver().getWindowHandles();
         Iterator<String> it = handles.iterator();
         String parent = it.next();
         System.out.println("Second Parent Window window handle  "+ parent);
         String child = it.next();
         System.out.println("Child" + child);
         SeleniumDriver.getDriver().switchTo().window(child);
         Thread.sleep(3000);
         
		if(MKTLinkvallocators.ACQpage_SimplicityCardtext.isDisplayed())
		{
			System.out.println("simplicity card text is displayed");
		}
		
		MKTLinkvallocators.TellusaboutYourselfText.isDisplayed();
		System.out.println("Tell about yourself is displayed");
		SeleniumDriver.getDriver().switchTo().window(parent);
		System.out.println("switched to pdp page");
	}
	
	public void pricinginfolinkvalidation() throws InterruptedException {
				
		Thread.sleep(6000);
		String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
        System.out.println("First Parent Window window handle  "+ parentwindow);
        WebElement element_pricinginfo = MKTLinkvallocators.pricinginfolink;
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
        System.out.println("Citi Disclosure text is displayed " + MKTLinkvallocators.pricinginfopage.isDisplayed());
        System.out.println("pricinginfopage is clicked");
        SeleniumDriver.getDriver().switchTo().window(parent);
       // System.out.println("Back to PDP Page");
		//MKTLinkvallocators.pricinginfopage.sendKeys(Keys.chord(Keys.CONTROL,"w"));
	}

	public void additionalinfolinkvalidation() throws InterruptedException {
		
		String parentwindow = SeleniumDriver.getDriver().getWindowHandle();
        System.out.println("First Parent Window window handle  "+ parentwindow);
		WebElement element_addinfo = MKTLinkvallocators.additionalinfolink;
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
		MKTLinkvallocators.additionalinfopage.isDisplayed();
		System.out.println("Additional info page is clicked");
		SeleniumDriver.getDriver().switchTo().window(parent);
		//MKTLinkvallocators.additionalinfopage.sendKeys(Keys.chord(Keys.CONTROL,"w"));
	}
	
}