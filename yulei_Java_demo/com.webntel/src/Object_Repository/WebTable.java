package Object_Repository;

import java.util.Iterator;

import org.bouncycastle.asn1.x509.DistributionPointName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Function_Libary.functions;

public class WebTable {
	WebElement webtable;
	WebDriver driver;
	String TableId;
	public WebTable(WebDriver driver,String TableId){
		this.TableId = TableId;
		this.webtable = driver.findElement(By.xpath("//table[@id='"+ TableId +"']"));
		this.driver = driver;
	}
	
	public void ReflashTable() {
		webtable = driver.findElement(By.xpath("//table[@id='"+ TableId +"']"));
	}
	
	public int RowCount() {
		ReflashTable();
		int rowcount = webtable.findElements(By.xpath("./tbody/tr")).size();
		return rowcount;
	}
	
	public int ColCount() {
		ReflashTable();
		int colcount = webtable.findElements(By.xpath("./tbody/tr[1]/td")).size();
		return colcount;
	}
	
	public String getCellValue(int row, int col) {
		ReflashTable();
		String getCellValue = webtable.findElement(By.xpath("./tbody/tr["+row+"]/td["+col+"]")).getText();
		return getCellValue;
	}
	
	public Boolean CheckCellValue(int row, int col,String Expected) {
		ReflashTable();
		String getCellValue = webtable.findElement(By.xpath("./tbody/tr["+row+"]/td["+col+"]")).getText();
		if (getCellValue.compareTo(Expected)==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getRowWithTN(String TN) {
		int TnsRow = -1;
		ReflashTable();
		int allrows = RowCount();
        String tNString;
		for (int i = 1; i < allrows; i++) {
			//TN:Colum number is 4
			tNString = getCellValue(i, 4);
			if (tNString.compareTo(TN)==0) {
			     TnsRow = i;
			     break;
			}
		}
		return TnsRow;
	}
	
	public WebElement getRow(int row) {
		WebElement getRowEle=null;
		 try {
			 ReflashTable();
			 Browser_GUI.SetWait(driver);
			 Browser_GUI.wait.until(ExpectedConditions.visibilityOf(webtable.findElement(By.xpath("./tbody/tr["+row+"]"))));
			 getRowEle = webtable.findElement(By.xpath("./tbody/tr["+row+"]"));
			 return getRowEle;
		 } catch (Exception e) {
			functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "Row: "+row   , "Is not Exist"));
		}
		 return getRowEle;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
