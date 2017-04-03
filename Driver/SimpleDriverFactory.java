package Driver;

import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class SimpleDriverFactory {
	
	public static enum DriverType {
		NORMAL,
		CAUTIOUS,
		AGRESSIVE
	};
	
	public Driver createDriver(DriverType type, Vehicle _vehicle, Sight _sight){
		
		// This method should never return NULL
		switch(type) {
		case NORMAL:
			return new NormalDriver(_vehicle, _sight);
		case CAUTIOUS:
			return new CautiousDriver(_vehicle, _sight);
		case AGRESSIVE:
			return new AggressiveDriver(_vehicle, _sight);
		default:
			return new NormalDriver(_vehicle, _sight);
		}
	}
	
}
