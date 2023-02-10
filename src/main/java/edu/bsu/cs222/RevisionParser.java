package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {

    public ArrayList<String> parseAccount(InputStream wikipediaData) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(wikipediaData, "$..user");
        ArrayList<String> parsedAccounts = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            parsedAccounts.add(result.get(i).toString());
        }
        return parsedAccounts;
    }

    public ArrayList<String> parseTimeStamp(InputStream wikipediaData) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(wikipediaData, "$..timestamp");
        ArrayList<String> parsedTimestamps = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            parsedTimestamps.add(result.get(i).toString());
        }
        return parsedTimestamps;
    }

    public ArrayList<String> parseRedirect(InputStream wikipediaData) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(wikipediaData, "$..redirects");
        ArrayList<String> parsedRedirects = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            parsedRedirects.add(result.get(i).toString());
        }
        return parsedRedirects;
    }
}
