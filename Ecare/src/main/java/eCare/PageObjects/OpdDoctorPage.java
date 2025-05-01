package eCare.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import eCare.AbstractComponent.AbstractComponents;

public class OpdDoctorPage extends AbstractComponents{

	WebDriver driver;
	
	public OpdDoctorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "[placeholder='Search Patient Name/UHID']")
	WebElement searchBar;
	
	@FindBy(css = ".cursor-auto")
	WebElement pickApoint;
	
	public void searchPatient(String uhid) {
		searchBar.sendKeys(uhid);
	}
	
	public void pickAppointment() {
		pickApoint.click();
	}
	
}
