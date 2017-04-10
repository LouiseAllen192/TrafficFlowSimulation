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
		this.vehicle =_vehicle;
	}
	
	/*

	public Hearing getDriverHearing() {
		return driverHearing;
	}

	public void setDriverHearing(Hearing driverHearing) {
		this.driverHearing = driverHearing;
	}

	public Sight getDriverSight() {
		return driverSight;
	}

	public void setDriverSight(Sight driverSight) {
		this.driverSight = driverSight;
	}

	public Vehicle getDriverVehicle() {
		return driverVehicle;
	}

	public void setDriverVehicle(Vehicle driverVehicle) {
		this.driverVehicle = driverVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	*/
	
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
