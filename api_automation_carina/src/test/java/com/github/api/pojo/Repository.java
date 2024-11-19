package com.github.api.pojo;

public class Repository {
    private String name;
    private String description;
    private boolean isPrivate;

    public Repository(String name, String description, boolean isPrivate) {
        this.name = name;
        this.description = description;
        this.isPrivate = isPrivate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
