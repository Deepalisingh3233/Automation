package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActionsTest {

    private WebDriver driver;

    private static final String SITE = "https://demoqa.com/buttons";

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(DriverFactory.BrowserType.CHROME);
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void clickTest() {
        driver.get(SITE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[h1[text()='Buttons']]")));

        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight / 3)");
        WebElement clickButton = driver.findElement(By.xpath(
                "//button[text()='Click Me']"));

        new Actions(driver)
                .click(clickButton)
                .perform();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));

        Assert.assertEquals(messageElement.getText(), "You have done a dynamic click");

        delay();
    }

    @Test
    public void doubleClickTest() {
        driver.get(SITE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[h1[text()='Buttons']]")));

        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight / 3)");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        new Actions(driver)
                .doubleClick(doubleClickButton)
                .perform();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

        Assert.assertEquals(messageElement.getText(), "You have done a double click");
        delay();
    }


    @Test
    public void rightClickTest() {
        driver.get(SITE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[h1[text()='Buttons']]")));

        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight / 3)");

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

        new Actions(driver)
                .contextClick(rightClickButton)
                .perform();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));

        Assert.assertEquals(messageElement.getText(), "You have done a right click");
        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
