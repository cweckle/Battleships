import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Computer extends Player{
    private ArrayList<Marker> computerMarkers = new ArrayList<Marker>();
    private String lastXSpot = "";
    private int lastYSpot = -10;

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
        //check if the guessed place has hit something
        boolean haveHit = false;
        boolean sunkThisShip = false;
        while (haveHit == false || sunkThisShip == true)
        {
            boolean drop = false;
            String xSpot = "";
            int ySpot = 0;
            ArrayList <Spot> hitSpots = new ArrayList<Spot>();
            if(lastXSpot.equals("") && lastYSpot == -10)
            {
                while (!drop)
                {
                    xSpot = Ship.convertIntX((int)(Math.random()* 600+20));
                    ySpot = Ship.convertToGridY((int)(Math.random()*600+150));
                    placeHit(xSpot,ySpot);
                }
            }
            else
            { 
                while (!drop)
                {
                    int round = 0;
                    for (int i = round; i <10; i+=4) //col x
                    {
                        for(int r = round; r <10; r+= 4) //row y
                        {
                            xSpot =  Ship.convertIntX(i);
                            ySpot = r;
                            placeHit(xSpot,ySpot);
                        }
                        round ++;
                    }
                }
            }
            for(int i = 0; i < hitSpots.size(); i++)
            {
                if(hitSpots.get(i).equals(new Spot(ySpot, xSpot)))
                {
                    i = hitSpots.size();
                }
                else
                {
                    hitSpots.add(new Spot(ySpot, xSpot));
                    lastXSpot = xSpot;
                    lastYSpot = ySpot;
                    drop = true;
                    //check to see what happens when you drop the bomb here
                    //and check to see if haveHit will be true
                    //something needs to call this method guess
                }
            }
        }
        while(haveHit == true && sunkThisShip == false)
        {
            
            //check direction of the ship, and if you have hit multiple places in the ship
            //need to check if you have sunk the entire ship
        }
    }
}