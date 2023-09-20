package ds2;

/*
 * This program demonstrates how to use a two-level symbol table.  It computes
 * the ration between the frequencies of a pair of words in a text file.  
 * 
 * It first stores a count for each word in a symbol table with the word as the
 * key and the count as the value.
 * 
 * Following that, it declares a two-level symbol table where the key is a word
 * and the value is a symbol table where the key is a second word and the value is 
 * the ratio between the counts of the two words.
 */
import algs4.*;
import myalgs4.*;

public class TwoLevelSymbolTable {

	public static void main(String[] args) {
		BSTEssential<String, Integer> wordCounts = new BSTEssential<>();
		BSTEssential<String, BSTEssential<String, Double>> wordRatios = new BSTEssential<>();

		StdIn.fromFile("data/tinyTale.txt");
		String[] words = StdIn.readAllStrings();

		// Fill the wordCounts symbol table with words and their counts in the
		// text file.
		for (String word : words) {
			Integer count = wordCounts.get(word);
			if (count == null)
				count = 0;
			wordCounts.put(word, count + 1);
		}

		// Fill the two-level wordRatios symbol table with word1 as the first level
		// key and, as its value, a symbol table with the word2 as the second level
		// key, with the ratio between the words' counts as the value.
		for (String word1 : wordCounts.keys()) {
			for (String word2 : wordCounts.keys()) {
				if (!wordRatios.contains(word1)) {
					wordRatios.put(word1, new BSTEssential<String, Double>());
				}
				wordRatios.get(word1).put(word2, 1.0 * wordCounts.get(word1) / wordCounts.get(word2));
			}
		}

		// Print the count of words, then print in alphabetical order each word followed
		// by its ratios with the other words.
		StdOut.println(wordCounts.size());
		for (String word1 : wordRatios.keys()) {
			StdOut.printf("%-12s\t", word1);
			for (String word2 : wordRatios.get(word1).keys()) {
				StdOut.printf("%5.3f ", wordRatios.get(word1).get(word2));
			}
			StdOut.println();
		}
	}
}
