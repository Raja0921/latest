package runners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.FeatureOverride;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

import com.citi.localProxy.LocalProxyServer;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.ConfigFileReader;

@CucumberOptions(
        plugin = {"json:target/cucumber1.json", "pretty", "html:target/cucumber.html", "com.cucumber.listener.ExtentCucumberFormatter:./newreport.html"},
        features = "src/test/resources/FeatureFiles",
        glue = "stepDef",
       tags = {"@MKT"}
        )

public class SignOnInternetBuildRunner_test  extends AbstractTestNGCucumberTests  {
	public static String fileNameFinal = "Default"; 
	ConfigFileReader configFileReader;
	
	  
@BeforeSuite
	
	public void beforeSuite() throws InvalidFormatException, IOException{
		FeatureOverride.overrideFeatureFiles("src/test/resources/FeatureFiles");
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {				
			try {
				System.out.println(">> Local Proxy Server - Start");
				LocalProxyServer.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println(">> Other than windows - Local Proxy Server Not required");
		}
	}

	
	@AfterSuite
	public void afterSuite() throws Exception{
		//SeleniumHelper.updateALM();
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {				
			LocalProxyServer.stop();
			System.out.println(">> Local Proxy Server - End");
		}
		else {
			System.out.println(">> Other than windows - Local Proxy Server Not required");
		}
	}

	@BeforeClass
	public static void setup() {
		SeleniumHelper.setupExtentReport();
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		
		String xlfileName = System.getProperty("user.dir")+"/"+strDate+".xls";
		fileNameFinal =xlfileName;
		System.out.println("Current excel path is ="+ xlfileName);
		File newFile1 = new File(xlfileName);
		System.setProperty("xlFile", xlfileName);
		
    	System.setProperty("lgcag", "");
    	
	}

	@AfterClass
	public void afterClass() throws Exception {
		SeleniumHelper.tearDownReport();
	}
	

	
}
