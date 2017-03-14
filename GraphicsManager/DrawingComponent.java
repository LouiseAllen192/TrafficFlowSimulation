package GraphicsManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import Vehicle.Vehicle;
import Road.Road;
import Driver.Driver;

import javax.imageio.ImageIO;

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

    public void render(Display display, Road road, ArrayList<Driver> drivers) {
    	buffer = display.canvas.getBufferStrategy();
    	if (buffer == null) {
    		display.canvas.createBufferStrategy(3);
    		buffer = display.canvas.getBufferStrategy();
    	}
    	
    	g = buffer.getDrawGraphics();
        g2d = (Graphics2D) g;
    	g2d.clearRect(0, 0, width, height);

        BufferedImage myImage = null;
        BufferedImage carImage = null;
        try {
            myImage = ImageIO.read(new File("grass.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImagePanel panel = new ImagePanel(myImage);
        panel.paintComponent(g2d);
    	

    	g2d.setColor(new Color(77, 77, 77));
    	g2d.setStroke(new BasicStroke(road.getRoadWidth()));
    	
    	g2d.draw(new Ellipse2D.Double(road.getX(), road.getY(), road.getWidth(), road.getHeight()));

    	for (Driver d : drivers) {
            drawVehicle(d.getDriverVehicle());
    	}
    	
    	buffer.show();
    	g2d.dispose();
    }

    private void drawVehicle(Vehicle v) {
    	//System.out.println("draw vehicle");
        BufferedImage carImage = null;
        try {
            carImage = ImageIO.read(new File(v.getVehicleImagePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        carImage = resize(carImage, v.getVehicleHeight(), v.getVehicleWidth());

        Point pos = v.getPosition();

        AffineTransform at = new AffineTransform();
        at.setToRotation(v.getAngle(), pos.x + (v.getVehicleWidth() / 2), pos.y + (v.getVehicleHeight() / 2));
        at.translate(pos.x - (v.getVehicleWidth() / 2), pos.y - (v.getVehicleHeight() / 2));
        System.out.println("x: "+pos.x+" y: "+pos.y+" current cell: "+v.getCurrentCell());
        g2d.drawImage(carImage, at, null);
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
