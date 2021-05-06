package com.lego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CartPageObject extends HeaderPageObject{

	//Variables
	private By proceedToCheckoutLocator = By.xpath("//a[@kind='transaction']");
	
	// Constructor
	public CartPageObject(WebDriver driver) {
		super(driver);
	}

	//Methods
	public CheckoutPageObject proceedToCheckout() {
		click(proceedToCheckoutLocator, 5);
		Reporter.log("Proceeding to checkout");
		return new CheckoutPageObject(driver);
	}
}
