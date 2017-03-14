package Vehicle;

import java.awt.Point;

public class Vehicle {
	private int currentCell,vehicleWidth,vehicleHeight,;
	public static enum manufacturer{
		Toyota,Volkswagen,Hyundai,Ford,Nissan,Mazda
	}
	private double maxSpeed,currentSpeed,angle;
	private Road track;
	private Point position;
	private Color color;
	private String imagePath;
	public Vehicle(){
		
	}
	public Vehicle(Point xy,int cellId, Road road, int vWidth, int vHeight, Color color){
		this.position = xy;
		this.currentCell = cellId;
		this.track = road;
		this.vehicleWidth = vWidth;
		this.vehicleHeight = vHeight;
		this.color = color;
        this.currentSpeed = 0.0;
	}
	public Vehicle(Point xy,int cellId, Road road, int vWidth, int vHeight, String imagePath){
		this.position = xy;
		this.currentCell = cellId;
		this.track = road;
		this.vehicleWidth = vWidth;
		this.vehicleHeight = vHeight;
		this.color = color;
		this.imagePath = imagePath;
        this.currentSpeed = 0.0;
	}
	public void setCurrentSpeed(double currentSpeed){
		this.currentSpeed = currentSpeed;
	}
	public void accelerate(){
		this.incrementCellId();
		this.updatePosition(track.getPosition(cellId));
		this.updateAngle(track.getCarAngle(cellId));
	}
	public void decellerate(){
		this.decrementCellId();
		this.updatePosition(track.getPosition(cellId));
		this.updateAngle(track.getCarAngle(cellId));
	}
	public void incrementCellId(){
		cellId = (cellId+1)%track.getNumCells();
	}
	public void decrementCellId(){
		cellId = (cellId-1)%track.getNumCells();
	}
	private void updateAngle(double angle){
		this.angle = angle;
	}
	/*public void updateCell(){
		
		
	}*/
	public void updatePosition(Point position){
		this.position.x = position.x;
		this.position.y = position.y;
	}
	public Point getPosition(){
		return position;
	}
	public double getAngle(){
		return angle;
	}
	public Road getRoad(){
		return track;
	}
	public Color getColor(){
		return color;
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
}

