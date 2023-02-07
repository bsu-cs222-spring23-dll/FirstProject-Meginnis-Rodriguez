package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;
public class RevisionReader {

    public static void main(String[] args) {
            RevisionReader revisionReader = new RevisionReader();
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            try {
                String timestamp = String.valueOf(revisionReader.getLatestRevisionOf(line));
                System.out.println(timestamp);
            } catch (IOException ioException) {
                System.err.println("Network connection problem: " + ioException.getMessage());
            }
    }

    private Revision getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=4&redirects", articleTitle);
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "RevisionReader/0.1 (bgmeginnis@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            RevisionParser parser = new RevisionParser();
            Revision timeStamp = parser.parse(inputStream);
            return timeStamp;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
}
