import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		LinkedCollection<String> stuff = new LinkedCollection<String>();
		
		stuff.add("A");
		stuff.add("B");
		stuff.add("C");
		stuff.add("D");
		System.out.println("Before: " + stuff);
		System.out.println("remove(10);  = " + stuff.remove(10));
		System.out.println("remove(\"C\"); = " + stuff.remove("C"));
		System.out.println("After : " + stuff);
		for(int i = 'A'; i <= 'D'; i++)
			System.out.printf("indexOf('%c') = %d\n", i , stuff.indexOf(""+(char)i));
		stuff.clear();
		System.out.println(stuff);
		
		
		int count = 0;
		
		try(Scanner fin = new Scanner(new File("words.txt"))) {
			while(fin.hasNextLine()) {
				String[] parts = clean(fin.nextLine()).split(" ");
				for(String s : parts) {
					count++;
					if(!stuff.contains(s)) stuff.add(s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("Vocabulary Density (%d/%d): %.16f", count, stuff.size(), ((double)count/stuff.size()));	
	}
	
	private static String clean(String line) {
		String ret = "";
		
		for(char c : line.toLowerCase().toCharArray()) {
			if( (c >= 'a' && c <= 'z') || (c == ' ') || (c == '\'') )
				ret += c;
		}
		
		return ret;
	}
	
}
