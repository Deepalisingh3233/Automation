package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Day3 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before executing any method in the class");
	}
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void webLoginCarLoan(String urlName, String apiKey) {
		//selenium
		System.out.println("Web Login Car");
		System.out.println(urlName + " " + apiKey);
	}
	
	@Test(timeOut = 4000)
	public void mobileLoginCarLoan() {
		//Appium
		System.out.println("Mobile login Car");
	}
	
	
	@BeforeMethod
	public void beforeEvery() {
		System.out.println("I am always execute before every methods");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After executing all methods in the class");
	}
	
	@Test(enabled = false)
	public void mobileSigninCarLoan() {
		//Appium
		System.out.println("Mobile Signin Car");
	}
	
	@AfterMethod
	public void afterEvery() {
		System.out.println("I am always execute after every methods");
	}
	
	@Test(groups = {"Smoke"})
	public void mobileSignoutCarLoan() {
		//Appium
		System.out.println("Mobile Signout Car");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am number 1");
	}


	@Test(dependsOnMethods = {"webLoginCarLoan", "mobileSignoutCarLoan"})
	public void  APICarLoan() {
		//Rest API
		System.out.println("API Login Car");
	}
}
