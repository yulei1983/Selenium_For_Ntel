package TestCases;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Function_Libary.WebDriver_Setup;
import Function_Libary.functions;
import Object_Repository.ChooseBox;
import Object_Repository.QTP_CheckList;
import Object_Repository.Browser_GUI;
import Object_Repository.CheckPoints;

public class WFA_POTS_Dial_Tone_2{
//	SoftAssert softAt = null;
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
	public void afterMethod() throws Exception{

	}
	
	@AfterClass
	public void AfterClass() throws Exception{
//		driver.close();
	}
	
	
	@Test
	public void DT_23(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991852584");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer_name_and_address$$$address_correct$);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		                
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT ON ALL PHONES");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT SP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CHECKED CPE AND/OR NID");
		funs.CheckPorperty(Browser_GUI.MainPage.Information_MSG_JTextPane(driver), "innerText",
				CheckPoints.information_I_would_like_to_assist_you_in_determining$$$If_the_customer_is_interested_select_Willing_to_check);
		funs.CheckPorperty(Browser_GUI.MainPage.Information_OK(driver), "innerText",CheckPoints.Information_OK);
		Browser_GUI.MainPage.Information_OK(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
		chooseBox.ChooseBoxBtn("Not willing to check").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT SP/AC HOLD FOR SUB"); 
		Browser_GUI.MainPage.Tree_value(driver, "NOT WILLING TO CHECK");
		chooseBox.ChooseBoxBtn("Call Tree").click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$);
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK);
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD CBDT PAYING 4 TT SP/AC HOLD FOR SUB CL TREE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();	
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	

	
	@Test
	public void DT_24(){
	 try {
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
   	    	
	}

		
}

