package GraphicsManager;

import java.awt.*;
import java.util.ArrayList;
import Road.Road;
import Driver.*;

public class GraphicManager implements Runnable{

    private String title;
    private double screenWidth, screenHeight;
    public DrawingComponent draw;

    //private Thread thread;
    private IDisplay display;

    public GraphicManager(double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road) {
        this.title = "Traffic Flow Simulation";
        this.draw = new DrawingComponent(screenWidth, screenHeight, road, drivers);
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
        		ex.printStackTrace();
        	}
        }
    }

    public void init() {
        display = new Display(title, screenWidth, screenHeight);
        display.createDisplay();
    }

    /*
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
    }*/
}



