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
    private final Color ROAD_COLOR;

    public Road(Point center, int width, int height) {
        this.center = center;
        this.width = width;
        this.height = height;
        this.cell_count = 1000;
        this.road_width = 40;
        this.angle_per_cell = 360.0 / this.cell_count;
        this.coordinates = new HashMap<>();
        this.ROAD_COLOR = new Color(77, 77, 77);
    }
    
    public int getX() {
    	return this.center.x / 2;
    }
    
    public int getY() {
    	return this.center.y / 2;
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

    public Color getRoadColor() {
        return ROAD_COLOR;
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
        
        if ((cell_index % this.cell_count) < this.cell_count / 2) {
        	p.x = (int)(((this.center.x / 2) + (this.getWidth() / 2)) + ((this.getWidth() / 2)  * Math.cos(Math.toRadians(angle))));
        	p.y = (int)(((this.center.y / 2) + (this.getHeight() / 2)) + ((this.getHeight() / 2) * Math.sin(Math.toRadians(angle))));
        	p.y = (int)(p.y + 1);
        } else {
        	p.x = (int)(((this.center.x / 2) + (this.getWidth() / 2)) + ((this.getWidth() / 2)  * Math.cos(Math.toRadians(angle))));
        	p.y = (int)(((this.center.y / 2) + (this.getHeight() / 2)) + ((this.getHeight() / 2) * Math.sin(Math.toRadians(angle))));
        	p.y = (int)(p.y - 1);
        }
        //this.coordinates.put(cell_index, p);
        
        return p;
    }

    private double getAngle(int cell_index) {
        return this.angle_per_cell * (cell_index % this.cell_count);
    }

    public double getCarAngle(int cell_index) {
        //TODO: functionality to get angle car is rotated at
    	return Math.toRadians(this.angle_per_cell * (cell_index % this.cell_count)) - 1.5708;
    	// return 1.5708;
    	// return ((360.0 / this.cell_count) * cell_index) / 80;
    	// return (this.angle_per_cell * (cell_index % this.cell_count));
    }
}
