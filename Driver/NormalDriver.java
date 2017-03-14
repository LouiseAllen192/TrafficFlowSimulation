package Driver;

import java.awt.Color;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class NormalDriver extends Driver {
	
	private int speedModifier = 1;
	
	public NormalDriver() {
		
	}

	public NormalDriver(Vehicle driverVehicle, String name, int age, String sex) {
		super(driverVehicle, name, age, sex);
		driverVehicle.setColor(Color.green);
	}
	
	public void drive(){
		//run calls drive
		this.driverVehicle.accelerate(speedModifier);
	}
}
