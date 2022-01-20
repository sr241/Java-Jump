import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;


public class GamePanel extends JPanel {
    private Game ga;
    //private boolean key = false; 
    // key is the up arrow
    private Ball b = new Ball (40,GameFrame.GAME_HEIGHT-20);
    private int dx, dy;
    private int x,y;
    public static int count;
   // private int startY;

    public GamePanel(Game gg) {
        ga = gg;
        setBackground( Color.CYAN );
        setBorder( BorderFactory.createLineBorder(Color.BLACK ) );
        addKeyListener( new Listen() );
        setFocusable(true); // very important
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); 
        // loop thru the obstacles and draw them
        ga.draw(g);
    }
    
    public Ball getBall(){
        return b; 
    }
   /* public int score2(){
        return game.getScore();
    }
    public boolean isAlive(){
        return game.keepPlaying();
    } */

    private class Listen extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){

            if (e.getKeyCode() == KeyEvent.VK_UP){
                //key = true;
                if (b.getY() == GameFrame.GAME_HEIGHT-20){
                    b.jump();
                    count++;
                }
                if ((b.getY() < GameFrame.GAME_HEIGHT-20) && count <= 1){
                    b.jump();
                    count++;
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e){

            if (e.getKeyCode() == KeyEvent.VK_UP){
                //key = false;
                b.move();
            }

        }

    }
    
}

