package ds2;

// Author: Charles Hanlon

import algs4.*;
import myalgs4.BSTEssential;
import java.io.*;

public class PlayChords {

    // pre-written method given for this assignment that plays audio using an array
    // of doubles (frequencies) as an argument
    public static void playChord(double... frequencies) {
        final int sliceCount = (int) (StdAudio.SAMPLE_RATE * 0.5);
        final double[] slices = new double[sliceCount + 1];
        for (int i = 0; i <= sliceCount; i++) {
            for (double frequency : frequencies) {
                slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
            }
            slices[i] /= frequencies.length;
        }
        StdAudio.play(slices);
    }

    public static void main(String[] args) {
    	
    	File file = new File(".");
    	for(String fileNames : file.list()) System.out.println(fileNames);

        StdOut.println("Charles Hanlon***"); // print name requirement

        BSTEssential<String, Double> tree = new BSTEssential<>(); // initialize symbol table class with keys of strings
                                                                  // and values of doubles

        StdIn.fromFile("data/notes_frequencies.txt");
        while (!StdIn.isEmpty()) { // loops until end of file
            String lines = StdIn.readLine(); // reads line by line
            String[] notes = lines.split("\\s"); // splits each line by empty space seperating notes and corresponding
                                                 // frequencies
            double freq = Double.parseDouble(notes[1]); // converts frequency value from string to double
            tree.put(notes[0], freq); // places data into symbol table with notes key and the frequency as value
        }

        StdIn.fromFile("data/chords.txt");
        String[] chords = StdIn.readAllLines(); // puts each line as an entry into an array of strings called chords
        for (String chord : chords) { // iterates through each line
            int ct = 0; // counter
            String[] chordSplit = chord.split(" "); // splits line into an array of strings where each value in the
                                                    // array is a single note
            double[] freqsToPlay = new double[chordSplit.length]; // decalres array of type double to store the
                                                                  // frequencies
            // System.out.println("Playing chord:"); // print 1/3
            for (String note : chordSplit) { // iterates through the individual notes
                freqsToPlay[ct] = tree.get(note); // looks up the frequency that corresponds to the current note and
                                                  // places that frequency into the array of doubles
                // System.out.println(note + " -> " + freqsToPlay[ct]); // USEFUL PRINT
                // STATEMENT TO SEE WHAT NOTE/FREQUENCY IS BEING PLAYED 2/3
                ct = ct + 1;
            }
            // System.out.println(""); // print 3/3
            playChord(freqsToPlay); // calls method with the array that we stored the frequencies in
        }
    }
}
