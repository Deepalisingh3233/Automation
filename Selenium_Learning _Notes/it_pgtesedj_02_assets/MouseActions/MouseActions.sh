
########################### 
demo-19-MouseActions 
###########################

# In IntelliJ
# Rename the test to MouseActionsTest behind the scenes



# Click

# Let's use the following website to for the click mouse actions
https://demoqa.com/buttons

# Let's go to this url and we can see 3 buttons there

# Click the button and see how that response is coming in the bottom
You have done a dynamic click


# Right-click -> Inspect the HTML

# Show the HTML of the 3 buttons (IMPORTANT show all 3)

click me - //button[text()='Click Me' - This button we are taking the xpath

Right click me - rightClickBtn

double click me - doubleClickBtn

# Click, Right-click, and double-click on each button and show the messages

# Right-click -> Inspect on the messages and show the id of the contents



----------------------------------------------------
# Let's use the actions API to handle clicks (v01)


package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
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
        WebElement buttonsDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[h1[text()='Buttons']]")));

        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight / 3)");
        WebElement clickButton = buttonsDiv.findElement(By.xpath(
                "//button[text()='Click Me']"));

        new Actions(driver)
                .click(clickButton)
                .perform();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));

        Assert.assertEquals(messageElement.getText(), "You have done a dynamic click");

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


# Run the code and this is success
# Next will check the double click using actions

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


# Next let's do the right click using actions




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




----------------------------------------------------
# Let's use the actions API to handle hover (v02)


# For that we will use following website
https://demoqa.com/menu


# Go to this website and hover over Main Item 2

# Next we can see while hovering we can see that 3 options will appear there

# Hover over SUB SUB List >>

# And show the nested hover menu that appears there

# Let's right click on Main Item 2 and inspect and find the xpath for that

# So let's see how this mouse hovering is going to work

# Replace all the click tests with this single test

    private static final String SITE = "https://demoqa.com/menu";


    @Test
    public void hoverTest() {
        driver.get(SITE);

        WebElement mainItem2El = driver.findElement(
                By.xpath("//a[text()='Main Item 2']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(mainItem2El).perform();

        delay();

        WebElement subItem1El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subItem2El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subSubItemEl = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        Assert.assertTrue(subItem1El.isDisplayed());
        Assert.assertTrue(subItem2El.isDisplayed());
        Assert.assertTrue(subSubItemEl.isDisplayed());
    }


# Run the code and the test will pass

# Add the following code to the test


        System.out.println("******************** Main menu hovering is done ********************");

        actions.moveToElement(subSubItemEl).perform();

        delay();

        WebElement subSubItem1El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        WebElement subSubItem2El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));

        Assert.assertTrue(subSubItem1El.isDisplayed());
        Assert.assertTrue(subSubItem2El.isDisplayed());

        System.out.println("******************** Nested hovering is done ********************");


# Code should now look like this

 @Test
    public void hoverTest() {
        driver.get(SITE);

        WebElement mainItem2El = driver.findElement(
                By.xpath("//a[text()='Main Item 2']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(mainItem2El).perform();

        delay();

        WebElement subItem1El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subItem2El = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subSubItemEl = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        Assert.assertTrue(subItem1El.isDisplayed());
        Assert.assertTrue(subItem2El.isDisplayed());
        Assert.assertTrue(subSubItemEl.isDisplayed());

        System.out.println("******************** Main menu hovering is done ********************");

        actions.moveToElement(subSubItemEl).perform();

        delay();

        WebElement subSubItem1El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        WebElement subSubItem2El = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));

        Assert.assertTrue(subSubItem1El.isDisplayed());
        Assert.assertTrue(subSubItem2El.isDisplayed());

        System.out.println("******************** Nested hovering is done ********************");

    }

# Run the code and we will get following output here

******************** Main menu hovering is done ********************
******************** Nested hovering is done ********************


----------------------------------------------------
# Let's use the actions API to handle drag and drop (v02)

# Go to this link and you can see that you can drag an element and drop to another
# Drag and drop and make sure this websites works fine

https://demoqa.com/droppable

# Next inspect on the drag me element and we will get following element

<div id="draggable" class="drag-box mt-4 ui-draggable ui-draggable-handle" style="position: relative;">Drag me</div>

# Next get the element for Drop here as well
<div id="droppable" class="drop-box ui-droppable"><p>Drop here</p></div>



# After that let's write the code and see how can we automate them properly



    private static final String SITE = "https://demoqa.com/droppable";



    @Test
    public void dragDropTest() {
        driver.get(SITE);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        Assert.assertEquals(droppable.getText(), "Dropped!");

        delay();
    }







