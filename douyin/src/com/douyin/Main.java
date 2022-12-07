package com.douyin;


import com.douyin.Store.store;
import com.douyin.video.account.VideoTest;
import com.douyin.search.engine.test.searchTest;
import com.douyin.zhibo.zhiboTest;

public class Main {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("直播功能测试");
        System.out.println("---------------------------");
        zhiboTest.main(args);

        System.out.println("");
        System.out.println("短视频功能测试");
        System.out.println("---------------------------");
        VideoTest.main(args);

        System.out.println("");
        System.out.println("商店功能测试");
        System.out.println("---------------------------");
        store.main(args);

        System.out.println("");
        System.out.println("搜索功能测试");
        System.out.println("---------------------------");
        searchTest.main(args);


    }
}
