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
		int currentLaneNo = this.vehicle.getCurrentLaneID();
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(currentLaneNo, this.vehicle.getCurrentCellID(), this.vehicle.getID());
		int currentLaneStatus = roadInfo.get(currentLaneNo);
		
		if(currentLaneStatus > 70 || currentLaneStatus == -100)// || crashChance == 1)
			this.vehicle.accelerate(speedModifier);
		//else stop - cautious drivers are too afraid to overtake
	}
}
