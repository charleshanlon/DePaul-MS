package week3;

import edu.princeton.cs.algs4.StdOut;

public class Example6 {
	public static void main(String[] args) {
		Counter[] A = new Counter[2];
		A[0] = new Counter();
		A[1] = new Counter();
		A[0].clickButton();
		StdOut.println("BEFORE");
		StdOut.printf("A[0].getCount() = %d\n",  A[0].getCount());
		Counter[] B = copyArray(A);
		StdOut.println("\nAFTER");
		StdOut.printf("A[0].getCount() = %d\n",  A[0].getCount());
		StdOut.printf("B[0].getCount() = %d\n",  B[0].getCount());
		StdOut.println("\nCalling B[0].clickButtion()");
		B[0].clickButton();
		StdOut.printf("A[0].getCount() = %d\n",  A[0].getCount());
		StdOut.printf("B[0].getCount() = %d\n",  B[0].getCount());
	}
	
	public static Counter[] copyArray(Counter[] A) {
		Counter[] answer = new Counter[A.length];
		for(int i = 0; i < A.length; i++) {
			answer[i] = A[i];
		}
		return answer;
	}
}
