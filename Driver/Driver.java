package Driver;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;
import Vehicle.VehicleStatesEnum;

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

	public void checkAvailableLanes() {
		//check what lanes can be moved into
		boolean laneToLeft = true;
		boolean laneToRight = true;
		boolean leftClear = false;
		boolean rightClear = false;
		boolean isCrashed = this.driverVehicle.isCrashed();
		int currentLane = this.driverVehicle.getCurrentLaneID();
		int noOfLanes = this.driverVehicle.getRoad().getLanes().size();
		int currentCell = this.driverVehicle.getCurrentCell();
		int vehicleID = this.driverVehicle.getID();
		
		if(currentLane == 0)
			laneToRight = false;
		
		if(currentLane == (noOfLanes-1))
			laneToLeft = false;
		
		if(laneToLeft)
			leftClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane+1), currentCell, vehicleID, isCrashed, 10, 10));
		
		if(laneToRight)
			rightClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane-1), currentCell, vehicleID, isCrashed, 10, 10));
		
		if(leftClear && rightClear) {
			//pick random lane to move into
			if(Math.random() < 0.5)
				rightClear = false;
			else
				leftClear = false;
		}
		
		if(leftClear)
			this.driverVehicle.getState().moveLane(currentLane+1, this.driverVehicle);
		else if(rightClear)
			this.driverVehicle.getState().moveLane(currentLane-1, this.driverVehicle);
	}

	public void stop() {
		
	}

	public void drive() {
		
	}

	public void run() {
		while(true) {
			if(this.driverVehicle.getStateEnum() == VehicleStatesEnum.DRIVING)
				this.drive();
			try {
				Thread.sleep(33);
			} catch(InterruptedException ex) {
				
			}
		}
	}
}
