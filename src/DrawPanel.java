import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color BG_UP_COLOR = new Color(13, 33, 121);
    private static final Color BG_DOWN_COLOR = new Color(4, 15, 51);
    private static final Color HOUSE_COLOR = new Color(75, 75, 75);
    private static final Color GROUND_COLOR = new Color(49, 49, 49);
    private static final Color DOOR_COLOR = new Color(28, 28, 28);
    private static final Color WINDOW_COLOR = new Color(28, 28, 28);
    private static final int groundHeight = 30;
    private static final Random rnd = new Random();

    private Door door;
    private Window window;
    private Moon moon;

    public DrawPanel() {
        door = new Door(50, 75, DOOR_COLOR);
        window = new Window(30, 20, WINDOW_COLOR, 8, 5);
    }


    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, BG_DOWN_COLOR,0 ,getHeight() , BG_UP_COLOR);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        drawStars(g2d);
        g2d.setColor(GROUND_COLOR);
        g2d.fillRect(0, getHeight() - groundHeight, getWidth(), groundHeight);
        moon.drawMoon(g2d);

        House house = new House(200, getHeight(), 400, 500, HOUSE_COLOR, door, window);

        house.draw(g2d);
    }

    private void drawStars(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        int indent = 80;
        int x = indent;
        int y = indent;
        double rand;
        for (int row = 0; row < getHeight()/indent; row++) {
            for (int col = 0; col < getWidth()/indent; col++) {
                rand = rnd.nextDouble(1);
                if (rand >= 0.6 && rand < 0.85) {
                    g2d.drawLine(x, y, x, y);
                } else if (rand >=0.85) {
                    g2d.drawLine(x - 1, y, x + 1, y);
                    g2d.drawLine(x, y - 1, x, y + 1);
                }
                x += indent + rnd.nextInt(10) - rnd.nextInt(10);
                y += rnd.nextInt(10) - rnd.nextInt(10);
            }
            x = indent;
            y = indent * (row + 1);
        }
    }
}
