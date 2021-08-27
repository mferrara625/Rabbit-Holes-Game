package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Contents extends JPanel implements ActionListener {

    private Image image;
    public static int x = 300, y = 400, z = -130, hole1 = 85, hole2 = 200, hole3 = 400, hole4 = 600 ;
    public int score1 = 0;
    public int randNum = (int)((Math.random() * 3) + 2);
    public int levelsDeep = 3;
    public int levelsDeepTrue = 3;
    public int i = 0, lives = 5;
    public boolean playerFailed = false, playersTurn = false;
    public int[] holeOrder = new int[levelsDeepTrue];
    public int[] reversedHoleOrder = new int[levelsDeepTrue];


    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("rabbit.png"));
        image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        if(!playersTurn){
//            g2d.setColor(Color.red);
//            g2d.fillOval( 75,300 , 150, 150);
            g2d.setColor(Color.yellow);
            g2d.fillOval( (hole2 - 10),300 , 150, 150);
            g2d.setColor(Color.green);
            g2d.fillOval( (hole3 - 10),300 , 150, 150);
            g2d.setColor(Color.blue);
            g2d.fillOval( (hole4 - 10),300 , 150, 150);
            g2d.setColor(Color.black);
//            g2d.drawOval( 75,300 , 150, 150);
            g2d.drawOval( (hole2 - 10),300 , 150, 150);
            g2d.drawOval( (hole3 - 10),300 , 150, 150);
            g2d.drawOval( (hole4 - 10),300 , 150, 150);
//            if(randNum == 1)
//                g2d.drawImage(image,hole1, z, this);
            if(randNum == 2){
                g2d.drawImage(image,hole2, z, this);
            }

            if(randNum == 3)
                g2d.drawImage(image,hole3, z, this);
            if(randNum == 4)
                g2d.drawImage(image,hole4, z, this);
        }
        if(playersTurn){
//            g2d.setColor(Color.red);
//            g2d.fillOval( 75,100 , 150, 150);
            g2d.setColor(Color.yellow);
            g2d.fillOval( (hole2 - 10),100 , 150, 150);
            g2d.setColor(Color.green);
            g2d.fillOval( (hole3 - 10),100 , 150, 150);
            g2d.setColor(Color.blue);
            g2d.fillOval( (hole4 - 10),100 , 150, 150);
            g2d.setColor(Color.black);
//            g2d.drawOval( 75,100 , 150, 150);
            g2d.drawOval( (hole2 - 10),100 , 150, 150);
            g2d.drawOval( (hole3 - 10),100 , 150, 150);
            g2d.drawOval( (hole4 - 10),100 , 150, 150);
            g2d.drawImage(image,x, y, this);
        }

        if(playerFailed){
            g2d.drawString( "WRONG HOLE", 400, 300);
        }


//        g2d.drawString("hole order " + Arrays.toString(holeOrder) + " reversed? " + Arrays.toString(reversedHoleOrder), 10, 50);
        g2d.drawString( "score: " + score1, 10, 25);
        g2d.drawString( "lives: " + lives, 10, 75);
        g2d.drawString( "holeSize " + reversedHoleOrder.length, 10, 100);
        g2d.drawString( "levelsDeep: " + levelsDeep, 10, 125);
        g2d.drawString("y: " + y, 700, 50);
        g2d.drawString( "x: " + x, 700, 25);
        g2d.drawString( "CONTROLS:", 10, 450);
        g2d.drawString( "W: UP", 10, 475);
        g2d.drawString( "S: DOWN", 10, 500);
        g2d.drawString( "A: LEFT", 10, 525);
        g2d.drawString( "D: RIGHT", 10, 550);

    }


    public static int zV = 4;
    public static int yV = 0;
    public static int xV = 0;



    public void move(){
        z = z + zV;
        y = y + yV;
        x = x + xV;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();


    if(!playersTurn){
        if (z >= 306){
            holeOrder[i] = randNum;
            i++;
            randNum =(int)((Math.random() * 3) + 2);
            z = -130;
            levelsDeep--;
            if(levelsDeep == 0){
                zV = 0;
                playersTurn = true;
                for(int i = 0; i < holeOrder.length; i++){
                    reversedHoleOrder[reversedHoleOrder.length - (i + 1)] = holeOrder[i];
                }
            }
        }
    }

        if(playersTurn){
            if(y <= 350){
                playerFailed = false;
            }
            if(y <= 115){
//                if(x >= 55 && x <= 105){
//                    if(reversedHoleOrder[levelsDeep] == 1){
//                        levelsDeep++;
//                        score1++;
//                    } else {
//                        playerFailed = true;
//                        lives--;
//                    }
//                    x = 75;
//                    y = 400;
//
//                } else
                if(x >= (hole2 - 30) && x<= (hole2 + 20)){
                    if(reversedHoleOrder[levelsDeep] == 2){
                        levelsDeep++;
                        score1++;
                    } else {
                        playerFailed = true;
                        lives--;
                    }
                    x = (hole2 - 10);
                    y = 400;

                } else if(x >= (hole3 - 30) && x<= (hole3 + 20)){
                    if(reversedHoleOrder[levelsDeep] == 3){
                        levelsDeep++;
                        score1++;
                    } else {
                        playerFailed = true;
                        lives--;
                    }
                    x = (hole3 - 10);
                    y = 400;

                } else if(x >= (hole4 - 30) && x<= (hole4 + 20)){
                    if(reversedHoleOrder[levelsDeep] == 4){
                        levelsDeep++;
                        score1++;
                    } else {
                        playerFailed = true;
                        lives--;
                    }
                    x = (hole4 - 10);
                    y = 400;
                }
            }
            if(levelsDeep == levelsDeepTrue){
                levelsDeep++;
                levelsDeepTrue++;
                z = 0;
                zV = 3;
                playersTurn = false;
                holeOrder = new int[levelsDeepTrue];
                reversedHoleOrder = new int[levelsDeepTrue];
                i = 0;
            }
        }


        repaint();
    }
}