package eCare.AbstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void goTo() {
		driver.get("https://devui-ecare.mightcode.com/login");
	}
	
	public void selectDob() {
		calendar.click();
		clickYear.click();
		year.click();
		month.click();
		date.click();
	}

}
