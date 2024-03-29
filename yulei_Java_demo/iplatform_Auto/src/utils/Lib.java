/**
 * 
 */
package utils;

import prepare.MMDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.grid.web.servlet.handler.LegacySeleniumRequest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.el.BooleanLiteral;
import org.apache.commons.io.FileUtils;
//import org.apache.regexp.recompile;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Guice;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Yaml;
import org.testng.log4testng.Logger;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;
import com.thoughtworks.selenium.condition.Not;

import autoitx4java.AutoItX;
import objectRepository.AppElements;
import objectRepository.MatterMost;
import checkpoints.AppBChkPoint;
import checkpoints.EnrollChat;
//import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.GuiCallback;

import org.testng.Assert;

/**
 * @author WangMingxun
 *
 */
public class Lib {
	// private WebDriver driver = null;
	public WebDriver window = null;
	protected static String webUrl = "";
	public String current_handles = "";
	private static Robot robot = null;
	private String ExceptionMessage = null;

	private static <E> String ExceptionMessageFormat(Exception e, int exp , int actual , E by) {
		String s = "";
		if (by == null) {
			s = ExceptionMessage(e, exp, actual) + "gui_start element is null gui_end";
			return s;
		}
		s = ExceptionMessage(e, exp, actual) + "gui_start "+by.toString() + " gui_end";
		return s;
	}
	
	private  static <E> String ExceptionMessageFormat(Exception e, String exp , String actual , E by) {
		String s = "";
		if (by == null) {
			s = ExceptionMessage(e, exp, actual) + "gui_start element is null gui_end";
			return s;
		}
		s = ExceptionMessage(e, exp, actual) + "gui_start "+by.toString() + " gui_end";
		return s;
	}

	private static String ExceptionMessageFormat(Exception e, String exp , String actual) {
		String s = "";
		s = ExceptionMessage(e, exp, actual) + "gui_start "+" gui_end";
		return s;
	}
	
	public static void GetExcptionMessageFromExcptionRejector(Exception e , String declaringClassNameReg) {
		MMDriver.softAssert.fail(Lib.ExcptionMessageRejector(e,declaringClassNameReg) + "gui_start " + e.toString() + " gui_end");
	}
	
	/**
	 * 启动Driver
	 * 本地运行
	 * @return WebDriver
	 * @author yulei
	 */
	public static WebDriver launchBrowser(){
		WebDriver driver;
		String webdv = PropertiesDataProvider.getTestData("config/config.properties", "webdv");
		String webdvdir = PropertiesDataProvider.getTestData("config/config.properties", "webdvdir");
		System.setProperty(webdv, webdvdir);
		
		DesiredCapabilities dCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();	
	    options.addArguments("test-type");
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-web-security");
	    options.addArguments("--allow-running-insecure-content");
		options.addArguments("--disable-infobars");
		options.addArguments("--ignore-certificate-errors");
//      options.addArguments("--disable-web-security");
//      options.addArguments("--allow-running-insecure-content");
		dCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		dCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dCapabilities.setCapability(CapabilityType.VERSION, true);
		
		driver = new ChromeDriver(dCapabilities);
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		return driver;
//		ChromeOptions options = new ChromeOptions();
//		  options.addArguments(
//		   "--verbose",
//		   "--headless",
//		   "--disable-web-security",
//		   "--ignore-certificate-errors",
//		   "--allow-running-insecure-content",
//		   "--allow-insecure-localhost",
//		   "--disable-gpu"
//		  );
//		  driver = new ChromeDriver(options);
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		  driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//		  driver.manage().window().maximize();
//		  return driver;
	}

	/**
	 * 启动Driver
	 * 远程运行
	 * @param Url
	 * @return WebDriver
	 * @author yulei
	 */
	public static WebDriver launchBrowser(String Url) {
		//远程运行
		RemoteWebDriver driver;
		try {
		DesiredCapabilities dCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		dCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(new URL(Url),dCapabilities);
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

		} catch (MalformedURLException e) {
			return null;
		}
		return driver; 
	}

	
	
	
	/**
	 * 登录MatterMost
	 */
	public static void login_Mm(WebDriver driver, String user, String password) {
		webUrl = PropertiesDataProvider.getTestData("config/config.properties", "MattermostUrl");
		driver.manage().window().maximize();
		driver.get(webUrl);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(MatterMost.Login_ID).clear();
		driver.findElement(MatterMost.Login_ID).sendKeys(user);
		driver.findElement(MatterMost.Login_PW).clear();
		driver.findElement(MatterMost.Login_PW).sendKeys(password);
		driver.findElement(MatterMost.SIGN_IN).click();

		if (isDisplayed(driver, MatterMost.Dialog_Status_Title, true, 2)) {
			driver.findElement(MatterMost.Dialog_Status_Yes).click();
		}
	}

	/**
	 * Logout MatterMost
	 */
	public static void logout_Mm(WebDriver driver) {

		if (Lib.isDisplayed(driver, MatterMost.SYS_Setting, true, 2)) {
			driver.findElement(MatterMost.SYS_Setting).click();
			driver.findElement(MatterMost.Logout).click();
		} else {
			driver.findElement(MatterMost.SYS_Setting_narrowDisplay).click();
			driver.findElement(MatterMost.Logout_narrowDisplay).click();
		}
	}

	public static void CheckMmResponseMessageContext(WebDriver driver, Boolean IsPattern , String serverID ,String context) {
		String s = "";
		WebElement TheLastMessage = null;
		List<WebElement> wl = null;
		String[] ReturnMessages = new String[2];
		Pattern p = Pattern.compile("\\d{2}:\\d{2}:\\d{2} (P|A)M");
		wl =  driver.findElements(MatterMost.Post_Messages);
		TheLastMessage = wl.get(wl.size() - 1);
		s = TheLastMessage.getAttribute("textContent");
		ReturnMessages = p.split(s);

        MMDriver.softAssert.assertEquals(ReturnMessages[0], serverID, ExceptionMessage(new Exception()));
        if (IsPattern) {
    		Pattern Pcontext = Pattern.compile(context);
            Matcher matcher = Pcontext.matcher(ReturnMessages[1]);
        	boolean b = matcher.matches();
	        MMDriver.softAssert.assertEquals(b, true, ExceptionMessage(new Exception()));
		}else {
	        MMDriver.softAssert.assertEquals(ReturnMessages[1], context, ExceptionMessage(new Exception()));
		}
        
        
	}
	
	public static void CheckMmPostMessageContext(WebDriver driver , String str) {
		String s = "";
		WebElement TheLastMessage = null;
		List<WebElement> wl = null;
		wl =  driver.findElements(MatterMost.Post_Messages);
		TheLastMessage = wl.get(wl.size() - 1);
		s = TheLastMessage.getAttribute("textContent");
		MMDriver.softAssert.assertTrue(s.contains(str), ExceptionMessage(new Exception()));
	}	
	
	public static void PostMmMessage(Actions action , String str) {
        Lib.SendKeysOnebyOne(action, str);
        action.sendKeys(Keys.ENTER);
        action.perform();
	}
	
	
/**
 * 
 * @param driver
 * @param user
 * @param password
 * @author yulei
 */
	public static void login_AppBuilder(WebDriver driver, String user, String password) {
		try {
			webUrl = PropertiesDataProvider.getTestData("config/config.properties", "urlappbuilder");
//			Boolean yBoolean = Lib.isExist(driver, AppElements.APP_ID_Tip);
//			if(!yBoolean) {
//			  driver.switchTo().frame("moduleFrame");
//			}
			    driver.switchTo().defaultContent();
				if(Lib.isExist(driver, AppElements.SIGNOUT)) {
					Actions actions = new Actions(driver);
					driver.findElement(AppElements.SIGNOUT_arrow).click();
					int width =driver.findElement(AppElements.SIGNOUT).getSize().getWidth();
					actions.moveToElement(driver.findElement(AppElements.SIGNOUT), (width/2)-2, 0).click();
					actions.perform();				
				}

			Lib.wait_Sleep(3000);
			driver.manage().window().maximize();
			driver.get(webUrl);
			Lib.wait_Sleep(5000);
			if (Lib.isExist(driver, MatterMost.Login_ID)) {
				driver.findElement(MatterMost.Login_ID).clear();
				driver.findElement(MatterMost.Login_ID).sendKeys(user);
				driver.findElement(MatterMost.Login_PW).clear();
				driver.findElement(MatterMost.Login_PW).sendKeys(password);
				driver.findElement(MatterMost.SIGN_IN).click();
				}


		} catch (UnreachableBrowserException e) {
			// TODO: handle exception
			System.out.println("" + e.toString());
		}
	}
	
/**
 * 
 * @param driver
 * @param user
 * @param password
 * @author yulei
 */
	public static void Switch_loginUser_AppBuilder(WebDriver driver, String user, String password) {
		try {
			Actions actions = new Actions(driver);
			driver.switchTo().defaultContent();
			driver.findElement(AppElements.SIGNOUT_arrow).click();
			int width =driver.findElement(AppElements.SIGNOUT).getSize().getWidth();
			actions.moveToElement(driver.findElement(AppElements.SIGNOUT), (width/2)-2, 0).click();
			actions.perform();

            Lib.wait_Sleep(3000);
          //登陆 
			driver.findElement(MatterMost.Login_ID).clear();
			driver.findElement(MatterMost.Login_ID).sendKeys(user);
			driver.findElement(MatterMost.Login_PW).clear();
			driver.findElement(MatterMost.Login_PW).sendKeys(password);
			driver.findElement(MatterMost.SIGN_IN).click();   
			Lib.wait_Sleep(3000);
			driver.switchTo().frame("moduleFrame");
			
		} catch (UnreachableBrowserException e) {
			// TODO: handle exception
			System.out.println("" + e.toString());
		}
	}
	
	public static void Switch_appGourp(WebDriver driver, String GroupName) {
		if (!isExist(driver, AppElements.Menu_bar_Switch)) {
			driver.switchTo().defaultContent();
		}
        wait_Sleep(4000);
		driver.findElement(By.xpath("//span[@id='wsiconId']")).click();
        wait_Sleep(4000);
        driver.findElement(By.xpath("//div[@id='switchWorkspaceListDiv']//a[@title='"+ GroupName +"']")).click();
        wait_Sleep(1000);
        SwitchToFrame(driver, "workspacesFrame");
	}
	
	/**
	 * 
	 * @param driver
	 * @param user
	 * @param password
	 * @return
	 * @author yulei
	 */
	public static Boolean clear_page(WebDriver driver,String user, String password) {
		Boolean y = false;
		String AppName;
		try {
//			//判断跳出switchapp页面
			Lib.SwitchToFrame(driver, "moduleFrame");
			if (!isExist(driver, By.xpath("//span[@id='appId'][1]"))) {
				driver.switchTo().defaultContent();
				Lib.SwitchToFrame(driver, "workspacesFrame");
				driver.findElement(AppElements.SwitchAppMenu_CustomObj("ui_app_test")).click();
			}
			//Clear之前所在app页面
			Lib.SwitchToFrame(driver, "moduleFrame");
			AppName = driver.findElement(By.xpath("//span[@id='appId'][1]")).getText();
			//Handle Channels页面无法点击logout按钮,原因 unknown.
			
	          if (Lib.isExist(driver, AppElements.WarningMessage_OK))
              {
	        	  driver.findElement(AppElements.WarningMessage_OK).click();
			  }
			
			if (isExist(driver, By.xpath("//p[@class='new_pop_cancel']//span[text()='Cancel']"))) {
				//去除message cover
				driver.findElement(By.xpath("//p[@class='new_pop_cancel']//span[text()='Cancel']")).click();
			}
			if (Lib.isExist(driver, AppElements.Version_History_Close)) {
	        	  driver.findElement(AppElements.Version_History_Close).click();
			}
			AutoItX AutoWin = new AutoItX();
			if (AutoWin.winExists("打开", "取消")) {
	            AutoWin.winWaitActive("打开");
				Lib.wait_Sleep(2000);
	    		AutoWin.controlClick("打开", "取消", "2");
			}

            //保证页面可操作
			Lib.DirFile(driver, "Document").click();
			//登出
			driver.switchTo().defaultContent();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.SIGNOUT_arrow).click();
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.SIGNOUT).click();
			Lib.wait_Sleep(6000);

            //登陆 
		    WebDriverWait wait = new WebDriverWait(driver,16);
		    wait.until(ExpectedConditions.presenceOfElementLocated(MatterMost.Login_ID)); 

			driver.findElement(MatterMost.Login_ID).clear();
			driver.findElement(MatterMost.Login_ID).sendKeys(user);
			driver.findElement(MatterMost.Login_PW).clear();
			driver.findElement(MatterMost.Login_PW).sendKeys(password);
			driver.findElement(MatterMost.SIGN_IN).click();
            
			Lib.wait_Sleep(3000);
			//是否为之前页面
			Lib.SwitchToFrame(driver, "moduleFrame");
			int IsBefore = driver.findElement(By.xpath("//span[@id='appId'][1]")).getText().compareTo(AppName);
			//如果不为之前页面，则跳转到之前页面
			if (IsBefore != 0) {            
	        	driver.switchTo().defaultContent();
	        	driver.findElement(AppElements.Menu_bar_WorkSpacesIcon).click();
				Lib.wait_Sleep(2000);
	        	driver.switchTo().frame("workspacesFrame");
				driver.findElement(AppElements.SwitchAppMenu_CustomObj(AppName)).click();
	            Lib.wait_Sleep(2000);
	    	    Lib.SwitchToFrame(driver, "moduleFrame");
	            Lib.chkIsDisplayed(driver, AppElements.Menu_bar_AppName(AppName), true);
			}
			y = true;
			return y;
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "", "Clear MainGui is failed!"));
			return y;
		}
	}
	
	public static WebElement findElement(WebDriver driver,By by) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "", "object not found!"));
			return null;
		}
	}
	
	/**
	 * Check java scripts load complete.
	 * @param driver
	 * @author yulei
	 */
	public static void checkPageIsReady(WebDriver driver) {
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
//		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }
	
	
	/**
	 * 
	 * @param driver
	 * @author yulei
	 */
	public static void SwitchApp(WebDriver driver) {
	    Lib.wait_Sleep(2000);
	    Actions action = new Actions(driver);
    	driver.switchTo().defaultContent();
	    if (isExist(driver, AppElements.Menu_bar_Switch)) {
	    	action.click(driver.findElement(AppElements.Menu_bar_Switch));
	    	action.perform();
//	    	driver.findElement(AppElements.Menu_bar_Switch).click();
	    	Lib.wait_Sleep(2000);
			Lib.SwitchToFrame(driver, "workspacesFrame");
		    Lib.chkIsDisplayed(driver, AppElements.AppsSwitchWindow, true);
		}
	}
	/**
	 * 
	 * @param driver
	 * @param by
	 * @return
	 * @author yulei
	 */
	public static boolean isExist(WebDriver driver,By by) {
		if (!driver.findElements(by).isEmpty()) {
			return driver.findElement(by).isDisplayed();
		} 
			return false;
	}
	
	/**
	 * 
	 * @param ele
	 * @return
	 * @author yulei
	 */
	public static boolean isExist(WebElement ele) {
		try {
			Boolean yBoolean = false;
			if (ele==null) {
				return false;
			}
			
			yBoolean = ele.isDisplayed();
	        return yBoolean;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 选择APP.
	 */
	public static void selectMMApp(WebDriver driver, String appName) {
		if (Lib.isDisplayed(driver, MatterMost.navbar, true, 1))
			driver.findElement(MatterMost.navbar).click();

		// boolean flag = true;
		// int j =0;
		// mouseMoveToElement(driver, MatterMost.orgName);
		// wait_Sleep(100);
		// do {
		//
		// try {
		// flag = driver.findElement(MatterMost.APP(appName)).isDisplayed();
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// try {
		// robot = new Robot();
		// robot.mouseWheel(5);
		// wait_Sleep(100);
		// } catch (AWTException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// flag = false;
		// j++;
		// }
		//
		// } while (j < 4 && flag == false);

		// if (flag = true)
		driver.findElement(MatterMost.APP(appName)).click();
		// else
		// Assert.fail("selectMMApp fail expected [ Select APP ] but found
		// [selectMMApp" + appName + " fail!]@@\n\t,");
	}

	/**
	 * 
	 * @param driver
	 * @param appName
	 * @author yulei
	 */
	public static void SelectApp(WebDriver driver, String appName) {
		String CurrappTitle = "";

		Lib.SwitchToFrame(driver, "moduleFrame");
		CurrappTitle = driver.findElement(AppElements.APP_ID_Tip).getText();
	
		if(!CurrappTitle.equals(appName)) {
			driver.switchTo().defaultContent();
			Lib.wait_Sleep(1000);
            driver.findElement(AppElements.Apps_btn_downarrow).click();
			Lib.wait_Sleep(1000);
			driver.findElement(AppElements.Menu_bar_Switch).click();
			Lib.wait_Sleep(1000);
			Lib.SwitchToFrame(driver, "moduleFrame");
			driver.findElement(AppElements.Display_OrgID_CustomObj(appName)).click();
			Lib.wait_Sleep(1000);
			String appTitle = driver.findElement(AppElements.APP_ID_Tip).getText();
			Lib.assertEquals(appTitle, appName);
		}
	}
	/**
	 * 
	 * @param driver
	 * @param appName
	 * @param ListOrTempList
	 * @author yulei
	 */
	public static void SelectApp(WebDriver driver, String appName, String ListOrTempList) {	
		String CurrappTitle = "";
		if (Lib.isExist(driver, AppElements.APP_ID_Tip)) {
			 CurrappTitle = driver.findElement(AppElements.APP_ID_Tip).getText();
		}else {
			Lib.SwitchToFrame(driver, "moduleFrame");
			 CurrappTitle = driver.findElement(AppElements.APP_ID_Tip).getText();
		}
	
		if(!CurrappTitle.equals(appName)) {
			driver.findElement(AppElements.Menu_bar_Switch).click();	
			Lib.wait_Sleep(2000);
			driver.findElement(AppElements.Display_AppID_CustomObj(appName,ListOrTempList)).click();
			Lib.wait_Sleep(2000);
			String appTitle = driver.findElement(AppElements.APP_ID_Tip).getText();
			MMDriver.softAssert.assertEquals(appTitle, appName, ExceptionMessage(new Exception(), "", "Switch app "+ appName +" is failed!"));
		}
	}
	
	
	/**
	 * 获取Login ID的User Name.
	 */

	public static String getUserName(WebDriver driver) {
		driver.findElement(MatterMost.SYS_Setting).click();
		driver.findElement(MatterMost.Account_Settings).click();
		wait_Sleep(100);
		String userName = driver.findElement(MatterMost.Account_Settings_UserNameDesc).getText();
		driver.findElement(MatterMost.Account_Settings_Close).click();
		wait_Sleep(100);
		return userName;
	}

	/**
	 * 选择Choose Session
	 */
	public static void selectChose(WebDriver driver, String choseValue) {
		try {
			driver.findElement(By.id(getLastMsgID(driver)))
					.findElement(By.xpath("//li[@class='select'][text()='" + choseValue + "']")).click();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				driver.findElement(By.id(getLastMsgID(driver))).findElement(By.partialLinkText(choseValue)).click();
			} catch (Exception e1) {
				Assert.fail(ExceptionMessage(new Exception(), "", choseValue + "Choose can't find out."));
			}
		}

	}

	/**
	 * 
	 * @return 最后一个message ID。
	 */
	public static String getLastMsgID(WebDriver driver) {
		return driver.findElement(MatterMost.Post_Last).getAttribute("id");
	}

	/**
	 *
	 * @return 最后一个message 内容
	 */
	private static String getLastMsgContent(WebDriver driver) {
		return driver.findElement(MatterMost.Post_Last).findElement(By.className("post__body")).getText();
	}

	/**
	 * 
	 * @return 谁的message
	 */
	private static String getLastMsgOwner(WebDriver driver) {
		return driver.findElement(MatterMost.Post_Last).findElement(By.className("user-popover")).getText();
	}

	
	/**
	 *
	 * @param expected
	 */
//	public static void chkMsg(WebDriver driver, String expected) {
//		String actual = null;
//		String lostID = null;
//		int j = 0, n = 6;
//
//		do {
//			actual = getMsg(driver);
//			lostID = getLastMsgID(driver);
//			if (actual.equals(expected)) {
//				break;
//			} else {
//				++j;
//				wait_Sleep(400);
//
//			}
//		} while (j < n);
//
//		if (j >= n) {
//			fail("Actual MsgID: " + lostID + ExceptionMessage(new Exception(), expected, actual));
//		}
//	}

	/**
	 * 获取系统时间
	 * @return String
	 */
	public static String getCurrentLocalDateTime() {
	    return LocalDateTime.now()
	    	   .format(DateTimeFormatter.ofPattern("EEE, MMM dd, YYYY"));
	}
	
	/**
	 * Check the owner and content
	 * 
	 * @param expected
	 */

	public static void chkMsg(WebDriver driver, String expected) {
		String DateSeparatorNodeTitle = null;
		WebElement LocationSeparatorNode = null;
		String CurrentLocalDateTime = getCurrentLocalDateTime();
		WebElement PostListContent = 
				driver.findElement(By.xpath("//div[@id='post-list']//div[@class='post-list__content']"));
		List<WebElement> DateSeparatorNodes = 
				PostListContent.findElements(By.xpath(".//div[contains(@class,'new-separator')]"));

		for (WebElement DateSeparatorNode : DateSeparatorNodes) {
			DateSeparatorNodeTitle = DateSeparatorNode.getAttribute("textContent");
			if (DateSeparatorNodeTitle.equals("New Messages") || DateSeparatorNodeTitle.equals(CurrentLocalDateTime)) {
				LocationSeparatorNode = DateSeparatorNode;
				break;
			}
		}
		
		List<WebElement> PostBodys =
		LocationSeparatorNode.findElements(By.xpath("./following-sibling::div//div[@class='post__body']"));
        Boolean IsPass = false;
        String Actual = "";
		for (WebElement PostBody : PostBodys) {
			Actual = PostBody.getAttribute("textContent");
			if (PostBody.getAttribute("textContent").trim().contentEquals(expected.trim())) {
				IsPass = true;
				break;
			}
		}
		MMDriver.softAssert.assertTrue(IsPass, ExceptionMessage(new Exception(), expected, Actual));			
	}

	/**
	 *
	 * @param expected
	 */

	public static void chkMsgRegEx(WebDriver driver, String expected) {
		String actual = null;
		String lostID = null;
		int j = 0;
		do {
			actual = getMsg(driver);
			lostID = getLastMsgID(driver);
			boolean result = Pattern.compile(expected).matcher(actual).find();

			// Pattern.compile(expected).matcher(actual).find();

			if (result) {
				break;
			} else {
				++j;
				wait_Sleep(500);
			}

		} while (j < 6);

		if (j >= 6) {
			if (actual.equals(EnrollChat.I_am_checking_for_a_couple_of_things))
				fail("Actual MsgID: " + lostID + ExceptionMessage(new Exception(), expected, actual));
			else
				MMDriver.softAssert.fail(
						"Actual MsgID: " + lostID + ExceptionMessage(new Exception(), expected, actual));
		}

	}

	/**
	 *
	 * @param expected
	 */

	public static void chkMsgRegEx(WebDriver driver, String owner, String expected) {
		String userNm = null;
		String actual = null;
		String lostID = null;
		int j = 0;
		do {
			actual = getMsg(driver);
			lostID = getLastMsgID(driver);
			userNm = getLastMsgOwner(driver);
			// boolean result = (userNm + ":" +
			// actual).matches(Pattern.compile(owner + ":" + expected));

			boolean result = Pattern.compile(owner + ":" + expected).matcher(userNm + ":" + actual).find();

			if (result) {
				break;
			} else {
				++j;
				wait_Sleep(500);
			}

		} while (j < 6);

		if (j >= 6) {
			sendMsg(driver, "Cancel and close the session");
			Assert.fail("Actual MsgID: " + lostID + " expected [" + owner + ":" + expected + "] but found [" + userNm
					+ ":" + actual + "]@@\n");
		}

	}

	/**
	 * 
	 * @return 获取message 内容
	 */
	private static String getMsg(WebDriver driver) {
		String tempID = null;
		String msgContent = "";
		int j = 0;
		String tempMsg = "";
		WebElement element = null;

		// 如果一次返回多个message，需要循环获取。
		do {
			tempID = getMsgId(driver, j);
			element = driver.findElement(By.id(tempID));

			tempMsg = element.findElement(By.className("post__body")).getText();
			// 判断是否一次返回多个message
			// 如果只有一个message
			if (j == 0 && !element.getAttribute("class").trim().equals("post same--user same--root"))
				msgContent = tempMsg + msgContent;
			else
				// 如果多个message，除了最后一个message后面添加\n.
				msgContent = tempMsg + "\n" + msgContent;
			++j;

		} while (element.getAttribute("class").trim().equals("post same--user same--root"));
		// System.out.println("Actual: " + msgContent);
		return msgContent;
	}

	/**
	 * 
	 * @param String[]
	 *            args - init Step.
	 * @Queue，发送"Clear the history and close".
	 */
	public static void initStart(WebDriver driver, String[] args) {
		String tempMsg = null;
		// 初始化
		sendMsg(driver, "clear session");

		// ???? 可能clear session没有任何反应，重试quit.
		wait_Sleep(500);
		if (getMsg(driver).equals("clear session")) {
			sendMsg(driver, "quit");
		}
		wait_Sleep(500);
		tempMsg = getMsg(driver);
		// 如果得到Goodbye或者Session is terminated，发送 "hello" 开始flow。
		if (tempMsg.equals("Goodbye.") | tempMsg.equals("Session is terminated"))
			sendMsg(driver, "hello");
		for (int i = 0; i < args.length; i++) {
			sendMsg(driver, args[i]);
			int j = 0;
			while (getLastMsgContent(driver).equals(args[i]) && j < 3) {
				wait_Sleep(200);
				j++;
			}
		}
		chkMsg(driver, "Goodbye.");

	}

	/**
	 * 
	 * @param actNum
	 * @return 获取message ID
	 */
	private static String getMsgId(WebDriver driver, int actNum) {
		String tempID = null;
		// String msgContent = null;
		tempID = driver.findElement(By.xpath("//div[@class='post-list__content']/div[last()-" + actNum
				+ "][not(@class='date-separator')][not(@class='new-separator')]/div")).getAttribute("id");

		return tempID;
	}

	public static void sendMsg(WebDriver driver, String sendInfo) {
		driver.findElement(MatterMost.Send_Box).sendKeys(sendInfo);
		wait_Sleep(300);
		driver.findElement(MatterMost.Send_Box).sendKeys(Keys.ENTER);
		wait_Sleep(500);
	}

	/**
	 * 获取engagement session By.
	 */

	public static void isEngageSuccess(WebDriver driver, String appName, String custName) {

		By engagementSession = By.xpath("//span[@class='sidebar-item__name'][text()='" + appName
				+ "']/parent::*/following-sibling::ul/li/a[@class='sidebar-channel'][text()='" + custName
				+ "']/parent::*");

		WebElement element = null;
		int j = 0;
		Boolean flag = false, isSelected = false;
		do {

			try {
				flag = driver.findElement(engagementSession).isDisplayed();
			} catch (Exception e) {
				// TODO: handle exception
				++j;
				wait_Sleep(500);
				continue;
			}

			if (flag == true) {
				isSelected = driver.findElement(engagementSession).getAttribute("class").equals("active");
				break;
			}

		} while (j < 10);

		if (flag == false || isSelected == false) {
			sendMsg(driver, "Cancel and close the session");
			Assert.fail(engagementSession.toString() + " expected [" + "Engage successfuly!" + "] but found ["
					+ "Engage successfuly: " + flag + " isSelected: " + isSelected + "]@@\n,");
		}
	}

	/**
	 * 退出
	 */
	public static void quit(WebDriver driver) {

		try {
			if (driver != null) {
				driver.quit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 退出
	 */
	public static void close(WebDriver driver) {

		driver.findElement(MatterMost.Logout).click();
		try {
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 最大化浏览器操作
	 */
	public static void maxWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * 根据preleveId查找下一级 ID.
	 */
	public static By findSubTree(WebDriver driver, By parentTree, String subTree) {
		String tempId = "";
		String id = driver.findElement(parentTree).getAttribute("id");
		
		List<WebElement> elements = driver.findElement(By.xpath("//div[@id='" + id + "']/following-sibling::ul"))
				.findElements(By.className("tree-node"));
		Iterator iterator = elements.iterator();

		while (iterator.hasNext()) {
			WebElement element = (WebElement) iterator.next();
			if (element.findElement(By.className("tree-title")).getText().equals(subTree)) {
				tempId = element.getAttribute("id");
				break;
			}

		}
		return By.id(tempId);
	}

	/**
	 * @see find app from Switch.
	 * @param appName
	 */
	public static By findAppFromSwitch(String appName) {

		return By.xpath("//div[@id='newOrg_info_p']//a[@class='newOrg_appId'][@title='" + appName + "']");

	}

	/**
	 * @see find template app.
	 * @param appName
	 */
	public static By findAppTemplate(String appName) {

		return By.xpath(
				"//div[@id='select_app_template_p']//span[@class='newOrg_templateid'][@title='" + appName + "']");

	}

	/**
	 * 查找tree hit.
	 */
	public static WebElement findTreeHit(WebDriver driver, By by) {
		return driver.findElement(by).findElement(By.className("tree-hit"));
	}
	
/**
 * 模拟键盘按键操作
 * @param driver
 * @param key
 */
	public static void simulate_Key(WebDriver driver, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(key).perform(); 
	}
	
	/**
	 * 模拟鼠标操作 - 鼠标移动到指定元素
	 */
	public static void mouseMoveToElement(WebDriver driver, By by) {
		checkPageIsReady(driver);
		Actions actions = new Actions(driver);
		Actions mouse = actions.moveToElement(driver.findElement(by));
		mouse.perform();
	}
/**
 * 模拟鼠标操作 - 鼠标移动到指定元素并且点击
 * @param driver
 * @param by
 * @param Xoffset X轴
 * @param Yoffset Y轴
 */
	public static void mouseMoveToElementAndClick(WebDriver driver, By by , int Xoffset , int Yoffset) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(by), Xoffset, Yoffset);
		 actions.click();
		 actions.perform();
	}
	
	
	/**
	 * 模拟鼠标拖拽
	 * @param driver
	 * @param by
	 * @param x
	 * @param y
	 */
	public static void dragAndDropBy(WebDriver driver , By by , int x , int y) {
		Actions actions =new Actions(driver);
        actions.dragAndDropBy(driver.findElement(by) , x , y);
        actions.perform();
	}
	
	/**
	 * 模拟鼠标拖拽
	 * @param driver
	 * @param ele
	 * @param x
	 * @param y
	 */
	public static void dragAndDropBy(WebDriver driver , WebElement ele , int x , int y) {
		Actions actions =new Actions(driver);
        actions.dragAndDropBy(ele , x , y);
        actions.perform();
	}
	
	/**
	 * 模拟鼠标操作 - 鼠标移动到指定元素
	 */
	public static void mouseMoveToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		Actions mouse = actions.moveToElement(element);
		mouse.perform();
	}
	
	/**
	 * 模拟鼠标操作 - 鼠标右击
	 */
	public static void mouseRightClick(WebDriver driver, By by) {
		try {
			checkPageIsReady(driver);
			driver.findElement(by).click();
			Lib.wait_Sleep(3000);			
			Actions actions = new Actions(driver);
//			actions.moveToElement(driver.findElement(by));
//			actions.click(driver.findElement(by));
			actions.contextClick(driver.findElement(by));
			actions.perform();
            Lib.wait_Sleep(2000);
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(e, "", "MouseRightClick failed!") );
//			MMDriver.softAssert.fail(ExceptionMessage(e, "", "MouseRightClick failed!") + "gui_start ");
		}
	}

	/**
	 * 模拟鼠标操作 - 鼠标右击
	 */
	public static void mouseRightClick(WebDriver driver, WebElement ele) {
		try {
            Lib.wait_Sleep(1000);
			ele.click();
			Actions actions = new Actions(driver);
			actions.click(ele);
			actions.perform();
			actions.contextClick(ele);
			actions.perform();
            Lib.wait_Sleep(1000);
		} catch (Exception e) {	
			MMDriver.softAssert.fail(ExceptionMessageFormat(e, "", "MouseRightClick failed!") );
//			MMDriver.softAssert.fail(ExceptionMessage(e, "", "MouseRightClick failed!") +"gui_start ");
		}
	}
	
	public static Boolean isDisplayed(WebElement element, boolean boolExp, int loopTimes) {
		boolean flag = true;
		int j = 0;
		do {
			try {
				flag = element.isDisplayed();
				if (flag == boolExp) {
					break;
				} else {
					wait_Sleep(500);
					flag = false;
					j++;
				}

			} catch (Exception e) {
				// TODO: handle exception
				wait_Sleep(500);
				flag = false;
				j++;
			}

		} while (j < loopTimes);

		return flag;

	}
	
	/**
	 * 检查是否displayed。
	 */
	public static Boolean isDisplayed(WebDriver driver, By by, boolean boolExp, int loopTimes) {
		boolean flag;
		int j = 0;

		do {
			if (boolExp) {
				flag = false;
				if (!driver.findElements(by).isEmpty()) {
					flag = driver.findElement(by).isDisplayed();
					if (!flag) {
						wait_Sleep(1000);
						++j;
						continue;
					}
					return flag;
				}
				flag = false;
				return flag;		
			}
			else {
				if (!driver.findElements(by).isEmpty()) {
					flag = !driver.findElement(by).isDisplayed();
					if (!flag) {
						wait_Sleep(1000);
						++j;
						continue;
					}
					return flag;
				}
				flag = true;
				return flag;
			}

		} while (j < loopTimes);	
		return flag;
	}
	
	/**
	 * 检查是否displayed。
	 */
	public static void chkIsDisplayed(WebDriver driver, By by, boolean boolExp) {
		checkPageIsReady(driver);
		boolean flag = isDisplayed(driver, by, boolExp, 3);
		if (boolExp == true) {
			if (flag == false)
				MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NotFound", by));
		} else {
			if (flag == false)
				MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "NotFound", "Displayed", by));
		}

	}
	
	/**
	 * 检查是否displayed。
	 */
	public static void chkIsDisplayed(WebDriver driver, WebElement element, boolean boolExp) {
		boolean flag = true;
//		checkPageIsReady(driver);
			try {
				flag = element.isDisplayed();
				if (boolExp) {
					if (flag == false) {
						MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NotFound", element));
//						MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "Displayed", "NotFound") + "gui_start " + element.toString() );
					}
				} else {
					if (flag == true) {
						MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "NotFound", "Displayed", element));
//						MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "NotFound", "Displayed") + "gui_start " + element.toString());
					}
				}
			} catch (Exception e) {
				if (boolExp) {
					MMDriver.softAssert.fail(ExceptionMessageFormat(e, "NotFound", "Displayed"));
				} 	
			}
	}
	

	/**
	 * 检查是否enabled。
	 */
	public static void chkIsEnabled(WebDriver driver, By by, boolean boolExp) {
		boolean flag = true;

		try {
			flag = (boolean) driver.findElement(by).isEnabled();
			Assert.assertEquals(flag, boolExp);
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), Boolean.toString(boolExp), Boolean.toString(flag), by.toString()+"is enabled"));
//					ExceptionMessage(new Exception(),Boolean.toString(boolExp), Boolean.toString(flag)) + "gui_start "+ by.toString() + "is enabled"));
		}

	}

	/**
	 * 检查是否Selected。
	 */
	public static void chkIsSelected(WebDriver driver, By by, boolean boolExp) {
		boolean flag = true;
		WebElement element = driver.findElement(by);
		// Assert.assertEquals((Boolean) element.isSelected(), expected,
		// element.toString() + " (" + by.toString() + ") is Selected");

		try {
			flag = (boolean) element.isSelected();
//			Assert.assertEquals(flag, boolExp, ExceptionMessage(new Exception(), Boolean.toString(boolExp), Boolean.toString(flag)));
			Assert.assertEquals(flag, boolExp, ExceptionMessageFormat(new Exception(), Boolean.toString(boolExp), Boolean.toString(flag)));
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), Boolean.toString(boolExp), Boolean.toString(flag), by.toString()+"is Selected"));
//			MMDriver.softAssert.fail( ExceptionMessage(new Exception(),Boolean.toString(boolExp), Boolean.toString(flag)) + "gui_start "+  by.toString() + "is Selected");
		}

	}

	/**
	 * 检查Text。
	 */
	public static void chkTextContent(WebDriver driver, By by, String expected) {
		String actualValue = "";
		WebElement element = null;
		if (isDisplayed(driver, by, true, 4))
			element = driver.findElement(by);
		   if (element.getAttribute("class").equals("input"))
			// 检查Input Text
			actualValue = getInputValue(driver,
					"return document.getElementById('" + element.getAttribute("id") + "').value;");
		else
			actualValue = element.getText();
		if (!actualValue.equals(expected))
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception() , expected, actualValue, by));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception() , expected , actualValue)  + "gui_start "+ by.toString());
	}

	/**
	 * 检查通用方法
	 */
	@Deprecated
	public static void chkIsStatus(WebDriver driver, By by, String expected) {
		Assert.assertEquals(driver.findElement(by).getAttribute("class"), expected, ExceptionMessage(new Exception(), expected, driver.findElement(by).getAttribute("class")));
	}

	/**
	 * 模拟键盘操作。
	 */
	public static void simulateKeyBoard(int event) {

		try {
			robot = new Robot();
			robot.keyPress(event);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 模拟组合键盘操作。
	 */
	public static void simulateKeyBoard(int[] events) {

		try {
			robot = new Robot();
			for (int i = 0; i < events.length; i++) {
				robot.keyPress(events[i]);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < events.length; i++) {
			robot.keyRelease(events[i]);

		}
		robot.delay(100);
		robot.mouseWheel(5);
	}

	/**
	 * 暂停当前用例的执行，暂停的时间为：sleepTime
	 */
	public static void wait_Sleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void wait_sync(WebDriver driver , By by , int looptime) {
		int size = -1;
		try {
			   for (int i = 0; i < looptime; i++) {
				   Thread.sleep(1000);
				   size = driver.findElements(by).size();
				   if (size > 0) {
				   break;
				}  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 暂停当前用例的执行，暂停的时间为：sleepTime
	 */
	public static void wait_Pause(int sleepTime) {
		if (sleepTime <= 0) {
			return;
		}
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/** 停止页面加载 */
	public static void stopLoad() {

		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 在给定的时间内去查找元素，如果没找到则超时，抛出异常
	 */
	public static boolean wait_Condition(WebDriver driver, int timeOut, final By By) {
		boolean flag = true;
		try {
			(new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			flag = false;
			

		}
		return flag;
	}

	/**
	 * 选择下拉选项 -根据value
	 */
	public static void selectByValue(WebDriver driver, By by, String value) {
		Select s = new Select(driver.findElement(by));
		s.selectByValue(value);
	}

	/**
	 * 选择下拉选项 -根据index角标
	 */
	public static void selectByIndex(WebDriver driver, By by, int index) {
		Select s = new Select(driver.findElement(by));
		s.selectByIndex(index);
	}

	/** 检查checkbox是不是勾选 */
	public static boolean doesCheckboxSelected(WebDriver driver, By elementLocator) {
		if (driver.findElement(elementLocator).isSelected() == true) {
			return true;
		} else
			return false;

	}

	/**
	 * 选择下拉选项 -根据文本内容
	 */
	public static void selectByText(WebDriver driver, By by, String text) {
		Select s = new Select(driver.findElement(by));
		s.selectByVisibleText(text);
	}

	/**
	 * 获得当前select选择的值
	 */
	public static String getCurrentSelectValue(WebDriver driver, By by) {

		Select s = new Select(driver.findElement(by));
		WebElement e = s.getFirstSelectedOption();
		return e.getText().trim();
	}

	/**
	 * 获取下拉列表的所有选项
	 * 
	 * @param By：By元素对象
	 * @return 返回所有下拉列表中的选项，如option1,option2,……
	 */
	public static String getSelectOption(WebDriver driver, By by) {
		String value = null;
		Select s = new Select(driver.findElement(by));
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			value = value + "," + options.get(i).getText();
		}
		return value.replace("null,", "");
	}

	/** 页面过长时候滑动页面 window.scrollTo(); */
	public static void scrollPage(WebDriver driver, int x, int y) {
		String js = "window.scrollTo(" + x + "," + y + ");";
		((JavascriptExecutor) driver).executeScript(js);
	}

	/**
	 * 获得输入框的值 这个方法 是针对某些input输入框 没有value属性，
	 */
	public static String getInputValue(WebDriver driver, String js) {
		return (String) ((JavascriptExecutor) driver).executeScript(js);

	}

	/**
	 * 获得输入框的值 这个方法 是针对某些input输入框 没有value属性，
	 */
	public static void executeJs(WebDriver driver, String js) {
		((JavascriptExecutor) driver).executeScript(js);

	}

	/*
	 * 抓图
	 */

	public String getScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String dateString = format.format(new Date());

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ssPath = "./test-output/img/" + dateString + ".png";
		try {

			File screenShot = new File(ssPath);
			FileUtils.copyFile(srcFile, screenShot);
			System.out.println("截图保存在: " + ssPath);

			// Link
			Reporter.log("<a href=" + ssPath.replace("/test-output", "") + " target=_blank>Failed Screen Shot</a>",
					true);

			// Img
			Reporter.log("<img src=" + ssPath.replace("/test-output", "") + " /img>", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Link

		return ssPath.replace("/test-output", "");
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param PropertyName
	 * @param vExpected
	 * @throws NoSuchElementException
	 * @author yulei
	 */
	public static void ChkProperty_Reg(WebDriver driver, WebElement element, String PropertyName, String vExpected) throws NoSuchElementException {
		String actualValue = "";
		try {
		  checkPageIsReady(driver);
		  element.isDisplayed();
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NoSuchElement", element));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "Displayed", "NoSuchElement").concat("gui_start " + element.toString()+ "gui_end"));
		}
		actualValue = element.getAttribute(PropertyName);
		actualValue = actualValue.trim();
		if (!actualValue.contains(vExpected)) {
		    MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), vExpected, actualValue, element));
//		    MMDriver.softAssert.fail(ExceptionMessage(new Exception(), vExpected, actualValue).concat("gui start " + element.toString() + "gui_end"));
		}
	}
		/**
		 * 
		 * @param driver
		 * @param by
		 * @param PropertyName
		 * @param vExpected
		 * @author yulei
		 */
	public static void ChkProperty_Reg(WebDriver driver, By by, String PropertyName, String vExpected){
		String actualValue = "";
		WebElement element = null;
//		String ByName = "";
		try {	
//			//获取参数by名称
//            Method method = Lib.class.getMethod("ChkProperty_Reg",WebDriver.class, By.class, String.class, String.class);
//			Parameter[] p = method.getParameters();
//			ByName = p[1].getName();		
			element = driver.findElement(by);
		    actualValue = element.getAttribute(PropertyName);
		    actualValue = actualValue.trim();
		    if (!actualValue.contains(vExpected)) {
			    MMDriver.softAssert
			    .fail(ExceptionMessage(new Exception(), vExpected, actualValue).concat("gui start " + by.toString()+ "gui end"));
		    }
		} catch (Exception e) {
			MMDriver.softAssert
			.fail(ExceptionMessage(new Exception(), "Displayed", "NoSuchElement").concat("gui start " + by.toString()+ "gui end"));
		}
	}

//	public static void ChkProperty(WebDriver driver, By by, String PropertyName, String vExpected) throws NoSuchElementException {
//		String actualValue = "";
//		WebElement element = null;
//		try {
//			element = driver.findElement(by);
//		    actualValue = element.getAttribute(PropertyName);
//		    actualValue = actualValue.trim();
//		if (!actualValue.equals(vExpected)) {
//			MMDriver.softAssert
//			.fail("The line number is " + new Exception().getStackTrace()[1].getLineNumber() + "; " + by.toString() + " expected [" + vExpected + "] but found [" + actualValue + "]@@\n\t,");
//		}
//		} catch (Exception e) {
//			MMDriver.softAssert
//			.fail("The line number is " + new Exception().getStackTrace()[1].getLineNumber() + "; " + by.toString() + " expected [Displayed] but found [NoSuchElement]@@\n\t,");
//		}
//	}
	
	public static Boolean ChkProperty(WebDriver driver, By by, String PropertyName, String vExpected) {
		String actualValue = "";
		WebElement element = null;
		try {
			element = driver.findElement(by);
		    actualValue = element.getAttribute(PropertyName);
		    actualValue = actualValue.trim();
		if (!actualValue.equals(vExpected)) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), vExpected, actualValue, by));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), vExpected, actualValue).concat("gui_start " + by.toString()));

		    return false;
		}
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NoSuchElement", by));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "Displayed", "NoSuchElement").concat("gui_start " + by.toString()));
			return false;
		}
		return true;
	}
	
	public static void ChkProperty(WebDriver driver, WebElement webElement, String PropertyName, String vExpected) {
		String actualValue = "";
		try {
			if (!webElement.isDisplayed()) {
//				MMDriver.softAssert
//				.fail(webElement.toString().concat(ExceptionMessage(new Exception(), "Displayed", "NoSuchElement")));	
	        }

			actualValue = webElement.getAttribute(PropertyName);
			if (!actualValue.equals(vExpected)) {
				MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), vExpected, actualValue, webElement));
//				MMDriver.softAssert.fail(ExceptionMessage(new Exception(), vExpected, actualValue).concat("gui_start " + webElement.toString()+ "gui_end"));
			}
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NoSuchElement", webElement));
//			MMDriver.softAssert.fail(ExceptionMessage(e , "Displayed", "NoSuchElement") + "gui_start " + webElement.toString()+ "gui_end");		
		  }
		
	}
	
	public static WebElement GetObjFromArray(WebDriver driver,By by,int index) {
		List<WebElement> ements = driver.findElements(by);
		WebElement ement = ements.get(index);
		return ement;
	}
	/**
	 * 
	 * @param downloadPath
	 * @param fileName
	 * @return
	 * @author yulei
	 */
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
              
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName))
                return flag=true;
                }
        Lib.assertTrue("Is download the file", flag);
        return flag;
    }
	
	/**
	 * 获取标准table表格中的数据
	 * @param TableObject table对象
	 * @param row  行 1起始
	 * @param column 列 1起始
	 * @return String
	 * @author yulei
	 */
	public static String GetTableCellData(WebElement TableObject, int row, int column)
    {
        String text = null;
//      String xpath="./tbody/tr["+row+"]/td["+column+"]";
        String xpath=".//tr["+row+"]/td["+column+"]";
        WebElement CellObj = TableObject.findElement(By.xpath(xpath));
        text=CellObj.getText();
        return text;
    }
	/**
	 * 获取总行数
	 * @param TableObject table对象
	 * @return int 总行数
	 * @author yulei
	 */
	public static int GetTableRows(WebElement TableObject)
    {
        int row = 0;
        String xpath="./tbody/tr";
        List<WebElement> eles = TableObject.findElements(By.xpath(xpath));
        row = eles.size();
        return row;
    }
	
	/**
	 * 获取总列数
	 * @param TableObject table对象
	 * @return int 总列数
	 * @author yulei
	 */
	public static int GetTableColumns(WebElement TableObject)
    {
        int column = 0;
        String xpath="./tbody/tr[1]/td";
        List<WebElement> eles = TableObject.findElements(By.xpath(xpath));
        column = eles.size();
        return column;
    }
	
	public static List<String> GetTableActuals(WebElement TableObject) {
		int Rowcount = Lib.GetTableRows(TableObject);
		int Columncount = Lib.GetTableColumns(TableObject);
		List<String> Actuals = new ArrayList<>();
//        HashMap<String, int[][]> acts =new HashMap< String, int[Rowcount][Columncount]>();
		for (int r = 0; r < Rowcount ; r++) {
			for (int c = 0; c < Columncount ; c++) {
				Actuals.add(Lib.GetTableCellData(TableObject, r+1, c+1));
			}
		}
		return Actuals;
	}
	
	/**
	 * 获取table中所有数据及数据坐标
	 * @Parameter TableObject (By为WebTable_XXX)
	 * @return Map<String, List<Integer>>
	 * @author yulei
	 */
	private static Map<List<Integer> , String> GetTableActualsSet(WebElement TableObject) {
		int Rowcount = Lib.GetTableRows(TableObject);
		List<WebElement> ColumnObjs = null;
		String R = null;
		List<Integer> XYPoint = null;
		Boolean IsInput = false;
		Boolean Istextarea = false;
        String InputBoxActual=null;
        int CloNum = 0;
		// create map to store
        Map<List<Integer> , String> map = new HashMap<List<Integer> , String>();
        
		for (int r = 0; r < Rowcount ; r++) {
			R = String.valueOf(r+1);
			ColumnObjs = TableObject.findElements(By.xpath("./tbody/tr["+ R +"]/td"));
			//遍历列
			CloNum = 1;
			for (WebElement ColumnObj : ColumnObjs) {
				IsInput = ColumnObj.findElements(By.xpath("./input")).size() != 0;
				Istextarea = ColumnObj.findElements(By.xpath("./textarea")).size() != 0;
				
			    //如果为input或textarea输入框,则取值
			    if (IsInput||Istextarea) {
			    	InputBoxActual = ColumnObj.getText();
			    	InputBoxActual = ColumnObj.findElement(By.xpath("./child::*")).getAttribute("value") + InputBoxActual;
			    	XYPoint = new ArrayList<Integer>();
			    	//X
			    	XYPoint.add(r+1);
			    	//Y
			    	XYPoint.add(CloNum);
		                map.put(XYPoint , InputBoxActual);
		                ++CloNum;
			    }
		        else {
			    	XYPoint = new ArrayList<Integer>();
			    	//X
			    	XYPoint.add(r+1);
			    	//Y
			    	XYPoint.add(CloNum);
		                map.put(XYPoint , Lib.GetTableCellData(TableObject, r+1, CloNum).trim());
		                ++CloNum;
			    }
			}
		}
        return map;
	}

	/**
	 * @param map
	 * @param CaseName
	 * @param CheckPointName
	 * @author yulei
	 */
	private static void InputTableActualsSetToExcel(Map<List<Integer> , String> map , String CaseName , String CheckPointName) {
		OutputStream os = null;
		OutputStream PointOs = null;
		String subFix = "";
		String testNgNm = "";
        Boolean IsExist = false;
        Boolean IsSame = false;
        int inx = 0;
        Label cell = null;
        Label XYcell = null;
        int j = 0;
        
		try {
			//是否存在该Case 的CheckPoint文件
	        File dir = new File("./TableCheckPoint/");
	        File[] dir_contents = dir.listFiles();     
	        for (int i = 0; i < dir_contents.length; i++) {
	            if (dir_contents[i].getName().equals(CaseName + ".xls"))
	                 IsExist = true;
	                }

	        if (!IsExist) {
			   os = new FileOutputStream("./TableCheckPoint/" + CaseName + ".xls");
			   // 创建一个可写的Workbook
			   WritableWorkbook wwb = Workbook.createWorkbook(os);
//			   wwb.removeSheet(1);
//			   wwb.removeSheet(2);
			   WritableSheet sheet = wwb.createSheet(CheckPointName , 0);
               //循环遍历map取值并输入到excel对应格中
			   
			   for(Map.Entry<List<Integer>, String> entry: map.entrySet())
	              {
	            	  cell = new Label(entry.getKey().get(1) , entry.getKey().get(0) , entry.getValue());
	            	  sheet.addCell(cell);
	            	  XYcell = new Label(j, 314, entry.getKey().get(0)+","+entry.getKey().get(1));
	            	  sheet.addCell(XYcell);
	            	  ++j;
	              }
//			          System.out.println(sheet.getColumns());  
			   wwb.write();
			   wwb.close();
			 //存在该Case 的CheckPoint文件  
			}else {
				// 获得原始文档
		       Workbook wb = Workbook.getWorkbook(new File("./TableCheckPoint/" + CaseName + ".xls")); 
		       WritableWorkbook wwb = Workbook.createWorkbook(new File("./TableCheckPoint/" + CaseName + ".xls"),wb);
		       WritableSheet[] sheetlist = wwb.getSheets();
		          //查找是否有同名检查点
		          for (WritableSheet writableSheet : sheetlist) { 
//		        	  System.out.println(writableSheet.getName());
		     	     if (writableSheet.getName().equals(CheckPointName)) {
		     	  	      IsSame = true;
		     	  	      break;
			 	     }  
		     	    ++inx;
			      }
		        //是否有同名检查点
		          if (IsSame) {
		        	  //检查点同名则修改检查点内容
		        	  WritableSheet sheet = wwb.getSheet(inx);
		        	//clear all cells
		        	  for (int i = sheet.getRows()-1; i >= 0; i--) {
						sheet.removeRow(i);
					  }  
		        	  //循环遍历map取值并输入到excel对应格中
		              for(Map.Entry<List<Integer>, String> entry: map.entrySet())
		              {
		            	  cell = new Label(entry.getKey().get(1) , entry.getKey().get(0) , entry.getValue());
		            	  sheet.addCell(cell);
		            	  XYcell = new Label(j, 314, entry.getKey().get(0)+","+entry.getKey().get(1));
		            	  sheet.addCell(XYcell);
		            	  ++j;
		              }
				  } else {
					 //检查点不同名则新建检查点sheet
			          WritableSheet sheet = wwb.createSheet(CheckPointName , sheetlist.length);
			          sheet.setName(CheckPointName);
			          //clear all cells
		        	  for (int i = sheet.getRows()-1; i >= 0; i--) {
						sheet.removeRow(i);
					  }  
		        	  //循环遍历map取值并输入到excel对应格中
		              for(Map.Entry<List<Integer>, String> entry: map.entrySet())
		              {
		            	  cell = new Label(entry.getKey().get(1) , entry.getKey().get(0) , entry.getValue());
		            	  sheet.addCell(cell);
		            	  XYcell = new Label(j, 314, entry.getKey().get(0)+","+entry.getKey().get(1));
		            	  sheet.addCell(XYcell);
		            	  ++j;
		              }
				    }
				   wwb.write();
				   wwb.close();
			 }

		} catch (Exception e) {
			System.out.println("InputTableActualsSetToExcel error");
		}
		
	}
    
	public static void TableCheckPoint(WebElement Obj , String CaseName, String CheckPointName) {
		String TableCheckPointEnable = PropertiesDataProvider.getTestData("config/config.properties", "TableCheckPointEnable");
		Map<List<Integer> , String> DataSet = null;
		String Expected = "";
		String Actualed = "";
	   try {
		switch (TableCheckPointEnable) {
		case "0":
	        DataSet = Lib.GetTableActualsSet(Obj);
		     Lib.InputTableActualsSetToExcel(DataSet, CaseName, CheckPointName);
			break;

		case "1":
			Map<List<Integer> , String> ExpectedDataSetMap = new HashMap<List<Integer> , String>();
			List<Integer> ExpectedXYPoint = null;
			String[] tempXYPoint = null;
			String XYCell = "";
	        DataSet = Lib.GetTableActualsSet(Obj);
		    Workbook wb = Workbook.getWorkbook(new File("./TableCheckPoint/" + CaseName + ".xls")); 
            Sheet sheet = wb.getSheet(CheckPointName);
            
            //将Excel中的数据转换为hashmap
            for (int i = 0; i < sheet.getColumns(); i++) {
            	ExpectedXYPoint = new ArrayList<Integer>();
				XYCell = sheet.getCell(i, 314).getContents();
				tempXYPoint = XYCell.split(",");
				for (String xandy : tempXYPoint) {
					ExpectedXYPoint.add(Integer.valueOf(xandy));
				}
				ExpectedDataSetMap.put(ExpectedXYPoint, sheet.getCell(ExpectedXYPoint.get(1), ExpectedXYPoint.get(0)).getContents());
			}
            
            for (Map.Entry<List<Integer>, String> ExpectedDataSetMapEntry : ExpectedDataSetMap.entrySet()) {
            	Actualed = DataSet.get(ExpectedDataSetMapEntry.getKey()); 
            	Expected = ExpectedDataSetMapEntry.getValue();
 			    assertEquals(Actualed, Expected, CheckPointName + "\n["+ ExpectedDataSetMapEntry.getKey()+"]");
 			    DataSet.remove(ExpectedDataSetMapEntry.getKey());
			}
            //如果不为空则实际值多出
            assertTrue(CheckPointName+"\nActuals is more than Expects.Please review the case,if need to update?", DataSet.isEmpty());
			break;
		}
		
	   } catch (Exception e) {
			// TODO: handle exception
	   }
	}
	
	public static void SetInputBoxValue(WebDriver dr,By by,String value) {
	     JavascriptExecutor jse = (JavascriptExecutor)dr;
	     jse.executeScript("arguments[0].value='"+ value +"';", dr.findElement(by));
	     ChkProperty(dr, by, "value", value);
	}
	
	private static void CompareTableDatas(List<String> TableActuals, List<String> TableExpecteds) {
			assertEquals(TableActuals, TableExpecteds);
	}
	/**
	 * @param TableObject
	 * @param Id historyid
	 * @return int row
	 * @author yulei
	 */
	public static int GetTableRowById(WebElement TableObject, String Id)
    {
		int row = -1;
		String string;
		for (int i = 0; i < GetTableRows(TableObject); i++) {
//			string = TableObject.findElement(By.xpath(".//tbody/tr["+ (i+1) +"]/td[2]")).getAttribute("innerText");
		  if(Id.equals(TableObject.findElement(By.xpath(".//tbody/tr["+ (i+1) +"]/td[1]")).getAttribute("innerText"))) {
				row = i+1;
				break;
		  }
		}
        return row;
    }
	
	/**
	 * 
	 * @param TableObject table对象
	 * @param row
	 * @param column
	 * @return WebElement cell对象
	 */
	public static WebElement GetTableCellObj(WebElement TableObject, int row, int column)
    {
		WebElement CellObj = null;
        String xpath=".//tbody/tr["+row+"]/td["+column+"]";
        CellObj = TableObject.findElement(By.xpath(xpath));
        return CellObj;
    }
	
	
	/**
	 * 切换窗口（当前窗口为2个）
	 * @param driver
	 */
	public static void changeWindow(WebDriver driver) { 		
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄

		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;// 跳出本次循环，继续下个循环
			}
			try {
				WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
			    System.out.println("New page title is:" + window.getTitle());
			} catch (Exception e) {
				MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "Switch to new window", "Can not switch to new window") );

			}
			// window.close();//关闭当前焦点所在的窗口
		}
		// driver.switchTo().window(currentWindow);//回到原来页面
	}

	public static void SwitchToFrame(WebDriver driver,String FrameId) {
		 Boolean yBoolean = Lib.isDisplayed(driver,By.xpath("//div[@id='page-logo-header']"), true, 3);
		//如果不是top frame，则跳出到top frame，然后再定位frame
			if (yBoolean) {
				driver.switchTo().frame(FrameId);
			} else {
				driver.switchTo().defaultContent();
				Lib.wait_Sleep(2000);
	            if(FrameId.equals("moduleFrame")) {
	            	driver.switchTo().frame("moduleFrame");
	            }
	            else {
	            	driver.switchTo().frame("moduleFrame");
	            	Lib.wait_Sleep(3000);
                	driver.switchTo().frame(FrameId);
	            }
			}
	}
	
	public static void ChkImportDataBase(WebDriver driver, String[][] TableExpected) {
		int TablesNum = TableExpected.length;
		int RowNum = TableExpected[0].length;

        for (int itar = 0 ; itar<=TablesNum-1 ; itar++) {
            WebElement Import_DataTable = driver.findElement(AppElements.ImportDataBaseWindow).findElement(By.xpath(".//div[starts-with(@class,'dbinfo')][@dborder='"+itar+"']"));
          	List<String> TableActedValue = new ArrayList();
          	for(int i= 0 ; i<=RowNum-1 ; i++) {
          		String divindex =  String.valueOf(i+1);
	            	String ColName = Import_DataTable.findElement(By.xpath(".//div[@class='dbitem']["+divindex+"]/label")).getText();
	            	String ColValue = Import_DataTable.findElement(By.xpath(".//div[@class='dbitem']["+divindex+"]/input")).getAttribute("value");
	            	ColName = ColName.trim();
	            	ColValue = ColValue.trim();
	            	String colNameColvalue =ColName.concat(ColValue);
	            	TableActedValue.add(colNameColvalue);
          	}
          	//检查期望值
          	for(int i= 0;i<= 6;i++) {       	
          		MMDriver.softAssert.assertTrue(TableActedValue.contains(TableExpected[itar][i]), ExceptionMessage(new Exception(), TableExpected[itar][i], TableActedValue.get(i)));

          	}
          	
			}
	}
	
	/**
	 * 
	 * @param Data_table  
	 * @param row 从1开始
	 * @param ExpectedValue 期望值列的顺序不能错
	 */
	public static void ChkFileTableDataByRow(FileListTable Data_table, int row, String [] ExpectedValue) {
		if (!ExpectedValue[0].equals("~")) {
			MMDriver.softAssert.assertEquals(Data_table.getCellData(row, 2).trim() , ExpectedValue[0] , ExceptionMessage(new Exception(), ExpectedValue[0], Data_table.getCellData(row, 2)));
		}
		if (!ExpectedValue[1].equals("~")) {
			MMDriver.softAssert.assertEquals(Data_table.getCellData(row, 4).trim() , ExpectedValue[1] , ExceptionMessage(new Exception(), ExpectedValue[1], Data_table.getCellData(row, 4)));
		}
	    if (!ExpectedValue[2].equals("~")) {
			MMDriver.softAssert.assertEquals(Data_table.getCellData(row, 5).trim() , ExpectedValue[2] , ExceptionMessage(new Exception(), ExpectedValue[2], Data_table.getCellData(row, 5)));
	    }
		if (!ExpectedValue[3].equals("~")) {
			MMDriver.softAssert.assertEquals(Data_table.getCellData(row, 6).trim() , ExpectedValue[3] , ExceptionMessage(new Exception(), ExpectedValue[3], Data_table.getCellData(row, 6)));		
		}
	}

	public static void ChkSearchResults(WebDriver driver,List<String> expecteds) {
		List<WebElement> results = null;
		Boolean Y = true;
	    results = driver.findElements(AppElements.Label_Content_resultView_s);
		List<String> Actualeds = new ArrayList<>();
		for (WebElement result : results) {
			Actualeds.add(result.getAttribute("textContent"));
		}
	    
		for (String expected : expecteds) {
			Y = Actualeds.contains(expected);
			if (!Y) {
				MMDriver.softAssert.fail(ExceptionMessage(new Exception(),expected, expected+"not exist in the Search list"));

			}
		}

	}
	
	public static Boolean IsExpanded(WebDriver driver,By ArrowObj) {
		Boolean Y = false;
		try {
			String s = driver.findElement(ArrowObj).getAttribute("class");
			if (s.contains("expanded")) {
				Y = true;
			}
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(new Exception(), "Arrow is exist in the Page", "Arrow is not exist in the Page"));

		}
		return Y;
	}
	
	public static Boolean ExpandNode(WebDriver driver,By by) {
		if (!Lib.IsExpanded(driver, by)) {
//			WebDriverWait wait = new WebDriverWait(driver,3);
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			Lib.wait_Sleep(1000);
			driver.findElement(by).click();
            return true;		
        }
		return false;
	}
	
	public static Boolean CollapseNode(WebDriver driver,By by) {
		if (Lib.IsExpanded(driver, by)) {
	        Lib.wait_Sleep(1000);
			driver.findElement(by).click();
            return true;		
        }
		return false;
	}

	
	public static void assertNull(Object obj , String message) {
		MMDriver.softAssert.assertNull(obj, message);		
	}
	
	public static void assertNull(Object obj) {
		MMDriver.softAssert.assertNull(obj, ExceptionMessage(new Exception(), "Object is exist in the Page", "Object is not exist in the Page"));		
	}
	
	public static void assertfail(String actual , String exp) {
		MMDriver.softAssert.fail(ExceptionMessage(new Exception(),exp, actual)); 		
	}
	
	public static void assertfail(String actual , String exp ,String objectname) {
		MMDriver.softAssert.fail(objectname + " " + ExceptionMessage(new Exception(),exp, actual)); 		
	}
	
	public static void assertSame(Object actual , Object exp) {
		MMDriver.softAssert.assertSame(actual , exp , ExceptionMessage(new Exception(), "Object is exist in the Page", "Object is not exist in the Page"));		
	}
	
	public static void assertEquals(String actual , String exp) {
			if (!exp.equals("~")) {		
				MMDriver.softAssert.assertEquals(actual , exp , 
						ExceptionMessage(new Exception()));
			}
	}
	
	public static void assertEquals(int actual , int exp) {
			MMDriver.softAssert.assertEquals(actual , exp , 
					ExceptionMessage(new Exception(),exp, actual));	
	}
	
	public static void assertEquals(String actual, String exp, String Checkpoint) {
		MMDriver.softAssert.assertEquals(actual , exp , 
				Checkpoint.concat(ExceptionMessage(new Exception(),exp, actual)));			
	}
	
	public static void assertTrue(boolean condition) {
		MMDriver.softAssert.assertTrue(condition, ExceptionMessageFormat(new Exception(), "True", "False"));	
//		MMDriver.softAssert.assertTrue(condition, ExceptionMessage(new Exception(), "True", "False") + "gui_start ");			
	}
	
	public static void assertFalse(boolean condition) {
		MMDriver.softAssert.assertFalse(condition, ExceptionMessageFormat(new Exception(), "False", "True"));	
//		MMDriver.softAssert.assertFalse(condition, ExceptionMessage(new Exception(), "False", "True") + "gui_start ");			
	}
	
	public static void assertTrue(String Checkpoint , boolean condition) {
		MMDriver.softAssert.assertTrue(condition, ExceptionMessageFormat(new Exception(), "True", "False" ,Checkpoint));			
//		MMDriver.softAssert.assertTrue(condition, ExceptionMessage(new Exception(), "True", "False") + "gui_start " + Checkpoint);			
	}

	public static void assertEquals(Object actual , Object exp) {
		MMDriver.softAssert.assertEquals(actual, exp ,ExceptionMessageFormat(new Exception(), exp.toString(), actual.toString()));			
//		MMDriver.softAssert.assertEquals(actual, exp ,ExceptionMessage(new Exception(), exp.toString(), actual.toString()));			
	}
	
	public static Boolean IsEnableStatus(WebDriver driver) {
		try {
			
	        WebElement webElement =  driver.findElement(AppElements.WebTest_value_Status);
	        String colorRGB = webElement.getCssValue("background-color");
	        if (colorRGB.equals("rgba(33, 150, 243, 1)")) {
				return true;
			}
        
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(new Exception(),"SelectBox Status is found" , "SelectBox Status not found"));
		}
        
        return false;
        //rgba(204, 204, 204, 1) is Gray;
        //rgba(33, 150, 243, 1) is blue;
	}
	
	
    public static void highlight(WebDriver driver, By element) {
    	WebElement ele = driver.findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" +
        "original_style = element.getAttribute('style');" +
        "element.setAttribute('style', original_style + \";" +
        " border: 2px solid red;\");" +
        "setTimeout(function(){element.setAttribute('style', original_style);}, 60000);", ele);
    }
    
    public static void highlight(WebDriver driver, WebElement element) {
    	try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("element = arguments[0];" +
            "original_style = element.getAttribute('style');" +
            "element.setAttribute('style', original_style + \";" +
            " border: 2px solid red;\");" +
            "setTimeout(function(){element.setAttribute('style', original_style);}, 60000);", element);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	
    public static String ExceptionMessage(Exception e,String Exp, String Actual) {
    	String s = "";
    	s = "@@line_start [" + e.getStackTrace()[1].getLineNumber() + "] line_end; expected ["+Exp+"] but found ["+Actual+"]";
//    	s = "@@\nline_start [" + e.getStackTrace()[1].getLineNumber() + "] line_end;";
        return s;
	}
    
    public static String ExceptionMessage(Exception e) {
    	String s = "";
//    	s = "@@\nline_start [" + e.getStackTrace()[1].getLineNumber() + "] line_end; expected ["+Exp+"] but found ["+Actual+"]";
    	s = "@@line_start [" + e.getStackTrace()[1].getLineNumber() + "] line_end;";
        return s;
	}
    
    
    public static String ExceptionMessage(Exception e,int Exp, int Actual) {
    	String s;
    	s = "@@line_start [" + e.getStackTrace()[1].getLineNumber() + "] line_end; expected ["+Exp+"] but found ["+Actual+"]";
        return s;
	}
    
    public static String ExcptionMessageRejector(Exception e,String filterkeyword) {
    	String s = "";
		StackTraceElement[] stackTraceElements = e.getStackTrace();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			if (stackTraceElement.getClassName().contains(filterkeyword)) {
				s = "@@line_start [" + stackTraceElement.getLineNumber()+ "] line_end;";
				break;	
			} 
		}
		return s;
	}
    
    /**
     * 
     * @param driver
     * @param AppPath 绝对路径
     * @return WebElement
     */
	public static WebElement DirFile(WebDriver driver, String AppPath) {
		String[] files = AppPath.split("/");
		List<WebElement> nodes = null;
		String node_Name = "";
		WebElement NodeElement = null;
		WebElement TreeRoot = null;
		WebElement arrow = null;
		Boolean yBoolean;
		Actions actions = new Actions(driver);
		
	try {
        TreeRoot = driver.findElement(By.xpath("//ul[@id='fileTree']/li"));
		for (String fileName : files) {
			//是否有展开箭头
			yBoolean = isExist(TreeRoot.findElement(By.xpath("./div/span[starts-with(@class,'tree-hit')]")));
			if (yBoolean) {
				arrow = TreeRoot.findElement(By.xpath("./div/span[starts-with(@class,'tree-hit')]"));
				//判断并展开对应的文件树形结构
		        Lib.wait_Sleep(1000);
				if (arrow.getAttribute("class").endsWith("collapsed")||arrow.getAttribute("class").endsWith("collapsed-hover")) {
					actions.moveToElement(arrow);
					actions.click();
					actions.perform();
				}
			}
	        Lib.wait_Sleep(1000);
			nodes = TreeRoot.findElements(By.xpath("./ul/li"));

			if (nodes.size()!=0) {
				//遍历目录
		        for (WebElement node : nodes) {
					node_Name = node.getAttribute("textContent");
					if (node_Name.startsWith(fileName)) {
//					if (node_Name.equals(fileName)) {	
						TreeRoot = node;
//						NodeElement = node.findElement(By.xpath("./div/span[starts-with(@class,'tree-title')]"));
						NodeElement = node.findElement(By.xpath("./div"));
		                break;
					}
					NodeElement = null;
				 }
			 }else {
				NodeElement = null;
			}	 
		}
	 } catch (Exception e) {
		 MMDriver.softAssert.fail(ExceptionMessageFormat(e, "" , "File not found" , AppPath));
//		 MMDriver.softAssert.fail(ExceptionMessage(e, "" , "File not found")+"gui_start "+AppPath+ "gui_end");
		 return NodeElement;
	 }
	return NodeElement;
	}
	
    /**
     * Switch console tab
     * @param driver
     */
	public static void Switch_ConsoleTab(WebDriver driver, By by) {
//		while  (Lib.isExist(driver, AppElements.ZebraDialog_Close)) 
//		{
//			driver.findElement(AppElements.ZebraDialog_Close).click(); 
//			Lib.wait_Sleep(10);
//		}
		driver.findElement(by).click();
		Lib.wait_Sleep(1000);
	}

    /**
     * 清理console
     * @param driver
     */
	public static void Clear_ConsoleMsg(WebDriver driver) {
		Lib.wait_Sleep(3000);
		List<WebElement> msgs = driver.findElement(AppElements.Console_Window).findElements(By.xpath(".//*"));
		int times = 0; 
		
        while (times < 2 && !msgs.isEmpty()) {
    		driver.findElement(AppElements.button_ConsoleClear).click();
    		Lib.wait_Sleep(1000);
    		msgs = driver.findElement(AppElements.Console_Window).findElements(By.xpath(".//*"));
    		++times;
        }
        
//		if (!msgs.isEmpty()) {				
//			MMDriver.softAssert.fail("The line number is " + new Exception().getStackTrace()[1].getLineNumber() + "; Clear console window failed!Times is out!");
//		}
	}
	
	public static void CheckConsoleMsg(WebDriver dr , String value) {
		List<WebElement> ConsoleMsgs = null;
		String actualValue = "";
		Boolean IsFound = false;
		int lootime = 1;
		
//		if (!Lib.isExist(dr, AppElements.tab_Console_selected)) {
//			dr.findElement(AppElements.tab_Console).click();
//		}
		
		if (!Lib.isExist(dr, AppElements.Console_Window)) {
			dr.findElement(AppElements.Btn_Console_op).click();
		}
		
		checkPageIsReady(dr);
		while (!IsFound && lootime<=10) {
    		Lib.wait_Sleep(1500);
    		try {  		
    		   if (!dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/p")).isEmpty()) {
    			   ConsoleMsgs = dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/p"));
			   }	
			} catch (Exception e) {
			}
    		try {
			   if (!dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/h4")).isEmpty()) {
				   ConsoleMsgs.addAll(dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/h4")));
			   }
			} catch (Exception e) {
//				ConsoleMsgs.add(ConsoleMsgs.get(1));
			}
    		try {
			   if (!dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/p")).isEmpty()) {
				   ConsoleMsgs.addAll(dr.findElements(By.xpath("//div[@id='eastmessageListContainer']/ul[@id='eastmessageList']/p")));
			   }
			} catch (Exception e) {
//				ConsoleMsgs.add(ConsoleMsgs.get(1));
			}
			if (ConsoleMsgs.size()<1) {
				continue;
			}
			
			for (int i = ConsoleMsgs.size()-1 ; i >= 0; i--) {
				try {
			       actualValue = ConsoleMsgs.get(i).getAttribute("textContent");
				} catch (Exception e) {
					
				}
			    actualValue = actualValue.trim();
			    if (actualValue.contains(value)) {
			    	IsFound = true;
			    	break;
				}
//			    ConsoleMsgs.clear();
			}
			++lootime;
		}
		
		if (!IsFound) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(), "Not found", value));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(),"Not found", value)+"gui_start ");
		}
		else { 
//			assertTrue(IsFound);			 
		}
		
	}
	
	public static void CheckConsoleErrorMsg(WebDriver dr , String value) {
		List<WebElement> ConsoleMsgs = null;
		String actualValue = "";
		Boolean IsFound = false;
		int lootime = 1;
			
		if (Lib.isExist(dr, AppElements.problems_Window_Cl)) {
			dr.findElement(AppElements.tab_problems).click();
		}
		
		checkPageIsReady(dr);
		while (!IsFound && lootime<=10) {
    		Lib.wait_Sleep(1500);
			ConsoleMsgs = dr.findElements(By.xpath("//div[@id='east_error']//ul[@id='east_errorlist']/p"));
			if (!dr.findElements(By.xpath("//div[@id='east_error']//ul[@id='east_errorlist']/h4")).isEmpty()) {
				ConsoleMsgs.addAll(dr.findElements(By.xpath("//div[@id='east_error']//ul[@id='east_errorlist']/h4")));
			}			
			for (int i = ConsoleMsgs.size()-1 ; i >= 0; i--) {
				try {
				       actualValue = ConsoleMsgs.get(i).getAttribute("textContent");
					} catch (Exception e) {
						
					}
			    actualValue = actualValue.trim();
			    if (actualValue.contains(value)) {
			    	IsFound = true;
			    	break;
				}
			}
			++lootime;
		}
		
		if (!IsFound) {
			MMDriver.softAssert.fail(ExceptionMessageFormat(new Exception(),"Not found", value));
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(),"Not found", value) + "gui_start ");
		}
		else { 
			assertTrue(IsFound);			 
		}
		
	}
	
	public static WebElement GetAutoCompleteObj(WebDriver dr, int row) {
		WebElement ele = null;
		try {
			ele =dr.findElement(By.xpath("//ul[@id='AutoCompleteMenu']/li["+ row +"]//strong")); 	
			return ele;
		} catch (Exception e) {
//			MMDriver.softAssert.fail(ExceptionMessage(new Exception(),"", "Not found"));
			return null;
		}
	}
	
	public static WebElement GetAutoCompleteObjByName(WebDriver dr, String Name){
		List<WebElement> eles = null;
		WebElement ele = null;
//		wait_Sleep(2000);
//			dr.findElements(By.xpath("//ul[@id='AutoCompleteMenu']/li["+ row +"]//strong")); 
		try {
			eles =dr.findElements(By.xpath("//ul[@id='AutoCompleteMenu']/li//strong")); 	
			for (WebElement element : eles) {
//				System.out.println(element.getText());		
				if (element.getAttribute("innerText").equals(Name)) {
					ele = element;
					break;
				}
			}
		} catch (Exception e) {
			return ele;
		}
			return ele;
	}
	
    public static WebElement GetAutoCompleteObjRedWord(WebDriver driver, String Name) {
    	WebElement ele = null;
    	try {
    	   ele =GetAutoCompleteObjByName(driver, Name).findElement(By.xpath(".//span[@style='color:red;']"));
		} catch (Exception e) {  
		}
 	   return ele;
    }
		
    public static WebElement GetAutoCompleteObjRedWord(WebDriver driver, int row) {
    	WebElement ele = null;
    	try {
    	   ele =GetAutoCompleteObj(driver, row).findElement(By.xpath(".//span[@style='color:red;']"));
    	   return ele;
		} catch (Exception e) {
		   return ele;
		}
    }
	
	public static WebElement GetChannel(String ChannelName) {
		WebElement ele = null;
//		ele = 	
		return ele;
	}
	
	public static List<String> getDiffrent(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<String>();
//        long start = System.currentTimeMillis();
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            Integer count = map.get(string);
            if (count != null) {
                map.put(string, ++count);
                continue;
            }
            map.put(string, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
//        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;
    }
	
	public static void RestoreRex(WebDriver driver, String filepath) {
		try {
		SwitchToFrame(driver, "moduleFrame");
        mouseRightClick(driver, DirFile(driver, filepath));
        wait_Sleep(2000);
        if (isExist(driver, AppElements.RIGHTCLICK_Document_Menu_Discard)) {
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
			wait_Sleep(500);
			driver.findElement(AppElements.Discard_OK).click();
		}
		checkPageIsReady(driver);
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(e,"", "Restore "+filepath+"failed."));
		}
	}
	
	public static void CheckOutRex(WebDriver driver, String filepath) {
		try {
	    checkPageIsReady(driver);
		SwitchToFrame(driver, "moduleFrame");
        mouseRightClick(driver, DirFile(driver, filepath));
        if (isExist(driver, AppElements.RIGHTCLICK_Document_Menu_Checkout)) {
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Checkout).click();
		}else {
			driver.findElement(AppElements.RIGHTCLICK_Document_Menu_Discard).click();
			driver.findElement(AppElements.Discard_Cancel).click();
		}
		} catch (Exception e) {
			MMDriver.softAssert.fail(ExceptionMessage(e,"", "Checkout "+filepath+"failed."));
		}
	}
	/**
	 * @param driver
	 * @param context Unit context.
	 * @param startwith begin with 0.
	 * @param longth
	 * @param ColorRGB 
	 * @author yulei
	 */
	public static void SetWordColor(WebDriver driver, String context, int startwith, int longth,String ColorRGB) {
		WebElement Unit = null;
		Actions action = new Actions(driver);
		FlowUnit fut = new FlowUnit(driver);
		Unit = fut.GetObjByContent(context);
		action.doubleClick(Unit);
		action.sendKeys(Keys.ARROW_LEFT);
		action.perform();
		for (int i = 0; i < startwith; i++) {
			action.sendKeys(Keys.ARROW_RIGHT);
		}
		action.keyDown(Keys.SHIFT);
		for (int i = 0; i < longth; i++) {
			action.sendKeys(Keys.ARROW_RIGHT);
		}
		action.keyUp(Keys.SHIFT);
		action.perform();
		driver.findElement(AppElements.REXTopbar_Format).click();
		wait_Sleep(500);
		driver.findElement(AppElements.REXTopbar_SetFontColor).click();
		wait_Sleep(500);
		driver.findElement(AppElements.SetFontColorRGB(ColorRGB)).click();
		driver.findElement(AppElements.SetFontColorPage_Apply).click();
		wait_Sleep(500);
		action.click(Unit);
		action.sendKeys(Keys.ESCAPE);
		action.perform();
	}
	
	public static void SendKeysOnebyOne(Actions action , String str  ) {
		 char[] characters= null;
		 characters = str.toCharArray();
		 for (char c : characters) {
			  action.sendKeys(Character.toString(c));
			  wait_Sleep(400);
		 }
	}
	

	
	
	
	
	
//	public static void wheel_element(WebDriver driver ,WebElement element, int deltaY, int offsetX, int offsetY)
//    {
//        try{
//              String script = "var element = arguments[0];"
//                +"var deltaY = arguments[1];"
//                +"var box = element.getBoundingClientRect();"
//                +"var clientX = box.left + (arguments[2] || box.width / 2);"
//                +"var clientY = box.top + (arguments[3] || box.height / 2);"
//                +"var target = element.ownerDocument.elementFromPoint(clientX, clientY);"
//                +"for (var e = target; e; e = e.parentElement) {"
//                  +"if (e === element) {"
//                +"target.dispatchEvent(new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
//                +"target.dispatchEvent(new MouseEvent('mousemove', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
//                +"target.dispatchEvent(new WheelEvent('wheel',     {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY, deltaY: deltaY}));"
//                +"return;"
//                  +"}"
//                +"}";  
//
//              WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
//              ((JavascriptExecutor) driver).executeScript(script, parent, deltaY, offsetX, offsetY);
//            }catch(WebDriverException e)
//            {
//            }
//    }
	
	
}


