import java.util.EmptyStackException;

/**
 * A Linked List based stack.
 * @author Johnathan Uptegraph 
 *
 */

public class LinkedListStack<Athlete> implements StackInterface<Athlete> {
	
	//======================================================== Inner Node Class
	private class Node {
		Athlete data = null;
		Node next = null;
		
		public Node(Athlete data) {
			this(data, null);
		}
		
		public Node(Athlete data, Node next) {
			this.data = data;
			this.next = next;
			
		}
	}
	//=========================================================================
	
	// private member variable to keep track of the number of nodes
	private int size;
	private Node head;
	
	/*
	 * For the following implementations, refer to the StackInterface for 
	 * documentation on how to handle edge cases
	 * 
	 */
	@Override
	public void push(Athlete item) {
		// 3 line version
		// Node a = new Node(item);
		// a.next = a;
		// head = a;
		
		// 1 line version
		head = new Node(item, head);
		size++;
	}

	@Override
	public Athlete pop() {
		Athlete ret = peek();
		head = head.next;
		size--;
		return ret;
	}

	@Override
	public Athlete peek() {	
		if(isEmpty()) throw new EmptyStackException();
		return head.data;
		// Check the StackInterface
		// When you don't know what to do if "isEmpty"
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	// Returns (without removing) the Athlete as the index position
	// throws IndexOutOfBoundsException if index is invalid 
	public Athlete get(int index) {
		Node tmp = head;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		while (index != 0) {
			tmp=tmp.next;
			index--;
		}
		return tmp.data;
	}

	// Reverses the stack
	public void reverseStack() {
		LinkedListStack<Athlete> temp= new LinkedListStack<>();
		for(int i = size-1; i > size; i--) {
			temp.push(get(i));
		}
		clear();
		while (!temp.isEmpty()){
			this.push(temp.pop());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while(tmp!=null) {
			sb.append(tmp.data.toString());
			sb.append("\n");
			tmp = tmp.next;
		}
		return sb.toString();
	}
	
}
