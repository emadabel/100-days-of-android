package com.example.day12of100;

public class MyListData {
    private int imgId;
    private String description;

    public MyListData(int imgId, String description) {
        this.imgId = imgId;
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
