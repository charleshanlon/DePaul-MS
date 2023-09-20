package week8;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class LinkedIntList {

	// helper linked list node class
	private class Node {
		private int item;
		private Node next;

		public Node() {
		}

		public Node(int number, Node nextNode) {
			item = number;
			next = nextNode;
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
		first = null;
		for (int i = data.length - 1; i >= 0; i--) {
			Node newNode = new Node();
			newNode.item = data[i];
			newNode.next = first;
			first = newNode;
		}
	}

	/**
	 * Prints the list to StdOut as a comma separted list inside of square brackets
	 */
	public void printList() {  // TODO
		throw new RuntimeException("Not implemented");
	}
	
	
	/**
	 * Constructs a string representing the list. The ints in the list appear in a
	 * comma separated list contained inside square brackets.
	 * 
	 * @return a string represeting the list.
	 */
	public String toString() { // TODO
		throw new RuntimeException("Not implemented");
	}


	/**
	 * Returns the first int in this list.
	 *
	 * @return the first int in this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.item;
	}

	/**
	 * Removes and returns the first int from this list.
	 *
	 * @return the first int from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		int answer = first.item;
		first = first.next;
		return answer;
	}

	/**
	 * Inserts the specified int at the beginning of this list. Shifts all ints
	 * already in the list to the right (adds one to their indices).
	 * 
	 * @param i the int to add
	 */
	public void addFirst(int i) {
		Node newFirst = new Node();
		newFirst.item = i;
		newFirst.next = first;
		first = newFirst;
	}

	/**
	 * Returns {@code true} if this list contains the specified int.
	 *
	 * @param i int whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 */
	public boolean contains(int i) { // TODO
		throw new RuntimeException("Not implemented");
	}
	
	
	/**
	 * Removes the first occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeFirstOccurrence(int i) { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the int at the specified position in this list.
	 *
	 * @param index index of the int to return
	 * @return the int at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int get(int index) { // TODO
		return getH(first, index);
	}
	
	private int getH(Node list, int index) {
		if (list == null)
			throw new IndexOutOfBoundsException();
		else {
			int temp = getH(list.next, index-1);
			return temp;
		}
	}

	/**
	 * Replaces the int at the specified position in this list with the specified
	 * int.
	 *
	 * @param index index of the element to replace
	 * @param i     int to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int set(int index, int i) { // TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Inserts the specified int at the specified position in this list. Shifts the
	 * int currently at that position (if any) and any subsequent ints to the right
	 * (adds one to their indices).
	 *
	 * @param index index at which the specified int is to be inserted
	 * @param i     int to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, int i) { // TODO
		throw new RuntimeException("Not implemented");
	}

	
	/**
	 * Checks if this list is equal to the argument list
	 * @param other the list to compare against
	 * @return {@code true} if this list equals {@code other} and
	 * 			{@code false} otherwise.
	 */
	public boolean equals(LinkedIntList other) { // TODO
		throw new RuntimeException("Not implemented");
	}
	


	
	/*********************HOMEWORK************************/

	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) {
		return indexOfH(first, i);
	}

	private int indexOfH(Node front, int i) {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the number of times a specified number appears in the list.
	 *
	 * @param i int to be counted
	 * @return the number of times the number {@code i} appears in the list
	 */
	public int count(int i) {
		return countH(first, i);
	}
	
	private int countH(Node front, int i) {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() {
		return sumH(first);
	}
	
	private int sumH(Node front) {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Constructs a new {@code LinkedIntList} consisting of just the even number
	 * from this list appearing in the same order as they occur in this list.
	 * 
	 * @return a new list that looks like this list be with all the odds removed.
	 */
	public LinkedIntList evens() {
		LinkedIntList answer = new LinkedIntList();
		answer.first = evensH(first);
		return answer;
	}
	
	public Node evensH(Node front) {
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
	public LinkedIntList listAddition(LinkedIntList otherList) {
		LinkedIntList answer = new LinkedIntList();
		answer.first = listAdditionH(first, otherList.first);
		return answer;
	}
	
	public Node listAdditionH(Node thisFront, Node otherFront) {
		throw new RuntimeException("Not implemented");
	}

	/* A small main to get started testing */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 2, 5, 6 };
		LinkedIntList l = new LinkedIntList(a);
		StdOut.println("The list: " + l.toString());
		StdOut.printf("has %d occurences of the number 2", l.get(4));
	}
}
