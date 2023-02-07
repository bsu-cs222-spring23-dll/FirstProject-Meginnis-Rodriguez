package edu.bsu.cs222;

public class Revision {
    private static String timeStamp;

    public Revision(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static String getTimeStamp() {
        return timeStamp;
    }
}
