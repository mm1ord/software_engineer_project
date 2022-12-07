package com.douyin.zhibo;

public class UserFactory {
    public static User createPeople(String type, String name) {
        if ("audience".equals(type)) {
           return new audience(name);
        } else if ("anchor".equals(type)) {
            return new anchor(name);
        } else if ("Administrator".equals(type)) {
            return new Administrator(name);
        } else {
            return null;
        }
    }
}
