package com.lego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HeaderPageObject extends BasePageObject {

	// Locators
	private By cartLocator = By.xpath("//a[@data-test='util-bar-cart']");
	
	private By filterLocator = By.xpath("(//span[@class='MainBarstyles__MenuItemLabel-qk6y7u-9 gFyTkD'])[2]");
	private By ageLocator = By.xpath("//button[@data-analytics-title='age']");
	private By ageFourAndPlusLocator = By.xpath("//span[text()='4+']");
	
	// Constructor
	public HeaderPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public ResultsPageObject filterByAge() {
		click(filterLocator, 5);
		click(ageLocator, 5);
		click(ageFourAndPlusLocator, 5);
		Reporter.log("Filtering by age 4+");
		return new ResultsPageObject(driver);
	}
	
	public CartPageObject goToCart(){
		click(cartLocator, 5);
		Reporter.log("Going to cart");
		return new CartPageObject(driver);
	}
	
}
