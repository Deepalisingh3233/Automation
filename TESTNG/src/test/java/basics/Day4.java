package basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Day4 {
	
	@Parameters("URL")
	@Test
	public void webLoginHomeLoan(String urlName) {
		//selenium
		System.out.println("Web Login Home");
		System.out.println(urlName);
	}
	
	@Test(groups = {"Smoke"})
	public void mobileLoginHomeLoan() {
		//Appium
		System.out.println("Mobile login Home");
	}

	@Test
	public void  loginAPIHomeLoan() {
		//Rest API
		System.out.println("API Login Home");
	}
}
