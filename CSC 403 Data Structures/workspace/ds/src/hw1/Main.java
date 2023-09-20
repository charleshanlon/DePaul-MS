package hw1;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] count = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] evens = {0, 2, 4, 6, 8};
		HW1 hw1 = new HW1();
		
		System.out.println("BEGIN TEST");
		if (hw1.sum(count) != 45)
			System.out.println("Error with sum");
		if (hw1.sum(evens) != 20)
			System.out.println("Error with sum");
		if (hw1.largest(count) != 9)
			System.out.println("Error with largest");
		if (hw1.largest(evens) != 8)
			System.out.println("Error with largest");
		if (hw1.secondLargest(count) != 8)
			System.out.println("Error with secondLargest");
		if (hw1.secondLargest(evens) != 6)
			System.out.println("Error with secondLargest");
		if (hw1.countEvens(count) != 5)
			System.out.println("Error with countEvens");
		if (hw1.countEvens(evens) != 5)
			System.out.println("Error with countEvens");
		if (!Arrays.equals(evens, hw1.getEvens(count)))
			System.out.println("Error with getEvens");
		if (!Arrays.equals(evens, hw1.getEvens(evens)))
			System.out.println("Error with getEvens");
		System.out.println("END TEST");
	}
}
