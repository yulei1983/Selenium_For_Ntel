package TestCases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Function_Libary.WebDriver_Setup;
import Function_Libary.functions;
import Object_Repository.Browser_GUI;
import Object_Repository.CheckPoints;
import Object_Repository.ChooseBox;
import Object_Repository.QTP_CheckList;

public class Optimz2_Name_Address_Display_Orders {
	WebDriver driver = null;
	functions funs = null;
	String declaringClassNameReg = "TestCases";
	
	@BeforeClass
	public void beforeClass()  {
		try {
			this.driver = WebDriver_Setup.init();
			this.funs= new functions(driver);
			funs.loginNtel("jt0005");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@BeforeMethod
	public void beforeMethod(){		
		try {
			Thread.sleep(200);
			SoftAssert softAt = new SoftAssert();
			functions.softassert = softAt;
			funs.ClearNtel(driver);
		} catch (Exception e) {
			funs.ClearNtel(driver);
		}finally {
		}
	}
	
	@AfterMethod
	public void afterMethod(){

	}
	
	@AfterClass
	public void AfterClass(){
//		driver.close();
	}
	
	
	@Test
	public void DPA_NameAddress_FromSearch_01(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112434");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Verify_and_select_the_name_and_service_address_being_reported_Title(driver), "outerText",
		CheckPoints.Verify_and_select_the_name_and_service_address_being_reported_Title());
		
		Browser_GUI.MainPage.
		V_and_s_name_and_service_address_Option(driver, "9991112301 R*****(TU MICHAEL) 1611 AV Q, HUNTSVILLE, In Effect").click();
		
		Browser_GUI.MainPage.
		V_and_s_name_and_service_address_OK(driver).click();

		funs.CheckBooleanTureIsPass(funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='R*****(TU MICHAEL)']")));
		funs.CheckBooleanTureIsPass(funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='1611 AV Q, HUNTSVILLE,']")));
		funs.CheckBooleanTureIsPass(funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(SF)']")));

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

	@Test
	public void DPA_Address_Not_Found_02(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9998002424");
	    Thread.sleep(3000);
	    
		funs.CheckPorperty(Browser_GUI.MainPage.Verify_and_select_the_name_and_service_address_being_reported_Title(driver), "outerText",
		CheckPoints.Verify_and_select_the_name_and_service_address_being_reported_Title());
		
		Browser_GUI.MainPage.
		V_and_s_name_and_service_address_Option(driver, "Address Not Found").click();
		
		Browser_GUI.MainPage.
		V_and_s_name_and_service_address_OK(driver).click();
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));
        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));

		funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver), "innerText",
				CheckPoints.Data_Input_Input_the_correct_address$());
		Browser_GUI.MainPage.DataInput2_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.select_Service_Address_Title(driver), "innerText",
				CheckPoints.Select_Service_Address_title());
		funs.CheckPorperty(Browser_GUI.MainPage.Select_Service_Address_JTextPane(driver), "innerText",
				CheckPoints.SSA_Please_select_the_LFACS_address_that_matches_the_address_the_customer_provided());
		Browser_GUI.MainPage.select_Service_Address_Option(driver, "Address Not Found").click();
		Browser_GUI.MainPage.Select_Service_Address_OK(driver).click();

		funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
		CheckPoints.AM_Is_the_address_mis_match_caused_by_a_Service_Order$());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_Yes(driver), "innerText",CheckPoints.AM_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.AM2_No(driver), "innerText",CheckPoints.AM_No());
		Browser_GUI.MainPage.Tree_value(driver, "LFACS AND CUSTOMER PROVIDED ADDRESSES DO NOT MATCH.");
		Browser_GUI.MainPage.AM2_Yes(driver).click();
		
		funs.Check_ChooseBoxList(QTP_CheckList.ChooseBox_MainMenu_SW);
		
		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void NameAddress_FromSearch_03(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112430");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='R*****(TU MICHAEL)']"));
        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1611 AV Q, HUNTSVILLE,']"));

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());

		funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void NameFromOsstr_AddressFromOsstr_04(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9996002425");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9996002425", "S24", "ERROR");
		
	    funs.Enter_TN("9996002425");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));
        
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_trouble_requires_further_isolation$());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9996002425", "S24", "CORRECT");
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void NameFromOsstr_AddressFromS14_05(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112432");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9991112432", "S24", "ERROR");
		
	    funs.Enter_TN("9991112432");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));
        
		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_trouble_requires_further_isolation$());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9991112432", "S24", "CORRECT");

		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void NameFromOsstr_AddressFromS24_06(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991112438");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1000 HOUGHTON, LIVONIA']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));

		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_Yes(driver), "innerText",CheckPoints.Ask_Yes());
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_No(driver), "innerText",CheckPoints.Ask_No());
		funs.ClearNtel(driver);
		
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
	@Test
	public void NameFromOsstr_AddressFromSearch_07(){
	    try {	
	    ChooseBox chooseBox;
	    chooseBox = new ChooseBox(driver);
	    funs.Enter_TN("9991172683");
	    Thread.sleep(3000);

        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1611 AV Q, HUNTSVILLE,']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES BST']"));

		funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
		CheckPoints.AM_This_trouble_requires_further_isolation$());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9991172683", "S24", "CORRECT");
		
	    funs.Enter_TN("9991112432");
	    Thread.sleep(3000);
        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1611 AV Q, HUNTSVILLE,']"));
        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES BST']"));
		funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
		CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
		funs.ClearNtel(driver);
		
		functions.Update_TrxStatus_InAdminGUI("9991172683", "S24", "ERROR");
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
        functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void NameFromS24_AddressFromOsstr_08(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9998002422");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

		@Test
		public void NameFromS24_AddressFromS14_09(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9996002426");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(LISTED)  COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

		@Test
		public void NameFromS24_AddressFromS24_10(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9991112433");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1000 HOUGHTON, LIVONIA']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void NameFromS24_AddressFromSearch_11(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9998002423");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1611 AV Q, HUNTSVILLE,']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void NameFromSearch_AddressFromOsstr_12(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9991112431");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)BOYD; & BOY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void NameFromSearch_AddressFromS14_13(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9996002427");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='R*****(TU MICHAEL)']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void NameFromSearch_AddressFromS24_SE_14(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9976002547");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1000 HOUGHTON, WANG']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)BOYD; & BOY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.ClearNtel(driver);
			
			functions.Update_TrxStatus_InAdminGUI("9976002547", "S14", "SUCCESS");
			
		    funs.Enter_TN("9976002547");
		    Thread.sleep(3000);
	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)BOYD; & BOY']"));
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.ClearNtel(driver);
			
			functions.Update_TrxStatus_InAdminGUI("9976002547", "S14", "ERROR");
			   }
		    catch (Exception e) {
				funs.ClearNtel(driver);
				 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
		       }
	        functions.softassert.assertAll();  	    	
		}
		
		@Test
		public void RX_NameAddress_FromSearch_15(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9991112435");
		    Thread.sleep(3000);

	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1611 AV Q, HUNTSVILLE,']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='R*****(TU MICHAEL)']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void RX_NameFromOsstr_AddressFromOsstr_16(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9998002425");
		    Thread.sleep(3000);

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();
		    
	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
			CheckPoints.AM_Refer_customer_to_Business_Office$$$TX_CS$$$800_499_7928$$$800_288_2020());
			Browser_GUI.MainPage.AM_OK(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM POUT NO SO NO CSR REFBO"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 

			funs.ClearNtel(driver);
			
			functions.Update_TrxStatus_InAdminGUI("9998002425", "S24", "CORRECT");
			
		    funs.Enter_TN("9998002425");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();
		    
	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
			funs.ClearNtel(driver);
			
			functions.Update_TrxStatus_InAdminGUI("9998002425", "S24", "ERROR");
			   }
		    catch (Exception e) {
				funs.ClearNtel(driver);
				 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
		       }
	        functions.softassert.assertAll();  	    	
		}

		@Test
		public void RX_NameFromS24_AddressFromS14_17(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9997001435");
		    Thread.sleep(3000);

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='5356 SILVER CREEK']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(LISTED)  COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void RX_NameFromS24_AddressFromS14_18(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9991172340");
		    Thread.sleep(3000);

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();
			
	        funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());
					funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}

		@Test
		public void RX_NameFromS24_AddressFromS14_19(){
		    try {	
		    ChooseBox chooseBox;
		    chooseBox = new ChooseBox(driver);
		    funs.Enter_TN("9991172343");
		    Thread.sleep(3000);

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();
			Boolean Y_NAME ,Y_ADDR;
			Y_ADDR = funs.IsNotExist(By.xpath("//div[@class='topLocLabel']//label[text()='1000 HOUGHTON, LIVONIA']"));
	        Y_NAME = funs.IsNotExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));

	        if (!Y_ADDR || !Y_NAME) {
				functions.softassert.fail(functions.ExceptionMessageFormat(new Exception() ,  "1000 HOUGHTON, LIVONIA,Not exist"   , "Exist"));
			}
 
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Refer_customer_to_Business_Office$$$IN_CS$$$800_206_4102$$$800_288_2020());

			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","TXCLOSE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","MISC"); 
			funs.ClearNtel(driver);
					
			functions.Update_TrxStatus_InAdminGUI("9991172343", "S24", "CORRECT");
		
		    funs.Enter_TN("9991172343");
		    Thread.sleep(3000);

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_ATT_does_not_provide_your_local_service$_Please_contact_COX_CALIFORNIA_TELCOM_LLC_at_888_222_7743());
			Browser_GUI.MainPage.Ask_No(driver).click();		
					
			funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='1000 HOUGHTON, LIVONIA']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));		
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","POSS PORTING PRBLM"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
			Browser_GUI.MainPage.Tree_value(driver, "CUSTOMER DOES NOT AGREE");

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());		
			funs.ClearNtel(driver);

			functions.Update_TrxStatus_InAdminGUI("9991172343", "S24", "ERROR");

		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
	
		@Test
		public void RX_NameFromS24_AddressFromS14_20(){
		    try {	
		    funs.Enter_TN("9997001436");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9997001436"); 
			funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='DISCONNECTED']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)ELGIRUS,WES']"));
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
 
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());		
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
			Browser_GUI.MainPage.AM_OK(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
			Browser_GUI.MainPage.AM2_No(driver).click();
			
//			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
//					CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
//			Browser_GUI.MainPage.AM_OK(driver).click();
//			
//			funs.CheckPorperty(Browser_GUI.MainPage.DataInput_Title(driver) , "innerText",
//					CheckPoints.Data_Input_Title());
//			funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver) , "innerText",
//					CheckPoints.Data_Input_Obtain_Reported_By_information_if_the_Report_By_field_is_blank$());
//			Browser_GUI.MainPage.DataInput_OK(driver).click();
//
//			funs.CheckPorperty(Browser_GUI.MainPage.DataInput_Title(driver) , "innerText",
//					CheckPoints.Data_Input_Title());
//			funs.CheckPorperty(Browser_GUI.MainPage.DataInput_JTextPane(driver) , "innerText",
//					CheckPoints.Data_Input_Obtain_callback_number_if_the_Reach_Number_field_is_blank_or_is_populated_with_zeros$());
//			Browser_GUI.MainPage.DataInput_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Commitment_has_been_missed_on_this_report$());		
			Browser_GUI.MainPage.Ask_No(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_Report(driver), "textContent","MISSED CMMT TEST TKT FOR APRO TEAM REPORT BY JANE TEMPLEMIRE"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ACTION(driver), "value","MISSLR"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9997001436"); 
			Browser_GUI.MainPage.BTN_Submit(driver).click(); 
			funs.CheckPorperty(Browser_GUI.MainPage.Submit_AgMsg_Yes(driver), "innerText",CheckPoints.Submit_AgMsg_Yes()); 
			Browser_GUI.MainPage.Submit_AgMsg_Yes(driver).click(); 
			 
			Browser_GUI.MainPage.Submit_APRO_OK(driver).click(); 
			funs.CheckPorperty(Browser_GUI.MainPage.Submit_TankYou_OK(driver), "innerText",CheckPoints.Submit_TankYou_OK()); 
			Browser_GUI.MainPage.Submit_TankYou_OK(driver).click();	
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void RX_NameFromS24_AddressFromS14_21(){
		    try {	
			 Thread.sleep(300);
		    funs.Enter_TN("9991112436");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9991112436"); 
			funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='38 SCHAFFER DR/EH']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
 
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());		
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_07_01_05_1052A_Pending_Pickup$AP$_General_NCSC_Screening_Bucket$POT$());
			Browser_GUI.MainPage.AM_OK(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
			Browser_GUI.MainPage.AM2_No(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9991112436"); 
			funs.ClearNtel(driver);

		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void RX_NameFromS24_AddressFromS14_22(){
		    try {	
			 Thread.sleep(300);
		    funs.Enter_TN("9998002384");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9998002384"); 
			funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='137 PINE VALLEY']"));
	        funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='COUNTY OF CALLAWAY']"));
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
			CheckPoints.Ask_Do_the_billing_records_and_customers_information_agree$());
			Browser_GUI.MainPage.Ask_Yes(driver).click();
 
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());		
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_07_01_05_1052A_Pending_Pickup$AP$_General_NCSC_Screening_Bucket$POT$());
			Browser_GUI.MainPage.AM_OK(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
			
			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		@Test
		public void RX_NameFromS24_AddressFromS14_23(){
		    try {
			 Thread.sleep(300);
		    funs.Enter_TN("9996002390");
		    Thread.sleep(3000);
		    
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_ReachNumber(driver), "value","9996002390"); 
			funs.CheckBooleanTureIsPass(funs.IsExist(By.xpath("//div[@class='topLocLabel']//label[text()='5356 SILVER CREEK']")));
			funs.CheckBooleanTureIsPass(funs.IsExist(By.xpath("//div[@class='topNameLabel']//label[text()='(NON-PUB)BOYD; & BOY']")));
			funs.CheckPorperty(Browser_GUI.MainPage.WebEdit_TYPE(driver), "value","NDT"); 

			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Please_verify_the_customer$s_name_and_address$());		
			Browser_GUI.MainPage.Ask_Yes(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_07_01_05_1052A_Pending_Pickup$PP$_General_NCSC_Screening_Bucket$POT$());
			Browser_GUI.MainPage.AM_OK(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM2_JTextPane(driver), "innerText",
					CheckPoints.AM_Is_the_customer_requesting_to_cancel_this_trouble_report$());
			Browser_GUI.MainPage.AM2_No(driver).click();

			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Explain_to_cust_that_line_is_involved_with_Cable_Failure$());
			Browser_GUI.MainPage.AM_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_Title(driver) , "innerText",
			CheckPoints.Data_Input_Title());
	        funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver) , "innerText",
			CheckPoints.Data_Input_Obtain_Reported_By_information_if_the_Report_By_field_is_blank$());
	        Browser_GUI.MainPage.DataInput2_OK(driver).click();

	        funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_Title(driver) , "innerText",
			CheckPoints.Data_Input_Title());
	        funs.CheckPorperty(Browser_GUI.MainPage.DataInput2_JTextPane(driver) , "innerText",
			CheckPoints.Data_Input_Obtain_callback_number_if_the_Reach_Number_field_is_blank_or_is_populated_with_zeros$());
	        Browser_GUI.MainPage.DataInput2_OK(driver).click();
			
			funs.CheckPorperty(Browser_GUI.MainPage.AM_JTextPane(driver), "innerText",
					CheckPoints.AM_Consider_the_commitment_time_negotiate_a_new_commitment_if_necessary$());
			Browser_GUI.MainPage.AM_OK(driver).click();
	        
			funs.CheckPorperty(Browser_GUI.MainPage.Ask_JTextPane(driver), "innerText",
					CheckPoints.Ask_Commitment_has_been_missed_on_this_report$());		

			funs.ClearNtel(driver);
		   }
	    catch (Exception e) {
			funs.ClearNtel(driver);
			 functions.GetExcptionMessageFromExcptionRejector(e, declaringClassNameReg); 
	       }
           functions.softassert.assertAll();  	    	
	}
		
		
		
	
	
	public static void main(String[] args) {
		

	}

}
