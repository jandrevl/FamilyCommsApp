package com.jandrevl.familycomms;

public class UserItemData {
    private String usernameItem;
    private int imgld;

    public UserItemData(String usernameItem, int imgld) {
        this.usernameItem = usernameItem;
        this.imgld = imgld;
    }

    public String getUsernameItem() {
        return usernameItem;
    }

    public void setUsernameItem(String usernameItem) {
        this.usernameItem = usernameItem;
    }

    public int getImgld() {
        return imgld;
    }

    public void setImgld(int imgld) {
        this.imgld = imgld;
    }
}
