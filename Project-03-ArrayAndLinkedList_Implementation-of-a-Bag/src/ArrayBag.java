// author Johnathan Uptegraph
// date 10/17/2021
// This is a ArrayBag and an Implementation of BagInterface and serves as a component of project 3
public class ArrayBag<E> implements BagInterface<E>{
	
	// ========================================== Properties
	int size;
	private E [] array;
	private static int DEFAULT_CAPACITY = 10;
	// ========================================== Constructors
	public ArrayBag() {
		this (DEFAULT_CAPACITY);
	}
	public ArrayBag(int size) {
		if (size < 0) throw new IllegalArgumentException("Array Size Cannot Be Negative");
		this.size = 0;
		this.array = (E[]) new Object[size];
	}
		
	// ========================================== Methods

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		 if (this.size == 0) {return true;}
		 else {return false;}
	}

	@Override
    public boolean add(Object newEntry) {
        if (this.array.length == 0) {
            this.array = (E[]) new Object[DEFAULT_CAPACITY];
            this.array[0] = (E) newEntry;
            this.size++;
            return true;
        }

        if(this.size == this.array.length) {
            E[] resizedArray = (E[]) new Object[this.size * 2];

            for (int i = 0; i < this.array.length; i++) {
                resizedArray[i] = this.array[i];
            }

            this.array = resizedArray;
        }

        this.array[size] = (E) newEntry;
        this.size++;
        return true;

    }
	
	@Override
	public E remove() {
		if (isEmpty()){return null;}
		E removeItem = this.array[this.size-1];
		this.array[this.size -1] = null; size--;
		return removeItem;
	}

	@Override
	public boolean remove(E anEntry) {
		if (isEmpty() || !(contains(anEntry))){return false;}
		else {
		for (int i = 0; i < this.size; i++) {
			if (this.array[i].equals(anEntry)) {
				this.array[i] = null;size--;
				}
			}
		}
		return true;
	}

	@Override
	public void clear() {
		size = 0;
		this.array = (E[]) new Object[DEFAULT_CAPACITY];
	}

	@Override
	public int getFrequencyOf(E anEntry) {
		if (isEmpty()) return 0;
		int duplicates = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (this.array[i].equals(anEntry)) {
				duplicates++;
			}
		}
		return duplicates;
	}

	@Override
	public boolean contains(E anEntry) {
		if (isEmpty()) return false;
		for (E currentElement : this.array) {
			if (currentElement == null) {
				continue;
			}
			if(currentElement.equals(anEntry)) return true;
			else{return false;}
		}
		return false;
	}

	@Override
    public E[] toArray() {
        E[] ret = (E[])new Object[size];
        for(int i = 0; i < size; i++)
            ret[i] = this.array[i];
        return ret;
    }

	@Override
    public void removeDuplicates() {
		if (this.size < 2) {
			return;
		}
		
		E[] uniques = (E[]) new Object[this.array.length];
		int uniquesLastIndex = 0;
		int uniquesSize = 0;
		for (int i = 0; i < this.size; i++) {
			if (!arrayContains(this.array[i+1], uniques)) {
				uniques[uniquesLastIndex] = this.array[i];
				uniquesLastIndex++;
				uniquesSize++;
			}
		}
		
		this.array = uniques;
		this.size = uniquesSize;

    }
	
	private boolean arrayContains(E anItem, E[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			if (anArray[i] == null) {
				continue;
			}
			if (anArray[i].equals(anItem)) {
				return true;
			}
		}
		return false;
	}

	@Override
    public boolean containsAll(BagInterface aBag) {
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
        E[] aBagArray = (E[]) aBag.toArray();

        if (aBag.size() != this.size) {
            return false;
        }

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                continue;
            }

            if (!(getFrequencyOf(this.array[i]) == aBag.getFrequencyOf(this.array[i]))) {
                return false;
            }
        }

        return true;
    }

}
