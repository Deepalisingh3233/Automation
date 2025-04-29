package Ecommerce.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.PageObjects.CartPage;
import Ecommerce.PageObjects.CheckoutPage;
import Ecommerce.PageObjects.ConfirmationPage;
import Ecommerce.PageObjects.LandingPage;
import Ecommerce.PageObjects.OrderPage;
import Ecommerce.PageObjects.ProductCatalogue;
import Ecommerce.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver.setup(); download chromedriver in your system

	
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addproductTocart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPagae();
		
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		

		String confirmMessage = confirmationPage.getConfirmationMesssage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("kartikey2@mightcode.com", "Test@123");
		OrderPage orderPage = productCatalogue.goToOrdersPagae();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "kartikey2@mightcode.com");
		map.put("password", "Test@123");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "rahulshetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map1}};
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"kartikey2@mightcode.com", "Test@123", "ZARA COAT 3"},{"rahulshetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}};
//	}
	

}
