package com.douyin.zhibo;

import java.util.List;

public interface Session {
    void sendMessage(String message);
    List<String> getHistory();
    void attach(UserObserver observer);
    void notifyAllObservers();

}
