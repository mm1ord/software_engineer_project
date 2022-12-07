package com.douyin.friend;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;

public class Group implements Relationship,DataBaseAware<Integer, Group> {
    private List<User> userList;
    private Integer groupId;

    private static AtomicInteger autoIncrement = new AtomicInteger(0);

    public Group() {
        this.groupId = autoIncrement.incrementAndGet();
    }

    public List<User> getUserList() {
        return userList;
    }

    public Integer getGroupId() {
        return groupId;
    }
    
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public Integer getKey() {
        return groupId;
    }
    
    public void add() {
    	System.out.println("添加群聊");
    }
}