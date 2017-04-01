package Road;

import java.awt.*;

public class SimpleRoadFactory {
	public Road createRoad(int numLanes, Point center, int laneWidth, int width, int height){
		return new Road(numLanes, center, laneWidth, width, height);
	}
}
