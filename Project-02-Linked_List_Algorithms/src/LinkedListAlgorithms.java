import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Johnathan Uptegraph
 * 
 * @apiNote Project-02 Linked Algorithms
 *
 */
public class LinkedListAlgorithms {

	// ==================================================================== Internal
	// Node Class
	private class Node {
		String data;
		Node next;

		Node(String data) {
			this(data, null);
		}

		Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		// You may add helper methods here
		Node findLast() {
			if (next == null)
				return this;
			return next.findLast();
		}

		Node get(int i) {
			if (i == 0)
				return this;
			return next.get(--i);
		}

		public String toString() {
			if (next == null)
				return data;
			return data + ", " + next.toString();
		}

		public String getConcatenation() {
			if (next == null)
				return null;
			return next.toString() + data;
		}

	}
	// ========================================================================================

	// ====================================================================
	// Properties
	public Node head;
	public int size;

	// ====================================================================
	// Constructors
	/**
	 * Creates the empty list.
	 */

	public LinkedListAlgorithms() {
		head = null;
		size = 0;
	}

	/**
	 * Creates a list containing all the elements of the passed array.
	 * {@code data[0]} will be the first element of the list, {@code data[1]} will
	 * be the second element of the list, and so on.
	 * 
	 * @param data The array of values
	 * @throws NullPointerException - data is null
	 */
	public LinkedListAlgorithms(String[] data) {
		if (data == null) throw new NullPointerException("Empty Data : Null Pointer Exception");
		for (String s : data) insertLast(s);
	}

	/**
	 * Constructs a deep copy of the linked list {@code original}
	 * 
	 * @param original The list to be copied
	 * @throws NullPointerException - original is null
	 */
	public LinkedListAlgorithms(LinkedListAlgorithms original) {
		if (original == null || original.head == null) return;
		Node temp = original.head;
		while (temp != null) {
			insertLast(temp.data); temp = temp.next;
		}
	}

	// ==================================================================== Methods
	/**
	 * Returns array with all the elements.
	 * 
	 * @return Array containing all elements.
	 */
	public String[] toArray() {
		String[] arr = new String[size];
		if (head == null) return arr;
		Node temp = head;
		for (int i = 0; i < size; i++) {
			arr[i] = temp.data; temp = temp.next;
		}
		return arr;
	}

	/**
	 * Formats the elements in the list using leading and ending brackets (i.e.,
	 * []), with the values comma separated. There will be one space between each of
	 * these but none at the beginning nor at the end. Some examples: if the list is
	 * empty, toString() gives [] if the list has these three elements in this
	 * order: "hello", "world", "everyone", then the result should be [hello, world,
	 * everyone]
	 */
	@Override
	public String toString() {
		if (head == null) return "[]";
		return "[" + head.toString() + "]";
	}

	/**
	 * Returns the number of items in the list
	 * 
	 * @return Number of items in the list
	 */
	public int size() {
		if (head == null) return 0;
		Node temp = head; int count = 1;
		while (temp.next != null) {
			count++; temp = temp.next;
		}
		return count;
	}

	/**
	 * Determines if two lists contain exactly the same values, in exactly the same
	 * order.
	 * 
	 * @return {@code true} if and only if obj is an list that is equivalent to the
	 *         incoming list.
	 */
	public boolean equalsLinkedList(LinkedListAlgorithms obj) {
		if (this.size() != obj.size()) return false;
		if (head == null && obj.head == null) return true;
		if ((this.head == null && obj.head != null) || (this.head != null && obj.head == null)) return false;
		Node temp = head; Node objtemp = obj.head;
		while (temp != null) {
			if (!temp.data.equals(objtemp.data)) return false;
			temp = temp.next; objtemp = objtemp.next;
		}
		return true;
	}

	/**
	 * Determines if {@code key} is in the linked list.
	 * 
	 * @param key The value to be found
	 * @return true if and only if {@code key} is in the list
	 */

	public boolean contains(String key) {
		if (head == null) return false;
		Node temp = head;
		while (temp != null) {
			if (temp.data.equals(key)) return true; temp = temp.next;
		}
		return false;
	}

	/**
	 * Determines the index of {@code key}. -1 is returned if the value is not
	 * present in the linked list. If {@code key} is present present more than once,
	 * the first index is returned.
	 * 
	 * @param key The value to be found
	 * @return The index of the {@code key}
	 */
	public int find(String key) {
		if (!contains(key))
			return -1;
		Node temp = head;
		int index = 0;
		while (temp != null) {
			if (temp.data.equals(key))
				return index;
			index++;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * Returns the value of the first element of the list.
	 * 
	 * @return The first element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getFirst() {
		if (head == null) throw new NoSuchElementException("List is Empty : No Such Element");
		return head.data;
	}

	/**
	 * Returns the value of the last element of the list.
	 * 
	 * @return The last element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getLast() {
		if (head == null) throw new NoSuchElementException("List is Empty : No Such Element");
		return head.findLast().data;
	}

	/**
	 * Returns the value of the {@code ith} element of the list (0 based).
	 * 
	 * @param i The target index
	 * @return The value of the ith element of the list.
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public String getAt(int i) {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Invalid Index : Index Out of Bounds");
		if (head == null) throw new NoSuchElementException("List is Empty : No Such Element");
		if (i == 0) return head.data;
		if (i == size - 1) return getLast();
		return head.get(i).data;
	}

	/**
	 * Adds {@code data} to the beginning of the list. All other values in the list
	 * remain but they are "shifted to the right."
	 * 
	 * @param data The value to add to the list
	 */
	public void insertFirst(String data) {
		insertAt(0, data); return;
	}

	/**
	 * Adds {@code data} to the end of the list. All other values in the list remain
	 * in their current positions.
	 * 
	 * @param data The value to add to the list
	 */
	public void insertLast(String data) {
		size++;
		if (head == null) {
			head = new Node(data); 
			return;
		}
		head.findLast().next = new Node(data);
	}

	/**
	 * Adds data to a specific spot in the list. The values in the list remain
	 * intact but {@code data} is inserted in the list at position {@code i}. When
	 * {@code i=0}, the result is the same as {@code insertFirst}.
	 * 
	 * @param i    The target index
	 * @param data The value to add to the list
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public void insertAt(int i, String data) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException("Invalid Index : Index Out of Bounds");
		Node dataNode = new Node(data);
		Node temp = head;
		if (i > 0 && i < size) {
			while (temp != null) {
				if (temp.data == head.get(i).data) {
					dataNode.next = temp;
					head.get(i - 1).next = dataNode;
					size++;
					return;
				}
				temp = temp.next;
			}
			return;
		} else if (i == 0) {
			dataNode.next = head;
			head = dataNode;
			size++;
			return;
		} else if (i == size)
		insertLast(data);
	}

	/**
	 * Adds {@code newData} the position immediately preceding {@code existingData}.
	 * If the {@code existingData} appears multiple times, only the first one is
	 * used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertBefore(String newData, String existingData) {
		if (head == null) return;
		if (find(existingData) == 0) insertAt(0, newData);
		else if (!contains(existingData)) throw new NoSuchElementException(existingData + " : Data Not Found : No Such Element Exception");
		else insertAt(find(existingData), newData);
	}

	/**
	 * Adds {@code newData} the position immediately after {@code existingData}. If
	 * the {@code existingData} appears multiple times, only the first one is used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertAfter(String newData, String existingData) {
		if (find(existingData) == size - 1) insertLast(newData);
		if (find(existingData) == 0) insertAt(1, newData);
		else if (!contains(existingData) || head == null) throw new NoSuchElementException(existingData + " : Data Not Found : No Such Element Exception");
		else insertAt(find(existingData) + 1, newData);
	}

	/**
	 * Removes the first element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeFirst() {
		if (head == null) throw new NoSuchElementException("Head is 'null' : No Such Element");
		return removeAt(0);
	}

	/**
	 * Removes the last element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeLast() {
		if (head == null) throw new NoSuchElementException("Head is 'null' : No Such Element");
		return removeAt(size - 1);
	}

	/**
	 * Removes the ith element of the list. The remaining elements are kept in their
	 * existing order.
	 * 
	 * @param i The target index
	 * @return The value removed from the list
	 * @throws IndexOutOfBoundsException i does not represent a legal index
	 */
	public String removeAt(int i) {
		if (head == null) return null;
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Invalid Index : Index Out of Bounds");
		String ret = head.get(i).data;
		if (i == 0) head = head.next;
		else if (i == size - 1) {
			head.findLast().data = null;
			head.get(size - 2).next = null;
		} 
		else head.get(i - 1).next = head.get(i + 1);
		size--;
		return ret;
	}

	/**
	 * Removes the first occurrence of data in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return {@code true} if and only if {@code data} was removed
	 */
	public boolean removeFirstOccurrenceOf(String data) {
		if (head == null) return false;
		if (!contains(data)) throw new NoSuchElementException("Element was not Found : No Such Element");
		removeAt(find(data));
		return true;
	}

	/**
	 * Removes the all occurrence of {@code data} in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return The number of times {@code data} was removed
	 */
	public int removeAllOccurrencesOf(String data) {
		if (head == null) return 0;
		int count = 0;
		while (contains(data) != false) {
			removeFirstOccurrenceOf(data); count++;
		}
		return count;
	}

	/**
	 * Reverses the elements in the incoming linked list.
	 */
	public void reverse() {
		String[] temp = toArray(); head = null;
		for (int i = temp.length - 1; i >= 0; i--) insertLast(temp[i]);	
		return;
	}

	/**
	 * Puts all the elements in the list to uppercase.
	 */
	public void toUpper() {
		if (head == null) return;
		Node temp = head;
		while (temp != null) {
			temp.data = temp.data.toUpperCase();
			temp = temp.next;
		}
	}

	/**
	 * Returns the comma concatenation of all strings, from left to right. NO
	 * additional characters should be added between words Example: Linked List =
	 * ["Hello", "World" ] the output should be: HelloWorld
	 * 
	 * @return Concatenation of all string in the list
	 */
	public String getConcatenation() {
		if (size == 0) return "";
		Node temp = head; String concatenation = "";
		while (temp != null) {
			concatenation += temp.data; temp = temp.next;
		}
		return concatenation;
	}

	/**
	 * Returns the alphabetically last value in the list.
	 * 
	 * @return The alphabetically last value in the list
	 * @throws NoSuchElementException list is empty
	 */
	public String getAlphabeticallyLast() {
		if (head == null) throw new NoSuchElementException("List is Empty : No Such Element Exception");
		String ret = head.data; Node temp = head; String lCase = temp.data; String lowerReturn = "";
		while (temp != null) {
			lCase = temp.data.toLowerCase(); lowerReturn = ret.toLowerCase();
			if (lowerReturn.compareTo(lCase) < 0) ret = temp.data; temp = temp.next;
		}
		return ret;
	}

	/**
	 * Returns the index where the alphabetically last value resides. If this value
	 * appears multiple times, the first occurrence is used.
	 * 
	 * @return Index value of where maximum value resides
	 * @throws NoSuchElementException list is empty
	 */
	public int indexOfAlphabeticallyLast() {
		if (head == null) throw new NoSuchElementException("List is Empty : No Such Element Exception");
		return find(getAlphabeticallyLast());
	}

	/**
	 * Determines if the two list contain elements that have exactly the same value,
	 * with the same list sizes, but with the elements perhaps in different order.
	 * 
	 * @returns true only if the two lists are permutations of one another.
	 */
	public boolean anagrams(LinkedListAlgorithms other) {
		if (size == 0 && other.size() == 0) return true;
		if (other.size != size|| other == null) return false;
		Node temp = head; LinkedListAlgorithms copy = new LinkedListAlgorithms(other);
		while (temp != null) {
			if (copy.removeFirstOccurrenceOf(temp.data) == false) return false;
			temp = temp.next;
		}
		return (copy.size() == 0);
	}
}
