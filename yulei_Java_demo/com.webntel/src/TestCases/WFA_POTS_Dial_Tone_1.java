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
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
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
				CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT ON ALL PHONES");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT SP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
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
	    			CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$);
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
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No);
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
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 
		 
		 
		 
		 
		 
		 
		 

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


	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
	
}
