package TestCases;

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
import Object_Repository.QTP_CheckList;

public class WFA_Key_Data {
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
	public void KEYD_01(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112424");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
//		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
//		CheckPoints.AM_ESL___GIVE_4_HOUR_COMMITMENT());
//		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
//		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",CheckPoints.AM_Recent_History_within_past_30_days$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_Yes(driver), "innerText",CheckPoints.AM_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_No(driver), "innerText",CheckPoints.AM_No());
		Browser_GUI.MainPage.AM2_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",CheckPoints.AM_Is_customer$s_recent_History_related_to_the_trouble_being_reported_now());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_Yes(driver), "innerText",CheckPoints.AM_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_No(driver), "innerText",CheckPoints.AM_No());
		Browser_GUI.MainPage.AM2_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		                
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("No Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Is_that_line_currently_in_use$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$for_CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Close with the Customer").click();

		Browser_GUI.MainPage.Tree_red_value(driver, "CABLE FAILURE");
		Browser_GUI.MainPage.Tree_value(driver, "30 DAY REPEATED REPORT SEE HISTORY");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0422A");
//		Browser_GUI.MainPage.Tree_value(driver, "GRP ID A001E");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMICHPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "MAINTENANCE PLAN:ESSENTIAL LINE");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC SUIT 101");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG ESL");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "SMALL BUSINESS SERVICES");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER W PHONE OPTION- RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "NOT RELATED TO CABLE FAILURE");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		Browser_GUI.MainPage.Tree_value(driver, "CHRONIC TROUBLE");
		Browser_GUI.MainPage.Tree_value(driver, "CHRONIC =0");
		Browser_GUI.MainPage.Tree_value(driver, "CORPORATION: AT&T");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
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
	public void KEYD_02(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991172373");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCINDIPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG MRS MULTI TNS-DIFFERENT RINGS");
		Browser_GUI.MainPage.Tree_value(driver, "PDATE 08-31-05 1145A");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "MULTI RING");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER WITH PHONE OPTION - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_03(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002352");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9996002352"); 

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 08-01-04 0255A");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9996002352");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_04(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002353");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9996002353"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_AccessAfter(driver), "value","0200P"); 

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 08-01-04 0255A");
		Browser_GUI.MainPage.Tree_value(driver, "ACCESS AFTER 0200P");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "HANDLE SMLOS");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9996002353");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_05(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991172308");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_for_a_Reach_Number$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCINDIPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 08-01-04 0255A");
		Browser_GUI.MainPage.Tree_value(driver, "ACCESS AFTER 0200P");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER WITH PHONE OPTION - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "HANDLE SMLOS");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_06(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998002352");
	    Thread.sleep(3000);
	    
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCTEXAPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "ACCESS AFTER 0200P");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_for_a_Reach_Number$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		
		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_07(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9983002338");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Miscellaneous").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MISC_SE);

		Boolean Y = funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.Tree_value(driver, "MISCELLANEOUS");
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED IN");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_08(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9983002339");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SE);
		chooseBox.ChooseBoxBtn("Miscellaneous").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MISC_SE);
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_09(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991852416");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9991852416"); 
		
		Browser_GUI.MainPage.Tree_value(driver, "30 DAY REPEATED REPORT SEE HISTORY");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMICHPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LSH");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 07-01-05 0500A");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9991852416");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "ENHANCED BUSINESS SERVICES");
		Browser_GUI.MainPage.Tree_value(driver, "DSL -- LINE SHARING ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER WITH PHONE OPTION - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_10(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991172308");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_for_a_Reach_Number$());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCINDIPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 08-01-04 0255A");
		Browser_GUI.MainPage.Tree_value(driver, "ACCESS AFTER 0200P");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "HANDLE SMLOS");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER WITH PHONE OPTION - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_11(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002358");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "ACCESS AFTER 0200P");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "HANDLE SMLOS");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9996002358");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_12(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002352");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9996002352"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-11-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0600P");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT A");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG CALL WAITING");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 08-01-04 0255A");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 07-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "TEST TKT FOR APRO TEAM");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9996002352");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_14(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991162352");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCILLIPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LSH LB");
		Browser_GUI.MainPage.Tree_value(driver, "OLD COMMITMENT 05-30-16 0818P");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CD");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS DT 10-31-04 0514A");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER CALLED 1");
		Browser_GUI.MainPage.Tree_value(driver, "HANDLE REFBO");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS PP");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE MISC");
		Browser_GUI.MainPage.Tree_value(driver, "PW/JACK CUST REQUESTS JACK/INSTLN/MOVE");
		Browser_GUI.MainPage.Tree_value(driver, "REACH NUMBER 9991162352");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DSL -- LINE SHARING ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "LINEBACKER WITH PHONE OPTION - RES/BUS");
		funs.Cancel_Ticket();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_15(){
	    try {
		Thread.sleep(1000);
	    funs.Enter_TN("9974002305");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_REP_Special_remarks_from_OSSLR$OSSCN_found$_ADD_CKT_NOTES_FOR_TAFI_TESTING$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		Browser_GUI.MainPage.AM2_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 CANCEL PER SUB REP GEN 1.5X256 QAY_VERNJR1@BELLSOUTH.NET IWP: NA; EMP: NA; CPE UNDER WARRNTY: NA; ((REPAIR))"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","XSUBOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

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
	public void KEYD_16(){
	    try {
		Thread.sleep(1000);
	    funs.Enter_TN("9974002306");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

//		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
//		CheckPoints.AM_REP_Special_remarks_from_OSSLR$OSSCN_found$_ADD_CKT_NOTES_FOR_TAFI_TESTING$());
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
//		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		Browser_GUI.MainPage.AM2_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CANCEL PER SUB REP GEN 1.5X256 QAY_VERNJR1@BELLSOUTH.NET IWP: NA; EMP: NA; CPE UNDER WARRNTY: NA; ((REPAIR))"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","XSUBOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

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
	public void KEYD_17(){
	    try {
		Thread.sleep(1000);
	    funs.Enter_TN("9986002550");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		Browser_GUI.MainPage.Tree_value(driver, "LOC APT 31");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_08_08_07_1000A_Available_for_Pickup$AP$_NDC_CO_Dispatch$POD$08_07_07_1129P_Dispatched_In_Pending_Load$HDCP$_NDC_CO_Dispatch$POD$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "TYPE NDT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void KEYD_18(){
	    try {
		Thread.sleep(1000);
	    funs.Enter_TN("9974002307");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void KEYD_19(){
	    try {
		Thread.sleep(1000);
	    funs.Enter_TN("9974002308");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9974002308"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_AccessAfter(driver), "value","0100P"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_AccessBefore(driver), "value","0800P"); 
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CAT CR");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

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
