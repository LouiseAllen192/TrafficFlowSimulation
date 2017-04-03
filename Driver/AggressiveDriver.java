package Driver;

import java.awt.*;
import java.util.HashMap;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class AggressiveDriver extends Driver {
	
	private int speedModifier = 5;
	private double crashChance = 0.02;
	
	public AggressiveDriver(Vehicle _vehicle, Sight _sight) {
		super(_vehicle, _sight);
		this.vehicle.setColor(Color.red);
	}
	
	public void drive() {
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(this.vehicle.getCurrentLaneID(), this.vehicle.getCurrentCellID());
		this.vehicle.accelerate(speedModifier);
		
		// Should now know if there is a car ahead, and in which lane.
		
		/*
		boolean carAhead = this.sight.checkLane(this.vehicle.getLane(), this.vehicle.getCurrentCell(), this.vehicle.getID(), 0, 15);
		if(carAhead) {
			crashChance = this.checkAvailableLanes(10, crashChance);
		}
		this.vehicle.accelerate(speedModifier);
		*/
	}
}
