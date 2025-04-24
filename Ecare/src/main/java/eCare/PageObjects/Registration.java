package eCare.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class Registration extends AbstractComponents{

	WebDriver driver;
	public Registration(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "[class*='ant-btn-primary']")
	WebElement registrationBtn;
	
	@FindBy(id = "rc_select_0")
	WebElement title;
	
	@FindBy(name = "patient_name")
	WebElement name;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "contact_number")
	WebElement number;
	
	@FindBy(name = "address")
	WebElement houseNumber;
	
	@FindBy(name = "pincode")
	WebElement pincode;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement saveBtn;
	
	public void registration() {
		registrationBtn.click();
		title.sendKeys("Mr", Keys.ENTER);
		name.sendKeys("Ankush Sharma");
		email.sendKeys("ankushsharma@mightcode.com");
		number.sendKeys("9856968574");
		selectDob();
		houseNumber.sendKeys("187-B Agile Heights");
		pincode.sendKeys("208022");
		saveBtn.click();
		
	}
	
	
	
	
}
