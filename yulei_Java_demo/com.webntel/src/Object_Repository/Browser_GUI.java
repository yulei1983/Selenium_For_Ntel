package Object_Repository;

import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Function_Libary.functions;
//import TestCases.Transfer_PrimaryDriver;

import java.awt.datatransfer.Transferable;
import java.lang.String;
import java.time.Duration;

//import net.bytebuddy.asm.Advice.AllArguments;
//import net.bytebuddy.jar.asm.commons.StaticInitMerger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class Browser_GUI {
	private static WebElement element = null;    
	public static FluentWait<WebDriver> wait;
	public Browser_GUI() {
	}
	public static void  SetWait(WebDriver driver) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			Browser_GUI.wait = wait;
            wait.withTimeout(Duration.ofSeconds(5));
			wait.pollingEvery(Duration.ofSeconds(1));		
			wait.ignoring(NoSuchElementException.class);
		} catch (Exception e) {

		}
	}
	
	private static void SetWait(WebDriver driver,int vTimeout, int PollingTime ) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			Browser_GUI.wait = wait;
            wait.withTimeout(Duration.ofSeconds(vTimeout));
			wait.pollingEvery(Duration.ofSeconds(PollingTime));		
			wait.ignoring(NoSuchElementException.class);
		} catch (Exception e) {

		}
	}
	
	
    public static class MainPage {
    	public MainPage() {
		}
		 public static WebElement EditBox_ATTUID(WebDriver driver){
			 element = driver.findElement(By.id("x-auto-17-input"));
			 return element;
			}
		 
		 public static WebElement EditBox_PSW(WebDriver driver){
			 element = driver.findElement(By.id("x-auto-18-input"));
			 return element;
			}
		 
//		 public static WebElement CHKBox_Change_WFAC_Passwd(WebDriver driver){
//			 element = driver.findElement(By.xpath("//input[@type='checkbox']//td[@valign='middle']//font[text()='OK']"));
//			 return element;
//			} 

		 public static WebElement BTN_BILL(WebDriver driver)  {
				 try {
					    Browser_GUI.SetWait(driver);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='transOneButton']//div[text()='BILL']")));
						element = driver.findElement(By.xpath("//div[@nid='transOneButton']//div[text()='BILL']"));
				        return element;
				} catch (Exception e) {
					return null;
				}
		 }
		 
		 public static WebElement BTN_RECORD(WebDriver driver){
				try {
				    Browser_GUI.SetWait(driver);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewStartButton']//div[text()='RECORD']")));
					element = driver.findElement(By.xpath("//div[@nid='viewStartButton']//div[text()='RECORD']"));
			        return element;
				} catch (Exception e) {
					return null;
				} 
		}
		 
		 public static WebElement BTN_LOOPCARE(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewStartButton']//div[text()='LOOPCARE']")));
				element = driver.findElement(By.xpath("//div[@nid='viewStartButton']//div[text()='LOOPCARE']"));
		        return element;
			}
		 
		 public static WebElement BTN_DPG(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='transOneButton']//div[text()='DPG']")));
				element = driver.findElement(By.xpath("//div[@nid='transOneButton']//div[text()='DPG']"));
		        return element;
			}

		 public static WebElement BTN_OSSCHI(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewStartButton']//div[text()='OSSCHI']")));
				element = driver.findElement(By.xpath("//div[@nid='viewStartButton']//div[text()='OSSCHI']"));
		        return element;
			}
		 
		 public static WebElement BTN_NOW(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='transOneButton']//div[text()='NOW']")));
				element = driver.findElement(By.xpath("//div[@nid='transOneButton']//div[text()='NOW']"));
		        return element;
			}
		 
		 public static WebElement BTN_QVF(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewStartButton']//div[text()='QVF']")));
				element = driver.findElement(By.xpath("//div[@nid='viewStartButton']//div[text()='QVF']"));
		        return element;
			}

		 public static WebElement BTN_HOST(WebDriver driver){
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewButton']//div[text()='HOST']")));
				element = driver.findElement(By.xpath("//div[@nid='viewButton']//div[text()='HOST']"));
		        return element;
			}
		 
		 public static WebElement BTN_VIEW(WebDriver driver){
				try {
				    Browser_GUI.SetWait(driver);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='viewButton']//div[text()='VIEW']")));
					element = driver.findElement(By.xpath("//div[@nid='viewButton']//div[text()='VIEW']"));
			        return element;
				} catch (Exception e) {
					return null;
				} 
		}

		 public static WebElement Information_OK(WebDriver driver){ 
			    Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@cellpadding='0']//td[@valign='middle']/div/div[normalize-space('OK')]")));
				element = driver.findElement(By.xpath("//table[@cellpadding='0']//td[@valign='middle']/div/div[normalize-space('OK')]"));
		 return element;
			} 
		 
		 public static WebElement information_CLOSE(WebDriver driver){ 
			 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//table//td[@valign='middle' and normalize-space(text()='CLOSE')]")));
				element = driver.findElement(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//table//td[@valign='middle' and normalize-space(text()='CLOSE')]"));
		 return element;
		} 
		 
		 public static WebElement Information_MSG_JTextPane(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			} 
		 
		 public static WebElement information_Title(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@id='head']//strong/font"));
			 return element;
			} 
		 
		 public static WebElement AM_Title(WebDriver driver){
		     element = driver.findElement(By.xpath("//div[@nid='messagedialog_U']//div[text()='Agent Message']"));
			 return element;
			} 
		 
		 public static WebElement AM_JTextPane(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement AM_queue_JTextPane(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//div[@nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement AM_OK_for_Queue(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']//table[normalize-space()='OK']//table")));
				element = driver.findElement(By.xpath("//div[@nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']//table[normalize-space()='OK']//table"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_OK"   , "No popup"));
			}
			 return element; 
			} 
		 
		 public static WebElement AM2_JTextPane(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//span[@class='askdialog-message']"));
			 return element;
			}

		 public static WebElement AM_OK(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div")));
				element = driver.findElement(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_OK"   , "No popup"));
			}
			 return element; 
			} 
		 
		 public static WebElement AM_Yes(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']")));
				element = driver.findElement(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_Yes"   , "No popup"));
			}
			 return element; 
			} 

		 public static WebElement AM_No(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='No']")));
				element = driver.findElement(By.xpath("//div[@nid='messagedialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='No']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_No"   , "No popup"));
			}
			 return element; 
			} 

		 public static WebElement AM2_Yes(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']")));
				element = driver.findElement(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_Yes"   , "No popup"));
			}
			 return element; 
			} 

		 public static WebElement AM2_No(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='No']")));
				element = driver.findElement(By.xpath("//div[@nid='askdialog_U' or @nid='askdialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='No']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_No"   , "No popup"));
			}
			 return element; 
			} 
		//div[@nid='askdialog_U']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']
		 
		 
		 public static WebElement BTN_Login_OK(WebDriver driver) throws NoSuchElementException{
		     element = driver.findElement(By.xpath("//font[text()='OK']"));
			 return element;
			} 
		 public static WebElement BTN_Login_Reset(WebDriver driver) throws NoSuchElementException{
			 element = driver.findElement(By.xpath("//font[text()='Reset']"));
			 return element;
			}  
		 public static WebElement Title_Error_MessageBox(WebDriver driver) throws NoSuchElementException{
			 element = driver.findElement(By.xpath("//div[text()='Error Message Box']"));
			 return element;
			}  
		 public static WebElement Error_MessageBox_Text(WebDriver driver) throws NoSuchElementException{
			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			} 		 
		 public static WebElement Error_MessageBox_OK(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='hotKey'][text()='O']")));
			 element = driver.findElement(By.xpath("//span[@class='hotKey'][text()='O']"));
			 return element;
			}		 

		 public static WebElement WebEdit_TNTR(WebDriver driver) {
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='tnText']/div/input[@type='text']")));
				 element = driver.findElement(By.xpath("//div[@nid='tnText']/div/input[@type='text']"));
				 return element;
			} catch (Exception e) {
				return null;
			}
		}
		 
		 public static WebElement WebEdit_Report(WebDriver driver) {
			 Browser_GUI.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='reportText']")));
			element = driver.findElement(By.xpath("//div[@nid='reportText']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_AccessAfter(WebDriver driver) {
			 element = driver.findElement(By.xpath("//div[@nid='accessAfterText']/div/input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_AccessBefore(WebDriver driver) {
			 element = driver.findElement(By.xpath("//div[@nid='accessBeforeText']/div/input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_AccessNumber(WebDriver driver) {
			 element = driver.findElement(By.xpath("//div[@nid='altReachNumText']/div/input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_ReachNumber(WebDriver driver) {
			 element = driver.findElement(By.xpath("//div[@nid='reachNumText']/div/input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_ReportBy(WebDriver driver) {
			 element = driver.findElement(By.xpath("//div[@nid='reportByText']/div/input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_TYPE(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='typeDrop']//input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_ACTION(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='actionDrop']//input[@type='text']")));
			element = driver.findElement(By.xpath("//div[@nid='actionDrop']//input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_Commitment(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='commitDatePicker']//input[@type='text']"));
			 return element;
			}
		 
		 public static WebElement WebEdit_TN(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='viewTnText']//input"));
			 return element;
			}
		 
		 public static WebElement ACTION_value(WebDriver driver,String vType){
			 element = driver.findElement(By.xpath("//div[text()='"+vType+"']"));
			 return element;
			}
		 
		 public static WebElement TYPE_value(WebDriver driver,String vType){
			 element = driver.findElement(By.xpath("//div[contains(@class,'x-ignore')]//div[text()='"+vType+"']"));
			 return element;
			}
		 
		 public static WebElement CheckBox_MR(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='MR']/preceding-sibling::input[@type='checkbox']")));
			 element = driver.findElement(By.xpath("//label[text()='MR']/preceding-sibling::input[@type='checkbox']"));
			 return element;
			}	
		 
		 public static WebElement CheckBox_BACKDOWN(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='BACKDOWN']/preceding-sibling::input")));
			 element = driver.findElement(By.xpath("//label[text()='BACKDOWN']/preceding-sibling::input"));
			 return element;
			}	
		 
		 public static WebElement CheckBox_MISSLR_ETKT_WRG(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='MISSLR/ETKT/WRG#']/preceding-sibling::input[@type='checkbox']")));
			 element = driver.findElement(By.xpath("//label[text()='MISSLR/ETKT/WRG#']/preceding-sibling::input[@type='checkbox']"));
			 return element;
			}	

		 public static WebElement MenuBar_System(WebDriver driver){
			 element = driver.findElement(By.xpath("//td[@valign='middle']/descendant::div[text()='System']"));
			 return element;
			}	
		 

		 
		 public static WebElement MenuBar_System_Exit(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[contains(text(),'Exit')]"));
			 return element;
			}	
		 
		 public static WebElement Exit_Yes(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[contains(text(),'Exit')]/ancestor::div//td[@align='center']//table//table[normalize-space()='Yes']"));
			 return element;
			}
		 
		 public static WebElement MenuBar_System_Demo(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[contains(text(),'Demo')]"));
			 return element;
			}	
		
		 public static WebElement MenuBar_System_CTIDemo(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[contains(text(),'CTIDemo')]"));
			 return element;
			}

		 public static WebElement RECORD_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//div[@id='flowlayoutcontainer']//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//div[@id='flowlayoutcontainer']//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement RECORD_Yes(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='Yes']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='Yes']"));
			 return element;
			}
		 
		 public static WebElement RECORD_No(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='No']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='No']"));
			 return element;
			}

		 public static WebElement BILL_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//div[@id='flowlayoutcontainer']//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//div[@id='flowlayoutcontainer']//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement BILL_Yes(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='Yes']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='Yes']"));
			 return element;
			}
		 
		 public static WebElement BILL_No(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='No']")));
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_L']//td[@class='buttonWarper']//div[contains(@style , 'font') and normalize-space()='No']"));
			 return element;
			}
		 
		 
		 public static WebElement Title_Ask(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='askdialog_U']//div[contains(text(),'Ask')]"));
			 return element;
			}

		 public static WebElement Ask_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='askdialog-message']")));
			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement Instruction_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//div[@class='ebmsgf']/span")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement Instruction_OK(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//td[@valign='middle']//div[contains(@style,'font') and normalize-space()='OK']")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement Instruction_Title(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='messagedialog_U']//div[text()='Instruction']")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement Information_JTextPane(WebDriver driver) throws Exception{
			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 

		
		 
		 public static WebElement Ask_Yes(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'es')]")));
			  return element;
			}
		 
		 public static WebElement Ask_No(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[@class = 'hotKey'][contains(text(),'N')]"));
			 element = element.findElement(By.xpath("./parent::div"));
			 return element;
			}
		 
		 public static WebElement select_Service_Address_Title(WebDriver driver) {
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='selsrvaddrdialog_U']//div[text()='Select Service Address']")));
			 return element;
			}
		 
		 public static WebElement Select_Service_Address_JTextPane(WebDriver driver) {
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='selsrvaddrdialog_U']//div[@class='ebmsgf']")));
			 return element;
			}
		 
		 public static WebElement select_Service_Address_Option(WebDriver driver , String Option) {
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'selsrvaddrFieldset')]//fieldset//label[text()='"+ Option +"']")));
			 return element;
			}

		 public static WebElement Select_Service_Address_OK(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='selsrvaddrdialog_U']//div[contains(@style,'font') and normalize-space()='OK']")));
			 return element;
			}
		 
		 
		 public static WebElement DataInput2_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='inputdialog_U']//td[@class='ebmsgf']")));
			 return element;
			}

		 public static WebElement DataInput2_Title(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='inputdialog_U']//div[text()='Data Input']")));
			 return element;
			}
		 
		 public static WebElement DataInput2_MaskEdit(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='inputdialog_U']//input")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement DataInput2_OK(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='inputdialog_U']//td[@class='buttonWarper']//td[@valign='middle']/div[normalize-space()='OK']")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement DataInput2_Cancel(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='inputdialog_U']//td[@class='buttonWarper']//td[@valign='middle']/div[normalize-space()='Cancel']")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}

		 public static WebElement DataInput_JTextPane(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multiinputdialog_U']//td[@class='ebmsgf']")));
			 return element;
			}

		 public static WebElement DataInput_Title(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multiinputdialog_U']//div[text()='Data Input']")));
			 return element;
			}
		 
		 public static WebElement DataInput_MaskEdit(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multiinputdialog_U']//td[@class='MaskEdit_1']//input")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement DataInput_OK(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multiinputdialog_U']//td[@class='buttonWarper']//td[@valign='middle']/div[normalize-space()='OK']/div")));
			 element = driver.findElement(By.xpath("//div[@nid='multiinputdialog_U']//td[@class='buttonWarper']//td[@valign='middle']/div[normalize-space()='OK']/div"));
			 return element;
			}
		 
		 public static WebElement DataInput_Cancel(WebDriver driver) throws Exception{
			  Browser_GUI.SetWait(driver);
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multiinputdialog_U']//td[@class='buttonWarper']//td[@valign='middle']/div[normalize-space()='Cancel']")));
//			 element = driver.findElement(By.xpath("//span[@class='askdialog-message']"));
			 return element;
			}
		 
		 public static WebElement Submit_AgMsg_Yes(WebDriver driver){
			 try {
					 Thread.sleep(300);
					 Browser_GUI.SetWait(driver);
					 
					 List<WebElement> eles;			
					 eles = driver.findElements(By.xpath(
							 "//*[@id=\"flowlayoutcontainer\"]/div/table//tr[3]//div[1]/div/table//table//span[contains(text(),'Y')]"));
						 if (eles.size()>1) {
							 return eles.get(1);
						 }
						 else {
							 return eles.get(0);
						 }
						} catch (Exception e) {

						}
					 return null;			 
		 }
			 
			  
		 public static WebElement Submit_AgMsg_No(WebDriver driver) throws Exception{
			 Thread.sleep(300);
			 List<WebElement> eles;
			 eles = driver.findElements(By.cssSelector(
			"#flowlayoutcontainer > div > table > tbody > tr:nth-child(3) > td > div > div > div:nth-child(2) > div > table > tbody > tr:nth-child(2) > td div table"));
			 if (eles.size()>1) {
				 return eles.get(1);
			 }
			 else {
				 return eles.get(0);
			 }
		  }
		 
		 public static WebElement Submit_APRO_OK(WebDriver driver){
			 try {
				 Browser_GUI.SetWait(driver);
				 Thread.sleep(2000);
				 By submit_APRO_OK_By = By.xpath("//*[@id='flowlayoutcontainer' and contains(@style,'641px') ]/div/table//table//table//div//span[contains(text(),'O')]/parent ::div");
				 wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(submit_APRO_OK_By, 0));
				 List<WebElement> eles = driver.findElements(submit_APRO_OK_By);    
				 for(WebElement element : eles) {	 
					 wait.until(ExpectedConditions.elementToBeClickable(element));
						  if(element.getText().equals("OK")) {
							 return element;
						   }
				    } 
					} catch (Exception e) {
						// TODO: handle exception
					}
			 return null;
		 }	
		 
		 public static WebElement Submit_TankYou_OK(WebDriver driver){
			 try {
				 Thread.sleep(300);
				 List<WebElement> eles = driver.findElements(By.xpath("//div[@nid='messagedialog_L']//td[@valign='middle']//div[contains(@style,'font') and normalize-space()='OK']"));
				 for(WebElement element : eles) {
						  if(element.getText().equals("OK")) {
							 return element;
						   }
				    }
				
			} catch (Exception e) {
				return null;
			}
			    return null;
			}
		 
		 public static WebElement Submit_TankYou_OK_For_Queue(WebDriver driver) {
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Queued Report:')]//ancestor::table[3]//tr[3]//table//td[@valign='middle' and normalize-space()='OK']")));
				 element = driver.findElement(By.xpath("//span[contains(text(),'Queued Report:')]//ancestor::table[3]//tr[3]//table//td[@valign='middle' and normalize-space()='OK']"));
				 return element;		
			 } catch (Exception e) {
						// TODO: handle exception
					}
			 return null;
		 }
		 
/*		 public static WebElement table(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[contains(@qtip,'TN')]/parent::td/parent::tr/parent::tbody/parent::table/parent::div/parent::div/following-sibling::div[1]//table"));
			//div[contains(@qtip,'TN')]/parent::td/parent::tr/parent::tbody/parent::table/parent::div/parent::div/following-sibling::div[1]//table
			 return element;
			}*/
		 
		 public static WebElement Table_Journal(WebDriver driver) {
			 String s = "//div[contains(@qtip,'TN')]/parent::td/parent::tr/parent::tbody/parent::table/parent::div/parent::div/following-sibling::div[1]//table";
			 element = driver.findElement(By.xpath(s));
			 return element;
		 }
		 
		 public static WebElement Table_Screening_Journal(WebDriver driver) {
			 String s = "//div[contains(@qtip,'TN')]/ancestor::div/div[contains(@style,'overflow') ]/div/table/tbody[2]";
			List<WebElement> elements = driver.findElements(By.xpath(s));
			element = elements.get(1);
			 return element;
		 }
		 
		 public static WebElement Table_Server_Queue(WebDriver driver) {
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(normalize-space() , 'TN or MR/Z ticket')] //table[contains(@class,'CKRB')]/tbody[2]")));
				 String s = "//div[contains(normalize-space() , 'TN or MR/Z ticket')] //table[contains(@class,'CKRB')]/tbody[2]";
					List<WebElement> elements = driver.findElements(By.xpath(s));
					element = elements.get(0);
					 return element;
			 } catch (Exception e) {
				 return null;
			 }
			 
			 
			 
			 
			 

		 }

		 public static WebElement Table_Hold_Journal(WebDriver driver) {
			 String s = "//div[contains(@qtip,'TN')]/ancestor::div/div[contains(@style,'overflow') ]/div/table[contains(@style, '1012px') and contains(@class,'CKRB')]/tbody[2]";
			List<WebElement> elements = driver.findElements(By.xpath(s));
			element = elements.get(0);
			 return element;
		 }
		 
		 public static WebElement BTN_RETRIEVE(WebDriver driver) {
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@valign='middle']//div[text()='RETRIEVE']")));
				 element = driver.findElement(By.xpath("//td[@valign='middle']//div[text()='RETRIEVE']"));
				 return element;		
			 } catch (Exception e) {
				 return null;
			 }
		 }
		 
		 public static WebElement CheckBox_AUTO(WebDriver driver) {
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='AUTO']//preceding-sibling::input")));
				 element = driver.findElement(By.xpath("//label[text()='AUTO']//preceding-sibling::input"));
				 return element;		
			 } catch (Exception e) {
				 return null;
			 }
		 }
		 
		 public static WebElement BTN_REFRESH(WebDriver driver) {
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@valign='middle']//div[text()='REFRESH']")));
				 element = driver.findElement(By.xpath("//td[@valign='middle']//div[text()='REFRESH']"));
				 return element;		
			 } catch (Exception e) {
				 return null;
			 }
		 }
		 
//		 public static String Table_QueueView_SQ() {
//			 String s = "//span[contains(text(),'TN or MR/Z ticket')]/parent::div/parent::td/parent::tr/parent::tbody/parent::table/parent::div/parent::div/following-sibling::div[1]//table";
//			 return s;
//		 } 
		 
		 public static WebElement Tree_WFA_CTR_SBCMICHPOTS(WebDriver driver){
			 element =driver.findElement(By.xpath("//span[text()='WFA CTR SBCMICHPOTS']"));
			 return element;
			}
		  		 
		 public static WebElement BTN_ScreenPool(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='Screen Pool']"));
			 return element;
			}
		 
		 public static WebElement BTN_Receipt(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='Receipt']"));
			 return element;
			}
		 
		 public static WebElement BTN_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='Journal']"));
			 return element;
			}

		 public static WebElement Tab_Screening_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Screening Journal']"));
			 return element;
			}
		 
		 public static WebElement Tab_Expedite_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Expedite Journal']"));
			 return element;
			}
		 
		 public static WebElement Tab_Hold_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Hold Journal']"));
			 return element;
			}
		 
		 public static WebElement Tab_Call_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Call Journal']"));
			 return element;
			}
		 
		 public static WebElement Tab_EMS_Journal(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='EMS Journal']"));
			 return element;
			}
		 
		 
		 
		 public static WebElement BTN_Submit(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='SUBMIT']"));
			 return element;
			}
		 
		 public static WebElement BTN_Queue(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='QUEUE']"));
			 return element;
			}
		 
		 public static WebElement BTN_QueueView(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='QueueView']"));
			 return element;
			}
		 
		 public static WebElement MenuBar_Table(WebDriver driver){
			 element = driver.findElement(By.xpath("//td[@valign='middle']/descendant::div[text()='Table']"));
			 return element;
			}
		 
		 public static WebElement Personalization_Admin(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Personalization Admin']"));
			 return element;
			}
	 
		 public static WebElement Label_QueueView_AUTO(WebDriver driver){
			 element = driver.findElement(By.xpath("//label[text()='AUTO']"));
			 return element;
			}
		
		 public static WebElement Cancel(WebDriver driver){
			 Browser_GUI.SetWait(driver);
			 element = driver.findElement(By.xpath("//div[text()='Cancel']"));
			 wait.until(ExpectedConditions.elementToBeClickable(element));

			 return element;
			}
		 
		 public static WebElement Cancel_Message_Yes(WebDriver driver) throws Exception{	
			Browser_GUI.SetWait(driver);	
			WebElement Cancel_Title = driver.findElement(By.xpath("//div[text() = 'Cancel']/parent::div/parent::div/parent::div/parent::div"));
			WebElement element =Cancel_Title.findElement(By.xpath("./following-sibling::div//span[contains(text() , 'Y')]"));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			 return element;
			}
		 
		 public static WebElement Cancel_Message_No(WebDriver driver) throws Exception{	
			Browser_GUI.SetWait(driver);	
			WebElement Cancel_Title = driver.findElement(By.xpath("//div[text() = 'Cancel']/parent::div/parent::div/parent::div/parent::div"));
			WebElement element =Cancel_Title.findElement(By.xpath("./following-sibling::div//span[contains(text() , 'N')]"));
			functions funs = new functions(driver);
			funs.fWait.until(ExpectedConditions.elementToBeClickable(element));
			 return element;
			}
		 
		 public static WebElement Cancel_Customer_Error(WebDriver driver){
				 element =driver.findElement(By.xpath("//span[text()='Customer Error']"));
			 return element;
			}
		 	 
		 
		 public static WebElement Verify_and_select_the_name_and_service_address_being_reported_Title(WebDriver driver){
			 try {
				//div[contains(@class,'informationRow')]//font[text()="TROUBLE INFORMATION"]
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[text()='Verify and select the name and service address being reported']")));
				 element = driver.findElement(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[text()='Verify and select the name and service address being reported']"));
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Verify_and_select_the_name_and_service_address_being_reported_Title"   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 public static WebElement V_and_s_name_and_service_address_Option(WebDriver driver,String Option){
			 try {
				//div[contains(@class,'informationRow')]//font[text()="TROUBLE INFORMATION"]
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[@id='flowlayoutcontainer']//div[@class='treeRootDIV']//span[text()='"+ Option +"']")));
				 element = driver.findElement(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[@id='flowlayoutcontainer']//div[@class='treeRootDIV']//span[text()='"+ Option +"']"));
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Verify_and_select_the_name_and_service_address_being_reported"   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 public static WebElement V_and_s_name_and_service_address_OK(WebDriver driver){
			 try {
				//div[contains(@class,'informationRow')]//font[text()="TROUBLE INFORMATION"]
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[contains(@class,'fullDiv')]//td[@valign='middle' and normalize-space()='OK']//div[contains(@style,'font')]")));
				 element = driver.findElement(By.xpath("//div[@nid='multirecordstreelistdialog_U']//div[contains(@class,'fullDiv')]//td[@valign='middle' and normalize-space()='OK']//div[contains(@style,'font')]"));
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Verify_and_select_the_name_and_service_address_being_reported_Title"   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 
		 
		 public static WebElement Tree(WebDriver driver,String vTree){
			 try {
				//div[contains(@class,'informationRow')]//font[text()="TROUBLE INFORMATION"]
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'informationRow')]//font[text()=\""+ vTree +"\"]")));
				 element = driver.findElement(By.xpath("//div[contains(@class,'informationRow')]//font[text()=\""+ vTree +"\"]"));
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  vTree   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 public static WebElement Tree_red_value(WebDriver driver,String vTree){
			 try {
				 Boolean Isdiplayed = false;
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ui[normalize-space()=\""+ vTree   +"\"]/font[@color='RED']")));
				 element = driver.findElement(By.xpath("//ui[normalize-space()=\""+ vTree   +"\"]/font[@color='RED']"));
				 Isdiplayed = wait.until(ExpectedConditions.attributeToBe(element, "outerText", vTree));
				 
				 if (Isdiplayed) {
					    functions.softassert.assertTrue(Isdiplayed, vTree+" PASS");
				} else {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception()  ,  vTree   , "The Tree no display!"));
				}
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  vTree   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 public static WebElement Tree_value(WebDriver driver,String vTree){
			 try {
				 Boolean Isdiplayed = false;
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ui[text()=\""+vTree+"\"]")));
				 element = driver.findElement(By.xpath("//ui[text()=\""+vTree+"\"]"));
				 Isdiplayed = wait.until(ExpectedConditions.attributeToBe(element, "outerText", vTree));
				 
				 if (Isdiplayed) {
					    functions.softassert.assertTrue(Isdiplayed, vTree+" PASS");
				} else {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception()  ,  vTree   , "The Tree no display!"));
				}
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  vTree   , "The Tree no display!"));
			   }
			 return element;
		 }
		 
		 public static WebElement Treelist_Title(WebDriver driver){
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='treelistdialog_U']//div[text()='TreeList']")));
			 element = driver.findElement(By.xpath("//div[@nid='treelistdialog_U']//div[text()='TreeList']"));
			 return element;
			}
		 
		 public static WebElement Treelist_Option(WebDriver driver , String treelist_option){
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='treeRootDIV']//span/span[text()=\"" + treelist_option + "\"]")));
			 element = driver.findElement(By.xpath("//div[@class='treeRootDIV']//span/span[text()=\"" + treelist_option + "\"]"));
			 return element;
			}
		 
		 public static WebElement Treelist_OK(WebDriver driver){
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='treelistdialog_U']//td[@valign = 'middle' and normalize-space()='OK']")));
			 element = driver.findElement(By.xpath("//div[@nid='treelistdialog_U']//td[@valign = 'middle' and normalize-space()='OK']"));
			 return element;
			}
		 
		 public static WebElement TreeForm_Title(WebDriver driver){
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='treeformdialog_U']//div[text()='TreeForm']")));
			 element = driver.findElement(By.xpath("//div[@nid='treeformdialog_U']//div[text()='TreeForm']"));
			 return element;
			}
		 
		 public static WebElement TreeForm_OK(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='treeformdialog_U']//td[@valign='middle']//div[contains(@style,'font') and normalize-space()='OK']"));
			 return element;
			}
		 
		 public static WebElement TreeForm_Cancel(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='treeformdialog_U']//td[@valign='middle']//div[contains(@style,'font') and normalize-space()='Cancel']"));
			 return element;
			}
		 
		 public static WebElement TreeForm_expandNode(WebDriver driver , String TreeForm_Option){
			 WebElement element;
			//div[@class='treeRootDIV']//span/span[text()="CAN'T BE CALLED"]/parent::span/preceding-sibling::img[2]
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='treeRootDIV']//span/span[text()=\"" + TreeForm_Option + "\"]"));
			element = elements.get(0);
			element = element.findElement(By.xpath("./parent::span/preceding-sibling::img[2]"));
			 return element;
			}
		 
		 public static WebElement TreeForm_Option(WebDriver driver , String TreeForm_Option ,int index){
			 WebElement element;
			//div[@class='treeRootDIV']//span/span[text()="CAN'T BE CALLED"]/parent::span/preceding-sibling::img[2]
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='treeRootDIV']//span/span[text()=\"" + TreeForm_Option + "\"]"));
			if (elements.size()>1) {
				element = elements.get(index);
			}else {
				element = elements.get(0);		
			}
			 return element;
			}
		 
		 public static WebElement topLocalTime(WebDriver driver) throws NoSuchElementException{
			 try {
				 Browser_GUI.SetWait(driver);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".topLocalTimeLabel > label")));
				 element = driver.findElement(By.cssSelector(".topLocalTimeLabel > label"));
			} catch (NoSuchElementException e) {
					try {
						functions.softassert.fail("topLocalTime not found!");
					} catch (Exception e2) {
	
					}
			}
			 return element;
			}
		 
		 public static WebElement OS_Commitment(WebDriver driver){
			 element =driver.findElement(By.xpath("//table//tr[normalize-space()='CURRENT COMMITMENTS AVAILABLE']/following-sibling::tr[2]/td[2]"));
		 return element;
		}
		 
		 public static WebElement AS_Commitment(WebDriver driver){
			 element =driver.findElement(By.xpath("//table//tr[normalize-space()='CURRENT COMMITMENTS AVAILABLE']/following-sibling::tr[1]/td[2]"));
		 return element;
		}
		 
		 public static WebElement BC_Commitment(WebDriver driver){
			 element =driver.findElement(By.xpath("//table//tr[normalize-space()='CURRENT COMMITMENTS AVAILABLE']/following-sibling::tr[3]/td[2]"));
		 return element;
		}
		 
		 public static WebElement Webtable_right_html_section(WebDriver driver){
			 element = driver.findElement(By.xpath("//table[@align='center']"));
			 return element;
			}

		 public static WebElement Webtable_right_html_section2(WebDriver driver){
			 element = driver.findElement(By.xpath("//table[@align='	//table[@align='center'][2]']"));
			 return element;
			}

		 public static WebElement Webtable_Right_section_FEATURE_COMPARISON_html(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@id='upperLayer1']/table"));
			 return element;
			}
		 
		 public static WebElement Webtable_Right_section_AIN_SMS_html(WebDriver driver){
			 element = driver.findElement(By.xpath("//body//table[contains(normalize-space() , 'AIN SMS')]"));
			 return element;
			}
		 public static WebElement Webtable_Right_section_FEATURE_COMPARISON(WebDriver driver){
			 element = driver.findElement(By.xpath("//body//table[contains(normalize-space() , 'FEATURE COMPARISON')]"));
			 return element;
			}
		 
		 public static WebElement Webtable_Right_section_AIN_SMS(WebDriver driver){
			 element = driver.findElement(By.xpath("//body//table[contains(normalize-space() , 'AIN SMS')]"));
			 return element;
			}

		 public static WebElement Receipt_1_X(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(normalize-space() , 'Receipt-1')]/preceding-sibling::a")));
				 element = driver.findElement(By.xpath("//a[contains(normalize-space() , 'Receipt-1')]/preceding-sibling::a"));
			     return element;
			 } catch (Exception e) {
//				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Receipt_1_X"   , "Receipt_1_X no display!"));
				        return null; 
			 }
			}

		 public static WebElement Screening_1_X(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(normalize-space() , 'Screening-1')]/preceding-sibling::a")));
				 element = driver.findElement(By.xpath("//a[contains(normalize-space() , 'Screening-1')]/preceding-sibling::a"));
				 return element;
			 } catch (Exception e) {
//				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Screening_1_X"   , "Screening_1_X no display!"));
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_TN_CKTID(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='TN/CKTID:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='TN/CKTID:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_TN_CKTID(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='EMS_tnText']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='EMS_tnText']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }

		 public static WebElement EMS_OREF_CALLBACK(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='CALLBACK #:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='CALLBACK #:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_CALLBACK(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='callbackText']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='callbackText']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_REASON_CODE(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='REASON CODE:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='REASON CODE:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_REASON_CODE(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='reasoncodeDrop']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='reasoncodeDrop']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_CONTACT_NAME(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='CONTACT NAME:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='CONTACT NAME:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_CONTACT_NAME(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='contactNameText']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='contactNameText']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_REQUESTED_COMMIT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='REQUESTED COMMIT:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='REQUESTED COMMIT:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_REQUESTED_COMMIT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='requestedCommitDatePicker']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='requestedCommitDatePicker']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_COMMENTS(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='COMMENTS:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='COMMENTS:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_COMMENTS(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='commentsText']//textarea")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='commentsText']//textarea"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }

		 public static WebElement EMS_OREF_SUPPRESS_AOD_CALLBACK(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='SUPPRESS AOD CALLBACK:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='SUPPRESS AOD CALLBACK:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_SUPPRESS_AOD_CALLBACK(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='suppressAodCallbackDrop']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='suppressAodCallbackDrop']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_APPROVAL_INDICATOR(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='APPROVAL INDICATOR:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='APPROVAL INDICATOR:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_APPROVAL_INDICATOR(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='approvalIndicatorDrop']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='approvalIndicatorDrop']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }

		 public static WebElement EMS_OREF_NDC_APPROVED_COMMIT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='NDC APPROVED COMMIT:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='NDC APPROVED COMMIT:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_NDC_APPROVED_COMMIT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='ndcApprovalCommitDatePicker']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='ndcApprovalCommitDatePicker']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }

		 public static WebElement EMS_OREF_NDC_APPROVAL_AGENT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='NDC APPROVAL AGENT:']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//label[text()='NDC APPROVAL AGENT:']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement WebEdit_EMS_OREF_NDC_APPROVAL_AGENT(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='ndcApprovalAgentText']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//td[@class='ndcApprovalAgentText']//input"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_OK(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//div[contains(@style,'font') and normalize-space()='OK']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//div[contains(@style,'font') and normalize-space()='OK']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 public static WebElement EMS_OREF_Cancel(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='emsrequestdialog_U']//div[contains(@style,'font') and normalize-space()='Cancel']")));
				 element = driver.findElement(By.xpath("//div[@nid='emsrequestdialog_U']//div[contains(@style,'font') and normalize-space()='Cancel']"));
				 return element;
			 } catch (Exception e) {
				        return null;   
			 } 
		 }
		 
		 
		 
		 
		 
		 
		 
    } 
    
    public static class PersonalizationAdmin {
		 public static WebElement PersonalizationAdmin_Edit(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='Edit']"));
			 return element;
			}
		 
		 public static WebElement PersonalizationAdmin_rightmenu_Edit(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[@unselectable='on' and text()='Edit']"));
			 return element;
			}

		 public static WebElement PersonalizationAdmin_Rollback(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[text()='Rollback']"));
			 return element;
			}
		 
//		 public static WebElement PersonalizationAdmin_Rollback_list(WebDriver driver){
//			 element = driver.findElement(By.xpath("//div[@class = 'GMRNFO4CNN GMRNFO4CDN']"));
//			 return element;
//			}
		 public static WebElement PersonalizationAdmin_Rollback_list(WebDriver driver){
			 List<WebElement> Rollback_list =  driver.findElements(By.xpath("//table//td[2]/div[normalize-space()='Rollback']"));
			 WebElement element = Rollback_list.get(0);
			 return element;
			}
		 
		 public static WebElement PersonalizationAdmin_Rollback_all(WebDriver driver){
			 element = driver.findElement(By.xpath("//span[text()='Rollback All']"));
			 return element;
			}
		 
		 public static WebElement Ask_Yes(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[contains(text(),'YES')]"));
			 return element;
		}
    }
    
    
    public static class SPPage {
		 public static WebElement TN_TICKET(WebDriver driver){
			 try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='ticketText']//input")));
				 element = driver.findElement(By.xpath("//div[@nid='ticketText']//input"));
			 } catch (Exception e) {
				        functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "TN_TICKET"   , "TN_TICKET no display!"));
			   }
			 return element;
			}

		 public static WebElement GetTicket(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='getTicketButton']"));
			 return element;
			}
		 
		 public static WebElement STATUS_COMMENTS_1(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='statuscommentText']//textarea"));
			 return element;
			}
		 
		 public static WebElement SP_HOLD_TICKET(WebDriver driver){
			 element = driver.findElement(By.xpath("//div[@nid='holdTicketButton']//div[text()='HOLD TICKET']"));
			 return element;
			}
		 
		 public static WebElement Tree_value(WebDriver driver,String vTree) throws NoSuchElementException{
			 try {
				 element = driver.findElement(By.xpath("//ui[text()=\""+vTree+"\"]"));
//				 functions func = new functions(driver);
//				 func.fWait.until(ExpectedConditions.visibilityOf(element));
			} catch (NoSuchElementException e) {
				SoftAssert softAt =new SoftAssert();
				softAt.assertEquals(false, true ,vTree+" Tree not found!");
			}
			 return element;
			}
		 
		 public static WebElement AM2_Yes(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@nid='askdialog_U' or @nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']")));
				element = driver.findElement(By.xpath("//div[@nid='askdialog_U' or @nid='messagedialog_L']//div[normalize-space()='Agent Message']/following-sibling::div//td[@valign='middle']/div[normalize-space()='Yes']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_Yes"   , "No popup"));
			}
			 return element; 
			}  
		 
		 public static WebElement AM_OK(WebDriver driver){	 
			 try {
				 Browser_GUI.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div")));
				element = driver.findElement(By.xpath("//div[@id='flowlayoutcontainer']//td[@valign='middle']//td[@valign='middle']//span[contains(text(),'O')]/parent::div"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AM_OK"   , "No popup"));
			}
			 return element; 
			} 

    }
 }










