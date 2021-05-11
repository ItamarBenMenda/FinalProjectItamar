package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.WelcomePage;

public class SortingProducts extends BaseTest{
	@Test
	public void tc01SortFromLowToHigh() throws InterruptedException  {
		//TEST CASE WHICH SORTING PRICES FROM LOW TO HIGHER
		WelcomePage login = new WelcomePage(driver);
		String product = "dress";
		login.searchProduct(product);
		login.clickSortSmallToHigh();
		Thread.sleep(2000);
		//ASSERT IF TRUE IT IS SORTED IF FALSE IT IS NOT SORTED FROM SMALL TO BIG
		boolean isSorted = login.sortedLowerPrice(product);
		System.out.println("THE RESULT IS " +isSorted);
		boolean expected = true;
		assertEquals(isSorted , expected);
	}
}
