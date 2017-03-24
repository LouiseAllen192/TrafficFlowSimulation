package SimulationControl;

import java.util.ArrayList;

import Driver.Driver;
import GraphicsManager.Display;
import GraphicsManager.DrawingComponent;
import GraphicsManager.IDisplay;
import Road.Road;


public class GraphicsController implements Runnable{

    private String title;
    private double screenWidth, screenHeight;
    public DrawingComponent draw;

    //private Thread thread;
    private IDisplay display;

    public GraphicsController(double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road) {
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
        		Thread.sleep(16);
        	} catch(InterruptedException ex) {
        		ex.printStackTrace();
        	}
        }
    }

    public void init() {
        display = new Display(title, screenWidth, screenHeight);
        display.createDisplay();
    }
}



