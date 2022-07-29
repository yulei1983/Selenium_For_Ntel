package TestCases;

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

public class WFA_LSMS_LNP_1 {
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
	public void LSMS_LNP_001_LRN_NPANXX_SNET(){
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
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",CheckPoints.Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT BILL-SE TT"); 
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_QVF_Failed$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT BILL-SE TT QVF FAILED"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CBDT BILL-SE TT QVF FAILED"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED IN");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "TROUBLE ON ALL PHONES");
		Browser_GUI.MainPage.Tree_value(driver, "QVF FAILED");
		Browser_GUI.MainPage.Tree_value(driver, "CORPORATION: UNKNOWN");

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 
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
	public void LSMS_LNP_002_LRN_CUSTOMER_AGREES_W(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002302");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_contact_TCG_TELEPORT_COMM$$$877_325_0445$$$TCG_Teleport_is_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FOLLOWUP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Backup(driver).click();
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO LSP-PORTED OUT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_AS(driver).isSelected()); 
//		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_BC(driver).isSelected()); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_003_NPANXX_Found_Customer_does_not_agree_W(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002409");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_QWEST_at_888_999_2656());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_a_third_party_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","FOLLOWUP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DENIED ACCOUNT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
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
	public void LSMS_LNP_004_No_NPANXX_Found_CLEC_Referral_Found_Agree(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998028001");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_ATT_at_1_800_288_4727());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
	    
		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_AS(driver).isSelected()); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO CLEC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_005_No_NPANXX_Found_CLEC_Referral_Found_Not_agree(){
	    try {	
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
		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_AS(driver).isSelected()); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
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
	public void LSMS_LNP_006_No_NPANXX_Found_CLEC_Referral_Found_Not_agree(){
	    try {	
		    Thread.sleep(2000);
	    funs.Enter_TN("9994024001");
	    Thread.sleep(3000);
	    
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
		
		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_AS(driver).isSelected()); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO LSP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void LSMS_LNP_007_No_NPANXX_Found_No_CLEC_Referral_Found_Not_agree(){
	    try {	
		    Thread.sleep(2000);
	    funs.Enter_TN("9994024002");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$());

		funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.Radio_AS(driver).isSelected()); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
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
	public void LSMS_LNP_008_Pooled_account_SNET(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002325");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_the_customer$() );
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "POOLED");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CORPORATION: UNKNOWN");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_009_No_SO_and_Billing_return_Pstat_present_W(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002372");
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

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		Browser_GUI.MainPage.Backup(driver).click();
	    Thread.sleep(1000);
		Browser_GUI.MainPage.Backup(driver).click();
	    Thread.sleep(1000);
		Browser_GUI.MainPage.Backup(driver).click();

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

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "NO DIAL TONE").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "NO DIAL TONE", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		String ExpOfferedCommit = funs.get_commitment_time();
		
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_Title(driver), "innerText","Data Input"); 
	    Thread.sleep(1000);
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("NO TROUBLE");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_MaskEdit(driver), "value","NO TROUBLE"); 
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM NO TROUBLE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","LNPC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
		
		funs.set_commitment_with_Commit_CalendarType(Calendar.DAY_OF_YEAR , -1);
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("888888888888"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-TY"); 
		
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
		
		//--------------------Checking Expeditet Log
		WebDriver AdminGuiDriver = functions.Open_Expeditet_LOG();
		 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
		 EmsLogTable.getRow(2).click();
		 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
		 functions funs = new functions(AdminGuiDriver);
		 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
		 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","NON DISPATCH"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","PE004C72"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_TNCKTID(AdminGuiDriver), "value","9996002372"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_State(AdminGuiDriver), "value","CN"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Account_Name(AdminGuiDriver), "value","G5004*PARKER COVERT"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-TY"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","8888888888"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Unknown"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0005"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "P" + functions.EMS_Log_TZ()); 
//		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebCheckBox_AOD_Callback_Suppress_Ind(AdminGuiDriver), "value", "0"); 
//		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Comments(AdminGuiDriver), "value"," "); 
		 funs.CheckPorperty(AdminGui.Expedite_Reports_Log_Detail.WebEdit_System(AdminGuiDriver), "value","NTEL"); 
//       funs.CheckPorpertyDate(AdminGui.Expedite_Reports_Log_Detail.WebEdit_EMSIssue_Dispatch_DT(AdminGuiDriver), "value", ExpIssueDispatch,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
       funs.CheckPorpertyDate(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Expedite_Report_Submit_DT(AdminGuiDriver), "value", ExpIssueSubmit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
       funs.CheckPorpertyDate(AdminGui.Expedite_Reports_Log_Detail.WebEdit_WFAC_Received_DT(AdminGuiDriver), "value", ExpWFACReceived,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
       funs.CheckPorpertyDate(AdminGui.Expedite_Reports_Log_Detail.WebEdit_WFAC_Offered_Commit_DT(AdminGuiDriver), "value", ExpOfferedCommit,"MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,15);
       funs.CheckPorpertyDate(AdminGui.Expedite_Reports_Log_Detail.WebEdit_Current_Commit_DT(AdminGuiDriver), "value", ExpCurrentCommit, "MM-dd-yy hhmma" , "MM/dd/yy hh:mma" ,0);

		 AdminGui.Expedite_Reports_Log_Detail.Btn_Back(AdminGuiDriver).click();
		 functions.GoBackWindow(AdminGuiDriver, OldOneHandle);
		 
		 try {
			 AdminGuiDriver.close();
		} catch (UnhandledAlertException e1) {
			AdminGuiDriver.close();
			funs.ClearNtel(driver);
		}
		 
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_010_No_SO_and_No_Billing_W(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002398");
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
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
				
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR SBCCANOPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG LB");
		Browser_GUI.MainPage.Tree_value(driver, "PORTED OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-LEO"); 

		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
//		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
//		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
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
	public void LSMS_LNP_011_WINBACK_account_SNET(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002326");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
				
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "WINBACK");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_012_WINDBACK_DIFF_CO_account_SNET(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9976002327");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value",""); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 
				
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "FLAG 1FR ZZZM ZZZM MSC=Y ADL RS RES");
		Browser_GUI.MainPage.Tree_value(driver, "WINBACK-DIFF CO");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_013_RX_Screen_Not_valid_SPID_State_California_Agree_W(){
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
		Browser_GUI.MainPage.Ask_Yes(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","RFRD TO LSP-PORTED OUT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void LSMS_LNP_014_RX_Screen_Not_valid_SPID_Local_Service_Provider_MW(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991172306");
	    Thread.sleep(3000);
		
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

		Browser_GUI.MainPage.Backup(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Instruction_JTextPane(driver), "innerText",
		CheckPoints.Instruction_Please_create_an_MR_ticket_with_the_following$$$From_ATT___Still_In_Switch$());
		Browser_GUI.MainPage.Instruction_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS POUT PRBLM CBC FROM ATT CUSTOMERS-STILL IN SWITCH?"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 

		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	

	public void LSMS_LNP_015_RX_Screen_LSMS_Present_Local_Service_Provider_SNET(){
//	    try {	
//		    Thread.sleep(2000);
//		 ChooseBox chooseBox;
//		 chooseBox = new ChooseBox(driver);
//	    funs.Enter_TN("9993332301");
//	    Thread.sleep(3000);
//		
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
//		CheckPoints.Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
//		Browser_GUI.MainPage.Ask_Yes(driver).click();
//	    
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
//		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
//		Browser_GUI.MainPage.Ask_No(driver).click();
//
//		Browser_GUI.MainPage.Backup(driver).click();
//		
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
//		CheckPoints.Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
//		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
//		Browser_GUI.MainPage.Ask_Yes(driver).click();
//		
//		funs.CheckPorperty(Browser_GUI.MainPage.Instruction_JTextPane(driver), "innerText",
//		CheckPoints.Instruction_Please_create_an_MR_ticket_with_the_following$$$From_ATT___Still_In_Switch$());
//		Browser_GUI.MainPage.Instruction_OK(driver).click();
//		
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS POUT PRBLM CBC FROM ATT CUSTOMERS-STILL IN SWITCH?"); 
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
//		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","0000000000"); 
//
//		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES");
//
//		funs.ClearNtel(driver);
//		   }
//	    catch (Exception e) {
//			funs.ClearNtel(driver);
//			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
//	       }
//           functions.softassert.assertAll();  	    	
	}

	@Test
	public void LSMS_LNP_016_RX_Screen_Do_not_agree_Billing_data_MW(){
	    try {	
		    Thread.sleep(2000);
	    funs.Enter_TN("9991122301");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Online_transfer_to_WI_CS_at_800_207_5098$_Educate_the_customer_at_800_288_2020_for_future_reporting$());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent",""); 
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
	public void LSMS_LNP_017_RX_Screen_Agree_Billing_data_W(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002344");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("No Dial Tone").click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Close with the Customer").click();

		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "CLOSE WITH THE CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("0000000000");
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
	public void LSMS_LNP_018_No_MR_report_RX_Screen_SO_Billing_ZBU(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9961002327");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Check_service_code$s$_to_determine_if_the_service_should_be_working$_Do_you_want_to_enter_a_MR_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Online_transfer_to_AR_CS_at_800_499_7928$_Educate_the_customer_at_800_288_2020_for_future_reporting$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("0000000000");
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
	public void LSMS_LNP_019_MR_report_RX_Screen_SO_Billing_ZBU_CS_SW(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9961002327");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Check_service_code$s$_to_determine_if_the_service_should_be_working$_Do_you_want_to_enter_a_MR_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
	    
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
		CheckPoints.Data_Input_Input_the_correct_address$());
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
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_a_third_party_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
	
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Online_transfer_to_AR_CS$$$800_499_7928$$$800_288_2020());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD RFRD BO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.AM_OK(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "NOT THIRD PARTY");
		Browser_GUI.MainPage.Tree_value(driver, "ADDRESS MISMATCH NOT CAUSED BY SERVICE ORDER.");
		Browser_GUI.MainPage.Tree_value(driver, "LFACS AND CUSTOMER PROVIDED ADDRESSES DO NOT MATCH.");
		Browser_GUI.MainPage.Tree_value(driver, "12 MAIN ST");
		Browser_GUI.MainPage.Tree_value(driver, "INLINE MAINTENANCE PLAN - RES/BUS");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD RFRD BO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("0000000000");
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
	public void LSMS_LNP_020_MR_report_RX_Screen_SO_Billing_ZBU_CS_SW(){
	    try {	
		    Thread.sleep(2000);
		 ChooseBox chooseBox;
		 chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9961002326");
	    Thread.sleep(3000);
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_trouble_requires_further_isolation$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		Browser_GUI.MainPage.Information_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "Hold").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "Hold", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
		CheckPoints.Data_Input_Please_enter_additional_information_needed_for_the_trouble_report$());
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("No information");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","IHOLD"); 
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NO INFORMATION"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","IHOLD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
		
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("888888888888");
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
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
