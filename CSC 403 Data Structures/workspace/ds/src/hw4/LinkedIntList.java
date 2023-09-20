package hw4;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

// Charles Hanlon
public class LinkedIntList {
	
	// helper linked list node class
	private class Node {
		private int item;
		private Node next;
		
		public Node() {	}
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
	 * Constructs a string representing the list. The ints in the list appear in a
	 * comma separated list contained inside square brackets.
	 * 
	 * @return a string represeting the list.
	 */
	public String toString() {
		if (first == null)
			return "[]";
		String answer = "[" + first.item;
		Node ptr = first.next;
		while (ptr != null) {
			answer += ", " + ptr.item;
			ptr = ptr.next;
		}
		answer += "]";
		return answer;
	}

	/**
	 * Prints the list to StdOut as a comma separted list inside of square brackets
	 */
	public void printList() {
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			StdOut.print(ptr.item + " ");
		}
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
	public boolean contains(int i) { // IN CLASS Do Array loop first
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			if (ptr.item == i)
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
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		else
			return ptr.item;
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
	public int set(int index, int i) {
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		int answer = ptr.item;
		ptr.item = i;
		return answer;
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
	public void add(int index, int i) { 
		Node previous = null;
		Node position = first;
		while (index > 0 && position != null) {
			previous = position;
			position = position.next;
			index--;
		}
		if (index > 0)
			throw new IndexOutOfBoundsException();
		Node newNode = new Node();
		newNode.item = i;
		newNode.next = position;
		if (previous == null)
			first = newNode;
		else
			previous.next = newNode;
	}
	
	/**
	 * Removes the first occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeFirstOccurrence(int i) {
		if (first == null)
			return false;
		if (first.item == i) {
			first = first.next;
			return true;
		}
		Node ptr = first;
		while (ptr.next != null && ptr.next.item != i)
			ptr = ptr.next;
		if (ptr.next == null)
			return false;
		ptr.next = ptr.next.next;
		return true;
	}
	
	
	
	
	
	

	// DONE: Tests pass
	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) { // TODO
		int index = 0;
		for (Node current = first ; current != null ; current = current.next) {
			if (current.item == i) {
				return index;
			}
			index++;
		}
		
		return -1;
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
		
		Node ptr = first;
		Node temp = first;
		boolean notPresent = true;
		boolean firstCheck = false;
		
		// Is list empty?
		if (first == null)
			return false;
		//Is i first item?
		if (first.item == i) {
			temp = first;
			notPresent = false;
			firstCheck = true;
		}
		
		while (ptr.next != null) {
			if (ptr.next.item == i) {
				temp = ptr;
				notPresent = false;
				firstCheck = false;
			}
			ptr = ptr.next;
		}
		
		// Was i present?
		if (notPresent == true)
			return false;
		
		if (firstCheck == true)
			first = first.next;
		else
			temp.next = temp.next.next;
		
		
		return true;
	}
	
	
	
	
	
	// DONE: Tests pass
	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() { // TODO
		int sum = 0;
		
		for (Node current = first; current != null; current = current.next) {
			sum += current.item;
		}
		return sum;
	}

	
	
	
	
	
	/**
	 * Constructs a new {@code LinkedIntList} consisting of just the even number from this list
	 * appearing in the same order as they occur in this list.
	 * 
	 * @return a new list that looks like this list be with all the odds removed.
	 */
	public LinkedIntList evens() {  // TODO
		LinkedIntList evensList = new LinkedIntList();
		Node firstEvens = null;
	
		
		for (Node current = first; current != null; current = current.next) {
			if (current.item % 2 == 0) {
				if (firstEvens == null) {
					Node temp = new Node();
					temp.item = current.item;
					temp.next = null;
					firstEvens = temp;
					evensList.first = firstEvens;
				}
				else {
					Node temp = new Node();
					temp.item = current.item;
					temp.next = null;
					firstEvens.next = temp;
					firstEvens = firstEvens.next;
				}
			}
		}
		return evensList;
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
	public LinkedIntList listAddition(LinkedIntList otherList) {  // TODO
		LinkedIntList additionList = new LinkedIntList();
		Node firstAddition = null;
		Node currentA = first;
		Node currentB = otherList.first;
		int sum = 0;
		
		
		while (currentA != null || currentB != null) {
			if (currentA != null && currentB == null || currentA == null && currentB != null)
				throw new IllegalArgumentException("Lists are different sizes");
			
			sum = currentA.item + currentB.item;
			
			if (firstAddition == null) {
				Node temp = new Node();
				temp.item = sum;
				temp.next = null;
				firstAddition = temp;
				additionList.first = firstAddition;
			}
			else {
				Node temp = new Node();
				temp.item = sum;
				temp.next = null;
				firstAddition.next = temp;
				firstAddition = firstAddition.next;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		
		return additionList;
	}
	
	
	
	
	
	
	
	/* A small main to get started testing */
	public static void main(String[] args) {
		int[] a = {2, 4, 5, 4, 3, 6, 4, 5, 4, 5, 5, 5, 5, 4, 3, 2, 5, 1};
		LinkedIntList l = new LinkedIntList(a);
		StdOut.println("Before: " + l);
		l.removeLastOccurrence(5);
		StdOut.println("Result: " + l);
		//StdOut.println("Should equal: [5, 7, 3, 5, 5, -1, 2, 0, 5, 9, 7, 5]");
	}
}
