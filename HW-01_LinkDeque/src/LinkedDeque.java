import java.util.NoSuchElementException;

public class LinkedDeque<E> implements DequeInterface<E>{
	//----------------------------------------------- Internal Node class
	private class Node {
		private E data;
		private Node next;
		
		private Node(E next) {
			this(next, null);
		}
		
		private Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//-------------------------------------------------------------------
	
	//====================================================================================== Properties
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	//====================================================================================== Constructors
	public LinkedDeque() {
		// head = null;
		// tail = null;
		// size = 0;
		clear(); 
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E e) {
		Node tempNode = new Node(e);				
		if(head == null) {
			head = tempNode; 					// head = new Node(e)
			tail = head; head.next = null;		// tail = new Node(e) head. next = null (Ex) "1"
		}
		else if (head == tail) {
			tail.next = tempNode;
			tail = tempNode;
			head.next = tail;
		}
		else {
			tail.next = tempNode;
			tail = tail.next;
		}
		size++; return true;
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public boolean addFirst(E e) {
		head = new Node(e, head); return true;
	}

	@Override
	public boolean addLast(E e) {
		add(e); return true;
	}

	@Override
	public boolean contains(E e) {
		Node temp = head; E tempData = temp.data;
		Node newNode = new Node(e); E newNodeData = newNode.data;
		while (temp != null){
			if(tempData == newNodeData) return true; 
			temp = temp.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (head == null && tail == head || size == 0) return true;
		return false;
	}

	@Override
	public E peekFirst() {
		if (isEmpty()) return null;
		return head.data;
	}

	@Override
	public E peekLast() {
		if (isEmpty()) return null;
		return tail.data;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) throw new NoSuchElementException();
		E tempData = head.data; head = head.next;  //(0)->0 BUT THEN (0)->1 SIZE = SIZE - 1
		size--; return tempData;
	}

	@Override
	public E removeLast() {
		Node temp = head; E tempData = temp.data;
		if (head == null) throw new NoSuchElementException();
		else if(head != null) {
			while(temp != null) {
				if(temp.next == tail) {
					tempData = tail.data;
					tail = temp; tail.next = null;
				}
				temp = temp.next;
			}
		}
		 // Empty
		else if (size() == 1) clear();
		size--;
		return tempData;
	}

	@Override
	public int size() {
		Node temp = head; int count = 0;
		while(temp != null) {
			temp = temp.next; 
			count++;
		}
		return count;
	}

	@Override
	public void clear() {
		// Base Case: head = null || tail = null || size = 0
		head = null; tail = head; size = 0;
	}

	@Override
	public String toString() {
		if (head != null) {
			String ret = ""; Node temp = head;
			while (temp != null) {
				ret += temp.data + " "; temp = temp.next;
			}
			return ret;
		}
		return "";
	}
	//----------------------------------------------- Internal Private Helper Methods
	
	
	//-------------------------------------------------------------------------------
	

}
