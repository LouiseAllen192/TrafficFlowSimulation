package Driver;

import java.awt.Color;
import java.util.HashMap;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class NormalDriver extends Driver {
	
	private int speedModifier = 3;
	private double crashChance = 0.005;

	public NormalDriver(Vehicle _vehicle, Sight _sight) {
		super(_vehicle, _sight);
		this.vehicle.setColor(Color.green);
	}
	
	public void drive() {
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(this.vehicle.getCurrentLaneID(), this.vehicle.getCurrentCellID());
		this.vehicle.accelerate(speedModifier);
		
		// Should now know if there is a car ahead, and in which lane.

		/*
		boolean carAhead = this.sight.checkLane(this.vehicle.getLane(), this.vehicle.getCurrentCell(), this.vehicle.getID(), 0, 15);
		if(carAhead)
			crashChance = this.checkAvailableLanes(12, crashChance);
		this.vehicle.accelerate(speedModifier);
		*/
	}
}
