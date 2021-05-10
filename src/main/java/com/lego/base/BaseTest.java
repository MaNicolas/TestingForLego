package com.lego.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	// Variables
	protected WebDriver driver;

	// Methods
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browser) {

		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1920,1080));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close browser
		driver.quit();
	}
}