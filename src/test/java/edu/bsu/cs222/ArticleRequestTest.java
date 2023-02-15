package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleRequestTest {

    @Test
    public void InputtedArticleRequestTest() {
        String userInput = "Frank Zappa";
        String output = ArticleRequest.articleSearch(userInput);
        Assertions.assertEquals(userInput, output);
    }
    @Test
    public void NoInputArticleRequestedTest() {
        String userInput = "";
        String output = ArticleRequest.articleSearch(userInput);
        Assertions.assertEquals(userInput, output);
    }
}
