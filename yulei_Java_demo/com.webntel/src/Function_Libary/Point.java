package Function_Libary;

public class Point {
	private Integer rowNo;
	private Integer colNo;
	public Point(){}
	public Point(Integer rowNo, Integer colNo) {
	super();
	this.rowNo = rowNo;
	this.colNo = colNo;
	}
	public int getRowNo() {
	return rowNo;
	}
	public void setRowNo(Integer rowNo) {
	this.rowNo = rowNo;
	}
	public int getColNo() {
	return colNo;
	}
	public void setColNo(Integer colNo) {
	this.colNo = colNo;
	}
	@Override
	public String toString() {
	return "Point [rowNo=" + rowNo + ", colNo=" + colNo + "]";
	}
}
