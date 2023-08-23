package Commonactions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class commonactions{
	
	public static WebDriver driver;
	public static ExtentReports extentreport;
	public static ExtentTest test;
	public static Properties prop;
	public static void initialize_extentreports(String title, String report_name) {
		extentreport = new ExtentReports();
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("C:\\Users\\nerellaharish.kumar\\Desktop\\New folder\\Demo\\Extentrepots\\Extentreport.html");
		extentreport.attachReporter(sparkreporter);
		sparkreporter.config().setDocumentTitle(title);
		sparkreporter.config().setReportName(report_name);
		

	}
	public static Properties getprop() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\nerellaharish.kumar\\Desktop\\Practice\\OrangeHRM\\Properties\\OrangeHRM.properties");
		prop= new Properties();
		prop.load(file);
		return prop;
		
		

	}
	
	public static void generate_report() {
		extentreport.flush();
		
		
		
	}

	
	public static WebDriver browser(String browsername) throws IOException, InterruptedException {
		test= extentreport.createTest("Browser launch");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nerellaharish.kumar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			
			
		}else if (browsername.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\nerellaharish.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		
		driver.get(getprop().getProperty("URL"));
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		return driver;
		
		
		
	
		
		
	}
	public static void username(String Username) throws IOException {
		test= extentreport.createTest("Username ");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(Username);
		
		
		
		
	}
	public static void password(String pswrd) throws IOException {
		test= extentreport.createTest("Pswd ");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pswrd);
	
		
	}
	public static void loginbtn() throws IOException {
		test= extentreport.createTest("Login Button ");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		
		
	}
	public static String screenshot(String name) throws IOException {
		test= extentreport.createTest("Screenshot");
		File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("C:\\Users\\nerellaharish.kumar\\Desktop\\Saucedemo.Screenshot\\" +name+".jpg"));
		return name;
		
		
	}
	public static void selectbag() throws IOException {
		test= extentreport.createTest("Bag Select ");
		WebElement backpack= driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		String backpackname= backpack.getText();
		WebElement backpack_addto= driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		backpack_addto.click();
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		cart.click();
		;
		WebElement backpack_addedcart= driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		String expected_backpack=backpack_addedcart.getText();
		if (expected_backpack.equals(backpackname)) {
			
			System.out.println("Same backpack added");
			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
			
			
		}else {
			System.out.println("not Same backpack added");
		}
		
		
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public static void Logout() throws IOException {
		test= extentreport.createTest("Logout ");
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		driver.close();
		
		
	}
	
	public static void address() throws IOException {
		test= extentreport.createTest("Address ");
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(getprop().getProperty("firstname"));
		
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(getprop().getProperty("lastname"));
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(getprop().getProperty("pin"));
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		
		
	}
	
	
	
}
