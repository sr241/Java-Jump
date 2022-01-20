import java.awt.*;
import java.util.*;
import java.awt.geom.RectangularShape.*;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;

public class Game{
    private boolean playing = true;
    private int width, height;
    private Ball b;
    private ArrayList<Obstacle> list = new ArrayList<Obstacle>();
    private int score;
    private GamePanel gp = null;
    private int milli = 0;

    public Game( int w, int h, boolean bean ){
        width = w;
        height = h;
        // playing = bean;
    }
    
    public void addGP( GamePanel ggg ){
        gp = ggg;
        b = gp.getBall();
    }

    // sets up the game
    public void init(){
        score = 0;
        milli = 0;
        //ball = (0, 0, 0, 0);
        list.clear();   // removes all elements
        playing = true;
    }

    public void updateBallMotion( int dy  ){
        b.setSpeed( dy );
    }

    public void update(){
        milli += 60;
        // update the player's position
        //b.move();
        //  maybe* spawn a new Guy
        //    set x so that it begins just off the right side of the panel
        //    set y to a random value
        if ( milli % 1000 == 0 && playing == true ){
            Obstacle g = new Obstacle( GameFrame.WIDTH , GameFrame.GAME_HEIGHT );
            list.add(g);
        }
        if (b.getY() == GameFrame.GAME_HEIGHT-20){
            GamePanel.count = 0;
        }
 
        // loop through the array list of Guy objects and tell each one to move
        for(int i = 0; i <list.size(); i++)
            list.get(i).move();

        Circle bl = new Circle(b.getX(),b.getY());
        int cx = b.getX();
        int cy = b.getY();
        Rectangle brec = new Rectangle(cx, cy, 20, 20);
        for ( int k = list.size() - 1; k >= 0; k-- ){
            Rectangle obs = list.get(k).getShape();
            if ( obs.intersects( brec ) ){
                playing = false;
            } else{
                score += 1;
            }
            // loop through all the guys and remove any that have moved off the left side of the panel
          //  if(list.get(k).getX() < 0){
           //     list.remove(k);
           // }
        }
        }
    

    public boolean keepPlaying(){
        return playing;
    }

    public int getScore(){
        return score;
    }

    public void draw( Graphics g ){
        
        if ( b != null )
            b.draw( g );
        for ( Obstacle guy : list )
            guy.draw( g );

    }
}

