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
	
	
//	@FindBy(xpath = "//div[@class='cursor-auto']/span")
	@FindBy(css = ".cursor-auto span")
//	@FindBy(css = "tbody tr:nth-child(2) td:nth-child(3)")
	WebElement pickApoint;
	
	@FindBy(css = "tbody td:nth-child(7) div span:nth-child(2)")
	WebElement completeApoint;
	
	@FindBy(css = ".ant-modal-footer button:nth-child(2)")
	WebElement yesPopup;
	
	public void searchPatient(String uhid) {
		searchBar.sendKeys(uhid);
	}
	
	public void pickAppointment() {
		pickApoint.click();
	}
	
	public void completeAppointment() {
		completeApoint.click();
	}
	
	public void clickYesPopup() {
		waitForElementToAppear(yesPopup);
		yesPopup.click();
	}

	
}
