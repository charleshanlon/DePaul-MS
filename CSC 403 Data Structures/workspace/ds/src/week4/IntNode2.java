package week4;

import edu.princeton.cs.algs4.StdOut;

public class IntNode2 {
	private int number;
	private IntNode2 next;
	
	public IntNode2(int number, IntNode2 next) {
		this.number = number;
		this.next = next;
	}
	
	public static void main(String[] args) {
		IntNode2 firstNode = new IntNode2(333, null);
		firstNode = new IntNode2(22, firstNode);
		firstNode = new IntNode2(1, firstNode);
		// Print out the value of the third node
		System.out.println(firstNode.next.next.number);

		
		// Change the value of the second node from 22 to 20
		firstNode.next.number = 20;
		
		
		// Insert a node with value 10 between the 1 and the 20 (between 1st and 2nd nodes)
		firstNode.next =  new IntNode2(10, firstNode.next);
	
		
				
		// Print out all the numbers in the list
		System.out.println(firstNode.number);
		System.out.println(firstNode.next.number);
		System.out.println(firstNode.next.next.number);
		System.out.println(firstNode.next.next.next.number);
		
		System.out.println("**********************************");

//		Printing out all the numbers in a normal array loop		
//		for(int i = 0; i < a.length; i++)
//			System.out.println(a[i]);
		
// 		Printing numbers in the list using a for loop w/ linked list syntax
		for(IntNode2 curr = firstNode; curr != null ;curr = curr.next) {
			System.out.println(curr.number);
		}
		
	}
}
