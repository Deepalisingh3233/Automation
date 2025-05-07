package eCare.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class PathologistPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css = "[placeholder*= 'Search With Patient Name / UHID ']")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[3]/div/span/span[1]")
	WebElement patientName;	
	
	@FindBy(xpath = "//span[contains(text(),'View Report')]")
	List<WebElement> ViewReportText;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement approveBtn;

	@FindBy(css = ".ant-modal-footer button:nth-child(2)")
	WebElement yesPopup;
	

	public PathologistPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void search(String uhid){
		waitForElementToAppear(patientName);
		searchBar.sendKeys(uhid);
	}
	
	public void clickPatientName() throws InterruptedException {
		Thread.sleep(2000);
		waitForElementToClickable(patientName);
		patientName.click();
	}
	
	public void clickViewReport() throws InterruptedException {
		Thread.sleep(3000);
		ViewReportText.stream().forEach(this::clickApproveBtn);
	}
	
	public void clickApproveBtn(WebElement element) {
		element.click();
		waitForElementToAppear(approveBtn);
		approveBtn.click();
		waitForElementToAppear(yesPopup);
		yesPopup.click();
	}
	
	public void reportApproved(String uhid) throws InterruptedException {
		search(uhid);
		clickPatientName();
		clickViewReport();
	}
}
