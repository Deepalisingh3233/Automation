package basics;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Day4 {
	
	@Test
	public void webLoginHomeLoan() {
		//selenium
		System.out.println("Web Login Home");
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
