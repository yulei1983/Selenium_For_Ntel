package testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.annotation.Documented;
import java.security.KeyStoreSpi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.activation.ActivationDataFlavor;
import javax.imageio.ImageIO;
import javax.management.openmbean.KeyAlreadyExistsException;
import javax.print.CancelablePrintJob;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.MouseAction;
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
import com.google.common.net.PercentEscaper;
import com.jacob.com.LibraryLoader;
//import com.opera.core.systems.scope.protos.EcmascriptProtos.Runtime;
//import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
//import com.opera.core.systems.scope.protos.PrefsProtos.ListPrefsArgOrBuilder;
import com.thoughtworks.selenium.Selenium;

import autoitx4java.AutoItX;
import checkpoints.AppBChkPoint;
import jxl.biff.drawing.Drawing2;
import objectRepository.AppElements;
import objectRepository.MatterMost;
import prepare.MMDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.DatabaseTables;
import utils.FileListTable;
import utils.FlowUnit;
import utils.ImgChecker;
import utils.Lib;
import utils.PropertiesDataProvider;
import utils.UCXUnit;
import utils.WebList;

public class UI_Data_file_termdef {
	WebDriver driver = null;
	int WaitTime = 0;
	String currentWindow = "";//主页面
	AutoItX AutoWin = null;
	String downloadpath = "";
	String UploadFilePath = "";
	String UserName = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderUserName");  
	String Password = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderPassword");	
	String UserName_2 = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderUserName_2");  
	String Password_2 = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderPassword_2");
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
		driver.manage().timeouts().implicitlyWait(9 , TimeUnit.SECONDS);
		Lib.login_AppBuilder(driver, UserName, Password);
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		UploadFilePath = PropertiesDataProvider.getTestData("config/config.properties", "UploadFilePath");
		WaitTime = Integer.parseInt(sWaitTime);
		Lib.checkPageIsReady(driver);
		Lib.Switch_appGourp(driver, "uitest_cyberobject_com_cn");
		Lib.checkPageIsReady(driver);
		driver.findElement(AppElements.SwitchAppMenu_CustomObj("intellisensetest")).click();
		Lib.SwitchToFrame(driver, "moduleFrame");
		
//		String [] TrainList = {"Data/IntelliSense/nidef_individual.xlsx",
//				"Data/IntelliSense/records.xlsx",
//				"Data/IntelliSense/termdef_domain.xlsx",
//				"Data/application.xlsx",
//				"Data/document.xlsx",
//				"Data/drink.xlsx",
//				"Data/drinklist.xlsx",
//				"Data/member.xlsx",
//				"Data/Org01_PhoneTerm.xlsx",
//				"Data/PhoneInfoTerm.xlsx",
//				"Data/termdef.xlsx",
//				"Data/TrainTerm.xlsx",
//				}; 	
//		for (String trainlist : TrainList) {
//		Lib.mouseRightClick(driver, Lib.DirFile(driver, trainlist));
//		driver.findElement(AppElements.RIGHTCLICK_Excel_Menu_Train).click();
//		}		
	}

	@AfterClass
	public void afterClass() {
		//Debug 请注释以下
		if (Integer.parseInt(PropertiesDataProvider.getTestData("config/config.properties", "Debug")) == 0) {
			driver.switchTo().defaultContent();
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
		Lib.checkPageIsReady(driver);
	}

	@AfterMethod
	public void afterMethod() {
//		MMDriver.softAssert.assertAll();	
	}
	
	@Test
	public void IntelliSense_01_Term_Filter_Rex(){
		try {
			Lib.wait_Sleep(2000);
//			int UnitsSize = 0;
//			List<WebElement> Units = null;
			WebElement Unit = null;
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
//			Lib.SwitchToFrame(driver, "visio_file_iframe");
//		    driver.findElement(AppElements.REXToolbarUnit).click();
//			Units = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
//			UnitsSize = Units.size();
//			Units.get(UnitsSize-2);

			FlowUnit fUnit = new FlowUnit(driver);
			Actions actionbuilder = new Actions(driver);
			actionbuilder.doubleClick(fUnit.GetObjByContent("<medical_product>"));
			actionbuilder.sendKeys(Keys.ARROW_LEFT);
			actionbuilder.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(actionbuilder, "<use");
			actionbuilder.perform();
			//step01
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
//            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user id"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
//            Lib.highlight(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate")); 
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "UseDate")  , "innerText", "Use");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "UserID")  , "innerText", "Use");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "user ID of records")  , "innerText", "use");	
		    //step02
		    FlowUnit fut = new FlowUnit(driver);
		    actionbuilder.sendKeys(Keys.ESCAPE);
		    actionbuilder.perform();
		    actionbuilder.doubleClick(fut.GetObjByContent("jump-1<<"));
		    actionbuilder.sendKeys(Keys.ARROW_RIGHT);
			Lib.SendKeysOnebyOne(actionbuilder, "<*Use");
			actionbuilder.perform();
           Lib.checkPageIsReady(driver); 
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID"), true);
			
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "UserID")  , "innerText", "Use");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "user")  , "innerText", "use");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "user ID of records")  , "innerText", "use");		
           //step03
		    actionbuilder.sendKeys(Keys.ARROW_LEFT);
			actionbuilder.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "US"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user id"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',UserID of DB member']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',MobileCodeInfo']")) , true);
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"US"), "innerText", "US");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user id"), "innerText", "us");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "us");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UseDate"), "innerText", "Us");	

		    //step04
			Lib.SendKeysOnebyOne(actionbuilder, "er");
			actionbuilder.perform();
			
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',UserID of DB member']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',MobileCodeInfo']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user input"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID"), true);
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "user");

            //step05
		    actionbuilder.sendKeys(Keys.BACK_SPACE);
			Lib.SendKeysOnebyOne(actionbuilder, "r");
			actionbuilder.perform();
			
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user input"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',UserID of DB member']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',MobileCodeInfo']")) , true);
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "use");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UseDate"), "innerText", "Use");
			//step06
		    actionbuilder.sendKeys("r");
		    actionbuilder.sendKeys(Keys.SPACE);
			actionbuilder.perform();
		    
//            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user id"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',UserID of DB member']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=',MobileCodeInfo']")) , true);

//		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user id"), "innerText", "user");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "user");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");	 

		    //step07
			Lib.SendKeysOnebyOne(actionbuilder, "k");
			actionbuilder.perform();
			Lib.chkIsDisplayed(driver, driver.findElement(AppElements.AutoCompleteMenu).findElement(By.xpath("./li[1]")) , false);
			actionbuilder.sendKeys(Keys.ESCAPE);
			actionbuilder.perform();
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("jump-1<<<User ke") , true);
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");

			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	@Test
	public void IntelliSense_02_Term_Oprations_Rex(){
		try {
			Lib.wait_Sleep(1000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			FlowUnit fut = new FlowUnit(driver);
			fut.ReleaseObjs();
			fut.CreateUnit(1, "1", "Good");
			Actions action = new Actions(driver);
			action.doubleClick(fut.GetObj("1"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.sendKeys("<");
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step02
			action.sendKeys("N");
			action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Brunswick"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Hampshire"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Mexico"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Jersey"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New York"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Newfoundland and Labrador"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Carolina"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Dakota"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northern Mariana Islands"), true);

			Lib.GetAutoCompleteObjByName(driver, "New York").click();
			action.click(driver.findElement(AppElements.REXgeBackgroundPage));
			action.perform();
			Lib.ChkProperty(driver, fut.GetObj("1"), "innerText", "Good<New York>");

			action.doubleClick(fut.GetObj("1"));
			action.sendKeys(Keys.ARROW_RIGHT);
			for (int i = 0; i < 8; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			
			fut.CreateUnit(2, "2", "Great");
			fut.DragAndDropUnit("2", 200, 200);
			action.doubleClick(fut.GetObj("2"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.sendKeys("<North");
			action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Carolina"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Dakota"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northern Mariana Islands"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northwest Territories"), true);

			action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ENTER);
			action.perform();
			action.click(driver.findElement(AppElements.REXgeBackgroundPage));
			action.perform();			
			Lib.ChkProperty(driver, fut.GetObj("2"), "innerText", "Great<Northern Mariana Islands>");
			
			action.doubleClick(fut.GetObj("2"));
			action.perform();
			for (int i = 0; i < 20; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			action.perform();
			
			action.sendKeys("<man&");
			action.perform();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			
			Lib.ChkProperty(driver, fut.GetGreenWordNode("2"), "title", "http://www.cyberobject.com/2012/12/term#MP");
			
			action.doubleClick(fut.GetObj("2"));
			action.sendKeys(Keys.DELETE);
			action.perform();
			
			Lib.ChkProperty(driver, fut.GetObj("2"), "innerText", "");
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_03_Term_Triggers_Rex(){
		try {
//			Lib.checkPageIsReady(driver);
			Lib.wait_Sleep(2000);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
			action.doubleClick(fut.GetObjByContent("<<A"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			//step02
			action.sendKeys("ri");
			action.perform();
			
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Arizona"), true);
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,1), "innerText", "Ari");	

		    //step03
		    Lib.GetAutoCompleteObjByName(driver, "Arizona").click();
		    action.sendKeys(Keys.ESCAPE);
		    action.perform();
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("<<Arizona>"), true);
			Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<<Arizona>", "<Arizona>"), true);

			//step04
			action.doubleClick(fut.GetObjByContent("<"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.perform();

			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step05
			action.sendKeys("<Al");
			action.perform();

			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alabama"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alaska"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alberta"), true);
			//step06
			for (int i = 0; i < 3; i++) {
				action.sendKeys(Keys.BACK_SPACE);
			}
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step07
			action.doubleClick(fut.GetObjByContent("We will travel to Beijing."));
			action.sendKeys(Keys.ARROW_RIGHT);
//			for (int i = 0; i < 4; i++) {
//				action.sendKeys(Keys.ARROW_LEFT);
//			}
			action.sendKeys(Keys.ARROW_LEFT);
			action.sendKeys("<");
			action.perform();
			action.sendKeys("to");
			action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjRedWord(driver, "tom"), true);

			//step08
		    Lib.GetAutoCompleteObjByName(driver, "tomorrow").click();
		    action.sendKeys(Keys.ESCAPE);
		    action.perform();                              
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("We will travel to Beijing<tomorrow>."), true);
			Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("We will travel to Beijing<tomorrow>.", "<tomorrow>"), true);

			//step09
			action.doubleClick(fut.GetObjByContent("what is your name?"));
			action.sendKeys(Keys.ARROW_RIGHT);
			for (int i = 0; i < 5; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			action.perform();
			action.sendKeys("<firs");
			action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "first"), true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver, "first"), "innerText", "firs");

			//step10
		    Lib.GetAutoCompleteObjByName(driver, "first").click();
		    action.sendKeys(Keys.ESCAPE);
		    action.perform();
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("what is your <first>name?"), true);
			Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("what is your <first>name?", "<first>"), true);
            
			//step11
			action.keyDown(Keys.CONTROL);
			action.sendKeys("s");
			action.keyUp(Keys.CONTROL);
			action.perform();
			
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("<<Arizona>"), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("<"), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("We will travel to Beijing<tomorrow>."), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("what is your <first>name?"), true);

			//step12
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("<<A"), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("<"), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("We will travel to Beijing."), true);
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("what is your name?"), true);
			Lib.SwitchToFrame(driver, "moduleFrame");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");

			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_04_Term_Orange_Rex(){
        WebDriver dr2 = new ChromeDriver();
        dr2.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		try {
			Lib.wait_Sleep(2000);
//			Lib.checkPageIsReady(driver);
			//step01
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step02
			action.doubleClick(fut.GetObjByContent("See you <tomorrow>"));
			action.perform();
//			action.sendKeys(Keys.ARROW_RIGHT);
//			for (int i = 0; i < 5; i++) {
//				action.sendKeys(Keys.ARROW_LEFT);
//			}
			action.moveToElement(fut.GetObjByContent("See you <tomorrow>"), 78, 8);
			action.release();
			action.build();
			action.perform();
			Lib.wait_Sleep(1000);
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"manana"), "innerText", "manana");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"morn"), "innerText", "morn");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"tomorrow"), "innerText", "tomorrow");
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"tomorrow"), "innerText", "tomorrow");	
		    //step03
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			Lib.wait_Sleep(3500);

			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			//step04 failed
			action.doubleClick(fut.GetObjByContent("See you <tomorrow>"));
			action.perform();
//			action.sendKeys(Keys.ARROW_RIGHT);
//			for (int i = 0; i < 5; i++) {
//				action.sendKeys(Keys.ARROW_LEFT);
//			}
			action.moveToElement(fut.GetObjByContent("See you <tomorrow>"), 155, 41);
			action.release();
			action.build();
			action.perform();
			Lib.GetAutoCompleteObjByName(driver, "morn").click();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			Lib.chkIsDisplayed(driver , fut.GetObjByContent("See you <tomorrow>") , true);
			
			//step05
			action.doubleClick(fut.GetObjByContent("Good"));
			action.perform();
			action.sendKeys(Keys.ARROW_RIGHT);			
			action.perform();
			action.sendKeys("<tom");
			action.perform();
			
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"tomorrow"), "innerText", "tom");	
		    Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"tomorrow"), "innerText", "tom");	

			//step06
		    action.moveToElement(Lib.GetAutoCompleteObjRedWord(driver, 1));
		    action.perform();
			Lib.ChkProperty(driver, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[1]")), "title", "http://www.uitest_cyberobject_com_cn.com/intellisensetest/term#tomorrow1");
			
			//step07
		    action.moveToElement(Lib.GetAutoCompleteObjRedWord(driver, 2));
		    action.perform();
			Lib.ChkProperty(driver, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[2]")), "title", "http://www.uitest_cyberobject_com_cn.com/intellisensetest/term#tomorrow1");

			//step08
			Lib.GetAutoCompleteObj(driver, 1).click();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			
			Lib.chkIsDisplayed(driver , fut.GetObjByContent("Good<tomorrw>") , true);
			Lib.chkIsDisplayed(driver , fut.GetOrangeWordNodeInSpecificUnit("Good<tomorrw>", "<tomorrw>") , true);

			//step09
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("document.body.style.zoom = '0.9'");

			action.doubleClick(fut.GetObjByContent("Good<tomorrw>"));
//			action.sendKeys(Keys.ARROW_LEFT);
//			for (int i = 0; i < 6; i++) {
//				action.sendKeys(Keys.ARROW_RIGHT);
//			}
			action.perform();
			action.moveToElement(fut.GetOrangeWordNodeInSpecificUnit("Good<tomorrw>", "<tomorrw>"));
			action.perform();

			Lib.chkIsDisplayed(driver , Lib.GetAutoCompleteObjByName(driver, "manana") , true);
			Lib.chkIsDisplayed(driver , Lib.GetAutoCompleteObjByName(driver, "morn") , true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObj(driver, 3), "innerText", "tomorrw");
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObj(driver, 4), "innerText", "tomorrw");
            //step10
			action.moveToElement(Lib.GetAutoCompleteObjByName(driver, "manana"));
			action.perform();
			Lib.ChkProperty(driver, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[1]")), "title", "http://www.cyberobject.com/uitest_cyberobject_com_cn/intellisense_test/term#tomorrow");
            //step11

            Lib.login_AppBuilder(dr2, UserName_2, Password_2);
    		Lib.wait_Sleep(3000);
    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
    		Lib.wait_Sleep(3000);
    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisense_test")).click();
    		Lib.SwitchToFrame(dr2, "moduleFrame");
    		Lib.DirFile(dr2, "Document/IntelliSense/Test_IntelliSense.rex").click();
			FlowUnit fut2 = new FlowUnit(dr2);
			Actions action2 =new Actions(dr2);
//          String currentWindow = driver.getWindowHandle();
            fut2.GetObjByContent("See you <tomorrow>").click();
            action2.moveToElement(fut2.GetObjByContent("See you <tomorrow>"), 115, 41);
            action2.perform();

            Lib.chkIsDisplayed(dr2, Lib.GetAutoCompleteObjByName(dr2, "tomorrow"), true);
            action2.moveToElement(Lib.GetAutoCompleteObjByName(dr2, "tomorrow"));
            action2.perform();

            Lib.chkIsDisplayed(dr2, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[@title='http://www.uitest_cyberobject_com_cn.com/intellisensetest/term#tomorrow1'][1]")), false);

            //step12 failed
			Lib.GetAutoCompleteObjByName(dr2, "manana").click();
			action2.sendKeys(Keys.ESCAPE);
			action2.perform();
            
			Lib.chkIsDisplayed(dr2 , fut2.GetObjByContent("See you <tomorrow>") , true);
			//step13
			action.doubleClick(fut.GetObjByContent("Good<tomorrw>"));
			action.moveToElement(fut.GetGreenWordNodeInSpecificUnit("Good<tomorrw>", "<tomorrw>"));
			action.perform();
			Lib.GetAutoCompleteObjByName(driver, "manana").click();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			Lib.chkIsDisplayed(driver , fut.GetObjByContent("Good<manana>") , true);

			dr2.quit();
			executor.executeScript("document.body.style.zoom = '1'");
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
		} catch (Exception e) {
			dr2.quit();
 			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("document.body.style.zoom = '1'");
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	@Deprecated
//	@Test
	public void IntelliSense_05_Term_Highlight_Realtime_Rex(){
		WebDriver dr2 = new ChromeDriver(); 
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
		    Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Midway Islands> <Spanish>", "<Midway Islands>"), true);
		    Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Midway Islands> <Spanish>", "<Spanish>"), true);
            //step02
            Lib.login_AppBuilder(dr2, UserName_2, Password_2);
    		Lib.wait_Sleep(3000);
    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
    		Lib.wait_Sleep(3000);
    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisense_test")).click();
    		Lib.SwitchToFrame(dr2, "moduleFrame");
    		Lib.DirFile(dr2, "Document/IntelliSense/Test_IntelliSense.rex").click();
			FlowUnit fut2 = new FlowUnit(dr2);
			Actions action2 =new Actions(dr2);
			Lib.CheckOutRex(dr2, "Data/IntelliSense/Test_IntelliSense.xlsx");
			Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Data/IntelliSense/Test_IntelliSense.xlsx"));
			dr2.findElement(AppElements.RIGHTCLICK_Sheet_Menu_Train).click();
			if (!Lib.isExist(dr2, AppElements.Console_Window)) {
				dr2.findElement(AppElements.Btn_Console_op).click();
	    		Lib.wait_Sleep(3000);
			}
			Lib.CheckConsoleMsg(dr2, "Succeeded in training document IntelliSense/Test_Intellisence.xlsx.");

			//step03
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.rex").click();
			Lib.SwitchToFrame(driver, "visio_file_iframe");
		    Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Midway Islands> <Spanish>", "<Midway Islands>"), true);
		    Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("<Midway Islands> <Spanish>", "<Spanish>"), true);

			//step04
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			action.doubleClick(fut.GetObjByContent("<Midway Islands> <Spanish>"));
			action.sendKeys(Keys.ARROW_RIGHT);
			for (int i = 0; i < 7; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			action.perform();
			action.sendKeys("n");
			action.perform();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			
		    Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Midwaya Islands> <Snpanish>"), true);
		    Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Midwaya Islands> <Snpanish>","<Midwaya Islands>"), true);
		    Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Midwaya Islands> <Snpanish>","<Snpanish>"), true);
		    //step05
			action.doubleClick(fut.GetObjByContent("<Midwaya Islands> <Snpanish>"));
			action.sendKeys(Keys.ARROW_LEFT);
			for (int i = 0; i < 8; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
			}
			action.sendKeys(Keys.BACK_SPACE);
			action.perform();
			for (int i = 0; i < 13; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
			}
			action.sendKeys(Keys.BACK_SPACE);
			action.perform();
			action.sendKeys(Keys.ESCAPE);
			action.perform();
		    Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Midway Islands> <Spanish>","<Midway Islands>"), true);
		    Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("<Midway Islands> <Spanish>","<Spanish>"), true);
		    
		    //step06
    		Lib.SwitchToFrame(dr2, "moduleFrame");
    		Lib.DirFile(dr2, "Document/IntelliSense/Test_term_highlight.rex").click();
			Lib.SwitchToFrame(dr2, "visio_file_iframe");
		    Lib.chkIsDisplayed(dr2, fut2.GetGreenWordNodeInSpecificUnit("<Midway Islands> <Spanish>", "<Midway Islands>"), true);
		    Lib.chkIsDisplayed(dr2, fut2.GetOrangeWordNodeInSpecificUnit("<Midway Islands> <Spanish>","<Spanish>"), true);

		    //step07 can not operate xlsx file. 
		    

			Lib.RestoreRex(dr2, "Document/IntelliSense/Test_term_highlight.rex");
			dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
		} catch (Exception e) {
			Lib.RestoreRex(dr2, "Document/IntelliSense/Test_term_highlight.rex");
			dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	@Test
	public void IntelliSense_06_Term_Highlight_SingleMulti_use_Rex(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Single_Multi-use.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Single_Multi-use.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
			
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Alberta>> is <belong> to <US>", "<belong>"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Great wall>", "<Great  wall>"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<New York>", "<New  York>"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<No.1>", "<No.1>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alberta>> is <belong> to <US>", "<Alberta>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alberta>> is <belong> to <US>", "<US>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<now>", "<now>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("what is date of <today>?", "<today>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<term:DATE>", "<term:DATE>"), true);

		    //step02
            action.doubleClick(fut.GetObjByContent("<"));
			action.sendKeys(Keys.ARROW_RIGHT);
            action.sendKeys("current time>");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
            
	        Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<current time>", "<current time>"), true);

	        //step03
	        action.doubleClick(fut.GetObjByContent("Time"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.sendKeys("<today>");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
	        Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Time<today>","<today>"), true);

	        //step04
	        action.doubleClick(fut.GetObjByContent("Total:"));
			action.sendKeys(Keys.ARROW_RIGHT);
			Lib.SendKeysOnebyOne(action, "<10");
			action.perform();
			String str = "$>";
			action.sendKeys(str);
			Lib.SendKeysOnebyOne(action, str);
			action.sendKeys(Keys.ESCAPE);
			action.perform();
	        Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("Total:<10$>","<10$>"), true);
            
	         //step05
	        action.doubleClick(fut.GetObjByContent("<<"));
			action.sendKeys(Keys.ARROW_RIGHT);
//			action.sendKeys("gender>");
			Lib.SendKeysOnebyOne(action, "gender>");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
	        Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("<<gender>","<gender>"), true);
 
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Single_Multi-use.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Single_Multi-use.rex");

			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_07_Term_Highlight_EditEffects_Rex(){
		try {
			Lib.checkPageIsReady(driver);
			//step01
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action = new Actions(driver);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alaska> is <belong> to <US> <tomorrow>", "<Alaska>"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<Alaska> is <belong> to <US> <tomorrow>", "<belong>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alaska> is <belong> to <US> <tomorrow>", "<US>"), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("<Alaska> is <belong> to <US> <tomorrow>", "<tomorrow>"), true);
          //set red.
            Lib.SetWordColor(driver, "<Alaska> is <belong> to <US> <tomorrow>", 0, 8, "rgb(255, 0, 0)");
    		Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Alaska> is <belong> to <US> <tomorrow>").findElement(By.xpath("./span//font[@color='#ff0000' and text()='<Alaska>']")), true);

    		fut.SetUnitContext("<Alabama>", "Jack");
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("Jack", "Jack"), false);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Jack", "Jack"), false);
            
            //step04
            action.doubleClick(fut.GetObjByContent("<North Carolina>,<product>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 17; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            Lib.SendKeysOnebyOne(action, "<fir");
            action.perform();
            Lib.wait_Sleep(1000);
            Lib.GetAutoCompleteObj(driver, 1).click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<North Carolina>,<first><product>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<North Carolina>,<first><product>", "<first>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<North Carolina>,<first><product>", "<North Carolina>"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("<North Carolina>,<first><product>", "<product>"), true);

            action.doubleClick(fut.GetObjByContent("<No.1 School>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 5; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("<New York>");
            action.perform();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<No.1<New York> School>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<No.1<New York> School>", "<New York>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<No.1<New York> School>", "<No.1"), false);

            //step06
            action.doubleClick(fut.GetObjByContent("<Islands>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("n");
            action.perform();
            
            Lib.GetAutoCompleteObjByName(driver, "Indiana").click();

            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();

            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Indiana>", "<Indiana>"), true);

            action.doubleClick(fut.GetObjByContent("<Midway time>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 7; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("<ma");
            action.perform();
            
            Lib.GetAutoCompleteObjByName(driver, "male").click();

            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();

            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Midway<male>"), true);
            //step08
            action.doubleClick(fut.GetObjByContent("(<Chinese score of records> > <Maths score of records> + 20)"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("Phy");
            action.perform();

            Lib.GetAutoCompleteObjByName(driver, "Physics score of records").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("(<Physics score of records> > <Maths score of records> + 20)"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("(<Physics score of records> > <Maths score of records> + 20)", "<Physics score of records>"), true);

            action.doubleClick(fut.GetObjByContent("what is your <first> name?"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 13; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("$");
            action.perform();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();

            Lib.chkIsDisplayed(driver, fut.GetObjByContent("what is your $<first> name?"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("what is your $<first> name?", "<first>"), true);

            action.doubleClick(fut.GetObjByContent("I come from $<Alaska>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 13; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("I come from <Alaska>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("I come from <Alaska>", "<Alaska>"), true);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_08_Term_Replace_Rex(){
		try {
            Lib.wait_Sleep(1000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Replace.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_Replace.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
            action.doubleClick(fut.GetObjByContent("<Alabama> is one state of USA."));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 1; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            Lib.SendKeysOnebyOne(action, "ala");
            action.perform();
            Lib.wait_Sleep(1000);
            Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Alaska> is one state of USA."), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alaska> is one state of USA.", "<Alaska>"), true);
           //step02
            action.doubleClick(fut.GetObjByContent("<Alabama> belongs US"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("la");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Alaska> belongs US"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alaska> belongs US", "<Alaska>"), true);
			
            //step03
            action.doubleClick(fut.GetObjByContent("what is your <first> name?"));
            action.sendKeys(Keys.ARROW_RIGHT);
            for (int i = 0; i < 7; i++) {
                action.sendKeys(Keys.ARROW_LEFT);
			}
            action.sendKeys("S");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "FirstStation").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("what is your <FirstStation> name?"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("what is your <FirstStation> name?", "<FirstStation>"), true);

            action.doubleClick(fut.GetObjByContent("<US> is a developed <country>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 3; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("A");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "USA").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<USA> is a developed <country>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<USA> is a developed <country>", "<USA>"), true);

            action.doubleClick
            (fut.GetObjByContent("My <last name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]."));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 4; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("first");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "first name").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("My <first name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]."), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("My <first name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif].", "<first name>"), true);

            action.doubleClick(fut.GetObjByContent("My name is Tom."));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("<fir");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "first").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("My<first> name is Tom."), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("My<first> name is Tom.", "<first>"), true);

            //step07
            action.doubleClick(fut.GetObjByContent("is my birthday."));
            action.sendKeys(Keys.ARROW_LEFT);

            action.sendKeys("<tod");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "today").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<today>is my birthday."), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<today>is my birthday.", "<today>"), true);

            action.doubleClick(fut.GetObjByContent("Tomorrow is my"));
            action.sendKeys(Keys.ARROW_RIGHT);
            action.sendKeys("<birth");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "birthday").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
           
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("Tomorrow is my<birthday>"), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("Tomorrow is my<birthday>", "<birthday>"), true);

            action.doubleClick(fut.GetObjByContent("<Ohio> belongs to <US>."));
            action.sendKeys(Keys.ARROW_LEFT);

            action.sendKeys("<Ala");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Alabama").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Alabama><Ohio> belongs to <US>."), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Alabama><Ohio> belongs to <US>.", "<Alabama>"), true);

            action.doubleClick(fut.GetObjByContent("My is Tom, Now we start to watch as shown in [All Resource/Hello.gif]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("<last");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "last name").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("My<last name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]"), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("My<last name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]", "<last name>"), true);
            //step11
            action.doubleClick(fut.GetObjByContent("if a > b"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 3; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.perform();
            Lib.SendKeysOnebyOne(action, "<ala");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            //failed need to review
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("if <Alaska>a > b"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("if <Alaska>a > b", "<Alaska>"), true);

            //step12
            action.doubleClick(fut.GetObjByContent("<The Aloha State> belongs to <US>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("<Tex");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Texas").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<T<Texas> belongs to <US>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<T<Texas> belongs to <US>", "<Texas>"), true);

            //step13
            action.doubleClick(fut.GetObjByContent("<Hello [All Resource/Hello.gif]>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 2; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.perform();
            action.sendKeys("a");
            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Hawaii").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            //low issue, no need fix now
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<Hawaii>ello [All Resource/Hello.gif]>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<Hawaii>ello [All Resource/Hello.gif]>", "<Hawaii>"), true);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Replace.rex");

		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Replace.rex");

			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_09_Term_Nest_Rex(){
		try {
            Lib.wait_Sleep(2000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Nest.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_Nest.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step02
            action.doubleClick(fut.GetObjByContent("set <user id> = (<users id> where [<UserID>]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 18; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
            //step03
            Lib.SendKeysOnebyOne(action, "use i");
            action.perform();
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjRedWord(driver, "user ID"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user id"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user input"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user speech"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user input status"), true);

			//step04
            Lib.GetAutoCompleteObjByName(driver, "user id").click();

            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
			
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("set <user id> = (<users id> where [<UserID>]"), true);
            Lib.assertTrue(fut.GetGreenWordNodesInSpecificUnit("set <user id> = (<users id> where [<UserID>]", "<user id>")==2);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("set <user id> = (<users id> where [<UserID>]", "<UserID>"), true);
            //step05
            action.doubleClick(fut.GetObjByContent("<today>, $(<today> where [<tomorrow>,<current  date>]),<now>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 32; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}

            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "manana"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "morn"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
            //IP-1960
            Lib.GetAutoCompleteObjByName(driver, "manana").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<today>, $(<today> where [<manana>, <current date>]),<now>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<today>, $(<today> where [<manana>, <current date>]),<now>", "<manana>"), true);

            action.doubleClick(fut.GetObjByContent("<today>, $(<today> where [<manana>, <current date>]),<now>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 34; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            
            action.sendKeys("<current time");
            action.sendKeys(Keys.ENTER);
            action.perform();
            
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform(); 
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<today>, $(<today> where [<manana><current time>, <current date>]),<now>"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("<today>, $(<today> where [<manana><current time>, <current date>]),<now>", "<current time>"), true);

            action.doubleClick(fut.GetObjByContent("<today>, $(<today> where [<manana><current time>, <current date>]),<now>"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 48; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            
            action.sendKeys("<tomorrow>");
            action.perform();
            
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("<today>, $(<today> where [<manana><current time><tomorrow>, <current date>]),<now>"), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("<today>, $(<today> where [<manana><current time><tomorrow>, <current date>]),<now>", "<tomorrow>"), true);

            action.doubleClick(fut.GetObjByContent("Study name plus Length = {<MyName> + $<length>/3}"));
            action.sendKeys(Keys.ARROW_RIGHT);
            for (int i = 0; i < 12; i++) {
                action.sendKeys(Keys.ARROW_LEFT);
			}
            action.sendKeys(Keys.DELETE);
            action.perform();
            
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();

            Lib.chkIsDisplayed(driver, fut.GetObjByContent("Study name plus Length = {<MyName> + <length>/3}"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Study name plus Length = {<MyName> + <length>/3}", "<length>"), true);

            action.doubleClick(fut.GetObjByContent("(<drink_ID> < 50 or <cardnumber> > 31)"));
            action.sendKeys(Keys.ARROW_RIGHT);
            for (int i = 0; i < 13; i++) {
                action.sendKeys(Keys.ARROW_LEFT);
			}
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();

            Lib.GetAutoCompleteObjByName(driver, "card number").click();
            
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("(<drink_ID> < 50 or <card number> > 31)"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("(<drink_ID> < 50 or <card number> > 31)", "<card number>"), true);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}

//	@Deprecated
	@Test
	public void IntelliSense_10_Term_Filter_Ucx(){
		try {
	        Lib.wait_Sleep(2000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action=new Actions(driver);
			//step01
			action.click(uxn.GetObjByContent("2.1.2", "<Gender>"));
			for (int i = 0; i < 4; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			Lib.SendKeysOnebyOne(action, "<**use");
			action.perform();
			
			//step02
			action.moveToElement(uxn.GetObjByContent("2.1.3.1.1", "You are a gentlemen<<"), 161, 10);
			action.click();
 			action.perform();
	        Lib.wait_Sleep(1000);	        
			Lib.SendKeysOnebyOne(action, "<Use");
 			action.perform();
//			action.sendKeys(Keys.ARROW_DOWN);
//			action.perform();
	        Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UseDate"), true);
//            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user id"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            try {
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=', UserID of DB member']")) , true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=', MobileCodeInfo']")) , true);
			} catch (Exception e) {
			}
            //step03
	        Lib.wait_Sleep(1000);
            action.sendKeys(Keys.ARROW_LEFT);
            action.perform();
	        Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "US"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjRedWord(driver, "US"), true);

            //step04
			Lib.SendKeysOnebyOne(action, "er");
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            try {
               Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=', UserID of DB member']")) , true);
			} catch (Exception e) {
			}
            Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input status"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user speech"), "innerText", "user");

	        //step05
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
            try {
                Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=', UserID of DB member']")) , true);
			} catch (Exception e) {
			}
            Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UseDate"), "innerText", "Use");
            Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "Use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"use criteria"), "innerText", "use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user"), "innerText", "use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input status"), "innerText", "use");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user speech"), "innerText", "use");
			
			//step06
            action.sendKeys("r");
            action.perform();
	        Lib.wait_Sleep(1000);
            action.sendKeys(Keys.SPACE);
            action.sendKeys(Keys.SPACE);
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input status"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user speech"), "innerText", "user");
			
            try {
               Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "UserID").findElement(By.xpath("./following-sibling::span[text()=', UserID of DB member']")) , true);
			} catch (Exception e) {
			}
            Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user ID of records"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"UserID"), "innerText", "User");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user"), "innerText", "user");
	        Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"user input"), "innerText", "user");

			//step07
            action.sendKeys("g");
            action.perform();
            
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_11_Term_Operations_Ucx(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action=new Actions(driver);

            //step01
			action.moveToElement(uxn.GetObjByContent("3.3", "advance"), 60, 6);
            action.click();
            action.perform();
            action.sendKeys("<");
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);
            //step02
            action.sendKeys("N");
            action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Brunswick"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Hampshire"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Jersey"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New Mexico"), true);

            //step03
            for (int i = 0; i < 12; i++) {
                action.sendKeys(Keys.ARROW_DOWN);
			}
            action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "New York"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Carolina"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Dakota"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northern Mariana Islands"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northwest Territories"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Nova Scotia"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "now"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Nunavut"), true);

            //step04
            Lib.GetAutoCompleteObjByName(driver, "New York").click();
            Lib.wait_Sleep(500);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.3", "advance<New York>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "advance<New York>", "<New York>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step05
			action.moveToElement(uxn.GetObjByContent("3.3", "advance<New York>"), 150, 6);
            action.click();
            action.perform();
            for (int i = 0; i < 17; i++) {
                action.sendKeys(Keys.BACK_SPACE);
                action.perform();
			}
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
            Lib.assertTrue(uxn.GetBlankLine("3.3"));
            //step06
			action.moveToElement(uxn.GetObjByContent("3.1", "initial"), 70, 6);
            action.click();
            action.perform();
            action.sendKeys("<Nort");
            action.perform();
            Lib.wait_Sleep(500);
            action.sendKeys("h");
            action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Carolina"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "North Dakota"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northern Mariana Islands"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Northwest Territories"), true);
            //step07 bug: IP-3547 skip line
//            for (int i = 0; i < 2; i++) {
//				action.sendKeys(Keys.ARROW_DOWN);
//				action.perform();
//			}
//            action.sendKeys(Keys.ENTER);
//            action.perform();
            Lib.GetAutoCompleteObjByName(driver, "Northern Mariana Islands").click();
            Lib.wait_Sleep(500);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.1", "initial<Northern Mariana Islands>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1", "initial<Northern Mariana Islands>", "<Northern Mariana Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step08
			action.moveToElement(uxn.GetObjByContent("3.1", "initial<Northern Mariana Islands>"), 0, 6);
            action.click();
            action.perform();
            for (int i = 0; i < 3; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
				action.perform();
			}
            action.sendKeys("<O");
            action.perform();
            Lib.wait_Sleep(500);
            action.sendKeys("h");
            action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Ohio"), true);
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "Ohio").getText(), "Oh");
            //step09
            action.sendKeys(Keys.ENTER);
            action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.1", "ini<Ohio>tial<Northern Mariana Islands>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1", "ini<Ohio>tial<Northern Mariana Islands>", "<Ohio>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step10
			action.moveToElement(uxn.GetObjByContent("3.1", "ini<Ohio>tial<Northern Mariana Islands>"), 0, 6);
            action.click();
            action.perform();
            for (int i = 0; i < 5; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
				action.perform();
			}
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1", "ini<Ohio>tial<Northern Mariana Islands>", "<Ohio>").getAttribute("title") , "http://www.cyberobject.com/2012/12/term#OH");
            //step11
			action.moveToElement(uxn.GetObjByContent("3.1", "ini<Ohio>tial<Northern Mariana Islands>"), 0, 6);
            action.click();
            action.perform();
            action.keyDown(Keys.SHIFT);
            for (int i = 0; i < 39; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.keyUp(Keys.SHIFT);
            action.perform();
            action.sendKeys(Keys.DELETE);
            action.perform();
            Lib.wait_Sleep(1000);
            
            Lib.assertTrue(uxn.GetBlankLine("3.1"));
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_12_Term_Triggers_Ucx(){
		try {
            Lib.wait_Sleep(2000);
			Lib.checkPageIsReady(driver);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			//step01 failed
			action.moveToElement(uxn.GetObjByContent("2.2", "<<A"), 40, 10);
			action.click();
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			//step02
			Lib.SendKeysOnebyOne(action, "ri");
			action.perform();
            Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Arizona"), true);
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "Arizona").getText(), "Ari");
            //step03
            Lib.GetAutoCompleteObjByName(driver, "Arizona").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2.2", "<<Arizona>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2", "<<Arizona>", "<Arizona>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step04
			action.moveToElement(uxn.GetObjByContent("2.1.3.2", "<"), 20, 10);
			action.doubleClick();
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step05 failed,no menu display.
			action.moveToElement(uxn.GetObjByContent("2.1.3.2", "<"), 20, 10);
			action.click();
			action.perform();
            Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<Al");
			action.perform();
            Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alabama"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alaska"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Alberta"), true);
            //step06
            for (int i = 0; i < 3; i++) {
                action.sendKeys(Keys.BACK_SPACE);
                action.perform();
	            Lib.wait_Sleep(500);
			}
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step07
			action.moveToElement(uxn.GetObjByContent("3.2.1", "The metaphase is a Beginner."), 0, 10);
			action.click();
			action.perform();
			for (int i = 0; i < 13; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
				action.perform();
	            Lib.wait_Sleep(500);
			}
			action.sendKeys("<");
			action.perform();
            Lib.wait_Sleep(1000);
			action.sendKeys("to");
			action.perform();
            Lib.wait_Sleep(1000);
			action.sendKeys("m");
			action.perform();
            Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "tomorrow").getText(), "tom");

            //step08
            Lib.GetAutoCompleteObjByName(driver, "tomorrow").click();
            Lib.wait_Sleep(500);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.2.1", "The metaphase<tomorrow> is a Beginner."), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.2.1", "The metaphase<tomorrow>", "<tomorrow>").getCssValue("color"), "rgba(255, 165, 0, 1)");

            //step09
			action.moveToElement(uxn.GetObjByContent("2.1.1", "Now you need provide yourself information to create a count ."), 1, 10);
			action.doubleClick();
			action.perform();
			action.sendKeys(Keys.ARROW_LEFT);
			action.perform();
			for (int i = 0; i < 30; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
				action.perform();
			}
			action.sendKeys("<term:fi");
			action.perform();
            Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term:FIRST_NAME"), true);
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "term:FIRST_NAME").getText(), "term:FI");
            //step10
            Lib.GetAutoCompleteObjByName(driver, "term:FIRST_NAME").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2.1.1", "Now you need provide yourself <term:FIRST_NAME>information to create a count ."), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.1", "Now you need provide yourself <term:FIRST_NAME>information to create a count .", "<term:FIRST_NAME>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step11
            action.keyDown(Keys.CONTROL);
            action.sendKeys("s");
            action.keyUp(Keys.CONTROL);
            action.perform();

            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2.1.3.2", "<"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2", "<<Arizona>", "<Arizona>").getCssValue("color"), "rgba(0, 128, 0, 1)");
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_13_Term_Orange_Ucx(){
		WebDriver dr2 = new ChromeDriver();
		try {
			Lib.checkPageIsReady(driver);
			Lib.wait_Sleep(1000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.ucx").click();
//			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			//step01
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2", "I am glad to see you <tomorrow>."), true);
            //step02
			action.moveToElement(uxn.GetObjByContent("2", "I am glad to see you <tomorrow>."), 180, 10);
			action.click();
			action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "manana"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "morn"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);

            //step03
			action.moveToElement(uxn.GetObjByContent("2", "I am glad to see you <tomorrow>."), 10, 10);
            action.click();
			action.perform();
            Lib.wait_Sleep(3000);
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step04
			action.moveToElement(uxn.GetObjByContent("2", "I am glad to see you <tomorrow>."), 180, 10);
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "morn").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2", "I am glad to see you <tomorrow>."), true);

            //step05
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.ucx").click();
            Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			action.moveToElement(uxn.GetObjByContent("3.3", "advance"), 80, 10);
			action.click();
			action.perform();
			action.sendKeys("<to");
			action.sendKeys("m");
			action.perform();
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "tomorrow"), true);
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "tomorrow").getText(), "tom");
            //step06
            action.moveToElement(Lib.GetAutoCompleteObjByName(driver, "tomorrow"));
            action.perform();
			Lib.ChkProperty(driver, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[1]")), "title", "http://www.uitest_cyberobject_com_cn.com/intellisensetest/term#tomorrow1");
			//step07
			Lib.ChkProperty(driver, driver.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li[2]")), "title", "http://www.cyberobject.com/uitest_cyberobject_com_cn/intellisensetest/term#tomorrow");
            //step08
			Lib.GetAutoCompleteObjByName(driver, "tomorrow").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.3", "advance<tomorrw>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "advance<tomorrw>", "<tomorrow>").getCssValue("color"), "rgba(255, 165, 0, 1)");
            //step09 recommend tested by manual.
			//step10
            action.moveToElement(uxn.GetObjByContent("3.3", "advance<tomorrw>"), 100, 10);
            action.perform();
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjByName(driver, "manana"), "title", "http://www.cyberobject.com/uitest_cyberobject_com_cn/intellisensetest/term#tomorrow");
			//step11
			Lib.login_AppBuilder(dr2, UserName_2, Password_2);
    		Lib.wait_Sleep(3000);
    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
    		Lib.wait_Sleep(5000);
    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisensetest")).click();
    		Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Document/IntelliSense/Test_IntelliSense.ucx").click();
            UCXUnit uxn2 = new UCXUnit(dr2);
            Actions action2 = new Actions(dr2);
            action2.moveToElement(uxn2.GetObjByContent("2", "I am glad to see you <tomorrow>."), 180, 10);
            action2.perform();
            Lib.chkIsDisplayed(dr2, Lib.GetAutoCompleteObjByName(dr2, "manana"), true);
            Lib.chkIsDisplayed(dr2, Lib.GetAutoCompleteObjByName(dr2, "morn"), true);
            Lib.chkIsDisplayed(dr2, Lib.GetAutoCompleteObjByName(dr2, "tomorrow"), true);
            Lib.chkIsDisplayed(dr2, Lib.GetAutoCompleteObjByName(dr2, "tomorrow"), true);
            //step12
			Lib.GetAutoCompleteObjByName(dr2, "manana").click();
            Lib.chkIsDisplayed(dr2, uxn2.GetObjByContent("2", "I am glad to see you <tomorrow>."), true);
            dr2.quit();
			//step13
            action.moveToElement(uxn.GetObjByContent("3.3", "advance<tomorrw>"), 100, 10);
            action.perform();
			Lib.GetAutoCompleteObjByName(driver, "manana").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.3", "<manana>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "<manana>", "<manana>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            //step14
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
		} catch (Exception e) {
			dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_14_Term_Highlight_Realtime_Ucx(){
	    WebDriver dr2 = Lib.launchBrowser();
        ImgChecker imgChecker = new ImgChecker(dr2);
		try {
			Lib.checkPageIsReady(driver);
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.ucx").click();
//			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);

			//step01
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");

            //step02
            Lib.login_AppBuilder(dr2, UserName_2, Password_2);
    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
    		Lib.wait_Sleep(5000);
    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisensetest")).click();

    		Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Data/IntelliSense/termhighlight_domain.xlsx").click();
            Lib.CheckOutRex(dr2, "Data/IntelliSense/termhighlight_domain.xlsx");
            Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Data/IntelliSense/termhighlight_domain.xlsx"));
            dr2.findElement(AppElements.RIGHTCLICK_Excel_Menu_Train).click();
    		Lib.wait_Sleep(5000);
            if (!Lib.isExist(dr2, AppElements.Console_Window)) {
				dr2.findElement(AppElements.Btn_Console_op).click();
			}
            Lib.CheckConsoleMsg(dr2, "Training cyberobject/uitest_cyberobject_com_cn/intellisensetest/data/IntelliSense/termhighlight_domain.xlsx success !");
            
            //step03
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.ucx").click();
			Lib.SwitchToFrame(driver, "ucx_file_iframe");
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");
            //step04
            Lib.SwitchToFrame(driver, "moduleFrame");
            Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
    		Lib.SwitchToFrame(driver, "ucx_file_iframe");
            action.moveToElement(uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), 59, 10);
            action.click();
            action.perform();
            action.sendKeys("a");
            action.perform();
            for (int i = 0; i < 12; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
//                action.wait(300);
			}
            action.sendKeys("n");
            action.perform();

            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midwaya Islands> <Snpanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midwaya Islands> <Snpanish>","<Midwaya Islands>").getCssValue("color"), "rgba(255, 0, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midwaya Islands> <Snpanish>","<Snpanish>").getCssValue("color"), "rgba(255, 0, 0, 1)");
           //step05
            action.moveToElement(uxn.GetObjByContent("5", "<Midwaya Islands> <Snpanish>"), 67, 10);
            action.click();
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();
            for (int i = 0; i < 13; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();
    		Lib.wait_Sleep(1000);
            action.sendKeys(Keys.ESCAPE);
            action.perform();
    		Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");

            //step06
			Lib.DirFile(dr2, "Document/IntelliSense/Test_term_highlight.ucx").click();
            Actions action2 = new Actions(dr2);
            UCXUnit uxn2 = new UCXUnit(dr2);
            Lib.chkIsDisplayed(dr2, uxn2.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn2.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn2.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");

            //step07
            Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Data/IntelliSense/termhighlight_domain.xlsx").click();
            Lib.SwitchToFrame(dr2, "externalAppIframe");
            action2.moveToElement(dr2.findElement(AppElements.xlsx_file_iframe), 20, 50);
            action2.click();
            action2.sendKeys(Keys.DELETE);
            action2.perform();
            action2.moveToElement(dr2.findElement(AppElements.xlsx_file_iframe), 20, 70);
            action2.click();
            action2.sendKeys(Keys.DELETE);
            action2.perform();

            //step08 words color review
            Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Document/IntelliSense/Test_term_highlight.ucx").click();
			Lib.SwitchToFrame(dr2, "ucx_file_iframe");
            Lib.chkIsDisplayed(dr2, uxn2.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn2.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn2.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");

            //step09
            Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.ucx").click();
			Lib.SwitchToFrame(driver, "ucx_file_iframe");
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)");      
           
            //step10
            Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
			Lib.SwitchToFrame(driver, "ucx_file_iframe");
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("5", "<Midway Islands> <Spanish>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Midway Islands>").getCssValue("color"), "rgba(0, 128, 0, 1)");
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("5", "<Midway Islands> <Spanish>","<Spanish>").getCssValue("color"), "rgba(255, 165, 0, 1)"); 
            //step11
            Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Data/IntelliSense/termhighlight_domain.xlsx").click();
            Lib.RestoreRex(dr2, "Data/IntelliSense/termhighlight_domain.xlsx");
//            Lib.highlight(dr2, AppElements.externalApp_iframe);
            imgChecker.CheckImg(AppElements.externalApp_iframe, "IntelliSense_14_Term_Highlight_Realtime_Ucx_Step11");
            
			dr2.quit();
		} catch (Exception e) {
            Lib.RestoreRex(dr2, "Data/IntelliSense/termhighlight_domain.xlsx");
			dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_15_Term_Highlight_Single_Multi_use_Ucx(){
		try {
    		Lib.wait_Sleep(2000);

			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_Single_Multi-use.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Single_Multi-use.ucx");

			ImgChecker imgChecker= new ImgChecker(driver);
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			imgChecker.CheckImg(AppElements.ucx_file_iframe, "IntelliSense_15_Term_Highlight_Single_Multi_use_Ucx_Step01");
			//step02 can not double click.
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			action.moveToElement(uxn.GetObjByContent("2.2.4.2", "<"), 15, 10);
			action.click();
			action.perform();
    		Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "current time>");

			action.sendKeys(Keys.ESCAPE);
			action.perform();
    		Lib.wait_Sleep(1000);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2.4.2", "<current time>","<current time>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step03
			action.moveToElement(uxn.GetObjByContent("2.2.4.2.2", "Time"), 40, 10);
			action.click();
			Lib.SendKeysOnebyOne(action, "<today>");
			action.perform();
    		Lib.wait_Sleep(1000);
			action.sendKeys(Keys.ESCAPE);
			action.perform();
    		Lib.wait_Sleep(1000);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2.4.2.2", "Time<today>","<today>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step04
			action.moveToElement(uxn.GetObjByContent("2.2.3", "Total:"), 40, 10);
			action.click();
			Lib.SendKeysOnebyOne(action, "<10$>");
			action.perform();
    		Lib.wait_Sleep(1000);
			action.sendKeys(Keys.ESCAPE);
			action.perform();
    		Lib.wait_Sleep(1000);

            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2.3", "Total:<10$>","<10$>").getCssValue("color"), "rgba(255, 0, 0, 1)");      

			//step05
			action.moveToElement(uxn.GetObjByContent("3", "what is date of <today>?"), 1, 10);
			action.click();
			Lib.SendKeysOnebyOne(action, "<jump test.ucx>");
			action.perform();
    		Lib.wait_Sleep(1000);	
			action.sendKeys(Keys.ESCAPE);
			action.perform();
    		Lib.wait_Sleep(1000);	
//			The <jump test.ucx>  with blue color,failed.
//            Lib.highlight(driver, uxn.GetObjByContent("3", "<jump test.ucx>what is date of <today>?"));
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3", "<jump test.ucx>what is date of <today>?","<jump test.ucx>").getCssValue("color"), "rgba(0, 0, 0, 1)");      

            //step06
			action.moveToElement(uxn.GetObjByContent("3.3", "advance"), 80, 10);
			action.click();
			Lib.SendKeysOnebyOne(action, "<Gender>");
			action.perform();
    		Lib.wait_Sleep(1000);	
			
			action.sendKeys(Keys.ESCAPE);
			action.perform();
    		Lib.wait_Sleep(1000);	
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3", "advance<Gender>","<Gender>").getCssValue("color"), "rgba(255, 165, 0, 1)");      

            //step07
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			Lib.DirFile(driver, "Document/IntelliSense/Test_Single_Multi-use.ucx").click();
			imgChecker.CheckImg(AppElements.ucx_file_iframe, "IntelliSense_15_Term_Highlight_Single_Multi_use_Ucx_Step07");
			
			//step08
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Single_Multi-use.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Single_Multi-use.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	@Deprecated
//	@Test   case need to review
	public void IntelliSense_16_Term_Highlight_EditEffects_Ucx(){
		try {
			Lib.checkPageIsReady(driver);
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_highlight.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			action.moveToElement(uxn.GetObjByContent("2.1", "<Alabama>"), 76, 10);
			action.click();
			for (int i = 0; i < 9; i++) {
				action.sendKeys(Keys.BACK_SPACE);
			}
			action.sendKeys("Jack");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
			Lib.assertNull(uxn.GetColorKeyWordInSpecificLine("2.1", "Jack","Jack"),"Not black");
			
			//step02
			action.moveToElement(uxn.GetObjByContent("2.1.3.2.1", "<North Carolina><product>"), 48, 10);
			action.click();
			action.sendKeys("<");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.3.2.1", "<North< Carolina><product>","< Carolina><product>").getCssValue("color"), "rgba(255, 0, 0, 1)");      

            //step03
			action.moveToElement(uxn.GetObjByContent("2.1.3.1.2", "<No.1 School>"), 38, 10);
			action.click();
			action.sendKeys("<gender>");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.3.1.2", "<No.1<gender> School>","<gender>").getCssValue("color"), "rgba(255, 165, 0, 1)");      

			//step04
			action.moveToElement(uxn.GetObjByContent("4", "<term:SSN>"), 82, 10);
            action.clickAndHold();
            action.moveToElement(uxn.GetObjByContent("4", "<term:SSN>"), 1, 10);
            action.perform();
            action.sendKeys(Keys.chord(Keys.CONTROL,"c"));
            action.perform();

			action.moveToElement(uxn.GetObjByContent("2.1.3.1", "<Islands>"), 68, 10);
            action.clickAndHold();
			action.moveToElement(uxn.GetObjByContent("2.1.3.1", "<Islands>"), 1, 10);
            action.perform();
            action.sendKeys(Keys.chord(Keys.CONTROL,"v"));
            action.perform();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.3.1", "<term:SSN>","<term:SSN>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
           
            //step05 need to review and update.
//			action.moveToElement(uxn.GetObjByContent("4", "<term:SSN>"), 82, 10);
//            action.clickAndHold();
//            action.moveToElement(uxn.GetObjByContent("4", "<term:SSN>"), 1, 10);
//            action.perform();
//            action.sendKeys(Keys.chord(Keys.CONTROL,"c"));
//            action.perform();
            
			
			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_highlight.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_17_Term_Replace_Ucx(){
		try {
			Lib.wait_Sleep(2000);
			Lib.checkPageIsReady(driver);
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Replace.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_Replace.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			
			action.moveToElement(uxn.GetObjByContent("2.1.2.2.1", "<Alabama> is one state of USA."), 10, 12);
			action.click();
//			action.sendKeys("ala");
			Lib.SendKeysOnebyOne(action, "ala");
			action.perform();
			Lib.wait_Sleep(2000);
			Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.2.2.1", "<Alaska> is one state of USA.","<Alaska>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
            Thread.sleep(2000);
            //step02
			action.moveToElement(uxn.GetObjByContent("2.1.1", "<Alabama> belongs US"), 17, 12);
			action.click();
            Thread.sleep(1000);
			Lib.SendKeysOnebyOne(action, "la");
			action.perform();
            Thread.sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.1", "<Alaska> belongs US","<Alaska>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step03 failed
//		    Lib.highlight(driver,uxn.GetObjByContent("3.3.1", "what is your <first> name?"));
			action.moveToElement(uxn.GetObjByContent("3.3.1", "what is your <first> name?"), 122, 12);
			action.click();
			action.sendKeys("S");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "FirstStation").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3.1", "what is your <FirstStation> name?","<FirstStation>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step04
//            Lib.highlight(driver, uxn.GetObjByContent("3", "<US> is a developed <country>"));  
			action.moveToElement(uxn.GetObjByContent("3", "<US> is a developed <country>"), 20, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "SA");
			action.perform();
			Lib.GetAutoCompleteObjByName(driver, "USA").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3", "<USA> is a developed <country>","<USA>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step05 failed.
			action.moveToElement(uxn.GetObjByContent("3.2.1", "My <last name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]"), 31, 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "first");
			action.perform();
			Lib.wait_Sleep(2000);
			Lib.GetAutoCompleteObjByName(driver, "first name").click();
			Lib.wait_Sleep(1000);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.2.1", "My <first name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]","<first name>").getCssValue("color"), "rgba(255, 165, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step06
			action.moveToElement(uxn.GetObjByContent("2.1", "My name is Tom."), 20, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<fir");
			action.perform();
			Lib.wait_Sleep(2000);
			Lib.GetAutoCompleteObjByName(driver, "first").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1", "My<first> name is Tom.","<first>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step07
			action.moveToElement(uxn.GetObjByContent("2.1.2.1", "is my birthday."), 1, 12);
			action.click();
			action.perform();
//			Lib.wait_Sleep(2000);
			Lib.SendKeysOnebyOne(action, "<tod");
			action.perform();
			Lib.wait_Sleep(2000);
			Lib.GetAutoCompleteObjByName(driver, "today").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.2.1", "<today>is my birthday.","<today>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step08
			action.moveToElement(uxn.GetObjByContent("2.2", "Tomorrow is my"), 110, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<birth");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "birthday").click();
			Lib.wait_Sleep(1000);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.2", "Tomorrow is my<birthday>","<birthday>").getCssValue("color"), "rgba(255, 165, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step09
			action.moveToElement(uxn.GetObjByContent("2.1.2.1.1", "<Ohio> belongs to <US>."), 48, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<Ala");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "Alabama").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.2.1.1", "<Ohio><Alabama> belongs to <US>.","<Alabama>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step10
			action.moveToElement(uxn.GetObjByContent("3.4.1", "My is Tom, Now we start to watch as shown in [All Resource/Hello.gif]"), 22, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<last");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "last name").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.4.1", "My<last name> is Tom, Now we start to watch as shown in [All Resource/Hello.gif]","<last name>").getCssValue("color"), "rgba(255, 165, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step11
			action.moveToElement(uxn.GetObjByContent("2.1.2.2", "if a > b"), 23, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<ala");
			action.perform();
			Lib.wait_Sleep(2000);
			Lib.GetAutoCompleteObjByName(driver, "Alaska").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2.1.2.2", "if <Alaska>a > b","<Alaska>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step12
			action.moveToElement(uxn.GetObjByContent("3.1.1", "<The Aloha State> belongs to <US>"), 229, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "<USA");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "USA").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1.1", "<The Aloha State> belongs to <US<USA>.","<USA>").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			Lib.wait_Sleep(2000);

            //step13
			action.moveToElement(uxn.GetObjByContent("3.4.2", "<Hello [All Resource/Hello.gif]>"), 7, 12);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "Ha");
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.GetAutoCompleteObjByName(driver, "Hawaii").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.4.2", "<Hawaii>Hello [All Resource/Hello.gif]> ","<Hawaii>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

			//step14
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Replace.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Replace.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_18_Term_Nest_Ucx(){
		try {
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Nest.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
			ImgChecker imgChecker= new ImgChecker(driver);
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			imgChecker.CheckImg(AppElements.ucx_file_iframe, "IntelliSense_18_Term_Nest_Ucx_Step01");
            //step02
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			action.moveToElement(uxn.GetObjByContent("2", "set <user id> = (<users id> where [<UserID>])"), 114, 10);
			action.click();
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			
			//step03
//			action.sendKeys("use");
			Lib.SendKeysOnebyOne(action, "use i");
			action.perform();
			try {
			      imgChecker.CheckImg(AppElements.AutoCompleteMenu, "IntelliSense_18_Term_Nest_Ucx_Step03");
			} catch (Exception e) {
			}
		    //step04 failed no "user id"			
			Lib.GetAutoCompleteObjByName(driver, "user id").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2", "set <user id> = (<user id> where [<UserID>])","<UserID>").getCssValue("color"), "rgba(255, 165, 0, 1)");      
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("2", "set <user id> = (<user id> where [<UserID>])","<user id>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

			//step05 IP-1960 no display automenu
			action.moveToElement(uxn.GetObjByContent("3.1.1", "<today>, $(<today> where [<tomorrow>, <current  date>]),<now>"), 217, 10);
			action.click();
			action.perform();
			
			//step06
			Lib.GetAutoCompleteObjByName(driver, "manana").click();
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1.1", "<today>, $(<today> where [<manana>, <current date>]),<now>","<manana>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step07
            action.sendKeys("<current time");
            action.sendKeys(Keys.ENTER);
            action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.1.1", "<today>, $(<today> where [<manana><current time>, <current date>]),<now>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1.1", "<today>, $(<today> where [<manana><current time>, <current date>]),<now>","<current time>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step08
            action.sendKeys("<current time");
            action.sendKeys(Keys.ENTER);
            action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.1.1", "<today>, $(<today> where [<manana><current time><tomorrow>, <current date>]),<now>"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.1.1", "<today>, $(<today> where [<manana><current time><tomorrow>, <current date>]),<now>","<tomorrow>").getCssValue("color"), "rgba(255, 165, 0, 1)");      

            //step09
			action.moveToElement(uxn.GetObjByContent("3.2.1", "Study name plus Length = {<MyName> + $<length>/3}"), 279, 10);
			action.click();
			action.sendKeys(Keys.DELETE);
			action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.2.1", "Study name plus Length = {<MyName> + <length>/3}"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.2.1", "Study name plus Length = {<MyName> + <length>/3}","<length>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step10
			action.moveToElement(uxn.GetObjByContent("3", "(<drink_ID> < 50 or <cardnumber>  >  31)"), 138, 10);
			action.click();
            action.sendKeys(Keys.SPACE);
            action.perform();
			Lib.GetAutoCompleteObjByName(driver, "card number").click();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3", "(<drink_ID> < 50 or <card number> > 31)"), true);
            Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3", "(<drink_ID> < 50 or <card number> > 31)","<card number>").getCssValue("color"), "rgba(0, 128, 0, 1)");      

            //step11
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Nest.ucx").click();
			imgChecker.CheckImg(AppElements.ucx_file_iframe, "IntelliSense_18_Term_Nest_Ucx_step11");
			
			//step12
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_19_Term_Filter_Spreadsheet(){
		try {
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_term_Nest.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
			ImgChecker imgChecker= new ImgChecker(driver);
			Lib.SwitchToFrame(driver, "moduleFrame"); 
			imgChecker.CheckImg(AppElements.ucx_file_iframe, "IntelliSense_19_Term_Filter_Spreadsheet_step01");
            //step02
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			action.moveToElement(uxn.GetObjByContent("2", "set <user id> = (<users id> where [<UserID>])"), 114, 10);
			action.click();
			action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			
			//step03
			action.sendKeys("use");
			action.perform();
			imgChecker.CheckImg(AppElements.AutoCompleteMenu, "IntelliSense_19_Term_Filter_Spreadsheet_Step03");

			
			
			
			
			
	
			
			//step12
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_term_Nest.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	@Test
	public void IntelliSense_32_Term_TopLevelTerm_TableTerm(){
		try {
			Lib.wait_Sleep(2000);
			Lib.DirFile(driver, "Document/IntelliSense/Test_IntelliSense.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

            action.doubleClick(fut.GetObjByContent("Good"));
            action.sendKeys(Keys.ARROW_RIGHT);
//         action.sendKeys("<term:");
            Lib.SendKeysOnebyOne(action, "<term:");
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
            //step02
            action.sendKeys("d");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term:DATE"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term:DATETIME"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term:DC"), true);
           //step03
            action.sendKeys(Keys.BACK_SPACE);
            action.sendKeys(Keys.BACK_SPACE);
//            Lib.SendKeysOnebyOne(action, ":d");
            action.perform();
            try {
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term_prefix"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term_url"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "term").findElement(By.xpath("./following-sibling::span[normalize-space(.) and normalize-space(text())=', root of any term']")) , true);
			} catch (Exception e) {
			}
			//step04
			for (int i = 0; i < 4; i++) {
	            action.sendKeys(Keys.BACK_SPACE);
			}
			action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
//step05
//            action.sendKeys("records's ");
            Lib.SendKeysOnebyOne(action, "records' ");
            action.perform();
            Lib.wait_Sleep(1000);
            //actual :records' Avg Score of records
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "records' Avg Score of records"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "records' Chemistry score of records"), true);	
//step06
			Lib.GetAutoCompleteObjByName(driver, "records' Avg Score of records").click();
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("Good<records' Avg Score of records>"), true);
			Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Good<records' Avg Score of records>", "<records' Avg Score of records>"), true);
//step07
			action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.wait_Sleep(1000);
			action.doubleClick(fut.GetObjByContent("Good<records' Avg Score of records>"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.perform();
			action.keyDown(Keys.SHIFT);
			for (int i = 0; i < 30; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			
			action.keyUp(Keys.SHIFT);
            action.sendKeys(Keys.DELETE);
			action.sendKeys(Keys.ESCAPE);
            action.perform();

			Lib.chkIsDisplayed(driver, fut.GetObjByContent("Good<"), true);
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
//step8
            Lib.SendKeysOnebyOne(action, "user id of records");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records"), true);
//step9
            action.sendKeys(Keys.SPACE);
            action.sendKeys("o");
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
//step10
            action.sendKeys("f");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records of records"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records of records").findElement(By.xpath("./following-sibling::span[normalize-space(.) and normalize-space(text())=',records table']")) , true);
//step11
            action.sendKeys(Keys.SPACE);
            action.sendKeys("r");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "user ID of records of records"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjRedWord(driver, "user ID of records of r"), true);
//step12	
            action.click();
            action.sendKeys(Keys.ENTER);
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("Good<user ID of records of records>"), true);
			Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Good<user ID of records of records>", "<user ID of records of records>"), true);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
		} catch (Exception e) {
 			FlowUnit fut = new FlowUnit(driver);
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_IntelliSense.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_33_Resource_Filter_Rex(){
		String webUrl = PropertiesDataProvider.getTestData("config/config.properties", "urlappbuilder");
		try {
			driver.get("http://www.cyberobject.com.cn:8085/iplatform-developer/?appid=iplatform");
			driver.manage().window().maximize();
			Lib.checkPageIsReady(driver);
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
            action.doubleClick(fut.GetObjByContent("Good"));
            action.sendKeys(Keys.ARROW_LEFT);
            action.sendKeys("[fi");
            action.perform();
			
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:PlayFire.mp4"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
		    for (int i = 1; i < 3; i++) {
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "Fi");	
			}
		    //step02
		    action.sendKeys("l");
            action.perform();
			Lib.wait_Sleep(1000);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
		    for (int i = 1; i < 2; i++) {
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "Fil");	
			}
		    //step03
		    action.sendKeys(Keys.BACK_SPACE);
            action.perform();
			Lib.wait_Sleep(2000);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:PlayFire.mp4"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
		    for (int i = 1; i < 3; i++) {
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "Fi");	
			}
		    //step04 
//		    action.sendKeys("le/user");
		    Lib.SendKeysOnebyOne(action, "le/user");
		    action.sendKeys(Keys.SPACE);
            action.perform();
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), false);
		    for (int i = 1; i < 2; i++) {
		    	//actual "File/User "
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "File/User ");
			}
		    //step05 failed.
		    action.sendKeys(Keys.ARROW_LEFT);
            action.perform();
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"@iplatform:File/User ID.txt"), "innerText", "File/User");	
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"@iplatform:File/users.ppt"), "innerText", "File/user");	

		    //step06
		    action.sendKeys("u");
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
			Lib.chkIsDisplayed(driver, fut.GetObjByContent("[file/userugood"), true);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			
			driver.get(webUrl);
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			//ClearMainGui
//			Lib.clear_page(driver, UserName, Password);
			driver.get(webUrl);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_34_Resource_Operations_Rex(){
		try {
			Lib.wait_Sleep(2000);
			Lib.checkPageIsReady(driver);
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			//step01
            action.doubleClick(fut.GetObjByContent("Good"));
            action.sendKeys(Keys.ARROW_LEFT);
            action.sendKeys("[");
            action.perform();
			 //@org:cat.png  @org:start_abe.jpg no display
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Audio/pat.m4a"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "PlayFire.mp4"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@org:cat.png"), false);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@org:start_abe.jpg"), false);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/English_ABC.jpg"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/internet.png"), true);

			//step02-3
			Lib.GetAutoCompleteObjByName(driver, "PlayFire.mp4").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[PlayFire.mp4]Good"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[PlayFire.mp4]Good", "[PlayFire.mp4]"), true);
            //step04
            action.doubleClick(fut.GetObjByContent("[PlayFire.mp4]Good"));
            action.sendKeys(Keys.ARROW_RIGHT);
            for (int i = 0; i < 19; i++) {
                action.sendKeys(Keys.BACK_SPACE);
			}
            action.perform();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);

            //step05
            action.doubleClick(fut.GetObjByContent("Great"));
            action.sendKeys(Keys.ARROW_RIGHT);
            action.sendKeys("[all");
            action.perform();
            
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Audio/Apple.mov"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Hello.gif"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
//			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Picture/Adult.jpg"), true);
		    for (int i = 1; i < 4; i++) {
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "All");	
			}
            //step06
            Lib.GetAutoCompleteObjByName(driver, "All Resource/Hello.gif").click();
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("Great[All Resource/Hello.gif]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Great[All Resource/Hello.gif]", "[All Resource/Hello.gif]"), true);
            //step07
            action.doubleClick(fut.GetObjByContent("Great[All Resource/Hello.gif]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 3; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("[adu");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Picture/Adult.jpg"), true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"@iplatform:All Resource/Picture/Adult.jpg"), "innerText", "Adu");	
            //step08
            action.sendKeys(Keys.ENTER);
            action.perform();
			Lib.wait_Sleep(1000);                                
            action.click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
			Lib.wait_Sleep(1000);                                
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("Gre[@iplatform:All Resource/Picture/Adult.jpg]at[@iplatform:All Resource/Hello.gif]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Gre[@iplatform:All Resource/Picture/Adult.jpg]at[@iplatform:All Resource/Hello.gif]", "[@iplatform:All Resource/Picture/Adult.jpg]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Gre[@iplatform:All Resource/Picture/Adult.jpg]at[@iplatform:All Resource/Hello.gif]", "[@iplatform:All Resource/Hello.gif]"), true);

            //step09
            action.doubleClick(fut.GetObjByContent("Gre[Picture/Adult.jpg]at[All Resource/Hello.gif]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 5; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step10
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            action.doubleClick(fut.GetObjByContent("Gre[Picture/Adult.jpg]at[All Resource/Hello.gif]"));
            action.sendKeys(Keys.DELETE);
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_35_Resource_Triggers_Rex(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			
			//step01
            action.doubleClick(fut.GetObjByContent("[[A"));
            action.sendKeys(Keys.ARROW_RIGHT);
            action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step02
            action.sendKeys("L");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Audio/pat.m4a"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Hello.gif"), true);
			for (int i = 1; i < 5; i++) {
				Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,i), "innerText", "Al");
			}
            //step03
            action.doubleClick(fut.GetObjByContent("["));
            action.sendKeys(Keys.ARROW_RIGHT);
            action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
			//step04
            action.sendKeys("hel");
            action.perform();
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Hello.gif"), true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,1), "innerText", "Hel");	
            //step05
            for (int i = 0; i < 4; i++) {
                action.sendKeys(Keys.BACK_SPACE);
			}
            action.perform();
			Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);

			//step06
			
			//step07
			
			//step08
            action.doubleClick(fut.GetObjByContent("We will travel to Beijing."));
            action.sendKeys(Keys.ARROW_RIGHT);
            for (int i = 0; i < 1; i++) {
                action.sendKeys(Keys.ARROW_LEFT);
			}
            action.perform();
            action.sendKeys("[Pic");
            action.perform();
            
			Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Picture/Adult.jpg"), true);
			Lib.ChkProperty(driver, Lib.GetAutoCompleteObjRedWord(driver,"Picture/Adult.jpg"), "innerText", "Pic");	

            //step09
			Lib.GetAutoCompleteObjByName(driver, "Picture/Adult.jpg").click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("We will travel to Beijing[Picture/Adult.jpg]."), true);

            //step10
			action.keyDown(Keys.CONTROL);
			action.sendKeys("s");
			action.keyUp(Keys.CONTROL);
			action.perform();
			
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[[AL"), true);
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("We will travel to Beijing[Picture/Adult.jpg]."), true);

            //step11
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_36_Resource_Highlight_Realtime_Rex(){
        WebDriver dr2 = new ChromeDriver();
        dr2.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		Actions action2=new Actions(dr2);
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			FlowUnit fut = new FlowUnit(driver);
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Midway Islands.jpg]"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
            //step02
            Lib.login_AppBuilder(dr2, UserName_2, Password_2);
    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
    		Lib.wait_Sleep(3000);
    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisensetest")).click();
    		
    		Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Resource").click();
    		Lib.SwitchToFrame(dr2, "externalAppIframe");
            String currentWindow = dr2.getWindowHandle();
    		dr2.findElement(AppElements.Button_Upload).click();
    		Lib.wait_Sleep(3000);
            Lib.changeWindow(dr2);
            dr2.findElement(AppElements.Button_Browser_Files).click();
    		Lib.wait_Sleep(3000);
			//windows operate 
	        AutoWin.winActivate("打开");
		    Lib.wait_Sleep(2000);
		    AutoWin.controlFocus("打开", "", "Edit1");
		    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\Midway Islands.jpg");
		    Lib.wait_Sleep(1000);
	        AutoWin.controlClick("打开", "", "Button1");
	        Lib.wait_Sleep(3000);
	        dr2.close();
	        dr2.switchTo().window(currentWindow);
			Lib.SwitchToFrame(dr2, "moduleFrame");
	        Lib.DirFile(dr2, "Resource/Midway Islands.jpg").isDisplayed();
	        //step03
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.SwitchToFrame(driver, "visio_file_iframe");	
//			FlowUnit fut2 = new FlowUnit(dr2);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
			//step04
            Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			Lib.SwitchToFrame(driver, "visio_file_iframe");
			action.doubleClick(fut.GetObjByContent("[Midway Islands.jpg]"));
			action.sendKeys(Keys.ARROW_LEFT);
			for (int i = 0; i < 7; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
			}
			action.sendKeys("a");
			action.sendKeys(Keys.ESCAPE);
			action.perform();
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midwaya Islands.jpg]", "[Midwaya Islands.jpg]"), true);

            //step05
			action.doubleClick(fut.GetObjByContent("[Midwaya Islands.jpg]"));
			action.sendKeys(Keys.ARROW_LEFT);
			for (int i = 0; i < 8; i++) {
				action.sendKeys(Keys.ARROW_RIGHT);
			}
			action.sendKeys(Keys.BACK_SPACE);
			action.sendKeys(Keys.ESCAPE);
			action.perform();
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);

            //step06
			Lib.SwitchToFrame(dr2, "moduleFrame");
			Lib.DirFile(dr2, "Document/IntelliSense/Test_Resource.rex").click();
			FlowUnit fut2= new FlowUnit(dr2);
            Lib.chkIsDisplayed(dr2, fut2.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
            //step07
			Lib.SwitchToFrame(dr2, "moduleFrame");
			if (Lib.isExist(Lib.DirFile(dr2, "Resource/Midway Islands.jpg"))) {
//		        Lib.SwitchToFrame(dr2, "moduleFrame");
		        Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Resource/Midway Islands.jpg"));
		        dr2.findElement(AppElements.RIGHTCLICK_JPG_Menu_Delete).click();
		        dr2.findElement(AppElements.Delete_OK).click();
			}
			
			//step08
			Lib.DirFile(dr2, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.SwitchToFrame(dr2, "visio_file_iframe");
            Lib.chkIsDisplayed(dr2, fut2.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);

            //step09
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			Lib.SwitchToFrame(driver, "visio_file_iframe");	
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
            //step10
			Lib.RestoreRex(dr2, "Document/IntelliSense/Test_Resource.rex");
    		dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
		} catch (Exception e) {
			Lib.RestoreRex(dr2, "Document/IntelliSense/Test_Resource.rex");
			if (Lib.isExist(Lib.DirFile(dr2, "Resource/Midway Islands.jpg"))) {
		        Lib.SwitchToFrame(dr2, "moduleFrame");
		        Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Resource/Midway Islands.jpg"));
		        dr2.findElement(AppElements.RIGHTCLICK_JPG_Menu_Delete).click();
		        dr2.findElement(AppElements.Delete_OK).click();
			}
			dr2.quit();
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Test
	public void IntelliSense_37_Resource_Highlight_EditEffects_Rex(){
		try {
			Lib.checkPageIsReady(driver);
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_resource_highlight.rex").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_resource_highlight.rex");
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			//step02
            Lib.SetWordColor(driver, "[Picture/Adult.jpg] [good]", 0, 19, "rgb(255, 0, 0)");
    		Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Picture/Adult.jpg] [good]").findElement(By.xpath("./span//font[@color='#ff0000' and text()='[Picture/Adult.jpg]']")), true);

            Lib.SetWordColor(driver, "[Picture/Adult.jpg] [good]", 20, 6, "rgb(0, 255, 0)");
    		Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Picture/Adult.jpg] [good]").findElement(By.xpath("./span//font[@color='#00ff00' and text()='[good]']")), true);

    		//step03
            action.doubleClick(fut.GetObjByContent("[PlayFire.mp4]"));
            action.sendKeys(Keys.BACK_SPACE);
            action.sendKeys("Jack");
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
    		Lib.chkIsDisplayed(driver, fut.GetObjByContent("Jack"), true);
    		//step04
            action.doubleClick(fut.GetObjByContent("[Picture/Adult.jpg]"));
            action.perform();
            action.keyDown(Keys.CONTROL);
            action.sendKeys("c");
            action.keyUp(Keys.CONTROL);
            action.perform();
            action.sendKeys(Keys.ARROW_RIGHT);
            action.keyDown(Keys.CONTROL);
            action.sendKeys("v");
            action.keyUp(Keys.CONTROL);
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.assertEquals(fut.GetGreenWordNodesInSpecificUnit("[Picture/Adult.jpg][Picture/Adult.jpg]", "[Picture/Adult.jpg]"), 2);

            //step05
            action.doubleClick(fut.GetObjByContent("[All Resource/Hello.gif] [bad]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 4; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("[");
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[All[ Resource/Hello.gif] [bad]"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[All[ Resource/Hello.gif] [bad]", "[ Resource/Hello.gif]"), true);
            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[All[ Resource/Hello.gif] [bad]", "[bad]"), true);

            //step06
            action.doubleClick(fut.GetObjByContent("[Test Page]"));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int i = 0; i < 5; i++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("[PlayFire.mp4]");
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();

            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Test[PlayFire.mp4] Page]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Test[PlayFire.mp4] Page]", "[PlayFire.mp4]"), true);

            //step07 failed
            action.doubleClick(fut.GetObjByContent("[Picture Test]"));
            action.sendKeys(Keys.ARROW_LEFT);
            action.sendKeys(Keys.ARROW_RIGHT);
            action.perform();
            action.sendKeys("Picture");
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.GetAutoCompleteObjByName(driver, "Picture/Adult.jpg").click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Picture/Adult.jpg]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Picture/Adult.jpg]", "[Picture/Adult.jpg]"), true);

            //step08
            action.doubleClick(fut.GetObjByContent("Now we start to watch as shown in,My <name> is Tom,\""));
            action.sendKeys(Keys.ARROW_LEFT);
            for (int j = 0; j < 33; j++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.sendKeys("[Play");
            action.perform();
	        Lib.wait_Sleep(1000);
            Lib.GetAutoCompleteObjByName(driver, "PlayFire.mp4").click();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
                                                                        
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("Now we start to watch as shown in[PlayFire.mp4],My <name> is Tom,\""), true);
            //case need to review.
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("Now we start to watch as shown in[PlayFire.mp4],My <name> is Tom,\"", "[PlayFire.mp4]"), true);
            Lib.chkIsDisplayed(driver, fut.GetOrangeWordNodeInSpecificUnit("Now we start to watch as shown in[PlayFire.mp4],My <name> is Tom,\"", "<name>"), true);

            //step09                              
            action.doubleClick(fut.GetObjByContent("I like [PlayFire.mp4]"));
            action.perform();
            action.sendKeys(Keys.ARROW_LEFT);
            for (int j = 0; j < 7; j++) {
                action.sendKeys(Keys.ARROW_RIGHT);
			}
            action.perform();
            action.sendKeys("$");
            action.perform();
            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.chkIsDisplayed(driver, fut.GetObjByContent("I like $[PlayFire.mp4]"), true);
            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("I like $[PlayFire.mp4]", "[PlayFire.mp4]"), true);


			Lib.RestoreRex(driver, "Document/IntelliSense/Test_resource_highlight.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_resource_highlight.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
//	@Deprecated
	@Test
	public void IntelliSense_38_Resource_Filter_Ucx(){
		try {
	        Lib.wait_Sleep(2000);
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action = new Actions(driver);
			action.moveToElement(uxn.GetObjByContent("2.1.2", "ask for <Gender>"), 51, 10);
			action.click();
			action.perform();
	        Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "[fi");
			action.perform();
	        Lib.wait_Sleep(1000);
            //menu disappear soon.failed.
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "PlayFire.mp4"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "Fi");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "Fi");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "PlayFire.mp4").getText(), "Fi");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/User ID.txt").getText(), "Fi");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/users.ppt").getText(), "Fi");
			} catch (Exception e) {
			}
            //step02
			action.sendKeys("l");
			action.perform();
	        Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
            try {
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "Fil");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "Fil");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/User ID.txt").getText(), "Fil");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/users.ppt").getText(), "Fil");
			} catch (Exception e) {
			}

            //step03
            action.sendKeys(Keys.BACK_SPACE);
            action.perform();
            Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "PlayFire.mp4"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
        
            try {
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "Fi");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "Fi");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "PlayFire.mp4").getText(), "Fi");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/User ID.txt").getText(), "Fi");
                Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/users.ppt").getText(), "Fi");
			} catch (Exception e) {
			}
            
			//step04
//            action.sendKeys("le/user");
            Lib.SendKeysOnebyOne(action, "le/user");
            action.sendKeys(Keys.SPACE);
            action.perform();
            Lib.wait_Sleep(1000);

            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "File/user");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "File/User");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/User ID.txt").getText(), "File/User");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/users.ppt").getText(), "File/user");
			} catch (Exception e) {
			}
            //step05
            action.sendKeys(Keys.ARROW_LEFT);
            action.perform();
            Lib.wait_Sleep(1000);

            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/User ID.txt"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:File/users.ppt"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "File/user");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "File/User");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/User ID.txt").getText(), "File/User");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:File/users.ppt").getText(), "File/user");
			} catch (Exception e) {

			}
            //step06
            action.sendKeys("_");
//            action.sendKeys(Keys.ESCAPE);
            action.perform();
            Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("2.1.2", "ask for <Gender>[file/use_") , true);
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}

//	@Deprecated
	@Test
	public void IntelliSense_39_Resource_Operations_Ucx(){
		Lib.wait_Sleep(2000);
		String webUrl = PropertiesDataProvider.getTestData("config/config.properties", "urlappbuilder");
		try {
			driver.get("http://www.cyberobject.com.cn:8085/iplatform-developer/?appid=iplatform");
			driver.manage().window().maximize();
			Lib.wait_Sleep(2000);
			Lib.SwitchToFrame(driver, "moduleFrame");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			UCXUnit uxn = new UCXUnit(driver);
			Actions action=new Actions(driver);
			//step01
			Lib.wait_Sleep(1000);
			action.moveToElement(uxn.GetObjByContent("3.1", "initial"), 40, 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			action.sendKeys("[");
			action.perform();
			Lib.wait_Sleep(1000);
			action.moveToElement(Lib.findElement(driver, AppElements.AutoCompleteMenu), 392, 59);
			action.clickAndHold();
			action.moveToElement(Lib.findElement(driver, AppElements.AutoCompleteMenu), 392, 159);
//            action.moveToElement(Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/internet.png"));
			action.perform();
			Lib.wait_Sleep(1000);

            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/English_ABC.jpg"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/internet.png"), true);

            //step02
//            JavascriptExecutor Scrool = (JavascriptExecutor) driver;
//            Scrool.executeScript("scroll(0,250);");
//            Lib.wheel_element(driver, Lib.findElement(driver, AppElements.AutoCompleteMenu)  ,120 , 0 , 0);
			action.moveToElement(Lib.findElement(driver, AppElements.AutoCompleteMenu), 392, 59);
			action.clickAndHold();
			
			action.moveToElement(Lib.findElement(driver, AppElements.AutoCompleteMenu), 392, 159);
			action.perform();
			Lib.wait_Sleep(1000);

            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/English_ABC.jpg"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:images/internet.png"), true);

            //step03 fail  [@iplatform:PlayFire.mp4]
            Lib.GetAutoCompleteObjByName(driver, "@iplatform:PlayFire.mp4").click();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.1", "initial[@iplatform:PlayFire.mp4]") , true);
            
            //step04
            action.moveToElement(uxn.GetObjByContent("3.1", "initial[@iplatform:PlayFire.mp4]"), 214, 10);
            action.click();
            action.perform();
			Lib.wait_Sleep(1000);
            for (int i = 0; i < 32; i++) {
    			action.sendKeys(Keys.BACK_SPACE);
			}
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu, false);
            Lib.assertTrue(uxn.GetBlankLine("3.1"));
            
            //step05
			action.moveToElement(uxn.GetObjByContent("3.3", "advance"), 60, 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "[all");
			action.perform();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Audio/Apple.mov"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Hello.gif"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Picture/Adult.jpg"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:All Resource/Hello.gif").getText(), "All");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:All Resource/Picture/Adult.jpg").getText(), "All");
			} catch (Exception e) {
			}
            
            //step06
            Lib.GetAutoCompleteObjByName(driver, "[All Resource/Hello.gif]").click();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.3", "advance[@iplatform:All Resource/Hello.gif]") , true);
            try {
                Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "advance[@iplatform:All Resource/Hello.gif]","[@iplatform:All Resource/Hello.gif]").getCssValue("color"), "rgba(0, 128, 0, 1)");      
			} catch (Exception e) {
			}

            //step07
			action.moveToElement(uxn.GetObjByContent("3.3", "advance[@iplatform:All Resource/Hello.gif]"), 18, 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "[adu");
			action.perform();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "@iplatform:All Resource/Picture/Adult.jpg"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "@iplatform:All Resource/Picture/Adult.jpg").getText(), "Adu");
			} catch (Exception e) {
			}
            
            //step08
            action.sendKeys(Keys.ENTER);
            action.perform();
            Lib.chkIsDisplayed(driver, uxn.GetObjByContent("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]") , true);
            try {
                Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]","[@iplatform:All Resource/Picture/Adult.jpg]").getCssValue("color"), "rgba(0, 128, 0, 1)");      
                Lib.assertEquals(uxn.GetColorKeyWordInSpecificLine("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]","[@iplatform:All Resource/Hello.gif]").getCssValue("color"), "rgba(0, 128, 0, 1)");      
            } catch (Exception e) {
			}
            
            //step09
            action.moveToElement(uxn.GetObjByContent("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]"), 240, 10);
            action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);
            
            //step10
            action.doubleClick(uxn.GetObjByContent("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]"));
			action.sendKeys(Keys.ARROW_LEFT);
			action.perform();
			action.sendKeys(Keys.SHIFT).clickAndHold();
			action.moveToElement(uxn.GetObjByContent("3.3", "ad[@iplatform:All Resource/Picture/Adult.jpg]vance[@iplatform:All Resource/Hello.gif]"), 588 , 10);
			action.click();
			action.release();
			action.perform();
			action.sendKeys(Keys.DELETE);
			action.perform();
            Lib.assertTrue(uxn.GetBlankLine("3.3"));
            
             //step11  case need to reivew and update
//            action.sendKeys(Keys.LEFT_CONTROL,"s");
//            action.perform();
//            Lib.SwitchToFrame(driver, "moduleFrame");
//            action.click(Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.ucx"));
//            action.perform();
            

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			
			driver.get(webUrl);
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			//ClearMainGui
//			Lib.clear_page(driver, UserName, Password);
			driver.get(webUrl);
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_40_Resource_Triggers_Ucx(){
		try {
			Lib.wait_Sleep(2000);
			//step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			UCXUnit ucx = new UCXUnit(driver);
			Actions action=new Actions(driver);
			
			action.moveToElement(ucx.GetObjByContent("2.1", "[[A"));
			action.doubleClick();
			action.perform();
			Lib.wait_Sleep(1000);
			action.moveToElement(ucx.GetObjByContent("2.1", "[[A"), 22 , 10);
			action.click();
			action.perform();
            Lib.chkIsDisplayed(driver, AppElements.AutoCompleteMenu , false);
            
            //step02
            Lib.SendKeysOnebyOne(action, "L");
        	action.perform();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Audio/pat.m4a"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/UserID.xlsx"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Hello.gif"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/Audio/pat.m4a").getText(), "Al");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/user guide.pdf").getText(), "Al");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/File/UserID.xlsx").getText(), "Al");
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/Hello.gif").getText(), "Al");
            } catch (Exception e) {
			}
            
            //step03
			action.moveToElement(ucx.GetObjByContent("2.1.3.1", "["), 14 , 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(2000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Adult.jpg"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Audio/pat.m4a"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Picture/Adult.jpg"), true);

            //step04
            Lib.SendKeysOnebyOne(action, "hel");
			action.perform();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Hello.gif"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "All Resource/Hello.gif").getText(), "Hel");
            } catch (Exception e) {
			}
            
            //step05
            for (int i = 0; i < 3; i++) {
				   action.sendKeys(Keys.BACK_SPACE);
			}
			action.perform();
            Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "adult.jpg"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/Audio/pat.m4a"), true);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "All Resource/File/user guide.pdf"), true);
            
            //step06
            //step07
            //step08
            action.moveToElement(ucx.GetObjByContent("2.1.3.2.1", "We will travel to Beijing."), 159 , 10);
			action.click();
			action.perform();
			Lib.wait_Sleep(1000);
			Lib.SendKeysOnebyOne(action, "[Pic");
			action.perform();
			Lib.wait_Sleep(1000);
            Lib.chkIsDisplayed(driver, Lib.GetAutoCompleteObjByName(driver, "Pitcture/Adult.jpg"), true);
            try {
            Lib.assertEquals(Lib.GetAutoCompleteObjRedWord(driver, "Pitcture/Adult.jpg").getText(), "Pit");
            } catch (Exception e) {
			}
			//step09
			Lib.GetAutoCompleteObjByName(driver, "Pitcture/Adult.jpg").click();
			ucx.GetObjByContent("2.1.3.2.1", "We will travel to Beijing[Picture/Adult.jpg].");

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
//	@Deprecated
	@Test
	public void IntelliSense_41_Resource_Highlight_Realtime_Ucx(){
			Lib.wait_Sleep(2000);
			WebDriver dr2 = new ChromeDriver();
	        dr2.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
			Actions action=new Actions(driver);
			Actions action2=new Actions(dr2);
			try {
				//step01
				Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
				Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
				FlowUnit fut = new FlowUnit(driver);
	            Lib.chkIsDisplayed(driver, fut.GetObjByContent("[Midway Islands.jpg]"), true);
	            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
	            //step02
	            Lib.login_AppBuilder(dr2, UserName_2, Password_2);
	    		Lib.Switch_appGourp(dr2, "uitest_cyberobject_com_cn");
	    		Lib.wait_Sleep(3000);
	    		dr2.findElement(AppElements.SwitchAppMenu_CustomObj("intellisensetest")).click();
	    		
	    		Lib.SwitchToFrame(dr2, "moduleFrame");
				Lib.DirFile(dr2, "Resource").click();
	    		Lib.SwitchToFrame(dr2, "externalAppIframe");
	            String currentWindow = dr2.getWindowHandle();
	    		dr2.findElement(AppElements.Button_Upload).click();
	    		Lib.wait_Sleep(3000);
	            Lib.changeWindow(dr2);
	            dr2.findElement(AppElements.Button_Browser_Files).click();
	    		Lib.wait_Sleep(3000);
				//windows operate 
		        AutoWin.winActivate("打开");
			    Lib.wait_Sleep(2000);
			    AutoWin.controlFocus("打开", "", "Edit1");
			    AutoWin.ControlSetText("打开", "", "Edit1", UploadFilePath+"FTP_files\\Midway Islands.jpg");
			    Lib.wait_Sleep(1000);
		        AutoWin.controlClick("打开", "", "Button1");
		        Lib.wait_Sleep(3000);
		        dr2.close();
		        dr2.switchTo().window(currentWindow);
				Lib.SwitchToFrame(dr2, "moduleFrame");
		        Lib.DirFile(dr2, "Resource/Midway Islands.jpg").isDisplayed();
		        //step03
				Lib.SwitchToFrame(driver, "moduleFrame");
				Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
				Lib.SwitchToFrame(driver, "visio_file_iframe");	
//				FlowUnit fut2 = new FlowUnit(dr2);
	            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
				//step04
	            Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
				Lib.SwitchToFrame(driver, "visio_file_iframe");
				action.doubleClick(fut.GetObjByContent("[Midway Islands.jpg]"));
				action.sendKeys(Keys.ARROW_LEFT);
				for (int i = 0; i < 7; i++) {
					action.sendKeys(Keys.ARROW_RIGHT);
				}
				action.sendKeys("a");
				action.sendKeys(Keys.ESCAPE);
				action.perform();
	            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midwaya Islands.jpg]", "[Midwaya Islands.jpg]"), true);

	            //step05
				action.doubleClick(fut.GetObjByContent("[Midwaya Islands.jpg]"));
				action.sendKeys(Keys.ARROW_LEFT);
				for (int i = 0; i < 8; i++) {
					action.sendKeys(Keys.ARROW_RIGHT);
				}
				action.sendKeys(Keys.BACK_SPACE);
				action.sendKeys(Keys.ESCAPE);
				action.perform();
	            Lib.chkIsDisplayed(driver, fut.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);

	            //step06
				Lib.SwitchToFrame(dr2, "moduleFrame");
				Lib.DirFile(dr2, "Document/IntelliSense/Test_Resource.rex").click();
				FlowUnit fut2= new FlowUnit(dr2);
	            Lib.chkIsDisplayed(dr2, fut2.GetGreenWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
	            //step07
				Lib.SwitchToFrame(dr2, "moduleFrame");
				if (Lib.isExist(Lib.DirFile(dr2, "Resource/Midway Islands.jpg"))) {
//			        Lib.SwitchToFrame(dr2, "moduleFrame");
			        Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Resource/Midway Islands.jpg"));
			        dr2.findElement(AppElements.RIGHTCLICK_JPG_Menu_Delete).click();
			        dr2.findElement(AppElements.Delete_OK).click();
				}
				
				//step08
				Lib.DirFile(dr2, "Document/IntelliSense/Test_Resource.rex").click();
				Lib.SwitchToFrame(dr2, "visio_file_iframe");
	            Lib.chkIsDisplayed(dr2, fut2.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);

	            //step09
				Lib.SwitchToFrame(driver, "moduleFrame");
				Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
				Lib.SwitchToFrame(driver, "visio_file_iframe");	
	            Lib.chkIsDisplayed(driver, fut.GetRedWordNodeInSpecificUnit("[Midway Islands.jpg]", "[Midway Islands.jpg]"), true);
	            //step10
				Lib.RestoreRex(dr2, "Document/IntelliSense/Test_Resource.rex");
	    		dr2.quit();
				Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			} catch (Exception e) {
				Lib.RestoreRex(dr2, "Document/IntelliSense/Test_Resource.rex");
				if (Lib.isExist(Lib.DirFile(dr2, "Resource/Midway Islands.jpg"))) {
			        Lib.SwitchToFrame(dr2, "moduleFrame");
			        Lib.mouseRightClick(dr2, Lib.DirFile(dr2, "Resource/Midway Islands.jpg"));
			        dr2.findElement(AppElements.RIGHTCLICK_JPG_Menu_Delete).click();
			        dr2.findElement(AppElements.Delete_OK).click();
				}
				dr2.quit();
				Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
				//ClearMainGui
				Lib.clear_page(driver, UserName, Password);
				Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
			}
			MMDriver.softAssert.assertAll();
	}
	
//	@Deprecated
	@Test
	public void IntelliSense_42_Resource_Highlight_EditEffects_Ucx(){
		try {
		    Lib.wait_Sleep(2000);
		    //step01
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource_highlight.ucx").click();
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource_highlight.ucx");
			UCXUnit unt = new UCXUnit(driver);
			Actions action=new Actions(driver);
			action.moveToElement(unt.GetObjByContent("2.1", "[PlayFire.mp4]") , 100 , 10);
			action.click();
			action.perform();
		    Lib.wait_Sleep(500);

            for (int i = 0; i < 14; i++) {
    			action.sendKeys(Keys.BACK_SPACE);
    			action.perform();
			}
			Lib.SendKeysOnebyOne(action, "Jack");
			action.perform();
            Lib.chkIsDisplayed(driver, unt.GetObjByContent("2.1", "Jack"), true);
            
            //step02
			action.moveToElement(unt.GetObjByContent("3", "[Picture/Adult.jpg]") , 127 , 10);
			action.click();
			action.perform();
			
			action.keyDown(Keys.SHIFT);
			for (int i = 0; i <"[Picture/Adult.jpg]".length()   ; i++) {
				action.sendKeys(Keys.ARROW_LEFT);
			}
			action.keyUp(Keys.SHIFT);
			action.perform();
			
			action.sendKeys(Keys.chord(Keys.CONTROL+"c"));
			action.sendKeys(Keys.ARROW_RIGHT);
			action.sendKeys(Keys.chord(Keys.CONTROL+"v"));
			action.perform();
		    Lib.wait_Sleep(1000);
		    ImgChecker imgChecker = new ImgChecker(driver);
		    Lib.SwitchToFrame(driver, "ucx_file_iframe");
		    imgChecker.CheckImg(unt.GetObjByContent("3", "[Picture/Adult.jpg][Picture/Adult.jpg]"), "IntelliSense_42_Step02");

			


			
            


			
			
			
			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource_highlight.ucx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource_highlight.ucx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_43_Resource_Filter_Spreadsheet(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);
			

			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_44_Resource_Operations_Spreadsheet(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_45_Resource_Triggers_Spreadsheet(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_46_Resource_Highlight_Realtime_Spreadsheet(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_47_Resource_Highlight_EditEffects_Spreadsheet(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_resource_highlight.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_resource_highlight.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_resource_highlight.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_resource_highlight.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	@Deprecated
//	@Test
	public void IntelliSense_48_Resource_DataSourceLevel(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.xlsx").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.xlsx");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}
	
	
	
//	@Test
	public void IntelliSense(){
		try {
			Lib.checkPageIsReady(driver);
			Lib.CheckOutRex(driver, "Document/IntelliSense/Test_Resource.rex");
			Lib.DirFile(driver, "Document/IntelliSense/Test_Resource.rex").click();
			FlowUnit fut = new FlowUnit(driver);
			Actions action=new Actions(driver);

			
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
		} catch (Exception e) {
			Lib.RestoreRex(driver, "Document/IntelliSense/Test_Resource.rex");
			//ClearMainGui
			Lib.clear_page(driver, UserName, Password);
			
			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}

}
