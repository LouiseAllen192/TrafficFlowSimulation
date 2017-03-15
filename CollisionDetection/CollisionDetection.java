package CollisionDetection;

import Driver.DriverCollisionObserver;
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
}
