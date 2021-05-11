package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.ContactUsPage;
import pageobjects.WelcomePage;

public class SendMail extends BaseTest {
	@Test
	public void tc01SendSuccessfullyMail() throws InterruptedException {
		WelcomePage login = new WelcomePage(driver);
		ContactUsPage contact = new ContactUsPage(driver);
		login.clickCotnactUs();
		contact.sendMail("Webmaster", "itamar83@gmail.com", "This is test mail");
		// ASSERT SECTION TO CHECK MAIL RESULT
		boolean actual = contact.SendMailResult();
		boolean expected = true;
		System.out.println("The result if the element is present " + actual);
		assertEquals(actual, expected);
	}
}
