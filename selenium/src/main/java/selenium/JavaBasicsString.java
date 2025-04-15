package selenium;

public class JavaBasicsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String is an Object 
		//String literal 
//		String s = "Deepali Singh";
//		String s4 = "Deepali Singh";
		//For S and s4 it refers to the same object, it doesn't create the new object
		String s1 = "Ritesh Singh";
		
		//new Keywords
//		String s2 = new String("Welcome");
//		String s3 = new String("Welcome");
		// For s2 and s3, its create the new object for both
		
		String s = "Rahul Shetty Academy";
		String[] splittedArray = s.split("Shetty");
		System.out.println(splittedArray[0]);
		System.out.println(splittedArray[1]);
		System.out.println(splittedArray[1].trim());
		
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println("------REVERSE ORDER------");
		
		for(int i = s.length() - 1; i >= 0 ; i--) {
			System.out.println(s.charAt(i));
		}
	}

}
