package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://developer.chrome.com/docs/chromedriver/capabilities");

       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src, new File("/home/unicode/Documents/Selenium/selenium/src/main/java/Screenshots/screenshot.png"));


    }
}
