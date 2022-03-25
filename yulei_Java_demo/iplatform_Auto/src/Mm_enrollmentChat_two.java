//package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import checkpoints.EnrollChat;
import objectRepository.MatterMost;
import prepare.*;
import utils.Lib;

public class Mm_enrollmentChat_two {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() {
		this.driver = MMDriver.init();
		Lib.login_Mm(driver, "wmx@qq.com", "123456");

	}

	@Test
	// 02_Main_Medical_DecDental
	// Select medical; decline dental;
	public void enrollChat_04_Main_Medical_DecDental() {
		driver.findElement(MatterMost.APP("enrollment_chat")).click();

		Lib.initStart(driver, new String[] { "English", "7621", "30080", "Cancel and close the session" });

		Lib.sendMsg(driver, "hello");

		Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);

		Lib.sendMsg(driver, "English");
		Lib.chkMsg(driver, 
				"If you have to drop off before we finish, just call or log back in and we'll continue where we left off. "
						+ "Let's begin by verifying your identification. May I have the last four digits of your social?");

		Lib.sendMsg(driver, "7621");
		Lib.chkMsg(driver, "Please give me your zip code.");

		Lib.sendMsg(driver, "30080");

		Lib.chkMsg(driver, 
				"Our records indicate you are Vernon, D, Beene, living at 807 Old Tree Stump Course in Smyrna. Is this correct?"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "Yes");
		// Lib.chkMsg(driver, 
		// "This is your open enrollment in the CyberObject Corporation employee
		// benefits! I will guide you through this process."
		// + "\nI have your date of hire with CyberObject Corporation as 4/5/15.
		// How time flies."
		// + "\nPlease be informed your enrollment period is open until
		// 12/17/2017, so be certain you complete your enrollment before this
		// date."
		// + "\nYour company participates in the Blue Cross Blue Shield Medical
		// insurance network. Would you like to sign up?!"
		// + "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, 
				"Please choose which of the two medical plans from BCBS you would like. Either the Open Access, P O S plan or the High Deductible, H S A plan"
						+ "\n1. high deductible" + "\n2. open access");

		Lib.sendMsg(driver, "high deductible");
		Lib.chkMsg(driver, 
				"Now tell me who the high deductible medical insurance should apply to, whether just you, or plus spouse, child, or family."
						+ "\n1. employee" + "\n2. employee and children" + "\n3. employee and spouse"
						+ "\n4. whole family");

		Lib.sendMsg(driver, "employee");
		Lib.chkMsg(driver, 
				"All right, for employee coverage on the BCBS, health savings account, high deductible plan, your per pay period contribution from your paycheck will be $18.35. Do you want to pick this plan"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver, "Do you want to enroll in the voluntary Blue Cross blue shield connect dental insurance program?"
				+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "No");
		Lib.chkMsg(driver, "So you have decided to waive the voluntary dental coverage. Is that so?" + "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, "It shall be as you wish." + "\nGood news! You have completed the enrollment process. Well done."
				+ "\nSince you have declined both medical and dental, I must make an official note of it. Please say, I, Vernon, decline the coverage.");

		Lib.sendMsg(driver, "decline the coverage");
		Lib.chkMsg(driver, "Very well. That will do nicely."
				+ "\nDo you agree that the information provided here is complete and accurate?" + "\n1. Yes"
				+ "\n2. No");

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, 
				"Before you disconnect, I have to get your overall verbal signature that confirms the selections you made on this call. Please say I, your name, agree!");

		Lib.sendMsg(driver, "w mx");
		Lib.chkMsg(driver, 
				"We will submit the application to your employer. You may talk to your company for details. Thank you! Goodbye.");

	}

	@Test
	// 01_Main_Medical_Dental_DependentNone
	// Value:3741+30093; medical: open access+employee and children; dental:
	// employee and children; dependent:none;recap; info c&a:no
	public void enrollChat_01_Main_Medical_Dental_DependentNone() {
		driver.findElement(MatterMost.APP("enrollment_chat")).click();
	
		// 初始化
		Lib.initStart(driver, new String[] { "English", "3741", "30093", "Cancel and close the session" });
	
		Lib.sendMsg(driver, "hello");
	
		Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	
		Lib.sendMsg(driver, "English");
		Lib.chkMsg(driver, EnrollChat.If_you_have_to_drop_off_before_we_finish);
	
		Lib.sendMsg(driver, "3741");
		Lib.chkMsg(driver, EnrollChat.Please_give_me_your_zip_code);
	
		Lib.sendMsg(driver, "30093");
		Lib.chkMsg(driver, EnrollChat.Our_records_indicate_you_are_Wiley("Wiley, W, Williams","1619 Wilmington Trace in Berkeley Lake"));
	
		Lib.sendMsg(driver, "Yes");
		Lib.chkMsgRegEx(driver,
				EnrollChat.This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx);
	
		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, EnrollChat.Please_choose_which_of_the_two_medical_plans);
	
		Lib.sendMsg(driver, "open access");
		Lib.chkMsg(driver, EnrollChat.Now_tell_me_who_the_high_deductible_medical_insurance);
	
		Lib.sendMsg(driver, "employee and children");
		Lib.chkMsg(driver, EnrollChat.All_right_for_employee_coverage_on_the_BCBS("287.56"));
	
		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"Do you want to enroll in the voluntary Blue Cross blue shield connect dental insurance program?"
						+ "\n1. Yes" + "\n2. No");
	
		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, "Please specify who this Dental coverage will apply to." + "\n1. employee"
				+ "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole family");
	
		Lib.sendMsg(driver, "employee and children");
		Lib.chkMsg(driver,
				"Okay, for employee and children coverage on the dental plan, your per paycheck premium will be $22.65. Shall we choose this plan"
						+ "\n1. Yes" + "\n2. No");
	
		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"For your coverage, I will need some details about any dependents you may be covering. Are there any dependents you would like to add to your coverage at this time?"
						+ "\n1. Yes" + "\n2. No");
	
		Lib.sendMsg(driver, "no");
		Lib.chkMsg(driver, "Good news! You have completed the enrollment process. Well done."
				+ "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");
	
		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"You chose employee and children coverage on the BCBS, point of service, open access plan. You will have deducted each pay period the amount of $287.56. And then you got dental coverage for employee and children. It will cost you an extra $22.65."
						+ "\nDo you agree that the information provided here is complete and accurate?" + "\n1. Yes"
						+ "\n2. No");
	
		Lib.sendMsg(driver, "no");
		Lib.chkMsg(driver,
				"We already finished our enrollment application. Please contact your employer if you have any changes to make from this juncture forward."
						+ "Before you disconnect, I have to get your overall verbal signature that confirms the selections you made on this call. Please say I, your name, agree!");
	
		Lib.sendMsg(driver, "i, wiley williams, agree!");
		Lib.chkMsg(driver,
				"We will submit the application to your employer. You may talk to your company for details. Thank you! Goodbye.");
	
	}

}
