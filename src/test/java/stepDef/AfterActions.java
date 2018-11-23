package stepDef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.MFUtil;
import utils.ExcelUtils;
import utils.SeleniumDriver;
import utils.SeleniumHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class AfterActions {

	final static Log log = LogFactory.getLog(AfterActions.class.getName());
	
    @After
    public static void tearDown(Scenario scenario) {
    	
    	System.out.println("Test End");
    	
    	
    	log.info(">> Run result failed - "+ scenario.isFailed());
    	log.info(">> Run result failed - "+ scenario.isFailed());
    	 if (scenario.isFailed()) {
             byte[] screenshotBytes = ((TakesScreenshot) SeleniumDriver.driver).getScreenshotAs(OutputType.BYTES);
             scenario.embed(screenshotBytes, "image/png");
             SeleniumHelper.takeScreenshot("Final Failed");
         }
    	 else
    	 {
    		 byte[] screenshotBytes = ((TakesScreenshot) SeleniumDriver.driver).getScreenshotAs(OutputType.BYTES);
         	scenario.embed(screenshotBytes, "image/png"); 
    		 SeleniumHelper.takeScreenshot("Final Pass");
    	 }
    	 

         ExcelUtils objExcelFile = new ExcelUtils();
         String filePath = System.getProperty("xlFile");
         System.out.println(" Data - "+ System.getProperty("Data"));
         objExcelFile.CreateExlFile(filePath);
         objExcelFile.writeExlFile(scenario.getName(), scenario.getStatus(), scenario.isFailed(),  filePath);
         
    log.info(">> Selenium Browser Close Start");
    SeleniumDriver.tearDown();
    try{
		MFUtil.logout();
	}
	catch(Exception e){
	}
    
    String scenarioStatus;
    if(scenario.getStatus().equals("passed")){
    	scenarioStatus = "Passed";
    }
    else {
    	scenarioStatus = "Failed";
    }
    SeleniumHelper.scenarioList.add(new String[]{scenario.getName(),scenarioStatus});
	
    log.info(">> Selenium Browser Close End");
   
    }
    
}    
