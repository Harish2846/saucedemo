package Login_to_checkOut_flow;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Loginpage.Loginpage_Dataprovider;

public class Loginpage_brokenlinks extends Loginpage_Dataprovider {
	@BeforeTest
	public static void browserlaunch() throws IOException, InterruptedException {
		initialize_extentreports("Loginpage", "Linkstest");
		setup();
		logins();
	}

	@Test
	public static void loginpage_brockenlinks() {

		all_links();

	}

	@AfterTest
	public static void reports() {

		generate_report();

	}

}
