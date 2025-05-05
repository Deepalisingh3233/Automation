package eCare.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import eCare.AbstractComponent.AbstractComponents;
import eCare.PageObjects.BookAppointment;
import eCare.PageObjects.PaymentPage;
import eCare.PageObjects.Registration;
import eCare.TestComponents.BaseTest;

public class RegressionTest extends BaseTest{

	String uhid;

	@Test
	public void Regression() throws InterruptedException, IOException {
		AbstractComponents loginPage = new AbstractComponents(driver);
		loginPage.loginWithValidCredentials("105", "Unicode@2022$");
			
		Registration registration = new Registration(driver);
		registration.registration();
		
		PaymentPage paymentPage = new PaymentPage(driver);
		uhid = paymentPage.getUHID();
		paymentPage.proceed();
		paymentPage.generateInvoice();
		paymentPage.cancelInvoice();
		
		BookAppointment bookAppointment = new BookAppointment(driver);
		bookAppointment.search(uhid);
		bookAppointment.clickBookApointBtn();
		bookAppointment.selectDepartment();
		bookAppointment.selectDoctor();
		bookAppointment.selectSlot();
		bookAppointment.clickConfirmBtn();
		Thread.sleep(1000);
		paymentPage.proceed();
		paymentPage.generateInvoice();
		paymentPage.cancelInvoice();
	}
}
