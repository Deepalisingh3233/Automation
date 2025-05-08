package eCare.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class OpdLabTechnicianPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css = "[placeholder*= 'Search Patient Name/UHID']")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[3]/div")
	WebElement patientName;
	
	@FindBy(xpath = "//span[contains(text(),'Add')]")
	List<WebElement> addReportText;
	
	@FindBy(xpath = "//input[@type='number']")
	List<WebElement> numberInputs;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement saveBtn;
	
	@FindBy(css = ".ant-checkbox-input")
	List<WebElement> approveCheckboxes;
	
	@FindBy(css = ".ant-modal-footer button:nth-child(2)")
	WebElement yesPopup;
	
	public OpdLabTechnicianPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void search(String uhid){
		waitForElementToAppear(patientName);
		searchBar.sendKeys(uhid);
	}
	
	public void clickPatientName() throws InterruptedException {
		Thread.sleep(3000);
		waitForElementToClickable(patientName);
		patientName.click();
	}
	
	public void clickAddReport() throws InterruptedException {
		Thread.sleep(2000);
		addReportText.stream().forEach(this::fillReport);
	}
	
	public void fillReport(WebElement element) {
		element.click();
		numberInputs.stream()
        .filter(WebElement::isEnabled)
        .forEach(input -> input.sendKeys("400", Keys.BACK_SPACE));
		saveBtn.click();
	}
	
	public void clickApproveCheckboxes() {
		approveCheckboxes.stream().forEach(s -> s.click());
	}
	
	public void clickSendBtn() throws InterruptedException {
		saveBtn.click();
		waitForElementToAppear(yesPopup);
		Thread.sleep(2000);
		yesPopup.click();
	}

}
