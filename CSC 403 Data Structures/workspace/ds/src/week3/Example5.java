package week3;

import edu.princeton.cs.algs4.StdOut;

public class Example5 {
	public static void main(String[] args) {
		int[] I = {4, 40};
		int[] J = {7, 70};
		StdOut.println("BEFORE");
		StdOut.printf("I[0] = %d\n",  I[0]);
		f(I, J);
		StdOut.println("\nAFTER");
		StdOut.printf("I[0] = %d\n",  I[0]);
	}
	
	public static void f(int[] I, int[] J) {
		I = J;
	}
}
