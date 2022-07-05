package TestCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
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

public class GUIs {
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
	public void afterMethod(){

	}
	
	@AfterClass
	public void AfterClass(){
//		driver.close();
	}
	
	
	@Test
	public void GUI_03_RUD_SW(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9998002612");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "TEST RESULTS/RECOMMENDATION").click();
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_DPG(driver),"outerText","DPG");
		Browser_GUI.MainPage.BTN_DPG(driver).click();
	    Thread.sleep(2000);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		funs.CheckPorpertyWithRegex(Browser_GUI.MainPage.Webtable_right_html_section(driver),"outerText","ISAAC[\\s\\S]*9998002612NO DATA FOUND");
        driver.switchTo().defaultContent();
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void GUI_04_RUD_W(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9996002540");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "TEST RESULTS/RECOMMENDATION").click();
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_DPG(driver),"outerText","DPG");
		Browser_GUI.MainPage.BTN_DPG(driver).click();
	    Thread.sleep(2000);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
//		funs.CheckPorpertyWithRegex(Browser_GUI.MainPage.Webtable_right_html_section(driver),"outerText","ISAAC INFORMATION[\\s\\S]*9996002540[\\s\\S]*");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_04_RUD_W","DPG Information Check");

        driver.switchTo().defaultContent();
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_10_Bill_Record_W(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9996002301");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "BILLING RECORD").click();
	    Thread.sleep(300);
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_BILL(driver),"outerText","BILL");
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_RECORD(driver),"outerText","RECORD");

	    Thread.sleep(2000);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_10_Bill_Record_W","Bill Information&Billed Features");
        driver.switchTo().defaultContent();
		Browser_GUI.MainPage.BTN_BILL(driver).click();
		
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_10_Bill_Record_W","Bill Information&Billed Features");
        driver.switchTo().defaultContent();
		Browser_GUI.MainPage.BTN_BILL(driver).click();
	    Thread.sleep(5000);
		funs.CheckPorperty(Browser_GUI.MainPage.BILL_JTextPane(driver), "innerText",
		CheckPoints.BILL_This_transaction_you_are_requesting$$$transaction_again$());
		Browser_GUI.MainPage.BILL_Yes(driver).click();
		
		Browser_GUI.MainPage.BTN_RECORD(driver).click();
        
		funs.CheckPorperty(Browser_GUI.MainPage.RECORD_JTextPane(driver), "innerText",
		CheckPoints.RECORD_This_transaction_you_are_requesting$$$transaction_again$());
		Browser_GUI.MainPage.RECORD_No(driver).click();

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_16_Service_Summary_Area(){
	    try {	
		Thread.sleep(300);
	    funs.Enter_TN("9991112457");
	    Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Tree(driver, "TEST RESULTS/RECOMMENDATION").click();
	    Thread.sleep(300);
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_LOOPCARE(driver),"outerText","LOOPCARE");
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_DPG(driver),"outerText","DPG");

		Browser_GUI.MainPage.Tree(driver, "HISTORY").click();
	    Thread.sleep(300);
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_OSSCHI(driver),"outerText","OSSCHI");
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_NOW(driver),"outerText","NOW");

		Browser_GUI.MainPage.Tree(driver, "BILLING RECORD").click();
	    Thread.sleep(300);
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_BILL(driver),"outerText","BILL");
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_RECORD(driver),"outerText","RECORD");
		
		Browser_GUI.MainPage.Tree(driver, "QVF INFORMATION").click();
	    Thread.sleep(300);
	    funs.IsNotExist(Browser_GUI.MainPage.BTN_BILL(driver));
	    funs.IsNotExist(Browser_GUI.MainPage.BTN_RECORD(driver));
		funs.CheckPorperty(Browser_GUI.MainPage.BTN_QVF(driver),"outerText","QVF");

		Browser_GUI.MainPage.BTN_QVF(driver).click();
	    Thread.sleep(300);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_16_Service_Summary_Area","QVFInfo_html");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_Right_section_FEATURE_COMPARISON_html(driver),"GUI_16_Service_Summary_Area","FEATURE COMPARISON_Info_html");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_Right_section_AIN_SMS_html(driver),"GUI_16_Service_Summary_Area","AIN SMS_Info_html");
        driver.switchTo().defaultContent();
		
		Browser_GUI.MainPage.BTN_HOST(driver).click();
	    Thread.sleep(300);
		funs.SwitchToFrame(driver, "class" , "gwt-Frame");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_16_Service_Summary_Area","QVFInfo");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_Right_section_FEATURE_COMPARISON(driver),"GUI_16_Service_Summary_Area","FEATURE COMPARISON_Info");
		functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_Right_section_AIN_SMS(driver),"GUI_16_Service_Summary_Area","AIN SMS_Info");
        driver.switchTo().defaultContent();

        if (funs.IsExist(Browser_GUI.MainPage.BTN_VIEW(driver))) {
        	Browser_GUI.MainPage.BTN_VIEW(driver).click();
		}

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_29_Queue_viewl_and_journal_TZ_display_not_match(){
	    try {	
		Thread.sleep(300);
		funs.ClearSP(driver);
		Browser_GUI.MainPage.BTN_ScreenPool(driver).click();
		Browser_GUI.SPPage.TN_TICKET(driver).sendKeys("9991122650");
		Browser_GUI.SPPage.GetTicket(driver).click();
		
		Browser_GUI.SPPage.Tree_value(driver, "TR# -All");
		Browser_GUI.SPPage.Tree_value(driver, "SUBSEQUENTS 00");
		Browser_GUI.SPPage.Tree_value(driver, "OUT OF SERVICE N");
		
		functions.Set_STATUS_COMMENTS(driver, "TEST");
		Browser_GUI.SPPage.SP_HOLD_TICKET(driver).click();

//	    Thread.sleep(3000);
	    Browser_GUI.SPPage.AM2_Yes(driver).click();
	    
	    Browser_GUI.SPPage.AM_OK(driver).click();

	    Browser_GUI.MainPage.BTN_Journal(driver).click();
	    
	    funs.CheckPorperty(Browser_GUI.MainPage.Tab_Screening_Journal(driver) , "outerText", "Screening Journal");
	    funs.CheckPorperty(Browser_GUI.MainPage.Tab_Expedite_Journal(driver) , "outerText", "Expedite Journal");
	    funs.CheckPorperty(Browser_GUI.MainPage.Tab_Hold_Journal(driver)  , "outerText", "Hold Journal");
	    funs.CheckPorperty(Browser_GUI.MainPage.Tab_Call_Journal(driver) , "outerText", "Call Journal");
	    funs.CheckPorperty(Browser_GUI.MainPage.Tab_EMS_Journal(driver) , "outerText", "EMS Journal");

	    Browser_GUI.MainPage.Tab_Screening_Journal(driver).click();
	    Thread.sleep(400);
	    int row = functions.GetDataRowByTN(Browser_GUI.MainPage.Table_Screening_Journal(driver), "9991122650", "DES");
	    functions.CheckCellData(Browser_GUI.MainPage.Table_Screening_Journal(driver) , row , 11 , "EASTERN");

	    Browser_GUI.MainPage.Tab_Hold_Journal(driver).click();

	    row = functions.GetDataRowByTN(Browser_GUI.MainPage.Table_Hold_Journal(driver), "9991122650", "DES");
	    functions.CheckCellData(Browser_GUI.MainPage.Table_Hold_Journal(driver) , row , 11 , "EASTERN");
	    
	    funs.ClearSP(driver);
		Thread.sleep(300);
		Browser_GUI.MainPage.BTN_Receipt(driver).click();
		funs.Enter_TN("9991122650");
		Thread.sleep(3000);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReportBy(driver), "value","COC-RON"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9999999999"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","TRAN"); 
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());

		Browser_GUI.MainPage.WebEdit_AccessNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_AccessNumber(driver).sendKeys("0000000000"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-xnb"); 
		Browser_GUI.MainPage.BTN_Queue(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_queue_JTextPane(driver), "innerText",
		CheckPoints.AM_Your_report_has_been_queued());
		
		Browser_GUI.MainPage.AM_OK_for_Queue(driver).click();
		
		String[] a = {"2" , "9991122650" , "^" , "^" , "READY" , "EASTERN"};
		functions.ChkInQView(driver, a , 2);

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_34_bim_info_in_Bill_MW(){
	    try {
			Thread.sleep(300);
			funs.Enter_TN("9991202408");
			Thread.sleep(3000);
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
			Browser_GUI.MainPage.Tree(driver, "BILLING RECORD").click();
			Thread.sleep(3000);
			
			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_34_bim_info_in_Bill_MW","Bill Record information");
	        driver.switchTo().defaultContent();
	        
	        Browser_GUI.MainPage.WebEdit_TN(driver).clear();
	        Browser_GUI.MainPage.WebEdit_TN(driver).sendKeys("9991202401");
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TN(driver), "value","9991202401"); 
	        Browser_GUI.MainPage.BTN_BILL(driver).click();
			Thread.sleep(3000);
			
			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_34_bim_info_in_Bill_MW","Bill information_9991202401");
	        driver.switchTo().defaultContent();

			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_36_BILL_inforamtion_not_back_again(){
	    try {
			Thread.sleep(300);
			funs.Enter_TN("9991112301");
			Thread.sleep(3000);
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
	        Browser_GUI.MainPage.Tree(driver, "BILLING RECORD").click();
			Thread.sleep(5000);
			
			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_36_BILL_inforamtion_not_back_again","Bill Record information");
	        driver.switchTo().defaultContent();
	        
	        Browser_GUI.MainPage.BTN_RECORD(driver).click();
			Thread.sleep(300);
			funs.CheckPorperty(Browser_GUI.MainPage.RECORD_JTextPane(driver), "innerText",
					CheckPoints.RECORD_This_transaction_you_are_requesting$$$transaction_again$());
			Browser_GUI.MainPage.RECORD_Yes(driver).click();
			Thread.sleep(5000);

			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_36_BILL_inforamtion_not_back_again","Bill Record information for 9991112301");
	        driver.switchTo().defaultContent();
	        
	        //step05
	        Browser_GUI.MainPage.BTN_BILL(driver).click();
			Thread.sleep(5000);

			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_36_BILL_inforamtion_not_back_again","BILL 9991112301");
	        driver.switchTo().defaultContent();
	        
	        //step06
	        Browser_GUI.MainPage.BTN_RECORD(driver).click();
			Thread.sleep(300);
			funs.CheckPorperty(Browser_GUI.MainPage.RECORD_JTextPane(driver), "innerText",
					CheckPoints.RECORD_This_transaction_you_are_requesting$$$transaction_again$());
			Browser_GUI.MainPage.RECORD_Yes(driver).click();
			Thread.sleep(3000);
			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_36_BILL_inforamtion_not_back_again","Bill Record information");
	        driver.switchTo().defaultContent();
	        
	        Browser_GUI.MainPage.BTN_BILL(driver).click();
			Thread.sleep(300);
			funs.CheckPorperty(Browser_GUI.MainPage.BILL_JTextPane(driver), "innerText",
					CheckPoints.BILL_This_transaction_you_are_requesting$$$transaction_again$());
			Browser_GUI.MainPage.BILL_Yes(driver).click();
			Thread.sleep(5000);
			funs.SwitchToFrame(driver, "class" , "gwt-Frame");
			functions.TableCheckPoint(Browser_GUI.MainPage.Webtable_right_html_section(driver),"GUI_36_BILL_inforamtion_not_back_again","BILL 9991112301");
	        driver.switchTo().defaultContent();

			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void GUI_45_City_and_State_in_Middle_Section_MW(){
	    try {
			Thread.sleep(300);
			funs.Enter_TN("9993012330");
			Thread.sleep(3000);
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
            Boolean yBoolean = false;
            yBoolean = funs.IsExist(By.xpath("//div[contains(@class , 'topCityLabel')]//label[text()='DUSTTOWN, IL']"));
			if (!yBoolean) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "DUSTTOWN, IL"   , "No Displayed"));
			}
			funs.Cancel_Ticket();
			funs.Enter_TN("9993012335");
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$());
		
            yBoolean = funs.IsExist(By.xpath("//div[contains(@class , 'topCityLabel')]//label[text()=' ']"));
			if (!yBoolean) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "DUSTTOWN, IL"   , "No Displayed"));
			}
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void EMS_084_CATS_ProcessD_NoProcess_Approved_UncheckBackdown_SW(){
	    try {
	    	ChooseBox chooseBox = new ChooseBox(driver);
			Thread.sleep(300);
			funs.Enter_TN("9973012647");
			Thread.sleep(3000);
			String ExpOfferedCommit = funs.get_commitment_time();

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
            Boolean yBoolean = false;
            yBoolean = funs.IsExist(By.xpath("//div[contains(@class , 'topNameLabel')]//label[text()='R*****(TU MICHAEL)']"));
			if (!yBoolean) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "R*****(TU MICHAEL)"   , "No Displayed"));
			}
            yBoolean = funs.IsExist(By.xpath("//div[contains(@class , 'topLocLabel')]//label[text()='1611 AV Q, HUNTSVILLE,']"));
			if (!yBoolean) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "1611 AV Q, HUNTSVILLE,"   , "No Displayed"));
			}
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Recent_History_within_past_30_days$());
			Browser_GUI.MainPage.AM2_No(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Is_customer$s_recent_History_related_to_the_trouble_being_reported_now());
			Browser_GUI.MainPage.AM2_Yes(driver).click();
			
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
			Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
		    Thread.sleep(1000);
		    funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
			chooseBox.ChooseBoxBtn("Physical").click();
		    
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
			chooseBox.ChooseBoxBtn("Premise Wire or Jack Trouble").click();

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","PW/JACK"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
			ExpOfferedCommit = funs.get_commitment_time();
			
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Premise_Wire_or_Jack_Trouble);
			chooseBox.ChooseBoxBtn("Premise Wire or Jack Trouble").click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Has_the_jack_ever_worked_with_the_telephone_number_being_reported$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Ask_customer_if_the_jack_is_damaged$());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Ask_customer_if_they_have_tried_another_jack_or_another_phone_in_the_jack$());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Ask_customer_if_they_are_willing_to_check_their_CPE$());
			Browser_GUI.MainPage.AM2_Yes(driver).click();
			
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT TRIED OTHER PHONE");
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
			chooseBox.ChooseBoxBtn("Call Tree").click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
			Browser_GUI.MainPage.AM_OK(driver).click();
			
			funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_MISSLR_ETKT_WRG(driver).isEnabled());
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA PW/JACK CL TREE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value", funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR, 4).substring(0, 9)  +"0818P" ); 

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Have_you_already_contacted_NDC_for$$$override_$ID_authorization_required$());
			Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
			Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9998002301");
			Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
			Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC - WMX");
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.DataInput_Title(driver), "innerText",
					CheckPoints.Data_Input_Title());
			Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("WM6535");
			Browser_GUI.MainPage.DataInput_OK(driver).click();
			
			funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_NDC_ID_request);
			chooseBox.ChooseBoxBtn("Approved").click();
			
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_TN_CKTID(driver), "outerText", "TN/CKTID:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_CALLBACK(driver), "outerText", "CALLBACK #:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_REASON_CODE(driver), "outerText", "REASON CODE:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_CONTACT_NAME(driver), "outerText", "CONTACT NAME:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_REQUESTED_COMMIT(driver), "outerText", "REQUESTED COMMIT:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_COMMENTS(driver), "outerText", "COMMENTS:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_SUPPRESS_AOD_CALLBACK(driver), "outerText", "SUPPRESS AOD CALLBACK:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_APPROVAL_INDICATOR(driver), "outerText", "APPROVAL INDICATOR:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_NDC_APPROVED_COMMIT(driver), "outerText", "NDC APPROVED COMMIT:");	
				funs.CheckPorperty(Browser_GUI.MainPage.EMS_OREF_NDC_APPROVAL_AGENT(driver), "outerText", "NDC APPROVAL AGENT:");	

				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_TN_CKTID(driver), "value", "9973012647");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_CALLBACK(driver), "value", "9998002301");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_REASON_CODE(driver), "value", "");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_CONTACT_NAME(driver), "value", "COC - WMX");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_REQUESTED_COMMIT(driver), "value", funs.get_commitment_time());	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_COMMENTS(driver), "value", "");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_SUPPRESS_AOD_CALLBACK(driver), "value", "N");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_APPROVAL_INDICATOR(driver), "value", "APPROVED");	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_NDC_APPROVED_COMMIT(driver), "value", funs.get_commitment_time());	
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_EMS_OREF_NDC_APPROVAL_AGENT(driver), "value", "WM6535");	

				funs.Set_REASON_CODE("WrongNumber");
				Browser_GUI.MainPage.WebEdit_EMS_OREF_COMMENTS(driver).sendKeys("TEST EMS");
				String ExpRequestedCommit = funs.datetime_calculation(funs.get_commitment_time(), Calendar.DAY_OF_YEAR , -1);
			    funs.set_REQUESTED_COMMIT(ExpRequestedCommit);
			    Browser_GUI.MainPage.EMS_OREF_OK(driver).click();
			    
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA PW/JACK CL TREE"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR, 4).substring(0, 9) +"0818P"); 

				Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
			    Thread.sleep(1000);
			    funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
			    
				funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
						CheckPoints.AM2_This_will_cancel_EMS_Escalatio());
				Browser_GUI.MainPage.AM2_Yes(driver).click();
				
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA PW/JACK CL TREE"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NHSE"); 
				funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR, 4).substring(0, 9) +"0818P"); 
				Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
				Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
				Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
				Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
				Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
				Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
				Browser_GUI.MainPage.Tree_value(driver, "PREMISE WIRE OR JACK TROUBLE");
				Browser_GUI.MainPage.Tree_value(driver, "JACK HAS WORKED UNDER THIS NUMBER");
				Browser_GUI.MainPage.Tree_value(driver, "JACK NOT DAMAGED");
				Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER HAS NOT TRIED OTHER PHONE");
				Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER WILL CHECK CPE");

				String ExpCurrentCommit  = funs.get_commitment_time();                                                                                                                  
				String ExpIssueDispatch= funs.get_localtime_maingui();
				String ExpIssueSubmit = funs.get_localtime_maingui();
				String ExpWFACReceived = funs.get_localtime_maingui();
				Browser_GUI.MainPage.BTN_Submit(driver).click(); 
				funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
				Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
				 
				Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
				funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
				Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
				
				WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
				 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
				 EmsLogTable.getRow(2).click();
				 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
				 functions funs = new functions(AdminGuiDriver);
				 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
				 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","CATS"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","PO206B47"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9973012647"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","MO"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","R*****(TU MICHAEL)"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC - WMX"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9998002301"); 
				 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
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
