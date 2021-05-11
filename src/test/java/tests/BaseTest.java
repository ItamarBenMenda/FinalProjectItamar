package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

public class BaseTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));
		//driver.get("http://automationpractice.com/index.php");           
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
