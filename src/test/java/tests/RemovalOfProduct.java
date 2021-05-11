package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.WelcomePage;

public class RemovalOfProduct extends BaseTest {
	@Test(priority = 1)
	// ADDING FEW PRODUCTS AND CHECKING THE REMOVAL OF THE PRODUCT - CHECKING AMOUNT
	// OF PRODUCTS
	public void tc05CheckingRemoveBTN() throws InterruptedException {
		WelcomePage login = new WelcomePage(driver);
		int productsAmount = 2;
		for (int i = 1; i <= productsAmount; i++) {
			login.addProduct();
		}
		login.clickToCheckOut();
		int BeforeRemove = login.returnNumberOfProducts();
		login.removeProduct();
		int AfterRemove = login.returnNumberOfProducts();
		// ASSERT TO CHECK IF THE PRODUCT WAS ADDED SUCCESSFULLY
		int expected = AfterRemove;
		int actual = BeforeRemove - 1;
		System.out.println("The actual value " + actual + "The expected is " + expected);
		assertEquals(actual, expected);
	}
}