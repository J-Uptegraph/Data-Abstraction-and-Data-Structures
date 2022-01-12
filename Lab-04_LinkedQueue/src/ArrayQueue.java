import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {

	//====================================================================================== Properties
	private final static int DEFAULT_CAPACITY = 100;	// default array size
	private E[] elements = null;						// the array for the queue
	private int front, back, size;
	
	//====================================================================================== Constructors
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
		elements = (E[])new Object[capacity];
		clear();
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E element) {
		verifyCapacity();
		moveBack();
		elements[back] = element;
		size++;
		return true;
	}

	@Override
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		E ret = elements[front];
		elements[front] = null;
		moveFront();
		if(--size == 0) clear();
		return ret;
	}

	@Override
	public E peek() {
		return (isEmpty() ? null : elements[front]);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			for(int i = 0; i < size;  i++) {
				elements[front] = null;
				moveFront();
			}
		}
		
		front = size = 0;
		back = elements.length - 1;
	}
	
	@Override
	public String toString() {
		String ret = "";
		int f = front;
		for(int i = 0; i < size; i++) {
			ret += ", " + elements[front];
			moveFront();
		}
		front = f;
		return ("[" + ret.substring(2) + "]").replace("[, ","[");
	}
	
	//--------------------------------- Internal Methods	
	public boolean isFull() {
		return size == elements.length;
	}

	private void moveFront() {
		front = ++front % elements.length;
	}
	
	private void moveBack() {
		back = ++back % elements.length;
	}
	
	private void verifyCapacity() {
		if(isFull()) {
			E[] orig = elements;
			elements = (E[])new Object[size * 2];
			for(int i = 0; i < size; i++) {
				elements[i] = orig[front];
				front = (front + 1) % size;
			}
			front = 0;
			back = size - 1;
		}
	}
	
	//===================================================== DELETE FOR PRODUCTION
	public String showActualArray() {
		return Arrays.toString(elements);
	}
	//===================================================== DELETE FOR PRODUCTION

}
