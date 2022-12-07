package com.douyin.zhibo;

import java.util.List;

public class SessionFactory {
    public Session createSession(User user) {
        IndividualSession session = new IndividualSession();
        UserObserver observer = new UserObserver(user, session);
        session.attach(observer);
        return session;
    }

    public Session createSession(List<User> users) {
        GroupSession session = new GroupSession();
        for(User user: users) {
            UserObserver observer = new UserObserver(user, session);
            session.attach(observer);
        }
        return session;
    }
}
