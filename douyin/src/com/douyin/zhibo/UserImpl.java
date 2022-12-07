package com.douyin.zhibo;

public class UserImpl implements User{
    public String name;
    public Integer id = 0; // 0 为默认值 1为观众 2为主播 3为管理员

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }

    @Override
    public String getUserName() {
        return name;
    }
}
