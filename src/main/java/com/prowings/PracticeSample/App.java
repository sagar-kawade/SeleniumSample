package com.prowings.PracticeSample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
	static String AppUrl = "https://opensource-demo.orangehrmlive.com/";

	static {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver.exe");
	}

	public static void main(String[] args) {
		startBrowser();

	}

	static void dealy(int timespan) {
		try {
			TimeUnit.SECONDS.sleep(timespan);
		} catch (InterruptedException e) { // Checked Exception --->
			e.printStackTrace();
		}

	}

	static void startBrowser() {
		WebDriver driverInstance = new ChromeDriver();
		driverInstance.get(AppUrl);
		dealy(3);
		driverInstance.manage().window().maximize();
		dealy(3);
		// Username : Admin | Password : admin123
		WebElement username = driverInstance.findElement(By.id("txtUsername"));
		WebElement password = driverInstance.findElement(By.id("txtPassword"));
		WebElement loginBtn = driverInstance.findElement(By.id("btnLogin"));
		username.clear();
		username.sendKeys("Admin");
		dealy(3);

		password.clear();
		password.sendKeys("admin123");
		dealy(3);

		loginBtn.click();
		dealy(4);

		driverInstance.close();
	}
}
