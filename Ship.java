import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Ship{
    private int length;
    private int direction;
    private int xLoc;
    private int yLoc;
    private boolean selected = false;
    
    private String gridX;
    private int gridY;
    
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
        gridX = "";
        gridY = 0;
    }
    
    public Ship(){
    }
    
    
    public void setX(int x){
        xLoc = x;
        gridX = convertIntX(xLoc);
    }
    
    public void setY(int y){
        yLoc = y;
        gridY = convertToGridY(yLoc);
    }
    public String getX(){
        return gridX;
    }
    
    public int getY(){
        return gridY;
    }
    
    public boolean overlapsWith(int x, int y){
        if(x >= xLoc && x <= xLoc + 60*length && y >= yLoc && y <= yLoc + 30){
            selected = true;
            return true;
        }
        return false;
    }
    
    public void move(int x, int y){
        xLoc = x;
        yLoc = y;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void draw( Graphics page ){
        if(yLoc >= Board.TOP)
            snapTo();
        
        if (selected){
            page.setColor(Color.YELLOW);
            page.fillRect(this.xLoc - 3, this.yLoc - 3, 60*length -14, 36);
        }
        
        page.setColor(new Color(100,100,100));
        page.fillRect(this.xLoc, this.yLoc, 60*length -20, 30);
        page.setColor( new Color( 255, 255, 255 ) );
        for(int i = 0; i < length; i ++)
            page.fillOval(this.xLoc + (60*i) + 20, this.yLoc + 10, 7, 7);
    }
    
    public void drawMini(Graphics page){
        snapTo();
        page.setColor(new Color(100,100,100));
        page.fillRect(this.xLoc, this.yLoc, 60*length -20, 30);
        page.setColor( new Color( 255, 255, 255 ) );
        for(int i = 0; i < length; i ++)
            page.fillOval(this.xLoc + (60*i) + 20, this.yLoc + 10, 7, 7);
    }
    
    
    public void snapTo(){
        String col = convertIntX(xLoc);
        int colVal = getColVal(col);
        int row = convertToGridY(yLoc);
        xLoc = ((colVal) * 60) + 30;
        yLoc = ((row) * 60) + 170;
        selected = false;
        //make it check to see if it goes out of bounds
    }
    
    public static int getColVal(String col){
        if (col==null)
            return -1;
        else if(col.equals("A"))
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
        return -1;
    }
    
    public static String convertIntX(int x){
        String answer = "A";
        int num = 0;
        while(answer!=null){
            if(x >= Board.LEFT + Board.SIDE*num && x <= Board.LEFT + Board.SIDE*(num+1))
                return answer;
            answer = increment(answer);
            num++;
        }
        return null;
    }
    
    public static int convertToGridY(int y){
        int answer = 0;
        int num = 0;
        while(num <= 9){
            if(y >= Board.TOP + Board.SIDE*num && y <= Board.TOP + Board.SIDE*(num+1))
                return answer;
            answer ++;
            num ++;
        }
        return -1;
    }
    
    public static String increment(String change){
        if(change == null)
            return null;
        else if(change.equals("A"))
            return "B";
        else if(change.equals("B"))
            return "C";
        else if(change.equals("C"))
            return "D";
        else if(change.equals("D"))
            return "E";
        else if(change.equals("E"))
            return "F";
        else if(change.equals("F"))
            return "G";
        else if(change.equals("G"))
            return "H";
        else if(change.equals("H"))
            return "I";
        else if(change.equals("I"))
            return "J";
        return null;
    }
    
    public void setLoc(){
        gridX = convertIntX(xLoc);
        gridY = convertToGridY(yLoc);
    }
}