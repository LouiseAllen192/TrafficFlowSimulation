package Driver;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Threading.Timer;
import Vehicle.Vehicle;

public class Driver implements Runnable {

	private Hearing driverHearing;
	private Sight driverSight;
	private String name;
	private int age;
	private String sex;
	protected double speedModifier;
	protected Vehicle driverVehicle;

	public Driver() {
		driverHearing = new Hearing();
		driverSight = new Sight();
		name = "default";
		age = 12;
		sex = "Male";
		speedModifier = 1;
	}

	public Driver(Vehicle driverVehicle, String name, int age, String sex) {
		this.driverHearing = new Hearing();
		this.driverSight = new Sight();
		this.driverVehicle = driverVehicle;
		this.name = name;
		this.age = age;
		this.sex = sex;
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

	public double checkAvailableLanes(int cellsToCheck, double chanceToCrash) {
		//check what lanes can be moved into after spotting vehicle ahead
		//chanceToCrash should be a decimal between 0 and 1
		double rand = Math.random();
		
		if(rand > chanceToCrash) {
			boolean laneToLeft = true;
			boolean laneToRight = true;
			boolean leftClear = false;
			boolean rightClear = false;
			int currentLane = this.driverVehicle.getCurrentLaneID();
			int noOfLanes = this.driverVehicle.getRoad().getLanes().size();
			int currentCell = this.driverVehicle.getCurrentCell();
			int vehicleID = this.driverVehicle.getID();
			
			if(currentLane == 0)
				laneToRight = false;
			
			if(currentLane == (noOfLanes-1))
				laneToLeft = false;
			
			if(laneToLeft)
				leftClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane+1), currentCell, vehicleID, cellsToCheck, cellsToCheck));
			
			if(laneToRight)
				rightClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane-1), currentCell, vehicleID, cellsToCheck, cellsToCheck));
			
			if(leftClear && rightClear) {
				//pick random lane to move into
				if(Math.random() < 0.5)
					rightClear = false;
				else
					leftClear = false;
			}
			
			if(leftClear && rand > chanceToCrash)
				this.driverVehicle.getState().moveLane(currentLane+1, this.driverVehicle);
			else if(rightClear && rand > chanceToCrash)
				this.driverVehicle.getState().moveLane(currentLane-1, this.driverVehicle);
				
			return chanceToCrash;
		}
		else {
            // System.out.println("OH NO GONNA CRASH");
            return 1;
            //return 1 so that car can't change lanes a second later
			/*if we didn't change the driver's crashChance, they'd have to fail to check lanes 3 or 4 
			  times in a row before they actually crash, due to how often this method is called */
        }
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
