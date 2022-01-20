import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.geom.RectangularShape.*;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
public class Obstacle {
    private int x;   // top left
    private int y;
    // private int yy;
    private int dx;  // speed
    private boolean good;
    //private BufferedImage img;
    private Rectangle r;
    //private int img_width, img_height;
    private int random = (int)(21*Math.random())+50;
    public Obstacle( int x, int y ){
        //         this.x = x;
        //         this.y = y;
        dx = -1*((int)(3*Math.random()+1));
        this.x = 450;
        this.y = 450;
          //  dx = -2;

    }

    public void move(){
        x += dx;
    }

    public int getX(){
        return x;
    }

    public void draw(  Graphics g ){
        g.setColor(Color.BLACK);
        g.fillRect( x, y - random + 50, 20, random );
    }

    public Rectangle getShape(){
        return new Rectangle( x, y - random + 50, 20, random );
    }
}

