package edu.bsu.cs222;

import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Article {
    public String generateURL(String articleName){
        articleName = URLEncoder.encode(articleName, Charset.defaultCharset());
        return String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=27&redirects");
    }
}
