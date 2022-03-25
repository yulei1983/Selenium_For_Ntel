//package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import checkpoints.*;
import prepare.*;
import utils.Lib;

public class Mm_enrollmentChat {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() {
		this.driver = MMDriver.init();
		Lib.login_Mm(driver, "wmx@qq.com", "123456");

	}

	@AfterClass
	public void afterClass() {
		Lib.logout_Mm(driver);
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
	// 01_Main_Medical_Dental_01
	// Value:3741+30093; medical: high deductible+employee; dental: employee
	public void enrollChat_01_Main_Medical_Dental() {
		Lib.selectMMApp(driver, "enrollment_cha");

		Lib.initStart(driver, new String[] { "English", "3741", "30093", "Cancel and close the session" });

		Lib.sendMsg(driver, "hello");

		Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);

		Lib.sendMsg(driver, "English");
		Lib.chkMsg(driver, EnrollChat.If_you_have_to_drop_off_before_we_finish);

		Lib.sendMsg(driver, "3741");
		Lib.chkMsg(driver, EnrollChat.Please_give_me_your_zip_code);

		Lib.sendMsg(driver, "30093");

		Lib.chkMsg(driver, EnrollChat.Our_records_indicate_you_are_Wiley("Wiley, W, Williams",
				"1619 Wilmington Trace in Berkeley Lake"));

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsgRegEx(driver,
				EnrollChat.This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx);

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, EnrollChat.Please_choose_which_of_the_two_medical_plans);

		Lib.sendMsg(driver, "high deductible");
		Lib.chkMsg(driver, EnrollChat.Now_tell_me_who_the_high_deductible_medical_insurance);

		Lib.sendMsg(driver, "employee");
		Lib.chkMsg(driver, EnrollChat.All_right_for_employee_coverage_on_the_BCBS("18.35"));

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver, EnrollChat.Do_you_want_to_enroll_in_the_voluntary_Blue_Cross_blue_shield);

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, EnrollChat.Please_specify_who_this_Dental_coverage_will_apply_to);

		Lib.sendMsg(driver, "employee");
		Lib.chkMsg(driver, EnrollChat.Okay_for_employee_coverage_on_the_dental_plan("26.52"));

		Lib.sendMsg(driver, "Yes");

		Lib.chkMsg(driver, EnrollChat.The_enrollment_process_has_now_been_completed);

		// Lib.chkMsg(driver,
		// EnrollChat.Good_news_You_have_completed_the_enrollment_process);
		//
		// Lib.sendMsg(driver, "no");
		// Lib.chkMsg(driver,
		// EnrollChat.Before_you_disconnect_I_have_to_get_your_overall_verbal_signature);
		//
		// Lib.sendMsg(driver, "i, wiley williams, agree!");
		// Lib.chkMsg(driver,
		// EnrollChat.We_will_submit_the_application_to_your_employer);

	}

	@Test
	// 02_Main_Medical_Dental_DependentFather
	// Value:3741+30093; medical: open access+employee and spouse; dental:
	// employee and spouse; dependent:father; recap; info c&a:yes
	public void enrollChat_02_Main_Medical_Dental_DependentFather() {
		Lib.selectMMApp(driver, "enrollment_chat");

		Lib.initStart(driver, new String[] { "English", "3741", "30093", "Cancel and Close the session" });
		Lib.sendMsg(driver, "hello");

		Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);

		Lib.sendMsg(driver, "English");
		Lib.chkMsg(driver, EnrollChat.If_you_have_to_drop_off_before_we_finish);

		Lib.sendMsg(driver, "3741");
		Lib.chkMsg(driver, "Please give me your zip code.");

		Lib.sendMsg(driver, "30093");

		Lib.chkMsg(driver, EnrollChat.Our_records_indicate_you_are_Wiley("Wiley, W, Williams",
				"1619 Wilmington Trace in Berkeley Lake"));

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsgRegEx(driver,
				EnrollChat.This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx);

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, EnrollChat.Please_choose_which_of_the_two_medical_plans);

		Lib.sendMsg(driver, "open access");
		Lib.chkMsg(driver,
				"Now tell me who the open access medical insurance should apply to, whether just you, or plus spouse, child, or family."
						+ "\n1. employee" + "\n2. employee and children" + "\n3. employee and spouse"
						+ "\n4. whole family");

		Lib.sendMsg(driver, "employee and spouse");
		Lib.chkMsg(driver,
				"All right, for employee and spouse coverage on the BCBS, point of service, open access plan, your per pay period contribution from your"
						+ "paycheck will be $341.25. Do you want to pick this plan" + "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"Do you want to enroll in the voluntary Blue Cross blue shield connect dental insurance program?"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver, "Please specify who this Dental coverage will apply to." + "\n1. employee"
				+ "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole family");

		Lib.sendMsg(driver, "employee and spouse");
		Lib.chkMsg(driver,
				"Okay, for employee and spouse coverage on the dental plan, your per paycheck premium will be $26.52. Shall we choose this plan"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"For your coverage, I will need some details about any dependents you may be covering. Are there any dependents you would like to add to your coverage at this time?"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "Yes");
		Lib.chkMsg(driver,
				"Spouse and dependent information must be completed for all additional dependents (if any) to be covered under this coverage. An eligible"
						+ "dependent may be your spouse or domestic partner, your children, or your spouse's or domestic partner's children, to the end of the calendar month in which they turn age twenty six, unless they qualify as a disabled person."
						+ "\nWhat is the relationship to you of the dependent you would like to add next?" + "\n1. son"
						+ "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");

		Lib.sendMsg(driver, "father");
		Lib.chkMsg(driver,
				"Usually, just your legal spouse and dependent children are eligible for the insurance coverage. You would need to talk to your group insurance provider in order to determine the cost of insuring additional family members. Do you want to give me a different dependent?"
						+ "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "no");
		Lib.chkMsg(driver, "Good news! You have completed the enrollment process. Well done."
				+ "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"You chose employee and spouse coverage on the BCBS, point of service, open access plan. You will have deducted each pay period the amount of $341.25. And then you got dental coverage for employee and spouse. It will cost you an extra $26.52."
						+ "\nDo you agree that the information provided here is complete and accurate?" + "\n1. Yes"
						+ "\n2. No");

		Lib.sendMsg(driver, "yes");
		Lib.chkMsg(driver,
				"Before you disconnect, I have to get your overall verbal signature that confirms the selections you made on this call. Please say I, your name, agree!");

		Lib.sendMsg(driver, "i, wiley williams, agree!");
		Lib.chkMsg(driver,
				"We will submit the application to your employer. You may talk to your company for details. Thank you! Goodbye.");

	}
	//
	// @Test
	// // 01_Main_Medical_Dental_DependentSon
	// // Value:3741+30093; medical: high+whole family; dental: whole family;
	// // dependent:son; NOrecap; info c&a:yes
	// public void enrollChat_01_Main_Medical_Dental_DependentSon() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.initStart(driver, new String[] { "English", "3741", "30093", "Clear
	// the history and close" });
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "3741");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30093");
	// Lib.chkMsg(driver,
	// "Our records indicate you are Wiley, W, Williams, living at 1619
	// Wilmington Trace in Berkeley Lake. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 11/8/10.
	// How time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Please choose which of the two medical plans from BCBS you would like.
	// Either the Open Access, P O S plan or the High Deductible, H S A plan"
	// + "\n1. high deductible" + "\n2. open access");
	//
	// Lib.sendMsg(driver, "high deductible");
	// Lib.chkMsg(driver,
	// "Now tell me who the high deductible medical insurance should apply to,
	// whether just you, or plus spouse, child, or family."
	// + "\n1. employee" + "\n2. employee and children" + "\n3. employee and
	// spouse"
	// + "\n4. whole family");
	//
	// Lib.sendMsg(driver, "whole family");
	// Lib.chkMsg(driver,
	// "All right, for whole family coverage on the BCBS, health savings
	// account, high deductible plan, your per pay period contribution from your
	// paycheck will be $58.71. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you want to enroll in the voluntary Blue Cross
	// blue shield connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "whole family");
	// Lib.chkMsg(driver,
	// "Okay, for whole family coverage on the dental plan, your per paycheck
	// premium will be $82.60. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver,
	// "For your coverage, I will need some details about any dependents you may
	// be covering. Are there any dependents you would like to add to your
	// coverage at this time?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Spouse and dependent information must be completed for all additional
	// dependents (if any) to be covered under this coverage. An eligible
	// dependent may be your spouse or domestic partner, your children, or your
	// spouse's or domestic partner's children, to the end of the calendar month
	// in which they turn age twenty six, unless they qualify as a disabled
	// person."
	// + "\nWhat is the relationship to you of the dependent you would like to
	// add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// Lib.sendMsg(driver, "son");
	// Lib.chkMsg(driver, "Is their last name also Williams?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please spell their first name.");
	//
	// Lib.sendMsg(driver, "terry");
	// Lib.chkMsg(driver, "That is terry. Right?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "And please" + "\n.what is their middle initial?");
	//
	// Lib.sendMsg(driver, "t");
	// Lib.chkMsg(driver, "Middle initial t. Yes?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Good. Could you give me their social security
	// number?");
	//
	// Lib.sendMsg(driver, "111111111");
	// Lib.chkMsg(driver, "Confirming. I got 111111111. Is that right for this
	// dependent?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Can you confirm please for me the gender of this
	// person, male or female?" + "\n1. female"
	// + "\n2. male");
	//
	// Lib.sendMsg(driver, "male");
	// Lib.chkMsg(driver, "Please give me their birth date, including the
	// year.");
	//
	// Lib.sendMsg(driver, "01-01-01");
	// Lib.chkMsg(driver, "That birth date was 01-01-01, yes or no?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Is this person considered legally disabled?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you have another dependent to add?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver, "Good news! You have completed the enrollment process.
	// Well done."
	// + "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver,
	// "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "i, wiley williams, agree!");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 01_Main_Medical_Dental_DependentAll
	// // Value:3741+30093; medical: high+whole family; dental: whole family;
	// // dependent:All; NOrecap; info c&a:yes
	// public void enrollChat_01_Main_Medical_Dental_DependentAll() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	//
	// Lib.initStart(driver, new String[] { "English", "3741", "30093", "Clear
	// the history and close" });
	//
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver, EnrollChat.If_you_have_to_drop_off_before_we_finish);
	//
	// Lib.sendMsg(driver, "3741");
	// Lib.chkMsg(driver, EnrollChat.Please_give_me_your_zip_code);
	//
	// Lib.sendMsg(driver, "30093");
	//
	// Lib.chkMsg(driver, EnrollChat.Our_records_indicate_you_are_Wiley);
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 11/8/10.
	// How time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// EnrollChat.Please_choose_which_of_the_two_medical_plans);
	//
	// Lib.sendMsg(driver, "high deductible");
	// Lib.chkMsg(driver,
	// EnrollChat.Now_tell_me_who_the_high_deductible_medical_insurance);
	//
	// Lib.sendMsg(driver, "whole family");
	// Lib.chkMsg(driver,
	// "All right, for whole family coverage on the BCBS, health savings
	// account, high deductible plan, your per pay period contribution from your
	// paycheck will be $58.71. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you want to enroll in the voluntary Blue Cross
	// blue shield connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "whole family");
	// Lib.chkMsg(driver,
	// "Okay, for whole family coverage on the dental plan, your per paycheck
	// premium will be $82.60. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver,
	// "For your coverage, I will need some details about any dependents you may
	// be covering. Are there any dependents you would like to add to your
	// coverage at this time?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Spouse and dependent information must be completed for all additional
	// dependents (if any) to be covered under this coverage. An eligible
	// dependent may be your spouse or domestic partner, your children, or your
	// spouse's or domestic partner's children, to the end of the calendar month
	// in which they turn age twenty six, unless they qualify as a disabled
	// person."
	// + "\nWhat is the relationship to you of the dependent you would like to
	// add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// // 1st dependent:son
	// Lib.sendMsg(driver, "son");
	// Lib.chkMsg(driver, "Is their last name also Williams?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please spell their first name.");
	//
	// Lib.sendMsg(driver, "terry");
	// Lib.chkMsg(driver, "That is terry. Right?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "And please" + "\n.what is their middle initial?");
	//
	// Lib.sendMsg(driver, "t");
	// Lib.chkMsg(driver, "Middle initial t. Yes?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Good. Could you give me their social security
	// number?");
	//
	// Lib.sendMsg(driver, "111111111");
	// Lib.chkMsg(driver, "Confirming. I got 111111111. Is that right for this
	// dependent?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Can you confirm please for me the gender of this
	// person, male or female?" + "\n1. female"
	// + "\n2. male");
	//
	// Lib.sendMsg(driver, "male");
	// Lib.chkMsg(driver, "Please give me their birth date, including the
	// year.");
	//
	// Lib.sendMsg(driver, "01-01-01");
	// Lib.chkMsg(driver, "That birth date was 01-01-01, yes or no?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Is this person considered legally disabled?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you have another dependent to add?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "What is the relationship to you of the dependent you
	// would like to add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// // 2nd dependent: domestic partner
	// Lib.sendMsg(driver, "domestic partner");
	// Lib.chkMsg(driver, "Is their last name also Williams?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please spell their first name.");
	//
	// Lib.sendMsg(driver, "martha");
	// Lib.chkMsg(driver, "That is martha. Right?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "And please" + "\n.what is their middle initial?");
	//
	// Lib.sendMsg(driver, "m");
	// Lib.chkMsg(driver, "Middle initial m. Yes?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Good. Could you give me their social security
	// number?");
	//
	// Lib.sendMsg(driver, "222222222");
	// Lib.chkMsg(driver, "Confirming. I got 222222222. Is that right for this
	// dependent?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Can you confirm please for me the gender of this
	// person, male or female?" + "\n1. female"
	// + "\n2. male");
	//
	// Lib.sendMsg(driver, "female");
	// Lib.chkMsg(driver, "Please give me their birth date, including the
	// year.");
	//
	// Lib.sendMsg(driver, "12-12-97");
	// Lib.chkMsg(driver, "That birth date was 12-12-97, yes or no?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Is this person considered legally disabled?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver, "Do you have another dependent to add?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "What is the relationship to you of the dependent you
	// would like to add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// // 3nd dependent: myself
	// Lib.sendMsg(driver, "myself");
	// Lib.chkMsg(driver, "Is their last name also Williams?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please spell their first name.");
	//
	// Lib.sendMsg(driver, "wiley");
	// Lib.chkMsg(driver, "That is wiley. Right?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "And please" + "\n.what is their middle initial?");
	//
	// Lib.sendMsg(driver, "w");
	// Lib.chkMsg(driver, "Middle initial t. Yes?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Good. Could you give me their social security
	// number?");
	//
	// Lib.sendMsg(driver, "359723741");
	// Lib.chkMsg(driver, "Confirming. I got 359723741. Is that right for this
	// dependent?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Can you confirm please for me the gender of this
	// person, male or female?" + "\n1. female"
	// + "\n2. male");
	//
	// Lib.sendMsg(driver, "male");
	// Lib.chkMsg(driver, "Please give me their birth date, including the
	// year.");
	//
	// Lib.sendMsg(driver, "11/14/10");
	// Lib.chkMsg(driver, "That birth date was 11/14/10, yes or no?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Is this person considered legally disabled?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you have another dependent to add?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "What is the relationship to you of the dependent you
	// would like to add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// // 4th dependent: wife
	// Lib.sendMsg(driver, "wife");
	// Lib.chkMsg(driver, "Is their last name also Williams?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please spell their first name.");
	//
	// Lib.sendMsg(driver, "mandy");
	// Lib.chkMsg(driver, "That is mandy. Right?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "And please" + "\n.what is their middle initial?");
	//
	// Lib.sendMsg(driver, "q");
	// Lib.chkMsg(driver, "Middle initial q. Yes?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Good. Could you give me their social security
	// number?");
	//
	// Lib.sendMsg(driver, "444444444");
	// Lib.chkMsg(driver, "Confirming. I got 444444444. Is that right for this
	// dependent?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Can you confirm please for me the gender of this
	// person, male or female?" + "\n1. female"
	// + "\n2. male");
	//
	// Lib.sendMsg(driver, "female");
	// Lib.chkMsg(driver, "Please give me their birth date, including the
	// year.");
	//
	// Lib.sendMsg(driver, "06-11-00");
	// Lib.chkMsg(driver, "That birth date was 06-11-00, yes or no?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Is this person considered legally disabled?" + "\n1.
	// Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you have another dependent to add?" + "\n1. Yes" +
	// "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "What is the relationship to you of the dependent you
	// would like to add next?" + "\n1. son"
	// + "\n2. domestic partner" + "\n3. father" + "\n4. myself" + "\n5. wife");
	//
	// // 5th dependent: father
	// Lib.sendMsg(driver, "father");
	// Lib.chkMsg(driver,
	// "Usually, just your legal spouse and dependent children are eligible for
	// the insurance coverage. You would need to talk to your group insurance
	// provider in order to determine the cost of insuring additional family
	// members. Do you want to give me a different dependent?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver, "Good news! You have completed the enrollment process.
	// Well done."
	// + "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver,
	// "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "i, wiley williams, agree!");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 01_Main_ReselectMedical_ReselectDental
	// // Value:7621+30080; reselect medical; reselect dental
	// public void enrollChat_01_Main_ReselectMedical_ReselectDental() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.initStart(driver, new String[] { "English", "3741", "30093", "Clear
	// the history and close" });
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "7621");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30080");
	// Lib.chkMsg(driver,
	// "Our records indicate you are Vernon, D, Beene, living at 807 Old Tree
	// Stump Course in Smyrna. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 4/5/15. How
	// time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Please choose which of the two medical plans from BCBS you would like.
	// Either the Open Access, P O S plan or the High Deductible, H S A plan"
	// + "\n1. high deductible" + "\n2. open access");
	//
	// Lib.sendMsg(driver, "high deductible");
	// Lib.chkMsg(driver,
	// "Now tell me who the high deductible medical insurance should apply to,
	// whether just you, or plus spouse, child, or family."
	// + "\n1. employee" + "\n2. employee and children" + "\n3. employee and
	// spouse"
	// + "\n4. whole family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "All right, for employee coverage on the BCBS, health savings account,
	// high deductible plan, your per pay period contribution from your paycheck
	// will be $18.35. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver,
	// "Do you want to select a different medical plan; Answer yes to re-select
	// or No to decline medical coverage all together."
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Please choose which of the two medical plans from BCBS you would like.
	// Either the Open Access, P O S plan or the High Deductible, H S A plan"
	// + "\n1. high deductible" + "\n2. open access");
	//
	// Lib.sendMsg(driver, "open access");
	// Lib.chkMsg(driver,
	// "Now tell me who the open access medical insurance should apply to,
	// whether just you, or plus spouse, child, or family."
	// + "\n1. employee" + "\n2. employee and children" + "\n3. employee and
	// spouse"
	// + "\n4. whole family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "All right, for employee coverage on the BCBS, point of service, open
	// access plan, your per pay period contribution from your paycheck will be
	// $0. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Do you want to enroll in the voluntary Blue Cross
	// blue shield connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "Okay, for employee coverage on the dental plan, your per paycheck
	// premium will be $26.52. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver,
	// "Do you still want to look at dental but covering different people than
	// your previous selection? Answer Yes to choose different dental coverage,
	// or No to waive dental coverage all together."
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "employee and children");
	// Lib.chkMsg(driver,
	// "Okay, for employee and children coverage on the dental plan, your per
	// paycheck premium will be $22.65. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "For your coverage, I will need some details about any dependents you may
	// be covering. Are there any dependents you would like to add to your
	// coverage at this time?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver, "Good news! You have completed the enrollment process.
	// Well done."
	// + "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver,
	// "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "w mx");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 02_Main_DecMedical_DecDental_NoPlanOverView
	// // Decline medican and dental without reviewing the plan; DecMedReason:
	// // enrolled in individual coverage
	// public void enrollChat_02_Main_DecMedical_DecDental_NoPlanOverview() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.initStart(driver, new String[] { "English", "7621", "30080", "Clear
	// the history and close" });
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "7621");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30080");
	// Lib.chkMsg(driver,
	// "Our records indicate you are Vernon, D, Beene, living at 807 Old Tree
	// Stump Course in Smyrna. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 4/5/15. How
	// time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "Do you mind please indicating your reason for
	// declining medical coverage?"
	// + "\n1. enrolled in individual coverage" + "\n2. medicare" + "\n3. no
	// coverage"
	// + "\n4. enrolled in other insurance" + "\n5. others" + "\n6. covered by
	// spouse coverage"
	// + "\n7. spouse covered by employer");
	//
	// Lib.sendMsg(driver, "enrolled in individual coverage");
	// Lib.chkMsg(driver, "Sounds good."
	// + "\nDo you want to enroll in the voluntary Blue Cross blue shield
	// connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "So you have decided to waive the voluntary dental
	// coverage. Is that so?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "It shall be as you wish." + "\nGood news! You have
	// completed the enrollment process. Well done."
	// + "\nSince you have declined both medical and dental, I must make an
	// official note of it. Please say, I, Vernon, decline the coverage.");
	//
	// Lib.sendMsg(driver, "decline the coverage");
	// Lib.chkMsg(driver, "Very well. That will do nicely."
	// + "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes"
	// + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "w mx");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 02_Main_DecMedical_DecDental_AfterPlanOverview
	// // Decline medican and dental after reviewing the plan; DecMedReason: no
	// // coverage
	// public void enrollChat_02_Main_DecMedical_DecDental_AfterPlanOverview() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.initStart(driver, new String[] { "English", "3741", "30093", "Clear
	// the history and close" });
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "7621");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30080");
	// Lib.chkMsg(driver,
	// "Our records indicate you are Vernon, D, Beene, living at 807 Old Tree
	// Stump Course in Smyrna. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 4/5/15. How
	// time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Please choose which of the two medical plans from BCBS you would like.
	// Either the Open Access, P O S plan or the High Deductible, H S A plan"
	// + "\n1. high deductible" + "\n2. open access");
	//
	// Lib.sendMsg(driver, "high deductible");
	// Lib.chkMsg(driver,
	// "Now tell me who the high deductible medical insurance should apply to,
	// whether just you, or plus spouse, child, or family."
	// + "\n1. employee" + "\n2. employee and children" + "\n3. employee and
	// spouse"
	// + "\n4. whole family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "All right, for employee coverage on the BCBS, health savings account,
	// high deductible plan, your per pay period contribution from your paycheck
	// will be $18.35. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver,
	// "Do you want to select a different medical plan; Answer yes to re-select
	// or No to decline medical coverage all together."
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "Do you mind please indicating your reason for
	// declining medical coverage?"
	// + "\n1. enrolled in individual coverage" + "\n2. medicare" + "\n3. no
	// coverage"
	// + "\n4. enrolled in other insurance" + "\n5. others" + "\n6. covered by
	// spouse coverage"
	// + "\n7. spouse covered by employer");
	//
	// Lib.sendMsg(driver, "no coverage");
	// Lib.chkMsg(driver, "Sounds good."
	// + "\nDo you want to enroll in the voluntary Blue Cross blue shield
	// connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "Okay, for employee coverage on the dental plan, your per paycheck
	// premium will be $26.52. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver,
	// "Do you still want to look at dental but covering different people than
	// your previous selection? Answer Yes to choose different dental coverage,
	// or No to waive dental coverage all together."
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "So you have decided to waive the voluntary dental
	// coverage. Is that so?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "It shall be as you wish." + "\nGood news! You have
	// completed the enrollment process. Well done."
	// + "\nSince you have declined both medical and dental, I must make an
	// official note of it. Please say, I, Vernon, decline the coverage.");
	//
	// Lib.sendMsg(driver, "decline the coverage");
	// Lib.chkMsg(driver, "Very well. That will do nicely."
	// + "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes"
	// + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "w mx");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 02_Main_DecMedical_Dental
	// // Decline medical; select dental; DecMedReason: medicare
	// public void enrollChat_02_Main_DecMedical_Dental() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.initStart(driver, new String[] { "English", "7621", "30080", "Clear
	// the history and close" });
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "7621");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30080");
	// Lib.chkMsg(driver,
	// "Our records indicate you are Vernon, D, Beene, living at 807 Old Tree
	// Stump Course in Smyrna. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 4/5/15. How
	// time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "Do you mind please indicating your reason for
	// declining medical coverage?"
	// + "\n1. enrolled in individual coverage" + "\n2. medicare" + "\n3. no
	// coverage"
	// + "\n4. enrolled in other insurance" + "\n5. others" + "\n6. covered by
	// spouse coverage"
	// + "\n7. spouse covered by employer");
	//
	// Lib.sendMsg(driver, "medicare");
	// Lib.chkMsg(driver, "Sounds good."
	// + "\nDo you want to enroll in the voluntary Blue Cross blue shield
	// connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Please specify who this Dental coverage will apply
	// to." + "\n1. employee"
	// + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole
	// family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "Okay, for employee coverage on the dental plan, your per paycheck
	// premium will be $26.52. Shall we choose this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "Good news! You have completed the enrollment process.
	// Well done."
	// + "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "no");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "i, wiley williams, agree!");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }
	//
	// @Test
	// // 02_Main_Medical_DecDental
	// // Select medical; decline dental;
	// public void enrollChat_02_Main_Medical_DecDental() {
	// driver.findElement(MatterMost.APP_enrollment_chat).click();
	// Lib.wait_Sleep(2000);
	//
	// Lib.initStart(driver, new String[] { "English", "7621", "30080", "Clear
	// the history and close" });
	//
	// Lib.sendMsg(driver, "hello");
	//
	// Lib.chkMsg(driver, EnrollChat.Welcome_to_the_E2E_enroll_me_hotline);
	//
	// Lib.selectChose("English");
	// Lib.chkMsg(driver,
	// "If you have to drop off before we finish, just call or log back in and
	// we'll continue where we left off. "
	// + "Let's begin by verifying your identification. May I have the last four
	// digits of your social?");
	//
	// Lib.sendMsg(driver, "7621");
	// Lib.chkMsg(driver, "Please give me your zip code.");
	//
	// Lib.sendMsg(driver, "30080");
	//
	// Lib.chkMsg(driver,
	// "Our records indicate you are Vernon, D, Beene, living at 807 Old Tree
	// Stump Course in Smyrna. Is this correct?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "This is your open enrollment in the CyberObject Corporation employee
	// benefits! I will guide you through this process."
	// + "\nI have your date of hire with CyberObject Corporation as 4/5/15. How
	// time flies."
	// + "\nPlease be informed your enrollment period is open until 12/17/2017,
	// so be certain you complete your enrollment before this date."
	// + "\nYour company participates in the Blue Cross Blue Shield Medical
	// insurance network. Would you like to sign up?!"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Please choose which of the two medical plans from BCBS you would like.
	// Either the Open Access, P O S plan or the High Deductible, H S A plan"
	// + "\n1. high deductible" + "\n2. open access");
	//
	// Lib.sendMsg(driver, "high deductible");
	// Lib.chkMsg(driver,
	// "Now tell me who the high deductible medical insurance should apply to,
	// whether just you, or plus spouse, child, or family."
	// + "\n1. employee" + "\n2. employee and children" + "\n3. employee and
	// spouse"
	// + "\n4. whole family");
	//
	// Lib.sendMsg(driver, "employee");
	// Lib.chkMsg(driver,
	// "All right, for employee coverage on the BCBS, health savings account,
	// high deductible plan, your per pay period contribution from your paycheck
	// will be $18.35. Do you want to pick this plan"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "yes");
	// Lib.chkMsg(driver, "Do you want to enroll in the voluntary Blue Cross
	// blue shield connect dental insurance program?"
	// + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "No");
	// Lib.chkMsg(driver, "So you have decided to waive the voluntary dental
	// coverage. Is that so?" + "\n1. Yes" + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver, "It shall be as you wish." + "\nGood news! You have
	// completed the enrollment process. Well done."
	// + "\nSince you have declined both medical and dental, I must make an
	// official note of it. Please say, I, Vernon, decline the coverage.");
	//
	// Lib.sendMsg(driver, "decline the coverage");
	// Lib.chkMsg(driver, "Very well. That will do nicely."
	// + "\nDo you agree that the information provided here is complete and
	// accurate?" + "\n1. Yes"
	// + "\n2. No");
	//
	// Lib.sendMsg(driver, "Yes");
	// Lib.chkMsg(driver,
	// "Before you disconnect, I have to get your overall verbal signature that
	// confirms the selections you made on this call. Please say I, your name,
	// agree!");
	//
	// Lib.sendMsg(driver, "w mx");
	// Lib.chkMsg(driver,
	// "We will submit the application to your employer. You may talk to your
	// company for details. Thank you! Goodbye.");
	//
	// }

}
