package Driver;

import java.awt.*;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class AggressiveDriver extends Driver{
	
	private int speedModifier = 5;
	
	public AggressiveDriver() {
		
	}
	
	public AggressiveDriver(Vehicle driverVehicle, String name, int age, String sex) {
		super(driverVehicle, name, age, sex);
		driverVehicle.setColor(Color.red);
	}
	
	public void drive(){
		boolean carAhead = this.getDriverSight().checkLane(this.driverVehicle.getLane(), this.driverVehicle.getCurrentCell(), this.driverVehicle.getID(), this.driverVehicle.isCrashed(), 0, 15);
		if(carAhead)
			this.checkAvailableLanes();
		this.driverVehicle.accelerate(speedModifier);
	}
}
