public class Computer extends Player{
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
}