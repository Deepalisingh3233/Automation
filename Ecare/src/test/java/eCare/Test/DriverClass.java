package eCare.Test;

import org.testng.annotations.Test;
import eCare.AbstractComponent.AbstractComponents;
import eCare.PageObjects.PaymentPage;
import eCare.PageObjects.Prescription;
import eCare.PageObjects.BookAppointment;
import eCare.PageObjects.OPDEMR;
import eCare.PageObjects.OpdDoctorPage;
import eCare.PageObjects.OpdLab;
import eCare.PageObjects.OpdPharmacy;
import eCare.PageObjects.Registration;
import eCare.PageObjects.Vitals;
import eCare.TestComponents.BaseTest;

public class DriverClass extends BaseTest{

	String uhid;
//	String uhid = "000004717";

	@Test(priority = 1)
	public void Registration() throws InterruptedException 
		{
			AbstractComponents loginPage = new AbstractComponents(driver);
			loginPage.loginWithValidCredentials("105", "Unicode@2022$");
				
			Registration registration = new Registration(driver);
			registration.registration();
			
			PaymentPage paymentPage = new PaymentPage(driver);
			uhid = paymentPage.getUHID();
			paymentPage.proceed();
			paymentPage.generateInvoice();
			paymentPage.cancelInvoice();
		}
	
	@Test(dependsOnMethods = "Registration", priority = 2)
//	@Test
	public void BookAppointment() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("105", "Unicode@2022$");
		BookAppointment bookAppointment = new BookAppointment(driver);
		bookAppointment.search(uhid);
		bookAppointment.clickBookApointBtn();
		bookAppointment.selectDepartment();
		bookAppointment.selectDoctor();
		bookAppointment.selectSlot();
		bookAppointment.clickConfirmBtn();
		Thread.sleep(1000);
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.proceed();
		paymentPage.generateInvoice();
		paymentPage.cancelInvoice();
		
	}
	
	@Test(priority = 3)
	public void OpdDoctorFlow() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("patel", "Patel@12345");
		OpdDoctorPage opdDoctorPage = new OpdDoctorPage(driver);
		opdDoctorPage.searchPatient(uhid);
		Thread.sleep(1000);
		opdDoctorPage.pickAppointment();
		Vitals vitals = new Vitals(driver);
		vitals.opdVitals();
		OPDEMR opdEMR = new OPDEMR(driver);
		opdEMR.fillEMR();
		Prescription prescription =  new Prescription(driver);
		prescription.fillPrescription();
		opdDoctorPage.searchPatient(uhid);
		Thread.sleep(1000);
		opdDoctorPage.completeAppointment();
		Thread.sleep(2000);
		opdDoctorPage.clickYesPopup();
	}
		
	@Test(priority = 4)
	public void OpdLabBooking() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("105", "Unicode@2022$");
		OpdLab opdLab = new OpdLab(driver);
		opdLab.opdLabBooking(uhid);
	}
	
	@Test(priority = 5)
	public void OpdPharmacyBooking() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("290", "Test@123");
		OpdPharmacy opdPharmacy = new OpdPharmacy(driver);
		opdPharmacy.opdPrescriptionBooking(uhid);
		
	}
	
}
