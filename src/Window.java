import java.awt.*;

public class Window extends Door{
    private int floors;
    private int windowsOnFloor;
    private Color lightedColor;

    public Window(int width, int height, Color color, int floors, int windowsOnFloor, Color lightedColor) {
        super(width, height, color);
        this.floors = floors;
        this.windowsOnFloor = windowsOnFloor;
        this.lightedColor = lightedColor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getWindowsOnFloor() {
        return windowsOnFloor;
    }

    public void setWindowsOnFloor(int windowsOnFloor) {
        this.windowsOnFloor = windowsOnFloor;
    }

    public Color getLightedColor() {
        return lightedColor;
    }

    public void setLightedColor(Color lightedColor) {
        this.lightedColor = lightedColor;
    }
}
