package eCare.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class OpdPharmacy extends AbstractComponents{

	WebDriver driver;
	public OpdPharmacy(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "(//input[@placeholder = 'Search Patient Name/UHID'])[1]")
	WebElement searchBar;
	
	@FindBy(xpath = "//tbody/tr[2]/td[6]/div")
	WebElement acceptText;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement proceedBtn;
	
	public void search(String uhid) throws InterruptedException {
		Thread.sleep(2000);
		waitForPageLoad();
		searchBar.sendKeys(uhid);
		waitForPageLoad();
	}
	
	public void clickAccept() {
		acceptText.click();
	}
	
	public void clickProceedBtn() {
		proceedBtn.click();
	}
	
	public void opdPrescriptionBooking(String uhid) throws InterruptedException, IOException {
		search(uhid);
		Thread.sleep(2000);
		clickAccept();
		Thread.sleep(2000);
		clickProceedBtn();
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.proceed();
		paymentPage.generateInvoice();
		paymentPage.cancelInvoice();
	}
}
