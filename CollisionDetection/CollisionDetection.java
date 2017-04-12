package CollisionDetection;

import Road.Lane;
import Vehicle.I_VehicleCollisionObserver;

import java.util.ArrayList;

public class CollisionDetection implements I_CollisionDetectionSubject {

    private ArrayList<I_VehicleCollisionObserver> observers;

    public CollisionDetection() {
        observers = new ArrayList<>();

    }

    public void registerObserver(I_VehicleCollisionObserver o) {
        observers.add(o);
    }

    public void removeObserver(I_VehicleCollisionObserver o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers(int vehicle1ID, int vehicle2ID) {
        for (int i = 0; i < observers.size(); i++) {
            I_VehicleCollisionObserver observer = observers.get(i);
            observer.collisionNotification(vehicle1ID, vehicle2ID);
        }
    }
    
    public int checkForCollisions(int vehicleID, int cellID, Lane track) {
		int cell_count = track.getNumCells();
		int upperBound = (cellID+30) % cell_count;
		int i = cellID;
		int otherCarID = -1;
		boolean crash = false;
		
		while(i != upperBound && !crash) {
			otherCarID = track.getCarAtCell(i);
			
			if((otherCarID != -1) && (otherCarID != vehicleID)) {
				crash = true;
				this.notifyObservers(vehicleID, otherCarID);
			}
			
			i = (i + 1) % cell_count;
		}
		
		return (crash) ? otherCarID : -1;
	}
}
