package Road;

import java.awt.*;
import java.util.HashMap;

public class Lane {
	private Point center;
	private int width;
	private int height;
	private int cell_count;
	private int lane_width;
	private double angle_per_cell;
	private HashMap<Integer, Point> coordinates;
	private HashMap<Integer, Integer> occupiedCells;
	private final Color ROAD_COLOR;
	private Color laneColor;
    private Object lock;

	public Lane(int x, int y, int width, int height, int lane_width, int numCells, Color color) {
		this.center = new Point();
		center.x = x;
		center.y = y;
		this.width = width;
		this.height = height;
		this.cell_count = numCells;
		this.lane_width = lane_width;
		this.angle_per_cell = 360.0 / this.cell_count;
		this.coordinates = new HashMap<>();
		this.occupiedCells = new HashMap<>();
		this.ROAD_COLOR = new Color(77, 77, 77);
		this.laneColor = color;
	    lock = new Object();
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

	public Color getLaneColor() {
		return laneColor;
	}

	public int getLaneWidth() {
		return this.lane_width;
	}
	
	public HashMap<Integer, Integer> getOccupiedCells() {
		synchronized (lock) {
			return occupiedCells;
        }
	}
	
	public void addToOccupiedCells(int cellID, int vehicleID) {
		synchronized (lock) {
			occupiedCells.put(cellID, vehicleID);
        }
	}
	
	public Point getPosition(int cell_index) {
		// if (this.coordinates.containsKey(cell_index)) {
		// return this.coordinates.get(cell_index);
		// }

		Point p = new Point();
		double angle = this.getAngle(cell_index);

		p.x = (int) (((this.center.x / 2) + (this.getWidth() / 2))
				+ ((this.getWidth() / 2) * Math.cos(Math.toRadians(angle))));
		p.y = (int) (((this.center.y / 2) + (this.getHeight() / 2))
				+ ((this.getHeight() / 2) * Math.sin(Math.toRadians(angle))));
		// this.coordinates.put(cell_index, p);

		return p;
	}

	private double getAngle(int cell_index) {
		return this.angle_per_cell * (cell_index % this.cell_count);
	}

	public double getCarAngle(int cell_index) {
		return Math.toRadians(this.angle_per_cell * (cell_index % this.cell_count)) - 1.5708;
	}

	public void occupyCell(int previousCell, int cellID, int vehicleID) {
		addToOccupiedCells(previousCell, -1);
		addToOccupiedCells(cellID, vehicleID);
	}

	public void removeVehicle(int cellID) {
		addToOccupiedCells(cellID, -1);
	}

	public void addCar(int cellID, int vehicleID) {
		boolean occupied = true;
		while (occupied) {
			if (getOccupiedCells().get(cellID) == null || getOccupiedCells().get(cellID) != -1) {
				addToOccupiedCells(cellID, vehicleID);
				occupied = false;
			} else
				cellID = Math.floorMod((cellID + 1), cell_count);
		}
	}

	public int getCarAtCell(int key) {
		  if ((getOccupiedCells().containsKey(key)) && (getOccupiedCells().get(key) != null)) {
			if (getOccupiedCells().get(key) != -1 && getOccupiedCells().get(key) != 0) {
				return getOccupiedCells().get(key);
			}
		}
		return -1;
	}

	public void occupiedCellsSize() {
		System.out.println("oc size: " + getOccupiedCells().size());
	}
}
