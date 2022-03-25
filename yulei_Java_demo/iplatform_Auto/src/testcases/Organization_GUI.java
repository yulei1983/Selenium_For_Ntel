package testcases;

import java.awt.RenderingHints;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jacob.com.LibraryLoader;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

import autoitx4java.AutoItX;
import bsh.commands.dir;
import checkpoints.AppBChkPoint;
import objectRepository.AppElements;
import prepare.MMDriver;
import utils.FileListTable;
import utils.Lib;
import utils.PropertiesDataProvider;
import utils.WebList;

public class Organization_GUI {
	WebDriver driver = null;
	AutoItX AutoWin = null;
	int WaitTime = 0;
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
		Lib.login_AppBuilder(driver, "uitest@cyberobject.com.cn", "123456");
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		UploadFilePath = PropertiesDataProvider.getTestData("config/config.properties", "UploadFilePath");
		WaitTime = Integer.parseInt(sWaitTime);
		Lib.wait_Sleep(2000);
		driver.switchTo().frame("moduleFrame");
		
        if (!Lib.isExist(driver, AppElements.Switch_App_Window_Title)) {
    		driver.switchTo().defaultContent();
    		driver.findElement(AppElements.Menu_bar_Apps).click();
    		driver.switchTo().frame("moduleFrame");
        }

		driver.findElement(AppElements.SwitchAppMenu_CustomObj("Organization")).click();
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
		driver.switchTo().frame("moduleFrame");
		//ClearMainGui
		int i = driver.findElements(AppElements.Window_masks).size();
		if(i != 0) {
			List<WebElement> Close_btns = driver.findElements(By.xpath("//a[@class='panel-tool-close']"));
			for (WebElement Close_btn : Close_btns) {
				Close_btn.click();
			}
			List<WebElement> No_btns = driver.findElements(By.xpath("//span[@id='confirm_win_no']"));
			for (WebElement No_btn : No_btns) {
				No_btn.click();
			}
		}
		
		if(Lib.isDisplayed(driver, AppElements.Organization_LeftTree_Data_expand_arrow, true, 3)) {
			driver.findElement(AppElements.Organization_LeftTree_Data_expand_arrow).click();
		}
		
	}

	@AfterMethod
	public void afterMethod() {
//		MMDriver.softAssert.assertAll();
	}

	@Test
	public void Organization_GUI_01_Organization_Menu_bar(){
		try {
    		Lib.wait_Sleep(2000);
			driver.switchTo().defaultContent();
			Lib.chkIsDisplayed(driver, AppElements.BuildId, true);
			Lib.SelectApp(driver, "Organization");
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_list_apps, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_List_app_templates, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_New_app, true);
			Lib.wait_Sleep(WaitTime);
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_Advanced, true);
			Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_input_OrgId, true);
			Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_Label_OrgId, true);
			Lib.chkIsDisplayed(driver, AppElements.OrganizationInformation_Title, true);

//			Lib.mouseMoveToElement(driver, AppElements.Menu_bar_UserName("uitest"));	
//			Lib.chkIsDisplayed(driver, AppElements.Red_tag_Text_CustomObj("uitest"), true);
	        driver.findElement(AppElements.OrganizationInformation_AdvancedDownArrow).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Label_Advanced_Prefix, true);
			Lib.chkIsDisplayed(driver, AppElements.Label_Advanced_URI, true);
			Lib.chkIsDisplayed(driver, AppElements.Label_Advanced_TermURI, true);
			Lib.chkIsDisplayed(driver, AppElements.Input_Advanced_URI, true);
			Lib.chkIsDisplayed(driver, AppElements.Input_Advanced_Prefix, true);
			Lib.chkIsDisplayed(driver, AppElements.Input_Advanced_TermURI, true);

			Lib.ChkProperty(driver, AppElements.Input_Advanced_URI, "value", "http://www.uitest_cyberobject_com_cn.com");
			Lib.ChkProperty(driver, AppElements.Input_Advanced_Prefix, "value", "uitest_cyberobject_com_cn");
			Lib.ChkProperty(driver, AppElements.Input_Advanced_TermURI, "value", "http://www.uitest_cyberobject_com_cn.com/term");
	
			driver.switchTo().defaultContent();
			driver.findElement(AppElements.Apps_btn_downarrow).click();
			driver.findElement(AppElements.Menu_bar_New).click();
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("Blank", "Listapptemplates"), true);

			driver.findElement(AppElements.Display_AppID_CustomObj("derick_app_temp", "Logo")).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Title, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Appdescription,true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_Appid,true);
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "textContent", "");
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Appname, true);
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appname, "textContent", "");
			Lib.ChkProperty_Reg(driver, AppElements.CreateNewApplication_input_Applogo, "src", "c2d2.png");
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_select_Apptemplate, "value", "derick_app_temp");
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Advanced, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_ArrowDown_Advanced, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_OK, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_Reset, true);

			driver.findElement(AppElements.CreateNewApplication_Arrow).click();
			Lib.wait_Sleep(1000);
//			issue :Prefix:=blank  
//			need click other place to occur it.
//			At now ,pending this issue.
			driver.findElement(AppElements.CreateNewApplication_input_Prefix).click();
			driver.findElement(AppElements.CreateNewApplication_input_URI).click();
			Lib.wait_Sleep(WaitTime);
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix, "value","uitest_cyberobject_com_cn");
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value","http://www.uitest_cyberobject_com_cn.com/#");
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value","http://www.uitest_cyberobject_com_cn.com//term#");
			
			//step12 issue pending
			driver.findElement(AppElements.CreateNewApplication_Close).click();
            Lib.SwitchApp(driver);
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("iplatform"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("Organization"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app", "Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_switch", "Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_test", "Listapps"), true);

			driver.findElement(AppElements.Menu_bar_New_app).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("Blank", "Listapptemplates"), true);
			//Step16
			driver.findElement(AppElements.CreateNewApplication_Close).click();
			driver.findElement(AppElements.Menu_bar_list_apps).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("iplatform"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("Organization"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app", "Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_switch", "Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_test", "Listapps"), true);
			//Step18
			driver.findElement(AppElements.Menu_bar_List_app_templates).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg)+";"+ e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_02_Organization_list(){
		try {//pass
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Service"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Template"), true);

			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Service"));
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));

//			if (Lib.isExist(driver, AppElements.LeftTree_Data_arrow)) {
//				driver.findElement(AppElements.LeftTree_Data_arrow).click();
//			}
//			Lib.wait_Sleep(WaitTime);
//			if (Lib.isExist(driver, AppElements.LeftTree_Document_arrow)) {
//				driver.findElement(AppElements.LeftTree_Document_arrow).click();
//			}
//			Lib.wait_Sleep(WaitTime);
//			if (Lib.isExist(driver, AppElements.LeftTree_Service_arrow)) {
//				driver.findElement(AppElements.LeftTree_Service_arrow).click();
//			}
//			Lib.wait_Sleep(WaitTime);
//			if (Lib.isExist(driver, AppElements.LeftTree_Template_arrow)) {
//				driver.findElement(AppElements.LeftTree_Template_arrow).click();
//			}
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data","UI_Org_Data_folder_01"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data","UI_Org_Data_folder_02"), true);
            
            if (Lib.isExist(driver, AppElements.AppDirectoryList_FolderArrowUnExpanded("Data", "UI_Org_Data_folder_01"))) {
				driver.findElement(AppElements.AppDirectoryList_FolderArrowUnExpanded("Data", "UI_Org_Data_folder_01")).click();
			}
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_Org_Data_file_employee.xlsx"), true);

            if (Lib.isExist(driver, AppElements.AppDirectoryList_FolderArrowUnExpanded("Data", "UI_Org_Data_folder_02"))) {
				driver.findElement(AppElements.AppDirectoryList_FolderArrowUnExpanded("Data", "UI_Org_Data_folder_02")).click();
			}
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_termdef.xlsx"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data","UI_Org_Data_file_nidef.xlsx"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document","UI_Org_Doc_folder_01"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document","UI_Org_Doc_folder_02"), true);
            if (Lib.isExist(driver, AppElements.AppDirectoryList_FolderArrowUnExpanded("Document", "UI_Org_Doc_folder_01"))) {
				driver.findElement(AppElements.AppDirectoryList_FolderArrowUnExpanded("Document", "UI_Org_Doc_folder_01")).click();
			}
			Lib.wait_Sleep(1000);
            if (Lib.isExist(driver, AppElements.AppDirectoryList_FolderArrowUnExpanded("Document", "UI_Org_Doc_folder_02"))) {
				driver.findElement(AppElements.AppDirectoryList_FolderArrowUnExpanded("Document", "UI_Org_Doc_folder_02")).click();
			}
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Document", "UI_Org_Doc_folder_01", "UI_Org_Doc_file_airline.rex"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Document", "UI_Org_Doc_folder_02", "UI_Org_Doc_file_Shop.rex"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Service","Database"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Service","Web Services"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Service","REST Services"), true);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Template","UI_Org_Data_file_nidef.xlsx"), true);
            //Step03
            Lib.mouseRightClick(driver, AppElements.LeftTreeTop_Organization);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_New_app, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_List_apps, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_List_app_templates, true);
            driver.findElement(AppElements.RIGHTCLICK_New_app).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);
            
			//Step06 issue pending until case update.
			driver.findElement(AppElements.CreateNewApplication_Close).click();

			Lib.mouseRightClick(driver, AppElements.LeftTreeTop_Organization);
            driver.findElement(AppElements.RIGHTCLICK_List_apps).click();
            Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("iplatform"), true);
            Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("Organization"), true);

            Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_switch", "Listapps"), true);
            Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ui_app_test", "Listapps"), true);

            Lib.mouseRightClick(driver, AppElements.LeftTreeTop_Organization);
            driver.findElement(AppElements.RIGHTCLICK_List_app_templates).click();
            Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
            Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
            Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg)+";"+ e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Test
	public void Organization_GUI_03_app_New_and_Delete(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Menu_bar_New_app).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template", "Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app_template", "Listapptemplates"), true);

			driver.findElement(AppElements.Display_AppID_CustomObj("derick_app_temp", "Logo")).click();
			Lib.wait_Sleep(WaitTime);
			
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Title, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Appid, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Appname, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Appdescription, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Applogo, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Apptemplate, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Advanced, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_ArrowDown_Advanced, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_OK, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_btn_Reset, true);
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appname, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appdescription, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Applogo, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_select_Apptemplate, "value", "derick_app_temp");

			driver.findElement(AppElements.CreateNewApplication_ArrowDown_Advanced).click();
			Lib.wait_Sleep(1000);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_Prefix, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_URI, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_input_TermURI, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_Prefix, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_URI, true);
			Lib.chkIsDisplayed(driver, AppElements.CreateNewApplication_Label_TermURI, true);
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value", "");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value", "");
            //点击输入框，然后失去焦点
			driver.findElement(AppElements.CreateNewApplication_input_Prefix).click();
			driver.findElement(AppElements.CreateNewApplication_Label_Prefix).click();
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix, "value", "uitest_cyberobject_com_cn");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value", "http://www.uitest_cyberobject_com_cn.com/#");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value", "http://www.uitest_cyberobject_com_cn.com//term#");
            driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "fm_app_temp");
			driver.findElement(AppElements.CreateNewApplication_input_URI).click();
			
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix, "value", "uitest_cyberobject_com_cn");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp#");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value", "http://www.uitest_cyberobject_com_cn.com/fm_app_temp/term#");
          //step05
            driver.findElement(AppElements.CreateNewApplication_btn_Reset).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.CreateNewApplication_ArrowUp_Advanced).click();
			Lib.wait_Sleep(WaitTime);
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Appid, "value", "");
          //step06
			driver.findElement(AppElements.CreateNewApplication_ArrowDown_Advanced).click();
            //点击输入框，然后失去焦点
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.CreateNewApplication_input_Prefix).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.CreateNewApplication_Label_Prefix).click();
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value", "http://www.uitest_cyberobject_com_cn.com/#");
            Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value", "http://www.uitest_cyberobject_com_cn.com//term#");
			//step07
            driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
			driver.findElement(AppElements.CreateNewApplication_btn_OK).click();
			Lib.wait_Sleep(2000);
			//step08
			Lib.SwitchApp(driver);
			driver.findElement(AppElements.Menu_bar_list_apps).click();
			Lib.wait_Sleep(WaitTime);

			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"), true);
			driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
			Lib.wait_Sleep(2000);

			driver.findElement(AppElements.Applicationinformation_Advanced_arrow).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Title, true);
			Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appid, true);
			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appid, "value", "fm_app_temp");
			Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appname, true);
			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appname, "value", "");
			Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Appdescription, true);
			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Appdescription, "value", "");
			Lib.chkIsDisplayed(driver, AppElements.Applicationinformation_Label_Applogo, true);

			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_Prefix, "value","uitest_cyberobject_com_cn_fm_app_temp");
			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_URI, "value","http://www.uitest_cyberobject_com_cn.com/fm_app_temp#");
			Lib.ChkProperty(driver, AppElements.Applicationinformation_input_TermURI, "value","http://www.uitest_cyberobject_com_cn.com/fm_app_temp/term#");

			driver.findElement(AppElements.Menu_bar_Delete).click();
			Lib.wait_Sleep(3000);
			Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
            //Step11
			driver.findElement(AppElements.Delete_Cancel).click();
            //step12
			driver.switchTo().defaultContent();
			driver.findElement(AppElements.Apps_btn_downarrow).click();
			driver.findElement(AppElements.Menu_bar_Switch).click();
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			Lib.wait_Sleep(WaitTime);
			
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"), true);
			driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
			Lib.wait_Sleep(1000);
			//step13
			driver.findElement(AppElements.Menu_bar_Delete).click();
			Lib.wait_Sleep(1000);
			Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
            driver.findElement(AppElements.Delete_OK).click();
            Lib.wait_Sleep(1000);
            //step15
            Lib.SwitchApp(driver);
            Lib.wait_Sleep(3000);
			driver.findElement(AppElements.Menu_bar_list_apps).click();

			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"), false);
			//step16
			driver.findElement(AppElements.Display_AppID_CustomObj("ui_app_test", "Listapps")).click();
			
			Lib.SwitchApp(driver);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Menu_bar_New_app).click();
			Lib.wait_Sleep(WaitTime);
			//step17 pending
			driver.findElement(AppElements.Display_AppID_CustomObj("Blank", "Logo")).click();
			Lib.wait_Sleep(2000);
			Lib.assertEquals(driver.findElement(AppElements.Display_AppID_CustomObj("Blank", "Logo")).getAttribute("src"), 
					         driver.findElement(AppElements.CreateNewApplication_input_Applogo).getAttribute("src"));

//			step18 Prefix:=blank  
//			need click other place to occur it.
//			At now ,pending this issue.
			driver.findElement(AppElements.CreateNewApplication_Arrow).click();
			Lib.wait_Sleep(1000);
			driver.findElement(AppElements.CreateNewApplication_input_Prefix).click();
			driver.findElement(AppElements.CreateNewApplication_input_URI).click();
			Lib.wait_Sleep(WaitTime);
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_Prefix, "value","uitest_cyberobject_com_cn");
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_URI, "value","http://www.uitest_cyberobject_com_cn.com/#");
			Lib.ChkProperty(driver, AppElements.CreateNewApplication_input_TermURI, "value","http://www.uitest_cyberobject_com_cn.com//term#");

			driver.findElement(AppElements.CreateNewApplication_input_Appid).sendKeys("fm_app_temp");
			driver.findElement(AppElements.CreateNewApplication_btn_OK).click();
			Lib.wait_Sleep(1000);
			
			Lib.mouseRightClick(driver, AppElements.LeftTree_RootNode("fm_app_temp"));
			driver.findElement(AppElements.RIGHTCLICK_Delete).click();
			Lib.wait_Sleep(1000);
			Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_App);
            driver.findElement(AppElements.Delete_OK).click();
            Lib.wait_Sleep(WaitTime);
            //Step 27
			Lib.SwitchApp(driver);
            driver.findElement(AppElements.Menu_bar_list_apps).click();
            Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"), false); 
	
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//删除残留测试数据
			Lib.SwitchApp(driver);
			Lib.wait_Sleep(1000);
            driver.findElement(AppElements.Menu_bar_list_apps).click();
            Lib.wait_Sleep(WaitTime);
            if (Lib.isExist(driver, AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps"))) {
            	driver.findElement(AppElements.Display_AppID_CustomObj("fm_app_temp", "Listapps")).click();
                Lib.wait_Sleep(WaitTime);
                Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName("fm_app_temp"), true);
            	driver.findElement(AppElements.Menu_bar_Delete).click();
    			Lib.wait_Sleep(1000);
                driver.findElement(AppElements.Delete_OK).click();
			}
//            MMDriver.softAssert.fail(e.toString() + "@@\n");
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) +";"+ e.toString() + "@@\n");

		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_04_Data_Information(){
		try {
			int i;
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(WaitTime);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			driver.findElement(AppElements.LeftTree_Data).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Console_arrow_left, true);
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Console_arrow_left).click();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.button_ConsoleClear).click();
            Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), false);
			driver.findElement(AppElements.Menu_bar_Train).click();
//			Lib.CheckConsoleMsg(driver, "Training");
            Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);
            
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/Data/app_termdef.xlsx]");
			driver.findElement(AppElements.tab_Console).click();

            driver.findElement(AppElements.LeftTree_Data).click();
            Lib.wait_Sleep(WaitTime);
			FileListTable Data_table = new FileListTable(driver, "filelist");    
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(Data_table, 1, ExpectedValue);

            ExpectedValue = new String[]{"UI_Org_Data_folder_01","~","",""};
            i = Data_table.getRowByFileName("UI_Org_Data_folder_01");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
//
            ExpectedValue = new String[]{"UI_Org_Data_folder_02","~","",""};
            i = Data_table.getRowByFileName("UI_Org_Data_folder_02");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
//           
            ExpectedValue = new String[]{"UI_Org_Data_file_nidef.xlsx","~","uitest","uitest"};
            i = Data_table.getRowByFileName("UI_Org_Data_file_nidef.xlsx");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
            
            Lib.mouseMoveToElement(driver, Data_table.getRowElementBy("UI_Org_Data_file_nidef.xlsx"));
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Data_file_nidef.xlsx"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Data_file_nidef.xlsx"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
		
	@Test
	public void Organization_GUI_05_Data_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			//初始化测试环境
			Lib.wait_Sleep(2000);
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_folder_add"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_folder_add"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
				Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.wait_Sleep(2000);
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_file_add.xlsx"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_file_add.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
				Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			Lib.wait_Sleep(2000);
			if (Lib.isExist(Lib.DirFile(driver, "Data/UI_TEST_Upload.xlsx"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_TEST_Upload.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
				Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}

			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
//            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
			Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Data_Menu_import);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import_Database, true);
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_import_Database).click();

            String[][] TableExpected = new String[6][7];
            TableExpected[0][0] = "resource:db_ers";
            TableExpected[0][1] = "ip:192.168.254.190";
            TableExpected[0][2] = "port:8306";
            TableExpected[0][3] = "type:mysql";
            TableExpected[0][4] = "pwd:123456";
            TableExpected[0][5] = "user:db_ers";
            TableExpected[0][6] = "db:db_ers";

            TableExpected[1][0] = "resource:test_ht";
            TableExpected[1][1] = "ip:192.168.0.55";
            TableExpected[1][2] = "port:6306";
            TableExpected[1][3] = "type:mysql";
            TableExpected[1][4] = "pwd:123456";
            TableExpected[1][5] = "user:iplatform_dev";
            TableExpected[1][6] = "db:test_ht";
      
            TableExpected[2][0] = "resource:iplatform_dev";
            TableExpected[2][1] = "ip:192.168.0.55";
            TableExpected[2][2] = "port:6306";
            TableExpected[2][3] = "type:mysql";
            TableExpected[2][4] = "pwd:123456";
            TableExpected[2][5] = "user:iplatform_dev";
            TableExpected[2][6] = "db:iplatform_dev";
                     
            TableExpected[3][0] = "resource:ipf_security_dev";
            TableExpected[3][1] = "ip:192.168.0.55";
            TableExpected[3][2] = "port:6306";
            TableExpected[3][3] = "type:mysql";
            TableExpected[3][4] = "pwd:123456";
            TableExpected[3][5] = "user:ipf_security_dev";
            TableExpected[3][6] = "db:ipf_security_dev";
                    
            TableExpected[4][0] = "resource:iplatform_prod";
            TableExpected[4][1] = "ip:192.168.254.190";
            TableExpected[4][2] = "port:6306";
            TableExpected[4][3] = "type:mysql";
            TableExpected[4][4] = "pwd:123456";
            TableExpected[4][5] = "user:iplatform_prod";
            TableExpected[4][6] = "db:iplatform_prod";
           
            TableExpected[5][0] = "resource:ipf_security_prod";
            TableExpected[5][1] = "ip:192.168.254.190";
            TableExpected[5][2] = "port:6306";
            TableExpected[5][3] = "type:mysql";
            TableExpected[5][4] = "pwd:123456";
            TableExpected[5][5] = "user:ipf_security_prod";
            TableExpected[5][6] = "db:ipf_security_prod";
            
            Lib.ChkImportDataBase(driver, TableExpected);
            
            driver.findElement(AppElements.ImportDataBaseWindow_Close).click();
			Lib.wait_Sleep(2000);
            //step04
	        Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
			driver.findElement(AppElements.RIGHTCLICK_Data_Menu_New).click();
			Lib.wait_Sleep(3000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content,  "Please enter a folder name:");
	        Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
	        Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
	        //step05
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_folder_add");
	        driver.findElement(AppElements.Input_OK).click();
	        Lib.wait_Sleep(1000);
	        Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("UI_Org_folder_add"), true);
			
	        //step06	        
	        Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
	        driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newsheet).click();
	        Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.NewSheet_Tab_Organization).click();
			Lib.wait_Sleep(1000);
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Organization", "UI_Org_Data_file_nidef.xlsx"), true);
            //step08
	        driver.findElement(AppElements.New_Sheet_CustomSheet("Organization","UI_Org_Data_file_nidef.xlsx")).click();
            driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Org_file_add");
	        Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.New_Sheet_Create).click();
            
	        Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("UI_Org_folder_add"), true);
	        Lib.wait_Sleep(3000);
	        //step09
	        Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
	        driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Uploadsheet).click();
			Lib.wait_Sleep(1000);
			//WebDriver version issue,need to special handling. 
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload)).click().perform();
//	        driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload).click();
	     //windows operate 
	        AutoWin.winActivate("打开");
		    Lib.wait_Sleep(2000);
		    AutoWin.controlFocus("打开", "", "Edit1");
		    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload sheet.xlsx");
		    Lib.wait_Sleep(1000);
	        AutoWin.controlClick("打开", "", "Button1");
	        Lib.wait_Sleep(3000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_TEST_Upload sheet.xlsx"), true);
	        Lib.mouseRightClick(driver,Lib.DirFile(driver,"Data/UI_TEST_Upload sheet.xlsx"));
	        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	        Lib.wait_Sleep(2000);
	        driver.findElement(AppElements.Delete_OK).click();
	        Lib.wait_Sleep(2000);
	        Lib.mouseRightClick(driver,AppElements.AppDirectoryList("UI_Org_folder_add"));
	        driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
	        Lib.wait_Sleep(2000);
	        Lib.chkTextContent(driver, AppElements.Delete_MSG_Content,  "Are you sure you want to remove this folder?");
	        Lib.wait_Sleep(3000);
	        driver.findElement(AppElements.Delete_OK).click();

//	        Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_TEST_Upload sheet.xlsx"));
//	        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
//	        Lib.wait_Sleep(2000);
//	        driver.findElement(AppElements.Delete_Yes).click();
	             
	        //还原数据
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_folder_add"))) {
		          Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_folder_add"));
		          driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
		          Lib.wait_Sleep(2000);
	        if (Lib.isExist(Lib.DirFile(driver , "Data/UI_Org_file_add.xlsx"))) {
		          Lib.mouseRightClick(driver , Lib.DirFile(driver, "Data/UI_Org_file_add.xlsx"));
		          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
	        
	        if (Lib.isExist(Lib.DirFile(driver , "Data/UI_TEST_Upload sheet.xlsx"))) {
		          Lib.mouseRightClick(driver,Lib.DirFile(driver , "Data/UI_TEST_Upload sheet.xlsx"));
		          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
		} catch (Exception e) {
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
	        if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_folder_add"))) {
		          Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_folder_add"));
		          driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
		          Lib.wait_Sleep(2000);
	        if (Lib.isExist(Lib.DirFile(driver , "Data/UI_Org_file_add.xlsx"))) {
		          Lib.mouseRightClick(driver , Lib.DirFile(driver, "Data/UI_Org_file_add.xlsx"));
		          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
	        
	        if (Lib.isExist(Lib.DirFile(driver , "Data/UI_TEST_Upload sheet.xlsx"))) {
		          Lib.mouseRightClick(driver,Lib.DirFile(driver , "Data/UI_TEST_Upload sheet.xlsx"));
		          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		          Lib.wait_Sleep(2000);
		          driver.findElement(AppElements.Delete_OK).click();
		    }
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_06_Data_folder_Information(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			//展开目录树
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			driver.findElement(AppElements.LeftTree_Data).click();
			Lib.wait_Sleep(WaitTime);
			Lib.DirFile(driver, "Data/UI_Org_Data_folder_01").click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			
			FileListTable Data_table = new FileListTable(driver, "filelist");    
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(Data_table, 1, ExpectedValue);
			
            ExpectedValue = new String[]{"UI_Org_Data_file_employee.xlsx","07-30-19 22:43:08","uitest","uitest"};
            int i = Data_table.getRowByFileName("UI_Org_Data_file_employee.xlsx");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
			
            Lib.mouseMoveToElement(driver, Data_table.getRowElementBy("UI_Org_Data_file_employee.xlsx"));
			Lib.wait_Sleep(3000);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Data_file_employee.xlsx"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Data_file_employee.xlsx"), true);		
            if (!Lib.isExist(driver, AppElements.Console_expand)) {
            	driver.findElement(AppElements.Console_arrow_left).click();
			}

			Lib.Clear_ConsoleMsg(driver);
			driver.findElement(AppElements.Menu_bar_Train).click();
            Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_01/UI_Org_Data_file_employee.xlsx success");
			 
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_01/UI_Org_Data_file_employee.xlsx]");
			driver.findElement(AppElements.tab_Console).click();

		} catch (Exception e) {
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
//			MMDriver.softAssert.fail(e.toString() + "@@\n");
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_07_Data_folder_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
//			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
//			Lib.wait_Sleep(WaitTime);

			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet, true);
//          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet, true);
			Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Folder_Menu_import);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_import_Database, true);
            driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_import_Database).click();
			//step03
            driver.findElement(AppElements.ImportDataBaseWindow_Close).click();
			Lib.wait_Sleep(2000);
			if (!Lib.isExist(driver, AppElements.Console_expand)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(1000);			            
			driver.findElement(AppElements.button_ConsoleClear).click();
			//step04
			Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_Data_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Train).click();
			Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_01/UI_Org_Data_file_employee.xlsx success");

			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_01/UI_Org_Data_file_employee.xlsx]");
			driver.findElement(AppElements.tab_Console).click();
			
			//step05
			Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_Data_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_New).click();
			Lib.wait_Sleep(2000);
			//step06
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content,  "Please enter a folder name:");
	        Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
	        Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_folder_fm");
			Lib.wait_Sleep(1000);
	        driver.findElement(AppElements.Input_OK).click();
	        
	        Lib.chkIsDisplayed(driver, AppElements.Empty_Folder, true);
	        Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_folder_fm"));
			Lib.wait_Sleep(1000);
			//step07
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Rename).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the new folder name:");
	        driver.findElement(AppElements.Input_Field).clear();
	        //step08
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_folder_new");
			Lib.wait_Sleep(1000);
	        driver.findElement(AppElements.Input_OK).click();
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data","UI_Org_Data_folder_01","UI_Org_Data_folder_new"), true);
			
//			//删除还原UI_Org_Data_folder_new
//			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data","UI_Org_Data_folder_01","UI_Org_Data_folder_new"));
//			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Delete).click();
//			driver.findElement(AppElements.Delete_Yes).click();

			Lib.wait_Sleep(1000);
			//step09
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Copy).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_01"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Copy, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Paste, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet, true);
			//step10
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Paste).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content,  "Please enter the folder name:");
	        Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
	        Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
	        Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Data_folder_01");
	         //step11
	        driver.findElement(AppElements.Input_Close).click();
             //step12
	        Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
	        driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Paste).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content,  "Please enter the folder name:");
	        Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
	        Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
	        Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Data_folder_01");
	        //step13
	        driver.findElement(AppElements.Input_Field).clear();
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_folder_copy_02");
	        driver.findElement(AppElements.Input_OK).click();
            //step14
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_copy_02"));
			driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
			driver.findElement(AppElements.Delete_OK).click();
	        Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_copy_02"), false);
            //step15
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Newsheet).click();
            //step16 
			driver.findElement(AppElements.New_Sheet_Command_Xlsx).click();
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Back, true);
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Create, true);
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Inputfield, true);
            //step17
			driver.findElement(AppElements.New_Sheet_Back).click();
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Command_Xlsx, true);
	        Lib.chkIsDisplayed(driver, AppElements.NewSheet_Tab_Iplatform, true);
            //step18
			driver.findElement(AppElements.New_Sheet_Command_Xlsx).click();
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Back, true);
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Create, true);
	        Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Inputfield, true);
        //step19
	        driver.findElement(AppElements.New_Sheet_Inputfield).clear();
	        driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Org_Data_file_fm");
			driver.findElement(AppElements.New_Sheet_Create).click();
			
	        Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm.xlsx"), true);
        //step20
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet).click(); 
			Lib.chkIsDisplayed(driver, AppElements.Upload_Please_select_excel_file_to_upload, true);
		//step22
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(AppElements.Upload_Please_select_excel_file_to_upload)).click().perform();
			Lib.wait_Sleep(2000);
			AutoWin.winActivate("打开");
			Lib.wait_Sleep(2000);
		    AutoWin.controlFocus("打开", "", "Edit1");
		    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload sheet.xlsx");
	        AutoWin.controlClick("打开", "", "Button1");
	        Lib.wait_Sleep(3000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"), true);
            //step25
            Lib.mouseRightClick(driver,AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"));
	        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			Lib.wait_Sleep(2000);
	        driver.findElement(AppElements.Delete_OK).click();

	        Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"), false);

			if (Lib.isDisplayed(Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
	        Lib.wait_Sleep(2000);
			if (Lib.isDisplayed(Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm"), true, 2)) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
	        Lib.wait_Sleep(2000);
			if (Lib.isDisplayed(Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_folder_new"), true, 2)) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"), true, 2)) {
		        Lib.mouseRightClick(driver,AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"));
		        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
		        driver.findElement(AppElements.Delete_OK).click();	
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Data", " UI_Org_Data_folder_copy_02"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", " UI_Org_Data_folder_copy_02"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
     
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_FolderArrow("Data", "UI_Org_Data_folder_01"));
			
			if (Lib.isDisplayed(Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isDisplayed(Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm"), true, 2)) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_01/UI_Org_Data_file_fm"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data","UI_Org_Data_folder_01", "UI_Org_Data_folder_new"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data","UI_Org_Data_folder_01", "UI_Org_Data_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"), true, 2)) {
		        Lib.mouseRightClick(driver,AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_01", "UI_TEST_Upload sheet.xlsx"));
		        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
		        driver.findElement(AppElements.Delete_OK).click();	
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Data", " UI_Org_Data_folder_copy_02"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", " UI_Org_Data_folder_copy_02"));
				driver.findElement(AppElements.RIGHTCLICK_DataFolder_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
//			MMDriver.softAssert.fail(e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_08_Data_file_Information(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.AppDirectoryList("Data","UI_Org_Data_file_nidef.xlsx")).click();
			Lib.wait_Sleep(3000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckout, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			
			if (!Lib.isExist(driver, AppElements.Console_expand)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}

			driver.findElement(AppElements.Menu_bar_ExcelTrain).click();
            Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_file_nidef.xlsx success");
            
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
            
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_file_nidef.xlsx]");
			driver.findElement(AppElements.tab_Console).click();

			driver.findElement(AppElements.Menu_bar_ExcelRefresh).click();
            Lib.CheckConsoleMsg(driver, "NPUTMANUALLY info is empty");

			//step05
			driver.findElement(AppElements.Menu_bar_ExcelCheckout).click();
			Lib.wait_Sleep(3000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelRefresh, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelSave, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelUncheck, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckin, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Excelhistory, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			//step06
			driver.findElement(AppElements.Menu_bar_Excelhistory).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
			String[] TablecolumExpecteds = new String[4];
			TablecolumExpecteds[0] = "Id";
			TablecolumExpecteds[1] = "UserId";
			TablecolumExpecteds[2] = "Time";
			TablecolumExpecteds[3] = "Notes";
			for (String TablecolumExpected : TablecolumExpecteds) {
				Lib.chkIsDisplayed(driver, By.xpath("//span[text()='"+ TablecolumExpected +"']"), true);
			}
			
			//点击表格第一行数据Step07
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
			driver.findElement(AppElements.Version_History_Show).click();

			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			Lib.changeWindow(driver);
			String string = driver.getCurrentUrl();
			Lib.assertTrue("Open Version History", string.contains("http://www.cyberobject.com.cn:8085/iplatform-ruleeditor/exceleditor/index.html"));
			
			driver.close();
			driver.switchTo().window(currentWindow);
			driver.switchTo().frame("moduleFrame");
			Lib.wait_Sleep(1000);
			
			  driver.findElement(AppElements.Menu_bar_history).click();
				Lib.wait_Sleep(3000);
				//点击表格第一行数据
				Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
				Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
				Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
				driver.findElement(AppElements.Version_History_CheckOut).click();
				Lib.wait_Sleep(3000);
				Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck, true);
				Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);

				driver.findElement(AppElements.Menu_bar_Uncheck).click();
				Lib.wait_Sleep(3000);
			    Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
//			MMDriver.softAssert.fail(e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_09_Data_file_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			Lib.wait_Sleep(WaitTime); 
			//step01
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data","UI_Org_Data_folder_02"));
			driver.findElement(AppElements.RIGHTCLICK_Folder_Menu_Newsheet).click();
			Lib.wait_Sleep(WaitTime); 
            //step02
			driver.findElement(AppElements.NewSheet_Tab_Organization).click();
			Lib.wait_Sleep(WaitTime);                                             
			driver.findElement(AppElements.New_Sheet_CustomSheet("Organization", "UI_Org_Data_file_nidef.xlsx")).click();
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.New_Sheet_Inputfield).sendKeys("UI_Org_Data_test_file");
			Lib.wait_Sleep(WaitTime);
		    driver.findElement(AppElements.New_Sheet_Create).click();	
			//case issue
			Lib.wait_Sleep(2000);
		    Lib.chkIsDisplayed(driver, Lib.DirFile(driver,"Data/UI_Org_Data_folder_02/UI_Org_Data_test_file.xlsx"), true);
		    //step03
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
			Lib.Clear_ConsoleMsg(driver);
			Lib.mouseRightClick(driver, Lib.DirFile(driver,"Data/UI_Org_Data_folder_02/UI_Org_Data_file_termdef.xlsx"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_SaveAsTemplate, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Refresh, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download, true);
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Train).click();

            Lib.CheckConsoleMsg(driver, "Training uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_02/UI_Org_Data_file_termdef.xlsx success");
            
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "trained spreadsheet doc [uitest_cyberobject_com_cn/Organization/data/UI_Org_Data_folder_02/UI_Org_Data_file_termdef.xlsx]");
			driver.findElement(AppElements.tab_Console).click();

            //step06
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02","UI_Org_Data_test_file.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
            //step07
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Input_Field).clear();
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_name_file.xlsx");;
			driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(1000);
		    Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_02/UI_Org_Data_name_file.xlsx"), true);

			//step08
			Lib.wait_Sleep(1000);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02","UI_Org_Data_name_file.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Delete_OK).click();

		    Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_name_file.xlsx"), false);
		    //step09
			driver.findElement(AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02","UI_Org_Data_file_termdef.xlsx")).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02","UI_Org_Data_file_termdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_SaveAsTemplate).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the template name:");
            //step10
	        driver.findElement(AppElements.Input_Field).clear();
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_file_template.xlsx");
	        driver.findElement(AppElements.Input_OK).click();
			//step11
			Lib.wait_Sleep(1000);
			Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newsheet).click();
			Lib.wait_Sleep(1000);
			driver.findElement(AppElements.NewSheet_Tab_Organization).click();
			Lib.wait_Sleep(1000);
			Lib.chkIsDisplayed(driver, AppElements.New_Sheet_CustomSheet("Organization", "UI_Org_Data_file_template.xlsx"), true);
			//step12
			driver.findElement(AppElements.New_Sheet_Close).click();
			Lib.wait_Sleep(2000);
            Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			Lib.wait_Sleep(2000);
		    Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Template","UI_Org_Data_file_template.xlsx"), true);

			//step13
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_termdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Copy).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Paste, true);
			//step14
			driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Paste).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the data name:");
	        Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Data_file_termdef.xlsx");
            //step15
	        driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"), true);
	        //step16
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"));
	        driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Delete_OK).click();

            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"), false);
            //step17
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_02"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_import, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_DataFolder_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Newsheet, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Uploadsheet, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_DataFolder_Menu_Delete, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Folder_Menu_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Paste, true);
			//step18
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Paste).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the data name:");
	        Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Data_file_termdef.xlsx");
			//step19
	        driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(1000);
	        Lib.chkTextContent(driver, AppElements.ErrMessage_content, "File UI_Org_Data_file_termdef.xlsx already exists! if you want to overwrite it, please delete it first.");
	        driver.findElement(AppElements.Err_Message_OK).click();
            //step20
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_folder_02"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Paste).click();
			Lib.wait_Sleep(1000);
            
	        driver.findElement(AppElements.Input_Field).clear();
	        driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_file_copytermdef.xlsx");
			Lib.wait_Sleep(WaitTime);
	        driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);

	        //step21
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	        Lib.wait_Sleep(3000);
			driver.findElement(AppElements.Delete_OK).click();
			Lib.wait_Sleep(WaitTime);
		    Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"), false);

		    //step22
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_folder_02/UI_Org_Data_file_termdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Download).click();
	        Lib.wait_Sleep(3000);
	        Lib.isFileDownloaded(downloadpath, "UI_Org_Data_file_termdef.xlsx");
	        
	        //step24
			Lib.mouseRightClick(driver, 
			AppElements.AppDirectoryList("Template", "UI_Org_Data_file_template.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
	        Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Delete_OK).click();
			Lib.wait_Sleep(WaitTime);
		    Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_template.xlsx"), false);

	        //避免误删除UI_Org_Data_file_termdef
//			Lib.CollapseNode(driver, AppElements.AppDirectoryList_FolderArrow("Data", "UI_Org_Data_folder_02"));
//			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"), true, 2)) {
//				driver.findElement(AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx")).click();
//				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"));
//				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
//		        Lib.wait_Sleep(2000);
//				driver.findElement(AppElements.Delete_Yes).click();
//			}
			
		    if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_Data_file_termdef.xlsx"))) {
		    	Lib.DirFile(driver, "Data/UI_Org_Data_file_termdef.xlsx").click();
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_file_termdef.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}

			Lib.ExpandNode(driver, AppElements.AppDirectoryList_FolderArrow("Data", "UI_Org_Data_folder_02"));
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_test_file.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_test_file.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
				
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Template", "UI_Org_Data_file_template.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Template", "UI_Org_Data_file_template.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
			    driver.findElement(AppElements.Delete_OK).click();
			}
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Data"));
			
			//避免误删除UI_Org_Data_file_termdef
			Lib.CollapseNode(driver, AppElements.AppDirectoryList_FolderArrow("Data", "UI_Org_Data_folder_02"));
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Data", "UI_Org_Data_file_termdef.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
		        Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_FolderArrow("Data", "UI_Org_Data_folder_02"));
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_file_copytermdef.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
				}
			
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_test_file.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Data", "UI_Org_Data_folder_02", "UI_Org_Data_test_file.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
			}
				
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			if (Lib.isDisplayed(driver, AppElements.AppDirectoryList("Template", "UI_Org_Data_file_template.xlsx"), true, 2)) {
				Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Template", "UI_Org_Data_file_template.xlsx"));
				driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			    Lib.wait_Sleep(2000);
				driver.findElement(AppElements.Delete_OK).click();
				}
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_10_Document_Information(){
		try {
			int i;
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(1000);
			
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			Lib.wait_Sleep(WaitTime); 
			
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.wait_Sleep(3000);
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
			Lib.Clear_ConsoleMsg(driver);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Menu_bar_Train).click();//issue: revice message slowly.
//            Lib.CheckConsoleMsg(driver, "Start training doc UI_Org_Doc_file_delete.ucx");
			Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);

			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
					Lib.wait_Sleep(WaitTime);
			}
			 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Org_Doc_file_delete.ucx");
			
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
					Lib.wait_Sleep(WaitTime);
			}
			
			driver.findElement(AppElements.tab_Console).click();

//			Lib.Clear_ConsoleMsg(driver);
			driver.findElement(AppElements.Menu_bar_Deploy).click();//issue: recvice message slowly.
			Lib.CheckConsoleMsg(driver, "[Start deploy]Document");

			//step05
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.wait_Sleep(WaitTime);
			FileListTable Data_table = new FileListTable(driver, "filelist");    
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(Data_table, 1, ExpectedValue);
			
            ExpectedValue = new String[]{"UI_Org_Doc_folder_01","~","",""};
            i = Data_table.getRowByFileName("UI_Org_Doc_folder_01");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
			
            ExpectedValue = new String[]{"UI_Org_Doc_folder_02","~","",""};
            i = Data_table.getRowByFileName("UI_Org_Doc_folder_02");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
            
            ExpectedValue = new String[]{"Copy_Org_Doc_blank.rex","~","uitest","uitest"};
            i = Data_table.getRowByFileName("Copy_Org_Doc_blank.rex");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
			Lib.wait_Sleep(WaitTime);
			Lib.mouseMoveToElement(driver, Data_table.getRowElementBy("UI_Org_Doc_folder_01"));
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Doc_folder_01"), false);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Doc_folder_01"), false);
			Lib.mouseMoveToElement(driver, Data_table.getRowElementBy("UI_Org_Doc_file_Drink.rex"));

//			Lib.highlight(driver, driver.findElement(AppElements.FileList_Download));
//			Lib.highlight(driver, driver.findElement(AppElements.FileList_Delete));
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Doc_file_Drink.rex"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Doc_file_Drink.rex"), true);
			Lib.wait_Sleep(WaitTime);
            driver.findElement(Data_table.getRowElementBy("UI_Org_Doc_folder_01")).click();
			Lib.wait_Sleep(1000);
			Data_table = new FileListTable(driver, "filelist");
            ExpectedValue = new String[]{"UI_Org_Doc_file_airline.rex","~","",""};
            i = Data_table.getRowByFileName("UI_Org_Doc_file_airline.rex");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
            driver.findElement(Data_table.getRowElementBy("UI_Org_Doc_file_airline.rex")).click();

		} catch (Exception e) {
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_11_Data_Information(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Document).click();
			
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			Lib.wait_Sleep(WaitTime); 
			
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
			
			//Step02
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}			
			Lib.wait_Sleep(3000);
			Lib.Clear_ConsoleMsg(driver);

			//Step03
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
			Lib.wait_Sleep(WaitTime);
			//issue wait time too long
            Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);       

			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Org_Doc_file_delete.ucx");
			driver.findElement(AppElements.tab_Console).click();
			
			//Step04
//			driver.findElement(AppElements.button_ConsoleClear).click();
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Deploy).click();
			Lib.wait_Sleep(WaitTime);
			Lib.CheckConsoleMsg(driver, "[Start deploy]Document");
			
			//Step05
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New).click();
			Lib.wait_Sleep(2000);

			//Step06
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_a_folder_name);
			Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
			driver.findElement(AppElements.Input_Field).clear();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_folder_add");
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_add"), true);
			Lib.wait_Sleep(2000);
			//Step07
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Script).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
			
			//Step08
			driver.findElement(AppElements.Input_Field).clear();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_script_add");
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_script_add.ucx"), true);

			//Step09
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
			Lib.wait_Sleep(2000);
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
			
			//Step10
			driver.findElement(AppElements.Input_Field).clear();
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_add");
			driver.findElement(AppElements.Input_OK).click();
			
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_file_add.rex"), true);
			
			//Step11
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Upload_Doc).click();
			Lib.wait_Sleep(2000);
			////step12 windows UI
	        AutoWin.winActivate("打开");
		    Lib.wait_Sleep(2000);
		    AutoWin.controlFocus("打开", "", "Edit1");
		    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload flow.rex");
		    Lib.wait_Sleep(1000);
	        AutoWin.controlClick("打开", "", "Button1");
		    Lib.wait_Sleep(2000);
		  //issue: popup a message about "can not open the file",cause script run error.
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document", "UI_TEST_Upload flow.rex"), true);
			
			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_add"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_add")));
				driver.findElement(AppElements.RIGHTCLICK_DocumentFolder_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}
		    Lib.wait_Sleep(1000);

			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_TEST_Upload flow.rex"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_TEST_Upload flow.rex")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}
		    Lib.wait_Sleep(1000);

			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_file_add.rex"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_file_add.rex")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}
		    Lib.wait_Sleep(1000);

			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_script_add.ucx"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_script_add.ucx")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			
			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_file_add.rex"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_file_add.rex")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}
		    Lib.wait_Sleep(1000);

			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_add"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_add")));
				driver.findElement(AppElements.RIGHTCLICK_DocumentFolder_Menu_Delete).click();//issue 
				driver.findElement(AppElements.Delete_OK).click();
			}
		    Lib.wait_Sleep(1000);

			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_TEST_Upload flow.rex"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_TEST_Upload flow.rex")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}

		    Lib.wait_Sleep(1000);
			if (Lib.isExist(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_script_add.ucx"))) {
				Lib.mouseRightClick(driver, (AppElements.AppDirectoryList("Document", "UI_Org_Doc_script_add.ucx")));
				driver.findElement(AppElements.RIGHTCLICK_File_Menu_Delete).click();
				driver.findElement(AppElements.Delete_OK).click();
			}
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}

		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_12_Document_folder_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));

			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.AppDirectoryList("Document","UI_Org_Doc_folder_01")).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.wait_Sleep(2000);
			
			//Step02
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
			Lib.Clear_ConsoleMsg(driver);

			//Step03
			driver.findElement(AppElements.Menu_bar_Train).click();
            Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);       
//			Lib.CheckConsoleMsg(driver, "training");

			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Org_Doc_folder_01/UI_Org_Doc_file_airline.rex");
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			driver.findElement(AppElements.tab_Console).click();
            
			//Step04
            Lib.Clear_ConsoleMsg(driver);
			driver.findElement(AppElements.Menu_bar_Deploy).click();
			Lib.CheckConsoleMsg(driver, "[Start deploy]UI_Org_Doc_folder_01");
			
			driver.findElement(AppElements.AppDirectoryList("Document","UI_Org_Doc_folder_01")).click();
			Lib.wait_Sleep(3000);
			FileListTable Data_table = new FileListTable(driver, "filelist");    
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(Data_table, 1, ExpectedValue);
			
            ExpectedValue = new String[]{"UI_Org_Doc_file_airline.rex","05-20-19 22:54:28","",""};
            int i = Data_table.getRowByFileName("UI_Org_Doc_file_airline.rex");
            Lib.ChkFileTableDataByRow(Data_table, i, ExpectedValue);
            
            Lib.mouseMoveToElement(driver, Data_table.getRowElementBy("UI_Org_Doc_file_airline.rex"));
			Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Doc_file_airline.rex"), true);
			Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Doc_file_airline.rex"), true);

		} catch (Exception e) {
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_13_Document_folder_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			Lib.wait_Sleep(WaitTime);

			Lib.mouseRightClick(driver, Lib.DirFile(driver , "Document/UI_Org_Doc_folder_01"));   
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_DocumentFolder_Menu_Delete , true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
			Lib.wait_Sleep(3000);
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
            Lib.Clear_ConsoleMsg(driver);
			
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
			Lib.CheckConsoleMsg(driver, "Start training doc UI_Org_Doc_folder_01/UI_Org_Doc_file_airline.rex");

			if (Lib.isExist(driver, AppElements.ZebraDialog_Close)) {
				driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			
			driver.findElement(AppElements.tab_Error_Cl).click();
			Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Org_Doc_folder_01/UI_Org_Doc_file_airline.rex");
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			driver.findElement(AppElements.tab_Console).click();
			
			//Step04
            Lib.Clear_ConsoleMsg(driver);
			Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Deploy).click();
			Lib.CheckConsoleMsg(driver, "[Start deploy]UI_Org_Doc_folder_01");

			//Step05
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_01"));
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New).click();
			//Step06
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_a_folder_name);
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_test_folder_01");
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
            
			Lib.wait_Sleep(WaitTime);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Document", "UI_Org_Doc_folder_01", "UI_Org_test_folder_01"), true);
            
            //Step07
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList_FolderChildren("Document", "UI_Org_Doc_folder_01", "UI_Org_test_folder_01"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Rename).click();

			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_new_folder_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_test_folder_01");
			//step08
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_test_folder_new");
            driver.findElement(AppElements.Input_OK).click();
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList_FolderChildren("Document", "UI_Org_Doc_folder_01", "UI_Org_test_folder_new"), true);
			Lib.wait_Sleep(3000);
            //Step09
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document","UI_Org_Doc_folder_01"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Copy).click();
			Lib.wait_Sleep(2000);
			//Step10
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_01"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Delete, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Folder_Paste, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
            
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_folder_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_folder_01");
			//Step11
			driver.findElement(AppElements.Input_Close).click();
            
            //Step12
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_02"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
			Lib.wait_Sleep(2000);
			
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_folder_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_folder_01");
			//Step13
            driver.findElement(AppElements.Input_OK).click();
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver , "Document/UI_Org_Doc_folder_02/UI_Org_Doc_folder_01"),true);
            
            //Step14
            Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();
			Lib.wait_Sleep(2000);
			//Step15
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_folder_01");
			driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.Folder_UI_Org_Doc_folder_01_already_exists);
			driver.findElement(AppElements.Message_OK).click();

			//Step16
            Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Paste).click();

            //Step17
			Lib.wait_Sleep(2000);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_folder_01");
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_folder_03");
            Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
            
            Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_03"), true);
            
            //step18
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_01"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Script).click();
			Lib.wait_Sleep(3000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
           
            //step19
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_script");
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_script.ucx"), true);
			Lib.wait_Sleep(3000);
            //step20
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();

			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
           
            //step21
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_fm");
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_fm.rex"), true);
			Lib.wait_Sleep(2000);
            //step22
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document", "UI_Org_Doc_folder_01"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Upload_Doc).click();
			Lib.wait_Sleep(4000);
            //step23 windows operate .Issue: popup a message"can not open file.",if run need to skip.
	        AutoWin.winActivate("打开");
		    Lib.wait_Sleep(2000);
		    AutoWin.controlFocus("打开", "", "Edit1");
		    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\UI_TEST_Upload flow.rex");
		    Lib.wait_Sleep(1000);
	        AutoWin.controlClick("打开", "", "Button1");
		    Lib.wait_Sleep(4000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_TEST_Upload flow.rex"), true);
		    Lib.wait_Sleep(2000);
            //step24
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
		    Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_folder);
            //step25
            driver.findElement(AppElements.Delete_OK).click();
		    Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"), false);

            //step26
            Lib.DirFile(driver, "Document/UI_Org_Doc_folder_03/UI_Org_Doc_file_airline.rex").click();
		    Lib.wait_Sleep(3000);
            driver.findElement(AppElements.Menu_bar_Checkout).click();
		    Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);
            
            //step27
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_03"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
		    Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Message_content, AppBChkPoint.There_are_files_checking_out_by_you$$$remove_this_folder);
            //step28
            driver.findElement(AppElements.Delete_OK).click();
		    Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_03"), false);

            //Restore test data.
		    Lib.wait_Sleep(1000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			}  
			
		    Lib.wait_Sleep(1000);
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_folder_03"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_folder_03"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			} 

		    Lib.wait_Sleep(1000);
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_02/UI_Org_Doc_folder_01"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_02/UI_Org_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			}  
						
		    Lib.wait_Sleep(1000);
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_TEST_Upload flow.rex"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_TEST_Upload flow.rex"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
		    Lib.wait_Sleep(1000);
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_fm.rex"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_fm.rex"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
					Lib.wait_Sleep(WaitTime);
					driver.findElement(AppElements.Delete_OK).click();
				}
		    
		        Lib.wait_Sleep(1000);
//				Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_script.ucx"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_script.ucx"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
					Lib.wait_Sleep(WaitTime);
					driver.findElement(AppElements.Delete_OK).click();
				}

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
			Lib.wait_Sleep(1000);
//			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_folder_01/UI_Org_test_folder_new"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			} 
			
		    Lib.wait_Sleep(1000);
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_folder_03"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_folder_03"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			} 

		    Lib.wait_Sleep(1000);
//			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_02"));
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_02/UI_Org_Doc_folder_01"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_02/UI_Org_Doc_folder_01"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Folder_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			} 
						
		    Lib.wait_Sleep(1000);
//			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
			if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_TEST_Upload flow.rex"))) {
				Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_TEST_Upload flow.rex"));
				driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
				Lib.wait_Sleep(WaitTime);
				driver.findElement(AppElements.Delete_OK).click();
			}
			
		    Lib.wait_Sleep(1000);
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_fm.rex"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_fm.rex"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
					Lib.wait_Sleep(WaitTime);
					driver.findElement(AppElements.Delete_OK).click();
				}
		    
		        Lib.wait_Sleep(1000);
//				Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("UI_Org_Doc_folder_01"));
				if (Lib.isExist(Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_script.ucx"))) {
					Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_folder_01/UI_Org_Doc_file_script.ucx"));
					driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
					Lib.wait_Sleep(WaitTime);
					driver.findElement(AppElements.Delete_OK).click();
				}
		     
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	@Test
	public void Organization_GUI_14_Document_file_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));

			Lib.wait_Sleep(WaitTime);
			//step01
			Lib.DirFile(driver, "Document/general.ucx").click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			
            
            if (Lib.isDisplayed(driver, AppElements.Console_arrow_left, true, 2)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(2000);
			
			Lib.Clear_ConsoleMsg(driver);
			//step03
            driver.findElement(AppElements.Menu_bar_Train).click();
            Lib.CheckConsoleMsg(driver, "Start training doc general.ucx");
            
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
            
            driver.findElement(AppElements.tab_Error_Cl).click();
            Lib.CheckConsoleErrorMsg(driver, "Start training doc general.ucx");
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
            driver.findElement(AppElements.tab_Console).click();

			driver.findElement(AppElements.Menu_bar_Deploy).click();
			Lib.CheckConsoleMsg(driver, "[Start deploy]general.ucx");
			
			//step05
			driver.findElement(AppElements.Menu_bar_history).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
			String[] TablecolumExpecteds = new String[4];
			TablecolumExpecteds[0] = "Id";
			TablecolumExpecteds[1] = "UserId";
			TablecolumExpecteds[2] = "Time";
			TablecolumExpecteds[3] = "Notes";
			for (String TablecolumExpected : TablecolumExpecteds) {
				Lib.chkIsDisplayed(driver, By.xpath("//span[text()='"+ TablecolumExpected +"']"), true);
			}
			
			//step06
			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
			
			//step07
			driver.findElement(AppElements.Version_History_Show).click();

			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			Lib.changeWindow(driver);
//			String string = driver.getCurrentUrl();

			//step08
			driver.close();
			driver.switchTo().window(currentWindow);
			driver.switchTo().frame("moduleFrame");
			Lib.wait_Sleep(1000);
			
          //step09
			driver.findElement(AppElements.Menu_bar_history).click();
			Lib.wait_Sleep(1000);
			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
			driver.findElement(AppElements.Version_History_CheckOut).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Save, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
          //step10
			driver.findElement(AppElements.Menu_bar_Uncheck).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	@Test
	public void Organization_GUI_15_Data_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Document"));
          //step01
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("UI_Org_Doc_file_Drink.rex"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Delete, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Download, true);
			//step02
			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
            Lib.Clear_ConsoleMsg(driver);
            //step03
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Train).click();
            Lib.CheckConsoleMsg(driver, "Start training doc UI_Org_Doc_file_Drink.rex");
            
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
			 
            driver.findElement(AppElements.tab_Error_Cl).click();
            Lib.CheckConsoleErrorMsg(driver, "Start training doc UI_Org_Doc_file_Drink.rex");
			 if (Lib.isExist(driver, AppElements.ZebraDialog)) {
					driver.findElement(AppElements.ZebraDialog_Close).click();
			}
            driver.findElement(AppElements.tab_Console).click();

            Lib.Clear_ConsoleMsg(driver);
          //step04
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document","UI_Org_Doc_file_Drink.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Deploy).click();
            Lib.CheckConsoleMsg(driver, "[Start deploy]UI_Org_Doc_file_Drink.rex");
            //step05
			Lib.wait_Sleep(2000);
            Lib.mouseRightClick(driver, Lib.DirFile(driver , "Document/UI_Org_Doc_file_Drink.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Copy).click();
			Lib.wait_Sleep(2000);
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Script, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Paste, true);

			
			//clear console
			if (Lib.isDisplayed(driver, AppElements.Console_arrow_left, true, 2)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
            Lib.Clear_ConsoleMsg(driver);
			
			//step06
            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Paste).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);  
            Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_file_Drink.rex");
			Lib.wait_Sleep(WaitTime);
			//step07
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.ErrorMsg_File_UI_Org_Doc_file_Drink_already_exists$$$overwrite_it_please_delete_it_first);  
            Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.GetConsole_Window_Msg(1), true);
            Lib.ChkProperty_Reg(driver, AppElements.GetConsole_Window_Msg(1), "textContent", "File UI_Org_Doc_file_Drink.rex already exists! if you want to overwrite it, please delete it first.");

            //step08
            driver.findElement(AppElements.Err_Message_OK).click();
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Paste).click();

			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_file_Drink.rex");

			//step09
			driver.findElement(AppElements.Input_Field).clear();
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_Drink_copy.rex");
            driver.findElement(AppElements.Input_OK).click();
            Lib.wait_Sleep(WaitTime);

            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink_copy.rex"), true);
            //step10
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink_copy.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Rename).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_new_file_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "UI_Org_Doc_file_Drink_copy.rex");
			
			//step11
			driver.findElement(AppElements.Input_Field).clear();
            Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_Drink_new.rex");
            Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
            Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink_new.rex"), true);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink_copy.rex"), false);

            //step12
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_Drink.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Download).click();
			Lib.wait_Sleep(3000);
			//step13
			Lib.isFileDownloaded(downloadpath, "UI_Org_Doc_file_Drink.rex");
            
			//step14
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Script).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "");
		//step15
			driver.findElement(AppElements.Input_Field).clear();
            Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_script");
            Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
            Lib.wait_Sleep(2000);
            
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_script.ucx"), true);
            Lib.wait_Sleep(WaitTime);
			//step16
            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document"));
//            Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_file_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "");
			//step17
			driver.findElement(AppElements.Input_Field).clear();
            Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Doc_file_delete");
            Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
            Lib.wait_Sleep(2000);
            
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Document/UI_Org_Doc_file_delete.rex"), true);
            //step18
            Lib.DirFile(driver, "Document").click();
            Lib.wait_Sleep(2000);

            FileListTable fileListTable = new FileListTable(driver, "filelist");
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_delete.rex"), true);
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(fileListTable, 1, ExpectedValue); 

            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_folder_01"), true);
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_folder_02"), true);
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_delete.rex"), true);
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_Drink.rex"), true);
           //step19
            Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_Drink.rex"));
            Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Doc_file_Drink.rex"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Doc_file_Drink.rex"), true);

            //step20
            driver.findElement(AppElements.FileList_Download("UI_Org_Doc_file_Drink.rex")).click();
            Lib.wait_Sleep(5000);
            Lib.isFileDownloaded(downloadpath, "UI_Org_Doc_file_Drink.rex");
            
            //step22
            Lib.mouseMoveToElement(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_delete.rex")); 
            Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("UI_Org_Doc_file_delete.rex"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("UI_Org_Doc_file_delete.rex"), true);
            //step23
            driver.findElement(AppElements.FileList_Delete("UI_Org_Doc_file_delete.rex")).click();
            Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            //step24
            driver.findElement(AppElements.Delete_OK).click();
            Lib.wait_Sleep(WaitTime);
            fileListTable = new FileListTable(driver, "filelist");
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_delete.rex"), false);

            //step25
            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_Drink_new.rex"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
            Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            //step26
            driver.findElement(AppElements.Delete_OK).click();
            Lib.wait_Sleep(WaitTime);
            fileListTable = new FileListTable(driver, "filelist");
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_Drink_new.rex"), false);

            //step27
            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_script.ucx"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
            Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            driver.findElement(AppElements.Delete_OK).click();
            Lib.wait_Sleep(WaitTime);
            fileListTable = new FileListTable(driver, "filelist");
            Lib.chkIsDisplayed(driver, fileListTable.getRowElementBy("UI_Org_Doc_file_script.ucx"), false);
            
            
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_file_Drink_new.rex"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_Drink_new.rex"));
	            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
	            Lib.wait_Sleep(1000);
	            driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_file_delete.rex"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_delete.rex"));
	            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
	            Lib.wait_Sleep(1000);
	            driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_file_Drink_copy.rex"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_Drink_copy.rex"));
	            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
	            Lib.wait_Sleep(1000);
	            driver.findElement(AppElements.Delete_OK).click();
			}
			
			if (Lib.isExist(Lib.DirFile(driver,"Document/UI_Org_Doc_file_script.ucx"))) {
	            Lib.mouseRightClick(driver, Lib.DirFile(driver,"Document/UI_Org_Doc_file_script.ucx"));
	            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Delete).click();
	            Lib.wait_Sleep(1000);
	            driver.findElement(AppElements.Delete_OK).click();
			}
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_16_Service_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			//step01
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Service"));
			//step02
			driver.findElement(AppElements.LeftTree_Service).click();
			Lib.wait_Sleep(2000);
			String string = driver.findElement(By.id("externalAppIframe")).getAttribute("innerText");
			if (!string.equals("")) {
				Lib.assertfail("Service not blank","Service page should be blank");
			}
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services"), true);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/REST Services"), true);
            //step03
			Lib.DirFile(driver, "Service/Web Services").click();
			
			//step04
			Lib.DirFile(driver, "Service/REST Services").click();	
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_17_Service_and_folder_Menu_list(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Service"));
			driver.findElement(AppElements.LeftTree_Service).click();
			//step01
			Lib.mouseRightClick(driver, AppElements.LeftTree_Service);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Test, true);
			//step02
			driver.findElement(AppElements.RIGHTCLICK_Service_Menu_Test).click();
			
			Lib.wait_Sleep(WaitTime);
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
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), true);
			//step05
			driver.findElement(AppElements.DIF_Testing_Page_addInputLabel_X(2)).click();
			driver.findElement(AppElements.DIF_Testing_Page_addOutputLabel_X(2)).click();
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), false);
			
			//step06
			driver.findElement(AppElements.DIF_Testing_Page_addInputLabel_X(1)).click();
			driver.findElement(AppElements.DIF_Testing_Page_addOutputLabel_X(1)).click();
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutput , true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInput , true);

			Lib.SwitchToFrame(driver, "moduleFrame");
			//step07
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Database"));
            driver.findElement(AppElements.RIGHTCLICK_Services_Menu_NewDatabase).click();
			
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_a_database_name);
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "");
			Lib.wait_Sleep(2000);
            //step08
            driver.findElement(AppElements.Input_Close).click();
            
            //step09
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Web Services"));
            driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
			Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_button_Add, true);
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_Addfromwebserviceurl, "value", "http://www.dneonline.com/calculator.asmx?wsdl");
           //step10
            driver.findElement(AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile).click();
			Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_button_Add, true);

            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
            //step11
            Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(AppElements.AddAwebservice_button_Upload_WSDLXSD_file)).click().perform();
	     //windows operate 
	        AutoWin.winActivate("打开");
		    Lib.wait_Sleep(2000);
		    //step12
	        AutoWin.controlClick("打开", "取消", "Button2");
	        Lib.wait_Sleep(3000);
            
            Lib.SwitchToFrame(driver, "moduleFrame");
            Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/REST Services"));
            driver.findElement(AppElements.RIGHTCLICK_RESTServices_Menu_AddRestservice).click();
		    Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_ServiceName, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_DescriptionOptional, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_label_HTTP$HTTPS_URL, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAHTTP$HTTPS_API_button_Submit, true);

            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_ServiceName, "value", "");
            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_DescriptionOptional, "value", "");
            Lib.ChkProperty(driver, AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL, "value", "");
            
            driver.findElement(AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL).click();
            Lib.selectByText(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, "GET");
            Lib.selectByText(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, "POST");
            Lib.selectByText(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, "PUT");
            Lib.selectByText(driver, AppElements.AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL, "DELETE");

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Test  issue: add function no response.
	public void Organization_GUI_18_Service_file_information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Service"));
			Lib.wait_Sleep(3000);

			//step01
			Lib.DirFile(driver, "Service/Web Services/WebTest").click();
			Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.WebTest_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Description, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Status, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Type, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Endpoint, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_CreateTime, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_Processes, true);
            Lib.chkIsDisplayed(driver, AppElements.WebTest_label_downloadOwls, true);
            
            Lib.ChkProperty(driver, AppElements.WebTest_value_Description, "textContent", "test");
            Lib.ChkProperty(driver, AppElements.WebTest_value_Type, "textContent", "Webservice");
            Lib.ChkProperty(driver, AppElements.WebTest_value_Endpoint, "textContent", "http://www.dneonline.com/calculator.asmx");
            Lib.ChkProperty(driver, AppElements.WebTest_value_CreateTime, "textContent", "2019-03-06 01:40:30");
            
			List<String> ProcessesExpecteds = Arrays.asList("Add","Divide","Multiply","Subtract");
			List<String> TableActuals = Lib.GetTableActuals(driver.findElement(AppElements.WebTest_values_Processes));
			Lib.assertEquals(TableActuals, ProcessesExpecteds);   
			
            //step02
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/WebTest/Add"), true);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/WebTest/Divide"), true);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/WebTest/Multiply"), true);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/WebTest/Subtract"), true);
            //step03
			Lib.wait_Sleep(3000);
			if (!Lib.isExist(driver, AppElements.Console_expand)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}
			Lib.wait_Sleep(3000);
			Lib.DirFile(driver, "Service/Web Services/WebTest/Add").click();
			Lib.wait_Sleep(3000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
			Lib.assertEquals(driver.findElement(AppElements.WebTest$Add_Table_ColHeader).getAttribute("textContent"), "NameMin OccursMax OccursTypeDefaultMapping"); 

            //step04
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Service/REST Services/RestService").click();
			Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Description, true);
            Lib.ChkProperty(driver, AppElements.RestTest_value_Description, "textContent", "test");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Status, true);
            Lib.ChkProperty(driver, AppElements.RestTest_value_Status, "checked", "true");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_Type, true);
            Lib.ChkProperty(driver, AppElements.RestTest_value_Type, "textContent", "Restful");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_URL, true);
            Lib.ChkProperty(driver, AppElements.RestTest_value_URL, "textContent", "[GET]  http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_label_CreateTime, true);
            Lib.ChkProperty(driver, AppElements.RestTest_value_CreateTime, "textContent", "2019-03-29 03:59:08");
            Lib.chkIsDisplayed(driver, AppElements.RestTest_button_Add, true);

            //step05  issue: add function no response.
            driver.findElement(AppElements.RestTest_button_Add).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Newprocess_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.Newprocess_label_Name, true);                                   
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_input_Name, true);   
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_label_Description, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_input_Description, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_label_CacheTime, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_input_CacheTime, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_tab_Request, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_tab_Response, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_input_Request, true);
			
            driver.findElement(AppElements.Newprocess_tab_Response).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_input_Response, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_button_Close, true); 
			Lib.chkIsDisplayed(driver, AppElements.Newprocess_button_Save, true); 
            Lib.ChkProperty(driver, AppElements.Newprocess_input_Name, "textContent", "");
            Lib.ChkProperty(driver, AppElements.Newprocess_input_Description, "textContent", "");
            Lib.ChkProperty(driver, AppElements.Newprocess_input_CacheTime, "textContent", "");

            //step06
            driver.findElement(AppElements.Newprocess_button_Close).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Newprocess_Title, false);
            Lib.SwitchToFrame(driver, "moduleFrame");
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			//还原数据
			
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test   
	public void Organization_GUI_19_Service_file_Menu_list(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Service).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Service"));
			Lib.wait_Sleep(3000);

//			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/REST Services/Rest"));
//            driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();
//            driver.findElement(AppElements.Delete_Yes).click();

			//step01
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Web Services"));
            driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
            Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional , true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true);
            Lib.chkIsDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile , true);
            
            driver.findElement(AppElements.AddAwebservice_input_WebserviceName).sendKeys("Web");
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "Web");
            driver.findElement(AppElements.AddAwebservice_button_Add).click();
			Lib.wait_Sleep(7000);
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/Web"), true);

            //step02
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Web Services/Web"));
            driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click();

			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            Lib.chkIsDisplayed(driver, AppElements.Delete_Cancel, true);
            Lib.chkIsDisplayed(driver, AppElements.Delete_OK, true);
			Lib.wait_Sleep(2000);
            //step03
			
//			Lib.highlight(driver, driver.findElement(AppElements.Delete_Yes)); 
			Actions action =new Actions(driver);
			action.moveToElement(driver.findElement(AppElements.Delete_OK));
			action.doubleClick(driver.findElement(AppElements.Delete_OK));
          action.perform();

			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/Web Services/Web"), false);

            //step04
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Service/REST Services"));
            driver.findElement(AppElements.RIGHTCLICK_RESTServices_Menu_AddRestservice).click();
			Lib.wait_Sleep(2000);
            Lib.SwitchToFrame(driver, "externalAppIframe");
            driver.findElement(AppElements.AddAHTTP$HTTPS_API_input_ServiceName).sendKeys("Rest");
            driver.findElement(AppElements.AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL).sendKeys("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.AddAHTTP$HTTPS_API_button_Submit).click();
           
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/REST Services/Rest"), true);
            
			//step05
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Service/REST Services/Rest"));
            driver.findElement(AppElements.RIGHTCLICK_RESTService_Menu_Delete).click();

			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            Lib.chkIsDisplayed(driver, AppElements.Delete_Cancel, true);
            Lib.chkIsDisplayed(driver, AppElements.Delete_OK, true);
			Lib.wait_Sleep(3000);
            //step06
            driver.findElement(AppElements.Delete_OK).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Service/REST Services/Rest"), false);

            //step07
            if (Lib.isExist(Lib.DirFile(driver, "Service/Web Services/Web"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Web Services/Web"));
                driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}
            
            if (Lib.isExist(Lib.DirFile(driver, "Service/REST Services/Rest"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/REST Services/Rest"));
                driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}
    
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
            if (Lib.isExist(Lib.DirFile(driver, "Service/Web Services/Web"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/Web Services/Web"));
                driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
//    			Actions action =new Actions(driver);
//    			action.moveToElement(driver.findElement(AppElements.Delete_Yes));
//    			action.click(driver.findElement(AppElements.Delete_Yes));
//              action.perform();
                driver.findElement(AppElements.Delete_OK).click();

			}
            
            if (Lib.isExist(Lib.DirFile(driver, "Service/REST Services/Rest"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Service/REST Services/Rest"));
                driver.findElement(AppElements.RIGHTCLICK_WebService_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}
            
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_20_Template_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Service).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			Lib.wait_Sleep(3000);
			driver.findElement(AppElements.LeftTree_Template).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
            //step02
			FileListTable table = new FileListTable(driver, "filelist");
            String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(table, 1, ExpectedValue);
			int row = table.getRowByFileName("Template_test_01.xlsx");
			Lib.assertEquals(table.getModifierData(row), "uitest");
			Lib.assertEquals(table.getCreatorData(row), "uitest");
			//step03
			Lib.mouseMoveToElement(driver, table.getRowElement("Template_test_01.xlsx"));
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Download("Template_test_01.xlsx"), true);
            Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("Template_test_01.xlsx"), true);
            //step04
			driver.findElement(AppElements.FileList_Download("Template_test_01.xlsx")).click();
			Lib.wait_Sleep(3000);
            Lib.isFileDownloaded(downloadpath, "Template_test_01.xlsx");
			//step05
			Lib.mouseMoveToElement(driver, table.getRowElement("Template_test_01.xlsx"));
			driver.findElement(AppElements.FileList_Delete("Template_test_01.xlsx")).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            Lib.chkIsDisplayed(driver, AppElements.Delete_Cancel, true);
            Lib.chkIsDisplayed(driver, AppElements.Delete_OK, true);
			Lib.wait_Sleep(3000);
            //step06
            driver.findElement(AppElements.Delete_Cancel).click();
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, table.getRowElement("Template_test_01.xlsx"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);

			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_21_Template_Menu_list(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Template).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			Lib.wait_Sleep(3000);
            //step01
			Lib.mouseRightClick(driver, AppElements.LeftTree_Template);
			//step02
			driver.findElement(AppElements.RIGHTCLICK_Template_Menu_NewTemplate).click();
			
			Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_InputBox, true);
			Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_Close, true);
			Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_Finish, true);

			driver.findElement(AppElements.NewTemplate_NewWindow_Close).click();

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);

			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_22_Template_file_Information(){
		try {
			Lib.wait_Sleep(1000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Template).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			Lib.wait_Sleep(3000);
            //step01			
			Lib.DirFile(driver,"Template/UI_Org_Data_file_nidef.xlsx").click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
            
            //step03
            driver.findElement(AppElements.Menu_bar_history).click();
			Lib.wait_Sleep(5000);
			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
            
            driver.findElement(AppElements.Version_History_Show).click();

			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			Lib.changeWindow(driver);
			String url = driver.getCurrentUrl();
			MMDriver.softAssert.assertTrue(url.contains("http://www.cyberobject.com.cn"), "The line number is " + new Exception().getStackTrace()[0].getLineNumber() + "; New window open failed!@@\\n\\t,");
			
			driver.close();
			driver.switchTo().window(currentWindow);
			driver.switchTo().frame("moduleFrame");
			Lib.wait_Sleep(1000);
			
			driver.findElement(AppElements.AppDirectoryList("UI_Org_Data_file_nidef.xlsx")).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);

            driver.findElement(AppElements.Menu_bar_history).click();
			Lib.wait_Sleep(5000);
			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
            
            driver.findElement(AppElements.Version_History_CheckOut).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);

			 if (!Lib.isExist(driver, AppElements.Console_expand)) {
				  driver.findElement(AppElements.Console_arrow_left).click();
			}

            Lib.Clear_ConsoleMsg(driver);
            driver.findElement(AppElements.Menu_bar_Refresh).click();
            Lib.CheckConsoleMsg(driver, "NPUTMANUALLY info is empty!");
            
            driver.findElement(AppElements.Menu_bar_ExcelUncheck).click();
            Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelCheckout, true);
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);

			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Organization_GUI_23_Template_file_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "Organization");
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Template).click();
			Lib.wait_Sleep(2000);
			Lib.ExpandNode(driver, AppElements.AppDirectoryList_Arrow("Template"));
			Lib.wait_Sleep(2000);
			//step01
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef.xlsx"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Refresh, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download, true);
            //step02
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
			Lib.wait_Sleep(WaitTime);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content , AppBChkPoint.Please_enter_the_new_file_name);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            //step03
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_file_nidef_name.xlsx");
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef_name.xlsx"), true);
            //step04
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_Data_folder_02/UI_Org_Data_file_termdef.xlsx"));

            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_SaveAsTemplate).click();
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_file_termdef.xlsx");
			Lib.wait_Sleep(WaitTime);
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"), true);
            //step05
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"));
            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			Lib.wait_Sleep(2000);
            Lib.chkTextContent(driver, AppElements.Delete_MSG_Content, AppBChkPoint.Are_you_sure_you_want_to_remove_this_file);
            Lib.chkIsDisplayed(driver, AppElements.Delete_Cancel, true);
            Lib.chkIsDisplayed(driver, AppElements.Delete_OK, true);
			//step06
            driver.findElement(AppElements.Delete_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"), false);
            //step07
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef_name.xlsx"));
            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Copy).click();
            //step08
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data"));
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Paste).click();
			Lib.wait_Sleep(WaitTime);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_data_name);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            //step09
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"), true);
            //step10
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"));
            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click();
			Lib.wait_Sleep(2000);
            driver.findElement(AppElements.Delete_OK).click();
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"), false);
            //step11
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef_name.xlsx"));
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            driver.findElement(AppElements.Input_Field).clear();
            driver.findElement(AppElements.Input_Field).sendKeys("UI_Org_Data_file_nidef.xlsx");
			Lib.wait_Sleep(2000);
            driver.findElement(AppElements.Input_OK).click();
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef.xlsx"), true);
            //step12
			Lib.wait_Sleep(3000);
			
            if (!Lib.isExist(driver, AppElements.Console_Window)) {
            	driver.findElement(AppElements.Console_arrow_left).click();
            	Lib.wait_Sleep(3000);
			}

            Lib.chkIsDisplayed(driver, AppElements.Console_Window, true);
            Lib.Clear_ConsoleMsg(driver);       
            //step13
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef.xlsx"));
            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Refresh).click();

            Lib.CheckConsoleMsg(driver, "NPUTMANUALLY info is empty!");
			
			//step14
            Lib.mouseRightClick(driver,Lib.DirFile(driver, "Template/UI_Org_Data_file_nidef.xlsx"));
            driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Download).click();
			Lib.wait_Sleep(3000);
			Lib.isFileDownloaded(downloadpath, "UI_Org_Data_file_nidef.xlsx");
            //step15
            //step16
            if (Lib.isExist(Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"));
                driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}

            if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"));
                driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}   
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
            if (Lib.isExist(Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Template/UI_Org_Data_file_termdef.xlsx"));
                driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}

            if (Lib.isExist(Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"))) {
    			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/UI_Org_Data_file_nidef_name.xlsx"));
                driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Delete).click(); 
    			Lib.wait_Sleep(3000);
                driver.findElement(AppElements.Delete_OK).click();
			}
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}

}
