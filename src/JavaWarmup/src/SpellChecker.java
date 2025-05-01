/*
Name: Steven Marco Navarrette
Assignment: Java Warmup Exercise 2
Date: 2/12/2025
*/

import java.io.*;
import java.util.*;

public class SpellChecker {
    //declaring the dictionary
    private final Set<String> dictionary;

    //makes the dictionary into a hash set
    //loads the dictionary from the file
    public SpellChecker(String dictionaryFile) throws IOException {
        dictionary = new HashSet<>();
        try (BufferedReader read = new BufferedReader(new FileReader(dictionaryFile))) {
            String word;
            while ((word = read.readLine()) != null) {
                //to make the words normal
                dictionary.add(word.trim().toLowerCase());
            }
        }
    }

    //reads the word from the file using buffered reader
    //removes any capitals or other characters when read
    //checks if the word is spelled right
    public void checkFile(String inputFile) throws IOException {
        try (BufferedReader read = new BufferedReader(new FileReader(inputFile))) {
            String word;
            while ((word = read.readLine()) != null) {
                word = word.trim().toLowerCase().replaceAll("[^a-z]", "");
                if (!dictionary.contains(word)) {
                    System.out.println("Misspelled words: " + word);
                }
            }
        }
    }

    //main method that tests the spell checker
    //creates object of spell checker which is the dictionary file
    //if the input file is found the program runs
    //if not, the error is handled
    public static void main(String[] args) {
        try {
            SpellChecker spellCheck = new SpellChecker("dictionary (1).txt");
            spellCheck.checkFile("inputWords.txt");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
