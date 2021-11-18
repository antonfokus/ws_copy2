package com.learn.wearexample1.model;

public class ListItemModel {
    private final int id;
    private String title;

    public ListItemModel(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
