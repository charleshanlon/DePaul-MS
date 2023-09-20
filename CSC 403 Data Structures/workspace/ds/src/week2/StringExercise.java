package week2;

import edu.princeton.cs.algs4.*;

// HW2
// isSorted
// hasDuplicate

public class StringExercise {	
	public static void main(String[] args) {
		System.out.println("Type in 2 words");
		String word1 = StdIn.readString();
		String word2 = StdIn.readString();
		
		StdOut.println("First word is:  " + word1);
		StdOut.println("Second word is: " + word2);
		
		StringExercise ex1 = new StringExercise();
		
		if (word1 == word2)
			StdOut.println("The words are the same");
		else {
			StdOut.println("The words are different");
			String first = ex1.firstWord(word1, word2);
			StdOut.println("First word in dictionary is " + first);
		}
	}
	
	public String firstWord(String w1, String w2) {
		throw new RuntimeException("Not implemented");
	}
	

}
