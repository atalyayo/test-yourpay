package com.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
	
	WebDriver driver;
	WebDriverWait driverWait;
	
	private static final String HOME_URL = "https://yourpay.co/";

	@BeforeTest
	private void init() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver/chromedriver-win64/chromedriver.exe/");
		driver = new ChromeDriver();
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to(HOME_URL);
		driver.manage().window().maximize();
	}

	@Test
	private void buttonTest() {
		driver.findElement(By.className("btn-new-google-play")).click();
		
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://play.google.com/store/apps/details?id=mtda.rpaynativeandroid&utm_source=webapp");
	}
	
	@AfterTest
	private void close() {
		driver.quit();
	}
}
