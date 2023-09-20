 package hw6;

public class DoublingString {
	/**
	 * Constructs a {@code String} of length {@code size} composed entirely
	 * of the character {@code c}.  This function creates the {@code String}
	 * by concatenating the temporary string to itself so as to double the
	 * length of the {@code String} every time until the temporary {@code String}
	 * is at least as long as {@code length}.  It then calls the substring method
	 * on the temporary {@code String} to make it the right length.
	 * @param c the character to use in the {@code String}
	 * @param size the length of the {@code String}
	 * @return a {@code String} consisting of {@code length} {@code c}s.
	 */
	public static String createString(char c, int size) {
		String result = "" + c;
		int resultSize = 1;
		while (resultSize < size) {
			result += result;
			resultSize += resultSize;
		}
		return result.substring(0, size);
	}
	
	public static void main(String[] args) {
		int SIZE = 187500000;
		long start = System.currentTimeMillis();
		String s = createString('*', SIZE);
		long finish = System.currentTimeMillis();
		System.out.println(finish-start);
	}
}
