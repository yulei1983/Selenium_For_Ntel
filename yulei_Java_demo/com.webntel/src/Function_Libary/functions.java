package Function_Libary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.sql.*;
import javax.swing.tree.ExpandVetoException;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
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

import Object_Repository.Browser_GUI;
import Object_Repository.ChooseBox;

import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class functions {
	public static int Threaddely = 2000;
	public static final String vNtelClientURL = PropertiesDataProvider.getTestData("config/config.properties", "vNtelClientURL");
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
//	    this.fWait = new FluentWait<WebDriver>(driver)
//		    	.withTimeout(5, TimeUnit.SECONDS)
//		        .pollingEvery(400, TimeUnit.MILLISECONDS);
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
	
	public void highlightObj(Object obj){
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
	
//	public void setSoftAt(SoftAssert softAt) {
//		this.softassert=softAt;
//	}

	public void Cancel_Ticket(String TN) throws Exception{
		Enter_TN(TN);
		ClearNtel(driver);
	}
	
	
	public void ClearNtel(WebDriver driver){
		try {
			WebElement AMOK;
			AMOK = driver.findElement(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div"));
			
			if(AMOK.isDisplayed()) {
			Browser_GUI.MainPage.AM_OK(driver).click();	
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
	
	public  void CheckPorperty(WebElement webelement,String porperty,String vExpected){
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
//	 		    // ȥ���ո� 
//	 	        vActualed = vActualed.replaceAll(" ", ""); 
	 			if (vExpected.compareTo(vActualed)!=0) {
				    functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , vActualed));
				}
//	 			functions.softassert.assertEquals(vActualed, vExpected," expected [" + vExpected + "] but found [" + vActualed + "]@@\n\t");
	 			
			} catch (Exception e) {
				functions.softassert.fail(ExceptionMessageFormat(new Exception() ,  vExpected   , "null"));
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
	
	public boolean IsExist(WebElement webelement) throws NoSuchElementException {
		try {
			fWait.until(ExpectedConditions.visibilityOf(webelement));
			webelement.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean IsExist(WebElement webelement,By by) throws NoSuchElementException {
		try {
			webelement.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean IsExist(By by) throws NoSuchElementException {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
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
			e.printStackTrace();
			return flag;	
		}
	}
	
	
	/**
	 *@author yulei 
	 *@param TableName ��Ҫ�޸ĵ�table
	 *@param sql SQL���
	 *@return Boolean true �޸ĳɹ���FALSE �޸�ʧ�ܣ����л���ԭ����
	 */
	public Boolean Update_table(String TableName,String sql) throws Exception {
		Thread.sleep(500);
		Boolean Flags = false;
		try {
			Boolean Y = functions.switchToWindow("Ntelagent Personalization Admin",driver);
			if(!Y) {
				Browser_GUI.MainPage.MenuBar_Table(driver).click();
				Browser_GUI.MainPage.Personalization_Admin(driver).click();
				functions.switchToWindow("Ntelagent Personalization Admin",driver);
			}
			WebElement OTableName = driver.findElement(By.xpath("//span[text()='"+TableName+"']"));
			OTableName.click();
	        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Edit(driver).click();
	        //String sql
	        functions.Excute_SQL(sql);
	        driver.close();
	        functions.switchToWindow("(DEMO)", driver);
		    Flags = true; 
	   }catch (NoSuchElementException e) {
			WebElement OTableName = driver.findElement(By.xpath("//span[text()='"+TableName+"*']"));
			String Edit_table_name = OTableName.getText();
				   //String sql
			functions.Excute_SQL(sql);
			driver.close();
			functions.switchToWindow("(DEMO)", driver);
			Flags = true;
			return Flags;
		}
		   return Flags;	
  }
	
	public void RollBackAll() throws Exception {		
		Thread.sleep(500);
		Set<String> handles = driver.getWindowHandles();
		Boolean PadminExist = false;
		for (String s : handles) {
			driver.switchTo().window(s);  
			if (driver.getTitle().contains("Ntelagent Personalization Admin")) {
				PadminExist = true;
		        Actions actions = new Actions(driver);
		        actions.moveToElement(Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_list(driver), 75,11).click();  
		        actions.perform();
		        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_all(driver).click();
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
		        Actions actions = new Actions(driver);
		        actions.moveToElement(Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_list(driver), 75,11).click();  
		        actions.perform();
		        Browser_GUI.PersonalizationAdmin.PersonalizationAdmin_Rollback_all(driver).click();
		        Browser_GUI.PersonalizationAdmin.Ask_Yes(driver).click();
		        driver.close();
		        functions.switchToWindow("(DEMO)", driver);
			}

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
	
	
	
	
	
}


