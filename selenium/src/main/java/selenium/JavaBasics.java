package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"Rahul", "Abhay", "Ankush", "Ankit"};
		for(String s : str) {
			System.out.println(s);
		}
		
		int numbers[] = {2, 5, 10, 42, 20};
	    
	    //Access and Print
	    System.out.println("First Element "+numbers[0]);
	    int count = numbers.length;
	    System.out.println("Last Element "+numbers[count-1]);
	    
	    //Reverse Order
	    
	    for(int i=numbers.length-1; i>=0; i--){
	        System.out.println(numbers[i]);
	    }
	    
	    // Element count
	    System.out.println("Count "+numbers.length);
	    
	    //ArrayList
	    System.out.println("--------------ArrayList------------------");
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("Ritesh");
	    a.add("Deepali");
	    a.add("Ankit");
	    a.remove(2);
	    System.out.println(a);
	    System.out.println(a.get(0));
	    
	    System.out.println("--------For Loop---------");
	    for(int i = 0; i < a.size(); i++) {
	    	System.out.println(a.get(i));
	    }
	    System.out.println("--------------Extended For Loop---------------");
	    for(String val : a) {
	    	System.out.println(val);
	    }
	    
	    //item is present in ArrayList or not
	    System.out.println(a.contains("Ankit"));
	    
	    System.out.println("------------");
	    
	    List<String> nameArraysList = Arrays.asList(str);
	    System.out.println(nameArraysList);
	    System.out.println(nameArraysList.contains("Abhay"));

	}

}
