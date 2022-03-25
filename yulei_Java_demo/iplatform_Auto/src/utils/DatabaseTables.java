/**
 * 
 */
package utils;

import java.util.List;

import org.dom4j.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author yulei
 * Objects are displayed on the Data/Database/Test page.
 *
 */
public class DatabaseTables {
//	private WebDriver driver = null;
	private List<WebElement> tables = null;
	
	  public DatabaseTables(WebDriver driver)  {
//			this.driver = driver;
			this.tables = driver.findElements(By.xpath("//div[@id='area']//div[@class='table']"));
		 }
	  
	  public WebElement GetDatabaseTableObject(String TableName) throws Exception{
		    WebElement obj = null;
		    WebElement temp = null;
		    try {
		     for (WebElement table : tables) {
		    	 temp = table.findElement(By.xpath("./table/thead/tr/td"));
			     if (temp.getText().equals(TableName)) {
			    	obj = temp;
					break;
				 }
			 }
			} catch (Exception e) {
				// TODO: handle exception
			}
		    return obj;    
		}
	  
	  
	  
	  
}
