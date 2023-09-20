package hw2;

import java.lang.String;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.Arrays;

public class CheckStringsTest {
	
	private CheckStrings check = new CheckStrings();
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void testHasDuplicateEmpty05() {
		String[] a = {};
		String[] b = {};
		assertFalse(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
	}

	@Test
	public void testHasDuplicateSmall05() {
		String[] a = {"ape", "dog", "lizard"};
		String[] b = Arrays.copyOf(a, a.length);
		assertFalse(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[2] = "ape"; //{"ape", "dog", "ape"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "ape"; //{"ape", "ape", "ape"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "bird"; //{"bird", "ape", "ape"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "bird"; //{"bird", "bird", "ape"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "cat"; //{"cat", "bird", "ape"}
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
	}

	@Test
	public void testHasDuplicateLarge05() {
		String[] a = {"car", "boat", "truck", "ship", "plane", "bicycle", "ship", "boat"};
		String[] b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "bus";  //{"car", "bus", "truck", "ship", "plane", "bicycle", "ship", "boat"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[6] = "sub";  //{"car", "bus", "truck", "ship", "plane", "bicycle", "sub", "boat"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "van";  //{"van", "bus", "truck", "ship", "plane", "bicycle", "sub", "boat"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[2] = "plane";  //{"van", "bus", "plane", "ship", "plane", "bicycle", "sub", "boat"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[3] = "plane";  //{"van", "bus", "plane", "plane", "plane", "bicycle", "sub", "boat"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.hasDuplicate(a));
		assertArrayEquals("The array was modified", b,a);
	}
	
	@Test
	public void testIsSortedEmpty05() {
		String[] a = {};
		String[] b = {};
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
	}

	@Test
	public void testIsSortedSmall05() {
		String[] a = {"ape", "dog", "lizard"};
		String[] b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "cat";  // {"cat", "dog", "lizard"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "bird"; // {"cat", "bird", "lizard"}
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[2] = "cow";  // {"cat", "bird", "cow"}
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "ant";  // {"and", "bird", "cow"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "bat";  // {"and", "bat", "cow"}
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[2] = "at";  // {"and", "bat", "at"}
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
	}
	
	@Test
	public void testIsSortedLarge05() {
		String[] a = {"and", "bat", "car", "dog", "farm", "ego", "ice", "jar", "kite"};
		String[] b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[5] = "farm"; //{"and", "bat", "car", "dog", "farm", "farm", "ice", "jar", "kite"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[5] = "go"; //{"and", "bat", "car", "dog", "farm", "go", "ice", "jar", "kite"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "bar"; //{"and", "bar", "car", "dog", "farm", "go", "ice", "jar", "kite"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[8] = "jam"; //{"and", "bar", "car", "dog", "farm", "go", "ice", "jar", "jam"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "at"; //{"and", "at", "car", "dog", "farm", "go", "ice", "jar", "jam"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[0] = "bar"; //{"bar", "at", "car", "dog", "farm", "go", "ice", "jar", "jam"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[7] = "igloo"; //{"bar", "at", "car", "dog", "farm", "go", "ice", "igloo", "jam"};
		b = Arrays.copyOf(a, a.length);
		assertFalse(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);
		
		a[1] = "base"; //{"bar", "base", "car", "dog", "farm", "go", "ice", "igloo", "jam"};
		b = Arrays.copyOf(a, a.length);
		assertTrue(check.isSorted(a));
		assertArrayEquals("The array was modified", b,a);		
	}
}
