package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.WelcomePage;
public class AddProduct extends BaseTest{
	@Test (priority =2)
	//TEST TO CHECK THAT ADDING ONE PRODUCT IS WORKING PROPERLY
	public void tc01AddProduct() throws InterruptedException  {
		WelcomePage login = new WelcomePage(driver);
		login.addProduct();
		//ASSERT TO CHECK IF THE PRODUCT WAS ADDED SUCCESSFULLY
		boolean expected = true;
		boolean actual =login.isAddinSucceed();	
	    assertEquals(actual, expected);
}
	@Test(priority=1)
	//TEST TO CHECK THAT ADDING A PRODUCT IS WORKING PROPERLY (COUNTER IS OK)
	public void tc02AddFewProduct() throws InterruptedException  {
		WelcomePage login = new WelcomePage(driver);
		int productsAmount = 3;
		for (int i = 1; i <= productsAmount; i++) {
			login.addProduct();
			Thread.sleep(3000);
		}
		int cartNumber =login.returnShoppingCounter();
		//ASSERT TO CHECK IF THE PRODUCT WAS ADDED SUCCESSFULLY
		int expected = productsAmount;
		int actual =cartNumber;
		System.out.println("The actual value "+ actual + "The expected is "+ expected);
	    assertEquals(actual, expected);
	}
}