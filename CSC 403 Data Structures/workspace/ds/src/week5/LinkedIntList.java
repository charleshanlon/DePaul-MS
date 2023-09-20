package week5;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class LinkedIntList {

	// helper linked list node class
	private class Node {
		private int item;
		private Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node first; // first node of the list

	/**
	 * Constructs an empty list.
	 */
	public LinkedIntList() {
		first = null;
	}

	/**
	 * Constructs a list containing the elements of the specified array, in the
	 * order they appear in the array.
	 *
	 * @param data the array whose elements are to be placed into this list
	 * @throws NullPointerException if the specified array is null
	 */
	public LinkedIntList(int[] data) {
		Node lastNodeSoFar = new Node(data[0], null);
		first = lastNodeSoFar;
		for (int i = 1; i < data.length; i++) {
			Node temp = new Node(data[i], null);
			lastNodeSoFar.next = temp;
			lastNodeSoFar = temp;
		}
	}

	/**
	 * Constructs a string representing the list. The ints in the list appear in a
	 * comma separated list contained inside square brackets.
	 * 
	 * @return a string represeting the list.
	 */
	public String toString() {
		String answer = "[" + first.item;
		for (Node current = first.next; current != null; current = current.next) {
			answer += ", " + current.item;
		}
		return answer + "]";
	}

	/**
	 * Prints the list to StdOut as a comma separted list inside of square brackets
	 */
	public void printList() {
		for (Node current = first; current != null; current = current.next)
			System.out.println(current.item);
	}

	/**
	 * Returns the first int in this list.
	 *
	 * @return the first int in this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int getFirst() {
		return this.first.item;
	}

	/**
	 * Removes and returns the first int from this list.
	 *
	 * @return the first int from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int removeFirst() {
		int temp = first.item;
		first = first.next;
		return temp;
	}

	/**
	 * Inserts the specified int at the beginning of this list. Shifts all ints
	 * already in the list to the right (adds one to their indices).
	 * 
	 * @param i the int to add
	 */
	public void addFirst(int i) {
		Node temp = new Node(i, first);
		first = temp;
	}

	/**
	 * Returns {@code true} if this list contains the specified int.
	 *
	 * @param i int whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 */
	public boolean contains(int i) { // IN CLASS Do Array loop first
		for (Node current = first; current != null; current = current.next) {
			if (current.item == i)
				return true;
		}
		return false;
	}

	/**
	 * Returns the int at the specified position in this list.
	 *
	 * @param index index of the int to return
	 * @return the int at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int get(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		int i = 0;
		Node current = first;
		while (i < index) {
			i++;
			current = current.next;
			if (current == null)
				throw new IndexOutOfBoundsException();
		}
		return current.item;
	}

	/**
	 * Replaces the {@code int} at the specified position in this list with the specified
	 * int.
	 *
	 * @param index index of the element to replace
	 * @param data int to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int set(int index, int data) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		int i = 0;
		Node current = first;
		while (i < index) {
			i++;
			current = current.next;
			if (current == null)
				throw new IndexOutOfBoundsException();
		}
		int old = current.item;
		current.item = data;
		return old;
	}

	/**
	 * Inserts the specified int at the specified position in this list. Shifts the
	 * int currently at that position (if any) and any subsequent ints to the right
	 * (adds one to their indices).
	 *
	 * @param index index at which the specified int is to be inserted
	 * @param data  int to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, int data) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			Node temp = new Node(data, first);
			first = temp;
		} else {
			int i = 0;
			Node current = first;
			while (i < index - 1) {
				i++;
				current = current.next;
				if (current == null)
					throw new IndexOutOfBoundsException();
			}
			Node temp = new Node(data, current.next);
			current.next = temp;
		}
	}

	/**
	 * Removes the first occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param data int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeFirstOccurrence(int data) {
		if(first.item == data) {
			first = first.next;
			return true;
		}
		
		// get to node before the data
		Node current = first;
		while (current.next != null && current.next.item != data) {
			current = current.next;
		}
		if (current.next == null)
			return false;
		
		// bypass the next node (which is the one to remove)
		current.next = current.next.next;
		return true;
	}

	/********************************** HOMEWORK **********************************/

	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Removes the last occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeLastOccurrence(int i) { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Constructs a new {@code LinkedIntList} consisting of just the even number
	 * from this list appearing in the same order as they occur in this list.
	 * 
	 * @return a new list that looks like this list be with all the odds removed.
	 */
	public LinkedIntList evens() { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Constructs a new int list where each entry in the new list is the sum of the
	 * corresponding entries in this list and the argument list.
	 * 
	 * @arg otherList the other list to be added to this list
	 * @return a new list where each entry in the new list is the sum of the
	 *         corresponding entries in this list and the argument list
	 * @throws IllegalArgumentException if this list and the other list have have
	 *                                  different lengths
	 */
	public LinkedIntList listAddition(LinkedIntList otherList) { // TODO
		throw new RuntimeException("Not implemented");
	}

	/* A small main to get started testing */
	public static void main(String[] args) {
		/*
		 * LinkedIntList l = new LinkedIntList(); l.addFirst(42); l.addFirst(0);
		 * l.addFirst(-5); l.addFirst(0); l.addFirst(1); l.printList();
		 * StdOut.println("removing " + l.removeFirst()); l.printList();
		 * StdOut.println("list contains 0 is " + l.contains(1));
		 */
		int[] a = { 1, 2, 3, 4, 2, 5, 6 };
		LinkedIntList l = new LinkedIntList(a);
		StdOut.println(l);
		//l.add(0, 99);
		//StdOut.println(l);
		// StdOut.println("Number in position 1 is " + l.get(1));
		// StdOut.println("Number in position 10 is " + l.get(10));
		StdOut.println("Before removing 1: " + l);
		l.removeFirstOccurrence(1);
		StdOut.println("After removing 1:  " + l);
	}
}
