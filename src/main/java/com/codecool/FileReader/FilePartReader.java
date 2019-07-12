package com.codecool.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public FilePartReader get() {
        return this;
    }

    /**
     * Check if arguments are correct and throws and exceptions otherwise.
     * Check especially if toLine is smaller than fromLine and if fromLine is smaller than 1.
     *
     * @param filePath absolute or relativa path of a file location
     * @param fromLine line to start reading from
     * @param toLine   last line to be read
     * @throws IllegalArgumentException If an argument is incorrect
     */
    public void setup(String filePath, Integer fromLine, Integer toLine)
            throws IllegalArgumentException {

        if ((toLine < fromLine)) {
            throw new IllegalArgumentException("FromLine should be smaller than toLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("FromLine should be bigger than 1");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }


    /**
     * Opens the file on filePath , and gives back it's content as a String
     * it doesn't catch the exception being raised, if the file isn't present on filePath ,
     * so actually the method throws the exception it received
     *
     * @return data as a String
     */
    public String read() throws Exception {
        String data;

        data = new String(Files.readAllBytes(Paths.get(this.filePath)));
        // readAllBytes() method reads all the bytes from a file.
        // The method ensures that the file is closed when all bytes
        // have been read or an I/O error, or other runtime exception,
        // is thrown.

        return data;
    }


    /**
     * Reads the file with read (). it gives back every line from it's content
     * between fromLine and toLine (both of them are included), and returns these
     * lines as a String. Take care because if fromLine is 1, it means the very
     * first row in the file. Also, if fromLine is 1 and toLine is 1 also, we
     * will read only the very first line.
     *
     * @return data as a String
     */
    public String readLines() {
        String filePart = "";
        int lineNumber;

        try {
            String data = this.read();
            String[] lines = data.split(System.lineSeparator());
            for (lineNumber = this.fromLine - 1; lineNumber <= this.toLine - 1; lineNumber++) {
                filePart += lines[lineNumber] + " ";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Unknown IOException");
        } catch (Exception e) {
            System.out.println("Some error occurred");
            e.printStackTrace();
        }
        return filePart;
    }
}

/*
    //String data = "";
    int lineNumber;

        try {
                String data = this.read();
                FileReader fr = new FileReader(this.filePath);
                BufferedReader br = new BufferedReader(fr);
                for (lineNumber = 1; lineNumber <= this.toLine; lineNumber++) {
                if (lineNumber < this.fromLine) {
        br.readLine();
        } else {
        data += br.readLine();
        }
        }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        } catch (IOException e) {
        System.out.println("Unknown IOException");
        } catch (Exception e) {
        System.out.println("Some error occurred");
        e.printStackTrace();
        }
        return data;
        }
*/
