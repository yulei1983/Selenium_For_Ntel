package prepare;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Begin {
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		MMDriver.init();
	}

	@AfterTest
	public void afterTest() {
		MMDriver.quitDriver();
	}

}
