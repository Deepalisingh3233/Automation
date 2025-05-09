package eCare.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import eCare.AbstractComponent.AbstractComponents;

public class OPDEMR extends AbstractComponents{
	
	WebDriver driver;
	String historyData = "Patient with a significant medical history of hypertension and hyperlipidemia. His family history includes a father with a history of heart disease and a mother with a history of diabetes.";
	
	String complaintsData = "Patient presents to the healthcare provider with a 1-week history of chest pain, shortness of breath, and fatigue. ";
	
	String diagnosisNotesData = "Patient's symptoms are consistent with Acute Coronary Syndrome, which may be triggered by his hypertension and hyperlipidemia. His medical history of hypertension and hyperlipidemia may also be contributing to his symptoms. It is essential to continue monitoring his symptoms and adjusting his treatment plan as needed to prevent complications. ";
	
	String specialInstructionsData = "Patient is instructed to take his prescribed medication for hypertension and hyperlipidemia, and to follow a low-fat diet. He is advised to quit smoking and to follow up with his healthcare provider in one week to review his symptoms and adjust his treatment plan as needed. Additionally, the following investigations have been prescribed: Electrocardiogram (ECG), Echocardiogram, and Lipid Profile.";
	
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
	
	@FindBy(css = ".ant-select-item-option-content")
	WebElement diagnosisDropdown;
	
	@FindBy(name = "diagnosis_notes")
	WebElement diagnosisNotes;
	
//	@FindBy(xpath = "//*[contains(text(),'Type & Search investigation')]")
	@FindBy(id = "rc_select_5")
	WebElement investigations;
	
	@FindBy(id = "1937")
	WebElement lipidID;
	
	@FindBy(id = "653")
	WebElement cbcID;
	
	@FindBy(id = "rc_select_6")
	WebElement allergies;
	
	@FindBy(name = "special_instructions")
	WebElement specialInstructions;
	
	@FindBy(xpath = "(//input[@class = 'ant-checkbox-input'])[1]")
	WebElement referToIPD;

	public void fillHistory() {
		waitForPageLoad();
		history.sendKeys(historyData);
	}
	
	public void fillComplaints() {
		complaints.sendKeys(complaintsData);
	}
	
	public void selectDiagnosis() {
		diagnosis.sendKeys("fever");
		waitForElementToAppear(diagnosisDropdown);
		diagnosis.sendKeys(Keys.ENTER);
		diagnosis.sendKeys(Keys.ESCAPE);
	}
	
	public void fillDiagnosisNotes() {
		diagnosisNotes.sendKeys(diagnosisNotesData);
	}
	
	public void selectLipidPanelTest() {
		investigations.sendKeys("Lipid Panel Test");		
		lipidID.click();
	}
	
	public void selectCBC() {
		investigations.sendKeys("CBC");		
		cbcID.click();
		investigations.sendKeys(Keys.ESCAPE);
	}
	
	public void selectAllergies() {
		allergies.sendKeys("z", Keys.ENTER);
		allergies.sendKeys(Keys.ESCAPE);
	}
	
	public void fillSpecialInstructions() {
		specialInstructions.sendKeys(specialInstructionsData);
	}
	
	public void selectIPDAdmission() {
		referToIPD.click();
	}
	
	public void fillEMR() {
		fillHistory();
		fillComplaints();		
		selectDiagnosis();
		fillDiagnosisNotes();
		selectLipidPanelTest();
		selectCBC();
		selectAllergies();
		fillSpecialInstructions();
//		selectIPDAdmission();
	}
	
}
