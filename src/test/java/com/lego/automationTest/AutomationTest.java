package com.lego.automationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lego.base.TestUtilities;
import com.lego.pages.CartPageObject;
import com.lego.pages.CheckoutPageObject;
import com.lego.pages.ItemPageObject;
import com.lego.pages.ResultsPageObject;
import com.lego.pages.WelcomePageObject;

public class AutomationTest extends TestUtilities {

	@Test(invocationCount = 1)
	public void purchaseItem() {
		
		//Go to https://www.lego.com/es-es
		WelcomePageObject welcomePage = new WelcomePageObject(driver);
		welcomePage.openPage();
		welcomePage.openshop();
		
		//Filter by age (4+ years old)
		ResultsPageObject resultsPage = welcomePage.filterByAge();
		
		//Filter by keychains under 20€
		resultsPage.filter();
		
		//Assert that the number of results is correct
		int expectedNumberOfResult = resultsPage.getNumberOfItems();
		int actualNumberOfResult = resultsPage.getNumberOfResult();
		Assert.assertEquals(actualNumberOfResult, expectedNumberOfResult);		
		
		//Check the article name and price
		ItemPageObject itemPage = resultsPage.selectRandomItem();
		itemPage.clickNoButton();
		String expectedItemName = itemPage.getItemName();
		float expectedItemPrice = itemPage.getItemPrice();
		
		//Drop in the cart and proceed to checkout
		itemPage.addToCart();
		CartPageObject cartPage = itemPage.goToCart();
		CheckoutPageObject checkoutPage = cartPage.proceedToCheckout();
		
		//Verify all details (item name, price, units, total amount…) are correct
		Assert.assertEquals(checkoutPage.getItemName(), expectedItemName);
		Assert.assertEquals(checkoutPage.getItemPrice(), expectedItemPrice);
		Assert.assertEquals(checkoutPage.getQuantity(), 1);
		
		float expectedTotalPrice = roundDecimalNumber(expectedItemPrice + checkoutPage.getShippingCost());
		float actualTotalPrice = checkoutPage.getTotalPrice();
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}
}





