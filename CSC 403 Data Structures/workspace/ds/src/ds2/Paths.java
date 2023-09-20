package ds2;

// Charles Hanlon
import algs4.*;
import myalgs4.*;

public class Paths {
    public static void main(String[] args) {
        StdOut.println("Charles Hanlon***");
        int s = 1;

        In in = new In("data/KBGraph.txt");
        Graph g = new Graph(in);

        DepthFirstPaths dfp = new DepthFirstPaths(g, s);

        StdOut.println("Vertex v        Path from 1 to vertex v");
        for (int v = 0; v < g.V(); v++) {
            if (dfp.hasPathTo(v)) {
                StdOut.print(v + "\t\t");
                for (int x : dfp.pathTo(v)) {
                    if (x == s)
                        StdOut.print(x);
                    else
                        StdOut.print("->" + x);
                }
                StdOut.println();
            }
        }
    }
}
