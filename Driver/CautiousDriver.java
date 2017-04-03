package Driver;

import java.awt.Color;
import java.util.HashMap;

import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class CautiousDriver extends Driver {
	
	private int speedModifier = 1;
	private double crashChance = 0;

	public CautiousDriver(Vehicle _vehicle, Sight _sight) {
		super(_vehicle, _sight);
	}
	
	public void drive() {
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(this.vehicle.getCurrentLaneID(), this.vehicle.getCurrentCellID());
		this.vehicle.accelerate(speedModifier);
		
		// Should now know if there is a car ahead, and in which lane.
		
		/*
		boolean carAhead = this.getSight().checkLane(this.getVehicle().getLane(), this.getVehicle().getCurrentCell(), this.getVehicle().getID(), 0, 15);
		if(carAhead) {
			crashChance = this.checkAvailableLanes(15, crashChance);
		} this.vehicle.accelerate(speedModifier);
		*/
	}
}
