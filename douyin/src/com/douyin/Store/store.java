package com.douyin.Store;

import java.util.Scanner;

public class store{

    public static void main(String[] args){
        cart carts=new cart();
        myorders orders=new myorders();
        Scanner in =new Scanner(System.in);
        System.out.println("---欢迎进入商店---");
        System.out.println("1.浏览主页\n 2.搜索商品\n 3.购物车\n 4.我的订单");
        int InterfaceChoices;
        while((InterfaceChoices=in.nextInt())!=-1){
            if(InterfaceChoices==1){
                new host(carts,orders);
            }else {
                if (InterfaceChoices == 2) {
                    new search(carts,orders);
                }else{
                    if(InterfaceChoices==3){
                        carts.Printl();
                        System.out.println("请输入需要删除的商品(从0开始）：(输入-1退出）");
                        int n=in.nextInt();
                        while(n!=-1) {
                            carts.deletgoods(n);
                            n = in.nextInt();
                        }
                    }else{
                        if(InterfaceChoices==4){
                            orders.Print();
                            System.out.println("请输入需要删除的订单(从0开始）：(输入-1退出）");
                            int n=in.nextInt();
                            while(n!=-1){
                                orders.deletorders(n);
                                n=in.nextInt();
                            }
                        }else{
                            if(InterfaceChoices==5){
                                System.out.println("Welcome Back");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
