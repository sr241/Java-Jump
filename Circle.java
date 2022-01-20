import java.awt.*;


public class Circle {
    private int x,y;
    private int radius;

    public Circle(int xx, int yy) {
        x = xx;
        y = yy;
        radius = 10;
    }

    public int getRadius() {
        return radius;
    }

    public int getCenterX() {
        return x;
    }
    
    public int getCenterY() {
        return y;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}


