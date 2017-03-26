package Vehicle;

import java.awt.Color;
import java.awt.Point;

import Road.Road;

public class SimpleVehicleFactory {
	
	public Vehicle createVehicle(Point xy, int cellId, Road road, int laneId, int vWidth, int vHeight, int id, String imagePath){
		return new Vehicle(xy, cellId, road, laneId, vWidth, vHeight, id, imagePath);
	}
	public Vehicle createVehicle(Point xy, int cellId, Road road, int laneId, int vWidth, int vHeight, int id, Color color){
		return new Vehicle(xy, cellId, road, laneId, vWidth, vHeight, id, color);
	}
}
