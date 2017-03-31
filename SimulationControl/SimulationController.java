package SimulationControl;

import Driver.*;
import Vehicle.Vehicle;
import Road.Road;
import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.SimpleVehicleFactory;
import Road.SimpleRoadFactory;

import java.awt.*;
import java.util.ArrayList;

public class SimulationController extends Controller {

    private ArrayList<Driver> drivers;
    private final int agressive_drivers = 1;
    private double screen_width, screen_height;
    private Point center;
    private Controller graphics_manager; 
    private Road road;
    private Controller collisionController;
    public SimulationController() {
    	SimpleControllerFactory c_fac  = new SimpleControllerFactory();
    	SimpleDriverFactory d_fac = new SimpleDriverFactory();
    	SimpleVehicleFactory v_fac = new SimpleVehicleFactory();
    	SimpleRoadFactory r_fac = new SimpleRoadFactory();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.drivers = new ArrayList<>();
    	this.screen_width = screenSize.getWidth() / 2;
    	this.screen_height = screenSize.getHeight() / 2;
    	this.center = new Point((int)(this.screen_width / 2), (int)(this.screen_height / 2));
    	this.road = r_fac.createRoad(3, this.center, 50, (int)this.screen_width, (int)this.screen_height);
    	
    	Driver d1 = d_fac.createDriver("Aggressive",v_fac.createVehicle(new Point(0,0), 0, this.road, 1, 30, 50, 1, "pink-sports-car.png"), "Rob", 20, "Male");
    	Driver d2 = d_fac.createDriver("Normal", v_fac.createVehicle(new Point(30,0), 250, this.road, 1, 30, 50, 2, "green-sports-car.png"), "Louise", 26, "Female");
    	Driver d3 = d_fac.createDriver("Cautious", v_fac.createVehicle(new Point(0,0), 502, this.road, 2, 30, 50, 3, "red-sports-car.png"), "Russell", 20, "Male");
    	
   
		drivers.add(d1);
    	drivers.add(d2);
    	drivers.add(d3);
    	this.collisionController = c_fac.createController("Collision Detection Controller",drivers);
    	this.graphics_manager = c_fac.createController("Graphics Controller",this.screen_width, this.screen_height, this.drivers, this.road);
    }
    
    public void begin() {
    	// Start the drivers driving
    	for (Driver d : drivers) {
    		new Thread(d).start();
    	}
    	
    	new Thread(collisionController).start();
    	// Start showing them on screen
    	graphics_manager.run();
    }
}
