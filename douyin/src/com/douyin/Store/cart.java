package com.douyin.Store;

public class cart {
    goods[] gs=new goods[5];
    goods p1=new goods("商品2");
    goods p2=new goods("商品3");
    int i=2;
    int piecesum=150;
    public cart(){
        this.gs[0]=p1;
        this.gs[1]=p2;
    }
    public void Printl(){
        int m=0;
        while(m!=i){
            System.out.println(gs[m].goodsname+" "+gs[m].piece);
            m++;
        }
        System.out.println("Sumpieces:"+this.piecesum);

    }
    public void addgoods(goods gs){
        this.gs[i]=gs;
        this.piecesum+=gs.piece;
        i++;
        System.out.println("加入成功！");
        this.Printl();
    }

    public void deletgoods(int n){
        this.piecesum-=gs[n].piece;
        while(n<this.i-1){
            gs[n]=gs[n+1];
            n++;
        }
        gs[i-1]=null;
        i--;
        System.out.println("删除成功！请继续输入!");
        this.Printl();
    }
}
