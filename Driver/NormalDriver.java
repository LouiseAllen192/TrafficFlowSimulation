package Driver;

import java.awt.Color;
import java.util.HashMap;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class NormalDriver extends Driver {
	
	private int speedModifier = 3;
	private double crashChance = 0.0001;

	public NormalDriver(Vehicle _vehicle, Sight _sight) {
		super(_vehicle, _sight);
		this.vehicle.setColor(Color.green);
	}
	
	public void drive() {
		int currentLaneNo = this.vehicle.getCurrentLaneID();
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(currentLaneNo, this.vehicle.getCurrentCellID(), this.vehicle.getID());
		int currentLaneStatus = roadInfo.get(currentLaneNo);
		double rand = Math.random();
		
		if(currentLaneStatus > 80 || currentLaneStatus == -100 || crashChance == 1) {
			if(rand < crashChance && crashChance != 1) {
				crashChance = 1;
			}
			this.vehicle.accelerate(speedModifier);
		}
		else if(roadInfo.size() > 1) {
			
			boolean rightClear = false;
			boolean leftClear = false;
			
			if(currentLaneNo != 0 && roadInfo.get(currentLaneNo-1) == -100) {
				rightClear = true;
			} 
			
			if(currentLaneNo != (roadInfo.size()-1) && roadInfo.get(currentLaneNo+1) == -100) {
				leftClear = true;
			}
			
			if(rightClear && leftClear) {
				if(rand < 0.5) {
					this.vehicle.changeLane(currentLaneNo-1);
				}
				else {
					this.vehicle.changeLane(currentLaneNo+1);
				}
					
			}
			else if(rightClear) {
				this.vehicle.changeLane(currentLaneNo-1);
			}
			else if(leftClear) {
				this.vehicle.changeLane(currentLaneNo+1);
			}
		}
	}
}
