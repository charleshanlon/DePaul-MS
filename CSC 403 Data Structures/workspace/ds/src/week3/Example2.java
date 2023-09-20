package week3;

import edu.princeton.cs.algs4.StdOut;

public class Example2 {
	public static void main(String[] args) {
		Counter i = new Counter();
		i.clickButton();
		StdOut.println("BEFORE");
		StdOut.printf("i.getCount() = %d\n",  i.getCount());
		f(i);
		StdOut.println("\nAFTER");
		StdOut.printf("i.getCount() = %d\n",  i.getCount());
	}
	
	public static void f(Counter i) {
		i = new Counter();
	}
}
