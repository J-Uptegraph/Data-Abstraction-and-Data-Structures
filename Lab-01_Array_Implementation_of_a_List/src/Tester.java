import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		// Do your own testing here.  Create a WordList object,
		// add, remove, check what's in the array, and so on.
		// Test edge cases as you go.
		
		WordList lst = new WordList();
		lst.add("a");
		lst.add("b");
		lst.add("c");
		lst.add("d");
		System.out.println(lst);
		lst.add(2, "e");
		System.out.println(lst);
		lst.add(1, "a");
		System.out.println(lst);
		lst.set(3, "ben");
		System.out.println(lst);
		System.out.println(lst.size());
		System.out.println(lst);
		System.out.println(lst.contains("abc"));
		System.out.println(lst);
		System.out.println(lst.contains("f"));
		System.out.println(lst);
		System.out.println(lst.contains("a"));
		System.out.println(lst);
		System.out.println(lst.contains("c"));
		System.out.println(lst);
		System.out.println(lst.remove(1));
		System.out.println(lst);
		System.out.println(lst.remove("a"));
		System.out.println(lst);
		lst.add("d");
		System.out.println(lst);
		
		System.out.println("-----------------------------------------------------------------------------");
		
		lst = new WordList(10);
		System.out.println("Made it");
		System.out.println(lst);
		for (int i = 0; i < 10; i++) {
			lst.add("" + i);
		}
		
		
		
		// While one think that .size() would output 10; in fact, it would actually output 0.
		// Calling the .size() simply returns the number of values in our array. 
		// There are technically 10 empty spaces, NOTHING IS IN THE ARRAY. 
		// Therefore, list has a size of 0.
		// In addition, we can never add something in the 10th place, our array only
		// holds position 0 through 9. Therefore if if (list.size() = list.length) we are done 
		// the array list is full.

	}

}
