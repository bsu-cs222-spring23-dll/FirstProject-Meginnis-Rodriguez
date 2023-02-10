package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        String userRequestedArticle;
        InputStream accounts;
        InputStream timeStamps;
        userRequestedArticle = userPrompt();
        accounts = articleAccounts(userRequestedArticle);
        timeStamps = articleTimeStamps(userRequestedArticle);
        ArticleAccountsPrepForFormat(accounts, timeStamps);
    }

    private static String userPrompt() {
        String requestedArticle;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What article would you like to search for?");
        requestedArticle = keyboard.nextLine();
        return requestedArticle;
    }

    private static InputStream articleAccounts(String requestedArticle) {
        Article userArticle = new Article();
        String encodedAccountURL = userArticle.generateURL(requestedArticle);
        InputStream accountInputStream = userArticle.connectURL(encodedAccountURL);
        return accountInputStream;
    }

    private static InputStream articleTimeStamps(String requestedArticle) {
        Article userArticle = new Article();
        String encodedTimeStampURL = userArticle.generateURL(requestedArticle);
        InputStream timeStampInputStream = userArticle.connectURL(encodedTimeStampURL);
        return timeStampInputStream;
    }

    private static void ArticleAccountsPrepForFormat(InputStream accounts, InputStream timeStamps) throws IOException {
        RevisionFormatter formatter = new RevisionFormatter();
        ArrayList<String> accountsList = formatter.parseAccountData(accounts);
        ArrayList<String> timestampsList = formatter.parseTimeStampData(timeStamps);
        System.out.println(formatter.revisionFormat(accountsList, timestampsList));
    }

}
