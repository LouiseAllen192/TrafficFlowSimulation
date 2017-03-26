package SimulationControl;

import java.util.ArrayList;

import Driver.Driver;
import Road.Road;

public class SimpleControllerFactory {
	public Controller createController(String type){
		if(type.equals("Simulation Controller"))
			return new SimulationController();
		else
			return new TrafficSimulation();
		
	}
	public Controller createController(String type, ArrayList<Driver> d){
		if(type.equals("Collision Detection Controller"))
			return  new CollisionDetectionController(d);
		return null;
	}
	public Controller createController(String type, double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road){
		if(type.equals("Graphics Controller"))
			return new GraphicsController(screenWidth, screenHeight, drivers, road);
		return null;
		
	}

}
