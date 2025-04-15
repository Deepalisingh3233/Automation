package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
    public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Broken links
        //Step 1-> is to get all the URL's tied up to the links using selenium
        // Java methods will call URL's and gets you the status code
        //if status code > 400 then that URL is not working->link which tied to url is broken


        SoftAssert a = new SoftAssert();
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        for(WebElement link : links){

            String url = link.getDomAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);   
            a.assertTrue(responseCode < 404, "The link with Text: "+link.getText()+ "is broken with code: "+ responseCode);
                 
        }

        a.assertAll();



        /* String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");

       HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
       conn.setRequestMethod("HEAD");
       conn.connect();
       int responseCode = conn.getResponseCode();
       System.out.println(responseCode); */

        
    }
}
