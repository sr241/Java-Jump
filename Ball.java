import java.awt.*;
public class Ball{
    private int x,y; 
    private int startY;
    private double dy = 0;  // speed
    private int panel_width, panel_height;  // size of the panel 

    public Ball( int x, int y){
        this.x = x;
        this.y = y;
        startY = y;
    }

    public void setSpeed(int dy ){
        this.dy = dy;
    }

    public void move(){

        y = y + (int)dy;

        dy = dy + 1;
        if ( y >= startY ){
            dy = 0;
            y = startY;
        }

        if (y>=GameFrame.GAME_HEIGHT){
            dy = 0;
            y = GameFrame.GAME_HEIGHT-20;
        }
        //add code so that the player cannot move off the panel

    }

    public void jump(){
        dy = -20;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }
    public void setX(int n){
        x = n;
    }
    public void setY(int n){
        y = n;
    }
    public void draw(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillOval( x, y, 20, 20 );
        //repaint();
    }
}
