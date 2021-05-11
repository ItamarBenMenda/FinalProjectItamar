package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.WelcomePage;

public class EnterNewLetterMail extends BaseTest {
	@Test
	public void tc01EnterNewMail() throws InterruptedException  {
		String mail = "itamar2@gmail.com";
		WelcomePage login = new WelcomePage(driver);
		login.enterMailForNewLetter(mail);
		String result = login.getTextStatus();
		//ASSERT SECTION TO CHECK MAIL RESULT
		String expected = "Newsletter : You have successfully subscribed to this newsletter.";
		assertEquals(result, expected);
	}
	@Test
	public void tc02EnterWrongMailFormat() throws InterruptedException  {
		String mail = "1234";
		WelcomePage login = new WelcomePage(driver);
		login.enterMailForNewLetter(mail);
		String result = login.getTextStatus();
		//ASSERT SECTION TO CHECK MAIL RESULT
		String expected = "Newsletter : Invalid email address.";	
		assertEquals(result, expected);
	}
	@Test
	public void tc03EnterExistMail() throws InterruptedException  {
		String mail = "itamar@gmail.com";
		WelcomePage login = new WelcomePage(driver);
		login.enterMailForNewLetter(mail);
		String result = login.getTextStatus();
		//ASSERT SECTION TO CHECK MAIL RESULT
		String expected = "Newsletter : This email address is already registered.";
		assertEquals(result, expected);	
	}
}
