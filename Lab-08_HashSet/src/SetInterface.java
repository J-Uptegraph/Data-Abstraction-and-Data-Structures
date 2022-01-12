
public interface SetInterface<T> {

	public boolean add(T item);
	public boolean remove(T item);
	public boolean contains(T item);
	public int size();
	public boolean isEmpty();
	public void clear();
	public Object[] toArray();
	
}
