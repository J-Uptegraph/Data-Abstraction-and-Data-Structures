
public class Tester {
	
	
	public static void main(String[] args) {

		LinkedQueue<Integer> nums = new LinkedQueue();
		
		nums.add(1);			System.out.printf("add(1): %-20s%n", nums);
		nums.add(2);			System.out.printf("add(2): %-20s%n", nums);
		nums.add(3);			System.out.printf("add(3): %-20s%n", nums);
		nums.add(4);			System.out.printf("add(4): %-20s%n", nums);
		nums.add(5);			System.out.printf("add(5): %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.add(6);			System.out.printf("add(6): %-20s%n", nums);
		nums.add(7);			System.out.printf("add(7): %-20s%n", nums);
		nums.add(8);			System.out.printf("add(8): %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.remove();			System.out.printf("remove: %-20s%n", nums);
		nums.add(1);			System.out.printf("add(1): %-20s%n", nums);
		nums.add(2);			System.out.printf("add(2): %-20s%n", nums);
		nums.add(3);			System.out.printf("add(3): %-20s%n", nums);		
		nums.add(4);			System.out.printf("add(4): %-20s%n", nums);
		nums.add(5);			System.out.printf("add(4): %-20s%n", nums);
		System.out.println(nums.size());
	}	
	
}
