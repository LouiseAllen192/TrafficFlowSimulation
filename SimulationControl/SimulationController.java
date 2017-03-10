package SimulationControl;


import GraphicsManager.GraphicManager;
import Vehicle.Vehicle;
import Road.Road;

import java.awt.*;
import java.util.ArrayList;

public class SimulationController {



    public SimulationController() {

    }

    public void begin() {

        Point center = new Point(20, 50);
        int height = 600;
        int width = 500;
        int numCells = 6;

        Road road = new Road(center, width, height, numCells);

        Vehicle v1 = new Vehicle(center, 0, road);
        ArrayList<Vehicle> vehicles = new ArrayList();
        vehicles.add(v1);

        GraphicManager gm = new GraphicManager(center, width, height, vehicles);
        gm.run();

        final long NANOSEC_PER_SEC = 1000l*1000*1000;

        long startTime = System.nanoTime();
        while ((System.nanoTime()-startTime)< 5*60*NANOSEC_PER_SEC){
            for (int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).accelerate();
            }
        }

    }
}