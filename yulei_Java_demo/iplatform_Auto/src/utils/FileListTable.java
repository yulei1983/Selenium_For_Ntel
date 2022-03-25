package utils;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.sql.RowSetMetaData;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.grid.common.exception.RemoteUnregisterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.reporters.ExitCodeListener;

import jxl.demo.XML;
import objectRepository.AppElements;

public class FileListTable {
	private String Id;
//	private WebDriver driver;
//	private String tableXML;		
	private WebElement table;
//	private Document document;
	
  public FileListTable(WebDriver driver,String Id ,String frameId)  {
	this.Id = Id;
	Lib.SwitchToFrame(driver, frameId);
	this.table = driver.findElement(By.xpath("//ul[@id='"+Id+"']"));

 }
  
  public FileListTable(WebDriver driver,String Id)  {
	try {
		this.Id = Id;
		Lib.SwitchToFrame(driver, "moduleFrame");
		this.table = driver.findElement(By.xpath("//div[@id='fileListPanel']//ul[@id='"+Id+"']"));
	} catch (Exception e) {
		// TODO: handle exception
	}
}
  
  public WebElement GetFileListTable(){
	return table;
}
  
  public int AllRowCount(){
	  int vRowsNum = 0;      
     List<WebElement> nods = table.findElements(By.xpath("./li"));
      vRowsNum = nods.size();
	  return vRowsNum;
}
  
  public int AllCloumCount(){
	  int vCloumNum = 0;
	  WebElement element = table.findElement(By.xpath(".//li[1]"));
	  List<WebElement> elems = element.findElements(By.xpath("./div[contains(@class,'column column-')]"));
	  vCloumNum = elems.size();
	  return vCloumNum;
  }
  
  public String getCellData(int row,int col) {
	  WebElement element = table.findElement(By.xpath(".//li["+ row +"]"));
	  element = element.findElement(By.xpath(".//div["+ col +"]"));
	  String FileNameCellData = element.getText().trim();
	  return FileNameCellData; 
  }
  
  
  public String getFileNameData(int row) {
	  String FileNameCellData = "";
	  WebElement element = table.findElement(By.xpath(".//li["+ row +"]"));
	  FileNameCellData = element.findElement(By.xpath("./div[contains(@class,'column-filename')]")).getText().trim();
	  return FileNameCellData; 
  }

  public String getModifiedData(int row) {
	  WebElement element = table.findElement(By.xpath(".//li["+ row +"]"));
	  WebElement oModified = element.findElement(By.xpath(".//div[contains(@class,'column column-lastModify')]"));
	  String ModifiedCellData = oModified.getText().trim();
	  return ModifiedCellData; 
  }
  
  public String getModifierData(int row) {
	  WebElement element = table.findElement(By.xpath(".//li["+ row +"]"));
	  WebElement oModifier = element.findElement(By.xpath(".//div[contains(@class,'column column-lastModify')]/following-sibling::div[1]"));//Modified同级定位
	  String ModifierCellData = oModifier.getText().trim();
	  return ModifierCellData; 
  }
  
  public String getCreatorData(int row) {
	  WebElement element = table.findElement(By.xpath(".//li["+ row +"]"));
	  WebElement oCreator = element.findElement(By.xpath(".//div[contains(@class,'column column-lastModify')]/following-sibling::div[2]"));
	  String CreatorCellData = oCreator.getText().trim();
	  return CreatorCellData; 
  }
  
	public int getRowByFileName(String vFileName) {
		  int vrow = -1;
		  List<WebElement> elements = table.findElements(By.xpath(".//li"));
		  int AllRow = elements.size();
		   for(int i= 1; i<= AllRow; i++ ) {  
			     if(getFileNameData(i).equals(vFileName)) {
				   vrow = i;
				   break;
			     }
		    }
	      return vrow;
	}
  
	public WebElement getRowElement(String vFileName) {
	       WebElement elem = null;
	       int row = -1;
	      for (int i = 0; i < AllRowCount(); i++) {
			if (getFileNameData(i+1).equals(vFileName)) {
				row = i+1;
				break;
			}
		}
	      elem =  table.findElement(By.xpath(".//li["+ row +"]"));
	      return elem;
	}

	public By getRowElementBy(String vFileName) {
	       By by = null;
	       int row = 0;
	      for (int i = 0; i < AllRowCount(); i++) {
			if (getFileNameData(i+1).equals(vFileName)) {
				row = i+1;
				break;
			}
		}
	      by = By.xpath("//ul[@id='"+Id+"']//li["+ row +"]//div[contains(@class,'column column-filename')]");
	      return by;
	}
	
	
	
	
  
}
