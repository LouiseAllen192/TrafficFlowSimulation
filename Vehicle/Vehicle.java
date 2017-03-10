package Vehicle;

import java.awt.*;
import Road.Road;

public class Vehicle {
    private Point position;
    private int cellId;
    private Road road;

    public Vehicle(Point xy, int cellId, Road road) {
        this.position = xy;
        this.cellId = cellId;
        this.road = road;
    }

    public Point getPosition() {
        return position;
    }

    public void accelerate() {
        incrementCellId();
        Point newPosition = road.getPosition(cellId);
        updatePosition(newPosition);
    }

    private void updatePosition(Point newPosition) {
        this.position.x = newPosition.x;
        this.position.y = newPosition.y;
    }

    private void incrementCellId() {
        if (cellId++ >= road.getNumCells()) {
            cellId = 0;
        } else {
            cellId++;
        }

    }
}
