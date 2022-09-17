import java.awt.*;

public class Moon {
    private int x, y, r;
    private Color color;

    public void drawMoon(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.fillOval(x, y, r * 2, r * 2);
    }

    public Moon(int x, int y, int r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
