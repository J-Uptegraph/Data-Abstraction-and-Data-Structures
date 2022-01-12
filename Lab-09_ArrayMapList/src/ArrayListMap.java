// Author Johnathan Uptegraph
// CSE 274
// Lab 09 ArrayList Map
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ArrayListMap<K, V> implements MapInterface<K, V>{
	
	//================================================================ Inner Class
	private class Entry {
		private K key;
		private V value;
		
		private Entry(K key) { this(key, null); }
		
		// =========================================================== Workhorse Constructor 
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
	}
	
	//================================================================ Properties
	private ArrayList<Entry> arrayMap;
	
	
	//================================================================ Constructors
	public ArrayListMap() {
		arrayMap = new ArrayList<Entry>();
	}


	@Override
	public V put(K key, V value) {
		for(Entry e : arrayMap) {
			if (e.key.equals(key)) {
				V ret = e.value;
				e.value = value;
				return ret;
			}
		}
		arrayMap.add(new Entry(key, value));
		return null;
	}


	@Override
	public V get(K key) {
		for(Entry e : arrayMap)
			if (e.key.equals(key))
			return e.value;
		return null;
	}


	@Override
	public V remove(K key) {
		//	for(Entry e : arrayMap) {
		//	if (e.key.equals(key)) {
		//	arrayMap.remove(e);
		//	return e.value;
		//	}
		
		for (int i = 0; i < arrayMap.size(); i++)
			if(arrayMap.get(i).key.equals(key))
				return arrayMap.remove(i).value;
		return null;
	}


	@Override
	public boolean containsKey(K key) {
		for(Entry e : arrayMap)
			if (e.key.equals(key)) return true;
		return false;
	}


	@Override
	public boolean isEmpty() {
		return arrayMap.isEmpty();
	}


	@Override
	public void clear() {
		arrayMap.clear();
		
	}


	@Override
	public int size() {
		return arrayMap.size();
	}


	@Override
	public Set<K> keySet() {
		Set<K> ret = new HashSet<K>();
		for(Entry e : arrayMap)
			ret.add(e.key);
		return ret;
	}


	@Override
	public Collection<V> values() {
		Collection<V> ret = new ArrayList<V>();
		for(Entry e : arrayMap)
			ret.add(e.value);
		return ret;
	}
	
}
