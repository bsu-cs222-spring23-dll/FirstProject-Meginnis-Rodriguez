package edu.bsu.cs222;

import java.io.InputStream;

public class ArticleRequest {
    public static String articleSearch(String articleSearchRequest) {
        if (articleSearchRequest.trim().equals("")) {
            System.err.println("No page requested");
            System.exit(0);
        }
        return articleSearchRequest;
    }
}