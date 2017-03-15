package SimulationControl;


import GraphicsManager.GraphicManager;
import Driver.*;
import Vehicle.Vehicle;
import Road.Road;
import SensoryPerception.Hearing;
import SensoryPerception.Sight;

import java.awt.*;
import java.util.ArrayList;

public class SimulationController {

    private ArrayList<Driver> drivers;
    private final int agressive_drivers = 1;
    private double screen_width, screen_height;
    private Point center;
    private GraphicManager graphics_manager;
    private Road road;

    public SimulationController() {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.drivers = new ArrayList<>();
    	this.screen_width = screenSize.getWidth() / 2;
    	this.screen_height = screenSize.getHeight() / 2;
    	this.center = new Point((int)(this.screen_width / 2), (int)(this.screen_height / 2));
    	this.road = new Road(this.center, (int)this.screen_width, (int)this.screen_height);
    	
    	AggressiveDriver d1 = new AggressiveDriver(new Vehicle(new Point(0,0), 0, this.road, 30, 50, "pink-sports-car.png"), "Rob", 20, "Male");
    	NormalDriver d2 = new NormalDriver(new Vehicle(new Point(30,0), 0, this.road, 30, 50, "green-sports-car.png"), "Louise", 26, "Female");
    	
    	drivers.add(d1);       
    	drivers.add(d2);
    	

    	this.graphics_manager = new GraphicManager(this.screen_width, this.screen_height ,drivers, this.road);
    }
    
    public void begin() {
    	// Start the drivers driving
    	for (Driver d : drivers) {
    		new Thread(d).start();
    	}
    	
    	// Start showing them on screen
    	graphics_manager.run();
    }
}
