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
    private int numLanes;
    private double screen_width, screen_height;
    private Point center;
    private Controller graphics_manager; 
    private Road road;
    private Controller collisionController;
    private Sight sight;

    public SimulationController(SimpleControllerFactory c_fac) {
    	SimpleDriverFactory d_fac = new SimpleDriverFactory();
    	SimpleVehicleFactory v_fac = new SimpleVehicleFactory();
    	SimpleRoadFactory r_fac = new SimpleRoadFactory();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.drivers = new ArrayList<>();
    	this.screen_width = screenSize.getWidth() / 2;
    	this.screen_height = screenSize.getHeight() / 2;
    	this.numLanes = 14; // max 30
    	this.center = new Point((int)(this.screen_width), (int)(this.screen_height));
    	this.road = r_fac.createRoad(this.numLanes, this.center, screen_width, screen_height);
    	this.sight = new Sight(this.road);
    	
    	addDriversToRoad(d_fac, v_fac);

    	this.collisionController = c_fac.createCollisionDetectionController(drivers);
    	this.graphics_manager = c_fac.createGraphicsController(this.screen_width, this.screen_height, this.drivers, this.road);
    }

    private void addDriversToRoad(SimpleDriverFactory d_fac, SimpleVehicleFactory v_fac) {
    	int count = 200;
    	for (int i = 0; i < count; i++) {
    		Driver d = null;
    		Vehicle vehicle = null;
    		int start_loc = (1000 / count) * i;
    		switch (i % 3) {
    		case 0:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "pink-sports-car.png");
        		d = d_fac.createDriver(SimpleDriverFactory.DriverType.AGRESSIVE, vehicle, this.sight);
    			break;
    		case 1:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "green-sports-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.NORMAL, vehicle, this.sight);
    			break;
    		case 2:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes,  i, "red-sports-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.CAUTIOUS, vehicle, this.sight);
    			break;
    		}
    		drivers.add(d);
    	}
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
