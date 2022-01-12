import java.util.ArrayList;
import java.util.Arrays;

/*
	Project-01 - Polynomial ADT
	Name:	

*/
public class Tester {

	public static void main(String[] args) {

		ArrayList<Double> coeficients;
		ArrayList<Integer> exponents;
		Polynomial poly1, poly2;
		

//		coeficients = new ArrayList<Double>(Arrays.asList(-2.0, -3.0, -4.0));
//		exponents = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
//		poly1 = new Polynomial(coeficients, exponents);
//
//		coeficients = new ArrayList<Double>(Arrays.asList(-4.0, -5.0, -6.0));
//		exponents = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
//		poly2 = new Polynomial(coeficients, exponents);
//		print(poly1, poly2, 3);
//		
//		System.exit(0);
		
		System.out.println();
		//======================================================================= Example 1
		// Poly1
		coeficients = new ArrayList<Double>(Arrays.asList(-3.0, -2.0, -5.0));
		exponents = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		poly1 = new Polynomial(coeficients,exponents);

		// Poly2
		coeficients = new ArrayList<Double>(Arrays.asList(-4.0, -5.0, -6.0));
		exponents = new ArrayList<Integer>(Arrays.asList(5, 3, 0));
		poly2 = new Polynomial(coeficients,exponents);
	
		
		print(poly1, poly2, 3); //	[3.0x^4 + 7.0x^2 + 5.0] == 311.0
								//	[3.0x^4 + 5.0] == 221.0
								//	[15.0x^6 + 10.0x^4 + 25.0x^2] == 11,970.0
		
		System.exit(0);
		
		//======================================================================= Example 2
		// Poly1
		coeficients = new ArrayList<Double>(Arrays.asList(5.0, 3.0, 4.0, 5.0));
		exponents = new ArrayList<Integer>(Arrays.asList(5, 2, 3, 1));
		poly1 = new Polynomial(coeficients,exponents);

		// Poly2
		coeficients = new ArrayList<Double>(Arrays.asList(2.0, 3.0));
		exponents = new ArrayList<Integer>(Arrays.asList(2, 2));
		poly2 = new Polynomial(coeficients,exponents);
		
		print(poly1, poly2, 3);	// [5.0x^5 + 4.0x^3 + 8.0x^2 + 5.0x] == 1,410.0
								// [5.0x^5 + 4.0x^3 + 5.0x] == 1,320.0
								// [25.0x^7 + 20.0x^5 + 15.0x^4 + 25.0x^3] == 61,425.0

	}
	
	private static void print(Polynomial poly1, Polynomial poly2, double x) {
		System.out.println("x = " + x);
		System.out.printf("(%s) + (%s) = [%s] == %,.1f\n", poly1, poly2, poly1.add(poly2), poly1.add(poly2).evaluate(x));		
		System.out.printf("(%s) - (%s) = [%s] == %,.1f\n", poly1, poly2, poly1.subtract(poly2), poly1.subtract(poly2).evaluate(x));	
		System.out.printf("(%s) * (%s) = [%s] == %,.1f\n", poly1, poly2, poly1.multiply(poly2), poly1.multiply(poly2).evaluate(x));	
		System.out.println("================================================================\n");
		
	}


}
