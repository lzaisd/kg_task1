import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        dp = new DrawPanel();
        this.add(dp);
    }
}
