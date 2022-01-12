
public interface QueueInterface<E> {
	boolean add(E element);	// Returns true unless system memory is full
	E remove();				// Throws NoSuchElementException if empty
	E peek();				// Returns value at top or null if empty
	void clear();
	boolean isEmpty();		// Returns true / false
	int size();				// Returns the number of elements in the Queue
}
