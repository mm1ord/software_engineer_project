package com.douyin.search.engine;

//myFrame基于JFrame的个人工具类


import java.awt.Container;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class myFrame extends JFrame{
    JLabel label = new JLabel("请输入您要搜索的内容：");

    //创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
    JTextField textField = new JTextField(16);
    JButton button = new JButton("确定");

    //构造函数
    public myFrame(String title)
    {
        //继承父类，
        super(title);

        //内容面板
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        //添加控件
        contentPane.add(label);
        contentPane.add(textField);
        contentPane.add(button);

        //按钮点击处理 lambda表达式
        button.addActionListener((e) -> {
            onButtonOk();
        });
    }

    //事件处理
    private void onButtonOk()
    {
        SerachBase serachBase = SerachBase.getSerachBase();
        serachBase.add("1", "用户1", "甘雨");
        serachBase.add("2", "用户2", "胡桃");
        serachBase.add("3", "用户3", "刻晴");
        serachBase.add("4", "聊天记录1", "你是谁？");
        serachBase.add("5", "聊天记录2", "高数确实很难。");
        serachBase.add("6", "聊天记录3", "上面的只是测试");
        serachBase.add("7", "视频1", "啊啊啊，想不出名字了");
        serachBase.add("8", "视频2", "救命，这个男人竟...");
        serachBase.add("9", "视频3", "日本2：1西班牙");
        serachBase.add("10", "直播1", "2022KIC英文流");
        serachBase.add("11", "直播2", "深渊刷新冲冲冲");
        serachBase.add("12", "直播3", "足 球 宝 贝，阿根廷加油");
        serachBase.add("13", "商品1", "周期");
        serachBase.add("14", "商品2", "麻辣牛肉干");
        serachBase.add("15", "商品3", "羽绒服");

        String str = textField.getText();//获取输入内容
        //判断是否输入了
        if(str.equals(""))
        {
            Object[] options = { "OK ", "CANCEL " };
            JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,null, options, options[0]);
        }
        else {
            String ids = serachBase.getIds(str);
            System.out.println(ids);
            List<Object> objs = serachBase.getObjects(ids);
            if (objs != null) {
                for (Object obj : objs) {
                    JOptionPane.showMessageDialog(this, "您已搜索到：" + (String)obj);
                }
            }
        }
    }

}
