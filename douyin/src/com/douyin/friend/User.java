package com.douyin.friend;

public abstract class User {
    protected String username;
    protected Integer userId;

    public Integer getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
