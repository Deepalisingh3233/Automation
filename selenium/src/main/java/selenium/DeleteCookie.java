package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookie {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // driver.manage().deleteCookieNamed("asdf");
        //session
        //click on any link
        //login page- verify login url
        
        driver.get("https://developer.chrome.com/docs/chromedriver/capabilities");

    }
}
