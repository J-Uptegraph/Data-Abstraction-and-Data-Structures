import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {

	private ArrayList<Node> terms;

	//============================= Node Inner Class (represents a single term)
	private class Node implements Comparable<Node> {
		double coefficient;
		int exponent;

		public Node(double c, int e) {
			coefficient = c;
			exponent = e;
		} 

		// Changed the compareTo to account for ordering terms with 0 for exponent
		@Override
		public int compareTo( Node node ) {
			if(node.exponent == 0) {
				// Try negative (int)(-coefficient) Line 24 return statement
				if(exponent != 0)	return -1000;
				else				return (int)(node.coefficient-coefficient);
			}
			return node.exponent - exponent;	
		}

		// 2 helper methods I added for toString and comparing terms
		@Override
		public String toString() {
			if(Math.abs(coefficient) < 0.0000000001) return "";

			String ret = ((coefficient < 0 ? " - " : " + ") + Math.abs(coefficient));
			if(exponent == 0) 	return ret;
			return ret + "x" + (exponent != 1 ? "^" + exponent : "");  // accounts for -exponents
		}

		public boolean equals(Node n) {
			return compareTo(n) == 0;
		}
	}

	//==================================================================== Constructors
	// Constructors
		public Polynomial() { // default constructor
			terms = new ArrayList<Node>();
		}

		public Polynomial(Polynomial poly) { // copy constructor
			terms = new ArrayList<Node>();
			ArrayList<Node> polyNodes = poly.terms;
			for (Node n : polyNodes)
				terms.add(new Node(n.coefficient, n.exponent));
		}

		public Polynomial(ArrayList<Double> coef, ArrayList<Integer> expon) { // workhorse
			terms = new ArrayList<Node>();
			if (coef.size() != expon.size())
				throw new InvalidParameterException("Coef and Expon must match in size");

			for (int i = 0; i < coef.size(); i++) {
				terms.add(new Node(coef.get(i), expon.get(i)));
			}

			Collections.sort(terms);
		}


	//==================================================================== Methods
	// check all terms for equality
	public boolean equals(Polynomial poly) {
		return poly.toString().equals(toString());	
	}

	//====================================================== Add
	public Polynomial add(Polynomial poly) {
		ArrayList<Integer> exponents = new ArrayList<Integer>();
		ArrayList<Double> coefficients = new ArrayList<Double>();

		Node node1, node2;

		int i = 0, j = 0;
		boolean done = false;

		while (!done) {
			if (i == terms.size() && j == terms.size()) {
				done = true;
			} else {
				if (i == poly.terms.size()) {
					while (j < poly.terms.size()) {
						node2 = poly.terms.get(j);
						coefficients.add(node2.coefficient);
						exponents.add(node2.exponent);
						j++;
					}
					done = true;
				} else if(j == poly.terms.size()) {
					while (i < terms.size()) {
						node1 = terms.get(i);
						coefficients.add(node1.coefficient);
						exponents.add(node1.exponent);
						i++;
					}
					done = true;
				} else {
					node1 = this.terms.get(i);
					node2 = poly.terms.get(j);
					// What do we do if two terms have the same exponent?
					if(node1.exponent == node2.exponent) {
						// We add the coefficients of both terms and then keep "one version" of the exponent.
						coefficients.add(node1.coefficient + node2.coefficient);
						exponents.add(node1.exponent);
						i++; j++;
						// i and j serve as our increment terms... if the exponents are the same
						// we add add their coefficients together and store that value
						// in our array list of coefficients.
						// Similarly, since the two exponents are equal...
						// we only need to store one copy of the exponent. So we store node1.exponent.

					} 
					// What do we do if the first  of two terms have a larger exponent than the other?
					else if (node1.exponent > node2.exponent) {
						// If we wanted to keep the problem in order we would write down the next biggest
						// exponent. We would also want to ensure that the component stayed consistent
						// therefore we would write down the exponent.
						coefficients.add(node1.coefficient);
						exponents.add(node1.exponent);
						i++;
					} 
					// What do we do if the second of two terms have a larger exponent than the other?
					else {
						// The opposite of the line above.
						coefficients.add(node2.coefficient);
						exponents.add(node2.exponent);
						j++;
					}
				}

			}

		}

		return new Polynomial(coefficients, exponents);	
	}

	//		
	//		ArrayList<Integer> exponents = new ArrayList<Integer>();
	//		Polynomial sum = new Polynomial(poly);
	//		for(int i = 0; i < this.terms.size(); i++) {
	//			sum.terms.add(this.terms.get(i));
	//		}
	//		return sum;
	//	}
	
	private void addTerm(Node n) {
		Node node = get(n.exponent);
		if (node == null)
			terms.add(new Node(n.coefficient, n.exponent));
		else
			node.coefficient += n.coefficient;
	}
	
	private Node get(int n) {
		for(Node node : terms) 
			if(node.exponent == n) return node;
			return null;
		
	}
	

	
	//====================================================== Subtract
	public Polynomial subtract(Polynomial poly) {

		// Below code is wrong. Keeping it since it's 85% there.
//		ArrayList<Integer> exponents = new ArrayList<Integer>();
//		ArrayList<Double> coefficients = new ArrayList<Double>();
//
//		Node node1, node2;
//
//		int i = 0, j = 0;
//		boolean done = false;
//
//		while (!done) {
//			if (i == terms.size() && j == terms.size()) {
//				done = true;
//			} else {
//				if (i == poly.terms.size()) {
//					while (j < poly.terms.size()) {
//						node2 = poly.terms.get(j);
//						coefficients.add(node2.coefficient);
//						exponents.add(node2.exponent);
//						j++;
//					}
//					done = true;
//				} else if(j == poly.terms.size()) {
//					while (i < terms.size()) {
//						node1 = terms.get(i);
//						coefficients.add(node1.coefficient);
//						exponents.add(node1.exponent);
//						i++;
//					}
//					done = true;
//				} else {
//					node1 = this.terms.get(i);
//					node2 = poly.terms.get(j);
//					// What do we do if two terms have the same exponent?
//					if(node1.exponent == node2.exponent) {
//						// We add the coefficients of both terms and then keep "one version" of the exponent.
//						coefficients.add(node1.coefficient + node2.coefficient);
//						exponents.add(node1.exponent);
//						i++; j++;
//						// i and j serve as our increment terms... if the exponents are the same
//						// we add add their coefficients together and store that value
//						// in our array list of coefficients.
//						// Similarly, since the two exponents are equal...
//						// we only need to store one copy of the exponent. So we store node1.exponent.
//
//					}
//					// What do we do if the first  of two terms have a larger exponent than the other?
//					else if (node1.exponent > node2.exponent) {
//						// If we wanted to keep the problem in order we would write down the next biggest
//						// exponent. We would also want to ensure that the component stayed consistent
//						// therefore we would write down the exponent.
//						coefficients.add(node1.coefficient);
//						exponents.add(node1.exponent);
//						i++;
//					}
//					// What do we do if the second of two terms have a larger exponent than the other?
//					else {
//						// The opposite of the line above.
//						coefficients.add(node2.coefficient);
//						exponents.add(node2.exponent);
//						j++;
//					}
//				}
//
//			}
//
//		}
//		return new Polynomial(coefficients, exponents);


//		Polynomial negationPoly = new Polynomial(poly);
//
//		for (int i = 0; i < negationPoly.terms.size(); i++) {
//			negationPoly.terms.get(i).coefficient *= -1;
//		}
//
//		return this.add(negationPoly);

		Polynomial ans = new Polynomial(this);
		for (Node n : poly.terms) {
			Node match = ans.get(n.exponent);
			if (match == null) {
				ans.addTerm(new Node(-n.coefficient,n.exponent));
			} else {
				match.coefficient -= n.coefficient;
			}
		}
		return ans;
	}
	
	

	//====================================================== Multiply
	public Polynomial multiply(Polynomial poly) {
        Polynomial ret = new Polynomial();
        for (Node p : terms) {
            for (Node j : poly.terms) {
                ret.add(new Node(p.coefficient * j.coefficient, p.exponent + j.exponent));
            }
        }
        return ret;
    }
	
	public void add(Node term) {
		terms.add(new Node(term.coefficient, term.exponent));
		Collections.sort(terms);
	}

	
	//====================================================== Evaluate
	// Evaluates the polynomial with the parameter value for the variable
	public double evaluate(double value) { 
		double ret = 0.0;
		
		// Takes "double value" and plugs it into the equation.
		// Start with this : "5^3 + 7^2 - 6^1"
		// End with this : "5x^3 + 7x^2 - 6x^1"
		
		for (Node n : terms)
			ret += n.coefficient * Math.pow(value, n.exponent);
			return ret;
		}

	public Polynomial derivative() { 

		// finds the derivative of host polynomial: 
		// (d/dx)x^n => nx^d-1
		//	Formula: (expo * coef) ^ (expo-1)
		
		ArrayList<Double> coefs = new ArrayList<Double>();
		ArrayList<Integer> expons = new ArrayList<Integer>();
		
		for(Node n : terms ) {
			// Attempt to address what happens with a negative exponent
			// Attempt to address what happens when the exponent is 0
			if (n.exponent > 0) {
				coefs.add(n.coefficient * n.exponent);
				expons.add(n.exponent-1);
			}
		}
		return new Polynomial(coefs, expons);
	}   
	
	//====================================================== toString
	public String toString() {
		Collections.sort(terms);
		StringBuilder ret = new StringBuilder();
		for(Node n : terms)			
			ret.append( n.toString());
		if(ret.length() == 0) return "0.0";
		ret.deleteCharAt(2);
		if(ret.charAt(1) == '+') 	ret.deleteCharAt(1);
		return ret.toString().trim();	
	}

}
