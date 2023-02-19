package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleRequestTest {

    @Test
    public void InputtedArticleRequestTest() {
        String userInput = "Frank Zappa";
        String output = ArticleRequest.articleSearch(userInput);
        Assertions.assertEquals(userInput, output);
    }

    @Test
    public void ErrorTest() {
        String userInput = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArticleRequest.articleSearch(userInput);
        });
        String expectedMessage = "No page requested";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
