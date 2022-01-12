import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A resizable-array based stack.
 * @param <T> the type of items to store in the stack.  Any object type is valid.
 */

public class ArrayStack<T> implements StackInterface<T> {

	private int topIndex;
	private T[] stackData;
	
	/**
	 * Constructs a new stack with underlying array of length 10
	 */
	// This makes the warning go away when we cast the Object array to a T array
	@SuppressWarnings("unchecked")
	//	**** Set Size **** only constructor
	public ArrayStack() {
		topIndex = -1;
		stackData = (T[])new Object[10];
	}
	
	@Override
	public void push(T item) {
		if (topIndex == stackData.length - 1)  // stack full? resize before push
			stackData = Arrays.copyOf(stackData, 2 * stackData.length);
		stackData[++topIndex] = item;			
	}

	@Override
	public T pop() {
		T result = peek();
		stackData[topIndex--] = null;
		return result;
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyStackException();
		return stackData[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}

	@Override
	public void clear() {
		for(int i = 0; i <= topIndex; i++)		stackData[i] = null;
		topIndex = -1;
	}
	
	@Override
	public <T> T[] toArray(T[] obj) {
		return (T[]) Arrays.copyOf(stackData, topIndex + 1, obj.getClass());
	}
	
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(stackData, topIndex + 1);
	}
	
	@Override
	public String toString() {
		return Arrays.toString( toArray() );
	}
}
