package Driver;

import Vehicle.Vehicle;

public class SimpleDriverFactory {
	public Driver createDriver(String type,Vehicle driverVehicle, String name, int age, String sex){
		Driver d = null;
		
		if(type.equals("Aggressive"))
			d = new AggressiveDriver(driverVehicle, name, age, sex);
		else if(type.equals("Normal"))
			d = new NormalDriver(driverVehicle, name, age, sex);
		else if(type.equals("Cautious"))
			d = new CautiousDriver(driverVehicle, name, age, sex);
		return d;
	}
}
