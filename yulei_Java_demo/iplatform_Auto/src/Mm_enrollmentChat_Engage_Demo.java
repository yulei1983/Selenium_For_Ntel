//package testcases;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import checkpoints.EnrollChat;
import objectRepository.MatterMost;
import prepare.*;
import utils.Lib;

public class Mm_enrollmentChat_Engage_Demo {
	WebDriver driver_agent = null;
	String appName = "";
	String userName = null;
	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() {
		this.driver = MMDriver.init();
		Lib.login_Mm(driver, "wmx@qq.com", "123456");
		this.userName = Lib.getUserName(driver);

		// int keys[] = { KeyEvent.VK_WINDOWS, KeyEvent.VK_LEFT };
		// Lib.simulateKeyBoard(keys);

		// ********************************************** 登录Agent
		this.driver_agent = Lib.launchBrowser();
		Lib.login_Mm(driver_agent, "wmx@cyberobject.com.cn", "123456");
		// int keys_agent[] = { KeyEvent.VK_WINDOWS, KeyEvent.VK_RIGHT };
		// Lib.simulateKeyBoard(keys_agent);

	}

	@AfterClass
	public void afterClass() {
		Lib.logout_Mm(driver);
		Lib.logout_Mm(driver_agent);
		Lib.quit(driver_agent);
	}

	@BeforeMethod
	public void beforeMethod() {
		MMDriver.softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		MMDriver.softAssert.assertAll();
	}

	@Test
	public void Engage_01_Engagement() {
		try {
			appName = "enrollment_chat";

			// 检查是否存在异常退出 engagement的情况。
			Lib.selectMMApp(driver, "enrollment_cht");
			Lib.chkTextContent(driver, MatterMost.Header_Infor, "enrollment_chat");

			Lib.initStart(driver, new String[] { "English", "7621", "30080", "Cancel and close the session" });

			Lib.sendMsg(driver, "hello");

			Lib.chkMsg(driver, appName, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);

			Lib.selectChose(driver, "English");
			Lib.chkMsg(driver, appName, EnrollChat.If_you_have_to_drop_off_before_we_finish);

			Lib.sendMsg(driver, "abcedefg");
			Lib.chkMsg(driver, appName,
					EnrollChat.Please_provide_the_last_four_digits_only_of_your_social_security_number);

			Lib.sendMsg(driver, "abcedefgeff");
			Lib.chkMsg(driver, appName, EnrollChat.I_am_checking_for_a_couple_of_things);

			// ********************************************** Agent
			if (Lib.wait_Condition(driver_agent, 30, MatterMost.Accept))
				driver_agent.findElement(MatterMost.Accept).click();

			Lib.isEngageSuccess(driver_agent, "enrollment_chat", userName);

			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");

			Lib.chkMsg(driver_agent, appName, "abcedefgeff\n" + EnrollChat.If_you_have_to_drop_off_before_we_finish);

			// CUST send message to agent on CM.
			Lib.sendMsg(driver, "I need help Zip Code 7621!");
			Lib.chkMsg(driver, userName, "I need help Zip Code 7621!");

			// Agent receive and send message on CM.
			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");
			Lib.chkMsg(driver_agent, userName, "I need help Zip Code 7621!");
			Lib.sendMsg(driver_agent, "7621");
			Lib.chkMsg(driver_agent, appName, EnrollChat.Please_give_me_your_zip_code);

			// CUST： 检查CUST没有收到任何消息
			Lib.chkMsg(driver, userName, "I need help Zip Code 7621!");

			// Agent在CM模式下 转发消息给CUST
			driver_agent.findElement(MatterMost.Forward_ToCUST(0)).click();

			Lib.chkIsStatus(driver_agent, MatterMost.Mode_Monitor, "active");
			Lib.chkMsg(driver_agent, appName, EnrollChat.Please_give_me_your_zip_code);

			// CUST： 检查CUST收到消息
			Lib.chkMsg(driver, appName, EnrollChat.Please_give_me_your_zip_code);

			// 在MONITOR模式下CUST发送消息
			// CUST
			Lib.sendMsg(driver, "30080");
			Lib.chkMsg(driver, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			// AGENT
			Lib.chkMsg(driver_agent, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			// 在MONITOR模式下AGENT发送消息
			// AGENT
			Lib.selectChose(driver_agent, "Yes");
			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");
			Lib.chkMsgRegEx(driver_agent, appName,
					EnrollChat.This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx);

			// CUST： 检查CUST没有收到任何消息
			Lib.chkMsg(driver, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			driver_agent.findElement(MatterMost.Leave_TopBar).click();

			Lib.sendMsg(driver, "Cancel and close the session");
			Lib.chkMsg(driver, appName, "Goodbye.");
		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}

	}

	@Test
	public void Engage_02_Engagement() {
		try {
			appName = "enrollment_chat";

			// 检查是否存在异常退出 engagement的情况。
			Lib.selectMMApp(driver, "enrollment_cha");
			Lib.chkTextContent(driver, MatterMost.Header_Infor, "enrollment_chat");

			Lib.initStart(driver, new String[] { "English", "7621", "30080", "Cancel and close the session" });

			Lib.sendMsg(driver, "hello");

			Lib.chkMsg(driver, appName, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);

			Lib.selectChose(driver, "English");
			Lib.chkMsg(driver, appName, EnrollChat.If_you_have_to_drop_off_before_we_finish);

			Lib.sendMsg(driver, "abcedefg");
			Lib.chkMsg(driver, appName,
					EnrollChat.Please_provide_the_last_four_digits_only_of_your_social_security_number);

			Lib.sendMsg(driver, "abcedefgeff");
			Lib.chkMsg(driver, appName, EnrollChat.I_am_checking_for_a_couple_of_things);

			// ********************************************** Agent
			if (Lib.wait_Condition(driver_agent, 30, MatterMost.Accept))
				driver_agent.findElement(MatterMost.Accept).click();

			Lib.isEngageSuccess(driver_agent, "enrollment_chat", userName);

			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");

			Lib.chkMsg(driver_agent, appName, "abcedefgeff\n" + EnrollChat.If_you_have_to_drop_off_before_we_finish);

			// CUST send message to agent on CM.
			Lib.sendMsg(driver, "I need help Zip Code 7621!");
			Lib.chkMsg(driver, userName, "I need help Zip Code 7621!");

			// Agent receive and send message on CM.
			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");
			Lib.chkMsg(driver_agent, userName, "I need help Zip Code 7621!");
			Lib.sendMsg(driver_agent, "7621");
			Lib.chkMsg(driver_agent, appName, EnrollChat.Please_give_me_your_zip_code);

			// CUST： 检查CUST没有收到任何消息
			Lib.chkMsg(driver, userName, "I need help Zip Code 7621!");

			// Agent在CM模式下 转发消息给CUST
			driver_agent.findElement(MatterMost.Forward_ToCUST(0)).click();

			Lib.chkIsStatus(driver_agent, MatterMost.Mode_Monitor, "active");
			Lib.chkMsg(driver_agent, appName, EnrollChat.Please_give_me_your_zip_code);

			// CUST： 检查CUST收到消息
			Lib.chkMsg(driver, appName, EnrollChat.Please_give_me_your_zip_code);

			// 在MONITOR模式下CUST发送消息
			// CUST
			Lib.sendMsg(driver, "30080");
			Lib.chkMsg(driver, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			// AGENT
			Lib.chkMsg(driver_agent, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			// 在MONITOR模式下AGENT发送消息
			// AGENT
			Lib.selectChose(driver_agent, "Yes");
			Lib.chkIsStatus(driver_agent, MatterMost.Mode_CM, "active");
			Lib.chkMsgRegEx(driver_agent, appName,
					EnrollChat.This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx);

			// CUST： 检查CUST没有收到任何消息
			Lib.chkMsg(driver, appName, EnrollChat.Our_records_indicate_you_are_Wiley("Vernon, D, Beene",
					"807 Old Tree Stump Course in Smyrna"));

			driver_agent.findElement(MatterMost.Leave_TopBar).click();

			Lib.sendMsg(driver, "Cancel and close the session");
			Lib.chkMsg(driver, appName, "Goodbye.");
		} catch (Exception e) {
			// TODO: handle exception
			MMDriver.softAssert.fail(e.toString() + "@@\n\t");
		}
	}

}
