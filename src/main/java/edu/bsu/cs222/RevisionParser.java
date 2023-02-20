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
/***
    public ArrayList<String> parseRedirectData(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..redirects");
        ArrayList<String> ListOfParsedRedirects = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            ListOfParsedRedirects.add(result.get(i).toString());
        }
        return ListOfParsedRedirects;
    }
***/
    public boolean detectNoPageFound(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..missing");
        return result.size() != 0;
    }

    public void parseNoPageFound(InputStream wikipediaData) throws IOException {
        if (detectNoPageFound(wikipediaData)) {
            System.err.println("Page does not exist");
            System.exit(0);
        }
    }

    public boolean detectRedirect(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..to");
        return result.size() != 0;
    }
    public ArrayList<String> parseRedirect(InputStream wikipediaData) throws IOException {
        JSONArray result = JsonPath.read(wikipediaData, "$..to");
        ArrayList<String> parsedRedirect = new ArrayList<>();
        if (detectRedirect(wikipediaData)) {
            parsedRedirect.add(result.get(0).toString());
            return parsedRedirect;
        } return null;
    }


}