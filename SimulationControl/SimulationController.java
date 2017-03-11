package SimulationControl;


import GraphicsManager.GraphicManager;
import Vehicle.Vehicle;
import Road.Road;

import java.awt.*;
import java.util.ArrayList;

public class SimulationController implements Runnable {


    private ArrayList<Vehicle> vehicles;

    public SimulationController() {

    }

    public void run() {
    	final long NANOSEC_PER_SEC = 1000l*1000*1000;

        long startTime = System.nanoTime();
        long currentTime;
        while ((currentTime = System.nanoTime()) > 0){
          if ((currentTime - startTime) > (NANOSEC_PER_SEC / 16)) {
            startTime = currentTime;
            for (int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).accelerate();
            }
        }
      }
    }

    public void begin() {
        int height = 600;
        int width = 500;
        Point center = new Point((1920/2) - (width / 2), ((1080 /2)- (height / 2)));

        int numCells = 50;

        int roadWidth = 30;
        int vehicleWidth = 30;
        int vehicleHeight = 50;

        Road road = new Road(center, width, height, numCells, roadWidth);

        Vehicle v1 = new Vehicle(new Point(0,0), 0, road, vehicleWidth, vehicleHeight, Color.BLUE);
        Vehicle v2 = new Vehicle(new Point(20,0), 4, road, vehicleWidth, vehicleHeight, Color.RED);
        vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);

        (new Thread(this)).start();

        GraphicManager gm = new GraphicManager(center, width, height, vehicles, road);
        gm.run();

    }
}
