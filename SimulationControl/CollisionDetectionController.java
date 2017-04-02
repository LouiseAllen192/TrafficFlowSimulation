package SimulationControl;

import java.util.ArrayList;

import Driver.Driver;
import Threading.Timer;
import CollisionDetection.*;

public class CollisionDetectionController extends Controller {
	
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
		Timer t = new Timer(Timer.DEFAULT_FRAMERATE);
    	t.setMessage("Collision Detection Controller");
		while(running) {
			t.start();
			for(Driver d : drivers) {
				if(!(d.getDriverVehicle().isCrashed())) {
					cd.checkForCollisions(d.getDriverVehicle().getID(),
							d.getDriverVehicle().getCurrentCell(),
							d.getDriverVehicle().getLane());
				}
			}
			t.end();
		}		
	}
	
	public void stopRunning() {
		this.running = false;
	}
	
	public void startRunning() {
		this.running = true;
	}
}
