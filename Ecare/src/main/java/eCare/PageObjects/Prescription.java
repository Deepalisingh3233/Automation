package eCare.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class Prescription extends AbstractComponents{

	WebDriver driver;
	public Prescription(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}

	@FindBy(id = "rc_select_1")
	WebElement medicineDropdown;
	
	@FindBy(id = "3102")
	WebElement mediNameWait;
	
	@FindBy(name = "dose")
	WebElement doseInput;
	
	@FindBy(id = "rc_select_3")
	WebElement frequency;
	
	@FindBy(id = "rc_select_4")
	WebElement timing;
	
	@FindBy(name = "duration")
	WebElement durationInput;
	
	@FindBy(name = "medical_lab")
	WebElement startDateCalendar;
	
	@FindBy(css = ".ant-picker-cell-today")
	WebElement currentDate;
	
	@FindBy(css = ".anticon-edit")
	WebElement instructions;
	
	@FindBy(css = ".ant-modal-body span textarea")
	WebElement instructionInput;
	
	@FindBy(css = ".ant-modal-footer div:nth-child(3)")
	WebElement instructionSaveBtn;
	
	@FindBy(css = ".anticon-plus")
	WebElement addBtn;
	
	@FindBy(css = "[class*='justify-end']:nth-child(1) button:nth-child(2)")
	WebElement emrSaveBtn;
	
	public void selectMedicine() {
		medicineDropdown.sendKeys("DVN Forte");
		waitForElementToAppear(mediNameWait);
		medicineDropdown.sendKeys(Keys.ENTER);
	}
	
	public void enterDose() {
		doseInput.sendKeys("1");
	}
	
	public void selectFrequency() {
		frequency.sendKeys("TID", Keys.ENTER);
	}
	
	public void enterDuration() {
		durationInput.sendKeys("3");
	}
	
	public void selectStartDate() {
		startDateCalendar.click();
		waitForElementToAppear(currentDate);
		currentDate.click();
	}
	
	public void selectTiming() {
		timing.sendKeys("After Meal", Keys.ENTER);
	}
	
	public void clickInstructionIcon() {
		instructions.click();
	}
	
	public void enterInstruction() {
		instructionInput.sendKeys("Take medicine with warm water.");
	}
	
	public void saveInstruction() {
		waitForElementToAppear(instructionSaveBtn);
		instructionSaveBtn.click();
	}
	
	public void addMedicine() {
		addBtn.click();
	}
	
	public void clickSaveBtn() {
		emrSaveBtn.click();
	}
	
	public void fillPrescription() {
		selectMedicine();
		enterDose();
		selectFrequency();
		selectTiming();
		enterDuration();
		selectStartDate();
		clickInstructionIcon();
		enterInstruction();
		saveInstruction();
		addMedicine();
		clickSaveBtn();
	}
}
