package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.WelcomePage;

public class AddFewProducts extends BaseTest{
	@Test(priority=1)
	//REMOVING A PRODUCT IS WORKING PROPERLY
	public void tc03RemoveProduct() throws InterruptedException  {
		WelcomePage login = new WelcomePage(driver);
		int productsAmount = 3;
		for (int i = 1; i <= productsAmount; i++) {
			login.addProduct();
		}
		int productNumberInCart =login.returnShoppingCounter();
		login.removeProduct();
		int productNumberAfterRemove = login.returnShoppingCounter();
		//ASSERT TO CHECK IF THE PRODUCT WAS ADDED SUCCESSFULLY
		int expected = productNumberInCart -1;
		int actual =productNumberAfterRemove;
		System.out.println("The actual value "+ actual + "The expected is "+ expected);
	    assertEquals(actual, expected);
	}
}