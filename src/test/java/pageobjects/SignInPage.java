package pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BasePage {

	@FindBy(css = "#SubmitCreate")
	private WebElement createAccountBtn;
	@FindBy(css = "#email_create")
	private WebElement userMail;
//USER DETAILS ELEMENTS
	@FindBy(css = "#uniform-id_gender1")
	private WebElement mrRadio;

	@FindBy(css = "#customer_firstname")
	private WebElement firstName;
	@FindBy(css = "#customer_lastname")
	private WebElement lastName;
	@FindBy(css = "#passwd")
	private WebElement password;
	@FindBy(css = "#firstname")
	private WebElement addressFirstName;
	@FindBy(css = "#lastname")
	private WebElement addressLastName;
	@FindBy(css = "#address1")
	private WebElement address;
	@FindBy(css = "#city")
	private WebElement city;

	@FindBy(css = "#id_state")
	private WebElement state;

	@FindBy(css = "#postcode")
	private WebElement postcode;
	@FindBy(css = "#phone_mobile")
	private WebElement phone;
	@FindBy(css = "#alias")
	private WebElement aliasAddress;
	@FindBy(css = "#submitAccount")
	private WebElement registerBtn;
	@FindBy(css = ".logout")
	private WebElement logout;
	@FindBy(css = "#email")
	private WebElement SignInEmail;
	@FindBy(css = "#passwd")
	private WebElement SignInPasswd;
	@FindBy(css = "#SubmitLogin")
	private WebElement SignInBtn;
	@FindBy(css = ".logout")
	private WebElement SignOutBtn;
	@FindBy(css = "#login_form > div > p.lost_password.form-group > a")
	private WebElement ForgotPasswordLink;
	@FindBy(css = "#form_forgotpassword > fieldset > p > button")
	private WebElement RetrievePasswordBtn;
	@FindBy(css = ".alert.alert-success")
	private WebElement successAlert;
	@FindBy(css = "#center_column > ul > li > a > span")
	private WebElement BackToLginBtn;
	@FindBy(css = ".page-subheading")
	private WebElement BackToLoginTitle;

	// CONSTRUCTOR
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	// ENTERING DESIRED MAIL
	public void fillMail(String mail) {
		fillText(userMail, mail);
	}

	// PRESSING CREATE AN ACCOUNT
	public void clickCreateAccount() throws InterruptedException {
		click(createAccountBtn);
		Thread.sleep(3000);
	}

	// FILLING THE USER DETAILS
	public void userDetails(String fName, String lName, String passwd, String addresFname, String addresLname,
			String addressR, String ct, String postcode1, String phoneNumber, String aliasAddress1) throws InterruptedException {
		Thread.sleep(3000);
		click(mrRadio);
		fillText(firstName, fName);
		fillText(lastName, lName);
		fillText(password, passwd);
		fillText(addressFirstName, addresFname);
		fillText(addressLastName, addresLname);
		fillText(address, addressR);
		fillText(city, ct);
		SelectState(state);// selecting random state
		fillText(postcode, postcode1);
		fillText(phone, phoneNumber);
		fillText(aliasAddress, aliasAddress1);
		click(registerBtn);
	}

	// SIGIN IN TO THE SYSTEM
	public void signInUser(String email, String passwd) throws InterruptedException {
		Thread.sleep(3000);
		fillText(SignInEmail, email);
		fillText(SignInPasswd, passwd);
		click(SignInBtn);
		Thread.sleep(3000);
	}

	// Sign Out from the system After already logged In
	public void clickSignOut() {
		click(SignOutBtn);
	}

	// FORGOT PASSWORD FUNCTIONALITY
	public void forgotPasword(String mailAdress) throws InterruptedException {
		click(ForgotPasswordLink);
		Thread.sleep(6000);
		fillText(SignInEmail, mailAdress);
		click(RetrievePasswordBtn);
		Thread.sleep(2000);
	}

	// TEST BACKTOLOGIN BTN FUNCTIONALITY
	public void pressBackToLogin() throws InterruptedException {
		click(ForgotPasswordLink);
		Thread.sleep(6000);
		click(BackToLginBtn);
	}

	public boolean isForgotPasswordSucceed() {
		boolean exist = false;
		try {
			exist = successAlert.isDisplayed();
			return exist;
		} catch (Throwable e) {
			return exist;
		}
	}

	public boolean isBackToLoginSuccessfull() {
		boolean exist = false;
		try {
			exist = BackToLoginTitle.isDisplayed();
			return exist;
		} catch (Throwable e) {
			return exist;
		}
	}

	public boolean isSignedIn() {
		boolean exist = false;
		try {
			exist = logout.isDisplayed();
			return exist;
		} catch (Throwable e) {
			return exist;
		}
	}

	// ACTION OF SELECTING RANDOM STATE
	public static void SelectState(WebElement state) {
		Select dropdown = new Select(state);
		// Get all options
		List<WebElement> stateOptions = dropdown.getOptions();
		int index = 0;// if list contains only one element it will take that element
		if (stateOptions.size() > 1) {
			// Get a random number between 1, size of dd
			Random rand = new Random();
			index = rand.nextInt(stateOptions.size() - 1);
		}
		if (index >= 0) {
			dropdown.selectByIndex(index);
		}
	}
}
