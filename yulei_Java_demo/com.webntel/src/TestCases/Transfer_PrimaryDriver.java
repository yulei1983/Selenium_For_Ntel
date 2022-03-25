//package TestCases;
//
//import java.util.concurrent.TimeUnit;
//
//import javax.swing.tree.ExpandVetoException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import Function_Libary.WebDriver_Setup;
//import Function_Libary.functions;
//import Object_Repository.ChooseBox;
//import bsh.This;
//
//public class Transfer_PrimaryDriver {
//	// static WebDriver driver = WebDriver_Setup.GetChromeDriver();
//	// WebDriver driver = WebDriver_Setup.Get_Remote_driver();
//	public static WebDriver driver = null;
//	public static boolean INIT = false;
//	public static SoftAssert softAt = null;
////	public static functions funs = null;
//
//	/**
//	 * ����webdriver
//	 * 
//	 * @return WebDriver
//	 */
//	public static WebDriver GetDriver() throws Exception {
//		if (INIT == false) {
//			Transfer_PrimaryDriver.setDriver();
//			INIT = true;
//		} else {
//			return driver;
//		}
//		return driver;
//	}
//
//	// public static functions funs() throws Exception {
//	// functions funs= new functions(driver);
//	// return funs;
//	// }
//
////	 public static void setSoftAt(SoftAssert softAt) {
////		 Transfer_PrimaryDriver.softAt = softAt;
////	 }
//
//	public static void setDriver() throws Exception {
//		 System.setProperty("webdriver.chrome.driver",
//		 "./BrowserDriver/chromedriver.exe");
//		Transfer_PrimaryDriver.driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//	}
//
//}
