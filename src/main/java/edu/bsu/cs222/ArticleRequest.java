package edu.bsu.cs222;

public class ArticleRequest {
    public static String articleSearch(String articleSearchRequest) {
        if (articleSearchRequest.trim().equals("")) {
            System.err.println("Searched article contained no input, no page requested");
            System.exit(0);
        }
        return articleSearchRequest;
    }
}
