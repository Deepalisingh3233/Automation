package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
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
	
	@Test(dataProvider = "getData")
	public void mobileLoginCarLoan(String username, String password) {
		//Appium
		System.out.println("Mobile login Car");
		System.out.println(username);
		System.out.println(password);
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
	
	@DataProvider
	public Object getData() {
		//1st combination - username password - good credit history -row
		//2nd combination - username password - no credit history
		//3rd combination - fraudelent credit history
		
		Object[][] data = new Object[3][2];
		//1st set data
		data[0][0] = "firstSetUsername";
		data[0][1] = "firstpassword";
		
		//2nd set
		data[1][0] = "secondSetUsername";
		data[1][1] = "secondpassword";
		
		//3rd set
		data[2][0] = "thirdSetUsername";
		data[2][1] = "thirdpassword";
		
		return data;
		
	}
}
