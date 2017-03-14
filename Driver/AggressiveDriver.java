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
		//run calls drive
		this.driverVehicle.accelerate(speedModifier);
	}
}
