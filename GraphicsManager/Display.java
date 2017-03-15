package GraphicsManager;

import javax.swing.*;
import java.awt.*;

public class Display implements IDisplay {
    private String title;
    private JFrame frame;
    private Canvas canvas;
    private Dimension screen;

    public Display(String title, double screenWidth, double screenHeight)  {
        this.title = title;
        this.screen = new Dimension();
        screen.setSize(screenWidth, screenHeight);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(this.screen);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(this.screen);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(this.screen);

        frame.add(canvas);
        frame.pack();

    }
}
