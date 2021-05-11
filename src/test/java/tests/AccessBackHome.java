package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageobjects.ContactUsPage;
import pageobjects.WelcomePage;

public class AccessBackHome extends BaseTest {
	@Test
	public void tc01BackHome() throws InterruptedException {
		WelcomePage login = new WelcomePage(driver);
		String firstUrl = login.getUrl();
		ContactUsPage contact = new ContactUsPage(driver);
		login.clickCotnactUs();
		contact.clickHome();
		String url = driver.getCurrentUrl();
		System.out.println("The first URL is " + firstUrl);
		System.out.println("The Last Url" + url);
		// ASSERT SECTION TO CHECK MAIL RESULT
		assertEquals(url, firstUrl);
	}
}
