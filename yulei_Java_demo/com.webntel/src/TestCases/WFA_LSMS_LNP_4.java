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

public class WFA_LSMS_LNP_4 {
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
	public void LSMS_LNP_067_C_N_Order_CMP_Duedate_DuePast_DSL_SNET(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9997001413");
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
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR CANEVTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DSL -- LINE SHARING ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "COLLECT/3RD PTY BILL BLOCK");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_The_account_record_indicates_this_line_has_DSL$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DSL);	
		chooseBox.ChooseBoxBtn("Customer reporting Voice only trouble").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REPORTING VOICE ONLY TROUBLE");
		chooseBox.ChooseBoxBtn("Data").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void LSMS_LNP_069_C_D_Order_D_DueToday_C_Jstat_CMP_MW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991202492");
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
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCMWTSTPOT");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "MULTIPLE ORDERS");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM D ORD DISC SERV ADVSE CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void LSMS_LNP_070_C_Order_CMP_DuePast_D_Order_PAC_DueFuture_SW(){
	    try {	
		Thread.sleep(2000);
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998003108");
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

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DSL -- LINE SHARING ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM"); 
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_The_account_record_indicates_this_line_has_DSL$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DSL);	
		chooseBox.ChooseBoxBtn("Customer reporting Voice only trouble").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REPORTING VOICE ONLY TROUBLE");
		chooseBox.ChooseBoxBtn("Data").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DATA);
		Browser_GUI.MainPage.Tree_value(driver, "DATA");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		chooseBox.ChooseBoxBtn("Can't Send").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T SEND");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$());
		Browser_GUI.MainPage.AM2_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD POSS PORTING PRBLM CNT SND ISP DLG ERROR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","CUST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","DATA"); 
		
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-SUE");
		
		Browser_GUI.MainPage.BTN_Submit(driver).click();	 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		
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
