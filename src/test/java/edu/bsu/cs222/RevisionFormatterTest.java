package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class RevisionFormatterTest {

    @Test
    public void FormatRevisionsInList() {
        ArrayList<String> accountsList = new ArrayList<>();
        ArrayList<String> timeStampsList = new ArrayList<>();

        accountsList.add("John Doe");
        timeStampsList.add("2024-02-02T15:01:53Z");
        accountsList.add("Jane Doe");
        timeStampsList.add("2023-02-03T03:42:20Z");
        accountsList.add("Doe Doe");
        timeStampsList.add("2022-04-08T09:22:30Z");

        ArrayList<String> predictedList = new ArrayList<>();
        predictedList.add("2024-02-02T15:01:53Z John Doe\n");
        predictedList.add("2023-02-03T03:42:20Z Jane Doe\n");
        predictedList.add("2022-04-08T09:22:30Z Doe Doe\n");

        RevisionFormatter formatter = new RevisionFormatter();
        ArrayList<String> output = formatter.revisionFormat(accountsList, timeStampsList);
        Assertions.assertEquals(predictedList, output);
    }
}
