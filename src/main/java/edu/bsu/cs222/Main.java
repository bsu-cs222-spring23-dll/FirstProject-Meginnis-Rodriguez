package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Main extends Application {
    static Scanner keyboard = new Scanner(System.in);
    private TextField urlField;
    private TextArea revisionsArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label urlLabel = new Label("What article would you like to search for?:");
        urlField = new TextField();
        Button fetchButton = new Button("Get Revision Data");
        fetchButton.setOnAction(e -> getRevisions());
        revisionsArea = new TextArea();

        VBox root = new VBox(5, urlLabel, urlField, fetchButton, revisionsArea);
        root.setPadding(new Insets(5));

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Wikipedia Article Revision Display");
        primaryStage.show();
    }

    private void getRevisions() {
        try {
            String url = urlField.getText();
            String userRequestedArticle = ArticleRequest.articleSearch(url);
            InputStream accounts = articleAccounts(userRequestedArticle);
            InputStream timeStamps = articleTimeStamps(userRequestedArticle);

            ArrayList<String> finalList = articleRevisionsPrepForFormat(accounts, timeStamps);
            if (finalList.isEmpty()) {
                revisionsArea.setText("No page found.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String s : finalList) {
                    sb.append(s).append('\n');
                }
                revisionsArea.setText(sb.toString());
            }
        } catch (IllegalArgumentException e) {
            revisionsArea.setText(e.getMessage());
        } catch (IOException | RuntimeException networkError) {
            if (networkError.getMessage().equals("No page found.")) {
                revisionsArea.setText("No page found.");
            } else {
                revisionsArea.setText("Network Error: " + networkError.getMessage());
            }
        }
    }

    private static void oldConsoleMethod() throws IOException {
        try {
            String userRequestedArticle = userPrompt();
            InputStream accounts = articleAccounts(userRequestedArticle);
            InputStream timeStamps = articleTimeStamps(userRequestedArticle);
            ArrayList<String> finalList = articleRevisionsPrepForFormat(accounts, timeStamps);
            if (finalList.isEmpty()) {
                throw new RuntimeException("No page found.");
            }
            for (String s : finalList) {
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        } catch (RuntimeException networkError) {
            if (networkError.getMessage().equals("No page found.")) {
                System.err.println("No page found.");
            } else {
                System.err.println("Network Error: " + networkError.getMessage());
            }
            System.exit(0);
        }
    }

    private static String userPrompt () {
        String requestedArticle;
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

    private static ArrayList<String> articleRevisionsPrepForFormat (InputStream accounts, InputStream timeStamps) throws IOException {
        RevisionFormatter formatter = new RevisionFormatter();
        ArrayList<String> accountsList = formatter.parseAccountData(accounts);
        ArrayList<String> timestampsList = formatter.parseTimeStampData(timeStamps);
        ArrayList<String> finalList;
        finalList = formatter.revisionFormat(accountsList, timestampsList);
        return finalList;
    }
}
