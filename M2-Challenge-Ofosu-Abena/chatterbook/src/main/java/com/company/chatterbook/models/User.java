package com.company.chatterbook.models;

import java.util.List;


public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }


    //getters and setters
    public void setName() {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }


}
