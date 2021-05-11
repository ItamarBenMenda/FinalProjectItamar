package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.SignInPage;
import pageobjects.WelcomePage;

public class ForgotPassword extends BaseTest{
	@Test
	public void tc01ForgotPasswordSuccess() throws InterruptedException  {
		//TEST TO CHECK IF FORGOT PASSWORD FUNCTIONALITY IS WORKING PROPERLY AND BEHAVE ACCORDINGLY
		WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);	
		String mail ="itamar83@gmail.com";
		login.clickSignIn();
		sign.forgotPasword(mail);
		//ASSERT TO CHECK IF ELEMNT OF SIGN OUT IS DISPLAYED IF DISPLAYED MEANING CREATE A USER WAS SUCCESSFULL
		boolean expected = true;
		boolean actual = sign.isForgotPasswordSucceed();
		assertEquals(actual, expected);	
	}
}
