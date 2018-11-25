package utils;




import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigFileReader;

public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
    String driverName = "phantomjsdriver";
    public static WebDriver driver;
    //initialize webdriver
    
    final static Log log = LogFactory.getLog(SeleniumDriver.class.getName());
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 60;
    public final static int PAGE_LOAD_TIMEOUT = 60;
    ConfigFileReader configFileReader;
    String tmpDriverPath;
    String tmpDriverUnxPath;
    ChromeOptions options = new ChromeOptions();

    
	
	private  SeleniumDriver() {
    	configFileReader= new ConfigFileReader();
    	if (System.getProperty("os.name").toLowerCase().contains("windows")) {				
			//-----------------------------------------------------------------------------------------------------
			//----------------------------- Windows Chrome WebDriver 32 bit ---------------------------------------
			//-----------------------------------------------------------------------------------------------------
    		int countRetry = 0;
    		 int maxRetryCount=3;
    		 
             while(driver==null && countRetry<maxRetryCount)
             {
                     try{
                    	 System.out.println("Windows 1");
                 		String proxyDetails = "webproxy.wlb2.nam.nsroot.net:8092";
                 		//WebDriverManager.chromedriver().proxy(proxyDetails).arch64().version("2.36").setup();
                 		
                 		try{
                 			System.out.println(">> Selenium Chrom Driver - Initiation - Try Part");
                 			WebDriverManager.chromedriver().version("2.36").setup();
                 		}catch (Exception e){
                 			System.out.println(">> Selenium Chrom Driver - Initiation - Catch Part");
                 			WebDriverManager.chromedriver().version("2.36").forceDownload().proxy(proxyDetails).setup();	
                 		}
                    	 
                    	 //WebDriverManager.chromedriver().arch64().version("2.36").setup();
                 		options.setExperimentalOption("useAutomationExtension", false);
                		options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                		driver = new ChromeDriver(options);
                        driver.manage().window().maximize();
             	        waitDriver = new WebDriverWait(driver, TIMEOUT);
             	        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
             	        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
             	        String window=driver.getWindowHandle();
             	        log.info("Window ->"+window);
             	        countRetry = countRetry + 1;
                     }
                     catch(Exception e){
                             System.out.println("Retrying " + countRetry +1  + "times to create driver instances..");
                             if(countRetry==maxRetryCount){
                                     throw new WebDriverException(e.getMessage());
                             }
                             e.printStackTrace();
                             countRetry = countRetry + 1;
                     }
             }
             
    		
	        
	        
    	} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			System.out.println("Linux 1");
			//-----------------------------------------------------------------------------------------------------
			//------------------------------- Linux Phantom WebDriver 32 bit --------------------------------------
			//-----------------------------------------------------------------------------------------------------
			String proxyDetails1 = "webproxy.wlb2.nam.nsroot.net:8092";
			WebDriverManager.phantomjs().proxy(proxyDetails1).setup();
			DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setJavascriptEnabled(true);
            String proxyDetails = "webproxy.wlb2.nam.nsroot.net:8092";
            Proxy proxy = new Proxy();
            proxy.setProxyType(ProxyType.MANUAL);
            proxy.setHttpProxy(proxyDetails).setSslProxy(proxyDetails).setSocksProxy(proxyDetails);
            capabilities.setCapability(CapabilityType.PROXY, proxy);
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            capabilities.setPlatform(Platform.ANY);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX + "X-MALP", "1");
            capabilities.setAcceptInsecureCerts(true);
            driver = new PhantomJSDriver(capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(proxyDetails);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
		} else {
			System.out.println("Other");
    		String proxyDetails = "webproxy.wlb2.nam.nsroot.net:8092";
    		WebDriverManager.chromedriver().proxy(proxyDetails).arch64().version("2.36").setup();
    		options.setExperimentalOption("useAutomationExtension", false);
   			options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
   			driver = new ChromeDriver(options);
           driver.manage().window().maximize();
	        waitDriver = new WebDriverWait(driver, TIMEOUT);
	        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	        String window=driver.getWindowHandle();
	        log.info("Window ->"+window);
		}
 }

    private DesiredCapabilities getCapChrome() {
	    DesiredCapabilities caps = DesiredCapabilities.chrome();
	    LoggingPreferences logPrefs = new LoggingPreferences();
	    logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
	    logPrefs.enable(LogType.PROFILER, Level.INFO);
	    logPrefs.enable(LogType.BROWSER, Level.INFO);
	    logPrefs.enable(LogType.CLIENT, Level.INFO);
	    logPrefs.enable(LogType.DRIVER, Level.INFO);
	    logPrefs.enable(LogType.SERVER, Level.INFO);
	    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    String proxyDetails = "webproxy.wlb2.nam.nsroot.net:8092";
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy(proxyDetails).setSslProxy(proxyDetails)
				.setSocksProxy(proxyDetails);
		caps.setCapability(CapabilityType.PROXY, proxy);
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,
				true);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setAcceptInsecureCerts(true);
	    //log.info(tmpDriverPath);
	    return caps;
	}
    
    
    public static void openPage(String url) {
    	log.info(url);
    	log.info(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
       		//seleniumDriver = 
    	   //seleniumDriver = new StartedChromeBrowser();
    }

    public static void tearDown() {
    	   if (driver != null) {            
               driver.quit();
               driver=null;
            }
            seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   

}
