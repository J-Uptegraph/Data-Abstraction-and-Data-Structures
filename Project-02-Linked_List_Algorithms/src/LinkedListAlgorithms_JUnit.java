/**
 * @author Johnathan Uptegraph
 * 
 * @apiNote Project-02 Linked_Algorithms_JUnit
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LinkedListAlgorithms_JUnit {

	LinkedListAlgorithms[] list;
	static final int NUM_LINKEDLIST_ALGORITHM_TESTS = 5;

	public LinkedListAlgorithms_JUnit() {
		String[] data;
		list = new LinkedListAlgorithms [NUM_LINKEDLIST_ALGORITHM_TESTS];
		list[0] = new LinkedListAlgorithms();
		
		String[] items = {"One","Two","Three","Four","Five"};
		list[1] = new LinkedListAlgorithms(items);
		
		String[] items2 = {"1", "2", "3", "4", "5", "6"};
		list[2] = new LinkedListAlgorithms(items2);
		
		String[] items3 = {"2", "1", "3", "5", "4", "6"};
		list[3] = new LinkedListAlgorithms(items3);
		
		String[] items4 = {"THIS", "THAT", "PADY", "WACK", "NOW", "GIVE", "UP", "I", "MADE", "IT"};
		list[4] = new LinkedListAlgorithms(items4);
	
	}
	
	@Test
	public void contructorTest() {
		assertTrue(list[0].size == 0);
		assertFalse(list[0].size == list[1].size);
		assertTrue(list[1].size == 5);
	}
	
	@Test
	public void toStringTest() {
		assertTrue(list[0].toString() == "[]"); 					// Tests Empty LinkedList
		assertFalse(list[1].toString() == "[]"); 					// Tests Non-Empty LinkedList
		assertEquals(list[0].toString(), list[0].toString());	    // Tests Equals Empty LinkedList
		assertEquals(list[1].toString(), list[1].toString());	    // Tests Equals Non-Empty LinkedList
		assertFalse(list[0].toString() == (list[1].toString())); 	// Tests Not Equals Empty to Non-Empty LinkedList
	}
	
	@Test
	public void toArrayTest() {
		assertEquals(Arrays.toString(list[0].toArray()), "[]"); 
		assertEquals(Arrays.toString(list[1].toArray()), "[One, Two, Three, Four, Five]");
		assertEquals(Arrays.toString(list[2].toArray()), "[1, 2, 3, 4, 5, 6]");
	}
	
	@Test
	public void sizeTest() {
		assertEquals(list[0].size(), 0); 
		assertEquals(list[1].size(), 5);
		assertEquals(list[2].size(), 6);
		assertEquals(list[1].toString(), list[1].toString());
		assertFalse(list[0].toString() == list[1].toString());
	}
	
	@Test
	public void equalsLinkedList() {
		String[] items3 = {};
		String[] items4 = {"1, 2, 3, 4, 5, 6"};
		String[] items5 = {"[1, 2, 3, 4, 5, 6]"};
		LinkedListAlgorithms testLinkedList1 = new LinkedListAlgorithms(items3);		
		LinkedListAlgorithms testLinkedList2 = new LinkedListAlgorithms(items4);		
		LinkedListAlgorithms testLinkedList3 = new LinkedListAlgorithms(items5); 		
		assertTrue(testLinkedList1.equalsLinkedList(testLinkedList1)); 					// Tests testLinkedList1 equals testLinkedList1
		assertTrue(testLinkedList2.equalsLinkedList(testLinkedList2)); 					// Tests testLinkedList2 equals testLinkedList2
		assertFalse(testLinkedList1.equalsLinkedList(testLinkedList2)); 				// Tests testLinkedList1 equals testLinkedList3
		assertTrue(testLinkedList1.equalsLinkedList(list[0]));							// Tests testLinkedList1 equals list[0]
		assertFalse(testLinkedList2.equalsLinkedList(list[2]));							// Tests testLinkedList2 equals list[2]
		assertFalse(testLinkedList3.equalsLinkedList(list[2]));							// Tests testLinkedList3 equals list[2]
	}
	
	@Test
	public void containsTest() {
		assertFalse(list[0].contains("Empty"));						 // Tests if the empty LinkedList contains the string "empty"
		assertTrue(list[1].contains("One"));						 // Tests if the list[1] contains the string "One"
		assertFalse(list[2].contains("One")); 						 // Tests if the list[2] contains the string "One"
		assertFalse(list[1].contains("1")); 						 // Tests if the list[1] contains the string "1"
		assertTrue(list[2].contains("1"));							 // Tests if the list[2] contains the string "1"
	}
	
	@Test
	public void findTest() {
		assertTrue(list[0].find("nothing") == -1);
		assertFalse(list[1].find("nothing") == 0);
		assertTrue(list[2].find("One") == -1);
		assertTrue(list[2].find("0") == -1);
	}
	
	// ___________________________________________________________________________________
	
	@Test
	public void getFirstTest() {
		assertFalse(list[1].getFirst() == "[One");
		assertFalse(list[1].getFirst() == "[One");				
		assertFalse(list[1].getFirst() == "1");					
		assertTrue(list[2].getFirst() == "1");					
	}
	
	@Test
	public void getLastTest() {
		assertFalse(list[1].getLast() == "1");					
		assertTrue(list[1].getLast() == "Five");
		assertFalse(list[2].getLast() == "One");
	}
	
	@Test 
	public void getAtTest() {
		assertTrue(list[1].getAt(1) == "Two");
		assertTrue(list[1].getAt(1) == "Two");
		assertFalse(list[1].getAt(0)== "1");
		assertTrue(list[1].getAt(0) == "One");
		assertTrue(list[1].getAt(2) == "Three");
		assertTrue(list[2].getAt(5) == "6");
	}
	
	@Test 
	public void insertFirstTest() {
		list[0].insertFirst("1");
		list[1].insertFirst("1");
		assertTrue(list[0].getFirst() == "1");
		assertTrue(list[1].getFirst() == "1");
		assertTrue(list[1].size() == 6);
		assertTrue(list[1].getAt(1) == "One");
	}
	
	@Test
	public void insertLastTest() {
		list[0].insertLast("1");
		list[1].insertLast("1");
		assertTrue(list[0].getLast() == "1");
		assertTrue(list[1].getLast() == "1");
		assertTrue(list[1].size() == 6);
		assertTrue(list[1].getAt(5) == "1");
	}
	
	@Test
	public void insertAtTest() {
		list[0].insertAt(0, "INSERT");
		list[1].insertAt(0, "INSERT");
		assertTrue(list[0].getFirst() == "INSERT");
		assertTrue(list[1].getFirst() == "INSERT");
		list[0].removeFirst();
		list[1].removeFirst();

		list[0].insertAt(list[0].size(), "INSERT");	
		list[1].insertAt(list[1].size(), "INSERT");
		assertTrue(list[0].getLast() == "INSERT");
		assertTrue(list[1].getLast() == "INSERT");
		list[0].removeLast();
		list[1].removeLast();
		
		list[2].insertAt(2, "INSERT");
		list[1].insertAt(5, "INSERT");
		assertTrue(list[2].getAt(2) == "INSERT");
		assertTrue(list[1].getAt(5) == "INSERT");
	}
	
	@Test
	public void insertBeforeTest() {
		list[1].insertBefore("Two", "One");
		assertTrue(list[1].getFirst() == "Two");
		list[1].removeAllOccurrencesOf("Two");
		
		list[2].insertBefore("2.25553", "2");
		assertTrue(list[2].getAt(1) == "2.25553");
		list[2].removeAllOccurrencesOf("2.255553");
		
		list[2].insertBefore("7", "6");
		assertTrue(list[2].getAt(6) == "7");
		list[2].removeAllOccurrencesOf("7");
	}
	
	@Test
	public void insertAfterTest() {
		list[1].insertAfter("Two", "One");
		assertTrue(list[1].getAt(1) == "Two");
		list[1].removeAllOccurrencesOf("Two");
		
		list[2].insertAfter("6", "2");
		assertTrue(list[2].getAt(list[2].find("2")) == "2");
		list[2].removeAllOccurrencesOf("2");
		
		list[2].insertAfter("4", "6");
		assertTrue(list[2].getAt(list[2].find("6")) == "6");
		list[2].removeAllOccurrencesOf("6");
		
		list[2].insertAfter("2", "4");
		assertTrue(list[2].getAt(list[2].find("4")) == "4");
		list[2].removeAllOccurrencesOf("4");
	}
	
	@Test
	public void removeFirstTest() {
		list[1].removeFirst(); assertTrue(list[1].getFirst() == "Two");
		list[2].removeFirst(); assertTrue(list[2].getFirst() == "2");
	}
	
	@Test
	public void removeLastTest() {
		list[1].removeLast(); assertTrue(list[1].getLast() == "Four");
		list[2].removeLast(); assertTrue(list[2].getLast() == "5");
	}

	@Test
	public void removeAtTest() {
		list[1].removeAt(0); assertTrue(list[1].getFirst() == "Two");
		list[1].insertFirst("One");
		list[1].removeAt(list[1].size-1); assertTrue(list[1].getLast() == "Four");
		list[1].insertLast("Five");
		list[2].removeAt(0); assertTrue(list[2].getFirst() == "2");
		list[2].insertFirst("1");
		list[2].removeAt(list[2].size-1); assertTrue(list[2].getLast() == "5");
		list[2].insertLast("6");
		list[1].removeAt(3); assertTrue(list[1].getAt(3)== "Five");
		list[2].removeAt(3); assertTrue(list[2].getAt(3)== "5");
	}
	
	@Test
	public void removeFirstOccurenceOfTest() {
		list[1].insertFirst("BaseCase");
		list[1].removeFirstOccurrenceOf("BaseCase"); assertTrue(list[1].getFirst() == "One");
		list[1].insertLast("BaseCase");
		list[1].removeFirstOccurrenceOf("BaseCase"); assertTrue(list[1].getLast() == "Five");
		list[1].insertAfter("BaseCase","Two");
		list[1].removeFirstOccurrenceOf("BaseCase"); assertTrue(list[1].getAt(2) == "Three");
		list[1].insertAfter ("BaseCase","Three");
		list[1].removeFirstOccurrenceOf("BaseCase"); assertTrue(list[1].getAt(3) == "Four");
	}
	
	@Test
	public void removeAllOccurencesOfTest() {
		list[1].insertFirst("BaseCase");
		list[1].insertLast("BaseCase");
		list[1].insertAfter("BaseCase", list[1].getFirst());
		list[1].insertAt(6, "BaseCase");
		list[1].insertLast("BaseCase");
		list[1].insertBefore("BaseCase","Two");
		list[1].insertFirst("BaseCase");
		list[1].removeAllOccurrencesOf("BaseCase");
		assertTrue(list[1].getLast() == "Five");
		assertTrue(list[1].getAt(3) == "Four");
		assertTrue(list[1].getFirst() == "One");
		list[1].insertFirst("BaseCase");list[1].insertLast("BaseCase");list[1].insertAt(3,"BaseCase");
		assertEquals(list[1].removeAllOccurrencesOf("BaseCase"),3);
	}
	
	@Test
	public void reverseTest() {
		list[1].reverse();
		list[2].reverse();
		assertEquals(list[1].getFirst() , "Five");
		assertEquals(list[1].getAt(1) , "Four");
		assertEquals(list[1].getAt(2) , "Three");
		assertEquals(list[1].getAt(3) , "Two");
		assertEquals(list[1].getLast() , "One");
	
		assertEquals(list[2].getLast() , "1");
		assertEquals(list[2].getAt(4) , "2");
		assertEquals(list[2].getAt(3) , "3");
		assertEquals(list[2].getAt(2) , "4");
		assertEquals(list[2].getAt(1) , "5");
		assertEquals(list[2].getFirst() , "6");
	}
	
	@Test
	public void testToUpperCase() {
		list[0].toUpper();
		list[1].toUpper();
		list[2].toUpper();

		assertEquals(list[1].getFirst(), "ONE");
		assertEquals(list[1].getAt(1) , "TWO");
		assertEquals(list[1].getAt(2) , "THREE");
		assertEquals(list[1].getAt(3) , "FOUR");
		assertEquals(list[1].getLast() , "FIVE");
	
		assertEquals(list[2].getLast() , "6");
		assertEquals(list[2].getAt(4) , "5");
		assertEquals(list[2].getAt(3) , "4");
		assertEquals(list[2].getAt(2) , "3");
		assertEquals(list[2].getAt(1) , "2");
		assertEquals(list[2].getFirst(), "1");
	}
	
	@Test
	public void getConcatenationTest() {
		assertEquals(list[0].getConcatenation(), "");
		assertEquals(list[1].getConcatenation(), "OneTwoThreeFourFive");
		assertEquals(list[2].getConcatenation(), "123456");
		list[1].reverse();
		list[2].reverse();
		assertEquals(list[1].getConcatenation(), "FiveFourThreeTwoOne");
		assertEquals(list[2].getConcatenation(), "654321");
	}
	
	@Test
	public void getAlphabeticallyLastTest() {
		assertEquals(list[1].getAlphabeticallyLast(), "Two");
		list[1].insertFirst("Zero");
		assertEquals(list[1].getAlphabeticallyLast(), "Zero");
		list[1].reverse();
		assertEquals(list[1].getAlphabeticallyLast(), "Zero");
		list[1].insertLast("ZZZZ");
		assertEquals(list[1].getAlphabeticallyLast(), "ZZZZ");
	}
	
	@Test
	public void indexofAlphabeticallyLastTest() {
		assertEquals(list[1].indexOfAlphabeticallyLast(), 1);
		list[1].insertFirst("Zero");
		assertEquals(list[1].indexOfAlphabeticallyLast(), 0);
		list[1].insertLast("ZX");
		assertEquals(list[1].indexOfAlphabeticallyLast(), 6);
		list[1].reverse();
		assertEquals(list[1].indexOfAlphabeticallyLast(), 0);
		list[1].insertAt(4,"ZZ");
		assertEquals(list[1].indexOfAlphabeticallyLast(), 4);
	}
	
	@Test
	public void anagramsTest() {
		assertTrue(list[1].anagrams(list[1]));
		assertTrue(list[2].anagrams(list[2]));
		assertTrue(list[2].anagrams(list[3]));
		assertFalse(list[3].anagrams(list[4]));
		assertFalse(list[1].anagrams(list[3]));
		assertFalse(list[3].anagrams(list[4]));
	}
	
	@Test
	public void copyTest() {
		assertEquals(list[0].toString() , new LinkedListAlgorithms(list[0]).toString());
		assertEquals(list[1].toString() , new LinkedListAlgorithms(list[1]).toString());
		assertEquals(list[2].toString() , new LinkedListAlgorithms(list[2]).toString());
		assertEquals(list[3].toString() , new LinkedListAlgorithms(list[3]).toString());
	}
}