package com.douyin.zhibo;

public class audience extends UserImpl {
    public audience(String name) {
        super(name);
        this.id = 1;
    }

    @Override
    public void run() {
        System.out.println("创建观众");
    }
}
