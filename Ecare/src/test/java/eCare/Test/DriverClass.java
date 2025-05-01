package eCare.Test;

import org.testng.annotations.Test;
import eCare.AbstractComponent.AbstractComponents;
import eCare.PageObjects.PaymentPage;
import eCare.PageObjects.BookAppointment;
import eCare.PageObjects.OpdDoctorPage;
import eCare.PageObjects.Registration;
import eCare.TestComponents.BaseTest;

public class DriverClass extends BaseTest{

//	String uhid;
	String uhid = "000004700";

//	@Test
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
	
//	@Test(dependsOnMethods = "Login")
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
	
	@Test
	public void OpdDoctorFlow() throws InterruptedException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("patel", "Patel@12345");
		OpdDoctorPage opdDoctorPage = new OpdDoctorPage(driver);
		opdDoctorPage.searchPatient(uhid);
		opdDoctorPage.pickAppointment();
	}
		
		
	
}
