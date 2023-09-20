package hw6;

public class IncrementalString {
	/**
	 * Constructs a {@code String} of length {@code size} composed entirely
	 * of the character {@code c}.  This function creates the {@code String}
	 * by building it up one character at a time.
	 * @param c the character to use in the {@code String}
	 * @param size the length of the {@code String}
	 * @return a {@code String} consisting of {@code length} {@code c}s.
	 */
	public static String createString(char c, int size) {
		String result = "";
		for(int i = 0; i < size; i++)
			result += c;
		return result;
	}
	
	public static void main(String[] args) {
		int SIZE = 275000;
		long start = System.currentTimeMillis();
		String s = createString('*', SIZE);
		long finish = System.currentTimeMillis();
		System.out.println(finish-start);
	}
}
