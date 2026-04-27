
########################### 
demo-21-InteractingWithOtherUIWidgets
###########################

# Rename the file to UIWidgetsTest


# We will work with the same eviltester site

---------------------------------------------------
# Radio button selection (v01)


package com.loonycorn.learningselenium;

import com.loonycorn.learningselenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Platform;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UIWidgetsTest {

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
    public void radioButtonsTest() {
        driver.get(SITE);

        WebElement radio1El = driver.findElement(By.cssSelector("input[value='rd1']"));
        WebElement radio2El = driver.findElement(By.cssSelector("input[value='rd2']"));
        WebElement radio3El = driver.findElement(By.cssSelector("input[value='rd3']"));

        System.out.println("----Before clicking");
        System.out.println("Radio 1 selected: " + radio1El.isSelected());
        System.out.println("Radio 2 selected: " + radio2El.isSelected());
        System.out.println("Radio 3 selected: " + radio3El.isSelected());

        delay();

        radio3El.click();

        System.out.println("----After clicking");
        System.out.println("Radio 1 selected: " + radio1El.isSelected());
        System.out.println("Radio 2 selected: " + radio2El.isSelected());
        System.out.println("Radio 3 selected: " + radio3El.isSelected());

        Assert.assertTrue(radio3El.isSelected());

        delay();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


# Run and show the results

# ----Before clicking
# Radio 1 selected: false
# Radio 2 selected: true
# Radio 3 selected: false
# ----After clicking
# Radio 1 selected: false
# Radio 2 selected: false
# Radio 3 selected: true


# Add another test



    @Test
    public void checkboxesTest() {
        driver.get(SITE);

        WebElement checkbox1El = driver.findElement(By.cssSelector("input[value='cb1']"));
        WebElement checkbox2El = driver.findElement(By.cssSelector("input[value='cb2']"));
        WebElement checkbox3El = driver.findElement(By.cssSelector("input[value='cb3']"));

        System.out.println("----Before clicking");
        System.out.println("Checkbox 1 selected: " + checkbox1El.isSelected());
        System.out.println("Checkbox 2 selected: " + checkbox2El.isSelected());
        System.out.println("Checkbox 3 selected: " + checkbox3El.isSelected());

        delay();

        checkbox1El.click();

        System.out.println("----After clicking");
        System.out.println("Checkbox 1 selected: " + checkbox1El.isSelected());
        System.out.println("Checkbox 2 selected: " + checkbox2El.isSelected());
        System.out.println("Checkbox 3 selected: " + checkbox3El.isSelected());

        Assert.assertTrue(checkbox1El.isSelected());

        delay();
    }


# Run and show results

# ----Before clicking
# Checkbox 1 selected: false
# Checkbox 2 selected: false
# Checkbox 3 selected: true
# ----After clicking
# Checkbox 1 selected: true
# Checkbox 2 selected: false
# Checkbox 3 selected: true






