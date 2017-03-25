package CollisionDetection;

import Road.*;
import Vehicle.I_VehicleCollisionObserver;

public interface I_CollisionDetectionSubject {
    void registerObserver(I_VehicleCollisionObserver o);
    void removeObserver(I_VehicleCollisionObserver o);
    void notifyObservers(int vehicle1ID, int vehicle2ID);
    int checkForCollisions(int vehicleID, int cellID, Lane track);
}
