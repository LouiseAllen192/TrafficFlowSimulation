package GraphicsManager;

import java.awt.*;
import java.util.ArrayList;
import Road.Road;
import Driver.*;

public class GraphicManager implements Runnable{
    private String title;
    private int width;
    private int height;
    private Point centerPoint;
    private Road road;
    public DrawingComponent draw;
    private ArrayList<Driver> drivers;


    private Thread thread;
    private Display display;

    public GraphicManager(Point centerPoint, int width, int height, ArrayList<Driver> drivers, Road road) {
        this.width = width;
        this.height = height;
        this.title = "Traffic Flow Simulation";
        this.centerPoint = centerPoint;
        this.drivers = drivers;
        this.road = road;
        this.draw = new DrawingComponent(centerPoint, 1920, 1080);
    }

    public void run() {
        init();

        int fps = 40;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();

        while (true) {
            delta = delta + (System.nanoTime() - current) / timePerTick;
            current = System.nanoTime();
            if (delta > 1) {
                for(int i = 0; i < drivers.size(); i++) {
                    draw.render(display, road, drivers);
                }
                delta--;
            }
        }
    }
    

    public void init() {
        display = new Display(title, width, height);
    }

    public synchronized void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



