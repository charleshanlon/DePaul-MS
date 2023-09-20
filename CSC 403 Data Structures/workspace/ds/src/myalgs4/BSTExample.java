package myalgs4;

import algs4.*;

public class BSTExample {

	public static void main(String[] args) {
		// BSTEssential<String, Integer> tree = new BSTEssential<>();
		BSTEssential<String, Integer> tree = new BSTEssential<>();
		StdIn.fromFile("data/tinyTale.txt");
		String[] words = StdIn.readAllStrings();
		// StdOut.println(words[0]);
		for (String word: words) {
			Integer count = tree.get(word);
			if (count == null) {
				count = 0;
				tree.put(word, 0);
			}
			tree.put(word, count+1);
		}
		StdOut.println("The word 'was' occurs " + tree.get("was") + " times.");
		tree.drawTree();
	}

}
