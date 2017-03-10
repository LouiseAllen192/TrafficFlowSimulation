package GraphicsManager;

import Vehicle.Vehicle;
import java.awt.*;
import java.util.ArrayList;

public class GraphicManager implements Runnable{
    private String title;
    private int width;
    private int height;
    private Point centerPoint;
    private ArrayList<Vehicle> vehicles;
    public DrawingComponent draw;


    private Thread thread;
    private Display display;

    public GraphicManager(Point centerPoint, int width, int height, ArrayList<Vehicle> cars) {
        this.width = width;
        this.height = height;
        this.title = "Traffic Flow Simulation";
        this.centerPoint = centerPoint;
        this.vehicles = cars;
        this.draw = new DrawingComponent(centerPoint, width, height);
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
                for(int i = 0; i < vehicles.size(); i++) {
                    draw.render(vehicles.get(i), display);
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



