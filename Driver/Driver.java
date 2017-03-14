package Driver;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class Driver implements Runnable {

	private Hearing driverHearing;
	private Sight driverSight;
	private String name;
	private int age;
	private String sex;
	private boolean hasCrashed;
	protected double speedModifier;
	protected Vehicle driverVehicle;

	public Driver() {
		driverHearing = new Hearing();
		driverSight = new Sight();
		// driverVehicle = new Vehicle();
		name = "default";
		age = 12;
		sex = "Male";
		hasCrashed = false;
		speedModifier = 1;
	}

	public Driver(Vehicle driverVehicle, String name, int age, String sex) {
		this.driverHearing = new Hearing();
		this.driverSight = new Sight();
		this.driverVehicle = driverVehicle;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.hasCrashed = false;
	}

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

	public boolean hasCrashed() {
		return hasCrashed;
	}

	public void setHasCrashed(boolean hasCrashed) {
		this.hasCrashed = hasCrashed;
	}

	public void overtake() {
		// We don't know how this will work yet
	}

	public void stop() {
		// driverVehicle.setCurrentSpeed(0);
	}

	public void drive() {
		// Is drive going to be continuously called or a constantly looping
		// while-loop?
		/*
		 * boolean vehicleAhead = driverSight.lookForVehicles();
		 * if(vehicleAhead) driverVehicle.decellerate(); else
		 * driverVehicle.accellerate();
		 * 
		 * driverVehicle.updateCurrentCell(); //is this called from here or
		 * accelerate/decellerate?
		 * 
		 * graphics.updaatePosition(driverVehicle);
		 */
		
	}

	public void run() {
		final long NANOSEC_PER_SEC = 1000l * 1000 * 1000;

		long startTime = System.nanoTime();
		long currentTime;
		while ((currentTime = System.nanoTime()) > 0) {
			if ((currentTime - startTime) > (NANOSEC_PER_SEC / 16)) {
				startTime = currentTime;
				this.drive();
			}
		}
	}
}
