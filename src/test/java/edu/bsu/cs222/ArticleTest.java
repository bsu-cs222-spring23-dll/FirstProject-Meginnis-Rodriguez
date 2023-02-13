package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    @Test
    public void generateArticleURL(){
        String articleTitle = "Frank Zappa";
        String searchOutput = Article.generateArticleURL(articleTitle);
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank+Zappa&rvprop=timestamp|user&rvlimit=27&redirects", searchOutput);
    }
}
