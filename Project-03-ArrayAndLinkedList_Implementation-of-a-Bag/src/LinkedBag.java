// author Johnathan Uptegraph
// date 10/17/2021'
// This is a LinkedBag and an Implementation of BagInterface and serves as a component of project 3
public class LinkedBag<E> implements BagInterface<E>{
	
	// ========================================== Internal Node Class
	private class Node {
		E data;
		Node next;
		
		Node (E data){
			this.data = data;
			next = null;
		}
	
	}
	
	// ========================================== Properties
	private Node head;
	private int size;
	private final static int DEFAULT_CAPACITY = 10;
	
	// ========================================== Constructors
	public LinkedBag() {
		this (DEFAULT_CAPACITY);
	}
	
	public LinkedBag(int size) {
		if (size < 0) throw new IllegalArgumentException("Array Size Cannot Be Negative");
		clear();
	}
	
	// ========================================== Methods

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (head == null && size == 0);
	}

	@Override
	public boolean add(E newEntry) {
		Node n = new Node(newEntry);
		if(head == null) head = n;
		else {
			Node temp = head;
			head = n; head.next = temp;
		}
		size++;
		return true;
	}

	@Override
	public E remove() {
//		if (isEmpty()){return null;}
//		else {
//			Node temp = head;
//			head.next = temp;
//			head.data = null;
//		}
//		return null;
		
		if (isEmpty()) { return null;}
		
		E data = head.data;
		head = head.next;
		size--;
		return data;
	}

	@Override
	public boolean remove(E anEntry) {
		// TODO Auto-generated method stub
		Node temp = head;
		
		if (this.size == 1) {
			clear();
		}
		
		while (temp.next != null) {
			if (temp.next.data.equals(anEntry)) {
				temp.next = temp.next.next;
				this.size--;
				return true;
			}
			temp = temp.next;
		}
		
		return false;
		
	}

	@Override
	public void clear() {
		head = null; size = 0;
	}

	@Override
	public int getFrequencyOf(E anEntry) {
//		int count = 0;
//		if (isEmpty()) return count;
//		while (head != null) {
//			head = head.next;
//			if (head.data == anEntry) count++;
//		}
//		return count;
		
		Node temp = head;
		int count = 0;
		
		if (isEmpty()) return 0;
		while (temp != null) {
			if (temp.data.equals(anEntry)) {
				count++;
			}
			
			temp = temp.next;
		}
		
		return count;
	}

	@Override
	public boolean contains(E anEntry) {
		if (isEmpty()) return false;
		Node temp = head;
//		while (head.next != null) {
//			head = head.next;
//			if (head.data == anEntry) return true;
//			}
		
		while (temp != null) {
			if (temp.data.equals(anEntry)) { return true;}
			temp = temp.next;
		}
		return false;
		
	}

	@Override
	public E[] toArray() {
		E[] ret = (E[])new Object[size];
		if (isEmpty()) return ret;
		while (head != null) {
			int i = 0;
			ret[i] = head.data;
			head = head.next; i++;
		}
	    return ret;
	}

	@Override
    public void removeDuplicates() {
        // TODO Auto-generated method stub
        if (this.size < 2) {
            return;
        }

        LinkedBag uniques = new LinkedBag(this.size);

        Node temp = head;

        while (temp != null) {
            if (!linkedContains(uniques, temp.data)) {
                uniques.add(temp.data);
            }

            temp = temp.next;
        }

        this.size = uniques.size;
        this.head = uniques.head;

    }

    private boolean linkedContains(LinkedBag uniques, E anElement) {
        Node temp = uniques.head;
        while (temp != null) {
            if (temp.data.equals(anElement)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

	@Override
	public boolean containsAll(BagInterface aBag) {
		// TODO Auto-generated method stub
		E[] aBagArray = (E[]) aBag.toArray();

        for (int i = 0; i < aBagArray.length; i++) {
            if (!this.contains(aBagArray[i])) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean sameItems(BagInterface aBag) {
		// TODO Auto-generated method stub
		
		if (aBag.size() != this.size) {
			return false;
		}
		
		Node temp = head;
		
		while (temp != null) {
			if (!(getFrequencyOf(temp.data) == aBag.getFrequencyOf(temp.data))) {
				return false;
			}
			
			temp = temp.next;
		}
		
		return true;
	}

}
