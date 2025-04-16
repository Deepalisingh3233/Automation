package basics;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Day1 {
	
	@Test
	public void demo() {
		System.out.println("Hello");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Bye");
	}
	
	@AfterSuite
	public void afSuite() {
		System.out.println("I am the number 1 from last.");
	}

}
