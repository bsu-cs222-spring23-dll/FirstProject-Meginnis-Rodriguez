package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class ArticleTest {

    @Test
    public void createArticleURL(){
        final URL url = new URL();
        final String articleTitle = "Frank Zappa";
        final String searchOutput = url.createArticleURL(articleTitle);
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27", searchOutput);
    }
}
