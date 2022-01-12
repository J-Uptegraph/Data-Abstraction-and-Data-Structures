
import java.util.Arrays;

public class Tester {

	// This Lab is to implement a BinarySearchTree SET. So, NO duplicate entries
	// are allowed.  You are also to code your BinarySearchTree so that you can
	// use a for-each loop
	public static void main(String[] args) {
		BinarySearchTree_Lab07<Integer> bst = new BinarySearchTree_Lab07<Integer>();
		
		bst.add(25);		
		bst.add(12);	
		bst.add(80);
		bst.add(8);	
		bst.add(20);	
		bst.add(63);
		bst.add(12);	//	should not be added
		bst.add(25);	//	should not be added
		bst.add(90);
		bst.add(20);	//	should not be added
		bst.add(44);
		bst.add(73);
		bst.add(85);
		bst.add(71);

		System.out.println(Arrays.toString(bst.preOrder_Traversal()));
		System.out.println(Arrays.toString(bst.inOrder_Traversal()));
		System.out.println(Arrays.toString(bst.postOrder_Traversal()));
		System.out.println(Arrays.toString(bst.breadthFirst_Traversal()));
		/*
			In-Order	:	8 12 20 25 44 63 71 73 80 85 90 
			Post-Order	:	8 20 12 44 71 73 63 85 90 80 25 
			Pre-Order	:	25 12 8 20 80 63 44 73 71 90 85 
			Breath First:	25 12 80 8 20 63 90 44 73 85 71
		*/
		
		System.out.println(bst.getHeight()); 	// 4
		System.out.println(bst.contains(44)); 	// true
		System.out.println(bst.contains(99)); 	// false
		System.out.println(bst.getLevel(73)); 	// 3
		System.out.println(bst.isBalanced()); 	// false
		System.out.println(bst.isEmpty()); 		// false
		System.out.println(bst.leafCount()); 	// 6
		System.out.println(bst.min()); 			// 8
		System.out.println(bst.max()); 			// 90
		
		/* Uncomment the following loop after setting up the 
		 * BinarySearchTree_Lab07 for iteration */
		//for(int s : bst) 
		//	System.out.print(s + " ");	
	}
}
