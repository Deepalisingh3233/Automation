package eCare.TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import eCare.PageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initalizeDriver() throws IOException {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//report" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//report" + testCaseName + ".png";
	}
	

	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {
		driver = new ChromeDriver();
		driver = initalizeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

//	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
