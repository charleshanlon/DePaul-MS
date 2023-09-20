package week2;

import edu.princeton.cs.algs4.StdOut;

public class UseRobot {
	public static void main(String[] args) {
		
		Robot r1 = new Robot("red");
		r1.move(5);
		r1.turnRight();
		r1.move(2);
		r1.turnLeft();
		StdOut.println(r1);  // red @ (2,5) facing up

		Robot r2 = new Robot("blue");
		r2.turnLeft();
		r2.move(1);
		r2.turnLeft();
		r2.move(3);
		r2.turnLeft();
		StdOut.println(r2);  // blue @ (-1, -3) facing right.
		
		r1.turnLeft();  // red: (2,5) facing left
		r1.move(10);    // red: (-8,5) facing left
		
		r2.turnRight(); // blue: (-1,-3) facing down
		r2.move(2);     // blue: (-1,-5) facing down
		r2.turnRight(); // blue: (-1,-5) facing left
		
		//Display r1 info to screen:  red: (-8,5) facing left
		StdOut.println(r1);
				
		//Display r2 info to screen:  blue: (-1,-5) facing left
		StdOut.println(r2);
	}
}
