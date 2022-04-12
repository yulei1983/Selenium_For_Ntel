package Function_Libary;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.*;
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
	public static WebDriver Edriver;
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
		String webdv;
		String webdvdir;
		switch ("EDGE") {
		case "Chrome":
			 webdv = PropertiesDataProvider.getTestData("config/config.properties", "webdv");
			 webdvdir = PropertiesDataProvider.getTestData("config/config.properties", "webdvdir");
			 System.setProperty(webdv, webdvdir);
				//Set Chrome Options.
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
				driver = new ChromeDriver();
			    break;
		case "EDGE":
			 webdv = PropertiesDataProvider.getTestData("config/config.properties", "Edgewebdv");
			 webdvdir = PropertiesDataProvider.getTestData("config/config.properties", "Edgewebdvdir");
			 System.setProperty(webdv, webdvdir);
			 driver = new EdgeDriver();
			 break;
		default:
			 driver = null;
		}
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
	


