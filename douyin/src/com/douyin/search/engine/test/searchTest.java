package com.douyin.search.engine.test;

import com.douyin.search.engine.myFrame;

import javax.swing.*;

public class searchTest {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                createGUI();
            }


        });
    }
    private static void createGUI()
    {
        myFrame frame = new myFrame("搜索");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        frame.setVisible(true);
    }

}
