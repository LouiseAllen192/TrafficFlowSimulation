package GraphicsManager;

import javax.swing.*;
import java.awt.*;

public class Display {
    private String title;
    private int width;
    private int height;
    private JFrame frame;
    public static Canvas canvas;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    public void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setBackground(new Color(51, 204, 51));
        frame.add(canvas);
        frame.pack();
    }
}
