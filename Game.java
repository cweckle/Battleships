import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JPanel implements MouseListener,ActionListener
{
    private Player player;
    private Board board;
    private Computer computer;
    private boolean placed = false;
    private boolean selected = false;
    private JButton button;
    private JLabel turn;
    private String yourTurn;
    private String compTurn;
    private String hit;
    private String miss;
    private JLabel result;

    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height)
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( new Color(0, 100, 180) );
        this.setPreferredSize( new Dimension( width, height ) );//Don't change

        //initialize the instance variables
        player = new Player();  //change these numbers and see what happens
        board = new Board();
        computer = new Computer();
        this.addMouseListener(this);//allows the program to respond to key presses - Don't change
        
        String text = "DONE PLACING YOUR SHIPS?";
        
        button = new JButton(text);
        button.setBounds(700,500,200,50);
        this.add(button);
        button.setVisible(true);
        button.addActionListener(this);
        
        compTurn = "The computer is guessing now.";
        yourTurn = "It's your turn to guess!";
        turn = new JLabel(yourTurn);
        turn.setForeground(Color.WHITE);
        turn.setBounds(80,50,800,50);
        this.add(turn);
        turn.setVisible(false);
        turn.setFont(new Font("Courier New", Font.ITALIC, 36));
        
        hit = "HIT!";
        miss = "MISS!";
        result = new JLabel();
        result.setForeground(Color.RED);
        result.setBounds(700, 700, 300, 80);
        this.add(result);
        result.setVisible(false);
        result.setFont(new Font("Courier New", Font.BOLD, 80));

        this.setFocusable(true);//I'll tell you later - Don't change
    }

    public void playGame()
    {
        boolean over = false;
        while( !over )
        {
            try
            {
                Thread.sleep( 200 );//pause for 200 milliseconds
            }catch( InterruptedException ex ){}
            try{
                Thread.sleep(800);
                result.setVisible(false);
            }catch(InterruptedException ex){}

            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
            
        }
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );//I'll tell you later.
        if(!placed)
        {
            board.draw(page);
            player.draw( page );//calls the draw method in the Player class
        }
        else
        {
            turn.setVisible(true);
            board.drawMini(page);
            player.drawMini(page);
            board.drawGame(page);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        result.setVisible(false);
        if(!placed){
            if(!selected){
                player.act(x,y);
                selected = true;
            }
            else{
                selected = player.move(x, y);
            }
        }
        else{
            if((computer.bombHit(x, y) == true)) //not sure if this is supposed to be this. We need to drop a bomb, and that bomb is what needs to call bombHit i think
            {
                result.setForeground(Color.RED);
                result.setText(hit);
                result.setVisible(true);
                board.placeHit(x,y);
            }
            else{
                result.setForeground(new Color(200,200,200));
                result.setText(miss);
                result.setVisible(true);
                board.placeMiss(x,y);
            }
            changeText();
        }
    }
    
    public void changePlaceBoolean(){
        if (selected)
            selected = false;
        else
            selected = true;
    }
    
    public void changeText(){
        if(turn.getText().equals(yourTurn))
            turn.setText(compTurn);
        else
            turn.setText(yourTurn);
    }

    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }
    
    public void actionPerformed(ActionEvent event){
        placed = true;
        button.setVisible(false);
    }
}