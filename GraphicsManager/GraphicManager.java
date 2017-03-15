package GraphicsManager;

import java.awt.*;
import java.util.ArrayList;
import Road.Road;
import Driver.*;

public class GraphicManager implements Runnable{

    private String title;
    private int width, height;
    private double screenWidth, screenHeight;
    public DrawingComponent draw;
    private ArrayList<Driver> drivers;

    private Thread thread;
    private IDisplay display;

    public GraphicManager(Point centerPoint, int width, int height, double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road) {
        this.width = width;
        this.height = height;
        this.title = "Traffic Flow Simulation";
        //this.centerPoint = centerPoint;
        this.drivers = drivers;
        //this.road = road;
        this.draw = new DrawingComponent(screenHeight, screenWidth, road, drivers);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void run() {
        init();

        while(true) {
        	try{
        		draw.render(display);
        		Thread.sleep(33);
        	} catch(InterruptedException ex) {
        		
        	}
        }
        /*
        int fps = 40;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();

        while (true) {
            delta = delta + (System.nanoTime() - current) / timePerTick;
            current = System.nanoTime();
            if (delta > 1) {
                draw.render(display);
                delta--;
            }
        }
        */
    }
    

    public void init() {
        display = new Display(title, width, height, screenWidth, screenHeight);
        display.createDisplay();
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



