package eCare.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class OpdLabFO extends AbstractComponents{
	
	WebDriver driver;
	
	public OpdLabFO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "[placeholder='Search Patient Name/UHID/Doctor Name']")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[6]/span")
	WebElement acceptText;
	
	@FindBy(css = "[role='combobox']")
	WebElement phleboDropdown;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement saveBtn;

	public void search(String uhid) {
		searchBar.sendKeys(uhid);
	}
	
	public void clickAccept() throws InterruptedException {
		Thread.sleep(2000);
		acceptText.click();
	}
	
	public void selectPhlebo() {
		waitForElementToClickable(phleboDropdown);
		phleboDropdown.sendKeys("Sameer", Keys.ENTER);
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}

	public void selectPhlebotomist(String uhid) throws InterruptedException {
		search(uhid);
		clickAccept();
		selectPhlebo();
		clickSaveBtn();
	}
}
