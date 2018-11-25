package utils;


import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import utils.ConfigFileReader;


public class SeleniumHelper {
	
	public static String reportNameFinal;
	public static String reportFolderNameFinal;
	
	public static List<String[]> scenarioList = new ArrayList<String[]>();
	
	//by web element
    public static boolean isElementPresent(WebElement webElement) {
        try {
            log.info(">>SeleniumHelper web helper WebElement=" + webElement.getText());
        	boolean isPresent = webElement.isDisplayed();
           
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }
        
    }
    
    //by xPath
    final static Log log = LogFactory.getLog(SeleniumHelper.class.getName());
    
    public static boolean isElementPresent(String xPath) {
        try {
            log.info(">>SeleniumHelper web helper Xpath=" + xPath);            
        	boolean isPresent = !SeleniumDriver.getDriver().findElements(By.xpath(xPath)).isEmpty();
            log.info(xPath+" isPresent?=" + isPresent);
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public static void takeScreenshot(){
    	takeScreenshot("");
    	
    }
    
    public static void takeScreenshot(String imageName){
    	try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	File scrFile = ((TakesScreenshot)SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE);
	    try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
			Date curDate = new Date();
			String imagePath;
			
			if(System.getProperty("os.name").contains("Windows")){
				String strDate = sdf.format(curDate);
		    	imagePath = reportFolderNameFinal + "/" + imageName +  "_" + strDate + ".png";
			}
			else
			{
				String strDate = sdf.format(curDate);
		    	imagePath = reportFolderNameFinal + "/" + imageName +".png";
			}
			
	    	FileUtils.copyFile(scrFile, new File(imagePath));
	    	
	    	
	    	Reporter.addScreenCaptureFromPath(imagePath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    	
    }
    
    public static void setupExtentReport(){
    	ConfigFileReader configFileReader;
		
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName;
		configFileReader= new ConfigFileReader();
		if(System.getProperty("os.name").contains("Windows")){
			fileName = System.getProperty("user.dir")+configFileReader.getReportPath()+ strDate + "/"+ strDate +".html";
			reportNameFinal =fileName;
			reportFolderNameFinal = System.getProperty("user.dir")+configFileReader.getReportPath()+ strDate;
			}
		else
		{
			fileName = System.getProperty("user.dir")+"/Results.html";
			reportNameFinal =fileName;
			reportFolderNameFinal = System.getProperty("user.dir");
		}
		
		
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(fileName);
    }
    
    public static void tearDownReport() throws Exception{
    	try{
    	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setSystemInfo("java version", System.getProperty("java.version"));
        
        Capabilities capa = ((RemoteWebDriver)SeleniumDriver.getDriver()).getCapabilities();
        Reporter.setSystemInfo("browser", capa.getBrowserName());        
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setTestRunnerOutput(capa.toString());
        Reporter.setTestRunnerOutput("[~~~~~~~~~~~~]" );
    	}
    	catch(Exception e){
    		
    	}

    }
    
    public static void updateALM() throws Exception{
    	for (String[] scenRow : SeleniumHelper.scenarioList) {
			 //AlmRest almRest = new AlmRest();			 
			//almRest.updateResult(scenRow[0],scenRow[1],SeleniumHelper.reportFolderNameFinal);
			
		   
		    } 
    	

    }
    

    public static void waitForVisibilityofElement(WebElement we, int sec){
    	WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(),sec);
		wait.until(ExpectedConditions.visibilityOf(we));
    }
    
  
    
    
}
