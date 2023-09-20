package hw2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class StringTest {

	private char[] emptyA;
	private String emptyS;
	private String emptySCopy;
	
	
	private char[] bookA;
	private char[] bookkeeperA;
	private char[] coverA;
	private char[] orangeA;
	private char[] stealA;
	private char[] steelA;
	private char[] tanA;
	private char[] tangerineA;
	private char[] tangleA;
	private char[] vectorA;
	
	private String bookS;
	private String bookkeeperS;
	private String coverS;
	private String orangeS;
	private String stealS;
	private String steelS;
	private String tanS;
	private String tangerineS;
	private String tangleS;
	private String vectorS;

	private String bookSCopy;
	private String bookkeeperSCopy;
	private String coverSCopy;
	private String orangeSCopy;
	private String stealSCopy;
	private String steelSCopy;
	private String tanSCopy;
	private String tangerineSCopy;
	private String tangleSCopy;
	private String vectorSCopy;
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);
	

	@Before
	public void initialize() {
		emptyA = new char[0];
		emptyS = new String(emptyA);
		emptySCopy = new String(emptyA);
		
		bookA = "book".toCharArray();
		bookkeeperA = "bookkeeper".toCharArray();
		coverA = "cover".toCharArray();
		orangeA = "orange".toCharArray();
		stealA = "steal".toCharArray();
		steelA = "steel".toCharArray();
		tanA = "tan".toCharArray();
		tangerineA = "tangerine".toCharArray();
		tangleA = "tangle".toCharArray();
		vectorA = "vecotr".toCharArray();
		
		bookS = new String(bookA);
		bookkeeperS = new String(bookkeeperA);
		coverS = new String(coverA);
		orangeS = new String(orangeA);
		stealS = new String(stealA);
		steelS = new String(steelA);
		tanS = new String(tanA);
		tangerineS = new String(tangerineA);
		tangleS = new String(tangleA);
		vectorS = new String(vectorA);
		
		bookSCopy = new String(bookA);
		bookkeeperSCopy = new String(bookkeeperA);
		coverSCopy = new String(coverA);
		orangeSCopy = new String(orangeA);
		stealSCopy = new String(stealA);
		steelSCopy = new String(steelA);
		tanSCopy = new String(tanA);
		tangerineSCopy = new String(tangerineA);
		tangleSCopy = new String(tangleA);
		vectorSCopy = new String(vectorA);
	}


	@Test
	public void test10ReuseArray() {
		char[] array = {'b', 'o', 'a', 't'};
		String boatS = new String(array);
		assertEquals('b', boatS.charAt(0));
		assertEquals('o', boatS.charAt(1));
		assertEquals('a', boatS.charAt(2));
		assertEquals('t', boatS.charAt(3));
		array[2] = 'o';
		assertEquals('b', boatS.charAt(0));
		assertEquals('o', boatS.charAt(1));
		assertEquals('a', boatS.charAt(2));
		assertEquals('t', boatS.charAt(3));
		String bootS = new String(array);
		assertEquals('b', boatS.charAt(0));
		assertEquals('o', boatS.charAt(1));
		assertEquals('a', boatS.charAt(2));
		assertEquals('t', boatS.charAt(3));
		assertEquals('b', bootS.charAt(0));
		assertEquals('o', bootS.charAt(1));
		assertEquals('o', bootS.charAt(2));
		assertEquals('t', bootS.charAt(3));
	}


	@Test
	public void test05EqualsEmptyAndSame() {
		assertTrue(emptyS.equals(emptySCopy));
		assertTrue(emptySCopy.equals(emptyS));
		assertFalse(emptyS.equals(bookS));
		assertFalse(bookS.equals(emptyS));
		assertFalse(emptyS.equals(steelS));
		assertFalse(steelS.equals(emptyS));
		
		assertTrue(bookS.equals(bookS));
		assertTrue(bookkeeperSCopy.equals(bookkeeperSCopy));
		assertTrue(steelS.equals(steelS));
		assertTrue(vectorSCopy.equals(vectorSCopy));
		assertTrue(tanS.equals(tanSCopy));
	}

	@Test
	public void test10Equals() {
		assertTrue(bookS.equals(bookSCopy));
		assertTrue(bookkeeperS.equals(bookkeeperSCopy));
		assertTrue(coverS.equals(coverSCopy));
		assertTrue(orangeS.equals(orangeSCopy));
		assertTrue(stealS.equals(stealSCopy));
		assertTrue(steelS.equals(steelSCopy));
		assertTrue(tanS.equals(tanSCopy));
		assertTrue(tangerineS.equals(tangerineSCopy));
		assertTrue(tangleS.equals(tangleSCopy));
		assertTrue(vectorS.equals(vectorSCopy));
	}

	@Test
	public void test05CompareToSmall() {
		assertTrue(emptyS.compareTo(emptySCopy) == 0);
		assertTrue(emptySCopy.compareTo(emptyS) == 0);
		assertTrue(emptyS.compareTo(tanS) < 0);
		assertTrue(bookS.compareTo(emptyS) > 0);

		char[] aArray = { 'a' };
		char[] bArray = { 'b' };
		char[] yArray = { 'y' };
		String a = new String(aArray);
		String b = new String(bArray);
		String y = new String(yArray);

		assertTrue(a.compareTo(b) < 0);
		assertTrue(a.compareTo(y) < 0);
		assertTrue(y.compareTo(a) > 0);
		assertTrue(y.compareTo(b) > 0);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(b.compareTo(y) < 0);
	}

	@Test
	public void test10CompareTo() {
		assertEquals(0, bookS.compareTo(bookSCopy));
		assertEquals(0, bookSCopy.compareTo(bookS));
		assertEquals(0, bookkeeperS.compareTo(bookkeeperSCopy));
		assertEquals(0, bookkeeperSCopy.compareTo(bookkeeperS));
		assertEquals(0, tanS.compareTo(tanSCopy));
		assertEquals(0, tanSCopy.compareTo(tanS));
		
		assertTrue(bookS.compareTo(tanS) < 0);
		assertTrue(bookS.compareTo(bookkeeperS) < 0);
		assertTrue(tangerineS.compareTo(tanS) > 0);
		assertTrue(tangleS.compareTo(tanS) > 0);
		assertTrue(tanS.compareTo(tangerineS) < 0);
		assertTrue(vectorS.compareTo(coverS) > 0);
	}

	@Test
	public void test05IndexOfSmall() {
		for (char c = 'a'; c <= 'z'; c++) {
			assertEquals(-1, emptyS.indexOf(c));
		}

		char[] aArray = { 'a' };
		char[] bArray = { 'b' };
		char[] yArray = { 'y' };
		String a = new String(aArray);
		String b = new String(bArray);
		String y = new String(yArray);
		assertEquals(0, a.indexOf('a'));
		assertEquals(0, b.indexOf('b'));
		assertEquals(0, y.indexOf('y'));
		assertEquals(-1, a.indexOf('b'));
		assertEquals(-1, a.indexOf('y'));
		assertEquals(-1, b.indexOf('a'));
		assertEquals(-1, y.indexOf('a'));
	}

	@Test
	public void test10IndexOf() {
		assertEquals(0, bookkeeperS.indexOf('b'));
		assertEquals(1, bookkeeperS.indexOf('o'));
		assertEquals(3, bookkeeperS.indexOf('k'));
		assertEquals(-1, bookkeeperS.indexOf('a'));
		assertEquals(5, bookkeeperS.indexOf('e'));
		assertEquals(7, bookkeeperS.indexOf('p'));
		assertEquals(9, bookkeeperS.indexOf('r'));
		assertEquals(-1, bookkeeperS.indexOf('c'));
		
		assertEquals(-1, bookS.indexOf('r'));
		
		assertEquals(0, stealS.indexOf('s'));
		assertEquals(1, stealS.indexOf('t'));
		assertEquals(3, stealS.indexOf('a'));
		assertEquals(-1, steelS.indexOf('a'));
	}

	@Test
	public void test05ReplaceSmall() {
		char[] aArray = { 'a' };
		char[] bArray = { 'b' };
		char[] yArray = { 'y' };
		String a = new String(aArray);
		String b = new String(bArray);
		String y = new String(yArray);
		String result = a.replace('a', 'y');
		assertEquals('y', result.charAt(0));
		assertEquals('a', a.charAt(0));
		result = b.replace('b', 'a');
		assertEquals('a', result.charAt(0));
		assertEquals('b', b.charAt(0));
		result = y.replace('y', 'b');
		assertEquals('b', result.charAt(0));
		assertEquals('y', y.charAt(0));
	}

	@Test
	public void test05ReplaceOldNotPresent() {
		String result;
		
		result = bookS.replace('a', 'b');
		
		// Note that the use of == instead of equals below is deliberate.
		// See the documentation of the replace method in Java's String API
		// if you don't understand why we use == in the tests.
		
		assertTrue(result == bookS);
		result = stealS.replace('r', 'c');
		assertTrue(result == stealS);
		result = tanS.replace('e', 'f');
		assertTrue(result == tanS);
		result = vectorS.replace('b', 'x');
		assertTrue(result == vectorS);
		result = bookkeeperS.replace('z', 'r');
		assertTrue(result == bookkeeperS);
		result = emptyS.replace('t', 'u');
		assertTrue(result == emptyS);
	}

	@Test
	public void test05ReplaceInWord() {

		String result;
		result = bookS.replace('b', 'x');
		assertEquals('x', result.charAt(0));
		assertEquals('o', result.charAt(1));
		assertEquals('o', result.charAt(2));
		assertEquals('k', result.charAt(3));
		assertEquals('b', bookS.charAt(0));
		assertEquals('o', bookS.charAt(1));
		assertEquals('o', bookS.charAt(2));
		assertEquals('k', bookS.charAt(3));
		
		result = bookkeeperS.replace('e', 'o');
		assertEquals('b', result.charAt(0));
		assertEquals('o', result.charAt(1));
		assertEquals('o', result.charAt(2));
		assertEquals('k', result.charAt(3));
		assertEquals('k', result.charAt(4));
		assertEquals('o', result.charAt(5));
		assertEquals('o', result.charAt(6));
		assertEquals('p', result.charAt(7));
		assertEquals('o', result.charAt(8));
		assertEquals('r', result.charAt(9));
		assertEquals('b', bookkeeperS.charAt(0));
		assertEquals('o', bookkeeperS.charAt(1));
		assertEquals('o', bookkeeperS.charAt(2));
		assertEquals('k', bookkeeperS.charAt(3));
		assertEquals('k', bookkeeperS.charAt(4));
		assertEquals('e', bookkeeperS.charAt(5));
		assertEquals('e', bookkeeperS.charAt(6));
		assertEquals('p', bookkeeperS.charAt(7));
		assertEquals('e', bookkeeperS.charAt(8));
		assertEquals('r', bookkeeperS.charAt(9));
		
		result = stealS.replace('a', 'e');
		assertTrue(result.equals(steelS));
		assertTrue(steelS.equals(result));
		assertTrue(stealS.equals(stealSCopy));
		assertTrue(stealSCopy.equals(stealS));
	}
}
