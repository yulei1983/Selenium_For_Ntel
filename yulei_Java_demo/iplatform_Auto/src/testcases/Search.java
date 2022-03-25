package testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import objectRepository.AppElements;
import prepare.MMDriver;
import utils.Lib;
import utils.PropertiesDataProvider;

public class Search {	
	WebDriver driver = null;
	AutoItX AutoWin = null;
	int WaitTime = 0;
	String downloadpath = "";
	String UploadFilePath = "";
	String UserName = "uitest@cyberobject.com.cn";
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
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Lib.login_AppBuilder(driver, "uitest@cyberobject.com.cn", "123456");
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		UploadFilePath = PropertiesDataProvider.getTestData("config/config.properties", "UploadFilePath");
		WaitTime = Integer.parseInt(sWaitTime);
		driver.switchTo().defaultContent();
		Lib.wait_Sleep(2000);
		driver.switchTo().frame("moduleFrame");
	}

	@AfterClass
	public void afterClass() {
		//Debug 请注释以下
		driver.switchTo().defaultContent();
		Lib.wait_Sleep(WaitTime);
		driver.findElement(AppElements.SIGNOUT_arrow).click();
        Lib.wait_Sleep(WaitTime);
		driver.findElement(AppElements.SIGNOUT).click();

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
	public void Search_01_One_page(){
		try {
			Lib.SelectApp(driver, "fm_app","Listapps");
			if(!Lib.isExist(driver, AppElements.Console_expand)) {
				driver.findElement(AppElements.Console_arrow_left).click();
				Lib.wait_Sleep(3000);
			}
			
			driver.findElement(AppElements.Search).click();
			driver.findElement(AppElements.inputBox_Search).sendKeys("fmtest");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Label_Content_resultNotFound, true);
			Lib.wait_Sleep(3000);
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(WaitTime);
			Lib.chkIsDisplayed(driver, AppElements.Label_File_resultNotFound, true);

			Lib.SelectApp(driver, "fm_search","Listapps");
			driver.findElement(AppElements.button_SearchClear_X).click();
			Lib.ChkProperty(driver, AppElements.inputBox_Search, "value", "");
			
			driver.findElement(AppElements.inputBox_Search).sendKeys("fMtEst");	
			driver.findElement(AppElements.button_Search).click();
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			List<String> expecteds = Arrays.asList("Data/Search_Data_folder_alfenny test/template created/Search_Data_file_FMTEST11.xlsxFmTeSt123@cyberobject.com.cn",
					                               "Document/Search_Doc_folder_alfenny test/search eat_food.rexset <Coffee type>=<FMTEST>");
			List<WebElement> results = driver.findElements(AppElements.Label_Content_resultView_s);
	        int i = 0;
			for (WebElement webElement : results) {
				Lib.ChkProperty(driver, webElement, "textContent", expecteds.get(i));
				i++;
			}
			Lib.wait_Sleep(WaitTime);
            //Click "search eat_food.rex"
			results.get(1).findElement(By.xpath(".//a")).click();
			Lib.wait_Sleep(5000);
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			By viso_by = By.xpath("//div[@style='display:inline-block;text-align:inherit;text-decoration:inherit;']");
		    List<WebElement> webElements = driver.findElements(viso_by);
            List<String> Actuals = new ArrayList();
		    for (WebElement webElement : webElements) {
		    	Actuals.add(webElement.getAttribute("outerText")) ;
			}
		    Boolean flag = false;
			for (String string : Actuals) {	
				                  
				if(string.equals("set <Coffee type>=<FMTEST>")) {
					flag = true;
					break;
				}
			}
			MMDriver.softAssert.assertTrue(flag , "set <Coffee type>=<FMTEST> is not found!");
			Lib.SwitchToFrame(driver, "moduleFrame");
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds = new ArrayList<>();
			results = new ArrayList<>();
			expecteds.add("Data/Search_Data_file_fMtEsT.xlsxSearch_Data_file_fMtEsT.xlsx");
			expecteds.add("Data/Search_Data_folder_alfenny test/template created/Search_Data_file_FMTEST11.xlsxSearch_Data_file_FMTEST11.xlsx");
			expecteds.add("Document/Search_Doc_folder_Coffee/Drink/search fmtest.rexsearch fmtest.rex");

			results = driver.findElements(AppElements.Label_Content_resultView_s);
			i = 0;
			for (WebElement webElement : results) {
			Lib.ChkProperty(driver, webElement, "textContent", expecteds.get(i));
			i++;
			}
	
		} catch (Exception e) {
			Lib.clear_page(driver, UserName, Password);
			MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg)+";"+ e.toString() + "@@\n");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Search_02_multipage(){
		try {
			Lib.wait_Sleep(2000);
			Lib.SelectApp(driver, "fm_app","Listapps");
			
			if(!Lib.isExist(driver, AppElements.Console_expand)) {
				driver.findElement(AppElements.Console_arrow_left).click();
			}
			
			Lib.wait_Sleep(3000);
			
			if (!driver.findElement(AppElements.inputBox_Search).getAttribute("value").equals("")) {
				driver.findElement(AppElements.button_SearchClear_X).click();
			}
			driver.findElement(AppElements.inputBox_Search).sendKeys("fanmingtest");
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			
			List<String> expecteds = Arrays.asList("Data/Search_Data_file_fanming test.xlsxFANMINGTEST",
					"Data/Search_FanMingTest.xlsxfaNmINGtEST",
					"Document/Search_Doc_folder_Coffee/Pay/search CreditcardFaNmInGtEsT.rexJump-car-FANMINGtest");
			Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.Label_File).click();
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_FanMingTest.xlsxSearch_FanMingTest.xlsx",
					                                 "Document/Search_Doc_folder_Coffee/Pay/search CreditcardFaNmInGtEsT.rexsearch CreditcardFaNmInGtEsT.rex")); 
			Lib.wait_Sleep(3000);
			Lib.ChkSearchResults(driver, expecteds);

			
			Lib.SelectApp(driver, "fm_search","Listapps");
//			driver.findElement(AppElements.Search).click();
			driver.findElement(AppElements.button_SearchClear_X).click();	
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.inputBox_Search).sendKeys("FAnMIngteST");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_Data_file_fMtEsT.xlsxgreen tea, red tea, flower tea, wulong teaFANMINGTest",
					                                 "Data/Search_Data_folder_ReturnPurchase/Search_Data_file_DeliveryInfo.xlsxfanmingtest"));
			Lib.ChkSearchResults(driver, expecteds);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),true);

			AppElements.Search_result_page(driver, "2").click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_Data_folder_ReturnPurchase/Search_Data_file_DeliveryInfo.xlsxfanmingtest",
					                                 "Document/Search_Doc_folder_Coffee/Food/search Food_order.rexJump-Repeatfoodorderfanmingtest"));
            Lib.ChkSearchResults(driver, expecteds);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Prev"),true);

			AppElements.Search_result_page(driver, "Prev").click();
			Lib.wait_Sleep(2000);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Prev"),false);
			
			AppElements.Search_result_page(driver, "Next").click();
			Lib.wait_Sleep(3000);
			AppElements.Search_result_page(driver, "Next").click();
			Lib.wait_Sleep(3000);
			
			expecteds =new ArrayList<>(Arrays.asList("Document/Search_Doc_folder_Coffee/Food/search Food_order.rexfanmingtestJump-Order in cyberobject/wmx_app/Document/Coffee/Drink/Coffee_order.rex",
					                                 "Document/Search_Doc_folder_Coffee/search_Coffee_quit.rexGoodbye! See FanMingtest next time!",
					                                 "Document/Search_Doc_folder_Coffee/search_Coffee_quit.rexFanMingtest end"));
            Lib.ChkSearchResults(driver, expecteds);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),false);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Prev"),true);
			
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_Data_folder_alfenny test/Search_file types/Search_Data_file_DB_FANmingTEST.xlsxSearch_Data_file_DB_FANmingTEST.xlsx",
					"Document/Search_Doc_file_FANMingtestrex.rexSearch_Doc_file_FANMingtestrex.rex"));
            Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.button_SearchClear_X).click();	
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.inputBox_Search).sendKeys("sEARch");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			
			expecteds = Arrays.asList("Data/Search_Data_folder_alfenny test/Search_file types/Search_Data_file_sparql_universal.xlsxhe C-SPAN Video Library uses closed captioning as an aid to searching the video, but does not provide copies of the transcripts.",
					"Data/Search_Data_folder_alfenny test/Search_file types/Search_Data_file_sparql_universal.xlsxMany programs aired since 2003 have searchable text transcripts of the program’s closed captioning.");		
			Lib.ChkSearchResults(driver, expecteds);

			
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds = Arrays.asList("Data/Search_Data_file_fMtEsT.xlsxSearch_Data_file_fMtEsT.xlsx",
					                  "Document/Search_Doc_file_testflow2.rexSearch_Doc_file_testflow2.rex");	
			Lib.ChkSearchResults(driver, expecteds);
			
			AppElements.Search_result_page(driver, "2").click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Prev"),true);
			expecteds = Arrays.asList("Document/Search_Doc_file_testjump1.rexSearch_Doc_file_testjump1.rex",
					                  "Document/Search_Doc_folder_Coffee/search_Coffee_main.rexsearch_Coffee_main.rex");	
            Lib.ChkSearchResults(driver, expecteds);
            
            AppElements.Search_result_page(driver, "Prev").click();
            Lib.wait_Sleep(3000);
			expecteds = Arrays.asList("Data/Search_Data_file_fMtEsT.xlsxSearch_Data_file_fMtEsT.xlsx",
	                  "Document/Search_Doc_file_testflow2.rexSearch_Doc_file_testflow2.rex");	
            Lib.ChkSearchResults(driver, expecteds);
			
            AppElements.Search_result_page(driver, "3").click();
            Lib.wait_Sleep(3000);
			expecteds = Arrays.asList(
			"Document/Search_Doc_folder_Coffee/search_Coffee_prepare.rexsearch_Coffee_prepare.rex",
		    "Document/Search_Doc_folder_Coffee/search_Coffee_quit.rexsearch_Coffee_quit.rex",
		    "Document/Search_Doc_folder_Coffee/search_Coffee_register.rexsearch_Coffee_register.rex");
            Lib.ChkSearchResults(driver, expecteds);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "1"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "2"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "3"),true);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Next"),false);
			Lib.chkIsDisplayed(driver,AppElements.Search_result_page(driver, "Prev"),true);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Search_03_Special_query(){
		try {
			Lib.SelectApp(driver, "fm_search","Listapps");
			if(Lib.isExist(driver, AppElements.SearchConsole_arrow)) {
				driver.findElement(AppElements.Search).click();
			}
			
			Lib.wait_Sleep(3000);
			
			if (!driver.findElement(AppElements.inputBox_Search).getAttribute("value").equals("")) {
				driver.findElement(AppElements.button_SearchClear_X).click();
			}
			driver.findElement(AppElements.inputBox_Search).sendKeys("fm*t");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			
			List<String> expecteds = Arrays.asList("Data/Search_Data_folder_alfenny test/template created/Search_Data_file_FMTEST11.xlsxFmTeSt123@cyberobject.com.cn",
					"Document/Search_Doc_folder_alfenny test/search eat_food.rexset <Coffee type>=<FMTEST>"
					);
			Lib.ChkSearchResults(driver, expecteds);

			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_Data_file_fMtEsT.xlsxSearch_Data_file_fMtEsT.xlsx",
					"Data/Search_Data_folder_alfenny test/template created/Search_Data_file_FMTEST11.xlsxSearch_Data_file_FMTEST11.xlsx",
					"Document/Search_Doc_folder_Coffee/Drink/search fmtest.rexsearch fmtest.rex"));
			Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.button_SearchClear_X).click();	
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.inputBox_Search).sendKeys("search ");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.Label_Content_resultNotFound, true);
			
			driver.findElement(AppElements.button_SearchClear_X).click();	
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.inputBox_Search).sendKeys("search ");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Document/Search_Doc_folder_alfenny test/search eat_food.rexsearch eat_food.rex",
					                                 "Document/Search_Doc_folder_Coffee/Drink/search fmtest.rexsearch fmtest.rex",
					                                 "Document/Search_Doc_folder_Coffee/Food/search Food_Count.rexsearch Food_Count.rex",
					                                 "Document/Search_Doc_folder_Coffee/Food/search Food_order.rexsearch Food_order.rex"));
			Lib.ChkSearchResults(driver, expecteds);
			
		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Search_04_iplatform(){
		try {
			Lib.SelectApp(driver, "iplatform");
			if(Lib.isExist(driver, AppElements.SearchConsole_arrow)) {
				driver.findElement(AppElements.Search).click();
			}
			
			Lib.wait_Sleep(3000);
			
			if (!driver.findElement(AppElements.inputBox_Search).getAttribute("value").equals("")) {
				driver.findElement(AppElements.button_SearchClear_X).click();
			}
			driver.findElement(AppElements.inputBox_Search).sendKeys("InEt");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			
			List<String> expecteds = Arrays.asList("Data/app_termdef.xlsxINET_DOMAIN");
			Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			
			expecteds =new ArrayList<>(Arrays.asList("Data/ni_inet_domain.xlsxni_inet_domain.xlsx"));
			Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.button_SearchClear_X).click();	
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.inputBox_Search).sendKeys("RESUME");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			
			expecteds =new ArrayList<>(Arrays.asList("Data/appcmd.xlsxclear the session and remove the context. This will not resume from where it left over.",
					"Data/appcmd.xlsxclear the session and remove the context. This will not resume from where it left over.",
					"Data/appcmd.xlsxclear the session and remove the context. This will not resume from where it left over.",
					"Data/sparkle.xlsxresume context",
					"Data/sparkle.xlsxresume from <context> by <key type=term:TERM>",
					"Data/sparkle.xlsxresume workflowfrom where it left off",
					"Document/resume.rexentry-resume",
					"Document/resume.rexresume from <context> by <key type=term:sesskey>"));
			Lib.ChkSearchResults(driver, expecteds);
			
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Document/resume.rexresume.rex"));
			Lib.ChkSearchResults(driver, expecteds);
				

		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Search_05_Organization(){
		try {
			Lib.Switch_loginUser_AppBuilder(driver, "uitest@cyberobject.com.cn", "123456");
            Lib.SelectApp(driver, "Organization");
			if(Lib.isExist(driver, AppElements.SearchConsole_arrow)) {
				driver.findElement(AppElements.Search).click();
			}
			
			Lib.wait_Sleep(3000);
			
			if (!driver.findElement(AppElements.inputBox_Search).getAttribute("value").equals("")) {
				driver.findElement(AppElements.button_SearchClear_X).click();
			}
			
			driver.findElement(AppElements.inputBox_Search).sendKeys("fANmINgtESt");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			List<String> expecteds =new ArrayList<>(Arrays.asList("Data/Copy_Org_Checkin_out_Datafolder/Copy_Org_Checkin_Datafile.xlsxfanmingtest",
					"Data/Copy_Org_Checkin_out_Datafolder/Copy_Org_Checkin_Datafile.xlsxFanMingTest",
					"Data/DragDrop_Org_Checkin_out_Datafolder/DragDrop_Org_Checkin_Datafile.xlsxfanmingtest",
					"Data/DragDrop_Org_Checkin_out_Datafolder/DragDrop_Org_Checkin_Datafile.xlsxFanMingTest",
					"Data/Search_Org_FanMingTest/Search_Data_file_FanMingtest.xlsxfanmingtest",
					"Data/Search_Org_FanMingTest/Search_Data_file_FanMingtest.xlsxFanMingTest",
					"Document/Search_Doc_fileFANMINGtest.rexFanmingtesTend",
					"Document/Search_Doc_fileFANMINGtest.rexstartFANMINGTEST"));
			Lib.ChkSearchResults(driver, expecteds);
			
				

		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void Search_06_same_name_app(){
		try {
			Lib.Switch_loginUser_AppBuilder(driver, "yulei@cyberobject.com.cn", "123456");
            Lib.SelectApp(driver, "fm_app","Listapps");
			if(Lib.isExist(driver, AppElements.SearchConsole_arrow)) {
				driver.findElement(AppElements.Search).click();
			}
			
			Lib.wait_Sleep(3000);
			
			if (!driver.findElement(AppElements.inputBox_Search).getAttribute("value").equals("")) {
				driver.findElement(AppElements.button_SearchClear_X).click();
			}
			driver.findElement(AppElements.inputBox_Search).sendKeys("fanmingtest");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			List<String> expecteds =new ArrayList<>(Arrays.asList("Data/Search_Data_file_fanming test.xlsxFANMINGTEST",
					                                              "Data/Search_FanMingTest.xlsxfaNmINGtEST",
					                                              "Document/Search_Doc_folder_Coffee/Pay/search CreditcardFaNmInGtEsT.rexJump-car-FANMINGtest"));
			Lib.ChkSearchResults(driver, expecteds);
			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_FanMingTest.xlsxSearch_FanMingTest.xlsx",
					                                 "Document/Search_Doc_folder_Coffee/Pay/search CreditcardFaNmInGtEsT.rexsearch CreditcardFaNmInGtEsT.rex"));
            Lib.ChkSearchResults(driver, expecteds);
			
			Lib.Switch_loginUser_AppBuilder(driver, "uitest@cyberobject.com.cn", "123456");
			Lib.SelectApp(driver, "fm_app","Listapps");
			driver.findElement(AppElements.Search).click();
			driver.findElement(AppElements.inputBox_Search).sendKeys("fanmingtest");		
			Lib.simulate_Key(driver,Keys.ENTER);
			Lib.wait_Sleep(WaitTime);
			driver.findElement(AppElements.Label_Content).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_file_Samefanmingtest.xlsxfanmingTEST",
					                                 "Data/Search_SameFanMingTest.xlsxFANMINGtest",
					                                 "Document/Search_Doc_folder_Coffee/Pay/search SameFaNmInGtEsT.rexJump-carFANmingTest"));
            Lib.ChkSearchResults(driver, expecteds);

			driver.findElement(AppElements.Label_File).click();
			Lib.wait_Sleep(3000);
			expecteds =new ArrayList<>(Arrays.asList("Data/Search_file_Samefanmingtest.xlsxSearch_file_Samefanmingtest.xlsx",
					                                 "Data/Search_SameFanMingTest.xlsxSearch_SameFanMingTest.xlsx",
					                                 "Document/Search_Doc_folder_Coffee/Pay/search SameFaNmInGtEsT.rexsearch SameFaNmInGtEsT.rex"));
            Lib.ChkSearchResults(driver, expecteds);
            
            
		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
		MMDriver.softAssert.assertAll();
	}
	
	
}
