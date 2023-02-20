package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {

    public ArrayList<String> parseAccountData(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..user");
        ArrayList<String> ListOfParsedAccounts = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            ListOfParsedAccounts.add(result.get(i).toString());
        }
        return ListOfParsedAccounts;
    }

    public ArrayList<String> parseTimeStampData(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..timestamp");
        ArrayList<String> ListOfParsedTimestamps = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            ListOfParsedTimestamps.add(result.get(i).toString());
        }
        return ListOfParsedTimestamps;
    }
}