package com.douyin;


import com.douyin.official.account.OfficialAccountShowCase;
import com.douyin.search.engine.test.searchTest;
import com.douyin.zhibo.zhiboTest;

public class Main {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("公众号功能测试");
        System.out.println("---------------------------");
        OfficialAccountShowCase.main(args);

        System.out.println("");
        System.out.println("直播功能测试");
        System.out.println("---------------------------");
        zhiboTest.main(args);

        System.out.println("");
        System.out.println("小程序功能测试");
        System.out.println("---------------------------");
        searchTest.main(args);
    }
}
