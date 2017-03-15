package GraphicsManager;

import javax.swing.*;
import java.awt.*;

public class Display implements IDisplay {
    private String title;
    private int width;
    private int height;
    private JFrame frame;
    private Canvas canvas;
    private int screenWidth, screenHeight;

    public Display(String title, int width, int height, double screenWidth, double screenHeight)  {
        this.title = title;
        this.width = width;
        this.height = height;
        this.screenWidth = (int) screenWidth;
        this.screenHeight = (int) screenHeight;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(this.screenWidth , this.screenHeight);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));

        frame.add(canvas);
        frame.pack();

    }
}
