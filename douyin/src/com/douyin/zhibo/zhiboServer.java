package com.douyin.zhibo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class zhiboServer {

    public static  String session = "";
    public static void zhiboStart() {
        System.out.println("--------开启直播---------");
        System.out.println("--------直播ing---------");
        System.out.println("--------直播ing---------");
        System.out.println("--------直播ing---------");
        System.out.println("--------直播ing---------");
        System.out.println("--------直播ing---------");
        SessionFactory sf = new SessionFactory();
        User czm1 = UserFactory.createPeople("audience", "czm1");
        User czm2 = UserFactory.createPeople("audience","czm2");
        User czm3 = UserFactory.createPeople("audience", "czm3");

        User anchor = UserFactory.createPeople("audience", "anchor");
        User Administrator = UserFactory.createPeople("Administrator", "Admin");

        List<User> zhibojian = new ArrayList<>();
        zhibojian.add(czm1);
        zhibojian.add(czm2);
        zhibojian.add(czm3);
        Session is = sf.createSession(anchor);
        Session gs = sf.createSession(zhibojian);
        Scanner in = new Scanner(System.in);
        System.out.println("请选择直播功能:1-送礼物。 2-发送评论 3-退出系统");
        while(in.hasNextDouble()) {
            Integer x = in.nextInt();
            if(x == 4) break;
            switch (x) {
                case 1:{
                    System.out.println("Present Test");
                    is.sendMessage("A new present.");
                    break;
                }
                case 2:{
                    System.out.println("GroupSession Test");
                    gs.sendMessage("A new message again.");
                    break;
                }
                case 3: {
                    System.out.println("正在退出.................");
                    System.exit(1);
                    break;
                }
                default:
                    System.out.println("非法输入");
                    break;
            }
            System.out.println("请选择直播功能:1-送礼物。 2-发送评论 3-退出系统");
        }
        in.close();
    }
}
