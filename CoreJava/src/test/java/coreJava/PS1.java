package coreJava;

import org.testng.annotations.Test;

public class PS1 extends PS{
	
	
	
	@Test
	public void testRun() {
		
		//If we doesn't extends then we will create object
//		PS ps = new PS();
//		ps.dothis();
		
		int a = 3;

		PS2 ps2 = new PS2(a); //constructor
		
		dothis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());

	}

}
