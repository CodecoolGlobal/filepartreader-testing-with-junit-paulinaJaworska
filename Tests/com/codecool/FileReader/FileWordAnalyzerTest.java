package com.codecool.FileReader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FilePartReader reader = new FilePartReader();
    String testFilePath = "/home/paulina/codecool/JAVA/filepartreader-testing-with-junit-paulinaJaworska/src/main/java/Resources/test.txt";

    @Test
    public void TestGetWordsOrderedAlphabetically() {
        reader.setup(testFilePath, 1, 1);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        ArrayList expected = new ArrayList();
        expected.add("file");
        expected.add("test");

        assertEquals(expected, analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void TestGetWordsContainingSubstring() {
        reader.setup(testFilePath, 1, 1);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        ArrayList expected = new ArrayList();
        expected.add("test");
        assertEquals(expected, analyzer.getWordsContainingSubstring("est"));
    }

    @Test
    public void TestGetStringsWhichPalindromes() {
        reader.setup(testFilePath, 1, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        ArrayList expected = new ArrayList();
        expected.add("kayak");
        expected.add("kayak");

        assertEquals(expected, analyzer.getStringsWhichPalindromes());
    }

}