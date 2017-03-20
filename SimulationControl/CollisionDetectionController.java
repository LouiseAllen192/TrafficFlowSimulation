package SimulationControl;

import java.util.ArrayList;

import Driver.Driver;
import CollisionDetection.*;

public class CollisionDetectionController implements Runnable{
	
	private I_CollisionDetectionSubject cd;
	private ArrayList<Driver> drivers;
	private boolean running;
	
	public CollisionDetectionController(ArrayList<Driver> d) {
		this.cd  = new CollisionDetection();
		this.drivers = d;
		this.running = true;
		registerVehicles();
	}
	
	public void registerVehicles() {
		for(Driver d : drivers)
			cd.registerObserver(d.getDriverVehicle());
	}
	
	@Override
	public void run() {
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){}
			
		while(running) {
			try{
				Thread.sleep(20);
			}
			catch(InterruptedException ex){}
			
			for(Driver d : drivers){
				if(!(d.getDriverVehicle().isCrashed()))
					cd.checkForCollisions(d.getDriverVehicle().getID(), d.getDriverVehicle().getCurrentCell(), d.getDriverVehicle().getRoad());
			}
		}		
	}
	
	public void stopRunning() {
		this.running = false;
	}
	
	public void startRunning() {
		this.running = true;
	}
}
