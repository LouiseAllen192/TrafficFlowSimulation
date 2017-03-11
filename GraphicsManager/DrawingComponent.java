package GraphicsManager;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import Vehicle.Vehicle;
import Road.Road;

public class DrawingComponent  {

    private String title;
    private int width;
    private int height;
    private Point centerPoint;
    private Graphics g;
    private Graphics2D g2d;
    private BufferStrategy buffer;


    public DrawingComponent(Point centerPoint, int width, int height) {
        this.title = "Traffic Flow simulation";
        this.width = width;
        this.height = height;
        this.centerPoint = centerPoint;
    }

    public void render(Display display, Road road, ArrayList<Vehicle> vehicles) {
    	buffer = display.canvas.getBufferStrategy();

    	if (buffer == null) {
    		display.canvas.createBufferStrategy(3);
    		buffer = display.canvas.getBufferStrategy();
    	}
    	
    	g = buffer.getDrawGraphics();
    	g.clearRect(0, 0, width, height);
    	
    	g2d = (Graphics2D) g;
    	g2d.setColor(new Color(166, 166, 166));
    	g2d.setStroke(new BasicStroke(road.getRoadWidth()));
    	
    	g2d.draw(new Ellipse2D.Double(road.getX(), road.getY(), road.getWidth(), road.getHeight()));
    	g.setColor(Color.RED);

    	for (Vehicle v : vehicles) {
    		Point pos = v.getPosition();
    		g.fillRect(pos.x, pos.y, v.getVehicleWidth(), v.getVehicleHeight());
    	}
    	
    	buffer.show();
    	g.dispose();
    }


}
