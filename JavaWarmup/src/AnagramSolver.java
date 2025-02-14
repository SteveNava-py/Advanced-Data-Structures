/*
Name: Steven Marco Navarrette
Assignment: Java Warmup Exercise 1
Date: 2/12/2025
*/

import java.io.*;
import java.util.*;

public class AnagramSolver {
    //converting anagram dictionary text file to variable of type string
    private static final String DICTIONARY = "anagram_dictionary (1).txt";
    //declaring anagram map with key value pairs being a string and list of strings
    private final Map<String, List<String>> anagramMap;

    //anagram solving method
    public AnagramSolver() {
        //make the anagram map a hash map
        anagramMap = new HashMap<>();
        //invoke the load dictionary method
        loadDictionary();
    }

    //method that loads the dictionary file
    //if it is not read, the error is handled
    private void loadDictionary() {
        try (BufferedReader buffread = new BufferedReader(new FileReader(DICTIONARY))) {
            String word;
            while ((word = buffread.readLine()) != null) {
                word = word.trim().toLowerCase();
                String sortedKey = sortString(word);
                anagramMap.computeIfAbsent(sortedKey, _ -> new ArrayList<>()).add(word);
            }
        } catch (IOException e) {
            System.out.println("Error reading dictionary file: " + e.getMessage());
        }
    }

    //method that sorts the strings in the list
    private String sortString(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    //method that finds the anagrams based on the users input from the main
    public void findAnagrams(String input) {
        String sortKey = sortString(input.toLowerCase());
        List<String> anagram = anagramMap.getOrDefault(sortKey, new ArrayList<>());

        if (anagram.isEmpty() || (anagram.size() == 1 && anagram.contains(input.toLowerCase()))) {
            System.out.println("No anagrams found for: " + input);
        } else {
            System.out.println("Anagrams for " + input + ": " + anagram);
        }
    }

    //main method
    //create solver object of anagram solver
    //create scan object of scanner
    //takes input from user and trims it and passes it through methods
    //closes the scanner when done
    public static void main(String[] args) {
        AnagramSolver solve = new AnagramSolver();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = scan.nextLine().trim();
        solve.findAnagrams(input);

        scan.close();
    }
}