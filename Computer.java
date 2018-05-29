import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Computer extends Player{
     private ArrayList<Marker> computerMarkers = new ArrayList<Marker>();
    
    public Computer(){
        super();
        randomize();
    }
    
    public void randomize(){
        for(int i = 0; i < Player.NUMSHIPS; i ++){
            getShip(i).setX((int)(Math.random()*(Board.NUM_ROWS*Board.SIDE))+Board.LEFT);
            getShip(i).setY((int)(Math.random()*(Board.NUM_COLS*Board.SIDE))+Board.TOP);
            getShip(i).snapTo();
        }
    }
    
        public void placeHit(String x, int y)
    {
        computerMarkers.add(new Marker(true, x,y));
    }
    
    public void guess()
    {
        //should have a varibale if it has hit something
        //if the boolean is false, then you make random, but intelligent guessed
        //if the boolean is true, and you haven't sunk the entire boat, you should be guessing to find this ship
        //if the boolean is true, but you've sunk the entire ship, you should go back to guessing randomly but intelligently
        boolean haveHit = false;
        boolean sunkThisShip = false;
        while (haveHit == false)
        {
            placeHit(Ship.convertIntX((int)(Math.random()* 600+20)),Ship.convertToGridY((int)(Math.random()*600+150))); //this isn't intelligent
            //do i need to check if this spot has already had a bomb dropped on it?
            //check if that has hit something
        }
        while(haveHit == true && sunkThisShip == false)
        {
            
        }
        while(haveHit == true && sunkThisShip == true)
        { 
            placeHit(Ship.convertIntX((int)(Math.random()* 600+20)),Ship.convertToGridY((int)(Math.random()*600+150))); //this isn't intelligent
        }
    }
    
    public void guess(int x, int y, boolean hit, boolean sink)
    { 
        boolean haveHit = hit;
        boolean sunkThisShip = sink;
        while(haveHit == true && sunkThisShip == false)
        {
            placeHit(Ship.convertIntX(x-60), y); //so how do we do this becuase if one doesnt work it needs to do the next, etc.
            placeHit(Ship.convertIntX(x-60), y);
            placeHit(Ship.convertIntX(x), y+60); //this also changes if we know the direction of the boat
            placeHit(Ship.convertIntX(x), y-60);
        }
    }
}