package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleRequestTest {

    @Test
    public void InputtedArticleRequestTest() {
        ArticleRequest articleRequest = new ArticleRequest();
        String userInput = "Frank Zappa";
        String output = articleRequest.articleSearch(userInput);
        Assertions.assertEquals(userInput, output);
    }
    @Test
    public void NoInputArticleRequestedTest() {
        ArticleRequest articleRequest = new ArticleRequest();
        String userInput = "";
        String output = articleRequest.articleSearch(userInput);
        Assertions.assertEquals(userInput, output);
    }
}
