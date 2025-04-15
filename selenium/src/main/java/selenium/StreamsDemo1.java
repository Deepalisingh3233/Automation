package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsDemo1 {

	// Without using stream
	// @Test
	public void regular() {
		// Count the number of name starting with Alphabet A in list

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhay");
		names.add("Ritesh");
		names.add("Deepali");
		names.add("Ankita");
		names.add("Rishu");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);
	}

	// Using Stream filter method
	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhay");
		names.add("Ritesh");
		names.add("Deepali");
		names.add("Ankita");
		names.add("Rishu");

//        There is no life of intermediate operation if there is no terminal operation.
//        Terminal operation executes only if the intermediate operation (Filter) returns true
//        We can create the stream
//        how to use filter in Stream API
		Long c = names.stream().filter(s -> s.startsWith("R")).count();
		System.out.println(c);

//		long d = Stream.of("Ritesh", "Deepali", "Ankita", "Rishu", "Dolly").filter(s -> {
//			s.startsWith("R");
//		}).count();
		long d = Stream.of("Ritesh", "Deepali", "Ankita", "Rishu", "Dolly").filter(s -> s.startsWith("A")).count();
		System.out.println(d);

//		Prints all the names of the ArrayList
		names.stream().filter(s -> s.length() > 5).forEach(s -> System.out.println(s));
		System.out.println("-----------------------------------");
		names.stream().filter(s -> s.length() > 5).limit(1).forEach(s -> System.out.println(s));
	}

	// Using Map method
	//@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Subrat");
		names.add("Ankit");
		names.add("Vineet");

//		Prints names which have last letter 'a' with uppercase
//		output -> Ankita -> ANKITA
		Stream.of("Arbiya", "Ritesh", "Deepali", "Ankita", "Rishu", "Dolly").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("--------------");
//		Prints name which have first letter as 'r' with uppercase and sorted
		List<String> names1 = Arrays.asList("Ritesh", "Deepali", "Ankita", "Rishu", "Dolly", "Arbiya");
		names1.stream().filter(s -> s.startsWith("R")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		System.out.println("---New Stream Data------");
//		Merging 2 different list
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//		newStream.sorted().forEach(s -> System.out.println(s));;

		System.out.println("--------");
		Boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Ritesh"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test
	public void streamCollect() {
		
		//You can also convert it into map and set too
		List<String> ls = Stream.of("Arbiya", "Ritesh", "Deepali", "Ankita", "Rishu", "Dolly")
				.filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(2,8,3,4,3,5,6,7,2);
//		print unique number from this array
//		sort the array -> 3rd index
		values.stream().distinct().forEach(s -> System.out.println(s));
		List<Integer> li =  values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("3rd index: "+li.get(2));
		
	}

}