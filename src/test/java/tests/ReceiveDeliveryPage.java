package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.DeliveryPage;
import pageobjects.WelcomePage;

public class ReceiveDeliveryPage extends BaseTest {
	@Test
	public void tc01ReveiDeliveryPage() throws InterruptedException  {		
		WelcomePage login = new WelcomePage(driver);
		DeliveryPage contact = new DeliveryPage(driver);
		String product = "Dress";
		String expected ="Shipments and returns";
		login.searchProduct(product);
		login.clickDeliveryPage();
		String ReceivedTitle = contact.getDeliveryPageTitle();
		//ASSERT SECTION TO CHECK MAIL RESULT
		assertEquals(ReceivedTitle, expected);
	}
}
