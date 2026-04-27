
########################### 
demo-18-RelativeLocators 
###########################

# Rename the IntelliJ test file to RelativeLocatorTest behind the scenes


# Go to this page

https://testpages.eviltester.com/styled/index.html

# Click on

"HTML Form Example"


# Show the form

# Enter user name and password

Bob Baker

password123


# Enter comments

Some comments here

# Click on Submit

# Show the page

----------------------------------------------------
# Use the below relative locator (v01)

# Now back to the code - set up the code

package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RelativeLocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://testpages.eviltester.com/styled/index.html";

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
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement usernameInputEl = driver.findElement(By.name("username"));
        usernameInputEl.sendKeys("Bob Baker");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).below(usernameInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement commentsInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("textarea")).below(passwordInputEl));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");

        delay();

        WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));

        submitInputEl.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));

        WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
        Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");

        WebElement passwordListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
        Assert.assertEquals(passwordListItemEl.getText(), "password123");

        WebElement commentsListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
        Assert.assertEquals(commentsListItemEl.getText(), "Some comments here");

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


# Run and show that things pass

# Please note that you may need to run 4-5 times before it passes. Just re-run till you can show the pass state


----------------------------------------------------
# Use the above relative locator (v02)



    @Test
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement commentsInputEl = driver.findElement(By.name("comments"));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(commentsInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement usernameInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
        usernameInputEl.sendKeys("Bob Baker");

        delay();

        WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));

        submitInputEl.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valuecomments")));

        WebElement commentsListItemEl = driver.findElement(By.id("_valuecomments"));
        Assert.assertEquals(commentsListItemEl.getText(), "Some comments here");

        WebElement passwordListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).above(commentsListItemEl));
        Assert.assertEquals(passwordListItemEl.getText(), "password123");

        WebElement usernameListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).above(passwordListItemEl));
        Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");
    }


# Run and show that things pass

# Please note that you may need to run 4-5 times before it passes. Just re-run till you can show the pass state


----------------------------------------------------
# Use the leftOf relative locator (v03)


# Go to the form

https://testpages.eviltester.com/styled/basic-html-form-test.html

# Right-click on the Submit button -> Inspect

# Show the buttons side-by-side

# Now update the code - to reset the form


    @Test
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement commentsInputEl = driver.findElement(By.name("comments"));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(commentsInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement usernameInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
        usernameInputEl.sendKeys("Bob Baker");

        delay();

        WebElement submitInputEl = driver.findElement(By.cssSelector("input[value='submit']"));
        WebElement cancelInputEl = driver.findElement(RelativeLocator.with(
                By.tagName("input")).toLeftOf(submitInputEl));

        cancelInputEl.click();

        delay();
    }



# Run and show that things pass

# Please note that you may need to run 2-4 times before it passes. Just re-run till you can show the pass state


----------------------------------------------------
# Use the rightOf relative locator (v04)


    @Test
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement commentsInputEl = driver.findElement(By.name("comments"));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(commentsInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement usernameInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).above(passwordInputEl));
        usernameInputEl.sendKeys("Bob Baker");

        delay();

        WebElement cancelInputEl =  driver.findElement(By.cssSelector("input[value='cancel']"));
        WebElement submitInputEl = driver.findElement(RelativeLocator.with(
                By.tagName("input")).toRightOf(cancelInputEl));

        submitInputEl.submit();

        WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
        Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");

        WebElement passwordListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
        Assert.assertEquals(passwordListItemEl.getText(), "password123");

        WebElement commentsListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
        Assert.assertEquals(commentsListItemEl.getText(), "Some comments here");


        delay();
    }


# Run and show that things pass

# Please note that you may need to run 1-2 times before it passes. Just re-run till you can show the pass state

----------------------------------------------------
# Use the near relative locator (v05)

# If the relative positioning is not obvious, 
# or it varies based on window size, 
# you can use the near method to identify an element 
# that is at most 50px away from the provided locator. 
# One great use case for this is to work with a form element 
# that doesn’t have an easily constructed locator, 
# but its associated input label element does.

# Update the code

    @Test
    public void relativeLocatorsTest() {
        driver.get(SITE);

        WebElement basicFormLinkEl = driver.findElement(By.linkText("HTML Form Example"));

        basicFormLinkEl.click();

        delay();

        WebElement usernameInputEl = driver.findElement(By.name("username"));
        usernameInputEl.sendKeys("Bob Baker");

        WebElement passwordInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("input")).near(usernameInputEl));
        passwordInputEl.sendKeys("password123");

        WebElement commentsInputEl = driver.findElement(
                RelativeLocator.with(By.tagName("textarea")).near(passwordInputEl));
        commentsInputEl.clear();
        commentsInputEl.sendKeys("Some comments here");


        delay();

        WebElement submitInputEl =  driver.findElement(By.cssSelector("input[value='submit']"));

        submitInputEl.submit();

        WebElement usernameListItemEl = driver.findElement(By.id("_valueusername"));
        Assert.assertEquals(usernameListItemEl.getText(), "Bob Baker");

        WebElement passwordListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(usernameListItemEl));
        Assert.assertEquals(passwordListItemEl.getText(), "password123");

        WebElement commentsListItemEl = driver.findElement(
                RelativeLocator.with(By.tagName("li")).below(passwordListItemEl));
        Assert.assertEquals(commentsListItemEl.getText(), "Some comments here");

        delay();
    }


# Run and show that things pass

# Please note that you may need to run 1-2 times before it passes. Just re-run till you can show the pass state













