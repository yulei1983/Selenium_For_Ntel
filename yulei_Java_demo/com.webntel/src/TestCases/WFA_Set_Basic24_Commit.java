package TestCases;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Function_Libary.WebDriver_Setup;
import Function_Libary.functions;
import Object_Repository.AdminGui;
import Object_Repository.Browser_GUI;
import Object_Repository.CheckPoints;
import Object_Repository.ChooseBox;
import Object_Repository.QTP_CheckList;
import Object_Repository.WebTable;

public class WFA_Set_Basic24_Commit {
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
	public void Basic24_01(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002323");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("No Dial Tone").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Is_that_line_currently_in_use$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: OPEN OUT BALANCED");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: DISPATCH OUT");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT AP/AC TEST:OPN OUT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Does_customer_want_their_calls_temporarily_forwarded$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_If_the_problem_is_in_your_premise_you_may_be());
		Browser_GUI.MainPage.AM_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT AP/AC TEST:OPN OUT NID CHK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_If_after_this_report_has_been_entered$$$technician_visit());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Customer_wants_Tech$$$each_add$l_15_minutes$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Will_customer_accept_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT AP/AC TEST:OPN OUT NID CHK REFSD TMQ"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_List_in_narr_name_of_person_declining_TMQ$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Does_the_customer_demand_a_dispatch$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "DOES NOT WANT CALLS TEMPORARILY FORWARDED");
		Browser_GUI.MainPage.Tree_value(driver, "DO NOT NEED INSTRUCTIONS ON LOCATING THE INTERFACE.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER WILL NOT ACCEPT CHARGES");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST COMPLEX 1 NDT AP/AC TEST:OPN OUT NID CHK REFSD TMQ"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
	public void Basic24_02(){
	    try {	
	    funs.Enter_TN("9984002344");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_03(){
	    try {	
		    funs.Enter_TN("9977002346");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
		 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
			}	
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_04(){
	    try {	
		    funs.Enter_TN("9977002347");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Service_Order_Activity_is_present$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
		     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
		 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
			}	
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_05(){
	    try {	
		    funs.Enter_TN("9984002345");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Service_Order_Activity_is_present$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
		     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
		 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
			}	
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_06(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002322");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CTX"); 
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SNET_CTX);
		funs.ClearNtel(driver);
	   }
    catch (Exception e) {
		funs.ClearNtel(driver);
		 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
       }
       functions.softassert.assertAll();  	   
	}
	
	@Test
	public void Basic24_07(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002326");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CTX"); 
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SNET_CTX);
		funs.ClearNtel(driver);
	   }
    catch (Exception e) {
		funs.ClearNtel(driver);
		 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
       }
       functions.softassert.assertAll();  	   
	}

	@Test
	public void Basic24_08(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002602");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		functions.SwitchToFrame(driver ,"class","gwt-Frame");
		funs.CheckPorperty(Browser_GUI.MainPage.information_Title(driver), "innerText","Service Order Status");
		driver.switchTo().defaultContent();
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	
	     
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Customer_has_both_a_transfer_of_service_To_$T$_order_and_a_transfer_of_service_From_$F$_order$());
			Browser_GUI.MainPage.AM_Yes(driver).click();
		
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Ord_is_Due_Today_PAC_and_tests_OPEN_IN$$$using_the_tree_form_list$());
			Browser_GUI.MainPage.AM_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
			Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE") .click();
			Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
			Browser_GUI.MainPage.TreeForm_OK(driver).click();			

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "TEST OPEN IN");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD TST: OPEN IN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FRAME"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
	public void Basic24_09(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002603");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_10(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002327");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_11(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9977002349");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LSH");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DSL -- LINE SHARING ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_The_account_record_indicates_this_line_has_DSL$());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();
		
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DSL);
			chooseBox.ChooseBoxBtn("Customer reporting Voice only trouble").click();
			
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REPORTING VOICE ONLY TROUBLE");
		    funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_12(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002321");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_13(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002346");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LSH");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
		    
	        funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_14(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9977002350");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_15(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002347");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
	     
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void Basic24_16(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9977002348");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void Basic24_18(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002348");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE") .click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();			

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_red_value(driver, "CABLE FAILURE");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0422A");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");

		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ASSOCIATE WITH CABLE FAILURE BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CABFAIL"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
		funs.SwitchToFrame(driver, "class", "gwt-Frame");
		String Exp_OS_OfferedCommit=Browser_GUI.MainPage.OS_Commitment(driver).getText();
		driver.switchTo().defaultContent();
		String ExpCurrentCommit = funs.get_commitment_time();
		String ExpIssueDispatch = funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived =funs.get_localtime_maingui();

		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();	
		
		WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
		 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
//		 int TnsRow = EmsLogTable.getRowWithTN("9973012689");
		 EmsLogTable.getRow(2).click();
		 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
		 functions funs = new functions(AdminGuiDriver);
		 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
		 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","FAILURE"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB842A48"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9984002348"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","TN"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","G5004*PARKER COVERT"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112300"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Business"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0005"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "C" + functions.EMS_Log_TZ()); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebCheckBox_AOD_Callback_Suppress_Ind(AdminGuiDriver), "value", "0"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Comments(AdminGuiDriver), "value"," "); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_System(AdminGuiDriver), "value","NTEL"); 
        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Dispatch_DT(AdminGuiDriver), "value", ExpIssueDispatch,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Submit_DT(AdminGuiDriver), "value", ExpIssueSubmit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Received_DT(AdminGuiDriver), "value", ExpWFACReceived,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Offered_Commit_DT(AdminGuiDriver), "value", Exp_OS_OfferedCommit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_Current_Commit_DT(AdminGuiDriver), "value", ExpCurrentCommit, "MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,0);

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
	public void Basic24_19(){
	    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9984002348");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
			CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
			Browser_GUI.MainPage.TreeForm_expandNode(driver, "PHYSICAL") .click();
			Browser_GUI.MainPage.TreeForm_Option(driver, "PHYSICAL", 1).click();
			Browser_GUI.MainPage.TreeForm_OK(driver).click();			

			Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
			Browser_GUI.MainPage.Tree_red_value(driver, "CABLE FAILURE");
			Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-01-05");
			Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0422A");
			Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");

			Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
			Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
			Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
			Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
			Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ASSOCIATE WITH CABLE FAILURE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CABFAIL"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 
			Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
			Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
	public void Basic24_20(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002348");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "NOT RELATED TO CABLE FAILURE");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("No Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_that_line_currently_in_use$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Customer requests a Dispatch").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK REQ DISP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDB"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Our_test_indicates_there_may_be_trouble_on$$$_there_is_a_charge_of_$30());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Will_customer_accept_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
        funs.Set_Action("CUST");
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Instruction_JTextPane(driver), "innerText",
		CheckPoints.Instruction_List_in_narr$$$Access_code_if_applicable());
		Browser_GUI.MainPage.Instruction_OK(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_red_value(driver, "CABLE FAILURE");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-01-05");
		Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0422A");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REQUESTS A DISPATCH");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		
		Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
		funs.SwitchToFrame(driver, "class", "gwt-Frame");
		String Exp_OS_OfferedCommit=Browser_GUI.MainPage.OS_Commitment(driver).getText();
		driver.switchTo().defaultContent();
		
        funs.CheckPorpertyDate(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value", Exp_OS_OfferedCommit , "MM-dd-yy hhmma" , "MM-dd-yy hhmma" ,0);

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK REQ DISP TMQ BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("0000000000"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
	public void Basic24_21(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002349");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
		
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
					funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
					Browser_GUI.MainPage.AM_OK(driver).click();
		
			   funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
							CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$());
							funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
							funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
							Browser_GUI.MainPage.Ask_Yes(driver).click();
					
							funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
							Browser_GUI.MainPage.TreeForm_expandNode(driver, "CAN'T BE CALLED") .click();
							Browser_GUI.MainPage.TreeForm_Option(driver, "CAN'T BE CALLED", 1).click();
							Browser_GUI.MainPage.TreeForm_OK(driver).click();	
					
							Browser_GUI.MainPage.Tree_red_value(driver, "CABLE FAILURE");
							Browser_GUI.MainPage.Tree_value(driver, "RESTORAL DATE 08-01-05");
							Browser_GUI.MainPage.Tree_value(driver, "RESTORAL TIME 0422A");
							Browser_GUI.MainPage.Tree_value(driver, "GRP ID A001E");
							Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
							Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
							Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
							Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
							Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
							Browser_GUI.MainPage.Tree_value(driver, "EQUIPMENT MAINTENANCE PLAN");
							Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
							
							funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ASSOCIATE WITH CABLE FAILURE"); 
							funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CABFAIL"); 
							funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
							Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
							Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
							
							Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
							funs.SwitchToFrame(driver, "class", "gwt-Frame");
							String Exp_OS_OfferedCommit=Browser_GUI.MainPage.OS_Commitment(driver).getText();
							driver.switchTo().defaultContent();
							String ExpCurrentCommit = funs.get_commitment_time();
							String ExpIssueDispatch = funs.get_localtime_maingui();
							String ExpIssueSubmit = funs.get_localtime_maingui();
							String ExpWFACReceived =funs.get_localtime_maingui();
							
							Browser_GUI.MainPage.BTN_Submit(driver).click(); 
							funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
							Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
							 
							Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
							funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
							Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();	
							
							WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
							 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
//							 int TnsRow = EmsLogTable.getRowWithTN("9973012689");
							 EmsLogTable.getRow(2).click();
							 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
							 functions funs = new functions(AdminGuiDriver);
							 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
							 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","FAILURE"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB842A49"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9984002349"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","TN"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","G5004*PARKER COVERT"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112300"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Business"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0005"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "C" + functions.EMS_Log_TZ()); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebCheckBox_AOD_Callback_Suppress_Ind(AdminGuiDriver), "value", "0"); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Comments(AdminGuiDriver), "value"," "); 
							 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_System(AdminGuiDriver), "value","NTEL"); 
					        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Dispatch_DT(AdminGuiDriver), "value", ExpIssueDispatch,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
					        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_EMSIssue_Submit_DT(AdminGuiDriver), "value", ExpIssueSubmit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
					        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Received_DT(AdminGuiDriver), "value", ExpWFACReceived,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
					        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Offered_Commit_DT(AdminGuiDriver), "value", Exp_OS_OfferedCommit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
					        funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_Current_Commit_DT(AdminGuiDriver), "value", ExpCurrentCommit, "MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,0);

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
	public void Basic24_22(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9985002325");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_CO_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Central_Office_Failure$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "RELATED TO COF");
		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE") .click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();

		Browser_GUI.MainPage.Tree_red_value(driver, "COFAIL");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ASSOCIATE WITH CO FAILURE BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","COFAIL"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_23(){
	    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9985002325");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
			Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
			CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_CO_Failure$());
			funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
			Browser_GUI.MainPage.AM_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Is_the_trouble_reported_related_to_the_Central_Office_Failure$());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			Browser_GUI.MainPage.Tree_value(driver, "RELATED TO COF");
			funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
			Browser_GUI.MainPage.TreeForm_expandNode(driver, "TRANSMISSION") .click();
			Browser_GUI.MainPage.TreeForm_Option(driver, "TRANSMISSION", 1).click();
			Browser_GUI.MainPage.TreeForm_OK(driver).click();

			Browser_GUI.MainPage.Tree_red_value(driver, "COFAIL");
			Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
			Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
			Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
			Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
			Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ASSOCIATE WITH CO FAILURE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","COFAIL"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","TRAN"); 
			Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
			Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_35(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9975002350");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Voice Mail").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD VMS NT PAYING 4"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","VMS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_The_customer_is_not_paying_for_the_feature$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_VMS);
		chooseBox.ChooseBoxBtn("Report VMS Trouble").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Check_for_Voice_Mail_outage$_Is_this_number_part_of_a_Voice_Mail_outage$());
		Browser_GUI.MainPage.AM_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_No_Report_VMS_Trouble_SE);
		chooseBox.ChooseBoxBtn("Calls Go Directly Into Voice Mail").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD VMS NT PAYING 4 CLS GO DIRECT TO VMS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_customer_calling_from_that_line$());
		Browser_GUI.MainPage.AM_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.information_CLOSE(driver) , "innerText" , CheckPoints.information_CLOSE());
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CBC_DEACTIVATE_FW);
		chooseBox.ChooseBoxBtn("Trouble not resolved").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
//		String ExpOfferedCommit = funs.get_commitment_time();
		Browser_GUI.MainPage.Tree_value(driver, "LIU");
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_The_line_must_be_clear_in_order_to_complete_testing$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Our_test_indicates_there$$$$RES_or_Bus$$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Does_customer_agree_to_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_that_the_trouble_will_be_cleared_by$$$access_to_the_NID());
		Browser_GUI.MainPage.AM_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Test_is_needed$_Has_the_customer_hung_up$());
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD VMS NT PAYING 4 CLS GO DIRECT TO VMS AP/AC TMQ"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");		
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL");
		Browser_GUI.MainPage.Tree_value(driver, "NOT PAYING FOR");
		Browser_GUI.MainPage.Tree_value(driver, "REPORT VMS TROUBLE");
		Browser_GUI.MainPage.Tree_value(driver, "NO VOICE MAIL OUTAGE");
		Browser_GUI.MainPage.Tree_value(driver, "CALLS GO DIRECTLY INTO VOICE MAIL");
		Browser_GUI.MainPage.Tree_value(driver, "LIU");
		Browser_GUI.MainPage.Tree_value(driver, "ADVISED TO DEACTIVATE FORWARDING");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES TO CHARGES");
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("888888888888"); 
		Browser_GUI.MainPage.WebEdit_AccessNumber(driver).sendKeys("123456"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.AM_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_report_will_be_Queued_for_testing$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
//		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK_For_Queue(driver), "innerText",CheckPoints.Submit_TankYou_OK_For_Queue());
		Browser_GUI.MainPage.Submit_TankYou_OK_For_Queue(driver).click();

	    Thread.sleep(3000);
	    funs.Enter_TN("9975002350");
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Check_QVF_INFORMATION_to_verify_Ring_Cycle$_Is_it_correct$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
	    
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD VMS NT PAYING 4 CLS GO DIRECT TO VMS AP/AC TMQ TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","888888888888"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_AccessNumber(driver), "value","123456"); 
		
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("888888888888"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL");
		Browser_GUI.MainPage.Tree_value(driver, "NOT PAYING FOR");
		Browser_GUI.MainPage.Tree_value(driver, "REPORT VMS TROUBLE");
		Browser_GUI.MainPage.Tree_value(driver, "NO VOICE MAIL OUTAGE");
		Browser_GUI.MainPage.Tree_value(driver, "CALLS GO DIRECTLY INTO VOICE MAIL");
		Browser_GUI.MainPage.Tree_value(driver, "LIU");
		Browser_GUI.MainPage.Tree_value(driver, "ADVISED TO DEACTIVATE FORWARDING");
		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE NOT RESOLVED");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES TO CHARGES");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		
		String B24Commitment=funs.get_localtime_Cal_round_dt(24);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver), "value",B24Commitment); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD VMS NT PAYING 4 CLS GO DIRECT TO VMS AP/AC TMQ TEST:TOK RCYC WRG NEEDS FIXD BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","RCMAC"); 

		      String ExpCurrentCommit  =funs.get_commitment_time();
		      String ExpIssueDispatch= funs.get_localtime_maingui();
		      String ExpIssueSubmit = funs.get_localtime_maingui();
		      String ExpWFACReceived = funs.get_localtime_maingui();
		
				Browser_GUI.MainPage.BTN_Submit(driver).click(); 
				funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
				Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
				 
				Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
				funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
				Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		      
				WebDriver AdminGuiDriver = functions.Open_Expeditet_LOG();
				 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
//				 int TnsRow = EmsLogTable.getRowWithTN("9973012689");
				 EmsLogTable.getRow(2).click();
				 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
				 functions funs = new functions(AdminGuiDriver);
				 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);

				 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","BASIC24"); 
				 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
				 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB752A50"); 
				 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_TNCKTID(AdminGuiDriver), "value","9975002350"); 

				 AdminGui.Expedite_Reports_Log_Detail.Btn_Back(AdminGuiDriver).click();
				 functions.GoBackWindow(AdminGuiDriver, OldOneHandle);
				 AdminGuiDriver.close();
				 AdminGuiDriver.quit();
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void Basic24_37(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9975002350");
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","NDT"); 

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("Beeping On Line").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL NOT PROGRAMMED IN ERROR");
		Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_the_beeping_heard_on_all_phones$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Advise_customer_to_check_their_equipment$_Is_customer_willing_to_check_equipment$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WILLING TO CHECK CPE");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		chooseBox.ChooseBoxBtn("Call Tree").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","ICATS"); 
		String CATSCommitment = funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR , 4);
		CATSCommitment = new StringBuilder(CATSCommitment).replace(9, 14, "0818P").toString();
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value",CATSCommitment); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD BEEPING CL TREE BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_38(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9975002350");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Physical").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
		Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
		chooseBox.ChooseBoxBtn("Network Interface Device").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Network_Interface_Device);
		Browser_GUI.MainPage.Tree_value(driver, "NETWORK INTERFACE DEVICE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NID"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","PHYS"); 
		chooseBox.ChooseBoxBtn("Repair NID").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","PREMIS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NID REPAIR"); 
		Browser_GUI.MainPage.Tree_value(driver, "REPAIR NID");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Does_the_customer_have_Dial_Tone$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "OOS");
		String B24Commitment = funs.get_localtime_Cal_round_dt(24);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","PREMIS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value",B24Commitment); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NID REPAIR BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","NDT"); 
		
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_will_cancel_Expedite_Escalation_Request$_Are_you_sure_you_want_to_Cancel$());
		Browser_GUI.MainPage.AM_Yes(driver).click();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_39(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9975002350");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Physical").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
		Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
		chooseBox.ChooseBoxBtn("Damaged Outside Plant (Cable/Pole/Terminal)").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Damaged_Outside_Plant_$Cable$Pole$Terminal$);
		Browser_GUI.MainPage.Tree_value(driver, "DAMAGED OUTSIDE PLANT (CABLE/POLE/TERMINAL)");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","PHYS"); 
		chooseBox.ChooseBoxBtn("Cable Down/Low").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CABLE DOWN/LOW");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Ask_customer_if_they_are_out_of_service$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_Hazardous$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER IS OUT OF SERVICE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","PDF"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CA DOWN/LOW CAB DOWN/LOW-OOS"); 
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","HAZARD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CA DOWN/LOW CAB DOWN/LOW-OOS HAZARDOUS BASIC24"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER SAYS HAZARDOUS");
		String HAZARDCommitment = funs.get_localtime_Cal_round_dt(4);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value",HAZARDCommitment); 

		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_will_cancel_Expedite_Escalation_Request$_Are_you_sure_you_want_to_Cancel$());
		Browser_GUI.MainPage.AM_Yes(driver).click();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_40(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9975002350");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Physical").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
		Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","PHYS"); 
		chooseBox.ChooseBoxBtn("Damaged Outside Plant (Cable/Pole/Terminal)").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "DAMAGED OUTSIDE PLANT (CABLE/POLE/TERMINAL)");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Damaged_Outside_Plant_$Cable$Pole$Terminal$);
		chooseBox.ChooseBoxBtn("Cable Down/Low").click();

		Browser_GUI.MainPage.Tree_value(driver, "CABLE DOWN/LOW");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Ask_customer_if_they_are_out_of_service$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER NOT OUT OF SERVICE");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_IF_aware_other_customers);
		chooseBox.ChooseBoxBtn("Cable Down/Low").click();

		Browser_GUI.MainPage.Tree_value(driver, "NO/UNSURE IF OTHERS AFFECTED");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_IF_AT$T_CABLE);
		chooseBox.ChooseBoxBtn("Unsure").click();	

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_Hazardous$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "UNSURE");
		Browser_GUI.MainPage.Tree_value(driver, "YES/UNSURE IF AT&T CABLE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","PHYS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","REFNDC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CA DOWN/LOW ATT CABLE DOWN/LOW"); 
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver) , "value","PHYS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver) , "value","HAZARD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CA DOWN/LOW ATT CABLE DOWN/LOW HAZARDOUS"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER SAYS HAZARDOUS");
		String HAZARDCommitment = funs.get_localtime_Cal_round_dt(4);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value",HAZARDCommitment); 

		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_will_cancel_Expedite_Escalation_Request$_Are_you_sure_you_want_to_Cancel$());
		Browser_GUI.MainPage.AM_Yes(driver).click();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 

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
	public void Basic24_41(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002350");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}	

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);

		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	     	
	}
	
	@Test
	public void Basic24_42(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9984002353");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
	     if (funs.IsExist(By.xpath("//ui[text()='BASIC24 CUSTOMER']"))) {
	 		functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "SHOULD NOT DISPLAY"   , "DISPLAY"));
		}
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.ClearNtel(driver);
		driver.quit();
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
