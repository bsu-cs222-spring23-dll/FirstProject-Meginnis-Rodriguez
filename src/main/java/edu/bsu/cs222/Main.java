package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        try {
            String userRequestedArticle;
            InputStream accounts;
            InputStream timeStamps;

            userRequestedArticle = userPrompt();
            accounts = articleAccounts(userRequestedArticle);
            timeStamps = articleTimeStamps(userRequestedArticle);
            articleRevisionsPrepForFormat(accounts, timeStamps);
        } catch (RuntimeException networkError) {
            System.err.println("Network Error:" + " " + networkError.getMessage());
            System.exit(0);
        }
    }
    private static String userPrompt () {
        String requestedArticle;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What article would you like to search for?");
        requestedArticle = keyboard.nextLine();
        requestedArticle = ArticleRequest.articleSearch(requestedArticle); // validate the user input using ArticleRequest
        return requestedArticle;
    }

    private static InputStream articleAccounts (String requestedArticle){
        Article userArticle = new Article();
        String encodedAccountURL = Article.generateArticleURL(requestedArticle);
        return userArticle.connectArticleURL(encodedAccountURL);
    }

     private static InputStream articleTimeStamps (String requestedArticle){
        Article userArticle = new Article();
        String encodedTimeStampURL = Article.generateArticleURL(requestedArticle);
        return userArticle.connectArticleURL(encodedTimeStampURL);
    }

    private static void articleRevisionsPrepForFormat (InputStream accounts, InputStream timeStamps) throws IOException {
        RevisionFormatter formatter = new RevisionFormatter();
        ArrayList<String> accountsList = formatter.parseAccountData(accounts);
        ArrayList<String> timestampsList = formatter.parseTimeStampData(timeStamps);
        ArrayList<String> finalList;
        finalList = formatter.revisionFormat(accountsList, timestampsList);
        for (String s : finalList) {
            System.out.println(s);
        }

    }

}
