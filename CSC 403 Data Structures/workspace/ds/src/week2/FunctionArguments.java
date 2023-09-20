package week2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class FunctionArguments {
	public static void main(String[] args) {
		int main_i = 5;
		int[] main_A = {1,2,3};
		int[] main_B = {4,5,6};
		FunctionArguments obj = new FunctionArguments();
		StdOut.println("main_i = " + main_i);
		StdOut.println("main_A = " + Arrays.toString(main_A));
		StdOut.println("main_B = " + Arrays.toString(main_B));
		
		obj.fun(main_i, main_A, main_B);
		
		StdOut.println("main_i = " + main_i);
		StdOut.println("main_A = " + Arrays.toString(main_A));
		StdOut.println("main_B = " + Arrays.toString(main_B));
	}
	
	public void fun(int fun_i, int[] fun_A, int[] fun_B) {
		int[] local = {400, 500, 600};
		fun_i = 100;
		fun_A[1] = 200;
		fun_B = local;
	}
}
