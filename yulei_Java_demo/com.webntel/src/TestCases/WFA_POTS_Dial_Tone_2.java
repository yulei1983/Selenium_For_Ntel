package TestCases;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.Highlighter.Highlight;

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
	    funs.Enter_TN("9991112301");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD");
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
//		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		                
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("No Dial Tone").click();

		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Close with the Customer").click();
	
		Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
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
	public void DT_24(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9998002301");
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
		 chooseBox.ChooseBoxBtn("No Dial Tone At Times").click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDTAT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("Customer Requests Dispatch").click();
		 
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REQUESTS DISPATCH");
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDTAT SP/AC REQ DISP"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
			CheckPoints.AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_notbus_SW());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();
		 
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_customer_agree_to_charges$());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			 Browser_GUI.MainPage.Ask_No(driver).click();

			 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE TO CHARGES");
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDTAT SP/AC REQ DISP REFSD TMQ"); 
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_demand_a_dispatch$());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			 Browser_GUI.MainPage.Ask_No(driver).click();
		 
			 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
			 chooseBox.ChooseBoxBtn("Call Tree").click();
			 
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REQUESTS DISPATCH");
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA NDTAT SP/AC REQ DISP REFSD TMQ CL TREE"); 
			
			 Date  vToday = new SimpleDateFormat("MM-dd-yy hhmma").parse(funs.get_localtime_maingui()+"M");
			 vToday = functions.DateAdd(vToday, Calendar.DAY_OF_YEAR , 4);
			 String strToday = functions.dateToString(vToday);
			 strToday = strToday.substring(0, 9);
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver), "value" , strToday+"0818P"); 
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
			CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA NDTAT SP/AC REQ DISP REFSD TMQ CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
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
	public void DT_25(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9976002301");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

//		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
//		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
//		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
//		 Browser_GUI.MainPage.Ask_No(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SE);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("All Phones Not All Calls (AP/NOT AC)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES NOT ALL CALLS (AP/NOT AC)");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.Information_I_would_like_to_assist_you_in_determining());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		 chooseBox.ChooseBoxBtn("Close with the Customer").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/NOT AC TEST:TOK"); 
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
	public void DT_26(){
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
		 chooseBox.ChooseBoxBtn("Can't Call Out").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T CALL OUT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CCO"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CCO_Number_POTS);
		 chooseBox.ChooseBoxBtn("All Numbers").click();

		 Browser_GUI.MainPage.Tree_value(driver, "ALL NUMBERS");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Do_you_have_Dial_Tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT HAVE DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AC NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Only has one phone/ not all calls (OH1P/NOT AC)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "ONLY HAS ONE PHONE/ NOT ALL CALLS (OH1P/NOT AC)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AC NDT OH1P/NOT AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		 Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AC NDT OH1P/NOT AC TEST:TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		 chooseBox.ChooseBoxBtn("Close with the Customer").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","AC NDT OH1P/NOT AC TEST:TOK"); 
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
	public void DT_27(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9976002301");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SE);
		 chooseBox.ChooseBoxBtn("Dial Tone").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Only has one phone/ all calls (OH1P/AC)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "ONLY HAS ONE PHONE/ ALL CALLS (OH1P/AC)");
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		 Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		 Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT OH1P/AC TEST:TOK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		 chooseBox.ChooseBoxBtn("Close with the Customer").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT OH1P/AC TEST:TOK"); 
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
	public void DT_28(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172309");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Has_the_customer_contacted_their_vendor$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_Yes(driver), "innerText",CheckPoints.AM_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_No(driver), "innerText",CheckPoints.AM_No());
		 Browser_GUI.MainPage.AM_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CONTACTED VENDOR");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_You_can_verify_if_the_trouble_is_in_the_phone_equipment());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CustWantsDISP);
		 chooseBox.ChooseBoxBtn("Customer does not want DISP").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT WANT DISP");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC HOLD FOR SUB - NEEDS TMQ"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("Verbal CPE/NID Isolation").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "VERBAL CPE/NID ISOLATION");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SDT SP/AC HOLD FOR SUB - NEEDS TMQ VRBL CPE/NID ISO"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SDT SP/AC HOLD FOR SUB - NEEDS TMQ VRBL CPE/NID ISO"); 
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
	public void DT_29(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996002322");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Has_the_customer_contacted_their_vendor$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_Yes(driver), "innerText",CheckPoints.AM_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_No(driver), "innerText",CheckPoints.AM_No());
		 Browser_GUI.MainPage.AM_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS CONTACTED VENDOR");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("Premise Wiring/Jack").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "PREMISE WIRING/JACK");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PREMIS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_W());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Will_customer_accept_charges$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER WILL NOT ACCEPT CHARGES");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC REFSD TMQ"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_List_in_narr_name_of_person_declining_TMQ$());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_demand_a_dispatch$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS CONTACTED VENDOR");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("Call Tree").click();
		 
		 Date  vToday = new SimpleDateFormat("MM-dd-yy hhmma").parse(funs.get_localtime_maingui()+"M");
		 vToday = functions.DateAdd(vToday, Calendar.DAY_OF_YEAR , 4);
		 String strToday = functions.dateToString(vToday);
		 strToday = strToday.substring(0, 9);
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver), "value" , strToday+"0818P"); 
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SDT SP/AC REFSD TMQ CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 

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
	public void DT_30(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996012405");
		Thread.sleep(3000);
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		 chooseBox.ChooseBoxBtn("Features").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "FEATURES");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Features_W);
		 chooseBox.ChooseBoxBtn("Call Blocking(*60)").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CALL BLOCKING(*60)");
		 Browser_GUI.MainPage.Tree_value(driver, "NO SERVICE ORDER ACTIVITY");
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER PAYING FOR FEATURE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CALL SCREEN NO SOA CUST PAYING 4"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBLK"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.information_CLOSE(driver), "innerText",CheckPoints.Information_CLOSE());
		 Browser_GUI.MainPage.information_CLOSE(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		 CheckPoints.AM_Was_the_trouble_resolved$());
		 Browser_GUI.MainPage.AM_No(driver).click();
		 
					 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT RESOLVED");
					funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
							CheckPoints.AM_The_feature_is_programmed_in_the_switch$());
					funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
					Browser_GUI.MainPage.AM_OK(driver).click();

					funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Test_the_touchtone_pad$());
					Browser_GUI.MainPage.AM_No(driver).click();
		 
			 Browser_GUI.MainPage.Tree_value(driver, "TOUCHTONE SIGNAL NOT OK");
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CALL SCREEN NO SOA CUST PAYING 4 TT TST NT OK SP/AC"); 
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			 Browser_GUI.MainPage.Ask_Yes(driver).click();
					 
			 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
			 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
			 chooseBox.ChooseBoxBtn("Further Isolation Needed").click();
					 
			 Browser_GUI.MainPage.Tree_value(driver, "FURTHER ISOLATION NEEDED");
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CALL SCREEN NO SOA CUST PAYING 4 TT TST NT OK SP/AC FURTHER ISOLATION IS NEEDED"); 
			 funs.CheckPorperty(Browser_GUI.MainPage.Information_MSG_JTextPane(driver), "innerText",CheckPoints.Information_I_would_like_to_assist_you_in_determining());
			 Browser_GUI.MainPage.Information_OK(driver).click();	 
					 
			 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
			 chooseBox.ChooseBoxBtn("Not willing to check").click();

			 Browser_GUI.MainPage.Tree_value(driver, "NOT WILLING TO CHECK");
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CALL SCREEN NO SOA CUST PAYING 4 TT TST NT OK SP/AC FURTHER ISOLATION IS NEEDED HOLD FOR SUB"); 
			 chooseBox.ChooseBoxBtn("No Instructions Given").click();

			 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT RESOLVED");
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA CALL SCREEN NO SOA CUST PAYING 4 TT TST NT OK SP/AC FURTHER ISOLATION IS NEEDED HOLD FOR SUB NO CPE/NID INSTRCTN"); 
			 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBLK"); 

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
	public void DT_31(){
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
		 chooseBox.ChooseBoxBtn("No Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("Further Isolation Needed").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "FURTHER ISOLATION NEEDED");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT SP/AC FURTHER ISOLATION IS NEEDED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Information_JTextPane(driver), "innerText",CheckPoints.Information_I_would_like_to_assist_you_in_determining());
		 Browser_GUI.MainPage.Information_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
		 chooseBox.ChooseBoxBtn("Willing to check").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "WILLING TO CHECK");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT SP/AC FURTHER ISOLATION IS NEEDED WL CK CPE-NID"); 
		 Browser_GUI.MainPage.information_CLOSE(driver).click();

		 Browser_GUI.MainPage.information_CLOSE(driver).click();

		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		 chooseBox.ChooseBoxBtn("Call Tree").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD NDT SP/AC FURTHER ISOLATION IS NEEDED WL CK CPE-NID CL TREE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD NDT SP/AC FURTHER ISOLATION IS NEEDED WL CK CPE-NID CL TREE"); 
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
	public void DT_32(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991112421");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE TROUBLE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_ATT_CPE$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RFDPP"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_The_customer_subscribes_to_Phone_Protect$$$Hours_are_M_F_9A_9P_EST_SAT_9A_2P_EST());
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD SDT SP/AC RFRD TO PP VNDR"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RFDPP"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

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
	public void DT_33(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9998002320");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("NID Trouble").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "NID TROUBLE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PREMIS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_notbus_SW());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_customer_agree_to_charges$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES TO CHARGES");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC TMQ"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_We_can_have_your_service_repaired_on_$rex_Date$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC TMQ"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PREMIS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 

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
	public void DT_34(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9998002301");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE TROUBLE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_ATT_CPE$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

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
	public void DT_35(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9976002301");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();
		 
//		 Browser_GUI.MainPage.Tree_value(driver, "CPE TROUBLE");
//		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
//		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
//		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Refer_to_the_Handbook_for_vendor_referral_information_if_the_customer_purchased_equipment_from_SNET());
//		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

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
	public void DT_36(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9996002301");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

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
	public void DT_37(){
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
		 chooseBox.ChooseBoxBtn("Beeping On Line").click();

		 Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		 Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
		 Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL NOT PROGRAMMED IN ERROR");

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","BEEPING"); 
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
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		 chooseBox.ChooseBoxBtn("Call Tree").click();

		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 Browser_GUI.MainPage.AM_OK(driver).click();  
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA BEEPING CL TREE"); 
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
	public void DT_38(){
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();
		 	 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE TROUBLE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Does_the_customer_have_ATT_CPE$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Advise_the_customer_to_call_the_ATT_CPE_Cust$$$1_800_667_2118$$$phone_is_under_warranty());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

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
	public void DT_39(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172309");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Has_the_customer_contacted_their_vendor$());
		 Browser_GUI.MainPage.AM_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CONTACTED VENDOR");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_You_can_verify_if_the_trouble_is_in_the_phone_equipment());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CustWantsDISP);
		 chooseBox.ChooseBoxBtn("Customer does not want DISP").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT WANT DISP");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC HOLD FOR SUB - NEEDS TMQ"); 
		 chooseBox.ChooseBoxBtn("Call Tree").click();

		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CONTACTED VENDOR");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 Browser_GUI.MainPage.AM_OK(driver).click();

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SDT SP/AC HOLD FOR SUB - NEEDS TMQ CL TREE"); 
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
	public void DT_40(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991202326");
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
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "SENT TO RCMAC TO ADD FEATURE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_The_feature_cannot_be_added_through_QVF$());
		 Browser_GUI.MainPage.AM_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS ADD FEAT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	 

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS ADD FEAT"); 
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
	public void DT_41(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991202327");
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
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver), "innerText",CheckPoints.Data_Input_Enter_the_call_forwarding_number$());
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_OK(driver), "innerText",CheckPoints.DataInput_OK());
		 Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("9996002301");
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_MaskEdit(driver), "value", "9996002301");
		 Browser_GUI.MainPage.DataInput_OK(driver).click();

		 Browser_GUI.MainPage.Tree_value(driver, "TT FIX NOT SUCCESSFUL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	 

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
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
	public void DT_42(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9991172671");
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
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver), "innerText",CheckPoints.Data_Input_Enter_the_call_forwarding_number$());
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_OK(driver), "innerText",CheckPoints.DataInput_OK());
		 Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("9996002301");
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_MaskEdit(driver), "value", "9996002301");
		 Browser_GUI.MainPage.DataInput_OK(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver), "innerText",CheckPoints.Data_Input_Please_input_the_desired_ring_cycle_for_this_feature$());
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_OK(driver), "innerText",CheckPoints.DataInput_OK());
		 Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("02");
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_MaskEdit(driver), "value", "02");
		 Browser_GUI.MainPage.DataInput_OK(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TT FIX NOT SUCCESSFUL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
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
	public void DT_43(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012362");
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
		 Browser_GUI.MainPage.Tree_value(driver, "TT ON BILLING ACCOUNT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver), "innerText",CheckPoints.Data_Input_Please_input_the_desired_ring_cycle_for_this_feature$());
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_OK(driver), "innerText",CheckPoints.DataInput_OK());
		 Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("02");
		 funs.CheckPorperty(Browser_GUI.MainPage.DataInput_MaskEdit(driver), "value", "02");
		 Browser_GUI.MainPage.DataInput_OK(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TT FIX NOT SUCCESSFUL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT PAYING 4 TT NOT IN XLTNS QVF FAILED"); 
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
	public void DT_44(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012669");
		Thread.sleep(3000);
		
		 Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		 Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		 Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		 Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
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
		 Browser_GUI.MainPage.Tree_value(driver, "TT SERVICE ORDER PENDING");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		 Browser_GUI.MainPage.Tree_value(driver, "TT SERVICE ORDER PENDING");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT OK IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_customer_calling_from_the_line$$$not_working$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_No(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER NOT ABLE TO PRESS BUTTONS");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT OK IN XLTNS TT IN XLATIONS"); 
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
	public void DT_45(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9973012306");
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
		 Browser_GUI.MainPage.Tree_value(driver, "SUBSCRIBES TO VOICE MAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS RETRIEVED MESSAGES");
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
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE ISOLATION EMAIL");
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	

		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD BEEPING ISO EMAIL"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
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
	public void DT_46(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9975002302");
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
		 chooseBox.ChooseBoxBtn("Slow Dial Tone").click();

		 Browser_GUI.MainPage.Tree_value(driver, "SLOW DIAL TONE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		 chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CHECKED CPE AND/OR NID");
		 funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premis_Wiring_Jack_Problem);
		 chooseBox.ChooseBoxBtn("CPE Trouble").click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "CPE TROUBLE");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT SP/AC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CKCPE"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
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
	public void DT_47(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.Enter_TN("9976002307");
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
		 Browser_GUI.MainPage.Tree_value(driver, "BILL-SOUTHEAST TT");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT BILL-SE TT"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT BILL-SE TT NOT IN XLTNS"); 
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
	
	@Test
	public void DT_48(){
	 try {
		 Thread.sleep(2000);
		ChooseBox chooseBox;
		chooseBox = new ChooseBox(driver);
		funs.ReloginNtel("jt0015");
		funs.update_ntel_dbase("update __jt0015_fixfeat set TREE='TOUCH-TONE SERVICE FOR TESTING',FEATMSG='TOUCH-TONE SERVICE FOR TESTING' where REGION='MW' and FEATURE='TOUCHTONE' and SWITCH_TYPE='5ESS'", "fixfeat");
		funs.update_ntel_dbase("update __jt0015_switchtype set `FIXABLE`='N' where `REGION`='MW' and `SWITCH_TYPE`='5ESS'", "switchtype");
	
		funs.Enter_TN("9991852584");
		Thread.sleep(3000);
		 Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		 Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
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

		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		 funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		 Browser_GUI.MainPage.Ask_Yes(driver).click();
		 
		 
		 Browser_GUI.MainPage.Tree_value(driver, "FEATURE NOT IN TRANSLATIONS");
		 Browser_GUI.MainPage.Tree_value(driver, "TOUCH-TONE SERVICE FOR TESTING");
		 Browser_GUI.MainPage.Tree_value(driver, "TT NOT ON SWITCH");
		 Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT NOT IN XLTNS"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_TOUCH_TONE_SERVICE_FOR_TESTING());
		 Browser_GUI.MainPage.AM_OK(driver).click();	
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_The_feature_is_missing_in_the_switch$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		 Browser_GUI.MainPage.AM_OK(driver).click();	
		 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CBDT PAYING 4 TT NOT IN XLTNS FEAT NT IN XLTN"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","RCMAC"); 
		 funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		 Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		 Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TYJ"); 
		 Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		 Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		  
		 Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		 funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		 Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();

			funs.RollBackAll();
			funs.ReloginNtel("jt0005");
	    }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			try {
				funs.RollBackAll();
				funs.ReloginNtel("jt0005");
			} catch (Exception e1) {
			}
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
       functions.softassert.assertAll();
	}
	
}

