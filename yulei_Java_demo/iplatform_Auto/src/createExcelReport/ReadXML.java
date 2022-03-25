/**
 * @author WangMingxun
 *
 */

package createExcelReport;

import java.util.regex.Pattern;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {
	private String testPoint = "";
	private String actValue = "";
	private String comments = "";
	private String ieVersion = "";
	private Boolean flag = false;
	private List<ResultObject> rList = null;

	public List<ResultObject> getrList() {
		return rList;
	}

	public String ReadXML() {
		String testngNm = "";
		rList = new ArrayList<ResultObject>();

		Map map = new HashMap<>();

		String methodNamePool = "beforeSuite,afterSuite,beforeTest;beforeClass;afterTest;afterClass";
		String allMethodNamePool = "beforeSuite,afterSuite,beforeTest;beforeClass;afterTest;afterClass,beforeMethod,afterMethod";
		SAXReader reader = new SAXReader();
		File file = new File("test-output/testng-results.xml");
		Document document;
		try {
			document = reader.read(file);

			Element root = document.getRootElement();

			List<Element> suiteList = root.elements("suite");
			for (Element child : suiteList) {
				testngNm = child.attributeValue("name");
				List<Element> testList = child.elements("test");
				for (Element ele : testList) {
					List<Element> classList = ele.elements("class");
					for (Element classElement : classList) {

						String className = classElement.attributeValue("name");

						List<Element> methodList = classElement.elements("test-method");

						String methodName = "";
						// String finalStatus = "";
						String testNm = "";

						for (int m = 0; m < methodList.size(); m++) {

							methodName = methodList.get(m).attributeValue("name");
							String tempStatus = methodList.get(m).attributeValue("status");
							testNm = className + "." + methodName;
							String finalStatus = "";

							if (allMethodNamePool.indexOf(methodName) != -1) {
								if (!tempStatus.equals("PASS"))
									analyzeStatus(methodList.get(m), testNm, className);
							}

							if (allMethodNamePool.indexOf(methodName) == -1)
								analyzeStatus(methodList.get(m), testNm, className);

						}

					}
				}

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return testngNm;
	}

	private void analyzeStatus(Element methodElement, String testNm, String className) {
		ResultObject rowResult = null;
		System.out.println("test case name: " + testNm);
		String expValue = "";
		String lineNum = "";
		testPoint = "";
		actValue = "";
		comments = "";
		String stacktrace = "";
		String ieException = "(WARNING: The server did not provide any stacktrace information)";

		String status = methodElement.attributeValue("status");
		String tempNm = methodElement.attributeValue("name");

		if (status.equals("FAIL"))
			stacktrace = methodElement.element("exception").elementText("full-stacktrace");

		// Parse the failed case.
		if (status.equals("FAIL")) {
			String temp = "The following asserts failed:";

			if (stacktrace.indexOf(temp) != -1)
				stacktrace = stacktrace.substring(stacktrace.indexOf(temp) + temp.length());

			int exp_stat_comm, exp_stat, exp_end, act_end, gui_start, gui_end;

			if (stacktrace.indexOf("@@") != -1) {
				String[] stacktraceArray = stacktrace.split("@@");

				for (int i = 1; i < stacktraceArray.length; i++) {
					System.out.println("-loop number: " + i);
					lineNum = "";
					testPoint = "";
					expValue = "";
					actValue = "";
					comments = "";
					String temp_v = "";
					String temp_stacktraceArray = "";

					// É¾³ýÎÞ¹ØµÄlog at org.testng.asserts.SoftAssert.assertAll

					int temp_assertAll_s = stacktraceArray[i].indexOf("at org.testng.asserts.SoftAssert.assertAll");
					if (temp_assertAll_s > -1)
						temp_stacktraceArray = stacktraceArray[i].substring(0, temp_assertAll_s);
					else
						temp_stacktraceArray = stacktraceArray[i];

					// lineNum
					if (temp_stacktraceArray.indexOf("line_start [") != -1) {
						lineNum = temp_stacktraceArray.substring(temp_stacktraceArray.indexOf("line_start [") + 12,
								temp_stacktraceArray.indexOf("] line_end;"));
						System.out.println("--line number: " + lineNum);
						temp_stacktraceArray = temp_stacktraceArray.replace("line_start [" + lineNum + "] line_end;",
								"");

					}

					exp_stat = temp_stacktraceArray.indexOf("expected [");
					if (exp_stat != -1) {
						exp_end = temp_stacktraceArray.indexOf("] but found [");
						expValue = temp_stacktraceArray.substring(exp_stat + 10, exp_end).trim();
						System.out.println("--expected value: " + exp_stat + " " + exp_end + " " + expValue);

						// actValue
						String act_temp = temp_stacktraceArray.substring(exp_end + 13);
						int actv_end = act_temp.indexOf("]");
						actValue = act_temp.substring(0, actv_end);
						System.out.println("--actual value: " + actValue);

						temp_stacktraceArray = temp_stacktraceArray
								.replace("expected [" + expValue + "] but found [" + actValue + "]", "");

					}

					// testPoint
					gui_start = temp_stacktraceArray.indexOf("gui_start ");
					if (gui_start != -1) {

						gui_end = temp_stacktraceArray.indexOf(" gui_end");

						if (gui_end != -1) {

							// testPoint =
							// temp_stacktraceArray.substring(gui_start + 10);
							testPoint = temp_stacktraceArray.substring(gui_start + 10, gui_end);
							System.out.println("--gui value: " + gui_start + " " + gui_end + " " + testPoint);

							int temp_V_s = temp_stacktraceArray.indexOf("(Session info:");

							if (temp_V_s != -1) {
								temp_stacktraceArray = temp_stacktraceArray.substring(0, temp_V_s);
								testPoint = temp_stacktraceArray.substring(gui_start + 10, temp_V_s);

							} else
								temp_stacktraceArray = temp_stacktraceArray
										.replace("gui_start " + testPoint + " gui_end", "");
						} else {

							int temp_V_s = temp_stacktraceArray.indexOf("(Session info:");

							if (temp_V_s != -1) {
								temp_stacktraceArray = temp_stacktraceArray.substring(0, temp_V_s);
								testPoint = temp_stacktraceArray.substring(gui_start + 10, temp_V_s);

							}
						}

					}

					if (exp_stat == -1) {
						// testPoint
						actValue = temp_stacktraceArray.trim();
						System.out.println("------acc_temp---" + actValue);
						// int temp_V_s = testPoint.indexOf("(Session info:");
						//
						// if (temp_V_s != -1) {
						// int temp_V_e = testPoint.indexOf(ieException);
						// String temp_ieVersion = testPoint.substring(temp_V_s,
						// temp_V_e);
						//
						// act_temp = testPoint.substring(0, temp_V_s);
						// if (!temp_ieVersion.equals(ieVersion)) {
						// ieVersion = temp_ieVersion;
						// flag = true;
						// }
						// } else
						// act_temp = testPoint;

						// if (flag) {
						// actValue = actValue + ieVersion;
						// flag = false;
						// }

					}

					// Only write case name for the first line.
					if (i != 1)
						testNm = "";
					comments = "";

					String NoSuchElementException = "NoSuchElementException: no such element: Unable to locate element:";

					// analyze actValue.
					if (actValue.indexOf(NoSuchElementException) != -1) {
						actValue = "Unable to found this element";
					}

					if (actValue.indexOf("{\"method\":") != -1)
						testPoint = actValue.substring(actValue.indexOf("{"), actValue.indexOf("}") + 1);

					// Enhance report for testPoint="," and out of "Session
					// Info"
					testPoint = testPoint.replace("org.openqa.selenium.", "");
					testPoint = Pattern.compile("[^a-zA-Z{(]").matcher(testPoint).replaceFirst("").trim();

					actValue = actValue.replace("org.openqa.selenium.", "");
					actValue = Pattern.compile("[^a-zA-Z{]").matcher(actValue).replaceFirst("").trim();

					rowResult = new ResultObject();
					rowResult.setCells(testNm, lineNum, testPoint, expValue, actValue, status, comments);
					rList.add(rowResult);

				}
			} else {

				String temp_v = "";
				String temp_testP = "";

				if (stacktrace.indexOf("line_start [") != -1) {
					lineNum = stacktrace.substring(stacktrace.indexOf("line_start [") + 12, stacktrace.indexOf(";"));
					stacktrace = stacktrace.replace("line_start [" + lineNum + "] line_end;", "");
				}

				// actValue
				if (stacktrace.indexOf("at org.testng.asserts.SoftAssert.assertAll") != -1)
					comments = stacktrace.substring(0,
							stacktrace.indexOf("at org.testng.asserts.SoftAssert.assertAll"));
				if ((stacktrace.indexOf("at " + testNm) != -1))
					comments = stacktrace.substring(0, stacktrace.indexOf("at " + testNm));
				if (stacktrace.indexOf("at sun.reflect") != -1)
					comments = stacktrace.substring(0, stacktrace.indexOf("at sun.reflect"));
				else
					comments = stacktrace;

				// For "Restart IE", Save the version before "(WARNING:
				// The server did not provide any stacktrace
				// information)"
				int temp_V_s = comments.indexOf("(Session info:");
				temp_v = comments.substring(0, comments.indexOf("(Session info:"));
				if (temp_V_s != -1) {
					int temp_V_e = comments.indexOf(ieException);
					String temp_ieVersion = comments.substring(temp_V_s, temp_V_e);
					temp_v = comments.substring(0, temp_V_s);
					if (!temp_ieVersion.equals(ieVersion)) {
						ieVersion = temp_ieVersion;
						flag = true;
					}

				}

				if (flag) {
					actValue = temp_v + ieVersion;
					flag = false;
				} else
					actValue = temp_v;

				actValue = actValue.replace("org.openqa.selenium.", "");
				actValue = Pattern.compile("[^a-zA-Z{]").matcher(actValue).replaceFirst("").trim();
				comments = "";

				rowResult = new ResultObject();
				rowResult.setCells(testNm, lineNum, testPoint, expValue, actValue, status, comments);
				rList.add(rowResult);

			}
		} else {
			rowResult = new ResultObject();
			rowResult.setCells(testNm, "", "", "", "", status, "");
			rList.add(rowResult);
		}
	}
}