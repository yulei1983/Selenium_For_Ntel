package utils;

import java.util.List;

import org.dom4j.XPath;
import org.jboss.netty.handler.timeout.ReadTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectRepository.AppElements;
import prepare.MMDriver;

public class FlowUnit{
	WebElement Unit;
	List<WebElement> Units;
	WebDriver driver;
	/**
	 * @param driver
	 * @author yulei
	 */
	public FlowUnit(WebDriver driver) {
		this.driver = driver;
		Lib.SwitchToFrame(driver, "visio_file_iframe");		
	}
	
	/**
	 * @param index Unit display order of type. Begin with 1(rectangle).
	 * @param locationindex Use to locate element which have the same innerhtml.
	 * @param context Unit context.
	 * @return Boolean
	 * @author yulei
	 */
	public Boolean CreateUnit(int index ,String locationindex , String context) {
		index = index+4;
		int beforeUnitsSize = 0;
		int UnitsSize = 0;
		WebElement ToolbarUnit = driver.findElement(By.xpath("//div[@class='geToolbarContainer top']//a[contains(@style,'overflow')]["+ index +"]"));
		Units = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		beforeUnitsSize = Units.size();
		ToolbarUnit.click();
		Units = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		UnitsSize = Units.size();
		Unit = Units.get(UnitsSize-1);
		Actions actionbuilder = new Actions(driver);
		actionbuilder.doubleClick(Unit);
		actionbuilder.sendKeys(context);
		actionbuilder.sendKeys(Keys.ESCAPE);
		actionbuilder.dragAndDropBy(Unit, 150, 150);
		actionbuilder.release();
		actionbuilder.perform();
		AddObjAttribute(Unit, "locationindex", locationindex);
		if (beforeUnitsSize < UnitsSize) {
			return true;
		}else {
			return false;
		}
	}
	
	public void DragAndDropUnit(String locationindex , int Xoffset ,int Yoffset) {
		Lib.wait_Sleep(500);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"rexDiv\"]/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate') and @locationindex='"+ locationindex +"']"));
		Actions actionbuilder = new Actions(driver);
		actionbuilder.dragAndDropBy(element, Xoffset, Yoffset);
		actionbuilder.perform();
	}
	
	/**
	 * @param locationindex begin with 1.
	 * @param context unit text.
	 * @return Weblement
	 * @author yulei
	 */
//	public WebElement GetObj(String context, String locationindex) {
//		WebElement object = null;
//		object = driver.findElement(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate') and @locationindex='"+ locationindex +"']/following-sibling::*[local-name()='g']//div[text()='"+ context +"']"));
//		return object;
//	}
	
	/**
	 * @param locationindex begin with 1. Prerequisites for use is created unit by function CreateUnit.
	 * @return Weblement
	 * @author yulei
	 */
	public WebElement GetObj(String locationindex) {
//		List<WebElement> objects = null;
		WebElement object = null;
		object = driver.findElement(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate') and @locationindex='"+ locationindex +"']/following-sibling::*[local-name()='g']//div[contains(@xmlns,'http')]"));
		return object;
	}
	
	/**
	 * @return List<WebElement>
	 * @author yulei
	 */
	private List<WebElement> GetObjs() {
		List<WebElement> objects = null;
//		WebElement object = null;
		objects = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]/following-sibling::*[local-name()='g']//div[contains(@xmlns,'http')]"));
		return objects;
	}
	
	public WebElement GetObjByContent(String textContent) {
		WebElement GetElement = null;
//		String tempstr = "";
		for (WebElement ement : GetObjs()) {
//			tempstr = ement.getText().replace("> ", ">");
//			tempstr = tempstr.replace(" <", "<");
//			System.out.println(ement.getText());
			if (ement.getText().equals(textContent)) {
				GetElement = ement;
				break;
			}
		}
		return GetElement;
	}
	
	/**
	 * @param index begin with 0.
	 * @return Weblement
	 * @author yulei
	 */
	public WebElement GetObj(int index) {
		List<WebElement> objects = null;
		WebElement object = null;
		objects = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]/following-sibling::*[local-name()='g']//div/div"));
		object = objects.get(index);
		return object;
	}
	
	public void SetUnitContext(String targetcontext , String Setcontext) {
		try {
			Actions action = new Actions(driver); 
			action.doubleClick(GetObjByContent(targetcontext));
			action.sendKeys(Setcontext);
			action.click(GetObjByContent(Setcontext));
			action.sendKeys(Keys.ESCAPE);
			action.perform();
		} catch (Exception e) {
			MMDriver.softAssert.fail(targetcontext + " Unit Set "+Setcontext+" failed!");
		}	
	}
	
	/**
	 * @param Context Unit context.
	 * @param ColorWord
	 * @return WebElement
	 * @author yulei
	 */
	public WebElement GetGreenWordNodeInSpecificUnit(String Context, String ColorWord) {
		try {
			return GetObjByContent(Context).findElement(By.xpath(".//span[contains(@style , 'color: green') and text()='"+ColorWord+"']")); 
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @param Context
	 * @param ColorWord
	 * @return WebElement
	 * @author yulei
	 */
	public int GetGreenWordNodesInSpecificUnit(String Context, String ColorWord) {
		try {
			int num = 0;
			num = GetObjByContent(Context).findElements(By.xpath(".//span[contains(@style , 'green') and text()='"+ColorWord+"']")).size(); 
			return num;
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * @param Context
	 * @param ColorWord
	 * @return WebElement
	 * @author yulei
	 */
	public WebElement GetRedWordNodeInSpecificUnit(String Context, String ColorWord) {
		try {
			return GetObjByContent(Context).findElement(By.xpath(".//span[contains(@style , 'red') and text()='"+ColorWord+"']")); 
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @param Context
	 * @param ColorWord
	 * @return WebElement
	 * @author yulei
	 */
	public WebElement GetOrangeWordNodeInSpecificUnit(String Context, String ColorWord) {
		try {
			return GetObjByContent(Context).findElement(By.xpath(".//span[contains(@style , 'orange') and text()='"+ColorWord+"']")); 
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @see 返回所有绿色字体单元
	 * @return List<WebElement>
	 * @author yulei
	 */
	public List<WebElement> GetGreenWordNodes() {
		List<WebElement> objects = null;
		objects = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]/following-sibling::*[local-name()='g']//div//span[@style='color: green']"));
		return objects;
	}
	
	/**
	 * @see 返回所有橙色字体单元
	 * @return List<WebElement>
	 * @author yulei
	 */
	public List<WebElement> GetOrangeWordNodes() {
		List<WebElement> objects = null;
		objects = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]/following-sibling::*[local-name()='g']//div//span[@style='color: orange']"));
		return objects;
	}
	
	/**
	 * @see 返回所有红色字体单元
	 * @return List<WebElement>
	 * @author yulei
	 */
	public List<WebElement> GetRedWordNodes() {
		List<WebElement> objects = null;
		objects = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]/following-sibling::*[local-name()='g']//div//span[@style='color: red']"));
		return objects;
	}
	
	/**
	 * @param locationindex begin with 1.
	 * @return Weblement
	 * @author yulei
	 */
	public WebElement GetGreenWordNode(String locationindex) {
//		List<WebElement> objects = null;
		WebElement object = null;
		object = driver.findElement(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate') and @locationindex='"+locationindex+"']/following-sibling::*[local-name()='g']//div//span[@style='color: green']"));
		return object;
	}
	
	/**
	 * @param AttributeName
	 * @param AttributeValue
	 * @return 
	 */
	private void AddObjAttribute(WebElement ele , String AttributeName, String AttributeValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
	    js.executeScript(scriptSetAttrValue, ele, AttributeName, AttributeValue);
	}
	
	/**
	 * @param context unit text.
	 * @param locationindex 
	 * @return Boolean
	 * @author yulei
	 */
	public Boolean ReleaseObj(String locationindex) {
		int beforeUnitsSize = 0;
		int UnitsSize = 0;
		Units = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		beforeUnitsSize = Units.size();
		DragAndDropUnit(locationindex, 500, 800);
		Lib.mouseRightClick(driver, GetObj(locationindex));
		//click delete.
		Lib.GetTableCellObj(driver.findElement(AppElements.Table_rightclickFlowUnitMenu) , 2, 2).click();
		Units = driver.findElements(By.xpath("//*[@id='rexDiv']/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		UnitsSize = Units.size();
		
		if (UnitsSize < beforeUnitsSize) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean ReleaseObjs() {
		int UnitsSize = 1;
		Units = driver.findElements(By.xpath("//*[@id=\"rexDiv\"]/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		Actions actionbuilder = new Actions(driver);
//		actionbuilder.moveByOffset(532, 502);
//		actionbuilder.contextClick();
//		actionbuilder.perform();
//		actionbuilder.click(driver.findElement(By.xpath("//table[@class='mxPopupMenu']//td[text()='Select All']")));
//		actionbuilder.sendKeys(Keys.DELETE);
//		actionbuilder.perform();
		if (Units.size()!=0) {
			actionbuilder.click(Units.get(0));
		}
		actionbuilder.sendKeys(Keys.ESCAPE);
		actionbuilder.keyDown(Keys.CONTROL);
		actionbuilder.sendKeys("a");
		actionbuilder.keyUp(Keys.CONTROL);
		actionbuilder.sendKeys(Keys.DELETE);
		actionbuilder.perform();

		Units = driver.findElements(By.xpath("//*[@id=\"rexDiv\"]/div[4]/*[local-name()='svg']/*[local-name()='g']/*[local-name()='g'][2]/*[local-name()='g' and contains(@transform,'translate')]"));
		UnitsSize = Units.size();

		if (UnitsSize == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	

}
