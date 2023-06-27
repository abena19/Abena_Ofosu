package com.company.chatterbook.models;


public class ChatterPost {
    //create text property
    private String text;
    public ChatterPost(String text) {
        this.text = text;
    }


    // getter and setter methods
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
       return text;
    }
}
