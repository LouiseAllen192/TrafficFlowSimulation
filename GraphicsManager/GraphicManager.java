package GraphicsManager;

import Vehicle.Vehicle;
import java.awt.*;
import java.util.ArrayList;
import Road.Road;

public class GraphicManager implements Runnable{
    private String title;
    private int width;
    private int height;
    private Point centerPoint;
    private ArrayList<Vehicle> vehicles;
    private Road road;
    public DrawingComponent draw;


    private Thread thread;
    private Display display;

    public GraphicManager(Point centerPoint, int width, int height, ArrayList<Vehicle> cars, Road road) {
        this.width = width;
        this.height = height;
        this.title = "Traffic Flow Simulation";
        this.centerPoint = centerPoint;
        this.vehicles = cars;
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
                for(int i = 0; i < vehicles.size(); i++) {
                    draw.render(display, road, vehicles);
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



