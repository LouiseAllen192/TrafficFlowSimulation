package SimulationControl;

public class TrafficSimulation extends Controller {

    public static void main(String[] args) {
    	SimpleControllerFactory factory = new SimpleControllerFactory();

        Controller sc = factory.createSimulationController(factory);
        sc.begin();
    }
    
}
