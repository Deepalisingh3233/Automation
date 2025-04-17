package coreJava;

public class PS2 {

	int a; //Class variable
	
	public PS2(int a) { //instance variable 'a'
		this.a = a;
	}

	public int increment() {
		
		a = a+1;
		return a;
	}
	
	public int decrement() {
		
		a = a-1;
		return a;
	}
	
}
