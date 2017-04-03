package Vehicle;

import java.awt.Color;
import java.awt.Point;

import Road.Road;

public class SimpleVehicleFactory {
	
	public Vehicle createVehicle(Point xy, int cellId, Road road, int laneId, int numLanes, int id, String imagePath){
		return new Vehicle(xy, cellId, road, laneId, numLanes, id, imagePath);
	}
	
}
