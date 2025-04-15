package basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Day3 {
	
	@Test
	public void webLoginCarLoan() {
		//selenium
		System.out.println("Web Login Car");
	}
	
	@Test
	public void mobileLoginCarLoan() {
		//Appium
		System.out.println("Mobile login Car");
	}
	
	
	@BeforeMethod
	public void beforeEvery() {
		System.out.println("I am always execute before every methods");
	}
	
	@Test
	public void mobileSigninCarLoan() {
		//Appium
		System.out.println("Mobile Signin Car");
	}
	
	@AfterMethod
	public void afterEvery() {
		System.out.println("I am always execute after every methods");
	}
	
	@Test
	public void mobileSignoutCarLoan() {
		//Appium
		System.out.println("Mobile Signout Car");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am number 1");
	}


	@Test
	public void  APICarLoan() {
		//Rest API
		System.out.println("API Login Car");
	}
}
