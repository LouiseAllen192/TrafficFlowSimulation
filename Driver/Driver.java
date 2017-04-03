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

	/*
	public double checkAvailableLanes(int cellsToCheck, double chanceToCrash) {
		//check what lanes can be moved into after spotting vehicle ahead
		//chanceToCrash should be a decimal between 0 and 1
		double rand = Math.random();
		
		if(rand > chanceToCrash) {
			boolean laneToLeft = true;
			boolean laneToRight = true;
			boolean leftClear = false;
			boolean rightClear = false;
			int currentLane = this.vehicle.getCurrentLaneID();
			int noOfLanes = this.vehicle.getRoad().getLanes().size();
			int currentCell = this.vehicle.getCurrentCell();
			int vehicleID = this.vehicle.getID();
			
			if(currentLane == 0)
				laneToRight = false;
			
			if(currentLane == (noOfLanes-1))
				laneToLeft = false;
			
			if(laneToLeft)
				leftClear = !(this.sight.checkLane(this.vehicle.getRoad().getLane(currentLane+1), currentCell, vehicleID, cellsToCheck, cellsToCheck));
			
			if(laneToRight)
				rightClear = !(this.sight.checkLane(this.vehicle.getRoad().getLane(currentLane-1), currentCell, vehicleID, cellsToCheck, cellsToCheck));
			
			if(leftClear && rightClear) {
				//pick random lane to move into
				if(Math.random() < 0.5)
					rightClear = false;
				else
					leftClear = false;
			}
			
			if(leftClear && rand > chanceToCrash) {
				this.vehicle.getState().moveLane(currentLane+1, this.vehicle);
			} else if(rightClear && rand > chanceToCrash) {
				this.vehicle.getState().moveLane(currentLane-1, this.vehicle);
			}
			
			return chanceToCrash;
		}
		else {
            // System.out.println("OH NO GONNA CRASH");
            return 1;
            //return 1 so that car can't change lanes a second later
			// if we didn't change the driver's crashChance, they'd have to fail to check lanes 3 or 4 
			// times in a row before they actually crash, due to how often this method is called
        }
	} */

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
