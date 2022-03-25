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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
import com.thoughtworks.selenium.Selenium;

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

public class Voice_test {
	WebDriver driver = null;
	int WaitTime = 0;
	String currentWindow = "";//主页面
	AutoItX AutoWin = null;
	String downloadpath = "";
	String UploadFilePath = "";
//	String UserName = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderUserName");  
//	String Password = PropertiesDataProvider.getTestData("config/config.properties", "AppBuilderPassword");
	String declaringClassNameReg = "testcases";

	@BeforeClass
	public void beforeClass() {
		//Debug Regex
//		   Pattern Pcontext = Pattern.compile("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2} (A|P)M");
//		   06/26/2021 03:07 AM
//        Matcher matcher = Pcontext.matcher("06/26/2021 03:07 AM");
//    	   boolean b = matcher.matches();
//		   System.out.println(b);

		//初始化windows COM插件
		String jacobDllVersionToUse = PropertiesDataProvider.getTestData("config/config.properties", "AutoXDll");
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		this.AutoWin = new AutoItX();
		//初始化webdriver及测试环境变量
		this.driver = MMDriver.init();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Lib.login_Mm(driver, "chinaqa", "123456");
		String sWaitTime = PropertiesDataProvider.getTestData("config/config.properties", "WaitTime");
		downloadpath = PropertiesDataProvider.getTestData("config/config.properties", "Downloadpath");
		UploadFilePath = PropertiesDataProvider.getTestData("config/config.properties", "UploadFilePath");
		WaitTime = Integer.parseInt(sWaitTime);

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

	}

	@AfterMethod
	public void afterMethod() {
//		MMDriver.softAssert.assertAll();	
	}
	
	@Test
	public void Voice_Char_Test(){
	   try {
		    Actions action= new Actions(driver);
			 Lib.checkPageIsReady(driver);
			 driver.switchTo().defaultContent();
 			 Lib.wait_Sleep(3000);
             driver.findElement(MatterMost.appList("charlie")).click();
             driver.findElement(MatterMost.Send_Box).click();
             driver.findElement(MatterMost.Send_Box).clear();
             Lib.PostMmMessage(action,"home phone");
             
 			 Lib.chkIsDisplayed(driver, MatterMost.Post_NewMessage_title , true);
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "Welcome to CyberObject. My name is Charlie.What kind of question do you have on your home phone, TV or Internet service today?");
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"123");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "You could say Wifi is down, Program TV remote, Change my voicemail password, or How to activate call forwarding.");
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"home phone");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "OK. What is the phone number you seem to be having trouble with?");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"9991112301");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver,false ,"charlie" , "Thank you. Let me make sure that I have got the right number. Is 999-111-2301 the correct number?1. Yes2. No");
 			 
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"yes");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "Good. What seems to be the trouble with that telephone number?1. dial tone problem2. Voicemail3. Can't Call Out4. Caller ID Issue5. Can't Be Called6. Feature Issue7. Transmission Problem8. Data Problem9. Outside damage10. 911 Related Issue11. Miscellaneous Issue");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"abc");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "You can say things like, no dial tone, I can't make calls, receive calls, problem with a phone feature, or a phone jack, or a telephone pole outside, etc.\n1. dial tone problem\n2. Voicemail\n3. Can't Call Out\n4. Caller ID Issue\n5. Can't Be Called\\n6. Feature Issue\n7. Transmission Problem\n8. Data Problem\n9. Outside damage\n10. 911 Related Issue\n11. Miscellaneous Issue\n");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"abc");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "Is it dial tone problem?");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"yes");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "What kind of dial tone trouble are you experiencing?1. No Dial Tone2. Slow Dial Tone3. No Dial Tone At Times4. my phone won't break the dial tone5. Beeping On Line");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"no dial tone");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "OK, no dial tone. Is the problem on every phone on that line?1. Yes2. No");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"yes");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "We need to test your line to isolate the trouble. Please hold while the testing is in progress...Our test indicates your line is working okay. The trouble is likely at your location. You can request a technician on site for repair, or perform some troubleshooting yourself with easy to follow instructions. Now do you want to try the troubleshooting steps yourself?1. Yes2. No");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"no");
 			 Lib.wait_Sleep(3000);
// 			 Lib.CheckMmResponseMessageContext(driver, true ,"charlie" , "Okay. We will have your trouble cleared between now and the end of the day on 06/26/2021 03:07 AM.May I have another number where we can reach you?");
 			 Lib.CheckMmResponseMessageContext(driver, true ,"charlie" , "Okay. We will have your trouble cleared between now and the end of the day on \\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2} (A|P)M\\.May I have another number where we can reach you\\?");

 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"9991112302");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "May I have your name for this report?");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"cyber");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "We have created a trouble report for your issue. The report number is PU001A01. You can call us back to check the status at any time.What else can I help you with today?");
 			
 			 Lib.wait_Sleep(3000);
             Lib.PostMmMessage(action,"goodbye");
 			 Lib.wait_Sleep(3000);
 			 Lib.CheckMmResponseMessageContext(driver, false ,"charlie" , "Goodbye");
 					 
             driver.findElement(MatterMost.SYS_Setting).click();
 			 Lib.wait_Sleep(1000);
             driver.findElement(MatterMost.Logout).click();
		} catch (Exception e) {
			//ClearMainGui
//			Lib.clear_page(driver, UserName, Password);

			Lib.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg);
		}
		MMDriver.softAssert.assertAll();
	}

}
