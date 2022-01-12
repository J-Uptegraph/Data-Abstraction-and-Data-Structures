// Author: @ Johnathan Uptegraph
// Lab-10 Sorted Linked Priority Queues


import java.util.NoSuchElementException;

public class SortedLinkedPriorityQueue <T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
		
	//============================================= Inner Node Class
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T data) {
			this(data, null);
		}
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//============================================= Properties
	private Node head;
	private int size;
	//============================================= Constructors
	public SortedLinkedPriorityQueue() {
		super();
		clear();
	}
	
	public SortedLinkedPriorityQueue(T[] entries) {
		this();
		for (T entry : entries) 		add(entry);
	}
	//============================================= Methods
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(T newEntry) {
		Node curr = head;
		Node prev = null;
		
		while(curr != null && curr.data.compareTo(newEntry) <= 0) {
			prev = curr;
			curr = curr.next;
		}
		
		if (prev == null) head = new Node(newEntry, curr);
		else prev.next = new Node(newEntry, curr);
		
		size++;
		
	}

	@Override
	public T peek() {
		return isEmpty() ? null : (T)head.data;
	}

	@Override
	public T remove() {
		if (isEmpty()) throw new NoSuchElementException();
		T ret = (T)head.data;
		head = head.next;
		size--;
		return ret;

	}
	
	public String toString() {
		String ret = "";
		Node curr = head;
		while(curr != null) {
			ret += ", " + curr.data.toString();
			curr = curr.next;
			
		}
		return "[" + ret.substring(2) + "]" ;
	}
	
	
	
	

}