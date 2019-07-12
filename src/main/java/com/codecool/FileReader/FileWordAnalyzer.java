package com.codecool.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileWordAnalyzer {

    FilePartReader reader = new FilePartReader();

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }


    /**
     * calls FilePartReader.readLines ()
     * returns the words ordered by alphabetically as an ArrayList
     *
     * @return ArrayList of words in alphabetical order
     */
    public List getWordsOrderedAlphabetically() {
        List<String> words = new ArrayList<>();

        String data = reader.readLines();

        String[] wordToClean = data.split(" ");
        for (String word : wordToClean) {
            words.add(word.replace(".", "").replace(",", "").trim().toLowerCase());
        }

        Collections.sort(words);

        return words;
    }


    /**
     * calls FilePartReader.readLines ()
     * returns the words which contains the subString
     *
     * @param subString cluster of letter to find
     * @return ArrayList of words containing substring
     */
    public List getWordsContainingSubstring(String subString) {
        List<String> words = new ArrayList<>();
        List<String> wordsContainingSubstring = new ArrayList<>();

        String data = reader.readLines();

        String[] wordToClean = data.split(" ");
        for (String word : wordToClean) {
            words.add(word.replace(".", "").replace(",", "").trim().toLowerCase());
        }

        for (String word : words) {
            if (word.contains(subString)) {
                wordsContainingSubstring.add(word);
            }

        }
        return wordsContainingSubstring;
    }


    /**
     * calls FilePartReader.readLines ()
     * returns the words from the String which are palindrome
     *
     * @return ArrayList of palindromes
     */
    public List getStringsWhichPalindromes() {
        List<String> words = new ArrayList<>();
        List<String> palindromes = new ArrayList<>();

        String data = reader.readLines();

        String[] wordsToClean = data.split(" ");
        for (String word : wordsToClean) {
            words.add(word.replace(".", "").replace(",", "").trim().toLowerCase());
        }

        for (String singleWord : words) {
            if (isPalindrome(singleWord)) {
                palindromes.add(singleWord);

            }
        }

        return palindromes;
    }


    private boolean isPalindrome(String word) {

        // return str.equals(new StringBuilder(str).reverse().toString());

        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        return word.equals(reversedWord);
    }
}

