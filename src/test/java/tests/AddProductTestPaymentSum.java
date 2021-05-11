package tests;

import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

import pageobjects.WelcomePage;

public class AddProductTestPaymentSum extends BaseTest{	
	@Test(priority=1)
	//TEST TO CHECK SUMMARIZE OF THE TOTAL PRICES IS WORKING PROPERLY AFTER ADDING FEW PRODUCTS
	public void tc04CalcProductsPrice() throws InterruptedException  {
		double totalPrice =0;
		WelcomePage login = new WelcomePage(driver);
		int productsAmount = 2;
		for (int i = 1; i <= productsAmount; i++) {
			login.addProduct();
			totalPrice= totalPrice + login.returnPriceProduct();
		}
		//ASSERT TO CHECK IF THE PRODUCT WAS ADDED SUCCESSFULLY
		double expected = login.returnTotalPriceTpPay();
		double actual =totalPrice+2.0;
		actual =Double.parseDouble(new DecimalFormat("##.####").format(actual));
		System.out.println("The actual value "+ actual + "The expected is "+ expected);
	    assertEquals(actual, expected);
	}
}