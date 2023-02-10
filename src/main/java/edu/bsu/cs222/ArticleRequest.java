package edu.bsu.cs222;

public class ArticleRequest {
    public static String articleSearch(String articleSearchRequest) {
        if (articleSearchRequest.trim().equals("")) {
            System.err.println("Search for article contained no input");
            System.exit(0);
        }
        return articleSearchRequest;
    }
}
