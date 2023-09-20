package ds2;

// Charles Hanlon
import algs4.*;
import myalgs4.*;
import java.util.Random;

public class Connected {
    public static void main(String[] args) {
        StdOut.println("Charles Hanlon***");
        int n = 50;
        Random rand = new Random();
        Graph g = new Graph(n);
        while (connected(g, g.V()) == false && n <= 400) {
            int edgeCount = 0;
            for (int i = 0; i < 500; i++) {
                int v = rand.nextInt(n);
                int u = rand.nextInt(n);
                g.addEdge(v, u);
                edgeCount++;
            }
            StdOut.println(g);
            StdOut.println("Edge Count: " + edgeCount);
            n *= 2;
            g = new Graph(n);
        }
    }

    public static boolean connected(Graph g, int n) {
        for (int i = 0; i < n; i++) {
            if (g.degree(i) == 0) {
                return false;
            }
        }
        return true;
    }

}
