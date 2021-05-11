package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	WebDriver driver;
	Actions action ;
	//Use this line to give a web element style with border
	//element is the WebElement that get the style
	JavascriptExecutor js; 
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		js=(JavascriptExecutor)driver; 
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	// CLICKING ON WEBELEMENT
	public void click(WebElement el) {
		js.executeScript("arguments[0].setAttribute('style', 'border: 1px solid blue;');", el);
		el.click();
	}
	// ADDING TEXT TO FIELDS
	public void fillText(WebElement el, String text) {
		// Clearing the field before entering values
		js.executeScript("arguments[0].setAttribute('style','background-color: yellow', 'border: 1px solid blue;');", el);
		el.clear();
		el.sendKeys(text);
	}
	// GETTING TEXT FROM A FIELD
	public String getText(WebElement el) {
		return el.getText();
	}
	//MOUSE ACTIONS
	public void moveMouse(WebElement el) {
		action.moveToElement(el).build().perform();
	}
}
