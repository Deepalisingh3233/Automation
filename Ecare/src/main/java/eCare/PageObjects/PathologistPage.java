package eCare.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
		waitForvisibilityOfAllElements(ViewReportText);
		System.out.println(ViewReportText.size());
	    List<WebElement> updatedViewReportText = driver.findElements(By.xpath("//span[contains(text(),'View Report')]"));
//		ViewReportText.stream().forEach(this::clickApproveBtn);
	    
	    for (WebElement element : updatedViewReportText) {
	    	clickApproveBtn(element);
	    	Thread.sleep(2000);
	    	updatedViewReportText = driver.findElements(By.xpath("//span[contains(text(),'View Report')]"));
		} 
	}
	
	public void clickApproveBtn(WebElement element) throws InterruptedException {
		waitForElementToClickable(element);
		element.click();
		waitForElementToAppear(approveBtn);
		approveBtn.click();
		waitForElementToAppear(yesPopup);
		yesPopup.click();
		Thread.sleep(2000);
	}
	
	public void reportApproved(String uhid) throws InterruptedException {
		search(uhid);
		clickPatientName();
		clickViewReport();
	}
}
