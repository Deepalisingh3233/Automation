package selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress: 4444");
        options.setCapability("proxy", proxy);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());

        //https://developer.chrome.com/docs/chromedriver/capabilities
    }
}
