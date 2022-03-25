/**
 * 
 */
package objectRepository;

import java.sql.Driver;
import java.util.List;

import org.bouncycastle.asn1.eac.Flags;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.format.RGB;
import utils.Lib;


public class AppElements {	
	public final static By Window_masks = By.xpath("//div[@class='window-mask'][contains(@style,'display: block')]");
	public final static By LOGIN_NAME = By.name("login_email");
	public final static By LOGIN_PASSWORD = By.name("login_password");
	public final static By LOGIN_SINGNIN = By.id("login_submit");
	public final static By SIGNOUT_arrow = By.xpath("//div[@id='LogoutBtn']//span[@class='m-btn-downarrow']");
//	public final static By SIGNOUT = By.xpath("//div[@id='login-hover-link']/div[contains(text(),'Sign out')]");
//	public final static By SIGNOUT = By.xpath("//a[@id='signoutBtn']");
//	public final static By SIGNOUT = By.linkText("Sign Out");
	public final static By SIGNOUT = By.cssSelector("#signoutBtn");

	
	public final static By TOPLOGO = By.cssSelector("img[id='db-logo'][src='images/cyberlogo.gif']");
	public final static By APP_CYBEROBJECT = By.xpath("//div[@id='_easyui_tree_4']/span[contains(text(),'cyberobject')]");
	public final static By APP_ID_Tip = By.xpath("//span[@id='appId']");
	public final static By Switch_App_Window_Close = By.xpath("//div[contains(@style,'display: block')]//div[text()='Switch App']//following-sibling::div/a");
	public final static By Switch_App_Window_Title = By.xpath("//div[contains(@style,'display: block')]//div[@id='fffu']");

	//New & Switch menu button.
	public final static By AppsSwitchWindow = By.xpath("//div[@class='workspaceContainer']");
	public final static By Apps_btn_downarrow = By.xpath("//div[@id='appicon']//span[@class='m-btn-downarrow']");
	public final static By Menu_bar_Switch = By.xpath("//span[@id='workspacesicon']");
	public final static By BuildId = By.xpath("//span[@id='buildVersion']");
	public final static By Menu_bar_Apps = By.xpath("//div[@id='AppBtns']");
	public final static By UserMenu_downarrow = By.xpath("//div[@id='auserIcon']//span[@class='m-btn-downarrow']");
	public final static By User_profile = By.xpath("//div[@id='username']/following-sibling::div");
	public final static By Username = By.xpath("//div[@id='username']");
	public final static By profile_account = By.cssSelector("#userProfile > div.userprofilenew > div:nth-child(1) > div.profile_userinfoaccount > div.profile_account > div.profile_myaccount.up-newtooltip > a > span.profile_account_text");
	public final static By favorites_account = By.xpath("//div[@class='profile_favorites up-newtooltip']//span[@class='profile_account_text']");


	
	public final static By Menu_bar_Input_search_shadow = By.xpath("//li[@id='searchdiv']//input[contains(@style,'display: none')]");
	public final static By Menu_bar_Input_search = By.xpath("//li[@id='searchdiv']//input");

	public final static By Menu_bar_BTN_search = By.xpath("//li[@id='searchdiv']//span");

	//	public final static By Menu_bar_Switch = By.xpath("//span[@class='treeTextSwitchApp tooltip-f']/span[contains(text(),'Switch')]");
	public final static By Menu_bar_New = By.xpath("//div[@id='newapp']/div[contains(text(),'New')]");
	public final static By Menu_bar_New_app = By.xpath("//span[@class='text'][text()='New app']");
	public final static By Menu_bar_list_apps = By.xpath("//span[@id='viewApps']//span[text()='List apps']");
	public final static By Menu_bar_List_app_templates = By.xpath("//span[@class='text'][text()='List app templates']");
	public final static By Menu_bar_Clear = By.xpath("//span[@id='clearDebugBtnSpan'][text()='Clear']");
	public final static By Menu_bar_Clear_bubble = By.xpath("//span[@id='debugStatusLight']");
	public final static By Menu_bar_Refresh = By.xpath("//span[@id='refreshUniversalBtnSpan']");
	public final static By Menu_bar_Checkout = By.xpath("//input[@id='checkout' and @value='Checkout']");
	public final static By Menu_bar_history = By.xpath("//input[@id='history'][@value='History']");
	public final static By Menu_bar_Save = By.xpath("//input[@id='saveExcel']");
	public final static By Menu_bar_Uncheck = By.xpath("//input[@id='checkout' and @value='Uncheck']");
	public final static By Menu_bar_Checkin = By.xpath("//input[@id='checkin'][@value='Checkin']");
	public final static By Menu_bar_Train = By.id("trainingBtn");
	public final static By Menu_bar_TableTrain = By.id("trainDesignerTables");
	public final static By Menu_bar_ClearTables = By.id("cleartables");
	public final static By Menu_bar_WorkSpaceDropdown_list = By.id("wsiconId");
	public final static By Menu_bar_WorkSpacesIcon = By.id("workspacesicon");

	public final static By Tool_bar_View = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'View')]");
	public final static By Tool_bar_Zoom = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Zoom (Alt+Mousewheel)')]");
	public final static By Tool_bar_Zoomin = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Zoom In')]");
	public final static By Tool_bar_Zoomout = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Zoom Out')]");
	public final static By Tool_bar_REXUndo = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Undo')]");
	public final static By Tool_bar_REXRedo = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Redo')]");
	public final static By Tool_bar_Delete = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Delete')]");
	public final static By Tool_bar_ToFront = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'To Front')]");
	public final static By Tool_bar_ToBack = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'To Back')]");
	public final static By Tool_bar_FillColor = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Fill Color')]");
	public final static By Tool_bar_LineColor = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Line Color')]");
	public final static By Tool_bar_Shadow = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Shadow')]");
	public final static By Tool_bar_Connection = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Connection')]");
	public final static By Tool_bar_Waypoints = By.xpath("//div[contains(@class,'geToolbarContainer')]/a[contains(@title,'Waypoints')]");
	
	public final static By Tool_bar_Chooseheading = By.xpath("//div[@id='toolbar-container']//span[text()='Choose heading']/parent::button");
	public final static By Tool_bar_FontFamilyDefault = By.xpath("//div[@id='toolbar-container']//span[text()='Font Family']/ancestor::button");
	public final static By Tool_bar_FontSizeDefault = By.xpath("//div[@id='toolbar-container']//span[text()='Font Size']/ancestor::button");
	public final static By Tool_bar_Bold = By.xpath("//div[@id='toolbar-container']//span[text()='Bold']/parent::button");
	public final static By Tool_bar_Italic = By.xpath("//div[@id='toolbar-container']//span[text()='Italic']/parent::button");
	public final static By Tool_bar_Link = By.xpath("//div[@id='toolbar-container']//span[text()='Link']/parent::button");
	public final static By Tool_bar_BulletedList = By.xpath("//div[@id='toolbar-container']//span[text()='Bulleted List']/parent::button");
	public final static By Tool_bar_NumberedList = By.xpath("//div[@id='toolbar-container']//span[text()='Numbered List']/parent::button");
	public final static By Tool_bar_Insertimage = By.xpath("//div[@id='toolbar-container']//span[text()='Insert image']/parent::button");
	public final static By Tool_bar_Blockquote = By.xpath("//div[@id='toolbar-container']//span[text()='Block quote']/parent::button");
	public final static By Tool_bar_Inserttable = By.xpath("//div[@id='toolbar-container']//span[text()='Insert table']/parent::button");
	public final static By Tool_bar_UCXUndo = By.xpath("//div[@id='toolbar-container']//span[text()='Undo']/parent::button");
	public final static By Tool_bar_UCXRedo = By.xpath("//div[@id='toolbar-container']//span[text()='Redo']/parent::button");

	public final static By Test_atBottom = By.xpath("//span[@id='dtd_test']//i");
	public final static By Distribute_atBottom = By.xpath("//span[@id='dtd_dis']//i");
	public final static By Dev_atBottom = By.xpath("//span[@id='dtd_dev']//i");
	public final static By TrainDocument_atBottom = By.xpath("//span[@id='dtd_train']//i");

	public final static By Menu_bar_ExcelTrain = By.id("trainingUniversalBtnSpan");
	public final static By Menu_bar_ExcelRefresh = By.id("refreshUniversalBtnSpan");
	public final static By Menu_bar_ExcelCheckout = By.xpath("//input[@id='checkout']");
	public final static By Menu_bar_Excelhistory = By.xpath("//input[@id='history'][@value='History']");
	public final static By Menu_bar_ExcelSave = By.xpath("//input[@id='saveExcel'][@value='Save']");
	public final static By Menu_bar_ExcelUncheck = By.xpath("//input[@id='checkout'][@value='Uncheck']");
	public final static By Menu_bar_ExcelCheckin = By.xpath("//input[@id='checkin'][@value='Checkin']");
	public final static By Menu_bar_Deploy = By.id("deployBtnSpan");
	public final static By Menu_bar_Delete = By.xpath("//span[@id='deleteProjectBtn']//span[text()='Delete']");
	public final static By Menu_bar_Build = By.xpath("//span[@id='buildProjectBtn']/span[text()='Build']");
	public final static By Menu_bar_Test = By.xpath("//span[@id='testProjectBtn']/span[text()='Test']");
	public final static By Menu_bar_Import = By.id("importDesignerDB");
	public final static By Menu_bar_Layout = By.id("layoutDesignerTables");

	public final static By appRoot_Build_Menu_Web = By.xpath("//div[contains(@style ,'display: block')]//div[contains(@data-options,'buildWebAction')]");
	public final static By appRoot_Build_Menu_SMS = By.xpath("//div[contains(@style ,'display: block')]//div[contains(@data-options,'buildSMSAction')]");
	public final static By appRoot_Build_Menu_Voice = By.xpath("//div[contains(@style ,'display: block')]//div[contains(@data-options,'buildVoiceAction')]");
	public final static By appRoot_Build_Menu_iOS = By.xpath("//div[contains(@style ,'display: block')]//div[contains(@data-options,'buildiOSAction')]");
	public final static By appRoot_Build_Menu_Android = By.xpath("//div[contains(@style ,'display: block')]//div[contains(@data-options,'buildAndroidAction')]");

	public final static By Build_Menu_Web = By.xpath("//div[@id='buildProjectMenu']//span[text()='Web']");
	public final static By Build_Menu_SMS = By.xpath("//div[@id='buildProjectMenu']//span[text()='SMS']");
	public final static By Build_Menu_Voice = By.xpath("//div[@id='buildProjectMenu']//span[text()='Voice']");
	public final static By Build_Menu_iOS = By.xpath("//div[@id='buildProjectMenu']//span[text()='iOS']");
	public final static By Build_Menu_Android = By.xpath("//div[@id='buildProjectMenu']//span[text()='Android']");

	public final static By WebTable_BuildWebWindow = By.xpath("//div[@id='buildWebWin']//table");
	public final static By BuildWebWindow_Label_Sise = By.xpath("//div[@id='buildWebWin']//table//span[text()='Sise']");
	public final static By BuildWebWindow_Label_Position = By.xpath("//div[@id='buildWebWin']//table//span[text()='Position']");
	public final static By BuildWebWindow_Label_HTMLCode = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[7]/td[1]");
	public final static By BuildWebWindow_Label_Image = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[5]/td[1]/span[text()='Image']");
	
	public final static By BuildWebWindow_input_width = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[2]/td[2]//input");
	public final static By BuildWebWindow_input_height = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[2]/td[4]//input");
	public final static By BuildWebWindow_input_right = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[4]/td[2]//input");
	public final static By BuildWebWindow_input_bottom = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[4]/td[4]//input");
	public final static By BuildWebWindow_input_URL = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[6]/td[2]/input[@id='targetImage']");
	public final static By BuildWebWindow_input_HTMLCode = By.xpath("//div[@id='buildWebWin']//table/tbody/tr[8]/td[1]//textarea");
	public final static By BuildWebWindow_button_Close = By.xpath("//span[@id='build_win_Close']");
	public final static By BuildWebWindow_button_Preview = By.xpath("//span[@id='build_win_preview']");

	public final static By SaveAsTemplateWindow_input_TemplateName = By.xpath("//div[@id='inputWinSaveAsTemplate']//div[@id='input-msg-name']/following-sibling::div/input");
	public final static By SaveAsTemplateWindow_input_Templatedescription = By.xpath("//div[@id='inputWinSaveAsTemplate']//div[@id='input-msg-description']/following-sibling::div/textarea");
	public final static By SaveAsTemplateWindow_button_Close = By.xpath("//div[@id='inputWinSaveAsTemplate']//span[@id='input_win_close']");
	public final static By SaveAsTemplateWindow_button_OK = By.xpath("//div[@id='inputWinSaveAsTemplate']//span[@id='input_win_yes']");

	public final static By Test_Menu_Web = By.xpath("//div[@id='testProjectMenu']//div[contains(@data-options,\"name:'testWebAction'\")]");
	public final static By Test_Menu_SMS = By.xpath("//div[@id='testProjectMenu']//div[contains(@data-options,\"name:'testSMSAction'\")]");
	public final static By Test_Menu_Voice = By.xpath("//div[@id='testProjectMenu']//div[contains(@data-options,\"name:'testVoiceAction'\")]");
	public final static By Test_Menu_iOS = By.xpath("//div[@id='testProjectMenu']//div[contains(@data-options,\"name:'testiOSAction'\")]");
	public final static By Test_Menu_Android = By.xpath("//div[@id='testProjectMenu']//div[contains(@data-options,\"name:'testAndroidAction'\")]");
//	public final static By Test_Menu_SMS = By.xpath("//div[@id='testProjectMenu']//span[text()='SMS']");
//	public final static By Test_Menu_Voice = By.xpath("//div[@id='testProjectMenu']//span[text()='Voice']");
//	public final static By Test_Menu_iOS = By.xpath("//div[@id='testProjectMenu']//span[text()='iOS']");
//	public final static By Test_Menu_Android = By.xpath("//div[@id='testProjectMenu']//span[text()='Android']");
	
	public final static By WarningMessage_content = By.xpath("//div[@id='new_pop_stream']//p/span[contains(@style,'word-wrap')]");
	public final static By WarningMessage_OK = By.xpath("//div[@id='new_pop_stream']//button[text()='OK']");

	
	public final static By Version_History_Title = By.xpath("//div[@id='history_div']//span[text()='Version History']");
	public final static By Version_History_Close = By.xpath("//div[@id='history_div']//div[@class='title_close']/img[2]");
	public final static By ErrMessage_content = By.xpath("//div[@id='err-msg-content']");
	public final static By Message_content = By.xpath("//div[@id='confirm-msg-content']");
	public final static By inputMessage_content = By.xpath("//div[@id='input-msg-content']");

	public final static By Err_Message_OK = By.xpath("//*[@id='new_pop_stream']//span[text()='OK']");
	public final static By Message_OK = By.xpath("//span[@id='err_win_ok']");

	public final static By LeftTree_Data_arrow_expand = By.xpath("//ul[@id='fileTree']/li//span[@class='tree-title'][text()='Data']//preceding-sibling::span[@class='tree-hit tree-expanded']");
	public final static By LeftTree_Data_arrow = By.xpath("//ul[@id='fileTree']/li//span[@class='tree-title'][text()='Data']//preceding-sibling::span[@class='tree-hit tree-collapsed']");
	
	
	public final static By LeftTree_Document_arrow = By.xpath("//span[starts-with(@class,'tree-title')][text()='Document']//preceding-sibling::span[@class='tree-hit tree-collapsed']");
	public final static By LeftTree_Document_arrow_expand = By.xpath("//span[starts-with(@class,'tree-title')][text()='Document']//preceding-sibling::span[@class='tree-hit tree-expanded']");
	public final static By LeftTree_Service_arrow = By.xpath("//span[contains(@class,'tree-title')][text()='Service']//preceding-sibling::span[@class='tree-hit tree-collapsed']");
	public final static By LeftTree_Service_arrow_expand = By.xpath("//span[contains(@class,'tree-title')][text()='Service']//preceding-sibling::span[@class='tree-hit tree-expanded']");
	public final static By LeftTree_Template_arrow = By.xpath("//span[@class='tree-title'][text()='Template']//preceding-sibling::span[@class='tree-hit tree-collapsed']");
	public final static By LeftTree_Template_arrow_expand = By.xpath("//span[@class='tree-title'][text()='Template']//preceding-sibling::span[@class='tree-hit tree-expanded']");
	public final static By LeftTreeTop_iplatform = By.xpath("//span[@id='appId'][text()='iplatform']");
	public final static By LeftTreeTop_Organization = By.xpath("//span[@id='appId'][text()='Organization']");

	public final static By LeftTree_Service = By.xpath("//div[starts-with(@id,'_easyui_tree')]//span[text()='Service']");
	public final static By LeftTree_Template = By.xpath("//div[starts-with(@id,'_easyui_tree')]//span[text()='Template']");

	public final static By Organization_LeftTree_Data_expand_arrow = By.xpath("//*[@id='_easyui_tree_7']/span[2]");
	public final static By OrganizationInformation_Title = By.xpath("//div[@id='fileListHead']");
	public final static By OrganizationInformation_Label_OrgId = By.xpath("//div[@id='fileListHead']/following-sibling::div/label[text()='Org id:']");
	public final static By OrganizationInformation_input_OrgId = By.xpath("//input[@id='orgid']");
	public final static By OrganizationInformation_Advanced = By.xpath("//div[@class='file-list-appAdvanced']/div[text()='Advanced']");
	public final static By OrganizationInformation_AdvancedDownArrow = By.xpath("//div[@class='file-list-appAdvanced']//a[@id='orgAdvanced_btn'][@class='layout-button-down']");
	public final static By OrganizationInformation_AdvancedUpArrow = By.xpath("//div[@class='file-list-appAdvanced']//a[@id='orgAdvanced_btn'][@class='layout-button-up']");


	public final static By Table_Version_History = By.xpath("//table[@class='hi_table']");
	public final static By Version_History_Show = By.xpath("//input[@id='checkDivShow']");
	public final static By Version_History_CheckOut = By.xpath("//input[@id='checkDivout']");

	public final static By NewSheet_Tab_Organization = By.xpath("//span[@id='orgTab']");
	public final static By NewSheet_Tab_Iplatform = By.xpath("//span[@id='iplatformTab']");

	public final static By Empty_Folder = By.id("_files_empty");

//	public static By SwitchWindow_CustomObj(String appname) {
//		By by = By.xpath("//div[@id='fffu']//span[text()='"+appname+"']");
//		return by;
//	}
	
	public static By SwitchApp_CustomObj(String OrgName) {
		By by = By.xpath("//div[@id='AppSwitchPopWin']//a[@class='newOrg_orgId'][text()='"+OrgName+"']");
		return by;
	}

	public static By SwitchAppMenu_CustomObj(String OrgName) {
		By by = By.xpath("//ol[@id='appsol']//span[text()='"+OrgName+"']");
		return by;
	}
	
	public static By Display_OrgID_CustomObj(String OrgName) {
		By by = By.xpath("//a[@class='newOrg_orgId'][text()='"+OrgName+"']");
		return by;
	}
	
	/**
	 * 识别不同菜单下的appID
	 * @param AppName
	 * @param AppType "Listapps" or "Listapptemplates" or "Orgapp"
	 * @return By
	 */
	public static By Display_AppID_CustomObj(String AppName,String AppType) {
		By by = null;
        switch(AppType){
        case "Listapps":
        	by = By.xpath("//a[@class='newOrg_appId'][text()='"+AppName+"']");
            break;
        case "Listapptemplates":
        	by = By.xpath("//a[@class='newOrg_templateid'][text()='"+AppName+"']");
        	break;
        case "":
        	by = By.xpath("//a[@class='newOrg_templateid'][text()='"+AppName+"']|//a[@class='newOrg_appId'][text()='"+AppName+"']");
        	break;
        case "Logo":
        	by = By.xpath("//input[@id='AppTemplateLogo'][@templateid='"+ AppName +"']");
        	break;
        }
		return by;
	}
	
	public final static By Left_Section_panel = By.xpath("//div[@id ='west_tree_panel'][contains(@style,'display: block')]");
	public final static By Left_Menutree = By.xpath("//div[@id ='_easyui_tree_6']//span[starts-with(@class,'tree-hit tree-')]");
//	public final static By arrow_s = By.xpath("(//div[@class='panel-tool']//a[starts-with(@class,'layout-button-left')])|(//div[contains(@class, 'layout-expand-west')]//div[@class='panel-tool']/a[@class='layout-button-right'])");
//	public final static By arrow_s = By.xpath("//div[@class='panel-tool']//a[starts-with(@class,'layout-button-left')]");
	public final static By left_collapsible_arrow = By.xpath("//div[contains(@class, 'layout-panel-west')]//div[@class='panel-tool']/a[@class='layout-button-left']");
	public final static By left_Expand_arrow = By.xpath("//div[contains(@class, 'layout-expand-west')]//div[@class='panel-tool']/a[@class='layout-button-right']");
	public final static By LeftTree_RootNode(String RootAppName) {
		By by = null;
		by = By.xpath("//div[@id='treeListDiv']//span[text()='" + RootAppName + "']");
		return by;
	}

	public final static By Section_s = By.xpath("//div[@class='panel layout-panel layout-panel-east layout-split-east']");
	public final static By Red_tag_Text = By.xpath("//div[@class = 'tooltip tooltip-bottom']/div[@class='tooltip-content']");

	
	public static By Red_tag_Text_CustomObj(String tag_Text) {
		By by = By.xpath("//span[@style='color:#fff'][text()='"+tag_Text+"']/parent::div/parent::div[contains(@style, 'display: block')]");
//		div[@class = 'tooltip tooltip-bottom']
		return by;
	}
	
	public static By Menu_bar_UserName(String UserName) {
		By by = By.xpath("//span[@class='UserText'][text()='"+ UserName +"']");
		return by;
	}

	public final static By Menu_bar_AppNameDropList = By.xpath("//span[@id='ellipsisAppIcon']");
	public final static By Menu_bar_Dropdown_list_Close = By.xpath("//div[@id='aw_p_header']");
	public static By Menu_bar_AppName(String AppName) {
		By by = By.xpath("//span[@id='appId'][text()='"+ AppName +"']");
		return by;
	}
	

	/**
	 * @see find app file.
	 * @param FileName
	 * @param WhichNode "Data","Document" ,"Service", "Template"
	 */
	public static By AppDirectoryList(String WhichNode,String FileName) {		
		By by = null;
		switch (WhichNode) {
		case "Data":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[1]/ul/li/div/span[text()='"
					+ FileName + "']");break;
		case "Document":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[2]/ul/li/div/span[text()='"
					+ FileName + "']");break;
		case "Service":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[3]/ul/li/div/span[text()='"
					+ FileName + "']");break;
		case "Template":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[4]/ul/li/div/span[text()='"
					+ FileName + "']");break;
		default:
			by = By.xpath("//ul[@id='fileTree']//ul//span[text()='"
							+ FileName + "']");break;
		}
		 return by;
	}
	
	public static By AppDirectoryList(String appName) {		
			By by = By.xpath("//ul[@id='fileTree']//ul//span[text()='"
							+ appName + "']");
			return by;
	}
	
	public static By AppDirectoryList_FolderArrowExpanded(String WhichNode,String FolderName) {
		By by = null;
		switch (WhichNode) {
		case "Data":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[1]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-expanded']");break;
		case "Document":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[2]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-expanded']");break;
		case "Service":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[3]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-expanded']");break;
		case "Template":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[4]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-expanded']");break;
		}
		 return by;
	}
	
	public static By AppDirectoryList_FolderArrowUnExpanded(String WhichNode,String FolderName) {
		By by = null;
		switch (WhichNode) {
		case "Data":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[1]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-collapsed']");break;
		case "Document":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[2]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-collapsed']");break;
		case "Service":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[3]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-collapsed']");break;
		case "Template":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[4]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[@class='tree-hit tree-collapsed']");break;
		}
		 return by;
	}
	
	public static By AppDirectoryList_FolderArrow(String WhichNode,String FolderName) {
		By by = null;
		switch (WhichNode) {
		case "Data":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[1]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[starts-with(@class,'tree-hit tree')]");break;
		case "Document":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[2]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[starts-with(@class,'tree-hit tree')]");break;
		case "Service":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[3]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[starts-with(@class,'tree-hit tree')]");break;
		case "Template":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[4]//span[text()='"
					+ FolderName + "']/preceding-sibling::span[starts-with(@class,'tree-hit tree')]");break;
		}
		 return by;
	}

	public static By AppDirectoryList_FolderChildren(String WhichNode,String FolderName,String ChilderName) {
		By by = null;
		switch (WhichNode) {
		case "Data":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[1]//span[text()='"
					+ FolderName + "']/parent::div/following-sibling::ul//span[text()= '" + ChilderName + "']");break;
		case "Document":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[2]//span[text()='"
					+ FolderName + "']/parent::div/following-sibling::ul//span[text()= '" + ChilderName + "']");break;
		case "Service":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[3]//span[text()='"
					+ FolderName + "']/parent::div/following-sibling::ul//span[text()= '" + ChilderName + "']");break;
		case "Template":
			by = By.xpath("//ul[@id='fileTree']//ul[@style='display:block']/li[4]//span[text()='"
					+ FolderName + "']/parent::div/following-sibling::ul//span[text()= '" + ChilderName + "']");break;
		}
		 return by;
	}
	
	
	public static By appRoot_sub(String appName) {
		return By
				.xpath("//ul[@id='fileTree']/li/ul/li//li/ul//span[text()='"
						+ appName + "']");
	}

	/**
	 * @see find app.
	 * @param NodeName
	 */
	public static By AppDirectoryList_Arrow(String NodeName) {
		return By.xpath("//div[@id='west_tree_panel']//ul[@id='fileTree']/li//span[text()='"+ NodeName +"']/preceding-sibling::span[contains(@class,'tree-hit')]");
	}
	
	public final static By LeftTree_Data = By.xpath("//div[@id='west_tree_panel']//ul[@id='fileTree']/li/ul/li[1]/div"
			+ "/span[contains(@class, 'tree-title')][text()='Data']/parent::div");
	public final static By LeftTree_Document = By.xpath("//div[contains(@id,'_easyui')]//span[text()='Document']");
	// APP右键菜单
	public final static By RIGHTCLICK_New_app = By.xpath("//div[@id='treeContextMenu']//span[text()='New app']");
	public final static By RIGHTCLICK_Delete = By.xpath("//div[@id='treeContextMenu']//div[starts-with(@class,'delProjectItem menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_List_apps = By.xpath("//div[@id='treeContextMenu']//span[text()='List apps']");
	public final static By RIGHTCLICK_List_app_templates = By.xpath("//div[@id='treeContextMenu']//span[text()='List app templates']");
	public final static By FileList_Download(String FileName) {
		return By.xpath("//div[@class='column column-filename'][text()='"+ FileName +"']/following-sibling::div/i[@action='downloadAction']");
	}
	public final static By FileList_Delete(String FileName) {
		return By.xpath("//div[@class='column column-filename'][text()='"+ FileName +"']/following-sibling::div/i[@class='ico ico-del']");
	}

	// Data右键菜单
	public final static By RIGHTCLICK_Database_Menu_import = By.xpath("//div[contains(@data-options,'importDesignerDB')]//span[text()='Import']");
	public final static By RIGHTCLICK_Database_Menu_AddTable = By.xpath("//div[contains(@data-options,'addDesignerTable')]//span[text()='Add Table']");
	public final static By RIGHTCLICK_Database_Menu_Checkin = By.xpath("//div[@id='versioning_checkin_sdb'][contains(@data-options,'checkinAction')]//span[text()='Checkin']");
	public final static By RIGHTCLICK_Database_Menu_Discard = By.xpath("//div[@id='versioning_uncheck_sdb'][contains(@data-options,'uncheckAction')]//span[text()='Discard']");
	public final static By RIGHTCLICK_Database_Menu_History = By.xpath("//div[@id='versioning_history_sdb']//span[text()='History']");
	public final static By RIGHTCLICK_Database_Menu_Train = By.xpath("//div[@id='servicesItem_trainItem']//span[text()='Train']");
	public final static By RIGHTCLICK_Database_Menu_Layout = By.xpath("//div[contains(@data-options,'layoutDesignerTables')]//span[text()='Layout']");
	public final static By RIGHTCLICK_Database_Menu_Delete = By.xpath("//div[contains(@data-options,'services_deletetablesAction')]//span[text()='Delete']");

	public final static By RIGHTCLICK_Data_Menu = By.xpath("//div[@id='treeContextMenu'][contains(@style, 'display: block')]");
	public final static By RIGHTCLICK_Data_Menu_import = By.xpath("//div[starts-with(@class,'importDatasource menu-item')][contains(@style, 'display: block')]");
	public final static By RIGHTCLICK_Data_Menu_Paste = By.xpath("//div[starts-with(@class,'pasteFilesItem menu-item')]//span[text()='Paste']");
	public final static By RIGHTCLICK_Data_Menu_import_Database = By.xpath("//div[starts-with(@data-options,\"name:'importdatabase',iconCls:'icon_db'\")]");
	public final static By RIGHTCLICK_Data_Menu_New = By.xpath("//div[starts-with(@class,'dataNodeItem newDataFolderItem dataItem menu-item')]//span[text()='New']");
	public final static By RIGHTCLICK_Data_Menu_CheckOutList = By.xpath("//div[@id='checkListItem']//span[text()='Check out List']");
	public final static By RIGHTCLICK_Data_Menu_Newsheet = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeNew dataItem menu-item')]//span[text()='New sheet']");

	public final static By RIGHTCLICK_Data_Menu_Newfolder = By.xpath("//div[starts-with(@class,'dataNodeItem newDataFolderItem')]//span[text()='New folder']");

	public final static By RIGHTCLICK_Data_Menu_Uploadsheet = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeUploadSheet dataItem menu-item')]//span[text()='Upload sheet']");
	public final static By RIGHTCLICK_Data_Menu_Train = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeTrainingItem dataItem menu-item')]//span[text()='Train']");
	public final static By RIGHTCLICK_Data_Menu_Rename = By.xpath("//div[starts-with(@class,'dataNodeItem renameDataFolderItem dataItem menu-item')]//span[text()='Rename']");
	public final static By RIGHTCLICK_Data_Menu_Delete = By.xpath("//div[starts-with(@class,'dataNodeItem deleteDataFolderItem dataItem menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_Data_Menu_Copy = By.xpath("//div[starts-with(@class,'copyFolderItem menu-item')]//span[text()='Copy']");
	public final static By RIGHTCLICK_Excel_Menu_Copy = By.xpath("//div[starts-with(@class,'dataNodeItem universalItem menu-item')]//span[text()='Copy']");
	public final static By RIGHTCLICK_Excel_Menu_Train = By.xpath("//span[@id='trainingUniversalItemSpan'][text()='Train']");
	public final static By RIGHTCLICK_Excel_Menu_Rename = By.xpath("//div[starts-with(@class,'dataNodeItem universalItem menu-item')]//span[text()='Rename']");
	public final static By RIGHTCLICK_Excel_Menu_SaveAsTemplate = By.xpath("//div[starts-with(@class,'dataNodeItem universalItem asTemplateItem menu-item')]//span[text()='SaveAsTemplate']");
	public final static By RIGHTCLICK_Excel_Menu_Delete = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeDelete universalItem menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_Excel_Menu_Refresh = By.xpath("//div[@id='universalItem_refreshItem']//span[text()='Refresh']");
	public final static By RIGHTCLICK_Excel_Menu_Download = By.xpath("//div[starts-with(@class,'dataNodeItem universalItem menu-item')]//span[text()='Download']");
	public final static By RIGHTCLICK_Excel_Menu_Paste = By.xpath("//div[starts-with(@class,'pasteFilesItem menu-item')]//span[text()='Paste']");
	public final static By RIGHTCLICK_Excel_Menu_Checkout = By.xpath("//div[@id='versioning_checkout_file']//span[text()='Checkout']");
	public final static By RIGHTCLICK_Excel_Menu_Checkin = By.xpath("//div[@id='versioning_checkin_file']//span[text()='Checkin']");
	public final static By RIGHTCLICK_Excel_Menu_Discard = By.xpath("//div[@id='versioning_uncheck_file']//span[text()='Discard']");
	public final static By RIGHTCLICK_Excel_Menu_History = By.xpath("//div[@id='versioning_history_file']//span[text()='History']");

	public final static By RIGHTCLICK_Sheet_Menu_Train = By.xpath("//div[contains(@data-options,'services_trainAction')]//span[text()='Train']");
	public final static By RIGHTCLICK_Sheet_Menu_Checkout = By.xpath("//div[@id='versioning_checkout_sesf']//span[text()='Checkout']");
	public final static By RIGHTCLICK_Sheet_Menu_Checkin = By.xpath("//div[@id='versioning_checkin_sesf']//span[text()='Checkin']");
	public final static By RIGHTCLICK_Sheet_Menu_Discard = By.xpath("//div[@id='versioning_uncheck_sesf']//span[text()='Discard']");
	public final static By RIGHTCLICK_Sheet_Menu_History = By.xpath("//div[@id='versioning_history_sesf']//span[text()='History']");
	public final static By RIGHTCLICK_Sheet_Menu_Delete = By.xpath("//div[contains(@class,'servicesItem sesf menu-item')][contains(@data-options,'services_deleteAction')]//span[text()='Delete']");
	public final static By RIGHTCLICK_Sheet_Menu_Download = By.xpath("//div[contains(@data-options,'services_downloadAction')]//span[text()='Download']");
	
	public final static By RIGHTCLICK_JPG_Menu_Delete = By.xpath("//div[contains(@class,'servicesItem resf resfi')][contains(@data-options,'resourceDeleteFolderAction')]//span[text()='Delete'][1]");

	
	
	
	public final static By RIGHTCLICK_File_Menu_Delete = By.xpath("//div[starts-with(@class,'delItem menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_Database_Menu_NewDiagram = By.xpath("//div[starts-with(@class,'servicesItem sdbnode menu-item')]//span[text()='New Diagram']");
	public final static By RIGHTCLICK_Document_Newscript = By.xpath("//div[@class='newFileItem menu-item']//span[text()='New script']");
	public final static By RIGHTCLICK_Document_Newdoc = By.xpath("//div[@class='newFileItem menu-item']//span[text()='New doc']");
	public final static By RIGHTCLICK_Document_Menu_CheckOutList = By.id("checkListItem");
	public final static By RIGHTCLICK_Document_Menu_Train = By.xpath("//div[@id='trainingItem']//span[@id='trainingItemSpan']");
	public final static By RIGHTCLICK_Document_Menu_Checkout = By.xpath("//div[@id='versioning_checkout_file']//span[text()='Checkout']");
	public final static By RIGHTCLICK_Document_Menu_History = By.xpath("//div[@id='versioning_history_file']//span[text()='History']");
	public final static By RIGHTCLICK_Document_Menu_Checkin = By.xpath("//div[@id='versioning_checkin_file']//span[text()='Checkin']");
	public final static By RIGHTCLICK_Document_Menu_Discard = By.xpath("//div[@id='versioning_uncheck_file']//span[text()='Discard']");

	public final static By RIGHTCLICK_Document_Menu_Deploy = By.id("deployMenuItemSpan");
	public final static By RIGHTCLICK_Document_Menu_New = By.xpath("//div[@class='newFolderItem menu-item']//span[text()='New']");
	public final static By RIGHTCLICK_Document_Menu_New_Doc = By.xpath("//div[@class='newFileItem menu-item']//span[text()='New doc']");
	public final static By RIGHTCLICK_Document_Menu_New_Script = By.xpath("//div[@class='newFileItem menu-item']//span[text()='New script']");
	public final static By RIGHTCLICK_Document_Menu_New_folder = By.xpath("//div[@class='newFolderItem menu-item']//span[text()='New folder']");
	
	public final static By RIGHTCLICK_Document_Menu_Upload_Doc = By.xpath("//div[@class='uploadFileItem menu-item']//span[text()='Upload doc']");
	public final static By RIGHTCLICK_Document_Menu_Paste = By.xpath("//div[starts-with(@class,'pasteFilesItem menu-item')]//span[text()='Paste']");
	public final static By RIGHTCLICK_Document_Folder_Paste = By.xpath("//div[starts-with(@class,'pastedocFolderItem menu-item')]//span[text()='Paste']");
	public final static By RIGHTCLICK_Document_Menu_Download = By.xpath("//div[starts-with(@class,'downloadItem menu-item')]//span[text()='Download']");
	public final static By RIGHTCLICK_Document_Menu_Rename = By.xpath("//div[starts-with(@class,'renameFilesItem menu-item')]//span[text()='Rename']");	                                                                                    
	public final static By RIGHTCLICK_Document_Folder_Rename = By.xpath("//div[starts-with(@class,'renameDocumentFolderItem menu-item')]//span[text()='Rename']");
	public final static By RIGHTCLICK_Document_Folder_Copy = By.xpath("//div[starts-with(@class,'copydocFolderItem menu-item')]//span[text()='Copy']");
	public final static By RIGHTCLICK_Document_Menu_Copy = By.xpath("//div[starts-with(@class,'copyFilesItem menu-item')]//span[text()='Copy']");
	public final static By RIGHTCLICK_Document_Menu_Delete = By.xpath("//div[@class='delItem menu-item']//span[text()='Delete']");
	public final static By RIGHTCLICK_Document_Folder_Delete = By.xpath("//div[@class='deleteDocumentFolderItem menu-item']//span[text()='Delete']");
	public final static By RIGHTCLICK_Sheet_Menu_NewSheet = By.xpath("//div[@class='servicesItem sesr menu-item']//span[text()='New Sheet']");
	public final static By RIGHTCLICK_Sheet_Menu_UploadSheet = By.xpath("//div[@class='servicesItem sesr menu-item']//span[text()='Upload Sheet']");

	public final static By RIGHTCLICK_Service_Menu_Test = By.xpath("//div[starts-with(@class,'servicesItem sr menu-item')]//span[text()='Test']");
	public final static By RIGHTCLICK_Service_Menu_CheckOutList = By.xpath("//div[@id='checkListItem']//span[text()='Check out List']");
	public final static By RIGHTCLICK_Service_Menu_Newfolder = By.xpath("//div[starts-with(@class,'servicesItem sr sfo menu-item')]//span[text()='New folder']");
	public final static By RIGHTCLICK_Service_Menu_NewService = By.xpath("//div[starts-with(@class,'servicesItem sr sfo menu-item')]//span[text()='New Service']");
	public final static By RIGHTCLICK_Service_Menu_Database = By.xpath("//div[@data-options=\"name:'services_newdbAction'\"]//span[text()='Database']");
	public final static By RIGHTCLICK_Services_Menu_NewDatabase = By.xpath("//span[text()='New Database']");
	public final static By RIGHTCLICK_Service_Menu_Webservice = By.xpath("//div[@data-options=\"name:'services_newwsdlAction'\"]//span[text()='Webservice']");
	public final static By RIGHTCLICK_Service_Menu_Restful = By.xpath("//div[@data-options=\"name:'services_newrestfulAction'\"]//span[text()='Restful']");
	public final static By RIGHTCLICK_Service_Menu_Delete = By.xpath("//div[starts-with(@class,'servicesItem sfo sfi menu-item')]//span[text()='Delete']");
	
	public final static By RIGHTCLICK_Service_Menu_Import = By.xpath("//div[@class='servicesItem sdb menu-item']//span[text()='Import']");
	public final static By RIGHTCLICK_Service_Menu_Train = By.xpath("//div[@id='servicesItem_trainItem']//span[text()='Train']");
	public final static By RIGHTCLICK_Service_Menu_Layout = By.xpath("//div[@class='servicesItem sdb menu-item']//span[text()='Layout']");
	public final static By RIGHTCLICK_Service_Menu_DBDelete = By.xpath("//div[@id='treeContextMenu']//div[starts-with(@class,'servicesItem sdb menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_DataService_Menu_ImportService = By.xpath("//div[@id='importServiceItem']//span[text()='Import Service']");

	public final static By Title_ImportService = By.xpath("//h4[text()='Import Service']");
	public final static By Input_Queryservice = By.xpath("//input[@id='queryString']");
	public final static By ImportService_btn_Search = By.xpath("//button[@id='searchBtn']");

	
	public final static By RIGHTCLICK_WebService_Menu_Delete = By.xpath("//div[starts-with(@class,'servicesItem sfi menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_RESTService_Menu_Delete = By.xpath("//div[starts-with(@class,'servicesItem sfi menu-item')]//span[text()='Delete']");
	public final static By RIGHTCLICK_WebServices_Menu_AddWebService = By.xpath("//span[text()='Add Web Service']");
	public final static By RIGHTCLICK_WebServices_Menu_NewDatabase = By.xpath("//span[text()='New Database']");
	public final static By RIGHTCLICK_RESTServices_Menu_AddRestservice = By.xpath("//span[text()='Add Rest Service']");

	public final static By RIGHTCLICK_DocumentFolder_Menu_Delete = By.xpath("//div[contains(@class,'deleteDocumentFolderItem')]//span[text()='Delete']");
	public final static By RIGHTCLICK_Template_Menu_NewTemplate = By.xpath("//div[starts-with(@class,'dataNodeItem newTemplateItem dataItem menu-item')]//span[text()='New Template']");
	public final static By RIGHTCLICK_DataFolder_Menu_Delete = By.xpath("//div[contains(@class , 'deleteDataFolderItem')]//span[text()='Delete']");
	public final static By RIGHTCLICK_DataFolder_Menu_Train = By.xpath("//span[contains(@id,'dataNodeTrainingItemSpan')][text()='Train']");
	
	
	public final static By RIGHTCLICK_Folder_Menu_Train = By.xpath("//div[contains(@class,'dataNodeTrainingItem')]//span[contains(@id,'rainingItemSpan')][text()='Train']");
	public final static By RIGHTCLICK_Folder_Menu_New = By.xpath("//div[starts-with(@class,'dataNodeItem newDataFolderItem')]//span[text()='New']");
	public final static By RIGHTCLICK_Folder_Menu_import = By.xpath("//div[starts-with(@class,'importDatasource')][contains(@style, 'display: block')]");
	public final static By RIGHTCLICK_Folder_Menu_import_Database = By.xpath("//div[starts-with(@data-options,\"name:'importdatabase',iconCls:'icon_db'\")]");
	public final static By RIGHTCLICK_Folder_Menu_Rename = By.xpath("//div[starts-with(@class,'dataNodeItem renameDataFolderItem')]//span[text()='Rename']");
	public final static By RIGHTCLICK_Folder_Menu_Copy = By.xpath("//div[starts-with(@class,'copyFolderItem')]//span[text()='Copy']");
	public final static By RIGHTCLICK_Folder_Menu_Delete = By.xpath("//div[contains(@class,'dataNodeItem deleteDataFolderItem')]");
	public final static By RIGHTCLICK_Folder_Menu_CheckOutList = By.xpath("//div[@id='checkListItem']");
	public final static By RIGHTCLICK_Folder_Menu_Newfolder = By.xpath("//div[starts-with(@class,'dataNodeItem newDataFolderItem')]//span[text()='New folder']");
	
	public final static By RIGHTCLICK_Folder_Menu_Newsheet = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeNew')]//span[text()='New sheet']");
	public final static By RIGHTCLICK_Folder_Menu_Uploadsheet = By.xpath("//div[starts-with(@class,'dataNodeItem dataNodeUploadSheet')]//span[text()='Upload sheet']");
	public final static By RIGHTCLICK_Folder_Menu = By.xpath("//div[@id='treeContextMenu'][contains(@style, 'display: block')]");
	public final static By RIGHTCLICK_Folder_Menu_Paste = By.xpath("//div[starts-with(@class,'pasteFolderItem')]//span[text()='Paste']");
	public final static By RIGHTCLICK_Folder_Menu_Deploy = By.xpath("//span[@id='deployMenuItemSpan']");
	public final static By RIGHTCLICK_Folder_Menu_Upload_doc = By.xpath("//div[@class='uploadFileItem menu-item']//span[text()='Upload doc']");
	public final static By RIGHTCLICK_Folder_Menu_New_doc = By.xpath("//div[@class='newFileItem menu-item']//span[text()='New doc']");

	public final static By appRoot_Menu_Build = By.xpath("//div[@class='buildProjectItem menu-item']//span[text()='Build']");
	public final static By AppNameDropList_Menu_TrainApp = By.xpath("//span[@id='trainingItemSpan']");
	public final static By AppNameDropList_Menu_DeployApp = By.xpath("//span[@id='deployMenuItemSpan']");
//	public final static By RIGHTCLICK_appRoot_Menu_Delete = By.xpath("//div[@class='delProjectItem menu-item']//span[text()='Delete']");
	public final static By AppNameDropList_Menu_TestApp = By.xpath("//div[@class='testProjectItem menu-item']//span[text()='Test App']");
	public final static By AppNameDropList_Menu_PendingCheckin = By.xpath("//div[@id='checkListItem']//span[text()='Pending Checkin']");
	public final static By AppNameDropList_Menu_Learning = By.xpath("//div[@id='learningItem']//span[text()='Learning']");
	public final static By AppNameDropList_Menu_Appinfo = By.xpath("//div[@id='editAppInfoItem']//span[text()='App Info']");
	public final static By AppNameDropList_Menu_RecentDocs = By.xpath("//div[@id='recentDocs']//span[text()='Recent Docs']");
	public static By AppNameDropList_Menu_RecentDocs(String RecentDocsName) {
        By by = null;
		     by = By.xpath("//div[@id='recentDocsList']//span[text()='"+ RecentDocsName +"']");
		return by;
	}
	
	
	
	public final static By AppNameDropList__Menu_DistributeApp = By.xpath("//div[@id='distributeProjectItem']//span[text()='Distribute App']");

	
	public final static By RIGHTCLICK_appRoot_Menu_DistributeApp = By.xpath("//div[@id='editAppInfoItem']//span[text()='Distribute App']");
	public final static By RIGHTCLICK_appRoot_Menu_SaveAsTemplate = By.xpath("//div[@class='saveAsAppTemplateItem menu-item']//span[text()='SaveAsTemplate']");
	public final static By RIGHTCLICK_appRoot_Menu_Build_Web = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'buildWebAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Build_SMS = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'buildSMSAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Build_Voice = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'buildVoiceAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Build_iOS = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'buildiOSAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Build_Android = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'buildAndroidAction'\")]");

	public final static By RIGHTCLICK_appRoot_Menu_Test_Web = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'testWebAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Test_SMS = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'testSMSAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Test_Voice = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'testVoiceAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Test_iOS = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'testiOSAction'\")]");
	public final static By RIGHTCLICK_appRoot_Menu_Test_Android = By.xpath("//div[@class='menu']//div[ contains(@data-options , \"name:'testAndroidAction'\")]");

	public final static By CheckOutList_Checkin = By.xpath("//div[@ng-controller='checkListController']//button[text()='Checkin']");
	public final static By CheckOutList_Uncheck = By.xpath("//div[@ng-controller='checkListController']//button[text()='Uncheck']");

	public final static By Web_table = By.xpath("//div[@id='buildWebWin']//table");
	public final static By Web_button_Close = By.xpath("//span[@id='build_win_Close']");
	public final static By Web_button_Preview = By.xpath("//span[@id='build_win_preview']");
	public final static By Web_input_SizeWidth = By.xpath("//input[@id='targetWidth']");
	public final static By Web_input_SizeHeight = By.xpath("//input[@id='targetHeight']");
	public final static By Web_input_HeightWidth = By.xpath("//input[@id='targetWidth']");
	public final static By Web_input_PositionRight = By.xpath("//input[@id='targetRight']");
	public final static By Web_input_PositionBottom = By.xpath("//input[@id='targetBottom']");
	public final static By Web_input_ImageURL = By.xpath("//input[@id='targetImage']");
	public final static By Web_input_HTMLCode = By.xpath("//textarea[@id='targetCode']");

	public final static By Lite_Chat_Test_Title = By.xpath("//html//title");

	public final static By ErrorInformation_Title = By.xpath("//div[@id='errWin']//h5[@class='modal-title']");
	public final static By ErrorInformation_x = By.xpath("//div[@id='errWin']//button[@class='close']/span");
	public final static By ErrorInformation_Close = By.xpath("//div[@id='errWin']//button[text()='Close']");
	public final static By ErrorInformation_Content = By.xpath("//div[@id='errWin']/div[@class='modal-dialog']//div[@id='err-msg-content']");

	public final static By ImportDataBaseWindow = By.xpath("//div[@id='importDataSourceWin']/div[@class='resourceContent']");
	public final static By ImportDataBaseWindow_Generate = By.xpath("//div[@id='importDataSourceWin']/div[@class='resourceFooter']/input[@value='Generate']");
	public final static By ImportDataBaseWindow_TestConnection = By.xpath("//div[@id='importDataSourceWin']/div[@class='resourceFooter']/input[@value='Test Connection']");
	public final static By ImportDataBaseWindow_Close = By.xpath("//div[@class='panel-title'][text()='Import Database']/following-sibling::div[1]");
	public final static By ImportDataBaseWindow_Label_DatabaseName = By.xpath("//div[@id='importDataSourceWin']//label[text()='Database Name:']");
	public final static By ImportDataBaseWindow_Input_DatabaseName = By.xpath("//div[@id='importDataSourceWin']//input[@data-type = 'Database Name']");
	public final static By ImportDataBaseWindow_Input_DatabaseType = By.xpath("//div[@id='importDataSourceWin']//input[@data-type ='Database Type']");
	public final static By ImportDataBaseWindow_Label_DatabaseType = By.xpath("//div[@id='importDataSourceWin']//label[text()='Database Type:']");
	public final static By ImportDataBaseWindow_Label_Host = By.xpath("//div[@id='importDataSourceWin']//label[text()='Host:']");
	public final static By ImportDataBaseWindow_Label_Port = By.xpath("//div[@id='importDataSourceWin']//label[text()='Port:']");
	public final static By ImportDataBaseWindow_Label_UserName = By.xpath("//div[@id='importDataSourceWin']//label[text()='User Name:']");
	public final static By ImportDataBaseWindow_Label_Password = By.xpath("//div[@id='importDataSourceWin']//label[text()='Password:']");
	public final static By ImportDataBaseWindow_Input_Host = By.xpath("//div[@id='importDataSourceWin']//input[@data-type = 'Host']");
	public final static By ImportDataBaseWindow_Input_Port = By.xpath("//div[@id='importDataSourceWin']//input[@data-type = 'Port']");
	public final static By ImportDataBaseWindow_Input_UserName = By.xpath("//div[@id='importDataSourceWin']//input[@data-type = 'User Name']");
	public final static By ImportDataBaseWindow_Input_Password = By.xpath("//div[@id='importDataSourceWin']//input[@data-type = 'Password']");

	//Edit Table
	public final static By EditTable_Title = By.xpath("//div[@id='window']/div[@id='windowtitle']");
	public final static By EditTable_Label_Name = By.xpath("//div[@id='window']//label[@id='tablenamelabel']");
	public final static By EditTable_input_Name = By.xpath("//div[@id='window']//input[@id='tablename']");
	public final static By EditTable_Label_Label = By.xpath("//div[@id='window']//label[@id='tablelabellabel']");
	public final static By EditTable_input_Label = By.xpath("//div[@id='window']//input[@id='teblelabel']");
	public final static By EditTable_Label_Synonym = By.xpath("//div[@id='window']//label[@id='tablesynonymlabel']");
	public final static By EditTable_input_Synonym = By.xpath("//div[@id='window']//input[@id='tablesynonym']");
	public final static By EditTable_Label_ReadWrite = By.xpath("//div[@id='window']//label[@id='tablereadwritelabel']");
	public final static By EditTable_radio_Read = By.xpath("//div[@id='window']//input[@type='radio'][@text='Read']");
	public final static By EditTable_radio_Write = By.xpath("//div[@id='window']//input[@type='radio'][@text='Write']");
	public final static By EditTable_Label_Description = By.xpath("//div[@id='window']//label[@id='tablecommentlabel']");
	public final static By EditTable_input_Description = By.xpath("//div[@id='window']//textarea[@id='tablecomment']");
	public final static By EditTable_btn_OK = By.xpath("//div[@id='window']//input[@id='windowok']");
	public final static By EditTable_btn_Cancel = By.xpath("//div[@id='window']//input[@id='windowcancel']");

	//Check In dialog
	public final static By CheckIn_MSG_Content = By.xpath("//div[@id='new_pop_stream']//input/parent::div/following-sibling::div[1]//span");
	public final static By CheckIn_input_field = By.xpath("//div[@id='new_pop_stream']//input");
	public final static By CheckIn_Cancel = By.xpath("//div[@id='new_pop_stream']//div[@class='ax_default primary_button']//span[text()='Cancel']");
	public final static By CheckIn_OK = By.xpath("//div[@id='new_pop_stream']//div[@class='ax_default primary_button']//span[text()='OK']");

	//Discard dialog
	public final static By Discard_MSG_Content = By.xpath("//div[@id='new_pop_stream']//p/span[contains(@style,'word-wrap')]");
	public final static By Discard_Cancel = By.xpath("//div[@id='new_pop_stream']//button[text()='Cancel']");
	public final static By Discard_OK = By.xpath("//div[@id='new_pop_stream']//button[text()='OK']");

	
	
	
	
	
	//connection info dialog
	public final static By ConnectionInfo_MSG_Title = By.xpath("//h5[@id='msg-title'][text()='Connection Info']");
	public final static By ConnectionInfo_MSG_X = By.xpath("//div[@class='modal-dialog']//button[@class='close']/span");
	public final static By ConnectionInfo_MSG_Content = By.xpath("//div[@id='msg-content']");
	public final static By ConnectionInfo_MSG_Close = By.xpath("//div[@class='modal-dialog']//button[@class='btn btn-primary'][text()='Close']");

	// Input dialog
//	public final static By Inputbox_newTemplate = By.xpath("//input[@placeholder='Please enter the template name']");
//	public final static By button_newTemplate_Finish = By.xpath("//button[@id='newTemplateBtn']");
	public final static By Input_MSG_Content = By.id("input-msg-content");
//	public final static By Input_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By Input_Field = By.id("input-text");
//	public final static By Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By Input_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");
	public final static By Input_Create = By.xpath("//span[@id='input_win_yes'][text()='Create']");
	public final static By Input_Rename = By.xpath("//span[@id='input_win_yes'][text()='Rename']");
	public final static By Input_Close = By.xpath("//span[@id='input_win_close']");
	public final static By Input_Cancel = By.xpath("//span[@id='input_win_close' and text()='Cancel']");
	public final static By Input_CheckIn = By.xpath("//span[@id='input_win_yes' and text()='Check In']");
	public final static By Input_radio_doc = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='doc']/ancestor::label/img");
	public final static By Input_radio_script = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='doc']/ancestor::label/img");

	public final static By Paste_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By Paste_Cancel = By.xpath("//p[@class='new_pop_cancel']/span");
	public final static By Paste_Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By Paste_OK = By.xpath("//p[@class='new_pop_ok']//span");

	
	public final static By Rename_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By Rename_Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By Rename_Cancel = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='Cancel']");
	public final static By Rename_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");

	public final static By NewDoc_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By NewDoc_Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By NewDoc_radio_doc = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='doc']/ancestor::label/img");
	public final static By NewDoc_radio_script = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='script']/ancestor::label/img");
	public final static By NewDoc_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");
	public final static By NewDoc_Cancel = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='Cancel']");

	public final static By NewFolder_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By NewFolder_Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By NewFolder_Cancel = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='Cancel']");
	public final static By NewFolder_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");

	public final static By NewDiagram_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");
	public final static By NewDiagram_Input_Field = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][2]//input");
	public final static By NewDiagram_Cancel = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='Cancel']");
	public final static By NewDiagram_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");
	
	public final static By checkoutlistfiles_empty = By.xpath("//div[@id='_checkoutlistfiles_empty']//p");

	public static By ChannelsName(String ChannelName) {
        By by = null;
		     by = By.xpath("//div[@class='text-center ng-binding'][text()='"+ ChannelName +"']");
		return by;
	}
	
	public static By ChannelsImg(String ChannelName) {
        By by = null;
		     by = By.xpath("//div[@class='text-center ng-binding'][text()='"+ ChannelName +"']/parent::div/preceding-sibling::img");
		return by;
	}
	
	public static By Channelstoggle(String ChannelName) {
        By by = null;
		     by = By.xpath("//div[@class='text-center ng-binding'][text()='"+ ChannelName +"']/parent::div//label");
		return by;
	}
	
	
	//div[@class='text-center ng-binding'][text()='Amazon Alexa Voice']/parent::div/preceding-sibling::img
	
		
	public static By New_Sheet_CustomSheet(String Tab , String SheetName) {
        By by = null;
		switch (Tab) {
		case "Iplatform":	
		     by = By.xpath("//div[@id='iplatformTemplateList']//a[text()='"+ SheetName +"']");
		     break;
		case "Organization":
		     by = By.xpath("//div[@id='orgTemplateList']//a[text()='"+ SheetName +"']");
		     break;	
		}
		return by;
	}
	
	
	public final static By New_Sheet_MSG_Content = By.xpath("//div[@id='createDataFinishDiv']//p[@class='new_pop_label']/span");
	public final static By New_Sheet_Inputfield = By.xpath("//div[@id='createDataFinishDiv']//input");
	public final static By New_Sheet_Back = By.xpath("//div[@id='createDataFinishDiv']//span[text()='<< Back']");
	public final static By New_Sheet_Create = By.xpath("//div[@id='createDataFinishDiv']//span[text()='Create']");
	public final static By New_Sheet_Title = By.xpath("//div[@id='new_pop_createDataInput']//span[text()='New Sheet']");
	public final static By New_Sheet_Title_2 = By.xpath("//div[@id='new_pop_createData']//span[text()='New Sheet']");

	public final static By New_Sheet_45h45_Xlsx = By.xpath("//div[@id='createDatalistDiv']//a[text()='45h45.xlsx']");
	public final static By New_Sheet_Command_Xlsx = By.xpath("//div[@id='createDatalistDiv']//a[text()='Command.xlsx']");
	public final static By New_Sheet_Close = By.xpath("//div[@class='panel window'][starts-with(@style,'display: block')]//div[@class='panel-title'][text()='New Sheet']/following-sibling::div/a[@class='panel-tool-close']");
	
	public final static By Database_Inputfield = By.xpath("//div[@id='inputWin'][contains(@style,'display: block')]//input");
	public final static By Database_OK = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='OK']");
	public final static By Database_Cancel = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']//span[text()='Cancel']");
	public final static By Database_MSG_Content = By.xpath("//div[@id='new_pop_stream']/div[@class='ax_default']/div[@class='ax_default'][3]//span");

	public final static By Upload_Please_select_excel_file_to_upload = By.xpath("//span[text()='Browse excel file to upload']");
	public final static By Upload_sheet_close = By.xpath("//i[@id='close_datasheetfile_win']");

	public final static By DIF_Testing_Page_Title = By.xpath("//h4[text()='DIF Testing Page']");
	public final static By DIF_Testing_Page_Input_Label = By.xpath("//td[text()='Input']");
	public final static By DIF_Testing_Page_InputBox_Term = By.xpath("//table[@id='inputTable']//input[1]");
	public final static By DIF_Testing_Page_InputBox_TermValue = By.xpath("//table[@id='inputTable']//input[2]");
	public final static By DIF_Testing_Page_addInput = By.xpath("//button[@id='addInput'][text()='+']");
	public static By DIF_Testing_Page_addInputLabel_X(int index) {
 		String s = String.valueOf(index*2);	
		return By
		.xpath("//table[@id='inputTable']//tr["+s+"]//div[@class='input-group']//button[@class='btn btn-outline-secondary'][text()='X']");
	}

	public final static By DIF_Testing_Page_Output_Label = By.xpath("//td[text()='Output']");
	public final static By DIF_Testing_Page_OutputBox_Term = By.xpath("//table[@id='outputTable']//input[1]");
	public final static By DIF_Testing_Page_OutputBox_TermValue = By.xpath("//table[@id='outputTable']//input[2]");
	public final static By DIF_Testing_Page_addOutput = By.xpath("//button[@id='addOutput'][text()='+']");
	public static By DIF_Testing_Page_addOutputLabel_X(int index) {
 		String s = String.valueOf(index+1);	
        return By
		.xpath("//table[@id='outputTable']//tr["+s+"]//div[@class='input-group']//button[@class='btn btn-outline-secondary'][text()='X']");
	}
	public final static By DIF_Testing_Page_GetPlan = By.xpath("//input[@id='getPlan']");
	public final static By DIF_Testing_Page_Execute = By.xpath("//input[@id='execute']");
	public final static By NewTemplate_NewWindow_Title = By.xpath("//div[@class='panel window']//div[@class='panel-title'][text()='New Window']");
	public final static By NewTemplate_NewWindow_Close = By.xpath("//div[@class='panel window']//div[@class='panel-title'][text()='New Window']/following-sibling::div/a[@class='panel-tool-close']");
	public final static By NewTemplate_NewWindow_InputBox = By.xpath("//div[@id='newTemplateDiv']/input");
	public final static By NewTemplate_NewWindow_Finish = By.xpath("//div[@id='newTemplateDiv']/button[@id='newTemplateBtn']");
	public final static By input_Console_Search = By.xpath("//div[contains(@style,'display: block')]//div[@class='searchdiv']//input");
	public final static By Console_expand = By.xpath("//div[contains(@style,'display: block')]//div[@id='eastconsole']/ul[@id='eastmessageList']");

	public final static By Console_arrow_left = By.cssSelector("#mainesidebarcontainer > span.ctable.console > i");
	public final static By Console_arrow_right = By.cssSelector("#esidebarcontainer > span.ctable.console > i");	
	public final static By Btn_Console_op = By.cssSelector("#mainesidebarcontainer > span.ctable.console > i");	
	public final static By Btn_Console_cl = By.cssSelector("#esidebarcontainer > span.ctable.console > i");	
	public final static By Btn_Problems_highlight = By.cssSelector("#esidebarcontainer > span.ctable.error > i");	
	public final static By Btn_Problems_op = By.xpath("//div[@id='mainesidebarcontainer']//span[@title='Problems']/i");	
	public final static By Btn_Problems_cl = By.xpath("//div[@id='eastconsole_rightsidebar']//span[@title='Problems']/i");	

	public final static By Btn_Error = By.cssSelector("#mainesidebarcontainer > span.ctable.error > i");	
	public final static By Btn_Search_cl = By.cssSelector("#esidebarcontainer > span.ctable.search > i");	
	public final static By Btn_Search_op = By.cssSelector("#mainesidebarcontainer > span.ctable.search > i");	
	public final static By Topbar_Btn_Search = By.xpath("//div[@id='top-login-wrapper']//span[@class='searchIcon']");	
	public final static By Topbar_input_Search = By.xpath("//div[@id='top-login-wrapper']//span[@class='searchInput']");	

	public final static By Btn_UserIcon = By.cssSelector("#auserIcon > span.UserIcon");	
	public final static By Search_window = By.xpath("//div[contains(@style,'display: block')]//div[@class='searchView']");	
	public final static By input_Search_Search = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchInputDiv']//input");

	public final static By Error_Window = By.xpath("//div[contains(@style,'display: block')]//ul[@id='east_errorlist']");
	public final static By input_Error_Search = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//input");

	public final static By Console_input_find = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv']//input");
	public final static By Console_btn_filter = By.xpath("//div[@id='eastconsole']//div[@class='searchdiv']//span[5]");
	public final static By Console_btn_Next = By.xpath("//div[@id='eastconsole']//div[@class='searchdiv']//span[2]");
	public final static By Console_btn_Last = By.xpath("//div[@id='eastconsole']//div[@class='searchdiv']//span[3]");
	public final static By Console_btn_Clear = By.xpath("//div[@id='eastconsole']//div[@class='searchdiv']//span[1]");

	public final static By Search_bar = By.xpath("//div[@id='eastconsole_center']//input[@auto-complete='new-password']");

	public final static By error_input_find = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//input");
	public final static By error_btn_filter = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//span[4]");
	public final static By error_btn_Next = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//span[2]");
	public final static By error_btn_Last = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//span[3]");
	public final static By error_btn_Clear = By.xpath("//div[@id='console_panel_footer_e']//div[@class='searchdiv errorInfo']//span[1]");

	public final static By Console_Window = By.xpath("//div[contains(@style,'display: block')]//div[contains(@style,'display: block') and @id='eastconsole']//div[@id='eastmessageListContainer' and contains(@style,'display: block')]/ul[@id='eastmessageList']");
	public final static By ZebraDialog = By.xpath("//div[@class='ZebraDialog_Body']");
	public final static By ZebraDialog_Close = By.xpath("//div[@class='ZebraDialog_Body']//a[@class='ZebraDialog_Close']");
	public final static By button_ConsoleClear = By.xpath("//div[@id='esidebarcontainer']//i[@class='ctico consoleClear']");
	public final static By tab_Console = By.cssSelector("#esidebarcontainer > span.ctable.console > i");
	public final static By tab_Error_Op = By.cssSelector("#mainesidebarcontainer > span.ctable.error > i");
	public final static By tab_Error_Cl = By.cssSelector("#esidebarcontainer > span.ctable.error > i");
	                             
	public final static By tab_problems = By.xpath("//span[@title='Problems' and contains(@style,'display:block')]/i[@data-type='error']");
	public final static By problems_Window_Op = By.xpath("//div[@id='east_error' and contains(@style,'display: block')]");
	public final static By problems_Window_Cl = By.xpath("//div[@id='east_error' and contains(@style,'display: none')]");
	public final static By tab_problem_selected = By.xpath("//span[@title='Problems']/i[@class='ctico ico-errorTab selectedconsoletype']");
	public final static By tab_Console_selected = By.xpath("//span[@title='Console']/i[@class='ctico ico-consoleTab selectedconsoletype']");

	public final static By tab_Search = By.cssSelector("#esidebarcontainer > span.ctable.search > i");

	public static By GetConsole_Window_Msg(int row) {
		String s = String.valueOf(row);
		return By.xpath("//div[@id='eastconsole']//ul[@id='eastmessageList']/li["+ s +"]");
		}

	public static By GetConsole_Window_ErrorMsg(int row) {
		String s = String.valueOf(row);
		return By.xpath("//div[@id='east_error']//ul[@id='east_errorlist']/p["+ s +"]");
		}
	
	public final static By Btn_TopSearch = By.xpath("//div[@id='eastconsole']//span[@class='searchnow']");
	public final static By input_TopSearch = By.xpath("//div[@id='eastconsole_layout']//div[@class='searchInputDiv']//input");

	public final static By Search = By.xpath("//div[@id='dataquerySubMenu']/following-sibling::div//span[text()='Search']");
	public final static By Search_expand = By.xpath("//div[@id='floatwindow']/preceding-sibling::div[contains(@style,'display: block')]//span[text()='Search']");
//	public final static By SearchConsole_arrow = By.xpath("//div[@id='dataquerySubMenu']/following-sibling::div[contains(@style,'display: block')]//a");
//	public final static By SearchConsole_arrow_expand = By.xpath("//div[@class='panel layout-panel layout-panel-east layout-split-east'][contains(@style,'display: block')]//div[@class='searchInputDiv']/following-sibling::div//a[6]");
	public final static By inputBox_Search = By.xpath("//div[@class='searchInputDiv']/input");
	public final static By button_Search = By.xpath("//span[@class='searchnow']");
	public final static By button_SearchClear_X = By.xpath("//span[@class='clearcondition']");
	public final static By Label_Content = By.xpath("//span[@class='typeSelected'][text()='Content']");
	public final static By Label_File = By.xpath("//div[@class='typeDiv']/span[text()='File']");
	public final static By Label_Content_resultNotFound = By.xpath("//div[@class='notFoundDiv'][text()='No matched result found.']");
	public final static By Label_File_resultNotFound = By.xpath("//div[@class='notFoundDiv'][text()='No matched result found.']");
	public final static By Label_Content_resultView_s = By.xpath("//div[@class='resultsDiv']/div[@class='resultView']");
	public final static WebElement Search_result_page(WebDriver driver,String intpage) {
		WebElement element = null;
		element = driver.findElement(By.xpath("//div[@class='pageselectDiv']/span[text()='"+intpage+"']"));
		return element;
	}
	public final static By Label_Advanced_Prefix = By.xpath("//div[@id='orgAdvanced']//label[text()='Prefix:']");
	public final static By Label_Advanced_URI = By.xpath("//div[@id='orgAdvanced']//label[text()='URI:']");
	public final static By Label_Advanced_TermURI = By.xpath("//div[@id='orgAdvanced']//label[text()='Term URI:']");
	public final static By Input_Advanced_Prefix = By.id("org_prefix");
	public final static By Input_Advanced_URI = By.xpath("//label[text()='URI:']/following-sibling::input[@id='org_uri']");
	public final static By Input_Advanced_TermURI = By.id("org_term_uri");

	public final static By Label_App_Advanced_Prefix = By.xpath("//div[@id='appAdvanced']//label[text()='Prefix:']");
	public final static By Label_App_Advanced_URI = By.xpath("//div[@id='appAdvanced']//label[text()='URI:']");
	public final static By Label_App_Advanced_TermURI = By.xpath("//div[@id='appAdvanced']//label[text()='Term URI:']");
	public final static By Input_App_Advanced_Prefix = By.id("app_prefix");
	public final static By Input_App_Advanced_URI = By.xpath("//label[text()='URI:']/following-sibling::input[@id='app_uri']");
	public final static By Input_App_Advanced_TermURI = By.id("app_term_uri");
	
	public final static By appDetail_CreateAppWindow = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']");
	public final static By appDetail_CreateAppWindow_Name = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='Name:']");
	public final static By appDetail_CreateAppWindow_Namevalue = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='Name:']/following-sibling::span");
	public final static By appDetail_CreateAppWindow_ID = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='ID:']");
	public final static By appDetail_CreateAppWindow_IDvalue = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='ID:']/following-sibling::span");
	public final static By appDetail_CreateAppWindow_Description = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='Description:  ']");
	public final static By appDetail_CreateAppWindow_Descriptionvalue = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[text()='Description:  ']/following-sibling::span");
	public final static By appDetail_CreateAppWindow_Create = By.xpath("//div[@id='appTemplateDetailAndCreateAppWin']//span[@id='appTemplateDetailAndCreateApp_win_create']");
	
	public final static By CreateNewApplication_Title = By.xpath("//div[@class='createAppWin']//span[@class='appWintitle'][text()='Create New Application']");
	public final static By CreateNewApplication_Close = By.xpath("//div[@class='createAppWin']//span[@class='closebtn'][text()='x']");
	public final static By CreateNewApplication_Label_Appid = By.xpath("//div[@class='createAppWin']//label[text()='App id:']");
	public final static By CreateNewApplication_input_Appid = By.xpath("//div[@class='createAppWin']//input[@class='app_id input']");
	public final static By CreateNewApplication_Label_Appname = By.xpath("//div[@class='createAppWin']//label[text()='App name:']");
	public final static By CreateNewApplication_input_Appname = By.xpath("//div[@class='createAppWin']//input[@class='app_name input']");
	public final static By CreateNewApplication_Label_Appdescription = By.xpath("//div[@class='createAppWin']//label[text()='App description:']");
	public final static By CreateNewApplication_input_Appdescription = By.xpath("//div[@class='createAppWin']//textarea[@class='app_description input']");
	public final static By CreateNewApplication_Label_Applogo = By.xpath("//div[@class='createAppWin']//label[text()='App logo:']");
	public final static By CreateNewApplication_input_Applogo = By.xpath("//div[@class='createAppWin']//input[@class='appLogoImg input']");
	public final static By CreateNewApplication_Label_Apptemplate = By.xpath("//div[@class='createAppWin']//label[text()='App template:']");
	public final static By CreateNewApplication_select_Apptemplate = By.xpath("//div[@class='createAppWin']//select[@class='app_template input']");
	public final static By CreateNewApplication_input_Templates = By.xpath("//div[@class='createAppWin']//input[@id='keyword']");

	
	public final static By CreateNewApplication_Label_Advanced = By.xpath("//div[@class='createAppWin']//label[text()='Advanced']");
	public final static By CreateNewApplication_Arrow = By.xpath("//div[@class='createAppWin']//a[starts-with(@class,'appAdvanced_btn')]");
	public final static By CreateNewApplication_ArrowUp_Advanced = By.xpath("//div[@class='createAppWin']//a[@class='appAdvanced_btn layout-button-up']");
	public final static By CreateNewApplication_ArrowDown_Advanced = By.xpath("//div[@class='createAppWin']//a[@class='appAdvanced_btn layout-button-down']");
	public final static By CreateNewApplication_Label_Prefix = By.xpath("//div[@class='createAppWin']//label[text()='Prefix:']");
	public final static By CreateNewApplication_input_Prefix = By.xpath("//div[@class='createAppWin']//input[@class='app_prefix input']");
	public final static By CreateNewApplication_Label_URI = By.xpath("//div[@class='createAppWin']//label[text()='URI:']");
	public final static By CreateNewApplication_input_URI = By.xpath("//div[@class='createAppWin']//input[@class='app_uri input']");
	public final static By CreateNewApplication_Label_TermURI = By.xpath("//div[@class='createAppWin']//label[text()='Term URI:']");
	public final static By CreateNewApplication_input_TermURI = By.xpath("//div[@class='createAppWin']//input[@class='app_term_uri input']");
	public final static By CreateNewApplication_btn_Reset = By.xpath("//div[@class='createAppWin']//span[text()='Reset']");
	public final static By CreateNewApplication_btn_OK = By.xpath("//div[@class='createAppWin']//span[text()='OK']");

//	public final static By CreateApplication_Title = By.xpath("//form[@id='app_profileForm']//div[@id='appInfotitle'][text()='Create Application']");
//	public final static By CreateApplication_Label_Appid = By.xpath("//form[@id='app_profileForm']//label[text()='App id:']");
//	public final static By CreateApplication_input_Appid = By.xpath("//form[@id='app_profileForm']//input[@id='app_id']");
//	public final static By CreateApplication_Label_Appname = By.xpath("//form[@id='app_profileForm']//label[text()='App name:']");
//	public final static By CreateApplication_input_Appname = By.xpath("//form[@id='app_profileForm']//input[@id='app_name']");
//	public final static By CreateApplication_Label_Appdescription = By.xpath("//form[@id='app_profileForm']//label[text()='App description:']");
//	public final static By CreateApplication_input_Appdescription = By.xpath("//form[@id='app_profileForm']//textarea[@id='app_description']");
//	public final static By CreateApplication_Label_Applogo = By.xpath("//form[@id='app_profileForm']//label[text()='App logo:']");
//	public final static By CreateApplication_input_Applogo = By.xpath("//form[@id='app_profileForm']//input[@id='appLogoImg']");
//	public final static By CreateApplication_Label_AppTemplate = By.xpath("//form[@id='app_profileForm']//label[text()='App Template:']");
//	public final static By CreateApplication_select_AppTemplate = By.xpath("//form[@id='app_profileForm']//select[@id='app_template']");
//	public final static By CreateApplication_Advanced_arrow = By.xpath("//form[@id='app_profileForm']//a[@id='appAdvanced_btn']");
//	public final static By CreateApplication_Advanced_label_Prefix = By.xpath("//div[@id='appAdvanced']//label[text()='Prefix:']");
//	public final static By CreateApplication_Advanced_input_Prefix = By.xpath("//div[@id='appAdvanced']//input[@id='app_prefix']");
//	public final static By CreateApplication_Advanced_label_URI = By.xpath("//div[@id='appAdvanced']//label[text()='URI:']");
//	public final static By CreateApplication_Advanced_input_URI = By.xpath("//div[@id='appAdvanced']//input[@id='app_uri']");
//	public final static By CreateApplication_Advanced_label_TermURI = By.xpath("//div[@id='appAdvanced']//label[text()='Term URI:']");
//	public final static By CreateApplication_Advanced_input_TermURI = By.xpath("//div[@id='appAdvanced']//input[@id='app_term_uri']");
//	public final static By CreateApplication_Advanced_button_Reset = By.xpath("//span[@id='app_info_reset']");
//	public final static By CreateApplication_Advanced_button_OK = By.xpath("//span[@id='app_info_save']");

	public final static By Applicationinformation_Title = By.xpath("//div[@id='appInfotitle' and text()='App Info']");
	public final static By Applicationinformation_Label_Appid = By.xpath("//div[@id='app_profileForm']//label[text()='App Id:']");
	public final static By Applicationinformation_input_Appid = By.xpath("//div[@id='app_profileForm']//input[@id='app_id']");
	public final static By Applicationinformation_input_Prefix = By.xpath("//div[@id='app_profileForm']//input[@id='app_prefix']");
	public final static By Applicationinformation_input_URI = By.xpath("//form[@id='app_profileForm']//input[@id='app_uri']");
	public final static By Applicationinformation_input_TermURI = By.xpath("//form[@id='app_profileForm']//input[@id='app_term_uri']");

	public final static By Applicationinformation_Advanced_arrow = By.xpath("//form[@id='app_profileForm']//a[@id='appAdvanced_btn']");
	public final static By Applicationinformation_Label_Appname = By.xpath("//div[@id='app_profileForm']//label[text()='App Name:']");
	public final static By Applicationinformation_input_Appname = By.xpath("//div[@id='app_profileForm']//input[@id='app_name']");
	public final static By Applicationinformation_Label_Appdescription = By.xpath("//*[@id='app_profileForm']/fieldset/div[3]/label[1]");
	public final static By Applicationinformation_input_Appdescription = By.xpath("//div[@id='app_profileForm']//textarea[@id='app_description']");
	public final static By Applicationinformation_Label_Applogo = By.xpath("//div[@id='app_profileForm']//label[text()='App Logo:']");
	public final static By Applicationinformation_input_Applogo = By.xpath("//div[@id='app_profileForm']//input[@id='appLogoImg']");
	public final static By UploadExcelToServer_button_X = By.xpath("//i[@id='close_datasheetfile_win']");

	
	public final static By AppInfo_Title = By.xpath("//div[@id='base_createapp']//span[text()='App Info']");
	public final static By AppInfo_Label_Appname = By.xpath("//div[@id='base_createapp']//span[text()='App Name:']");
	public final static By AppInfo_input_Appname = By.xpath("//div[@id='base_createapp']//div[@class='ax_default text_field'][1]//input");
	public final static By AppInfo_Label_Appdescription = By.xpath("//div[@id='base_createapp']//span[text()='App Description:']");
	public final static By AppInfo_input_Appdescription = By.xpath("//div[@id='base_createapp']//div[@class='ax_default text_field'][2]//input");
	public final static By AppInfo_Label_Applogo = By.xpath("//div[@id='base_createapp']//span[text()='App Logo:']");
	public final static By AppInfo_input_Applogo = By.xpath("//div[@id='base_createapp']//div[@class='ax_default text_field'][3]//input");
	public final static By AppInfo_button_OK = By.xpath("//div[@id='base_createapp']//div[@class='ax_default button']//span[text()='OK']");
	public final static By AppInfo_button_Cancel = By.xpath("//div[@id='base_createapp']//div[@class='ax_default button']//span[text()='Cancel']");

	public final static By AddADatabase_Title = By.xpath("//div[@class='col-md-12 order-md-1']//h4[text()='Add a database']");
	public final static By AddADatabase_Label_DB_service_Name = By.xpath("//label[@for='databaseName']");
	public final static By AddADatabase_input_DB_service_Name = By.xpath("//input[@id='databaseName']");
	public final static By AddADatabase_Label_DescriptionOptional = By.xpath("//label[@for='databaseDescription']");
	public final static By AddADatabase_input_DescriptionOptional = By.xpath("//input[@id='databaseDescription']");
	public final static By AddADatabase_Label_DatabaseType = By.xpath("//label[@for='databaseType']");
	public final static By AddADatabase_input_DatabaseType = By.xpath("//input[@id='databaseType']");
	public final static By AddADatabase_Label_Host = By.xpath("//label[@for='host']");
	public final static By AddADatabase_input_Host = By.xpath("//input[@id='host']");
	public final static By AddADatabase_Label_Port = By.xpath("//label[@for='port']");
	public final static By AddADatabase_input_Port = By.xpath("//input[@id='port']");
	public final static By AddADatabase_Label_DatabaseName = By.xpath("//label[@for='database']");
	public final static By AddADatabase_input_DatabaseName = By.xpath("//input[@id='database']");
	public final static By AddADatabase_Label_UserName = By.xpath("//label[@for='username']");
	public final static By AddADatabase_input_UserName = By.xpath("//input[@id='username']");
	public final static By AddADatabase_Label_Password = By.xpath("//label[@for='password']");
	public final static By AddADatabase_input_Password = By.xpath("//input[@id='password']");
	public final static By AddADatabase_button_TestConnect = By.xpath("//button[@id='testConnectionBtn']");
	public final static By AddADatabase_button_Submit = By.xpath("//button[@id='addBtn']");

//	public final static By DataBaseInform_Title = By.xpath("//span[@id='databaseName']");
//	public final static By DataBaseInform_DownloadOWLs = By.xpath("//a[@id='downloadOwls']/img[@alt='Download OWLs']");
//	public final static By DataBaseInform_Table = By.xpath("//span[@id='databaseName']/ancestor::div[@class='page-header']/following-sibling::table");
	public final static By DatabaseInfo_Title = By.xpath("//span[@id='databaseName']");
	public final static By DatabaseInfo_Img_DownloadOWLs = By.xpath("//img[@title='Download OWLs']");
	public final static By DatabaseInfo_Img_RefreshOWLs = By.xpath("//img[@id='syncDatabase']");
	public final static By DatabaseInfo_label_Description = By.xpath("//table//td[text()='Description']");
	public final static By DatabaseInfo_value_Description = By.xpath("//table//td[@id='description']");
	public final static By DatabaseInfo_label_Status = By.xpath("//table//td[text()='Status']");
	public final static By DatabaseInfo_value_Status = By.xpath("//table//td[text()='Status']/following-sibling::td/label[@class='switch']");
	public final static By DatabaseInfo_label_Type = By.xpath("//table//td[text()='Type']");
	public final static By DatabaseInfo_value_Type = By.xpath("//table//td[text()='Type']/following-sibling::td");
	public final static By DatabaseInfo_label_Connection = By.xpath("//table//td[text()='Connection']");
	public final static By DatabaseInfo_value_Connection = By.xpath("//table//td[text()='Connection']/following-sibling::td[@id='endpoint']");
	public final static By DatabaseInfo_label_CreateTime = By.xpath("//table//td[text()='CreateTime']");
	public final static By DatabaseInfo_value_CreateTime = By.xpath("//table//td[text()='CreateTime']/following-sibling::td[@id='createTime']");
	public final static By DatabaseInfo_label_Tables = By.xpath("//table//td[text()='Tables']");
	public final static By DatabaseInfo_Tables = By.xpath("//table[@id='tables']");
	public final static By DEV_QUEUE_CO_23__QSYNC_title = By.xpath("//span[@id='tableName'][text()='DEV_QUEUE_CO_23::QSYNC']");
	public final static By TableColumns_DetailTable = By.xpath("//span[@id='tableName'][text()='DEV_QUEUE_CO_23::QSYNC']");

	public final static By WebTest_Title = By.xpath("//span[@id='serviceName'][text()='WebTest']");
	public final static By WebTest_Form = By.xpath("//span[@id='serviceName'][text()='WebTest']/parent::h4/parent::div/following-sibling::table");
	public final static By WebTest_label_Description = By.xpath("//span[@id='serviceName'][text()='WebTest']");
	public final static By WebTest_label_downloadOwls = By.xpath("//a[@id='downloadOwls']");
	public final static By WebTest_value_Description = By.xpath("//td[@id='description']");
	public final static By WebTest_label_Status = By.xpath("//table/tbody/tr[2]/td[1][text()='Status']");
	public final static By WebTest_value_Status = By.xpath("//table/tbody/tr[2]/td[1][text()='Status']//following-sibling::td//span[@class='slider round']");
	public final static By WebTest_label_Type = By.xpath("//table/tbody/tr[3]/td[1][text()='Type']");
	public final static By WebTest_value_Type = By.xpath("//table/tbody/tr[3]/td[1][text()='Type']/following-sibling::td");
	public final static By WebTest_label_Endpoint = By.xpath("//table/tbody/tr/td[text()='Endpoint']");
	public final static By WebTest_value_Endpoint = By.xpath("//table/tbody//td[@id='endpoint']");
	public final static By WebTest_label_CreateTime = By.xpath("//table/tbody/tr/td[text()='CreateTime']");
	public final static By WebTest_value_CreateTime = By.xpath("//table/tbody//td[@id='createTime']");
//	public final static By WebTest_label_Processes = By.xpath("//table/tbody/tr[6]/td[1][text()='Processes']");
//	public final static By WebTest_values_Processes = By.xpath("//table/tbody/tr[6]/td[1][text()='Processes']/following-sibling::td/table");
	public final static By WebTest_label_Operations = By.xpath("//table/tbody/tr/td[text()='Operations']");
	public final static By WebTest_values_Operations = By.xpath("//table/tbody/tr/td[text()='Operations']/following-sibling::td/table");

	
	public final static By WebTest$Add_Title = By.xpath("//span[@id='processName'][text()='WebTest::Add']");
	public final static By WebTest$Add_Table = By.xpath("//div[@id='grid']/div/div[@class='gc-grid-container']");
	public final static By WebTest$Add_Table_ColHeader = By.xpath("//div[contains(@id , 'columnHeader-inner')]");

	public final static By RestTest_Title = By.xpath("//span[@id='serviceName'][text()='RestTest']");
	public final static By RestService_DownloadImg = By.xpath("//a[@id='downloadOwls']");
	public final static By RestTest_Table = By.cssSelector("body > div.container.body-content > table");
	public final static By RestTest_label_Description = By.xpath("//td[@id='description']/preceding-sibling::td");
	public final static By RestTest_value_Description = By.xpath("//td[@id='description']");
	public final static By RestTest_label_Status = By.xpath("//td[text()='Status']");
	public final static By RestTest_value_Status = By.xpath("//input[@id='enable']");
	public final static By RestTest_label_Type = By.xpath("//td[text()='Type']");
	public final static By RestTest_value_Type = By.xpath("//td[text()='Type']/following-sibling::td");
	public final static By RestTest_label_URL = By.xpath("//td[text()='URL']");
	public final static By RestTest_value_URL = By.xpath("//td[@id='url']");
	public final static By RestTest_value_Method = By.xpath("//td[@id='method']");

	public final static By RestTest_label_CreateTime = By.xpath("//td[text()='CreateTime']");
	public final static By RestTest_value_CreateTime = By.xpath("//td[@id='createTime']");
	public final static By RestTest_value_Parameters = By.xpath("//input[@id='addParamEntry']");
	public final static By RestTest_button_Add = By.xpath("//input[@id='addProcess']");
	public final static By RestTest_label_Processes = By.xpath("//td[text()='Processes']");
	public final static By RestTest_label_Parameters = By.xpath("//td[text()='Parameters']");

	
	public final static By Newprocess_Title = By.xpath("//h5[@id='modalLabel' and text()='New process']");
	public final static By Newprocess_label_Name = By.xpath("//label[@for='name' and text()='Name']");
	public final static By Newprocess_input_Name = By.xpath("//input[@id='processName']");
	public final static By Newprocess_label_Description = By.xpath("//label[@for='description' and text()='Description']");
	public final static By Newprocess_input_Description = By.xpath("//input[@id='processDescription']");
	public final static By Newprocess_label_CacheTime = By.xpath("//label[@for='cachetime' and text()='Cache Time']");
	public final static By Newprocess_input_CacheTime = By.xpath("//input[@id='processCachetime']");
	public final static By Newprocess_tab_Request = By.xpath("//a[@id='requestTab' and text()='Request']");
	public final static By Newprocess_tab_Response = By.xpath("//a[@id='responseTab' and text()='Response']");
	public final static By Newprocess_input_Request = By.xpath("//textarea[@id='request']");
	public final static By Newprocess_input_Response = By.xpath("//textarea[@id='response']");
	public final static By Newprocess_button_Close = By.xpath("//button[text()='Close']");
	public final static By Newprocess_button_Save = By.xpath("//button[@id='saveProcessBtn']");

	public final static By AreaContainer = By.xpath("//div[@id='area']");
	public final static By QHIST = By.xpath("//div[@id='area']//td[text()='QHIST']/ancestor::div[1]");
	public final static By QINFO = By.xpath("//div[@id='area']//td[text()='QINFO']/ancestor::div[1]");
	public final static By QSYNC = By.xpath("//div[@id='area']//td[text()='QSYNC']/ancestor::div[1]");
	public final static By QUEUEDATA = By.xpath("//div[@id='area']//td[text()='QUEUEDATA']/ancestor::div[1]");
	public final static By REQINDEX = By.xpath("//div[@id='area']//td[text()='REQINDEX']/ancestor::div[1]");
	public final static By test = By.xpath("//div[@id='area']//td[text()='test']/ancestor::div[1]");
	public final static By TRXCACHE = By.xpath("//div[@id='area']//td[text()='TRXCACHE']/ancestor::div[1]");


	
	public final static By AddAwebservice_Title = By.xpath("//div[@class='col-md-12 order-md-1']//h4[text()='Add a webservice']");
	public final static By AddAwebservice_label_WebserviceName = By.xpath("//label[@for='serviceName']");
	public final static By AddAwebservice_input_WebserviceName = By.xpath("//div[@id='new_pop_stream']//input");
	public final static By AddAwebservice_label_DescriptionOptional = By.xpath("//label[@for='serviceDescription']");
	public final static By AddAwebservice_input_DescriptionOptional = By.xpath("//input[@id='serviceDescription']");
	public final static By AddAwebservice_label_Addfromwebserviceurl = By.xpath("//a[@id='addFromUrlTab']");
	public final static By AddAwebservice_label_AddfromlocalWSDL$XSDfile = By.xpath("//a[@id='addFromFileTab']");
	public final static By AddAwebservice_input_Addfromwebserviceurl = By.xpath("//input[@id='webserviceUrl']");
	public final static By AddAwebservice_button_OK = By.xpath("//div[@class='ax_default primary_button']//p[@class='new_pop_ok']");
	public final static By AddAwebservice_button_Upload_WSDLXSD_file = By.xpath("//button[@id='fileAddBtn']");
	public final static By AddAwebservice_button_Add = By.xpath("//button[@id='addWebserviceBtn']");

	public final static By AddAHTTP$HTTPS_API_Title = By.xpath("//div[@class='col-md-12 order-md-1']//h4[text()='Add a HTTP/HTTPS API']");
	public final static By AddAHTTP$HTTPS_API_label_ServiceName = By.xpath("//form[@id='addServiceForm']//label[@for='serviceName']");
	public final static By AddAHTTP$HTTPS_API_input_ServiceName = By.xpath("//form[@id='addServiceForm']//input[@id='serviceName']");
	public final static By AddAHTTP$HTTPS_API_label_DescriptionOptional = By.xpath("//form[@id='addServiceForm']//label[@for='serviceDescription']");
	public final static By AddAHTTP$HTTPS_API_input_DescriptionOptional = By.xpath("//form[@id='addServiceForm']//input[@id='serviceDescription']");
	public final static By AddAHTTP$HTTPS_API_label_HTTP$HTTPS_URL = By.xpath("//form[@id='addServiceForm']//label[@for='serviceUrl']");
	public final static By AddAHTTP$HTTPS_API_select_HTTP$HTTPS_URL = By.xpath("//form[@id='addServiceForm']//select[@id='method']");
	public final static By AddAHTTP$HTTPS_API_input_HTTP$HTTPS_URL = By.xpath("//form[@id='addServiceForm']//input[@id='serviceUrl']");
	public final static By AddAHTTP$HTTPS_API_button_Submit = By.xpath("//form[@id='addServiceForm']//button[@id='addBtn']");
	public final static By AddAHTTP$HTTPS_API_input_ServiceUrl = By.xpath("//form[@id='addServiceForm']//input[@id='serviceUrl']");


	public final static By REFRESH = By.id("refreshBtn");
	public final static By Delete = By.xpath("//*[@id='deleteProjectBtn']/span[text()='Delete']");
	public final static By inProcess = By.xpath("//div[@id='progressWin'][contains(@style, 'display: block')]");
	public final static By BUILD_APP = By.className("buildProjectItem");
	public final static By BUILD_APP_WEB = By.xpath("//div[contains(@data-options,'buildWebAction')]");
	public final static By COPY_APP = By.xpath("//div[contains(@data-options,'copyAppAction')]");

	public final static By DELETE_APP = By
			.xpath("//div[@id='treeContextMenu']/div[@class='delProjectItem menu-item']/div/span[text()='Delete']");

	// COYP APP
	// public final static By Copy_Application =
	// By.xpath("//div[@id='appInfotitle'][text()='Copy Application']");

	// Elements for NEW APP
	public final static By App_id = By.xpath("//input[@id='app_id']/preceding-sibling::label[1]");
	public final static By Input_App_id = By.id("app_id");
	// public final static By Domain = By.id("orgDomainDiv");
	public final static By Domain = By.xpath("//select[@id='app_domain']/preceding-sibling::label[1]");
	public final static By Domain_Select = By.id("app_domain");

	public final static By Advanced = By.xpath("//*[@id='app_profileForm']/div[@class='file-list-appAdvanced']/div[1]");
	public final static By Advanced_btn = By
			.xpath("//*[@id='app_profileForm']/div[@class='file-list-appAdvanced']/div[2]/a[@id='appAdvanced_btn']");
	public final static By Advanced_FrameArea = By.id("appAdvanced");

	public final static By Prefix = By.xpath("//input[@id='app_prefix']/preceding-sibling::label[1]");
	public final static By Prefix_input = By.id("app_prefix");

	public final static By URI = By.xpath("//input[@id='app_uri']/preceding-sibling::label[1]");
	public final static By URI_Input = By.id("app_uri");

	public final static By Term_URI = By.xpath("//input[@id='app_term_uri']/preceding-sibling::label[1]");
	public final static By Term_URI_Input = By.id("app_term_uri");

	public final static By Reset = By.xpath("//span[@id='app_info_reset'][text()='Reset']");
	public final static By app_info_save_OK = By.xpath("//span[@id='app_info_save'][text()='OK']");

	// Delete APP
	public final static By Delete_Box = By.id("confirmWin");
	public final static By Delete_MSG_Content = By.xpath("//div[@id='new_pop_stream']//p/span[contains(@style,'word-wrap')]");
	public final static By Delete_OK = By.xpath("//div[@id='new_pop_stream']//button[text()='OK']");
	public final static By Delete_Cancel = By.xpath("//div[@id='new_pop_stream']//button[text()='Cancel']");
	
	// Data右键菜单
	public final static By ADD = By.xpath("//div[contains(@data-options,'addDataFileAction')]");
	public final static By Download = By.xpath("//div[contains(@data-options,'downloadAction')]");
	public final static By New_Data = By.xpath(
			"//div[@id='treeContextMenu']/div[contains(@data-options, 'newFolderAction')]/div/span[text()='New']");
	public final static By New_sheet = By.xpath(
			"//div[@id='treeContextMenu']/div[contains(@data-options, 'newDataSheetAction')]/div/span[text()='New sheet']");

	public final static By Delete_Data = By.xpath("//*[@id='treeContextMenu']/div[22]/div[1]/span[text()='Delete']");
	public final static By Delete_File = By.xpath("//div[contains(@data-options,'deleteCSVDataFileAction')]");

	public final static By ADD_TITLE = By.xpath("//div[@id='addDataFileWin']/div[1]/div/div[1]/span[1]");
	public final static By File = By.xpath("//li[contains(@class,'tabs-first')]/a/span[1]");
	public final static By Select_XSDWSDLExcel_file_content = By.xpath("//*[@id='datafileZone']/div[1]/label/span");
	public final static By Select_XSDWSDLExcel_file_Upload = By.xpath("//input[@type='file'][@title='Click to add Files']");
	public final static By confirm_universal = By.id("confirm-universal-content");
	public final static By confirm_universal_Checkbox = By
			.xpath("//*[@id='confirm-universal-content']/ul/li/input[@type='checkbox']");
	public final static By confirm_universal_continue = By.id("confirm_universal_continue");
	public final static By confirm_Yes = By.xpath("//span[@id='confirm_win_yes']");

	public final static By or = By.xpath("//*[@id='datafileZone']/div[2]");
	public final static By Provide_a_co_driver_URL = By.xpath("//*[@id='datafileZone']/div[3]/span");
	public final static By Provide_a_co_driver_URL_Input = By.id("data_file_url");
	public final static By Provide_a_co_driver_URL_Submit = By.id("data_file_url_submit");

	public final static By New_Excel_Close = By.id("input_win_close");
	public final static By LiteChatTest_ChannelName = By.id("channelname");
	public final static By PendingCheckin_btn_Checkin = By.xpath("//button[text()='Checkin']");
	public final static By PendingCheckin_btn_Uncheck = By.xpath("//button[text()='Uncheck']");
	public final static By Learning_QA = By.xpath("//div[@class='panel-header pannelHeader']/div[text()='QA']");
	public final static By Learning_Session = By.xpath("//div[@class='panel-header pannelHeader']/div[text()='Session']");
	public final static By Learning_STATUS = By.id("statuslabel");
	public final static By Learning_FROM = By.xpath("//label[@class='layui-form-label' and text()='FROM']");
	public final static By Learning_TO = By.xpath("//label[@class='layui-form-label' and text()='TO']");
	public final static By Learning_select_STATUS = By.xpath("//label[@id='statuslabel']/following-sibling::div[1]/div");
	
	public final static By New_a_blank_excel_template_Title = By.xpath("//h4[text()='New a blank excel template']");
	public final static By Nabet_label_TemplateName = By.xpath("//form[@id='addServiceForm']//label[text()='Template Name']");
	public final static By Nabet_input_TemplateName = By.xpath("//form[@id='addServiceForm']//input[@id='templateName']");
	public final static By Nabet_label_Description  = By.xpath("//form[@id='addServiceForm']//label[@for='templateDescription']");
	public final static By Nabet_input_Description = By.xpath("//form[@id='addServiceForm']//input[@id='templateDescription']");
	public final static By Nabet_Submit = By.xpath("//form[@id='addServiceForm']//button[@id='addBtn']");

	public final static By Upload_an_Excel_Template_Title = By.xpath("//h4[text()='Upload an Excel Template']");
	public final static By UaET_label_TemplateName = By.xpath("//form[@id='addTemplateForm']//label[text()='Template Name']");
	public final static By UaET_input_TemplateName = By.xpath("//form[@id='addTemplateForm']//input[@id='templateName']");
	public final static By UaET_label_Description  = By.xpath("//form[@id='addTemplateForm']//label[@for='templateDescription']");
	public final static By UaET_input_Description = By.xpath("//form[@id='addTemplateForm']//input[@id='templateDescription']");
	public final static By UaET_Submit = By.xpath("//form[@id='addTemplateForm']//button[@id='uploadExcelBtn']");
	public final static By UaET_btn_UploadExcelTemplatefile = By.xpath("//form[@id='addTemplateForm']//button[@id='fileAddBtn']");
	public final static By Table_rightclickFlowUnitMenu = By.xpath("//table[@class='mxPopupMenu']");

	//-----------------IntelliSense
	public final static By REXToolbarUnit = By.xpath("//div[@class='geToolbarContainer top']//a[contains(@style,'overflow')][5]");
	public final static By AutoCompleteMenu = By.xpath("//ul[@id='AutoCompleteMenu' and contains(@style,'display: block')]");
	public final static By REXgeBackgroundPage = By.xpath("//div[@class='geBackgroundPage']");
	public final static By REXTopbar_Format = By.xpath("//div[@class='geToolbarContainer top']//div[@class='geSprite geSprite-dots']");
	public final static By REXTopbar_SetFontColor = By.xpath("//div[@class='geIcon geSprite geSprite-fontcolor']");
	public final static By SetFontColorPage_Cancel = By.xpath("//div[@class='geDialog']//button[text()='Cancel']");
	public final static By SetFontColorPage_Apply = By.xpath("//div[@class='geDialog']//button[text()='Apply']");
	public final static By SetFontColorRGB(String RGB) {
		return By.xpath("//td[contains(@style,'"+RGB+"')]");	
	}
	
	//-----------Resource
	public final static By Button_Upload = By.xpath("//button[@id='upload_b']");
	public final static By Button_Browser_Files = By.xpath("//button[@id='FF']");

	//frame
	public final static By ucx_file_iframe = By.xpath("//iframe[@id='ucx_file_iframe']");
	public final static By xlsx_file_iframe = By.xpath("//canvas[@id='ssvp_vp']");
	public final static By externalApp_iframe = By.xpath("//iframe[@id='externalAppIframe']");

	//---------Create Release
	public final static By CreateRelease_Title = By.xpath("//span[text()='Create Release']");
	public final static By CreateNewRelease_btn = By.xpath("//span[text()='Create New Release']");
	public final static By PreviousReleases_Title = By.xpath("//span[text()='Previous Releases']");

	

	
	
	
	
	
	
	
	public static WebElement getWebElementByIndex(WebDriver driver ,By by ,int index) {
		List<WebElement> elements = driver.findElements(by);
		return elements.get(index);
	}
	
}
