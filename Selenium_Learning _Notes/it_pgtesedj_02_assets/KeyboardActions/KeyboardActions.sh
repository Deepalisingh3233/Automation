
##################### 
demo-20-KeyboardActions 
##########################

##########################
# https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/

# There are only 2 actions that can be accomplished with a keyboard: pressing down on a key, and releasing a pressed key. In addition to supporting ASCII characters, each keyboard key has a representation that can be pressed or released in designated sequences.

##########################


# Please rename the test file to KeyboardActionsTest.java

# Show this page

https://testpages.eviltester.com/styled/basic-html-form-test.html

----------------------------------------------------
# Use sendKeys and action chaining (v01)

# Add this code

package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyboardActionsTest {

    private WebDriver driver;

    private static final String SITE = "https://testpages.eviltester.com/styled/basic-html-form-test.html";

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
    public void keyboardActionsTest() {
        driver.get(SITE);

        WebElement usernameEl = driver.findElement(By.name("username"));
        WebElement passwordEl = driver.findElement(By.name("password"));
        WebElement commentsEl = driver.findElement(By.name("comments"));

        commentsEl.clear();

        Actions actions = new Actions(driver);

        actions.sendKeys(usernameEl, "John Smith")
                .sendKeys(passwordEl, "password123")
                .sendKeys(commentsEl, "Some comments here")
                .perform();


        delay();

        WebElement submitInputEl =  driver.findElement(By.cssSelector("input[value='submit']"));

        submitInputEl.submit();

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://testpages.eviltester.com/styled/the_form_processor.php");

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



# Run the test and show - should see the fields getting filled



----------------------------------------------------
# Use can use keys as well (v02)

# Replace the previous actions with this


        Actions actions = new Actions(driver);

        actions.keyDown(Keys.SHIFT)
               .sendKeys(commentsEl, "Some comments here")
               .keyUp(Keys.SHIFT)
               .sendKeys(usernameEl, "John Smith")
               .sendKeys(passwordEl, "password123")
               .perform();

        System.out.println("Username: " + usernameEl.getAttribute("value"));
        System.out.println("Password: " + passwordEl.getAttribute("value"));
        System.out.println("Comments: " + commentsEl.getAttribute("value"));



# Code looks like this


    @Test
    public void keyboardActionsTest() {
        driver.get(SITE);

        WebElement usernameEl = driver.findElement(By.name("username"));
        WebElement passwordEl = driver.findElement(By.name("password"));
        WebElement commentsEl = driver.findElement(By.name("comments"));

        commentsEl.clear();

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.SHIFT)
               .sendKeys(commentsEl, "Some comments here")
               .keyUp(Keys.SHIFT)
               .sendKeys(usernameEl, "John Smith")
               .sendKeys(passwordEl, "password123")
               .perform();

        System.out.println("Username: " + usernameEl.getAttribute("value"));
        System.out.println("Password: " + passwordEl.getAttribute("value"));
        System.out.println("Comments: " + commentsEl.getAttribute("value"));

        delay();

        WebElement submitInputEl =  driver.findElement(By.cssSelector("input[value='submit']"));

        submitInputEl.submit();

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://testpages.eviltester.com/styled/the_form_processor.php");

        delay();
    }


# Run and show that the comments are capitalized

# Username: John Smith
# Password: password123
# Comments: SOME COMMENTS HERE


----------------------------------------------------
# Let's manipulate the text we input using keys (v03)

# So everything works fine here
# Next we will check another key to using left right arrows
# I want to change the name such a way that, I will add a middle name as well
# We know the last name is Smith, it has 5 charaters
# So we should go to left 5 times and add the name there
# To go to left we will use following command

# Just update the actions in the test


        actions.sendKeys(usernameEl, "John Smith")
               .sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT)
               .keyDown(Keys.SHIFT)
               .sendKeys("Oliver ")
               .keyUp(Keys.SHIFT)
               .sendKeys(passwordEl, "password123")
               .sendKeys(commentsEl, "Some comments here")
               .perform(); 


# Run and show the results

# Username: John OLIVER Smith
# Password: password123
# Comments: Some comments here


----------------------------------------------------
# More text manipulation, delete the last name (v04)

# Just update the actions like this

        actions.sendKeys(usernameEl, "John Smith")
                .sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys("Oliver ")
                .pause(Duration.ofSeconds(2))
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT)
                .sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
                .pause(Duration.ofSeconds(5))
                .sendKeys(passwordEl, "password123")
                .sendKeys(commentsEl, "Some comments here")
                .perform();


# Note that you can pause after performing an action if needed

# Run and show output

Username: John OLIVER
Password: password123
Comments: Some comments here



----------------------------------------------------
# Copy-paste (v05)


# Replace the actions

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        actions.sendKeys(usernameEl, "John Smith")
               .keyDown(Keys.SHIFT)
               .sendKeys(Keys.ARROW_UP)
               .keyUp(Keys.SHIFT)
               .keyDown(cmdCtrl)
               .sendKeys("xvv")
               .keyUp(cmdCtrl)
               .sendKeys(passwordEl, "password123")
               .sendKeys(commentsEl, "Some comments here")
               .perform();


# Run and show the results

# Username: John SmithJohn Smith
# Password: password123
# Comments: Some comments here

















