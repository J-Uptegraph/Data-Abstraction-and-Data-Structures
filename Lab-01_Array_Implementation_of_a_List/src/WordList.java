import java.util.Arrays;

/**
 * 
 * Implements an array-backed list of words. The array will have a fixed
 * capacity, meaning that once it is full, no additional words can be added.
 * 
 **/

// Typically when we work with lists, we expect them to maintain order
// (things stay in the position we put them), and there are certain methods we expect to have:

//   add() 		which adds a new word to the end of the list * DONE *
//   add() 		which adds a new word to a particular location in the list * NOT DONE *
//   get() 		which retrieves an element from a particular location * DONE *
//   set() 		which changes an element at a particular location * DONE *
//	 size() 	which returns the number of elements in the list * DONE *
//   remove() 	which removes a particular word * DONE *
//   remove() 	which retrieves and removes an element from a particular location * DONE *
//   contains() which tells us whether a particular word is in the list * DONE *
//   clear() 	which removes all words * DONE *
//   toArray() 	which returns an array of words in the list * DONE *
//	 toString()	which returns a string representing the array in [value0, value1, value2, ...] format * DONE *

public class WordList {
	private String[] words;
	private int size;
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * Constructs a new empty word list with the specified capacity.
	 * 
	 * @param capacity the maximum capacity of the list
	 */

	// WordList is our Workhorse Constructor
	public WordList(int capacity) {
		words = new String[capacity];
		size = 0;
	}

	/**
	 * Constructs a new empty word list with a default capacity (in this case, 10).
	 */
	public WordList() {
		// calls the workhorse constructor
		this(DEFAULT_CAPACITY);
		// (A completely alternative solution is listed below. but this is the easier
		// way and it looks cleaner)
		// words = new String[DEFAULT_CAPACITY];
		// size = 0;

	}

	/**
	 * Returns the number of words in this list.
	 * 
	 * @return the number of words in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds a specified string to this word list
	 * 
	 * @param s string to be added
	 * @return true if the add was successful, false otherwise
	 */
	public boolean add(String s) {
		if (size == words.length)
			return false;
		// set words at size = to our string s
		words[size++] = s;
		// increment size;
		return true;
	}

	/**
	 * Adds a specified string to this word list at a specified index. The word may
	 * be added to the end of the list (when the index is the size of the list) or
	 * anywhere earlier (in which case, words will be shifted down to make room for
	 * the added word)
	 * 
	 * @param s     string to be added
	 * @param index the index where the word is to be added (any value from 0 up to
	 *              the size of the list).
	 * @param s     the word to be added
	 * @return true if the add was successful, and false otherwise
	 * @throws IndexOutOfBoundsException if index < 0 or index > size
	 */
	public boolean add(int index, String s) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		// add 1 from to size and sets value at position equal to s
//		String temp = words[index];
//		words[index] = s;
//		words[index+1] = temp;
//		for (int i = index+2; i > size; i++) {
//			words[size++] = null; 
//			words[i] = words[i+1];
//		}
//		// add 1 to size and sets value at position equal to null
//		return true;
		
		String oldString = words[index];
		String newString = s;
		for (int i = index; i < words.length -1; i++) {
			
			
			
			oldString = words[i];
			words[i] = newString;
			newString = oldString;
			oldString = words[i+1];
		}
		
		return true;
	}

	/**
	 * Removes an element from a particular location. If the location is valid,
	 * return the word that is removed. If the location is not valid, throw an
	 * OutOfBoundsException.
	 * 
	 * @param index the index of the word to be removed
	 * @return the word at the specified index
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public String remove(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		String ret = words[index];
		for (int i = index; i < size - 1; i++)
			words[i] = words[i + 1];
		// subtract 1 from size and sets value at position equal to null
		words[--size] = null;

		// Same way as below but it is simplified above

		// size --;
		// words[size] = null;

		return ret;
	}

	/**
	 * Removes all words from the list.
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * Returns true if the specified word is in this list, and false otherwise.
	 * 
	 * @param s the word to look for
	 * @return true if the word is in this list, and false otherwise
	 */
	public boolean contains(String s) {
		if (getLocation(s) == -1)
			return false;
		else
			return true;
	}

	/**
	 * Removes the first occurrence of a particular string, if it exists in the
	 * list.
	 * 
	 * @param s the string to be removed
	 * @return true if the string was removed, and false otherwise
	 */
	public boolean remove(String s) {
		int pos = getLocation(s);
		if (pos == -1)
			return false;
		remove(pos);
		return true;
	}

	/**
	 * Returns the string at a particular index, if the index is valid
	 * 
	 * @param index The location of word to be removed. Valid values are 0 through 1
	 *              less than the size of the list.
	 * @return the string at the specified location
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public String get(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		return words[index];
	}

	/**
	 * Sets a particular pre-existing location to a new word, and returns the old
	 * word that was in that location
	 * 
	 * @param index The location of word to be updated. Valid values are 0 through 1
	 *              less than the size of the list.
	 * @param s     the new value
	 * @return the old string that was just replaced
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public String set(int index, String s) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		// add 1 from to size and sets value at position equal to s
		for (int i = index + 1; i < size - 1; i++) {
			words[i] = words[i+1];
		}
		String str = words[index];
		words[index] = s;
		return str;
		// add 1 to size and sets value at position equal to null
	}
	/*
	 * A helper method. There are a couple operations that need to be able to look
	 * up where a word is in the list. So let's put that logic in one place.
	 * 
	 * returns the first index where s is located, or -1 if s is not found in the
	 * list
	 */
	private int getLocation(String s) {
		for (int i = 0; i < size; i++)
			if (words[i].equals(s))
				return i;
		return -1;
	}

	/**
	 * Returns an array of the words in the list. This is NOT the same as the array
	 * instance variable. For example, the instance variable named words might have
	 * a capacity of 10, but only contain 2 words. In that case, toArray() should
	 * return an array of length 2, containing the two words. An an empty array
	 * should return []
	 * 
	 * @return an array of all the words in the list
	 */

	public String[] toArray() {
		if (size == 0)
			return new String[0];
		String[] ret = new String[size];
		for (int i = 0; i < size; i++)
			ret[i] = words[i];
		return ret;
	}

	/**
	 * Returns a formatted string that represents the list of the array of words you
	 * can
	 * 
	 * @return a formatted string of the list of words in the format [value0,
	 *         value1, value2, ...] an empty array should return []
	 */
	public String toString() {
		// Simply ties into the toArray() above and returns it's values as a string
		// using the "Arrays. "
		return Arrays.toString(toArray());
	}
	
	public String toStringTestDontUse() {
		return Arrays.toString(words);
	}

}