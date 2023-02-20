package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParserTest {

    @Test
    public void AccountParserTest() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream wikipediaData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> OutputtedListOfParsedAccounts = parser.parseAccountData(wikipediaData);
        Assertions.assertEquals("InternetArchiveBot", OutputtedListOfParsedAccounts.get(0));
    }

    @Test
    public void TimeStampParserTest() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream wikipediaData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        ArrayList<String> OutputtedListOfParsedTimeStamps = parser.parseTimeStampData(wikipediaData);
        Assertions.assertEquals("2023-01-30T20:20:13Z", OutputtedListOfParsedTimeStamps.get(0));
    }

}
