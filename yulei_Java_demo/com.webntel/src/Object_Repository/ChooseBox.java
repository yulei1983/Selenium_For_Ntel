package Object_Repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Function_Libary.MyException;
import Function_Libary.functions;
import bsh.This;

public class ChooseBox {
	private List<WebElement> ObjChooseBoxBtns = null;
//	private WebElement ObjChooseBoxBtn = null;
	private WebDriver driver = null;
//	private SoftAssert softAssert;
	public ChooseBox(WebDriver driver) {
		this.driver = driver;
//		this.softAssert = softAssert;
	}
	
//	public static WebDriver getDriver() {
//		return driver;
//	}
//
//	public static void setDriver(WebDriver driver) {
//		ChooseBox.driver = driver;
//	}

	/**ʶ������ChooseButton*/
	 public List<WebElement> ChooseBoxBtns() throws Exception{
         try {
 			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
 			fwait.withTimeout(Duration.ofSeconds(6));
 			fwait.pollingEvery(Duration.ofSeconds(2));		
 			fwait.ignoring(NoSuchElementException.class);
 			fwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='chooseBtnTable']")));
        	 this.ObjChooseBoxBtns = this.driver.findElements(By.cssSelector("[class*='chooseBtnTable']"));

	    }catch (Exception e) {
	    	fail("ChooseBtns not found!");
	    	return ObjChooseBoxBtns;
	     }
	   return ObjChooseBoxBtns;
      }
	 /**ʶ��ָ��ChooseButton*/
	 public WebElement ChooseBoxBtn(String BtnName) throws Exception{
		    ChooseBox choosebox = new ChooseBox(this.driver);
        	 List<WebElement> ChooseBoxBtns = choosebox.ChooseBoxBtns();
		   for(WebElement ObjChooseBoxBtn : ChooseBoxBtns) {
//				 func.fWait.until(ExpectedConditions.elementToBeClickable(ObjChooseBoxBtn));  
			  if(ObjChooseBoxBtn.getText().equals(BtnName)) {
				 return ObjChooseBoxBtn;
			  }
		   }
		   MyException myex = new MyException("[ChooseBoxBtn: "+BtnName+"] not found!");
		   throw myex;
      }
	 
	 /**ʶ��ָ��ChooseBox��������*/
	 public WebElement ChooseBox_JTextPane(){
		 
		WebElement element = driver.findElement(By.cssSelector("span.choosedialog-message"));
		 return element;
		}
	 
	 /**����ChooseButton����*/	 
	 public int ChooseBtnCount() throws Exception {
		    ChooseBox choosebox = new ChooseBox(this.driver);
		  int Num = choosebox.ChooseBoxBtns().size();
//          ChooseBoxBtns = ChooseBox.driver.findElements(By.cssSelector("[class*='chooseBtnTable']"));
//          ChooseBoxBtns.size();
         return Num;
	}
	 
	 
	 
	 
	 
	 
	 
}
