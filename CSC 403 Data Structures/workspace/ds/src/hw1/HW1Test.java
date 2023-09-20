package hw1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW1Test {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void test05SumEmpty() {
		int[] empty = {};
		HW1 hw1 = new HW1();
		assertEquals(0, hw1.sum(empty));
	}

	@Test
	public void test05SumSingle() {
		int[] one = { 1 };
		int[] zero = { 0 };
		int[] negFive = { -5 };
		int[] oneHundredOne = { 101 };
		HW1 hw1 = new HW1();
		assertEquals(1, hw1.sum(one));
		assertEquals(0, hw1.sum(zero));
		assertEquals(-5, hw1.sum(negFive));
		assertEquals(101, hw1.sum(oneHundredOne));
	}

	@Test
	public void test05SumDouble() {
		int[] a = { 0, 0 };
		int[] b = { -5, 5 };
		HW1 hw1 = new HW1();

		assertEquals(0, hw1.sum(a));
		assertEquals(0, hw1.sum(b));
		a[1] = 7;
		b[0] = 0;
		assertEquals(7, hw1.sum(a));
		assertEquals(5, hw1.sum(b));
		a[0] = 2;
		b[1] = -10;
		assertEquals(9, hw1.sum(a));
		assertEquals(-10, hw1.sum(b));
	}

	@Test
	public void test05SumLong() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int total = 55;
		HW1 hw1 = new HW1();
		assertEquals(total, hw1.sum(a));
		for (int i = 0; i < a.length; i++) {
			a[i]++;
			total++;
			assertEquals(total, hw1.sum(a));
		}
		for (int i = 0; i < 10; i++) {
			a[6] += 11;
			total += 11;
			assertEquals(total, hw1.sum(a));
		}
	}

	@Test
	public void test05LargestSingle() {
		int[] one = { 1 };
		int[] zero = { 0 };
		int[] negFive = { -5 };
		int[] oneHundredOne = { 101 };
		HW1 hw1 = new HW1();
		assertEquals(1, hw1.largest(one));
		assertEquals(0, hw1.largest(zero));
		assertEquals(-5, hw1.largest(negFive));
		assertEquals(101, hw1.largest(oneHundredOne));
	}

	@Test
	public void test05LargestDouble() {
		int[] a = { 0, 0 };
		int[] b = { -5, 5 };
		HW1 hw1 = new HW1();

		assertEquals(0, hw1.largest(a));
		assertEquals(5, hw1.largest(b));
		a[1] = 7;
		b[0] = 0;
		assertEquals(7, hw1.largest(a));
		assertEquals(5, hw1.largest(b));
		a[0] = 2;
		b[1] = -10;
		assertEquals(7, hw1.largest(a));
		assertEquals(0, hw1.largest(b));
	}

	@Test
	public void test10LargestLong() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 };
		HW1 hw1 = new HW1();

		assertEquals(10, hw1.largest(a));
		assertEquals(-1, hw1.largest(b));

		int aMax = 0;
		int bMax = -1;
		for (int i = 0; i < 9; i++) {
			a[i] *= 11;
			b[i] *= 11;
			aMax += 11;
			bMax -= 1;
			assertEquals(aMax, hw1.largest(a));
			assertEquals(bMax, hw1.largest(b));
		}
	}

	@Test
	public void test05SecondLargestDouble() {
		int[] a = { 10, 0 };
		int[] b = { -5, 5 };
		HW1 hw1 = new HW1();

		assertEquals(0, hw1.secondLargest(a));
		assertEquals(-5, hw1.secondLargest(b));
		a[1] = 17;
		b[0] = 20;
		assertEquals(10, hw1.secondLargest(a));
		assertEquals(5, hw1.secondLargest(b));
		a[0] = 2;
		b[1] = -10;
		assertEquals(2, hw1.secondLargest(a));
		assertEquals(-10, hw1.secondLargest(b));
	}

	@Test
	public void test05SecondLargestTriple() {
		int[] a = { 10, 0, 5 };
		int[] b = { 3, 1, 8 };
		HW1 hw1 = new HW1();

		assertEquals(5, hw1.secondLargest(a));
		assertEquals(3, hw1.secondLargest(b));

		a[0] = 21;
		b[0] = 13;
		assertEquals(5, hw1.secondLargest(a));
		assertEquals(8, hw1.secondLargest(b));

		a[1] = 30;
		b[1] = 100;
		assertEquals(21, hw1.secondLargest(a));
		assertEquals(13, hw1.secondLargest(b));

	}

	@Test
	public void test10SecondLargestLong() {
		int[] a = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		HW1 hw1 = new HW1();

		assertEquals(80, hw1.secondLargest(a));

		a[0] = 100;
		assertEquals(90, hw1.secondLargest(a));

		a[4] = 44;
		assertEquals(90, hw1.secondLargest(a));

		a[8] = 88;
		assertEquals(90, hw1.secondLargest(a));

		a[9] = 99;
		assertEquals(99, hw1.secondLargest(a));

		a[9] = 9;
		assertEquals(88, hw1.secondLargest(a));
	}

	@Test
	public void test05countEvensEmpty() {
		int[] empty = {};
		HW1 hw1 = new HW1();
		assertEquals(0, hw1.countEvens(empty));
	}

	@Test
	public void test05countEvensSingle() {
		int[] seven = { 7 };
		int[] neg2 = { -2 };
		HW1 hw1 = new HW1();

		assertEquals(0, hw1.countEvens(seven));
		assertEquals(1, hw1.countEvens(neg2));
	}

	@Test
	public void test05countEvensDouble() {
		int[] a = { 2, -6 };
		int[] b = { -1, 7 };
		HW1 hw1 = new HW1();

		assertEquals(2, hw1.countEvens(a));
		assertEquals(0, hw1.countEvens(b));

		a[1] = -3;
		b[1] = 4;

		assertEquals(1, hw1.countEvens(a));
		assertEquals(1, hw1.countEvens(b));
	}

	@Test
	public void test05countEvensLong() {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		HW1 hw1 = new HW1();

		assertEquals(5, hw1.countEvens(a));
		a[0] = 20;
		assertEquals(5, hw1.countEvens(a));
		a[1] = 22;
		assertEquals(6, hw1.countEvens(a));
		a[3] = 66;
		assertEquals(7, hw1.countEvens(a));
		a[6] = 120;
		assertEquals(7, hw1.countEvens(a));
		a[3] = 33;
		assertEquals(6, hw1.countEvens(a));
	}

	@Test
	public void test05getEvensEmpty() {
		int[] empty1 = {};
		int[] empty2 = {};
		HW1 hw1 = new HW1();
		assertArrayEquals(empty2, hw1.getEvens(empty1));
		assertArrayEquals(empty1, hw1.getEvens(empty1));
	}

	@Test
	public void test05getEvensSingle() {
		int[] empty = {};
		int[] seven = { 7 };
		int[] neg2 = { -2 };
		HW1 hw1 = new HW1();
		assertArrayEquals(empty, hw1.getEvens(seven));
		assertArrayEquals(neg2, hw1.getEvens(neg2));
	}
	
	@Test
	public void test05getEvensDouble() {
		int[] empty = {};
		int[] ee = { 4, -2 };
		int[] eo = { -2, 7 };
		int[] oe = { 7, -2 };
		int[] oo = { -5, 7 };
		int[] negTwo = { -2 };
		HW1 hw1 = new HW1();
		
		assertArrayEquals(empty, hw1.getEvens(oo));
		assertArrayEquals(negTwo, hw1.getEvens(eo));
		assertArrayEquals(negTwo, hw1.getEvens(oe));
		assertArrayEquals(ee, hw1.getEvens(ee));
	}
	
	@Test
	public void test05getEvensLong() {
		int[] count = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] evens = {0, 2, 4, 6, 8};
		int[] evens10 = {0, 10, 2, 4, 6, 8};
		int[] evens1030 = {0, 10, 2, 30, 4, 6, 8};
		int[] evens30 = {0, 2, 30, 4, 6, 8};
		HW1 hw1 = new HW1();
		
		assertArrayEquals(evens, hw1.getEvens(count));
		count[1] = 10;
		assertArrayEquals(evens10, hw1.getEvens(count));
		count[3] = 30;
		assertArrayEquals(evens1030, hw1.getEvens(count));
		count[1] = 17;
		assertArrayEquals(evens30, hw1.getEvens(count));
	}
}