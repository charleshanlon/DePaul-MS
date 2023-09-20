package week3;

import edu.princeton.cs.algs4.StdOut;

public class Example1 {
	public static void main(String[] args) {
		int i = 4;
		StdOut.println("BEFORE");
		StdOut.printf("i = %d\n",  i);
		f(i);
		StdOut.println("\nAFTER");
		StdOut.printf("i = %d\n",  i);
	}
	
	public static void f(int i) {
		i = 10;
	}
}
