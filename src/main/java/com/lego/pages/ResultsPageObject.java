package com.lego.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class ResultsPageObject extends HeaderPageObject {

	// Variables
	private By keyChainLocator = By.xpath("//span[contains(text(),'Llaveros')]");
	private By priceBelow20 = By.xpath("//span[contains(text(),'0\u00a0€')]");
	private By addToCartLocator = By.xpath("//button[@kind='product']");
	private By itemNameLocator = By.xpath("//h2[@data-test='product-leaf-title']");

	// Constructor
	public ResultsPageObject(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void filter() {
		click(keyChainLocator, 5);
		click(priceBelow20, 5);
		Reporter.log("Filtering by keychain from 0-20€");
	}

	public int getNumberOfItems() {
		String s = find(keyChainLocator).getText();
		s = s.replaceAll("[\\D.]", "");
		Reporter.log("There are " + Integer.valueOf(s) + " keychains available.");
		return Integer.valueOf(s);
	}

	public int getNumberOfResult() {
		waitForElementToBeClickable(addToCartLocator, 3);
		List<WebElement> list = findAll(addToCartLocator);
		Reporter.log("Number of result is: " + list.size() + " keychains");
		return list.size();
	}

	public ItemPageObject selectRandomItem() {
		List<WebElement> listOfItems = findAll(itemNameLocator);
		
		Random random = new Random();
		int randomNumber = 0;
		do {
			randomNumber = random.nextInt(listOfItems.size() + 1);
		} while (randomNumber == 0);
		
		click(By.xpath("(//h2[@data-test='product-leaf-title'])[" + randomNumber + "]"), 5);
		Reporter.log("Selecting one of the keychains available");
		return new ItemPageObject(driver);
	}
}
