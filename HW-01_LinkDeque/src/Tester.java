
public class Tester {

	public static void main(String[] args) {
		LinkedDeque<Integer> nums = new LinkedDeque<Integer>();
		System.out.println("C".compareTo("A"));
		System.out.println("=======================================");
		System.out.println(nums.peekFirst());
		System.out.println(nums.peekLast());
		
		for(int i = 0; i < 69; i++)
			nums.add(i);
		System.out.println(nums);	
		System.out.println("First Number: " + nums.peekFirst());
		System.out.println("Last Number: " + nums.peekLast());
		nums.remove();							System.out.println(nums);
		nums.remove();							System.out.println(nums);
		nums.removeLast();						System.out.println(nums);
		nums.removeFirst();						System.out.println(nums);
		nums.addFirst(0);						System.out.println(nums);
		nums.addLast(99);						System.out.println(nums);
		System.out.println("First: " + nums.peekFirst());
		System.out.println("Last: " + nums.peekLast());
		System.out.println("Size: " + nums.size());
		System.out.println("Contains(3): " + nums.contains(3));
		System.out.println("Contains(100): " + nums.contains(100));
		System.out.println("Empty: " + nums.isEmpty());
		nums.clear();
		System.out.println("Size: " + nums.size());
		System.out.println("Empty: " + nums.isEmpty());
				
	}
	
}
