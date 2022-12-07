package com.douyin.friend;

import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;

public class Friend extends User implements Relationship,DataBaseAware<Integer, Friend> {
    
    private String tel;
    private String photo;

    private static AtomicInteger autoIncrement = new AtomicInteger(0);

    public Friend() {
        this.userId = autoIncrement.getAndIncrement();
    }
    
    public Friend(String username) {
        this.userId = autoIncrement.getAndIncrement();
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }
    public String getTel() {
        return tel;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public Integer getKey() {
        return this.userId;
    }
    
    public void add() {
    	System.out.println("添加好友");
    }
}