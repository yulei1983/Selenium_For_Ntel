package prepare;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utils.Lib;
import utils.PropertiesDataProvider;

public class MMDriver {
	public static WebDriver driver=null;
	public static boolean INIT=false;
	public static SoftAssert softAssert = null;
	public static WebDriver init() {
		if(INIT==false){
			MMDriver.setDriver();
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
    		MMDriver.driver = Lib.launchBrowser();
        }
    	else {
    		//Remote running
    		MMDriver.driver = Lib.launchBrowser(RemoteServerUrl);
		}
	}
	
	public static void quitDriver(){
		driver.quit();
	}
	
	
}
