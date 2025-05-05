package eCare.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class LabPaymentPage extends AbstractComponents{

	WebDriver driver;
	
	public LabPaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "[placeholder = '0']")
	WebElement discountInput;
	
	@FindBy(css = "[placeholder = 'Enter Remarks']")
	WebElement remarkInput;
	
	@FindBy(xpath = "(//button)[2]")
	WebElement proceedBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Generate Invoice')]")
	WebElement generateInvoiceBtn;
	
	@FindBy(css = ".ant-btn-color-default")
	WebElement cancelBtn;
	
	public void enterDiscount() {
		discountInput.sendKeys("10");
	}
	
	public void enterRemark() {
		remarkInput.sendKeys("Add Discount.");;
	}
	
	public void clickProceed() {
		proceedBtn.click();
	}
	
	public void generateInvoice() {
		waitForElementToAppear(generateInvoiceBtn);
		generateInvoiceBtn.click();
	}
	
	public void cancelInvoice() {
		waitForElementToAppear(cancelBtn);
		cancelBtn.click();
	}
}
