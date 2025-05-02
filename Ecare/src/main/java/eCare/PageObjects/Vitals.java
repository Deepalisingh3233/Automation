package eCare.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eCare.AbstractComponent.AbstractComponents;

public class Vitals extends AbstractComponents{

	WebDriver driver;
	
	public Vitals(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(name = "Heart Rate")
	WebElement heartRate;
	
	@FindBy(name = "Pulse")
	WebElement pulse;
	
	@FindBy(name = "Blood Sugar")
	WebElement bloodSugar;
	
	@FindBy(name = "Systolic")
	WebElement systolic;
	
	@FindBy(name = "Diastolic")
	WebElement diastolic;
	
	@FindBy(name = "Temperature")
	WebElement temperature;
	
	@FindBy(name = "RR")
	WebElement rr;
	
	@FindBy(name = "SPO2")
	WebElement spo2;
	
	@FindBy(name = "Height")
	WebElement height;
	
	@FindBy(name = "Weight")
	WebElement weight;
	
	public void fillHeartRate() {
		heartRate.sendKeys("90");
	}
	
	public void fillPulse() {
		pulse.sendKeys("98");
	}
	
	public void fillBloodSugar() {
		bloodSugar.sendKeys("120");
	}
	
	public void fillSystolic() {
		systolic.sendKeys("160");
	}
	
	public void fillDiastolic() {
		diastolic.sendKeys("86");
	}
	
	public void fillTemperature() {
		temperature.sendKeys("99");
	}
	
	public void fillRR() {
		rr.sendKeys("18");
	}
	
	public void fillSPO2() {
		spo2.sendKeys("98");
	}
	
	public void fillheight() {
		height.sendKeys("158");
	}
	
	public void fillWeight() {
		weight.sendKeys("60");
	}
	
	public void opdVitals() {
		fillHeartRate();
		fillPulse();
		fillBloodSugar();
		fillSystolic();
		fillDiastolic();
		fillTemperature();
		fillRR();
		fillSPO2();
		fillheight();
		fillWeight();
	}
}

