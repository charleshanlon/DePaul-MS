package hw2;

/**
 * Charles Hanlon
 * A class that mimics how Java's String class behaves.
 * Look at Java's String API for information on how each of these should behave.
 *
 */
public class String {
	private char[] data;

	public String(char[] value) {
		int size = value.length;
		data = new char[size];
		
		for (int i = 0; i < size; i++) {
			data[i] = value[i];
		}
		//System.out.println(data);
	}

	
	public char charAt(int index) {
		return data[index];
	}


	public int indexOf(char ch) {
		int ct = 0;
		int size = data.length;
		
		for (int i = 0; i < size; i++) {
			if (data[i] == ch) {
				return ct;	
			}
			ct++;
		}
		return -1;
	}

	public boolean equals(String other) {
		
		/**Better Answer:
		 * 
		 * if (data.length != other.data.length)
		 * 		return false;
		 * 
		 * for (int i=0; i<data.length; i++)
		 * 		if (data[i] != other.data[i])
		 * 			return false;
		 * return true;
		 * 
		 * 
		 */
		String s = new String(data);
		int size1 = this.data.length;
		int size2 = other.data.length;
		
		if (this.data == null && other.data == null)
			return true;
		
		if (size1 != size2)
			return false;

		for (int i = 0; i < size1; i++) {
			if (s.charAt(i) != other.charAt(i))
				return false;
		}
		return true; 
	}

	public int compareTo(String anotherString) {
		String s = new String(data);
		int size = 0;
		int sizeThis = this.data.length;
		int sizeOther = anotherString.data.length;
		
		if (sizeThis < sizeOther)
			size = sizeThis;
		else
			size = sizeOther;
		
		if (s.equals(anotherString))
			return 0;
		
		for (int i = 0; i < size; i++) {
			if (s.charAt(i) != anotherString.charAt(i)) {
				return s.charAt(i) - anotherString.charAt(i);
			}	
		}
		return sizeThis - sizeOther;
	}


	public String replace(char oldChar, char newChar) {
		int size = data.length;
		char newString[] = new char[size];
		int ct = 0;
		
		while (ct < size) {
			if (data[ct] == oldChar)
				break;
			ct++;
		}
		if (ct == size)
			return this;
		
		if (oldChar != newChar) {
			for (int i = 0; i < size; i++) {
				if (data[i] == oldChar) {
					newString[i] = newChar;
				}
				else
					newString[i] = data[i];
			}
			String ans = new String(newString);
			return ans;
		}
		return this;
	}
}
