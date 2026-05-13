package com.learningcucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.learningcucumber.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	
	public static final String SITE = "https://www.saucedemo.com/";
	
	@Before
	public void setUp() {
		driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
	}
	
	@Given("User is on the login page")
	public void user_is_on_login_page() {
		driver.get(SITE);
	}
	
	@When("User enters a valid username")
	public void user_enters_valid_username() {
		WebElement usernameEl = driver.findElement(By.id("user-name"));
		usernameEl.sendKeys("standard_user");
	}
	
	@When("User enters a valid password")
	public void user_enters_valid_password() {
		WebElement passwordEl = driver.findElement(By.id("password"));
		passwordEl.sendKeys("secret_sauce");
	}
	
	@When("User clicks on the login button")
	public void user_clicks_on_login_button() {
		WebElement loginButtonEl = driver.findElement(By.id("login-button"));
		loginButtonEl.click();
	}
	
	@Then("User navigates to the inventory page")
	public void user_navigates_to_inventory_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "login failed");
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
