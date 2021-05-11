package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.SignInPage;
import pageobjects.WelcomePage;
import utils.Excel;
import utils.Utils;

public class SignInUserToSystem extends BaseTest {
	
	@Test
	public void tc01SignInFailed() throws InterruptedException {
		// SIGN IN TO THE SYSTEM WITH USER ALREADY EXIST
		WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);
		String mail = "";
		String password = "";
		login.clickSignIn();
		sign.signInUser(mail, password);
		// ASSERT WILL CHECK IF THERE IS NOT SIGNOUT BTN
		boolean actual = sign.isSignedIn();
		boolean expected = false;
		assertEquals(actual, expected);
	}
	// USING EXCEL FILE TO LOGIN THE SYSTEM - READING THE COLUMNS AND WORKING
	// ACCORDINGLY - FAILURE TO SIGN IS IS SUCCESS
	@Test(dataProvider = "getDataFromExcel", description = "Using Different Mail of users")
	public void tc02SignInFailed(String mail, String password) throws InterruptedException {
		// SIGN IN TO THE SYSTEM WITH USER ALREADY EXIST
		WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);
		// String mail = "111212@gmail.com";
		// String password = "122322";
		login.clickSignIn();
		sign.signInUser(mail, password);
		// ASSERT WILL CHECK IF THERE IS NOT SIGNOUT BTN
		boolean actual = sign.isSignedIn();
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void tc03SignInSuccessfullyToSystem() throws InterruptedException {
		// SIGN IN TO THE SYSTEM WITH USER ALREADY EXIST
	//	WelcomePage login = new WelcomePage(driver);
		SignInPage sign = new SignInPage(driver);
		String mail = "Itamar831@gmail.com";
		String password = "qjeLx9ce!";
		//login.clickSignIn();
		sign.signInUser(mail, password);
		// ASSERT TO CHECK IF ELEMNT OF SIGN OUT IS DISPLAYED IF DISPLAYED MEANING
		// CREATE A USER WAS SUCCESSFULL
		boolean actual = sign.isSignedIn();
		boolean expected = true;
		assertEquals(actual, expected);
		
	}

	@DataProvider
	public Object[][] getDataFromExcel() {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\SignInUsers.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}
}
