package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class WelcomePage extends BasePage {
	// LOGING FIELDS
	@FindBy(css = "#search_query_top")
	private WebElement idField;
	@FindBy(css = ".btn.btn-default.button-search")
	private WebElement searchBtn;
	@FindBy(css = ".page-heading.product-listing")
	private WebElement searchResultTxt;
	@FindBy(css = ".alert.alert-warning")
	private WebElement failedSearch;
	// CONTACT US SECTION
	@FindBy(css = "#contact-link")
	private WebElement contactUs;
	@FindBy(css = ".login")
	private WebElement signIn;
	// SECTION FOR PRODUCTS RESULTS
	@FindBy(css = "#center_column > ul > li > div")
	private List<WebElement> productList;
	@FindBy(css = "#center_column > ul > li > div >  div > div.content_price ")
	private List<WebElement> productPrices;
	// SORTING PRODUCTS SECTION
	@FindBy(css = "#selectProductSort")
	private WebElement sortBtn;
	// PRODUCTS TABS
	@FindBy(css = "#block_top_menu > ul > li")
	private List<WebElement> productsTab;
	@FindBy(css = ".cat-name")
	private WebElement categoryName;
	@FindBy(css = ".page-heading.product-listing")
	private WebElement productTitle;
	// NEWSLETTER SECTION
	@FindBy(css = "#newsletter-input")
	private WebElement newsLetterField;
	@FindBy(css = "#newsletter_block_left > div > form > div > button")
	private WebElement newsLetterBTN;
	@FindBy(css = "#columns > p")
	private WebElement newLeterStatus;
	// CONTACT US
	@FindBy(css = "#contact-link > a")
	private WebElement contactUsBTN;
	// DELIVERY DETAILS
	@FindBy(css = "#informations_block_left_1  ul > li:nth-child(1) > a")
	private WebElement deliverUrl;
	// SPECIFIC PRODUCT DETAIL
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[4]/div/div[1]/div/a[1]/img")
	private WebElement productExample;
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[4]/div/div[1]/div/a[2]/span")
	private WebElement quickViewBTN;
	@FindBy(css = ".fancybox-iframe")
	private WebElement iframe;
	// PRODUCTS LIST
	@FindBy(css = "#homefeatured >li")
	private List<WebElement> productsList;
	@FindBy(css = "#homefeatured > li> div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
	private List<WebElement> addToCartBtn;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2 > i")
	private WebElement successAdding;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
	private WebElement shoppingCounter;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span")
	private WebElement crossBtn;
	@FindBy(css = ".cart_quantity_delete > i")
	private List<WebElement> trashBtnList;
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
	private WebElement cartBtn;
	@FindBy(css = "#layer_cart_product_price")
	private WebElement productPrice;
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div:nth-child(4) > span")
	private WebElement totalSumToPay;
	@FindBy(css = "#button_order_cart")
	private WebElement checkOutBtn;

	// CONSTRUCTOR
	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	// ACTION TO GET THE URL
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	// SEARCHING FOR A PRODUCT
	public void searchProduct(String productName) throws InterruptedException {
		click(idField);
		fillText(idField, productName);
		click(searchBtn);
		Thread.sleep(5000);
	}

	// ACTION TO CLICK THE SORT PRODUCT FROM SMALL TO HIGH
	public void clickSortSmallToHigh() {
		Select sortSelection = new Select(sortBtn);
		// Selection from SMALL TO HIGH
		sortSelection.selectByIndex(1);
	}

	// RETURN THE RESULT IF A PRODUCT WAS FOUND OR NOT
	public boolean isFailedSearchExist() {
		boolean result = false;
		try {
			result = failedSearch.isDisplayed();
			return result;
		} catch (Throwable e) {
			return false;
		}
	}

	// CHECKING IF THE PRODUCTS ARE SORTED FROM SMALL TO HIGH
	public boolean sortedLowerPrice(String productName) {
		click(idField);
		fillText(idField, productName);
		click(searchBtn);
		List<WebElement> listOfprices = productPrices;
		double[] temp = new double[listOfprices.size()];
		int i = 0;
		for (WebElement product : listOfprices) {
			System.out.println(product.getText().substring(1, 6));
			temp[i] = Double.parseDouble(product.getText().substring(1, 6));
			// temp[i]= Double.valueOf(i);
			i++;
		}
		boolean sortedArray = isSortedSmallToBig(temp);
		return sortedArray;
	}

	// SCENARIO TO CLICK OVER THE TAB SECTION
	public boolean clickProducts(String productName) throws InterruptedException {
		for (WebElement product : productsTab) {
			System.out.println(product.getText());
			if (product.getText().contains(productName)) {
				click(product);
				break;
			}
		}
		Thread.sleep(8000);
		String test = categoryName.getText();
		System.out.println(test);
		if (categoryName.getText().contains(productName))
			return true;
		else
			return false;
	}

	public void clickContactUs() {
		click(contactUs);
	}

	// SCENARIO TO CLICK OVER THE TAB SECTION
	public void clickProductsTabOnly(String productName) throws InterruptedException {
		for (WebElement product : productsTab) {
			System.out.println(product.getText());
			if (product.getText().contains(productName)) {
				click(product);
				Thread.sleep(10000);
				break;
			}
		}
	}

	// ENTER MAIL FOR NEWSLETTER
	public void enterMailForNewLetter(String mail) throws InterruptedException {
		fillText(newsLetterField, mail);
		click(newsLetterBTN);
		Thread.sleep(5000);
	}

	// GET MAIL FOR NEW LETTER RESULT
	public String getTextStatus() {
		String result = newLeterStatus.getText();
		return result;
	}

	public String getProductSelectedTitle() {
		String result = productTitle.getText();
		return result;
	}

	// CLICK ON THE CONTACT US BTN
	public void clickCotnactUs() throws InterruptedException {
		click(contactUsBTN);
		Thread.sleep(2000);
	}

	// CLICK ON THE SIGNIN BTN
	public void clickSignIn() throws InterruptedException {
		Thread.sleep(10000);
		click(signIn);
		Thread.sleep(2000);
	}

	// ADD A PRODUCT TO THE CART
	public void addProduct() throws InterruptedException {
		List<WebElement> listOfproducts = productsList;
		int productsListSize = listOfproducts.size();
		Random rand = new Random();
		int index = rand.nextInt(productsListSize);
		WebElement product = listOfproducts.get(index);
		WebElement btn = addToCartBtn.get(index);
		moveMouse(product);
		Thread.sleep(8000);
		click(btn);
		Thread.sleep(4000);
		click(crossBtn);
		Thread.sleep(5000);
	}

	// ACTION TO REMOVE A PRODUCT FROM CART - BY PRESSING THE TRASH
	public void removeProduct() throws InterruptedException {
		click(cartBtn);
		Thread.sleep(4000);
		int trashBtnsSize = trashBtnList.size();
		Random rand = new Random();
		int index = rand.nextInt(trashBtnsSize);
		WebElement trash = trashBtnList.get(index);
		click(trash);
		Thread.sleep(6000);
	}

	public void clickToCheckOut() throws InterruptedException {
		moveMouse(cartBtn);
		Thread.sleep(5000);
		click(checkOutBtn);
		Thread.sleep(5000);
	}

	public int returnNumberOfProducts() {
		return trashBtnList.size();
	}

	// CLICK ON THE DELIVERY BTN
	public void clickDeliveryPage() {
		click(deliverUrl);
	}

	// CLICK ON QUICK VIEW BY HOVERING
	public void clickQuickView() throws InterruptedException {
		moveMouse(productExample);
		Thread.sleep(10000);
		click(quickViewBTN);
		Thread.sleep(10000);
	}

	// CHECKING IF IFRAME ELEMENT IS AVAILABLE
	public boolean isElementPresent() {
		try {
			iframe.isDisplayed();
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	// CHECKING IF ADDING SUCCEEDED BY CHECKING IF ELEMENT IS AVAILABLE
	public boolean isAddinSucceed() {
		try {
			successAdding.isDisplayed();
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	// FUNCTION TO CHECK IF ARRAY IS SORTED FROM SMALL TO BIGGER
	public static boolean isSortedSmallToBig(double[] array) {
		boolean isSorted = true;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					isSorted = false;
					break;
				}
			}
		}
		return isSorted;
	}

	// RETURN THE UPDATE VALUE OF THE CART COUNTER
	public int returnShoppingCounter() {
		return Integer.parseInt(shoppingCounter.getText());
	}

	// FUNCTION TO RETURN THE PRICE PRODUCT
	public double returnPriceProduct() throws InterruptedException {
		Thread.sleep(2000);
		String sum1 = productPrice.getAttribute("innerHTML").substring(1);
		double num1= Double.valueOf(sum1);
		return num1;
	}

	// FUNCTION TO RETURN THE TOTAL SUM REQUIRED TO PAY
	public double returnTotalPriceTpPay() throws InterruptedException {
		Thread.sleep(2000);
		String sum = totalSumToPay.getAttribute("innerHTML").substring(1);
		double number = Double.valueOf(sum);
		return number;
	}
}