package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pageobjects.WelcomePage;

public class SearchProduct extends BaseTest {
	@Test
	public void tc01SearchNotExistProduct() throws InterruptedException {
		// TEST CASE WHICH ENTERS ONLY DESTINATION VALUE AND CHECK RESULT
		WelcomePage login = new WelcomePage(driver);
		String product = "1234";
		login.searchProduct(product);
		boolean expected = true;
		boolean actual = login.isFailedSearchExist();
		assertEquals(actual, expected);
	}

	@Test
	public void tc01SearchExistProduct() throws InterruptedException {
		// TEST CASE WHICH ENTERS ONLY DESTINATION VALUE AND CHECK RESULT
		WelcomePage login = new WelcomePage(driver);
		String product = "dress";
		login.searchProduct(product);
		boolean expected = false;
		boolean actual = login.isFailedSearchExist();
		assertEquals(actual, expected);
	}
}
