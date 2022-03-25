package testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import com.google.common.collect.Table;
//import com.thoughtworks.selenium.Wait.WaitTimedOutException;
import checkpoints.AppBChkPoint;
import objectRepository.*;
import prepare.MMDriver;
import utils.FileListTable;
import utils.Lib;
import utils.PropertiesDataProvider;
import utils.WebList;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

public class IPlatform_GUI {
	WebDriver driver = null;
	AutoItX AutoWin = null;
	int WaitTime = 0;
	String downloadpath = "";
	String UserName = "fanming@cyberobject.com.cn";
	String Password = "123456";
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
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Lib.login_AppBuilder(driver, UserName, Password);
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		WaitTime = Integer.parseInt(sWaitTime);	
		Lib.wait_Sleep(2000);
		driver.switchTo().frame("moduleFrame");
		
        if (!Lib.isExist(driver, AppElements.Switch_App_Window_Title)) {
    		driver.switchTo().defaultContent();
    		driver.findElement(AppElements.Menu_bar_Apps).click();
    		driver.switchTo().frame("moduleFrame");
        }
		driver.findElement(AppElements.SwitchAppMenu_CustomObj("iplatform")).click();
	}

	@AfterClass
	public void afterClass() {
		//Debug 请注释以下三行
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
		//切换到正确的测试app下
		if (!Lib.isDisplayed(driver, AppElements.LeftTreeTop_iplatform, true, 3)) {
			driver.findElement(AppElements.Menu_bar_list_apps).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Display_OrgID_CustomObj("iplatform")).click();
		}
		
		if(Lib.isDisplayed(driver, AppElements.LeftTree_Data_arrow, true, 3)) {
			driver.findElement(AppElements.LeftTree_Data_arrow).click();
		}
		
//		driver.findElement(AppElements.LeftTree_iplatform).click();
		
	
	}

	@AfterMethod
	public void afterMethod() {
//		MMDriver.softAssert.assertAll();
	}

	@Test
	public void IPlatform_GUI_01_iplatform_Menu_bar(){
		try {	
			Lib.wait_Sleep(2000);
            Lib.SwitchApp(driver);
			Lib.wait_Sleep(1000);
			driver.findElement(AppElements.SwitchAppMenu_CustomObj("iplatform")).click();
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_list_apps, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_List_app_templates, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_New_app, true);
			Lib.wait_Sleep(WaitTime);
			
			driver.switchTo().defaultContent();
			driver.findElement(AppElements.Menu_bar_UserName("yulei")).click();
			Lib.chkIsDisplayed(driver, AppElements.SIGNOUT, true);
			
			driver.findElement(AppElements.Apps_btn_downarrow).click();
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_New, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Switch, true);
          //When mouse move on,Can not displayed tag_Text
//			Lib.mouseMoveToElement(driver, AppElements.Menu_bar_New);
//			Lib.chkIsDisplayed(driver, AppElements.Red_tag_Text_CustomObj("Create a new App"), true);
//			
//			Lib.mouseMoveToElement(driver, AppElements.Menu_bar_Switch);
//			Lib.chkIsDisplayed(driver, AppElements.Red_tag_Text_CustomObj("Switch to another App"), true);

			driver.findElement(AppElements.Menu_bar_New).click();
			driver.switchTo().frame("moduleFrame");
			Lib.wait_Sleep(WaitTime);
			Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.Please_login_with_iplatform_admin_user_to_new_APP);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Err_Message_OK).click();
			Lib.wait_Sleep(WaitTime);
			driver.switchTo().defaultContent();
			driver.findElement(AppElements.Apps_btn_downarrow).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Menu_bar_Switch).click();
			Lib.wait_Sleep(3000);
			driver.switchTo().frame("moduleFrame");
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("iplatform"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_OrgID_CustomObj("Organization"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("Derick","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app","Listapps"), true);
//			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_test","Listapps"), true);
            //Close Switch App window
			driver.findElement(AppElements.Switch_App_Window_Close).click();
             
            //左边arrow
			driver.findElement(AppElements.left_collapsible_arrow).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Left_Section_panel, false);
			
			//左边arrow
			driver.findElement(AppElements.left_Expand_arrow).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Left_Section_panel, true);
			
			driver.findElement(AppElements.Menu_bar_New_app).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkTextContent(driver,AppElements.ErrMessage_content, AppBChkPoint.Please_login_with_iplatform_admin_user_to_new_APP);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Err_Message_OK).click();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Menu_bar_list_apps).click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("Derick","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app","Listapps"), true);
//			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_test","Listapps"), true);

			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Menu_bar_List_app_templates).click();
			Lib.wait_Sleep(3000);
            //you can add temp data to check this point.
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("ers_template","Listapptemplates"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app_temp","Listapptemplates"), true);
		} catch (Exception e) {
			// TODO: handle exception
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}

	@Test
	public void IPlatform_GUI_02_iplatform_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, AppElements.LeftTreeTop_iplatform);	
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_New_app, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_List_app_templates, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_List_apps, true);
			driver.findElement(AppElements.RIGHTCLICK_New_app).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkTextContent(driver, AppElements.ErrMessage_content, AppBChkPoint.Please_login_with_iplatform_admin_user_to_new_APP);
			driver.findElement(AppElements.Err_Message_OK).click();

			Lib.wait_Sleep(1000);
			Lib.mouseRightClick(driver, AppElements.Menu_bar_AppName("iplatform"));
			driver.findElement(AppElements.RIGHTCLICK_List_apps).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("Derick","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("derick_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("fm_app","Listapps"), true);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("wmx_app","Listapps"), true);
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.Menu_bar_AppName("iplatform"));
			driver.findElement(AppElements.RIGHTCLICK_List_app_templates).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Display_AppID_CustomObj("a00","Listapptemplates"), true);
		} catch (Exception e) {
			// TODO: handle exception
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(e.getMessage() + "@@\n");
			
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_03_Data_Information(){
		try {
			Lib.wait_Sleep(2000);
//			driver.switchTo().frame("moduleFrame");
			driver.findElement(AppElements.LeftTree_Data).click();
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);

			FileListTable Data_table = new FileListTable(driver, "filelist");
			MMDriver.softAssert.assertEquals(Data_table.getFileNameData(1), "FileName", AppBChkPoint.AssertMsg("", "FileName", Data_table.getFileNameData(1)));
			MMDriver.softAssert.assertEquals(Data_table.getModifiedData(1), "Modified", AppBChkPoint.AssertMsg("", "Modified", Data_table.getModifiedData(1)));
			MMDriver.softAssert.assertEquals(Data_table.getModifierData(1), "Modifier", AppBChkPoint.AssertMsg("", "Modifier", Data_table.getModifierData(1)));
			MMDriver.softAssert.assertEquals(Data_table.getCreatorData(1), "Creator", AppBChkPoint.AssertMsg("", "Creator", Data_table.getCreatorData(1)));
			
			Lib.isDisplayed(driver, Data_table.getRowElementBy("address"), true, 3);
			Lib.isDisplayed(driver, Data_table.getRowElementBy("app_termdef.xlsx"), true, 3);
			Lib.isDisplayed(driver, Data_table.getRowElementBy("flow_logicdef.xlsx"), true, 3);
			Lib.isDisplayed(driver, Data_table.getRowElementBy("flow_termdef.xlsx"), true, 3);
			Lib.isDisplayed(driver, Data_table.getRowElementBy("sparkle.xlsx"), true, 3);

//			Lib.highlight(driver, driver.findElement(Data_table.getRowElementBy("app_termdef.xlsx")));
			Lib.mouseMoveToElement(driver,Data_table.getRowElementBy("app_termdef.xlsx"));
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.FileList_Download("app_termdef.xlsx"), true);
			Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("app_termdef.xlsx"), true);
			driver.findElement(AppElements.FileList_Download("app_termdef.xlsx")).click();
			Lib.wait_Sleep(5000);
			MMDriver.softAssert.assertTrue(Lib.isFileDownloaded(downloadpath, "app_termdef.xlsx"), "download!");
			
		} catch (Exception e) {
			// TODO: handle exception
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_04_Data_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
//			driver.switchTo().frame("moduleFrame");
			Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
			Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Data_Menu_import);
			Lib.wait_Sleep(WaitTime);
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
          
          Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
          driver.findElement(AppElements.RIGHTCLICK_Data_Menu_New).click();
          Lib.chkTextContent(driver, AppElements.Input_MSG_Content,  "Please enter a folder name:");
          Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
          Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
          driver.findElement(AppElements.Input_Close).click();
            
          Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
          driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newsheet).click();
            
          Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title, true);
          Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Command_Xlsx, true);

          driver.findElement(AppElements.New_Sheet_Close).click();
          
          Lib.mouseRightClick(driver,AppElements.LeftTree_Data);
          driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Uploadsheet).click();
          Lib.chkIsDisplayed(driver, AppElements.Upload_Please_select_excel_file_to_upload, true);
          driver.findElement(AppElements.Upload_sheet_close).click();
   
		} catch (Exception e) {
			// TODO: handle exception
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_05_Data_folder_Information(){
		try {
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Data).click();
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			FileListTable Data_table = new FileListTable(driver, "filelist");
			driver.findElement(Data_table.getRowElementBy("address")).click();

			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
			
			String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
            Lib.ChkFileTableDataByRow(Data_table, 1, ExpectedValue);
		
			//表格内容更新，需要同步
			Data_table = new FileListTable(driver, "filelist");
//			int row = Data_table.getRowByFileName("ni_state.xlsx");			            
			Lib.assertEquals(Data_table.getModifiedData(2), "07-09-19 04:27:34");
			Lib.mouseMoveToElement(driver,Data_table.getRowElementBy("ni_state.xlsx"));
			Lib.chkIsDisplayed(driver, AppElements.FileList_Download("ni_state.xlsx"), true);
			Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("ni_state.xlsx"), true);
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_06_Data_folder_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Copy, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Delete, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Rename, true);
            Lib.wait_Sleep(WaitTime);
            Lib.mouseMoveToElement(driver,AppElements.RIGHTCLICK_Data_Menu_import);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import_Database, true);
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_import_Database).click();
            Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow, true);
            Lib.chkIsDisplayed(driver, AppElements.ImportDataBaseWindow_Close, true);
            driver.findElement(AppElements.ImportDataBaseWindow_Close).click();
            
            Lib.wait_Sleep(WaitTime);
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_New).click();

			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_a_folder_name);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
			driver.findElement(AppElements.Input_Close).click();            
			
			Lib.wait_Sleep(WaitTime);
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Rename).click();
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_new_folder_name);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            Lib.ChkProperty(driver, AppElements.Input_Field, "value", "address");
			driver.findElement(AppElements.Input_Close).click();
			
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Copy).click();
            Lib.wait_Sleep(WaitTime);
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Copy, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Delete, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Rename, true);
            
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Newsheet).click();
            Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Title, true);
            Lib.chkIsDisplayed(driver, AppElements.New_Sheet_Close, true);
            driver.findElement(AppElements.New_Sheet_Close).click();
            Lib.wait_Sleep(WaitTime);
            Lib.mouseRightClick(driver, AppElements.AppDirectoryList("address"));
            driver.findElement(AppElements.RIGHTCLICK_Data_Menu_Uploadsheet).click();
            Lib.chkIsDisplayed(driver, AppElements.Upload_Please_select_excel_file_to_upload, true);
            Lib.chkIsDisplayed(driver, AppElements.Upload_sheet_close, true);
            driver.findElement(AppElements.Upload_sheet_close).click();
	
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}


	@Test
	public void IPlatform_GUI_07_Data_file_Information(){
		try {
			Lib.wait_Sleep(2000);
//			driver.switchTo().frame("moduleFrame");
			Lib.DirFile(driver, "Data/flow_logicdef.xlsx").click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Refresh, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			
			Lib.wait_Sleep(5000);
			driver.findElement(AppElements.Menu_bar_Checkout).click();
			Lib.wait_Sleep(5000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_ExcelTrain, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Refresh, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Save, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			
			driver.findElement(AppElements.Menu_bar_history).click();
			Lib.wait_Sleep(5000);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Title, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Close, true);
			String[] TableColumExpecteds = new String[4];
			TableColumExpecteds[0] = "Id";
			TableColumExpecteds[1] = "UserId";
			TableColumExpecteds[2] = "Time";
			TableColumExpecteds[3] = "Notes";
			for (String TablecolumExpected : TableColumExpecteds) {
				Lib.chkIsDisplayed(driver, By.xpath("//span[text()='"+ TablecolumExpected +"']"), true);
			}

			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);

			driver.findElement(AppElements.Version_History_Close).click();
			Lib.wait_Sleep(5000);
			driver.findElement(AppElements.Menu_bar_Uncheck).click();
			Lib.wait_Sleep(5000);

			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_08_Data_file_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, Lib.DirFile(driver, "Data/flow_logicdef.xlsx"));
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Train, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Refresh, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_SaveAsTemplate, true);

			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the file new name:");
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "flow_logicdef.xlsx");
			Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
			Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);

			driver.findElement(AppElements.Input_Close).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.AppDirectoryList("flow_logicdef.xlsx")).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("flow_logicdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_SaveAsTemplate).click();
			Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the template name:");
			Lib.ChkProperty(driver, AppElements.Input_Field, "value", "");
			Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
			Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
			driver.findElement(AppElements.Input_Close).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("flow_logicdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Copy).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Paste, true);
            driver.findElement(AppElements.AppDirectoryList("flow_logicdef.xlsx")).click();
			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("flow_logicdef.xlsx"));
			driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Download).click();
			Lib.wait_Sleep(5000);
		    Lib.assertTrue("Is flow_logicdef.xlsx download?", Lib.isFileDownloaded(downloadpath, "flow_logicdef.xlsx"));

		} catch (NoSuchElementException e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_09_Document_Information(){
		try {
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.AppDirectoryList("Document")).click();
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			
			FileListTable Data_table = new FileListTable(driver, "filelist");
			Lib.chkIsDisplayed(driver, Data_table.getRowElementBy("resume.rex"), true);
			driver.findElement(Data_table.getRowElementBy("resume.rex")).click();
			Lib.wait_Sleep(3000);
			//检查resume.rex内容
			Lib.SwitchToFrame(driver,"visio_file_iframe");
			Lib.chkIsDisplayed(driver, By.xpath("//div[text()='entry-resume']"), true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_10_Document_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Deploy, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_New_Doc, true);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Upload_Doc, true);

            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New).click();
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter a folder name:");
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            driver.findElement(AppElements.Input_Close).click();

			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Script).click();
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the file name:");
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            driver.findElement(AppElements.Input_Close).click();
            
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_New_Doc).click();
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the file name:");
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            driver.findElement(AppElements.Input_Close).click();
            
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Document"));
            driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Upload_Doc).click();
            AutoWin.winActivate("打开");
			Lib.wait_Sleep(2000);
    		AutoWin.controlClick("打开", "取消", "2");

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_11_Document_Menu_list(){
		try {	
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.AppDirectoryList("Document")).click();
			Lib.wait_Sleep(2000);
			FileListTable Data_table = new FileListTable(driver, "filelist");
			Lib.chkIsDisplayed(driver, Data_table.getRowElementBy("resume.rex"), true);
			driver.findElement(Data_table.getRowElementBy("resume.rex")).click();
			Lib.wait_Sleep(5000);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Train, true);
            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Deploy, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);

			//检查resume.rex内容
			Lib.SwitchToFrame(driver,"visio_file_iframe");
			Lib.chkIsDisplayed(driver, By.xpath("//div[text()='entry-resume']"), true);
			Lib.SwitchToFrame(driver, "moduleFrame");
			driver.findElement(AppElements.Menu_bar_history).click();

			Lib.wait_Sleep(5000);
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

			//点击表格第一行数据
			Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			Lib.wait_Sleep(2000);
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
			
			driver.findElement(AppElements.Menu_bar_Uncheck).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_12_Document_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
			if(Lib.isExist(driver, AppElements.LeftTree_Document_arrow)) {
				driver.findElement(AppElements.LeftTree_Document_arrow).click();
			}
			Lib.wait_Sleep(3000);
			Lib.mouseRightClick(driver , Lib.DirFile(driver , "Document/resume.rex"));
            Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Rename).click();
			Lib.wait_Sleep(3000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter the file new name:");
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            driver.findElement(AppElements.Input_Close).click();
			
			Lib.mouseRightClick(driver , Lib.DirFile(driver , "Document/resume.rex"));
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Copy).click();
			Lib.wait_Sleep(3000);
			
//			driver.findElement(AppElements.LeftTree_Document).click();
			Lib.mouseRightClick(driver, AppElements.LeftTree_Document);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Paste, true);
            Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.LeftTree_Data).click();

			Lib.mouseRightClick(driver , Lib.DirFile(driver , "Document/resume.rex"));
			Lib.wait_Sleep(WaitTime);
            Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Document_Menu_Download, true);
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Download).click();
			Lib.wait_Sleep(5000);

			Lib.isFileDownloaded(downloadpath, "resume.rex");		
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_13_Service_Information(){
		try {		
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.LeftTree_Service).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
//			Lib.SwitchToFrame(driver, "externalAppIframe");
			Lib.chkIsDisplayed(driver, By.xpath("//iframe[starts-with(@src,'about:blank')]"), true);
			
//			Lib.SwitchToFrame(driver, "moduleFrame");

			if (Lib.isExist(driver, AppElements.LeftTree_Service_arrow)) {
			   driver.findElement(AppElements.LeftTree_Service_arrow).click();
			}
			 Lib.isDisplayed(driver, AppElements.AppDirectoryList("Service","Database"), true, 3);
			 Lib.isDisplayed(driver, AppElements.AppDirectoryList("Service","Web Services"), true, 3);
			 Lib.isDisplayed(driver, AppElements.AppDirectoryList("Service","REST Services"), true, 3);
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_14_Service_Menu_list(){
		try {
			Lib.wait_Sleep(2000);
            Lib.mouseRightClick(driver, AppElements.LeftTree_Service);
//			Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Service_Menu_NewService);
//			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Database, true);
//			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Newfolder, true);
			Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Service_Menu_Test, true);
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

			driver.findElement(AppElements.DIF_Testing_Page_addInput).click();
			driver.findElement(AppElements.DIF_Testing_Page_addOutput).click();
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);

			driver.findElement(AppElements.DIF_Testing_Page_addInput).click();
			driver.findElement(AppElements.DIF_Testing_Page_addOutput).click();
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), true);

			driver.findElement(AppElements.DIF_Testing_Page_addInputLabel_X(2)).click();
			driver.findElement(AppElements.DIF_Testing_Page_addOutputLabel_X(2)).click();
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(2), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(2), false);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addInputLabel_X(1), true);
			Lib.chkIsDisplayed(driver, AppElements.DIF_Testing_Page_addOutputLabel_X(1), true);
	        Lib.SwitchToFrame(driver, "moduleFrame");
			if (Lib.isExist(driver, AppElements.LeftTree_Service_arrow)) {
				   driver.findElement(AppElements.LeftTree_Service_arrow).click();
				}
			Lib.wait_Sleep(2000);
			Lib.mouseRightClick(driver, Lib.DirFile(driver,"Service/Database"));
			driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_NewDatabase).click();
			Lib.wait_Sleep(4000);
            Lib.chkTextContent(driver, AppElements.Input_MSG_Content, "Please enter a database name:");
            Lib.chkIsDisplayed(driver, AppElements.Input_Close, true);
            Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
            driver.findElement(AppElements.Input_Close).click();
			Lib.wait_Sleep(WaitTime);
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Service","Web Services"));
			driver.findElement(AppElements.RIGHTCLICK_WebServices_Menu_AddWebService).click();
			Lib.wait_Sleep(3000);
            //不在同一webpage中，利用特殊方式识别
//			WebElement AddWebserviceObj = driver.findElement(By.xpath("//iframe[@id='externalAppIframe']"));
//			String Src = AddWebserviceObj.getAttribute("src");
//			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
//			driver=new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(Src);
			Lib.SwitchToFrame(driver, "externalAppIframe");
            Lib.isDisplayed(driver, AppElements.AddAwebservice_Title, true, 3);
            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_WebserviceName, true, 3);
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_WebserviceName, "value", "");
            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_DescriptionOptional, true, 3);
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_DescriptionOptional, "value", "");
            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_Addfromwebserviceurl, true, 3);
            Lib.isDisplayed(driver, AppElements.AddAwebservice_label_AddfromlocalWSDL$XSDfile, true, 3);
            Lib.ChkProperty(driver, AppElements.AddAwebservice_input_Addfromwebserviceurl, "value", "http://www.dneonline.com/calculator.asmx?wsdl");
            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Check, true, 3);
            Lib.isDisplayed(driver, AppElements.AddAwebservice_button_Add, true, 3);

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
            driver.findElement(AppElements.AddAwebservice_button_Upload_WSDLXSD_file).click();
			Lib.wait_Sleep(WaitTime);
            AutoWin.winWaitActive("打开");
			Lib.wait_Sleep(2000);
    		AutoWin.controlClick("打开", "取消", "2");
            
	        Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.mouseRightClick(driver, AppElements.AppDirectoryList("Service","REST Services"));
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
                      
//			driver.close();
//			driver.switchTo().window(currentWindow);		
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_15_Service_Menu_list(){
		try {
			  Lib.wait_Sleep(2000);
	         driver.findElement(AppElements.AppDirectoryList("Template")).click();
			 Lib.wait_Sleep(2000);
	         Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
	         Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
             FileListTable datatable = new FileListTable(driver, "filelist");
             String[] ExpectedValue = {"FileName","Modified","Modifier","Creator"};
	         Lib.ChkFileTableDataByRow(datatable, 1, ExpectedValue);
             String[] ExpectedValue_1 = {"Command.xlsx","04-02-19 02:39:32","gaomingjie","gaomingjie"};//测试数据受人为变动影响
	         Lib.ChkFileTableDataByRow(datatable, 3, ExpectedValue_1);
			
	         Lib.mouseMoveToElement(driver, datatable.getRowElementBy("Command.xlsx"));
			 Lib.chkIsDisplayed(driver, AppElements.FileList_Download("Command.xlsx"), true);
			 Lib.chkIsDisplayed(driver, AppElements.FileList_Delete("Command.xlsx"), true);
   
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_16_Template_Menu_list(){
		try {
			  Lib.wait_Sleep(2000);
	Lib.mouseRightClick(driver, AppElements.LeftTree_Template);
	Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Template_Menu_NewTemplate, true);
	driver.findElement(AppElements.RIGHTCLICK_Template_Menu_NewTemplate).click();
	Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_Title, true);
	Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_Finish, true);
	Lib.chkIsDisplayed(driver, AppElements.NewTemplate_NewWindow_InputBox, true);
    Lib.ChkProperty(driver, AppElements.NewTemplate_NewWindow_InputBox, "placeholder", "Please enter the template name");
	driver.findElement(AppElements.NewTemplate_NewWindow_Close).click();

		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}

	@Test
	public void IPlatform_GUI_17_Template_file_Information(){
		try {
			  Lib.wait_Sleep(2000);
	          Lib.SelectApp(driver, "iplatform");
			  driver.findElement(AppElements.LeftTree_Template).click();
		      FileListTable fileListTable = new FileListTable(driver, "filelist");			    
		      driver.findElement(fileListTable.getRowElementBy("TestHeader.xlsx")).click();
			  Lib.wait_Sleep(3000);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Refresh, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			  
			  driver.findElement(AppElements.Menu_bar_history).click();
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

			  //点击表格第一行数据
			  Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
		      Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
			  driver.findElement(AppElements.Version_History_Show).click();
				
			  String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			  Lib.changeWindow(driver);
			  String string = driver.getCurrentUrl();
			  Lib.assertTrue(string.contains("http://www.cyberobject.com.cn:8085/iplatform-ruleeditor/exceleditor/index.html"));			  
			  driver.close();
			  driver.switchTo().window(currentWindow);
			  driver.switchTo().frame("moduleFrame");
			  Lib.wait_Sleep(1000);
			  
			  driver.findElement(AppElements.Menu_bar_history).click();
			  Lib.wait_Sleep(2000);
			    //点击表格第一行数据
			  Lib.GetTableCellObj(driver.findElement(AppElements.Table_Version_History), 1, 2).click();
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_CheckOut, true);
			  Lib.chkIsDisplayed(driver, AppElements.Version_History_Show, true);
			  driver.findElement(AppElements.Version_History_CheckOut).click();
		      Lib.wait_Sleep(3000);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Refresh, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Save, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Uncheck, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkin, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_history, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear, true);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Clear_bubble, true);
			  driver.findElement(AppElements.Menu_bar_Uncheck).click();
			  Lib.wait_Sleep(5000);
			  Lib.chkIsDisplayed(driver, AppElements.Menu_bar_Checkout, true);
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IPlatform_GUI_18_Servbucice_Menu_list(){
		try {
	          Lib.SelectApp(driver, "iplatform");
			  driver.findElement(AppElements.LeftTree_Template).click();
		      FileListTable fileListTable = new FileListTable(driver, "filelist");			    
		      driver.findElement(fileListTable.getRowElementBy("TestHeader.xlsx")).click();
			  Lib.wait_Sleep(6000);
			  Lib.mouseRightClick(driver, AppElements.AppDirectoryList("TestHeader.xlsx"));
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Copy, true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Delete, true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Rename, true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Refresh, true);
			  Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Excel_Menu_Download, true);

			  driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Rename).click();
			  Lib.chkTextContent(driver, AppElements.Input_MSG_Content, AppBChkPoint.Please_enter_the_new_file_name);
	          Lib.chkIsDisplayed(driver, AppElements.Input_OK, true);
	          Lib.ChkProperty(driver, AppElements.Input_Field, "value", "TestHeader.xlsx");
	          driver.findElement(AppElements.Input_Close).click();
				
			  Lib.mouseRightClick(driver, AppElements.AppDirectoryList("TestHeader.xlsx"));
			  driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Copy).click();

			  Lib.mouseRightClick(driver, AppElements.LeftTree_Data);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu, true);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import, true);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_New, true);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Newsheet, true);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Uploadsheet, true);
              Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_Paste, true);
		      Lib.mouseMoveToElement(driver, AppElements.RIGHTCLICK_Data_Menu_import);
	          Lib.chkIsDisplayed(driver, AppElements.RIGHTCLICK_Data_Menu_import_Database, true);
			  driver.findElement(AppElements.AppDirectoryList("TestHeader.xlsx")).click();
			  Lib.wait_Sleep(3000);
			  Lib.mouseRightClick(driver, AppElements.AppDirectoryList("TestHeader.xlsx"));

	          driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Download).click();
			  Lib.wait_Sleep(5000);
              Lib.isFileDownloaded(downloadpath, "TestHeader.xlsx");
			  
			
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + ";" + e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
}
