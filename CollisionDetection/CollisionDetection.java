package CollisionDetection;

import Driver.DriverCollisionObserver;
import Road.Road;

import java.util.ArrayList;

public class CollisionDetection implements CollisionDetectionSubject {

    private ArrayList<DriverCollisionObserver> observers;

    public CollisionDetection() {
        observers = new ArrayList<>();

    }

    public void registerObserver(DriverCollisionObserver o) {
        observers.add(o);
    }

    public void removeObserver(DriverCollisionObserver o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers(int vehicle1ID, int vehicle2ID) {
        for (int i = 0; i < observers.size(); i++) {
            DriverCollisionObserver observer = observers.get(i);
            observer.collisionNotification(vehicle1ID, vehicle2ID);
        }
    }
    
    public int checkForCollisions(int vehicleID, int cellID, Road track){
		int cell_count = track.getNumCells();
		int lowerBound = Math.floorMod((cellID-3), cell_count); //((cellID - 100)%cell_count);
		int upperBound = (cellID+3) % cell_count;
		int i = lowerBound;
		int otherCarID = -1;
		boolean crash = false;
		
		while(i != upperBound && !crash) {
			otherCarID = track.getCarAtCell(i);
			
			if((otherCarID != -1) && (otherCarID != vehicleID)) {
				crash = true;
				this.notifyObservers(vehicleID, otherCarID);
				System.out.println("Crash between:"+vehicleID+" + "+otherCarID);
			}
			
			i = (i+1)%cell_count;
		}
		
		if(crash)
			return otherCarID;
		else
			return -1;
	}
}
