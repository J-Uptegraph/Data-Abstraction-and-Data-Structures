// Author @Johnathan Uptegraph
/*
 	Lab-07: BinarySearchTree Implementation
 	
 	Rules:
 		1. Allow Tester to iterate through all nodes using the in-order traversal as the default.
 			This means, in Tester the following code should work for an instance of this class
 			called bst that is storing Student objects for the data:
 				
 				BinarySearchTree_Lab07<String> bst = new BinarySearchTree_Lab07<String>();
 				bst.add("Man");		bst.add("Soda");	bst.add("Flag");
 				bst.add("Home");	bst.add("Today");	bst.add("Jack");
 			
 				for(String s : bst) 
 					System.out.println(s);
*/


import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree_Lab07<T> {
	//====================================================================================== Properties
	private Node root;
	private int nodeCount;

	private Comparator<T> comp = new Comparator<T>() {

		public int compare(T o1, T o2) {
			return ((Comparable)o1).compareTo(o2);
		}
	};

	//====================================================================================== Constructors
	public BinarySearchTree_Lab07() {
		root = null;
		nodeCount = 0;
	}

	// Constructor that takes an array of items and populates the tree
	public BinarySearchTree_Lab07(T[] items) {
		this();
		for (T o : items) {
			add(o);
		}
	}

	//====================================================================================== Methods
	public void add(T data) {	// Implement recursively and do NOT allow duplicates
		if (isEmpty()) {
			root = new Node(data);
			return;
		}
		recursiveAdd(root, data);
		return;
	}

	private void recursiveAdd(Node node, T newData) {
		if (comp.compare(node.data, newData) == 0) {
			return;
		} else if (comp.compare(node.data, newData) > 0) {
			if (node.left == null) {
				node.left = new Node(newData);
				nodeCount++;
				return;
			} else
				recursiveAdd(node.left, newData);
				return;
		} else {
			if (node.right == null) {
				node.right = new Node(newData);
				nodeCount++;
				return;
			} else
				recursiveAdd(node.right, newData);
				return;
		}
	}

	// Returns the traversal of this tree as an array
	public String[] preOrder_Traversal() {
		return preOrder_Traversal_Recursive(root).split(" ");
	}

	private String preOrder_Traversal_Recursive(Node node) {
		String result = "";

		if (node != null) {
			result += node.data.toString() + " " + preOrder_Traversal_Recursive(node.left) + preOrder_Traversal_Recursive(node.right);
		}

		return result;
	}

	public String[] inOrder_Traversal() {
		return inOrder_Traversal_Recursive(root).split(" ");
	}

	private String inOrder_Traversal_Recursive(Node node) {
		String result = "";

		if (node != null) {
			result += inOrder_Traversal_Recursive(node.left) + node.data.toString() + " " + inOrder_Traversal_Recursive(node.right);
		}

		return result;
	}

	public String[] postOrder_Traversal() {
		return postOrder_Traversal_Recursive(root).split(" ");
	}

	private String postOrder_Traversal_Recursive(Node node) {
		String result = "";

		if (node != null) {
			result += postOrder_Traversal_Recursive(node.left) + postOrder_Traversal_Recursive(node.right) + node.data.toString() + " ";
		}

		return result;
	}

	public String[] breadthFirst_Traversal() {
		String[] result = new String[nodeCount];
		LinkedList<T> ll = new LinkedList<T>();
		breadthFirst_Traversal_Recursive(root, ll);
		for(int i = 0; i < result.length; i++) { result[i] = "" + ll.get(i); }
		return result;
	}

	private void breadthFirst_Traversal_Recursive(BinarySearchTree_Lab07<T>.Node n, LinkedList<T> ll) {

		if (n == null) return;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(n);
		while(!(q.isEmpty())) {
			Node temp = q.remove();
			ll.add(temp.data);
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
	}

	// Since this is a binary SEARCH tree, you should write
	// an efficient solution to this that takes advantage of the order
	// of the nodes in a BST.  Your algorithm should be, on average,
	// O(h) where h is the height of the BST.
	public boolean contains(T data) {
		return containsRecursive(root, data);
	}

	private boolean containsRecursive(Node node, T data) {
		if (node == null) {
			return false;
		}

		if (node.data.equals(data)) {
			return true;
		} else if (comp.compare(node.data, data) > 0) {
			return containsRecursive(node.left, data);
		} else {
			return containsRecursive(node.right, data);
		}
	}

	// returns the smallest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version 
	public T min() { return min(root); }		// this method is done for you.

	private T min(Node n) {	// Write this method.
		if(n.left != null) {
			return (T) min(n.left);
		}
		return (T) n.data;
	}

	// returns the largest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version
	public T max() { return max(root); }		// this method is done for you.

	private T max(Node n) {	// Write this method.
		if(n.right != null) {
			return (T) max(n.right);
		}
		return (T) n.data;
	}

	// Returns whether the tree is empty
	public boolean isEmpty() {
		return root == null;
	}

	// returns the height of this BST. If a BST is empty, then
	// consider its height to be -1.
	public int getHeight() {
		if (isEmpty() || (root.left == null && root.right == null)) {
			return 0;
		}

		return getHeightRecursive(root);
	}

	private int getHeightRecursive(Node node) {
		if (node == null) {
			return -1;
		}

		return 1 + Math.max(getHeightRecursive(node.left), getHeightRecursive(node.right));
	}


	// returns the number of leaf nodes
	public int leafCount() {
		return leafCountRecursive(root);
	}

	private int leafCountRecursive(Node node){
		if( node == null )
			return 0;
		if( node.left == null && node.right == null ) {
			return 1;
		} else {
			return leafCountRecursive(node.left) + leafCountRecursive(node.right);
		}
	}


	// returns the "level" of the value in a tree.
	// the root is considered level 0
	// the children of the root are level 1
	// the children of the children of the root are level 2
	// and so on.  If a value does not appear in the tree, return -1
	//              15
	//             /  \
	//            10  28
	//              \   \
	//              12  40
	//                 /
	//                30
	// In the tree above:
	// getLevel(15) would return 0
	// getLevel(10) would return 1
	// getLevel(30) would return 3
	// getLevel(8) would return -1
	public int getLevel(T n) {
		return getLevel(root, n, 0);
	}

	private int getLevel(Node n, T o, int count) {
		if(n == null) return -1;
		if(comp.compare(o, n.data) == 0) 	 { return count; }
		if(comp.compare(o, n.data) <= 0) 	return getLevel( n.left ,o, count+1);
		else								return getLevel( n.right ,o, count+1);
	}


	// *********************************************************
	// EXTRA CREDIT: 5pts
	// *********************************************************
	// A tree is height-balanced if at each node, the heights
	// of the node's two subtrees differs by no more than 1.
	//  Special note about null subtrees:
	//            10
	//              \
	//               20
	// Notice in this example that 10's left subtree is null,
	// and its right subtree has height 0. We would consider this
	// to be a balanced tree. If the tree is empty, return true;
	public boolean isBalanced() {
		return false;
	}


	//====================================================================================== Inner Node Class
	private class Node {
		private T data;
		private Node left, right;

		private Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
}

