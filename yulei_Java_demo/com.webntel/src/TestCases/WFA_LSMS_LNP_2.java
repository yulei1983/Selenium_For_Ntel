package TestCases;

import java.time.DayOfWeek;
import java.util.Calendar;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
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

public class WFA_LSMS_LNP_2 {
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
	public void LSMS_LNP_034_Pooled_Account_Request_a_trx_Lookup_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112333");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_the_customer$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMICHPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_035_N_Order_PENDING_DueFuture_NonFielded_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002329");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 		 
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
	public void LSMS_LNP_036_N_Order_CMP_DuePast_LineRecord_W(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002588");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR CANEVTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "COLLECT/3RD PTY BILL BLOCK");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FOLLOWUP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		
		funs.ClearNtel(driver);	
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_037_D_Order_CMP_DueToday_NonFielded_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002360");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();
	
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM D ORD DISC SERV ADVSE CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
        
		Browser_GUI.MainPage.Tree(driver, "PORTING INFORMATION").click();
		Thread.sleep(2000);
		functions.SwitchToFrame(driver, "class", "gwt-Frame");
		funs.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver)  , "LSMS_LNP_037" , "Check Porting Information");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Browser_GUI.MainPage.BTN_HOST(driver).click();
		Thread.sleep(2000);
		functions.SwitchToFrame(driver, "class", "gwt-Frame");
		funs.TableCheckPoint(Browser_GUI.MainPage.Webtable_Right_section_HOST(driver)  , "LSMS_LNP_037" , "Check Porting Information_HOST");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Browser_GUI.MainPage.BTN_VIEW(driver).click();

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 		 
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
	public void LSMS_LNP_038_D_Order_PAC_DueFuture_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998003102");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FOLLOWUP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
    
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void LSMS_LNP_039_D_Order_CMP_DuePast_NonFielded_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002361");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM D ORD DISC SERV ADVSE CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
    
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_040_No_RX_Screen_C_Order_PAC_DueFuture_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998003103");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		chooseBox.ChooseBoxBtn("No Dial Tone At Times").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE AT TIMES");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM NDTAT"); 
		chooseBox.ChooseBoxBtn("Some Phones (SP)").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Has_customer_checked_CPE_and$or_NID$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM NDTAT SP/AC"); 
		Browser_GUI.MainPage.Tree_value(driver, "SOME PHONES (SP)");
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Information_MSG_JTextPane(driver), "innerText",
		CheckPoints.Information_I_would_like_to_assist_you_in_determining());
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT CHECKED CPE AND/OR NID");
		Browser_GUI.MainPage.Information_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Willing_To_Check);
		chooseBox.ChooseBoxBtn("Willing to check").click();

		Browser_GUI.MainPage.Tree_value(driver, "WILLING TO CHECK");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM NDTAT SP/AC WL CK CPE-NID"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		chooseBox.ChooseBoxBtn("Call Tree").click();

		Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD POSS PORTING PRBLM NDTAT SP/AC WL CK CPE-NID CL TREE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS");	
		funs.Check_Commitment_CATS();
		Browser_GUI.MainPage.AM_OK(driver).click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD POSS PORTING PRBLM NDTAT SP/AC WL CK CPE-NID CL TREE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
    
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_041_N_Order_CAN_DueToday_Billing_Return_W(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002435");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
    
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_042_N_Order_PAC_DueFuture_C_Order_CMP_DuePast_SNE(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002362");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.AM_OK(driver).click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_043_D_Order_Pending_DueFuture_No_Line_record_NonFielded_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002363");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Data").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.AM2_No(driver).click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_044_T_Order_CMP_DueToday_F_Order_CMP_DuePast_W(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002591");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR CANEVTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Thread.sleep(2000);
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
		CheckPoints.Data_Input_Input_description_of_the_trouble_the_customer_is_having$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("NO TROUBLE");
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM NO TROUBLE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_045_C_Order_CMP_DueToday_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998002439");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		chooseBox.ChooseBoxBtn("Data").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();
	
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCTEXAPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "INLINE MAINTENANCE PLAN - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

//		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
//		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_046_RX_Screen_Not_valid_SPID_State_California_Not_agree_W(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996012301");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);	
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll(); 
	}
	
	@Test
	public void LSMS_LNP_047_RX_Screen_LSMS_SPID_LRN_Lsms_Spid_NO_Billing_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9997001411");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$NV_CS$$$858_503_6452$$$800_288_2020());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll(); 
	}
	
	@Test
	public void LSMS_LNP_048_No_LSMS_No_NPANXX_No_CLEC_Referral_Found_NPA(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998028001");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_ATT_at_1_800_288_4727());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_ATT_at_1_800_288_4727());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO CLEC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_049_No_LSMS_No_NPANXX_No_CLEC_Referral_Found_NPA(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9994024001");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 

		Browser_GUI.MainPage.AM_OK(driver).click();
		
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		Browser_GUI.MainPage.Backup(driver).click();
		Thread.sleep(2000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO LSP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_050_Address_Not_Found_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112401");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
		CheckPoints.Data_Input_Input_the_correct_address$());
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("12 MAIN ST");
		Browser_GUI.MainPage.DataInput2_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Select_Service_Address_JTextPane(driver), "innerText",
		CheckPoints.SSA_Please_select_the_LFACS_address_that_matches_the_address_the_customer_provided());
		Browser_GUI.MainPage.select_Service_Address_Option(driver, "Address Not Found").click();
		Browser_GUI.MainPage.Select_Service_Address_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_address_mis_match_caused_by_a_Service_Order$());
		Browser_GUI.MainPage.AM2_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_a_third_party_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_customer_contact_us$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","3PR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","3 PTY"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","3 PTY"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","3PR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMICHPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS NOT CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "12 MAIN ST");
		Browser_GUI.MainPage.Tree_value(driver, "LFACS AND CUSTOMER PROVIDED ADDRESSES DO NOT MATCH.");
		Browser_GUI.MainPage.Tree_value(driver, "ADDRESS MISMATCH NOT CAUSED BY SERVICE ORDER.");
		Browser_GUI.MainPage.Tree_value(driver, "THIRD PARTY");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_051_N_Order_CMP_DueToday_NoLineRecord_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002365");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);	
		chooseBox.ChooseBoxBtn("Data").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_052_D_Order_CAN_DuePast_Resaleusoc_in_S24_NonFielded_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9997001412");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_ALLEGIANCE_TELECOM_INC$_at_800_553_1989());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR CANEVTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$NV_CS$$$858_503_6452$$$800_288_2020());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_053_D_Order_DEL_DueFuture_Billing_Return_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998002435");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_NII_COMMUNICATIONS_LTD$_at_800_897_2448());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$TX_CS$$$800_499_7928$$$800_288_2020());
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCTEXAPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_054_T_Order_CMP_DueToday_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202420");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$OH_CS$$$800_207_3081$$$800_288_2020());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_055_CC_Order_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202491");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Input_description_of_the_trouble_the_customer_is_having$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("NO TROUBLE");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_MaskEdit(driver), "value","NO TROUBLE"); 
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM NO TROUBLE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_056_N_Order_CMP_D_Order_CAN_Duedate_N_after_D_NonFielded_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202422");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "900_976 RESTRICTED ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);	
		chooseBox.ChooseBoxBtn("Data").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_057_N_D_Order_Due_date_N_is_equal_D_CMP_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202497");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "900_976 RESTRICTED ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);	
		chooseBox.ChooseBoxBtn("Data").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_058_Change_localtime_N_Order_CMP_D_Order_CAN_DueFutureandDuedate_NisafterD_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9973012694");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$MO_EB$$$800_499_7928$$$800_499_7928());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_059_N_Order_PAC_DueToday_D_Order_CMP_DuePast_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202499");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_060_N_Order_PAC_DueFuture_D_Order_CMP_DuePast_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202418");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_061_N_Order_PAC_DueFuture_D_Order_CMP_DuePast_W(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9997001352");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR CANEVTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$NV_CS$$$858_503_6452$$$800_288_2020());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_062_N_Order_PAC_DueFuture_D_Order_CAN_DuePast_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9973012588");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		String ExpOfferedCommit = funs.get_commitment_time();
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Input_description_of_the_trouble_the_customer_is_having$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","LNPC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("QA");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_MaskEdit(driver), "value","QA"); 
    	funs.set_commitment_with_Commit_CalendarType(Calendar.DAY_OF_YEAR , -1);
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM QA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","LNPC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY");
		
		String ExpCurrentCommit = funs.get_commitment_time();                                                                                                             
		String ExpIssueDispatch= funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived = funs.get_localtime_maingui();
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		
		WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
		try {	
		 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
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
         funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_Offered_Commit_DT(AdminGuiDriver), "value", ExpOfferedCommit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
         funs.CheckPorpertyDate(AdminGui.EMS_Issues_Log_Detail.WebEdit_Current_Commit_DT(AdminGuiDriver), "value", ExpCurrentCommit, "MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,0);

		 AdminGui.EMS_Issues_Log_Detail.Btn_Back(AdminGuiDriver).click();
		 functions.GoBackWindow(AdminGuiDriver, OldOneHandle);
		 AdminGuiDriver.close();
		} catch (Exception e) {
			AdminGuiDriver.close();
		}

		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll(); 
	}
	
	@Test
	public void LSMS_LNP_063_N_Order_CAN_DueToday_D_Order_CAN_DuePast_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998003109");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Input_description_of_the_trouble_the_customer_is_having$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("QA");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_MaskEdit(driver), "value","QA"); 
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM QA"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("8888888888");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_064_N_Order_PAC_DueToday_C_Order_CMP_DuePast_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998003110");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SWBTTSTPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Advise_the_customer_of_the_Service_Order_due_date$and_if_necessary_refer_to_Business_Office$());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT N ORD PEND REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	public void LSMS_LNP_065_Change_localtime_N_Order_PAC_DuePast_C_Order_CMP_DuePast_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002367");
	    Thread.sleep(3000);

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Refer_customer_to_Business_Office$$$NC_CS$$$NONE$$$NONE());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
        funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
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
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
