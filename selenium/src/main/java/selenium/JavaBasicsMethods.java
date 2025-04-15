package selenium;

public class JavaBasicsMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaBasicsMethods obj = new JavaBasicsMethods();
		String name  = obj.getDate();
		System.out.println(name);
		
		MethodsDemo2  obj2 = new MethodsDemo2();
		obj2.getUserDate();
		
		withoutObj();
	}
	
	public String getDate() {
		System.out.println("Hello World!");
		return "Deepali Singh";
	}
	
	public static void withoutObj() {
		System.out.println("Call method without using object");
	}

}
