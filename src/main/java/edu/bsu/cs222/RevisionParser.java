package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
public class RevisionParser {
    public Revision parse(InputStream testDataStream) throws IOException {
       JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
       String timeStamp = result.get(0).toString();
       return new Revision(timeStamp);
    }

}
