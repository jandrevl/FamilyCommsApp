package com.jandrevl.familycomms;

public class FamCommUser {

    private String username;

    public FamCommUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "FamCommUser{" +
                "username='" + username + '\'' +
                '}';
    }
}
