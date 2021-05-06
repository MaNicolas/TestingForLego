package com.lego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CheckoutPageObject extends HeaderPageObject{

	//Variables
	private By itemNameLocator = By.xpath("//span[@data-test='product-title']");
	private By itemPriceLocator = By.xpath("//span[@data-test='product-price-sale']");
	private By quantityLocator = By.xpath("//p[contains(text(),'Uds')]");
	private By totalPriceLocator = By.xpath("//span[text()='Importe total']/following-sibling::*");
	private float shippingCost = 5.95f;	
	
	// Constructor
	public CheckoutPageObject(WebDriver driver) {
		super(driver);
	}
	
	//Methods
	public String getItemName() {
		String itemName = find(itemNameLocator).getText();
		Reporter.log("Item's name is: " + itemName);
		return itemName;
	}
	
	public float getItemPrice() {
		String itemPriceText = find(itemPriceLocator).getText();
		itemPriceText = removeSpecialCharacters(itemPriceText);		
		float itemPrice = Float.valueOf(itemPriceText);
		return itemPrice;
	}
	
	public int getQuantity() {
		String quantityText = find(quantityLocator).getText();
		quantityText = removeSpecialCharacters(quantityText);
		quantityText = quantityText.replace(".", "");
		int quantity = Integer.valueOf(quantityText);
		Reporter.log("There is " + quantity + " item in the cart.");
		return quantity;
	}
	
	public float getShippingCost() {
		Reporter.log("Shipping cost is: " + shippingCost);
		return shippingCost;
	}
	
	public float getTotalPrice() {
		String totalPriceText = find(totalPriceLocator).getText();		
		totalPriceText = removeSpecialCharacters(totalPriceText);
		float totalPrice = Float.valueOf(totalPriceText);
		Reporter.log("Total price is: " + totalPrice);
		return totalPrice;
	}
}
