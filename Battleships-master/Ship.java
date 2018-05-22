import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Ship{
    private int length;
    private int direction;
    private int xLoc;
    private int yLoc;
    
    //player's ship constructor
    public Ship(int l){
        length = l; 
        if(l == 2 || l == 5){
            yLoc = 20;
            xLoc = 20+(50*l)+200*(l%2);
        }
        else{
            yLoc = 80;
            if(l!=1)
                xLoc = 20+300*(l%2+1);
            else
                xLoc = 50;
        }
    }
    
    public Ship(){
    }
    
    public boolean overlapsWith(int x, int y){
        System.out.println("Coords: " + x + ", "+ y);
        System.out.println("Ship: " + xLoc + ", "+ yLoc);
        if(x >= xLoc && x <= xLoc + 60*length && y >= yLoc && y <= yLoc + 30)
            return true;
        return false;
    }
    
    public void move(int x, int y){
        xLoc = x;
        yLoc = y;
    }
    
    public void draw( Graphics page ){
        page.fillRect(this.xLoc, this.yLoc, 60*length -20, 30);
        page.setColor( new Color( 255, 255, 255 ) );
        for(int i = 0; i < length; i ++)
            page.fillOval(this.xLoc + (60*i) + 20, this.yLoc + 10, 7, 7);
    }
    
    public String toString(){
        return "LENGTH: " + length;
    }
    
    public void snapTo(){
        String col = getX();
        int col = getColVal(col);
        int row = getY();
        int x = ((col) * 60) + 50;
        int y = ((row) * 60) + 180;
        move(x, y);
    }
    
    public int getColVal(String col){
        if (col.equals("A"))
            return 0;
        else if (col.equals("B"))
            return 1;
        else if (col.equals("C"))
            return 2;
        else if (col.equals("D"))
            return 3;
        else if (col.equals("E"))
            return 4;
        else if (col.equals("F"))
            return 5;
        else if (col.equals("G"))
            return 6;
        else if (col.equals("H"))
            return 7;
        else if (col.equals("I"))
            return 8;
        else if (col.equals("J"))
            return 9;
    }
}