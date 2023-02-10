package edu.bsu.cs222;

import java.util.ArrayList;

public class RevisionFormatter extends RevisionParser{
    public ArrayList<String> revisionFormat (ArrayList<String> parsedUserList, ArrayList<String> parsedTimeStampList){
        ArrayList<String> revisionList = new ArrayList<>();
        for (int object = 0; object < parsedUserList.size(); object++){
            revisionList.add(parsedTimeStampList.get(object) + " " + parsedUserList.get(object) + "\n");
        } return revisionList;
    }
}
