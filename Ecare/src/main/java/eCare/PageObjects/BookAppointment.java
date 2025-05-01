package eCare.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class BookAppointment extends AbstractComponents{

	WebDriver driver;
	
	public BookAppointment(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "(//input[@placeholder = 'Search Patient Name/UHID'])[1]")
	WebElement searchBar;
	
	@FindBy(css = ".book-btn")
	WebElement bookApointBtn;
	
	@FindBy(xpath = "//h2[contains(text(),'OPD Patients')]")
	WebElement heading;
	
	@FindBy(xpath = "(//input)[1]")
	WebElement selectDept;
	
	@FindBy(xpath = "(//input)[2]")
	WebElement selectDoc;
	
	@FindBy(css = ".customhoverBg")
	WebElement slot;
	
	@FindBy(xpath = "//*[contains(text(),'Confirm')]")
	WebElement confirmBtn;
	
	public void search(String uhid) throws InterruptedException {
		Thread.sleep(2000);
		waitForElementToAppear(heading);
		searchBar.sendKeys(uhid);
	}
	
	public void clickBookApointBtn() throws InterruptedException {
		Thread.sleep(2000);
		waitForElementToAppear(bookApointBtn);
		bookApointBtn.click();
		Thread.sleep(1000);
	}
	
	public void selectDepartment() {
		selectDept.sendKeys("Cardiac Sciences", Keys.ENTER);
	}
	
	public void selectDoctor() throws InterruptedException {
		Thread.sleep(1000);
		selectDoc.sendKeys("Mithilesh", Keys.ENTER);
	}
	
	public void selectSlot() {
		slot.click();
	}
	
	public void clickConfirmBtn() {
		confirmBtn.click();
	}
	
	
}
