package checkpoints;

public class EnrollChat {
	
	public final static String Sorry_I_did_not_get_that_Please_say_that_again = "Sorry, I did not get that. Please say that again?";
	
	public final static String Please_just_answer_Yes_or_No = "Please just answer \"Yes\" or \"No\"."
			+ "\n1. Yes" + "\n2. No";

	public final static String I_am_checking_for_a_couple_of_things = "I am checking for a couple of things. Please hold for a few moments...";

	public final static String Welcome_to_the_E2E_enroll_me_hotline = "Welcome to the E2E enroll me hotline. I am Charlie. Do you prefer to proceed in English or Spanish?"
			+ "\n1. English" + "\n2. Spanish";

	public final static String If_you_have_to_drop_off_before_we_finish = "If you have to drop off before we finish, just call or log back in and we'll continue where we left off. "
			+ "Let's begin by verifying your identification. May I have the last four digits of your social?";

	public final static String Please_give_me_your_zip_code = "Please give me your zip code.";

	public final static String Our_records_indicate_you_are_Wiley(String name, String address){ 

		return "Our records indicate you are " + name +", living at "+ address + ". Is this correct?"
			+ "\n1. Yes" + "\n2. No";}
	
//	return "Our records indicate you are +" + "Wiley, W, Williams" +", living at 1619 Wilmington Trace in Berkeley Lake. Is this correct?"
//	+ "\n1. Yes" + "\n2. No";}

	public final static String This_is_your_open_enrollment_in_the_CyberObject_Corporation_employee_benefits_RegEx = "This is your open enrollment in the CyberObject Corporation employee benefits! I will guide you through this process."
			+ "\nI have your date of hire with CyberObject Corporation as *";

	public final static String Please_choose_which_of_the_two_medical_plans = "Please choose which of the two medical plans from Blue Cross Blue Shield you would like. Either the Open Access, POS plan or the High Deductible, HSA plan."
			+ "\n1. high deductible" + "\n2. open access";

	public final static String Now_tell_me_who_the_high_deductible_medical_insurance = "Now tell me who the high deductible medical insurance should apply to, whether just you, or plus spouse, child, or family."
			+ "\n1. employee" + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole family";

	public static String All_right_for_employee_coverage_on_the_BCBS(String dolar) {
		return "All right, for employee coverage on the Blue Cross Blue Shield, health savings account, high deductible plan, your per pay period contribution from your paycheck will be $"
				+ dolar + ". Do you want to pick this plan?" + "\n1. Yes" + "\n2. No";
	}

	public final static String Do_you_want_to_enroll_in_the_voluntary_Blue_Cross_blue_shield = "Do you want to enroll in the voluntary Blue Cross blue shield connect dental insurance program?"
			+ "\n1. Yes" + "\n2. No";

	public final static String Please_specify_who_this_Dental_coverage_will_apply_to = "Please specify who this Dental coverage will apply to."
			+ "\n1. employee" + "\n2. employee and children" + "\n3. employee and spouse" + "\n4. whole family";

	public static String Okay_for_employee_coverage_on_the_dental_plan(String Dolar) {
		return "Okay, for employee coverage on the dental plan, your per paycheck premium will be $" + Dolar
				+ ". Shall we choose this plan?" + "\n1. Yes" + "\n2. No";
	}

	public final static String The_enrollment_process_has_now_been_completed = "The enrollment process has now been completed.\nDo you want a recap of your selections?"
			+ "\n1. Yes" + "\n2. No";

	public final static String Good_news_You_have_completed_the_enrollment_process = "Good news! You have completed the enrollment process. Well done."
			+ "\nDo you want a recap of your selections?" + "\n1. Yes" + "\n2. No";
	public final static String Before_you_disconnect_I_have_to_get_your_overall_verbal_signature = "Before you disconnect, I have to get your overall verbal signature that confirms the selections you made on this call. Please say I, your name, agree!";

	public final static String We_will_submit_the_application_to_your_employer = "We will submit the application to your employer. You may talk to your company for details. Thank you! Goodbye.";

	public final static String Please_provide_the_last_four_digits_only_of_your_social_security_number = "Please provide the last four digits only of your social security number. Any information you provide is completely confidential and safe with us.";
}
