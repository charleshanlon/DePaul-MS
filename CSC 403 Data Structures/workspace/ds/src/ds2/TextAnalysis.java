package ds2;

// Author: Charles Hanlon

import algs4.StdIn;
import algs4.StdOut;

public class TextAnalysis {
	
	public static void main(String[] args) {
		
		System.out.println("Charles Hanlon***");	// Print name w/ three asterisks
		
		// Reads words into an array of strings
		StdIn.fromFile("data/tale.txt");		
		String[] words = StdIn.readAllStrings();	
		
		// Initialize variables 
		int min = words[0].length();
		int max = words[0].length();
		int wordCount = 0;
		int totalLength = 0;
		int tmp = 0;
		float mean = 0;
		float sum = 0;
		
		// Iterate through the array 
		for (String word : words) {
			wordCount += 1;
			tmp = word.length();
			
			if (tmp < min) {
				min = tmp;
			}
			
			if (tmp > max) {
				max = tmp;
			}
			
			totalLength += tmp;
			sum = totalLength;
		}
		
		mean = sum/wordCount;
		
		StdOut.println("Word Count: " + wordCount);
		StdOut.println("Total Length: " + totalLength);
		StdOut.println("Mean Length: " + mean);
		StdOut.println("Minimum Length: " + min);
		StdOut.println("Maximum Length: " + max);
	}	
}
