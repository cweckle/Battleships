import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame{
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    public static final int TOP = 150;
    public static final int SIDE = 60;
    public static final int LEFT = 20;
    public static final int THICK = 2;

    private ArrayList<Ship> computer = new ArrayList<Ship>();
    private ArrayList<Marker> markers = new ArrayList<Marker>();
    private ArrayList<Marker> computerMarkers = new ArrayList<Marker>();

    public Board(){
    }

    public void draw( Graphics page ){
        page.setColor( Color.BLACK );//color defined using rgb values (0-255 each)
        for(int r = 0; r <= NUM_ROWS; r ++)
            page.fillRect(LEFT, TOP+SIDE*r, NUM_COLS * SIDE, THICK);
        for(int c = 0; c <= NUM_COLS; c++)
            page.fillRect(LEFT+SIDE*c, TOP, THICK, NUM_ROWS * SIDE);
    }
    
    public void drawGame( Graphics page){
        this.draw(page);
        for(Marker next : markers)
            next.draw(page);
    }
        
    public void act(int x, int y){

    }

    public void placeHit(int x, int y)
    {
        markers.add(new Marker(true, x,y));
    }
    
    public void placeMiss(int x, int y)
    {
        markers.add(new Marker(false, x, y));
    }
}