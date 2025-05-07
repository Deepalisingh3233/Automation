package eCare.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class OpdLab extends AbstractComponents{

	WebDriver driver; 
	
	public OpdLab(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "(//li[@role='menuitem'])[3]")
	WebElement labMenu;
	
	@FindBy(xpath = "(//input[@placeholder = 'Search Patient Name/UHID'])[1]")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[7]/button")
	WebElement bookTestBtn;
	
	@FindBy(css = ".ant-checkbox-wrapper")
	List<WebElement> checkbox;
	
	@FindBy(css = ".ant-btn")
	WebElement confirmBtn;
	
	public void clickLabMenu() {
		labMenu.click();
	}
	
	public void search(String uhid) throws InterruptedException {
		Thread.sleep(2000);
		searchBar.sendKeys(uhid);
	}
	
	public void clickBookTestBtn() {
		bookTestBtn.click();
	}
	
	public void clickCheckbox() {
		checkbox.stream().forEach(s -> s.click());
	}
	
	public void clickConfirmBtn() {
		confirmBtn.click();
	}
	
	public void opdLabBooking(String uhid) throws InterruptedException, IOException {
		clickLabMenu();
		search(uhid);
		Thread.sleep(2000);
		clickBookTestBtn();
		clickCheckbox();
		clickConfirmBtn();
		LabPaymentPage labPaymentPage = new LabPaymentPage(driver);
		labPaymentPage.enterDiscount();
		labPaymentPage.enterRemark();
		labPaymentPage.clickProceed();
		labPaymentPage.generateInvoice();
		labPaymentPage.cancelInvoice();
		
	}
	
	
}
