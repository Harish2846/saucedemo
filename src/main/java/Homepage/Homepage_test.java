package Homepage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Commonactions.commonactions;

public class Homepage_test extends commonactions {

	public static void setup() throws IOException, InterruptedException {

		initialize_extentreports("Homepage", "Iteamstest");
		test = extentreport.createTest("setup");
		browser("chrome");
		username(getprop().getProperty("Uname"));
		password(getprop().getProperty("Psward"));
		loginbtn();

	}

	public static void Mouse_actions() throws IOException {

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(getprop().getProperty("URL"));
		username(getprop().getProperty("Uname"));
		password(getprop().getProperty("Psward"));
		loginbtn();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String first_window = driver.getWindowHandle();
		System.out.println("1st window :" + first_window);

		Set<String> All_windows = driver.getWindowHandles();
		System.out.println("NUmber of windows opened :" + All_windows.size() + "Window names:" + All_windows);
		Iterator it = All_windows.iterator();
		String secondwindow = (String) it.next();
		System.out.println("2nd window :" + secondwindow);
		driver.switchTo().window(secondwindow);

		WebElement white_tshirt = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));

		Actions mouseactions = new Actions(driver);

		mouseactions.moveToElement(white_tshirt).click().build().perform();

		test = extentreport.createTest("Mouse_actions");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenshot("White shirt");
		test.log(Status.PASS, "Mouse actions passed");

	}

}
