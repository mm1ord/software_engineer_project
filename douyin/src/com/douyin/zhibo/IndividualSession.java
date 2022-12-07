package com.douyin.zhibo;

import java.util.ArrayList;
import java.util.List;

public class IndividualSession implements Session{

    private UserObserver observer;
    private List<String> history = new ArrayList<>();


    @Override
    public void sendMessage(String message) {
        history.add(message);
        System.out.printf("已发送礼物: %s%n", message);
        notifyAllObservers();
    }

    public UserObserver getObserver() {
        return observer;
    }

    @Override
    public List<String> getHistory() {
        return history;
    }

    @Override
    public void attach(UserObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyAllObservers() {
        observer.update2();
    }
}
