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
			cd.registerObserver(d.getVehicle());
	}
	
	@Override
	public void run() {
		Timer t = new Timer(1);
    	t.setMessage("Collision Detection Controller");
		while(running) {
			t.start();
			for(Driver d : drivers) {
				cd.checkForCollisions(d.getVehicle().getID(),
						d.getVehicle().getCurrentCell(),
						d.getVehicle().getLane());
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
