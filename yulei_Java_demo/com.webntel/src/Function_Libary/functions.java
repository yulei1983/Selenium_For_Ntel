package Function_Libary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Locale;
import java.util.Map;
import java.sql.*;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Yaml;

import Object_Repository.AdminGui;
import Object_Repository.Browser_GUI;
import Object_Repository.ChooseBox;
import Object_Repository.WebTable;
//import prepare.MMDriver;
//import utils.Lib;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class functions {
	public static int Threaddely = 2000;
	public static final String vNtelClientURL = PropertiesDataProvider.getTestData("config/config.properties", "vNtelClientURL");
	public static final String IcareURL = PropertiesDataProvider.getTestData("config/config.properties", "IcareURL");
	public static final String MetricsURL = PropertiesDataProvider.getTestData("config/config.properties", "MetricsURL");
	
	public static StringBuffer verificationErrors= new StringBuffer();
    public static final String MySQLDBdriver = PropertiesDataProvider.getTestData("config/config.properties", "MySQLDBdriver");
    public static final String MySQLDBurl =  PropertiesDataProvider.getTestData("config/config.properties", "MySQLDBurl");
    public static final String MySQLDBuser = PropertiesDataProvider.getTestData("config/config.properties", "MySQLDBuser");
    public static final String MySQLDBpassword =  PropertiesDataProvider.getTestData("config/config.properties", "MySQLDBpassword");
    
	public WebElement webelement = null;
    public WebDriver driver = null;
	public  FluentWait<WebDriver> fWait = null;
	public static SoftAssert softassert = null;

	
//	public functions(WebDriver driver)
//	{
//        this.driver = driver;
//	    this.fWait = new FluentWait<WebDriver>(driver)
//		    	.withTimeout(4, TimeUnit.SECONDS)
//		        .pollingEvery(500, TimeUnit.MILLISECONDS);
//	}
	
	public functions(WebDriver driver) throws Exception
	{
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
		fwait.withTimeout(Duration.ofSeconds(6));
		fwait.pollingEvery(Duration.ofSeconds(2));		
		fwait.ignoring(NoSuchElementException.class);
		this.fWait = fwait;
	    this.driver = driver;
//		        .ignoring(NoSuchElementException.class);
//		if (Debug_scripts.isDebug) {
//			loginNtel("jt0005");
//		}
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
    
	private  static <E> String ExceptionMessageFormat(Exception e, String exp , String actual , E by) {
		String s = "";
		if (by == null) {
			s = ExceptionMessage(e, exp, actual) + "gui_start element is null gui_end";
			return s;
		}
		s = ExceptionMessage(e, exp, actual) + "gui_start "+by.toString() + " gui_end";
		return s;
	}

	public static String ExceptionMessageFormat(Exception e, String exp , String actual) {
		String s = "";
		s = ExceptionMessage(e, exp, actual) + "gui_start "+" gui_end";
		return s;
	}
	
	public static String ExceptionMessageFormat(Exception e, Boolean exp , Boolean actual) {
		String s = "";
		s = ExceptionMessageFormat(e, exp, actual) + "gui_start "+" gui_end";
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

	public static void GetExcptionMessageFromExcptionRejector(Exception e , String declaringClassNameReg) {
		functions.softassert.fail(functions.ExcptionMessageRejector(e,declaringClassNameReg) + "gui_start " + e.toString() + " gui_end");
	}
	
	public void Enter_TN(String TN) {
		Browser_GUI.MainPage.WebEdit_TNTR(driver).sendKeys(TN);
		Browser_GUI.MainPage.WebEdit_TNTR(driver).sendKeys(Keys.ENTER);
	}
	
	public static void highlightObj(Object obj,WebDriver driver){
		JavascriptExecutor hl = (JavascriptExecutor)driver;
		hl.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", obj);
		}
	
	public void loginNtel(String UserName) throws Exception{
		driver.get(vNtelClientURL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Browser_GUI.MainPage.EditBox_ATTUID(driver).click();
        Browser_GUI.MainPage.EditBox_ATTUID(driver).sendKeys(UserName);
		Thread.sleep(Threaddely);
        Browser_GUI.MainPage.EditBox_PSW(driver).click();
        Browser_GUI.MainPage.EditBox_PSW(driver).sendKeys("12345678");
        Browser_GUI.MainPage.BTN_Login_OK(driver).click();
        Thread.sleep(2000);
//		functions fun =new functions(driver);
//		fun.fWait.until(ExpectedConditions.visibilityOf(Browser_GUI.MainPage.Title_Error_MessageBox(driver)));
//		fun.highlightObj(Browser_GUI.MainPage.Title_Error_MessageBox(driver));
		Browser_GUI.MainPage.Error_MessageBox_OK(driver).click();
        Thread.sleep(Threaddely);
        
        Browser_GUI.MainPage.MenuBar_System(driver).click();
		Thread.sleep(Threaddely);
		Browser_GUI.MainPage.MenuBar_System_Demo(driver).click();
	}
	/*Function: When you logining the ntel,then relogin with other user id.
	 * 
	 * By yulei, on 05052022
	 */
	public void ReloginNtel(String UserName){
		try {
        ClearNtel(driver);
        Browser_GUI.MainPage.MenuBar_System(driver).click();
		Thread.sleep(Threaddely);
		Browser_GUI.MainPage.MenuBar_System_Exit(driver).click();
		Thread.sleep(Threaddely);
		Browser_GUI.MainPage.Exit_Yes(driver).click();
		Thread.sleep(3000);	
		Browser_GUI.MainPage.EditBox_ATTUID(driver).click();
        Browser_GUI.MainPage.EditBox_ATTUID(driver).sendKeys(UserName);
		Thread.sleep(Threaddely);
        Browser_GUI.MainPage.EditBox_PSW(driver).click();
        Browser_GUI.MainPage.EditBox_PSW(driver).sendKeys("12345678");
        Browser_GUI.MainPage.BTN_Login_OK(driver).click();
        Thread.sleep(2000);
		Browser_GUI.MainPage.Error_MessageBox_OK(driver).click();
        Thread.sleep(Threaddely);
        
        Browser_GUI.MainPage.MenuBar_System(driver).click();
		Thread.sleep(Threaddely);
		Browser_GUI.MainPage.MenuBar_System_Demo(driver).click();
		} catch (Exception e) {
		    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  ""   , "ReloginNtel failed"));
		}
	}
	
	public Boolean update_ntel_dbase(String sql , String TableName) {
		try {
				Browser_GUI.MainPage.MenuBar_Table(driver).click();
				Browser_GUI.MainPage.Personalization_Admin(driver).click();
		        Thread.sleep(3000);
				String mainpageHandleId = functions.SwitchToNewWindowAndRecordOldOne(driver);
				functions fun = new functions(driver);
			    boolean IsEdited = fun.IsExist(By.xpath("//span[text()='"+TableName+"*']"));
			    if (!IsEdited) {
			    	driver.findElement(By.xpath("//span[text()='"+TableName+"']")).click();
			        Thread.sleep(2000);
			    	functions.mouseRightClick(driver, By.xpath("//span[text()='"+TableName+"']"));
			    	Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_rightmenu_Edit(driver).click();
				}
		        functions.Excute_SQL(sql);
		        driver.close();
		        driver.switchTo().window(mainpageHandleId);
		        return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 *@author yulei 
	 *@param sql SQL��� inert or update or delete.
	 *@return int 0  �޸�ʧ�ܣ�!0 �޸ĳɹ���������
	 */
	public static int Excute_SQL(String sql) {
		int flag = 0;
        try {
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection(MySQLDBurl, MySQLDBuser, MySQLDBpassword);
			PreparedStatement prestatment = conn.prepareStatement(sql);
			flag = prestatment.executeUpdate();
			if(prestatment!=null){
				prestatment.close();
				if(conn!=null){
					conn.close();
				}
			}
			return flag;
		} catch (Exception e) {
			return flag;	
		}
	}
		
	public void RollBackAll() {	
		try {
		Thread.sleep(500);
		Set<String> handles = driver.getWindowHandles();
		Boolean PadminExist = false;
		for (String s : handles) {
			driver.switchTo().window(s);  
			if (driver.getTitle().contains("Ntelagent Personalization Admin")) {
				PadminExist = true;
		        Actions actions = new Actions(driver);
		        actions.moveToElement(Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_list(driver), 42,1);
		        actions.click();
		        actions.build().perform();

				Thread.sleep(500);
		        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_all(driver).click();
				Thread.sleep(2000);
		        Browser_GUI.PersonalizationAdmin.Ask_Yes(driver).click();
		        driver.close();
		        functions.switchToWindow("(DEMO)", driver);
				break;
			}
		 }
			if (!PadminExist) {	
				Thread.sleep(500);
				Browser_GUI.MainPage.MenuBar_Table(driver).click();
				Browser_GUI.MainPage.Personalization_Admin(driver).click();
				functions.switchToWindow("Ntelagent Personalization Admin", driver);
				Thread.sleep(2000);
		        Actions actions = new Actions(driver);
		        actions.moveToElement(Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_list(driver), 42 , 1);
		        actions.click();
		        actions.build().perform();

		        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_all(driver).click();
				Thread.sleep(2000);
		        Browser_GUI.PersonalizationAdmin.Ask_Yes(driver).click();
		        driver.close();
		        functions.switchToWindow("(DEMO)", driver);
			}
		} catch (Exception e) {
		    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  ""   , "Rollback failed"));
		}

	}
	
//	/**
//	 *@author yulei 
//	 *@param TableName ��Ҫ�޸ĵ�table
//	 *@param sql SQL���
//	 *@return Boolean true �޸ĳɹ���FALSE �޸�ʧ�ܣ����л���ԭ����
//	 */
//	public Boolean Update_table(String TableName,String sql) {
//		Boolean Flags = false;
//		try {
//			Thread.sleep(500);
//			Boolean Y = functions.switchToWindow("Ntelagent Personalization Admin",driver);
//			if(!Y) {
//				Browser_GUI.MainPage.MenuBar_Table(driver).click();
//				Browser_GUI.MainPage.Personalization_Admin(driver).click();
//				functions.switchToWindow("Ntelagent Personalization Admin",driver);
//			}
//			WebElement OTableName = driver.findElement(By.xpath("//span[text()='"+TableName+"']"));
//			OTableName.click();
//	        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Edit(driver).click();
//	        //String sql
//	        functions.Excute_SQL(sql);
//	        driver.close();
//	        functions.switchToWindow("(DEMO)", driver);
//		    Flags = true; 
//	   }catch (Exception e) {
//			WebElement OTableName = driver.findElement(By.xpath("//span[text()='"+TableName+"*']"));
//			String Edit_table_name = OTableName.getText();
//				   //String sql
//			functions.Excute_SQL(sql);
//			driver.close();
//			functions.switchToWindow("(DEMO)", driver);
//			Flags = true;
//			return Flags;
//		}
//		   return Flags;	
//  }
	
	


	public void Cancel_Ticket(String TN) throws Exception{
		String isdisabled = Browser_GUI.MainPage.WebEdit_TNTR(driver).getAttribute("disabled");
		if (isdisabled.compareToIgnoreCase("true")==0) {
			ClearNtel(driver);
		}
		Enter_TN(TN);
		ClearNtel(driver);
	}
	
	
	public void ClearNtel(WebDriver driver){
		try {
			Boolean Y = IsExist(driver.findElement(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div")));
			if(Y) {
			    Browser_GUI.MainPage.AM_OK(driver).click();	
		    }
			   Y =IsExist(By.xpath("//span[contains(text(),'Please select an entry from the tree list')]//ancestor::table[3]//table//table[normalize-space()='OK']"));
			if(Y) {
			    driver.findElement(By.xpath("//span[contains(text(),'Please select an entry from the tree list')]//ancestor::table[3]//table//table[normalize-space()='OK']")).click();	
		    }
			
		if (Browser_GUI.MainPage.Submit_AgMsg_Yes(driver) != null) {
			Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click();
		}
		if (Browser_GUI.MainPage.Submit_APRO_OK(driver) != null) {
			Browser_GUI.MainPage.Submit_APRO_OK(driver).click();
		}
		if (Browser_GUI.MainPage.Submit_TankYou_OK(driver) != null) {
			Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();
		}
		
		

		   } catch (Exception e) {
			   // TODO: handle exception
		   }
		finally {
			try {
				Thread.sleep(Threaddely);
		        Browser_GUI.MainPage.Cancel(driver).click();
				Thread.sleep(Threaddely);
				Browser_GUI.MainPage.Cancel_Customer_Error(driver).click();
				Thread.sleep(Threaddely);
				Browser_GUI.MainPage.Cancel_Message_Yes(driver).click(); 
			} catch (Exception e2) {
			}
		}
	}
	
	
	
	public void Set_Type(String vType) throws Exception{
		Browser_GUI.MainPage.WebEdit_TYPE(driver).click();
		Browser_GUI.MainPage.TYPE_value(driver, vType).click();
	}
	
	public void Set_Action(String vAction) throws Exception{
		Browser_GUI.MainPage.WebEdit_ACTION(driver).click();
		Browser_GUI.MainPage.ACTION_value(driver, vAction).click();
	}
	
	public  void CheckPorperty(By by,String porperty,String vExpected){
        try {
			Thread.sleep(500);
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
			fwait.withTimeout(Duration.ofSeconds(6));
			fwait.pollingEvery(Duration.ofSeconds(2));		
			fwait.ignoring(NoSuchElementException.class);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(by));
 			String vActualed = driver.findElement(by).getAttribute(porperty);
 		    // <p>�����滻Ϊ���� 
             vActualed = vActualed.replaceAll("<p .*?>", "\r\n"); 
 		    // <br><br/>�滻Ϊ���� 
 			vActualed = vActualed.replaceAll("<br\\s*/?>", "\r\n"); 
 		    // ȥ��������<>֮��Ķ��� 
 			vActualed = vActualed.replaceAll("\\<.*?>", ""); 
 			//ȥ��\r
 			vActualed = vActualed.replaceAll("\r", ""); 
 			//ȥ��\n
 			vActualed = vActualed.replaceAll("\n", "");
 			//ȥ��amp;
 			vActualed = vActualed.replaceAll("amp;", "");
// 		    // ȥ���ո� 
// 	        vActualed = vActualed.replaceAll(" ", ""); 
 			if (vExpected.compareTo(vActualed)!=0) {
			    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , vActualed));
			}
// 			functions.softassert.assertEquals(vActualed, vExpected," expected [" + vExpected + "] but found [" + vActualed + "]@@\n\t");
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , "null"));
		}
}

	public  Boolean CheckPorperty(WebElement webelement,String porperty,String vExpected){
	        try {
				Thread.sleep(500);
				FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
				fwait.withTimeout(Duration.ofSeconds(6));
				fwait.pollingEvery(Duration.ofSeconds(2));		
				fwait.ignoring(NoSuchElementException.class);
				fwait.until(ExpectedConditions.visibilityOf(webelement));
	 			String vActualed = webelement.getAttribute(porperty);
	 		    // <p>�����滻Ϊ���� 
	             vActualed = vActualed.replaceAll("<p .*?>", "\r\n"); 
	 		    // <br><br/>�滻Ϊ���� 
	 			vActualed = vActualed.replaceAll("<br\\s*/?>", "\r\n"); 
	 		    // ȥ��������<>֮��Ķ��� 
	 			vActualed = vActualed.replaceAll("\\<.*?>", ""); 
	 			//ȥ��\r
	 			vActualed = vActualed.replaceAll("\r", ""); 
	 			//ȥ��\n
	 			vActualed = vActualed.replaceAll("\n", "");
	 			//ȥ��amp;
	 			vActualed = vActualed.replaceAll("amp;", "");
//	 		    // ȥ���ո� 
//	 	        vActualed = vActualed.replaceAll(" ", ""); 
	 			Boolean IsRexMatcher = vExpected.contains("regex_");
	  			if (IsRexMatcher) {	//正则比对
	  				vExpected = vExpected.replace("regex_", "");
		    		Pattern intPattern = Pattern.compile(vExpected);
			  		Matcher m = intPattern.matcher(vActualed);
		 			if (!m.matches()) {
					    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , vActualed));
					    return false;
					}else {
			 			return true;
					}
				} else {//全文比对
		 			if (vExpected.compareTo(vActualed)!=0) {
					    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , vActualed));
					    return false;
					}else {
			 			return true;
					}
				}

			} catch (Exception e) {
				functions.softassert.fail(ExceptionMessageFormat(e ,  vExpected   , "null"));
				return false;
			}
	}
	
	public void CheckBooleanTureIsPass(Boolean yBoolean){
        try {
    		if (!yBoolean) {
   			 functions.softassert.fail(ExceptionMessageFormat(new Exception() , true , false));
   		}
		} catch (Exception e) {
			 functions.softassert.fail(ExceptionMessageFormat(new Exception() , true , false));
		}
    }
	
	public void CheckBooleanFalseIsPass(Boolean yBoolean){
        try {
    		if (yBoolean) {
   			 functions.softassert.fail(ExceptionMessageFormat(new Exception() , false , true));
   		}
		} catch (Exception e) {
  			 functions.softassert.fail(ExceptionMessageFormat(new Exception() , false , true));
		}
    }
	
	public  Boolean CheckPorpertyDate(WebElement webelement,String porperty,String vExpected ,String ExpectedFormat , String ActFormat , int distance){
        try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
			fwait.withTimeout(Duration.ofSeconds(6));
			fwait.pollingEvery(Duration.ofSeconds(2));		
			fwait.ignoring(NoSuchElementException.class);
			fwait.until(ExpectedConditions.visibilityOf(webelement));
 			String vActualed = webelement.getAttribute(porperty);
 		    // <p>�����滻Ϊ���� 
             vActualed = vActualed.replaceAll("<p .*?>", "\r\n"); 
 		    // <br><br/>�滻Ϊ���� 
 			vActualed = vActualed.replaceAll("<br\\s*/?>", "\r\n"); 
 		    // ȥ��������<>֮��Ķ��� 
 			vActualed = vActualed.replaceAll("\\<.*?>", ""); 
 			//ȥ��\r
 			vActualed = vActualed.replaceAll("\r", ""); 
 			//ȥ��\n
 			vActualed = vActualed.replaceAll("\n", "");
 			//ȥ��amp;
 			vActualed = vActualed.replaceAll("amp;", "");
// 		    // ȥ���ո� 
// 	        vActualed = vActualed.replaceAll(" ", ""); 
 			Date expDate =new SimpleDateFormat(ExpectedFormat).parse(vExpected+"M");
 			Date ActDate = new SimpleDateFormat(ActFormat).parse(vActualed+"M");
 			long startTime = expDate.getTime();
 			long endTime = ActDate.getTime();
 			long IsOver15mins = Math.abs((startTime - endTime)/1000/60);
 			if (  IsOver15mins > distance ) {
 				functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  expDate.toString()   , ActDate.toString()));
			    return false;
			}else {
	 			return true;
			}
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(e ,  vExpected   , "null"));
			return false;
		}
}
	
	
	public  void CheckPorpertyWithRegex(WebElement webelement,String porperty,String vExpected, int Exoffset, int actoffset){
        try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
			fwait.withTimeout(Duration.ofSeconds(6));
			fwait.pollingEvery(Duration.ofSeconds(2));		
			fwait.ignoring(NoSuchElementException.class);
			fwait.until(ExpectedConditions.visibilityOf(webelement));
 			String vActualed = webelement.getAttribute(porperty);
 		    // <p>�����滻Ϊ���� 
             vActualed = vActualed.replaceAll("<p .*?>", "\r\n"); 
 		    // <br><br/>�滻Ϊ���� 
 			vActualed = vActualed.replaceAll("<br\\s*/?>", "\r\n"); 
 		    // ȥ��������<>֮��Ķ��� 
 			vActualed = vActualed.replaceAll("\\<.*?>", ""); 
 			//ȥ��\r
 			vActualed = vActualed.replaceAll("\r", ""); 
 			//ȥ��\n
 			vActualed = vActualed.replaceAll("\n", "");
 			//ȥ��amp;
 			vActualed = vActualed.replaceAll("amp;", "");
// 		    // ȥ���ո� 
// 	        vActualed = vActualed.replaceAll(" ", ""); 
   		    boolean IsPass = vExpected.regionMatches(Exoffset, vActualed, actoffset, vExpected.length());
 			if (!IsPass) {
			    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , vActualed));
			}
// 			functions.softassert.assertEquals(vActualed, vExpected," expected [" + vExpected + "] but found [" + vActualed + "]@@\n\t");
 			
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , "null"));
		}
}
	
	public  void CheckPorpertyWithRegex(WebElement webelement,String porperty,String vExpectedRegex){
        try {
        	boolean IsPass = false;
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
			fwait.withTimeout(Duration.ofSeconds(6));
			fwait.pollingEvery(Duration.ofSeconds(2));		
			fwait.ignoring(NoSuchElementException.class);
			fwait.until(ExpectedConditions.visibilityOf(webelement));
 			String vActualed = webelement.getAttribute(porperty);
 		    // <p>�����滻Ϊ���� 
             vActualed = vActualed.replaceAll("<p .*?>", "\r\n"); 
 		    // <br><br/>�滻Ϊ���� 
 			vActualed = vActualed.replaceAll("<br\\s*/?>", "\r\n"); 
 		    // ȥ��������<>֮��Ķ��� 
 			vActualed = vActualed.replaceAll("\\<.*?>", ""); 
 			//ȥ��\r
 			vActualed = vActualed.replaceAll("\r", ""); 
 			//ȥ��\n
 			vActualed = vActualed.replaceAll("\n", "");
 			//ȥ��amp;
 			vActualed = vActualed.replaceAll("amp;", "");
// 		    // ȥ���ո� 
// 	        vActualed = vActualed.replaceAll(" ", ""); 
 			
 	    	Pattern Pcontext = Pattern.compile(vExpectedRegex);
 	        Matcher matcher = Pcontext.matcher(vActualed);
 	        IsPass = matcher.find();

 			if (!IsPass) {
			    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpectedRegex   , vActualed));
			}
// 			functions.softassert.assertEquals(vActualed, vExpected," expected [" + vExpected + "] but found [" + vActualed + "]@@\n\t");
 			
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpectedRegex   , "null"));
		}
}
//	public void CheckPorperty(WebElement webelement,String porperty,String vExpected) throws Exception{
//		fWait.until(ExpectedConditions.visibilityOf(webelement));
//		String vActualed = webelement.getAttribute(porperty);
//		assertEquals(vActualed, vExpected," expected [" + vExpected + "] but found [" + vActualed + "]");
//}

	public void CreateReport(SoftAssert softassert) {
		softassert.assertAll();	
	}
	
	public boolean IsExist(WebElement webelement) {
		try {
			fWait.until(ExpectedConditions.visibilityOf(webelement));
			webelement.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean IsExist(WebElement webelement,By by) {
		try {
			webelement.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean IsExist(By by) {
		try {
			fWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  "Exist"   , "Not exist"));
			return false;
		}
	}
	
	public boolean IsNotExist(By by) {
		try {
			fWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
//	public static boolean IsExist(Table table) throws NoSuchElementException{
//		try {
//			int i = table.hashCode();
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
	
	public  List<String> Check_ChooseBox(List<String> args) throws Exception {
		try {
			  List<WebElement> ChooseBoxBtns = new ArrayList<WebElement>();
			  List<String> Actual_ChooseBtnNames = new ArrayList<String>();
			  List<String> Expected_BtnsName = new ArrayList<String>();
			  List<String> NeedRemoveActual = new ArrayList<String>();
			  List<String> CheckedResult = new ArrayList<String>();

			  
			  ChooseBox chooseBox= new ChooseBox(driver);
			  for (String arg : args) {
				  /**ChooseBox����ֵ��ӽ����� */
				  Expected_BtnsName.add(arg);
			}

	          ChooseBoxBtns = chooseBox.ChooseBoxBtns();
			  for(WebElement element : ChooseBoxBtns) {
				  /**ChooseBoxʵ��ֵ��ӽ����� */
				Actual_ChooseBtnNames.add(element.getText());
			  }
			  /**�Ƴ��հ�Ԫ�أ������п��ܴ���innerTextΪ������Ԫ��*/
			  for(int i = 0; i < Actual_ChooseBtnNames.size(); i++) {
				  if(Actual_ChooseBtnNames.get(i).equals("")) {
					  Actual_ChooseBtnNames.remove(i);
				  }
			  }
			  /**��Actual_ChooseBtnNames��Expected_BtnsName����Ƚ�*/	 
			  int BtnCount = Actual_ChooseBtnNames.size();
			  for(int i = 0; i<BtnCount ; i++) {
				  //�Ա���ȷ���Ƴ�����ֵ
				for(int j = 0; j< Expected_BtnsName.size(); j++) {
					if(Actual_ChooseBtnNames.get(i).equals(Expected_BtnsName.get(j))) {	
						Expected_BtnsName.remove(Actual_ChooseBtnNames.get(i));
						NeedRemoveActual.add(Actual_ChooseBtnNames.get(i));
						break;
					}

				}
			  }
			  /**ʵ��ֵ����*/
//			softassert.assertEquals(flag, 1, "expected [null] but found [ChooseButton " + ActBtnName + "]@@\n\t");
		
				  /**ʵ��ֵȱ��*/
//				for(int i = 0; i < Expected_BtnsName.size(); i++) {
//					softassert.assertNull(Expected_BtnsName.get(i), "expected [ChooseButton " + Expected_BtnsName.get(i) + "] but found [Null]@@\n\t");
//				}
			  
			  if(!Actual_ChooseBtnNames.isEmpty() || !Expected_BtnsName.isEmpty()) {
				  String tempExpected="";	
				  String acttemp = "";
				  if(!Actual_ChooseBtnNames.isEmpty()) {
					  //�Ƴ��Ա���ȷ��ʵ��ֵ
					  for (int i = 0; i < NeedRemoveActual.size(); i++) {
						  Actual_ChooseBtnNames.remove(NeedRemoveActual.get(i));
					}
					  //��ȡ����ʵ��ֵ
					  for (int i = 0; i < Actual_ChooseBtnNames.size(); i++) {
						  acttemp += Actual_ChooseBtnNames.get(i) + ",\n";
					}
					  
				  }
			      //��ȡ��������ֵ
				  if(!Expected_BtnsName.isEmpty()) {
					  for (int i = 0; i < Expected_BtnsName.size(); i++) {
						  tempExpected += Expected_BtnsName.get(i) + ",\n";
						  CheckedResult.add(0, tempExpected);
						  CheckedResult.add(1, acttemp);
	//					  softassert.assertNull(Expected_BtnsName.get(i), "expected [ChooseButton " + Expected_BtnsName.get(i) + "] but found [Null]@@\n\t");
					}  
				  }

				  return CheckedResult;
//				  functions.softassert.assertEquals(acttemp, tempExpected, "expected [ChooseButton " + tempExpected + "] but found ["+acttemp+"]@@\n\t");
			  }		  
		}
		catch (Exception e) {
			return null;
//			 functions.softassert.fail(ExceptionMessageFormat(new Exception(), "Displayed", "NotFound", args.get(0).trim()));
		}
		return null;
	 }	

	public  void Check_ChooseBoxList( String[] args) {
		try {
			ChooseBox choosebox = new ChooseBox(driver);
			functions func = new functions(driver);
			fWait.until(ExpectedConditions.visibilityOf(choosebox.ChooseBox_JTextPane()));
			
			func.CheckPorperty(choosebox.ChooseBox_JTextPane(), "textContent",
		      args[0]);
		    
		    List<String> list=Arrays.asList(args);
		    List<String> ExpectedList = new ArrayList<String>(list);
		    ExpectedList.remove(0);

				  List<WebElement> ChooseBoxBtns = new ArrayList<WebElement>();
				  List<String> Actual_ChooseBtnNames = new ArrayList<String>();
				  List<String> Expected_BtnsName = new ArrayList<String>();
				  List<String> NeedRemoveActual = new ArrayList<String>();
				  List<String> CheckedResult = new ArrayList<String>();

				  
				  ChooseBox chooseBox= new ChooseBox(driver);
				  for (String expectedlist : ExpectedList) {
					  /**ChooseBox����ֵ��ӽ����� */
					  Expected_BtnsName.add(expectedlist);
				}

		          ChooseBoxBtns = chooseBox.ChooseBoxBtns();
				  for(WebElement element : ChooseBoxBtns) {
					  /**ChooseBoxʵ��ֵ��ӽ����� */
					Actual_ChooseBtnNames.add(element.getText());
				  }
				  /**�Ƴ��հ�Ԫ�أ������п��ܴ���innerTextΪ������Ԫ��*/
				  for(int i = 0; i < Actual_ChooseBtnNames.size(); i++) {
					  if(Actual_ChooseBtnNames.get(i).equals("")) {
						  Actual_ChooseBtnNames.remove(i);
					  }
				  }
				  /**��Actual_ChooseBtnNames��Expected_BtnsName����Ƚ�*/	 
				  int BtnCount = Actual_ChooseBtnNames.size();
				  for(int i = 0; i<BtnCount ; i++) {
					  //�Ա���ȷ���Ƴ�����ֵ
					for(int j = 0; j< Expected_BtnsName.size(); j++) {
						if(Actual_ChooseBtnNames.get(i).equals(Expected_BtnsName.get(j))) {	
							Expected_BtnsName.remove(Actual_ChooseBtnNames.get(i));
							NeedRemoveActual.add(Actual_ChooseBtnNames.get(i));
							break;
						}

					}
				  }
  
				  if(!Actual_ChooseBtnNames.isEmpty() || !Expected_BtnsName.isEmpty()) {
					  String tempExpected="";	
					  String tempact = "";
					  if(!Actual_ChooseBtnNames.isEmpty()) {
						  //�Ƴ��Ա���ȷ��ʵ��ֵ
						  for (int i = 0; i < NeedRemoveActual.size(); i++) {
							  Actual_ChooseBtnNames.remove(NeedRemoveActual.get(i));
						}
						  //��ȡ����ʵ��ֵ
						  for (int i = 0; i < Actual_ChooseBtnNames.size(); i++) {
							  tempact += Actual_ChooseBtnNames.get(i) + ",\n";
						  }
					  }
				      //��ȡ��������ֵ
					  if(!Expected_BtnsName.isEmpty()) {
						  for (int i = 0; i < Expected_BtnsName.size(); i++) {
							  tempExpected += Expected_BtnsName.get(i) + ",\n";
							  CheckedResult.add(0, tempExpected);
							  CheckedResult.add(1, tempact);
						}
						  functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  CheckedResult.get(0)    , CheckedResult.get(1)));
					  }
 
				  }
		    	   
		} catch (Exception e) {
//			 functions.softassert.fail(ExceptionMessageFormat(e,  "Displayed"    , "NotFound"));
		}
		
	}
	
	/**
	 *@author yulei 
	 *@param windowTitle ��Ҫ�л��Ĵ���Title
	 *@param dr Webdriver
	 *@return Boolean true �л��ɹ���FALSE �л�ʧ��
	 */
	public static boolean switchToWindow(String windowTitle,WebDriver dr) throws Exception{   
		Thread.sleep(500);
        boolean flag = false;    
            //��ҳ�������е�windowshandle������set���ϵ���  
            Set<String> handles1 = dr.getWindowHandles(); 
            for (String s : handles1) {
            	String sTitle = dr.switchTo().window(s).getTitle();
                //�͵�ǰ�Ĵ��ڽ��бȽ������ͬ���л���windowhandle  
                //�ж�title�Ƿ��handles��ǰ�Ĵ�����ͬ  
				if (sTitle.contains(windowTitle)) {
					flag = true;
//                    System.out.println("Switch to window: " + sTitle 
//                    + " successfully!");
                    return flag;
//					break;
				}
				else {
					continue;
				}
			}
            
				return flag;    
    }

	public String get_commitment_time() {
		String get_commitment_time = Browser_GUI.MainPage.WebEdit_Commitment(driver).getAttribute("value");
        return get_commitment_time;
	}
	
	public String get_localtime_maingui() {
		assertNotNull(Browser_GUI.MainPage.topLocalTime(driver),"Not found localtimeGUI!");
		String get_localtime_maingui = Browser_GUI.MainPage.topLocalTime(driver).getText();
        return get_localtime_maingui;
	}
	
	public static Date convert_datetime_format_ntel_to_qtp(String datetime) throws ParseException {
		  datetime = datetime + "M";
		  SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy hhmma",Locale.US);
		  try {
			  Date Dt = sdf.parse(datetime);
			  return Dt;
		} catch (ParseException e) {
			
			return null;
		}
	}
	
/**
 * DateAdd(vToday, Calendar.DAY_OF_YEAR, 4)
 * @param Dt  ԭ����
 * @param CalType  �������� eg.Calendar.DAY_OF_YEAR
 * @param Num  ������
 * @return  Date ���ĺ�
 */
	public static Date DateAdd(Date Dt,int CalType, int Num) {
      Calendar c = Calendar.getInstance();
      c.setTime(Dt);
      c.add(CalType, Num);
      Date Dt1 = c.getTime();
      return Dt1;
	}
		
	/** 
	   * ��java.util.Date ��ʽת��Ϊ�ַ�����ʽ'MM-dd-yy hhmma'(12Сʱ��)<br> 
	   * ��Sat May 11 17:23:22 CST 2002 to '05-11-02 0523P'<br> 
	   * @param time Date ����<br> 
	   * @return String �ַ���<br> 
	   */  
	public static String dateToString(Date time){   
	    SimpleDateFormat formatter = new SimpleDateFormat ("MM-dd-yy hhmma"); 
	    String ctime = formatter.format(time);
	    ctime = ctime.substring(0, ctime.length()-1);
	    return ctime;  
	}  
	
	/** 
	   * ��java.util.Date ��ʽת��Ϊ�ַ�����ʽ'yyyy-MM-dd HH:mm:ss'(24Сʱ��)<br> 
	   * ��Sat May 11 17:23:22 CST 2002 to '2002-05-11 17:23:22'<br> 
	   * @param time Date ���� <br>
	   * @param format string �Զ������ʱ���ʽ<br>
	   * @return String �ַ���<br>
	   */  
	public static String dateToString(Date time,String format){   
	    SimpleDateFormat formatter = new SimpleDateFormat (format); 
	    String ctime = formatter.format(time);
	    ctime = ctime.substring(0, ctime.length()-1);
	    return ctime;  
	}
	
	/**
	 * 
	 * @param CalType  �������� eg.Calendar.DAY_OF_YEAR
	 * @param num  
	 * @return  Boolean
	 * @throws ParseException
	 */
	public Boolean set_commitment_with_CalendarType(int CalType,int num) throws ParseException {
		Boolean bool = false;
		String get_commitment = Browser_GUI.MainPage.topLocalTime(driver).getText();
		Date commit = functions.convert_datetime_format_ntel_to_qtp(get_commitment);
		commit = DateAdd(commit, CalType, num);
		get_commitment = dateToString(commit);
		Browser_GUI.MainPage.WebEdit_Commitment(driver).sendKeys(get_commitment);
		
		if(Browser_GUI.MainPage.WebEdit_Commitment(driver).getAttribute("value").equals(get_commitment)) {
			bool = true;
		}	
		return bool;
	}
	
//	'####################################################
//	'# Login_AG
//	'# Function: Login to Admin GUI.
	// return: WebDriver
//	'#  By yulei, on 04072022
//	'####################################################
	public static WebDriver Login_AG(String UserName, String PassWord, String BaseName) {
	WebDriver adminGUIDriver = WebDriver_Setup.launchBrowser();	
	adminGUIDriver.get(IcareURL);
	AdminGui.LoginPage.UserID(adminGUIDriver).sendKeys(UserName);
	AdminGui.LoginPage.PassWord(adminGUIDriver).sendKeys(PassWord);
	AdminGui.LoginPage.database(adminGUIDriver, BaseName);
	AdminGui.LoginPage.Btn_Login(adminGUIDriver).click();
	return adminGUIDriver;
	}
	
//	'####################################################
//	'# Open_EMS_LOG()
//	'# Function: Goto demo EMS Issues Log to check TR all fields’ value
//	'#  By yulei, on 04072022
//	'####################################################
	public static WebDriver Open_EMS_LOG() {
		WebDriver adminGUIDriver = Login_AG("QAVIEW", "123456", "CO");
		SwitchToFrame(adminGUIDriver, "Menu");
		AdminGui.MainPage.EMS_Issue_Admin(adminGUIDriver).click();
		AdminGui.MainPage.EMS_Issues_Log(adminGUIDriver).click();
		SwitchToFrame(adminGUIDriver, "mainFrame");
		AdminGui.MainPage.Btn_Demo(adminGUIDriver).click();
		return adminGUIDriver;
	}
	
//	'####################################################
//	'# Open_Expeditet_LOG()
//	'# Function: Goto demo Expeditet Issues Log to check TR all fields’ value
//	'#  By yulei, on 04072022
//	'####################################################
	public static WebDriver Open_Expeditet_LOG() {
		WebDriver adminGUIDriver = Login_AG("QAVIEW", "123456", "CO");
		SwitchToFrame(adminGUIDriver, "Menu");
		AdminGui.MainPage.Expedite_Admin(adminGUIDriver).click();
		AdminGui.MainPage.Expedite_Reports_Log(adminGUIDriver).click();
		SwitchToFrame(adminGUIDriver, "mainFrame");
		AdminGui.MainPage.Btn_Demo(adminGUIDriver).click();
		return adminGUIDriver;
	}
	
	public static Boolean SwitchToFrame(WebDriver driver,String FrameSrcName) {
		driver.switchTo().defaultContent();
		int size = driver.findElements(By.tagName("frame")).size();
		for (int i = 0; i < size; i++) {
//			System.out.print(driver.findElements(By.tagName("frame")).get(i).getAttribute("name"));
		    if (driver.findElements(By.tagName("frame")).get(i).getAttribute("name").equalsIgnoreCase(FrameSrcName)) {
			    driver.switchTo().frame(i);
			    return true;
	    	}         
		}
		return false;
	}
	
	public static Boolean SwitchToFrame(WebDriver driver,String Attribute,String value) {
		driver.switchTo().defaultContent();
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < size; i++) {
//			System.out.print(driver.findElements(By.tagName("frame")).get(i).getAttribute("name"));
		    if (driver.findElements(By.tagName("iframe")).get(i).getAttribute(Attribute).equalsIgnoreCase(value)) {
			    driver.switchTo().frame(i);
			    return true;
	    	}         
		}
		return false;
	}
	
	/**
	 * 切换窗口（当前窗口为2个）
	 * @param driver
	 * @return 返回初始句柄
	 */
	public static String SwitchToNewWindowAndRecordOldOne(WebDriver driver) { 	
		String currentWindow = "";
		currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;// 跳出本次循环，继续下个循环
			}
			try {
				WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
//			    System.out.println("New page title is:" + window.getTitle());
			    return currentWindow;
			} catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Switch to new window"   , "Can not switch to new window"));
				return currentWindow;
			}
			// window.close();//关闭当前焦点所在的窗口
		}
		return currentWindow;
		// driver.switchTo().window(currentWindow);//回到原来页面
	}
	
	public static void GoBackWindow(WebDriver driver, String currentWindow) { 	
			try {
				WebDriver window = driver.switchTo().window(currentWindow);// 切换到新窗口
//			    System.out.println("New page title is:" + window.getTitle());
			} catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Go back window"   , "Can not go back window"));
			}
	}
	
	public static void ClickWithJs(WebDriver driver,WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}
	
	public static String EMS_Log_TZ() {
		return "DT";
	} 

	public String get_localtime_Cal_round_dt(int hours) {	
		String strDate = "";
		String strtempDate = "";
		try {
			String localtime = get_localtime_maingui();
			Date ActDate = new SimpleDateFormat("MM-dd-yy hhmma").parse(localtime+"M");
//			long startTime = ActDate.getTime();
			ActDate = DateAdd(ActDate, Calendar.HOUR , hours);
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy hhmma");
			strtempDate = dateFormat.format(ActDate);
			strDate = strtempDate;
			if ( Integer.parseInt(strtempDate.substring(11, 13)) > 1 ) {//If more than 10mins then add 1 hours.
				ActDate = DateAdd(ActDate, Calendar.HOUR , 1);
				strDate = dateFormat.format(ActDate);
				strDate = new StringBuilder(strDate).replace(11, 13, "00").toString();
			}
			strDate = strDate.replace("M", "");
			return strDate;
		} catch (Exception e) {
			strDate = "null value";
		}
		return strDate;
	} 
	/*
	 * @TimeClass  :  eg.  Calendar.HOUR_OF_DAY
	 * @instance : eg. 1 or 2 or 3 etc.
	 * 
	 */
	public String get_localtime_Cal_dt( int TimeClass , int instance) {	
		String strDate = "";
		try {
			String localtime = get_localtime_maingui();
			Date ActDate = new SimpleDateFormat("MM-dd-yy hhmma").parse(localtime+"M");
//			long startTime = ActDate.getTime();     Calendar.HOUR_OF_DAY
			ActDate = DateAdd(ActDate, TimeClass , instance);
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy hhmma");
			strDate = dateFormat.format(ActDate).replace("M", "");
			return strDate;
		} catch (Exception e) {

		}
		return strDate;
	} 
	
	/**
	 * 模拟鼠标操作 - 鼠标右击
	 */
	public static void mouseRightClick(WebDriver driver, By by) {
		try {
			driver.findElement(by).click();
			Actions actions = new Actions(driver);
//			actions.moveToElement(driver.findElement(by));
//			actions.click(driver.findElement(by));
			actions.contextClick(driver.findElement(by));
			actions.perform();
		} catch (Exception e) {
			functions.softassert.fail(ExceptionMessageFormat(e, "", "MouseRightClick failed!") );
//			MMDriver.softAssert.fail(ExceptionMessage(e, "", "MouseRightClick failed!") + "gui_start ");
		}
	}
	
	
	
	public static String get_CommitentWithTZ(WebDriver driver , String TZ) {	
		String Commit = "";
		try {
		    Browser_GUI.MainPage.Tree(driver, "TROUBLE INFORMATION").click();
			functions.SwitchToFrame(driver, "class", "gwt-Frame");
			switch (TZ) {
			case "OS":
				Commit = Browser_GUI.MainPage.OS_Commitment(driver).getText();
				driver.switchTo().defaultContent();
				break;
			case "AS":
				Commit = Browser_GUI.MainPage.AS_Commitment(driver).getText();
				driver.switchTo().defaultContent();
				break;
			case "BC":
				Commit = Browser_GUI.MainPage.BC_Commitment(driver).getText();
				driver.switchTo().defaultContent();
				break;
			default:
				Commit = Browser_GUI.MainPage.AS_Commitment(driver).getText();
				driver.switchTo().defaultContent();
				break;
			}
			return Commit;
		} catch (Exception e) {
			return Commit;
		}
	} 

	public static Boolean Update_TrxStatus_InAdminGUI(String TN , String DataClass , String Status) {
		WebDriver adminGUIDriver = null;
		try {
		adminGUIDriver = Login_AG("QAVIEW", "123456", "CO");
		SwitchToFrame(adminGUIDriver, "Menu");
		AdminGui.MainPage.DRM(adminGUIDriver).click();
		AdminGui.MainPage.Modify_Data_DRM(adminGUIDriver).click();
		SwitchToFrame(adminGUIDriver, "mainFrame");
		adminGUIDriver.switchTo().frame("checkframe");
		AdminGui.ModifyData.select_Search_type(adminGUIDriver,"TN");
		AdminGui.ModifyData.WebEdit_Search(adminGUIDriver).sendKeys(TN);
		AdminGui.ModifyData.Btn_Search(adminGUIDriver).click();
		adminGUIDriver.switchTo().frame("Tree");
		adminGUIDriver.findElement(By.xpath("//a[text()='"+ TN +"']")).click();
		adminGUIDriver.switchTo().parentFrame();
		adminGUIDriver.switchTo().frame("myframe");
		adminGUIDriver.findElement(By.xpath("//td/font[text()='"+ DataClass +"']")).click();
		AdminGui.ModifyData.select_STATUS(adminGUIDriver, Status);
		adminGUIDriver.quit();
        return true;
		} catch (Exception e) {
			adminGUIDriver.quit();
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Update_TrxStatus_InAdminGUI"   , "Failed"));
	        return false;
		}
        
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
		int Rowcount = functions.GetTableRows(TableObject);
		int Columncount = functions.GetTableColumns(TableObject);
		List<String> Actuals = new ArrayList<>();
//        HashMap<String, int[][]> acts =new HashMap< String, int[Rowcount][Columncount]>();
		for (int r = 0; r < Rowcount ; r++) {
			for (int c = 0; c < Columncount ; c++) {
				Actuals.add(functions.GetTableCellData(TableObject, r+1, c+1));
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
		int Rowcount = functions.GetTableRows(TableObject);
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
		                map.put(XYPoint , functions.GetTableCellData(TableObject, r+1, CloNum).trim());
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
//		String subFix = "";
//		String testNgNm = "";
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
	        DataSet = functions.GetTableActualsSet(Obj);
	        functions.InputTableActualsSetToExcel(DataSet, CaseName, CheckPointName);
			break;

		case "1":
			Map<List<Integer> , String> ExpectedDataSetMap = new HashMap<List<Integer> , String>();
			List<Integer> ExpectedXYPoint = null;
			String[] tempXYPoint = null;
			String XYCell = "";
	        DataSet = functions.GetTableActualsSet(Obj);
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
    			functions.softassert.assertEquals(Actualed, Expected, functions.ExceptionMessageFormat(new Exception() ,  CheckPointName   , "Failed"));

// 			    assertEquals(Actualed, Expected, CheckPointName + "\n["+ ExpectedDataSetMapEntry.getKey()+"]");
 			    DataSet.remove(ExpectedDataSetMapEntry.getKey());
			}
            //如果不为空则实际值多出
			functions.softassert.assertTrue(DataSet.isEmpty() , functions.ExceptionMessageFormat(new Exception() ,  CheckPointName   , "\nActuals is more than Expects.Please review the case,if need to update?"));
//			functions.softassert.assertTrue(DataSet.isEmpty(), CheckPointName+"\nActuals is more than Expects.Please review the case,if need to update?");
			break;
		}
		
	   } catch (Exception e) {
			// TODO: handle exception
	   }
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		WebDriver dr = WebDriver_Setup.launchBrowser();
		functions fun = new functions(dr);
		fun.loginNtel("jt0005");

//		 Date  vToday = new SimpleDateFormat("MM-dd-yy hhmma").parse("04-13-22 1037P"+"M");
//		 vToday = DateAdd(vToday, Calendar.DAY_OF_YEAR , 4);
//		 String strToday = dateToString(vToday);
//		 strToday = strToday.substring(0, 9);
		
// 			Date expDate =new SimpleDateFormat("MM-dd-yy hhmma").parse("04-13-22 1037p"+"M");
// 			Date ActDate = new SimpleDateFormat("MM/dd/yy hh:mma").parse("04/13/22 10:30p"+"M");
// 			long startTime = expDate.getTime();
// 			long endTime = ActDate.getTime();
//
// 			long IsOver15mins = Math.abs((startTime - endTime)/1000/60);
// 			if (  IsOver15mins >= 15 ) {
//			    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  expDate.toString()   , ActDate.toString()));
//			}
//			System.out.println(IsOver15mins);

		
		 //open ems log page and show demo list.
//			WebDriver AdminGuiDriver = functions.Open_EMS_LOG();
//			 WebTable EmsLogTable = new WebTable(AdminGuiDriver,"datatable");
//			 int TnsRow = EmsLogTable.getRowWithTN("9973012689");
//			 EmsLogTable.getRow(TnsRow).click();
//			 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
//			 functions funs = new functions(AdminGuiDriver);
//			 String OldOneHandle = functions.SwitchToNewWindowAndRecordOldOne(AdminGuiDriver);
//
//			 //Check some details.
//			 funs.CheckPorperty(AdminGui.EMS_Issues_Log_Detail.WebEdit_ATTUID(AdminGuiDriver), "value","JT0015"); 
//			 
//
//			 //Close the admingui window..
//			 AdminGui.EMS_Issues_Log_Detail.Btn_Back(AdminGuiDriver).click();
//			 functions.GoBackWindow(AdminGuiDriver, OldOneHandle);
//			 AdminGuiDriver.close();
		 
		 
//		 SwitchToFrame(AdminGuiDriver, "mainFrame");
//		 EmsLogTable.getRow(3).click();
//		 AdminGui.MainPage.Btn_viewdetail(AdminGuiDriver).click();
		
	}
	

}


