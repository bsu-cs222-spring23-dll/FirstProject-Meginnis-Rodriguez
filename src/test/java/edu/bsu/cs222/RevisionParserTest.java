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


}
