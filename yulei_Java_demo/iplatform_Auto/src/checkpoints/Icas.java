package checkpoints;

public interface Icas {

	final String Ask_Please_verify_the_customers_name_and_address = "Thank you. Let me make sure that I have got the right number. Is 9991112401 the correct number?"
			+ "\n1. Yes" + "\n2. No";

	final String ChooseBox_MainMenu_MW = "What seems to be the trouble with that telephone number?"
			+ "\n1. Dial Tone" + "\n2. Voice Mail" + "\n3. Can't Call Out" + "\n4. Caller ID" + "\n5. Can't Be Called"
			+ "\n6. Features" + "\n7. Transmission" + "\n8. Data" + "\n9. Physical" + "\n10. 911"
			+ "\n11. Miscellaneous";

	final String ChooseBox_MainMenu = "We need to test your line to isolate the trouble. Please hold while the testing is in progress..."
			+ "Our test indicates your line is working okay. The trouble is likely at your location. You can request a technician on site for repair, or perform some troubleshooting yourself with easy to follow instructions."
			+ "Now do you want to troubleshoot yourself or request a dispatch?"
			+ "\n1. Isolate for CPE Trouble"
			+ "\n2. Close with the Customer"
			+ "\n3. Customer requests a Dispatch";

}
