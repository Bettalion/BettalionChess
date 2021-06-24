package com.Bettalion;

import java.util.LinkedList;

public class ChessPiece {
    boolean isLightPiece;
    LinkedList<ChessPiece> ps;
    String type;
    int xpos;
    int ypos;

    public ChessPiece(boolean isLightPiece, int xpos, int ypos, LinkedList<ChessPiece> ps, String type) {
        this.isLightPiece = isLightPiece;
        this.xpos = xpos;
        this.ypos = ypos;
        this.type=type;
        ps.add(this);

    }

    public void move(int xpos,int ypos){
        for(ChessPiece p: ps)
            if (p.xpos == xpos && p.ypos == ypos) {
                p.capture();
            }
    }
    public void capture(){
        ps.remove(this);
    }
}
