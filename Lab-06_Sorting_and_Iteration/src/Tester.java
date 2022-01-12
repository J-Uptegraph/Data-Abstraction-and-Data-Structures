// Johnathan Uptegraph

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Tester {
	private static DoublyLinkedCollectionIteration<Student> students = new DoublyLinkedCollectionIteration<>();
	private static ArrayList<Student> alStudents = new ArrayList<>();
	public static void main(String[] args) {
		loadData();
		Collections.sort(alStudents);
		
		System.out.println("\n====================================== Class Average");
		System.out.println(getTotalAverage());
		System.out.println("\n====================================== Top10()");
		showTop10();
		System.out.println("\n====================================== BottomTop10()");
		showBottom10();
	}
	
	
	
	private static void loadData() {
		try(Scanner fin = new Scanner(new File("StudentData.txt")) ) {
			fin.nextLine();
			// First line is read but we do nothing with it because
			// the header will break our code as "age" is not of type int
			while (fin.hasNextLine()) {
				// Read in student make it an object
				Student s = new Student(fin.nextLine());
				// Now add "s" to both collections
				students.add(s);
				alStudents.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void showTop10() {
		Comparator<Student> top10ByAverage = new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return (int)(o2.average()*100) - (int)(o1.average()*100);
			}
		};
		
		Collections.sort(alStudents, top10ByAverage);
		printList(10);
	}
	
	private static void showBottom10() {
		// Sort in decending order by flipping o1 and o2 of the showTop10()
		Comparator<Student> bottom10ByAverage = new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return (int)(o1.average()*100) - (int)(o2.average()*100);
			}
		};
		Collections.sort(alStudents, bottom10ByAverage);
		printList(10);
	}
	
	private static double getTotalAverage() {
		double sum = 0;
		for (Student s: students)
			sum += s.average();
		return sum / students.size();
	}
	
	private static void printList(int count) {
		int i = 0;
		for(Student s: alStudents) {
			System.out.println(s);
			if (++i == count) break;
		}
		
	}
}
