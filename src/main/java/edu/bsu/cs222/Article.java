package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Article {
    public static String generateArticleURL(String articleName) {
        articleName = URLEncoder.encode(articleName, Charset.defaultCharset());
        return String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=27&redirects", articleName);
    }

    public InputStream connectArticleURL(String urlText) {
        try {
            java.net.URL articleURL = new java.net.URL(urlText);
            URLConnection connection = articleURL.openConnection();
            connection.setRequestProperty("Beethoven-Meginnis",
                    "Revision Reporter/0.1 (bgmeginnis@bsu.edu)");
            return connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}