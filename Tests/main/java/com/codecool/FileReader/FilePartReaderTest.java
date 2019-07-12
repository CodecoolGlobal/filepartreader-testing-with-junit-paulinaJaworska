package main.java.com.codecool.FileReader;

import com.codecool.FileReader.FilePartReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader fr = new FilePartReader();

    @Test
    public void testAllCorrectArgumentsDoesNotThrowException() {
        String fakeFilePath = "src/resources/test.txt";
        assertDoesNotThrow(() -> {
            fr.setup(fakeFilePath, 3, 10);
        });
    }

 /*   @Test
    public void testIsIncorrectFilePathFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fr.setup(1,1,3);
        });
    }

    @Test
    public void testIsIncorrectFromLineFormatThrowsException() {
        String fakeFilePath = "src/resources/test.txt";
        assertThrows(IllegalArgumentException.class, () -> {
            fr.setup(fakeFilePath, "1", 5);
        });
    }

    @Test
    public void testIsIncorrectToLineFormatThrowsException() {
        String fakeFilePath = "src/resources/test.txt";
        assertThrows(IllegalArgumentException.class, ()-> {
            fr.setup(fakeFilePath, 3, 15.2);
        });
    }*/

    @Test
    public void testIsToLineSmallerThanFromLineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fr.setup("src/resources/test.txt", 15, 2);
        });
    }

    @Test
    public void testIsfromLineSmaller1ThowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fr.setup("src/resources/test.txt", 0, 5);
        });
    }

    @Test
    public void testIsReadThrowsException() {
        assertThrows(Exception.class, () -> {
            fr.read();
        });
    }

    @Test
    public void testIfReadsFile() throws Exception { // Should there be throws Exception?
        String testFileName = "/home/paulina/codecool/JAVA/filepartreader-testing-with-junit-paulinaJaworska/src/main/java/Resources/test.txt";
        fr.setup(testFileName, 1, 2);
        assertEquals("Test file.\n" +
                "kayak kayak", fr.read());
    }

    @Test
    public void testReadOnlyFirstLine() throws Exception {
        String testFileName = "/home/paulina/codecool/JAVA/filepartreader-testing-with-junit-paulinaJaworska/src/main/java/Resources/test.txt";
        fr.setup(testFileName, 1, 1);
        assertEquals("Test file. ", fr.readLines());
    }

    @Test
    public void testReadFirstAndSecondLine() throws Exception {
        String testFileName = "/home/paulina/codecool/JAVA/filepartreader-testing-with-junit-paulinaJaworska/src/main/java/Resources/test.txt";
        fr.setup(testFileName, 1, 2);
        assertEquals("Test file. kayak kayak ", fr.readLines());
    }

}