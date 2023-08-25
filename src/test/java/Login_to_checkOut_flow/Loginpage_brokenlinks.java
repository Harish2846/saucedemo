package Login_to_checkOut_flow;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

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

	@AfterMethod
	public static void extent_after_method(ITestResult result) throws IOException {
		if (result.getStatus() == org.testng.ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));

		} else if (result.getStatus() == org.testng.ITestResult.SUCCESS) {

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.BLUE));

		}

	}

}
