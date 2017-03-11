package Vehicle;

import java.awt.*;

import Road.Road;

public class Vehicle {
    private Point position;
    private int cellId;
    private Road road;
    private int vehicleWidth;
    private int vehicleHeight;

    public Vehicle(Point xy, int cellId, Road road, int vWidth, int vHeight) {
        this.position = xy;
        this.cellId = cellId;
        this.road = road;
        this.vehicleWidth = vWidth;
        this.vehicleHeight = vHeight;
    }

    public Point getPosition() {
        return position;
    }

    public int getVehicleWidth() {
        return vehicleWidth;
    }

    public int getVehicleHeight() {
        return vehicleHeight;
    }

    public Road getRoad() {
        return road;
    }

    public void accelerate() {
        this.incrementCellId();
        this.updatePosition(road.getPosition(cellId));
    }

    private void updatePosition(Point newPosition) {
        this.position.x = newPosition.x;
        this.position.y = newPosition.y;
    }

    private void incrementCellId() {
    	cellId = (cellId + 1) % road.getNumCells();
    }
}
