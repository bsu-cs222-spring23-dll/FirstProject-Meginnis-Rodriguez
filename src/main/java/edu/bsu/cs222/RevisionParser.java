package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {
    public Revision parse(InputStream testDataStream) throws IOException {
       JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
       String timeStamp = result.get(0).toString();
       return new Revision(timeStamp);
    }

    public ArrayList<String> parseAccount(InputStream wikipediaData) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(wikipediaData, "$..user");
        ArrayList<String> parsedAccounts = new ArrayList<>();
        for (int i = 0; i < result.toArray().length; i++)
        {
            parsedAccounts.add(result.get(i).toString());
        }
        return parsedAccounts;
    }


}
