package week2;

import edu.princeton.cs.algs4.StdOut;

public class UseCounter {
	
	
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		Counter[] A = {c1, c2};
		A[0].clickButton();
		Counter[] B = A;
		B[0] = c3;
		System.out.println("A[0] is " + A[0].getCount());
		System.out.println("B[0] is " + B[0].getCount());
	}
	
}
