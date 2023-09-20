package ds2;

// Author: Charles Hanlon 10/20/2022
import java.util.*;
import algs4.*;
import ds2.A5BSTDepth;

public class A5Test {

    public static void main(String[] args) {
        StdIn.fromFile("data/tale.txt");
        String words[] = StdIn.readAllStrings();

        StdOut.println("Average depths on words in text order: " + textOrder(words));
        StdOut.println("Average depths on words in random order: " + randomOrder(words));
        StdOut.println("Average depths on words in ascending order: " + ascendingOrder(words));
    }

    public static double textOrder(String[] words) {
        A5BSTDepth<String, Integer> tree = new A5BSTDepth<>();
        List<String> list = Arrays.asList(words);
        for (String word : words) {
            int count = Collections.frequency(list, word);
            if (tree.get(word) == null) {
                tree.put(word, count);
            }
        }
        tree.assignDepths();

        return tree.averageDepth();
    }

    public static double randomOrder(String[] words) {
        A5BSTDepth<String, Integer> tree = new A5BSTDepth<>();
        List<String> list = Arrays.asList(words);
        Collections.shuffle(list);
        list.toArray(words);
        for (String word : words) {
            int count = Collections.frequency(list, word);
            if (tree.get(word) == null) {
                tree.put(word, count);
            }
        }
        tree.assignDepths();

        return tree.averageDepth();
    }

    public static double ascendingOrder(String[] words) {
        A5BSTDepth<String, Integer> tree = new A5BSTDepth<>();
        List<String> list = Arrays.asList(words);
        Collections.sort(list);
        list.toArray(words);
        for (String word : words) {
            int count = Collections.frequency(list, word);
            if (tree.get(word) == null) {
                tree.put(word, count);
            }
        }
        tree.assignDepths();

        return tree.averageDepth();
    }
}