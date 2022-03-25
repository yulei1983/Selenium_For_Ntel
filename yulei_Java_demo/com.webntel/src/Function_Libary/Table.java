package Function_Libary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import net.bytebuddy.description.field.FieldDescription.InGenericShape;

public class Table {
	private By by;
	private WebElement table;
	private WebDriver driver;
	
	public Table(WebElement table) {
//	super();
	this.table = table;
	}
	
	public Table(By by) {
//		super();
	   this.by = by;
	   this.table = driver.findElement(this.by);
	}
/**
 * 取指定行元素
 * @param point
 * point对象中指定行(rowNo)属性
 * @return
 * 指定行所对应的WebElement对象
 * @throws MyException 
 */
   private WebElement getRow(Point point) throws MyException{
      WebElement target = null;
      List<WebElement> allRows = this.getAllRows();
      try{
         target = allRows.get(point.getRowNo());
      }catch(IndexOutOfBoundsException e){
         throw new MyException(">>>rowNo out of range : \n"
          + "rowNo should be [rowNo >= 0 || rowNo < "+allRows.size()+"]");
       }
      return target;
     }    
/**
 * 取所有行元素
 * @return
 * List<WebElement>返回表格中所有行元素
 */
private List<WebElement> getAllRows(){
List<WebElement> allRows = null;
allRows = this.table.findElements(By.tagName("tr"));
return allRows;
}
/**
 * 取指定行中所有Cell
 * @param point
 * point对象中指定行(rowNo)属性
 * @return
 * 返回指定行中所有单元格元素
 * @throws MyException 
 */
public List<WebElement> getCellsOfRow(Point point) throws MyException{
List<WebElement> cells = null;
WebElement row = this.getRow(point);
cells = row.findElements(By.tagName("th"));
if(cells.size()>0){
return cells;
}
cells = row.findElements(By.tagName("td"));
if(cells.size()>0){
return cells;
}
return null;
}
/**
 * 取指定行和列Cell
 * @param point
 * point对象中指定行(rowNo)和列(colNo)
 * @return
 * 返回指定行和列对象的WebElement对象
 * @throws MyException 
 */
public WebElement getCellOfRow(Point point) throws MyException{
 List<WebElement> cells = null;  
 WebElement Row = this.getRow(point);
     WebElement target = null;  
     int cell = point.getColNo();
     //分开处理列里面"<th>"、"<td>"两种标签
     cells = Row.findElements(By.tagName("th"));
     if(cells.size() == 0){
     cells = Row.findElements(By.tagName("td"));
     }
     if(cells.size() == 0){
     return null;
     }
     try{
target = cells.get(cell);  
     }catch(IndexOutOfBoundsException e){
     throw new MyException(">>>colNo out of range : \n"
+ "colNo should be [colNo >= 0 || colNo < "+cells.size()+"]");
     }
 return target; 
}
/**
 * 取指定列中所有Cell
 * @param point
 * point对象中指定列(colNo)
 * @return
 *返回指定列中所有单元格元素，该方法会将不存在的列所对应的单元格元素置为null,添加到List结果中 
 * @throws MyException 
 */
public List<WebElement> getCellsOfCol(Point point) throws Exception,MyException,NoSuchElementException{
	int colNo = point.getColNo();
	if(colNo >= this.maxLength()){
	throw new MyException(">>>colNo should be less than the max number("+this.maxLength()+")"
	+ " of any row's column amount in this table");
	}
	List<WebElement> cells = new ArrayList<WebElement>();
	List<WebElement> tmpCells = null;
	List<WebElement> allRows = this.getAllRows();
	WebElement row = null;
	
for(int i = 0;i<allRows.size();i++) {
	try{
//			List<WebElement> allRows1 = this.getAllRows();//防止页面临时刷新，重新捕获元素
			row = allRows.get(i);
			boolean IsExist = functions.IsExist(row, By.tagName("th"));
			if(IsExist) {
				tmpCells = row.findElements(By.tagName("th"));
			}else {
				tmpCells = row.findElements(By.tagName("td"));			
			}
		if(tmpCells.size()>0){
			if(colNo < tmpCells.size()){
			 cells.add(tmpCells.get(colNo));
			}else{
			 cells.add(null);
			}
		}else    //当tr中不存在td 和 th 时，添加null
			cells.add(null);
	}catch(IndexOutOfBoundsException e){
		     throw new MyException(">>>colNo out of range : \n"
		+ "colNo should be [colNo >= 0 || colNo < "+tmpCells.size()+"]");
	}

}
	
	return cells;
}
/**
 * 获取表格中行的最大宽度，即行的最大单元格个数
 * @return
 */
private int maxLength(){
int max = 0;
int arrLength = this.getAllRows().size();
Iterator<WebElement> allRows = this.getAllRows().iterator();
int maxArr[] = new int[arrLength];
WebElement row = null;
List<WebElement> tmpCells = null;
int i = 0;
while(allRows.hasNext()){
row = allRows.next();
if(i == 0){
tmpCells = row.findElements(By.tagName("th"));
if(tmpCells.size() == 0){
tmpCells = row.findElements(By.tagName("td"));
}
}else{
tmpCells = row.findElements(By.tagName("td"));
}
maxArr[i] = tmpCells.size();
i++;
}
Arrays.sort(maxArr);
max = maxArr[arrLength-1];
return max;
}
/**
 * 将指定列中所有单元格
 * @param cells
 * @return
 */
@SuppressWarnings("null")
public List<WebElement> TrimCellsOfCol(List<WebElement> cells){
List<WebElement> tmp = null;
Iterator<WebElement> cellIter = cells.iterator();
while(cellIter.hasNext()){
WebElement e = cellIter.next();
if(e != null){
tmp.add(e);
}
}
return tmp;
}
}
