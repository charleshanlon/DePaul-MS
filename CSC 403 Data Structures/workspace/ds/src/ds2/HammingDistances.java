package ds2;

// Charles Hanlon 2022

import algs4.*;
import myalgs4.*;

public class HammingDistances {
    public static void main(String[] args) {
        // Print a line with your first and last names followed by three asterisks.
        StdOut.println("Charles Hanlon***");

        BSTEssential<String, String> speciesDNA = new BSTEssential<>();
        BSTEssential<String, BSTEssential<String, Double>> speciesTable = new BSTEssential<>();

        StdIn.fromFile("data/largesequences.txt");
        while (!StdIn.isEmpty()) {
            String lines = StdIn.readLine();
            String[] speciesDnaSplit = lines.split("\\t");
            speciesDNA.put(speciesDnaSplit[0], speciesDnaSplit[1]);
        }

        for (String species1 : speciesDNA.keys()) {
            for (String species2 : speciesDNA.keys()) {
                if (!speciesTable.contains(species1)) {
                    speciesTable.put(species1, new BSTEssential<String, Double>());
                }
                int count = 0;
                int i = 0;
                while (i < speciesDNA.get(species1).length()) {
                    if (speciesDNA.get(species1).charAt(i) != speciesDNA.get(species2).charAt(i)) {
                        count++;
                    }
                    i++;
                }
                speciesTable.get(species1).put(species2, (1.0 * count) / speciesDNA.get(species1).length());
            }
        }

        StdOut.println(speciesDNA.size());
        for (String species1 : speciesTable.keys()) {
            StdOut.printf("%-28s\t", species1);
            for (String species2 : speciesTable.get(species1).keys()) {
                StdOut.printf("%5.4f ", speciesTable.get(species1).get(species2));
            }
            StdOut.println();
        }
    }

}
