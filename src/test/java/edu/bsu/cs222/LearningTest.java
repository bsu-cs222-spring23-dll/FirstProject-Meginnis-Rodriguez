package edu.bsu.cs222;

import java.io.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LearningTest {
    //adapted from https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    @Test
    public void testingFileForAuthorName() {
        File file = new File("src/test/resources/Elizabeth_IIExampleFile");

        try (FileReader fileReader = new FileReader(file)) {

            StringBuilder fileInString = new StringBuilder();
            int character;

            while ((character = fileReader.read()) != -1) {
                fileInString.append((char) character);
            }

            System.out.println(fileInString);

            boolean result = fileInString.toString().contains("Neveselbert");
            Assertions.assertTrue(result);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file);
        }
    }
}
