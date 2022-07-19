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
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
