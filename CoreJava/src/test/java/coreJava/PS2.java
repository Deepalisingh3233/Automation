package coreJava;

public class PS2 extends PS3{

	int a; //Class variable
	
	public PS2(int a) { //instance variable 'a'
		super(a); //parent class constructor is called.
		//super keyword should be first line in your child class constructor
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
