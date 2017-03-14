package Road;

import java.awt.*;
import java.util.*;

public class Road {
	
    private Point center;
    private int width;
    private int height;
    private int cell_count;
    private int road_width;
    private double angle_per_cell;
    private HashMap<Integer, Point> coordinates;

    public Road(Point center, int width, int height) {
        this.center = center;
        this.width = width;
        this.height = height;
        this.cell_count = 1000;
        this.road_width = 5;
        this.angle_per_cell = 0.36;//360 / this.cell_count;
        this.coordinates = new HashMap<>();
    }
    
    public int getX() {
    	return this.center.x;
    }
    
    public int getY() {
    	return this.center.y;
    }
    
    public int getWidth() {
    	return this.width;
    }
    
    public int getHeight() {
    	return this.height;
    }

    public int getNumCells() {
        return this.cell_count;
    }

    public int getRoadWidth() {
        return this.road_width;
    }

    public Point getPosition(int cell_index) {
       	//if (this.coordinates.containsKey(cell_index)) {
    		//return this.coordinates.get(cell_index);
    	//}
    	
        Point p = new Point();
        double angle = this.getAngle(cell_index);
        System.out.println(angle);
        p.x = (int)((this.center.x + (this.getWidth() / 2)) + ((this.getWidth() / 2)  * Math.cos(Math.toRadians(angle))) + 0.5);
        p.y = (int)((this.center.y + (this.getHeight() / 2)) + ((this.getHeight() / 2) * Math.sin(Math.toRadians(angle))) + 0.5);
        
        //this.coordinates.put(cell_index, p);
        
        return p;
    }

    private double getAngle(int cell_index) {
    	System.out.println(this.angle_per_cell);
        return this.angle_per_cell * (cell_index % this.cell_count);
    }

    public double getCarAngle(int cellId) {
        //TODO: functionality to get angle car is rotated at
        return 45;
    }
}
