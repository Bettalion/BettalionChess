package com.Bettalion;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    //set up / init main board
	JFrame frame = new JFrame();
	frame.setResizable(false); //not resizeable
    frame.setBounds(10, 10,512,530); //dimensions: 10x10 squares, height changed to adjust for border
    JPanel pn = new JPanel() {
        @Override
        public void paint(Graphics g) {
            boolean White = true;
            for (int y = 0; y<8; y++){
                for(int x = 0; x<8; x++){
                    if (White) {
                        g.setColor(Color.GRAY);
                    }else{
                        g.setColor(Color.DARK_GRAY);
                    }
                g.fillRect(x*64, y*64, 64,64);
                    White =!White;
                }
                White =!White;
            }
        }


    };
    frame.add(pn);

    //Make the pannel closable and visible
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);


    }
}
