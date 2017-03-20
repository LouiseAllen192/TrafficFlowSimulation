package CollisionDetection;

import Driver.DriverCollisionObserver;
import Road.Road;

public interface CollisionDetectionSubject {
    void registerObserver(DriverCollisionObserver o);
    void removeObserver(DriverCollisionObserver o);
    void notifyObservers(int vehicle1ID, int vehicle2ID);
    int checkForCollisions(int vehicleID, int cellID, Road track);
}
