package com.douyin.zhibo;

public class Administrator extends UserImpl {
    public Administrator(String name) {
        super(name);
        this.id = 3;
    }

    @Override
    public void run() {
        System.out.println("创建管理员");
    }
}
