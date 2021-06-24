package com.Bettalion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // get pieces
        LinkedList<ChessPiece> piece = new LinkedList<>();
        BufferedImage pieces = null;
        try {
            pieces = ImageIO.read(new File("/Users/amoghsimhadri/BettalionFolder/Coding/Java/BettalionChess/src/Pieces.png"));
            System.out.println(pieces.getHeight());
            System.out.println(pieces.getWidth());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image loading error");
        }


            Image pieceImgs[] = new Image[12]; //array of the individual pieces
            int i = 0;
            for (int y = 0; y < 400; y += 200) {
                for (int x = 0; y < 1200; x += 200) {
                    pieceImgs[i] = pieces.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                    // takes a section of the spritemap and cuts it into pieces, then scales it to 64x64px
                    i++;
                    System.out.println(x);
                    System.out.println(y);
                }
            }




        //set up / init main board
        JFrame frame = new JFrame();
        frame.setResizable(false); //not resizeable
        frame.setBounds(10, 10, 512, 530); //dimensions: 10x10 squares, height changed to adjust for border
        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean White = true;
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (White) {
                            g.setColor(Color.GRAY);
                        } else {
                            g.setColor(Color.DARK_GRAY);
                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        White = !White;
                    }
                    White = !White;
                }


            }


        };
        frame.add(pn);

        //Make the pannel closable and visible
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);


    }
}

