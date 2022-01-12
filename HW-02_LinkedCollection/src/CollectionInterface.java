public interface CollectionInterface<E> {
	boolean add(E e);			// appends the specified element to the end of this list.
	void clear();				// removes all of the elements from this list.
	boolean contains(E o);		// returns true if this list contains the specified element.
	E get(int index);			// returns element at the index or throws IndexOutOfBoundsException
								// if (index < 0 || index >= size())
	int indexOf(E o);			// returns the index of o in list or -1 if not found
	boolean isEmpty();			// returns boolean depending on the size of the list
	boolean remove(int index);	// removes element at position index. Returns true if element was removed
	boolean remove(E o);		// removes fist instance of o. Returns true if element was removed
	int size();					// returns the number of elements in the list
}
