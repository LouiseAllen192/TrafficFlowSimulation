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

    public SimulationController(SimpleControllerFactory c_fac) {
    	SimpleDriverFactory d_fac = new SimpleDriverFactory();
    	SimpleVehicleFactory v_fac = new SimpleVehicleFactory();
    	SimpleRoadFactory r_fac = new SimpleRoadFactory();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.drivers = new ArrayList<>();
    	this.screen_width = screenSize.getWidth() / 2;
    	this.screen_height = screenSize.getHeight() / 2;
    	this.center = new Point((int)(this.screen_width / 2), (int)(this.screen_height / 2));
    	this.road = r_fac.createRoad(3, this.center, 50, (int)this.screen_width, (int)this.screen_height);

    	addDriversToRoad(d_fac, v_fac);

    	this.collisionController = c_fac.createCollisionDetectionController(drivers);
    	this.graphics_manager = c_fac.createGraphicsController(this.screen_width, this.screen_height, this.drivers, this.road);
    }

    private void addDriversToRoad(SimpleDriverFactory d_fac, SimpleVehicleFactory v_fac) {
        Driver d1 = d_fac.createDriver("Aggressive",v_fac.createVehicle(new Point(0,0), 0, this.road, 1, 30, 50, 1, "pink-sports-car.png"), "Rob", 20, "Male");
        Driver d2 = d_fac.createDriver("Normal", v_fac.createVehicle(new Point(30,0), 250, this.road, 1, 30, 50, 2, "green-sports-car.png"), "Louise", 26, "Female");
        Driver d3 = d_fac.createDriver("Cautious", v_fac.createVehicle(new Point(0,0), 502, this.road, 2, 30, 50, 3, "red-sports-car.png"), "Russell", 20, "Male");
        Driver d4 = d_fac.createDriver("Aggressive",v_fac.createVehicle(new Point(0,0), 0, this.road, 0, 30, 50, 4, "pink-sports-car.png"), "Rob", 20, "Male");
        Driver d5 = d_fac.createDriver("Normal", v_fac.createVehicle(new Point(30,0), 800, this.road, 1, 30, 50, 5, "green-sports-car.png"), "Louise", 26, "Female");
        Driver d6 = d_fac.createDriver("Cautious", v_fac.createVehicle(new Point(0,0), 750, this.road, 1, 30, 50, 6, "red-sports-car.png"), "Russell", 20, "Male");
        Driver d7 = d_fac.createDriver("Aggressive",v_fac.createVehicle(new Point(0,0), 150, this.road, 2, 30, 50, 7, "pink-sports-car.png"), "Rob", 20, "Male");
        Driver d8 = d_fac.createDriver("Normal", v_fac.createVehicle(new Point(30,0), 20, this.road, 2, 30, 50, 8, "green-sports-car.png"), "Louise", 26, "Female");
        Driver d9 = d_fac.createDriver("Cautious", v_fac.createVehicle(new Point(0,0), 500, this.road, 0, 30, 50, 9, "red-sports-car.png"), "Russell", 20, "Male");

        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);
        //drivers.add(d4);
        //drivers.add(d5);
        //drivers.add(d6);
        //drivers.add(d7);
        //drivers.add(d8);
        //drivers.add(d9);
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
