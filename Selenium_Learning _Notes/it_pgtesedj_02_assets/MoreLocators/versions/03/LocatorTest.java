package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class LocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://www.saucedemo.com/";

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }

    private static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void cssSelectorsLocatorsTest() {
        driver.get(SITE);

        // "<tagname>[class=’<class value>’]"
        WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

        // "<tagname>[id=’<id value>’]"
        WebElement usernameEl = loginEl.findElement(By.cssSelector("input[id='user-name']"));
        WebElement passwordEl = loginEl.findElement(By.cssSelector("input[id='password']"));

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();

        // "<tagname>[attr=’<attr value>’]"
        WebElement submitButtonEl = loginEl.findElement(By.cssSelector("input[data-test='login-button']"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");

        // Add first product to cart
        WebElement addToCartBackpackEl = driver.findElement(By.cssSelector(
                "button.btn_inventory[name='add-to-cart-sauce-labs-backpack']"));

        addToCartBackpackEl.click();

        // Add second product to cart
        WebElement addToCartOnesieEl = driver.findElement(By.cssSelector(
                "button#add-to-cart-sauce-labs-onesie[data-test='add-to-cart-sauce-labs-onesie']"));

        addToCartOnesieEl.click();

        delay();

        // Click on the shopping cart link using the prefix of an attribute
        WebElement shoppingCartLinkEl = driver.findElement(By.cssSelector(
                "a[class^='shopping_cart']"));

        shoppingCartLinkEl.click();

        delay();

        // Click on the continue shopping button using the suffix of an attribute
        WebElement continueShoppingButtonEl = driver.findElement(By.cssSelector(
                "button[id$='inue-shopping']"));

        continueShoppingButtonEl.click();

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
