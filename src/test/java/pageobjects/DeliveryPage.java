package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryPage extends BasePage {

	@FindBy (css="#center_column >div > h2")
	private WebElement DeliveryPageTitle;
	
	
	//CONSTRUCTOR
	public DeliveryPage(WebDriver driver) {
		super(driver);
	}
	public String getDeliveryPageTitle() {
		return DeliveryPageTitle.getText();
	}
}
