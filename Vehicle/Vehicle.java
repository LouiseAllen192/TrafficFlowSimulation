package Vehicle;

import java.awt.Color;
import java.awt.Point;

import Road.Road;
import Road.Lane;


public class Vehicle implements I_VehicleCollisionObserver {
	
	private int currentCell,vehicleWidth,vehicleHeight;
	public static enum manufacturer{
		Toyota,Volkswagen,Hyundai,Ford,Nissan,Mazda
	}
	
	private double maxSpeed,currentSpeed,angle;
	private Lane track;
	private Road road;
	private int currentLaneId;
	private Point position;
	private Color color;
	private String imagePath;
	private int vehicleId;
	private boolean isCrashed;
	
	public Vehicle(Point xy, int cellId, Road road, int laneId, int vWidth, int vHeight, int id, Color color){
		this.position = xy;
		this.currentCell = cellId;
		this.road = road;
		this.currentLaneId = laneId;
		this.track = road.getLane(currentLaneId);
		this.vehicleWidth = vWidth;
		this.vehicleHeight = vHeight;
		this.color = color;
        this.currentSpeed = 0.0;
        this.vehicleId = id;
        this.isCrashed = false;
	}
	
	public Vehicle(Point xy, int cellId, Road road, int laneId, int vWidth, int vHeight, int id, String imagePath){
		 this.position = xy;
		 this.currentCell = cellId;
		 this.road = road;
		 this.currentLaneId = laneId;
		 this.track = road.getLane(currentLaneId);
		 this.vehicleWidth = vWidth;
		 this.vehicleHeight = vHeight;
		 this.color = Color.gray;
		 this.imagePath = imagePath;
		 this.currentSpeed = 0.0;
	     this.vehicleId = id;
		 this.isCrashed = false;
	 }
	
	public void setCurrentSpeed(double currentSpeed){
		this.currentSpeed = currentSpeed;
	}
	
	public void accelerate(int speedModifier){
		if(!isCrashed){
			this.incrementCellId(speedModifier);
			this.updatePosition(track.getPosition(this.currentCell));
			this.updateAngle(track.getCarAngle(this.currentCell));
		}
	}
	
	public void decellerate(){
		this.decrementCellId();
		this.updatePosition(track.getPosition(this.currentCell));
		this.updateAngle(track.getCarAngle(this.currentCell));
	}
	
	public void incrementCellId(int speedModifier){
		int previousCell = this.currentCell;
		this.currentCell = (this.currentCell + speedModifier) % track.getNumCells();
		track.occupyCell(previousCell, currentCell, this.vehicleId);
	}
	
	public void decrementCellId(){
		this.currentCell = (this.currentCell - 1) % track.getNumCells();
	}
	
	private void updateAngle(double angle){
		this.angle = angle;
	}

	public void updatePosition(Point position) {
		
		this.position.x = position.x;
		this.position.y = position.y;
		/*
		if (this.currentCell > 400 && this.currentCell < 600) {
			this.position.x = position.x - this.vehicleWidth;
		} else {
			this.position.x = position.x;
		}
		
		if (this.currentCell < track.getNumCells() / 2) {
			this.position.y = position.y;
		} else {
			this.position.y = position.y - this.vehicleHeight;
		}
		*/
	}

	public void collisionNotification(int vehicle1ID, int vehicle2ID) {
		if (this.vehicleId == vehicle1ID || this.vehicleId == vehicle2ID) {
		    this.isCrashed = true;
        }
	}
	
	public Point getPosition(){
		return position;
	}
	
	public double getAngle(){
		return angle;
	}
	
	public Road getRoad(){
		return road;
	}

	public Lane getLane() {
		return track;
	}
	
	public Color getColor(){
		return color;
	}
	
	public String getVehicleImagePath() {
		return this.imagePath;
	}
	
	public int getCurrentCell() {
		return currentCell;
	}
	
	public int getVehicleHeight() {
		return vehicleHeight;
	}
	
	public int getVehicleWidth() {
		return vehicleWidth;
	}
	
	public double getCurrentSpeed() {
		return currentSpeed;
	}

    public boolean isCrashed() {
        return isCrashed;
    }

    public void setColor(Color color){
		this.color = color;
	}
    
    public int getID(){
    	return vehicleId;
    }
}

