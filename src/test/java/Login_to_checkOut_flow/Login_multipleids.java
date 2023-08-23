package Login_to_checkOut_flow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import Commonactions.commonactions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_multipleids extends commonactions  {
	@org.testng.annotations.Test(dataProvider = "create")
	public void launch  (String username, String passward) throws IOException {
		WebDriverManager.edgedriver().create();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passward);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		driver.quit();
		
	}
	@DataProvider(name="create")
	public static Object[][] data() {
		return new Object[][]
				{
					{"standard_user", "secret_sauce"},
					{"locked_out_user", "secret_sauce"},
					{"problem_user", "secret_sauce"},
					{"performance_glitch_user", "secret_sauce"}
					
				};
		
		

	}
	@BeforeTest
	public static void extentrepo() {
		initialize_extentreports("Multiple Users", "Datatproviders used");
	}
	@AfterTest
	public static void extentrepogen() throws IOException {
		String ss_path=screenshot("Dataprovider login");
		test.log(Status.INFO, (Markup) MediaEntityBuilder.createScreenCaptureFromPath(ss_path));
		generate_report();
	}

}
