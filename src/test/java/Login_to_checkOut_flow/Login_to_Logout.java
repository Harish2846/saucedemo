package Login_to_checkOut_flow;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Commonactions.commonactions;

public class Login_to_Logout extends commonactions {

	@BeforeTest
	public static void initialize_reports() throws IOException, InterruptedException {
		initialize_extentreports("saource", "test1");

	}

	@AfterTest

	public static void reports() throws IOException {

		generate_report();
	}

	@Test(priority = 1)
	public static void Applogin() throws IOException, InterruptedException {

		browser("Edge");
		username(getprop().getProperty("Uname"));
		password(getprop().getProperty("Psward"));
		loginbtn();
		screenshot("homepage");
	}

	@Test(priority = 2)
	public static void addcart() throws IOException {

		selectbag();

	}

	@Test(priority = 3)
	public static void addres() {
		try {
			address();
		} catch (IOException e) {

			System.out.println(e);
		}
	}

	@Test(priority = 4)
	public static void Applogout() throws IOException {

		screenshot("Bag");
		Logout();
		screenshot("checkout");
		driver.close();

	}

	@AfterMethod
	public static void aftemethod_setup(org.testng.ITestResult result) throws IOException {

		if (result.getStatus() == org.testng.ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));

		} else if (result.getStatus() == org.testng.ITestResult.SUCCESS) {

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.BLUE));

		}

	}

}
