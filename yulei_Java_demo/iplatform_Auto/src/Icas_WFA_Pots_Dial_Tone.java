//package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import checkpoints.Icas;
import objectRepository.MatterMost;
import prepare.MMDriver;
import utils.Lib;

public class Icas_WFA_Pots_Dial_Tone {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() {
		this.driver = MMDriver.init();
		Lib.login_Mm(driver, "wmx@qq.com", "123456");
	}

	@Test
	public void Icas_01_DT() {
		driver.findElement(MatterMost.APP("icas")).click();

		Lib.initStart(driver, new String[] { "9991112401", "Cancel Report", "Yes" });

		Lib.sendMsg(driver, "hello");

		Lib.chkMsg(driver, "Hello. I am Charlie. Glad to work with you today."
				+ "What is the telephone number you seem to be having trouble with?");

		Lib.sendMsg(driver, "9991112401");
		Lib.sendMsg(driver, "clear session");

		Lib.sendMsg(driver, "hello");

		Lib.chkMsg(driver, "Hello. I am Charlie. Glad to work with you today."
				+ "What is the telephone number you seem to be having trouble with?");

		Lib.sendMsg(driver, "9991112401");
		Lib.chkMsg(driver, Icas.Ask_Please_verify_the_customers_name_and_address);

		Lib.chkMsg(driver, Icas.ChooseBox_MainMenu_MW);

		Lib.selectChose(driver, "Dial Tone");
		Lib.selectChose(driver, "No Dial Tone");
		Lib.selectChose(driver, "All Phones/All Calls (AP/AC)");
		Lib.chkMsg(driver, Icas.ChooseBox_MainMenu);

		Lib.sendMsg(driver, "Customer requests a Dispatch");
		Lib.sendMsg(driver, "Yes");
		Lib.sendMsg(driver, "Yes");
		Lib.sendMsg(driver, "9991112401");
		Lib.sendMsg(driver, "coc wmx");

		Lib.sendMsg(driver, "Clear Session");
		Lib.chkMsg(driver, "Goodbye.");

	}

}
