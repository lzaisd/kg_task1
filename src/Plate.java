import java.awt.*;

public class Plate extends Door{
    private int stepFromDoor;
    private String houseNumber;
    private int fontSize;

    public Plate(int width, int height, Color color, int stepFromDoor, String houseNumber, int fontSize) {
        super(width, height, color);
        this.stepFromDoor = stepFromDoor;
        this.houseNumber = houseNumber;
        this.fontSize = fontSize;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getStepFromDoor() {
        return stepFromDoor;
    }

    public void setStepFromDoor(int stepFromDoor) {
        this.stepFromDoor = stepFromDoor;
    }
}
