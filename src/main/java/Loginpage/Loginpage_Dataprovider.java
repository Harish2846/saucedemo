package Loginpage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Commonactions.commonactions;

public class Loginpage_Dataprovider extends commonactions {

	public static void setup() throws IOException, InterruptedException {
		browser("Edge");

	}

	public static void logins() throws IOException {
		username(getprop().getProperty("Uname"));
		password(getprop().getProperty("Psward"));
		loginbtn();

	}

	public static void all_links() {
		String b_links = null;
		List<WebElement> Login_links = driver.findElements(By.tagName("a"));
		int size = Login_links.size();
		System.out.println("Number of links in loginpage :" + size);

		try {

			URL urls = new URL(b_links);
			HttpsURLConnection http = (HttpsURLConnection) urls.openConnection();
			http.setConnectTimeout(3000);
			http.connect();
			if (http.getResponseCode() == 200) {
				System.out.println(b_links + "- " + http.getResponseMessage());
				System.out.println(Login_links.get(4));

			}
			if (http.getResponseCode() == HttpsURLConnection.HTTP_NOT_FOUND) {
				System.out
						.println(b_links + "- " + http.getResponseMessage() + "- " + HttpsURLConnection.HTTP_NOT_FOUND);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
