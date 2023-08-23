package Homepage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Commonactions.commonactions;

public class Homepage_test extends commonactions{
	
	public static void setup() throws IOException, InterruptedException {
		initialize_extentreports("Homepage", "Iteamstest");
		browser("chrome");
		username(getprop().getProperty("Uname"));
		password(getprop().getProperty("Psward"));
		loginbtn();
		
	}
	public static void Homepagetest() {
		
		
		List<WebElement>All_links= driver.findElements(By.xpath("/html"));
		System.out.println("Number of links :" +All_links);
		
	}

}
