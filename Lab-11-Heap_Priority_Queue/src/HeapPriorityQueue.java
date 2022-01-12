import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapPriorityQueue<T extends Comparable<? super T>>{

	//============================================================================ Properties
	private static final int DEFAULT_CAPACITY = 11;
	private T[] heap;
	private int size;
	//============================================================================ Constructors
	public HeapPriorityQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public HeapPriorityQueue(int capacity) {
		heap = (T[]) new Comparable[capacity];
		size = 0;
	}
	
	public HeapPriorityQueue(T[] entries) {
		this(entries.length + 1);
		size = entries.length;
		for(int index = 0; index < entries.length; index++)
			heap[index + 1] = entries[index];
		for(int rIndex = size / 2; rIndex > 0; rIndex--)
			reheapDown(rIndex);
		}
	
	//============================================================================ Helper Methods
	private void verifyCapacity() {
		if(size == heap.length - 1)
			heap = Arrays.copyOf(heap, 2 * (size + 1));
	}
	
	private void reheapUp(int index) {
		if(index < 2) return;
		int par = index / 2;
		if(getCompare(index, par) <= 0) return;
		
		swap(index, par);
		reheapUp(par);
	}
	
	private void reheapDown(int index) {
		if (checkLeaf(index) == true) {
			return;
		}
		int child = checkChild(index);
		if (heap[index].compareTo(heap[child]) < 0) {
			swap(index, child);
		}

		reheapDown(child);
	}
	
	private int checkChild(int num) {
		if (heap[num * 2] == null) {
			return (num * 2) + 1;
		}
		if ((num*2)+1 >= size || heap[(num * 2) + 1] == null) {
			return (num * 2);
		}
		return (heap[num * 2].compareTo(heap[(num * 2) + 1]) > 0) ? num * 2 : num * 2 + 1;
	}
	
	private boolean checkLeaf(int pos) {
		if (pos * 2 > size) {
			return true;
		} else if (heap[pos * 2] == null && heap[(pos * 2) + 1] == null) {
			return true;
		}
		return false;
	}
	
	private void swap(int i, int j) {
		T tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	private int getCompare(int i, int j) {
		return heap[i].compareTo(heap[j]);
	}
	
	@Override
	public String toString() {
		String ret = "[" + heap[0];
		for(int i = 1; i <= size; i++) {
			ret += ", " + heap[i];
		}
		return ret + "]";
	}
	//============================================================================ Implemented Methods
	
	
	
	public boolean isEmpty() {
		return size == 0;
	}

	
	public boolean isFull() {
		return false;
	}

	
	public void clear() {
		Arrays.fill(heap, 0, size, null);
		size = 0;
	}

	
	public int size() {
		return size;
	}

	
	public void add(T newEntry) {
		verifyCapacity();
		heap[++size] = newEntry;
		reheapUp(size);
	}

	
	public T peek() {
		return isEmpty() ? null : heap[1];
	}

	
	public T remove() {
		if(isEmpty()) throw new NoSuchElementException();
		T ret = heap[1];
		heap[1] = heap[size];
		heap[size--] = null;
		reheapDown(1);
		return ret;
	}

	

}
