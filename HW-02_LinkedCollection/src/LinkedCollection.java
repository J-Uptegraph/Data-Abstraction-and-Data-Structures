import java.util.NoSuchElementException;

public class LinkedCollection<E> implements CollectionInterface<E> {

	//************************************************************************************** Inner Node Class
	private class Node {

		E data;
		Node next;

		Node(E data) {
			this(data, null);
		}

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		//================================== Helper

	}
	//**************************************************************************************

	//====================================================================================== Properties
	private int size;
	private Node head;

	//====================================================================================== Constructors
	public LinkedCollection() {
		// head = null;
		// size = 0;
		clear();
	}

	//====================================================================================== Methods
	@Override
	public boolean add(E o) {


		Node node = new Node(o);

		if (head == null) {
			head = node;
			size++;
			return true;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;

		size++;

		return true;
	}

	@Override
	public boolean remove(E o) {
		int index = indexOf(o);
		remove(index);
		return true;
	}

	@Override
	public boolean remove(int index) {
		if (head == null) return false;
		Node temp = head;
		if (index == 0) {
			head = temp.next; return true;
		}
		for (int i = 0; temp != null && i < index - 1; i++) temp = temp.next;
		if (temp == null || temp.next == null) return false;
		Node next = temp.next.next;
		temp.next = next;
		return true;
	}

	@Override
	public boolean contains(E o) {
		Node temp = head;
		while (temp != null) {
			if (temp.data.equals(o)) return true;
			temp = temp.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (head == null || size == 0) return true;
		return false;
	}

	@Override
	public E get(int index) {
		Node temp = head;

		if (head == null) return null;

		int tempIndex = 0;
		while (temp != null) {
			if (tempIndex == index) return temp.data;


			tempIndex++;
			temp = temp.next;
		}

		return null;
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
	public int indexOf(E o) {
		if (!contains(o)) return -1;
		int index = 0;

		Node temp = head;

		while (temp != null) {
			if (temp.data.equals(o)) {
				return index;
			}
			index++;
			temp = temp.next;
		}

		return -1;
	}

	@Override
	public void clear() {
		head = null; size = 0;
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
}