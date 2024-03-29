package testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.internal.seleniumemulation.Highlight;
//import org.openqa.selenium.internal.seleniumemulation.SeleneseCommand;
//import org.openqa.selenium.internal.seleniumemulation.WaitForPopup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.jacob.com.LibraryLoader;
//import com.opera.core.systems.scope.protos.EcmascriptProtos.Runtime;
//import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

import autoitx4java.AutoItX;
import checkpoints.AppBChkPoint;
import objectRepository.AppElements;
import objectRepository.MatterMost;
import prepare.MMDriver;
import utils.DatabaseTables;
import utils.FileListTable;
import utils.FlowUnit;
import utils.ImgChecker;
import utils.Lib;
import utils.PropertiesDataProvider;
import utils.UCXUnit;
import utils.WebList;

public class APP_GUI {
	WebDriver driver = null;
	int WaitTime = 0;
	String currentWindow = "";//主页面
	AutoItX AutoWin = null;
	String downloadpath = "";
	String UploadFilePath = "";
	String UserName = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderUserName");  
	String Password = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderPassword");
	String declaringClassNameReg = "testcases";

	@BeforeClass
	public void beforeClass() {
		//初始化windows COM插件
		String jacobDllVersionToUse = PropertiesDataProvider.getTestData("config/config.properties", "AutoXDll");
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		this.AutoWin = new AutoItX();
		//初始化webdriver及测试环境变量
		this.driver = MMDriver.init();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Lib.login_AppBuilder(driver, UserName, Password);
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		UploadFilePath = PropertiesDataProvider.getTestData("config/config.properties", "UploadFilePath");
		WaitTime = Integer.parseInt(sWaitTime);
		Lib.wait_Sleep(3000);
		Lib.Switch_appGourp(driver, "ui-test");
//		Lib.checkPageIsReady(driver);
		Lib.wait_Sleep(3000);
		driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();	
	}

	@AfterClass
	public void afterClass() {
		//Debug 请注释以下
		if (Integer.parseInt(PropertiesDataProvider.getTestData("config/config.properties", "Debug")) == 0) {
			driver.switchTo().defaultContent();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.SIGNOUT_arrow).click();
	        Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.SIGNOUT).click();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		MMDriver.softAssert = new SoftAssert();
		driver.switchTo().defaultContent();
		Lib.wait_Sleep(2000);
		Lib.SwitchToFrame(driver, "moduleFrame");
		//ClearMainGui
		int i = driver.findElements(AppElements.Window_masks).size();
		if(i != 0) {
//			List<WebElement> Close_btns = driver.findElements(By.xpath("//a[@class='panel-tool-close']"));
//			for (WebElement Close_btn : Close_btns) {
//				Close_btn.click();
//			}
			List<WebElement> No_btns = driver.findElements(By.xpath("//div[@id='new_pop_stream']//span[text()='Cancel']"));
			for (WebElement No_btn : No_btns) {
				No_btn.click();
			}
		}
		
		this.currentWindow = driver.getWindowHandle();	
	}

	@AfterMethod
	public void afterMethod() {
//		MMDriver.softAssert.assertAll();	
	}
	
	@Test
	public void APP_GUI_01_app_Menu_bar(){
	   try {
			Lib.checkPageIsReady(driver);
			 driver.switchTo().defaultContent();
             Lib.chkIsDisplayed(driver, AppElements.Btn_UserIcon  , true);
             Lib.chkIsDisplayed(driver, AppElements.Topbar_Btn_Search  , true);
			 Lib.SwitchToFrame(driver, "moduleFrame");
             Lib.chkIsDisplayed(driver, AppElements.Btn_Console_op  , true);
             Lib.chkIsDisplayed(driver, AppElements.Btn_Error  , true);
             Lib.chkIsDisplayed(driver, AppElements.Btn_Search_op  , true);

//             Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Title , true);
//             Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appid , true);
//             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appid, "value", "ui_app_test");
//             Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appname , true);
//             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appname, "value", "");
//             Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appdescription , true);
//             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appdescription, "value", "");
//             Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Applogo , true);
//             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Applogo, "value", "");
           //step02
			 driver.switchTo().defaultContent();
			 driver.findElement(AppElements.UserMenu_downarrow).click();
			 Lib.chkIsDisplayed(driver, AppElements.SIGNOUT , true);
//			 Lib.chkIsDisplayed(driver, AppElements.User_profile , true);
//             Lib.ChkProperty(driver, AppElements.User_profile, "innerText", "COC");
             Lib.ChkProperty(driver, AppElements.Username, "innerText", "uitest");
             Lib.ChkProperty(driver, AppElements.profile_account, "innerText", "My Account");
//             Lib.ChkProperty(driver, AppElements.favorites_account, "innerText", "Favorites");
			 //收起菜单
			 driver.findElement(AppElements.UserMenu_downarrow).click();
			 //step03
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 driver.findElement(AppElements.Btn_Search_op).click();
             Lib.isExist(driver, AppElements.Search_window); 
             //step04
			 driver.switchTo().defaultContent();
			 driver.findElement(AppElements.Menu_bar_WorkSpacesIcon).click();
			 Lib.SwitchToFrame(driver, "workspacesFrame");
			 Lib.chkIsDisplayed(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_gmj") , true);
			 Lib.chkIsDisplayed(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_switch") , true);
			 Lib.chkIsDisplayed(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_test") , true);
            //step05
			 Lib.mouseMoveToElement(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_gmj"));
			 Lib.mouseMoveToElement(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_switch"));
			 Lib.mouseMoveToElement(driver, AppElements.SwitchAppMenu_CustomObj("ui_app_test"));

			 //step06
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 driver.findElement(AppElements.Btn_Console_op).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Console_Window , true);
			 Lib.chkIsDisplayed(driver, AppElements.Console_btn_filter , true);
			 Lib.chkIsDisplayed(driver, AppElements.Console_btn_Clear , true);
			 Lib.chkIsDisplayed(driver, AppElements.Console_btn_Last , true);
			 Lib.chkIsDisplayed(driver, AppElements.Console_btn_Next , true);
//			 Lib.chkIsDisplayed(driver, AppElements.Console_input_find , true);

             //step07
			 driver.findElement(AppElements.Btn_Console_cl).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Console_Window , false);

            //step08			
			 Lib.wait_Sleep(2000);
			 driver.findElement(AppElements.Btn_Problems_op).click();
			 Lib.chkIsDisplayed(driver, AppElements.Search_bar , false);
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Problems_highlight , true);
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Console_cl , true);
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Search_cl , true);

//			 Lib.chkIsDisplayed(driver, AppElements.error_btn_filter , true);
//			 Lib.chkIsDisplayed(driver, AppElements.error_btn_Clear , true);
//			 Lib.chkIsDisplayed(driver, AppElements.error_btn_Last , true);
//			 Lib.chkIsDisplayed(driver, AppElements.error_btn_Next , true);

			//step09
			 Lib.wait_Sleep(2000);
			 driver.findElement(AppElements.Btn_Search_cl).click();
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Problems_cl , true);
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Console_cl , true);
			 Lib.chkIsDisplayed(driver, AppElements.Btn_Search_cl , true);
			 Lib.chkIsDisplayed(driver, AppElements.Search_bar , false);

            //step10
//			 driver.switchTo().defaultContent();
		    driver.findElement(AppElements.Btn_TopSearch).click();
            Lib.chkIsDisplayed(driver, AppElements.input_TopSearch , true);

		} catch (Exception e) {
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
//	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_folder_add"))) {
//		          Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_folder_add"));
//		          driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
//		          Lib.wait_Sleep(2000);
//		          driver.findElement(AppElements.Delete_Yes).click();
//		    }
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_02_app_list(){
		try {
			Lib.checkPageIsReady(driver);
 
			 //step01
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Resource"), true);
             //step02
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database/Test") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database/Tables") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Sheet/SheetTest") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/RestTest") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/WebTest") , true);

			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_employee.xlsx") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_file_nidef.xlsx") , true);
			 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Script_file_JumpFlowEnd.ucx") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_02/UI_Doc_file_JumpFlowStart.rex") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testucx.ucx") , true);

			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Mattermost") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Resource") , true);
			 //step03
//			 driver.switchTo().defaultContent();
			 driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TrainApp, true);
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_DeployApp, true);
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TestApp, true);
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_PendingCheckin, true);
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Learning, true);
			 Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Appinfo, true);

			 //step04
			 driver.findElement(AppElements.Btn_Console_op).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Console_Window , true);
             //step05
			 driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_TrainApp).click();
			 Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(2), true);
			 //step06
			 driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_DeployApp).click();
			 Lib.CheckConsoleMsg(driver, "[Start deploy]Document");
			 Lib.wait_Sleep(10000);
			 Lib.CheckConsoleMsg(driver, "[End deploy]Document");

              String currentWindow = driver.getWindowHandle();
             //step07
			 driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_TestApp).click();
			 Lib.wait_Sleep(3000);
             Lib.changeWindow(driver);
             Lib.ChkProperty(driver, AppElements.LiteChatTest_ChannelName, "textContent", "ui_app_test");
             //step08 
             driver.close();
             driver.switchTo().window(currentWindow);
             Lib.SwitchToFrame(driver, "moduleFrame");
 		     //step09
             driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_PendingCheckin).click();
             Lib.ChkProperty(driver, AppElements.checkoutlistfiles_empty, "innerText", "You haven't checked out any file!");
//             Lib.chkIsDisplayed(driver, AppElements.PendingCheckin_btn_Checkin, true);
//             Lib.chkIsDisplayed(driver, AppElements.PendingCheckin_btn_Uncheck, true);
//             FileListTable datatable = new FileListTable(driver, "filelist", "moduleFrame");
//             Lib.assertEquals(datatable.getFileNameData(2), "Data/UI_Data_folder_01/UI_Data_file_employee.xlsx");

             //step10
             Lib.SwitchToFrame(driver, "moduleFrame");
             driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_Learning).click();
             Lib.SwitchToFrame(driver, "externalAppIframe");
             Lib.chkIsDisplayed(driver, AppElements.Learning_Session, true);
             Lib.chkIsDisplayed(driver, AppElements.Learning_QA, true);
             Lib.chkIsDisplayed(driver, AppElements.Learning_STATUS, true);
             Lib.chkIsDisplayed(driver, AppElements.Learning_FROM, true);
             Lib.chkIsDisplayed(driver, AppElements.Learning_TO, true);
             Lib.chkIsDisplayed(driver, AppElements.Learning_select_STATUS, true);

             //step11
             Lib.SwitchToFrame(driver, "moduleFrame");
             driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList_Menu_Appinfo).click();
			 
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_Label_Appname, true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_Label_Appdescription, true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_Label_Applogo, true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_input_Appdescription , true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_input_Applogo , true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_input_Appname , true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_button_OK , true);
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_button_Cancel , true);

             Lib.ChkProperty(driver, AppElements.AppInfo_input_Appname, "value", "ui_app_test");
             Lib.ChkProperty(driver, AppElements.AppInfo_input_Appdescription, "value", "test");

			 driver.findElement(AppElements.AppInfo_button_Cancel).click();
             Lib.chkIsDisplayed(driver, AppElements.AppInfo_Title, false);
             
             //step13
             driver.findElement(AppElements.Menu_bar_AppNameDropList).click();
			 driver.findElement(AppElements.AppNameDropList__Menu_DistributeApp).click();
             Lib.SwitchToFrame(driver, "deploymentFrame");
             Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Release"), true); 
             Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data"), true); 
             Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true); 

             Lib.SwitchToFrame(driver, "externalAppIframe");
             
             Lib.chkIsDisplayed(driver, AppElements.CreateRelease_Title , true); 
             Lib.chkIsDisplayed(driver, AppElements.CreateNewRelease_btn , true); 
             Lib.chkIsDisplayed(driver, AppElements.PreviousReleases_Title , true); 

             //step14 pending
             
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_02a_app_list_fold_app_tree(){
		try {
			 Actions action = new Actions(driver);
			Lib.checkPageIsReady(driver);
			 //step01
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Resource"), true);
             //step02
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Sheet/SheetTest") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/RestTest") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/WebTest") , true);

			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_employee.xlsx") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx") , true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_file_nidef.xlsx") , true);
			 //step03
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TrainApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_DeployApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TestApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList__Menu_DistributeApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_PendingCheckin , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Learning , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_RecentDocs , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Appinfo , true); 
             //step04
			 Lib.wait_Sleep(1000);
             driver.findElement(AppElements.AppNameDropList_Menu_TrainApp).click();
//             Lib.CheckConsoleMsg(driver, "Submitting ui-test/ui_app_test/data/... for training");
             //step05
			 Lib.wait_Sleep(1000);
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
			 Lib.wait_Sleep(1000);
             driver.findElement(AppElements.AppNameDropList_Menu_DeployApp).click();
//             Lib.CheckConsoleMsg(driver, "<current time>:[Start deploy]Document");
//             Lib.CheckConsoleMsg(driver, "<current time>:[End deploy]Document");
             //step06
			 Lib.wait_Sleep(2000);
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
			 Lib.wait_Sleep(1000);
             driver.findElement(AppElements.AppNameDropList_Menu_PendingCheckin).click();
             Lib.chkTextContent(driver, AppElements.checkoutlistfiles_empty , AppBChkPoint.You_havent_checked_out_any_file);

             //step07
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
			 Lib.wait_Sleep(1000);
             driver.findElement(AppElements.AppNameDropList_Menu_Learning).click();
             ImgChecker imgChecker = new ImgChecker(driver);
             Lib.SwitchToFrame(driver, "moduleFrame"); 
             Lib.SwitchToFrame(driver, "externalAppIframe"); 
             imgChecker.CheckImg(driver.findElements(By.xpath("//html[@class='panel-fit']//body[contains(@class,'easyui-layout')]")).get(0), "APP_GUI_02a_step07");

             //step08
             Lib.SwitchToFrame(driver, "moduleFrame");
             driver.findElement(AppElements.Test_atBottom).click();
			 Lib.wait_Sleep(2000);
             String currentWindow = driver.getWindowHandle();
             Lib.changeWindow(driver);
             //step09
             driver.close();
             //step10
            driver.switchTo().window(currentWindow);
             Lib.SwitchToFrame(driver, "moduleFrame");
             driver.findElement(AppElements.Distribute_atBottom).click();
			 Lib.wait_Sleep(2000);
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame("deploymentFrame");
             driver.switchTo().frame("externalAppIframe");
             imgChecker.CheckImg(driver.findElement(By.xpath("//div[@id='base']/parent::body")), "APP_GUI_02a_step10");

             //step11
             driver.switchTo().defaultContent();
			 driver.switchTo().frame("deploymentFrame");
             driver.findElement(AppElements.Dev_atBottom).click();
             Lib.SwitchToFrame(driver, "moduleFrame");
             
             //step12
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Resource"), true);
			 
			 //step13
			 Lib.DirFile(driver, "Document").click();
			 
			 //step14
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TrainApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_DeployApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_TestApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList__Menu_DistributeApp , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_PendingCheckin , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Learning , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Learning , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_RecentDocs , true); 
             Lib.chkIsDisplayed(driver, AppElements.AppNameDropList_Menu_Appinfo , true); 
           
			 Lib.chkIsDisplayed(driver, AppElements.Dev_atBottom , true);
			 Lib.chkIsDisplayed(driver, AppElements.Distribute_atBottom , true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_atBottom , true);

			 //step15
			 Lib.findElement(driver, AppElements.TrainDocument_atBottom).click();
			 
			 //step16
			 Lib.DirFile(driver, "Data/termdef.xlsx").click();

			 //step17
			 Lib.findElement(driver, AppElements.TrainDocument_atBottom).click();
			 Lib.CheckConsoleMsg(driver, "Training spreadsheet termdef.xlsx");

			 //step18
			 Lib.DirFile(driver, "Document/UI_Doc_file_script.rex").click();
			 
			 //step19
			 AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();
			 Lib.CheckConsoleMsg(driver, "	training UI_Doc_file_script.rex");

			 //step20
			 Lib.findElement(driver, AppElements.Menu_bar_AppNameDropList).click();
             action.moveToElement(Lib.findElement(driver, AppElements.AppNameDropList_Menu_RecentDocs));
             action.perform();
             
             //step21
             action.moveToElement(Lib.findElement(driver, AppElements.AppNameDropList_Menu_RecentDocs("termdef.xlsx")));
             action.perform();
             
             //step22
             Lib.DirFile(driver, "Data/UI_Data_folder_01").click();
             
             //step23
			 AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

			 //step24
             Lib.DirFile(driver, "Document/Intellisense").click();
             
             //step25
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();
             
             //step26
             Lib.DirFile(driver, "Data/Database").click();
             
             //step27
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step28
             Lib.DirFile(driver, "Data/Database/Database/Test").click();
             
             //step29
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step30
             Lib.DirFile(driver, "Data/Database/Database/Tables").click();

             //step31
             Lib.DirFile(driver, "Data/Database/Database/Tables/QHIST").click();

             //step32
             Lib.DirFile(driver, "Data/Sheet").click();

             //step33
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step34
             Lib.DirFile(driver, "Data/Sheet/SheetTest").click();
             
             //step35
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();
             
             //step36
             Lib.DirFile(driver, "Data/Data Service").click();

             //step37
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step38
             Lib.DirFile(driver, "Data/Data Service/RestTest").click();

             //step39
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step40
             Lib.DirFile(driver, "Data/Data Service/WebTest").click();
             
             //step41
             AppElements.getWebElementByIndex(driver, AppElements.TrainDocument_atBottom, 0).click();

             //step42
             Lib.DirFile(driver, "Channel").click();
             
             //step43
             Lib.DirFile(driver, "Resource").click();



             
             
             


             
             
             
             
             
             






			 
			 


             
             

             

             
             
             

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	
	/**
	 * @deprecated  Can't new app after del it.
	 */
//	@Test 
	public void APP_GUI_03_app_New_and_Delete(){
		try {
			 Lib.wait_Sleep(2000);
			 driver.switchTo().defaultContent();
			 driver.findElement(AppElements.Apps_btn_downarrow).click();
			 driver.findElement(AppElements.Menu_bar_New).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
             //step02
		     driver.findElement(AppElements.Display_AppID_CustomObj("derick_app_temp", "Logo")).click();
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_Appid, true);
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appname, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appdescription, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_select_Apptemplate , "value", "derick_app_temp");
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_ArrowDown_Advanced , true);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Advanced , true);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_Reset , true);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_OK , true);
            //step03
		     driver.findElement(AppElements.CreateNewApplication_ArrowDown_Advanced).click();
			 Lib.wait_Sleep(2000);
		     driver.findElement(AppElements.CreateNewApplication_input_Appid).click();
		     driver.findElement(AppElements.CreateNewApplication_input_Appname).click();
			 Lib.wait_Sleep(WaitTime);
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix , "value", "uitest_cyberobject_com_cn");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI , "value", "http://www.uitest_cyberobject_com_cn.com/#");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI , "value", "http://www.uitest_cyberobject_com_cn.com//term#");

		     //step04
             driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
			 Lib.wait_Sleep(WaitTime);
		     driver.findElement(AppElements.CreateNewApplication_input_Appname).click();
			 Lib.wait_Sleep(WaitTime);
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "fm_app_temp");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix , "value", "uitest_cyberobject_com_cn");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI , "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp#");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI , "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp/term#");

             //step05
		     driver.findElement(AppElements.CreateNewApplication_btn_Reset).click();
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI , "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI , "value", "");
             //step06
             driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");   //issue :case need to update.
		     driver.findElement(AppElements.CreateNewApplication_btn_OK).click();     
			 Lib.wait_Sleep(3000);
		     Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("fm_app_temp") , true);
		     //step07
		     Lib.SwitchApp(driver);
			 Lib.wait_Sleep(2000);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps") , true);

		     //step08
		     driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
			 Lib.wait_Sleep(WaitTime);
		     Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Title , true);
		     Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appid , true);
             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appid, "value", "fm_app_temp");
//             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_, "value", "fm_app_temp");
             //open advanced option
             driver.findElement(AppElements.Applicationinformation_Advanced_arrow).click();
			 Lib.wait_Sleep(3000);
             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Prefix , "value", "uitest_cyberobject_com_cn_fm_app_temp");
             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_URI , "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp#");
             Lib.ChkProperty(driver, AppElements.Applicationinformation_input_TermURI , "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp/term#");

             //step09
             driver.findElement(AppElements.Menu_bar_Delete).click();
			 Lib.wait_Sleep(3000);
             Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
             //step10
             driver.findElement(AppElements.Delete_Cancel).click();
			 
             //step11
		     Lib.SwitchApp(driver);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(2000);
			 //step12
		     driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
			 Lib.wait_Sleep(WaitTime);
             driver.findElement(AppElements.Menu_bar_Delete).click();
			 Lib.wait_Sleep(3000);
             Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
             //step13
             driver.findElement(AppElements.Delete_OK).click();
			 
             //step14
		     Lib.SwitchApp(driver);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_List_app_templates).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps") , false);

			 //step15
		     Lib.SwitchApp(driver);
		     driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
//		     driver.findElement(AppElements.Menu_bar_list_apps).click();
//			 Lib.wait_Sleep(2000);
//		     driver.findElement(AppElements.Display_AppID_CustomObj("ui_app_test", "Listapps")).click();
		     Lib.SwitchApp(driver);
		     driver.findElement(AppElements.Menu_bar_New_app).click();
			 Lib.wait_Sleep(4000);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_Templates , true);

             //step16
		     driver.findElement(AppElements.Display_AppID_CustomObj("Blank", "Logo")).click();
			 Lib.wait_Sleep(2000);
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appname, "value", "");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appdescription, "value", "");
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_ArrowDown_Advanced , true);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_Reset , true);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_OK , true);

			 //step17
             driver.findElement(AppElements.CreateNewApplication_ArrowDown_Advanced).click();
			 Lib.wait_Sleep(3000);
             driver.findElement(AppElements.CreateNewApplication_input_Prefix).click();
             driver.findElement(AppElements.CreateNewApplication_input_URI).click();
			 Lib.wait_Sleep(WaitTime);
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix , "value", "uitest_cyberobject_com_cn");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI , "value", "http://www.uitest_cyberobject_com_cn.com/#");
             Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI , "value", "http://www.uitest_cyberobject_com_cn.com//term#");

             //step18
             driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
		     driver.findElement(AppElements.CreateNewApplication_btn_OK).click();
			 Lib.wait_Sleep(3000);
		     Lib.SwitchApp(driver);
		     
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps") , true);

             //step19
		     Lib.mouseRightClick(driver, AppElements.Menu_bar_AppName("fm_app_temp"));
//             driver.findElement(AppElements.RIGHTCLICK_appRoot_Menu_Delete).click();
			 Lib.wait_Sleep(3000);
             Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
             //step20
             driver.findElement(AppElements.Delete_OK).click();
             //step21
		     Lib.SwitchApp(driver);
             driver.findElement(AppElements.Display_OrgID_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps") , false);

		     //step22
		     driver.findElement(AppElements.Menu_bar_New_app).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Title , true);
           //step23
		     driver.findElement(AppElements.Display_AppID_CustomObj("Blank", "Logo")).click();
			 Lib.wait_Sleep(2000);
             driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
		     driver.findElement(AppElements.CreateNewApplication_btn_OK).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("fm_app_temp") , true);
            //step24
		     Lib.mouseRightClick(driver, AppElements.Menu_bar_AppName("fm_app_temp"));
//             driver.findElement(AppElements.RIGHTCLICK_appRoot_Menu_Delete).click();
            //step25
             Lib.wait_Sleep(3000);
             Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
             driver.findElement(AppElements.Delete_OK).click();
             //step26
             Lib.SwitchApp(driver);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps") , false);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			 Lib.SwitchApp(driver);
			 Lib.wait_Sleep(2000);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_list_apps).click();
			 Lib.wait_Sleep(WaitTime);
			 if (Lib.isExist(driver,AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"))) {
				 driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
				 Lib.wait_Sleep(WaitTime);
	             driver.findElement(AppElements.Menu_bar_Delete).click();
				 Lib.wait_Sleep(3000);
	             driver.findElement(AppElements.Delete_OK).click();
			}
			 
			 Lib.SwitchApp(driver);
			 Lib.wait_Sleep(2000);
             driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
		     driver.findElement(AppElements.Menu_bar_List_app_templates).click();
			 if (Lib.isExist(driver,AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapptemplates"))) {
				 driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapptemplates")).click();
				 Lib.wait_Sleep(WaitTime);
	             driver.findElement(AppElements.Menu_bar_Delete).click();
				 Lib.wait_Sleep(3000);
	             driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_04_Data_Information(){
		try {
			Lib.checkPageIsReady(driver);
             Lib.DirFile(driver, "Data").click();
			 FileListTable fileListTable = new FileListTable(driver, "filelist","moduleFrame");
			 String [][] ExecptedArray = {{"FileName", "Modified", "Modifier", "Creator"},
					 {"UI_Data_folder_01", "08-16-18 03:19:39","uitest","uitest"},
					 {"UI_Data_folder_02", "08-16-18 03:20:27","uitest","uitest"},
					 {"UI_Data_file_nidef.xlsx", "08-16-18 03:20:52", "uitest", "uitest"}
			 }; 
			 int row;
			 for (int i = 0; i < ExecptedArray.length ; i++) {
				 Lib.wait_Sleep(1000);
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
			 
             Lib.DirFile(driver, "Data/Database/Database").click();
			 Lib.wait_Sleep(1000);
             String[] Databaselist = {"Test","~","uitest","uitest"};
			 row = fileListTable.getRowByFileName(Databaselist[0]);
			 int i = 1;
             for (String databaselist : Databaselist) {
            	 if (databaselist.equals("~")) {
            		i++;
					continue;
				}
            	 Lib.assertEquals(fileListTable.getCellData(row, i+1), databaselist);
            	 i++;
			 }
             //step03
             Lib.DirFile(driver, "Data/Sheet").click();
             Lib.wait_Sleep(1000);
             String[] Sheetlist = {"SheetTest","~", "~","uitest","uitest"};
			 row = fileListTable.getRowByFileName(Sheetlist[0]);
             i = 1;
             for (String sheetlist : Sheetlist) {
            	 if (sheetlist.equals("~")) {
            		i++;
					continue;
				}
            	 Lib.assertEquals(fileListTable.getCellData(row, i+1), sheetlist);
            	 i++;
			 }
             
             //step04
             Lib.DirFile(driver, "Data/Data Service").click();
             Lib.wait_Sleep(1000);
             String[][] Serviceslist = {{"WebTest","~", "~","uitest","uitest"},
            		 {"RestTest","~", "~","uitest","uitest"}};
			 for (i = 0; i < Serviceslist.length ; i++) {
				 row = fileListTable.getRowByFileName(Serviceslist[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), Serviceslist[i][0]);
				 Lib.assertEquals(fileListTable.getModifierData(row), Serviceslist[i][3]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), Serviceslist[i][4]);
			 };

		     //step06
             Lib.DirFile(driver, "Data").click();
             Lib.wait_Sleep(1000);
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElement("UI_Data_file_nidef.xlsx"));
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("UI_Data_file_nidef.xlsx").findElement(By.xpath(".//i[@action='downloadAction'][@class='ico ico-download']")), true);
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("UI_Data_file_nidef.xlsx").findElement(By.xpath(".//i[@action='deleteUniversalAction'][@class='ico ico-del']")), true);  
		
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_05_Data_Menu_list(){
		try {
               Lib.wait_Sleep(2000);
			 
				//windows operate 
               //java.lang.Runtime.getRuntime().exec("D:\\Move_To_Iplatform\\iplatform\\autoit-v3\\uploadfile.exe");

			 //step02
             Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newfolder , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet , true);

//			 driver.findElement(AppElements.RIGHTCLICK_Data_Menu_import_Database).click();
//			      
//	            String[][] TableExpected = new String[6][7];
//	            TableExpected[0][0] = "resource:db_ers";
//	            TableExpected[0][1] = "ip:192.168.254.190";
//	            TableExpected[0][2] = "port:8306";
//	            TableExpected[0][3] = "type:mysql";
//	            TableExpected[0][4] = "pwd:123456";
//	            TableExpected[0][5] = "user:db_ers";
//	            TableExpected[0][6] = "db:db_ers";
//
//	            TableExpected[1][0] = "resource:test_ht";
//	            TableExpected[1][1] = "ip:192.168.0.55";
//	            TableExpected[1][2] = "port:6306";
//	            TableExpected[1][3] = "type:mysql";
//	            TableExpected[1][4] = "pwd:123456";
//	            TableExpected[1][5] = "user:iplatform_dev";
//	            TableExpected[1][6] = "db:test_ht";
//	      
//	            TableExpected[2][0] = "resource:iplatform_dev";
//	            TableExpected[2][1] = "ip:192.168.0.55";
//	            TableExpected[2][2] = "port:6306";
//	            TableExpected[2][3] = "type:mysql";
//	            TableExpected[2][4] = "pwd:123456";
//	            TableExpected[2][5] = "user:iplatform_dev";
//	            TableExpected[2][6] = "db:iplatform_dev";
//	                     
//	            TableExpected[3][0] = "resource:ipf_security_dev";
//	            TableExpected[3][1] = "ip:192.168.0.55";
//	            TableExpected[3][2] = "port:6306";
//	            TableExpected[3][3] = "type:mysql";
//	            TableExpected[3][4] = "pwd:123456";
//	            TableExpected[3][5] = "user:ipf_security_dev";
//	            TableExpected[3][6] = "db:ipf_security_dev";
//	                    
//	            TableExpected[4][0] = "resource:iplatform_prod";
//	            TableExpected[4][1] = "ip:192.168.254.190";
//	            TableExpected[4][2] = "port:6306";
//	            TableExpected[4][3] = "type:mysql";
//	            TableExpected[4][4] = "pwd:123456";
//	            TableExpected[4][5] = "user:iplatform_prod";
//	            TableExpected[4][6] = "db:iplatform_prod";
//	           
//	            TableExpected[5][0] = "resource:ipf_security_prod";
//	            TableExpected[5][1] = "ip:192.168.254.190";
//	            TableExpected[5][2] = "port:6306";
//	            TableExpected[5][3] = "type:mysql";
//	            TableExpected[5][4] = "pwd:123456";
//	            TableExpected[5][5] = "user:ipf_security_prod";
//	            TableExpected[5][6] = "db:ipf_security_prod";
//	            Lib.ChkImportDataBase(driver, TableExpected);
//	            //step03
//	          driver.findElement(AppElements.ImportDataBaseWindow_Close).click();
	          //step02
				if (!Lib.isExist(driver, AppElements.Console_Window)){
					driver.findElement(AppElements.Btn_Console_op).click();
					Lib.wait_Sleep(3000);
				}
			  Lib.chkIsDisplayed(driver, AppElements.Console_Window, true);
//			  Lib.Clear_ConsoleMsg(driver);
			  
	          //step03
	          Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			  driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Train).click();
//              Lib.CheckConsoleMsg(driver, "trained");
			  Lib.wait_Sleep(2000);
              Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
              Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Data/UI_Data_test_file.xlsx]");
              Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);
               
              //step04
			  Lib.wait_Sleep(1000);
	          Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			  driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newfolder).click();
			  Lib.wait_Sleep(2000);

	          Lib.chkTextContent(driver, AppElements.NewFolder_MSG_Content , AppBChkPoint.Please_enter_a_folder_name);
			  Lib.chkIsDisplayed(driver, AppElements.NewFolder_Input_Field , true);
			  Lib.chkIsDisplayed(driver, AppElements.NewFolder_Cancel, true);
			  Lib.chkIsDisplayed(driver, AppElements.NewFolder_OK, true);

              //step05
			  driver.findElement(AppElements.NewFolder_Input_Field).clear();
			  driver.findElement(AppElements.NewFolder_Input_Field).sendKeys("UI_Data_folder_add");
			  driver.findElement(AppElements.NewFolder_OK).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_add") , true);
			  //step06
	          Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			  driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newsheet).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title_2, true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx"), true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Iplatform", "TestHeader.xlsx"), true);
			  //step07
			  driver.findElement(AppElements.New_Sheet_CustomSheet("Iplatform", "TestHeader.xlsx")).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title, true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Inputfield, true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Back, true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Create, true);

			  //step08
			  driver.findElement(AppElements.New_Sheet_Back).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title_2, true);
			  Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx"), true);

			  //step09
			  driver.findElement(AppElements.New_Sheet_CustomSheet("Iplatform", "TestHeader.xlsx")).click();
			  Lib.wait_Sleep(2000);
			  driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Data_file_add");
			  driver.findElement(AppElements.New_Sheet_Create).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_add") , true);

			 //step10
	          Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			  driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Uploadsheet).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, AppElements.Upload_Please_select_excel_file_to_upload, true);
			  Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload));
				actions.click(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload));
				//step11
				actions.perform();              
				Lib.wait_Sleep(3000);
               //step12
				//windows operate 
		        AutoWin.winActivate("打开");
			    Lib.wait_Sleep(2000);
			    AutoWin.controlFocus("打开", "", "Edit1");
			  //step13
			    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload sheet.xlsx");
			    Lib.wait_Sleep(1000);
		        AutoWin.controlClick("打开", "", "Button1");
		        Lib.wait_Sleep(3000);
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_TEST_Upload sheet.xlsx"), true);
                try {
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_file_add.xlsx"), true);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_TEST_Upload sheet.xlsx"), true);
				} finally {
		  	    Lib.SwitchToFrame(driver, "moduleFrame");
				//step14
		        Lib.mouseRightClick(driver,Lib.DirFile(driver,"Data/UI_TEST_Upload sheet.xlsx"));
		        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
		        driver.findElement(AppElements.Delete_OK).click();
				//step15
		        Lib.wait_Sleep(2000);
		        Lib.mouseRightClick(driver,Lib.DirFile(driver,"Data/UI_Data_file_add.xlsx"));
		        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
		        driver.findElement(AppElements.Delete_OK).click();
                //step16
		        Lib.mouseRightClick(driver,Lib.DirFile(driver,"Data/UI_Data_folder_add"));
		        driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
		        driver.findElement(AppElements.Delete_OK).click();
				}
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_TEST_Upload sheet.xlsx"))) {
		          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_TEST_Upload sheet.xlsx"));
				  driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
				  Lib.wait_Sleep(3000);
				  driver.findElement(AppElements.Delete_OK).click(); 
			}

			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_file_add.xlsx"))) {
		          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_file_add.xlsx"));
				  driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
				  Lib.wait_Sleep(3000);
				  driver.findElement(AppElements.Delete_OK).click(); 
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_add"))) {
		          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_add"));
				  driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
				  Lib.wait_Sleep(3000);
				  driver.findElement(AppElements.Delete_OK).click(); 
			}
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";gui_start " + e.toString());
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_06_Data_folder_Information(){
		try {
			Lib.checkPageIsReady(driver);
			 //step01
			 Lib.DirFile(driver, "Data/UI_Data_folder_01").click();
			 Lib.wait_Sleep(2000);
			 FileListTable fileListTable = new FileListTable(driver, "filelist");
			 String [][] ExecptedArray = {{"FileName", "Modified", "Modifier", "Creator"},
					 {"UI_Data_file_employee.xlsx", "01-11-19 02:17:17","uitest","uitest"}};
			 int row;
			 for (int i = 0; i < ExecptedArray.length ; i++) {
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//				 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
			 //step02
//		  	 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Data").click();
			 Lib.wait_Sleep(2000);
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElement("UI_Data_file_employee.xlsx"));
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("UI_Data_file_employee.xlsx").findElement(By.xpath(".//i[@action='downloadAction'][@class='ico ico-download']")), true);
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("UI_Data_file_employee.xlsx").findElement(By.xpath(".//i[@action='deleteUniversalAction'][@class='ico ico-del']")), true);
			 //step03
			 Lib.DirFile(driver, "Data/Database").click();
			 Lib.wait_Sleep(3000);
			 ExecptedArray = new String [][]{{"Database", "~", "migrate", "uitest"}};
		 for (int i = 0; i < ExecptedArray.length ; i++) {
			 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
			 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//			 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
			 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
			 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
		 };
		 //step04
		     Lib.DirFile(driver, "Data/Database/Database").click();
		     Lib.wait_Sleep(3000);
			 ExecptedArray = new String [][]{{"Test", "~","migrate","uitest"}};
			 for (int i = 0; i < ExecptedArray.length ; i++) {
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//				 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
			 //step05
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElement("Test"));
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("Test").findElement(By.xpath(".//i[@action='services_deletetablesAction'][@class='ico ico-del']")), true);
	          //step06
			 Lib.DirFile(driver, "Data/Sheet").click();
			 Lib.wait_Sleep(2000);
			 ExecptedArray =new String [][]{{"FileName", "Modified", "Modifier", "Creator"},
					 {"SheetTest", "01-11-19 02:17:17","uitest","uitest"}};
					 for (int i = 0; i < ExecptedArray.length ; i++) {
						 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
						 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//						 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
						 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
						 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
					 };
			//step07
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElement("SheetTest"));
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("SheetTest").findElement(By.xpath(".//i[@action='services_deleteAction'][@class='ico ico-del']")), true);
		    //step08
			 Lib.DirFile(driver, "Data/Data Service").click();
			 Lib.wait_Sleep(2000);
			 ExecptedArray =new String [][]{{"FileName", "Modified", "Modifier", "Creator"},
					 {"WebTest", "01-11-19 02:17:17","uitest","uitest"},
					 {"RestTest", "01-11-19 02:17:17","uitest","uitest"}};
					 for (int i = 0; i < ExecptedArray.length ; i++) {
						 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
						 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//						 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
						 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
						 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
					 };
			//step09
			 Lib.wait_Sleep(1000);	 
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElement("WebTest"));
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("WebTest").findElement(By.xpath(".//i[@action='services_deleteAction'][@class='ico ico-del']")), true);	 
			//step10
//			 Lib.DirFile(driver, "Data/Rest Services").click();
//			 Lib.wait_Sleep(2000);
//			 ExecptedArray =new String [][]{{"FileName", "Modified", "Modifier", "Creator"},
//					 {"RestTest", "01-11-19 02:17:17","uitest","uitest"}};
//					 for (int i = 0; i < ExecptedArray.length ; i++) {
//						 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
//						 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
////						 Lib.assertEquals(fileListTable.getModifiedData(row), ExecptedArray[i][1]);
//						 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
//						 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
//					 };
			//step10
			  Lib.mouseMoveToElement(driver, fileListTable.getRowElement("RestTest"));
			  Lib.chkIsDisplayed(driver, fileListTable.getRowElement("RestTest").findElement(By.xpath(".//i[@action='services_deleteAction'][@class='ico ico-del']")), true);
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_07_Data_folder_Menu_list(){
		try {
			 Lib.wait_Sleep(2000);	 
			 //step01
	            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Train , true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet, true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet, true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Copy , true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Delete , true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newfolder , true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Rename , true);
//           //step02
//				Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Folder_Menu_import);
//				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_import_Database).click();
//				String[][] TableExpected = new String[6][7];
//	            TableExpected[0][0] = "resource:db_ers";
//	            TableExpected[0][1] = "ip:192.168.254.190";
//	            TableExpected[0][2] = "port:8306";
//	            TableExpected[0][3] = "type:mysql";
//	            TableExpected[0][4] = "pwd:123456";
//	            TableExpected[0][5] = "user:db_ers";
//	            TableExpected[0][6] = "db:db_ers";
//
//	            TableExpected[1][0] = "resource:test_ht";
//	            TableExpected[1][1] = "ip:192.168.0.55";
//	            TableExpected[1][2] = "port:6306";
//	            TableExpected[1][3] = "type:mysql";
//	            TableExpected[1][4] = "pwd:123456";
//	            TableExpected[1][5] = "user:iplatform_dev";
//	            TableExpected[1][6] = "db:test_ht";
//	      
//	            TableExpected[2][0] = "resource:iplatform_dev";
//	            TableExpected[2][1] = "ip:192.168.0.55";
//	            TableExpected[2][2] = "port:6306";
//	            TableExpected[2][3] = "type:mysql";
//	            TableExpected[2][4] = "pwd:123456";
//	            TableExpected[2][5] = "user:iplatform_dev";
//	            TableExpected[2][6] = "db:iplatform_dev";
//	                     
//	            TableExpected[3][0] = "resource:ipf_security_dev";
//	            TableExpected[3][1] = "ip:192.168.0.55";
//	            TableExpected[3][2] = "port:6306";
//	            TableExpected[3][3] = "type:mysql";
//	            TableExpected[3][4] = "pwd:123456";
//	            TableExpected[3][5] = "user:ipf_security_dev";
//	            TableExpected[3][6] = "db:ipf_security_dev";
//	                    
//	            TableExpected[4][0] = "resource:iplatform_prod";
//	            TableExpected[4][1] = "ip:192.168.254.190";
//	            TableExpected[4][2] = "port:6306";
//	            TableExpected[4][3] = "type:mysql";
//	            TableExpected[4][4] = "pwd:123456";
//	            TableExpected[4][5] = "user:iplatform_prod";
//	            TableExpected[4][6] = "db:iplatform_prod";
//	           
//	            TableExpected[5][0] = "resource:ipf_security_prod";
//	            TableExpected[5][1] = "ip:192.168.254.190";
//	            TableExpected[5][2] = "port:6306";
//	            TableExpected[5][3] = "type:mysql";
//	            TableExpected[5][4] = "pwd:123456";
//	            TableExpected[5][5] = "user:ipf_security_prod";
//	            TableExpected[5][6] = "db:ipf_security_prod";
//	            Lib.ChkImportDataBase(driver, TableExpected);
//		        driver.findElement(AppElements.ImportDataBaseWindow_Close).click();
			 //step02
					if (!Lib.isExist(driver, AppElements.Console_Window)){
						driver.findElement(AppElements.Btn_Console_op).click();
						Lib.wait_Sleep(2000);
					}
				Lib.chkIsDisplayed(driver, AppElements.Console_Window, true);
				
				//step03
				Lib.wait_Sleep(1000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Train).click();
				Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/data/UI_Data_folder_01/UI_Data_file_employee.xlsx success");
//				Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
				Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Data/UI_Data_folder_01/UI_Data_file_employee.xlsx]");
				Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);

		        //step04
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Newfolder).click();
				Lib.wait_Sleep(3000);

				Lib.chkTextContent(driver,AppElements.NewFolder_MSG_Content,AppBChkPoint.Please_enter_a_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.NewFolder_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.NewFolder_Cancel, true);
				Lib.chkIsDisplayed(driver, AppElements.NewFolder_OK, true);
				//step05
		        driver.findElement(AppElements.NewFolder_Input_Field).clear();
		        driver.findElement(AppElements.NewFolder_Input_Field).sendKeys("UI_Data_folder_fm");
		        driver.findElement(AppElements.NewFolder_OK).click();
				Lib.wait_Sleep(8000);
		        Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm").click();
				FileListTable fileListTable = new FileListTable(driver, "filelist");
                Lib.assertEquals(fileListTable.AllRowCount(), 2); 
                //step06
		        Lib.DirFile(driver, "Data").click();
				Lib.wait_Sleep(2000);
				fileListTable = new FileListTable(driver, "filelist");
				String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
				int row = fileListTable.getRowByFileName("FileName");
                Lib.ChkFileTableDataByRow(fileListTable, row, ExpectedValue);

				ExpectedValue =new String [] {"UI_Data_folder_01","~","~","~"};
				row = fileListTable.getRowByFileName("UI_Data_folder_01");
                Lib.ChkFileTableDataByRow(fileListTable, row, ExpectedValue);
                //step07
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm"));
				driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Rename).click();
				Lib.wait_Sleep(3000);

				Lib.chkTextContent(driver,AppElements.Rename_MSG_Content, AppBChkPoint.Please_enter_the_new_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Rename_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Rename_Cancel, true);
				Lib.chkIsDisplayed(driver, AppElements.Rename_OK, true);

                //step08
				driver.findElement(AppElements.Rename_Input_Field).clear();
				driver.findElement(AppElements.Rename_Input_Field).sendKeys("UI_Data_folder_new");
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Rename_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Data/UI_Data_folder_01/UI_Data_folder_new"), true);

				//step09
				Lib.wait_Sleep(2000);

				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Copy).click();
				Lib.wait_Sleep(2000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Paste, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newfolder, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_DataFolder_Menu_Delete, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Copy, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet, true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet, true);
	            //step10
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Paste).click();
				
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content , AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel , true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_OK , true);
		        //step11
				Lib.wait_Sleep(1000);
		        driver.findElement(AppElements.Paste_Cancel).click();
		        
		        //step12
				Lib.wait_Sleep(1000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data"));
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Paste).click();
				//step13
				Lib.wait_Sleep(3000);
		        driver.findElement(AppElements.Paste_Input_Field).clear();
		        driver.findElement(AppElements.Paste_Input_Field).sendKeys("UI_Data_folder_copy_02");
		        driver.findElement(AppElements.Paste_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Data/UI_Data_folder_copy_02"), true);

		        //step14
				Lib.wait_Sleep(2000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Newsheet).click();
				
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title_2, true);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx"), true);
				//step15
				driver.findElement(AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx")).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Inputfield, true);
				Lib.ChkProperty(driver, AppElements.New_Sheet_MSG_Content , "innerText", "Please enter the file name:");
				//step16
				driver.findElement(AppElements.New_Sheet_Back).click();

				//step17
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx"), true);
				driver.findElement(AppElements.New_Sheet_CustomSheet("Iplatform", "Command.xlsx")).click();
				
				Lib.wait_Sleep(3000);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Inputfield, true);
				Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Create, true);
				Lib.ChkProperty(driver, AppElements.New_Sheet_MSG_Content, "innerText", "Please enter the file name:");
				//step18
		        driver.findElement(AppElements.New_Sheet_Inputfield).clear();
		        driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Data_file_fm");
		        driver.findElement(AppElements.New_Sheet_Create).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx") , true);
                
				//step19~21
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Uploadsheet).click();
				Lib.wait_Sleep(3000);
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload));
				actions.click(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload));
				actions.perform();
				//step22
				Lib.wait_Sleep(3000);
				AutoWin.winActivate("打开");
			    Lib.wait_Sleep(2000);
			    AutoWin.controlFocus("打开", "", "Edit1");
			    Lib.wait_Sleep(1000);
			    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload sheet.xlsx");
			    Lib.wait_Sleep(1000);
		        AutoWin.controlClick("打开", "", "Button1");
		        Lib.wait_Sleep(3000);
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"), true);
	            
	            //step23
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"));
                driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
                Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Delete_MSG_Content,AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
                //step24
				driver.findElement(AppElements.Delete_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx") , false);

		         //step25
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_new"));
				 driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
	             Lib.chkTextContent(driver, AppElements. Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_folder);
	             driver.findElement(AppElements.Delete_OK).click();
		         Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_folder_new"), false);

                 //step26
		         Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_copy_02"));
				 driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
	             Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_folder);
	             driver.findElement(AppElements.Delete_OK).click();
		         Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_copy_02"), false);
                 
		         //step27
		         Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"));
				 driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
	             Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
	             driver.findElement(AppElements.Delete_OK).click();
		         Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"), false);

		         //step28
		         Lib.wait_Sleep(1000);
		         Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database"));
				 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_NewDiagram).click();
			     Lib.wait_Sleep(3000);
				 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_Input_Field, true);
				 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_OK, true);
				 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_Cancel, true);
	             Lib.chkTextContent(driver, AppElements.NewDiagram_MSG_Content , AppBChkPoint.Please_enter_a_database_name);
				 //step29
	             driver.findElement(AppElements.NewDiagram_Cancel).click();
				 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_Input_Field, false);
                 //step30
		         Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet"));
	             driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_NewSheet).click();
	             Lib.SwitchToFrame(driver, "externalAppIframe");
				 Lib.chkIsDisplayed(driver, AppElements.New_a_blank_excel_template_Title, true);
				 Lib.chkIsDisplayed(driver, AppElements.Nabet_input_Description, true);
				 Lib.chkIsDisplayed(driver, AppElements.Nabet_input_TemplateName, true);
				 Lib.chkIsDisplayed(driver, AppElements.Nabet_label_Description, true);
				 Lib.chkIsDisplayed(driver, AppElements.Nabet_label_TemplateName, true);
				 Lib.chkIsDisplayed(driver, AppElements.Nabet_Submit, true);
				 Lib.SwitchToFrame(driver, "moduleFrame");
				 //step31
		         Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet"));
	             driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_UploadSheet).click();
	             Lib.SwitchToFrame(driver, "externalAppIframe");
				 Lib.chkIsDisplayed(driver, AppElements.Upload_an_Excel_Template_Title, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_btn_UploadExcelTemplatefile, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_input_Description, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_label_Description, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_input_TemplateName, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_label_TemplateName, true);
				 Lib.chkIsDisplayed(driver, AppElements.UaET_Submit, true);
				 //step32
				 actions.moveToElement(driver.findElement(AppElements.UaET_btn_UploadExcelTemplatefile));
				 Lib.wait_Sleep(1000);
				 actions.click(driver.findElement(AppElements.UaET_btn_UploadExcelTemplatefile));
				 actions.perform(); 
				 Lib.wait_Sleep(3000);
				 //step33
				 AutoWin.winActivate("打开");
			     AutoWin.controlClick("打开", "", "Button2");
				 Lib.SwitchToFrame(driver, "moduleFrame");
				 
//				 Right click Data/Web Services
//				 Select New Web service
				 Lib.wait_Sleep(WaitTime);
				 Lib.mouseRightClick(driver, Lib.DirFile(driver , "Data/Data Service"));
				 driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
				 Lib.wait_Sleep(3000);
				 Lib.SwitchToFrame(driver, "externalAppIframe");
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
		         Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
		         Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true, 3);
		         Lib.ChkProperty(driver, AppElements.AddAwebservice_input_Addfromwebserviceurl, "value", "http://www.dneonline.com/calculator.asmx?wsdl");
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_button_OK, true, 3);
		         Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);
				 //step34
		         driver.findElement(AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile).click();
					Lib.wait_Sleep(1000);
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
		            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
		            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Upload_WSDLXSD_file, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);
		            //step35
		            driver.findElement(AppElements.AddAwebservice_button_Upload_WSDLXSD_file).click();
					Lib.wait_Sleep(WaitTime);
		            AutoWin.winWaitActive("打开");
					Lib.wait_Sleep(2000);
					//step36
		    		AutoWin.controlClick("打开", "取消", "2");
		    		Lib.SwitchToFrame(driver, "moduleFrame");
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service"));
					driver.findElement(AppElements.RIGHTCLICK_RESTServices_Menu_AddRestservice).click();
					Lib.wait_Sleep(3000);
					Lib.SwitchToFrame(driver, "externalAppIframe");
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_Title, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_ServiceName, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_DescriptionOptional, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_HTTP$HTTPS_URL, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_button_Submit, true, 3);
		            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, true, 3);
		            
		            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_ServiceUrl , "value", "");
		            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_DescriptionOptional, "value", "");
		            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_ServiceName, "value", "");
		            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL, "value", "");
		            WebList httpmethod =new WebList(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL);
		            //step37
		            Lib.ChkProperty(driver, httpmethod.GetOptionObj("GET"), "value", "GET");  
		            Lib.ChkProperty(driver, httpmethod.GetOptionObj("POST"), "value", "POST");  
		            Lib.ChkProperty(driver, httpmethod.GetOptionObj("PUT"), "value", "PUT");  
		            Lib.ChkProperty(driver, httpmethod.GetOptionObj("DELETE"), "value", "DELETE");  
		            httpmethod.select("GET");
		            //step38
		    		Lib.SwitchToFrame(driver, "moduleFrame");
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service"));
					driver.findElement(AppElements.RIGHTCLICK_DataService_Menu_ImportService).click();
		    		Lib.SwitchToFrame(driver, "externalAppIframe");
		            Lib.chkIsDisplayed(driver, AppElements.ImportService_btn_Search , true);
		            Lib.chkIsDisplayed(driver, AppElements.Title_ImportService , true);
		            Lib.chkIsDisplayed(driver, AppElements.Input_Queryservice , true);

		            //step39
		    		Lib.SwitchToFrame(driver, "moduleFrame");
		            if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"))) {
					    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"));
					    driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
					    Lib.wait_Sleep(3000);
		                driver.findElement(AppElements.Delete_OK).click();
					    Lib.wait_Sleep(2000);
			            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"), false);
					}
		            
					if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm"))) {
					    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm"));
					    driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
				        Lib.wait_Sleep(3000);
		                driver.findElement(AppElements.Delete_OK).click();
			            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_folder_fm"), false);
					}
					
					if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_new"))) {
					    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_new"));
					    driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Delete).click();
				        Lib.wait_Sleep(3000);
		                driver.findElement(AppElements.Delete_OK).click();
			            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_folder_new"), false);
					}
					
					if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_copy_02"))) {
			            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_copy_02"));
					    driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
				        Lib.wait_Sleep(3000);
		                driver.findElement(AppElements.Delete_OK).click();
			            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_copy_02"), false);
					}
			           
			        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"))) {
			            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"));
					    driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
				        Lib.wait_Sleep(3000);
		                driver.findElement(AppElements.Delete_OK).click();
			            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"), false);
			         }
		 				 
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);

			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"))) {
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"));
			    driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			    Lib.wait_Sleep(2000);
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_TEST_Upload sheet.xlsx"), false);
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm"))) {
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_fm"));
			    driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_folder_fm"), false);
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_new"))) {
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_folder_new"));
			    driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_folder_new"), false);
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_copy_02"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_copy_02"));
			    driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_copy_02"), false);
			}
	           
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"));
			    driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Data_folder_01/UI_Data_file_fm.xlsx"), false);
	         }
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_08_app_Menu_bar(){
		try {
			Lib.checkPageIsReady(driver);
			 //step01
			  Lib.DirFile(driver, "Data/UI_Data_file_nidef.xlsx").click();
//			  Lib.wait_Sleep(3000);
//			  Lib.SwitchToFrame(driver, "externalAppIframe");
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckout , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble , true);
			  //step02
			  Lib.SwitchToFrame(driver, "moduleFrame");
			  Lib.DirFile(driver, "Data/Database/Database/Test").click();
			  Lib.SwitchToFrame(driver, "externalAppIframe");
			  DatabaseTables databaseTables = new DatabaseTables(driver);
			  Lib.chkIsDisplayed(driver, databaseTables.GetDatabaseTableObject("School"), true);

			  //step03 can not find this file.
			  Lib.SwitchToFrame(driver, "moduleFrame");
			  Lib.DirFile(driver, "Data/Sheet/SheetTest").click();
//			  cannot check excel info
			  //step04
			  Lib.DirFile(driver, "Data/Data Service/TestWeb").click();
			  Lib.wait_Sleep(2000);
	            Lib.SwitchToFrame(driver, "externalAppIframe");
	            Lib.chkIsDisplayed(driver, AppElements.WebTest_Title, true);
	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Description, true);
//	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Status, true);
//	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Type, true);
	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Endpoint, true);
	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_CreateTime, true);
//	            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Processes, true);
	            
	            Lib.ChkProperty(driver, AppElements.WebTest_value_Description, "textContent", "test");
//	            Lib.ChkProperty(driver, AppElements.WebTest_value_Type, "textContent", "Webservice");
	            Lib.ChkProperty(driver, AppElements.WebTest_value_Endpoint, "textContent", "http://www.dneonline.com/calculator.asmx");
	            Lib.ChkProperty(driver, AppElements.WebTest_value_CreateTime, "textContent", "2021-01-17 20:59:42");
                
			    Lib.assertEquals(Lib.GetTableCellData(driver.findElement(AppElements.WebTest_values_Operations), 1, 1), "Add");
			    Lib.assertEquals(Lib.GetTableCellData(driver.findElement(AppElements.WebTest_values_Operations), 2, 1), "Divide");
			    Lib.assertEquals(Lib.GetTableCellData(driver.findElement(AppElements.WebTest_values_Operations), 3, 1), "Multiply");
			    Lib.assertEquals(Lib.GetTableCellData(driver.findElement(AppElements.WebTest_values_Operations), 4, 1), "Subtract");
			  //step05
                Lib.SwitchToFrame(driver, "moduleFrame");
			    Lib.DirFile(driver, "Data/Data Service/RestTest").click();
				Lib.wait_Sleep(2000);
		        Lib.SwitchToFrame(driver, "externalAppIframe");				
	            Lib.chkIsDisplayed(driver, AppElements.RestTest_Title, true);
	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Description, true);
//	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Status, true);
//	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Type, true);
	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_URL, true);
	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_CreateTime, true);
	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Parameters, true);
//	            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Processes, true);
	            
	            Lib.ChkProperty(driver, AppElements.RestTest_value_Description, "textContent", "test");
//	            Lib.ChkProperty(driver, AppElements.RestTest_value_Type, "textContent", "Restful");
	            Lib.ChkProperty(driver, AppElements.RestTest_value_Method, "textContent", "GET");
	            Lib.ChkProperty(driver, AppElements.RestTest_value_URL, "textContent", "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
	            Lib.ChkProperty(driver, AppElements.RestTest_value_CreateTime, "textContent", "2021-01-17 21:04:43");
	            Lib.ChkProperty(driver, AppElements.RestTest_value_Parameters, "title", "add paramter");

	            Lib.chkIsDisplayed(driver, AppElements.RestTest_button_Add, true);

//			  driver.findElement(AppElements.Menu_bar_ExcelCheckout).click();
//			  Lib.wait_Sleep(3000);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelSave , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelUncheck , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckin , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble , true);
//			 //step04
//		      driver.findElement(AppElements.Menu_bar_history).click();
//			  Lib.wait_Sleep(WaitTime);
//			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
//		      String[] TableColumExpecteds = new String[4];
//		      TableColumExpecteds[0] = "Id";
//		      TableColumExpecteds[1] = "UserId";
//		      TableColumExpecteds[2] = "Time";
//		      TableColumExpecteds[3] = "Notes";
//		      for (String TablecolumExpected : TableColumExpecteds) {
//		      	Lib.chkIsDisplayed(driver, By.xpath("//span[text()='"+ TablecolumExpected +"']"), true);
//		      }
//		      //step05
//		      //点击表格第一行数据
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
//		      //step06
//			  driver.findElement(AppElements.Version_History_Show).click();
//			  Lib.wait_Sleep(3000);
////			  String current = driver.getWindowHandle();
//			  Lib.changeWindow(driver);
//			  Lib.assertEquals(driver.getTitle() , "ui_app_test/Data/UI_Data_file_nidef.xlsx<version:1>");
//			  //step07
//			  driver.close();//关闭当前焦点所在的窗口
//			  driver.switchTo().window(currentWindow);
//			  driver.switchTo().frame("moduleFrame");//回到原来页面
//			  
//			  Lib.wait_Sleep(2000);
//		      driver.findElement(AppElements.Menu_bar_Excelhistory).click();
//			  Lib.wait_Sleep(WaitTime);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//			  driver.findElement(AppElements.Version_History_CheckOut).click();
//			  Lib.wait_Sleep(3000);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelSave , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckin , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelUncheck , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelSave , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear , true);
//			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble , true);
//
//			  //step08
//			  driver.findElement(AppElements.Menu_bar_Uncheck).click();
//			  Lib.wait_Sleep(3000);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckout , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble , true);
//		      //step09
//		      if (!Lib.isExist(driver , AppElements.Console_expand)) {
//				  driver.findElement(AppElements.Console_arrow_left).click();
//				  Lib.wait_Sleep(3000);
//			  }
//			  Lib.Clear_ConsoleMsg(driver);
//              //step10
//			  driver.findElement(AppElements.Menu_bar_ExcelTrain).click();
//			  Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/data/UI_Data_file_nidef.xlsx success");
//			  Lib.Switch_ConsoleTab(driver, AppElements.tab_Error);
//              Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Data/UI_Data_file_nidef.xlsx]");
//			  Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);
//
//			  //step11
//			  Lib.Clear_ConsoleMsg(driver);
//			  driver.findElement(AppElements.Menu_bar_ExcelRefresh).click();
//			  Lib.CheckConsoleMsg(driver, "NPUTMANUALLY info is empty");
////              Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);
//              
//              //step12
//			  driver.findElement(AppElements.Menu_bar_Test).click();
//		      Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Web , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Android , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Test_Menu_iOS , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Test_Menu_SMS , true);
//		      Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Voice , true);
//	          Lib.ChkProperty(driver, AppElements.Test_Menu_Web, "class", "menu-item");
//	          Lib.ChkProperty(driver, AppElements.Test_Menu_iOS, "class", "menu-item menu-item-disabled");
//	          Lib.ChkProperty(driver, AppElements.Test_Menu_Android, "class", "menu-item menu-item-disabled");
//	          Lib.ChkProperty(driver, AppElements.Test_Menu_SMS, "class", "menu-item menu-item-disabled");
//	          Lib.ChkProperty(driver, AppElements.Test_Menu_Voice, "class", "menu-item menu-item-disabled");
//			  driver.findElement(AppElements.Console_Window).click();

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.DirFile(driver, "Data/UI_Data_file_nidef.xlsx").click();
			if (Lib.isExist(driver, AppElements.Menu_bar_ExcelUncheck)) {
				  driver.findElement(AppElements.Menu_bar_ExcelUncheck).click();

			}
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_09_Data_file_Spreadsheet_Menu_list(){
		try {
			 Lib.wait_Sleep(2000);
			 String[] History;
			 int r = 0;
			 //step01
             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02"));
			 driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Newsheet).click();
			 Lib.wait_Sleep(1000);
			 Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title_2 , true);
			 Lib.wait_Sleep(2000);
			 //step02
			 driver.findElement(AppElements.New_Sheet_Command_Xlsx).click();
			 Lib.wait_Sleep(2000);
			 driver.findElement(AppElements.New_Sheet_Inputfield).clear();
			 driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Data_test_file");
			 driver.findElement(AppElements.New_Sheet_Create).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_test_file.xlsx") , true);

			 //step03
			 if (!Lib.isExist(driver, AppElements.Console_Window)) {
			 	  driver.findElement(AppElements.Btn_Console_op).click();
			 }  
			  Lib.wait_Sleep(3000);
			  Lib.chkIsDisplayed(driver, AppElements.Console_Window , true);
			  
			 //step04
			  Lib.wait_Sleep(3000);
			  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Checkout  , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Train , true);
              //step05
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Train).click();
	          Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/data/UI_Data_folder_02/UI_Data_file_termdef.xlsx");
			  driver.findElement(AppElements.tab_Error_Cl).click();
              Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx]");
			  driver.findElement(AppElements.tab_Console).click();

			  //step06
			  Lib.wait_Sleep(3000);
			  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Checkout).click();
			  Lib.wait_Sleep(3000);
	          Lib.ChkProperty_Reg(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx").findElement(By.xpath(".//descendant::span[5]")),
	                	  "class", "icon_unlock_excel");
	          //step07
			  Lib.wait_Sleep(3000);
			  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Train , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Checkin , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Discard , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_History , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download , true);
	          //step08
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Discard).click();
//	       	  Lib.chkTextContent(driver,AppElements.Discard_Msg_Content,AppBChkPoint.Are_you_sure_to_discard_the_change_on_UI_Doc_file_testrex);
	          driver.findElement(AppElements.Discard_OK).click();
	          Lib.wait_Sleep(2000);
	          Lib.ChkProperty_Reg(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx").findElement(By.xpath(".//descendant::span[5]")),
                	  "class", "icon_excel");
	          //step09
	          
			  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_History).click();
	          
	          Lib.wait_Sleep(WaitTime);
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
		      String[] TableColumExpecteds = new String[] {"Id","UserId","Time","Notes"};
		      for (String TablecolumExpected : TableColumExpecteds) {
		      	Lib.chkIsDisplayed(driver, By.xpath("//table/thead//td[text()='"+ TablecolumExpected +"']"), true);
		      }
		      History = new String[]{"1","uitest@cyberobject.com.cn","~","Create new file UI_Data_file_termdef.xlsx."}; 
              r = Lib.GetTableRowById(driver.findElement(AppElements.Table_Version_History), "1");
		      for (int j = 0; j < History.length; j++) {
		    	  if (History[j].equals("~")) {
					continue;
				  }
		    	  Lib.assertEquals(Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History),r, j+1).getText(), History[j]);
			  }
		      //step10
			  driver.findElement(AppElements.Version_History_Close).click();
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, false);
	          //step11
			  Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Data_folder_02/UI_Data_test_file.xlsx"));
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
	          Lib.wait_Sleep(3000);
			  Lib.chkIsDisplayed(driver, AppElements.Rename_Input_Field , true);
			  Lib.chkTextContent(driver,AppElements.Rename_MSG_Content , AppBChkPoint.Please_enter_the_new_file_name);
			  //step12
			  driver.findElement(AppElements.Rename_Input_Field).clear();
	          driver.findElement(AppElements.Rename_Input_Field).sendKeys("UI_Data_name_file.xlsx");
	          driver.findElement(AppElements.Rename_OK).click();
	          Lib.wait_Sleep(2000); 
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_name_file.xlsx") , true);      
	          //step13
	          Lib.wait_Sleep(2000);
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Copy).click();
              Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data"));
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newfolder , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Paste , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet , true);
              
	          //step14
	          driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Paste).click();
	          Lib.wait_Sleep(3000);
			  Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_data_name);
              Lib.ChkProperty(driver, AppElements.Paste_Input_Field, "value", "UI_Data_file_termdef.xlsx");
              //step15
              driver.findElement(AppElements.Paste_OK).click();
	          Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx") , true);     
			  //step16
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02"));
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Train , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newfolder , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Rename , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Delete , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Copy , true);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Paste , true);
	          //step17
	          driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Paste).click();
	          Lib.wait_Sleep(3000);
			  Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_data_name);
              Lib.ChkProperty(driver, AppElements.Paste_Input_Field, "value", "UI_Data_file_termdef.xlsx");
              //step18
              driver.findElement(AppElements.Paste_OK).click();
	          Lib.wait_Sleep(2000);

			  //step19
	          if (Lib.isExist(driver, AppElements.WarningMessage_OK))
              {
	        	  driver.findElement(AppElements.WarningMessage_OK).click();
			  }

              driver.findElement(AppElements.Paste_Cancel).click();
			  Lib.CheckConsoleMsg(driver, "File UI_Data_file_termdef.xlsx already exists! if you want to overwrite it, please delete it first.");
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02"));
	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Paste).click();
	          Lib.wait_Sleep(3000);
			  Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_data_name);
              Lib.ChkProperty(driver, AppElements.Paste_Input_Field, "value", "UI_Data_file_termdef.xlsx");
			  //step20
	          driver.findElement(AppElements.Paste_Input_Field).clear();
	          driver.findElement(AppElements.Paste_Input_Field).sendKeys("UI_Data_file_copytermdef.xlsx");
	          driver.findElement(AppElements.Paste_OK).click();
	          Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx") , true);      
	          //step21
	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_termdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Download).click();
	          Lib.wait_Sleep(3000);
	          Lib.isFileDownloaded(downloadpath, "UI_Data_file_termdef.xlsx");

              //step22~23
		        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_name_file.xlsx"))) {
			          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_name_file.xlsx"));
		              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			          Lib.wait_Sleep(3000);
		              driver.findElement(AppElements.Delete_OK).click();
			        }
		      //step24
	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	          Lib.wait_Sleep(3000);
              driver.findElement(AppElements.Delete_OK).click();
              Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"), false);

              //step25
	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	          Lib.wait_Sleep(3000);
              driver.findElement(AppElements.Delete_OK).click();
              Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"), false);
   
              
//	          Lib.wait_Sleep(3000);
//	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database"));
//              driver.findElement(AppElements.RIGHTCLICK_Database_Menu_NewDiagram).click();
//			  Lib.chkTextContent(driver,AppElements.NewDiagram_MSG_Content,AppBChkPoint.Please_enter_the_database_name);
//			  driver.findElement(AppElements.NewDiagram_Input_Field).clear();
//			  driver.findElement(AppElements.NewDiagram_Input_Field).sendKeys("Testing");
//			  driver.findElement(AppElements.NewDiagram_OK).click();
//			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database/Testing"), true);
//	
//			  //step27
//	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Testing"));
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_import , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_AddTable , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Checkin , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Discard , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_History , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Train , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Layout , true);
//			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Delete , true);
//			  //step28-29
//			  driver.findElement(AppElements.RIGHTCLICK_Database_Menu_import).click();
			  

              //step26
	          if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"))) {
	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	          Lib.wait_Sleep(3000);
              driver.findElement(AppElements.Delete_OK).click();
				}
              
	          if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"))) {
	          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"));
              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	          Lib.wait_Sleep(3000);
              driver.findElement(AppElements.Delete_OK).click();
				}

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_test_file.xlsx"))) {
		          Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_test_file.xlsx"));
	              driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		          Lib.wait_Sleep(3000);
	              driver.findElement(AppElements.Delete_OK).click();
		    }
			
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_name_file.xlsx"))) {
	             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_name_file.xlsx"));
                 driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	             Lib.wait_Sleep(3000);
                 driver.findElement(AppElements.Delete_OK).click();
	        }
	        
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_file_template.xlsx"))) {
	             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_file_template.xlsx"));
                 driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	             Lib.wait_Sleep(3000);
                 driver.findElement(AppElements.Delete_OK).click();
	        }
	        
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"))) {
	             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_file_termdef.xlsx"));
                 driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	             Lib.wait_Sleep(3000);
                 driver.findElement(AppElements.Delete_OK).click();
	        }
	        
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"))) {
	             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Data_folder_02/UI_Data_file_copytermdef.xlsx"));
                 driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	             Lib.wait_Sleep(3000);
                 driver.findElement(AppElements.Delete_OK).click();
	        }
	        
//              Lib.SwitchApp(driver);
//      		  driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_09A_Data_file_Database_Menu_list(){
		try {
		     Lib.wait_Sleep(2000);
		     if (Lib.isExist(Lib.DirFile(driver, "Data/Database/Database/Testing"))) {
				  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
				  driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Delete).click();
				  Lib.wait_Sleep(2000);
				  driver.findElement(AppElements.Delete_OK).click();
			}
			 //step01
		     
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_NewDiagram).click();
		     Lib.wait_Sleep(3000);
			 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_Input_Field, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_OK, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDiagram_Cancel, true);
//          Lib.chkTextContent(driver, AppElements.NewDiagram_MSG_Content , AppBChkPoint.Please_enter_a_database_name);

			 driver.findElement(AppElements.NewDiagram_Input_Field).clear();
			 driver.findElement(AppElements.NewDiagram_Input_Field).sendKeys("Testing");
			 driver.findElement(AppElements.NewDiagram_OK).click();
		     Lib.wait_Sleep(WaitTime);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database/Database/Testing") , true);     
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_import, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_AddTable, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Checkin, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Database_Menu_Discard, true);
			 Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Database_Menu_import);
		     Lib.wait_Sleep(WaitTime);
//			 Lib.ChkProperty_Reg(driver, AppElements.RIGHTCLICK_Database_Menu_import, "class", "menu-Active");
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_import).click();
			 Lib.wait_Sleep(3000);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Password , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Password , true);
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType, "value", "mysql");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "");
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Close , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_TestConnection , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Generate , true);
			 
			 //step05
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_DatabaseName).sendKeys("DEV_QUEUE_CO");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Host).sendKeys("192.168.0.23");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Port).sendKeys("3306");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_UserName).sendKeys("dev_queue_co");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Password).sendKeys("123456");
			 
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "DEV_QUEUE_CO");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "192.168.0.23");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "3306");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "dev_queue_co");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "123456");
			 
			 driver.findElement(AppElements.ImportDataBaseWindow_Generate).click();

			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.WarningMessage_content, AppBChkPoint.ErrorMsg_All_tables_have_been_added_successfully);

			 //step06
			 driver.findElement(AppElements.WarningMessage_OK).click();
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Train).click();
			 if (!Lib.isExist(driver, AppElements.Console_Window)) {
				 driver.findElement(AppElements.Btn_Console_op).click();
			}
			 Lib.wait_Sleep(2000);
			 Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST");
			 Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST]");
			 //step07
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.chkIsDisplayed(driver, AppElements.QHIST , true);
			 Lib.chkIsDisplayed(driver, AppElements.QINFO , true);
			 Lib.chkIsDisplayed(driver, AppElements.QSYNC , true);
			 Lib.chkIsDisplayed(driver, AppElements.QUEUEDATA , true);
			 Lib.chkIsDisplayed(driver, AppElements.REQINDEX , true);
			 Lib.chkIsDisplayed(driver, AppElements.test , true);
			 Lib.chkIsDisplayed(driver, AppElements.TRXCACHE , true);
             WebElement QhistTitle = driver.findElement(AppElements.QHIST).findElement(By.xpath(".//td[text()='QHIST']"));
             Lib.dragAndDropBy(driver, QhistTitle , 359, 367);
             
			 Lib.wait_Sleep(3000);
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetLeft", "570");
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetTop", "376");
             Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Data/Database/Database/Testing").click();
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Layout).click();
			 //step08
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_AddTable).click();
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.EditTable_Title , true);
			 //step09
			 driver.findElement(AppElements.EditTable_btn_Cancel).click();
			 Lib.chkIsDisplayed(driver, AppElements.EditTable_Title , false);
			 //step10
             Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Checkin).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.CheckIn_MSG_Content, AppBChkPoint.CheckinMsg_Please_enter_your_notes_for_the_version);
			 Lib.chkIsDisplayed(driver, AppElements.CheckIn_input_field , true);
			 Lib.chkIsDisplayed(driver, AppElements.CheckIn_OK , true);
			 Lib.chkIsDisplayed(driver, AppElements.CheckIn_Cancel , true);
			 //step11
			 driver.findElement(AppElements.CheckIn_Cancel).click();
			 Lib.chkIsDisplayed(driver, AppElements.CheckIn_input_field , false);
			 //step12
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Discard).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.Discard_MSG_Content, AppBChkPoint.DiscardMsg_Are_you_sure_to_discard_the_change_on_Testing);

			 //step13
			 driver.findElement(AppElements.Discard_Cancel).click();
			 Lib.chkIsDisplayed(driver, AppElements.Discard_MSG_Content , false);
			 //step14
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Database_Menu_History).click();
			 Lib.wait_Sleep(WaitTime);
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
		      String[] TableColumExpecteds = new String[4];
		      TableColumExpecteds[0] = "Id";
		      TableColumExpecteds[1] = "UserId";
		      TableColumExpecteds[2] = "Time";
		      TableColumExpecteds[3] = "Notes";
		      for (String TablecolumExpected : TableColumExpecteds) {
		      	Lib.chkIsDisplayed(driver, By.xpath("//table[@class='hi_table']//td[text()='"+ TablecolumExpected +"']"), true);
		      }
//		      //点击表格第一行数据
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
		      
		      //step15
			  driver.findElement(AppElements.Version_History_Close).click();
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, false);
			  //step16
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
			  driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Delete).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_Database);
			  driver.findElement(AppElements.Delete_OK).click();
			  Lib.wait_Sleep(WaitTime);
			  Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"), false);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Data/Database/Testing"))) {
				  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Database/Database/Testing"));
				  driver.findElement(AppElements.RIGHTCLICK_Database_Menu_Delete).click();
				  Lib.wait_Sleep(2000);
				  driver.findElement(AppElements.Delete_OK).click();
			}

			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_09B_Data_file_Sheet_Menu_list(){
		try {
			String[] History;
			int r = 0;
			 Lib.wait_Sleep(2000);
			  //step01
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet"));
             driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_NewSheet).click();
             Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.chkIsDisplayed(driver, AppElements.New_a_blank_excel_template_Title, true);
			 Lib.chkIsDisplayed(driver, AppElements.Nabet_input_Description, true);
			 Lib.chkIsDisplayed(driver, AppElements.Nabet_input_TemplateName, true);
			 Lib.chkIsDisplayed(driver, AppElements.Nabet_label_Description, true);
			 Lib.chkIsDisplayed(driver, AppElements.Nabet_label_TemplateName, true);
			 Lib.chkIsDisplayed(driver, AppElements.Nabet_Submit, true);
			 
             driver.findElement(AppElements.Nabet_input_TemplateName).sendKeys("Test");
             Lib.ChkProperty(driver, AppElements.Nabet_input_TemplateName, "value", "Test");
             driver.findElement(AppElements.Nabet_Submit).click();
			 Lib.wait_Sleep(2000);
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Sheet/Test"), true);
			 //step02
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_Train, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_Checkin, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_Discard, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_History, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_Delete, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Sheet_Menu_Download, true);
			 //step03
             driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Train).click();
			 Lib.wait_Sleep(2000);
             if (!Lib.isExist(driver, AppElements.Console_Window)) {
            	 Actions actions = new Actions(driver);
            	 actions.click(driver.findElement(AppElements.Btn_Console_op));
            	 actions.perform();       
			}
			 Lib.wait_Sleep(2000);
             Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST");
             if (Lib.isExist(driver, AppElements.tab_Error_Cl)) {
               	 driver.findElement(AppElements.tab_Error_Cl).click();
			}else {
           	     driver.findElement(AppElements.tab_Error_Op).click();
			}
            
             
             Lib.CheckConsoleErrorMsg(driver, "trained [uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST]");
             //step04
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
             driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Discard).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.Discard_MSG_Content, AppBChkPoint.DiscardMsg_Are_you_sure_to_discard_the_change_on_Test);
			 //step05
			 driver.findElement(AppElements.Discard_Cancel).click();
			 Lib.chkIsDisplayed(driver, AppElements.Discard_MSG_Content, false);
			 
			 //step06
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
              driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Checkin).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkTextContent(driver, AppElements.CheckIn_MSG_Content, AppBChkPoint.CheckinMsg_Please_enter_your_notes_for_the_version);
			  Lib.chkIsDisplayed(driver, AppElements.CheckIn_Cancel, true);
			  Lib.chkIsDisplayed(driver, AppElements.CheckIn_OK, true);
			  //step07
              driver.findElement(AppElements.CheckIn_Cancel).click();
			  Lib.chkIsDisplayed(driver, AppElements.CheckIn_MSG_Content, false);
			 
			 //step08
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
			  driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_History).click();
			  Lib.wait_Sleep(2000);
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
		      String[] TableColumExpecteds = new String[4];
		      TableColumExpecteds[0] = "Id";
		      TableColumExpecteds[1] = "UserId";
		      TableColumExpecteds[2] = "Time";
		      TableColumExpecteds[3] = "Notes";
		      for (String TablecolumExpected : TableColumExpecteds) {
		      	Lib.chkIsDisplayed(driver, By.xpath("//table[@class='hi_table']//td[text()='"+ TablecolumExpected +"']"), true);
		      }
		      
		      History = new String[]{"1","uitest@cyberobject.com.cn","~","Create new file SheetTest.xlsx"}; 
              r = Lib.GetTableRowById(driver.findElement(AppElements.Table_Version_History), "1");
		      for (int j = 0; j < History.length; j++) {
		    	  if (History[j].equals("~")) {
					continue;
				  }
		    	  Lib.assertEquals(Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History),r, j+1).getText(), History[j]);
			  }
		      
		         //step09
				 driver.findElement(AppElements.Version_History_Close).click();
				 Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, false);
				 //step10
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
				 driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Download).click();
				 Lib.wait_Sleep(3000);
                 Lib.isFileDownloaded(downloadpath, "Test");
                 //step11_12
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
				 driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Delete).click();
				 Lib.wait_Sleep(2000);
				 Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
				 //step13
				 driver.findElement(AppElements.Delete_OK).click();
				 Lib.assertFalse(Lib.isExist(Lib.DirFile(driver, "Data/Sheet/Test")));
	 
		}
		catch(Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Data/Sheet/Test"))) {
				  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Sheet/Test"));
				  driver.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Delete).click();
				  Lib.wait_Sleep(2000);
				  driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		finally {
			MMDriver.softAssert.assertAll();
		}

	}
	
	@Test
	public void APP_GUI_09C_Data_file_HTTP_Services_Menu_list(){
		try {
			Lib.checkPageIsReady(driver);
			    //step01
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service"));
			    driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
			    Lib.wait_Sleep(3000);
				Lib.SwitchToFrame(driver, "moduleFrame");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_Addfromwebserviceurl, "value", "http://www.dneonline.com/calculator.asmx?wsdl");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_OK, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);
	            driver.findElement(AppElements.AddAwebservice_input_WebserviceName).sendKeys("TestWeb");
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "TestWeb");
			    driver.findElement(AppElements.AddAwebservice_button_OK).click();
			    Lib.wait_Sleep(3000);

			    driver.findElement(AppElements.AddAwebservice_button_Add).click();
			    
				Lib.SwitchToFrame(driver, "moduleFrame");
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/TestWeb"), true);
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service"));
			    driver.findElement(AppElements.RIGHTCLICK_RESTServices_Menu_AddRestservice).click();
				Lib.SwitchToFrame(driver, "externalAppIframe");
				
				driver.findElement(AppElements.AddAHTTP$HTTPS_API_input_ServiceName).sendKeys("TestRest");
	            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_ServiceName, "value", "TestRest");

				driver.findElement(AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL).
				sendKeys("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
	            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL, "value", "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");

				driver.findElement(AppElements.AddAHTTP$HTTPS_API_button_Submit).click();
				Lib.SwitchToFrame(driver, "moduleFrame");
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/TestRest"), true);
	            //step02
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service/TestWeb"));
			    driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();
				Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
				//step03
				driver.findElement(AppElements.Delete_OK).click();
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/TestWeb"), false);
				//step04
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/Data Service/TestRest"));
			    driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();
                //step05
				driver.findElement(AppElements.Delete_OK).click();
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/Data Service/TestRest"), false);

		}
		catch(Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Data/Data Service/TestRest"))) {
			    driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			if (Lib.isExist(Lib.DirFile(driver, "Data/Data Service/TestWeb"))) {
			    driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		finally {
			MMDriver.softAssert.assertAll();
		}

	}
	

	@Test
	public void APP_GUI_10_Document_Information(){
		try {
			 int i;
			 int row;
			 Lib.checkPageIsReady(driver);
			 //step01
			 driver.findElement(AppElements.LeftTree_Document).click();
			 Lib.wait_Sleep(WaitTime);
			 FileListTable fileListTable = new FileListTable(driver, "filelist");
			String[][] ExecptedArray =new String [][]{{"FileName", "Modified", "Modifier", "Creator"},
				 {"UI_Doc_folder_01", "01-11-19 02:17:17","~","~"},
				 {"UI_Doc_folder_02", "01-11-19 02:17:17","~","~"},
				 {"UI_Doc_file_testrex.rex", "01-11-19 02:17:17","uitest","uitest"},
				 {"UI_Doc_file_testucx.ucx", "01-11-19 02:17:17","uitest","uitest"}};
				 for (i = 0; i < ExecptedArray.length ; i++) {
					 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
					 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
					 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
					 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
				 };
  
			 //step02
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Doc_folder_01"));
	  		 Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Doc_folder_01"), false);
	  		 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Doc_folder_01"), false);

	  		 //step03
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Doc_file_testrex.rex"));
	  		 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Doc_file_testrex.rex"), true);
		     //step04
			 Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Doc_file_testucx.ucx"));
	  		 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Doc_file_testucx.ucx"), true);
	  		 //step05
	  		 Lib.DirFile(driver, "Document/UI_Doc_folder_01").click();
		     Lib.wait_Sleep(WaitTime);
			 ExecptedArray = new String[][] {{"FileName", "Modified", "Modifier", "Creator"},
			 {"UI_Doc_file_JumpFlowOne.rex", "01-11-19 02:17:17", "uitest", "uitest"}};	     
			 for (i = 0; i < ExecptedArray.length ; i++) {
			 	 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
			 	 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//			 	 Lib.assertEquals(fileListTable.getModifiedData(i+1), ExecptedArray[i][1]);
			 	 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
			 	 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
		     
	  		 //step06
			 Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex").click();
	         Lib.wait_Sleep(3000);
	         FlowUnit flowUnit = new FlowUnit(driver);
	         Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("Jump Start Flow"), true);
	         Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("Flow End"), true);
	         Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("(<gender>==<male>)"), true);
             //step07
             Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Script_file_JumpFlowEnd.ucx").click();
			 UCXUnit ucxUnit=new UCXUnit(driver);
	         Lib.chkIsDisplayed(driver, ucxUnit.GetObjByContent("1.3.1.1.1", "go to Jump Start Flow in other drink.rex"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_11_Document_Menu_list(){
		try {
	         Lib.wait_Sleep(2000);
			 //step01
             Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_folder, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);

			 //step02
			 if (!Lib.isExist(driver, AppElements.Console_Window)) {
				  driver.findElement(AppElements.Btn_Console_op).click();
			 }
// 		     Lib.Clear_ConsoleMsg(driver);
			 //step03
			 Lib.wait_Sleep(WaitTime);
 		     Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
			 Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);

		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
	         Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex");
		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);
		     //step04
// 		     Lib.Clear_ConsoleMsg(driver);
 		     Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_folder).click();
			 
	         Lib.wait_Sleep(3000);
			 Lib.chkTextContent(driver,AppElements.NewFolder_MSG_Content,AppBChkPoint.Please_enter_a_folder_name);
             Lib.ChkProperty(driver, AppElements.NewFolder_Input_Field, "value", "");
			 Lib.chkIsDisplayed(driver, AppElements.NewFolder_Cancel, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewFolder_OK, true);
			 //step05
			 driver.findElement(AppElements.NewFolder_Input_Field).click();
			 driver.findElement(AppElements.NewFolder_Input_Field).clear();
			 driver.findElement(AppElements.NewFolder_Input_Field).sendKeys("UI_Doc_folder_add");
             driver.findElement(AppElements.NewFolder_OK).click();			 

		     Lib.wait_Sleep(WaitTime);
		     Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_add"), true);
		     //step06
		     Lib.wait_Sleep(WaitTime);
 		     Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
		     Lib.wait_Sleep(3000);
		     Lib.chkTextContent(driver, AppElements.NewDoc_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_Cancel, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_OK, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_doc, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_script, true);

		     //step07
			 driver.findElement(AppElements.NewDoc_Input_Field).click();
			 driver.findElement(AppElements.NewDoc_Input_Field).clear();
			 driver.findElement(AppElements.NewDoc_Input_Field).sendKeys("UI_Doc_file_script");
			 driver.findElement(AppElements.NewDoc_radio_script).click();
			 driver.findElement(AppElements.NewDoc_OK).click();
		     Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_file_script.ucx"), true);
             //step08
 		     Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
		     Lib.wait_Sleep(3000);
		     Lib.chkTextContent(driver, AppElements.NewDoc_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_Cancel, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_OK, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_doc, true);
			 Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_script, true);
		     //step09
			 driver.findElement(AppElements.NewDoc_Input_Field).click();
			 driver.findElement(AppElements.NewDoc_Input_Field).clear();
			 driver.findElement(AppElements.NewDoc_Input_Field).sendKeys("UI_Doc_file_add");
			 driver.findElement(AppElements.NewDoc_radio_doc).click();
			 driver.findElement(AppElements.NewDoc_OK).click();
			 Lib.wait_Sleep(2000);
		     Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_file_add.rex"), true);

		     //step10
 		     Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Upload_Doc).click();
		     Lib.wait_Sleep(3000);

		     //step11
		     AutoWin.winActivate("打开");
			 Lib.wait_Sleep(2000);
			 AutoWin.controlFocus("打开", "", "Edit1");
			 AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload flow.rex");
			 Lib.wait_Sleep(1000);
		     AutoWin.controlClick("打开", "", "Button1");
		     Lib.wait_Sleep(3000);
	         Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_TEST_Upload flow.rex"), true);
		     
	         //step12~16
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_script.ucx"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_script.ucx"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
	         
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_add"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_add"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
	         
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_add.rex"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_add.rex"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }

	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_TEST_Upload flow.rex"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_TEST_Upload flow.rex"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
	 
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_script.ucx"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_script.ucx"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
	         
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_add"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_add"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
	         
	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_add.rex"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_add.rex"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }

	         if (Lib.isExist(Lib.DirFile(driver, "Document/UI_TEST_Upload flow.rex"))) {
	 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_TEST_Upload flow.rex"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(3000);
				 driver.findElement(AppElements.Delete_OK).click();
			 }
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_12_Document_folder_Information(){
		try {
			 int i;
			 int row;
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.DirFile(driver, "Document/UI_Doc_folder_01").click();
			 Lib.wait_Sleep(WaitTime);
			 FileListTable fileListTable = new FileListTable(driver, "filelist");
			 String[][] ExecptedArray =new String [][]{{"FileName", "Modified", "Modifier", "Creator"},
				 {"UI_Doc_file_JumpFlowOne.rex", "01-11-19 02:17:17","uitest","uitest"},
				 {"UI_Script_file_JumpFlowEnd.ucx", "01-11-19 02:17:17","uitest","uitest"}};
				 for (i = 0; i < ExecptedArray.length ; i++) {
					 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
					 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
					 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
					 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
				 };
			 
		  	 //step02
			  Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Script_file_JumpFlowEnd.ucx")); 
	  		  Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Script_file_JumpFlowEnd.ucx"), true);
		     //step03   
	  		  fileListTable.getRowElement("UI_Script_file_JumpFlowEnd.ucx").click();
			  Lib.wait_Sleep(3000);
			  
			  UCXUnit ucxUnit=new UCXUnit(driver);
		      Lib.chkIsDisplayed(driver, ucxUnit.GetObjByContent("1.3.1.1.1", "go to Jump Start Flow in other drink.rex"), true);

	  		  Lib.SwitchToFrame(driver, "moduleFrame");
	  		  //step04
			  Lib.DirFile(driver, "Document/UI_Doc_folder_01").click();
		      Lib.wait_Sleep(3000);
			  Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Doc_file_JumpFlowOne.rex")); 
	  		  Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Doc_file_JumpFlowOne.rex"), true);
	  		  //step05
	  		  fileListTable.getRowElement("UI_Doc_file_JumpFlowOne.rex").click();
			  Lib.wait_Sleep(3000);
			  FlowUnit flowUnit = new FlowUnit(driver);
		      Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("Jump Start Flow"), true);
		      Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("Flow End"), true);
		      Lib.chkIsDisplayed(driver, flowUnit.GetObjByContent("(<gender>==<male>)"), true);
	  		  Lib.SwitchToFrame(driver, "moduleFrame");
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_13_Document_folder_Menu_list(){
		try {
			 int i;
			 Lib.wait_Sleep(2000);
			 //step01
             Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Rename , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Delete , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Copy , true);

			 //step02
			 if (!Lib.isExist(driver, AppElements.Console_Window)) {
				  driver.findElement(AppElements.Btn_Console_op).click();
			}
			 //step03
			 Lib.wait_Sleep(2000);
 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
			 Lib.wait_Sleep(3000);
	         Lib.CheckConsoleMsg(driver, "Start training doc UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex");
	         
			 Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
			 Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex");
			 Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);

		     //step04
			 Lib.wait_Sleep(2000);
 		     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_folder).click();
		     Lib.chkTextContent(driver, AppElements.NewFolder_MSG_Content, AppBChkPoint.Please_enter_a_folder_name);
		     Lib.chkIsDisplayed(driver, AppElements.NewFolder_Cancel , true);  
		     Lib.chkIsDisplayed(driver, AppElements.NewFolder_OK , true); 

		     //step05
		     Lib.wait_Sleep(2000);
			 driver.findElement(AppElements.NewFolder_Input_Field).click();
			 driver.findElement(AppElements.NewFolder_Input_Field).clear();
			 driver.findElement(AppElements.NewFolder_Input_Field).sendKeys("UI_test_folder_01");
			 driver.findElement(AppElements.NewFolder_OK).click();
		     Lib.wait_Sleep(WaitTime);
		     Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_01"), true);
		     //step06
			 driver.findElement(AppElements.LeftTree_Document).click();
	         Lib.wait_Sleep(WaitTime);
			 FileListTable fileListTable = new FileListTable(driver, "filelist");
			 String [][] ExecptedArray = {{"FileName", "Modified", "Modifier", "Creator"},
					 {"UI_Doc_folder_01", "01-11-19 02:17:17", "uitest", "uitest"}
			 }; 	 
			 int row = 0;
			 for (i = 0; i < ExecptedArray.length ; i++) {
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//				 Lib.assertEquals(fileListTable.getModifiedData(i+1), ExecptedArray[i][1]);
//				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
//				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
             
			    //step07
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Rename).click();
				Lib.wait_Sleep(3000);

				Lib.chkTextContent(driver,AppElements.Rename_MSG_Content, AppBChkPoint.Please_enter_the_new_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Rename_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Rename_Cancel, true);
                //step08
				driver.findElement(AppElements.Rename_Input_Field).clear();
				driver.findElement(AppElements.Rename_Input_Field).sendKeys("UI_test_folder_new");
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Rename_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_folder_01/UI_test_folder_new"), true);

				//step09
				Lib.wait_Sleep(2000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Copy).click();
				Lib.wait_Sleep(2000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Paste, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Delete, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Copy, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Rename, true);
	            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Newdoc, true);
		        Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_folder, true);

	            //step10
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
				Lib.wait_Sleep(3000);

				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step11
				driver.findElement(AppElements.Paste_OK).click();
//				driver.findElement(AppElements.Paste_Cancel).click();

				//pending 
				driver.findElement(AppElements.Paste_Cancel).click();
//				driver.findElement(AppElements.Paste_Cancel).click();
		        Lib.CheckConsoleMsg(driver, "Failed to copy files.");
		        Lib.CheckConsoleMsg(driver, 
		        "The destination folder is a subfolder of the source folder");
		          
				//step12

				Lib.wait_Sleep(1000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step13
				driver.findElement(AppElements.Paste_Cancel).click();
				Lib.chkIsDisplayed(driver, AppElements.Input_Field, false);
				//step14
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_02"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step15
				driver.findElement(AppElements.Paste_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_folder_02/UI_Doc_folder_01"), true);

				//step16
				Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step17
				driver.findElement(AppElements.Paste_OK).click();
//				driver.findElement(AppElements.Paste_Cancel).click();
		        Lib.CheckConsoleMsg(driver, "Folder UI_Doc_folder_01 already exists! if you want to overwrite it, please delete it first.");
//		        Lib.chkIsDisplayed(driver, AppElements.WarningMessage_content, true);
//				driver.findElement(AppElements.WarningMessage_OK).click();
				//step18
//				Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
//				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
//				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_folder_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				driver.findElement(AppElements.Paste_Input_Field).clear();
				driver.findElement(AppElements.Paste_Input_Field).sendKeys("UI_Doc_folder_03");
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Paste_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_folder_03"), true);
				//step19
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.NewDoc_MSG_Content,AppBChkPoint.Please_enter_the_file_name);
				Lib.chkIsDisplayed(driver, AppElements.NewDoc_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.NewDoc_Cancel, true);
				//step20
				driver.findElement(AppElements.NewDoc_Input_Field).clear();
				driver.findElement(AppElements.NewDoc_Input_Field).sendKeys("UI_Doc_file_script");
				driver.findElement(AppElements.NewDoc_radio_script).click();
				driver.findElement(AppElements.NewDoc_OK).click();
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"), true);
                //step21
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.NewDoc_MSG_Content,AppBChkPoint.Please_enter_the_file_name);
				Lib.chkIsDisplayed(driver, AppElements.NewDoc_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.NewDoc_Cancel, true);
				//step22
				driver.findElement(AppElements.NewDoc_Input_Field).clear();
				driver.findElement(AppElements.NewDoc_Input_Field).sendKeys("UI_Doc_file_fm");
				driver.findElement(AppElements.NewDoc_radio_doc).click();
				driver.findElement(AppElements.NewDoc_OK).click();
				Lib.wait_Sleep(2000);
				Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"), true);
				//step23
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Upload_Doc).click();
				//step24
				Lib.wait_Sleep(2000);
		        AutoWin.winActivate("打开");
			    Lib.wait_Sleep(2000);
			    AutoWin.controlFocus("打开", "", "Edit1");
			    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload flow.rex");
			    Lib.wait_Sleep(1000);
		        AutoWin.controlClick("打开", "", "Button1");
		        Lib.wait_Sleep(3000);
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"), true);
	            //step25
		        Lib.wait_Sleep(2000);
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
		        Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Delete_MSG_Content,AppBChkPoint.Are_you_sure_you_want_to_remove_this_folder);
//				There are files checking out by you. Are you sure you want to remove this folder?
				
				//step26
				driver.findElement(AppElements.Delete_OK).click();
		        Lib.wait_Sleep(3000);
	            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_01/UI_test_folder_new"), false);

	            //step27
	            Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex").click();
	            //checkin: tree-icon tree-file icon_rex
                Lib.ChkProperty_Reg(driver, 
                Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex").findElement(By.xpath(".//descendant::span[5]")), 
                	"class", "tree-icon tree-file icon_rex");
                //checkout: tree-icon tree-file icon_unlock_rex
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Checkout).click();
                Lib.ChkProperty_Reg(driver, 
                Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex").findElement(By.xpath(".//descendant::span[5]")), 
                	"class", "tree-icon tree-file icon_unlock_rex");
//				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex"));
//				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
//				driver.findElement(AppElements.Discard_OK).click();

				//step28
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_03"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				    Lib.wait_Sleep(3000);
					Lib.chkTextContent(driver,AppElements.Delete_MSG_Content,AppBChkPoint.There_are_files_checking_out_by_you$$$remove_this_folder);
					//step29
					driver.findElement(AppElements.Delete_OK).click();
		            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_03"), false);
				}
				//step30
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				    Lib.wait_Sleep(3000);
					driver.findElement(AppElements.Delete_OK).click();
		            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"), false);
				}
				//step31
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				    Lib.wait_Sleep(3000);
					driver.findElement(AppElements.Delete_OK).click();	
		            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"), false);
				}
				//step32
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				    Lib.wait_Sleep(3000);
					driver.findElement(AppElements.Delete_OK).click();
		            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"), false);
				}
				//step33
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_02/UI_Doc_folder_01"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_02/UI_Doc_folder_01"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				    Lib.wait_Sleep(3000);
					driver.findElement(AppElements.Delete_OK).click();	
		            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Document/UI_Doc_folder_02/UI_Doc_folder_01"), false);
				}
					//discard the file
//				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex").findElement(By.xpath(".//descendant::span[5][contains(@class,'tree-icon tree-file icon_unlock_rex')]")))) {
//					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex"));
//					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
//					driver.findElement(AppElements.Discard_OK).click();
//				}

//				Document/UI_Doc_folder_01/UI_test_folder_01
//				Document/UI_Doc_folder_02/UI_Doc_folder_01
//				Document/UI_Doc_folder_01/UI_Doc_file_script.ucx
//	            Document/UI_Doc_folder_01/UI_TEST_Upload sheet.xlsx
//				Document/UI_Doc_folder_01/UI_Doc_file_fm.rex
//				Document/UI_Doc_folder_03
//				Document/UI_Doc_folder_01/UI_test_folder_new
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_03"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			    Lib.wait_Sleep(3000);
				//step30
				driver.findElement(AppElements.Delete_OK).click();
			}
			//step31
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_fm.rex"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			//step32
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_TEST_Upload flow.rex"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();	
			}
			//step33
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_Doc_file_script.ucx"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			//step34
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_02/UI_Doc_folder_01"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_02/UI_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();	
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_new"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();	
			}
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_01"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_01/UI_test_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
			    Lib.wait_Sleep(3000);
				driver.findElement(AppElements.Delete_OK).click();	
			}
			
//			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex").findElement(By.xpath(".//descendant::span[5][contains(@class,'tree-icon tree-file icon_unlock_rex')]")))) {
//				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_folder_03/UI_Doc_file_JumpFlowOne.rex"));
//				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
//				driver.findElement(AppElements.Discard_OK).click();
//			}
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void APP_GUI_14_Document_file_Information(){
		try {
			Lib.wait_Sleep(2000);
			 //step01
             Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex").click();
			 //step02
			 Lib.SwitchToFrame(driver, "visio_file_iframe");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_View, "class", "geLabel");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Zoom, "class", "geLabel");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Zoomin, "class", "geButton");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Zoomout, "class", "geButton");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_REXUndo, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_REXRedo, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Delete, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_ToFront, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_ToBack, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_FillColor, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_LineColor, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Shadow, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Connection, "class", "geButton mxDisabled");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Waypoints, "class", "geButton mxDisabled");

			 //step03
			 Lib.SwitchToFrame(driver, "moduleFrame");
             Lib.DirFile(driver, "Document/UI_Doc_file_testucx.ucx").click();
			 Lib.wait_Sleep(2000);
             //step04
			 Lib.SwitchToFrame(driver, "ucx_file_iframe");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Chooseheading, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_FontFamilyDefault, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_FontSizeDefault, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Bold, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Italic, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Link, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_BulletedList, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_NumberedList, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Insertimage, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Blockquote, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_Inserttable, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_UCXUndo, "aria-disabled", "true");
			 Lib.ChkProperty(driver, AppElements.Tool_bar_UCXRedo, "aria-disabled", "true");
			 Lib.SwitchToFrame(driver, "moduleFrame");
//			 //step02
//			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
//				  driver.findElement(AppElements.Console_arrow_left).click();
//			}
//			 //step03
//		     Lib.Clear_ConsoleMsg(driver);
//			 driver.findElement(AppElements.Menu_bar_Train).click();
//		     Lib.CheckConsoleMsg(driver, "Start training doc UI_Doc_file_testrex.rex");
//
//		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Error);
//			 Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Doc_folder_01/UI_Doc_file_JumpFlowOne.rex");
//		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);
//
//			 //step04
//		     Lib.Clear_ConsoleMsg(driver);
//			 driver.findElement(AppElements.Menu_bar_Deploy).click();
//		     Lib.CheckConsoleMsg(driver, "[Start deploy]UI_Doc_file_testrex.rex");
//			 
//		     //step05
//			 driver.findElement(AppElements.Menu_bar_Test).click();
//		     Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Web, true);  
//		     Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Android, true);  
//		     Lib.chkIsDisplayed(driver, AppElements.Test_Menu_iOS, true);  
//		     Lib.chkIsDisplayed(driver, AppElements.Test_Menu_SMS, true);  
//		     Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Voice, true);
//		     
//		     //step06
//			 driver.findElement(AppElements.Menu_bar_history).click();
//			 Lib.wait_Sleep(WaitTime);
//			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
//		      String[] TableColumExpecteds = new String[4];
//		      TableColumExpecteds[0] = "Id";
//		      TableColumExpecteds[1] = "UserId";
//		      TableColumExpecteds[2] = "Time";
//		      TableColumExpecteds[3] = "Notes";
//		      for (String TablecolumExpected : TableColumExpecteds) {
//		      	Lib.chkIsDisplayed(driver, By.xpath("//span[text()='"+ TablecolumExpected +"']"), true);
//		      }
//		      //step07
//		      //点击表格第一行数据
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
//		      //step08
//			  driver.findElement(AppElements.Version_History_Show).click();
//			  Lib.wait_Sleep(3000);
////			  String current = driver.getWindowHandle();
//			  Lib.changeWindow(driver);
//			  Lib.assertEquals(driver.getTitle() , "ui_app_test/Document/UI_Doc_file_testrex.rex<version:1>");
//			  //step09
//			  driver.close();//关闭当前焦点所在的窗口
//			  driver.switchTo().window(currentWindow);
//			  driver.switchTo().frame("moduleFrame");
//		     //step10
//			  driver.findElement(AppElements.Menu_bar_history).click();
//			  Lib.wait_Sleep(WaitTime);
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//			  driver.findElement(AppElements.Version_History_CheckOut).click();
//			  Lib.wait_Sleep(2000);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Save, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
//		      //step11
//			  driver.findElement(AppElements.Menu_bar_Uncheck).click();
//			  Lib.wait_Sleep(2000);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, false);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	@Test
	public void APP_GUI_15_Document_file_Menu_list(){
		try {
			 int i;
			 String[] Historys;
			 Lib.wait_Sleep(2000);
			 //step01
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Checkout, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Rename, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_History, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Delete, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Copy, true);
			 //step02
			 if (!Lib.isExist(driver, AppElements.Console_Window)) {
				  driver.findElement(AppElements.Btn_Console_op).click();
			}
			 //step03
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
		     Lib.CheckConsoleMsg(driver, "Start training UI_Doc_file_testrex.rex");
		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
			 Lib.CheckConsoleErrorMsg(driver, "Start training UI_Doc_file_testrex.rex");
		     Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);
		     //step04
			 Lib.wait_Sleep(3000);		 
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Checkout).click();
             Lib.ChkProperty_Reg(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex").findElement(By.xpath(".//descendant::span[4]")),
         	  "class", "icon_unlock_rex");

		     //step05
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Checkin, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Rename, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_History, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Delete, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Copy, true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Discard, true);

			 //step06
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
             Lib.ChkProperty_Reg(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex").findElement(By.xpath(".//descendant::span[4]")),
         	  "class", "icon_unlock_rex");
             Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver,AppElements.Discard_MSG_Content,AppBChkPoint.Are_you_sure_to_discard_the_change_on_UI_Doc_file_testrex);
			 driver.findElement(AppElements.Discard_OK).click();
			//step07
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_History).click();
			  Lib.wait_Sleep(WaitTime);
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
		      String[] TableColumExpecteds = new String[4];
		      TableColumExpecteds[0] = "Id";
		      TableColumExpecteds[1] = "UserId";
		      TableColumExpecteds[2] = "Time";
		      TableColumExpecteds[3] = "Notes";
		      for (String TablecolumExpected : TableColumExpecteds) {
		      	Lib.chkIsDisplayed(driver, By.xpath("//td[text()='"+ TablecolumExpected +"']"), true);
		      }
		      Historys = new String[]{"1","uitest@cyberobject.com.cn","~","Create new file UI_Doc_file_testrex.rex."}; 
		      int row = Lib.GetTableRowById(driver.findElement(AppElements.Table_Version_History), "1");
		      for (int j = 0; j < Historys.length; j++) {
		    	  if (Historys[j].equals("~")) {
					continue;
				  }
		    	  
		    	  Lib.assertEquals(Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History),row, j+1).getText(), Historys[j]);
			  }
		      //step08
			  driver.findElement(AppElements.Version_History_Close).click();
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, false);
		      //step09
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex.rex"));
			  driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Copy).click();
			  Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document"));
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train , true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc , true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Paste, true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_folder , true);			  
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc , true);
			  //step10
			  driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Paste).click();
			  Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_file_name);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step11
				driver.findElement(AppElements.Paste_Input_Field).clear();
				driver.findElement(AppElements.Paste_Input_Field).sendKeys("UI_Doc_file_testrex.rex");
				driver.findElement(AppElements.Paste_OK).click();
				
				driver.findElement(AppElements.Paste_Cancel).click();

				
				Lib.wait_Sleep(2000);
				Lib.CheckConsoleMsg(driver, "UI_Doc_file_testrex.rex already exists! if you want to overwrite it, please delete it first.");
	            //step12
//	            driver.findElement(AppElements.Err_Message_OK).click();
			    Lib.wait_Sleep(WaitTime);
			    Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Paste).click();
				Lib.wait_Sleep(3000);
			    Lib.chkTextContent(driver,AppElements.Paste_MSG_Content,AppBChkPoint.Please_enter_the_file_name);
			    Lib.chkIsDisplayed(driver, AppElements.Paste_Input_Field, true);
				Lib.chkIsDisplayed(driver, AppElements.Paste_Cancel, true);
				//step13
				driver.findElement(AppElements.Paste_Input_Field).clear();
				driver.findElement(AppElements.Paste_Input_Field).sendKeys("UI_Doc_file_testrex_copy.rex");
				driver.findElement(AppElements.Paste_OK).click();
			     Lib.wait_Sleep(2000);
			     Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_file_testrex_copy.rex"), true);
				//step14
			     Lib.wait_Sleep(1000);
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex_copy.rex"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Rename).click();
			     Lib.wait_Sleep(3000);
			     Lib.chkTextContent(driver,AppElements.Rename_MSG_Content , AppBChkPoint.Please_enter_the_new_file_name);
			     Lib.chkIsDisplayed(driver, AppElements.Rename_Input_Field, true);
			     Lib.chkIsDisplayed(driver, AppElements.Rename_Cancel, true);
			     Lib.ChkProperty(driver, AppElements.Rename_Input_Field, "value", "UI_Doc_file_testrex_copy.rex");
			     //step15
			     driver.findElement(AppElements.Rename_Input_Field).clear();
			     driver.findElement(AppElements.Rename_Input_Field).sendKeys("UI_Doc_file_testrex_new.rex");
			     Lib.wait_Sleep(WaitTime);
			     driver.findElement(AppElements.Rename_OK).click();
			     Lib.wait_Sleep(3000);
			     Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_file_testrex_new.rex"), true);
				//step16
			     Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document"));
				 driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
			     Lib.wait_Sleep(3000);
			     Lib.chkTextContent(driver,AppElements.NewDoc_MSG_Content,AppBChkPoint.Please_enter_the_file_name);
			     Lib.chkIsDisplayed(driver, AppElements.NewDoc_Input_Field, true);
			     Lib.chkIsDisplayed(driver, AppElements.NewDoc_Cancel, true);
			     Lib.chkIsDisplayed(driver, AppElements.NewDoc_OK, true);
			     Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_doc, true);
			     Lib.chkIsDisplayed(driver, AppElements.NewDoc_radio_script, true);
			     Lib.ChkProperty(driver, AppElements.NewDoc_Input_Field, "value", "");
//		      //点击表格第一行数据
//		      Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
//		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
//
//			  driver.findElement(AppElements.Version_History_Show).click();
//			  Lib.wait_Sleep(3000);
////			  String current = driver.getWindowHandle();
//			  Lib.changeWindow(driver);
//			  Lib.assertEquals(driver.getTitle() , "ui_app_test/Data/UI_Data_file_nidef.xlsx<version:1>");
//
//			  driver.close();//关闭当前焦点所在的窗口
//			  driver.switchTo().window(currentWindow);
//			  driver.switchTo().frame("moduleFrame");//回到原来页面

		     //step17
		     driver.findElement(AppElements.NewDoc_Input_Field).clear();
		     driver.findElement(AppElements.NewDoc_Input_Field).sendKeys("UI_Doc_file_delete");
		     Lib.wait_Sleep(1000);
		     
		     
		     driver.findElement(AppElements.NewDoc_OK).click();
		     Lib.wait_Sleep(3000);
		     Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Doc_file_delete.rex"), true);
             //step18
		     Lib.DirFile(driver, "Document").click();
		     Lib.wait_Sleep(3000);
		     FileListTable fileListTable = new FileListTable(driver, "filelist");
			 String [][] ExecptedArray = {{"FileName", "Modified", "Modifier", "Creator"},
					 {"UI_Doc_folder_01", "01-11-19 02:17:17", "~", "~"},
					 {"UI_Doc_folder_02", "~", "~", "~"},
					 {"UI_Doc_file_delete.rex", "~", "uitest", "uitest"},
					 {"UI_Doc_file_testrex.rex", "~", "uitest", "uitest"},
					 {"UI_Doc_file_testrex_new.rex", "~", "uitest", "uitest"}
			 }; 	 
			 row = 0;
			 for (i = 0; i < ExecptedArray.length ; i++) {
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//				 Lib.assertEquals(fileListTable.getModifiedData(i+1), ExecptedArray[i][1]);
				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };

		     //step19
			 Lib.mouseMoveToElement(driver,fileListTable.getRowElement("UI_Doc_file_delete.rex"));
//			 Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Doc_file_delete.rex") , true);
			 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Doc_file_delete.rex") , true);
			 //step20
			 driver.findElement(AppElements.FileList_Delete("UI_Doc_file_delete.rex")).click();
		     Lib.wait_Sleep(3000);
		     Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
		     //step21
		     driver.findElement(AppElements.Delete_OK).click();
		     Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Doc_file_delete.rex") , false);
			 //step22
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex_new.rex"));
		     driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
		     Lib.wait_Sleep(2000);
		     driver.findElement(AppElements.Delete_OK).click();

			 if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_testrex_copy.rex"))) {
					 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex_copy.rex"));
				     driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				     Lib.wait_Sleep(2000);
				     driver.findElement(AppElements.Delete_OK).click();
			 }
		     
//		     Document/UI_Doc_file_delete.rex
//		     Document/UI_Doc_file_testrex_new.rex
//		     Document/UI_Doc_file_testrex_copy.rex
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_delete.rex"))) {
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_delete.rex"));
			     driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(2000);
			     driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_testrex_new.rex"))) {
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex_new.rex"));
			     driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(2000);
			     driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Doc_file_testrex_copy.rex"))) {
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Doc_file_testrex_copy.rex"));
			     driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
			     Lib.wait_Sleep(2000);
			     driver.findElement(AppElements.Delete_OK).click();
			}

			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	/**
	 * @deprecated
	 */
//	@Test
	public void APP_GUI_16_Service_and_folder_Information(){
		try {
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Service").click();
			 driver.findElement(AppElements.AppDirectoryList_Arrow("Service")).click();
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Database"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Sheet"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/REST Services"), true);
			 Lib.SwitchToFrame(driver, "externalAppIframe");
             Lib.ChkProperty(driver, By.xpath("//body"), "outerText", "");

			 //step02
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 driver.findElement(AppElements.Menu_bar_Test).click();
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Web, true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Android, true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_iOS, true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_SMS, true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Voice, true);
	         Lib.ChkProperty(driver, AppElements.Test_Menu_Web, "class", "menu-item");
	         Lib.ChkProperty(driver, AppElements.Test_Menu_iOS, "class", "menu-item menu-item-disabled");
	         Lib.ChkProperty(driver, AppElements.Test_Menu_Android, "class", "menu-item menu-item-disabled");
	         Lib.ChkProperty(driver, AppElements.Test_Menu_SMS, "class", "menu-item menu-item-disabled");
	         Lib.ChkProperty(driver, AppElements.Test_Menu_Voice, "class", "menu-item menu-item-disabled");
			 
			 //step03
			 driver.findElement(AppElements.Test_Menu_Web).click();
			 Lib.wait_Sleep(3000);
             
	 		 Lib.changeWindow(driver);
	 		 String string = driver.getCurrentUrl();
	 		 Lib.assertTrue("Popup a window", string.contains("www.cyberobject.com.cn"));
	 		 //step04
	 		 driver.close();
	 		 driver.switchTo().window(currentWindow);
	 		 driver.switchTo().frame("moduleFrame");
		     //step05
	 		 Lib.DirFile(driver, "Service/Database").click();
		     Lib.wait_Sleep(3000);
		     FileListTable fileListTable = new FileListTable(driver, "filelist");
			 String [][] ExecptedArray = {{"FileName", "Modified", "Modifier", "Creator"},
					 {"Test", "~", "uitest", "uitest"},
			 }; 	 
			 int row = 0;
			 for (int i = 0; i < ExecptedArray.length ; i++) {
				 row = fileListTable.getRowByFileName(ExecptedArray[i][0]);
				 Lib.assertEquals(fileListTable.getFileNameData(row), ExecptedArray[i][0]);
//				 Lib.assertEquals(fileListTable.getModifiedData(i+1), ExecptedArray[i][1]);
				 Lib.assertEquals(fileListTable.getModifierData(row), ExecptedArray[i][2]);
				 Lib.assertEquals(fileListTable.getCreatorData(row), ExecptedArray[i][3]);
			 };
	 		 //step06
			 Lib.mouseMoveToElement(driver , fileListTable.getRowElement("Test"));
			 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("Test") , true);
			 //step07
			 driver.findElement(AppElements.FileList_Delete("Test")).click();
		     Lib.wait_Sleep(3000);
		     Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_Database);
		     driver.findElement(AppElements.Delete_Cancel).click();
		     Lib.wait_Sleep(WaitTime);
			 Lib.chkIsDisplayed(driver, fileListTable.getRowElement("Test") , true);

			 //step09
		     Lib.DirFile(driver, "Service/Sheet").click();

			 
			 //step10~14
		     Lib.mouseMoveToElement(driver, Lib.DirFile(driver, "Service/Sheet/SheetTest"));
			 
			 
			 
			 
			 
			 
			 
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	/**
	 * @deprecated
	 */
//	@Test
	public void APP_GUI_17_Service_and_folder_Menu_list(){
		try {
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 
			 Lib.mouseRightClick(driver , Lib.DirFile(driver, "Service"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Test , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_CheckOutList , true);

			 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_Test).click();
			 Lib.wait_Sleep(2000);
			 Lib.SwitchToFrame(driver, "externalAppIframe");
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_Title, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_OutputBox_TermValue, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_OutputBox_Term, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_Output_Label, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutput, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_InputBox_TermValue, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_InputBox_Term, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_Input_Label, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInput, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_Execute, true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_GetPlan, true);
				//step03
				driver.findElement(AppElements.DIF_Testing_Page_addInput).click();
				driver.findElement(AppElements.DIF_Testing_Page_addOutput).click();
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);
				
				//step04
				driver.findElement(AppElements.DIF_Testing_Page_addInput).click();
				driver.findElement(AppElements.DIF_Testing_Page_addOutput).click();
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), true);
				
				//step05
				driver.findElement(AppElements.DIF_Testing_Page_addInputLabel_X(2)).click();
				driver.findElement(AppElements.DIF_Testing_Page_addOutputLabel_X(2)).click();
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), false);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), false);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);
				
				//step06
				driver.findElement(AppElements.DIF_Testing_Page_addInputLabel_X(1)).click();
				driver.findElement(AppElements.DIF_Testing_Page_addOutputLabel_X(1)).click();
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), false);
				Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), false);
		        Lib.SwitchToFrame(driver, "moduleFrame");
		        //step07
		        Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database"));
				driver.findElement(AppElements.RIGHTCLICK_Services_Menu_NewDatabase).click();
				Lib.wait_Sleep(3000);
				Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_a_database_name);
                Lib.chkIsDisplayed(driver, AppElements.Input_Field , true);
                Lib.chkIsDisplayed(driver, AppElements.Input_Close , true);
                Lib.chkIsDisplayed(driver, AppElements.Input_OK , true);
                
                //step08
				driver.findElement(AppElements.Input_Close).click();

				//step09
				Lib.wait_Sleep(WaitTime);
				Lib.mouseRightClick(driver, Lib.DirFile(driver , "Service/Web Services"));
				driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
				Lib.wait_Sleep(3000);
				Lib.SwitchToFrame(driver, "externalAppIframe");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_Addfromwebserviceurl, "value", "http://www.dneonline.com/calculator.asmx?wsdl");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_OK, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);
                //step10
	            driver.findElement(AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile).click();
				Lib.wait_Sleep(1000);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
	            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Upload_WSDLXSD_file, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);
	            //step11
	            driver.findElement(AppElements.AddAwebservice_button_Upload_WSDLXSD_file).click();
				Lib.wait_Sleep(WaitTime);
	            AutoWin.winWaitActive("打开");
				Lib.wait_Sleep(2000);
	    		AutoWin.controlClick("打开", "取消", "2");
	            //step12
		        Lib.SwitchToFrame(driver, "moduleFrame");
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/REST Services"));
				driver.findElement(AppElements.RIGHTCLICK_RESTServices_Menu_AddRestservice).click();
				Lib.wait_Sleep(1000);
				Lib.SwitchToFrame(driver, "externalAppIframe");
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_Title, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_ServiceName, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_DescriptionOptional, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_HTTP$HTTPS_URL, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_button_Submit, true, 3);
	            Lib.isDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, true, 3);
	            
	            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_DescriptionOptional, "value", "");
	            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_ServiceName, "value", "");
	            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL, "value", "");
	            WebList httpmethod =new WebList(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL);
	            Lib.ChkProperty(driver, httpmethod.GetOptionObj("GET"), "value", "GET");  
	            Lib.ChkProperty(driver, httpmethod.GetOptionObj("POST"), "value", "POST");  
	            Lib.ChkProperty(driver, httpmethod.GetOptionObj("PUT"), "value", "PUT");  
	            Lib.ChkProperty(driver, httpmethod.GetOptionObj("DELETE"), "value", "DELETE");  
	            httpmethod.select("GET");

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	/**
	 * @deprecated
	 */
//	@Test
	public void APP_GUI_18_Service_file_information(){
		try {
			 Lib.checkPageIsReady(driver);
			//step01
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			 Lib.wait_Sleep(2000);
			 Lib.DirFile(driver, "Service/Database/test").click();
			 Lib.wait_Sleep(3000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Import, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_TableTrain, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Layout, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			 //step02
			 if (Lib.isExist(driver , AppElements.Menu_bar_Checkout)) {
				 driver.findElement(AppElements.Menu_bar_Checkout).click();
			}
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Import, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_TableTrain, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Layout, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Save , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			 //step03
			 Lib.DirFile(driver, "Service/Database/test").click();
			 Lib.wait_Sleep(2000);

			 driver.findElement(AppElements.Menu_bar_Import).click();
			 Lib.wait_Sleep(3000);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Password , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Password , true);
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType, "value", "mysql");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "");

			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Close , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Generate , true);
			 //step04
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_DatabaseName).sendKeys("DEV_QUEUE_CO");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Host).sendKeys("192.168.0.23");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Port).sendKeys("3306");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_UserName).sendKeys("dev_queue_co");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Password).sendKeys("123456");
			 
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "DEV_QUEUE_CO");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "192.168.0.23");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "3306");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "dev_queue_co");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "123456");
			 
			 driver.findElement(AppElements.ImportDataBaseWindow_Generate).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.ErrorMsg_All_tables_have_been_added_successfully);

			 //step05
			 driver.findElement(AppElements.Err_Message_OK).click();
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.chkIsDisplayed(driver, AppElements.QHIST , true);
			 Lib.chkIsDisplayed(driver, AppElements.QINFO , true);
			 Lib.chkIsDisplayed(driver, AppElements.QSYNC , true);
			 Lib.chkIsDisplayed(driver, AppElements.QUEUEDATA , true);
			 Lib.chkIsDisplayed(driver, AppElements.REQINDEX , true);
			 Lib.chkIsDisplayed(driver, AppElements.test , true);
			 Lib.chkIsDisplayed(driver, AppElements.TRXCACHE , true);
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
				  Lib.wait_Sleep(3000);
			}
			 //step06
             Lib.Clear_ConsoleMsg(driver);
             driver.findElement(AppElements.Menu_bar_TableTrain).click();
             Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/Service/Database/test/QHIST");

             Lib.Switch_ConsoleTab(driver, AppElements.tab_Error_Cl);
             Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Service/Database/test/QHIST]");//app path issue
             Lib.Switch_ConsoleTab(driver, AppElements.tab_Console);

             //step07
			 Lib.SwitchToFrame(driver, "externalAppIframe");
             WebElement QhistTitle = driver.findElement(AppElements.QHIST).findElement(By.xpath(".//td[text()='QHIST']"));
             Lib.dragAndDropBy(driver, QhistTitle , 359, 367);
             
			 Lib.wait_Sleep(3000);
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetLeft", "368");
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetTop", "376");

             //step08
			 Lib.SwitchToFrame(driver, "moduleFrame");
             driver.findElement(AppElements.Menu_bar_Test).click();
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Web , true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Android , true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_iOS , true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_SMS , true);
			 Lib.chkIsDisplayed(driver, AppElements.Test_Menu_Voice , true);

			 //step09
             driver.findElement(AppElements.Test_Menu_Web).click();
 			Lib.wait_Sleep(3000);

 			Lib.changeWindow(driver);
 			String string = driver.getCurrentUrl();
 			Lib.assertTrue("Popup a window", string.contains("https://www.cyberobject.com.cn:8084/liteclient"));
            
 			//step10
 			driver.close();
 			driver.switchTo().window(currentWindow);
 			driver.switchTo().frame("moduleFrame");
			//step11
            driver.findElement(AppElements.Menu_bar_history).click();
 			Lib.wait_Sleep(WaitTime);
 			//step12
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Title , true);
            driver.findElement(AppElements.Version_History_Close).click();

 			//step13
            driver.findElement(AppElements.Menu_bar_Checkin).click();
 			Lib.wait_Sleep(3000);
 			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Input_Please_enter_your_notes_for_the_version);
			Lib.chkIsDisplayed(driver, AppElements.Input_Cancel , true);
			Lib.chkIsDisplayed(driver, AppElements.Input_CheckIn , true);
            //step14
            driver.findElement(AppElements.Input_Cancel).click();

			 if (Lib.isExist(driver , AppElements.Menu_bar_Uncheck)) {
				 driver.findElement(AppElements.Menu_bar_Uncheck).click();
			}
	 		 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Import, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_TableTrain, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Layout, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Test, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear , true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble , true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.DirFile(driver, "Service/Database/test").click();
			 if (Lib.isExist(driver , AppElements.Menu_bar_Uncheck)) {
				 driver.findElement(AppElements.Menu_bar_Uncheck).click();
			}

			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	/**
	 * @deprecated
	 */
//    @Test
	public void APP_GUI_19_Service_file_information(){
		try {
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database"));
			 driver.findElement(AppElements.RIGHTCLICK_Services_Menu_NewDatabase).click();
			 Lib.wait_Sleep(3000);
			 driver.findElement(AppElements.Input_Field).sendKeys("Testing");
			 driver.findElement(AppElements.Input_OK).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Database/Testing") , true);
			 //step02
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database/Testing"));
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Import , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Train , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Layout , true);
			 Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_DBDelete , true);
			 
			 //step03~04
			 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_Import).click();
			 Lib.wait_Sleep(3000);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Label_Password , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Host , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Port , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_UserName , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Input_Password , true);
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseType, "value", "mysql");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "");
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_TestConnection , true);
			 Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Generate , true);
			 //step05
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_DatabaseName).sendKeys("DEV_QUEUE_CO");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Host).sendKeys("192.168.0.23");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Port).sendKeys("3306");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_UserName).sendKeys("dev_queue_co");
			 driver.findElement(AppElements.ImportDataBaseWindow_Input_Password).sendKeys("123456");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_DatabaseName, "value", "DEV_QUEUE_CO");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Host, "value", "192.168.0.23");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Port, "value", "3306");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_UserName, "value", "dev_queue_co");
			 Lib.ChkProperty(driver, AppElements.ImportDataBaseWindow_Input_Password, "value", "123456");
			 driver.findElement(AppElements.ImportDataBaseWindow_Generate).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.ErrorMsg_All_tables_have_been_added_successfully);

			 //step06
			 driver.findElement(AppElements.Err_Message_OK).click();
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
				  Lib.wait_Sleep(3000);
			}
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_Train).click();
             Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST");
			 
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
		         driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
             driver.findElement(AppElements.tab_Error_Cl).click();
             Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/ui_app_test/Service/Database/Testing/QHIST]");//issue
             driver.findElement(AppElements.tab_Console).click();
   
             //step07
			 Lib.SwitchToFrame(driver, "externalAppIframe");
             WebElement QhistTitle = driver.findElement(AppElements.QHIST).findElement(By.xpath(".//td[text()='QHIST']"));
             Lib.dragAndDropBy(driver, QhistTitle , 359, 367);
             
			 Lib.wait_Sleep(3000);
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetLeft", "368");
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetTop", "376");
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_Layout).click();
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.wait_Sleep(WaitTime);
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetLeft", "10");
             Lib.ChkProperty(driver, AppElements.QHIST, "offsetTop", "10");
             //step08
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database/Testing"));
			 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_DBDelete).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_Database);
			 
			 driver.findElement(AppElements.Delete_OK).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Database/Testing") , false);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			if (Lib.isExist(Lib.DirFile(driver, "Service/Database/Testing"))) {
				 Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database/Testing"));
				 driver.findElement(AppElements.RIGHTCLICK_Service_Menu_DBDelete).click();
				 driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}

    @Test
	public void APP_GUI_20_Channel_Information(){
		try {
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.DirFile(driver, "Channel").click();
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 Lib.wait_Sleep(20000);
			 String[] Channels = new String[] {"Amazon Alexa Voice","Facebook Messenger","iOS",
					 "Mattermost","Microsoft Skype","Tropo SMS","Tropo Voice"};
			 for (String channel : Channels) {
				 Lib.chkIsDisplayed(driver, AppElements.ChannelsImg(channel) , true);
				 Lib.chkIsDisplayed(driver, AppElements.ChannelsName(channel) , true);
				 Lib.chkIsDisplayed(driver, AppElements.Channelstoggle(channel) , true);
			 }
//			 for (String channel : Channels) {
//				 Lib.ChkProperty_Reg(driver, By.xpath("//div[@class='text-center ng-binding'][text()='"+ channel +"']/following-sibling::div/input") ,"class" , "ng-empty");
//			 }
			 Lib.SwitchToFrame(driver, "externalAppIframe"); 
			 //step02
			 WebElement stoggle_off = null;
			 for (String channel : Channels) {
				 try {
					 stoggle_off = driver.findElement(By.xpath("//div[@class='text-center ng-binding'][text()='"+ channel +"']/following-sibling::div/input[contains(@class,'ng-empty')]/following-sibling::label"));
				} catch (Exception e) {
					stoggle_off = null;
				}
				if (Lib.isExist(stoggle_off)) {
					stoggle_off.click();
				}
			}

			 driver.findElement(AppElements.Channelstoggle("iOS")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame"); 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/iOS") , false);
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 //step03
			 driver.findElement(AppElements.Channelstoggle("Mattermost")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame"); 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Mattermost") , false); 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/iOS") , false);
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 //step04
			 driver.findElement(AppElements.Channelstoggle("iOS")).click();
			 Lib.ChkProperty_Reg(driver, By.xpath("//div[@class='text-center ng-binding'][text()='iOS']/parent::div//label/preceding-sibling::input") ,"class" , "ng-not-empty");

			 Lib.SwitchToFrame(driver, "moduleFrame"); 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/iOS") , true);
             //step05
			 Lib.SwitchToFrame(driver, "externalAppIframe");
			 driver.findElement(AppElements.Channelstoggle("Mattermost")).click();
			 Lib.ChkProperty_Reg(driver, By.xpath("//div[@class='text-center ng-binding'][text()='Mattermost']/parent::div//label/preceding-sibling::input") ,"class" , "ng-not-empty");
			 Lib.SwitchToFrame(driver, "moduleFrame"); 
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Mattermost") , true);			 
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
    @Test
	public void APP_GUI_21_Mattermost_Test(){
		try {
			 Lib.checkPageIsReady(driver);
			 //step01
			 Lib.login_Mm(driver, "gaomingjie@cyberobject.com.cn", "123456");
			 //step02	
			 Lib.mouseMoveToElementAndClick(driver, MatterMost.APP("UI_app_test") , 11, 3);
			 Lib.wait_Sleep(3000);
			 //step03
			 Lib.sendMsg(driver, "Hello");
			 Lib.wait_Sleep(3000);
			 
			 Lib.chkMsg(driver, "Logic is start.What's your drinking?\n1. cola\n2. wine\n3. Water\n");
             //step04 issue
			 Lib.sendMsg(driver, "A glass of wine");
			 Lib.wait_Sleep(3000);
			 Lib.chkMsg(driver, "UI_app_testLogic is start.\nAre you 18?\n1. Yes\n2. No");
			 //step05
			 Lib.sendMsg(driver, "Yes!");
			 Lib.wait_Sleep(3000);
			 Lib.chkMsg(driver, "UI_app_testLogic is start.\nOf course, will be soon.");
			 
			 String webUrl = PropertiesDataProvider.getTestData("config/config.properties", "urlappbuilder");
		     Lib.wait_Sleep(3000);
		     driver.manage().window().maximize();
		     driver.get(webUrl);
		     Lib.wait_Sleep(3000);
		     if (!Lib.isExist(driver, AppElements.LOGIN_NAME)) {
				Lib.Switch_loginUser_AppBuilder(driver, UserName, Password);
			}
		} catch (Exception e) {
			Lib.login_AppBuilder(driver, UserName, Password);
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
    
    @Test
 	public void APP_GUI_22_Mattermost_Test(){
 		try {
 			 Lib.checkPageIsReady(driver);
 			 //step01
 			 Lib.login_Mm(driver, "gaomingjie@cyberobject.com.cn", "123456");
 			 //step02	
 			 Lib.mouseMoveToElementAndClick(driver, MatterMost.APP("UI_app_test") , 11, 3);
 			 Lib.wait_Sleep(3000);
 			 //step03
 			 Lib.sendMsg(driver, "Hello");
 			 Lib.wait_Sleep(3000);
 			 
 			 Lib.chkMsg(driver, "Logic is start.What's your drinking?\n1. cola\n2. wine\n3. Water\n");
              //step04 issue
 			 Lib.sendMsg(driver, "A glass of wine");
 			 Lib.wait_Sleep(3000);
 			 Lib.chkMsg(driver, "UI_app_testLogic is start.\nAre you 18?\n1. Yes\n2. No");
 			 //step05
 			 Lib.sendMsg(driver, "Yes!");
 			 Lib.wait_Sleep(3000);
 			 Lib.chkMsg(driver, "UI_app_testLogic is start.\nOf course, will be soon.");
 			 
 			 String webUrl = PropertiesDataProvider.getTestData("config/config.properties", "urlappbuilder");
 		     Lib.wait_Sleep(3000);
 		     driver.manage().window().maximize();
 		     driver.get(webUrl);
 		     Lib.wait_Sleep(3000);
 		     if (!Lib.isExist(driver, AppElements.LOGIN_NAME)) {
 				Lib.Switch_loginUser_AppBuilder(driver, UserName, Password);
 			}
 		} catch (Exception e) {
 			Lib.login_AppBuilder(driver, UserName, Password);
 			Lib.clear_page(driver, UserName, Password);
 			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
 		}
 		MMDriver.softAssert.assertAll();
 	}
    
    
    
    
    
    
//    @Test
	public void RememberLastFile_01_SwitchToAnotherApp_SwitchBackToApp(){
		try {
			 Lib.wait_Sleep(2000);
			 //step01
			 Lib.SwitchApp(driver);
			 
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_switch_Data_folder/UI_switch_Data_file_termdef.xlsx"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 //step02
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_Title, true);
			 //step03
			 Lib.SwitchApp(driver);
			 Lib.wait_Sleep(2000);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("ui_app_switch"), true);

			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_switch_Data_folder/UI_switch_Data_file_termdef.xlsx"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
    
//    @Test
	public void RememberLastFile_02_SwitchToOtherApps_SwitchBackToApp(){
		try {
			 Lib.wait_Sleep(2000);
			 //step01
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_switch_Doc_folder/UI_switch_Doc_file_Start.rex"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 //step02
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("iplatform")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("iplatform"), true);
			 //step03
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_Title, true);
			 //step04
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Data_folder_01/UI_Data_file_employee.xlsx"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 //step05
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("ui_app_switch"), true);
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("Document"), "class" ,"tree-hit tree-expanded");
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("UI_switch_Doc_folder"), "class" ,"tree-hit tree-expanded");

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
    
//    @Test
	public void RememberLastFile_03_SwitchToAnotherAppFile_SwitchBackToApp(){
		try {
			 Lib.wait_Sleep(1000);
			//step01
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_switch_Doc_folder/UI_switch_Doc_file_Start.rex"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
			 //step02
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.wait_Sleep(2000);
			 
			 Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink.rex").click();
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);

			 //step03
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("ui_app_switch"), true);
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("Document"), "class" ,"tree-hit tree-expanded");
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("UI_switch_Doc_folder"), "class" ,"tree-hit tree-expanded");

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
    
//    @Test
 	public void RememberLastFile_04_SwitchToOtherAppFiles_SwitchBackToApp(){
 		try {
 			 Lib.wait_Sleep(1000);
 			//step01
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_switch_Data_folder/UI_switch_Data_file_termdef.xlsx"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
 			 //step02
 			Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("iplatform")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Document/resume.rex").click();
 			 Lib.wait_Sleep(3000);
 			 
 			 //step03
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.DirFile(driver, "Data/UI_Data_file_nidef.xlsx").click();
 			 Lib.wait_Sleep(3000);

 			 //step04
			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
			 Lib.SwitchToFrame(driver, "moduleFrame");
			 Lib.wait_Sleep(2000);
			 Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink.rex").click();

			 //step05
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("ui_app_switch"), true);
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("Data"), "class" ,"tree-hit tree-expanded");
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("UI_switch_Data_folder") , "class" ,"tree-hit tree-expanded");
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_switch_Data_folder/UI_switch_Data_file_termdef.xlsx"), true);

 		} catch (Exception e) {
 			Lib.clear_page(driver, UserName, Password);
 			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
 		}
 		MMDriver.softAssert.assertAll();
 	}
    
//    @Test
 	public void RememberLastFile_05_Data_Document_SwitchToAnotherApp_SwitchBackToApp_HighlightData(){
 		try {
 			 Lib.wait_Sleep(1000);
 			//step01
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
 			driver.findElement(AppElements.LeftTree_Data).click();
// 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_switch_Data_folder/UI_switch_Data_file_termdef.xlsx"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
 			 //step02
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
 			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("ui_app_test"), true);
			 //step03
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
 			 //step04
  			 driver.findElement(AppElements.LeftTree_Document).click();
  			 FileListTable fileListTable = new FileListTable(driver, "filelist");
  			 Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_switch_Doc_folder"), true); 
  			 //step05
 			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
 			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("Organization"), true);
			 
			 //step06
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service"), true);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel"), true);
  			 Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_switch_Doc_folder"), true); 

 		} catch (Exception e) {
 			Lib.clear_page(driver, UserName, Password);
 			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
 		}
 		MMDriver.softAssert.assertAll();
 	}
    
//    @Test
 	public void RememberLastFile_06_Data_Document_Folder_SwitchToAnotherApp_SwitchBackToApp_HighlightDocumentFolder(){
 		try {
 			 Lib.wait_Sleep(1000);
 			//step01
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
 			 Lib.DirFile(driver, "Service/Web Services/test").click();

 			 //step02
 			 Lib.SwitchApp(driver);
			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("iplatform")).click();
 			 Lib.wait_Sleep(2000);
			 Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("iplatform"), true);
 			 
			 //step03
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(2000);
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("Service"), "class" ,"tree-hit tree-expanded");
			 Lib.ChkProperty(driver, AppElements.AppDirectoryList_Arrow("Web Services"), "class" ,"tree-hit tree-expanded");

 			 //step04
			 Lib.SwitchToFrame(driver, "moduleFrame");
 			 Lib.DirFile(driver, "Service").click();
 			 driver.findElement(AppElements.AppDirectoryList_Arrow("Channel")).click();
 			 Lib.wait_Sleep(15000);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Amazon Alexa Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Facebook Messenger"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Google Assistant"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/iOS"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Mattermost"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Microsoft Skype"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Tropo SMS"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Tropo Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Twilio Messaging"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Voxeo Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Web Chat"), true);
 			 Lib.DirFile(driver, "Channel/Mattermost").click();

 			 //step05
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
 			 Lib.wait_Sleep(2000);
 			 
 			 //step06
 			 Lib.SwitchApp(driver);
 			 driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_switch")).click();
 			 Lib.wait_Sleep(20000);
 			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Amazon Alexa Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Facebook Messenger"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Google Assistant"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/iOS"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Mattermost"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Microsoft Skype"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Tropo SMS"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Tropo Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Twilio Messaging"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Voxeo Voice"), true);
			 Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Channel/Web Chat"), true);

 		} catch (Exception e) {
 			Lib.clear_page(driver, UserName, Password);
 			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
 		}
 		MMDriver.softAssert.assertAll();
 	}
    
    
    
    
    
}
