package eCare.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import eCare.AbstractComponent.AbstractComponents;

public class OPDEMR extends AbstractComponents{
	
	WebDriver driver;
	
	public OPDEMR(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	@FindBy(name = "history_notes")
	WebElement history;
	
	
	@FindBy(name = "chief_complaint_notes")
	WebElement complaints;
	
//	@FindBy(xpath = "//*[contains(text(),'Type & Search diagnosis')]")
	@FindBy(id = "rc_select_0")
	WebElement diagnosis;
	
//	@FindBy(xpath = "//*[contains(text(),'Type & Search investigation')]")
	@FindBy(id = "rc_select_5")
	WebElement investigations;

	public void fillHistory() {
		history.sendKeys("Patient with a significant medical history of hypertension and hyperlipidemia. His family history includes a father with a history of heart disease and a mother with a history of diabetes. ");
	}
	
	public void fillComplaints() {
		complaints.sendKeys("Patient presents to the healthcare provider with a 1-week history of chest pain, shortness of breath, and fatigue. ");
	}
	
	public void selectDiagnosis() {
		diagnosis.sendKeys("fever", Keys.ENTER);
	}
	
	public void selectInvestigation() {
		investigations.sendKeys("Lipid Panel", Keys.ENTER);
	}
	
}
