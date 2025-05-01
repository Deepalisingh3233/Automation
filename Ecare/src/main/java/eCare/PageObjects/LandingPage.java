package eCare.PageObjects;

import org.openqa.selenium.WebDriver;

import eCare.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents{

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver; 
	
	public void goTo() {
		driver.get("https://devui-ecare.mightcode.com/login");
	}
}
