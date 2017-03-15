package CollisionDetection;

import Driver.DriverCollisionObserver;

public interface CollisionDetectionSubject {
    void registerObserver(DriverCollisionObserver o);
    void removeObserver(DriverCollisionObserver o);
    void notifyObservers(int vehicle1ID, int vehicle2ID);
}
