package week4;

import edu.princeton.cs.algs4.StdOut;

public class IntNode1 {
	private int number;
	private IntNode1 next;
	
	public IntNode1(int number, IntNode1 next) {
		this.number = number;
		this.next = next;
	}
	
	public static void main(String[] args) {
		IntNode1 n1 = new IntNode1(1, null);
		IntNode1 n22 = new IntNode1(22, null);
		IntNode1 n333 = new IntNode1(333, null);
		
		n1.next = n22;
		n22.next = n333;
		
		// Print out the number in n1
		StdOut.println(n1.number);
		
		// Print out the number in the node after n1
		StdOut.println(n1.next.number);
		
		// Print out the number in the node after n22
		StdOut.println(n22.next.number);
		
		// Print out the number 2 nodes after n1
		StdOut.println(n1.next.next.number);
	}
}
