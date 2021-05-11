package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.SignInPage;
import pageobjects.WelcomePage;

public class BackToLoginFromSignIn extends BaseTest {
	@Test
	public void tc01BackToLogin() throws InterruptedException {
		// TEST TO CHECK BACK TO LOGIN FUNCTIONALITY
		WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);
		login.clickSignIn();
		sign.pressBackToLogin();
		// ASSERT TO CHECK IF ELEMNT OF SIGN OUT IS DISPLAYED IF DISPLAYED MEANING
		// CREATE A USER WAS SUCCESSFULL
		boolean expected = true;
		boolean actual = sign.isBackToLoginSuccessfull();
		assertEquals(actual, expected);
	}
}
