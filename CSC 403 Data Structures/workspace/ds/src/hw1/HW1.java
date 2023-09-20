package hw1;

// Written by Charles Hanlon 4/2022

public class HW1 {
	/**
	 * 
	 * Computes the sum of the ints in an array.
	 * 
	 * @param a the array of ints to be summed
	 * @return the sum of the ints in <code>a</code>
	 */
	public int sum(int[] a) {
		int sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		
		return sum;
	}
	
	/**
	 * Finds the maximum int in a non-empty array.
	 * 
	 * @param a a non-empty array of ints
	 * @return the maximum int in the array
	 */
	public int largest(int[] a) {
		int largest = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if (a[i] > largest) {
				largest = a[i];
			}
		}
		return largest;
	}
	
	/**
	 * Finds the second largest int in an array of unique ints
	 * 
	 * @param a an int array of unique ints with size > 1
	 * @return the second largest int in the array
	 */
	public int secondLargest(int[] a) {
		int largest = largest(a);
		int secondLargest = a[0];
		
		if (a.length == 2) {
			if (a[0] < a[1]) {
				return secondLargest;
			}
			else {
				secondLargest = a[1];
				return secondLargest;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[i] && a[j] < largest) {
					secondLargest = a[j];
				}
			}
		}
		return secondLargest;
	}
	
	/**
	 * Returns the number of even ints in an array.
	 * 
	 * @param a an array of ints
	 * @return the number of even ints in the array
	 */
	public int countEvens(int[] a) {
		int countEvens = 0;
		
		for (int i = 0; i< a.length; i++) {
			if ((a[i])%2 == 0) {
				countEvens ++;
			}
		}
		
		return countEvens;
	}
	
	/**
	 * Returns a new array containing the even ints from an input array in
	 * the same order they appear in the array.
	 * 
	 * @param a an array of ints
	 * @return a new array containing the even ints from an input array in
	 * the same order they appear in the array
	 */
	public int[] getEvens(int[] a) {
		int evensListLength = countEvens(a);
		// Test System.out.print((evensListLength + " "));
		int[] evensList = new int[evensListLength];
		
		if (evensListLength !=0) {
			for (int i = 0, j = 0; i < a.length; i++) {
				if ((a[i])%2 == 0) {
					evensList[j] = a[i];
					j++;
					// Test System.out.print((j + " <-> " + a[i] + "\n"));
				}
			}
		}
		return evensList;
		}
}
