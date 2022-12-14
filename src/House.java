import java.awt.*;

public class House {
    private int x, y, width, height;
    private Color color;
    private Door door;
    private Window window;
    private Plate plate;

    public House(int x, int y, int width, int height, Color c, Door door, Window window, Plate plate) {
        this.x = x;
        this.y = y; //координата левого нижнего угла
        this.width = width;
        this.height = height;
        this.color = c;
        this.door = door;
        this.window = window;
        this.plate = plate;
    }

    public void draw (Graphics2D g2d) {
        /*if (Math.random() > 0.3) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(this.x + this.width / 2, this.y - this.height, (int) (this.x + this.width / 2 + ( Math.random() * (30 - 10) ) + 10), (int) (this.y - this.height - ( Math.random() * (100 - 10) ) + 10));
            g2d.drawLine(this.x + this.width / 2, this.y - this.height, (int) (this.x + this.width / 2 - ( Math.random() * (30 - 10) ) + 10), (int) (this.y - this.height - ( Math.random() * (100 - 10) ) + 10));
        }*/
        g2d.setColor(this.color);
        g2d.fillRect(this.x, this.y - this.height, this.width, this.height);  //используем this.y - this.height (левый верхний угол)
        drawDoor(g2d);
        drawWindows(g2d);
        drawPlate(g2d);
    }

    private void drawDoor (Graphics2D g2d) {
        g2d.setColor(this.door.getColor());
        g2d.fillRect(this.x + this.width/2 - this.door.getWidth()/2, this.y - this.door.getHeight(), this.door.getWidth(), this.door.getHeight());
    }

    private void drawPlate (Graphics2D g2d) {
        g2d.setColor(this.plate.getColor());
        g2d.fillRect(this.x + this.width/2 + this.door.getWidth()/2 + this.plate.getStepFromDoor(), this.y - this.door.getHeight(), this.plate.getWidth(), this.plate.getHeight());
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Impact", Font.PLAIN, this.plate.getFontSize()));
        g2d.drawString(this.plate.getHouseNumber(), (int) (this.x + this.width/2 + this.door.getWidth() / 2 + this.plate.getStepFromDoor() + this.plate.getWidth() * 0.43), (int) (this.y - this.door.getHeight() + this.plate.getHeight() * 0.65));
    }

    private void drawWindows (Graphics2D g2d) {
        int widthBetweenWindows = (this.width - this.window.getWidth() * this.window.getWindowsOnFloor()) / (this.window.getWindowsOnFloor() + 1);
        int heightBetweenWindows = (this.height - this.door.getHeight() - this.window.getHeight() * this.window.getFloors()) / (this.window.getFloors() + 1);
        int tempX = this.x + widthBetweenWindows;
        int tempY = this.y - this.height + heightBetweenWindows;

        for (int row = 0; row < this.window.getFloors(); row++) {
            for (int col = 0; col < this.window.getWindowsOnFloor(); col++) {
                if (Math.random() > 0.93) {
                    g2d.setColor(this.window.getLightedColor());
                } else {
                    g2d.setColor(this.window.getColor());
                }
                g2d.fillRect(tempX, tempY, this.window.getWidth(), this.window.getHeight());
                tempX = tempX + this.window.getWidth() + widthBetweenWindows;
            }
            tempX = this.x + widthBetweenWindows;
            tempY = tempY + this.window.getHeight() + heightBetweenWindows;
        }
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
