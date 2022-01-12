
public class Tester {

	public static void main(String[] args) {
		DoublyLinkedCollection<Integer> nums = new DoublyLinkedCollection<Integer>();
		for(int i = 1; i <= 10; i++)
			nums.add(i);
		System.out.println(nums); 				// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		nums.add(99, 0);
		System.out.println(nums); 				// [99, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

		nums.add(99, 3);
		System.out.println(nums); 				// [99, 1, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10]
		

		nums.add(99, nums.size());
		System.out.println(nums); 				// [99, 1, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10, 99]

		nums.add(55, 2);
		System.out.println(nums); 				// [99, 1, 55, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10, 99]

		nums.add(55, 6);
		System.out.println(nums); 				// [99, 1, 55, 2, 99, 3, 55, 4, 5, 6, 7, 8, 9, 10, 99]
		
		nums.remove((Integer)55);	// remove the first object found that that equals 55
		System.out.println(nums); 				// [99, 1, 2, 99, 3, 55, 4, 5, 6, 7, 8, 9, 10, 99]
		
		nums.remove((Integer)55);	// remove the first object found that that equals 55
		System.out.println(nums); 				// [99, 1, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10, 99]
		
		nums.remove();
		System.out.println(nums); 				// [99, 1, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10]

		nums.remove(0);
		System.out.println(nums); 				// [1, 2, 99, 3, 4, 5, 6, 7, 8, 9, 10]

		nums.remove(2);
		System.out.println(nums);				// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		nums.remove(9);  // remove the 9th index
		System.out.println(nums);				// [1, 2, 3, 4, 5, 6, 7, 8, 9]

		System.out.println(nums.size());		// 9
		
		try {nums.add(99, nums.size()+1);} 
		catch (Exception e) {System.out.println("Correctly threw error adding to index " + (nums.size()+1));}
		
		try {nums.add(99, -1); } 
		catch (Exception e) {System.out.println("Correctly threw error adding to index -1");}
		
		System.out.println("===================================");
		while(!nums.isEmpty()) {
			nums.remove();
			System.out.println(nums + " - size: " + nums.size());
		}
		

	}

}
