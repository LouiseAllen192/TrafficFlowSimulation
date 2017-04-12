package Driver;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Threading.Timer;
import Vehicle.Vehicle;

public class Driver implements Runnable {

	protected Sight sight;
	protected Vehicle vehicle;
	protected double speedModifier;

	public Driver(Vehicle _vehicle, Sight _sight) {
		this.sight = _sight;
		this.vehicle = _vehicle;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public Sight getSight() {
		return this.sight;
	}

	public void stop() {
		
	}

	public void drive() {
		
	}

	public void run() {
		Timer t = new Timer(Timer.DEFAULT_FRAMERATE);
    	t.setMessage("Driver");
		while(true) {
			t.start();
			this.drive();
			t.end();
		}
	}
}
