
########################### 
demo-16-Locators
###########################


https://www.selenium.dev/documentation/webdriver/elements/locators

###########################

# In Selenium, locators are mechanisms used to find and interact with elements on a web page. When automating tests with Selenium WebDriver, you often need to locate specific elements (like buttons, text fields, links, etc.) on the web page to perform actions such as clicking, typing, or reading text.

# Selenium provides several methods for locating elements, and each method uses a specific type of locator to find elements in the HTML DOM (Document Object Model) of the web page. 
###########################


--------------------------------------------------
# Accessing locators and observing web elements

# Go to

https://www.demoblaze.com/

# Show the URL appends /index.html

# Click on the tabs on top

Home, Contact, About us, Cart, Login, Sign up


# Go back home, click on the categories

Phones
Laptops
Monitors

# Click on any product

# Add to cart

# Go to the cart page and show it is there

# Click on "delete" to remove from cart



# First let's see how id locator works
# For that first let's go to the PRODUCT STORE in the top left
# And right click and choose inspect

# You can see the element in the right side which has high lightened and we can see that

<a class="navbar-brand" id="nava" href="index.html"><img width="50" height="50" style="margin-right:10px" src="bm.png">
      PRODUCT STORE</a>

# For example this is the element of the PRODUCT STORE


--------------------------------------------------
# Rename the test to LocatorTest behind the scenes (v01)

# Add the code to LocatorTest

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LocatorTest {

    private WebDriver driver;

    private static final String SITE = "https://www.demoblaze.com/";

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
    public void idLocatorsTest() {
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


# Now add the details of the test


        driver.get(SITE);

        WebElement logoEl = driver.findElement("nava");

        System.out.println("Element text: " + logoEl.getText());

        Assert.assertTrue(logoEl.isDisplayed());
        Assert.assertTrue(logoEl.isEnabled());


# Hover over the red underline and show

# Run the code and show the error


# Start typing inside bindElement

By.

# Show the options in the popup

# Type

By.id("nava")

# Add import


import org.openqa.selenium.By;


# Run and show (PRODUCT STORE printed on console)

# Add a delay after referencing the element

 @Test
    public void idLocatorsTest() {

        WebElement logoEl = driver.findElement(By.id("nava"));

        delay();

        ...
    }


# Cmd + click on WebElement

# Show the decompiled interface

# Go to

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html


# Show the docs


--------------------------------------------------
# Click on the element and assert results (v02)




    @Test
    public void idLocatorsTest() {
        driver.get(SITE);

        driver.get(CART);

        delay();

        WebElement logoEl = driver.findElement(By.id("nava"));

        System.out.println("Element text: " + logoEl.getText());

        Assert.assertTrue(logoEl.isDisplayed());
        Assert.assertTrue(logoEl.isEnabled());
        Assert.assertFalse(logoEl.isSelected());

        logoEl.click();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");
    }


# Run and show

# Not all actions make sense on all elements

# Just BEFORE click() add this

        logoEl.sendKeys("Test");

        logoEl.click();


# Run and show it makes no difference


# Just BEFORE click() add this (replace sendKeys())

        logoEl.clear();

        logoEl.click();


# Should be an exception

org.openqa.selenium.InvalidElementStateException: invalid element state
  (Session info: chrome=123.0.6312.124)



# Just BEFORE click() add this (replace clear())

        logoEl.submit();

        logoEl.click();


# Should be an exception

java.lang.UnsupportedOperationException: To submit an element, it must be nested inside a form element

# Remove the extra broken code

# Add this code as the last line in the test (after Assert.assertEquals())

        logoEl.click();


# Code should look like this

    @Test
    public void idLocatorsTest() {
        ...

        logoEl.click();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");

        logoEl.click();
    }

# run and show the exception

org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
  (Session info: chrome=123.0.6312.124)


# This is because the logoEl is an reference to the logo element in the previous page once we navigate to a new page that reference of the compare we can no longer click on it


# Add this code just BEFORE the second logoEl.click() - second last line

        logoEl = driver.findElement(By.id("nava"));


    @Test
    public void idLocatorsTest() {
        ...

        logoEl.click();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");

        logoEl = driver.findElement(By.id("nava"));
        logoEl.click();
    }


# Run the test it should pass


--------------------------------------------------
# Manage window size using code (v03)

# Go to DriverFactory

# Update the CHROME options as follows

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;


# Run the same test and show how the window is maximized

# With this code it maximizes the page, but it is not full screen
# So let's make it full screen instead of maximize like following code

driver.manage().window().fullscreen();


# Run and show

# Make sure you go back to the old code

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;



--------------------------------------------------
# Using IDs to access multiple elements (v04)

# Let's see one more id from the same web page

# Go to

https://www.demoblaze.com/

# Right-click on the "Cart" link and show its id

id="cartur"


# Go to the footer 

# Right-click on the footer and show its id

id="footc"


# Update the code to navigate by click on the cart element



    @Test
    public void idLocatorsTest() {
        driver.get(SITE);

        WebElement footerEl = driver.findElement(By.id("footc"));

        Assert.assertNotNull(footerEl);
        Assert.assertTrue(footerEl.isDisplayed());
        Assert.assertTrue(footerEl.isEnabled());

        WebElement cartEl = driver.findElement(By.id("cartur"));

        cartEl.click();

        Assert.assertEquals(driver.getCurrentUrl(), CART);

        // Need to get this element afresh for this page
        footerEl = driver.findElement(By.id("footc"));

        Assert.assertNotNull(footerEl);
        Assert.assertTrue(footerEl.isDisplayed());
        Assert.assertTrue(footerEl.isEnabled());

        delay();

        WebElement logoEl = driver.findElement(By.id("nava"));

        logoEl.click();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "index.html");

        delay();
    }


-------------------------------------------------
# Multiple elements with same ID (v04)

# IDs should be unique on a web page, generally you should not have multiple 
# elements with the same id


# Now go to the following url again and click on Laptops under Categories
# From here what we can understand is while clicking on Laptops only
# Laptops images will appear

# For that let's do the following
# Next right click on Laptops and inspect
# We have found that id of the Laptops

id="itemc"

# Now update the test


    @Test
    public void idLocatorsTest() {
        driver.get(SITE);

        WebElement laptopEl = driver.findElement(By.id("itemc"));

        Assert.assertNotNull(laptopEl);
        Assert.assertTrue(laptopEl.isDisplayed());
        Assert.assertTrue(laptopEl.isEnabled());

        laptopEl.click();

        delay();
    }




# Run the code and we suppose to get it clicked on Laptops
# But it is clicking on phones

# We are not able to see why it is clicking on phones only

# To check that let's see the text which is attach to the id
# for that we have to add this line

        System.out.println("Category text: " + laptopEl.getText());



# Run the code and following is the output
Category text: Phones


# This means it is not clicking the laptops, it is clicking on Phones


# Let's go and inspect phones now in the browser

# Right click on phones and click on inspect

# Look at the id for the phone id id same as the laptop id and monitor id

# Thats why it was not coming properly for laptops


# Find element just find the first element that matches the locator that you have specified if you want to find multiple elements you have to use find elements will discuss this later


# *****************************************************************
# Find element by class
# *****************************************************************
-------------------------------------------------

# Find elements by class (v05)


# Here we will see how can we do the tests using classes
# Here first let's go to the following url

https://www.demoblaze.com/

# Right click and inspect this 

<a href="prod.html?idp_=1" class="hrefch">Samsung galaxy s6</a>

# Close Chrome dev tools

# Then click on the Samsung galaxy s6 (first product)

# This will go to the details page

# Right-click on the "Add to cart" button and inspect that

<a href="#" onclick="addToCart(1)" class="btn btn-success btn-lg">Add to cart</a>

# Click on "Add to cart"

# An alert dialog pops up

# Click on the Cart link at the top

# Click on the table row containing the Samsung Galaxy S6

<tr class="success"><td><img width="100" height="100" src="imgs/galaxy_s6.jpg"></td><td>Samsung galaxy s6</td><td>360</td><td><a href="#" onclick="deleteItem('8463f99c-e9f2-82f7-0ba4-e6624d681e37')">Delete</a></td></tr>


# Let's perform these actions using code

# This is going to be complex, we will introduce some functionality that we will cover in detail in a later path


# Replace the test case with this new one


    @Test
    public void classLocatorsTest() {
        driver.get(SITE);

        WebElement samsungGalaxyEl = driver.findElement(By.className("hrefch"));

        Assert.assertTrue(samsungGalaxyEl.isDisplayed());
        Assert.assertTrue(samsungGalaxyEl.isEnabled());

        samsungGalaxyEl.click();

        WebElement addToCartButtonEl = driver.findElement(By.className("btn-success"));

        addToCartButtonEl.click();

        // We will learn more about alerts in a later learning path
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement cartEl = driver.findElement(By.id("cartur"));

        cartEl.click();

        WebElement cartItemEl = driver.findElement(By.className("success"));

        Assert.assertTrue(cartItemEl.isDisplayed());
        Assert.assertTrue(cartItemEl.isEnabled());
    }


# When you run this you will encounter an error

org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":".hrefch"}


# We will add an implicit wait for every page to load

# Go to DriverFactory

# Add import

import java.time.Duration;


# Update the CHROME option

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;


# We will leave this in here for future demos

#######################################
#### NOTES

# In Selenium, implicitlyWait(Duration) is a method used to specify the amount of time the WebDriver instance should wait when trying to find an element if it is not immediately available. It is applicable for the lifetime of the WebDriver instance and affects all subsequent searches for elements.


# driver: This is an instance of the WebDriver interface, typically representing a web browser (e.g., Chrome, Firefox) controlled by Selenium.

# manage(): This method returns an instance of the Options interface, which allows you to manage various WebDriver settings.

# timeouts(): This method returns an instance of the Timeouts interface, which allows you to specify different timeouts related to WebDriver actions.

# implicitlyWait(Duration.ofSeconds(5)): This sets the implicit wait timeout to 5 seconds. The Duration.ofSeconds(5) creates a duration of 5 seconds, specifying the maximum amount of time WebDriver should wait when trying to find an element before throwing a NoSuchElementException.

# The implicit wait is useful for handling dynamic elements on a web page that may take some time to appear. It helps avoid NoSuchElementException errors by giving the web page some time to load elements before attempting to interact with them.

#######################################

# Now run the test again

# Again you will encounter an error

org.openqa.selenium.NoAlertPresentException: no such alert
  (Session info: chrome=123.0.6312.124)


# Add these imports

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


# Add this AFTER addToCartButtonEl.click()

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.alertIsPresent());


# Code now looks like this

    @Test
    public void classLocatorsTest() {
        driver.get(SITE);

        WebElement samsungGalaxyEl = driver.findElement(By.className("hrefch"));

        Assert.assertTrue(samsungGalaxyEl.isDisplayed());
        Assert.assertTrue(samsungGalaxyEl.isEnabled());

        samsungGalaxyEl.click();

        WebElement addToCartButtonEl = driver.findElement(By.className("btn-success"));

        addToCartButtonEl.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.alertIsPresent());

        // We will learn more about alerts in a later learning path
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement cartEl = driver.findElement(By.id("cartur"));

        cartEl.click();

        WebElement cartItemEl = driver.findElement(By.className("success"));

        Assert.assertTrue(cartItemEl.isDisplayed());
        Assert.assertTrue(cartItemEl.isEnabled());
    }

# Now run it will pass


# Selenium does not support compound class names for locators

# Update this line of code to use compound class names

        WebElement addToCartButtonEl = driver.findElement(By.className("btn btn-success btn-lg"));


# Run and show the error

org.openqa.selenium.InvalidSelectorException: Compound class names not permitted




# *****************************************************************
# Tagname
# *****************************************************************
# Find elements by tagName (v06)


# First let's go to the following url
https://www.demoblaze.com/ 


# Then right click and choose inspect


# After this we can see many tags are there

# From here we will start looking at a simple tag that is tag <img>

# press command+F and type <img> 

# We can see total 14 places we have a tag

# Let's press enter and we can see in the left side, each enter the places are getting highlighted


    @Test
    public void tagNameLocatorsTest() {
        driver.get(SITE);

        WebElement imgEl = driver.findElement(By.tagName("img"));

        String srcAttr = imgEl.getAttribute("src");

        Assert.assertNotNull(srcAttr);

        System.out.println("Image source:" + srcAttr);
    }


# There are many image elements but only the first one is picked and the details displayed

# Now let's see the difference between findElement and findElements

# Wherever we call driver.findElement start typing

driver.f

# Show the findElements() option

# Change the line to

        List<WebElement> imgEl = driver.findElements(By.tagName("img"));


# add this below

        for (WebElement imgEl : imgEls) {
            String srcAttr = imgEl.getAttribute("src");
            Assert.assertNotNull(srcAttr);

            System.out.println("Image source:" + srcAttr);
        }


# The code should now look like this


    @Test
    public void tagNameLocatorsTest() {
        driver.get(SITE);

        List<WebElement> imgEls = driver.findElements(By.tagName("img"));

        for (WebElement imgEl : imgEls) {
            String srcAttr = imgEl.getAttribute("src");
            Assert.assertNotNull(srcAttr);

            System.out.println("Image source:" + srcAttr);
        }

    }

# run and show the image sources printed

Image source:https://www.demoblaze.com/bm.png
Image source:https://www.demoblaze.com/Samsung1.jpg
Image source:https://www.demoblaze.com/nexus1.jpg
Image source:https://www.demoblaze.com/iphone1.jpg
Image source:https://www.demoblaze.com/bm.png


-------------------------------------------------

# Find elements by tag name and assert number of elements 
# Also evaluating only a subset of the DOM rather than the entire DOM (v07)

# Go to

https://www.demoblaze.com/

# Click on

Phones (7 items)
Laptops (6 items)
Monitors (2 items)

# Right-click -> Inspect

# The class containing all this information is

<div class="row" id="tbodyid">


# Select this and show


# Now back to the test


    @Test
    public void tagNameLocatorsTest() {
        driver.get(SITE);

        List<WebElement> categoriesEls = driver.findElements(By.id("itemc"));

        for (WebElement categoryEl : categoriesEls) {

            System.out.println("---------------");
            System.out.println("Category clicked: " + categoryEl.getText());

            categoryEl.click();

            // This is needed to ensure that the categories are updated due to the click
            delay();

            WebElement containerEl = driver.findElement(By.id("tbodyid"));

            // Search a subset of the DOM (to find only the links within the main page)
            List<WebElement> linkEls = containerEl.findElements(By.tagName("a"));

            for (WebElement linkEl : linkEls) {
                String hrefAttr = linkEl.getAttribute("href");
                Assert.assertNotNull(hrefAttr);

                System.out.println("URL:" + hrefAttr);
            }

        }
    }


# Note how we use a previously accessed dom element to search the subset of the dom

# Run and show the output




# *****************************************************************
# name
# *****************************************************************
# Find elements by name (v08)

# Go to

https://www.demoblaze.com/

# Right-click -> Inspect on the previous/next buttons at the bottom right


<form name="frm">


# Expand this element and show how the buttons are set up

# IMPORTANT: Expand the whole section under the <form> so it is clear


# Now let's write some code


    @Test
    public void nameLocatorsTest() {
        driver.get(SITE);

        WebElement formEl = driver.findElement(By.name("frm"));

        Assert.assertTrue(formEl.isEnabled());
        Assert.assertTrue(formEl.isDisplayed());

        List<WebElement> buttonsEl = formEl.findElements(By.tagName("button"));

        // Make sure we have two buttons and both displayed
        Assert.assertEquals(buttonsEl.size(), 2);
        Assert.assertTrue(buttonsEl.get(0).isDisplayed());
        Assert.assertTrue(buttonsEl.get(1).isDisplayed());

        System.out.println("Button text: " + buttonsEl.get(0).getText());
        System.out.println("Button text: " + buttonsEl.get(1).getText());
    }

# Run and show the console output









