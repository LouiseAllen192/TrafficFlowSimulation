package Road;

import java.awt.*;

public class SimpleLaneFactory {
    public Lane createLane(int x, int y, int width, int height, int lane_width, int numCells, Color color) {
        return new Lane(x, y, width, height, lane_width, numCells, color);
    }
}
