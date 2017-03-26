package SimulationControl;

import SensoryPerception.SensoryPerception;

public class TrafficSimulation extends Controller{

    public static void main(String[] args) {
    	SimpleControllerFactory factory = new SimpleControllerFactory();
        Controller sc = factory.createController("Simulation Controller");
    	//SimulationController sc = new SimulationController();
        sc.begin();
    }
}
