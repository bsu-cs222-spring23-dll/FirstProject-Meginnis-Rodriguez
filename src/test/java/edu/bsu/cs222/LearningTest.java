package edu.bsu.cs222;

import java.io.*;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LearningTest {
    //adapted from https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    @Test
    public void testingFileForAuthorName() throws Exception {
        File file = new File("src/main/java/edu/bsu/cs222/Elizabeth_IIExampleFile");
        FileReader fileReader = new FileReader(file);

        String fileInString = "";
        int character;

        while((character = fileReader.read()) != -1) {
            fileInString = fileInString + (char)character;
        }

        System.out.println(fileInString);

        boolean result = fileInString.contains("Neveselbert");
        Assertions.assertTrue(result);
    }
}
