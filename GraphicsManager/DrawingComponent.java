package GraphicsManager;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import Vehicle.Vehicle;

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

    public void render(Vehicle vehicle, Display display) {
        Point position = vehicle.getPosition();

        buffer = display.canvas.getBufferStrategy();
        if (buffer == null) {
            display.canvas.createBufferStrategy(3);
            return;
        }
        g = buffer.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        g2d = (Graphics2D) g;
        g2d.setColor(new Color(166, 166, 166));
        g2d.setStroke(new BasicStroke(vehicle.getRoad().getRoadWidth()));

        //draw road
        Ellipse2D rd = new Ellipse2D.Double(centerPoint.x, centerPoint.y, 400, 500);
        g2d.draw(rd);

        //draw car start
        g.setColor(Color.RED);
        g.fillRect(position.x, position.y, vehicle.getVehicleWidth(), vehicle.getVehicleHeight());

        //draw car end
        buffer.show();
        g.dispose();
    }


}
