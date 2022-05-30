package TestCases;

import java.util.Calendar;

import org.checkerframework.framework.qual.FromByteCode;
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

public class WFA_Set_Basic24_Commit_Personalization {
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
		funs.ClearNtel(driver);
	}
	
	@AfterClass
	public void AfterClass() throws Exception{
//		driver.close();
	}
	
	@Test
	public void Basic24_25(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("update __jt0015_mltvercode set `FINAL_ACTION`='' where `REGION`='SE' and `VERC`='LT'","mltvercode");
			funs.update_ntel_dbase("update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");

	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
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
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "NOT RELATED TO COF");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("Slow Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: LONG TEST-EXPECT DELAYED RESULTS");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: NEED FURTHER ISOLATION");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/AC TEST:LNG TEST-EXPCT DELAYED"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
				CheckPoints.AM_The_test_result_is_inconclusive$_The_line_will_be_retested$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_Yes(driver), "innerText",CheckPoints.AM_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_No(driver), "innerText",CheckPoints.AM_No());
		Browser_GUI.MainPage.AM2_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/AC TEST:LNG TEST-EXPCT DELAYED"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
				CheckPoints.AM_The_test_result_is_inconclusive$_The_line_will_be_retested$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_Yes(driver), "innerText",CheckPoints.AM_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_No(driver), "innerText",CheckPoints.AM_No());
		Browser_GUI.MainPage.AM2_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_This_trouble_requires_further_isolation$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.TreeForm_Title(driver), "innerText","TreeForm");
		Browser_GUI.MainPage.TreeForm_expandNode(driver, "Dispatch Out").click();
		Browser_GUI.MainPage.TreeForm_Option(driver, "Dispatch Out", 1).click();
		Browser_GUI.MainPage.TreeForm_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Please_enter_additional_information_needed_for_the_trouble_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDO"); 
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput2_MaskEdit(driver).sendKeys("PHONE WON'T WORK");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_MaskEdit(driver), "value","PHONE WON'T WORK"); 
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/AC TEST:LNG TEST-EXPCT DELAYED PHONE WON'T WORK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Customer_wants_Tech_to_come_to_$$$_add$l_15_minutes$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Does_customer_agree_to_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_red_value(driver, "COFAIL");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER AGREES TO CHARGES");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SDT AP/AC TEST:LNG TEST-EXPCT DELAYED PHONE WON'T WORK TMQ BASIC24"); 
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
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
		   }
	    catch (Exception e) {
			 funs.ClearNtel(driver);
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	

	@Test
	public void Basic24_26(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");

	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002328");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
				CheckPoints.AM_Line_not_involved_in_CABFAIL$_Preventative_Maintenance_activity_in_area());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CTX"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SNET_CTX);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone_CTX);
		chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CTX CBDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
				CheckPoints.Ask_Is_the_customer_calling_from_the_line$$$not_working$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();

		Browser_GUI.MainPage.Tree_red_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "CUTOVER");
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NEEDS A SHOE TEST");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CTX CBDT NDS SHOE TEST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		
		String Commitment = funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR, 1);
		Commitment = new StringBuilder(Commitment).replace(9, 14, " 1145A").toString();

	    Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
		functions.SwitchToFrame(driver, "class", "gwt-Frame");
		String Exp_OS_OfferedCommit = Browser_GUI.MainPage.OS_Commitment(driver).getText();
		driver.switchTo().defaultContent();
		
		String ExpOfferedCommit = Exp_OS_OfferedCommit;
		String ExpCurrentCommit = funs.get_commitment_time();
		String ExpIssueDispatch = funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived =funs.get_localtime_maingui();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
		 WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
		 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
		 EmsLogTable.getRow(2).click();
		 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
		 functions funs = new functions(AdminGuiDriver);
		 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
		 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","FAILURE"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB852A28"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9985002328"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","KY"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","LAVOIE,MARK"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112300"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
		 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void Basic24_27(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");

	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002320");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Can't Be Called").click();

		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BE CALLED");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_a_third_party_report$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "NOT THIRD PARTY");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CBC);
		chooseBox.ChooseBoxBtn("Recording On Line").click();

		Browser_GUI.MainPage.Tree_value(driver, "RECORDING ON LINE");
		funs.CheckPorperty(Browser_GUI.MainPage.Treelist_Title(driver), "innerText","TreeList");
		Browser_GUI.MainPage.Treelist_Option(driver , "Gets ROL/Intercept When Called").click();
		Browser_GUI.MainPage.Treelist_OK(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "GETS ROL/INTERCEPT WHEN CALLED");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","ROL BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CBC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value",""); 

	    Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
		functions.SwitchToFrame(driver, "class", "gwt-Frame");
		String Commit_OS = Browser_GUI.MainPage.OS_Commitment(driver).getText();
		driver.switchTo().defaultContent();
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver), "value",Commit_OS); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void Basic24_28(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002329");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Service_Order_Activity_is_present$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CTX"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SNET_CTX);
		chooseBox.ChooseBoxBtn("Can't Call Out").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CCO"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CCO_CTX);
		chooseBox.ChooseBoxBtn("Can't Break Dial Tone").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CTX CBDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_the_customer_calling_from_the_line$$$not_working$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T CALL OUT");
		Browser_GUI.MainPage.Tree_value(driver, "CAN'T BREAK DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "TOUCHTONE HEARD");

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD CTX CBDT NDS SHOE TEST"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","SCREEN"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		String Commit_OS = functions.get_CommitentWithTZ(driver, "OS");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , Commit_OS); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112300"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_29(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002330");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Physical").click();

		Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
		chooseBox.ChooseBoxBtn("Drop").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","DROP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 
		Browser_GUI.MainPage.Tree_value(driver, "DROP");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Drop);
		chooseBox.ChooseBoxBtn("Drop Down/Low").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","DROP DOWN/LOW"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","DROP"); 
		Browser_GUI.MainPage.Tree_value(driver, "DROP DOWN/LOW");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_Hazardous$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","HAZARD"); 
		Browser_GUI.MainPage.Tree_value(driver, "HAZARDOUS");
		String HAZARDCommitment = funs.get_localtime_Cal_round_dt(4);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , HAZARDCommitment); 

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Hazardous__give_4_hour_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_you_have_Dial_Tone$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "HAS DT");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","HAZARDOUS DROP DOWN/LOW NOT SVC AFF"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_If_this_is_hazardous$$$214_858_4504_Southwest$$$6AM_CT());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","HAZARDOUS DROP DOWN/LOW NOT SVC AFF"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","HAZARD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_30(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002320");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Physical").click();

		Browser_GUI.MainPage.Tree_value(driver, "PHYSICAL");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Physical);
		chooseBox.ChooseBoxBtn("Drop").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","DROP"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 
		Browser_GUI.MainPage.Tree_value(driver, "DROP");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Drop);
		chooseBox.ChooseBoxBtn("Drop Down/Low").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","DROP DOWN/LOW"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","DROP"); 
		Browser_GUI.MainPage.Tree_value(driver, "DROP DOWN/LOW");
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_this_Hazardous$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","PHYS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","HAZARD"); 
		Browser_GUI.MainPage.Tree_value(driver, "HAZARDOUS");
		String HAZARDCommitment = funs.get_localtime_Cal_round_dt(4);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , HAZARDCommitment); 

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Hazardous__give_4_hour_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_you_have_Dial_Tone$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "OOS");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","HAZARDOUS DROP DOWN/LOW NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_If_this_is_hazardous$$$214_858_4504_Southwest$$$6AM_CT());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","HAZARDOUS DROP DOWN/LOW NDT BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","HAZARD"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , HAZARDCommitment); 

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
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM2_This_will_cancel_EMS_Escalatio());
		Browser_GUI.MainPage.AM2_Yes(driver).click();
		
		       String ExpOfferedCommit = functions.get_CommitentWithTZ(driver, "OS");
		       String ExpCurrentCommit  = funs.get_commitment_time();
		       String ExpIssueDispatch= funs.get_localtime_maingui();
		       String ExpIssueSubmit = funs.get_localtime_maingui();
		       String ExpWFACReceived = funs.get_localtime_maingui();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9999999999"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","HAZARD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB852A20"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9985002320"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","KY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","LAVOIE,MARK"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9999999999"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_31(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002334");
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
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		chooseBox.ChooseBoxBtn("Beeping On Line").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD BEEPING"); 
		Browser_GUI.MainPage.Tree_value(driver, "BEEPING ON LINE");
		Browser_GUI.MainPage.Tree_value(driver, "DOES NOT SUBSCRIBE TO VOICE MAIL");
		Browser_GUI.MainPage.Tree_value(driver, "VOICE MAIL NOT PROGRAMMED IN ERROR");
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
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD BEEPING CL TREE"); 
		Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		String CATSCommitment= funs.get_localtime_Cal_dt(Calendar.DAY_OF_YEAR, 4).substring(0, 9)+"0818P";
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , CATSCommitment); 

		       String ExpOfferedCommit = functions.get_CommitentWithTZ(driver, "OS");
		       String ExpCurrentCommit  = funs.get_commitment_time();
		       String ExpIssueDispatch= funs.get_localtime_maingui();
		       String ExpIssueSubmit = funs.get_localtime_maingui();
		       String ExpWFACReceived = funs.get_localtime_maingui();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","CATS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB852A34"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9985002334"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","KY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","LAVOIE,MARK"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112301"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_32(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='00:02AM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9977002351");
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
		chooseBox.ChooseBoxBtn("Can't Call Out").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","CCO"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CCO);
		chooseBox.ChooseBoxBtn("All Numbers").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "ALL NUMBERS");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_you_have_Dial_Tone$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "DOES NOT HAVE DIAL TONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC NDT"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		chooseBox.ChooseBoxBtn("Only has one phone/ not all calls (OH1P/NOT AC)").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "ONLY HAS ONE PHONE/ NOT ALL CALLS (OH1P/NOT AC)");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC NDT OH1P/NOT AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_that_line_currently_in_use$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC NDT OH1P/NOT AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Customer requests a Dispatch").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC NDT OH1P/NOT AC TEST:TOK REQ DISP"); 
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER REQUESTS A DISPATCH");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDB"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Customer_wants_Tech_to_come_to_$$$_add$l_15_minutes$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Will_customer_accept_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Instruction_JTextPane(driver), "innerText",
		CheckPoints.Instruction_List_in_narr$$$Access_code_if_applicable());
		Browser_GUI.MainPage.Instruction_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD AC NDT OH1P/NOT AC TEST:TOK REQ DISP TMQ BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDB"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "BUSINESS SERVICE");

		String B24Commitment=funs.get_localtime_Cal_round_dt(24);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , B24Commitment); 

		       String ExpOfferedCommit = functions.get_CommitentWithTZ(driver, "OS");
		       String ExpCurrentCommit  = funs.get_commitment_time();
		       String ExpIssueDispatch= funs.get_localtime_maingui();
		       String ExpIssueSubmit = funs.get_localtime_maingui();
		       String ExpWFACReceived = funs.get_localtime_maingui();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","BASIC24"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB772A51"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9977002351"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","SC"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","G5004*PARKER COVERT"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112301"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Business"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_33(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002330");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER'S ADDRESS IS CORRECT.");
		Browser_GUI.MainPage.Tree_value(driver, "BASIC24 CUSTOMER");
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("No Dial Tone").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT"); 
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","NDT AP/AC TEST:BAD COT CU BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDB"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: COT CU BAD");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: DISPATCH IN-FRAME");

		String B24Commitment=funs.get_localtime_Cal_round_dt(24);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , B24Commitment); 
		String ExpOfferedCommit = functions.get_CommitentWithTZ(driver, "OS");
	    String ExpCurrentCommit  = funs.get_commitment_time();
		String ExpIssueDispatch= funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived = funs.get_localtime_maingui();

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","BASIC24"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB852A30"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9985002330"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","KY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","LAVOIE,MARK"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112301"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void Basic24_34(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002334");
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
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("No Dial Tone").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT"); 
		chooseBox.ChooseBoxBtn("All Phones/All Calls (AP/AC)").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Are_you_calling_from_that_number_now$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: TEST OK");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE: VERIFY OK WITH CUSTOMER ATTEMPT TO FEC");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT AP/AC TEST:TOK"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_Isolate_for_cpe);
		chooseBox.ChooseBoxBtn("Isolate for CPE Trouble").click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT AP/AC TEST:TOK NID CHK"); 
		Browser_GUI.MainPage.information_CLOSE(driver).click();
		Browser_GUI.MainPage.information_CLOSE(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Does_customer_agree_to_check_CPE$NID$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT AP/AC TEST:TOK NID CHK CUST AGREES TO CK CPE/NID"); 
		Browser_GUI.MainPage.Tree_value(driver, "AGREES TO CHECK CPE/NID");
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_CPE_Isolation_Cats);
		chooseBox.ChooseBoxBtn("Call Tree").click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CALL TREE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD NDT AP/AC TEST:TOK NID CHK CUST AGREES TO CK CPE/NID CL TREE"); 
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC (SF)");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "NO DIAL TONE");
		Browser_GUI.MainPage.Tree_value(driver, "ALL PHONES/ALL CALLS (AP/AC)");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "ISOLATE FOR CPE TROUBLE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD NDT AP/AC TEST:TOK NID CHK CUST AGREES TO CK CPE/NID CL TREE BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		String CATSCommitment=funs.get_localtime_Cal_dt(Calendar.DAY_OF_MONTH , 4).substring(0, 9).concat("0818P");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , CATSCommitment); 
		
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanTureIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Have_you_already_contacted_NDC_for$$$override_$ID_authorization_required$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		
		Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).click();
	    Thread.sleep(1000);
	    funs.CheckBooleanFalseIsPass(Browser_GUI.MainPage.CheckBox_BACKDOWN(driver).isSelected());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM2_This_will_cancel_EMS_Escalatio());
		Browser_GUI.MainPage.AM2_Yes(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","CRA SVC ORD NDT AP/AC TEST:TOK NID CHK CUST AGREES TO CK CPE/NID CL TREE BASIC24"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","ICATS"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

		CATSCommitment=funs.get_localtime_Cal_dt(Calendar.DAY_OF_MONTH , 4).substring(0, 9).concat("0818P");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , CATSCommitment); 
		
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
		
		String ExpOfferedCommit = functions.get_CommitentWithTZ(driver, "OS");
		String ExpIssueDispatch= funs.get_localtime_maingui();
		String ExpIssueSubmit = funs.get_localtime_maingui();
		String ExpWFACReceived = funs.get_localtime_maingui();
	    String ExpCurrentCommit  = funs.get_commitment_time();

		Browser_GUI.MainPage.BTN_Submit(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
		Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
		 
		Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
		funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
		Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		 funs.RollBackAll();
		 funs.ReloginNtel("jt0005");
		 
			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
			 EmsLogTable.getRow(2).click();
			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
			 functions funs = new functions(AdminGuiDriver);
			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
			 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Reason_Code(AdminGuiDriver), "value","CATS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Override_Type(AdminGuiDriver), "value","Reporting"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_WFAC_TR(AdminGuiDriver), "value","NB852A34"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_TN_CKTID(AdminGuiDriver), "value","9985002334"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_State(AdminGuiDriver), "value","KY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Name(AdminGuiDriver), "value","LAVOIE,MARK"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Contact_Name(AdminGuiDriver), "value","COC-JERRY"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Callback(AdminGuiDriver), "value","9991112301"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Cust_Type(AdminGuiDriver), "value","Consumer"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_NCSC_Center(AdminGuiDriver), "value","LAKEWOOD"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Acct_Type(AdminGuiDriver), "value","TN"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Orig_Grp(AdminGuiDriver), "value","NCS"); 
			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_Customer_Time_Zone(AdminGuiDriver), "value", "E" + functions.EMS_Log_TZ()); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	
	
	
	
	
	
	@Test
	public void Basic24_36(){
	    try {	
			funs.ReloginNtel("jt0015");
			funs.update_ntel_dbase("Update __jt0015_afterhours Set ONTIME='00:01AM',OFFTIME='11:59PM' Where BUSUNIT='BASIC24'","afterhours");
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.ClearNtel(driver);
	    funs.Enter_TN("9985002335");
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
		CheckPoints.Ask_Our_records_indicate_you_are_reporting_a_Coin_phone$_Are_you_the_owner_or_vendor$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_MW_COIN);
		chooseBox.ChooseBoxBtn("Dial Tone").click();

		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_DialTone_COIN);
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		chooseBox.ChooseBoxBtn("No Dial Tone").click();

		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","SVC ORD NDT AP/AC"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Is_that_line_currently_in_use$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "NID LOCATION");
		Browser_GUI.MainPage.Tree_value(driver, "EXK OVERRIDE USED TO TEST THIS NUMBER");
		Browser_GUI.MainPage.Tree_value(driver, "LINE NOT IN USE");
		Browser_GUI.MainPage.Tree_value(driver, "MLT/LOOPCARE:CROSS");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST : CROSS TO WKG PR"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDO"); 

		funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Ask_the_customer_where_the_NID_is_located$_Input_location_of_NID$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDO"); 
		Browser_GUI.MainPage.DataInput_MaskEdit(driver).clear();
		Browser_GUI.MainPage.DataInput_MaskEdit(driver).sendKeys("DON'T KNOW");
		funs.CheckPorperty(Browser_GUI.MainPage.DataInput_MaskEdit(driver), "value","DON'T KNOW"); 
		Browser_GUI.MainPage.DataInput_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Does_NID_location_require_access_arrangements$());
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST : CROSS TO WKG PR DON'T KNOW"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_No(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_Customer_wants_Tech_to_come_to_$$$_add$l_15_minutes$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM_OK(driver), "innerText",CheckPoints.AM_OK());
		Browser_GUI.MainPage.AM_OK(driver).click();
		
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Will_customer_accept_charges$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		Browser_GUI.MainPage.Ask_Yes(driver).click();
		
		Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER WILL ACCEPT CHARGES");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST : CROSS TO WKG PR DON'T KNOW TMQ"); 
		funs.CheckPorperty(Browser_GUI.MainPage.Instruction_JTextPane(driver), "innerText",
		CheckPoints.Instruction_List_in_narr$$$Access_code_if_applicable());
		Browser_GUI.MainPage.Instruction_OK(driver).click();

		Browser_GUI.MainPage.Tree_value(driver, "WFA CTR ATTSENFPOTS");
		Browser_GUI.MainPage.Tree_value(driver, "ACCOUNT STATUS:IN EFFECT");
		Browser_GUI.MainPage.Tree_value(driver, "STATUS WKG");
		Browser_GUI.MainPage.Tree_value(driver, "LOC SUIT 101");
		Browser_GUI.MainPage.Tree_value(driver, "CONSUMER SERVICE");
		Browser_GUI.MainPage.Tree_value(driver, "PAY PHONE");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","TEST : CROSS TO WKG PR DON'T KNOW TMQ"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","PDO"); 
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
		String Commit_OS = functions.get_CommitentWithTZ(driver, "OS");
		funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Commitment(driver) , "value" , Commit_OS); 

		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReachNumber(driver).sendKeys("9991112301"); 
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).clear();
		Browser_GUI.MainPage.WebEdit_ReportBy(driver).sendKeys("COC-JERRY"); 
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
			 funs.RollBackAll();
			 funs.ReloginNtel("jt0005");
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
