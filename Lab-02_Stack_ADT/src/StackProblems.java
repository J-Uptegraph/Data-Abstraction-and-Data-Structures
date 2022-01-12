import java.util.Arrays;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

public class StackProblems {

	public static void main(String[] args) {

		// Do initial testing here.
		// For example, here is a basic test of the sum method:
		ArrayStack<Integer> stk;
		ArrayStack<Integer> stk2 = new ArrayStack<>();
		stk = new ArrayStack<>();
		stk.push(4);
		stk.push(1);
		stk.push(2);
		stk.push(2);
		stk.push(7);
		stk.push(2);
		stk.push(8);
		stk.push(8);
		stk.push(8);
		stk.push(4);
		for (int i = 0; i < 10; i++) {
			stk2.push(i);
		}
		//System.out.println("46?= " + sum(stk));
		//System.out.print("28?" + sumSkipDuplicates(stk));
		pushUnder(stk, 5);
		System.out.println(copyStack(stk));	
		reverseStack(stk);
		System.out.println("Reversed" + stk);
	}

	/*
	 * Computes the sum of all the numbers in the ArrayStack. 
	 * It's okay to destroy the ArrayStack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		if (data.isEmpty()) return 0;
		int sum = data.pop();
		while (!data.isEmpty())
			sum += data.pop();
		return sum;
	}

	/*
	 * Puts an integer under the top item in an ArrayStack. 
	 * If the ArrayStack is empty, just put the item on the top. 
	 * For example: if 		stk starting at the top is: 7, 8, 5, 11, 
	 * 				then 	pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11
	 * 
	 * For example: if 		stk is empty,  
	 * 				then 	pushUnder(stk, 20) would result in: 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		if(data.isEmpty()) {
			data.push(value);
		}
		else {
			// Take it off the top save to temp
			int top = data.pop();
			// push value
			data.push(value);
			// push number back on top
			data.push(top);
		}
	}
	
	
	/*
	 * Computes the sum of all the numbers in the ArrayStack. However, if two or
	 * more numbers in a row are equal, only add one of them. So, for example, if the
	 * ArrayStack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		if (data.isEmpty()) return 0;
		
		int sum, last, top;
		last = sum = data.pop();
		while (!data.isEmpty()) {
			top = data.pop();
			if (last != top) {
				sum += top;
				last = top;
			}
			// ONE POTENTIAL SOLUTION but it is slower
			// sum += (last == top) ? 0 : top;
			// last = top;
		}
		return sum;
	}

	/*
	 * Puts all of the characters of a string into an ArrayStack, with the first
	 * character of the string at the bottom of the ArrayStack and the last character
	 * of the string at the top of the ArrayStack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> ret = new ArrayStack<Character>();
		for (int i = 0; i < s.length(); i++) {
			ret.push(s.charAt(i));
		}
		return ret;
	}

	/*
	 * Returns an exact copy of the given ArrayStack.  At the end of this method
	 * the original stack should be the same as when it started, and a new copy
	 * of that ArrayStack should be returned.  YOU MAY USE ADDITIONAL ArrayStacks AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> copy = new ArrayStack<Integer>();
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		while(!s.isEmpty()) {
			copy.push(s.pop());
		}
		while (!copy.isEmpty()) {
			int num = copy.pop();
			temp.push(num);
			s.push(num);
		}
		return temp;
	}

	/*
	 * Reverses a given ArrayStack, so that the top of the ArrayStack becomes the bottom
	 * and the bottom becomes the top. YOU MAY USE ADDITIONAL ArrayStack AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> copy = new ArrayStack<Integer>();
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		while (!s.isEmpty()) {
			copy.push(s.pop());
		}
			while (!copy.isEmpty()) {
				temp.push(copy.pop());
		}
			while (!temp.isEmpty()) {
				s.push(temp.pop());
		}
	}
	
	
	/*
	 * A palindrome reads the same forward and backward. Use an ArrayStack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and an ArrayStack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		
        ArrayStack<Character> palindrome = stringToStack(s);
        for (int i = 0; i < s.length(); i++) {
            if (palindrome.pop() != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
	
	
}

