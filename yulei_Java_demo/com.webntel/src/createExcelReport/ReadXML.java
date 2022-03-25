/**
 * @author WangMingxun
 *
 */

package createExcelReport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {

	private List<ResultObject> rList = null;

	public List<ResultObject> getrList() {
		return rList;
	}

	public ReadXML() {
		rList = new ArrayList<ResultObject>();
		ResultObject rowResult = null;
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
				List<Element> testList = child.elements("test");
				for (Element ele : testList) {
					List<Element> classList = ele.elements("class");
					for (Element classElement : classList) {

						String className = classElement.attributeValue("name");

						List<Element> methodList = classElement.elements("test-method");

						String methodName = "";
						String finalStatus = "";
						String testNm = "";

						int u = 0;
						for (int m = 0; m < methodList.size(); m++) {

							methodName = methodList.get(m).attributeValue("name");
							// System.out.println(methodName);

							if (methodNamePool.indexOf(methodName) != -1) {
								u = 0;
								finalStatus = "";
								finalStatus = methodList.get(m).attributeValue("status");
								testNm = className + "." + methodName;
							} else {
								if (methodName.equals("beforeMethod")) {
									u = 3;
									finalStatus = "PASS";
									for (int k = 0; k < 3; k++) {
										String tempMethodName = methodList.get(m + k).attributeValue("name");
										String tempStatus = methodList.get(m + k).attributeValue("status");
										// Get Test Case Name
										if (allMethodNamePool.indexOf(tempMethodName) == -1) {

											testNm = className + "." + tempMethodName;
										}
										// Get Result
										if (tempStatus.equals("FAIL")) {
											finalStatus = "FAIL";
										}
										if (!finalStatus.equals("FAIL"))
											if (tempStatus.equals("SKIP"))
												finalStatus = "SKIP";
									}
								}
								u--;
								
//								If no (beforemethod), only case.
								if (u == -1)
									if (allMethodNamePool.indexOf(methodName) == -1) {
										u = 0;
										finalStatus = "";
										testNm = className + "." + methodName;
										finalStatus = methodList.get(m).attributeValue("status");
										System.out.println(testNm);
										System.out.println(finalStatus);
									}
							}

							if (finalStatus.equals("PASS") || finalStatus.equals("SKIP")) {

								if (allMethodNamePool.indexOf(methodName) == -1) {
									rowResult = new ResultObject();
									rowResult.setCells(testNm, "", "", finalStatus, "");
									rList.add(rowResult);
									continue;
								}
							}
							String expValue = "";
							String actValue = "";
							String comments = "";

							Element methodElement = methodList.get(m);

							String status = methodElement.attributeValue("status");
							String tempNm = methodElement.attributeValue("name");
							// Parse the failed case.
							if (status.equals("FAIL")) {
								String stacktrace = methodElement.element("exception").elementText("full-stacktrace");

								int exp_stat_comm, exp_stat, exp_end, act_end;
								exp_stat_comm = stacktrace.indexOf("expected [");

								// For HardAssert Fail
								if (exp_stat_comm != -1) {
									String[] stacktraceArray = stacktrace.split("@@\n\t");

									for (int i = 0; i < stacktraceArray.length - 1; i++) {
										expValue = "";
										actValue = "";
										comments = "";

										exp_stat = stacktraceArray[i].indexOf("expected [");
										if (exp_stat != -1) {
											exp_end = stacktraceArray[i].indexOf("] but found [");
											System.out.println(stacktraceArray[i]);
											expValue = stacktraceArray[i].substring(exp_stat + 10, exp_end).trim();
											// System.out.println(expValue);
											if (i == 0)
												comments = stacktraceArray[i].substring(0, exp_stat).trim() + ";"
														+ stacktrace.substring(
																stacktrace.indexOf(className + "." + tempNm)
																		+ (className + "." + tempNm).length(),
																stacktrace.indexOf("at sun.reflect."));
											else
												comments = stacktraceArray[i].substring(0, exp_stat).trim();

											String act_temp = stacktraceArray[i].substring(exp_end + 13);
											act_end = act_temp.indexOf("]");
											actValue = act_temp.substring(0, act_end).trim();
										} else {
											if (stacktraceArray[i].indexOf("(Session info:") != -1)
												comments = stacktraceArray[i].substring(0,
														stacktraceArray[i].indexOf("(Session info:"));
											else
												comments = stacktraceArray[i].substring(0,
														stacktraceArray[i].indexOf("at sun.reflect."));

										}
										comments = comments.replaceAll(",, ", "")
												.replaceAll("The following asserts failed:", "");

										if (i != 0)
											testNm = "";
										if (comments.equals(","))
											comments = "";
										rowResult = new ResultObject();
										rowResult.setCells(testNm, expValue, actValue, finalStatus, comments);
										rList.add(rowResult);
									}
									continue;
								} else {
									if (stacktrace.indexOf("(Session info:") != -1)
										comments = stacktrace.substring(0, stacktrace.indexOf("(Session info:"));
									else
										comments = stacktrace.substring(0, stacktrace.indexOf("at sun.reflect."));
									if (comments.equals(","))
										comments = "";
									rowResult = new ResultObject();
									rowResult.setCells(testNm, expValue, actValue, finalStatus, comments);
									rList.add(rowResult);
								}
								// System.out.println(actValue);

							}
						}

					}

				}

			}

		} catch (

		DocumentException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

}
