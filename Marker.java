import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Marker
{
    private Color col;
    private int yCoord;
    private int xCoord;
    
    public Marker(boolean hit, String x, int y)
    {
        if (hit == true)
        {
            col = Color.RED;
        }
        else
        {
            col = Color.WHITE;
        }
        yCoord = y;
    }
    
    public Marker(boolean hit, int x, int y){
        if(hit)
            col = Color.RED;
        else
            col = Color.WHITE;
        xCoord = x;
        yCoord = y;
        snapTo();
    }
    
    public void snapTo(){
        String col = Ship.convertIntX(xCoord);
        int colVal = Ship.getColVal(col);
        int row = Ship.convertToGridY(yCoord);
        xCoord = ((colVal) * 60) + 30;
        yCoord = ((row) * 60) + 170;
        //make it check to see if it goes out of bounds
    }

    public void draw( Graphics page )
    {
        page.setColor(col);
        page.fillOval(xCoord, yCoord, 20, 20);
    }
}