package coreJava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me first..");
	}
	
	public void dothis(){
		System.out.println("I am here..");
	}
	
	@AfterMethod
	public void afterRun() {
		System.out.println("Run me last..");
	}
}
