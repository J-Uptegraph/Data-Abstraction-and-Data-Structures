/***
 * 
 * @apiNote Lab-05_DoublyLinkedCollection
 * 
 * @author Johnathan Uptegraph, Jake Hoffman, Tanner Cornett 
 * 
 *
 */

public class DoublyLinkedCollection<E> implements CollectionInterface<E> {
	//====================================================================================== Internal Classes
	private class Node {
		E data;
		Node next;
		Node prev;
		
		public Node(E data) {
			this(data, null, null);
		}
		
		public Node(E data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		//============================================= Node methods
		void remove() {
			if (prev != null) prev.next = next;
			if (next != null) next.prev = prev;
		}
		
		Node insertLeft(E data) {
			return insertLeft(new Node(data));
		}
		
		Node insertRight(E data) {
			return insertRight(new Node(data));
		}
		
		
		Node insertLeft(Node n) {
			// Hold onto this
			n.next = this;
			// node prev = my prev
			n.prev = prev;
			if (prev != null) {
				prev.next = n;
			}
			prev = n;
			return n;
		}
		
		Node insertRight(Node n) {
			// Hold onto this
			n.prev = this;
			// node prev = my prev
			n.next = next;
			if (next != null) {
				next.prev = n;
			}
			next = n;
			return n;
		}
		
		Node find(E val) {
			if (data.equals(val)) return this;
			if (next == null) return null;
			return next.find(val);
		}
		Node get(int i) {
			if (i == 0) return this;
			if (i < 0 || next == null) return null;
			return next.get(--i);
		}
		
		@Override
		public String toString() {
			if (next == null) return data.toString();
			return data.toString() + ", " + next.toString();
		}
		
	}
		
	
	//====================================================================================== Properties
	private Node head;
	private Node tail;
	private int size;
	
	//====================================================================================== Constructors
	public DoublyLinkedCollection() {
		clear();
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E e) {
		return add(e,size);		
	}

	@Override
	public boolean add(E e, int index) {
		// You need to check the bounds first
		if (index < 0 || index > size) throw new IndexOutOfBoundsException();

		Node tmp = new Node(e);
			if (isEmpty()) {
				head = tail =  tmp;
			} else if (index == size) {
				tail.next = tmp;
				tmp.prev = tail;
				tmp.next = null;
				tail = tmp;
			} else if (index == 0) {
				head = head.insertLeft(tmp);
			}
			else {
				head.get(index - 1).insertRight(tmp);
			}
			size++;
			return true;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E o) {
		if (isEmpty()) return false;
		// If it comes back as null then it was false.
		return head.find(o) != null;
	}

	@Override
	public E get(int index) {
		// You need to check the bounds first
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return head.get(index).data;	
	}

	@Override
	public int indexOf(E o) {
		if(isEmpty()) {
			return -1;
		}
			Node n = head;
			int count = 0;
			while (n != null) {
				if(n.data.equals(o)) {
					return count;
				}
			count++;
			n = n.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean remove(int index) {
		// You need to check the bounds first
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			Node tmp = head.get(index);
			if(isEmpty()) return false;
			else if (head == tail || size == 1) {
				clear();
				return true;
			} else if (index == size - 1) {
				tail = tail.prev;
				tail.next = null;
			} else if (index == 0) {
				head = head.next;
				head.prev = null;
			} else {
				tmp.remove();
			}
			size--;
			return true;		
	}

	@Override
	public boolean remove(E o) {
		return remove(indexOf(o));
	}
		

	@Override
	public boolean remove() {
		return remove(size-1);		// remove method will remove the last node
	}

	@Override
	public int size() {
		return size;		
	}

	@Override
	public String toString() {
		if(head == null)
			return "[]";
		return "[" + head.toString() + "]";
	}
}
