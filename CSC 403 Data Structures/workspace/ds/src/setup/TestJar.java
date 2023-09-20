package setup;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;

import org.junit.Test;


import edu.princeton.cs.algs4.*;

public class TestJar {

	@Test
	public void testBag() {
		Bag<String> b = new Bag<String>();
		b.add("hello");
		assertEquals(1, b.size());
		for (String s : b) {
			assertEquals("hello", s);
		}
	}

	@Test
	public void testStack() {
		Stack<String> s = new Stack<String>();
		s.push("hello");
		assertEquals(1, s.size());
		assertEquals("hello", s.pop());
	}

	@Test
	public void testGraphics() {
		StdDraw.setCanvasSize(601, 601);
		StdDraw.setScale(-300,300);
		StdDraw.clear(Color.BLACK);
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledCircle(0,0,250);
		Font font = new Font("Arial", Font.BOLD, 60);
		StdDraw.setFont(font);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0, 0, "Passed");
		StdDraw.pause(4000);
	}
}
