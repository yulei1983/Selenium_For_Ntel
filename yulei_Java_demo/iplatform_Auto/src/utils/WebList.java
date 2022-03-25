package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bsh.This;
import prepare.MMDriver;

public class WebList {
	private WebElement element = null;
	private WebDriver dr;

	public WebList(WebDriver dr, By by) {
		this.dr = dr;
		this.element = dr.findElement(by);
	}

	public int GetOptionCount() {
		int count = -1;
		count = element.findElements(By.xpath(".//option")).size();
		return count;
	}
	
	public WebElement GetOptionObj(String OptionName) {
		WebElement OptionObj = null;
		try {
		OptionObj = element.findElement(By.xpath(".//option[text()='" + OptionName + "']"));
		} catch (Exception e) {
//			MMDriver.softAssert.fail("@@line_start [" + new Exception().getStackTrace()[1].getLineNumber() + "] line_end;gui start Option not exist in the Weblist!");
			MMDriver.softAssert.fail("@@line_start [" + new Exception().getStackTrace()[1].getLineNumber() + "] line_end; expected [Display] but found [NotFound]gui_start  <"+OptionName+"> Option not exist in the Weblist!");
		}
		return OptionObj;
	}
	
	public void select(String OptionName) {
		try {
			element.click();
			GetOptionObj(OptionName).click();
		} catch (Exception e) {			
			MMDriver.softAssert.fail("@@line_start [" + new Exception().getStackTrace()[1].getLineNumber() + "] line_end; expected [Display] but found [NotFound]gui_start <"+OptionName+"> Option not exist in the Weblist!");
		}
	}
	

	
	
	
}
