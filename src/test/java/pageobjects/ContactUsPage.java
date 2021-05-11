package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

	@FindBy(css = ".home")
	private WebElement backHome;
	// SEND MAIL SELECTION
	@FindBy(css = "#id_contact")
	private WebElement departmentSelector;
	@FindBy(css = "#email")
	private WebElement mail;
	@FindBy(css = "#message")
	private WebElement mailMessage;
	@FindBy(css = "#submitMessage")
	private WebElement sendMailBtn;
	@FindBy(css = "#submitMessage")
	private WebElement mailResult;
	@FindBy(css = ".alert.alert-success")
	private WebElement successClass;

	// CONSTRUCTOR
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	// PRESSING THE HOME BTN BACK TO THE MAIN PAGE
	public void clickHome() {
		click(backHome);
	}

	public void sendMail(String department, String mailAddress, String message) {
		Select departmentSelection = new Select(departmentSelector);
		try {
			departmentSelection.selectByVisibleText(department);
			;
		} catch (Exception e) {
			System.out.println("The Value Is not found from the drop down list");
		}
		fillText(mail, mailAddress);
		fillText(mailMessage, message);
		click(sendMailBtn);
	}

	public boolean SendMailResult() {
		boolean result = false;
		try {
			result = successClass.isDisplayed();
			return result;
		} catch (Throwable e) {
			return false;
		}
	}
}
