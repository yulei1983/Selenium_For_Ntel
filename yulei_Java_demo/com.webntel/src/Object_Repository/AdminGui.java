package Object_Repository;

import java.security.cert.PKIXRevocationChecker.Option;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import Function_Libary.functions;

public class AdminGui {
	private static WebElement element = null;    
	private static FluentWait<WebDriver> wait;
	public AdminGui() {
	}
	private static void  SetWait(WebDriver driver) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			AdminGui.wait = wait;
            wait.withTimeout(Duration.ofSeconds(5));
			wait.pollingEvery(Duration.ofSeconds(1));		
			wait.ignoring(NoSuchElementException.class);
		} catch (Exception e) {

		}
	}
	
	private static void SetWait(WebDriver driver,int vTimeout, int PollingTime ) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			AdminGui.wait = wait;
            wait.withTimeout(Duration.ofSeconds(vTimeout));
			wait.pollingEvery(Duration.ofSeconds(PollingTime));		
			wait.ignoring(NoSuchElementException.class);
		} catch (Exception e) {

		}
	}
	
	public static class LoginPage{
		 public static WebElement UserID(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='j_user_name']")));
				element = driver.findElement(By.xpath("//input[@name='j_user_name']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "UserID"   , "No popup"));
			}
			 return element; 
			} 
		 
		 public static WebElement PassWord(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='j_password']")));
				element = driver.findElement(By.xpath("//input[@name='j_password']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "UserID"   , "No popup"));
			}
			 return element; 
			} 
		
		 public static Boolean database(WebDriver driver,String BaseName){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='selectDB']")));
				Select select=new Select(driver.findElement(By.xpath("//select[@name='selectDB']")));
                select.selectByValue(BaseName);
                return true;
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "database"   , "No popup"));
			    return false;
			}
		 }
		 
		 public static WebElement Btn_Login(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='submit']")));
				element = driver.findElement(By.xpath("//input[@name='submit']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Btn_Login"   , "No popup"));
			}
			 return element; 
			} 
		 
		 public static WebElement btn_Reset(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='images/signon/zz_21.gif']")));
				element = driver.findElement(By.xpath("//img[@src='images/signon/zz_21.gif']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "btn_Reset"   , "No popup"));
			}
			 return element; 
			} 
	}
	public static class MainPage{
		 public static WebElement EMS_Issue_Admin(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'EMS Issue Admin')]")));
				element = driver.findElement(By.xpath("//td[contains(text(),'EMS Issue Admin')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "EMS_Issue_Admin"   , "No popup"));
			}
			 return element; 
			}
		
		 public static WebElement EMS_Issues_Log(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[contains(text(),'EMS Issues Log')]")));
				element = driver.findElement(By.xpath("//td/a[contains(text(),'EMS Issues Log')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "EMS Issues Log"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement Expedite_Admin(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Expedite Admin')]")));
				element = driver.findElement(By.xpath("//td[contains(text(),'Expedite Admin')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Expedite Admin"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement Expedite_Reports_Log(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[contains(text(),'Expedite Reports Log')]")));
				element = driver.findElement(By.xpath("//td/a[contains(text(),'Expedite Reports Log')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Expedite Reports Log"   , "No popup"));
			}
			 return element; 
			}

		 public static WebElement Btn_Demo(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='viewdemoissue']")));
				element = driver.findElement(By.xpath("//input[@id='viewdemoissue']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Btn_Demo"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement Btn_viewdetail(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='viewdetail' and contains(@src,'viewdetail.gif')]")));
				element = driver.findElement(By.xpath("//input[@name='viewdetail' and contains(@src,'viewdetail.gif')]"));
			 } catch (Exception e) {
				driver.close();
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Btn_viewdetail"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement Btn_Refresh(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='viewdetail' and contains(@src,'refresh.gif')]")));
				element = driver.findElement(By.xpath("//input[@name='viewdetail' and contains(@src,'refresh.gif')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Btn_Refresh"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement DRM(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'>>DRM')]")));
				element = driver.findElement(By.xpath("//td[contains(text(),'>>DRM')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "DRM"   , "No popup"));
			}
			 return element; 
			}
		 
		 public static WebElement Modify_Data_DRM(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Modify Data ')]")));
				element = driver.findElement(By.xpath("//a[contains(text(),'Modify Data ')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Modify Data "   , "No popup"));
			}
			 return element; 
			}
	}
	
	public static class ModifyData{
		 public static Boolean select_Search_type(WebDriver driver , String classString){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='select']")));
				element = driver.findElement(By.xpath("//select[@name='select']"));
				element.click();
				element.findElement(By.xpath("./option[@value='" + classString + "']")).click();
				return true;
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "select_Search_type"   , "failed"));
				return false;
			 }
		 }
			 
				public static WebElement WebEdit_Search(WebDriver driver){	 
					 try {
						 AdminGui.SetWait(driver);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='DefaultGrayText']//input[@name='key']")));
						element = driver.findElement(By.xpath("//td[@class='DefaultGrayText']//input[@name='key']"));
					 } catch (Exception e) {
						functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Search"   , "No exist"));
					}
					 return element; 
					}
			 
				public static WebElement Btn_Search(WebDriver driver){	 
					 try {
						 AdminGui.SetWait(driver);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Submit']")));
						element = driver.findElement(By.xpath("//input[@name='Submit']"));
					 } catch (Exception e) {
						functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Search"   , "No exist"));
					}
					 return element; 
					}
				
				 public static Boolean select_STATUS(WebDriver driver , String STATUS){	 
					 try {
						 AdminGui.SetWait(driver);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='STATUS']")));
						element = driver.findElement(By.xpath("//select[@name='STATUS']"));
						element.click();
						wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("./option[@value='" + STATUS + "']"))));
						element.findElement(By.xpath("./option[@value='" + STATUS + "']")).click();
						return true;
					 } catch (Exception e) {
						functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "select_Search_type"   , "failed"));
						return false;
					 }
				 }
				
				 public static Boolean Btn_Update(WebDriver driver){	 
					 try {
						 AdminGui.SetWait(driver);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/img[@onclick='onUpdate();']")));
						element = driver.findElement(By.xpath("//td/img[@onclick='onUpdate();']"));
						element.click();
						return true;
					 } catch (Exception e) {
						functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Btn_Update"   , "failed"));
						return false;
					 }
				 }
				 
				 
			 
	}
	
	
	
	public static class EMS_Issues_Log_Detail{
	public static WebElement WebEdit_IssueID(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_issueid']")));
			element = driver.findElement(By.xpath("//input[@id='j_issueid']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_IssueID"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_EMSIssue_Dispatch_DT(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_oper_time']")));
			element = driver.findElement(By.xpath("//input[@id='j_oper_time']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "EMSIssue_Dispatch_DT"   , "No exist"));
		}
		 return element; 
		}

	 public static WebElement WebEdit_WFAC_TR(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfactroubleticketnumber']")));
			element = driver.findElement(By.xpath("//input[@id='j_wfactroubleticketnumber']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WFAC_TR#"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_TN_CKTID(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_tn']")));
			element = driver.findElement(By.xpath("//input[@id='j_tn']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "TN/CKTID"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_State(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_state']")));
			element = driver.findElement(By.xpath("//input[@id='j_state']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "State"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Acct_Type(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_accounttype']")));
			element = driver.findElement(By.xpath("//input[@id='j_accounttype']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Acct Type"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Cust_Name(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_accountname']")));
			element = driver.findElement(By.xpath("//input[@id='j_accountname']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Cust Name"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Cust_Type(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_customertype']")));
			element = driver.findElement(By.xpath("//input[@id='j_customertype']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Cust Type"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Override_Type(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_overrideindicatortype']")));
			element = driver.findElement(By.xpath("//input[@id='j_overrideindicatortype']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Override Type"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Reason_Code(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_reason_code']")));
			element = driver.findElement(By.xpath("//input[@id='j_reason_code']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Reason Code"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_EMSIssue_Submit_DT(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_issuesubmitdate']")));
			element = driver.findElement(By.xpath("//input[@id='j_issuesubmitdate']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "EMS Issue Submit D/T"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_WFAC_Received_DT(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfaccreatedate']")));
			element = driver.findElement(By.xpath("//input[@id='j_wfaccreatedate']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WFAC Received D/T"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Contact_Name(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_contactname']")));
			element = driver.findElement(By.xpath("//input[@id='j_contactname']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Contact Name"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Callback(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_callbacknumber']")));
			element = driver.findElement(By.xpath("//input[@id='j_callbacknumber']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Callback #"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_ATTUID(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_agentattuid']")));
			element = driver.findElement(By.xpath("//input[@id='j_agentattuid']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "ATTUID"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Orig_Grp(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_originatinggroup']")));
			element = driver.findElement(By.xpath("//input[@id='j_originatinggroup']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Orig Grp"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_NCSC_Center(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_ncsc']")));
			element = driver.findElement(By.xpath("//input[@id='j_ncsc']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "NCSC Center"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_WFAC_Offered_Commit_DT(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfaccommittmentdate']")));
			element = driver.findElement(By.xpath("//input[@id='j_wfaccommittmentdate']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WFAC Offered Commit D/T"   , "No exist"));
		}
		 return element; 
		}
	
	 public static WebElement WebEdit_Current_Commit_DT(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_currentcommitmentdate']")));
			element = driver.findElement(By.xpath("//input[@id='j_currentcommitmentdate']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Current Commit D/T"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Customer_Time_Zone(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_customertimezone']")));
			element = driver.findElement(By.xpath("//input[@id='j_customertimezone']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Customer Time Zone"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_System(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_systemstamp']")));
			element = driver.findElement(By.xpath("//input[@id='j_systemstamp']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "System"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebCheckBox_AOD_Callback_Suppress_Ind(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_aodcallbacksuppressindicator']")));
			element = driver.findElement(By.xpath("//input[@id='j_aodcallbacksuppressindicator']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "AOD Callback Suppress Ind"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement WebEdit_Comments(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='j_comments']")));
			element = driver.findElement(By.xpath("//textarea[@id='j_comments']"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Comments"   , "No exist"));
		}
		 return element; 
		}
	 
	 public static WebElement Btn_Back(WebDriver driver){	 
		 try {
			 AdminGui.SetWait(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'images/back.gif')]")));
			element = driver.findElement(By.xpath("//img[contains(@src, 'images/back.gif')]"));
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Back"   , "No exist"));
		}
		 return element; 
		}
	}
	
	public static class Expedite_Reports_Log_Detail{
		public static WebElement WebEdit_Validation_ID(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_issueid']")));
				element = driver.findElement(By.xpath("//input[@id='j_issueid']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Validation_ID"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_WFAC_TR(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfactroubleticketnumber']")));
				element = driver.findElement(By.xpath("//input[@id='j_wfactroubleticketnumber']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_WFAC_TR"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_State(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_state']")));
				element = driver.findElement(By.xpath("//input[@id='j_state']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_State"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Account_Name(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_accountname']")));
				element = driver.findElement(By.xpath("//input[@id='j_accountname']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Account_Name"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Override_Type(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_overrideindicatortype']")));
				element = driver.findElement(By.xpath("//input[@id='j_overrideindicatortype']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Override_Type"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Expedite_Report_Submit_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_issuesubmitdate']")));
				element = driver.findElement(By.xpath("//input[@id='j_issuesubmitdate']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Expedite_Report_Submit_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Contact_Name(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_contactname']")));
				element = driver.findElement(By.xpath("//input[@id='j_contactname']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Contact_Name"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_ATTUID(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_agentattuid']")));
				element = driver.findElement(By.xpath("//input[@id='j_agentattuid']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_ATTUID"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_NCSC_Center(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_ncsc']")));
				element = driver.findElement(By.xpath("//input[@id='j_ncsc']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_NCSC_Center"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Current_Commit_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_currentcommitmentdate']")));
				element = driver.findElement(By.xpath("//input[@id='j_currentcommitmentdate']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Current_Commit_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_System(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_systemstamp']")));
				element = driver.findElement(By.xpath("//input[@id='j_systemstamp']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_System"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_TNCKTID(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_tn']")));
				element = driver.findElement(By.xpath("//input[@id='j_tn']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_TNCKTID"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Trx_Type(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_trxtype']")));
				element = driver.findElement(By.xpath("//input[@id='j_trxtype']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Trx_Type"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Acct_Type(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_accounttype']")));
				element = driver.findElement(By.xpath("//input[@id='j_accounttype']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Acct_Type"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Cust_Type(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_customertype']")));
				element = driver.findElement(By.xpath("//input[@id='j_customertype']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Cust_Type"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Reason_Code(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_reason_code']")));
				element = driver.findElement(By.xpath("//input[@id='j_reason_code']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Reason_Code"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_WFAC_Received_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfaccreatedate']")));
				element = driver.findElement(By.xpath("//input[@id='j_wfaccreatedate']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_WFAC_Received_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Callback(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_callbacknumber']")));
				element = driver.findElement(By.xpath("//input[@id='j_callbacknumber']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Callback"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Orig_Grp(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_originatinggroup']")));
				element = driver.findElement(By.xpath("//input[@id='j_originatinggroup']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Orig_Grp"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_WFAC_Offered_Commit_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wfaccommittmentdate']")));
				element = driver.findElement(By.xpath("//input[@id='j_wfaccommittmentdate']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_WFAC_Offered_Commit_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Customer_Time_Zone(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_customertimezone']")));
				element = driver.findElement(By.xpath("//input[@id='j_customertimezone']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Customer_Time_Zone"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Went_Unprocessed(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_wentunprocessed']")));
				element = driver.findElement(By.xpath("//input[@id='j_wentunprocessed']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Went_Unprocessed"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Approval(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_approval']")));
				element = driver.findElement(By.xpath("//input[@id='j_approval']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Approval"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Appt_Start_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_appstart']")));
				element = driver.findElement(By.xpath("//input[@id='j_appstart']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Appt_Start_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Appt_End_DT(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_append']")));
				element = driver.findElement(By.xpath("//input[@id='j_append']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Appt_Start_DT"   , "No exist"));
			}
			 return element; 
			}
		
		public static WebElement WebEdit_Denial_Reason(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_denialreason']")));
				element = driver.findElement(By.xpath("//input[@id='j_denialreason']"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "WebEdit_Denial_Reason"   , "No exist"));
			}
			 return element; 
			}
		
		 public static WebElement Btn_Back(WebDriver driver){	 
			 try {
				 AdminGui.SetWait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'images/back.gif')]")));
				element = driver.findElement(By.xpath("//img[contains(@src, 'images/back.gif')]"));
			 } catch (Exception e) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Back"   , "No exist"));
			}
			 return element; 
			}

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
