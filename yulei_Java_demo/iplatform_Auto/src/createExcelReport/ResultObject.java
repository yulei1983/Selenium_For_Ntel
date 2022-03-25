package createExcelReport;

public class ResultObject {

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestPoint() {
		return testPoint;
	}

	public void setTestPoint(String testPoint) {
		this.testPoint = testPoint;
	}

	public String getExpValue() {
		return expValue;
	}

	public void setExpValue(String expValue) {
		this.expValue = expValue;
	}

	public String getActValue() {
		return actValue;
	}

	public void setActValue(String actValue) {
		this.actValue = actValue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public void setCells(String testName, String lineNum, String testPoint, String expValue, String actValue, String result,
			String comments) {

		this.setTestName(testName);
		this.setLineNum(lineNum);
		this.setTestPoint(testPoint);
		this.setExpValue(expValue);
		this.setActValue(actValue);
		this.setResult(result);
		this.setComments(comments);

	}

	private String testName;
	private String lineNum;
	private String testPoint;
	private String expValue;
	private String actValue;
	private String result;
	private String comments;

}