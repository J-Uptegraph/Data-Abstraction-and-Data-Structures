import java.util.NoSuchElementException;public final class LinkedQueue<E> implements QueueInterface<E> {	//----------------------------------------------------- Inner Node Class	private class Node {		private E data;		private Node next;				private Node(E next) {			this(next, null);		}		private Node(E data, Node next) {			this.data = data;			this.next = next;		}		public String toString() {			if(next == null) return data.toString();			return data.toString() + "->" + next.toString( );			}		}	//----------------------------------------------------------------------	//====================================================================== Properties	private Node head;	private Node tail;	private int size;		//====================================================================== Constructors	public LinkedQueue() {		clear();	}	//====================================================================== Methods	@Override	public boolean isEmpty() {		if (head == null) {			return true;		}		return false;	}		@Override	public void clear() {		head = null;		tail = null;		size = 0;	}		@Override	public int size() {		return size;				}		@Override	public boolean add(E newEntry) {		if (head == null && tail == null) {			head = new Node(newEntry, null);			tail = head;		}		else if (head == tail) {			head.next = new Node(newEntry, null);			tail = head.next;			}		else {			tail.next = new Node(newEntry, null);			tail = tail.next;		}		size++;		return true;	}		// Returns null if empty	@Override	public E peek() {		if(isEmpty()){			return null;		}		return head.data;	}		// Throws NoSuchElementException if empty	@Override	public E remove() {		if(isEmpty()){			throw new NoSuchElementException();		} else if (head == tail) {			tail = null;		}		E ret = head.data;		head = head.next;		size--;		return ret;	}		@Override	public String toString() {		if (head == null) {			return "Queue is Empty";		}		return head.toString();	}		//----------------------------------------------- Personal Methods			//	public static void main(String[] args) {	//		LinkedQueue<Integer> lst = new LinkedQueue();	//		lst.add(1);	//		lst.add(2);	//		lst.add(3);	//		lst.add(4);	//		lst.add(5);	//		System.out.println(lst);	//		System.out.println(lst.peek());	//		System.out.println(lst.remove());	//		System.out.println(lst);	//	}}