package hw5;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions. Your code needs to run in
 * constant time. It is OK if your testing code has loops (like in
 * checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node first; 	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node last; 		// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	private class Node {

		public T item; 		// The data stored at this node.
		public Node next; 	// The node to the right (or null if there is no
							// node to the right)
		public Node prev; 	// The node to the lett (or null if there is no
							// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		N = 0;
		first = null;
		last = first;
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns the number of items currenlty in this <code>Deque</code>.
	 * 
	 * @return the number of items currenlty in this <code>Deque</code>
	 */
	public int size() {
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushFront(T item) {
		
		// Temporary node to hold the now second node information
        Node temp = first;
        
        //Blank node to add to start
        first = new Node();
        
        first.item = item;
        first.next = temp;
        first.prev = null;
        
        if (temp != null)
        	temp.prev = first;
        
        if (isEmpty())
        	last = first;
        
		N++;
	}

	/**
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item the item to be inserted
	 */
	public void pushBack(T item) {
		
		// Temporary node to hold the now second to last node information
		
		//Blank node to add to end
		Node temp = last;
		
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = temp;

		if (temp == null)
			first = last;
		else 
			temp.next = last;
		
		N++;
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popFront() {
		if (first == null)
			throw new NoSuchElementException("DEQUE IS EMPTY");
		
		T removed = first.item;
	
		first = first.next;
		if (first != null)
			first.prev = null;
		
		if (first == null)
			last = null;
		
		N--;
		
		return removed;
	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		if (last == null)
			throw new NoSuchElementException("DEQUE IS EMPTY");
		
		
		T removed = last.item;
		
		last = last.prev;
		
		if (last != null)
			last.next = null;
		
		if (last == null)
			first = null;
		
		N--;
		
		return removed;
	}
}
