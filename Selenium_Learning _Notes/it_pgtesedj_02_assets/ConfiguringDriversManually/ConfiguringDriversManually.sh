
########################### 
demo-13-ConfiguringDriversManually 
###########################

# Open up a Chrome window

Click on the chrome -> About Google Chrome

# Now we can see the version, for me now it is currently
Version 122.0.6261.112 (Official Build) (x86_64)


# While downloading please keep this in mind according to this version only we have to download the driver


# Go to this link
https://googlechromelabs.github.io/chrome-for-testing/


# Next go to the following link
https://storage.googleapis.com/chrome-for-testing-public/122.0.6261.111/mac-x64/chromedriver-mac-x64.zip

# From here we can choose which chrome version we want 
# Here I am using macOS so choosing following link
https://drive.google.com/drive/folders/1iAQRODbIaxXsY0BedRhnBMN_uHkI73VR

# After downloading we will keep that folder in home directory
# And while writing the code ready, we will give the path of the chrome driver

# Check the version of chromedriver
cd chromedriver-mac-x64

# This is the command to check the version
./chromedriver --version
# while running it might ask to give permission to open the file
# In that case go to the system preferences -> status and privacy
# Then give permission to allow access download from chrome
# Then the code will execute

# This will return the following result
ChromeDriver 122.0.6261.111 (9d4c1072da62b411b351a38b9ed6214ab236aa7b-refs/branch-heads/6261@{#1015})


# ********************************************
# Now go back to IntelliJ

# Update the code in WebDriverTest.java

# 

package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverTest {

    @Test
    public void navigateToPageUsingChrome() {
        System.setProperty(
            "webdriver.chrome.driver", "/Users/loonycorn/chromedriver-mac-x4/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}

# This should work!

# Now run the code, we can see that the chrome has open automatically 
# And has redirected to the google.com page and stays there
# That means our selenium is working fine

# Let's make a modification in our setup

# Let's delete the chromedriver-mac-x64 folder

# Now go to the following link
https://chromedriver.chromium.org/downloads

# And click on the following
ChromeDriver 114.0.5735.90

# And it will redirect to the following

https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/

# click on this and download
chromedriver_mac64.zip


# Extract this and place the folder in the ~/loonycorn folder


# Let's redirect to the terminal

ls -l


# Go to the chromedriver_mac64
cd chromedriver_mac64

# Run the following code
./chromedriver --version

# Now file has downloaded and we have added to the path
# Notice this line of code


System.setProperty("webdriver.chrome.driver", "/Users/loonycorn/chromedriver_mac64/chromedriver");


# Run the program and it is showing following error

Exception in thread "main" org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: session not created: This version of ChromeDriver only supports Chrome version 114
Current browser version is 122.0.6261.112 with binary path /Applications/Google Chrome.app/Contents/MacOS/Google Chrome 

# This means each time of the browser update we have to update the browser as well
# For this selenium came up with a solution where,
# You don't have to specify any driver from selenium 4 onwards
# so we can remove this line of code

System.setProperty("webdriver.chrome.driver", "/Users/athira/chromedriver_mac64/chromedriver");


# Now make one more change

# Go to the applications and remove the Google chrome from there
# Now we don't have any Google chrome installed in our machine

# It runs successfully and it opens a chrome browser
# And notice the icon of chrome it has a label called Test


# Also it shows a warning in the top saying that, this chrome is only for automation testing
# Now run the code and we can see from selenium 4 onwards we don't need any explicit driver

# https://www.selenium.dev/documentation/webdriver/browsers/chrome/
# https://stackoverflow.com/questions/76477186/selenium-not-requiring-chromedriver

# ********************************************


















































