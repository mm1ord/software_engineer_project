package com.douyin.Store;

import java.util.Scanner;
public class search {
    cart carts;
    myorders orders;
    public search(cart carts, myorders orders){
        this.carts=carts;
        this.orders=orders;
        System.out.println("请输入需要搜索的货物名称！");
        Scanner in=new Scanner(System.in);
        String needgoods= in.nextLine();
        goods p1=new goods(needgoods);
        p1.shuchu();
        System.out.println("1.购买\n 2.加入购物车");
        int m=in.nextInt();
        if(m==1){
            p1.pay();
            orders.addorder(p1);
        }else{
            if(m==2){
                carts.addgoods(p1);
            }
        }
    }
}
