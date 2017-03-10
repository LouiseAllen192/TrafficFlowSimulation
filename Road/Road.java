package Road;

import java.awt.*;

public class Road {
    private Point centerPoint;
    private int width;
    private int height;
    int numCells;


    public Road(Point centerPoint, int width, int height, int numCells) {
        this.centerPoint = centerPoint;
        this.width = width;
        this.height = height;
        this.numCells = numCells;
    }

    public int getNumCells() {
        return numCells;
    }

    public Point getPosition(int cellId) {
        Point p = new Point();

        double angle = getAngle(cellId);
        p.x = (int)(centerPoint.x + (width  * Math.cos(Math.toRadians(angle))) + 0.5);
        p.y = (int)(centerPoint.y + (height * Math.sin(Math.toRadians(angle))) + 0.5);
        return p;
    }

    private double getAngle(int cellIndex) {
        return getSegmentAngle() * (cellIndex % numCells);
    }

    private double getSegmentAngle() {
        return 360 / numCells;
    }
}
