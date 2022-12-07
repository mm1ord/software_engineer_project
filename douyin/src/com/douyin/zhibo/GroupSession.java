package com.douyin.zhibo;

import java.util.ArrayList;
import java.util.List;

public class GroupSession implements Session {

    private List<UserObserver> observers = new ArrayList<>();
    private List<String> history = new ArrayList<>();

    public List<UserObserver> getObservers() {
        return observers;
    }

    @Override
    public void sendMessage(String message) {
        history.add(message);
        System.out.printf("已发送评论: %s%n", message);
        notifyAllObservers();
    }

    @Override
    public List<String> getHistory() {
        return history;
    }

    @Override
    public void attach(UserObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(UserObserver observer: observers) {
            observer.update();
        }
    }
}
