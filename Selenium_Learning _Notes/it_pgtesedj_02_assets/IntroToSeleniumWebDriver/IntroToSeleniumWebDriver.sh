
########################### 
demo-12-IntroductionToSeleniumWebdriver 
###########################

# Please make sure to recording in the loonycorn login

# Before recording remove the .m2 folder on your local machine ~/loonycorn/.m2

# Before recording remove the .cache folder on your local machine ~/loonycorn/.cache


# This will ensure that you have no Maven dependencies on your machine


# Both Java and Maven should be installed on your machine (have it already installed)

# On the terminal
java --version

# Run following command to check the maven version
mvn --version


# Go to the bash profile
nano ~/.bash_profile

# Show the JAVA_HOME and PATH environment variables (should be already configured)

# Show where you can install Java and Maven from

# Go to 

https://www.oracle.com/in/java/technologies/downloads/

# Click on JDK 17 and show the options

# Click on

Linux
MacOS
Windows

# Show where you can download Maven

https://maven.apache.org/download.cgi

# Show how you can install Maven

https://maven.apache.org/install.html


-------------------------------------------------
# Set up a new IntelliJ project

# For that open intellij
# Create a new project -> choose java and maven for this
# Store project in ~/IdeaProjects
# and give the name for the project

learning-selenium

# Check JDK 17

# Click on Advanced Settings to set the groupId and artifactId

groupId: com.loonycorn.learningselenium
artifactdId: learning-selenium


# A new project will be created, show pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.loonycorn.learningselenium</groupId>
    <artifactId>learning-selenium</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>


# Show the project structure

src/main/java/com/loonycorn/learningselenium/Main.java

src/test/java 


# Now let's see how you can set up and use Selenium in this project


# Let's go to following link
https://www.selenium.dev/

# Click on 

# These are the main parts of selenium 

# Click on 

Selenium WebDriver

# Click on "Getting Started" from the left

# Click on "Install a Selenium Library"

# Show how you can add the Maven dependency

# Go to 

https://mvnrepository.com/

# Search for 

selenium

# Click on the first link

Selenium Java

# Click on the latest version

4.19.1


# Select and let's add this to our pom.xml


    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.19.1</version>
        </dependency>
    </dependencies>


# Go back to 

https://mvnrepository.com/

# Search for

testng

# Select the latest version and add to pom.xml

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.1</version>
    <scope>test</scope>
</dependency>


# Reload the Maven project so the red lines disappear

# Click on "External Dependencies" on the left and show the dependencies are present in our project


-------------------------------------------------

# We're now ready to write our first Selenium test

# Right-click on "test" -> New file

java/com/loonycorn/learningselenium/WebDriverTest.java

# (This will set up the file with the right folder structure)


package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverTest {

    @Test
    public void navigateToPageUsingChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}


# Click on the "play" icon for the class and run the test

# A Chrome window should pop up on the screen and should be on Google

# Close the window and add to the tests

    @Test
    public void navigateToPageUsingFireFox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://duckduckgo.com");
    }

# Use the "play" button to run only this test

# Show that FireFox pops up on the duckduckgo site


# Now add another test

    @Test
    public void navigateToPageUsingEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://bing.com");
    }

# Use the "play" button to run only this test

# Show that Edge pops up on the bing site


# Now click on the "play" button of the whole class to run *all* tests

# Show that the three browsers show up and are still up - they are not closed

# Add this code to all 3 tests


        driver.quit();


 # Code looks like this
 
 public class WebDriverTest {

    @Test
    public void navigateToPageUsingChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.quit();
    }

    @Test
    public void navigateToPageUsingFireFox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://duckduckgo.com");

        driver.quit();
    }

    @Test
    public void navigateToPageUsingEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://bing.com");

        driver.quit();
    }
}
       

# Now click on the "play" button of the whole class to run *all* tests

# Each browser comes up and shuts down 


-------------------------------------------------
# Now interacting with browsers in Selenium need drivers. Where are these drivers?

##################################
# Notes

# Note how easy it was to bring up the different browser observe identity whether these Browser for installed or not on my machine it doesn't matter whether there installed or not this will tell work that's because the Selenium manager automatically download the install the drivers that you need to run these different browsers


# Selenium WebDriver uses browser-specific drivers to interact with web browsers. These drivers act as intermediaries between the Selenium WebDriver scripts and the browser instances. They facilitate communication between the Selenium WebDriver API and the browser's native automation interface.

# Here are the main browser drivers used by Selenium:

# ChromeDriver: ChromeDriver is the WebDriver implementation for Google Chrome. It allows Selenium WebDriver to control and automate interactions with Chrome browser instances.

# GeckoDriver: GeckoDriver is the WebDriver implementation for Mozilla Firefox. It enables Selenium WebDriver to automate Firefox browser instances.

# WebDriver for Microsoft Edge (EdgeDriver): EdgeDriver is the WebDriver implementation for Microsoft Edge. It enables Selenium WebDriver to interact with Edge browser instances.

##################################


# Open up the Finder window on 

~/loonycorn

# Hit "Cmd + Shift + ." to see hidden folders

# Show the .cache folder

# Expand the contents of this folder and show the drivers for the browsers we used





##################################
# Notes

# Note how easy it was to bring up the different browser observe identity whether these Browser for installed or not on my machine it doesn't matter whether there installed or not this will tell work that's because the Selenium manager automatically download the install the drivers that you need to run these different browsers

# https://www.selenium.dev/documentation/selenium_manager/

# TL;DR: Selenium Manager automatically discovers, downloads, and caches the drivers required by Selenium when these drivers are unavailable.

# The primary feature of Selenium Manager is called automated driver management. Let’s consider an example to understand it. Suppose we want to driver Chrome with Selenium (see the doc about how to start a session with Selenium). Before the session begins, and when the driver is unavailable, Selenium Manager manages chromedriver for us. We use the term management for this feature (and not just download) since this process is broader and implies different steps:

# Browser version discovery. Selenium Manager discovers the browser version (e.g., Chrome, Firefox, Edge) installed in the machine that executes Selenium. This step uses shell commands (e.g., google-chrome --version).
# Driver version discovery. With the discovered browser version, the proper driver version is resolved. For this step, the online metadata/endpoints maintained by the browser vendors (e.g., chromedriver, geckodriver, or msedgedriver) are used.
# Driver download. The driver URL is obtained with the resolved driver version; with that URL, the driver artifact is downloaded, uncompressed, and stored locally.
# Driver cache. Uncompressed driver binaries are stored in a local cache folder (~/.cache/selenium). The next time the same driver is required, it will be used from there if the driver is already in the cache.

# TL;DR: Selenium Manager automatically discovers, downloads, and caches the browsers driven with Selenium (Chrome, Firefox, and Edge) when these browsers are not installed in the local system.

# As of Selenium 4.11.0, Selenium Manager also implements automated browser management. With this feature, Selenium Manager allows us to discover, download, and cache the different browser releases, making them seamlessly available for Selenium. Internally, Selenium Manager uses an equivalent management procedure explained in the section before, but this time, for browser releases.


# TL;DR: Selenium Manager is used by the Selenium bindings when the drivers (chromedriver, geckodriver, etc.) are unavailable.

##################################



