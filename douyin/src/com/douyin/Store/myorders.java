package com.douyin.Store;

public class myorders {
    goods[] gS=new goods[5];
    goods p1=new goods("商品1","已完成");
    int i=1;
    public myorders(){
        this.gS[0]=p1;
    }
    public void addorder(goods p){
        this.gS[i]=p;
        i++;
    }
    public void Print(){
        int m=0;
        while(m!=i){
            System.out.println(gS[m].goodsname+" "+gS[m].piece+" "+gS[m].zhuangtai);
            m++;
        }
    }
    public void deletorders(int n){
        while(n<this.i-1){
            gS[n]=gS[n+1];
            n++;
        }
        gS[i-1]=null;
        i--;
        System.out.println("删除成功！请继续输入!");
        this.Print();
    }
}
