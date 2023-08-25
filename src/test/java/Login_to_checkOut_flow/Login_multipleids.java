package Login_to_checkOut_flow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Commonactions.commonactions;

public class Login_multipleids extends commonactions {
	@org.testng.annotations.Test(dataProvider = "create")
	public void launch(String username, String passward) throws IOException {
		test = extentreport.createTest("Multiple logins check");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nerellaharish.kumar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passward);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		screenshot("Logins check");

		driver.quit();

	}

	@DataProvider(name = "create")
	public static Object[][] data() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" }

		};

	}

	@BeforeTest
	public static void extentrepo() {
		initialize_extentreports("Multiple Users", "Datatproviders used");
	}

	@AfterTest
	public static void extentrepogen() throws IOException {

		generate_report();
		driver.close();
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
