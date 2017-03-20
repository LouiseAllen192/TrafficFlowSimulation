package SimulationControl;
import Vehicle.Vehicle;
import Driver.Driver;
import CollisionDetection.*;
public class CollisionDetectionController implements Runnable{
	private CollisionDetectionSubject cd;
	private Driver[] drivers;
	private boolean running = true;
	public CollisionDetectionController (Driver[] d){
		this.cd  = new CollisionDetection();
		this.drivers = d;
		registerVehicle();
	}
	
	public void registerVehicle(){
		for(Driver d : drivers)
		cd.registerObserver(d.getDriverVehicle());
	}
	
	@Override
	public void run() {
		
		while(running){
			for(Driver d : drivers){
				checkForCollision(d.getDriverVehicle().getVehicleId(), d.getDriverVehicle().getCurrentCell());
			}
		}
		// TODO Auto-generated method stub
		
	}
}
