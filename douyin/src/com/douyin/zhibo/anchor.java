package com.douyin.zhibo;

public class anchor extends UserImpl{
    public anchor(String name) {
        super(name);
        this.id = 2;
    }

    @Override
    public void run() {
        System.out.println("创建主播");
    }
}
