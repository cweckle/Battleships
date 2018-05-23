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
    
    private ArrayList<Button> ships = new ArrayList<Button>();
    private Button[][] clicks = new Button[NUM_ROWS][NUM_COLS];
    
    public Board(){
    }
    public void draw( Graphics page ){
        page.setColor( Color.BLACK );//color defined using rgb values (0-255 each)
        for(int r = 0; r <= NUM_ROWS; r ++)
            page.fillRect(LEFT, TOP+SIDE*r, NUM_COLS * SIDE, THICK);
        for(int c = 0; c <= NUM_COLS; c++)
            page.fillRect(LEFT+SIDE*c, TOP, THICK, NUM_ROWS * SIDE);
    }
    
    public void act(int x, int y){
         
    }
    
    public void makeButtons(){
        for(int r = 0; r < NUM_ROWS; r++)
            for(int c = 0; c < NUM_COLS; c++)
            {
                Spot s = new Spot(r, c);
                Button button = new Button();
                button.setBackground(Color.BLACK);
                button.setBounds(new Rectangle(40,40,200,200));
                add(button);
                //button.addMouseListener(this);
                clicks[r][c] = button;
            }
    }
}