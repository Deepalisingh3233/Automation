package eCare.PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCare.AbstractComponent.AbstractComponents;

public class PaymentPage extends AbstractComponents{
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'UHID')]")
	WebElement uhidEle;
	
	@FindBy(css = ".ant-btn-primary")
	WebElement proceedBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Generate Invoice')]")
	WebElement generateInvoiceBtn;
	
	@FindBy(css = ".ant-btn-color-default")
	WebElement cancelBtn;
	
	public String getUHID() {
		String uhid = uhidEle.getText().split("_0")[1].trim();
		System.out.println(uhid);
		return uhid;
	}
	
	public void proceed() {
		waitForElementToAppear(proceedBtn);
		proceedBtn.click();
	}
	
	public void generateInvoice() throws IOException {
		getSS();
		waitForElementToAppear(generateInvoiceBtn);
		generateInvoiceBtn.click();
	}
	
	public void cancelInvoice() {
		waitForElementToAppear(cancelBtn);
		cancelBtn.click();
	}
}
