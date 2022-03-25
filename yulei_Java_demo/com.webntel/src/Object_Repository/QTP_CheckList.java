package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Function_Libary.functions;

public class QTP_CheckList {

	public QTP_CheckList() {

	}
	public static String[] ChooseBox_MainMenu_MW 
	     = {"AT&T POTS Main Menu - Select One:",
			"Dial Tone","Can't Call Out","Voice Mail","Caller ID",
			 "Can't Be Called","Features","Transmission",
			 "Miscellaneous","Data","911","Physical"};

	 public static String[] ChooseBox_MainMenu_SW
		  = {"AT&T POTS Main Menu - Select One:",
				  "Dial Tone","Call Notes",
				  "Can't Call Out","Caller ID",
				 "Can't Be Called","Features","Transmission",
				 "Miscellaneous","Data","911","Physical"};

	 public static String[] ChooseBox_DialTone
	 	= {"Dial Tone - Select One:",
	 			  "No Dial Tone",
	    		  "Slow Dial Tone","No Dial Tone At Times",
	    		  "Can't Break Dial Tone",
			      "Beeping On Line"};
	 
	 public static String[] ChooseBox_Willing_To_Check
	 	= {"Will check trouble-shooting steps? - Select One:",
	 			"Willing to check","Not willing to check"};
	 
	 public static String[] ChooseBox_CPE_Isolation_Cats
	 			= {   "Which CPE Isolation method did you use?Select One:",
	 				  "CPE Isolation Email",
		    		  "Call Tree",
		    		  "Verbal CPE/NID Isolation",
		    		  "No Instructions Given"};
		      
	 public static String[] ChooseBox_CPE 
	 				= {"CPE Isolation - Select One:",
			          "Some Phones (SP)","Only has one phone/ all calls (OH1P/AC)",
		    		  "Only has one phone/ not all calls (OH1P/NOT AC)",
		    		  "All Phones Not All Calls (AP/NOT AC)",
		    		  "All Phones/All Calls (AP/AC)"};

	 public static String[] ChooseBox_Isolate_for_cpe 
	               = {"Select One:",
		    		  "Customer requests a Dispatch",
		    		  "Close with the Customer",
		    		  "Isolate for CPE Trouble"};

	 public static String[] ChooseBox_Premis_Wiring_Jack_Problem
	 			= {"What was the problem?Select One:",
		    		  "Premise Wiring/Jack",
		    		  "CPE Trouble",
		    		  "NID Trouble","Customer Requests Dispatch",
		    		  "Further Isolation Needed"};

	 public static String[] ChooseBox_Features_MW
		= {"POTS Features - Select One:"
				,"Call Forward"
				,"Speed Calling"
				,"Call Waiting"
				,"Automatic Callback (*69)"
				,"Three Way Call"
				,"Call Screening (*60)"
				,"Call Trace (*57)"
				,"Multi Ring"
				,"Repeat Dial(*66)"
				,"Privacy Manager"
				,"Call Control"
				,"Customer Control(*92)"
				,"Fast Forward Distinctive Ringing"
				,"Anonymous Call Rejection"
				,"Other Feature"};

	public static String[] ChooseBox_1$_or_Long_Distance
			= {"1+ or Long Distance - Select One:"
					,"500 Numbers"
					,"8XX Numbers (Toll Free)"
					,"900/976"
					,"Local"
					,"Long Distance"
					,"International"
					,"N11"
					};
	public static String[] ChooseBox_8XX_Numbers_$Toll_Free$
			= {"Select One:"
					,"All Phones"
					,"Only Has One Phone"
					,"Some Phones"};
	public static String[] ChooseBox_ACBNotWorking
			= {"Select One:"
					,"ACB Not Working"
					,"Reach Wrong Party"
					,"Wrong Party Keeps Calling"
					,"Customer Requests Blocking"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Wait
			= {"Select One:"
					,"Call Waiting"
					,"Call Waiting ID"};
	public static String[] ChooseBox_CBC_COIN
			= {"Coin Can't Be Called - Select One:"
					,"Can't Be Polled"
					,"Wrong ROL"
					,"CBC-Fast Busy, ROL, RNA or Busy"
					};
	public static String[] ChooseBox_CBC
			= {"Can't Be Called - Select One:"
					,"Gets Cut Off"
					,"Bell Rings Other Party" 
					,"Can't Be Called Collect"
					,"Busy When Dialed"
					,"Gets Call For Other Number" 
					,"Bell Rings One Time" 
					,"Hunting" 
					,"Fast Busy/Reorder"
					,"No ROL & Gets Fast Busy" 
					,"Bell Rings After Answer"
					,"Bell Doesn't Ring"
					,"Recording On Line"};
	public static String[] ChooseBox_CBC_Fast_Busy$_ROL$_RNA_or_Busy
			= {"Coin CBC-Fast Busy, ROL, RNA or Busy - Select One:"
					,"Fast Busy"
					,"ROL"
					,"RNA or Busy"};
	public static String[] ChooseBox_CCO
			= {"Can't Call Out - Select One:"
					,"All Numbers"
					,"Some Numbers"
					,"One Number"
					,"International"
					,"911"
					,"N11"
					,"500 Numbers"
					,"700 Numbers"
					,"8XX Numbers (Toll Free)"
					,"900/976"
					,"Operator, DA, Time, Other"};
	public static String[] ChooseBox_CCO_COIN
			= {"Coin Can't Call Out - Select One:"
					,"Can't Call 811"
					,"Other"
					,"Can't Call Long Distance"};
	public static String[] ChooseBox_CCO_HasDT_Recording_On_Line
			= {"Select One:"
					,"All Phones (AP)"
					,"Only Has One Phone (OH1P)"
					,"Some Phones (SP)"
					};
	public static String[] ChooseBox_Close_C$C_R_a_Dispatch
			= {"Select One:"
					,"Close with the Customer" 
					,"Customer requests a Dispatch"};
	public static String[] ChooseBox_DialTone_COIN
			= {"Coin Dial Tone - Select One:"
					,"Can't Break Dial Tone"
					,"No Dial Tone"
					};
	public static String[] ChooseBox_MainMenu_MW_COIN
			= {"AT&T COIN Main Menu - Select One:"
					,"Dial Tone"
					,"Can't Call Out"
					,"Can't Be Called"
					,"Transmission"
					,"911"
					,"Miscellaneous"};
	public static String[] ChooseBox_CCO_CTX
			= {"Centrex Can't Call Out - Select One:"
					,"Can't Call 811"
					,"Can't Call 911"
					,"1+ or Long Distance"
					,"No Dial Tone"
					,"Can't Break Dial Tone"
					,"Silence/Dead Air"
					,"Gets Cut Off"
					,"Gets Wrong Number"
					,"Busy/Fast Busy"
					};
	public static String[] ChooseBox_MainMenu_SNET_CTX
			= {"AT&T Centrex Main Menu - Select One:"
					,"Dial Tone" 
					,"Voice Mail"
					,"Can't Call Out" 
					,"Caller ID" 
					,"Can't Be Called" 
					,"Features" 
					,"Transmission" 
					,"Data" 
					,"Physical" 
					,"911" 
					,"Miscellaneous"
					};
	public static String[] ChooseBox_MainMenu_SW_CTX
			= {"AT&T Centrex Main Menu - Select One:"
					,"Dial Tone" 
					,"Call Notes"
					,"Can't Call Out" 
					,"Caller ID" 
					,"Can't Be Called" 
					,"Features" 
					,"Transmission"
					,"Data" 
					,"Physical" 
					,"911" 
					,"Miscellaneous"};
	public static String[] ChooseBox_Transmission_CTX
			= {"Centrex Transmission - Select One:"
					,"Roaring/Buzz/Hum/Static" 
					,"Hears Others On Line" 
					,"Crossed With Other Number"
					,"Can't Hear" 
					,"Can't Be Heard" 
					,"Hears Data on Line" 
					,"Other Noise" 
					};
	public static String[] ChooseBox_DATA
			= {"Data - Select One:"
					,"Can't Send"
					,"Can't Receive"
					,"Garbled Data"
					,"Gets Cut Off"
					,"Speed"
					};
	public static String[] ChooseBox_DATA_CannorReceive
			= {"Are you experiencing any problems when using the line for voice communications?"
					,"No"
					,"Yes"
					,"Unsure"
					};
	public static String[] ChooseBox_DialTone_CTX
			= {"Centrex Dial Tone - Select One:"
					,"No Dial Tone" 
					,"Slow Dial Tone" 
					,"No Dial Tone At Times" 
					,"Can't Break Dial Tone" 
					};
	public static String[] ChooseBox_DSL
			= {"Choose one:" 
					,"Customer reporting Data only trouble" 
					,"Customer reporting Voice only trouble" 
					,"Customer reporting both Voice and Data trouble" };
	public static String[] ChooseBox_Features_MW_CTX
			= {"Centrex Features Main Menu - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Call Transfer"
					,"Three Way/Conf Call/Consultation Hold"
					,"Call Hold"
					,"Call PickUp"
					,"Other"};
	public static String[] ChooseBox_Features_SNET
			= {"POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Miscalled Dialing (*69)"
					,"Three Way Call"
					,"Call Blocking(*60)"
					,"Call Trace (*57)"
					,"Priority Call Ringing(*61)"
					,"Star Ring"
					,"Call Again(*66)"
					,"Privacy Manager"
					,"Fast Forward Distinctive Ringing"
					,"Other Feature"
					,"Outgoing Call Control"};
	public static String[] ChooseBox_Features_SW
			= {"POTS Features - Select One:"
					,"Call Forward" 
					,"Speed Calling" 
					,"Call Waiting" 
					,"Call Return (*69)" 
					,"Three Way Call" 
					,"Call Blocker(*60)" 
					,"Call Trace (*57)" 
					,"Priority Call Ringing(*61)" 
					,"Personalized Ring" 
					,"Auto Redial(*66)"
					,"Privacy Manager" 
					,"Outgoing Call Control" 
					,"Fast Forward Distinctive Ringing"
					,"Anonymous Call Rejection" 
					,"Other Feature" 
					};
	public static String[] ChooseBox_Features_W
			= {"POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Call Return (*69)"
					,"Three Way Call"
					,"Call Blocking(*60)"
					,"Call Trace (*57)"
					,"Priority Call Ringing(*61)"
					,"Repeat Dial (*66)"
					,"Privacy Manager"
					,"Fast Forward Distinctive Ringing"
					,"Anonymous Call Rejection"
					,"Other Feature"};
	public static String[] ChooseBox_Has_Dial_Tone
			= {"Can't Call Out, All Numbers - Select One:"
					,"Busy/Fast Busy"
					,"Dead Air/Silence"
					,"Recording on Line"
					,"Gets Wrong Number"
					,"Can't Hear"
					,"Can't Be Heard"
					,"Gets Cut Off"
					,"Can't Break Dial Tone"
					,"Misc"
					};
	public static String[] ChooseBox_MISC_MW
			= {"Miscellaneous - Select One:"
					,"Foreman Call Back" 
					,"Customer Request Trouble History"
					,"Cord/Set Delivery" 
					,"Referrals" 
					,"Complaint/Commendation" 
					,"Billing Dispute" 
					,"Business Office Calling for Info" 
					,"Customer Wants to Cancel Closed Report" 
					,"PIC/LPIC Verification" 
					,"Busy/Un-busy Line - Business Only - Not Reporting Trouble" 
					,"Test Only" 
					,"Collect Calls" 
					,"Customer Wants Other Information" 
					,"Vendor Meet" 
					,"Non-AT&T CPE" 
					,"Other" 
					,"Hunting" 
					,"Bill Information" 
					,"Annoyance Calls" 
					,"Do Not Call List" 
					};
	public static String[] ChooseBox_MISC_W$SNET
			= {"Miscellaneous - Select One:"
					,"Foreman Call Back"
					,"Customer Request Trouble History"
					,"Referrals"
					,"Complaint/Commendation"
					,"Billing Dispute"
					,"Business Office Calling for Info"
					,"Customer Wants to Cancel Closed Report"
					,"PIC/LPIC Verification"
					,"Busy/Un-busy Line - Business Only - Not Reporting Trouble"
					,"Test Only"
					,"Collect Calls"
					,"Customer Wants Other Information"
					,"Vendor Meet"
					,"Non-AT&T CPE"
					,"Other"
					,"Hunting"
					,"Bill Information"
					,"Annoyance Calls"
					};
	public static String[] ChooseBox_MISC_COIN
			= {"Coin Miscellaneous - Select One:"
					,"PIC/LPIC"
					,"Test Only"
					,"Operator Not Identifying Payphone"
					,"Payphone Won't Collect or Return Coins"
					,"Payphone Gives Free Calls"
					,"Vendor Meet"
					,"Other"
					};
	public static String[] ChooseBox_MusicRadio
			= {"Music/Radio - Select One:"
					,"All phones/All calls"
					,"Only has one phone/Not all calls"
					,"All phones/Not all calls"
					,"Only has one phone/All calls"
					,"Some Phones"
					};
	public static String[] ChooseBox_No_Report_VMS_Trouble
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Mailbox Not Built"
					,"Multi-Ring and Voice Mail Trouble"
					};
	public static String[] ChooseBox_Other_Noise
			= {"Other Noise - Select One:"
					,"Music/Radio"
					,"CB/Ham Radio"
					,"Incoming Fax"
					,"Incoming Computer"
					,"Beeping On Line"
					};
	public static String[] ChooseBox_Special_Access
			= {"Special Access Instructions Select One:" 
					,"No Special Access Instructions" 
					,"Special Access Instructions-No Appointment Needed" 
					,"Special Access Instructions-Make Appointment"};
	public static String[] ChooseBox_Test_Only
			= {"Coin Test Only - Select One:"
					,"No Dial Tone"
					,"Can't Call Out"
					,"Transmission"
					,"Can't Be Called"
					,"Miscellaneous"
					};
	public static String[] ChooseBox_Trans_CBH
			= {"Music/Radio - Select One:"
					,"All phones/All calls"
					,"Only has one phone/Not all calls"
					,"All phones/Not all calls"
					,"Only has one phone/All calls"
					,"Some Phones"
					};
	public static String[] ChooseBox_Transmission
			= {"Transmission - Select One:"
					,"Roaring/Buzz/Hum/Static" 
					,"Hears Others On Line" 
					,"Crossed With Other Number"
					,"Can't Hear" 
					,"Can't Be Heard" 
					,"Hears Data on Line" 
					,"Music/Radio" 
					,"CB/Ham Radio" 
					,"Incoming Fax" 
					,"Incoming Computer" 
					,"Beeping On Line" 
					};
	public static String[] ChooseBox_Transmission_COIN
			= {"Coin Transmission - Select One:"
					,"Roaring/Buzz/Hum/Static"
					,"Can't Hear"
					,"Can't Be Heard"
					};
	public static String[] ChooseBox_VMS
			= {"Voice Mail - Select One:"
					,"Order Voice Mail Service"
					,"Report VMS Trouble"
					};
	public static String[] ChooseBox_911_MW
			= {"911 - Select One:" 
					,"Wrong Number (ANI) Appears at 911" 
					,"Wrong Address (ALI) Appears at 911" 
					,"Routes to Wrong 911" 
					,"Can't Call 911" 
					,"Release Information to PSAP" 
					,"PSAP/911 Circuit Trouble or 911 Outage"
					,"Calling 911 in Error" 
					,"Gas Leaks" 
					,"Emergency Call Trace or Hostage Situation"};
	public static String[] ChooseBox_PWJack$CPE
			= {"Centrex CPE - Select One:","Premise Wiring/Jack" 
					,"CPE Trouble" 
					};
	public static String[] ChooseBox_CFWD_CTX
			= {"Centrex Call Forward - Select One:","Call FWD Variable"
					,"Call FWD Don't Answer"
					,"Call FWD Busy Line"
					,"Customer Wants to Remove Feature"
					};
	public static String[] ChooseBox_911_COIN
			= {"Coin 911 Menu - Select One:"
					,"Routes to Wrong 911" 
					,"Misdirected Call from PSAP (Public Safety Answering Point)" 
					,"Vendor Reporting Can't Call Out 911"
					};
	public static String[] ChooseBox_Misdirected_Call_from_PSAP
			= {"Select One:"
					,"911 Outage"
					,"Emergency Call Trace Request"};
	public static String[] ChooseBox_CPE_CTX
			= {"CPE Isolation - Select One:","All Phones/All Calls" 
					,"Only has one phone/ not all calls (OH1P/NOT AC)" 
					,"All Phones Not All Calls (AP/NOT AC)" 
					,"Only has one phone/ all calls (OH1P/AC)" 
					,"Some Phones" 
					};
	public static String[] ChooseBox_CPE_Trans
			= {"Music/Radio - Select One:","All phones/All calls"
					,"Only has one phone/Not all calls"
					,"All phones/Not all calls"
					,"Only has one phone/All calls"
					,"Some Phones"
					};
	public static String[] ChooseBox_DoesNot_CPENID
			= {"Music/Radio trouble - Select One:","Purchase a noise filter/suppressor at any store"
					,"AT&T can isolate with possible charges"
					,"Customer can hire a vendor to isolate"
					,"If CB/Ham radio Cust can contact FCC"
					};
	public static String[] ChooseBox_Call_Wait_CTX
			= {"Centrex Call Wait - Select One:","Can't Answer"
					,"Low Tone"
					,"Gets Cut Off"
					,"Tone Not Heard"
					,"Customer Wants to Remove Feature"
					};
	public static String[] ChooseBox_Features_W_BUS
			= {"Business POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Call Return (*69)"
					,"Three Way Call"
					,"Call Blocking (*60)"
					,"Call Trace (57)"
					,"Priority Call Ringing (*61)"
					,"Repeat Dial"
					,"Privacy Manager"
					,"Fast Forward Distinctive Ringing"
					,"Other Feature"};
	public static String[] ChooseBox_Account
			= {"Is the account:"
					,"CONSUMER"
					,"BUSINESS"};
	public static String[] ChooseBox_U$verse
			= {"The account record indicates the customer subscribes to U-verse service. Determine if the customer is reporting Voice, U-verse, or both Voice and U-verse trouble."
					,"Customer reporting U-verse trouble only"
					,"Customer reporting Voice trouble only"
					,"Customer reporting both U-verse and Voice trouble"};
	public static String[] ChooseBox_FeatureProblem
			= {"Review the Billing Record and Service Orders. Is the customer paying for the feature?"
					,"Yes"
					,"No"
					,"Unsure"};
	public static String[] ChooseBox_Physical
			= {"Physical - Select One:","Premise Wire or Jack Trouble"
					,"Drop"
					,"Shock"
					,"Wire Tap"
					,"Property Damage (Inside/Outside)"
					,"Damaged Outside Plant (Cable/Pole/Terminal)"
					,"Network Interface Device"
					,"Request to Locate Cable"
					,"Defective CPE"
					};
	public static String[] ChooseBox_Service_Type
			= {"Service Type unknown. Please select one of the following:" 
					,"CONSUMER"
					,"BUSINESS"
					,"COIN"
					,"CENTREX"};
	public static String[] ChooseBox_MR
			= {"MR Main Menu - Select One:"
					,"Cable Cut"
					,"Pole Damage"
					,"Xbox Damage"
					,"Drop Down"
					,"Yard Damage"
					,"Other"
					,"Remove Drop"
					,"Bury/Cutover Drop"};
	public static String[] ChooseBox_Premise_Wire_or_Jack_Trouble
			= {"Premise Wire or Jack Trouble - Select One:","Premise Wire or Jack Trouble"
					,"Jack Install/Move/Rearrange"
					};
	public static String[] ChooseBox_No_Check_CPE
			= {"Physical - Select One:" ,"Close Report"
					,"Dispatch Report"
					};
	public static String[] ChooseBox_Drop
			= {"Drop - Select One:"
					,"Drop Down/Low"
					,"Buried Drop Cut"
					,"Buried Drop Needs Cutover"
					,"Temp Drop on Ground Needs Buried"
					,"Reroute/Move Drop Wire"
					,"Limb On Line"
					,"Tag Drop"};
	public static String[] ChooseBox_Property_Damage_Inside$Outside
			= {"Property Damage (Inside/Outside) - Select One:"
					,"Barricades/Cones"
					,"Debris/Equipment in Yard"
					,"Open Hole"
					,"Broken Sprinkler"
					,"Re-Sod Yard"
					,"Other Outside Problems"
					,"Inside Trouble"};
	public static String[] ChooseBox_Damaged_Outside_Plant_$Cable$Pole$Terminal$
			= {"Damaged Outside Plant (Cable/Pole/Terminal) - Select One:"
					,"Cable Down/Low"
					,"Cable Cut"
					,"Move Cable"
					,"Terminal Damaged"
					,"Pole Damaged"
					,"Guy Wire Broken"
					,"Power Line On Cable"};
	public static String[] ChooseBox_Network_Interface_Device
			= {"Network Interface Device - Select One:","Install NID"
					,"Move NID"
					,"Repair NID"
					};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SW
			= {"Report VMS Trouble - Select One:","Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Personalized Ring and Voice Mail Trouble"
					};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SNET
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Mailbox Not Built"
					,"Star Ring and Voice Mail Trouble"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_W
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Mailbox Not Built"};
	public static String[] ChooseBox_Hunting
			= {"Hunting - Select One:","Hunting to Wrong Number"
					,"Not Hunting"
					};
	public static String[] ChooseBox_CallScreen_POTS
			= {"Select One:"
					,"Still Receives Calls After Activation"
					,"Can't Activate or Deactivate"
					,"Doesn't Understand Announcement"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_CallerID_CTX
			= {"Caller ID - Select One:"
					,"Caller ID"
					,"Caller ID With Name"
					,"Call Waiting ID"
					,"Caller ID Blocking"
					,"Wrong Name Displaying"};
	public static String[] ChooseBox_Caller_ID_Blocking
			= {"Caller ID Blocking - Select One:"
					,"Per Line Blocking"
					,"Per Call Blocking (*67)"};
	public static String[] ChooseBox_Talking_Call_Waiting
			= {"Select One:"
					,"Can't Answer"
					,"Low or Weak Tone"
					,"Gets Cut Off"
					,"Can't Cancel Call Waiting"
					,"Tone Not Heard"
					,"Customer Wants to Remove Feature"
					,"Talking Call Waiting - Name Not Heard"};
	public static String[] ChooseBox_Closing_Code
			= {"Select One:"
					,"REFBO"
					,"DBAC"};
	public static String[] ChooseBox_Priority_Call_Ring
			= {"Select One:"
					,"Unable to activate"
					,"Unable to add telephone numbers to list"
					,"No difference in ringing pattern"
					,"Customer wants to remove feature"};
	public static String[] ChooseBox_Some_Number_CCO
			= {"Select One:"
					,"500 Numbers"
					,"700 Numbers"
					,"8XX Numbers (Toll Free)"
					,"900/976"
					,"Local or Long Distance"
					,"International"
					,"Misc"
					,"911"
					,"N11"};
	public static String[] ChooseBox_N11
			= {"Can't Call N11 - Select One:"
					,"211"
					,"311"
					,"411"
					,"511"
					,"711"
					,"811"};
	public static String[] ChooseBox_411
			= {"Select One:"
					,"All Phones (AP)"
					,"Only Has One Phone (OH1P)"
					,"Some Phones (SP)"};
	public static String[] ChooseBox_3_Way_Call_POTS
			= {"Select One:"
					,"Not Working"
					,"Not Hearing second Dial Tone"
					,"Customer Requests Blocking"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_PPU
			= {"Select One:"
					,"Customer Reporting Block Not Working"
					,"Customer Reporting PPU Feature Not Working"};
	public static String[] ChooseBox_CPE_and$or_NID
			= {"","Premise Wiring/Jack"
					,"CPE Trouble"
					,"NID Trouble"
					,"Customer Requests Dispatch"
					,"Further Isolation Needed"};
	public static String[] ChooseBox_900$976
			= {"Select the problem with 900/976:"
					,"Can Dial and Should Be Blocked"
					,"Can't Dial"};
	public static String[] ChooseBox_CCO_Intra
			= {"Is the call INTRA LATA or Local?"
					,"INTRA-LATA"
					,"LOCAL"};
	public static String[] ChooseBox_CCO_Misc
			= {"Can't Call - Select One:"
					,"Operator"
					,"Directory Assistance"
					,"Time"
					,"Other"};
	public static String[] ChooseBox_Call_Forward_cg
			= {"Call Forward Trouble - Select One:"
					,"Not Working"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Forward
			= {"Call Forward - Select One:"
					,"Call Forward Variable"
					,"Call FWD Don't Answer"
					,"Call FWD Busy Line"
					,"Remote Call FWD"
					,"Remote Access Call FWD"
					,"Customer Wants to Remove Feature"
					,"Multiple Simultaneous Call FWD Don't Answer"
					,"Multiple Simultaneous Call FWD Busy Line"};
	public static String[] ChooseBox_Call_Forward_W$SW
			= {"Call Forward - Select One:"
					,"Call Forward Variable"
					,"Call FWD Don't Answer"
					,"Call FWD Busy Line"
					,"Remote Call FWD"
					,"Remote Access Call FWD"
					,"Selective Call Forward"
					,"Customer Wants to Remove Feature"
					,"Multiple Simultaneous Call FWD Don't Answer"
					,"Multiple Simultaneous Call FWD Busy Line"};
	public static String[] ChooseBox_Call_Forward_SNET
			= {"Call Forward - Select One:"
					,"Call Forward Variable"
					,"Call FWD Don't Answer"
					,"Call FWD Busy Line"
					,"Remote Call FWD"
					,"Follow Me Service"
					,"Priority Call Forward"
					,"Customer Wants to Remove Feature"
					,"Multiple Simultaneous Call FWD Don't Answer"
					,"Multiple Simultaneous Call FWD Busy Line"};
	public static String[] ChooseBox_Call_Forward_RACF
			= {"RACF - Select One:"
					,"Forgot PIN"
					,"Can't Activate or Deactivate"
					,"Forgot RACF/RADN Number"
					,"RACF Access Number Busy/Ring No Answer"};
	public static String[] ChooseBox_Multi_Ring_MW
			= {"Select One:"
					,"Not Receiving Calls/Gets Intercept"
					,"No Difference in Ringing Pattern"
					,"Wrong Ring Pattern"
					,"Multi Ring Calls Transfer with Main Number"
					,"Multi Ring Won't Forward with Main Number"
					,"Gets Generic Voice Mail Greeting when Multi Ring # is Called"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Multi_Ring_SNET
			= {"Select One:"
					,"Not Receiving Calls/Gets Intercept"
					,"No Difference in Ringing Pattern"
					,"Wrong Ring Pattern"
					,"Star Ring Calls Transfer with Main Number"
					,"Star Ring Won't Forward with Main Number"
					,"Gets Generic Voice Mail Greeting when Star Ring # is Called"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Multi_Ring_SW
			= {"Select One:"
					,"Not Receiving Calls/Gets Intercept"
					,"No Difference in Ringing Pattern"
					,"Wrong Ring Pattern"
					,"Personalized Ring Calls Transfer with Main Number"
					,"Personalized Ring Won't Forward with Main Number"
					,"Gets Generic Voice Mail Greeting when Personalized Ring # is Called"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_No_Check_CPE$NID
			= {"Music/Radio trouble - Select One:"
					,"Purchase a noise filter/suppressor at any store"
					,"AT&T can isolate with possible charges"
					,"Customer can hire a vendor to isolate"
					,"If CB/Ham radio Cust can contact FCC"};
	public static String[] ChooseBox_CPE_CTX_Tran
			= {"Select One:"
					,"All phones/All calls"
					,"Some Phones"};
	public static String[] ChooseBox_CallerID_MW
			= {"Caller ID - Select One:"
					,"Caller ID"
					,"Caller ID With Name"
					,"Call Waiting ID"
					,"Caller ID Blocking"
					,"Talking Call Waiting"
					,"Wrong Name Displaying"};
	public static String[] ChooseBox_SpeedCall_cg_Lite
			= {};
	public static String[] ChooseBox_MultiRing_MW_Lite
			= {};
	public static String[] ChooseBox_MultiRing_SNET_Lite
			= {};
	public static String[] ChooseBox_AR_cg_Lite
			= {};
	public static String[] ChooseBox_CallControl_cg_Lite
			= {};
	public static String[] ChooseBox_Call_Wait_Lite
			= {};
	public static String[] ChooseBox_Call_Wait_cg_Lite
			= {};
	public static String[] ChooseBox_Call_Wait_SNET_cg_Lite
			= {};
	public static String[] ChooseBox_AR_cg
			= {"Anonymous Call Rejection - Select One:"
					,"Not Working"
					,"Feature Interaction"
					,"Education"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Wait_MW
			= {"Select One:"
					,"Call Waiting"
					,"Call Waiting ID"
					,"Talking Call Waiting"};
	public static String[] ChooseBox_Call_Wait_cg
			= {"Select One:"
					,"Can't Answer"
					,"Low or Weak Tone"
					,"Gets Cut Off"
					,"Can't Cancel Call Waiting"
					,"Tone Not Heard"
					,"Customer Wants to Remove Feature"
					,"Talking Call Waiting - Name Not Heard"};
	public static String[] ChooseBox_Customer_Control
			= {"*92 Customer Control - Select One:"
					,"Can't Activate or Deactivate"
					,"Calls Not Going to Voice Mail Box"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_DR
			= {"Select One:"
					,"Distinctive Ringing Not Working"
					,"FastForward Problem"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Temporary$Permanent_Drop_Move_Lite
			= {};
	public static String[] ChooseBox_Call_Forward_MW_Lite
			= {};
	public static String[] ChooseBox_Call_Forward_SNET_Lite
			= {};
	public static String[] ChooseBox_Call_Forward_RACF_Lite
			= {};
	public static String[] ChooseBox_PCR_Lite
			= {};
	public static String[] ChooseBox_RD_Lite
			= {};
	public static String[] ChooseBox_Features_MW_BUS
			= {"Business POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Automatic Callback (*69)"
					,"Three Way Call"
					,"Call Screening (*60)"
					,"Call Trace (57)"
					,"Multi Ring"
					,"Repeat Dial (*66)"
					,"Privacy Manager"
					,"Customer Control (*92)"
					,"Fast Forward Distinctive Ringing"
					,"Other Feature"};
	public static String[] ChooseBox_911_SW
			= {"911 - Select One:" 
					,"Wrong Number (ANI) Appears at 911" 
					,"Wrong Address (ALI) Appears at 911" 
					,"Routes to Wrong 911" 
					,"Can't Call 911" 
					,"Release Information to PSAP" 
					,"PSAP/911 Circuit Trouble or 911 Outage"
					,"Calling 911 in Error" 
					,"Gas Leaks" 
					,"Emergency Call Trace or Hostage Situation"};
	public static String[] ChooseBox_Call_Control
			= {"Select One:"
					,"OCC Not Working" 
					,"Lost/Forgotten PIN" 
					,"Voice Mail Visual or Stutter Dial Tone is Not Working" 
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Speed_Calling
			= {"Speed Calling Type - Select One:"
					,"Speed Call 30" 
					,"Speed Call 8"};
	public static String[] ChooseBox_Speed_Calling_cg
			= {"Speed Calling Trouble - Select One:"
					,"Not Working"
					,"Can't Program Certain Numbers"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_PRIV
			= {"Privacy Manager - Select One:"
					,"Not Working"
					,"Not displaying \"Privacy Manager\""
					,"Trouble with Access Code"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_PRIV_TWAC
			= {"Trouble with Access Code - Select One:"
					,"Can't Call Access Code Activation Number"
					,"Can't Establish/Change/Delete Access Code"
					,"Access Code Doesn't Work"
					,"Caller ID Doesn't Alert - PIN PVM call"
					,"PIN Activation VRU says \"Calling from invalid PVM Line\""};
	public static String[] ChooseBox_PRIV_Not_MW
			= {"Privacy Manager - Select One:"
					,"Not Working"
					,"Not displaying \"Privacy Manager\""
					,"Trouble with Access Code"
					,"Customer Wants to Remove Feature"
					,"Trouble with PIN"};
	public static String[] ChooseBox_211$811
			= {"Can't Call 811 - Select One:"
					,"All Phones (AP)"
					,"Only Has One Phone (OH1P)"
					,"Some Phones (SP)"};
	public static String[] ChooseBox_811
			= {"811 - Select One:"
					,"Calling 811 in error"
					,"Routes to Wrong 811 One Center"
					,"Can't Call 811"
					,"Other"};
	public static String[] ChooseBox_Transmission_CBH_CTX
			= {"Select One:" 
					,"All phones/All calls"
					,"Some Phones"};
	public static String[] ChooseBox_Subs_Choice
			= {"Has the customer's equipment been checked? Please make a single choice:" 
					,"No, customer needs further instruction"
					,"Yes, customer checked equipment and wants dispatch"
					,"Yes, customer checked equipment, service is working"};
	public static String[] ChooseBox_Subs_Choice_0
			= {"Now that you have provided further instruction, what does the customer want to do? Please make a single choice:" 
					,"Continue to hold report"
					,"Wants dispatch"
					,"Wants to cancel report"};
	public static String[] ChooseBox_Subs_Choice_1
			= {"What does the customer want to do? Please make a single choice:"
					,"Continue to hold report"
					,"Wants to cancel report"};
	public static String[] ChooseBox_MainPhysical
			= {"Physical - Select One:" 
					,"Premise Wire or Jack Trouble"
					,"Drop"
					,"Shock"
					,"Wire Tap"
					,"Property Damage (Inside/Outside)"
					,"Damaged Outside Plant (Cable/Pole/Terminal)"
					,"Network Interface Device"
					,"Request to Locate Cable"};
	public static String[] ChooseBox_Phy_CPT
			= {"Damaged Outside Plant (Cable/Pole/Terminal) - Select One:"
					,"Cable Down/Low"
					,"Cable Cut"
					,"Move Cable"
					,"Terminal Damaged"
					,"Pole Damaged"
					,"Guy Wire Broken"
					,"Power Line On Cable"};
	public static String[] ChooseBox_Serv_Unknown
			= {"Service Type unknown. Please select one of the following:"
					,"CONSUMER"
					,"BUSINESS"
					,"COIN"
					,"CENTREX"};
	public static String[] ChooseBox_Redirect
			= {"Is the account:"
					,"CONSUMER"
					,"BUSINESS"};
	public static String[] ChooseBox_Class_Of_Service
			= {"Review the record and determine the Class of Service:"
					,"Res POTS"
					,"Bus POTS"
					,"Centrex"
					,"Coin"};
	public static String[] ChooseBox_Pur_a_noise
			= {"Music/Radio trouble - Select One:"
					,"Purchase a noise filter/suppressor at any store"
					,"Customer can hire a vendor to isolate"
					,"If CB/Ham radio Cust can contact FCC"
					,"AT&T can isolate with possible charges"};
	public static String[] ChooseBox_Call_Forward_CTX
			= {"Centrex Call Forward - Select One:"
					,"Call FWD Variable"
					,"Call FWD Don't Answer"
					,"Call FWD Busy Line"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Hold_CTX
			= {"Centrex Call Hold - Select One:"
					,"Parties Get Cut Off"
					,"Not Hearing 2nd Dial Tone"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Pick_Up_CTX
			= {"Centrex Call Pickup - Select One:"
					,"Customer Unable to Answer Call"
					,"Parties Get Cut Off"
					,"Not Hearing 2nd Dial Tone"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Call_Trans_CTX
			= {"Centrex Call Transfer - Select One:"
					,"Call Transfer (within their Centrex System)"
					,"Deluxe Call Transfer/Transfer Call Disconnect (within or outside their Centrex System)"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Speed_Call_CTX
			= {"Speed Calling Trouble - Select One:"
					,"Not Working"
					,"Can't Program"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Speed_Call_No_CTX
			= {"Centrex Speed Calling Type - Select One:"
					,"Speed Calling 8"
					,"Speed Calling 30"
					,"Other Speed Calling Type"};
	public static String[] ChooseBox_Call_Wait_2but
			= {"Select One:"
					,"Call Waiting"
					,"Call Waiting ID"};
	public static String[] ChooseBox_Anonymous
			= {"Anonymous Call Rejection - Select One:"
					,"Not Working"
					,"Feature Interaction"
					,"Customer Wants to Remove Feature"
					,"Education"};
	public static String[] ChooseBox_Call_Wait1
			= {"Select One:"
					,"Call Waiting"
					,"Call Waiting Deluxe"
					,"Talking Call Waiting"};
	public static String[] ChooseBox_Other_Feat
			= {"Review the Billing Record and Service Orders. Is the customer paying for the feature?"
					,"Yes"
					,"No"
					,"Unsure"};
	public static String[] ChooseBox_Other_Feat2
			= {"Use QVF to verify that the feature is in translations. Is the feature in translations?"
					,"Yes"
					,"No"
					,"Unsure"};
	public static String[] ChooseBox_3WayConf_CTX
			= {"Centrex Three Way/Conf Call/Consultation Hold - Select One:"
					,"Parties Get Cut Off"
					,"Not Hearing 2nd Dial Tone"
					,"Can't Connect Parties"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_AutoCallback
			= {"Select One:"
					,"ACB Not Working"
					,"Reach Wrong Party"
					,"Wrong Party Keeps Calling"
					,"Customer Requests Blocking"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_RepeatDial
			= {"Touchtone - Select One:"
					,"Not Working"
					,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_Caller_ID_Not_MW
			= {"Caller ID - Select One:"
					,"Caller ID"
					,"Caller ID With Name"
					,"Call Waiting"
					,"Caller ID Blocking"
					,"Wrong Name Displaying"};
	public static String[] ChooseBox_900_976_2b
			= {"Select the problem with 900/976:"
					,"Can dial and should be blocked"
					,"Can't dial"};
	public static String[] ChooseBox_CBC_hunt_CTX
			= {"Hunting - Select One:"
					,"Hunting to Wrong Number"
					,"Not Hunting"};
	public static String[] ChooseBox_211$811_CTX
			= {"N11 Trouble - Select One:"
					,"All Phones"
					,"Only Has One Phone"
					,"Some Phones"};
	public static String[] ChooseBox_N11_CTX
			= {"N11 - Select One:"
					,"211"
					,"311"
					,"411"
					,"511"
					,"711"};
	public static String[] ChooseBox_CallerID_bg
			= {"Caller ID Blocking - Select One:"
					,"Per Line Blocking"
					,"Per Call Blocking (*67)"};
	public static String[] ChooseBox_Call_Tran2
			= {"Call Transfer Trouble - Select One:"
					,"Parties Get Cut Off"
					,"Not Hearing 2nd Dial Tone"
					,"Other"
					,"Customer Unable to Connect Transfer"};
	public static String[] ChooseBox_CCO_Intra_CTX
			= {"Is the call INTRA-LATA or Local?"
					,"LOCAL"
					,"INTRA-LATA"};
	public static String[] ChooseBox_Misc_BillDis
			= {"Please select One from the list:"
					,"Calls Not Made"
					,"Charge from Dispatch"};
	public static String[] ChooseBox_Misc_BillDis_CNM
			= {"Please select One from the list:"
					,"Customer is Calling"
					,"Business Office is Calling"};
	public static String[] ChooseBox_Misc_2PD
			= {"Please select one from the list:"
					,"2PD Request"
					,"Request History"};
	public static String[] ChooseBox_Misc_piclpic
			= {"PIC/LPIC Verification - Select One:"
					,"Customer Request"
					,"Business Office Request"
					,"Carrier Request"};
	public static String[] ChooseBox_Misc_AC
			= {"Please select One from the list:"
					,"Fax/Computer Calls"
					,"ALIT (Half ring received in evening)"
					,"Unwanted/Harassment Calls"};
	public static String[] ChooseBox_CPE_iso2
			= {"","Premise Wiring/Jack"
					,"CPE Trouble"
					,"NID Trouble"
					,"Customer Requests Dispatch"
					,"Further Isolation Needed"};
	public static String[] ChooseBox_Caller_ID_Lite
			= {};
	public static String[] ChooseBox_Customer_Control_Lite
			= {};
	public static String[] ChooseBox_Call_Trace_Lite
			= {};
	public static String[] ChooseBox_Dist_Ring_Lite
			= {};
	public static String[] ChooseBox_3_Way_Call_Lite
			= {};
	public static String[] ChooseBox_Call_Screen_Lite
			= {};
	public static String[] ChooseBox_CCO_POTS
			= {"Select One:"
					,"500 Numbers"
					,"700 Numbers"
					,"8XX Numbers (Toll Free)"
					,"900/976"
					,"Local or Long Distance"
					,"International"
					,"Misc"
					,"911"
					,"N11"};
	public static String[] ChooseBox_CustWantsDISP
			= {"PBX Dispatch - Select One:"
					,"Customer wants DISP"
					,"Customer does not want DISP"};
	public static String[] ChooseBox_CCO_Number_POTS
			= {"Can't Call Out - Select One:"
					,"All Numbers"
					,"Some Numbers"
					,"One Number"};
	public static String[] ChooseBox_Features_SNET_BUS
			= {"Business POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Miscalled Dialing (*69)"
					,"Three Way Call"
					,"Call Blocking(*60)"
					,"Priority Call Ringing(*61)"
					,"Star Ring"
					,"Call Again (*66)"
					,"Privacy Manager"
					,"Fast Forward Distinctive Ringing"
					,"Other Feature"
					,"Outgoing Call Control"};
	public static String[] ChooseBox_Features_SW_BUS
			= {"Business POTS Features - Select One:"
					,"Call Forward"
					,"Speed Calling"
					,"Call Waiting"
					,"Call Return (*69)"
					,"Three Way Call"
					,"Call Blocker (*60)"
					,"Priority Call Ringing(*61)"
					,"Personalized Ring"
					,"Auto Redial (*66)"
					,"Fast Forward Distinctive Ringing"
					,"Other Feature"
					,"Outgoing Call Control"};
	public static String[] ChooseBox_Operator_DA_TimeOther
			= {"Can't Call - Select One:"
					,"Operator"
					,"Directory Assistance"
					,"Other"
					,"Time"};
	public static String[] ChooseBox_LDTMS_Recording$
			= {"Recording on Line - Select One:"
					,"Recording # 1-2-8-9-10-13-14-22"
					,"Recording # 11 or 19"
					,"Recording # 16"
					,"Recording # 18"
					,"Recording # 3-4-5"
					,"Recording # 6 or 12"
					,"Recording # 7-15-17"
					,"Recording Unknown"
					,"Local/Other Recording"};
	public static String[] ChooseBox_LDTMS_Check_the_Chalkboard
			= {"Check the Chalkboard for a Switch Trunk Outage that would affect this call - Select One:"
					,"Long Distance Trunk Outage"
					,"Local Trunk Outage"
					,"No Trunk Outage"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SNET_UM
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Web Issues (email/fax/wireless messages)"
					,"Star Ring and Voice Mail Trouble"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SW_UM
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Web Issues (email/fax/wireless messages)"
					,"Personalized Ring and Voice Mail Trouble"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_MW_UM
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Web Issues (email/fax/wireless messages)"
					,"Multi-Ring and Voice Mail Trouble"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_W_UM
			= {"Report VMS Trouble - Select One:"
					,"Education Requested"
					,"Password Problems"
					,"Ring Cycle Change"
					,"Can't Retrieve Messages"
					,"Can't Delete Messages"
					,"Callers Get Generic Greeting"
					,"Calls Go Directly Into Voice Mail"
					,"User Guide Requested"
					,"Trouble With Message Waiting Indicator"
					,"Call Transfer to Attendant (Operator Escape) - BUS Only"
					,"Pager Notification"
					,"Calls Not Forwarding to Voice Mail"
					,"*98 Access Not Working"
					,"Other VMS Trouble"
					,"Web Issues (email/fax/wireless messages)"};
	public static String[] ChooseBox_Foreman_Call_Back
			= {"Foreman Callback Related to - Select One:"
					,"Technician Commendation or Complaint"
					,"Service Issue"};
	public static String[] ChooseBox_Transmission_CH_CBH
			= {"Select the appropriate trouble:"
					,"No Dial Tone"
					,"Can't Call Out"
					,"Can't Be Called"};
	public static String[] ChooseBox_InstallNIDChoose_MW
			= {"Select One:"
					,"Customer Will Check Further For NID"
					,"Needs NID Installed"};
	public static String[] ChooseBox_CBC_DEACTIVATE_FW
			= {"Did call forward deactivation resolve the trouble?" 
					,"Trouble resolved"
					,"Trouble not resolved" 
					,"Customer needs to verify"};
	public static String[] ChooseBox_Caller_ID_W
			= {"Caller ID - Select One:"
					,"Caller ID With Name"
					,"Call Waiting ID"
					,"Caller ID Blocking"
					,"Wrong Name Displaying"};
	public static String[] ChooseBox_CFW_CUSTOMER_REPORTING
			= {"Customer Reporting - Select One:"
					,"Can't Be Called-Busy"
					,"Can't Be Called-Dead Air"
					,"Can't Be Called-Ring No Answer"
					,"Can't Be Called-Recording on Line"
					,"Can't Be Called-Gets Wrong Number"
					,"Request to change CFN"};
	public static String[] ChooseBox_No_Message_Waiting_Indicator_VMS
			= {"No MWI - Select One:"
					,"Message Waiting Works At Times"
					,"Message Waiting Stopped Working"
					,"Message Waiting Never Worked"};
	public static String[] ChooseBox_Cant_Call_8XX_$Toll_Free$
			= {"Can't Call 8XX (Toll Free) - Select One:"
					,"All Phones (AP)"
					,"Only Has One Phone (OH1P)"
					,"Some Phones (SP)"};
	public static String[] ChooseBox_CBC_CTX
			= {"Centrex Can't Be Called - Select One:"
					,"Gets Cut Off"
					,"Bell Rings Other Party" 
					,"Can't Be Called Collect"
					,"Busy When Dialed"
					,"Gets Call For Other Number" 
					,"Bell Rings One Time" 
					,"Hunting" 
					,"Fast Busy/Reorder"
					,"No ROL & Gets Fast Busy" 
					,"Bell Rings After Answer"
					,"Bell Doesn't Ring"
					,"Recording On Line"};
	public static String[] ChooseBox_500_8xx_900$976_Trouble
			= {"500/8XX/900-976 Trouble - Select One:"
					,"All Phones"
					,"Only Has One Phone"
					,"Some Phones"};
	public static String[] ChooseBox_CCO_HasDT_Recording_On_Line_CPE
			= {"CPE Isolation - Select One:"
					,"All Phones (AP)"
					,"Only Has One Phone (OH1P)"
					,"Some Phones (SP)"};
	public static String[] ChooseBox_Multi$Ring_Transfer_to_VM
			= { "Multi-Ring Trouble - Select One:"
					,"Multi-Ring Transfer to VM"
					,"Multi-Ring Gets Generic Greeting"
					,"Multi-Ring Won't Transfer to VM"};
	public static String[] ChooseBox_Star_Ring_Trouble_to_VM
			= {"Star Ring Trouble - Select One:"
					,"Star Ring Transfer to VM"
					,"Star Ring Gets Generic Greeting"
					,"Star Ring Won't Transfer to VM"};
	public static String[] ChooseBox_98_Trouble_to_VM
			= {"*98 Trouble - Select One:"
					,"ROL"
					,"Wrong Number /Mailbox"
					,"Busy, Reorder"
					,"Generic Greeting"};
	public static String[] ChooseBox_Type_of_MWI
			= {"Type of MWI - Select One:"
					,"Audible Message Waiting Indicator"
					,"Visual Message Waiting Indicator"};
	public static String[] ChooseBox_MWI_Trouble
			= {"MWI Trouble - Select One:"
					,"Message Waiting Indicator Stuck on with No Messages"
					,"No Message Waiting Indicator"};
	public static String[] ChooseBox_Personalized_Ring_Trouble
			= {"Personalized Ring Trouble - Select One:"
					,"Personalized Ring Transfer to VM"
					,"Personalized Ring Won't Transfer to VM"
					,"Personalized Ring Gets Generic Greeting"};
	public static String[] ChooseBox_PRIV_TWPIC
			= {"Trouble With PIN - Select One:","Customer Forgot PIN"
					,"PIN Not Working"
					};
	public static String[] ChooseBox_CallerID_se
			= {"Caller ID Blocking - Select One:","Per Line Blocking"
					,"Calling Number Delivery Block (*67)"
					};
	public static String[] ChooseBox_Caller_ID_SW
			= {"Caller ID - Select One:","Caller ID"
					,"Caller ID With Name"
					,"Call Waiting ID"
					,"Caller ID Blocking"
					,"Wrong Name Displaying"
					};	
	
	public static String[] ChooseBox_NDC_ID_request
		= {"Select if the request was:"
				,"Approved"
				,"Rejected"};
	public static String[] ChooseBox_Feature_SE_Bus
		= {"Business POTS Features - Select One:"
				,"Call Forward"
				,"Speed Calling"
				,"Call Waiting"
				,"Automatic Callback(*69)"
				,"Three Way Call"
				,"Call Block(*60)"
				,"Call Selector(*61)"
				,"Ringmaster"
				,"Repeat Dial(*66)"
				,"Other Feature"};
	public static String[] ChooseBox_Feature_SE
		= {"POTS Features - Select One:"
				,"Call Forward" 
				,"Speed Calling" 
				,"Call Waiting" 
				,"Call Return (*69)" 
				,"Three Way Call" 
				,"Call Block(*60)"
				,"Call Trace (*57)" 
				,"Call Selector(*61)"
				,"Ringmaster"
				,"Repeat Dial(*66)"
				,"Privacy Director" 
				,"Anonymous Call Rejection" 
				,"Other Feature"};
	public static String[] ChooseBox_Call_Wait_SE
		= {"Select One:"
				,"Call Waiting"
				,"Talking Call Waiting"
				,"Call Waiting/ID Deluxe"};
	public static String[] ChooseBox_Call_Forward_SE
		= {"Call Forward - Select One:"
				,"Call Forward Variable"
				,"Call FWD Don't Answer"
				,"Call FWD Busy Line"
				,"Remote Call FWD"
				,"Remote Access Call FWD"
				,"Preferred Call Forward"
				,"Customer Wants to Remove Feature"
				,"Multiple Simultaneous Call FWD Don't Answer"
				,"Multiple Simultaneous Call FWD Busy Line"};
	public static String[] ChooseBox_Multi_Ring_SE
		= {"Select One:"
				,"Not Receiving Calls/Gets Intercept"
				,"No Difference in Ringing Pattern"
				,"Wrong Ring Pattern"
				,"Ringmaster Calls Transfer with Main Number"
				,"Ringmaster Won't Forward with Main Number"
				,"Gets Generic Voice Mail Greeting when Ringmaster # is Called"
				,"Customer Wants to Remove Feature"};
	public static String[] ChooseBox_PRIV_SE
		= {"Privacy Director - Select One:"
				,"Not Working"
				,"Not displaying \"Privacy Director\""
				,"Trouble with Access Code"
				,"Customer Wants to Remove Feature"
				,"Trouble with PIN"};
	public static String[] ChooseBox_Cant_Call_811
		= {"Can't Call 811 - Select One:"
				,"Choose"
				,"All Phones (AP)"
				,"Only Has One Phone (OH1P)"
				,"Some Phones (SP)"};
	public static String[] ChooseBox_MISC_SE
		= {"Miscellaneous - Select One"
				,"Foreman Call Back"
				,"Customer Request Trouble History"
				,"Referrals"
				,"Complaint/Commendation"
				,"Billing Dispute"
				,"Business Office Calling for Info"
				,"Customer Wants to Cancel Closed Report"
				,"PIC/LPIC Verification"
				,"Busy/Un-busy Line - Business Only - Not Reporting Trouble"
				,"Test Only"
				,"Collect Calls"
				,"Customer Wants Other Information"
				,"Vendor Meet"
				,"Non-AT&T CPE"
				,"Other"
				,"Hunting"
				,"Bill Information"
				,"Annoyance Calls"
				,"Locate and Tag Line"
				};
	public static String[] ChooseBox_MOVE_IND
		= {"Move NID - Select One:"
				,"Inside to Outside"
				,"Outside to Outside"
				,"Outside to Inside"
				,"For Remodeling"};
	public static String[] ChooseBox_IF_AT$T_CABLE
		= {"Ask customer if this is an AT&T cable?"
				,"Yes"
				,"No"
				,"Unsure"
				};
	public static String[] ChooseBox_IF_aware_other_customers
		= {"Ask if the customer is aware of other customers in the area affected?","Yes"
				,"No"
				,"Unsure"
				};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SE
		= {"Report VMS Trouble - Select One:"
				,"Education Requested"
				,"Password Problems"
				,"Ring Cycle Change"
				,"Can't Retrieve Messages"
				,"Can't Delete Messages"
				,"Callers Get Generic Greeting"
				,"Calls Go Directly Into Voice Mail"
				,"User Guide Requested"
				,"Trouble With Message Waiting Indicator"
				,"Call Transfer to Attendant (Operator Escape) - BUS Only"
				,"Pager Notification"
				,"Calls Not Forwarding to Voice Mail"
				,"*98 Access Not Working"
				,"Other VMS Trouble"
				,"Ringmaster and Voice Mail Trouble"};
	public static String[] ChooseBox_Ringmaster_Trouble_SE
		= {"Ringmaster Trouble - Select One:"
				,"Ringmaster Transfer to VM"
				,"Ringmaster Won't Transfer to VM"
				,"Ringmaster Gets Generic Greeting"};
	public static String[] ChooseBox_No_Report_VMS_Trouble_SE_UM
		= {"Report VMS Trouble - Select One:"
				,"Education Requested"
				,"Password Problems"
				,"Ring Cycle Change"
				,"Can't Retrieve Messages"
				,"Can't Delete Messages"
				,"Callers Get Generic Greeting"
				,"Calls Go Directly Into Voice Mail"
				,"User Guide Requested"
				,"Trouble With Message Waiting Indicator"
				,"Call Transfer to Attendant (Operator Escape) - BUS Only"
				,"Pager Notification"
				,"Calls Not Forwarding to Voice Mail"
				,"*98 Access Not Working"
				,"Other VMS Trouble"
				,"Web Issues (email/fax/wireless messages)"
				,"Ringmaster and Voice Mail Trouble"};
	public static String[] ChooseBox_98_Trouble
		= {"*98 Trouble - Select One:"
				,"ROL"
				,"Wrong Number /Mailbox"
				,"Busy, Reorder"
				,"Generic Greeting"};
	public static String[] ChooseBox_Report_VMS_Trouble_SE
		= {"Report VMS Trouble - Select One:"
				,"Education Requested"
				,"Password Problems"
				,"Ring Cycle Change"
				,"Can't Retrieve Messages"
				,"Can't Delete Messages"
				,"Callers Get Generic Greeting"
				,"Calls Go Directly Into Voice Mail"
				,"User Guide Requested"
				,"Trouble With Message Waiting Indicator"
				,"Call Transfer to Attendant (Operator Escape) - BUS Only"
				,"Pager Notification"
				,"Calls Not Forwarding to Voice Mail"
				,"*98 Access Not Working"
				,"Other VMS Trouble"
				,"Web Issues (email/fax/wireless messages)"
				,"Ringmaster and Voice Mail Trouble"};
	public static String[] ChooseBox_MainMenu_SE
		= {"AT&T POTS Main Menu - Select One:" 
				,"Dial Tone" 
				,"Voice Mail" 
				,"Can't Call Out" 
				,"Caller ID" 
				,"Can't Be Called" 
				,"Features" 
				,"Transmission" 
				,"Data" 
				,"Physical" 
				,"911" 
				,"Miscellaneous"};
	public static String[] ChooseBox_MainMenu_MW_CTX
		= {"AT&T Centrex Main Menu - Select One:" 
				,"Dial Tone" 
				,"Voice Mail" 
				,"Can't Call Out" 
				,"Caller ID" 
				,"Can't Be Called" 
				,"Features" 
				,"Transmission" 
				,"Data" 
				,"Physical" 
				,"911" 
				,"Miscellaneous"};
	public static String[] ChooseBox_Caller_ID_M_SE
		= {"Caller ID - Select One:"
				,"Caller ID"
				,"Caller ID With Name"
				,"Call Waiting/ID Deluxe"
				,"Caller ID Blocking"
				,"Wrong Name Displaying"};
	
	
	
	
	
	
	
	
				
}
