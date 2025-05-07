package eCare.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class OpdPhlebotomistPage extends AbstractComponents{

	WebDriver driver;
	
	public OpdPhlebotomistPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "[placeholder = 'Search Patient Name/UHID']")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[2]/div/span/span")
	WebElement patientNameCol;
	
	@FindBy(css = ".ant-checkbox-input")
	List<WebElement> checkboxes;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement saveBtn;
	
	public void search(String uhid) {
		waitForPageLoad();
		waitForElementToAppear(patientNameCol);
		searchBar.sendKeys(uhid);
	}
	
	public void clickPatientName() throws InterruptedException {
//		Thread.sleep(2000);
		waitForElementToAppear(patientNameCol);
		patientNameCol.click();
	}
	
	public void selectCheckboxes() {
		waitForPageLoad();
		checkboxes.stream().forEach(s -> s.click());
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public void selectSample(String uhid) throws InterruptedException {
		search(uhid);
		clickPatientName();
		selectCheckboxes();
		clickSaveBtn();
	}
}
