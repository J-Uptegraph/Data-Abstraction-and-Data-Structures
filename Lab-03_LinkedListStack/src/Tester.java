import java.io.File;
import java.util.Scanner;

public class Tester {

	static LinkedListStack<Athlete> athletes = new LinkedListStack<Athlete>();
	
	public static void main(String[] args) {
		
//		athletes.push(new Athlete(1, "A", "AA", "AA", "em1", 5));
//		athletes.push(new Athlete(2, "B", "BB", "BB", "em2", 6));
//		athletes.push(new Athlete(3, "C", "CC", "CC", "em3", 7));
		
		loadAthletes("Athletes.txt");
		
		System.out.println(athletes.peek());	// should print Mabelle Spreadbury's record
		System.out.println(athletes.pop());		// should print Mabelle Spreadbury's record
		System.out.println(athletes.pop()); 	// should print Annabela Ferrini's record
		System.out.println(athletes.get(10));	// should print Curr Mervyn's record

		System.out.println("\n=========================================================== Reverse Stack\n");
		athletes.reverseStack();
		
		System.out.println(athletes.peek() );	// should print Jaquenetta Finlayson's record
		System.out.println(athletes.pop());		// should print Jaquenetta Finlayson's record
		System.out.println(athletes.pop()); 	// should print Madonna Edgler's record
		System.out.println(athletes.get(10));	// should print Christen Rylstone's record
	}
	
	// This method is complete - you do not need to modify
	public static void loadAthletes(String fileName) {
		// open file and read in all records
		try(Scanner fin = new Scanner(new File(fileName))) {
			fin.nextLine();						// read off the header line
			while(fin.hasNextLine())
				athletes.push(new Athlete(fin)); 	// adds a new athlete to the stack
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
