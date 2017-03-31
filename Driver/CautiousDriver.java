package Driver;

import java.awt.Color;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class CautiousDriver extends Driver {
	
	private int speedModifier = 1;
	private double crashChance = 0;
	
	public CautiousDriver() {
		
	}

	public CautiousDriver(Vehicle driverVehicle, String name, int age, String sex) {
		super(driverVehicle, name, age, sex);
		//driverVehicle.setColor(Color.blue); this doesn't do anything at the moment
	}
	
	public void drive(){
		//run calls drive
		boolean carAhead = this.getDriverSight().checkLane(this.driverVehicle.getLane(), this.driverVehicle.getCurrentCell(), this.driverVehicle.getID(), 0, 15);
		if(carAhead)
			crashChance = this.checkAvailableLanes(15, crashChance);
		this.driverVehicle.accelerate(speedModifier);
	}
}
