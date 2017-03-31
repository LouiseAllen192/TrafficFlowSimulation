package Road;

import java.awt.*;
import java.util.ArrayList;

public class Road {

    private ArrayList<Lane> lanes;
    private Point center;
    private int numCells;
    private int laneWidth;
    private int screenWidth;
    private int screenHeigth;
    private final Color ROAD_COLOR;

    public Road(int numLanes, Point center, int laneWidth, int width, int height) {
       lanes = new ArrayList<>();
       this.center = center;
       this.laneWidth = laneWidth;
       this.screenWidth = width;
       this.screenHeigth = height;
       this.numCells = 1000;
       this.ROAD_COLOR = new Color(77, 77, 77);

       addLanes(numLanes);
    }

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

    public int getNumCells() {
        return numCells;
    }

    public Color getRoadColor() {
        return ROAD_COLOR;
    }

    private void addLanes(int numLanes) {
        int laneOffset = laneWidth / 2;

        int currentWidth = screenWidth;
        int currentHeight = screenHeigth;

        int currentX = (int) center.getX();
        int currentY = (int) center.getY();


        //To be removed after - just hear for clarity to see lanes more clearly

        ArrayList<Color> c = new ArrayList<>();
        c.add(new Color(144, 150, 160));
        c.add(new Color(111, 114, 119));
        c.add(new Color(71, 73, 76));


        for (int i = 0; i < numLanes; i++) {

            lanes.add(new Lane(currentX, currentY, currentWidth, currentHeight, laneWidth, numCells, c.get(i)));

            currentWidth += laneWidth * 2;
            currentHeight += laneWidth * 2;

            currentX -= laneWidth * 2;
            currentY -= laneWidth * 2;
        }
    }

    public Lane getLane(int laneId) {
        return lanes.get(laneId);
    }
}
