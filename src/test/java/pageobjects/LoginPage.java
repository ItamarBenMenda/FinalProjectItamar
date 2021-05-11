package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
		//LOGING FIELDS
		@FindBy (css="#ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_MembertxtID")
		private WebElement idField;
		@FindBy (css="#ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_PasswordtxtID")
		private WebElement passwordField;
		//LOGIN BTN
		@FindBy (css="#ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_lnkSubmit")
		private WebElement entranceBtn;
		//LOGIN RESULT
		@FindBy (css="#ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_ResponseErrorMsg")
		private WebElement entranceMessage;
		
		public LoginPage(WebDriver driver) {
		super(driver);
	}
		
		//LOGIN PAGE ACTION
		public void memberClubLogin(String name , String password)  {
			fillText(idField, name);
			fillText(passwordField, password);
			click(entranceBtn);
		}
		public String getFailedEntranceMessage() {
			return getText(entranceMessage);
		}	
		public boolean isErrorMessageAvailable()  {
			//BY TRY CATCH WE ARE CHECKING IF ELEMENT EXIST OR NOT
			boolean present;
			try {
			   //entranceMessage;
			   driver.findElement(By.id("#ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_ResponseErrorMsg"));
			   present = true;
			} catch (NoSuchElementException e) {
			   present = false;
			}
			return present;
		}
}
