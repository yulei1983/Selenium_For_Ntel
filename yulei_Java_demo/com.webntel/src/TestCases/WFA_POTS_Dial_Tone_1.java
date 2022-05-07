package TestCases;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import Object_Repository.WebTable;
import Object_Repository.AdminGui;
import Object_Repository.Browser_GUI;
import Object_Repository.CheckPoints;

public class WFA_POTS_Dial_Tone_1{
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
	public void DT_01(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991852584");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
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
				CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT ON ALL PHONES");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT SP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CHECKED CPE AND/OR NID");
		funs.CheckPorperty(Browser_GUI.MainPage.Information_MSG_JTextPane(driver), "innerText",
				CheckPoints.Information_I_would_like_to_assist_you_in_determining());
		funs.CheckPorperty(Browser_GUI.MainPage.Information_OK(driver), "innerText",CheckPoints.Information_OK());
		Browser_GUI.MainPage.Information_OK(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
		chooseBox.ChooseBoxBtn("Not willing to check").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT SP/AC HOLD FOR SUB"); 
		Browser_GUI.MainPage.Tree_value(driver, "NOT WILLING TO CHECK");
		chooseBox.ChooseBoxBtn("Call Tree").click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD CBDT PAYING 4 TT SP/AC HOLD FOR SUB CL TREE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();	
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void DT_02() throws Exception{	
	    try {
			ChooseBox chooseBox;
			chooseBox = new ChooseBox(driver);
	    	funs.Enter_TN("9991172632");
			Thread.sleep(2000);
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();
	    	
	    	Thread.sleep(1000);
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Service_Order_Activity_is_present$());
	    	Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_No(driver).click();

	    	funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
	    	chooseBox.ChooseBoxBtn("Dial Tone").click();

	    	Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

	    	funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
	    	chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

	    	Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
	    	Browser_GUI.MainPage.Tree_value(driver, "TT SERVICE ORDER PENDING");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
	    	Browser_GUI.MainPage.Tree_value(driver, "TT ON SWITCH");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT OK IN XLTNS");
	    	 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    	       CheckPoints.Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER ABLE TO PRESS BUTTONS");
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT OK IN XLTNS TT TEST W/CUST OK");
	    	Browser_GUI.MainPage.Tree_value(driver, "AGENT HEARD TONE");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
	    	Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
	    	Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
	    	Browser_GUI.MainPage.BTN_Submit(driver).click(); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
	    	Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
	    	 
	    	Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
	    	Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

		    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();	
	}
	
	@Test
	public void DT_03() throws Exception{
	    try {
			ChooseBox chooseBox;
			chooseBox = new ChooseBox(driver);
	    	funs.Enter_TN("9973012360");
			Thread.sleep(2000);
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_No(driver).click();

	    	funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
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
	    			CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
	    	Browser_GUI.MainPage.Tree_value(driver, "TT ON SWITCH");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT OK IN XLTNS"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
	    			CheckPoints.Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_Yes(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER ABLE TO PRESS BUTTONS");
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
	    	funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    	Browser_GUI.MainPage.Ask_No(driver).click();

	    	Browser_GUI.MainPage.Tree_value(driver, "AGENT DID NOT HEAR TONE");
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT OK IN XLTNS TT TST FAILED, CHK 4 RVRSD PRS"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FRAME"); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
	    	Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
	    	Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
	    	Browser_GUI.MainPage.BTN_Submit(driver).click(); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
	    	Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
	    	 
	    	Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
	    	funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
	    	Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
   	    	
	}
	
	@Test
	public void DT_04() throws Exception{
	 try {
			Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
    	funs.Enter_TN("9973012360");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$());
		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		Browser_GUI.MainPage.Tree_value(driver, "TT ON SWITCH");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT OK IN XLTNS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT OK IN XLTNS TT IN XLATIONS");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER NOT ABLE TO PRESS BUTTONS");
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON");
		Browser_GUI.MainPage.BTN_Submit(driver).click();
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes());
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click();
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click();
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
   	    	
	}
	
	@Test
	public void DT_05(){
	 try {
		Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
    	funs.Enter_TN("9991852584");
		Thread.sleep(2000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
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
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "TT FIXED IN SWITCH VIA QVF");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FIXFEASO"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_TT_has_been_added_to_the_customer$s_line_in_the_switch$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT NOT IN XLTNS TT FIXED VIA QVF"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FIXFEASO"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
   	    	
	}
	
	@Test
	public void DT_06(){
	 try {
		Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991852585");
		Thread.sleep(2000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "TT SERVICE ORDER PENDING");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_TT_has_been_added_to_the_customer$s_line_in_the_switch$());
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "TT FIXED IN SWITCH VIA QVF");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FIXFEASO"); 
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NOT IN XLTNS TT FIXED VIA QVF"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FIXFEASO"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
	}
	
	@Test
	public void DT_07(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991853164");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorpertyWithRegex(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by(), 0, 0);
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "TT FIX NOT SUCCESSFUL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
	}
	
	@Test
	public void DT_08(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991852536");
		Thread.sleep(2000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT BLG DOWN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
          functions.softassert.assertAll();
	}
	
	@Test
	public void DT_09(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172670");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER PHONE HAS PULSE/TONE SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Advise_the_customer_to_switch_the_phone_to_pulse_setting$());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT ADVSD SUB"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}

	@Test
	public void DT_10(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012361");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUST PHONE HAS NO PULSE/TONE SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Touchtone_service_is_not_on_the_customer$s_account$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "WANTS TOUCHTONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","REFBO"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Online_transfer_to_MO_EB$$$800_499_7928$$$800_499_7928());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","REFBO"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_11(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172670");
		Thread.sleep(3000);
		
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		
		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT"); 

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUST PHONE HAS NO PULSE/TONE SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Touchtone_service_is_not_on_the_customer$s_account$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT WANT TOUCHTONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT ADVSD SUB"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_12(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991852550");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "SUBSCRIBES TO VOICE MAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT RETRIEVED MESSAGES");
		 Browser_GUI.MainPage.information_CLOSE(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_customer$s_trouble_resolved$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE RESOLVED");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING TBL RESOLVED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_13(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9998002370");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "SUBSCRIBES TO VOICE MAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT RETRIEVED MESSAGES");
		 Browser_GUI.MainPage.information_CLOSE(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_customer$s_trouble_resolved$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT RESOLVED");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CHECKED CPE AND/OR NID");
		 funs.CheckPorperty(Browser_GUI.MainPage.Information_MSG_JTextPane(driver), "innerText",CheckPoints.Information_I_would_like_to_assist_you_in_determining());
		 Browser_GUI.MainPage.Information_OK(driver).click();

		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
		 chooseBox.ChooseBoxBtn("Willing to check").click();

		 Browser_GUI.MainPage.Tree_value(driver, "WILLING TO CHECK");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING SP/AC WL CK CPE-NID"); 
		 Browser_GUI.MainPage.information_CLOSE(driver).click();

		 Browser_GUI.MainPage.information_CLOSE(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("Call Tree").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA BEEPING SP/AC WL CK CPE-NID CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA BEEPING SP/AC WL CK CPE-NID CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_14(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012689");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 String ExpOfferedCommit = funs.get_commitment_time();
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "SUBSCRIBES TO VOICE MAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
	 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_beeping_heard_on_all_phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Advise_customer_to_check_their_equipment$_Is_customer_willing_to_check_equipment$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "WILLING TO CHECK CPE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("CPE Isolation Email").click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD BEEPING ISO EMAIL"); 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE ISOLATION EMAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD BEEPING ISO EMAIL"); 

		String  ExpCurrentCommit  = funs.get_commitment_time();                                                                                               
		String  ExpIssueDispatch= funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived = funs.get_localtime_maingui();
		 	 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 
		 //open ems log page and show demo list.
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
//			 int TnsRow = EmsLogTable.getRowWithTN("9973012689");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","CATS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","CATS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","PO206B89"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9973012689"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","MO"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","RHONDA GRAHAM"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","MO"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-TY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9999999999"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Business"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0005"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "C" + functions.EMS_Log_TZ()); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebCheckBox_AOD_Callback_Suppress_Ind(AdminGuiDriver), "value", "0"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Comments(AdminGuiDriver), "value"," "); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_System(AdminGuiDriver), "value","NTEL"); 
             funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Dispatch_DT(AdminGuiDriver), "value", ExpIssueDispatch,15);
             funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Submit_DT(AdminGuiDriver), "value", ExpIssueSubmit,15);
             funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Received_DT(AdminGuiDriver), "value", ExpWFACReceived,15);
             funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Offered_Commit_DT(AdminGuiDriver), "value", ExpOfferedCommit,15);
             funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_Current_Commit_DT(AdminGuiDriver), "value", ExpCurrentCommit,0);
			 
			 AdminGui.EMS_Issues_Log_Detail.Btn_Back(AdminGuiDriver).click();
			 functions.GoBackWindow(AdminGuiDriver, OldOneHandle);
			 AdminGuiDriver.close();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_15(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9998002446");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL NOT PROGRAMMED IN ERROR");
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
//		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_beeping_heard_on_all_phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "NOT ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_there_any_equipment());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME EQUIPMENT REQUIRES BATTERIES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Advise_customer_to_check_their_equipment$_Is_customer_willing_to_check_equipment$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "NOT WILLING TO CHECK CPE");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		 Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING TEST:TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		 chooseBox.ChooseBoxBtn("Close with the Customer").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING TEST:TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_16(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996012306");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();

		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL NOT PROGRAMMED IN ERROR");
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
//		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_beeping_heard_on_all_phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "NOT ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_there_any_equipment_$such_as_headsets());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "NOT ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_that_line_currently_in_use$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		 Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		 chooseBox.ChooseBoxBtn("Close with the Customer").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING TEST:TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_17(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996012660");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();

		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING MWI NEEDS REMOVED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_18(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012317");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Touchtone_service_is_not_on_the_customer$s_account$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT NT PAYING 4 TT ADVSD SUB"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT WANT TOUCHTONE");
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_19(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991852441");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER PHONE HAS PULSE/TONE SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Advise_the_customer_to_switch_the_phone_to_pulse_setting$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT ADVSD SUB"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_20(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996002337");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		 Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: BUSY SPEECH");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: SSMTEST REQ RETEST");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: NEED FURTHER ISOLATION");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AP/AC TEST:BUSY"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_The_test_result_is_inconclusive$_The_line_will_be_retested$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_Yes(driver), "innerText",CheckPoints.AM_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_No(driver), "innerText",CheckPoints.AM_No());
		 Browser_GUI.MainPage.AM_No(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_The_test_result_is_inconclusive$_The_line_will_be_retested$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_Yes(driver), "innerText",CheckPoints.AM_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_No(driver), "innerText",CheckPoints.AM_No());
		 Browser_GUI.MainPage.AM_No(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "outerText",CheckPoints.AM_Our_test_indicates_there$$$15_minutes$());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_customer_agree_to_charges$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE TO CHARGES");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AP/AC TEST:BUSY REFSD TMQ"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_demand_a_dispatch$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("Call Tree").click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA AP/AC TEST:BUSY REFSD TMQ CL TREE"); 

		 Date  vToday = new SimpleDateFormat("MM-dd-yy hhmma").parse(funs.get_localtime_maingui()+"M");
		 vToday = functions.DateAdd(vToday, Calendar.DAY_OF_YEAR , 4);
		 String strToday = functions.dateToString(vToday);
		 strToday = strToday.substring(0, 9);
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver), "value" , strToday+"0818P"); 

		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA AP/AC TEST:BUSY REFSD TMQ CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_21(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172610");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
	     funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "TT SERVICE ORDER PENDING");
	     funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "SENT TO RCMAC TO ADD FEATURE");
	     funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_The_feature_cannot_be_added_through_QVF$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
	     funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NOT IN XLTNS ADD FEAT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
	     funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT NOT IN XLTNS ADD FEAT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-RON"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	@Test
	public void DT_22(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991112301");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "NO TT SERVICE ORDER PENDING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT"); 

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "QVF FAILED");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_QVF_Failed$());
	     funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
	     funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	
}
