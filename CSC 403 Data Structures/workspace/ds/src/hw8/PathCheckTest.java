package hw8;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PathCheckTest {

	@Rule
    public Timeout globalTimeout = Timeout.seconds(10);
	
	@Test
	public void test10Exceptions() {
		PathCheck pc = new PathCheck(271);
		pc.select(0,0);
		pc.select(270,270);
		try {
			pc.select(10,-2);
			fail("col was negative");
		} catch (IllegalArgumentException e) {}
		pc.select(0,1);
		pc.select(270,269);
		try {
			pc.select(10,271);
			fail("col was too large");
		} catch (IllegalArgumentException e) {}
		pc.select(1,270);
		pc.select(270,1);
		try {
			pc.select(-100, 10);
			fail("row was negative");
		} catch (IllegalArgumentException e) {}
		pc.select(11,269);
		pc.select(270,11);
		try {
			pc.select(2510,260);
			fail("col was too large");
		} catch (IllegalArgumentException e) {}
		pc = new PathCheck(2);
		try {
			pc.select(0,2);
			fail("col was too large");
		} catch (IllegalArgumentException e) {}	
	}

	@Test
	public void test20Size2() {
		PathCheck pc0 = new PathCheck(2);
		PathCheck pc1 = new PathCheck(2);
		PathCheck pc2 = new PathCheck(2);
		PathCheck pc3 = new PathCheck(2);
		assertFalse(pc0.select(0,0));
		assertFalse(pc1.select(0,1));
		assertFalse(pc2.select(1,0));
		assertFalse(pc3.select(1,1));
		assertFalse(pc0.select(1,1));
		assertFalse(pc1.select(1,0));
		assertFalse(pc2.select(1,1));
		assertTrue(pc3.select(0,1));
		assertTrue(pc0.select(0,1));
		assertTrue(pc1.select(1,1));
		assertFalse(pc2.select(1,0));
		assertTrue(pc2.select(0,0));
	}
	
	@Test
	public void test20Size3() {
		PathCheck pc0 = new PathCheck(3);
		PathCheck pc4 = new PathCheck(3);
		PathCheck pc8 = new PathCheck(3);
		assertFalse(pc0.select(0,0));
		assertFalse(pc4.select(1,1));
		assertFalse(pc8.select(2,2));
		
		assertFalse(pc0.select(0,1));
		assertFalse(pc0.select(1,1));
		assertFalse(pc0.select(2,2));
		assertTrue(pc0.select(2,1));
		
		assertFalse(pc4.select(1,2));
		assertFalse(pc4.select(0,0));
		assertFalse(pc4.select(2,2));
		assertFalse(pc4.select(2,0));
		assertTrue(pc4.select(0,2));
		
		assertFalse(pc8.select(0,0));
		assertFalse(pc8.select(0,1));
		assertFalse(pc8.select(0,2));
		assertFalse(pc8.select(2,1));
		assertFalse(pc8.select(2,0));
		assertTrue(pc8.select(1,1));
	}
	
	@Test
	public void test30Size5() {
		PathCheck pc = new PathCheck(5);
		assertFalse(pc.select(1,3));
		assertFalse(pc.select(0,0));
		assertFalse(pc.select(4,0));
		assertFalse(pc.select(1,1));
		assertFalse(pc.select(4,2));
		assertFalse(pc.select(2,1));
		assertFalse(pc.select(3,3));
		assertFalse(pc.select(3,0));
		assertFalse(pc.select(3,2));
		assertFalse(pc.select(2,4));
		assertFalse(pc.select(0,2));
		assertFalse(pc.select(1,2));
		assertTrue(pc.select(2,3));
	}
	
	@Test
	public void test20SizeLarge() {
		final int SIZE = 10001;  //ASSUMED TO BE ODD
		PathCheck pc = new PathCheck(SIZE);
		
		// FILL IN CHECKERBOARD PATTERN
		for(int row = 0; row < SIZE; row++)
			for(int col = 0; col < SIZE; col++)
				if ((row + col) % 2 == 0)
					assertFalse(pc.select(row, col));
		
		// FILL IN SOME EMPTY CELLS ALONG DIAGONALS
		// CREATING X WITH CENTER MISSING
		for(int i = 0; i < SIZE/2-2; i++) {
			assertFalse(pc.select(i, i+1));
			assertFalse(pc.select(i, SIZE-(i+1)));
			assertFalse(pc.select(SIZE-(i+1), i+1));
			assertFalse(pc.select(SIZE-(i+1), SIZE-(i+1)));
		}
		
		// NOW FILL IN A COLUMN CONNECTING TOP LEFT OF X
		// TO BOTTOM LEFT OF X
		int start = SIZE / 3;
		int end = SIZE - 1 - start;
		for(int i = start+1; i < end-1; i += 2)
			assertFalse(pc.select(i, start));
		assertTrue(pc.select(end-1, start));
	}
}
