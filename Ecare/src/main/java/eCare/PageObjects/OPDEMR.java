package eCare.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class OPDEMR {
	
	@FindBy(name = "history_notes")
	WebElement history;
	
	
	@FindBy(name = "chief_complaint_notes")
	WebElement complaints;
	
	@FindBy(xpath = "//*[contains(text(),'Type & Search diagnosis')]")
	WebElement diagnosis;
	
	@FindBy(xpath = "//*[contains(text(),'Type & Search investigation')]")
	WebElement investigations;

	@Test
	public void opdEMR() {
		
		
	}
}
