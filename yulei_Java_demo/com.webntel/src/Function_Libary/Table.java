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
 * ȡָ����Ԫ��
 * @param point
 * point������ָ����(rowNo)����
 * @return
 * ָ��������Ӧ��WebElement����
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
 * ȡ������Ԫ��
 * @return
 * List<WebElement>���ر����������Ԫ��
 */
private List<WebElement> getAllRows(){
List<WebElement> allRows = null;
allRows = this.table.findElements(By.tagName("tr"));
return allRows;
}
/**
 * ȡָ����������Cell
 * @param point
 * point������ָ����(rowNo)����
 * @return
 * ����ָ���������е�Ԫ��Ԫ��
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
 * ȡָ���к���Cell
 * @param point
 * point������ָ����(rowNo)����(colNo)
 * @return
 * ����ָ���к��ж����WebElement����
 * @throws MyException 
 */
public WebElement getCellOfRow(Point point) throws MyException{
 List<WebElement> cells = null;  
 WebElement Row = this.getRow(point);
     WebElement target = null;  
     int cell = point.getColNo();
     //�ֿ�����������"<th>"��"<td>"���ֱ�ǩ
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
 * ȡָ����������Cell
 * @param point
 * point������ָ����(colNo)
 * @return
 *����ָ���������е�Ԫ��Ԫ�أ��÷����Ὣ�����ڵ�������Ӧ�ĵ�Ԫ��Ԫ����Ϊnull,��ӵ�List����� 
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
//			List<WebElement> allRows1 = this.getAllRows();//��ֹҳ����ʱˢ�£����²���Ԫ��
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
		}else    //��tr�в�����td �� th ʱ�����null
			cells.add(null);
	}catch(IndexOutOfBoundsException e){
		     throw new MyException(">>>colNo out of range : \n"
		+ "colNo should be [colNo >= 0 || colNo < "+tmpCells.size()+"]");
	}

}
	
	return cells;
}
/**
 * ��ȡ������е�����ȣ����е����Ԫ�����
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
 * ��ָ���������е�Ԫ��
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
