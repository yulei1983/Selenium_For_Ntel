package checkpoints;

public class AppBChkPoint {
	public final static String Please_login_with_iplatform_admin_user_to_new_APP = "Please login with iplatform admin user to new APP !";
	public final static String Please_enter_a_folder_name = "Please enter a folder name:";
	public final static String Please_enter_the_folder_name = "Please enter the folder name:";
	public final static String Please_enter_the_new_folder_name = "Please enter the new folder name:";
	public final static String Please_enter_the_new_file_name = "Please enter the new file name:";
	public final static String Input_Please_enter_your_notes_for_the_version = "Please enter your notes for the version.";
	public final static String Are_you_sure_to_discard_the_change_on_UI_Doc_file_testrex = "Are you sure to discard the change on UI_Doc_file_testrex.rex?";

	public final static String Are_you_sure_you_want_to_remove_this_services_excel = "Are you sure you want to remove this services_excel?";
	public final static String Are_you_sure_you_want_to_remove_this_services_webservice = "Are you sure you want to remove this services_webservice?";

	public final static String Are_you_sure_you_want_to_remove_this_App = "Are you sure you want to remove this App?";
	public final static String Are_you_sure_you_want_to_remove_this_App_template = "Are you sure you want to remove this App template?";
	public final static String Please_enter_the_file_name = "Please enter the file name:";
	public final static String ErrorMsg_File_UI_Org_Doc_file_Drink_already_exists$$$overwrite_it_please_delete_it_first = "File UI_Org_Doc_file_Drink.rex already exists! if you want to overwrite it, please delete it first.";
	public final static String ErrorMsg_Save_the_app_template$$$successfully = "Save the app template 'ui_app_test' successfully!";
	public final static String ErrorMsg_App_template_id_already_exists = "App template id already exists!";
	public final static String ErrorMsg_All_tables_have_been_added_successfully = "All tables have been added successfully.";

	public final static String CheckinMsg_Please_enter_your_notes_for_the_version = "Please enter your notes for the version.";

	public final static String DiscardMsg_Are_you_sure_to_discard_the_change_on_Testing = "Are you sure to discard the change on Testing?";
	public final static String DiscardMsg_Are_you_sure_to_discard_the_change_on_Test = "Are you sure to discard the change on Test?";

	
	public final static String Are_you_sure_you_want_to_remove_this_Database = "Are you sure you want to remove this database?";
	public final static String Are_you_sure_you_want_to_remove_this_file = "Are you sure you want to remove this file?";
	public final static String Are_you_sure_you_want_to_remove_this_folder = "Are you sure you want to remove this folder?";
	public final static String ConnectionInfo_Connection_successful = "Connection successful!";
	public final static String ErrorInformation_The_same_name_exists_in_the_current_directory = "The same name exists in the current directory.";
	public final static String Please_enter_the_data_name = "Please enter the data name:";
	public final static String Please_enter_the_database_name = "Please enter the database name:";
	public final static String Please_enter_a_database_name = "Please enter a database name:";
	public final static String You_havent_checked_out_any_file = "You haven't checked out any file!";

	
	public final static String Folder_UI_Org_Doc_folder_01_already_exists = "Folder UI_Org_Doc_folder_01 already exists! if you want to overwrite it, please delete it first.";
	public final static String There_are_files_checking_out_by_you$$$remove_this_folder = "There are files checking out by you. Are you sure you want to remove this folder?";

	
    public static String AssertMsg(String CheckPoint , String vExpected , String vActual) {
    	String s = "The line number is " + new Exception().getStackTrace()[1].getLineNumber() + "; "+ CheckPoint +" expected ["+vExpected+"] but found ["+vActual +"]@@\n\t,";
    return s;
    }
	
}
