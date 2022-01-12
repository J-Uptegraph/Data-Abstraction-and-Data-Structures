import java.util.PriorityQueue;

public class Tester {
	
	public static void main(String[] args){
		
		PriorityQueueInterface<Student> students = new SortedLinkedPriorityQueue<Student>();
		students.add(new Student("Tom", 24, true));
		students.add(new Student("Bob", 26, false));
		
		System.out.println(students);
		while(!students.isEmpty())
			System.out.println(students.remove());
		
	}
}
//	******************************** Unsorted Priority Queue Tester ******************************************
////public class Tester {
////	public static void main(String[] args) {
////		
////		UnsortedArrayPriorityQueue<Student> students = new UnsortedArrayPriorityQueue<Student>();
////		
////		students.add(new Student("Tom",33,false));
////		students.add(new Student("Tyler",23,true));
////		students.add(new Student("Sam",30,true));
////		students.add(new Student("Lily",24,false));
////		students.add(new Student("Cindy",24,false));
////		
////		while (!students.isEmpty())
////			System.out.println(students.remove());
////	}
////}
