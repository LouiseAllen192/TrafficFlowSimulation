package Road;

import java.awt.*;

public class SimpleRoadFactory {
	public Road createRoad(int numLanes, Point center, double width, double height){
		return new Road(numLanes, center, width, height);
	}
}
