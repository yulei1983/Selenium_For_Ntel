package Function_Libary;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class WebDriver_Setup {
//	public static WebDriver driver=null;
	public static WebDriver driver;
	public static EdgeDriver Edriver;
    public static RemoteWebDriver rDriver;
	public static SoftAssert softAssert = null;
	public static boolean INIT=false;
	private WebDriver_Setup() {}
	public static WebDriver init() {
		if(INIT==false){
			WebDriver_Setup.setDriver();
			INIT=true;
		}else{
			return driver;
		}
		return driver;
	}
	
	public static void setDriver() {
		String IsLocalRunning = PropertiesDataProvider.getTestData("config/config.properties", "LocalRunning");
		String RemoteServerUrl = PropertiesDataProvider.getTestData("config/config.properties", "RemoteServerUrl");

		if (IsLocalRunning.equals("1")) {
//    		local running
			WebDriver_Setup.driver = WebDriver_Setup.launchBrowser();
        }
    	else {
    		//Remote running
    		WebDriver_Setup.rDriver = launchBrowser(RemoteServerUrl);
		}
	}
	
	/**
	 * 启动Driver
	 * 本地运行
	 * @return WebDriver
	 * @author yulei
	 */
	public static WebDriver launchBrowser(){
		WebDriver driver;
//		EdgeDriver edgeDriver;
		String webdv = PropertiesDataProvider.getTestData("config/config.properties", "webdv");
		String webdvdir = PropertiesDataProvider.getTestData("config/config.properties", "webdvdir");
		System.setProperty(webdv, webdvdir);

//Set Edage
//			EdgeOptions options = new EdgeOptions();
//		    EdgeDriver driver = new EdgeDriver(options);
		    
			//Set Chrome Options.
		    
//			DesiredCapabilities dCapabilities = DesiredCapabilities.chrome();
			ChromeOptions Coptions = new ChromeOptions();
			Coptions.addArguments("test-type");
			Coptions.addArguments("--start-maximized");
			Coptions.addArguments("--disable-web-security");
			Coptions.addArguments("--allow-running-insecure-content");
			Coptions.addArguments("--disable-infobars");
			Coptions.addArguments("--ignore-certificate-errors");
			Coptions.addArguments("--disable-web-security");
			Coptions.addArguments("--allow-running-insecure-content");
			Coptions.setCapability(ChromeOptions.CAPABILITY, Coptions);
//			dCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			dCapabilities.setCapability(CapabilityType.VERSION, true);
//			driver = new ChromeDriver(dCapabilities);
			driver = new ChromeDriver();
		return driver;
	}

	/**
	 * 启动Driver
	 * 远程运行
	 * @param Url
	 * @return WebDriver
	 * @author yulei
	 */
	public static RemoteWebDriver launchBrowser(String Url) {
		//远程运行
		RemoteWebDriver driver;
		try {
		ChromeOptions Coptions = new ChromeOptions();
		Coptions.setCapability("browserVersion", "98");
		Coptions.addArguments("disable-infobars");
		driver = new RemoteWebDriver(new URL(Url), Coptions);

		} catch (MalformedURLException e) {
			return null;
		}
		return driver; 
	}
	

	

}
	


