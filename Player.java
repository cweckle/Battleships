import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Player{
    private Ship[] ships;
    public static final int NUMSHIPS=5;
    private Ship clicked;
    
    public Player(){
        ships = new Ship[NUMSHIPS];
        clicked = new Ship();
        for(int i = 0; i < ships.length; i ++){
            ships[i] = new Ship(i+1); 
            System.out.println(ships[i]);
        }
    }
    
    public Ship getShip(int i){
        return ships[i];
    }

    public boolean bombHit(int xInt, int y)
    {
        String x = Ship.convertIntX(xInt);
        y = Ship.convertToGridY(y);
        
        for (int i = 0; i <ships.length; i++)
        {
            System.out.println("Ship at " + ships[i].getX() + ", " + ships[i].getY());
            String storedX = ships[i].getX();
            if(x.equals(ships[i].getX()) && y == ships[i].getY())
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean inBounds(){
        //CHECK TO SEE IF PLACED SHIPS ARE INBOUNDS FOR BOTH PLAYER AND COMPUTER
        return false;
    }
    
    //draws ships
    public void draw( Graphics page ){
        //color defined using rgb values (0-255 each)
        for(int i = 0; i < ships.length; i ++){
            page.setColor( new Color( 100, 100, 100 ) );
            ships[i].draw(page);
        }
    }
    
    public void drawMini(Graphics page){
        for(int i = 0; i < ships.length; i ++){
            page.setColor( new Color( 100, 100, 100 ) );
            ships[i].drawMini(page);
        }
    }
    
    public void move(int x, int y){
        clicked.move(x,y);
    }
    
    public void act(int x, int y){
        boolean overlaps = false;
        int num = 0;
        
        while(!overlaps && num < 5){
            overlaps = ships[num].overlapsWith(x,y);
            num++;
        }
        if(overlaps)
            clicked = ships[num-1];
    }
    
    public void mapLocs(){
        for(Ship next : ships){
            next.setLoc();
        }
    }
}