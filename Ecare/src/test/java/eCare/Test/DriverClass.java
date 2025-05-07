package eCare.Test;

import java.io.IOException;

import org.testng.annotations.Test;
import eCare.AbstractComponent.AbstractComponents;
import eCare.PageObjects.*;
import eCare.TestComponents.BaseTest;

public class DriverClass extends BaseTest{

//	String uhid;
	String uhid = "000004715";

	@Test(priority = 1)
	public void Registration() throws InterruptedException, IOException 
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
	public void BookAppointment() throws InterruptedException, IOException {
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
	public void OpdLabBooking() throws InterruptedException, IOException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("105", "Unicode@2022$");
		OpdLab opdLab = new OpdLab(driver);
		opdLab.opdLabBooking(uhid);
	}
	
	@Test(priority = 5)
	public void OpdPharmacyBooking() throws InterruptedException, IOException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("290", "Test@123");
		OpdPharmacy opdPharmacy = new OpdPharmacy(driver);
		opdPharmacy.opdPrescriptionBooking(uhid);
	}
	
	@Test(priority = 6)
	public void OpdLabFO() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("502", "Test@123");
		OpdLabFO opdLabFO = new OpdLabFO(driver);
		opdLabFO.selectPhlebotomist(uhid);
	}
	
	@Test(priority = 7)
	public void OpdLabPhlebotomist() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("504", "Test@123");
		OpdPhlebotomistPage opdPhlebotomistPage = new OpdPhlebotomistPage(driver);
		opdPhlebotomistPage.selectSample(uhid);
	}
	
	@Test(priority = 8)
	public void OpdLabTechnician() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("175", "Test@123");
		OpdLabTechnicianPage opdLabTechnicianPage = new OpdLabTechnicianPage(driver);
		opdLabTechnicianPage.search(uhid);
		opdLabTechnicianPage.clickPatientName();
		opdLabTechnicianPage.clickAddReport();
		opdLabTechnicianPage.clickApproveCheckboxes();
		opdLabTechnicianPage.clickSendBtn();
	}
	
	@Test(priority = 9)
	public void Pathologist() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("506", "Test@123");
		PathologistPage pathologistPage = new PathologistPage(driver);
		pathologistPage.reportApproved(uhid);
	}
}
