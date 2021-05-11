package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.WelcomePage;

public class QuickViewProduct extends BaseTest{
	@Test
	public void tc01ClickPreview() throws InterruptedException  {
		WelcomePage login = new WelcomePage(driver);
		login.clickQuickView();
		//ASSERT SECTION TO CHECK MAIL RESULT
		boolean actual = login.isElementPresent();
		boolean expected = true;
		System.out.println("The result if the element is present " + actual);
		System.out.println("The expected is ");
		assertEquals(actual, expected);		
	}
}
