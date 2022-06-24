package TestCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Function_Libary.WebDriver_Setup;
import Function_Libary.functions;
import Object_Repository.Browser_GUI;
import Object_Repository.CheckPoints;
import Object_Repository.ChooseBox;

public class GUIs {
	WebDriver driver = null;
	functions funs = null;
	String declaringClassNameReg = "TestCases";
	
	@BeforeClass
	public void beforeClass()  {
		try {
			this.driver = WebDriver_Setup.init();
			this.funs= new functions(driver);
			funs.loginNtel("jt0005");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@BeforeMethod
	public void beforeMethod(){		
		try {
			Thread.sleep(200);
			SoftAssert softAt = new SoftAssert();
			functions.softassert = softAt;
			funs.ClearNtel(driver);
		} catch (Exception e) {
			funs.ClearNtel(driver);
		}finally {
		}
	}
	
	@AfterMethod
	public void afterMethod(){

	}
	
	@AfterClass
	public void AfterClass(){
//		driver.close();
	}
	
	
	@Test
	public void GUI_03_RUD_SW(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9998002612");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "TEST RESULTS/RECOMMENDATION").click();
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_DPG(driver),"outerText","DPG");
		Browser_GUI.MainPage.BTN_DPG(driver).click();
	    Thread.sleep(2000);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		funs.CheckPorpertyWithRegex(Browser_GUI.MainPage.Webtable_right_html_section(driver),"outerText","ISAAC[\\s\\S]*9998002612NO DATA FOUND");
        driver.switchTo().defaultContent();
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void GUI_04_RUD_W(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9996002540");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "TEST RESULTS/RECOMMENDATION").click();
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_DPG(driver),"outerText","DPG");
		Browser_GUI.MainPage.BTN_DPG(driver).click();
	    Thread.sleep(2000);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
//		funs.CheckPorpertyWithRegex(Browser_GUI.MainPage.Webtable_right_html_section(driver),"outerText","ISAAC INFORMATION[\\s\\S]*9996002540[\\s\\S]*");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_04_RUD_W","DPG Information Check");

        driver.switchTo().defaultContent();
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
