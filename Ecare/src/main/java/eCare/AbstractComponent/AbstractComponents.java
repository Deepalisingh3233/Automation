package eCare.AbstractComponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(id = "basic_email")
	WebElement loginEmail;
	
	@FindBy(id = "basic_password")
	WebElement loginPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@placeholder='Select Date']")
	WebElement calendar;
	
	@FindBy(css = ".ant-picker-year-btn")
	WebElement clickYear;
	
	@FindBy(xpath = "//td[@title='2019']")
	WebElement year;
	
	@FindBy(xpath = "//td[@title='2019-04']")
	WebElement month;
	
	@FindBy(xpath = "//td[@title='2019-04-08']")
	WebElement date;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithValidCredentials(String email, String password)
	{
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
	}
	
	
	
	public void selectDob() {
		calendar.click();
		clickYear.click();
		year.click();
		month.click();
		date.click();
	}
	
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public boolean waitForElementEnabled(WebElement findBy) {
		return findBy.isEnabled();
		
	}
	
	public void getSS() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//Screenshot" + "invoice.png"));
	}
	
	public void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	

}
