package Driver;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

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
		
		//for the next two ifs, call vehicle.getLane and then call checkOccupiedCells for say 10 cells either side of our current position (less for aggressive, more for cautious)
		if(laneToLeft) {
			leftClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane+1), currentCell, vehicleID, isCrashed, 10, 10));
			if(leftClear) {
				System.out.println("Can go left");
				moveLane((driverVehicle.getCurrentLaneID())+1);
			}
			else
				System.out.println("LEFT NOT CLEAR");
		}
		else if(laneToRight) {
			rightClear = !(driverSight.checkLane(driverVehicle.getRoad().getLane(currentLane-1), currentCell, vehicleID, isCrashed, 10, 10));
			if(rightClear) {
				System.out.println("Can go right");
				moveLane(driverVehicle.getCurrentLaneID()-1);
			}
			else
				System.out.println("RIGHT NOT CLEAR");
		}
		
		/*if(leftClear && rightClear)
			//pick random one
		else if(leftClear)
			//moveLeft
		else if(rightClear)
			//moveRight*/
		
		//check if those lanes have cars near
		//move*/
	}

	public void stop() {
		
	}

	public void drive() {
		
	}

	public void run() {
		while(true) {
			if(!this.driverVehicle.isCrashed())
				this.drive();
			try {
				Thread.sleep(33);
			} catch(InterruptedException ex) {
				
			}
		}
	}
	
	public void moveLane(int laneID) {
		//int currentLane = this.driverVehicle.getCurrentLaneID();
		int currentCell = this.driverVehicle.getCurrentCellId();
		this.driverVehicle.getLane().removeCar(currentCell);
		//this.driverVehicle.getRoad().getLane(laneID).addCar(currentCell, this.getDriverVehicle().getID());
		driverVehicle.changeLane(laneID);
	}
	
	/*public boolean checkLane() {
		int cell_count = this.driverVehicle.getLane().getNumCells();
		int currentCell = this.driverVehicle.getCurrentCell();
		int i = currentCell;
		int limit = Math.floorMod((currentCell+10), cell_count);
		int myVehicleID = this.driverVehicle.getID();
		int otherCarID;
		boolean vehicleSpotted = false;
		
		while(i != limit && !vehicleSpotted && !(this.driverVehicle.isCrashed())) {
			otherCarID = this.driverVehicle.getLane().getCarAtCell(i);
			
			if((otherCarID != -1) && (otherCarID != myVehicleID)) {
				vehicleSpotted = true;
				System.out.println("Vehicle "+myVehicleID+"can't move left");
			}
			i = Math.floorMod((i+1), cell_count);
		}
		return vehicleSpotted;
	}*/
}
