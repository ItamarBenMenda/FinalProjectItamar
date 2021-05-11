package tests;
	import static org.testng.Assert.assertEquals;
	import org.testng.annotations.Test;
	import pageobjects.WelcomePage;
	public class ProductTabSelection extends BaseTest{	
		@Test
		public void tc01ProductTabSelection() throws InterruptedException  {
			//TEST CASE WHICH SORTING PRICES FROM LOW TO HIGHER
			WelcomePage login = new WelcomePage(driver);
			String product = "T-SHIRTS";
			boolean actual = login.clickProducts(product);
			System.out.println("THE RESULT IS " +actual);
			boolean expected = true;
			assertEquals(actual , expected);
	}
		
		@Test
		public void tc02ProductSelection() throws InterruptedException  {
			//TEST TO CHECK THAT RELEVANT PRODUCTS ARE DISPLAYED
			WelcomePage login = new WelcomePage(driver);
			String product = "T-SHIRTS ";
			login.clickProductsTabOnly(product);
			String title = login.getProductSelectedTitle();
			boolean actual = title.contains(product); 
			assertEquals(actual, true);
		}
}
