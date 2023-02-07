package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {

    @Test
    public void testParse() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Revision revision = parser.parse(testDataStream);
        String TimeStamp = Revision.getTimeStamp();
        Assertions.assertEquals("2023-01-30T20:20:13Z", TimeStamp);
    }
}
