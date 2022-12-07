package com.douyin.Store;

import java.util.Scanner;
public class host {
    cart carts;
    myorders orders;
    goods p;
    public host(cart carts, myorders orders){
        this.carts=carts;
        this.orders=orders;
        System.out.println("1.商品1\n 2.商品2\n 3.商品3\n 4.商品4");
        Scanner in =new Scanner(System.in);
        int selectgoods;
        while((selectgoods=in.nextInt())!=-1){
            if(selectgoods==1){
                this.p=new goods("商品1");
            }
            if(selectgoods==2){
                this.p=new goods("商品2");
            }
            if(selectgoods==3){
                this.p=new goods("商品3");
            }
            if(selectgoods==4){
                this.p=new goods("商品4");
            }
            p.shuchu();

            }
        System.out.println("1.购买\n 2.加入购物车");
        int m=in.nextInt();
        if(m==1){
            p.pay();
            orders.addorder(p);
        }else{
            if(m==2){
                carts.addgoods(p);
            }
        }
    }


}
