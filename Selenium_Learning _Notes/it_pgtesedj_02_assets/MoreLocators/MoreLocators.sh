
########################### 
demo-17-MoreLocators
###########################

# Go to this page

https://www.saucedemo.com/

# Login with

Username: standard_user

Password: secret_sauce

# Add one item to cart

# Click on the cart

# Click on the navigation menu on the left -> Logout

# In the login page

# Right-click -> Inspect the login element

# Note that it is inside this div - select this <div> and show

class="login-box"


# Inside this <div> we have <input> - select each and show


id="user-name"

# and

id="password"


# login button

id="login-button" and class="submit-button btn_action"



--------------------------------------------------
# Now let's automate logging in using CSS selectors (v01)



    @Test
    public void cssSelectorsLocatorsTest() {
        driver.get(SITE);

        // Select by .className selector
        WebElement loginEl = driver.findElement(By.cssSelector("div.login-box"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

        // Find within a subset of the DOM
        // Select by #id (with or without tag name)
        WebElement usernameEl = loginEl.findElement(By.cssSelector("#user-name"));
        WebElement passwordEl = loginEl.findElement(By.cssSelector("input#password"));

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();

        WebElement submitButtonEl = loginEl.findElement(By.cssSelector(".submit-button"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");
    }



--------------------------------------------------
# Can specify CSS selectors in different ways (v02)


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
    }


# Run and show


--------------------------------------------------
# Specify combinations of attributes and attribute prefixes and suffixes (v03)



# Go to this page

https://www.saucedemo.com/

# Login with

Username: standard_user

Password: secret_sauce

# Right-click and inspect the "Add to Cart" button of the first item

Sauce Labs Backpack

# Click on "Add to Cart" for backpack


# Right-click and inspect the "Add to Cart" button of the onesie

Sauce Labs Onesie

# Click on "Add to Cart" for onesie


# Right-click and inspect the "Shopping Cart" link on the top right


# Click on the shopping cart link


# Right-click and inspect the "Continue Shopping" button on the bottom left


# Click on the "Continue Shopping" button


# Now update the code as follows



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


# Run the code and show


--------------------------------------------------
# Use xpath (v04)


# We will build this up bit-by-bit

# Replace the test with this partial test case


    @Test
    public void xpathLocatorsTest() {
        driver.get(SITE);

        WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

    }


# Now go to this page (make sure you are on the login page)

https://www.saucedemo.com/


# Right click on the username text box -> inspect

# Select the <input> element -> right-click -> Copy -> Copy full XPath


/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input


# Now add this line of code to the test

        WebElement usernameEl = loginEl.findElement(By.xpath(
                "/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));



# Right click on the password text box -> inspect

# Select the <input> element -> right-click -> Copy -> Copy XPath



# Now add this line of code to the test


        WebElement passwordEl = loginEl.findElement(By.xpath("//*[@id=\"password\"]"));

# And then the usual

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();



# Right click on the Login button -> inspect

# Select the <input> element -> right-click -> Copy -> Copy XPath

# Now add this line of code to the test

        WebElement submitButtonEl = loginEl.findElement(By.xpath("//*[@id=\"login-button\"]"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");

# Login and show

# Now click on the "Sauce Labs Backpack" go to the product page and then click back

# Now click on the "Sauce Labs Onesie" go to the product page and then click back


# Add this to the test



        WebElement addToCartBackpackLinkEl = driver.findElement(By.linkText("Sauce Labs Backpack"));

        addToCartBackpackLinkEl.click();

        delay();

        driver.navigate().back();

        WebElement addToCartOnesieLinkEl = driver.findElement(By.partialLinkText("Onesie"));

        addToCartOnesieLinkEl.click();

        delay();

        driver.navigate().back();


# The whole test should look like this


    @Test
    public void xpathLocatorsTest() {
        driver.get(SITE);

        WebElement loginEl = driver.findElement(By.cssSelector("div[class='login-box']"));

        Assert.assertTrue(loginEl.isEnabled());
        Assert.assertTrue(loginEl.isDisplayed());

        WebElement usernameEl = loginEl.findElement(By.xpath(
                "/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        WebElement passwordEl = loginEl.findElement(By.xpath("//*[@id=\"password\"]"));

        usernameEl.sendKeys("standard_user");
        passwordEl.sendKeys("secret_sauce");

        delay();

        WebElement submitButtonEl = loginEl.findElement(By.xpath("//*[@id=\"login-button\"]"));
        submitButtonEl.submit();

        delay();

        Assert.assertEquals(driver.getCurrentUrl(), SITE + "inventory.html");

        WebElement addToCartBackpackLinkEl = driver.findElement(By.linkText("Sauce Labs Backpack"));

        addToCartBackpackLinkEl.click();

        delay();

        driver.navigate().back();

        WebElement addToCartOnesieLinkEl = driver.findElement(By.partialLinkText("Onesie"));

        addToCartOnesieLinkEl.click();

        delay();

        driver.navigate().back();
    }


# Run the test and show it passes











