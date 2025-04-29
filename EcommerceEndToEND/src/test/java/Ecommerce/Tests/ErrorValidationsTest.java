package Ecommerce.Tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
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
import Ecommerce.PageObjects.ProductCatalogue;
import Ecommerce.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException{
	
		landingPage.loginApplication("kartikey2@mightcode.com", "Testw@123");
		AssertJUnit.assertEquals(landingPage.getErrorMessage() ,"Incorrect email or password.");
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException{

		String productName = "ZARA COAT 3";
	
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addproductTocart(productName);
		CartPage cartPage = productCatalogue.goToCartPagae();
		
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
