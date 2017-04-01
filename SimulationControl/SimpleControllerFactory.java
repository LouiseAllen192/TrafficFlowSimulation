package SimulationControl;

import java.util.ArrayList;

import Driver.Driver;
import Road.Road;

public class SimpleControllerFactory {

	public Controller createSimulationController(SimpleControllerFactory factory) {
        return new SimulationController(factory);
    }

	public Controller createCollisionDetectionController(ArrayList<Driver> d) {
		return  new CollisionDetectionController(d);
	}

	public Controller createGraphicsController(double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road){
		return new GraphicsController(screenWidth, screenHeight, drivers, road);
	}

}
