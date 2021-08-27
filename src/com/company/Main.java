package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {

        new Main();
    }

    public Main(){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_W) {
                    Contents.yV = -3;
//                    Contents.xV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_S){
                    Contents.yV = 3;
//                    Contents.xV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_A){
//                    Contents.yV = 0;
                    Contents.xV = -3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_D){
//                    Contents.yV = 0;
                    Contents.xV = 3;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_SPACE){

                    event.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_W) {
                    Contents.yV = 0;
//                    Contents.xV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_S){
                    Contents.yV = 0;
//                    Contents.xV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_A){
//                    Contents.yV = 0;
                    Contents.xV = 0;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_D){
//                    Contents.yV = 0;
                    Contents.xV = 0;
                    event.consume();
                }

            }

            @Override
            public void keyTyped(KeyEvent event) {
            }

        };
        JFrame frame = new JFrame();
        frame.setTitle("Rabbit Holes - Can you find your way out ?");
        frame.setSize(900, 600);
        frame.setLocation(100, 50);
        frame.addKeyListener(listener);
        frame.add(new Contents());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

