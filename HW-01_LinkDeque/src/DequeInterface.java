

public interface DequeInterface<E> {
	boolean add(E e);		// Adds e to end of list and returns true.
	E remove();				// Returns and removes first element of list. Throws NoSuchElementException if list is empty
	boolean addFirst(E e);	// Adds e to front of list and returns true.
	boolean addLast(E e);	// Adds e to end of list and returns true.
	boolean contains(E e);	// Returns true or false depending if e is found in the Deque list
	boolean isEmpty();		// Returns true if the number of elements in list = 0, false otherwise
	E peekFirst();			// Returns first element of list or null if list is empty
	E peekLast();			// Returns last element of list or null if list is empty
	E removeFirst();		// Returns and removes first element of list. Throws NoSuchElementException if list is empty
	E removeLast();			// Returns and removes last element of list. Throws NoSuchElementException if list is empty
	int size();				// Returns the number of elements in the Deque list
	void clear();			// Clears all items from list
}
