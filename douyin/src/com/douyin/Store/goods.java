package com.douyin.Store;

import java.util.*;
public class goods {
    String goodsname;
   int piece;
   String zhuangtai;
    public goods(String goodname){
        this.goodsname=goodname;
        if(goodname=="商品1"){
            this.piece=20;
        }
        if(goodname=="商品2"){
            this.piece=50;
        }
        if(goodname=="商品3"){
            this.piece=100;
        }
        if(goodname=="商品4"){
            this.piece=500;
        }
    }

    public goods(String goodname,String zhuangtai){
        this.goodsname=goodname;
        this.zhuangtai=zhuangtai;
        if(goodname=="商品1"){
            this.piece=20;
        }
        if(goodname=="商品2"){
            this.piece=50;
        }
        if(goodname=="商品3"){
            this.piece=100;
        }
        if(goodname=="商品4"){
            this.piece=500;
        }
    }
    public void shuchu(){
        System.out.println("goodsname："+this.goodsname+" "+"piece："+this.piece);
    }
    public void pay(){
        Scanner in=new Scanner(System.in);
        System.out.println("你购买的商品为："+this.piece+"元,请付款");
        int n=in.nextInt();
        if(n<this.piece){
            System.out.println("余额不足！");
        }else{
            System.out.println("购买成功！");
            this.zhuangtai="已完成";
        }
    }
}
