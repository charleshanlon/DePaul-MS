package hw2;

import java.lang.String;

public class CheckStrings {
	/**
	 * Charles Hanlon
	 * Returns true if the Strings in w appear in sorted order
	 * (alphabetical order) and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if the Strings in w appear in sorted order
	 * and false otherwise.
	 */
	public boolean isSorted(String[] w) {
		for (int i = 1; i < w.length; i++) {
			if (w[i-1].compareTo(w[i]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns true if at least one String in w appears more than once
	 * and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if at least one String in w appears more than once
	 * and false otherwise.
	 */
	public boolean hasDuplicate(String[] w) {
		for (int i = 0; i < w.length; i++) {
			for (int j = i+1; j < w.length; j++) {
				if (w[i].equals(w[j])) {
					return true;
				}
			}
		}
		return false;
	}
}
