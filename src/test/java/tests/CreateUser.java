package tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import pageobjects.SignInPage;
import pageobjects.WelcomePage;

public class CreateUser extends BaseTest{
	@Test
	public void tc01CreateUser() throws InterruptedException  {
		//TEST CASE WHICH SORTING PRICES FROM LOW TO HIGHER
		 Random rand = new Random();
		int num = rand.nextInt(1000);
		String mail ="itamar" + num +"@gmail.com";
		WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);	
		login.clickSignIn();
		sign.fillMail(mail);
		sign.clickCreateAccount();
		sign.userDetails("Itamar", "BenMenda", "qjeLx9ce!", "Itamar", "BenMenda", "HarHazofim", "Rehovot","12345", "0546400654", "REHOVOT");
		Thread.sleep(2000);
		//ASSERT TO CHECK IF ELEMNT OF SIGN OUT IS DISPLAYED IF DISPLAYED MEANING CREATE A USER WAS SUCCESSFULL
		boolean expected = true;
		boolean actual = sign.isSignedIn();
		assertEquals(actual, expected);	
	}
}
