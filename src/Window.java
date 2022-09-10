import java.awt.*;

public class Window extends Door{
    private int floors;
    private int windowsOnFloor;

    public Window(int width, int height, Color color, int floors, int windowsOnFloor) {
        super(width, height, color);
        this.floors = floors;
        this.windowsOnFloor = windowsOnFloor;
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
}
