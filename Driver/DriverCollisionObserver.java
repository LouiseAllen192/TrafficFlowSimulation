package Driver;

public interface DriverCollisionObserver {

    // all drivers implement this interface and must provide an collisionNotification() method
    void collisionNotification(int vehicle1ID, int vehicle2ID);
}
