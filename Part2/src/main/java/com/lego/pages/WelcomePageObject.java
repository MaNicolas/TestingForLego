package com.lego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class WelcomePageObject extends HeaderPageObject {

	// Variables
	private String pageUrl = "https://www.lego.com/es-es";
	private By continueButtonLocator = By.xpath("//button[@kind='lightTheme']");
	private By acceptCookieLocator = By.xpath("//button[@kind='primary']");

	// Constructor
	public WelcomePageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void openPage() {
		Reporter.log("Opening page: " + pageUrl);
		openUrl(pageUrl);
		Reporter.log("Page opened!");
	}
	
	public void openshop() {
		click(continueButtonLocator, 5);
		click(acceptCookieLocator, 5);
		Reporter.log("Accepting cookies");
	}
}
