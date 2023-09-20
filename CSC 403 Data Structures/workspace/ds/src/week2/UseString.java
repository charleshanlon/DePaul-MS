package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UseString {
	public static void main(String[] args) {
		StdOut.println("Type in a word");
		String s1 = StdIn.readString();
		
		StdOut.printf("character in slot 1 is %c%n", s1.charAt(1));
		
		StdOut.printf("substring(1,3) is %s%n", s1.substring(1,3));
		StdOut.printf("s1 is still %s%n", s1);
		
		StdOut.printf("replace('l','X') is %s%n", s1.replace('l','X'));
		StdOut.printf("s1 is still %s%n", s1);
		
		
		StdOut.println("Type in another word");
		String s2 = StdIn.readString();
		String s3 = s1;
		StdOut.println("s1 is " + s1);
		StdOut.println("s2 is " + s2);
		StdOut.println("s3 is " + s3);
		if (s1 == s2)
			StdOut.println("s1 == s2");
		else
			StdOut.println("s1 != s2");
		if (s1 == s3)
			StdOut.println("s1 == s3");
		else
			StdOut.println("s1 != s3");
		if (s1.equals(s2))
			StdOut.println("s1.equals(s2)");
		else
			StdOut.println("NOT the case that s1.equals(s2)");
		
		StdOut.println("s1.compareTo(s2) returns " + s1.compareTo(s2));
		StdOut.println("s2.compareTo(s1) returns " + s2.compareTo(s1));
		
	}	
}
