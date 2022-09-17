import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color BG_UP_COLOR = new Color(13, 33, 121);
    private static final Color BG_DOWN_COLOR = new Color(4, 15, 51);
    private static final Color HOUSE_COLOR_FRONT = new Color(75, 75, 75);
    private static final Color HOUSE_COLOR_BACK = new Color(63, 63, 63);
    private static final Color GROUND_COLOR = new Color(49, 49, 49);
    private static final Color DOOR_COLOR = new Color(28, 28, 28);
    private static final Color WINDOW_COLOR = new Color(28, 28, 28);
    private static final Color WINDOW_LIGHTED_COLOR = new Color(255, 166, 0);
    private static final Color PLATE_COLOR = new Color(13, 33, 121, 105);
    private static final int groundHeight = 50;
    private static final Random rnd = new Random();

    private Moon moon;

    public DrawPanel() {
        moon = new Moon(rnd.nextInt(1700), rnd.nextInt(500), 45, Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, BG_DOWN_COLOR,0 ,getHeight() , BG_UP_COLOR);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        drawStars(g2d);
        g2d.setColor(GROUND_COLOR);
        g2d.fillRect(0, getHeight() - groundHeight, getWidth(), groundHeight);
        moon.drawMoon(g2d);

        drawHouses(g2d);
    }

    private void drawHouses (Graphics2D g2d) {
        int x = 50;
        double coef;
        int k = 1;

        while (x < getWidth() - 250) {
            coef = ( Math.random() * (1 - 0.4) ) + 0.4;
            Door door = new Door((int) (50 * coef), (int) (75 * coef), DOOR_COLOR);
            Window window = new Window((int) (30 * coef), (int) (20 * coef), WINDOW_COLOR, 8 + rnd.nextInt(2) - rnd.nextInt(2), 5 + rnd.nextInt(2) - rnd.nextInt(2), WINDOW_LIGHTED_COLOR);
            Plate plate = new Plate((int) (50 * coef), (int) (45 * coef), PLATE_COLOR, (int) (80 * coef), Integer.toString(k), (int) (25 * coef));
            House house;
            if (coef < 0.6) {
                house = new House(x + rnd.nextInt(50) - rnd.nextInt(50), (int) (getHeight() - groundHeight + groundHeight * coef), (int) (400 * coef), (int) (500 * coef), HOUSE_COLOR_BACK, door, window, plate);
            } else {
                house = new House(x + rnd.nextInt(50) - rnd.nextInt(50), (int) (getHeight() - groundHeight + groundHeight * coef), (int) (400 * coef), (int) (500 * coef), HOUSE_COLOR_FRONT, door, window, plate);
            }
            house.draw(g2d);
            x += 400 * coef + 75;
            k++;
        }
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
