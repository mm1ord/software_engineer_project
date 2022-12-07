package com.douyin.zhibo;

import java.util.List;

public class UserObserver extends Observer {
    public User user;
    public UserObserver(User user, Session session) {
        this.user = user;
        this.session = session;
    }
    @Override
    public void update() {
        List<String> list = session.getHistory();
        System.out.printf("%s 已收到消息: %s%n", user.getUserName(), list.get(list.size() - 1));
    }

    @Override
    public void update2() {
        List<String> list = session.getHistory();
        System.out.printf("%s 已收到礼物: %s%n", user.getUserName(), list.get(list.size() - 1));
    }
}
