package Object_Repository;

import java.io.File;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class CheckPoints {
//    public static String getMessage(String JTextPane) {
//    	String expected;
//    	
//    	
//		return expected;
//	}
	
	public static String getValueFromExcel(String CheckpointName) {
	    try {
			File file = new File("./src/Object_Repository/CheckPointsList.xlsx");
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
	        int tabIndex =0;
//	        List<List<String>> list= new ArrayList<List<String>>();
	        Sheet sheet = xssfWorkbook.getSheetAt(tabIndex);
	        Row row;
	        Cell ValueCell;
	        Cell CheckPointCell;
	        for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			     row = sheet.getRow(i);
                 if(row == null) {
                     continue;
                   }
                 CheckPointCell = row.getCell(0);
                 if (CheckPointCell.getStringCellValue().compareTo(CheckpointName)==0) {
                     ValueCell = row.getCell(1);
                     if(ValueCell == null) {
                         continue;
                         }
//                     System.out.println("xlsx表格中读取的数据" + cell.getStringCellValue());
                     return ValueCell.getStringCellValue();
				} else {
					continue;
				}
			}
            return "CheckPoint \""+ CheckpointName+"\""+"is not exist";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "CheckPoint \""+ CheckpointName+"\""+"is not exist";
	    }
	}
    
	public static void main(String[] args) {
	    	 try {
	    		 Pattern intPattern = Pattern.compile("We can have your service repaired on \\d{2}-\\d{2}-\\d{2}\\. Will you\\nbe available from 0800A to 1200P\\?");
	  			Matcher m = intPattern.matcher("We can have your service repaired on 04-25-22. Will you\nbe available from 0800A to 1200P?");
	  			System.out.print(m.matches()); 
	  			
//	    		 System.out.print(getValueFromExcel("Ask_We_can_have_your_service_repaired_on_$rex_Date$"));
	  			
	  			
//	 			File file = new File("./src/Object_Repository/CheckPointsList.xlsx");
//	 	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
//	 	        XSSFWorkbook tempxssfWorkbook = new XSSFWorkbook();
//	 	        int tabIndex =0;
//	 	        Sheet sheet = xssfWorkbook.getSheetAt(tabIndex);
//	 	        Sheet tempsheet = tempxssfWorkbook.createSheet("1");
//	 	        Row row;
//	 	        Row temprow;
//	 	        Cell tempCell;
//	 	        Cell CheckPointCell; 	       
//	 	        for (int i = 1; i < sheet.getLastRowNum() ; i++) {
//	 			     row = sheet.getRow(i);
//	                 CheckPointCell = row.getCell(0);
//	                 temprow = tempsheet.createRow(i);
//	                 tempCell = temprow.createCell(0);
//	                 tempCell.
//    setCellValue(	"public static String " + CheckPointCell.getStringCellValue()+"(){\n String checkpoint = \""+CheckPointCell.getStringCellValue()+"\";\n return getValueFromExcel(checkpoint);\n}");
//	 			}
//	 	        try (FileOutputStream outputStream = new FileOutputStream("./src/Object_Repository/temp.xlsx")) {
//	 	        	tempxssfWorkbook.write(outputStream);
//	 	        }
	 	    } catch (Exception e) {
	 	        e.printStackTrace();
	 	    }
	}
	
	public static String DataInput_OK() {
		String checkpoint = "DataInput_OK";
		return getValueFromExcel(checkpoint);
	}
	
	public static String DataInput_Enter_the_call_forwarding_number() {
		String checkpoint = "DataInput_Enter_the_call_forwarding_number";
		return getValueFromExcel(checkpoint);
	}
	
	public static String information_CLOSE() {
		String checkpoint = "information_CLOSE";
		return getValueFromExcel(checkpoint);
	}
	
	public static String DataInput_Cancel() {
		String checkpoint = "DataInput_Cancel";
		return getValueFromExcel(checkpoint);
	}
	
	public static String Ask_Have_you_already_contacted_NDC_for$$$override_$ID_authorization_required$() {
		String checkpoint = "Ask_Have_you_already_contacted_NDC_for$$$override_$ID_authorization_required$";
		return getValueFromExcel(checkpoint);
	}
	
	public static String AM_Advise_the_customer_to_call_the_ATT_CPE_Cust$$$1_800_667_2118$$$phone_is_under_warranty() {
		String checkpoint = "AM_Advise_the_customer_to_call_the_ATT_CPE_Cust$$$1_800_667_2118$$$phone_is_under_warranty";
		return getValueFromExcel(checkpoint);
	}
	
	public static String Zip_finder_error_999199_not_found_in_NPANXX_table() {
		String checkpoint = "Zip_finder_error_999199_not_found_in_NPANXX_table";
		return getValueFromExcel(checkpoint);
	}
	
	public static String Ask_We_can_have_your_service_repaired_on_$rex_Date$() {
        String checkpoint = "Ask_We_can_have_your_service_repaired_on_$rex_Date$";
		return getValueFromExcel(checkpoint);
	}

		public static String Yes_2(){
		 String checkpoint = "Yes_2";
		 return getValueFromExcel(checkpoint);
		}
		public static String Yes(){
		 String checkpoint = "Yes";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning_There_is_less_than_4_hours$$$Would_you_like_to_change_the_appointment_hours$(){
		 String checkpoint = "Warning_There_is_less_than_4_hours$$$Would_you_like_to_change_the_appointment_hours$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning_Please_select_one$(){
		 String checkpoint = "Warning_Please_select_one$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning_OK_5(){
		 String checkpoint = "Warning_OK_5";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning_OK(){
		 String checkpoint = "Warning_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning_Commitment_time_is_less_than_4_hours_from_the_current_time$(){
		 String checkpoint = "Warning_Commitment_time_is_less_than_4_hours_from_the_current_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_Warm_Transfer_to_Special_Services_at_1_203_771_2247$(){
		 String checkpoint = "Warning$_Warm_Transfer_to_Special_Services_at_1_203_771_2247$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_Warm_Transfer_the_PSAP_to_the_local_state$s_ATT_Security_office$(){
		 String checkpoint = "Warning$_Warm_Transfer_the_PSAP_to_the_local_state$s_ATT_Security_office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_Warm_Transfer_the_PSAP_to_the_local_state$s_ATT_Asset$$$1_888_272_4047$$$This_is_a_24_by_7number(){
		 String checkpoint = "Warning$_Warm_Transfer_the_PSAP_to_the_local_state$s_ATT_Asset$$$1_888_272_4047$$$This_is_a_24_by_7number";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_OK(){
		 String checkpoint = "Warning$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_Negotiate_Access$(){
		 String checkpoint = "Warning$_Negotiate_Access$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Warning$_Advise_the_PSAP_that_to_initiate_a_live_trace_the_call_must_still_be_in_progress$_Warm_transfer_the_PSAP_to_Asset_Protection_Client_Services$$$$$$(){
		 String checkpoint = "Warning$_Advise_the_PSAP_that_to_initiate_a_live_trace_the_call_must_still_be_in_progress$_Warm_transfer_the_PSAP_to_Asset_Protection_Client_Services$$$$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Verify_and_select_the_name_and_service_address_being_reported_Title(){
		 String checkpoint = "Verify_and_select_the_name_and_service_address_being_reported_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Unsure(){
		 String checkpoint = "Unsure";
		 return getValueFromExcel(checkpoint);
		}
		public static String TreeList_Title(){
		 String checkpoint = "TreeList_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String TreeForm_Title(){
		 String checkpoint = "TreeForm_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Submit_TankYou_OK(){
		 String checkpoint = "Submit_TankYou_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String Submit_APRO_OK(){
		 String checkpoint = "Submit_APRO_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String Submit_AgMsg_Yes(){
		 String checkpoint = "Submit_AgMsg_Yes";
		 return getValueFromExcel(checkpoint);
		}
		public static String Submit_AgMsg_No(){
		 String checkpoint = "Submit_AgMsg_No";
		 return getValueFromExcel(checkpoint);
		}
		public static String SSA_Please_select_the_LFACS_address_that_matches_the_address_the_customer_provided(){
		 String checkpoint = "SSA_Please_select_the_LFACS_address_that_matches_the_address_the_customer_provided";
		 return getValueFromExcel(checkpoint);
		}
		public static String Select_title(){
		 String checkpoint = "Select_title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Select_The_following_commitment_times$$$select_one(){
		 String checkpoint = "Select_The_following_commitment_times$$$select_one";
		 return getValueFromExcel(checkpoint);
		}
		public static String Select_Please_make_an_appointment_that_fits_customer$s_need$(){
		 String checkpoint = "Select_Please_make_an_appointment_that_fits_customer$s_need$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Select_Service_Address_title(){
		 String checkpoint = "Select_Service_Address_title";
		 return getValueFromExcel(checkpoint);
		}
		public static String RECORD_This_transaction_you_are_requesting$$$transaction_again$(){
		 String checkpoint = "RECORD_This_transaction_you_are_requesting$$$transaction_again$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Please_rerun$Script_runtime_is_incorrect$(){
		 String checkpoint = "Please_rerun$Script_runtime_is_incorrect$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Online_transfer_to_CA_CS_at_Res$800_310_2355$$$800_750_2355$$$800_288_2020$$$800_750_2355_for_future_reporting$(){
		 String checkpoint = "Online_transfer_to_CA_CS_at_Res$800_310_2355$$$800_750_2355$$$800_288_2020$$$800_750_2355_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String OK(){
		 String checkpoint = "OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String No(){
		 String checkpoint = "No";
		 return getValueFromExcel(checkpoint);
		}
		public static String MLHG_Customer_has_Hunting$_Please_select_any_number$s$_which_need_to_be_updated$(){
		 String checkpoint = "MLHG_Customer_has_Hunting$_Please_select_any_number$s$_which_need_to_be_updated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_Wrong_Number_Reissue(){
		 String checkpoint = "MISSLR_Wrong_Number_Reissue";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_WFA$C_Ticket$(){
		 String checkpoint = "MISSLR_WFA$C_Ticket$";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_Received_Date$Time$(){
		 String checkpoint = "MISSLR_Received_Date$Time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_Please_select_one_of_below$(){
		 String checkpoint = "MISSLR_Please_select_one_of_below$";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_Missing_Line_Record_Reissue(){
		 String checkpoint = "MISSLR_Missing_Line_Record_Reissue";
		 return getValueFromExcel(checkpoint);
		}
		public static String MISSLR_E_Ticket_Reissue(){
		 String checkpoint = "MISSLR_E_Ticket_Reissue";
		 return getValueFromExcel(checkpoint);
		}
		public static String Message_Enter_the_Npanxx_CLLI_code_or_City_for_the_State(){
		 String checkpoint = "Message_Enter_the_Npanxx_CLLI_code_or_City_for_the_State";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_WFA$C_Ticket$s_format_is_AA$$$$$$$(){
		 String checkpoint = "INVALID_INPUT_WFA$C_Ticket$s_format_is_AA$$$$$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_The_number_should_between_1_and_30(){
		 String checkpoint = "INVALID_INPUT_The_number_should_between_1_and_30";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Please_input_data_in_the_provided_field$(){
		 String checkpoint = "INVALID_INPUT_Please_input_data_in_the_provided_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Please_input_data_in_the_field$(){
		 String checkpoint = "INVALID_INPUT_Please_input_data_in_the_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Please_enter_enough_information(){
		 String checkpoint = "INVALID_INPUT_Please_enter_enough_information";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Format_is_XX$$$$$(){
		 String checkpoint = "INVALID_INPUT_Format_is_XX$$$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Format_is_AA$$$$$$$(){
		 String checkpoint = "INVALID_INPUT_Format_is_AA$$$$$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Entry_must_be_10_digits_and_cannot_begin_with_1_or_0$(){
		 String checkpoint = "INVALID_INPUT_Entry_must_be_10_digits_and_cannot_begin_with_1_or_0$";
		 return getValueFromExcel(checkpoint);
		}
		public static String INVALID_INPUT_Commitment_time_must_be_on_the_hour$_Enter_Time_as_HH$00A_or_P_$st$(){
		 String checkpoint = "INVALID_INPUT_Commitment_time_must_be_on_the_hour$_Enter_Time_as_HH$00A_or_P_$st$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Warm_transfer_the_PSAP_to_the_South_911_Resolution_Center_at_1_800_553_2811$(){
		 String checkpoint = "Instruction_Warm_transfer_the_PSAP_to_the_South_911_Resolution_Center_at_1_800_553_2811$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Warm_transfer_the_PSAP_to_the_North_911_Resolution_Center_at_1_888_243_1911$(){
		 String checkpoint = "Instruction_Warm_transfer_the_PSAP_to_the_North_911_Resolution_Center_at_1_888_243_1911$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Verify_that_the_number_the_customer_is_dialing_for_Access_Code_activation_is_correct$(){
		 String checkpoint = "Instruction_Verify_that_the_number_the_customer_is_dialing_for_Access_Code_activation_is_correct$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Title(){
		 String checkpoint = "Instruction_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_This_will_be_referred_to_our_Voice_Mail_Group_for_correction$_RES_ATT_Voice_Mail$$$1_800_223_9999_and_BUS$$$1_800_348_9999$(){
		 String checkpoint = "Instruction_This_will_be_referred_to_our_Voice_Mail_Group_for_correction$_RES_ATT_Voice_Mail$$$1_800_223_9999_and_BUS$$$1_800_348_9999$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_This_is_an_II_Retail_account$_Take_the_trouble_report$(){
		 String checkpoint = "Instruction_This_is_an_II_Retail_account$_Take_the_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_The_Billing_Record_indicates_a_Remote_Call_Forwarding_service$(){
		 String checkpoint = "Instruction_The_Billing_Record_indicates_a_Remote_Call_Forwarding_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_REP$_This_is_a_Quick_Service_Account(){
		 String checkpoint = "Instruction_REP$_This_is_a_Quick_Service_Account";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Refer_to_the_Voice_Mail_Group$_RES_BUS_Message_Center_1_800_540_8020_and_BUS_ATT_Voice_Mail_1_800_540_8020(){
		 String checkpoint = "Instruction_Refer_to_the_Voice_Mail_Group$_RES_BUS_Message_Center_1_800_540_8020_and_BUS_ATT_Voice_Mail_1_800_540_8020";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Refer_to_the_Voice_Mail_Group$_RES_ATT_Call_Notes_1_800_824_4424_and_BUS_ATT_Voice_Service_1_800_798_6689$(){
		 String checkpoint = "Instruction_Refer_to_the_Voice_Mail_Group$_RES_ATT_Call_Notes_1_800_824_4424_and_BUS_ATT_Voice_Service_1_800_798_6689$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Refer_to_the_Voice_Mail_Group$_$center1_$vm_help1_or_$center2_$vm_help2_$_Note$_Spanish_ATT_Voice_Mail_Group$_$vm_help7(){
		 String checkpoint = "Instruction_Refer_to_the_Voice_Mail_Group$_$center1_$vm_help1_or_$center2_$vm_help2_$_Note$_Spanish_ATT_Voice_Mail_Group$_$vm_help7";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Refer_the_customer_to_their_local_police_agency$(){
		 String checkpoint = "Instruction_Refer_the_customer_to_their_local_police_agency$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Provide_customer_with_appropriate_811_One_Call_Center_number$(){
		 String checkpoint = "Instruction_Provide_customer_with_appropriate_811_One_Call_Center_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Please_input_data_in_the_provided_field$(){
		 String checkpoint = "Instruction_Please_input_data_in_the_provided_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Please_create_an_MR_ticket_with_the_following$$$From_ATT___Still_In_Switch$(){
		 String checkpoint = "Instruction_Please_create_an_MR_ticket_with_the_following$$$From_ATT___Still_In_Switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer$$$RES_ATT1_800_223_9960$$$BUS_ATT1_800_348_9960$$$Spanish_ATT1_800_870_7575(){
		 String checkpoint = "Instruction_Online_transfer$$$RES_ATT1_800_223_9960$$$BUS_ATT1_800_348_9960$$$Spanish_ATT1_800_870_7575";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer$$$1_800_824_4424$$$1_800_798_6689(){
		 String checkpoint = "Instruction_Online_transfer$$$1_800_824_4424$$$1_800_798_6689";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer$$$1_800_540_8020$$$1_800_540_8020(){
		 String checkpoint = "Instruction_Online_transfer$$$1_800_540_8020$$$1_800_540_8020";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer$$$1_800_223_9960$$$1_800_348_9960$$$1_800_870_7575(){
		 String checkpoint = "Instruction_Online_transfer$$$1_800_223_9960$$$1_800_348_9960$$$1_800_870_7575";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT$$$1_800_798_6689$$$1_800_798_6689(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT$$$1_800_798_6689$$$1_800_798_6689";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960$_Note$_Spanish_ATT_Voice_Mail_Group$_1_800_870_7575(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960$_Note$_Spanish_ATT_Voice_Mail_Group$_1_800_870_7575";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_575_5551_and_BUS_ATT_Voice_Mail_Helpline_1_800_575_5552$(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_575_5551_and_BUS_ATT_Voice_Mail_Helpline_1_800_575_5552$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960$(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_Helpline_1_888_300_6500_or_BUS_ATT_Unified_Messaging_Helpline_1_888_300_6500$_No_note(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_Helpline_1_888_300_6500_or_BUS_ATT_Unified_Messaging_Helpline_1_888_300_6500$_No_note";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_Helpline_1_888_300_6500_and_BUS_ATT_Unified_Messaging_Helpline_1_888_300_6500$(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_Helpline_1_888_300_6500_and_BUS_ATT_Unified_Messaging_Helpline_1_888_300_6500$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_1_888_300_6500_and_BUS_ATT_Unified_Messaging_1_888_300_6500$(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Unified_Messaging_1_888_300_6500_and_BUS_ATT_Unified_Messaging_1_888_300_6500$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Call_Notes_1_800_824_4424_and_BUS_ATT_Voice_Service_1_800_798_6689$(){
		 String checkpoint = "Instruction_Online_transfer_to_the_ATT_Voice_Mail_Group$_RES_ATT_Call_Notes_1_800_824_4424_and_BUS_ATT_Voice_Service_1_800_798_6689$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960_$_Note$_Spanish_ATT_Voice_Mail_Group$_1_800_870_7575(){
		 String checkpoint = "Instruction_Online_transfer_to_ATT_Voice_Mail_Group$_RES_ATT_Voice_Mail_Helpline_1_800_223_9960_or_BUS_ATT_Voice_Mail_Helpline_1_800_348_9960_$_Note$_Spanish_ATT_Voice_Mail_Group$_1_800_870_7575";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Online_transfer_to_ATT_Voice_Mail_Group$_$center1_$vm_help1_or_$center2_$vm_help2$_Note$_Spanish_ATT_Voice_Mail_Group$_$vm_help7$(){
		 String checkpoint = "Instruction_Online_transfer_to_ATT_Voice_Mail_Group$_$center1_$vm_help1_or_$center2_$vm_help2$_Note$_Spanish_ATT_Voice_Mail_Group$_$vm_help7$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_No_service_order_to_connect_service_was$$$records_exist_in_WFA$C(){
		 String checkpoint = "Instruction_No_service_order_to_connect_service_was$$$records_exist_in_WFA$C";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_List_in_narr$$$Access_code_if_applicable(){
		 String checkpoint = "Instruction_List_in_narr$$$Access_code_if_applicable";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Is_feature_in_switch_translations$(){
		 String checkpoint = "Instruction_Is_feature_in_switch_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Has_the_customer_deactivated_Call_Waiting_using_$70_$1170$_prior_to_dialing_the_ISP_number$(){
		 String checkpoint = "Instruction_Has_the_customer_deactivated_Call_Waiting_using_$70_$1170$_prior_to_dialing_the_ISP_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Explain_to_the_customer_that_activating_Call(){
		 String checkpoint = "Instruction_Explain_to_the_customer_that_activating_Call";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Enter_the_customer$s_name_address$$$on_the_report_narrative_and_follow_the_Ntelagent_recommendation$(){
		 String checkpoint = "Instruction_Enter_the_customer$s_name_address$$$on_the_report_narrative_and_follow_the_Ntelagent_recommendation$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Does_the_customer_have_Voice_Mail$Call_Notes$(){
		 String checkpoint = "Instruction_Does_the_customer_have_Voice_Mail$Call_Notes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_DO_NOT_TEST_LINE$_Refer_to_the_Escalation_desk$(){
		 String checkpoint = "Instruction_DO_NOT_TEST_LINE$_Refer_to_the_Escalation_desk$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Check_WALDO$$$Is_the_location_in_ATT_territory$(){
		 String checkpoint = "Instruction_Check_WALDO$$$Is_the_location_in_ATT_territory$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Check_the_Billing_Record_for$$$Is_the_Personal_ID_present_on_the_account$(){
		 String checkpoint = "Instruction_Check_the_Billing_Record_for$$$Is_the_Personal_ID_present_on_the_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Check_the_Billing_Record_for$GSZ$$$$Is_the_Personal_ID_present_on_the_account$(){
		 String checkpoint = "Instruction_Check_the_Billing_Record_for$GSZ$$$$Is_the_Personal_ID_present_on_the_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Check_Hunting_order_in_translations$(){
		 String checkpoint = "Instruction_Check_Hunting_order_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Check_for_Service_Order_activity(){
		 String checkpoint = "Instruction_Check_for_Service_Order_activity";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Advise_the_customer_if_they_have_an_emergency(){
		 String checkpoint = "Instruction_Advise_the_customer_if_they_have_an_emergency";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Advise_the_customer_call_forwarding_will_be(){
		 String checkpoint = "Instruction_Advise_the_customer_call_forwarding_will_be";
		 return getValueFromExcel(checkpoint);
		}
		public static String Instruction_Advise_customer_that_OCC_and_VMS_message_waiting_indicators_do_not_work_together$(){
		 String checkpoint = "Instruction_Advise_customer_that_OCC_and_VMS_message_waiting_indicators_do_not_work_together$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_What_time_may_we_arrive_between$(){
		 String checkpoint = "Input_What_time_may_we_arrive_between$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Title(){
		 String checkpoint = "Input_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Please_enter_the_appointment_negotiated_with_the_customer$(){
		 String checkpoint = "Input_Please_enter_the_appointment_negotiated_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Please_check_for_additional_appointment_windows_in_the_trouble_information_section$(){
		 String checkpoint = "Input_Please_check_for_additional_appointment_windows_in_the_trouble_information_section$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Enter_the_commitment_date_and_time_that_was_negotiated_with_the_customer$(){
		 String checkpoint = "Input_Enter_the_commitment_date_and_time_that_was_negotiated_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Cancel(){
		 String checkpoint = "Input_Cancel";
		 return getValueFromExcel(checkpoint);
		}
		public static String Input_Ask_customer_what_number_they_are_dialing$(){
		 String checkpoint = "Input_Ask_customer_what_number_they_are_dialing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_TYPE_Code_should_be_populated(){
		 String checkpoint = "Information_TYPE_Code_should_be_populated";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Title(){
		 String checkpoint = "Information_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_This_is_a_Remote_Call_Forwarding_Line$(){
		 String checkpoint = "Information_This_is_a_Remote_Call_Forwarding_Line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_The_commitment_is_earlier_than_current_time$(){
		 String checkpoint = "Information_The_commitment_is_earlier_than_current_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_The_Access_B_and_Commitment_time_must_match$$$Would_you_like_to_change_the_appointment_hours$(){
		 String checkpoint = "Information_The_Access_B_and_Commitment_time_must_match$$$Would_you_like_to_change_the_appointment_hours$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_Report_By_field$(){
		 String checkpoint = "Information_Please_populate_Report_By_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_Reach_Number$$$TYPE_Code_should_be_populated$(){
		 String checkpoint = "Information_Please_populate_a_valid_Reach_Number$$$TYPE_Code_should_be_populated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_Reach_Number$$$Access_Number$$$Report_By_field$(){
		 String checkpoint = "Information_Please_populate_a_valid_Reach_Number$$$Access_Number$$$Report_By_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_Reach_Number$(){
		 String checkpoint = "Information_Please_populate_a_valid_Reach_Number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_NPANXX$TYPE_Code_should_be_populated(){
		 String checkpoint = "Information_Please_populate_a_valid_NPANXX$TYPE_Code_should_be_populated";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_NPANXX$$$TYPE_Code_should_be_populated(){
		 String checkpoint = "Information_Please_populate_a_valid_NPANXX$$$TYPE_Code_should_be_populated";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_Access_Number$_TYPE_Code_should_be_populated$(){
		 String checkpoint = "Information_Please_populate_a_valid_Access_Number$_TYPE_Code_should_be_populated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_Please_populate_a_valid_Access_Number(){
		 String checkpoint = "Information_Please_populate_a_valid_Access_Number";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_OK(){
		 String checkpoint = "Information_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_customer_contact_us$(){
		 String checkpoint = "Information_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_customer_contact_us$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_business_contact_us$(){
		 String checkpoint = "Information_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_business_contact_us$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_I_would_like_to_assist_you_in_determining(){
		 String checkpoint = "Information_I_would_like_to_assist_you_in_determining";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_CLOSE(){
		 String checkpoint = "Information_CLOSE";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_A_service_charge_may_apply_if_a_telephone_technician$$$at_the_location_or_not(){
		 String checkpoint = "Information_A_service_charge_may_apply_if_a_telephone_technician$$$at_the_location_or_not";
		 return getValueFromExcel(checkpoint);
		}
		public static String Information_A_service_charge_may_apply_if_a_telephone_technician(){
		 String checkpoint = "Information_A_service_charge_may_apply_if_a_telephone_technician";
		 return getValueFromExcel(checkpoint);
		}
		public static String FMD_A_mismatch_between_service_order$billing_and_the_switch_has_been_detected_on_Voice_Mail_features$_Do_you_want_to_fix_the_mismatch$(){
		 String checkpoint = "FMD_A_mismatch_between_service_order$billing_and_the_switch_has_been_detected_on_Voice_Mail_features$_Do_you_want_to_fix_the_mismatch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String FMD_A_mismatch_between_service_order$billing_and_the_switch_has_been_detected_on_Voice_Mail_features$(){
		 String checkpoint = "FMD_A_mismatch_between_service_order$billing_and_the_switch_has_been_detected_on_Voice_Mail_features$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Fix_Bundle_Features_Title(){
		 String checkpoint = "Fix_Bundle_Features_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String FBF_Title(){
		 String checkpoint = "FBF_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String FBF_The_following_features_are_missing_in_Switch$_Select_the_features_you_wish_to_add$(){
		 String checkpoint = "FBF_The_following_features_are_missing_in_Switch$_Select_the_features_you_wish_to_add$";
		 return getValueFromExcel(checkpoint);
		}
		public static String ER_TreeList_Title(){
		 String checkpoint = "ER_TreeList_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String DV_Please_populate_Report_By_field$(){
		 String checkpoint = "DV_Please_populate_Report_By_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Display_Title(){
		 String checkpoint = "Display_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Display_Please_make_an_appointment_that_fits_customer$s_need$(){
		 String checkpoint = "Display_Please_make_an_appointment_that_fits_customer$s_need$";
		 return getValueFromExcel(checkpoint);
		}
		public static String DataInput_What_happens_when_customer_dials_911$(){
		 String checkpoint = "DataInput_What_happens_when_customer_dials_911$";
		 return getValueFromExcel(checkpoint);
		}
		public static String DataInput_Please_enter_the_other_telephone_numbers(){
		 String checkpoint = "DataInput_Please_enter_the_other_telephone_numbers";
		 return getValueFromExcel(checkpoint);
		}
		public static String DataInput_Input_feature_name_and_description_of_problem$(){
		 String checkpoint = "DataInput_Input_feature_name_and_description_of_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String DataInput_Explain_referral$(){
		 String checkpoint = "DataInput_Explain_referral$";
		 return getValueFromExcel(checkpoint);
		}
		public static String DataInput_Ask_the_customer_where_the_NID_is_located$_Input_location_of_NID$(){
		 String checkpoint = "DataInput_Ask_the_customer_where_the_NID_is_located$_Input_location_of_NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_TYPE_Code_should_be_populated$(){
		 String checkpoint = "Data_Validation_TYPE_Code_should_be_populated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_The_commitment_is_earlier_than_current_time$(){
		 String checkpoint = "Data_Validation_The_commitment_is_earlier_than_current_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_Please_select_another_Action_code$_No_remark_could_be_added$(){
		 String checkpoint = "Data_Validation_Please_select_another_Action_code$_No_remark_could_be_added$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_Please_populate_Report_By_field$(){
		 String checkpoint = "Data_Validation_Please_populate_Report_By_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_Please_populate_a_valid$$$TYPE_Code_should_be_populated(){
		 String checkpoint = "Data_Validation_Please_populate_a_valid$$$TYPE_Code_should_be_populated";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_Please_populate_a_valid_Reach_Number$(){
		 String checkpoint = "Data_Validation_Please_populate_a_valid_Reach_Number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_Please_populate_a_valid_Access_Number$(){
		 String checkpoint = "Data_Validation_Please_populate_a_valid_Access_Number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Validation_2_3Fields_ReachNum_AccessNum_ReportBy(){
		 String checkpoint = "Data_Validation_2_3Fields_ReachNum_AccessNum_ReportBy";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_What_telephone_number_are_calls_hunting_to$(){
		 String checkpoint = "Data_Input_What_telephone_number_are_calls_hunting_to$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_What_number_should_line_be_hunting_to$(){
		 String checkpoint = "Data_Input_What_number_should_line_be_hunting_to$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_What_happens_when_customer_dials_911$(){
		 String checkpoint = "Data_Input_What_happens_when_customer_dials_911$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_What_does_the_customer_hear_when_dialing$(){
		 String checkpoint = "Data_Input_What_does_the_customer_hear_when_dialing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Title(){
		 String checkpoint = "Data_Input_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Special_Access_instructions$(){
		 String checkpoint = "Data_Input_Special_Access_instructions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_input_the_desired_ring_cycle_for_this_feature$(){
		 String checkpoint = "Data_Input_Please_input_the_desired_ring_cycle_for_this_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_input_Please_explain_reason$_Other(){
		 String checkpoint = "Data_input_Please_explain_reason$_Other";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_the_other_telephone_numbers$$$is_being_reported_leave_blank(){
		 String checkpoint = "Data_Input_Please_enter_the_other_telephone_numbers$$$is_being_reported_leave_blank";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_the_ID_of_the_NDC_agent$(){
		 String checkpoint = "Data_Input_Please_enter_the_ID_of_the_NDC_agent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_the_ID_of_the_JRT_agent$(){
		 String checkpoint = "Data_Input_Please_enter_the_ID_of_the_JRT_agent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_the_CFN$(){
		 String checkpoint = "Data_Input_Please_enter_the_CFN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_details_provided_by_customer$(){
		 String checkpoint = "Data_Input_Please_enter_details_provided_by_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_customers_comments$(){
		 String checkpoint = "Data_Input_Please_enter_customers_comments$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Please_enter_additional_information_needed_for_the_trouble_report$(){
		 String checkpoint = "Data_Input_Please_enter_additional_information_needed_for_the_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_the_transfer_number_for_Operator_Escape$(){
		 String checkpoint = "Data_Input_Obtain_the_transfer_number_for_Operator_Escape$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_the_pager_number_for_Pager_Notification$(){
		 String checkpoint = "Data_Input_Obtain_the_pager_number_for_Pager_Notification$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_Reported_By_information_if_the_Report_By_field_is_blank$(){
		 String checkpoint = "Data_Input_Obtain_Reported_By_information_if_the_Report_By_field_is_blank$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_Reported_By_information_if_the_Report_By_field(){
		 String checkpoint = "Data_Input_Obtain_Reported_By_information_if_the_Report_By_field";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_numbers_being_called_for_free$(){
		 String checkpoint = "Data_Input_Obtain_numbers_being_called_for_free$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_callback_number$$$populated_with_zeros$(){
		 String checkpoint = "Data_Input_Obtain_callback_number$$$populated_with_zeros$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Obtain_callback_number_if_the_Reach_Number_field_is_blank_or_is_populated_with_zeros$(){
		 String checkpoint = "Data_Input_Obtain_callback_number_if_the_Reach_Number_field_is_blank_or_is_populated_with_zeros$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Name_of_Party$(){
		 String checkpoint = "Data_Input_Name_of_Party$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_what_happens_when_using_VRU$_Include_the_Access_Code_$_the_customer_is_trying_to_change$(){
		 String checkpoint = "Data_Input_Input_what_happens_when_using_VRU$_Include_the_Access_Code_$_the_customer_is_trying_to_change$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_what_happens_when_using_VRU$(){
		 String checkpoint = "Data_Input_Input_what_happens_when_using_VRU$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_what_happens_when_trying_to_use_Access_Code$(){
		 String checkpoint = "Data_Input_Input_what_happens_when_trying_to_use_Access_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_what_appears_on_the_display_include_caller$s_number$(){
		 String checkpoint = "Data_Input_Input_what_appears_on_the_display_include_caller$s_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_updated_callback_number_$add_$CELL$_to_end_if_needed_to_stop_AOD_notification$$(){
		 String checkpoint = "Data_Input_Input_updated_callback_number_$add_$CELL$_to_end_if_needed_to_stop_AOD_notification$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_the_number_customer_is_dialing_$including_the_access_code$$(){
		 String checkpoint = "Data_Input_Input_the_number_customer_is_dialing_$including_the_access_code$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_the_correct_address$(){
		 String checkpoint = "Data_Input_Input_the_correct_address$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_site_contact_person$s_name$(){
		 String checkpoint = "Data_Input_Input_site_contact_person$s_name$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_previous_trouble_description_what_was_found_from_original_report_cite_contact_person$s_name$(){
		 String checkpoint = "Data_Input_Input_previous_trouble_description_what_was_found_from_original_report_cite_contact_person$s_name$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_name$number_that_is_being_displayed$(){
		 String checkpoint = "Data_Input_Input_name$number_that_is_being_displayed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_information_for_this_delivery$_Provide_Zip_code_and_any_special_delivery_instructions$(){
		 String checkpoint = "Data_Input_Input_information_for_this_delivery$_Provide_Zip_code_and_any_special_delivery_instructions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_feature_name_and_description_of_problem$(){
		 String checkpoint = "Data_Input_Input_feature_name_and_description_of_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_description_of_the_trouble_the_customer_is_having$(){
		 String checkpoint = "Data_Input_Input_description_of_the_trouble_the_customer_is_having$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_description_of_the_problem$(){
		 String checkpoint = "Data_Input_Input_description_of_the_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Input_Centrex_feature_name$(){
		 String checkpoint = "Data_Input_Input_Centrex_feature_name$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_trouble_the_customer_is_having$(){
		 String checkpoint = "Data_Input_Enter_trouble_the_customer_is_having$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_trouble_details$(){
		 String checkpoint = "Data_Input_Enter_trouble_details$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_TN$s_to_be_tested$(){
		 String checkpoint = "Data_Input_Enter_TN$s_to_be_tested$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_Trunk_Outage_information_from_the_Chalkboard$(){
		 String checkpoint = "Data_Input_Enter_the_Trunk_Outage_information_from_the_Chalkboard$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_trouble_the_customer_is_experiencing$(){
		 String checkpoint = "Data_Input_Enter_the_trouble_the_customer_is_experiencing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_trouble_customer_is_having$(){
		 String checkpoint = "Data_Input_Enter_the_trouble_customer_is_having$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_Toll_Free_Number_that_the_customer_is_dialing$(){
		 String checkpoint = "Data_Input_Enter_the_Toll_Free_Number_that_the_customer_is_dialing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_time_and_date_the_trouble_occurred$(){
		 String checkpoint = "Data_Input_Enter_the_time_and_date_the_trouble_occurred$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_telephone_number_that_the_customer_is_getti(){
		 String checkpoint = "Data_Input_Enter_the_telephone_number_that_the_customer_is_getti";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_Telephone_Number_that_the_customer_is_attempting_to_dial$(){
		 String checkpoint = "Data_Input_Enter_the_Telephone_Number_that_the_customer_is_attempting_to_dial$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_recording_number_and_add_trailer_number_as_needed$_Leave_blank_if_the_recording_is_not_listed$(){
		 String checkpoint = "Data_Input_Enter_the_recording_number_and_add_trailer_number_as_needed$_Leave_blank_if_the_recording_is_not_listed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_recording_number_and_add_trailer_number_as_needed$(){
		 String checkpoint = "Data_Input_Enter_the_recording_number_and_add_trailer_number_as_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_Pole_$_Case_$_onsite_contact_Name_and_Reach_TN$(){
		 String checkpoint = "Data_Input_Enter_the_Pole_$_Case_$_onsite_contact_Name_and_Reach_TN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_name_of_the_Escalation_Administrator$(){
		 String checkpoint = "Data_Input_Enter_the_name_of_the_Escalation_Administrator$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_name_of_the_caller_and_the_name_of__the_Asset_Protection_agent_that_the_call_was_transferred_to$(){
		 String checkpoint = "Data_Input_Enter_the_name_of_the_caller_and_the_name_of__the_Asset_Protection_agent_that_the_call_was_transferred_to$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_International_telephone_number_that_the_customer_is_attempting_to_dial$(){
		 String checkpoint = "Data_Input_Enter_the_International_telephone_number_that_the_customer_is_attempting_to_dial$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_customer$s_Account_Code(){
		 String checkpoint = "Data_Input_Enter_the_customer$s_Account_Code";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_call_forwarding_number$(){
		 String checkpoint = "Data_Input_Enter_the_call_forwarding_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_900$976_Number_that_the_customer_is_dialing$(){
		 String checkpoint = "Data_Input_Enter_the_900$976_Number_that_the_customer_is_dialing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_the_500_Number_that_the_customer_is_dialing$(){
		 String checkpoint = "Data_Input_Enter_the_500_Number_that_the_customer_is_dialing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_reason_why_customer_is_asking_for_a_call_back(){
		 String checkpoint = "Data_Input_Enter_reason_why_customer_is_asking_for_a_call_back";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_Officer$Dispatcher_Name_and_CBR(){
		 String checkpoint = "Data_Input_Enter_Officer$Dispatcher_Name_and_CBR";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_dial_around_code_that_the_customer_is_using$(){
		 String checkpoint = "Data_Input_Enter_dial_around_code_that_the_customer_is_using$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_details_of_trouble$(){
		 String checkpoint = "Data_Input_Enter_details_of_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Enter_any_recording_details_needed_to_screen_the_report$_$i$e$_Date$Time_of_Call_700$_called$$$(){
		 String checkpoint = "Data_Input_Enter_any_recording_details_needed_to_screen_the_report$_$i$e$_Date$Time_of_Call_700$_called$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Billing_and_Service_Orders_are_not_available$(){
		 String checkpoint = "Data_Input_Billing_and_Service_Orders_are_not_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Bill_to_telephone_number$(){
		 String checkpoint = "Data_Input_Bill_to_telephone_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Ask_what_ring_pattern_the_customer_should_have$(){
		 String checkpoint = "Data_Input_Ask_what_ring_pattern_the_customer_should_have$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Ask_the_customer_where_the_NID_is_located$_Input_location_of_NID$(){
		 String checkpoint = "Data_Input_Ask_the_customer_where_the_NID_is_located$_Input_location_of_NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_Ask_the_customer_what_telephone_number_the_calls_sh(){
		 String checkpoint = "Data_Input_Ask_the_customer_what_telephone_number_the_calls_sh";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input_After_hours_call_the_Night_Reporting$$$Enter_the_initials_of_the_Night_Reporting_Center_agent$(){
		 String checkpoint = "Data_Input_After_hours_call_the_Night_Reporting$$$Enter_the_initials_of_the_Night_Reporting_Center_agent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input__Please_enter_additional_information_needed_for_the_trouble_report$(){
		 String checkpoint = "Data_Input__Please_enter_additional_information_needed_for_the_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input__Enter_the_type_of_Speed_Calling_customer_is_reporting$(){
		 String checkpoint = "Data_Input__Enter_the_type_of_Speed_Calling_customer_is_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input__Enter_the_telephone_number_that_the_customer_is_getting_calls_for$(){
		 String checkpoint = "Data_Input__Enter_the_telephone_number_that_the_customer_is_getting_calls_for$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Data_Input__Ask_what_ring_pattern_the_customer_should_have$(){
		 String checkpoint = "Data_Input__Ask_what_ring_pattern_the_customer_should_have$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Dara_Input_Obtain_callback_number_if$$$populated_with_zeros$(){
		 String checkpoint = "Dara_Input_Obtain_callback_number_if$$$populated_with_zeros$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Dara_Input_Input_the_correct_address$(){
		 String checkpoint = "Dara_Input_Input_the_correct_address$";
		 return getValueFromExcel(checkpoint);
		}
		public static String CLOSE(){
		 String checkpoint = "CLOSE";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Use_QVF_to_verify_that_the_feature_is_in_translations$_Is_the_feature_in_translations$(){
		 String checkpoint = "Choose_Use_QVF_to_verify_that_the_feature_is_in_translations$_Is_the_feature_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Title(){
		 String checkpoint = "Choose_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Select_an_appointment_for_the_next_business_day$(){
		 String checkpoint = "Choose_Select_an_appointment_for_the_next_business_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Review_the_Billing_Record_and_Service_Orders$_Is_the_customer_paying_for_the_feature$(){
		 String checkpoint = "Choose_Review_the_Billing_Record_and_Service_Orders$_Is_the_customer_paying_for_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_QVF_is_unable_to_process_3(){
		 String checkpoint = "Choose_QVF_is_unable_to_process_3";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_QVF_is_unable_to_process_request_please_enter_whether_call_is_INTER_or_INTRA$(){
		 String checkpoint = "Choose_QVF_is_unable_to_process_request_please_enter_whether_call_is_INTER_or_INTRA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_QVF_is_unable_to_process(){
		 String checkpoint = "Choose_QVF_is_unable_to_process";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Ask_if_the_customer_is_aware_of_other_customers_in_the_area_affected$(){
		 String checkpoint = "Choose_Ask_if_the_customer_is_aware_of_other_customers_in_the_area_affected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Choose_Ask_customer_if_this_is_an_ATT_cable$(){
		 String checkpoint = "Choose_Ask_customer_if_this_is_an_ATT_cable$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Cancel_Do_you_really_want_to_cancel_this_report$(){
		 String checkpoint = "Cancel_Do_you_really_want_to_cancel_this_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Cancel_datainput(){
		 String checkpoint = "Cancel_datainput";
		 return getValueFromExcel(checkpoint);
		}
		public static String Cancel(){
		 String checkpoint = "Cancel";
		 return getValueFromExcel(checkpoint);
		}
		public static String BILL_This_transaction_you_are_requesting$$$transaction_again$(){
		 String checkpoint = "BILL_This_transaction_you_are_requesting$$$transaction_again$";
		 return getValueFromExcel(checkpoint);
		}
		public static String ASOSChanged_We_can_have_your_service_repaired_by(){
		 String checkpoint = "ASOSChanged_We_can_have_your_service_repaired_by";
		 return getValueFromExcel(checkpoint);
		}
		public static String ASOS_We_have_a_commitment_to_have_your_service_repaired_by(){
		 String checkpoint = "ASOS_We_have_a_commitment_to_have_your_service_repaired_by";
		 return getValueFromExcel(checkpoint);
		}
		public static String ASOS_We_can_have_your_service_repaired_by$$$_not_acceptable_to_the_customer$$(){
		 String checkpoint = "ASOS_We_can_have_your_service_repaired_by$$$_not_acceptable_to_the_customer$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String ASOS_We_can_have_your_service_repaired_by(){
		 String checkpoint = "ASOS_We_can_have_your_service_repaired_by";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Yes_3(){
		 String checkpoint = "Ask_Yes_3";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Yes(){
		 String checkpoint = "Ask_Yes";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Will_customer_use_automated_method_to_change_Ring_Cycle$(){
		 String checkpoint = "Ask_Will_customer_use_automated_method_to_change_Ring_Cycle$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Will_customer_accept_charges$(){
		 String checkpoint = "Ask_Will_customer_accept_charges$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_WFA$C_indicates_a_non_working_account_with_pending_status$_Is_this_a_working_number$(){
		 String checkpoint = "Ask_WFA$C_indicates_a_non_working_account_with_pending_status$_Is_this_a_working_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_We_can_have_your_service_repaired_by_$$$Would_you_like_me_to_check_for_available_appointments$(){
		 String checkpoint = "Ask_We_can_have_your_service_repaired_by_$$$Would_you_like_me_to_check_for_available_appointments$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Was_trouble_resolved_with_education$(){
		 String checkpoint = "Ask_Was_trouble_resolved_with_education$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Was_there_recent_service_order_activity$(){
		 String checkpoint = "Ask_Was_there_recent_service_order_activity$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Was_the_trouble_resolved$(){
		 String checkpoint = "Ask_Was_the_trouble_resolved$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Was_the_reported_number_entered_correctly_into_Ntelagent$(){
		 String checkpoint = "Ask_Was_the_reported_number_entered_correctly_into_Ntelagent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Was_customer_dialing_correctly$(){
		 String checkpoint = "Ask_Was_customer_dialing_correctly$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$(){
		 String checkpoint = "Ask_Voice_mail_subscriber$_Beeping_may_be_the_message_waiting_indicator_tone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Voice_mail_subscriber$(){
		 String checkpoint = "Ask_Voice_mail_subscriber$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Verify_with_the_customer_that_there_is_access(){
		 String checkpoint = "Ask_Verify_with_the_customer_that_there_is_access";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Verify_F1_facilities$_Are_facilities_copper$(){
		 String checkpoint = "Ask_Verify_F1_facilities$_Are_facilities_copper$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_THREE_WAY_CALLING$(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_THREE_WAY_CALLING$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_SPEED_CALLING_8_SPEED_CALL_30(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_SPEED_CALLING_8_SPEED_CALL_30";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_SPEED_CALLING(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_SPEED_CALLING";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_SPEED_CALL_30(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_SPEED_CALL_30";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_PRIORITY_CALL$(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_PRIORITY_CALL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_CALLER_ID_NUMBER$(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_CALLER_ID_NUMBER$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_CALLER_ID_NUMBER_MISCALLED_DIAL_SPEED_CALL_30_PRIORITY_CALL_CALL_BLOCKER$(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_CALLER_ID_NUMBER_MISCALLED_DIAL_SPEED_CALL_30_PRIORITY_CALL_CALL_BLOCKER$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_CALL_FORWARDING_SPEED_CALLING_8_CALL_FORWARDING_SPEED_CALL_30(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_CALL_FORWARDING_SPEED_CALLING_8_CALL_FORWARDING_SPEED_CALL_30";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Unable_to_determine_status_of_CALL_AGAIN_PRIORITY_CALL$(){
		 String checkpoint = "Ask_Unable_to_determine_status_of_CALL_AGAIN_PRIORITY_CALL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Try_QVF_a_second_time$_Was_transaction_successful_this_time$(){
		 String checkpoint = "Ask_Try_QVF_a_second_time$_Was_transaction_successful_this_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Touchtone_service_is_not_on_the_customer$s_account$(){
		 String checkpoint = "Ask_Touchtone_service_is_not_on_the_customer$s_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Toll_restriction_found$_Does_the_customer_want_to_remove_restriction$(){
		 String checkpoint = "Ask_Toll_restriction_found$_Does_the_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Title(){
		 String checkpoint = "Ask_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_message_is_being_displayed(){
		 String checkpoint = "Ask_This_message_is_being_displayed";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_U_verse$$$Use_SoftPhone_number_551_9816_$English$_551_9817_$Spanish$$$$877_353_5963_$English$_or_877_353_5971_$Spanish$_to_connect_the_customer$_Advise_the_customer_to_call_1_800_288_2020_to_report_U_Verse_trouble_in_the_future$$$U_Verse_Voice_Service$(){
		 String checkpoint = "Ask_This_is_a_U_verse$$$Use_SoftPhone_number_551_9816_$English$_551_9817_$Spanish$$$$877_353_5963_$English$_or_877_353_5971_$Spanish$_to_connect_the_customer$_Advise_the_customer_to_call_1_800_288_2020_to_report_U_Verse_trouble_in_the_future$$$U_Verse_Voice_Service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_U_verse$$$Use_SoftPhone_number_551_9816_$English$_551_9817_$Spanish$$$$1_800_288_2020$$$have_U_Verse_Voice_Service$(){
		 String checkpoint = "Ask_This_is_a_U_verse$$$Use_SoftPhone_number_551_9816_$English$_551_9817_$Spanish$$$$1_800_288_2020$$$have_U_Verse_Voice_Service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_U_verse_Voice_over_IP_customer$$U_verse_Voice_service$(){
		 String checkpoint = "Ask_This_is_a_U_verse_Voice_over_IP_customer$$U_verse_Voice_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_7777$$$8_888_888_8888$$$have_U_verse_Voice_service$(){
		 String checkpoint = "Ask_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_7777$$$8_888_888_8888$$$have_U_verse_Voice_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_1270__to_call_1_800_288_2020(){
		 String checkpoint = "Ask_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_1270__to_call_1_800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_is_a_disconnected_record$_Do_you_want_to_enter_a_report$(){
		 String checkpoint = "Ask_This_is_a_disconnected_record$_Do_you_want_to_enter_a_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_This_account_does_not_subscribe_to_$98$__Does_customer_want_to_order_the_feature$(){
		 String checkpoint = "Ask_This_account_does_not_subscribe_to_$98$__Does_customer_want_to_order_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_There_is_a_toll_restriction_on_account$(){
		 String checkpoint = "Ask_There_is_a_toll_restriction_on_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_There_is_a_restriction_on_the_line_that_prevents_the_use_of_a_dial_around_code$(){
		 String checkpoint = "Ask_There_is_a_restriction_on_the_line_that_prevents_the_use_of_a_dial_around_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_There_are_no_restrictions_on_the_account$_Is_the_customer_able_to_use_a_different_Dial_Around_call_to_complete_the_call$(){
		 String checkpoint = "Ask_There_are_no_restrictions_on_the_account$_Is_the_customer_able_to_use_a_different_Dial_Around_call_to_complete_the_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_There_are_no_restrictions_on_the_account$(){
		 String checkpoint = "Ask_There_are_no_restrictions_on_the_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_There_are_no_restrictions_found_on_this_account$_Has_the_customer_contacted_their_Long_Distance_carrier$(){
		 String checkpoint = "Ask_There_are_no_restrictions_found_on_this_account$_Has_the_customer_contacted_their_Long_Distance_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Test_the_touchtone_pad(){
		 String checkpoint = "Ask_Test_the_touchtone_pad";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Test_the_customer$s_touchtone_pad_by_asking_the_customer_to_press_the_$_or_$_key$_Was_the_touchtone_signal_good$(){
		 String checkpoint = "Ask_Test_the_customer$s_touchtone_pad_by_asking_the_customer_to_press_the_$_or_$_key$_Was_the_touchtone_signal_good$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Service_Order_Activity_is_present$_Is_the_trouble_being_reported_related_to_the_servic(){
		 String checkpoint = "Ask_Service_Order_Activity_is_present$_Is_the_trouble_being_reported_related_to_the_servic";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Service_Order_Activity_is_present$_Is_the_trouble_being_reporte(){
		 String checkpoint = "Ask_Service_Order_Activity_is_present$_Is_the_trouble_being_reporte";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Service_Order_Activity_is_present$_Is_the(){
		 String checkpoint = "Ask_Service_Order_Activity_is_present$_Is_the";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Service_Order_Activity_is_present$(){
		 String checkpoint = "Ask_Service_Order_Activity_is_present$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Review_the_Native_View_of_QVF_Feature_Comparison$(){
		 String checkpoint = "Ask_Review_the_Native_View_of_QVF_Feature_Comparison$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Review_the_Billing_Record$_Is_the_customer_paying_for_call_forwarding$(){
		 String checkpoint = "Ask_Review_the_Billing_Record$_Is_the_customer_paying_for_call_forwarding$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_REP_ask_customer_to_confirm_the_reported_number$$$entered_into_Ntelagent$(){
		 String checkpoint = "Ask_REP_ask_customer_to_confirm_the_reported_number$$$entered_into_Ntelagent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$(){
		 String checkpoint = "Ask_Refer_the_customer_to_their_Local_Service_Provider$_Does_the_customer_agree_that_ATT_is_not_their_Local_Service_Provider$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_QVF_not_available$_Place_report_in_Queue$(){
		 String checkpoint = "Ask_QVF_not_available$_Place_report_in_Queue$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Please_verify_the_customer$s_name_and_address$(){
		 String checkpoint = "Ask_Please_verify_the_customer$s_name_and_address$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Please_contact_TCG_TELEPORT_COMM$$$877_325_0445$$$TCG_Teleport_is_their_Local_Service_Provider$(){
		 String checkpoint = "Ask_Please_contact_TCG_TELEPORT_COMM$$$877_325_0445$$$TCG_Teleport_is_their_Local_Service_Provider$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$_Advise_customer_to_deny_charges$_Did_call_complete$(){
		 String checkpoint = "Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$_Advise_customer_to_deny_charges$_Did_call_complete$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$_Ad(){
		 String checkpoint = "Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$_Ad";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$(){
		 String checkpoint = "Ask_Place_a_test_call_to_the_customer_using_1_800_CALL_ATT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Our_records_indicate_you_are_reporting_a_Coin_phone$_Are_you_the_owner_or_vendor$(){
		 String checkpoint = "Ask_Our_records_indicate_you_are_reporting_a_Coin_phone$_Are_you_the_owner_or_vendor$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Our_records_indicate_you_are_reporting_a_Coin_phone$(){
		 String checkpoint = "Ask_Our_records_indicate_you_are_reporting_a_Coin_phone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_NOTE_TO_REP$_If_the_customer_disagrees_with$$$press_No_else_press_Yes(){
		 String checkpoint = "Ask_NOTE_TO_REP$_If_the_customer_disagrees_with$$$press_No_else_press_Yes";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_No_PIC_LPIC_found$_Ask_if_the_customer_wants_to_add_PIC_LPIC_to_their_account$(){
		 String checkpoint = "Ask_No_PIC_LPIC_found$_Ask_if_the_customer_wants_to_add_PIC_LPIC_to_their_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_No_PIC_found$_Ask_if_the_customer_wants_to_add_PIC_to_their_account$(){
		 String checkpoint = "Ask_No_PIC_found$_Ask_if_the_customer_wants_to_add_PIC_to_their_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_No_LPIC_found$_Ask_if_the_customer_wants_to_add_LPIC_to_their_account$(){
		 String checkpoint = "Ask_No_LPIC_found$_Ask_if_the_customer_wants_to_add_LPIC_to_their_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_No(){
		 String checkpoint = "Ask_No";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Multiple_service_orders_indicate_Resale_activity$(){
		 String checkpoint = "Ask_Multiple_service_orders_indicate_Resale_activity$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call$_Did_you_get_ROL$(){
		 String checkpoint = "Ask_Make_a_test_call$_Did_you_get_ROL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_verify_fast_busy_condition$(){
		 String checkpoint = "Ask_Make_a_test_call_to_verify_fast_busy_condition$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$$$ALL_is_not_in_service_for_incoming_calls$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$$$ALL_is_not_in_service_for_incoming_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$$$9998002360_is_not_in_service_for_incoming_calls$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$$$9998002360_is_not_in_service_for_incoming_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$$$9996002360_is_not_in_service_for_incoming_calls$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$$$9996002360_is_not_in_service_for_incoming_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$$$9991112360_is_not_in_service_for_incoming_calls$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$$$9991112360_is_not_in_service_for_incoming_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$_Did_the_MA_hear_the_modem$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$_Did_the_MA_hear_the_modem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_number$_Did_the_MA_hear_the_modem(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_number$_Did_the_MA_hear_the_modem";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Make_a_test_call_to_the_customer$s_number$(){
		 String checkpoint = "Ask_Make_a_test_call_to_the_customer$s_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_LPIC_on_account_is_9100$_Does_customer_agree$(){
		 String checkpoint = "Ask_LPIC_on_account_is_9100$_Does_customer_agree$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_LPIC_on_account_is_5124$_Does_customer_agree$(){
		 String checkpoint = "Ask_LPIC_on_account_is_5124$_Does_customer_agree$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Line_is_not_busy$_Is_the_customer_requesting_that_the_line_be_busied_out$(){
		 String checkpoint = "Ask_Line_is_not_busy$_Is_the_customer_requesting_that_the_line_be_busied_out$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Line_is_busy$_Is_the_customer_requesting_that_the_line_be_made_un_busy$(){
		 String checkpoint = "Ask_Line_is_busy$_Is_the_customer_requesting_that_the_line_be_made_un_busy$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Kick_off_QVF$_Was_the_QVF_successful$(){
		 String checkpoint = "Ask_Kick_off_QVF$_Was_the_QVF_successful$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_Touchtone_on_Billing_Record$(){
		 String checkpoint = "Ask_Is_Touchtone_on_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_Touchtone_in_translations$(){
		 String checkpoint = "Ask_Is_Touchtone_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_Urgent$(){
		 String checkpoint = "Ask_Is_this_Urgent$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_request_to_temporarily_lower$raise_the_Drop_wire_for_Tree_Trimming$(){
		 String checkpoint = "Ask_Is_this_request_to_temporarily_lower$raise_the_Drop_wire_for_Tree_Trimming$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_occurring_on_all_International_numbers$(){
		 String checkpoint = "Ask_Is_this_occurring_on_all_International_numbers$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_Hazardous$(){
		 String checkpoint = "Ask_Is_this_Hazardous$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_account_denied_temporarily_suspended(){
		 String checkpoint = "Ask_Is_this_account_denied_temporarily_suspended";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_account_denied_temporarily__suspended(){
		 String checkpoint = "Ask_Is_this_account_denied_temporarily__suspended";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_account_denied_temporarily(){
		 String checkpoint = "Ask_Is_this_account_denied_temporarily";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_a_third_party_report$(){
		 String checkpoint = "Ask_Is_this_a_third_party_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_a_Public_Emergency_Agency_$PEA$$(){
		 String checkpoint = "Ask_Is_this_a_Public_Emergency_Agency_$PEA$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_this_a_medical_emergency(){
		 String checkpoint = "Ask_Is_this_a_medical_emergency";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_there_any_equipment_$such_as_headsets(){
		 String checkpoint = "Ask_Is_there_any_equipment_$such_as_headsets";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_there_any_equipment(){
		 String checkpoint = "Ask_Is_there_any_equipment";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_there_a_restriction_in_translations_related_to_the_reported_trouble$(){
		 String checkpoint = "Ask_Is_there_a_restriction_in_translations_related_to_the_reported_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_trouble_reported_related_to_the_OEF_Failure$(){
		 String checkpoint = "Ask_Is_the_trouble_reported_related_to_the_OEF_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_trouble_reported_related_to_the_Failure$(){
		 String checkpoint = "Ask_Is_the_trouble_reported_related_to_the_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_trouble_reported_related_to_the_Central_Office_Failure$(){
		 String checkpoint = "Ask_Is_the_trouble_reported_related_to_the_Central_Office_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$(){
		 String checkpoint = "Ask_Is_the_trouble_reported_related_to_the_Cable_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_Sub_paying_for_this_feature$(){
		 String checkpoint = "Ask_Is_the_Sub_paying_for_this_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_service_affected$(){
		 String checkpoint = "Ask_Is_the_service_affected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_PSAP_reporting_this_problem$(){
		 String checkpoint = "Ask_Is_the_PSAP_reporting_this_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_line_out_of_service_because_of_this_problem$(){
		 String checkpoint = "Ask_Is_the_line_out_of_service_because_of_this_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer$s_trouble_resolved$(){
		 String checkpoint = "Ask_Is_the_customer$s_trouble_resolved$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer$s_line_forwarded$(){
		 String checkpoint = "Ask_Is_the_customer$s_line_forwarded$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_using_the_correct_Centrex_access_code$(){
		 String checkpoint = "Ask_Is_the_customer_using_the_correct_Centrex_access_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_using_a_dial_access_code_of_8_or_9_prior_to_dialing_number$(){
		 String checkpoint = "Ask_Is_the_customer_using_a_dial_access_code_of_8_or_9_prior_to_dialing_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_stating_that_the_feature_is_working_on_their_line_in_error$(){
		 String checkpoint = "Ask_Is_the_customer_stating_that_the_feature_is_working_on_their_line_in_error$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_satisfied$(){
		 String checkpoint = "Ask_Is_the_customer_satisfied$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_request_due_to_demolition$(){
		 String checkpoint = "Ask_Is_the_customer_request_due_to_demolition$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_reporting_trouble_on_the_Data_portion_of_service(){
		 String checkpoint = "Ask_Is_the_customer_reporting_trouble_on_the_Data_portion_of_service";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_reporting_the_Data_portion_of_service$(){
		 String checkpoint = "Ask_Is_the_customer_reporting_the_Data_portion_of_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_reporting_a_trouble$$$Voice_Mail_or_a_feature(){
		 String checkpoint = "Ask_Is_the_customer_reporting_a_trouble$$$Voice_Mail_or_a_feature";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_reporting_a_trouble$$$MemoryCall_or_a_feature(){
		 String checkpoint = "Ask_Is_the_customer_reporting_a_trouble$$$MemoryCall_or_a_feature";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_reporting_5_or_more_lines$(){
		 String checkpoint = "Ask_Is_the_customer_reporting_5_or_more_lines$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_receiving_calls_for_another_telephone_number$(){
		 String checkpoint = "Ask_Is_the_customer_receiving_calls_for_another_telephone_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_calling_from_the_line$$$not_working$(){
		 String checkpoint = "Ask_Is_the_customer_calling_from_the_line$$$not_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$(){
		 String checkpoint = "Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_carrier_reporting_trouble$(){
		 String checkpoint = "Ask_Is_the_carrier_reporting_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_California_Highway_Patrol_$CHP$_reporting_a_Hazardous(){
		 String checkpoint = "Ask_Is_the_California_Highway_Patrol_$CHP$_reporting_a_Hazardous";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_the_beeping_heard_on_all_phones$(){
		 String checkpoint = "Ask_Is_the_beeping_heard_on_all_phones$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_that_line_currently_in_use$(){
		 String checkpoint = "Ask_Is_that_line_currently_in_use$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_it_affecting_your_service$(){
		 String checkpoint = "Ask_Is_it_affecting_your_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_using_dial_around_code$(){
		 String checkpoint = "Ask_Is_customer_using_dial_around_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_using_dial_access_code_of_8_or_9_prior_to_dialing_the_number$(){
		 String checkpoint = "Ask_Is_customer_using_dial_access_code_of_8_or_9_prior_to_dialing_the_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_using_a_Dial_Around_Code$(){
		 String checkpoint = "Ask_Is_customer_using_a_Dial_Around_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_using_a_dial_access_code_of_8_or_9_prior_to_dialing_the_number$(){
		 String checkpoint = "Ask_Is_customer_using_a_dial_access_code_of_8_or_9_prior_to_dialing_the_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_satisfied$(){
		 String checkpoint = "Ask_Is_customer_satisfied$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_satisfied_with_explanation$(){
		 String checkpoint = "Ask_Is_customer_satisfied_with_explanation$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_reporting_unwanted_solicitation_calls$(){
		 String checkpoint = "Ask_Is_customer_reporting_unwanted_solicitation_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$(){
		 String checkpoint = "Ask_Is_customer_reporting_Can$t_Be_Called_by_ATT_customers_only$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_paying_for_the_feature$(){
		 String checkpoint = "Ask_Is_customer_paying_for_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_dialing_correctly$(){
		 String checkpoint = "Ask_Is_customer_dialing_correctly$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_calling_to_request_a_24_hour$$$reporting_trouble_on_line$(){
		 String checkpoint = "Ask_Is_customer_calling_to_request_a_24_hour$$$reporting_trouble_on_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_customer_able_to_use_a_different_Dial_Around_Code$(){
		 String checkpoint = "Ask_Is_customer_able_to_use_a_different_Dial_Around_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Is_CALL_TRACE_available$(){
		 String checkpoint = "Ask_Is_CALL_TRACE_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_problem_been_solved$(){
		 String checkpoint = "Ask_Has_the_problem_been_solved$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_problem_been_resolved$(){
		 String checkpoint = "Ask_Has_the_problem_been_resolved$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_jack_ever_worked_with_the_telephone_number_being_reported$(){
		 String checkpoint = "Ask_Has_the_jack_ever_worked_with_the_telephone_number_being_reported$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_customer_had_their_vendor_out_to_isolate_the_trouble$(){
		 String checkpoint = "Ask_Has_the_customer_had_their_vendor_out_to_isolate_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_customer_had_their_vendor_out_to(){
		 String checkpoint = "Ask_Has_the_customer_had_their_vendor_out_to";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_customer_contacted_their_carrier$(){
		 String checkpoint = "Ask_Has_the_customer_contacted_their_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_the_customer_already_stated_that_they_have_checked_their_Caller_ID_equipment$(){
		 String checkpoint = "Ask_Has_the_customer_already_stated_that_they_have_checked_their_Caller_ID_equipment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_NCSC_been_notified_of_any_exceptional_reason_for_commitment_being_120_hours_or_more$(){
		 String checkpoint = "Ask_Has_NCSC_been_notified_of_any_exceptional_reason_for_commitment_being_120_hours_or_more$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_customer_retrieved_their_messages$(){
		 String checkpoint = "Ask_Has_customer_retrieved_their_messages$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_customer_checked_equipment_and_found_trouble$$$$Dialtone_OK_at_NID$$(){
		 String checkpoint = "Ask_Has_customer_checked_equipment_and_found_trouble$$$$Dialtone_OK_at_NID$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Has_customer_checked_CPE_and$or_NID$(){
		 String checkpoint = "Ask_Has_customer_checked_CPE_and$or_NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Explain_to_the_customer_that_there_was_a_PIC_change_on_their_line$(){
		 String checkpoint = "Ask_Explain_to_the_customer_that_there_was_a_PIC_change_on_their_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_Translations_match_order$(){
		 String checkpoint = "Ask_Does_Translations_match_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_wish_to_make_an_appointment$(){
		 String checkpoint = "Ask_Does_the_customer_wish_to_make_an_appointment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_to_isolate_their_own_trouble$(){
		 String checkpoint = "Ask_Does_the_customer_want_to_isolate_their_own_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_their_vendor_to_isolate_the_trouble$(){
		 String checkpoint = "Ask_Does_the_customer_want_their_vendor_to_isolate_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_their_vendor_to_come_out_first$(){
		 String checkpoint = "Ask_Does_the_customer_want_their_vendor_to_come_out_first$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_their_calls_temporarily_forwarded$(){
		 String checkpoint = "Ask_Does_the_customer_want_their_calls_temporarily_forwarded$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_their_calls(){
		 String checkpoint = "Ask_Does_the_customer_want_their_calls";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_the_line_to_be_made(){
		 String checkpoint = "Ask_Does_the_customer_want_the_line_to_be_made";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_ATT_to_isolate_the_trouble$(){
		 String checkpoint = "Ask_Does_the_customer_want_ATT_to_isolate_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_a_trouble_report_opened_$(){
		 String checkpoint = "Ask_Does_the_customer_want_a_trouble_report_opened_$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_want_a_trouble_report(){
		 String checkpoint = "Ask_Does_the_customer_want_a_trouble_report";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_still_want_the_loaner_telephone$(){
		 String checkpoint = "Ask_Does_the_customer_still_want_the_loaner_telephone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_still_want_a_dispatch$(){
		 String checkpoint = "Ask_Does_the_customer_still_want_a_dispatch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_need_to_update_their_reach_information$(){
		 String checkpoint = "Ask_Does_the_customer_need_to_update_their_reach_information$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_have_Dial_Tone$(){
		 String checkpoint = "Ask_Does_the_customer_have_Dial_Tone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_have_ATT_CPE$(){
		 String checkpoint = "Ask_Does_the_customer_have_ATT_CPE$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$(){
		 String checkpoint = "Ask_Does_the_customer_have_a_pulse$tone_switch_on_their_telephone_set$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_demand_a_dispatch$(){
		 String checkpoint = "Ask_Does_the_customer_demand_a_dispatch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_agree_to_close_the_report$(){
		 String checkpoint = "Ask_Does_the_customer_agree_to_close_the_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_customer_accept_this$(){
		 String checkpoint = "Ask_Does_the_customer_accept_this$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_calling_party_agree_to_the_charges$(){
		 String checkpoint = "Ask_Does_the_calling_party_agree_to_the_charges$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_the_Billing_record_have_the_correct_information_for_this_customer(){
		 String checkpoint = "Ask_Does_the_Billing_record_have_the_correct_information_for_this_customer";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_NID_location_require_access_arrangements$(){
		 String checkpoint = "Ask_Does_NID_location_require_access_arrangements$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_$tPhone_num$$$Wireless_Home_Phone$(){
		 String checkpoint = "Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_&lt;Phone_num&gt;$$$Wireless_Home_Phone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_888_341_1270$$$Wireless_Home_Phone$(){
		 String checkpoint = "Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_888_341_1270$$$Wireless_Home_Phone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_866_860_9198$$$Wireless_Home_Phone$(){
		 String checkpoint = "Ask_Does_customer_want_to_transfer_to_WHP_Sales_Center_at_866_860_9198$$$Wireless_Home_Phone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_remove$change_the_restrictions$(){
		 String checkpoint = "Ask_Does_customer_want_to_remove$change_the_restrictions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_remove_toll_restriction$(){
		 String checkpoint = "Ask_Does_customer_want_to_remove_toll_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_to_remove_restriction$(){
		 String checkpoint = "Ask_Does_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_their_calls_temporarily_forwarded$_2(){
		 String checkpoint = "Ask_Does_customer_want_their_calls_temporarily_forwarded$_2";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_their_calls_temporarily_forwarded$(){
		 String checkpoint = "Ask_Does_customer_want_their_calls_temporarily_forwarded$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_want_the_feature$(){
		 String checkpoint = "Ask_Does_customer_want_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_have_Voice_Mail$(){
		 String checkpoint = "Ask_Does_customer_have_Voice_Mail$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_with_the_PIC$LPIC_found_in_the_Billing_Record$(){
		 String checkpoint = "Ask_Does_customer_agree_with_the_PIC$LPIC_found_in_the_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_with_the_CFN_in_the_Billing_Record$(){
		 String checkpoint = "Ask_Does_customer_agree_with_the_CFN_in_the_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_with_PIC_on_the_Account$(){
		 String checkpoint = "Ask_Does_customer_agree_with_PIC_on_the_Account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_with_LPIC_in_Billing$(){
		 String checkpoint = "Ask_Does_customer_agree_with_LPIC_in_Billing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_with_CFN(){
		 String checkpoint = "Ask_Does_customer_agree_with_CFN";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_to_check_CPE$NID$(){
		 String checkpoint = "Ask_Does_customer_agree_to_check_CPE$NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_agree_to_charges$(){
		 String checkpoint = "Ask_Does_customer_agree_to_charges$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_customer_accept_Expedite_result$(){
		 String checkpoint = "Ask_Does_customer_accept_Expedite_result$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_Billing_Record_match_LCC_in_translations$(){
		 String checkpoint = "Ask_Does_Billing_Record_match_LCC_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Does_ATT_own_the_800_number$(){
		 String checkpoint = "Ask_Does_ATT_own_the_800_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_want_to_enter_a_new_ticket$(){
		 String checkpoint = "Ask_Do_you_want_to_enter_a_new_ticket$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_want_to_continue_checking_the_features_in_switch$(){
		 String checkpoint = "Ask_Do_you_want_to_continue_checking_the_features_in_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_need_to_refer_this_to_the_EA$(){
		 String checkpoint = "Ask_Do_you_need_to_refer_this_to_the_EA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_need_to_enter_this_into_EMS(){
		 String checkpoint = "Ask_Do_you_need_to_enter_this_into_EMS";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_need_to_arrange_access_with_the_customer$(){
		 String checkpoint = "Ask_Do_you_need_to_arrange_access_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_you_have_Dial_Tone$(){
		 String checkpoint = "Ask_Do_you_have_Dial_Tone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Do_the_billing_records_and_customers_information_agree$(){
		 String checkpoint = "Ask_Do_the_billing_records_and_customers_information_agree$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$(){
		 String checkpoint = "Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_this_fix_resolve_the_customer$s_trouble$(){
		 String checkpoint = "Ask_Did_this_fix_resolve_the_customer$s_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_the_dial_access_explanation_solve_the_problem$(){
		 String checkpoint = "Ask_Did_the_dial_access_explanation_solve_the_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_the_dial_access_explanation_solve_the(){
		 String checkpoint = "Ask_Did_the_dial_access_explanation_solve_the";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_feature_education_resolve_the_problem$(){
		 String checkpoint = "Ask_Did_feature_education_resolve_the_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Did_feature_education_resolve_problem$(){
		 String checkpoint = "Ask_Did_feature_education_resolve_problem$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Dial_around_toll_restriction_found$_Does_customer_want_to_remove_restriction$(){
		 String checkpoint = "Ask_Dial_around_toll_restriction_found$_Does_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Dial_around_restrictions_found$_Does_customer_want_restrictions_removed$(){
		 String checkpoint = "Ask_Dial_around_restrictions_found$_Does_customer_want_restrictions_removed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Customer_Record_shows_PBX$(){
		 String checkpoint = "Ask_Customer_Record_shows_PBX$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Customer_has_DSL$_Were_noise_filters_installed_on_this_line$(){
		 String checkpoint = "Ask_Customer_has_DSL$_Were_noise_filters_installed_on_this_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Customer_has_DSL$_Are_noise_filters$DSL_Splitters_installed_on_line$(){
		 String checkpoint = "Ask_Customer_has_DSL$_Are_noise_filters$DSL_Splitters_installed_on_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Customer_has_a_Deny_Non_regulated_Product_Flag_$DDR$_on_their_account$(){
		 String checkpoint = "Ask_Customer_has_a_Deny_Non_regulated_Product_Flag_$DDR$_on_their_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Compare_the_LCC_in_the_Billing_Record_to_what_is_in_Translations$(){
		 String checkpoint = "Ask_Compare_the_LCC_in_the_Billing_Record_to_what_is_in_Translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Compare_Billing_Record_to_translations$_Is_LCC_wrong_in_translations$(){
		 String checkpoint = "Ask_Compare_Billing_Record_to_translations$_Is_LCC_wrong_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Commitment_has_been_missed_on_this_report$(){
		 String checkpoint = "Ask_Commitment_has_been_missed_on_this_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_translations$_Does_translations_match_Billing_Record$(){
		 String checkpoint = "Ask_Check_translations$_Does_translations_match_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_translations_for_Call_Forwarding$_Is_Call_Forwarding_activated$(){
		 String checkpoint = "Ask_Check_translations_for_Call_Forwarding$_Is_Call_Forwarding_activated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_translations_for_Call_Forwarding$_Is(){
		 String checkpoint = "Ask_Check_translations_for_Call_Forwarding$_Is";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_that_lines_are_hunting_correctly$_Is_there_a_problem_wit(){
		 String checkpoint = "Ask_Check_that_lines_are_hunting_correctly$_Is_there_a_problem_wit";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_service_code$s$_to_determine_if_the_service_should_be_working$_Do_you_want_to_enter_a_MR_report$(){
		 String checkpoint = "Ask_Check_service_code$s$_to_determine_if_the_service_should_be_working$_Do_you_want_to_enter_a_MR_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_QVF_INFORMATION_to_verify_Ring_Cycle$_Is_it_correct$(){
		 String checkpoint = "Ask_Check_QVF_INFORMATION_to_verify_Ring_Cycle$_Is_it_correct$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_LCC_in_translations$_Does_translations_match_Billing_Record$(){
		 String checkpoint = "Ask_Check_LCC_in_translations$_Does_translations_match_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_for_repeat_and_NOW$_Does_the_customer_qualify$(){
		 String checkpoint = "Ask_Check_for_repeat_and_NOW$_Does_the_customer_qualify$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Check_Billing_Record_or_Order_Information_to_determine_if_feature_is_being_billed(){
		 String checkpoint = "Ask_Check_Billing_Record_or_Order_Information_to_determine_if_feature_is_being_billed";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Can_you_repair_using_QVF$(){
		 String checkpoint = "Ask_Can_you_repair_using_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Can_customer_receive_calls$(){
		 String checkpoint = "Ask_Can_customer_receive_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Can_customer_make_calls$(){
		 String checkpoint = "Ask_Can_customer_make_calls$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Call_forwarding_is_not_found_in_billing$_Does_the_customer_want_to_keep_the_call_forwarding_feature$$(){
		 String checkpoint = "Ask_Call_forwarding_is_not_found_in_billing$_Does_the_customer_want_to_keep_the_call_forwarding_feature$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Call_Forwarding_is_active_on_Account$$$deactivation_instructions(){
		 String checkpoint = "Ask_Call_Forwarding_is_active_on_Account$$$deactivation_instructions";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Call_Forwarding_is_active_but_is_not_in_billing$(){
		 String checkpoint = "Ask_Call_Forwarding_is_active_but_is_not_in_billing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Billing_Record_currently_unavailable(){
		 String checkpoint = "Ask_Billing_Record_currently_unavailable";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_WILTEL_LOCAL_NETWORK_LLC_at_877_864_2310";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_QWEST_at_888_999_2656(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_QWEST_at_888_999_2656";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_NII_COMMUNICATIONS_LTD$_at_800_897_2448(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_NII_COMMUNICATIONS_LTD$_at_800_897_2448";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_ATT_at_1_800_288_4727(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_ATT_at_1_800_288_4727";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_does_not_provide_your_local_service$_Please_contact_ALLEGIANCE_TELECOM_INC$_at_800_553_1989(){
		 String checkpoint = "Ask_ATT_does_not_provide_your_local_service$_Please_contact_ALLEGIANCE_TELECOM_INC$_at_800_553_1989";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_ATT_can_send_you_a_suppression_filter_at_no_charge$(){
		 String checkpoint = "Ask_ATT_can_send_you_a_suppression_filter_at_no_charge$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_they_have_called_the_CMS_hotline_for_assistance$(){
		 String checkpoint = "Ask_Ask_the_customer_if_they_have_called_the_CMS_hotline_for_assistance$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_they_have_called_the_Centrexmate_hotline_for_assistance$(){
		 String checkpoint = "Ask_Ask_the_customer_if_they_have_called_the_Centrexmate_hotline_for_assistance$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_they_have_called_the_CCRS$Plexarmate_hotline_for_assistance$(){
		 String checkpoint = "Ask_Ask_the_customer_if_they_have_called_the_CCRS$Plexarmate_hotline_for_assistance$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$(){
		 String checkpoint = "Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_the_number_they_are_calling_is_on_their_Call_Control_list$(){
		 String checkpoint = "Ask_Ask_the_customer_if_the_number_they_are_calling_is_on_their_Call_Control_list$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_the_customer_if_the_number_they_are(){
		 String checkpoint = "Ask_Ask_the_customer_if_the_number_they_are";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_they_hear_others_on_line$_$If(){
		 String checkpoint = "Ask_Ask_customer_if_they_hear_others_on_line$_$If";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_they_have_tried_another_jack_or_another_phone_in_the_jack$(){
		 String checkpoint = "Ask_Ask_customer_if_they_have_tried_another_jack_or_another_phone_in_the_jack$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_they_are_out_of_service$(){
		 String checkpoint = "Ask_Ask_customer_if_they_are_out_of_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_their_phone_line_is_used_only_for$$$satellite_dish_connected$(){
		 String checkpoint = "Ask_Ask_customer_if_their_phone_line_is_used_only_for$$$satellite_dish_connected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_their_phone_line_is_used_only_for_voice$$$device_connected$(){
		 String checkpoint = "Ask_Ask_customer_if_their_phone_line_is_used_only_for_voice$$$device_connected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Ask_customer_if_the_jack_is_damaged$(){
		 String checkpoint = "Ask_Ask_customer_if_the_jack_is_damaged$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Are_you_calling_from_that_number_now$(){
		 String checkpoint = "Ask_Are_you_calling_from_that_number_now$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Are_the_facilities_on_Integrated_SLC_$(){
		 String checkpoint = "Ask_Are_the_facilities_on_Integrated_SLC_$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Are_calls_received_between_10pm___2am$(){
		 String checkpoint = "Ask_Are_calls_received_between_10pm___2am$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Are_calls_originating_from_a_secure$correctional_facility$(){
		 String checkpoint = "Ask_Are_calls_originating_from_a_secure$correctional_facility$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_An_unprocessed_EMS_issue_exists$_Is_the_customer_calling_about_the_EMS_request$(){
		 String checkpoint = "Ask_An_unprocessed_EMS_issue_exists$_Is_the_customer_calling_about_the_EMS_request$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_there_is_a_toll_restriction_on_the_account$_Does_the_customer_want_to_remove_the_Toll_Restriction$(){
		 String checkpoint = "Ask_Advise_the_customer_that_there_is_a_toll_restriction_on_the_account$_Does_the_customer_want_to_remove_the_Toll_Restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_line_is_forwarded$_Provide_deactivation_instructions(){
		 String checkpoint = "Ask_Advise_the_customer_that_line_is_forwarded$_Provide_deactivation_instructions";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_line_is_forwarded$_Provide_deactiv(){
		 String checkpoint = "Ask_Advise_the_customer_that_line_is_forwarded$_Provide_deactiv";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_line_is_forwarded$(){
		 String checkpoint = "Ask_Advise_the_customer_that_line_is_forwarded$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_calls_are_forwarded$_Provide_instruc(){
		 String checkpoint = "Ask_Advise_the_customer_that_calls_are_forwarded$_Provide_instruc";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_ATT_can_provide_this_service_at_our_labor_rates$(){
		 String checkpoint = "Ask_Advise_the_customer_that_ATT_can_provide_this_service_at_our_labor_rates$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_that_a_Toll_Restriction_is_on_the_account$_Does_the_customer_want_to_remove_it$(){
		 String checkpoint = "Ask_Advise_the_customer_that_a_Toll_Restriction_is_on_the_account$_Does_the_customer_want_to_remove_it$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_customer_of_the_toll_restriction$_Does_customer_want_to_remove_restriction$(){
		 String checkpoint = "Ask_Advise_the_customer_of_the_toll_restriction$_Does_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_the_caller_before_any_work_can_be_done_an_email_must_be_sent_to_the_NDC_Demolition_Mail_box_at_NDC_DEMO$att$com$(){
		 String checkpoint = "Ask_Advise_the_caller_before_any_work_can_be_done_an_email_must_be_sent_to_the_NDC_Demolition_Mail_box_at_NDC_DEMO$att$com$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_that_cordless_phone_can_sometimes(){
		 String checkpoint = "Ask_Advise_that_cordless_phone_can_sometimes";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_customer_to_check_their_equipment$_Is_customer_willing_to_check_equipment$(){
		 String checkpoint = "Ask_Advise_customer_to_check_their_equipment$_Is_customer_willing_to_check_equipment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_customer_that_there_is_a_toll_restriction$(){
		 String checkpoint = "Ask_Advise_customer_that_there_is_a_toll_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Advise_customer_that_a_toll_restriction_was_found$_Does_the_customer_want_to_remove_restriction$(){
		 String checkpoint = "Ask_Advise_customer_that_a_toll_restriction_was_found$_Does_the_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$_CCO(){
		 String checkpoint = "Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$_CCO";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$_4(){
		 String checkpoint = "Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$_4";
		 return getValueFromExcel(checkpoint);
		}
		public static String Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$(){
		 String checkpoint = "Ask_Account_does_not_have_PIC$_Does_customer_want_a_PIC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Z_type_tickets_cannot_be_processed_as_subsequent_reports$(){
		 String checkpoint = "AM_Z_type_tickets_cannot_be_processed_as_subsequent_reports$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_will_need_to_call_the_number_on_the_front_of_the_Coin_phone_to_report_this_trouble$(){
		 String checkpoint = "AM_You_will_need_to_call_the_number_on_the_front_of_the_Coin_phone_to_report_this_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center_ALL(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center_ALL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center$$$Please_call_them_at_866_318_3663$$$AMERITEL___UNE___KS(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center$$$Please_call_them_at_866_318_3663$$$AMERITEL___UNE___KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center$$$Please_call_them_at_866_247_7727$$$COMMUNICATIONS_INC_is_their_Service_Provider_$(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center$$$Please_call_them_at_866_247_7727$$$COMMUNICATIONS_INC_is_their_Service_Provider_$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center$$$877_375_2255(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center$$$877_375_2255";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center$$$800_923_8375(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center$$$800_923_8375";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_have_reached_the_ATT_Customer_Repair_Center$$$715_392_8101(){
		 String checkpoint = "AM_You_have_reached_the_ATT_Customer_Repair_Center$$$715_392_8101";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_You_can_verify_if_the_trouble_is_in_the_phone_equipment(){
		 String checkpoint = "AM_You_can_verify_if_the_trouble_is_in_the_phone_equipment";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Yes(){
		 String checkpoint = "AM_Yes";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_WIRETAP_is_not_covered_by_LINEBACKER$(){
		 String checkpoint = "AM_WIRETAP_is_not_covered_by_LINEBACKER$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Wireline_and_U_verse_services$$$Please_contact_your_Frontier_Customer_Service_Representatives$_ATT_wireless$$$1_800_921_8101Frontier_Business$_1_800_921_8102(){
		 String checkpoint = "AM_Wireline_and_U_verse_services$$$Please_contact_your_Frontier_Customer_Service_Representatives$_ATT_wireless$$$1_800_921_8101Frontier_Business$_1_800_921_8102";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_When_referring_customer_to_Cingular(){
		 String checkpoint = "AM_When_referring_customer_to_Cingular";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_WFA$DO_information_not_available$(){
		 String checkpoint = "AM_WFA$DO_information_not_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_WFA$C_Center_ID_is_not_found$_Check_the_Center_ID_for_correct_referral(){
		 String checkpoint = "AM_WFA$C_Center_ID_is_not_found$_Check_the_Center_ID_for_correct_referral";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_WFA_Ticket_number_needed$$$complete_the_commitment_Backdown(){
		 String checkpoint = "AM_WFA_Ticket_number_needed$$$complete_the_commitment_Backdown";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Were_you_able_to_reset_using_QVF$(){
		 String checkpoint = "AM_Were_you_able_to_reset_using_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Were_you_able_to_delete_the_message$(){
		 String checkpoint = "AM_Were_you_able_to_delete_the_message$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_We_do_not_handle_repairs_to_the_Data_portion_of_your_line(){
		 String checkpoint = "AM_We_do_not_handle_repairs_to_the_Data_portion_of_your_line";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_We_can_only_clear_the_Voice_portion_of_your_line$$$1_800_ATT_2020$(){
		 String checkpoint = "AM_We_can_only_clear_the_Voice_portion_of_your_line$$$1_800_ATT_2020$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_We_can_only_clear_the_Voice_portion_of_your_line$$$(){
		 String checkpoint = "AM_We_can_only_clear_the_Voice_portion_of_your_line$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Was_the_trouble_resolved$(){
		 String checkpoint = "AM_Was_the_trouble_resolved$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Was_the_Message_Waiting_trouble_resolved_on_the_callback_to_the_customer$(){
		 String checkpoint = "AM_Was_the_Message_Waiting_trouble_resolved_on_the_callback_to_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Was_the_call_placed_greater_than_12_hours_ago$(){
		 String checkpoint = "AM_Was_the_call_placed_greater_than_12_hours_ago$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Was_customer_able_to_delete_message$(){
		 String checkpoint = "AM_Was_customer_able_to_delete_message$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_to_resolution_center_at_all(){
		 String checkpoint = "AM_Warm_transfer_to_resolution_center_at_all";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_to_resolution_center_at_1_888_243_1911$(){
		 String checkpoint = "AM_Warm_transfer_to_resolution_center_at_1_888_243_1911$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_to_resolution_center_at_1_800_332_1321$(){
		 String checkpoint = "AM_Warm_transfer_to_resolution_center_at_1_800_332_1321$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_to_resolution_center_at_1_203_420_3791$(){
		 String checkpoint = "AM_Warm_transfer_to_resolution_center_at_1_203_420_3791$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_Transfer_to_OICC_$Operation_Information_Control_Center$_at_1_800_275_0014$(){
		 String checkpoint = "AM_Warm_Transfer_to_OICC_$Operation_Information_Control_Center$_at_1_800_275_0014$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_the_customer_to_U_verse_Support_at_1_888_722_9337_Transfer_code_924$$(){
		 String checkpoint = "AM_Warm_transfer_the_customer_to_U_verse_Support_at_1_888_722_9337_Transfer_code_924$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Warm_transfer_the_customer_to_U_verse_Support_at_1_888_341_1270_Transfer_code_NONE$(){
		 String checkpoint = "AM_Warm_transfer_the_customer_to_U_verse_Support_at_1_888_341_1270_Transfer_code_NONE$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Voice_mail_features_programmed_in_switch___no_trouble_found$(){
		 String checkpoint = "AM_Voice_mail_features_programmed_in_switch___no_trouble_found$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Verify_that_the_customer_is_using_a_dial_access_code_of_8_or_9(){
		 String checkpoint = "AM_Verify_that_the_customer_is_using_a_dial_access_code_of_8_or_9";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Verify_that_the_customer_is_using_a_dial(){
		 String checkpoint = "AM_Verify_that_the_customer_is_using_a_dial";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Using_the_System_Bar_go_to_WFA_C_for_report_entry$(){
		 String checkpoint = "AM_Using_the_System_Bar_go_to_WFA_C_for_report_entry$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Use_the_Technician_Feedback_Form_to_send_an_email_to_the_technician$s_foreman$(){
		 String checkpoint = "AM_Use_the_Technician_Feedback_Form_to_send_an_email_to_the_technician$s_foreman$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Use_the_link_to_the_NPA$NXX_pages_to_determine_the_RACF$RADN_and_provide_the_number_to_the_customer$(){
		 String checkpoint = "AM_Use_the_link_to_the_NPA$NXX_pages_to_determine_the_RACF$RADN_and_provide_the_number_to_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Use_the_link_to_determine_the_RACF_number$(){
		 String checkpoint = "AM_Use_the_link_to_determine_the_RACF_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Use_the_instructions_in_the_help_file_to_locate_the_customers_RADN(){
		 String checkpoint = "AM_Use_the_instructions_in_the_help_file_to_locate_the_customers_RADN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_remove_feature_from_switch$(){
		 String checkpoint = "AM_Unable_to_remove_feature_from_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$(){
		 String checkpoint = "AM_Unable_to_locate_records_with_the_TN_entered$_If_further_investigation_is_needed_please_enter_a_MR_ticket$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_fix_CALL_FORWARDING$(){
		 String checkpoint = "AM_Unable_to_fix_CALL_FORWARDING$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_fix_CALL_BLOCKER$(){
		 String checkpoint = "AM_Unable_to_fix_CALL_BLOCKER$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_determine_status_of_SPEED_CALLING_8$_The_customer_is_entitled_to_these_features_as_part_of_their_bundle$_Would_they_like_to_get_these_features_added_to_their_service$(){
		 String checkpoint = "AM_Unable_to_determine_status_of_SPEED_CALLING_8$_The_customer_is_entitled_to_these_features_as_part_of_their_bundle$_Would_they_like_to_get_these_features_added_to_their_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_determine_status_of_CALL_WAITING$(){
		 String checkpoint = "AM_Unable_to_determine_status_of_CALL_WAITING$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_determine_status_of_CALL_WAITING_CALL_WAITING$(){
		 String checkpoint = "AM_Unable_to_determine_status_of_CALL_WAITING_CALL_WAITING$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Unable_to_add_feature_in_switch$(){
		 String checkpoint = "AM_Unable_to_add_feature_in_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_TT_has_been_added_to_the_customer$s_line_in_the_switch$(){
		 String checkpoint = "AM_TT_has_been_added_to_the_customer$s_line_in_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Trouble_requires_further_analysis$(){
		 String checkpoint = "AM_Trouble_requires_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Trouble_Report_needs_further_analysis$(){
		 String checkpoint = "AM_Trouble_Report_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Trouble_needs_further_analysis$(){
		 String checkpoint = "AM_Trouble_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_TRANSFER_TO_THE_CAB_AT_800_247_2020(){
		 String checkpoint = "AM_TRANSFER_TO_THE_CAB_AT_800_247_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Transfer_to_Special_Services_$_1_203_771_2247$(){
		 String checkpoint = "AM_Transfer_to_Special_Services_$_1_203_771_2247$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Transfer_to_OICC_$Operation_Information_Control_Center$_$1_800_275_0014$(){
		 String checkpoint = "AM_Transfer_to_OICC_$Operation_Information_Control_Center$_$1_800_275_0014$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Transfer_to_Messaging_Center_at_888_914_2332_$internal_Only$(){
		 String checkpoint = "AM_Transfer_to_Messaging_Center_at_888_914_2332_$internal_Only$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Transfer_to_Messaging_Center_at_877_441_2480_$internal_only$(){
		 String checkpoint = "AM_Transfer_to_Messaging_Center_at_877_441_2480_$internal_only$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_TOUCH_TONE_SERVICE_FOR_TESTING(){
		 String checkpoint = "AM_TOUCH_TONE_SERVICE_FOR_TESTING";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_TN_9998002409_has_other_service_call_forwarded_to_it$_9993330001(){
		 String checkpoint = "AM_TN_9998002409_has_other_service_call_forwarded_to_it$_9993330001";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_TN_9998002406_has_other_service_call_forwarded_to_it$_9993330001(){
		 String checkpoint = "AM_TN_9998002406_has_other_service_call_forwarded_to_it$_9993330001";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Title(){
		 String checkpoint = "AM_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_will_cancel_Expedite_Escalation_Request$_Are_you_sure_you_want_to_Cancel$(){
		 String checkpoint = "AM_This_will_cancel_Expedite_Escalation_Request$_Are_you_sure_you_want_to_Cancel$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM2_This_will_cancel_EMS_Escalatio(){
		 String checkpoint = "AM2_This_will_cancel_EMS_Escalatio";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_will_be_referred_to_our_Voice_Mail_Group_for_correction$(){
		 String checkpoint = "AM_This_will_be_referred_to_our_Voice_Mail_Group_for_correction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_trouble_requires_further_isolation$(){
		 String checkpoint = "AM_This_trouble_requires_further_isolation$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_trouble_requires_further_analysis$(){
		 String checkpoint = "AM_This_trouble_requires_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_trouble_requires_further_analysis(){
		 String checkpoint = "AM_This_trouble_requires_further_analysis";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_trouble_needs_further_analysis$(){
		 String checkpoint = "AM_This_trouble_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_Service_Order_has_not_been_scheduled_for_dispatch$(){
		 String checkpoint = "AM_This_Service_Order_has_not_been_scheduled_for_dispatch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_Service_Order_has_been_scheduled_for_dispatch$$$will_be_working_as_soon_as_possible$(){
		 String checkpoint = "AM_This_Service_Order_has_been_scheduled_for_dispatch$$$will_be_working_as_soon_as_possible$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_service_is_suspended_at_the_customer$s_request$_Transfer_to_the_Business_office$(){
		 String checkpoint = "AM_This_service_is_suspended_at_the_customer$s_request$_Transfer_to_the_Business_office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_service_is_suspended_at_the_customer_request$_Transfer_to_the_Business_Office_to_discuss_account$(){
		 String checkpoint = "AM_This_service_is_suspended_at_the_customer_request$_Transfer_to_the_Business_Office_to_discuss_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_service_is_scheduled_to_be_disconnected_by_a_future_dated_D_order$(){
		 String checkpoint = "AM_This_service_is_scheduled_to_be_disconnected_by_a_future_dated_D_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_service_is_on_a_pay_per_use_basis_only$(){
		 String checkpoint = "AM_This_service_is_on_a_pay_per_use_basis_only$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_service_is_denied_for_non_payment$(){
		 String checkpoint = "AM_This_service_is_denied_for_non_payment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_report_will_be_referred_to_the_NTC(){
		 String checkpoint = "AM_This_report_will_be_referred_to_the_NTC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_report_will_be_referred_to_the_NDC(){
		 String checkpoint = "AM_This_report_will_be_referred_to_the_NDC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_report_will_be_Queued_for_testing$(){
		 String checkpoint = "AM_This_report_will_be_Queued_for_testing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_report_is_being_cancelled$_Please_re_enter_the_correct_number(){
		 String checkpoint = "AM_This_report_is_being_cancelled$_Please_re_enter_the_correct_number";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_report_is_associated_with_the_transferring_of_service_from_one_location_to_another_location$(){
		 String checkpoint = "AM_This_report_is_associated_with_the_transferring_of_service_from_one_location_to_another_location$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_line_has_hunting$(){
		 String checkpoint = "AM_This_line_has_hunting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_not_an_ATT_800$$(){
		 String checkpoint = "AM_This_is_not_an_ATT_800$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_not_an_ATT_800_number$(){
		 String checkpoint = "AM_This_is_not_an_ATT_800_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_an_FTTP_customer_and_requires_special_handling$_Select_a_Trouble$$$to_the_report(){
		 String checkpoint = "AM_This_is_an_FTTP_customer_and_requires_special_handling$_Select_a_Trouble$$$to_the_report";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_an_FTTP_customer_and_requires_special_handling$(){
		 String checkpoint = "AM_This_is_an_FTTP_customer_and_requires_special_handling$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_a_Wholesale_account$(){
		 String checkpoint = "AM_This_is_a_Wholesale_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_a_U_verse_Voice_over_IP_customer$$$888_722_9337__transfer_code_256(){
		 String checkpoint = "AM_This_is_a_U_verse_Voice_over_IP_customer$$$888_722_9337__transfer_code_256";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_1270__to_call_1_800_288_2020(){
		 String checkpoint = "AM_This_is_a_U_verse_Voice_over_IP_customer$$$888_341_1270__to_call_1_800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_the_customer$(){
		 String checkpoint = "AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_t(){
		 String checkpoint = "AM_This_is_a_pooled_account$_Do_not_discuss_Pooled_status_with_t";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_This_customer_leases_ATT_equipment$_If_the_customer_is$$$(){
		 String checkpoint = "AM_This_customer_leases_ATT_equipment$_If_the_customer_is$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_is_trouble_on_the_forwarding_number$(){
		 String checkpoint = "AM_There_is_trouble_on_the_forwarding_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_is_possible_charge_W(){
		 String checkpoint = "AM_There_is_possible_charge_W";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_is_possible_charge$(){
		 String checkpoint = "AM_There_is_possible_charge$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_is_a_PPU_block_on_the_account$_Refer_to_the_Business_Office_to_remove_the_block$(){
		 String checkpoint = "AM_There_is_a_PPU_block_on_the_account$_Refer_to_the_Business_Office_to_remove_the_block$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_has_been_recent_order_activity$(){
		 String checkpoint = "AM_There_has_been_recent_order_activity$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_There_are_multiple_orders_on_this_telephone_number$(){
		 String checkpoint = "AM_There_are_multiple_orders_on_this_telephone_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_trouble_may_be_with_the_number_the_customer_is_calling$(){
		 String checkpoint = "AM_The_trouble_may_be_with_the_number_the_customer_is_calling$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_trouble_may_be_isolated_at_the(){
		 String checkpoint = "AM_The_trouble_may_be_isolated_at_the";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_touchtone_feature_is_programmed_in_the_switch$_Advise_customer_to_check_their_equipment$(){
		 String checkpoint = "AM_The_touchtone_feature_is_programmed_in_the_switch$_Advise_customer_to_check_their_equipment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_test_results_indicate_that_the_trouble(){
		 String checkpoint = "AM_The_test_results_indicate_that_the_trouble";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_test_result_is_inconclusive$_The_line_will_be_retested$(){
		 String checkpoint = "AM_The_test_result_is_inconclusive$_The_line_will_be_retested$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_test_result_is_inconclusive$(){
		 String checkpoint = "AM_The_test_result_is_inconclusive$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_Service_Order_has_been_scheduled_for_dispatch$$$Close_the_report$(){
		 String checkpoint = "AM_The_Service_Order_has_been_scheduled_for_dispatch$$$Close_the_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_report_is_closed$_The_status_is_CLD$(){
		 String checkpoint = "AM_The_report_is_closed$_The_status_is_CLD$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_order_is_Pending_Facilities$(){
		 String checkpoint = "AM_The_order_is_Pending_Facilities$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_order_is_not_completed_refer_to_the_Business_Office_for_additional_assistance$(){
		 String checkpoint = "AM_The_order_is_not_completed_refer_to_the_Business_Office_for_additional_assistance$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_order_is_in_jeopardy$(){
		 String checkpoint = "AM_The_order_is_in_jeopardy$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_order_is_assigned_to_a_technician_and_the_order_will_be_worked_by_the_end_of_the_day$(){
		 String checkpoint = "AM_The_order_is_assigned_to_a_technician_and_the_order_will_be_worked_by_the_end_of_the_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_operation_you_have_specified_may_take_a_while$_It_is_advised_that_you_queue_the_report$(){
		 String checkpoint = "AM_The_operation_you_have_specified_may_take_a_while$_It_is_advised_that_you_queue_the_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_Make_Busy_command_failed$(){
		 String checkpoint = "AM_The_Make_Busy_command_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_LPIC_cannot_be_changed_due_to_the_IntraLATA$$$The_LPIC_of_9199_work_in_unison_for_IWS_II(){
		 String checkpoint = "AM_The_LPIC_cannot_be_changed_due_to_the_IntraLATA$$$The_LPIC_of_9199_work_in_unison_for_IWS_II";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_LPIC_cannot_be_changed_due_to_the_IntraLATA_Wholesale_Service_procedure$(){
		 String checkpoint = "AM_The_LPIC_cannot_be_changed_due_to_the_IntraLATA_Wholesale_Service_procedure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_Linebacker$_Inline_Maintenance_Plans_have_been_discontinued_for_residential_accounts(){
		 String checkpoint = "AM_The_Linebacker+$_Inline+_Maintenance_Plans_have_been_discontinued_for_residential_accounts,";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_line_must_be_clear_in_order_to_complete_testing$(){
		 String checkpoint = "AM_The_line_must_be_clear_in_order_to_complete_testing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_line_hunts_to_another_number$_Verify_with(){
		 String checkpoint = "AM_The_line_hunts_to_another_number$_Verify_with";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_working(){
		 String checkpoint = "AM_The_feature_is_working";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_programmed_in_the_switch$AIN$(){
		 String checkpoint = "AM_The_feature_is_programmed_in_the_switch$AIN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_programmed_in_the_switch$(){
		 String checkpoint = "AM_The_feature_is_programmed_in_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_programmed_in_the_switch_but$$$$$$Do_you_want_to_remove_the_feature_from_the_switch$(){
		 String checkpoint = "AM_The_feature_is_programmed_in_the_switch_but$$$$$$Do_you_want_to_remove_the_feature_from_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_not_in_Billing$_Is_customer_using_as_PPU$(){
		 String checkpoint = "AM_The_feature_is_not_in_Billing$_Is_customer_using_as_PPU$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_not_found_in_the_switch$(){
		 String checkpoint = "AM_The_feature_is_not_found_in_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_is_missing_in_the_switch$(){
		 String checkpoint = "AM_The_feature_is_missing_in_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_cannot_be_removed_through_QVF$(){
		 String checkpoint = "AM_The_feature_cannot_be_removed_through_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_feature_cannot_be_added_through_QVF$(){
		 String checkpoint = "AM_The_feature_cannot_be_added_through_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer$s_mailbox_has_an_extension_mailbox_option$(){
		 String checkpoint = "AM_The_customer$s_mailbox_has_an_extension_mailbox_option$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer$s_mailbox_has_a_sub$extension_mailbox_option$(){
		 String checkpoint = "AM_The_customer$s_mailbox_has_a_sub$extension_mailbox_option$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer_will_need_to_contact_their_Carrier$(){
		 String checkpoint = "AM_The_customer_will_need_to_contact_their_Carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer_subscribes_to_Phone_Protect$$$Hours_are_M_F_9A_9P_EST_SAT_9A_2P_EST(){
		 String checkpoint = "AM_The_customer_subscribes_to_Phone_Protect$$$Hours_are_M_F_9A_9P_EST_SAT_9A_2P_EST";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer_is_not_paying_for_the_feature$(){
		 String checkpoint = "AM_The_customer_is_not_paying_for_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_customer_can_make_the_changes_online$$$MW$$automated_system_$_800_233_7719(){
		 String checkpoint = "AM_The_customer_can_make_the_changes_online$$$MW$$automated_system_$_800_233_7719";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_commitment_will_be_set_to_the_next_4_business_hours$(){
		 String checkpoint = "AM_The_commitment_will_be_set_to_the_next_4_business_hours$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_Activate_Call_Forward_command_failed$(){
		 String checkpoint = "AM_The_Activate_Call_Forward_command_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_account_record_indicates_this_line_has_DSL$(){
		 String checkpoint = "AM_The_account_record_indicates_this_line_has_DSL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_The_ABWS_system_is_un_available_at_this_time(){
		 String checkpoint = "AM_The_ABWS_system_is_un_available_at_this_time";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Thank_customer_for_letting_us$$$auto_close_in_24_hours$(){
		 String checkpoint = "AM_Thank_customer_for_letting_us$$$auto_close_in_24_hours$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad_SPD8(){
		 String checkpoint = "AM_Test_the_touchtone_pad_SPD8";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad$$$was_the_touchtone_signal_good$(){
		 String checkpoint = "AM_Test_the_touchtone_pad$$$was_the_touchtone_signal_good$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad$$$or_$_key_on_the_pad_and_listen_for_a_solid_tone$_Was_the_touchtone_signal_good$(){
		 String checkpoint = "AM_Test_the_touchtone_pad$$$or_$_key_on_the_pad_and_listen_for_a_solid_tone$_Was_the_touchtone_signal_good$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad$$$or_$_key(){
		 String checkpoint = "AM_Test_the_touchtone_pad$$$or_$_key";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad$(){
		 String checkpoint = "AM_Test_the_touchtone_pad$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_the_touchtone_pad_with_customer_by_pressing(){
		 String checkpoint = "AM_Test_the_touchtone_pad_with_customer_by_pressing";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Test_is_needed$_Has_the_customer_hung_up$(){
		 String checkpoint = "AM_Test_is_needed$_Has_the_customer_hung_up$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Take_report$_T(){
		 String checkpoint = "AM_Take_report$_T";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Take_report$(){
		 String checkpoint = "AM_Take_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Take_report_on_the_trouble_described_by_the_customer$(){
		 String checkpoint = "AM_Take_report_on_the_trouble_described_by_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Switch_to_Live_mode_and_try_the_number_again$(){
		 String checkpoint = "AM_Switch_to_Live_mode_and_try_the_number_again$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_State_of_California_Agency$_CMAC_Controlled$_If_unsure_of_process_see_supervisor$(){
		 String checkpoint = "AM_State_of_California_Agency$_CMAC_Controlled$_If_unsure_of_process_see_supervisor$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Some_customers_are_on_special_calling_plans$_Is_the_customer_dialing_the_call_with_the_correct_dialing_pattern$(){
		 String checkpoint = "AM_Some_customers_are_on_special_calling_plans$_Is_the_customer_dialing_the_call_with_the_correct_dialing_pattern$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Some_customers_are_on_special_calling_plans$(){
		 String checkpoint = "AM_Some_customers_are_on_special_calling_plans$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Since_the_commitment$appointment_to_repair_your_service_is_over_120_hours(){
		 String checkpoint = "AM_Since_the_commitment$appointment_to_repair_your_service_is_over_120_hours";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Should_you_need_to_place_an_emergency_call_while_the_problem_is_being_cleared_please_dial_0_for_operator$(){
		 String checkpoint = "AM_Should_you_need_to_place_an_emergency_call_while_the_problem_is_being_cleared_please_dial_0_for_operator$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Service_Provider_is_not_ATT$(){
		 String checkpoint = "AM_Service_Provider_is_not_ATT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Service_order_pending_to_remove_feature_in_question$_Is_the_customer_reporting_that_the_feature_is_not_working$(){
		 String checkpoint = "AM_Service_order_pending_to_remove_feature_in_question$_Is_the_customer_reporting_that_the_feature_is_not_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Service_Order_check_ok_continue_with_the_report(){
		 String checkpoint = "AM_Service_Order_check_ok_continue_with_the_report";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Service_Order_activity_indicates_Toll_Restrictions_were_added_to_this_account$_Refer_to_Business_Office$(){
		 String checkpoint = "AM_Service_Order_activity_indicates_Toll_Restrictions_were_added_to_this_account$_Refer_to_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Select_the_correct_city_name_in_the_City_field$$$street_in_the_Location_field(){
		 String checkpoint = "AM_Select_the_correct_city_name_in_the_City_field$$$street_in_the_Location_field";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Select_the_correct_city_name_in_the_City_field_if_incorrect$Enter_the_nearest_cross_street_in_the_Location_field$(){
		 String checkpoint = "AM_Select_the_correct_city_name_in_the_City_field_if_incorrect$Enter_the_nearest_cross_street_in_the_Location_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Select_the_appointment_that_was_negotiated_with_the_customer$(){
		 String checkpoint = "AM_Select_the_appointment_that_was_negotiated_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_See_HELP_under_$Linebacker_Set_Delivery_Schedule$_to_get_commitment_date_by_zip_code$(){
		 String checkpoint = "AM_See_HELP_under_$Linebacker_Set_Delivery_Schedule$_to_get_commitment_date_by_zip_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_RX___POSSIBLE_WRONG_NUMBER(){
		 String checkpoint = "AM_RX___POSSIBLE_WRONG_NUMBER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ringmaster_is_unable_to_be_verified_from_the_Switch_for_Southeast$$$trouble_categories$(){
		 String checkpoint = "AM_Ringmaster_is_unable_to_be_verified_from_the_Switch_for_Southeast$$$trouble_categories$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Review_ABWS_Information(){
		 String checkpoint = "AM_Review_ABWS_Information";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reset_using_QVF$(){
		 String checkpoint = "AM_Reset_using_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Report_will_be_sent_to_RCMAC_to_correct_LPIC$_Provide_commitment_date_to_customer$(){
		 String checkpoint = "AM_Report_will_be_sent_to_RCMAC_to_correct_LPIC$_Provide_commitment_date_to_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$_WEST_NDC___Illinois___Wisconsin_800_649_9598(){
		 String checkpoint = "AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$_WEST_NDC___Illinois___Wisconsin_800_649_9598";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$_South_Texas_NDC___Houston___Austin___San_Antonio_888_224_4827(){
		 String checkpoint = "AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$_South_Texas_NDC___Houston___Austin___San_Antonio_888_224_4827";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$__NONE(){
		 String checkpoint = "AM_Report_this_cut_cable$hazardous_condition_to_the_NDC$__NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Repair_rep_to_call_RNSC_1_800_337_4194_to_verify_ownership_of_800_number$_RNSC_will_provide_the_repair_number$(){
		 String checkpoint = "AM_Repair_rep_to_call_RNSC_1_800_337_4194_to_verify_ownership_of_800_number$_RNSC_will_provide_the_repair_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Repair_Rep_to_call_RNSC(){
		 String checkpoint = "AM_Repair_Rep_to_call_RNSC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Repair_does_not_handle_these_requests$(){
		 String checkpoint = "AM_Repair_does_not_handle_these_requests$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_REP_Special_remarks_from_OSSLR$OSSCN_found$_ADD_CKT_NOTES_FOR_TAFI_TESTING$(){
		 String checkpoint = "AM_REP_Special_remarks_from_OSSLR$OSSCN_found$_ADD_CKT_NOTES_FOR_TAFI_TESTING$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Remove_the_feature_via_QVF$(){
		 String checkpoint = "AM_Remove_the_feature_via_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Remove_the_feature_via_QVF(){
		 String checkpoint = "AM_Remove_the_feature_via_QVF";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_have_D$T_box(){
		 String checkpoint = "AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_have_D$T_box";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_hav_bak(){
		 String checkpoint = "AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_hav_bak";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_hav(){
		 String checkpoint = "AM_REGULATORY_Spanish_Ctr$_Quote_MTSS_$4$_ATT_will_hav";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_REGULATORY__In_the_unlikely_event_that_ATT_is_unable_to(){
		 String checkpoint = "AM_REGULATORY__In_the_unlikely_event_that_ATT_is_unable_to";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refuse_TMQ_quote_not_applicable$_Continue_with_report$(){
		 String checkpoint = "AM_Refuse_TMQ_quote_not_applicable$_Continue_with_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Referral_number_for_CPE_Repair_Contracts$1_888_477_6477(){
		 String checkpoint = "AM_Referral_number_for_CPE_Repair_Contracts$1_888_477_6477";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Referral_number_for_CPE_Repair_Contracts$1_877_593_2999(){
		 String checkpoint = "AM_Referral_number_for_CPE_Repair_Contracts$1_877_593_2999";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Referral_number_for_ATT_CPE$1_888_477_6477(){
		 String checkpoint = "AM_Referral_number_for_ATT_CPE$1_888_477_6477";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form_MISC(){
		 String checkpoint = "AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form_MISC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form_CTX_CBC(){
		 String checkpoint = "AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form_CTX_CBC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$_Advise_customer_that_trouble_should_be_cleared_by_noon_the_next_business_day$(){
		 String checkpoint = "AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$_Advise_customer_that_trouble_should_be_cleared_by_noon_the_next_business_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$_Advis(){
		 String checkpoint = "AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$_Advis";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$(){
		 String checkpoint = "AM_Refer_trouble_to_DBAC_ONLINE_FORM_via_online_form$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_the_Handbook_for_vendor_referral_information_if_the_customer_purchased_equipment_from_SNET(){
		 String checkpoint = "AM_Refer_to_the_Handbook_for_vendor_referral_information_if_the_customer_purchased_equipment_from_SNET";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_NCSC_Handbook_for_more_information$(){
		 String checkpoint = "AM_Refer_to_NCSC_Handbook_for_more_information$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Live_Trace_Help_File$_Further_Isolate$(){
		 String checkpoint = "AM_Refer_to_Live_Trace_Help_File$_Further_Isolate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Business_Office$(){
		 String checkpoint = "AM_Refer_to_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Business_Office_at_Res$$$$_or_Bus$(){
		 String checkpoint = "AM_Refer_to_Business_Office_at_Res$$$$_or_Bus$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Business_Office_at_NONE(){
		 String checkpoint = "AM_Refer_to_Business_Office_at_NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Business_Office_at_877_999_0788(){
		 String checkpoint = "AM_Refer_to_Business_Office_at_877_999_0788";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Business_Office_at_800_499_7928(){
		 String checkpoint = "AM_Refer_to_Business_Office_at_800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Annoyance_Call_Bureau_at_888_771_2135(){
		 String checkpoint = "AM_Refer_to_Annoyance_Call_Bureau_at_888_771_2135";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Annoyance_Call_Bureau_at_800_769_4099(){
		 String checkpoint = "AM_Refer_to_Annoyance_Call_Bureau_at_800_769_4099";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Annoyance_Call_Bureau_at_800_348_8727(){
		 String checkpoint = "AM_Refer_to_Annoyance_Call_Bureau_at_800_348_8727";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_to_Annoyance_Call_Bureau_at_800_281_6920(){
		 String checkpoint = "AM_Refer_to_Annoyance_Call_Bureau_at_800_281_6920";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_customer_to_the_Business_office_to_have_the_Ring_Pattern_changed_to_another_Ring_Pattern$(){
		 String checkpoint = "AM_Refer_the_customer_to_the_Business_office_to_have_the_Ring_Pattern_changed_to_another_Ring_Pattern$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Carrier_to_the_Interexchange_Carrier_Group_at_1_860_725_5520$(){
		 String checkpoint = "AM_Refer_the_Carrier_to_the_Interexchange_Carrier_Group_at_1_860_725_5520$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_carrier_to_the_Interexchange_Carrier_Group_at_1_800_982_7144$(){
		 String checkpoint = "AM_Refer_the_carrier_to_the_Interexchange_Carrier_Group_at_1_800_982_7144$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_NONE(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_888_990_0124(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_888_990_0124";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_800_924_1743(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_800_924_1743";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_800_634_4948(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_800_634_4948";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_800_616_1172(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_800_616_1172";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Collections_Department_at_800_300_5099(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Collections_Department_at_800_300_5099";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at$t_TelNum(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at$t_TelNum";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at_NONE(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at_NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at_800_499_7928(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at_800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at_800_448_1008(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at_800_448_1008";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at_800_424_5112(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at_800_424_5112";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_the_Caller_to_the_Business_Office_at_800_288_2020(){
		 String checkpoint = "AM_Refer_the_Caller_to_the_Business_Office_at_800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_their_long_distance_carrier$(){
		 String checkpoint = "AM_Refer_customer_to_their_long_distance_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_their_Local_Service_Provider(){
		 String checkpoint = "AM_Refer_customer_to_their_Local_Service_Provider";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_their_carrier$(){
		 String checkpoint = "AM_Refer_customer_to_their_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_following_hotline_number_for_their_region$$$1_800_635_7371(){
		 String checkpoint = "AM_Refer_customer_to_the_following_hotline_number_for_their_region$$$1_800_635_7371";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_following_hotline_number_for_their_region$$$1_800_332_1321(){
		 String checkpoint = "AM_Refer_customer_to_the_following_hotline_number_for_their_region$$$1_800_332_1321";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_Custom_Work_Order_Center_at_1_888_901_2779$(){
		 String checkpoint = "AM_Refer_customer_to_the_Custom_Work_Order_Center_at_1_888_901_2779$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_Claims_department_at_800_894_0374_Opt$_1(){
		 String checkpoint = "AM_Refer_customer_to_the_Claims_department_at_800_894_0374_Opt$_1";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_Business_Office$$$800_499_7928(){
		 String checkpoint = "AM_Refer_customer_to_the_Business_Office$$$800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_NONE(){
		 String checkpoint = "AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_800_773_5550$(){
		 String checkpoint = "AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_800_773_5550$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_800_769_4099$(){
		 String checkpoint = "AM_Refer_customer_to_the_ATT_Annoyance_Call_Bureau_at_800_769_4099$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$TX_EB$$$800_499_7928$$$800_448_1008(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$TX_EB$$$800_499_7928$$$800_448_1008";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$TX_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$TX_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$OH_II$$$800_924_3666$$$877_728_1200(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$OH_II$$$800_924_3666$$$877_728_1200";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$OH_CS$$$800_207_3081$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$OH_CS$$$800_207_3081$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$NV_CS$$$858_503_6452$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$NV_CS$$$858_503_6452$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$NC_CS$$$NONE$$$NONE(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$NC_CS$$$NONE$$$NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$MO_EB$$$800_499_7928$$$800_499_7928(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$MO_EB$$$800_499_7928$$$800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$MO_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$MO_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$MI_II$$$800_924_3666$$$877_728_1200(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$MI_II$$$800_924_3666$$$877_728_1200";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$MI_CS$$$800_206_4793$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$MI_CS$$$800_206_4793$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$IN_CS$$$800_206_4102$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$IN_CS$$$800_206_4102$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$CT_CS$$$860_422_6045$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$CT_CS$$$860_422_6045$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355$$$reporting$(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355$$$reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$$$CA_CS$$$800_288_2020$$$800_750_2355(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$$$CA_CS$$$800_288_2020$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_Business_Office$_Online_transfer_to_TX_CS_business_office_800_499_7928$$$$800_288_2020(){
		 String checkpoint = "AM_Refer_customer_to_Business_Office$_Online_transfer_to_TX_CS_business_office_800_499_7928$$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_customer_to_3rd_party_VM_provider$(){
		 String checkpoint = "AM_Refer_customer_to_3rd_party_VM_provider$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Refer_caller_to_their_Business_Office$(){
		 String checkpoint = "AM_Refer_caller_to_their_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Records_support_this_is_not_an_ATT_account$(){
		 String checkpoint = "AM_Records_support_this_is_not_an_ATT_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Records_support_this_is_an_ATT_account$(){
		 String checkpoint = "AM_Records_support_this_is_an_ATT_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Recent_History_within_past_30_days$(){
		 String checkpoint = "AM_Recent_History_within_past_30_days$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reason_for_No_Access$_NO_ONE_HOME___LEFT_NAS_TAG_ON_GATE_BECAUSE_MEAN_DOG_IN_YARD(){
		 String checkpoint = "AM_Reason_for_No_Access$_NO_ONE_HOME___LEFT_NAS_TAG_ON_GATE_BECAUSE_MEAN_DOG_IN_YARD";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reason_for_No_Access$_I_NAO_TKT_NEED_BUCKET_TRUCK_2_FINISH_JOB_LEFT_NA_TAG_FOR_CU$(){
		 String checkpoint = "AM_Reason_for_No_Access$_I_NAO_TKT_NEED_BUCKET_TRUCK_2_FINISH_JOB_LEFT_NA_TAG_FOR_CU$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reason_for_No_Access$_I_NAO_TKT_NEED_BUCKET_TRUCK_2_FINISH_JOB_LEFT_NA_TAG_FOR_CU(){
		 String checkpoint = "AM_Reason_for_No_Access$_I_NAO_TKT_NEED_BUCKET_TRUCK_2_FINISH_JOB_LEFT_NA_TAG_FOR_CU";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reason_for_No_Access$_$Details_of_No_Access$_not_returned_from_SDC_Log$Can_the_No_Access_condition_be_cleared_by_the_customer$(){
		 String checkpoint = "AM_Reason_for_No_Access$_$Details_of_No_Access$_not_returned_from_SDC_Log$Can_the_No_Access_condition_be_cleared_by_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Reason_for_No_Access$_$Details_of_No_Access$_not_returned_from_SDC_Log$(){
		 String checkpoint = "AM_Reason_for_No_Access$_$Details_of_No_Access$_not_returned_from_SDC_Log$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_Not_Available$(){
		 String checkpoint = "AM_QVF_Not_Available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_is_unable_to_process_request_at_this_time$$$can_be_performed$(){
		 String checkpoint = "AM_QVF_is_unable_to_process_request_at_this_time$$$can_be_performed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_is_unable_to_process_request_at_this_time$_Advise_customer_that_a_specialist_will_contact_them$(){
		 String checkpoint = "AM_QVF_is_unable_to_process_request_at_this_time$_Advise_customer_that_a_specialist_will_contact_them$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_Failed$(){
		 String checkpoint = "AM_QVF_Failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_Failed(){
		 String checkpoint = "AM_QVF_Failed";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_QVF_Caller_ID_Name_lookup_failed$(){
		 String checkpoint = "AM_QVF_Caller_ID_Name_lookup_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Queue_report_until_ready_to_call_customer_back$(){
		 String checkpoint = "AM_Queue_report_until_ready_to_call_customer_back$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Queue_report_and_perform_callback$(){
		 String checkpoint = "AM_Queue_report_and_perform_callback$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Provide_$_1_800_956_7000$_$On_line_transfer$$(){
		 String checkpoint = "AM_Provide_$_1_800_956_7000$_$On_line_transfer$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Privacy_manager_is_no_longer_available$$$Business_Office_about_other_features$(){
		 String checkpoint = "AM_Privacy_manager_is_no_longer_available$$$Business_Office_about_other_features$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB$(){
		 String checkpoint = "AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB____1_800_332_1321$(){
		 String checkpoint = "AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB____1_800_332_1321$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB____1_800_303_0103$(){
		 String checkpoint = "AM_Priority_Business_Referral$_On_line_transfer_to_the_CAB____1_800_303_0103$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Prior_to_resetting_the_password(){
		 String checkpoint = "AM_Prior_to_resetting_the_password";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Preventative_Line_Insulation_Test_is_programmed$(){
		 String checkpoint = "AM_Preventative_Line_Insulation_Test_is_programmed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Preventative_Line_Insulation_Test_is_not_programmed$(){
		 String checkpoint = "AM_Preventative_Line_Insulation_Test_is_not_programmed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Prepaid_Home_Service___PHS_DO_NOT_upsell$(){
		 String checkpoint = "AM_Prepaid_Home_Service___PHS_DO_NOT_upsell$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Populate_commitment_refer_to_help_file_for_commitment_offerings$(){
		 String checkpoint = "AM_Populate_commitment_refer_to_help_file_for_commitment_offerings$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Please_use_the_BACKDOWN_checkbox_to_process(){
		 String checkpoint = "AM_Please_use_the_BACKDOWN_checkbox_to_process";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Please_populate_the_MPC$Action_code_on_the_recommendation_screen_that_pertains_to_this_trouble$(){
		 String checkpoint = "AM_Please_populate_the_MPC$Action_code_on_the_recommendation_screen_that_pertains_to_this_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Please_call_NDC_on_cancellations_at$_800_649_9598(){
		 String checkpoint = "AM_Please_call_NDC_on_cancellations_at$_800_649_9598";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach_CCO(){
		 String checkpoint = "AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach_CCO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach$_Was_the_call_completed$(){
		 String checkpoint = "AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach$_Was_the_call_completed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach$(){
		 String checkpoint = "AM_Place_customer_on_hold_and_call_the_number_the_customer_is_trying_to_reach$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC$LPIC_is_correct_in_the_switch$_Call_1_700_555_4141_from_the_number_in_question_to_hear_your_designated_carrier$(){
		 String checkpoint = "AM_PIC$LPIC_is_correct_in_the_switch$_Call_1_700_555_4141_from_the_number_in_question_to_hear_your_designated_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC$LPIC_Failed$_Sending_to_RCMAC$(){
		 String checkpoint = "AM_PIC$LPIC_Failed$_Sending_to_RCMAC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC_incorrect$_QVF_failed$(){
		 String checkpoint = "AM_PIC_incorrect$_QVF_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC_incorrect_in_Switch$_QVF_Fix_successful$(){
		 String checkpoint = "AM_PIC_incorrect_in_Switch$_QVF_Fix_successful$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC_has_been_corrected$(){
		 String checkpoint = "AM_PIC_has_been_corrected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC_$_LPIC_incorrect$_QVF_failed$(){
		 String checkpoint = "AM_PIC_$_LPIC_incorrect$_QVF_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PIC_$_LPIC_incorrect_in_Switch$_QVF_Fix_successful$(){
		 String checkpoint = "AM_PIC_$_LPIC_incorrect_in_Switch$_QVF_Fix_successful$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Perform_test_call_to_number_to_ensure_the_feature_is_programmed$_Did_test_call_work$(){
		 String checkpoint = "AM_Perform_test_call_to_number_to_ensure_the_feature_is_programmed$_Did_test_call_work$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Perform_a_test_call_to_see_if_the_Star_Ring_calls_transfer$_Did_call_transfer$(){
		 String checkpoint = "AM_Perform_a_test_call_to_see_if_the_Star_Ring_calls_transfer$_Did_call_transfer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Perform_a_test_call_to_see_if_the_Ringmaster_calls_transfer$Did_call_transfer$(){
		 String checkpoint = "AM_Perform_a_test_call_to_see_if_the_Ringmaster_calls_transfer$Did_call_transfer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Perform_a_test_call_to_see_if_the_Personalized_Ring_calls_transfer$_Did_call_transfer$(){
		 String checkpoint = "AM_Perform_a_test_call_to_see_if_the_Personalized_Ring_calls_transfer$_Did_call_transfer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Perform_a_test_call_to_see_if_the_Multi_Ring_calls_transfer$_Did_call_transfer$(){
		 String checkpoint = "AM_Perform_a_test_call_to_see_if_the_Multi_Ring_calls_transfer$_Did_call_transfer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Pending_regulatory_approvals_we_expect_that_wireline_and_U_verse_services(){
		 String checkpoint = "AM_Pending_regulatory_approvals_we_expect_that_wireline_and_U_verse_services";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_PCL___DO_NOT_SOLICIT_SALE(){
		 String checkpoint = "AM_PCL___DO_NOT_SOLICIT_SALE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Password_was_reset_to_the_mailbox_number$(){
		 String checkpoint = "AM_Password_was_reset_to_the_mailbox_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Overtype_the_correct_City_name_in_the_City_Field_if_incorrect(){
		 String checkpoint = "AM_Overtype_the_correct_City_name_in_the_City_Field_if_incorrect";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there$$$15_minutes$(){
		 String checkpoint = "AM_Our_test_indicates_there$$$15_minutes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there$$$$RES_or_Bus$$(){
		 String checkpoint = "AM_Our_test_indicates_there$$$$RES_or_Bus$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there_may_be_trouble_on$$the_only_work_performed$(){
		 String checkpoint = "AM_Our_test_indicates_there_may_be_trouble_on$$the_only_work_performed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there_may_be_trouble_on$$$wire_run_and_$45(){
		 String checkpoint = "AM_Our_test_indicates_there_may_be_trouble_on$$$wire_run_and_$45";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there_may_be_trouble_on$$$Residence_$38_Business_$55(){
		 String checkpoint = "AM_Our_test_indicates_there_may_be_trouble_on$$$Residence_$38_Business_$55";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there_may_be_trouble_on$$$Business_$50(){
		 String checkpoint = "AM_Our_test_indicates_there_may_be_trouble_on$$$Business_$50";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_test_indicates_there_may_be_trouble_on$$$_there_is_a_charge_of_$30(){
		 String checkpoint = "AM_Our_test_indicates_there_may_be_trouble_on$$$_there_is_a_charge_of_$30";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_records_show_this_is_not_an_ATT_area$$$rovided_npanxx_in_Report_field_after_prepopulated_narrative_then_click_Submit$(){
		 String checkpoint = "AM_Our_records_show_this_is_not_an_ATT_area$$$rovided_npanxx_in_Report_field_after_prepopulated_narrative_then_click_Submit$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Our_initial_test_indicate_access_is_required(){
		 String checkpoint = "AM_Our_initial_test_indicate_access_is_required";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ORDER_information_not_available$(){
		 String checkpoint = "AM_ORDER_information_not_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ord_is_PAC$_Call_the_NDC_to_have_order_completed_NONE(){
		 String checkpoint = "AM_Ord_is_PAC$_Call_the_NDC_to_have_order_completed_NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ord_is_PAC$(){
		 String checkpoint = "AM_Ord_is_PAC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ord_is_PAC_not_testing_OPEN_IN$(){
		 String checkpoint = "AM_Ord_is_PAC_not_testing_OPEN_IN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ord_is_PAC_and_tests_OPEN_IN$(){
		 String checkpoint = "AM_Ord_is_PAC_and_tests_OPEN_IN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ord_is_Due_Today_PAC_and_tests_OPEN_IN$$$using_the_tree_form_list$(){
		 String checkpoint = "AM_Ord_is_Due_Today_PAC_and_tests_OPEN_IN$$$using_the_tree_form_list$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_WI_CS$$$888_727_8368$$$888_727_8368(){
		 String checkpoint = "AM_Online_transfer_to_WI_CS$$$888_727_8368$$$888_727_8368";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_WI_CS$$$800_207_5098$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_WI_CS$$$800_207_5098$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_WI_CS_business_office_800_207_5098$(){
		 String checkpoint = "AM_Online_transfer_to_WI_CS_business_office_800_207_5098$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_WI_CS_at_800_207_5098$_Educate_the_customer_at_800_288_2020_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_WI_CS_at_800_207_5098$_Educate_the_customer_at_800_288_2020_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_TX_EB$$$800_499_7928$$$800_448_1008(){
		 String checkpoint = "AM_Online_transfer_to_TX_EB$$$800_499_7928$$$800_448_1008";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_TX_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_TX_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_TN_CS_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_TN_CS_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_SC_CS_business_office_NONE$$$NONE$$$P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_SC_CS_business_office_NONE$$$NONE$$$P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_SB$$$888_618_4784$$$800_660_3000(){
		 String checkpoint = "AM_Online_transfer_to_OH_SB$$$888_618_4784$$$800_660_3000";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_SB_ISDN_Office_at_888_727_8368$$$888_727_8368(){
		 String checkpoint = "AM_Online_transfer_to_OH_SB_ISDN_Office_at_888_727_8368$$$888_727_8368";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_EB$$$800_480_8088$$$$800_480_8088(){
		 String checkpoint = "AM_Online_transfer_to_OH_EB$$$800_480_8088$$$$800_480_8088";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_CS$$$800_207_3081$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_OH_CS$$$800_207_3081$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_CS_ISND$$$888_727_8368$$$888_727_8368(){
		 String checkpoint = "AM_Online_transfer_to_OH_CS_ISND$$$888_727_8368$$$888_727_8368";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_OH_CS_ISDN_Office_at_888_727_8368$$$888_727_8368(){
		 String checkpoint = "AM_Online_transfer_to_OH_CS_ISDN_Office_at_888_727_8368$$$888_727_8368";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_NV_EB$$$858_573_8550$$$877_469_2355(){
		 String checkpoint = "AM_Online_transfer_to_NV_EB$$$858_573_8550$$$877_469_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_NV_CS$$$858_503_6452$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_NV_CS$$$858_503_6452$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_NF_EB_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_NF_EB_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_NC_EB$$$NONE$$$NONE(){
		 String checkpoint = "AM_Online_transfer_to_NC_EB$$$NONE$$$NONE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MS_EB_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_MS_EB_business_office_NONE$$$NONE$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MS_EB_business_office_877_999_0788$$$800_288_2020$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_MS_EB_business_office_877_999_0788$$$800_288_2020$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MO_EB$$$800_499_7928$$$800_499_7928(){
		 String checkpoint = "AM_Online_transfer_to_MO_EB$$$800_499_7928$$$800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MO_CS$$$888_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_MO_CS$$$888_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MO_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_MO_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MI_SB$$$888_618_4784$$$800_660_3000(){
		 String checkpoint = "AM_Online_transfer_to_MI_SB$$$888_618_4784$$$800_660_3000";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MI_II$$$800_924_3666$$$877_728_1200(){
		 String checkpoint = "AM_Online_transfer_to_MI_II$$$800_924_3666$$$877_728_1200";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MI_EB$$$800_480_8088$$$800_480_8088(){
		 String checkpoint = "AM_Online_transfer_to_MI_EB$$$800_480_8088$$$800_480_8088";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_MI_CS$$$800_206_4793$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_MI_CS$$$800_206_4793$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_KY_CS$$$888_618_4784$$$800_660_3000(){
		 String checkpoint = "AM_Online_transfer_to_KY_CS$$$888_618_4784$$$800_660_3000";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_KS_CS$$$800_499_7928$$$800_288_2020$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_KS_CS$$$800_499_7928$$$800_288_2020$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_IN_II_at_800_924_3666$_Educate_the_customer_at_877_728_1200_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_IN_II_at_800_924_3666$_Educate_the_customer_at_877_728_1200_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_IN_EB$$$800_480_8088$$$800_480_8088(){
		 String checkpoint = "AM_Online_transfer_to_IN_EB$$$800_480_8088$$$800_480_8088";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_IN_EB_at_800_480_8088$_Educate_the_customer_at_800_480_8088_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_IN_EB_at_800_480_8088$_Educate_the_customer_at_800_480_8088_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_IN_CS$$$877_999_0788$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_IN_CS$$$877_999_0788$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_IN_CS_at_800_206_4102$_Educate_the_customer_at_800_288_2020_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_IN_CS_at_800_206_4102$_Educate_the_customer_at_800_288_2020_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_GA_EB_business_office_NONE$$$$NONE_for_future_reporting$_Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_GA_EB_business_office_NONE$$$$NONE_for_future_reporting$_Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CT_EB$$$800_424_5112$$$800_424_5112(){
		 String checkpoint = "AM_Online_transfer_to_CT_EB$$$800_424_5112$$$800_424_5112";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CT_CS$$$860_422_6045$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_CT_CS$$$860_422_6045$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_EB$$$800_750_2355$$$800_750_2355(){
		 String checkpoint = "AM_Online_transfer_to_CA_EB$$$800_750_2355$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_EB_business_office_800_750_2355$$$Make_a_P2R_referral_if_appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_CA_EB_business_office_800_750_2355$$$Make_a_P2R_referral_if_appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_EB_at_800_750_2355$_Educate_the_customer_at_800_750_2355_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_CA_EB_at_800_750_2355$_Educate_the_customer_at_800_750_2355_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355$$$appropriate$(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355$$$appropriate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS$$$866_346_1168$$$800_750_2355$$$800_288_2020$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS$$$800_310_2355$$$800_750_2355$$$800_288_2020$$$800_750_2355(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS$$$800_310_2355$$$800_750_2355$$$800_288_2020$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS$$$800_288_2020$$$800_750_2355$$$866_346_1168$$$800_750_2355(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS$$$800_288_2020$$$800_750_2355$$$866_346_1168$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS_business_office_Res(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS_business_office_Res";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_CA_CS_at_800_750_2355$_Educate_the_customer_at_866_346_1168_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_CA_CS_at_800_750_2355$_Educate_the_customer_at_866_346_1168_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_AR_EB_at_800_499_7928$_Educate_the_customer_at_800_499_7928_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_AR_EB_at_800_499_7928$_Educate_the_customer_at_800_499_7928_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_AR_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Online_transfer_to_AR_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Online_transfer_to_AR_CS_at_800_499_7928$_Educate_the_customer_at_800_288_2020_for_future_reporting$(){
		 String checkpoint = "AM_Online_transfer_to_AR_CS_at_800_499_7928$_Educate_the_customer_at_800_288_2020_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_On_line_transfer_to_CB_at_800_790_2972$_Educate_the_customer_with_800_790_2972_for_future_reporting$(){
		 String checkpoint = "AM_On_line_transfer_to_CB_at_800_790_2972$_Educate_the_customer_with_800_790_2972_for_future_reporting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_On_line_transfer_or_refer$$$800_300_3788$$$M_F_8am_6pm(){
		 String checkpoint = "AM_On_line_transfer_or_refer$$$800_300_3788$$$M_F_8am_6pm";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_On_line_transfer_or_refer$$$800_288_2020$$$M_F_8am_6pm(){
		 String checkpoint = "AM_On_line_transfer_or_refer$$$800_288_2020$$$M_F_8am_6pm";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_OK(){
		 String checkpoint = "AM_OK";
		 return getValueFromExcel(checkpoint);
		}
		
		public static String Submit_TankYou_OK_For_Queue(){
			 String checkpoint = "Submit_TankYou_OK_For_Queue";
			 return getValueFromExcel(checkpoint);
			}
		
		public static String AM_Ntelagent_will_close_report$(){
		 String checkpoint = "AM_Ntelagent_will_close_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ntelagent_shall_close_report$(){
		 String checkpoint = "AM_Ntelagent_shall_close_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ntelagent_has_located_a_Billing_record$$$Click_BILLING_RECORD_to_review_this_information(){
		 String checkpoint = "AM_Ntelagent_has_located_a_Billing_record$$$Click_BILLING_RECORD_to_review_this_information";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Notify_the_Intercept_Department$(){
		 String checkpoint = "AM_Notify_the_Intercept_Department$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Note_to_RR$_It_is_not_necessary_to_quote_charges_to_this_customer$$$charge_of_$37(){
		 String checkpoint = "AM_Note_to_RR$_It_is_not_necessary_to_quote_charges_to_this_customer$$$charge_of_$37";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Not_an_ATT_Account$_Refer_customer_to_their_Local_Provider$_Does_the_customer_agree_$(){
		 String checkpoint = "AM_Not_an_ATT_Account$_Refer_customer_to_their_Local_Provider$_Does_the_customer_agree_$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Not_an_ATT_Account$_Refer_customer_to_their_Local_Provider(){
		 String checkpoint = "AM_Not_an_ATT_Account$_Refer_customer_to_their_Local_Provider";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_2(){
		 String checkpoint = "AM_No_2";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_trouble_was_detected$(){
		 String checkpoint = "AM_No_trouble_was_detected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_trouble_was_detected_calls_are_not_transferring$(){
		 String checkpoint = "AM_No_trouble_was_detected_calls_are_not_transferring$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_PIC$LPIC_on_found_on_account__unable_to_complete_2PD_request$(){
		 String checkpoint = "AM_No_PIC$LPIC_on_found_on_account__unable_to_complete_2PD_request$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_pending_buried_drop_wire_work_orders_were_found$_Advise_the_customer_that_a_representative_from_the_Buried_Wire_Center_will_contact_them_within_2_business_days_by_5pm_$local_time$$(){
		 String checkpoint = "AM_No_pending_buried_drop_wire_work_orders_were_found$_Advise_the_customer_that_a_representative_from_the_Buried_Wire_Center_will_contact_them_within_2_business_days_by_5pm_$local_time$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No_pending_buried_drop_wire_work_orders_were_found$(){
		 String checkpoint = "AM_No_pending_buried_drop_wire_work_orders_were_found$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_No(){
		 String checkpoint = "AM_No";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Negotiate_call_back_with_customer$(){
		 String checkpoint = "AM_Negotiate_call_back_with_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Needs_further_analysis$(){
		 String checkpoint = "AM_Needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_My_test_call_indicates_there_is_trouble_on_the_number_you_are_calling$(){
		 String checkpoint = "AM_My_test_call_indicates_there_is_trouble_on_the_number_you_are_calling$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_MW_Residence_customer_(){
		 String checkpoint = "AM_MW_Residence_customer_";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_have_the_option_of$_SW(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_have_the_option_of$_SW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_W(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_W";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_SW(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_SW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_SE(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_SE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_RES$BUS(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_RES$BUS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_notbus_SW(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_notbus_SW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_MW(){
		 String checkpoint = "AM_Mr$Ms$Mrs_$last_name$_you_do_have_the_option_of_MW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_test_call_to_customer$s_number$_Did_call_transfer_with_the_correct_number_of_rings$(){
		 String checkpoint = "AM_Make_test_call_to_customer$s_number$_Did_call_transfer_with_the_correct_number_of_rings$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_test_call_to_customer$s_number$(){
		 String checkpoint = "AM_Make_test_call_to_customer$s_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$TX$$$800_499_7928$$$800_448_1008(){
		 String checkpoint = "AM_Make_an_ERIC$$$TX$$$800_499_7928$$$800_448_1008";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$TX$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$TX$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$OH$$$800_480_8088$$$$800_480_8088(){
		 String checkpoint = "AM_Make_an_ERIC$$$OH$$$800_480_8088$$$$800_480_8088";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$OH$$$800_207_3081$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$OH$$$800_207_3081$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$OH_SB$$$888_618_4784$$$800_660_3000(){
		 String checkpoint = "AM_Make_an_ERIC$$$OH_SB$$$888_618_4784$$$800_660_3000";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MO$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$MO$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MO_EB$$$800_499_7928$$$800_499_7928(){
		 String checkpoint = "AM_Make_an_ERIC$$$MO_EB$$$800_499_7928$$$800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MO_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$MO_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MI$$$888_618_4784$$$800_660_3000(){
		 String checkpoint = "AM_Make_an_ERIC$$$MI$$$888_618_4784$$$800_660_3000";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MI$$$800_924_3666$$$877_728_1200(){
		 String checkpoint = "AM_Make_an_ERIC$$$MI$$$800_924_3666$$$877_728_1200";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MI$$$800_206_4793$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$MI$$$800_206_4793$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$MI_EB$$$800_480_8088$$$800_480_8088(){
		 String checkpoint = "AM_Make_an_ERIC$$$MI_EB$$$800_480_8088$$$800_480_8088";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$CT$$$860_422_6045$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC$$$CT$$$860_422_6045$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$CT$$$800_424_5112$$$800_424_5112(){
		 String checkpoint = "AM_Make_an_ERIC$$$CT$$$800_424_5112$$$800_424_5112";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$CA$$$800_750_2355$$$800_750_2355(){
		 String checkpoint = "AM_Make_an_ERIC$$$CA$$$800_750_2355$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC$$$CA$$$800_288_2020$$$800_750_2355$$$866_346_1168$$$800_750_2355(){
		 String checkpoint = "AM_Make_an_ERIC$$$CA$$$800_288_2020$$$800_750_2355$$$866_346_1168$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate_TX_SW(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate_TX_SW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate_OH(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate_MI_MW(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate_MI_MW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate_CN_W(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate_CN_W";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate$$$AR_CS$$$800_499_7928$$$800_288_2020(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate$$$AR_CS$$$800_499_7928$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_an_ERIC_Referral_when_appropriate_otherwise_online(){
		 String checkpoint = "AM_Make_an_ERIC_Referral_when_appropriate_otherwise_online";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_Star_Ring$_Was_the_customer_able_to_answer$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_Star_Ring$_Was_the_customer_able_to_answer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_Ringmaster$_Was_the_customer_able_to_answer$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_Ringmaster$_Was_the_customer_able_to_answer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_Personalized_Ring$_Was_the_customer_able_to_answer$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_Personalized_Ring$_Was_the_customer_able_to_answer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_number$_Did_the_operator_escape_option_transfer_to_the_correct_number$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_number$_Did_the_operator_escape_option_transfer_to_the_correct_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_number$_Did_pager_notification_work$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_number$_Did_pager_notification_work$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_Multi_Ring$_Was_the_customer_able_to_answer$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_Multi_Ring$_Was_the_customer_able_to_answer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_customer$s_number$_Did_Voice_Mail_answer$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_customer$s_number$_Did_Voice_Mail_answer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_the_customer$s_number$(){
		 String checkpoint = "AM_Make_a_test_call_to_the_customer$s_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_to_both_RCF_and_CFN(){
		 String checkpoint = "AM_Make_a_test_call_to_both_RCF_and_CFN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Make_a_test_call_by_dialing_$67_then_the_customer$s_numbers_to_confirm_the_trouble$(){
		 String checkpoint = "AM_Make_a_test_call_by_dialing_$67_then_the_customer$s_numbers_to_confirm_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LVM_Unified_Message_Redirect_Message_MW_SNET(){
		 String checkpoint = "AM_LVM_Unified_Message_Redirect_Message_MW_SNET";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LPIC_not_ATT$_Refer_customer_to_their_carrier$(){
		 String checkpoint = "AM_LPIC_not_ATT$_Refer_customer_to_their_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LPIC_is_ATT$_Trouble_needs_further_analysis$(){
		 String checkpoint = "AM_LPIC_is_ATT$_Trouble_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LPIC_incorrect$_QVF_failed$(){
		 String checkpoint = "AM_LPIC_incorrect$_QVF_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LPIC_incorrect_in_Switch$_QVF_Fix_successful$(){
		 String checkpoint = "AM_LPIC_incorrect_in_Switch$_QVF_Fix_successful$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LPIC_has_been_corrected$(){
		 String checkpoint = "AM_LPIC_has_been_corrected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_List_in_narr_name_of_person_declining_TMQ$(){
		 String checkpoint = "AM_List_in_narr_name_of_person_declining_TMQ$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_successfully_made_un_busy$(){
		 String checkpoint = "AM_Line_successfully_made_un_busy$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_successfully_busied_out$(){
		 String checkpoint = "AM_Line_successfully_busied_out$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_not_involved_in_CABFAIL$_Preventative_Maintenance_activity_in_area(){
		 String checkpoint = "AM_Line_not_involved_in_CABFAIL$_Preventative_Maintenance_activity_in_area";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_not_involved_in_CABFAIL$_Preventative(){
		 String checkpoint = "AM_Line_not_involved_in_CABFAIL$_Preventative";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_not_involved_in_CABFAIL$(){
		 String checkpoint = "AM_Line_not_involved_in_CABFAIL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_could_not_be_made_un_busy$_Sending_to_screening$(){
		 String checkpoint = "AM_Line_could_not_be_made_un_busy$_Sending_to_screening$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Line_could_not_be_busied_out$_Sending_to_screening$(){
		 String checkpoint = "AM_Line_could_not_be_busied_out$_Sending_to_screening$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_LD_Carrier_subscribes_to_LDTMS$(){
		 String checkpoint = "AM_LD_Carrier_subscribes_to_LDTMS$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Kick_off_QVF$(){
		 String checkpoint = "AM_Kick_off_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_VM_stuck_on_first_message$(){
		 String checkpoint = "AM_Is_VM_stuck_on_first_message$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_this_3rd_party_Voice_Mail$(){
		 String checkpoint = "AM_Is_this_3rd_party_Voice_Mail$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_there_access_to_the_customer$s_NID$terminal$(){
		 String checkpoint = "AM_Is_there_access_to_the_customer$s_NID$terminal$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_requesting_to_cancel_this_trouble_report$(){
		 String checkpoint = "AM_Is_the_customer_requesting_to_cancel_this_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_reporting_that_they_get_a_Recording_on_Line_when_number_is_dialed$(){
		 String checkpoint = "AM_Is_the_customer_reporting_that_they_get_a_Recording_on_Line_when_number_is_dialed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_reporting_that_the_service_is_still_working$(){
		 String checkpoint = "AM_Is_the_customer_reporting_that_the_service_is_still_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_indicating_the_service_is_still_working$(){
		 String checkpoint = "AM_Is_the_customer_indicating_the_service_is_still_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_indicating_service_is_still_working$(){
		 String checkpoint = "AM_Is_the_customer_indicating_service_is_still_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_dialing_the_correct_International_Country_Code$(){
		 String checkpoint = "AM_Is_the_customer_dialing_the_correct_International_Country_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_customer_able_to_use_a_different_Dial_Around_code_to_complete_the_call$(){
		 String checkpoint = "AM_Is_the_customer_able_to_use_a_different_Dial_Around_code_to_complete_the_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_Billing_Record_different_from_what_the_customer_says_it_should_be$(){
		 String checkpoint = "AM_Is_the_Billing_Record_different_from_what_the_customer_says_it_should_be$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_Billing_Record_different_from_what_the_customer_says_it(){
		 String checkpoint = "AM_Is_the_Billing_Record_different_from_what_the_customer_says_it";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_the_address_mis_match_caused_by_a_Service_Order$(){
		 String checkpoint = "AM_Is_the_address_mis_match_caused_by_a_Service_Order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_feature_in_switch_translations$(){
		 String checkpoint = "AM_Is_feature_in_switch_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer$s_recent_History_related_to_the_trouble_being_reported_now(){
		 String checkpoint = "AM_Is_customer$s_recent_History_related_to_the_trouble_being_reported_now";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_using_dial_around_code$(){
		 String checkpoint = "AM_Is_customer_using_dial_around_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_satisfied_with_feature$(){
		 String checkpoint = "AM_Is_customer_satisfied_with_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_reporting_that_the_service_is_still_working$(){
		 String checkpoint = "AM_Is_customer_reporting_that_the_service_is_still_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_reporting_that_the_feature_is_working_in_error$(){
		 String checkpoint = "AM_Is_customer_reporting_that_the_feature_is_working_in_error$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_dialing_$98_from_the_line_that_Voice_Mail_is_programmed_on$(){
		 String checkpoint = "AM_Is_customer_dialing_$98_from_the_line_that_Voice_Mail_is_programmed_on$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Is_customer_calling_from_that_line$(){
		 String checkpoint = "AM_Is_customer_calling_from_that_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Instruct_customer_not_to_accept_delivery$_Check_DATH_for_Date_received$_Call_Telamon_1_800_788_2261(){
		 String checkpoint = "AM_Instruct_customer_not_to_accept_delivery$_Check_DATH_for_Date_received$_Call_Telamon_1_800_788_2261";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Input_npanxx_information$(){
		 String checkpoint = "AM_Input_npanxx_information$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Input_description_of_the_CPE_trouble(){
		 String checkpoint = "AM_Input_description_of_the_CPE_trouble";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Initial_data_indicates_ATT_Wireless$Ntelagent_will_now_check_other_systems$(){
		 String checkpoint = "AM_Initial_data_indicates_ATT_Wireless$Ntelagent_will_now_check_other_systems$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Initial_data_indicates_ATT_WHP$Ntelagent_will_now_check_other_systems$(){
		 String checkpoint = "AM_Initial_data_indicates_ATT_WHP$Ntelagent_will_now_check_other_systems$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_they_must_be_available_at_their_premises_for_the_delivery_of_the_loaner_telephone$(){
		 String checkpoint = "AM_Inform_the_customer_they_must_be_available_at_their_premises_for_the_delivery_of_the_loaner_telephone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_the_report_will_be_entered_on_the_CFN(){
		 String checkpoint = "AM_Inform_the_customer_the_report_will_be_entered_on_the_CFN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_the_account_has_STAR_RING(){
		 String checkpoint = "AM_Inform_the_customer_the_account_has_STAR_RING";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_the_account_has_RINGMASTER(){
		 String checkpoint = "AM_Inform_the_customer_the_account_has_RINGMASTER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_the_account_has_PERSONALIZED_RING(){
		 String checkpoint = "AM_Inform_the_customer_the_account_has_PERSONALIZED_RING";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_the_account_has_MULTI_RING(){
		 String checkpoint = "AM_Inform_the_customer_the_account_has_MULTI_RING";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_this_report_will_be_referred_to_their_long_distance_carrier$(){
		 String checkpoint = "AM_Inform_the_customer_that_this_report_will_be_referred_to_their_long_distance_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_trouble_will_be_cleared_by(){
		 String checkpoint = "AM_Inform_the_customer_that_the_trouble_will_be_cleared_by";
		 return getValueFromExcel(checkpoint);
		}
		
		public static String AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$(){
			 String checkpoint = "AM_Inform_the_customer_that_the_trouble_will_be_cleared_by_$Rex$";
			 return getValueFromExcel(checkpoint);
			}

		public static String AM_Inform_the_customer_that_the_report_will_be$$$a_dispatch_is_required$(){
		 String checkpoint = "AM_Inform_the_customer_that_the_report_will_be$$$a_dispatch_is_required$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$(){
		 String checkpoint = "AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_report_will_be_held_for_24_hours(){
		 String checkpoint = "AM_Inform_the_customer_that_the_report_will_be_held_for_24_hours";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_report_will_be(){
		 String checkpoint = "AM_Inform_the_customer_that_the_report_will_be";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_report(){
		 String checkpoint = "AM_Inform_the_customer_that_the_report";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_the_CFG_will_call_the_customer_back_by_the_next_Business_Day_by_5pm$(){
		 String checkpoint = "AM_Inform_the_customer_that_the_CFG_will_call_the_customer_back_by_the_next_Business_Day_by_5pm$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_that_in_order_for_$98_to_work_properly_they_must_dial_$82_then_$98$(){
		 String checkpoint = "AM_Inform_the_customer_that_in_order_for_$98_to_work_properly_they_must_dial_$82_then_$98$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_customer_of_the_VMS_outage$(){
		 String checkpoint = "AM_Inform_the_customer_of_the_VMS_outage$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_the_Business_Office_Rep_that_the_PIC$LPIC_was_corrected$(){
		 String checkpoint = "AM_Inform_the_Business_Office_Rep_that_the_PIC$LPIC_was_corrected$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_customer_the_wire_is_probably(){
		 String checkpoint = "AM_Inform_customer_the_wire_is_probably";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Inform_customer_that_test_call_worked$_Does_customer_want_a_different_ring_pattern$(){
		 String checkpoint = "AM_Inform_customer_that_test_call_worked$_Does_customer_want_a_different_ring_pattern$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Incident_Management_indicates_there_is_presently_an_issue_affecting_this_line$s_DSL_service$_Inform_the_customer_that_the_trouble_will_be_cleared_by08_09_19_0659A(){
		 String checkpoint = "AM_Incident_Management_indicates_there_is_presently_an_issue_affecting_this_line$s_DSL_service$_Inform_the_customer_that_the_trouble_will_be_cleared_by08_09_19_0659A";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Incident_Management_indicates_there_is_presently_an_issue_affecting_this_line$s_DSL_service$_Inform_the_customer_that_the_trouble_will_be_cleared_by(){
		 String checkpoint = "AM_Incident_Management_indicates_there_is_presently_an_issue_affecting_this_line$s_DSL_service$_Inform_the_customer_that_the_trouble_will_be_cleared_by";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_In_order_to_provide_you_with_the_best_service_possible_I_am_going_to_transfer(){
		 String checkpoint = "AM_In_order_to_provide_you_with_the_best_service_possible_I_am_going_to_transfer";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_IL_Loaner_Phones_are_no_longer_offered(){
		 String checkpoint = "AM_IL_Loaner_Phones_are_no_longer_offered";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_your_data_filters_have_not_been_installed$$$_Data_Service_Provider$(){
		 String checkpoint = "AM_If_your_data_filters_have_not_been_installed$$$_Data_Service_Provider$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_your_data_filters_have_not_been_installed(){
		 String checkpoint = "AM_If_your_data_filters_have_not_been_installed";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_trouble_still_exists$$$number_or_enter_an_MR_ticket$(){
		 String checkpoint = "AM_If_trouble_still_exists$$$number_or_enter_an_MR_ticket$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$Sunday_After_6PM_Before_7AM_CT$(){
		 String checkpoint = "AM_If_this_is_hazardous$$$Sunday_After_6PM_Before_7AM_CT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$Sat_Sun_After_8pm_Before_6am_PT(){
		 String checkpoint = "AM_If_this_is_hazardous$$$Sat_Sun_After_8pm_Before_6am_PT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$call_the_Southern_California_NDC_on_1_800_422_4133(){
		 String checkpoint = "AM_If_this_is_hazardous$$$call_the_Southern_California_NDC_on_1_800_422_4133";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$call_the_South_Texas_NDC_on_1_888_723_5800(){
		 String checkpoint = "AM_If_this_is_hazardous$$$call_the_South_Texas_NDC_on_1_888_723_5800";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$call_the_MW_NDC_on_1_800_649_9598(){
		 String checkpoint = "AM_If_this_is_hazardous$$$call_the_MW_NDC_on_1_800_649_9598";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$214_858_4504$$$M_F_After_10PM_Before_6am_pt_sAT_sUN_aFTER_8pm_Before_6am_PT(){
		 String checkpoint = "AM_If_this_is_hazardous$$$214_858_4504$$$M_F_After_10PM_Before_6am_pt_sAT_sUN_aFTER_8pm_Before_6am_PT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous$$$214_858_4504_Southwest$$$6AM_CT(){
		 String checkpoint = "AM_If_this_is_hazardous$$$214_858_4504_Southwest$$$6AM_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_this_is_hazardous_give_a_four_hour_commitment$$$214_858_4504(){
		 String checkpoint = "AM_If_this_is_hazardous_give_a_four_hour_commitment$$$214_858_4504";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_not_in_the_ATT_facilities$$$a_$71_service_call_charge$(){
		 String checkpoint = "AM_If_the_trouble_is_not_in_the_ATT_facilities$$$a_$71_service_call_charge$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_not_in_the_ATT_facilities$$$a_$51_service_call_charge$(){
		 String checkpoint = "AM_If_the_trouble_is_not_in_the_ATT_facilities$$$a_$51_service_call_charge$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_not_in_the_ATT_facilities(){
		 String checkpoint = "AM_If_the_trouble_is_not_in_the_ATT_facilities";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_found_to_be_in_your_premises_wiring(){
		 String checkpoint = "AM_If_the_trouble_is_found_to_be_in_your_premises_wiring";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_found_to_be_in_the_ATT_facilities$$$repairs_inside_your_premises$(){
		 String checkpoint = "AM_If_the_trouble_is_found_to_be_in_the_ATT_facilities$$$repairs_inside_your_premises$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_trouble_is_found_to_be_in_the_ATT$$$_the_repair_work(){
		 String checkpoint = "AM_If_the_trouble_is_found_to_be_in_the_ATT$$$_the_repair_work";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_problem_is_in_your_premise_you_may_be_$$$avoid_a_techni$(){
		 String checkpoint = "AM_If_the_problem_is_in_your_premise_you_may_be_$$$avoid_a_techni$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_problem_is_in_your_premise_you_may_be(){
		 String checkpoint = "AM_If_the_problem_is_in_your_premise_you_may_be";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_customer_believes_their_service_was_$slammed$$$$ALL(){
		 String checkpoint = "AM_If_the_customer_believes_their_service_was_$slammed$$$$ALL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_customer_believes_their_service_was_$slammed$$$$888_618_4784(){
		 String checkpoint = "AM_If_the_customer_believes_their_service_was_$slammed$$$$888_618_4784";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_customer_believes_their_service_was_$slammed$$$$866_346_1168$$$800_750_2355(){
		 String checkpoint = "AM_If_the_customer_believes_their_service_was_$slammed$$$$866_346_1168$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_customer_believes_their_service_was_$slammed$$$$800_499_7928(){
		 String checkpoint = "AM_If_the_customer_believes_their_service_was_$slammed$$$$800_499_7928";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_the_customer_believes_their_service_was_$slammed$$$$800_310_2355$$$800_750_2355(){
		 String checkpoint = "AM_If_the_customer_believes_their_service_was_$slammed$$$$800_310_2355$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_after_this_report_has_been_entered$$$technician_visit(){
		 String checkpoint = "AM_If_after_this_report_has_been_entered$$$technician_visit";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_If_a_technician_is_dispatched_and_finds_that_the_line_is_already_tagged_a_Premise_Visit_Charge_may_be_applied$(){
		 String checkpoint = "AM_If_a_technician_is_dispatched_and_finds_that_the_line_is_already_tagged_a_Premise_Visit_Charge_may_be_applied$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ICATS_process_does_not_apply_for_customer_with_Missing_Line_Record$(){
		 String checkpoint = "AM_ICATS_process_does_not_apply_for_customer_with_Missing_Line_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_IBN_CONSOLE_$Centrex$(){
		 String checkpoint = "AM_IBN_CONSOLE_$Centrex$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I$m_sorry$_Your_local_service_is_handled_by_LCI_International$Their_number_is_888_524_0011$(){
		 String checkpoint = "AM_I$m_sorry$_Your_local_service_is_handled_by_LCI_International$Their_number_is_888_524_0011$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_customer_contact_us$(){
		 String checkpoint = "AM_I$m_not_able_to_enter_a_report_at_this_time$_It_will_be_necessary_to_have_the_customer_contact_us$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I$m_not_able_to_enter_a_report_at_this_time$(){
		 String checkpoint = "AM_I$m_not_able_to_enter_a_report_at_this_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble(){
		 String checkpoint = "AM_I_would_like_to_assist_you_in_determining$$$CPE_Trouble";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I_will_be_glad_to_note_this_on_the_request(){
		 String checkpoint = "AM_I_will_be_glad_to_note_this_on_the_request";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I_apologize_that_ATT$$$ERDS___restrictions_due_to_natural_disaster$(){
		 String checkpoint = "AM_I_apologize_that_ATT$$$ERDS___restrictions_due_to_natural_disaster$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_I_apologize_that_ATT_will_not_be_able_to_fulfill_your_request_for_an_earlier_repair_commitment$_The_reason_is(){
		 String checkpoint = "AM_I_apologize_that_ATT_will_not_be_able_to_fulfill_your_request_for_an_earlier_repair_commitment$_The_reason_is";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Hazardous__give_4_hours_or_if_report_taken_after_4pm_give_next_day$(){
		 String checkpoint = "AM_Hazardous__give_4_hours_or_if_report_taken_after_4pm_give_next_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Hazardous__give_4_hour_commitment$(){
		 String checkpoint = "AM_Hazardous__give_4_hour_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Has_the_customer_contacted_their_vendor$(){
		 String checkpoint = "AM_Has_the_customer_contacted_their_vendor$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Has_the_customer_checked_their_Caller_ID_equipment$(){
		 String checkpoint = "AM_Has_the_customer_checked_their_Caller_ID_equipment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Has_the_customer_called_the_PIC_verification_number_at_1_700_555_4141$(){
		 String checkpoint = "AM_Has_the_customer_called_the_PIC_verification_number_at_1_700_555_4141$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Give_PIC_information_to_customer$(){
		 String checkpoint = "AM_Give_PIC_information_to_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Give_customer_instructions_on_usage$_See_NCSC_Handbook_for_details$(){
		 String checkpoint = "AM_Give_customer_instructions_on_usage$_See_NCSC_Handbook_for_details$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Give_4_hour_commitment$(){
		 String checkpoint = "AM_Give_4_hour_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Further_Isolation_is_needed$_Tell_the_customer_they_will_be_called_back_after_the_trouble_is_investigated$(){
		 String checkpoint = "AM_Further_Isolation_is_needed$_Tell_the_customer_they_will_be_called_back_after_the_trouble_is_investigated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Further_Isolation_is_needed$(){
		 String checkpoint = "AM_Further_Isolation_is_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Found_toll_restriction$_Referring_to_RCMAC$(){
		 String checkpoint = "AM_Found_toll_restriction$_Referring_to_RCMAC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Follow_Help_File_Instructions_to_locate_RADN(){
		 String checkpoint = "AM_Follow_Help_File_Instructions_to_locate_RADN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Follow_Backdown_SPA_Process(){
		 String checkpoint = "AM_Follow_Backdown_SPA_Process";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_FOLLOW_BACKDOWN_PROCEDURE(){
		 String checkpoint = "AM_FOLLOW_BACKDOWN_PROCEDURE";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Fix_was_successful$(){
		 String checkpoint = "AM_Fix_was_successful$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Fix_VMS_features_were_failed$(){
		 String checkpoint = "AM_Fix_VMS_features_were_failed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Filters_can_be_purchased_at_an_electronic_store$(){
		 String checkpoint = "AM_Filters_can_be_purchased_at_an_electronic_store$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Feature_missing_in_AIN$(){
		 String checkpoint = "AM_Feature_missing_in_AIN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_this_type_of_request_requires_a_service_order$(){
		 String checkpoint = "AM_Explain_to_the_customer_that_this_type_of_request_requires_a_service_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_they_are_involved_with_construction_activity(){
		 String checkpoint = "AM_Explain_to_the_customer_that_they_are_involved_with_construction_activity";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_there_was_a_LPIC_change_on_their_line$(){
		 String checkpoint = "AM_Explain_to_the_customer_that_there_was_a_LPIC_change_on_their_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_there_is_LPIC_activity_occurring_on_their_line$_Would_the_customer_like_additional_information_on_this$(){
		 String checkpoint = "AM_Explain_to_the_customer_that_there_is_LPIC_activity_occurring_on_their_line$_Would_the_customer_like_additional_information_on_this$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_there_is_LPIC_activity_occurring_on_their_line$(){
		 String checkpoint = "AM_Explain_to_the_customer_that_there_is_LPIC_activity_occurring_on_their_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_that_the_order_is_not_due(){
		 String checkpoint = "AM_Explain_to_the_customer_that_the_order_is_not_due";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_the_customer_and_advise_that_they_can_purchase_item_at_an_electronic_store$(){
		 String checkpoint = "AM_Explain_to_the_customer_and_advise_that_they_can_purchase_item_at_an_electronic_store$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_cust_that_line_is_involved_with_OEF_Failure$(){
		 String checkpoint = "AM_Explain_to_cust_that_line_is_involved_with_OEF_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_cust_that_line_is_involved_with_CO_Failure$(){
		 String checkpoint = "AM_Explain_to_cust_that_line_is_involved_with_CO_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$(){
		 String checkpoint = "AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_to_cust_that_line_is_involved_with_a_Failure(){
		 String checkpoint = "AM_Explain_to_cust_that_line_is_involved_with_a_Failure";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_there_is_no_trouble_with_system_possible_CPE_trouble$(){
		 String checkpoint = "AM_Explain_there_is_no_trouble_with_system_possible_CPE_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_that_it_may_take_up_to_10_days_for_the_database_to_update$(){
		 String checkpoint = "AM_Explain_that_it_may_take_up_to_10_days_for_the_database_to_update$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_that_it_is_not_available$(){
		 String checkpoint = "AM_Explain_that_it_is_not_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_that_ATT$s_responsibility_ends_at_the_D_Marc$(){
		 String checkpoint = "AM_Explain_that_ATT$s_responsibility_ends_at_the_D_Marc$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_that_ATT$s_responsibility_ends_at(){
		 String checkpoint = "AM_Explain_that_ATT$s_responsibility_ends_at";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_service_is_working$_Could_customer_hear_the_different_ring_pattern$(){
		 String checkpoint = "AM_Explain_service_is_working$_Could_customer_hear_the_different_ring_pattern$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Explain_ATT_does_not_provide_tree_trimming_service$(){
		 String checkpoint = "AM_Explain_ATT_does_not_provide_tree_trimming_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Expedite_system_unavailable$$$appropriate_commitment_with_the_customer$(){
		 String checkpoint = "AM_Expedite_system_unavailable$$$appropriate_commitment_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ESL___GIVE_4_HOUR_COMMITMENT(){
		 String checkpoint = "AM_ESL___GIVE_4_HOUR_COMMITMENT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Enter_escalation_into_EMS$(){
		 String checkpoint = "AM_Enter_escalation_into_EMS$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Enter_a_detailed_description_of_the_trouble_in_the_report_narrative$(){
		 String checkpoint = "AM_Enter_a_detailed_description_of_the_trouble_in_the_report_narrative$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Emergency_Restoration_no_longer_applies_please_validate_all(){
		 String checkpoint = "AM_Emergency_Restoration_no_longer_applies_please_validate_all";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Educate_the_customer_with_the_correct_access_code$(){
		 String checkpoint = "AM_Educate_the_customer_with_the_correct_access_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Educate_customer_and_on_line_transfer$$$(){
		 String checkpoint = "AM_Educate_customer_and_on_line_transfer$$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Educate_customer_and_on_line_transfer_to_1_800_956_7000_for_ATT_800_Service$(){
		 String checkpoint = "AM_Educate_customer_and_on_line_transfer_to_1_800_956_7000_for_ATT_800_Service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_Voice_Mailbox_accept_the_customer$s_password$(){
		 String checkpoint = "AM_Does_the_Voice_Mailbox_accept_the_customer$s_password$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_name_the_customer_provided_match_the_bill_record$(){
		 String checkpoint = "AM_Does_the_name_the_customer_provided_match_the_bill_record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_customer_want_to_order_the_feature$(){
		 String checkpoint = "AM_Does_the_customer_want_to_order_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_customer_need_instructions_on_checking_CPE$NID$(){
		 String checkpoint = "AM_Does_the_customer_need_instructions_on_checking_CPE$NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_customer_name_information_match_what_the_customer_is_stating_it_should_be$(){
		 String checkpoint = "AM_Does_the_customer_name_information_match_what_the_customer_is_stating_it_should_be$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_customer_have$know_their_Account_Code$(){
		 String checkpoint = "AM_Does_the_customer_have$know_their_Account_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_the_Billing_Record_match_translations$(){
		 String checkpoint = "AM_Does_the_Billing_Record_match_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_not_qualify_for_vendor_meet$_Press_OK_to_return_to_main_menu_and_take_trouble_report$(){
		 String checkpoint = "AM_Does_not_qualify_for_vendor_meet$_Press_OK_to_return_to_main_menu_and_take_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_customer_want_to_order_the_feature$(){
		 String checkpoint = "AM_Does_customer_want_to_order_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_customer_want_ATT_to_isolate$(){
		 String checkpoint = "AM_Does_customer_want_ATT_to_isolate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_customer_agree_with_PIC_in_Billing$(){
		 String checkpoint = "AM_Does_customer_agree_with_PIC_in_Billing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Does_ATT_own_800$$(){
		 String checkpoint = "AM_Does_ATT_own_800$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Do_you_want_to_continue_to_reset_the_Message_Waiting_Indicator$(){
		 String checkpoint = "AM_Do_you_want_to_continue_to_reset_the_Message_Waiting_Indicator$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Do_not_give_call_back_unless_customer_demands$(){
		 String checkpoint = "AM_Do_not_give_call_back_unless_customer_demands$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Do_not_discuss_possible_cause_or_responsibility$(){
		 String checkpoint = "AM_Do_not_discuss_possible_cause_or_responsibility$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Did_you_get_the_customer$s_greeting$(){
		 String checkpoint = "AM_Did_you_get_the_customer$s_greeting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Did_feature_education_resolve_the_customer$s_trouble$(){
		 String checkpoint = "AM_Did_feature_education_resolve_the_customer$s_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Did_education_resolve_trouble$(){
		 String checkpoint = "AM_Did_education_resolve_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Dial_around_toll_restriction_found$_Does_customer_want_to_remove_restriction$(){
		 String checkpoint = "AM_Dial_around_toll_restriction_found$_Does_customer_want_to_remove_restriction$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_wants_Tech$$$each_add$l_15_minutes$(){
		 String checkpoint = "AM_Customer_wants_Tech$$$each_add$l_15_minutes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_wants_Tech_to_come_to_$$$_add$l_15_minutes$(){
		 String checkpoint = "AM_Customer_wants_Tech_to_come_to_$$$_add$l_15_minutes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_subscribes_to_the_following_feature$s$$_PRIVACY_MANAGER_CALLER_ID(){
		 String checkpoint = "AM_Customer_subscribes_to_the_following_feature$s$$_PRIVACY_MANAGER_CALLER_ID";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_subscribes_to_the_following_feature$s$$_PRIVACY_MANAGER(){
		 String checkpoint = "AM_Customer_subscribes_to_the_following_feature$s$$_PRIVACY_MANAGER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKING_CALLER_ID_WN_PRIVACY_MANAGER(){
		 String checkpoint = "AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKING_CALLER_ID_WN_PRIVACY_MANAGER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKER_PRIVACY_MANAGER(){
		 String checkpoint = "AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKER_PRIVACY_MANAGER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKER(){
		 String checkpoint = "AM_Customer_subscribes_to_the_following_feature$s$$_CALL_BLOCKER";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_is_not_being_charged_for_the_mailbox$(){
		 String checkpoint = "AM_Customer_is_not_being_charged_for_the_mailbox$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_multiple_transfers_of_service_$T$_orders$(){
		 String checkpoint = "AM_Customer_has_multiple_transfers_of_service_$T$_orders$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_multiple_new_connect_$N$_orders$(){
		 String checkpoint = "AM_Customer_has_multiple_new_connect_$N$_orders$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_multiple_change_$C$_orders$(){
		 String checkpoint = "AM_Customer_has_multiple_change_$C$_orders$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_Hunting$_Please_select_any_number$s$_which_need_to_be_updated$(){
		 String checkpoint = "AM_Customer_has_Hunting$_Please_select_any_number$s$_which_need_to_be_updated$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_both_a_transfer_of_service_To_$T$_order_and_a_transfer_of_service_From_$F$_order$(){
		 String checkpoint = "AM_Customer_has_both_a_transfer_of_service_To_$T$_order_and_a_transfer_of_service_From_$F$_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_both_a_transfer_of_service_$T$_order_and_a_change_$C$_order$(){
		 String checkpoint = "AM_Customer_has_both_a_transfer_of_service_$T$_order_and_a_change_$C$_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_transfer_of_service_$T$_Order$(){
		 String checkpoint = "AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_transfer_of_service_$T$_Order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_Disconnect_$D$_order$(){
		 String checkpoint = "AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_Disconnect_$D$_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_Change_$C$_order$(){
		 String checkpoint = "AM_Customer_has_both_a_new_connect_$N$_Service_Order_and_a_Change_$C$_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_a_Deny_Non_regulated_Product_Flag_$DDR$_on_their_account$(){
		 String checkpoint = "AM_Customer_has_a_Deny_Non_regulated_Product_Flag_$DDR$_on_their_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Customer_has_a_$deny_non_regulated_product$_flag(){
		 String checkpoint = "AM_Customer_has_a_$deny_non_regulated_product$_flag";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Current_time_is_after_hours$_Give_appropriate_commitment(){
		 String checkpoint = "AM_Current_time_is_after_hours$_Give_appropriate_commitment";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Correctional_facilities_use_different_coin_vendors_CT_SNET(){
		 String checkpoint = "AM_Correctional_facilities_use_different_coin_vendors_CT_SNET";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Correctional_facilities_use_different_coin_vendors_which_provide_a_blocking_service$(){
		 String checkpoint = "AM_Correctional_facilities_use_different_coin_vendors_which_provide_a_blocking_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$NONE$$$8ALL(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$NONE$$$8ALL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$888_361_5455$$$Res$_800_288_2020_or_Bus$_800_750_2355(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$888_361_5455$$$Res$_800_288_2020_or_Bus$_800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$888_224_4827$$$800_288_2020(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$888_224_4827$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$888_367_3330$$$800_424_5112(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$888_367_3330$$$800_424_5112";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$888_367_3330$$$800_288_2020(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$888_367_3330$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$800_736_9980$$$800_750_2355(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$800_736_9980$$$800_750_2355";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Contact_the_Installation_Control_Center$$$800_649_9598$$$800_288_2020(){
		 String checkpoint = "AM_Contact_the_Installation_Control_Center$$$800_649_9598$$$800_288_2020";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Consider_the_commitment_time_negotiate_a_new_commitment_if_necessary$(){
		 String checkpoint = "AM_Consider_the_commitment_time_negotiate_a_new_commitment_if_necessary$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Confirm_the_customer_has_checked_both_inside_and_outside_for_an_existing_NID$(){
		 String checkpoint = "AM_Confirm_the_customer_has_checked_both_inside_and_outside_for_an_existing_NID$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Confirm_that_the_customer_is_not_dialing_up_on_the_Voice_portion_of_the_line_to_access(){
		 String checkpoint = "AM_Confirm_that_the_customer_is_not_dialing_up_on_the_Voice_portion_of_the_line_to_access";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Complete_the_flow_and_inform_customer_their_trouble_will_be_cleared_by(){
		 String checkpoint = "AM_Complete_the_flow_and_inform_customer_their_trouble_will_be_cleared_by";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Complete_2PIC_Form(){
		 String checkpoint = "AM_Complete_2PIC_Form";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Close_trouble_report$(){
		 String checkpoint = "AM_Close_trouble_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Close_report$(){
		 String checkpoint = "AM_Close_report$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Choose_appropriate_TYPE_Code_and_describe_issue$s$_in_Report_Field(){
		 String checkpoint = "AM_Choose_appropriate_TYPE_Code_and_describe_issue$s$_in_Report_Field";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Checking_QVF$(){
		 String checkpoint = "AM_Checking_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_your_input_or_use_the_reported_telephone_number$(){
		 String checkpoint = "AM_Check_your_input_or_use_the_reported_telephone_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_status_of_the_order$(){
		 String checkpoint = "AM_Check_status_of_the_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_ROS_for_Pay_Per_Use_availability$(){
		 String checkpoint = "AM_Check_ROS_for_Pay_Per_Use_availability$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_OLRM_for_Pay_Per_Use_availability$(){
		 String checkpoint = "AM_Check_OLRM_for_Pay_Per_Use_availability$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_NPANXX_pages_for_PPU_availability$_Is_PPU_available$(){
		 String checkpoint = "AM_Check_NPANXX_pages_for_PPU_availability$_Is_PPU_available$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_LCC_in_translations$_Does_translations_match_Billing_Record$(){
		 String checkpoint = "AM_Check_LCC_in_translations$_Does_translations_match_Billing_Record$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_LCC_in_translations$(){
		 String checkpoint = "AM_Check_LCC_in_translations$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_History$(){
		 String checkpoint = "AM_Check_History$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_History(){
		 String checkpoint = "AM_Check_History";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_for_Voice_Mail_outage$_Is_this_number_part_of_a_Voice_Mail_outage$(){
		 String checkpoint = "AM_Check_for_Voice_Mail_outage$_Is_this_number_part_of_a_Voice_Mail_outage$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_EXCHANGE_PLUS_for_Pay_Per_Use_availability$(){
		 String checkpoint = "AM_Check_EXCHANGE_PLUS_for_Pay_Per_Use_availability$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Check_ASSIST_NET_for_Pay_Per_Use_availability$(){
		 String checkpoint = "AM_Check_ASSIST_NET_for_Pay_Per_Use_availability$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Changes_from_one_type_of_network_to_another(){
		 String checkpoint = "AM_Changes_from_one_type_of_network_to_another";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Calls_are_transferring$(){
		 String checkpoint = "AM_Calls_are_transferring$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_CALL_WAITING_CALL_FORWARDING_not_fixed$(){
		 String checkpoint = "AM_CALL_WAITING_CALL_FORWARDING_not_fixed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_CALL_WAITING_CALL_BLOCKER_not_fixed$(){
		 String checkpoint = "AM_CALL_WAITING_CALL_BLOCKER_not_fixed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_Southern_California_NDC_on_1_800_736_9980$(){
		 String checkpoint = "AM_Call_the_Southern_California_NDC_on_1_800_736_9980$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_RACF$RADN_Number$_Was_the_test_call_OK(){
		 String checkpoint = "AM_Call_the_RACF$RADN_Number$_Was_the_test_call_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_Night_Reporting_Center_at_1_888_433_9133(){
		 String checkpoint = "AM_Call_the_Night_Reporting_Center_at_1_888_433_9133";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_NDC_center$(){
		 String checkpoint = "AM_Call_the_NDC_center$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_customer_back$_Did_the_MWI_reset_resolve_the_customer$s_trouble$(){
		 String checkpoint = "AM_Call_the_customer_back$_Did_the_MWI_reset_resolve_the_customer$s_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_the_CFN_and_enter_the_customer$s_number_to_ensure_mailbox_is_built$_Is_mailbox_built$(){
		 String checkpoint = "AM_Call_the_CFN_and_enter_the_customer$s_number_to_ensure_mailbox_is_built$_Is_mailbox_built$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_CALL_PICK_UP_FOR_TEST(){
		 String checkpoint = "AM_CALL_PICK_UP_FOR_TEST";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_forwarding_removed_via_QVF$(){
		 String checkpoint = "AM_Call_forwarding_removed_via_QVF$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_Forwarding_is_active_on_Account$(){
		 String checkpoint = "AM_Call_Forwarding_is_active_on_Account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_CALL_FORWARD_PHN_SOLUTION(){
		 String checkpoint = "AM_CALL_FORWARD_PHN_SOLUTION";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_East_NDC_on_1_888_830_5370(){
		 String checkpoint = "AM_Call_East_NDC_on_1_888_830_5370";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Call_CFN_bridge_customer_in_and_ask_customer_to_delete_message$(){
		 String checkpoint = "AM_Call_CFN_bridge_customer_in_and_ask_customer_to_delete_message$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Cable_Failure_restoration_takes_priority_over_individual_troubles$$$888_361_5455(){
		 String checkpoint = "AM_Cable_Failure_restoration_takes_priority_over_individual_troubles$$$888_361_5455";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Cable_Failure_restoration_takes_priority_over_individual_troubles$(){
		 String checkpoint = "AM_Cable_Failure_restoration_takes_priority_over_individual_troubles$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_WI(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_TX(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_OK(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_OH(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_NV(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_MO(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_KS(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_IN(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_IL(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_CT(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_CA(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Small_Business_State$_AR(){
		 String checkpoint = "AM_Business_Office$_Small_Business_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_WI(){
		 String checkpoint = "AM_Business_Office$_Security_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_TX(){
		 String checkpoint = "AM_Business_Office$_Security_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_OK(){
		 String checkpoint = "AM_Business_Office$_Security_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_OH(){
		 String checkpoint = "AM_Business_Office$_Security_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_NV(){
		 String checkpoint = "AM_Business_Office$_Security_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_MO(){
		 String checkpoint = "AM_Business_Office$_Security_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_MI(){
		 String checkpoint = "AM_Business_Office$_Security_State$_MI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_KS(){
		 String checkpoint = "AM_Business_Office$_Security_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_IN(){
		 String checkpoint = "AM_Business_Office$_Security_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_IL(){
		 String checkpoint = "AM_Business_Office$_Security_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_CT(){
		 String checkpoint = "AM_Business_Office$_Security_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_CA(){
		 String checkpoint = "AM_Business_Office$_Security_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Security_State$_AR(){
		 String checkpoint = "AM_Business_Office$_Security_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_WI(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_TX(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_OK(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_OH(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_NV(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_MS(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_MS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_MO(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_MI(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_MI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_KS(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_IN(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_IL(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_CT(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_CA(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_AR(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Enhanced_Business_State$_AL(){
		 String checkpoint = "AM_Business_Office$_Enhanced_Business_State$_AL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_WI(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_TX(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_OK(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_OH(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_NV(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_MO(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_MI(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_MI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_KS(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_IN(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_IL(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_FL(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_FL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_CT(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_CA(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Consumer_State$_AR(){
		 String checkpoint = "AM_Business_Office$_Consumer_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_WI(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_TX(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_OK(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_OH(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_NV(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_NC(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_NC";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_MO(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_MI(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_MI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_KS(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_IN(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_IL(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_CT(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_CA(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_Annoyance_Call_Bureau_State$_AR(){
		 String checkpoint = "AM_Business_Office$_Annoyance_Call_Bureau_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_WI(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_WI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_TX(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_OK(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_OK";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_OH(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_OH";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_NV(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_NV";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_MO(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_MO";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_MI(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_MI";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_KS(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_KS";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_IN(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_IN";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_IL(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_IL";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_CT(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_CT";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_CA(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_CA";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Business_Office$_AIIS_$resale$_State$_AR(){
		 String checkpoint = "AM_Business_Office$_AIIS_$resale$_State$_AR";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Buried_Wire_requests_are_handled_by_the_Business_Office(){
		 String checkpoint = "AM_Buried_Wire_requests_are_handled_by_the_Business_Office";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Bill_Information_is_being_Gathered$(){
		 String checkpoint = "AM_Bill_Information_is_being_Gathered$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Backdown_TCF_requires_local_manual_processing(){
		 String checkpoint = "AM_Backdown_TCF_requires_local_manual_processing";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATTN_AGENTS$$$888_289_7921_TX(){
		 String checkpoint = "AM_ATTN_AGENTS$$$888_289_7921_TX";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician$$$Network_Interface_Device$$$isolation_work(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician$$$Network_Interface_Device$$$isolation_work";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician_and_clear_any_trouble_to_the_ATT_outside$$$$115_and_$45_$each_add$l_wire_run$$(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician_and_clear_any_trouble_to_the_ATT_outside$$$$115_and_$45_$each_add$l_wire_run$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician_and_clear_any_trouble_to_the_ATT_outside(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician_and_clear_any_trouble_to_the_ATT_outside";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician_and_$$$of_trouble_only(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician_and_$$$of_trouble_only";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician_and(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician_and";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_Repair_will_dispatch_a_technician$$$isolation_work(){
		 String checkpoint = "AM_ATT_Repair_will_dispatch_a_technician$$$isolation_work";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_is_not_permitted_to_work_on_telephone_equipment$(){
		 String checkpoint = "AM_ATT_is_not_permitted_to_work_on_telephone_equipment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_has_the_correct_name$(){
		 String checkpoint = "AM_ATT_has_the_correct_name$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_NC$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_NC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_CT$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_CT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_AL$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_56kbps_for_AL$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_MI$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_MI$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_IN$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_IN$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_CA$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_4800bps_for_CA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of_14$4kbps_for_OH$(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of_14$4kbps_for_OH$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_ATT_guarantees_a_data_transmission_speed_of(){
		 String checkpoint = "AM_ATT_guarantees_a_data_transmission_speed_of";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$(){
		 String checkpoint = "AM_Ask_the_customer_to_verify_their_ISP_number$_Is_it_programmed_correctly$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_the_customer_to_verify_their_ISP_number$(){
		 String checkpoint = "AM_Ask_the_customer_to_verify_their_ISP_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_the_customer_if_they_are_required_to_dial_an_access_code_$e$g$_8_or_9$$(){
		 String checkpoint = "AM_Ask_the_customer_if_they_are_required_to_dial_an_access_code_$e$g$_8_or_9$$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_if_customer_has_eligible_equipment_to_support_the_feature$(){
		 String checkpoint = "AM_Ask_if_customer_has_eligible_equipment_to_support_the_feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_for_a_Reach_Number$(){
		 String checkpoint = "AM_Ask_for_a_Reach_Number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_to_unplug_phone_and_change_the_batteries$(){
		 String checkpoint = "AM_Ask_customer_to_unplug_phone_and_change_the_batteries$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_to_unplug_phone_and_change_the(){
		 String checkpoint = "AM_Ask_customer_to_unplug_phone_and_change_the";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_to_try_the_call_again$_Call_back_if_the_trouble_occurs_again$(){
		 String checkpoint = "AM_Ask_customer_to_try_the_call_again$_Call_back_if_the_trouble_occurs_again$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_to_contact_their_Long_Distance_carrier$(){
		 String checkpoint = "AM_Ask_customer_to_contact_their_Long_Distance_carrier$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_if_they_want_to_keep_Call_Forwarding_Feature$(){
		 String checkpoint = "AM_Ask_customer_if_they_want_to_keep_Call_Forwarding_Feature$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_if_they_hear_others_on_line$_$If(){
		 String checkpoint = "AM_Ask_customer_if_they_hear_others_on_line$_$If";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Ask_customer_if_they_are_willing_to_check_their_CPE$(){
		 String checkpoint = "AM_Ask_customer_if_they_are_willing_to_check_their_CPE$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Arrange_Access_appointment_and_advise_customer_of_cost_of_dispatch$(){
		 String checkpoint = "AM_Arrange_Access_appointment_and_advise_customer_of_cost_of_dispatch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_An_EMS_Issue_exists_for_this_report_with_a_status_of_OPEN$_Refer_the_customer_to_EMS_at_1_888_272_4047(){
		 String checkpoint = "AM_An_EMS_Issue_exists_for_this_report_with_a_status_of_OPEN$_Refer_the_customer_to_EMS_at_1_888_272_4047";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_An_ATT_Emergency_Number_has_been_accessed$(){
		 String checkpoint = "AM_An_ATT_Emergency_Number_has_been_accessed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_All_requests_to_move_the_drop_wire_are_handled_by_the_Business_Office$(){
		 String checkpoint = "AM_All_requests_to_move_the_drop_wire_are_handled_by_the_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_After_hours_call_the_Southern_California_NDC_on_1_800_736_9980$(){
		 String checkpoint = "AM_After_hours_call_the_Southern_California_NDC_on_1_800_736_9980$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_After_hours_call_the_$MW$_West_NDC_on_1_800_649_9598$(){
		 String checkpoint = "AM_After_hours_call_the_$MW$_West_NDC_on_1_800_649_9598$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_After_hours_a_call_needs_to_be_made_to_advise_the_field_of_the_Cable_Cut$Hazardous_Condition_MSG192(){
		 String checkpoint = "AM_After_hours_a_call_needs_to_be_made_to_advise_the_field_of_the_Cable_Cut$Hazardous_Condition_MSG192";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_After_hours_a_call_needs_to_be_made_to_advise_the_field_of_the_Cable_Cut$Hazardous_Condition_MSG191(){
		 String checkpoint = "AM_After_hours_a_call_needs_to_be_made_to_advise_the_field_of_the_Cable_Cut$Hazardous_Condition_MSG191";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_you_will_transfer_them_to_the_Business_office$$$called_into_Report_narrative_field$(){
		 String checkpoint = "AM_Advise_the_customer_you_will_transfer_them_to_the_Business_office$$$called_into_Report_narrative_field$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_you_will_transfer_them_to_the_Business_office_to_discuss_an_order$(){
		 String checkpoint = "AM_Advise_the_customer_you_will_transfer_them_to_the_Business_office_to_discuss_an_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_will_transfer_to_the_Business_Office_to_discuss_the_order$(){
		 String checkpoint = "AM_Advise_the_customer_will_transfer_to_the_Business_Office_to_discuss_the_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_we_will_inform_the_contractor_of_your_request_and_we_will_ask_the_contractor_to_give_you_a_call_within_5_business_days(){
		 String checkpoint = "AM_Advise_the_customer_we_will_inform_the_contractor_of_your_request_and_we_will_ask_the_contractor_to_give_you_a_call_within_5_business_days";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_we_will_inform_the_contractor_of_your_request_and_we_will_ask_the_contractor_to_give_you_a_call_within_2_business_days_if_they_cannot_bury_the_wire_by_that_date$(){
		 String checkpoint = "AM_Advise_the_customer_we_will_inform_the_contractor_of_your_request_and_we_will_ask_the_contractor_to_give_you_a_call_within_2_business_days_if_they_cannot_bury_the_wire_by_that_date$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_we_will_ask_the_contractor(){
		 String checkpoint = "AM_Advise_the_customer_we_will_ask_the_contractor";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_try_their_call_again_with_the_correct_Country_Code$(){
		 String checkpoint = "AM_Advise_the_customer_to_try_their_call_again_with_the_correct_Country_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_try_the_call_again_during_a_non_peak_time$(){
		 String checkpoint = "AM_Advise_the_customer_to_try_the_call_again_during_a_non_peak_time$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_switch_the_phone_to_pulse_setting$(){
		 String checkpoint = "AM_Advise_the_customer_to_switch_the_phone_to_pulse_setting$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_report_the_trouble_to_SNET_All_Distance_at_1_800_808_7638$(){
		 String checkpoint = "AM_Advise_the_customer_to_report_the_trouble_to_SNET_All_Distance_at_1_800_808_7638$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_their_Public_Service_Answer_Point_$PSAP$at_the_Non_Emergency_PSAP_telephone_number$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_their_Public_Service_Answer_Point_$PSAP$at_the_Non_Emergency_PSAP_telephone_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_telephone_number_on_the_recording$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_telephone_number_on_the_recording$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_Phone_Protect$$$1_877_594_2999$$$M_F_8A_9P_CST_SAT_8A_3P_CST$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_Phone_Protect$$$1_877_594_2999$$$M_F_8A_9P_CST_SAT_8A_3P_CST$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_Phone_Protect_vendor_at_1_888_477_6477$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_Phone_Protect_vendor_at_1_888_477_6477$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_operator_to_assist_with_placing_the_call$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_operator_to_assist_with_placing_the_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_ATT_CPE_Cust_Equipment_Support_at_1_800_667_2118_to_determine_if_the_phone_is_under_warranty$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_ATT_CPE_Cust_Equipment_Support_at_1_800_667_2118_to_determine_if_the_phone_is_under_warranty$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_the_Affina_at_1_800_667_2118_to_determine_if_the_phone_is_under_warranty$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_the_Affina_at_1_800_667_2118_to_determine_if_the_phone_is_under_warranty$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_to_call_TFSC_at_1_800_959_2000$(){
		 String checkpoint = "AM_Advise_the_customer_to_call_TFSC_at_1_800_959_2000$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_this_service_is_suspended_at_the_customer$s_request$(){
		 String checkpoint = "AM_Advise_the_customer_this_service_is_suspended_at_the_customer$s_request$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_this_order_needs_further_analysis$_Send_to_NDC_to_get_service_working$(){
		 String checkpoint = "AM_Advise_the_customer_this_order_needs_further_analysis$_Send_to_NDC_to_get_service_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_this_order_needs_further_analysis$(){
		 String checkpoint = "AM_Advise_the_customer_this_order_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_there_is_an_order_that_has_disconnected_this_service$(){
		 String checkpoint = "AM_Advise_the_customer_there_is_an_order_that_has_disconnected_this_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_there_is_a_Service_order_that_has_disconnected_this_service$(){
		 String checkpoint = "AM_Advise_the_customer_there_is_a_Service_order_that_has_disconnected_this_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_there_is_a_pending_Service_Order_on_their_account(){
		 String checkpoint = "AM_Advise_the_customer_there_is_a_pending_Service_Order_on_their_account";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_service_will_be_working_by_the_end_of_the_day$(){
		 String checkpoint = "AM_Advise_the_customer_the_service_will_be_working_by_the_end_of_the_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_service_order_is_pending$(){
		 String checkpoint = "AM_Advise_the_customer_the_service_order_is_pending$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_service_is_scheduled_to_be_disconnected_by_a_future_dated_F_order$(){
		 String checkpoint = "AM_Advise_the_customer_the_service_is_scheduled_to_be_disconnected_by_a_future_dated_F_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_service_has_been_disconnected_as_requested_per_the_Service_Order$(){
		 String checkpoint = "AM_Advise_the_customer_the_service_has_been_disconnected_as_requested_per_the_Service_Order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_service_has_been_disconnected_as_requested_by_the_Service_Order$(){
		 String checkpoint = "AM_Advise_the_customer_the_service_has_been_disconnected_as_requested_by_the_Service_Order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_report_will_be_closed$(){
		 String checkpoint = "AM_Advise_the_customer_the_report_will_be_closed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_report_needs_further_analysis$$$number_if_appropriate(){
		 String checkpoint = "AM_Advise_the_customer_the_report_needs_further_analysis$$$number_if_appropriate";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_report_needs_further_analysis$(){
		 String checkpoint = "AM_Advise_the_customer_the_report_needs_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_Order_is_still_pending(){
		 String checkpoint = "AM_Advise_the_customer_the_Order_is_still_pending";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_Order_is_pending(){
		 String checkpoint = "AM_Advise_the_customer_the_Order_is_pending";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_order_is_being_dispatched_and_a_technician_will_be_working_to_complete_it_by_the_end_of_day$(){
		 String checkpoint = "AM_Advise_the_customer_the_order_is_being_dispatched_and_a_technician_will_be_working_to_complete_it_by_the_end_of_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_order_has_not_completed(){
		 String checkpoint = "AM_Advise_the_customer_the_order_has_not_completed";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_feature_was_removed_by_a_service_order$Does_the_customer_want_to_discuss_order(){
		 String checkpoint = "AM_Advise_the_customer_the_feature_was_removed_by_a_service_order$Does_the_customer_want_to_discuss_order";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_the_feature_was_removed_by_a_service_order$_Does_the_customer_want_to_discuss_with_the_Business_Office$(){
		 String checkpoint = "AM_Advise_the_customer_the_feature_was_removed_by_a_service_order$_Does_the_customer_want_to_discuss_with_the_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_we_will_need_to_do_further_testing$(){
		 String checkpoint = "AM_Advise_the_customer_that_we_will_need_to_do_further_testing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_we_will_enter_a_report_to_have_their_drop_wire_buried$(){
		 String checkpoint = "AM_Advise_the_customer_that_we_will_enter_a_report_to_have_their_drop_wire_buried$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_we_are_unable_to_investigate_without_the_Recording_information$(){
		 String checkpoint = "AM_Advise_the_customer_that_we_are_unable_to_investigate_without_the_Recording_information$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_this_report_will_be_closed$(){
		 String checkpoint = "AM_Advise_the_customer_that_this_report_will_be_closed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_they$$$_811_One_Call_Center_by_dialing_811(){
		 String checkpoint = "AM_Advise_the_customer_that_they$$$_811_One_Call_Center_by_dialing_811";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_they_can_dial_the_700$_to_verify_the_carrier_on_their_line$(){
		 String checkpoint = "AM_Advise_the_customer_that_they_can_dial_the_700$_to_verify_the_carrier_on_their_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_there_is_no_trouble_on_their_line$(){
		 String checkpoint = "AM_Advise_the_customer_that_there_is_no_trouble_on_their_line$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_there_is_a_toll_restriction_on_the_account$(){
		 String checkpoint = "AM_Advise_the_customer_that_there_is_a_toll_restriction_on_the_account$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_will_be_worked_by_the_end_of_the_day$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_will_be_worked_by_the_end_of_the_day$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_was_cancelled$$$Business_Office_if_they_have_questions$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_was_cancelled$$$Business_Office_if_they_have_questions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_was_cancelled_and_transfer_to_the_Business_Office_if_they_have_questions$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_was_cancelled_and_transfer_to_the_Business_Office_if_they_have_questions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_was_cancelled(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_was_cancelled";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_is_not_complete$$$if_they_have_questions(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_is_not_complete$$$if_they_have_questions";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_is_not_complete_and_refer_to_the_Business_Office_for_additional_assistance$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_is_not_complete_and_refer_to_the_Business_Office_for_additional_assistance$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_order_is_due$DueDate$$_Does_customer_agree_with_due_date(){
		 String checkpoint = "AM_Advise_the_customer_that_the_order_is_due$DueDate$$_Does_customer_agree_with_due_date";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_line_is_forwarded$_Provide_deactivation_instructions$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_line_is_forwarded$_Provide_deactivation_instructions$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_line_is_forwarded$_Provide_deact(){
		 String checkpoint = "AM_Advise_the_customer_that_the_line_is_forwarded$_Provide_deact";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_the_Call_Forwarding_feature_will_be_removed$(){
		 String checkpoint = "AM_Advise_the_customer_that_the_Call_Forwarding_feature_will_be_removed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_information_can_be_obtained_online_at_https$$$www$um$att$com$(){
		 String checkpoint = "AM_Advise_the_customer_that_information_can_be_obtained_online_at_https$$$www$um$att$com$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_information_can_be_obtained_online_at_att$com$(){
		 String checkpoint = "AM_Advise_the_customer_that_information_can_be_obtained_online_at_att$com$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_further_analysis_is_needed$$$_tree_form$(){
		 String checkpoint = "AM_Advise_the_customer_that_further_analysis_is_needed$$$_tree_form$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_further_analysis_is_needed$(){
		 String checkpoint = "AM_Advise_the_customer_that_further_analysis_is_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_that_calls_are_forwarded$_Provide_instructions_to_deactivate$(){
		 String checkpoint = "AM_Advise_the_customer_that_calls_are_forwarded$_Provide_instructions_to_deactivate$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_the_Service_Order_due_date_and_if_necessary_refer_to_Business_Office$(){
		 String checkpoint = "AM_Advise_the_customer_of_the_Service_Order_due_date_and_if_necessary_refer_to_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_the_results_of_the_test_call_CFW(){
		 String checkpoint = "AM_Advise_the_customer_of_the_results_of_the_test_call_CFW";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_the_results_of_the_test_call$_Does_the_customer_agree_that_Voice_Mail_is_working$(){
		 String checkpoint = "AM_Advise_the_customer_of_the_results_of_the_test_call$_Does_the_customer_agree_that_Voice_Mail_is_working$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_the_results_of_the_test_call$_Does_customer$$$working_now(){
		 String checkpoint = "AM_Advise_the_customer_of_the_results_of_the_test_call$_Does_customer$$$working_now";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_the_results_of_the_test_call$(){
		 String checkpoint = "AM_Advise_the_customer_of_the_results_of_the_test_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_4_hour_commitment$(){
		 String checkpoint = "AM_Advise_the_customer_of_4_hour_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_of_2_hour_commitment$(){
		 String checkpoint = "AM_Advise_the_customer_of_2_hour_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_customer_a_new_order_is_needed$(){
		 String checkpoint = "AM_Advise_the_customer_a_new_order_is_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_Caller_to_report_trouble_through_Jacksonville_CAB_at_$800$_247_2020$(){
		 String checkpoint = "AM_Advise_the_Caller_to_report_trouble_through_Jacksonville_CAB_at_$800$_247_2020$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_caller_if_they_need_a_confirmation_letter_to_send_an_email_to_the_NDC_Demolition_Mailbox_at_NDC_DEMO$att$com$(){
		 String checkpoint = "AM_Advise_the_caller_if_they_need_a_confirmation_letter_to_send_an_email_to_the_NDC_Demolition_Mailbox_at_NDC_DEMO$att$com$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_Business_Office_that_the_line_tested_OK$(){
		 String checkpoint = "AM_Advise_the_Business_Office_that_the_line_tested_OK$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_after_hours_field_of_the_Urgent$$$RMK_to_the_ticket_LOG_with_the_name_of_the_NRC_Agent(){
		 String checkpoint = "AM_Advise_the_after_hours_field_of_the_Urgent$$$RMK_to_the_ticket_LOG_with_the_name_of_the_NRC_Agent";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_after_hours_field_of_the_Urgent_Condition$$$ticket_LOG_with_the_name_of_the_NRC_Agent_MSG231(){
		 String checkpoint = "AM_Advise_the_after_hours_field_of_the_Urgent_Condition$$$ticket_LOG_with_the_name_of_the_NRC_Agent_MSG231";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_the_after_hours_field_of_the_Urgent_Condition$$$ticket_LOG_with_the_name_of_the_NRC_Agent_MSG230(){
		 String checkpoint = "AM_Advise_the_after_hours_field_of_the_Urgent_Condition$$$ticket_LOG_with_the_name_of_the_NRC_Agent_MSG230";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_that_the_password_cannot_be_reset$(){
		 String checkpoint = "AM_Advise_that_the_password_cannot_be_reset$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_that_Ring_Cycle_is_too_short_and_could_be_causing_the_trouble$(){
		 String checkpoint = "AM_Advise_that_Ring_Cycle_is_too_short_and_could_be_causing_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_that_cordless_phone_can_sometimes_cause_this_problem$_Does_the_customer_have_a_cordless_phone$(){
		 String checkpoint = "AM_Advise_that_cordless_phone_can_sometimes_cause_this_problem$_Does_the_customer_have_a_cordless_phone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_that_cordless_phone_can_sometimes(){
		 String checkpoint = "AM_Advise_that_cordless_phone_can_sometimes";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_PSAP_we_are_unable_to_take_report_for_the_payphone$(){
		 String checkpoint = "AM_Advise_PSAP_we_are_unable_to_take_report_for_the_payphone$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_of_ERDS_Restriction_and_try_to_uphold_the_commitment$(){
		 String checkpoint = "AM_Advise_of_ERDS_Restriction_and_try_to_uphold_the_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_Due_date_of_Order$(){
		 String checkpoint = "AM_Advise_Due_date_of_Order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_will_transfer_to_the_Business_office_to_discuss_their_order$(){
		 String checkpoint = "AM_Advise_customer_will_transfer_to_the_Business_office_to_discuss_their_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_will_transfer_to_the_Business_Office_to_discuss_the_order$(){
		 String checkpoint = "AM_Advise_customer_will_transfer_to_the_Business_Office_to_discuss_the_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_we_will_begin_working_on_trouble_IMMEDIATELY$(){
		 String checkpoint = "AM_Advise_customer_we_will_begin_working_on_trouble_IMMEDIATELY$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_we_have_a_buried_wire_request_on_file_for_their_address$(){
		 String checkpoint = "AM_Advise_customer_we_have_a_buried_wire_request_on_file_for_their_address$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_unable_to_send_filters$(){
		 String checkpoint = "AM_Advise_customer_unable_to_send_filters$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_program_$70_or_1170_before_their_ISP_number_to_disable_the_Call_Waiting_service$(){
		 String checkpoint = "AM_Advise_customer_to_program_$70_or_1170_before_their_ISP_number_to_disable_the_Call_Waiting_service$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_dial_3_until_reaches_end_of_message_and_then_dial_7_to_delete$(){
		 String checkpoint = "AM_Advise_customer_to_dial_3_until_reaches_end_of_message_and_then_dial_7_to_delete$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_contact_the_carrier_for_the_Dial_Around_code$(){
		 String checkpoint = "AM_Advise_customer_to_contact_the_carrier_for_the_Dial_Around_code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_contact_carrier_of_Dial_Around_Code$(){
		 String checkpoint = "AM_Advise_customer_to_contact_carrier_of_Dial_Around_Code$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_clear_messages_in_sub$extension_mailboxes$(){
		 String checkpoint = "AM_Advise_customer_to_clear_messages_in_sub$extension_mailboxes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_to_clear_messages_in_extension_mailboxes$(){
		 String checkpoint = "AM_Advise_customer_to_clear_messages_in_extension_mailboxes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_this_report_will_be_sent_for_further_analysis$(){
		 String checkpoint = "AM_Advise_customer_this_report_will_be_sent_for_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_this_is_not_an_active_account_and_this_report_is_being_closed(){
		 String checkpoint = "AM_Advise_customer_this_is_not_an_active_account_and_this_report_is_being_closed";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_they_have_Per_Line_Blocking$(){
		 String checkpoint = "AM_Advise_customer_they_have_Per_Line_Blocking$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_their_report_is_assigned_to_a_technician_and_confirm_the_commitment_with_the_customer$(){
		 String checkpoint = "AM_Advise_customer_their_report_is_assigned_to_a_technician_and_confirm_the_commitment_with_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_the_service_was_disconnected_through_the_completion_of_a_Service_order$(){
		 String checkpoint = "AM_Advise_customer_the_service_was_disconnected_through_the_completion_of_a_Service_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_the_service_was_disconnected_through_a_Service_order$(){
		 String checkpoint = "AM_Advise_customer_the_service_was_disconnected_through_a_Service_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_the_service_was_disconnected(){
		 String checkpoint = "AM_Advise_customer_the_service_was_disconnected";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_the_report_needs_further_analysis(){
		 String checkpoint = "AM_Advise_customer_the_report_needs_further_analysis";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_we_will_need_to_do_further_testing$(){
		 String checkpoint = "AM_Advise_customer_that_we_will_need_to_do_further_testing$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_we_are_sorry$$$http$$$espcare2$web$att$com$ESPCARE$_for_this_information(){
		 String checkpoint = "AM_Advise_customer_that_we_are_sorry$$$http$$$espcare2$web$att$com$ESPCARE$_for_this_information";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_trouble_determination$$$is_the_only_work_performed$(){
		 String checkpoint = "AM_Advise_customer_that_trouble_determination$$$is_the_only_work_performed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_there_is_no_900$976_block_message$(){
		 String checkpoint = "AM_Advise_customer_that_there_is_no_900$976_block_message$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_trouble_will_be_referred_to_further_analysis$(){
		 String checkpoint = "AM_Advise_customer_that_the_trouble_will_be_referred_to_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_trouble_will_be_referred_for_further_analysis$(){
		 String checkpoint = "AM_Advise_customer_that_the_trouble_will_be_referred_for_further_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_trouble_will_be_referred_for_analysis$(){
		 String checkpoint = "AM_Advise_customer_that_the_trouble_will_be_referred_for_analysis$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_test_call_through_ATT_completed$(){
		 String checkpoint = "AM_Advise_customer_that_the_test_call_through_ATT_completed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_PPU_Feature_is_not_available_in_their_area$(){
		 String checkpoint = "AM_Advise_customer_that_the_PPU_Feature_is_not_available_in_their_area$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_PIC_is_correct_and_further_isolation_is_needed$(){
		 String checkpoint = "AM_Advise_customer_that_the_PIC_is_correct_and_further_isolation_is_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_pager_notification_option_worked_correctly_on_the_test_call$(){
		 String checkpoint = "AM_Advise_customer_that_the_pager_notification_option_worked_correctly_on_the_test_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_order_is_not_complete(){
		 String checkpoint = "AM_Advise_customer_that_the_order_is_not_complete";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_the_operator_escape_option_worked_correctly_on_the_test_call$(){
		 String checkpoint = "AM_Advise_customer_that_the_operator_escape_option_worked_correctly_on_the_test_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_test_call_worked$(){
		 String checkpoint = "AM_Advise_customer_that_test_call_worked$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_problem_may_be_in_their_equipment$_Refer_to_CPE_ISO_and_NIQ_helpfiles$(){
		 String checkpoint = "AM_Advise_customer_that_problem_may_be_in_their_equipment$_Refer_to_CPE_ISO_and_NIQ_helpfiles$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_ATT_no_longer_supports_Collect_Calls$$$used_to_make_the_collect_call$(){
		 String checkpoint = "AM_Advise_customer_that_ATT_no_longer_supports_Collect_Calls$$$used_to_make_the_collect_call$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_Customer_that_a_new_order_is_needed$(){
		 String checkpoint = "AM_Advise_Customer_that_a_new_order_is_needed$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_a_computer_or_fax_is_calling_their_number_repeatedly$$$Business_Office$(){
		 String checkpoint = "AM_Advise_customer_that_a_computer_or_fax_is_calling_their_number_repeatedly$$$Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_a_computer_or_fax_is_calling_their_number_repeatedly$(){
		 String checkpoint = "AM_Advise_customer_that_a_computer_or_fax_is_calling_their_number_repeatedly$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_a_computer_or_fax_$$$Annoyance_Call_Bureau$(){
		 String checkpoint = "AM_Advise_customer_that_a_computer_or_fax_$$$Annoyance_Call_Bureau$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_that_$98_only_works_from_the_line_that_is_programmed_with_Voice_Mail$(){
		 String checkpoint = "AM_Advise_customer_that_$98_only_works_from_the_line_that_is_programmed_with_Voice_Mail$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_of_the_future_due_date$(){
		 String checkpoint = "AM_Advise_customer_of_the_future_due_date$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_of_reset_and_ask_customer$$$back_within_15_minutes$(){
		 String checkpoint = "AM_Advise_customer_of_reset_and_ask_customer$$$back_within_15_minutes$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_of_reset_and_ask_customer_to_hang_up_and_wait_one_minute_before_checking_if_indicator_is_reset$(){
		 String checkpoint = "AM_Advise_customer_of_reset_and_ask_customer_to_hang_up_and_wait_one_minute_before_checking_if_indicator_is_reset$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_of_future_due_date$(){
		 String checkpoint = "AM_Advise_customer_of_future_due_date$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_Customer_of_Collect_Call_Block_condition$(){
		 String checkpoint = "AM_Advise_Customer_of_Collect_Call_Block_condition$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_needs_to_be_transferred_to_the_business_office_for_a_new_order$(){
		 String checkpoint = "AM_Advise_customer_needs_to_be_transferred_to_the_business_office_for_a_new_order$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_needs_to_be_transferred_to_the_business_office_for_a_new_order(){
		 String checkpoint = "AM_Advise_customer_needs_to_be_transferred_to_the_business_office_for_a_new_order";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_ATT_does_not_perform_WireTap_checks_in_South_Carolina$(){
		 String checkpoint = "AM_Advise_customer_ATT_does_not_perform_WireTap_checks_in_South_Carolina$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_ATT_does_not_perform_Wire_Tap_checks_in_Florida$(){
		 String checkpoint = "AM_Advise_customer_ATT_does_not_perform_Wire_Tap_checks_in_Florida$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_customer_a_callback_is_needed_as_soon_as_possible_if_a_dispatch_is_required$(){
		 String checkpoint = "AM_Advise_customer_a_callback_is_needed_as_soon_as_possible_if_a_dispatch_is_required$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_cust_that_order_will_be_worked_by_end_of_day(){
		 String checkpoint = "AM_Advise_cust_that_order_will_be_worked_by_end_of_day";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_caller_that_additional_testing_is_needed_and_give_commitment$(){
		 String checkpoint = "AM_Advise_caller_that_additional_testing_is_needed_and_give_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Advise_business_office_that_report_will_be_dispatched_for_a_facilities_check_and_provide_commitment$(){
		 String checkpoint = "AM_Advise_business_office_that_report_will_be_dispatched_for_a_facilities_check_and_provide_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Account_Ported_to_ATT$(){
		 String checkpoint = "AM_Account_Ported_to_ATT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Account_is_TSP$_Advise_customer_of_the_commitment$(){
		 String checkpoint = "AM_Account_is_TSP$_Advise_customer_of_the_commitment$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_the_Escalation_Database(){
		 String checkpoint = "AM_Access_the_Escalation_Database";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_NCS_Commendation_Form(){
		 String checkpoint = "AM_Access_NCS_Commendation_Form";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_is_required_in_order_to_clear_your_trouble$commit_week$$$The_appointment_times$$$$Time$Which_one(){
		 String checkpoint = "AM_Access_is_required_in_order_to_clear_your_trouble$commit_week$$$The_appointment_times$$$$Time$Which_one";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_is_required_in_order_to_clear_your_trouble$$$The_appointment_times$$$Which_one(){
		 String checkpoint = "AM_Access_is_required_in_order_to_clear_your_trouble$$$The_appointment_times$$$Which_one";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_East_Demolition_form_to_send_an_email_for_the_customer$(){
		 String checkpoint = "AM_Access_East_Demolition_form_to_send_an_email_for_the_customer$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_Customer_Rules(){
		 String checkpoint = "AM_Access_Customer_Rules";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_Access_and_complete_DBAC_form_on_MMOnline_site$(){
		 String checkpoint = "AM_Access_and_complete_DBAC_form_on_MMOnline_site$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_vendor_meet_is_negotiated_after$(){
		 String checkpoint = "AM_A_vendor_meet_is_negotiated_after$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_Service_Order_is_needed_to_establish_an_alias_in_Voice_Mail_for_the_UM_or_Voice_Mail_number$(){
		 String checkpoint = "AM_A_Service_Order_is_needed_to_establish_an_alias_in_Voice_Mail_for_the_UM_or_Voice_Mail_number$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_Service_Order_is_needed_to_correct_the_trouble$_Refer_to_the_Business_Office$(){
		 String checkpoint = "AM_A_Service_Order_is_needed_to_correct_the_trouble$_Refer_to_the_Business_Office$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_Service_Order_is_needed_to_correct_the_trouble$(){
		 String checkpoint = "AM_A_Service_Order_is_needed_to_correct_the_trouble$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_new_commitment_cannot_be_set_until_the_reason_for_the_NAO_is_resolved(){
		 String checkpoint = "AM_A_new_commitment_cannot_be_set_until_the_reason_for_the_NAO_is_resolved";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_A_Callback_number_is_needed_to_complete$$$cancel_the_override_request$(){
		 String checkpoint = "AM_A_Callback_number_is_needed_to_complete$$$cancel_the_override_request$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_900$976_block_is_on_account$_Trouble_will_be_sent_to_RCMAC$(){
		 String checkpoint = "AM_900$976_block_is_on_account$_Trouble_will_be_sent_to_RCMAC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_2_Title(){
		 String checkpoint = "AM_2_Title";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$(){
		 String checkpoint = "AM_12_31_13_0730A_Available_for_Pickup$AP$_$DSG$08_30_12_0841A$$$Facility$HDF$_$DSG$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_11_06_06_1052A_Dispatched_Out_Craft_Loaded$HDDL$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_11_06_06_1052A_Dispatched_Out_Craft_Loaded$HDDL$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_11_02_08_1108P_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_11_02_08_1108P_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_27_08_1108P_No_Access$NA$_No_Access_Subscriber$PNA$(){
		 String checkpoint = "AM_10_27_08_1108P_No_Access$NA$_No_Access_Subscriber$PNA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_27_08_1008P_Dispatched_Out_Pre_assigned$HDDA$$$$Subscriber$PNA$(){
		 String checkpoint = "AM_10_27_08_1008P_Dispatched_Out_Pre_assigned$HDDA$$$$Subscriber$PNA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_25_08_1033P_Dispatched_Out$$$$HDDA$$$$NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_10_25_08_1033P_Dispatched_Out$$$$HDDA$$$$NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_20_08_1108P_No_Access$NA$$$$Subscriber$PNA$(){
		 String checkpoint = "AM_10_20_08_1108P_No_Access$NA$$$$Subscriber$PNA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_20_08_1108P_Craft_Loaded$IP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_10_20_08_1108P_Craft_Loaded$IP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_14_08_1222A$$$$HLD$$$$Miscellaneous_Z_Reports$MSC$(){
		 String checkpoint = "AM_10_14_08_1222A$$$$HLD$$$$Miscellaneous_Z_Reports$MSC$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_10_14_08_1222A_Pending_Pickup$PP$_No_Access_Other$PNO$(){
		 String checkpoint = "AM_10_14_08_1222A_Pending_Pickup$PP$_No_Access_Other$PNO$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_08_07_1000A$$$08_07_07_1129P$$$CO_Dispatch$POD$(){
		 String checkpoint = "AM_08_08_07_1000A$$$08_07_07_1129P$$$CO_Dispatch$POD$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_08_07_1000A_PP_POD_08_07_07_1129P_HDCP_POD(){
		 String checkpoint = "AM_08_08_07_1000A_PP_POD_08_07_07_1129P_HDCP_POD";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_08_07_1000A_Dispatched_In_Management_Review$HDCV$_NDC_CO_Dispatch$POD$(){
		 String checkpoint = "AM_08_08_07_1000A_Dispatched_In_Management_Review$HDCV$_NDC_CO_Dispatch$POD$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_08_07_1000A_Available_for_Pickup$AP$_NDC_CO_Dispatch$POD$08_07_07_1129P_Dispatched_In_Pending_Load$HDCP$_NDC_CO_Dispatch$POD$(){
		 String checkpoint = "AM_08_08_07_1000A_Available_for_Pickup$AP$_NDC_CO_Dispatch$POD$08_07_07_1129P_Dispatched_In_Pending_Load$HDCP$_NDC_CO_Dispatch$POD$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_07_07_1129P_Verify_Test_OK_Activation$VTK$_NDC_CO_Dispatch$POD$(){
		 String checkpoint = "AM_08_07_07_1129P_Verify_Test_OK_Activation$VTK$_NDC_CO_Dispatch$POD$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_07_07_1129P_No_Access$NA$_No_Access_Subscriber$PNA$(){
		 String checkpoint = "AM_08_07_07_1129P_No_Access$NA$_No_Access_Subscriber$PNA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_07_07_1129P_Dispatched_Out_Jeopardy$HDDJ$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_08_07_07_1129P_Dispatched_Out_Jeopardy$HDDJ$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_02_08_1052A_No_Access$NA$_No_Access_Other$PNO$(){
		 String checkpoint = "AM_08_02_08_1052A_No_Access$NA$_No_Access_Other$PNO$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_08_02_08_0850P_Dispatched_Out_Craft_Loaded$HDDL$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_08_02_08_0850P_Dispatched_Out_Craft_Loaded$HDDL$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_06_08_0850P_Hold$HLD$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_06_08_0850P_Hold$HLD$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_06_08_0850P_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_06_08_0850P_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_06_08_0850P_Auto_Test_Completed$ATC$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_06_08_0850P_Auto_Test_Completed$ATC$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_Pending_Pickup$AP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_Pending_Pickup$AP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_No_Access$NA$_No_Access_Subscriber$PNA$(){
		 String checkpoint = "AM_07_01_05_1052A_No_Access$NA$_No_Access_Subscriber$PNA$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_No_Access$NA$_No_Access_Other$PNO$(){
		 String checkpoint = "AM_07_01_05_1052A_No_Access$NA$_No_Access_Other$PNO$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_No_Access$NA$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_No_Access$NA$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_Dispatched_Out_Pre_assigned$HDDA$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_Dispatched_Out_Pre_assigned$HDDA$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_Available_for_Pickup$AP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_Available_for_Pickup$AP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_07_01_05_1052A_$NO$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_07_01_05_1052A_$NO$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_05_13_09_0527P_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_05_13_09_0527P_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_04_19_11_1033P_Dispatched_Out_Pre_assigned$HDDA$$$$Service$OCS$(){
		 String checkpoint = "AM_04_19_11_1033P_Dispatched_Out_Pre_assigned$HDDA$$$$Service$OCS$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_01_31_14_0209P_Not_Available_for_Pickup$NAP$$$$$POT$01_31_14_0209P_Verify_Test_OK_Activation$VTK$$$$Bucket$POT$(){
		 String checkpoint = "AM_01_31_14_0209P_Not_Available_for_Pickup$NAP$$$$$POT$01_31_14_0209P_Verify_Test_OK_Activation$VTK$$$$Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_01_30_07_1115A_Not_Available_for_Pickup$NAP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_01_30_07_1115A_Not_Available_for_Pickup$NAP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_01_30_07_1115A_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_01_30_07_1115A_Dispatched_out_Facility$HDF$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_$98_is_on_this_account_and_is_programmed_in_the_switch$(){
		 String checkpoint = "AM_$98_is_on_this_account_and_is_programmed_in_the_switch$";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_$_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$_3(){
		 String checkpoint = "AM_$_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$_3";
		 return getValueFromExcel(checkpoint);
		}
		public static String AM_$_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$(){
		 String checkpoint = "AM_$_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$";
		 return getValueFromExcel(checkpoint);
		}
		
		public static String AM_Advise_the_customer_that_the_trouble_will_be_cleared_by$$$access_to_the_NID(){
			 String checkpoint = "AM_Advise_the_customer_that_the_trouble_will_be_cleared_by$$$access_to_the_NID";
			 return getValueFromExcel(checkpoint);
			}
		
		public static String Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$(){
			 String checkpoint = "Ask_The_customer_has_already_been_given$$$customer_accept_this_commitment$";
			 return getValueFromExcel(checkpoint);
			}
	

	
	
	
	
//	public static String Ask_Yes = "Yes";
//	public static String Information_OK = "O";
//	public static String Submit_TankYou_OK = "OK";
//	public static String Ask_No = "No";
//	public static String AM_OK = "OK";
//	public static String Submit_AgMsg_No = "No";
//	public static String Submit_AgMsg_Yes = "Y";
//	public static String ThankYou_OK = "O";
//	public static String AM_Title = "Agent Message";
//	public static String Ask_Does_the_customer_demand_a_dispatch$ = "Does the customer demand a dispatch?";
//	public static String Ask_Does_customer_agree_to_charges$ ="Does customer agree to charges?";
//	public static String AM_Mr$Ms$Mrs_$last_name$$_you_do_have_the_option_of_notbus_SW = 
//			"Mr/Ms/Mrs (last name), you have the option of: -Repairing the trouble yourself. -Arranging for a contractor to do the repair work. -Or,"
//			+ " if you would like, ATT can complete this repair work and a charge will apply. $99 1st 30 minutes $40 each add'l 15 minutes.";
//	
//	public static String Ask_Does_the_customer_have$$$switch_on_their_telephone_set = "Does the customer have a pulse/tone switch on their telephone set?";
//	public static String Ask_Does_the_customer_have_a_pulse_tone_switch_on_their_telephone_set = "Does the customer have a pulse/tone switch on their telephone set?";
//	public static String Ask_Touchtone_service_is_not_on_the_customers_account = "Touchtone service is not on the customer's account. Does the customer want to order Touchtone service?";
//	public static String Ask_Are_you_calling_from_that_number_now$ = "Are you calling from that number now?";
//	
//	public static String AM_Online_transfer_to_MO_EB$$$800_499_7928$$$800_4997928 = "Online transfer to MO EB business office 800-499-7928. Educate the customer with 800-499-7928 for future reporting. Make a P2R referral if appropriate.";
//	public static String AM_Advise_the_customer_toswitchthephonetopulsesetting = "Advise the customer to switch the phone to pulse setting.";
//	public static String AM_I_would_like_to_assist_you_in_determining = "I would like to assist you in determining if the trouble is at your location or in your telephone equipment. "
//				+ "Are you interested in hearing the trouble-shooting steps?If the customer is interested, "
//				+ "select \"Isolate for CPE Trouble\" flow.";
//	
//	public static String AM_TT_has_been_added_to_the_customer$s_line_in_the_switch$ = 
//			"TT has been added to the customer's line in the switch.";
//	public static String Ask_Has_the_customer_had_their_vendor_out_to_isolate_the_trouble$ = 
//					"Has the customer had their vendor out to isolate thetrouble?";
//	public static String Ask_Service_Order_Activity_is_present$ = "Service Order Activity is present. Is the trouble being reported related to the service order? If reporting a feature, select \"No\".";
//	public static String Ask_Is_the_customer_calling_from_the_line_and_are_they_able_to_press_one_of_the_buttons_on_the_phone_that_is_not_working$
//			= "Is the customer calling from the line and are they able to press one of the buttons on the phone that is not working?";
//
//	public static String Ask_Did_you_hear_a_tone_when_the_customer_pressed_the_button$ 
//	                  = "Did you hear a tone when the customer pressed the button?";
//
//		
//	public static String Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones$
//			= "Ask the customer if the trouble is on all Phones?";
//
//	public static String Ask_Has_customer_checked_CPE_and$or_NID$ = "Has customer checked CPE and/or NID?";
//
//	public static String AM_Inform_the_customer_that_the_report_will_be_held_for_24hours$$$ICATS_process_withcustomer$ 
//	       = "Inform the customer that the report will be held for 24hours. Ensure understanding of ICATS process withcustomer.";
//							
//	public static String AM_Explain_that_ATT_s_responsibility_ends_at_the_D_Marc 
//	      = "Explain that AT&T's responsibility ends at the D-Marc.";
//	
//	public static String Ask_Please_verify_the_customer_name_and_address$$$address_correct$
//	       = "Please verify the customer's name and address.Is the customer's address correct?";
//
//	public static String Ask_Ask_the_customer_if_the_trouble_is_on_all_Phones
//	       = "Ask the customer if the trouble is on all Phones?";
//
//	public static String Ask_Has_customer_checked_CPE_and_or_NID = "Has customer checked CPE and/or NID?";
//	
//	public static String information_I_would_like_to_assist_you_in_determining$$$If_the_customer_is_interested_select_Willing_to_check
//	= "I would like to assist you in determining if the trouble is at your location or in your telephone equipment. Are you interested in hearing the trouble-shooting steps?If the customer is interested, select 'Willing to check'";

	
}
