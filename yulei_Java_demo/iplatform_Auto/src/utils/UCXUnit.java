package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UCXUnit {
	WebDriver driver;
	public UCXUnit(WebDriver driver) {
		this.driver = driver;
		Lib.SwitchToFrame(driver, "ucx_file_iframe");
	}
	
	public WebElement GetObjByContent(String Serialnumber,String textContent) {
		String RootXpathStr = "//*[@id='document-editor__editable-container']";
		String[] Seriallist = Serialnumber.split("[.]",0);
		int i = 0;
		for (String string : Seriallist) {
			Seriallist[i] = "//ol/li["+ string +"]";
			i++;
		}
		
		for (int j = 0; j < Seriallist.length; j++) {
			RootXpathStr = RootXpathStr.concat(Seriallist[j]);
		}
		//first node "//ol/li" no need replace "/".
		if (RootXpathStr.indexOf("//ol/li") != RootXpathStr.lastIndexOf("//ol/li")) {
			int start = RootXpathStr.lastIndexOf("//");
			StringBuilder builder = new StringBuilder(RootXpathStr);
			builder.replace(start, start + 2, "/");
			RootXpathStr = builder.toString();
		}
	
		for (WebElement ele : driver.findElements(By.xpath(RootXpathStr))) {
			if (ele.getText().startsWith(textContent)) {
				return ele;
			}
		}
		
		for (WebElement ele : driver.findElements(By.xpath(RootXpathStr.concat("/span")))) {
			if (ele.getText().equals(textContent)) {
				return ele;
			}
		}
		return null;
	}
	
	public Boolean GetBlankLine(String Serialnumber) {
		WebElement element = null;
		String RootXpathStr = "//*[@id='document-editor__editable-container']";
		String[] Seriallist = Serialnumber.split("[.]",0);
		int i = 0;
		for (String string : Seriallist) {
			Seriallist[i] = "//ol/li["+ string +"]";
			i++;
		}
		for (int j = 0; j < Seriallist.length; j++) {
			RootXpathStr = RootXpathStr.concat(Seriallist[j]);
		}
		RootXpathStr = RootXpathStr.concat("/br");
		try {
			element = driver.findElement(By.xpath(RootXpathStr));
			if (element.getTagName().equals("br")) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public WebElement GetColorKeyWordInSpecificLine(String Serialnumber , String textContent , String ColorWord) {
		WebElement element = null;
		try {
			element = GetObjByContent(Serialnumber,textContent).findElement(By.xpath("./span[text()='"+ ColorWord +"']"));
		} catch (Exception e) {
//			element=null;
//			return element;
		}
		return element;
	}
	
	
	public static void main(String[] args) {

		
	}
	
	
	

}
