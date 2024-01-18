package com.example.notes;

import com.google.firebase.Timestamp;

public class Note {

    private String title;
    private String content;
    Timestamp timeStamp;

    public Note(String title, String content, Timestamp timeStamp) {
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public Note() {

    }

    public void setTitle(String noteTitle) {
    }

    public void setContent(String noteContent) {
    }

    public void setTimeStamp(Timestamp now) {
    }

    public Timestamp timeStamp() {
        return null;
    }

    public int title() {
        return 0;
    }

    public Object content() {
        return null;
    }
}
