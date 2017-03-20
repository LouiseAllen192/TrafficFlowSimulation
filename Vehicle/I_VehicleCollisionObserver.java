package Vehicle;

public interface I_VehicleCollisionObserver {
    // all vehicles implement this interface and must provide a collisionNotification() method
    void collisionNotification(int id1, int id2);
}
