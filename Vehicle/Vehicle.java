package Vehicle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Road.Road;
import Road.Lane;

public class Vehicle implements I_VehicleCollisionObserver {
	

	public static enum manufacturer{
		Toyota,Volkswagen,Hyundai,Ford,Nissan,Mazda
	}
    private int currentCell, vehicleWidth, vehicleHeight, currentLaneId, vehicleId;
	private double maxSpeed, currentSpeed, angle;
	private Lane track;
	private Road road;
	private Point position;
	private Color color;
	private String imagePath;
	private I_VehicleState state;
	private BufferedImage carImage;
	
	public Vehicle(){
		
	}
	public Vehicle(Point xy, int cellId, Road road, int laneId, int numLanes, int id, String imagePath) {
		 this.position = xy;
		 this.currentCell = cellId;
		 this.road = road;
		 this.currentLaneId = laneId;
		 this.track = road.getLane(currentLaneId);
		 this.vehicleWidth = getVehicleWidthRelevantToLaneNum(numLanes);
		 this.vehicleHeight = getVehicleHeightRelevantToLaneNum(numLanes);
		 this.color = Color.gray;
		 this.imagePath = imagePath;
		 this.currentSpeed = 0.0;
	     this.vehicleId = id;
		 this.state = new VehicleDrivingState();
		 this.carImage = createCarImage();
	}
	
	public BufferedImage getCarImage() {
		return this.carImage;
	}

	public int getCurrentCellID() {
	    return this.currentCell;
    }
	
	public void setCurrentSpeed(double currentSpeed){
		this.currentSpeed = currentSpeed;
	}
	
	public void accelerate(int speedModifier){
		state.accelerate(speedModifier, this, track);
	}
	
	public void decellerate(){
		this.decrementCellID();
		this.updatePosition(track.getPosition(this.currentCell));
		this.updateAngle(track.getCarAngle(this.currentCell));
	}
	
	public void incrementCellID(int speedModifier){
		int previousCell = this.currentCell;
		this.currentCell = (this.currentCell + speedModifier) % track.getNumCells();
		track.occupyCell(previousCell, currentCell, this.vehicleId);
	}
	
	public void decrementCellID(){
		this.currentCell = (this.currentCell - 1) % track.getNumCells();
	}
	
	public void updateAngle(double angle){
		this.angle = angle;
	}

	public void updatePosition(Point position) {
		this.position.x = position.x;
		this.position.y = position.y;
	}

	public void collisionNotification(int vehicle1ID, int vehicle2ID) {
		if (this.vehicleId == vehicle1ID || this.vehicleId == vehicle2ID) {
		    this.state = new VehicleCrashedState();
        }
	}
	
	public void changeLane(int laneID) {
		state.changeLane(laneID, this);		
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
        return (this.state.getState() == VehicleStatesEnum.CRASHED);
    }

    public void setColor(Color color){
		this.color = color;
	}
    
    public int getID(){
    	return vehicleId;
    }

    public int getVehicleWidthRelevantToLaneNum(int numLanes) {
    	int width;
		if (numLanes <= 6) {
			width = 30;
		} else if (numLanes > 6 && numLanes < 12) {
			width = 20;
		} else if (numLanes >= 12  && numLanes < 20) {
			width = 15;
		} else {
			width = 10;
		}
		return width;
	}

	public int getVehicleHeightRelevantToLaneNum(int numLanes) {
		int height;
		if (numLanes <= 6) {
			height = 50;
		} else if (numLanes > 6 && numLanes < 12) {
			height = 35;
		} else if (numLanes >= 12  && numLanes < 20) {
			height = 25;
		} else {
			height = 15;
		}
		return height;
	}
    
    public int getCurrentLaneID() {
    	return this.currentLaneId;
    }
    
    public void setLane(int laneID) {
    	this.currentLaneId = laneID;
		this.track = road.getLane(laneID);
    }
    
    public VehicleStatesEnum getStateEnum() {
        return this.state.getState();
    }
    
    public I_VehicleState getState() {
        return this.state;
    }
    
	private BufferedImage createCarImage() {
		try {
            BufferedImage img = ImageIO.read(new File(this.getVehicleImagePath()));
        	BufferedImage resized_car_image = new BufferedImage(this.getVehicleHeight(), this.getVehicleWidth(), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D graphics = resized_car_image.createGraphics();
	        graphics.drawImage(img.getScaledInstance(this.getVehicleHeight(), this.getVehicleWidth(), Image.SCALE_SMOOTH), 0, 0, null);
	        graphics.dispose();
        	return resized_car_image;
		} catch (IOException ex) {
			return null;
		}
	}
}

