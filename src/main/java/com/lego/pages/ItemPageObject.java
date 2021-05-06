package com.lego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ItemPageObject extends HeaderPageObject {

	// Variables
	private String itemName;
	private float itemPrice;
	private By noButtonLocator = By.id("noButton");
	private By addToCartButton = By.xpath("//button[@data-test='add-to-bag']");
	private By itemNameLocator = By.xpath("//h1[@data-test='product-overview-name']");
	private By itemPriceLocator = By.xpath("//span[@data-test='product-price-sale']");
	
	// Constructor
	public ItemPageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void clickNoButton() {
		try {
			click(noButtonLocator, 3);
			Reporter.log("Declining offer to answer survey");
		} catch (Exception e) {
			System.out.println(e);
			Reporter.log("Survey was not requested");
		}
	}
	
	public String getItemName() {
		itemName = find(itemNameLocator).getText();
		Reporter.log("Item's name is " + itemName);
		return itemName;
	}
	
	public float getItemPrice() {
		String itemPriceText = find(itemPriceLocator).getText();
		itemPriceText = removeSpecialCharacters(itemPriceText);
		itemPrice = Float.valueOf(itemPriceText);
		Reporter.log("Item's price is " + itemPrice);
		return itemPrice;
	}
	
	public void addToCart() {
		click(addToCartButton, 5);
		Reporter.log("Adding item into the cart");
	}
}
