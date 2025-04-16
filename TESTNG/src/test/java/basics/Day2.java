package basics;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@AfterTest
	public void lastExecution() {
		System.out.println("I will execute last");
	}
	
	@Test(groups = {"Smoke"})
	public void ploan() {
		System.out.println("Pay Loan");
	}
	
	@BeforeTest
	public void preRequiste() {
		System.out.println("I will execute first");
	}
}
