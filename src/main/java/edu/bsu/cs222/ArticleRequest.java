package edu.bsu.cs222;

public class ArticleRequest {

    public static String articleSearch(String articleSearchRequest) {
        if (articleSearchRequest.trim().equals("")) {
            throw new IllegalArgumentException("No page requested.");
        }
        return articleSearchRequest;
    }
}