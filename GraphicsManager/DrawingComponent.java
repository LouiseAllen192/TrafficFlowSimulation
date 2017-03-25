package GraphicsManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import Vehicle.Vehicle;
import Road.*;
import Driver.Driver;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;

public class DrawingComponent implements IDrawingComponent{

    private int screenWidth;
    private int screenHeight;
    private Graphics2D g2d;
    private BufferStrategy buffer;
    private Road road;
    private ArrayList<Driver> drivers;
    private final String GRASS_IMAGE_PATH;


    public DrawingComponent(double screenWidth, double screenHeight, Road road, ArrayList<Driver> drivers) {
    	System.out.printf("Width - %.2f, Height - %.2f\n", screenWidth, screenHeight);
        this.screenWidth = (int) screenWidth;
        this.screenHeight = (int) screenHeight;
        this.road = road;
        this.drivers = drivers;
        this.GRASS_IMAGE_PATH = "grass.png";
    }

    public void render(IDisplay display) {
    	setBuffer(display);

        g2d = (Graphics2D) buffer.getDrawGraphics();
    	g2d.clearRect(0, 0, screenWidth, screenHeight);

        paintGrassBackgroundImage();

        ArrayList<Lane> lanes = road.getLanes();
        for (Lane l : lanes) {
            drawLane(l);
        }

    	for (Driver d : this.drivers) {
            drawVehicle(d.getDriverVehicle());
    	}
    	
    	buffer.show();
    	g2d.dispose();
    }

    private void setBuffer(IDisplay display) {
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null) {
            display.getCanvas().createBufferStrategy(3);
            buffer = display.getCanvas().getBufferStrategy();
        }
    }

    private void paintGrassBackgroundImage() {
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File(GRASS_IMAGE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImagePanel panel = new ImagePanel(myImage);
        panel.paintComponent(g2d);
    }

    private void drawLane(Lane lane) {
        g2d.setColor(lane.getLaneColor());
        g2d.setStroke(new BasicStroke(lane.getLaneWidth()));
        g2d.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWidth(), lane.getHeight()));
    }

    private void drawVehicle(Vehicle v) {
        BufferedImage carImage = resize(getCarImage(v), v.getVehicleHeight(), v.getVehicleWidth());
        Point pos = v.getPosition();
        Point p2 = new Point(pos.x - (v.getVehicleWidth() / 2), pos.y - (v.getVehicleHeight() / 2));

        AffineTransform at = new AffineTransform();
        at.rotate(v.getAngle(), p2.x + (v.getVehicleWidth() / 2), p2.y + (v.getVehicleHeight() / 2));
        at.translate(p2.x, p2.y);

        g2d.drawImage(carImage, at, null);
    }

    private BufferedImage getCarImage(Vehicle v) {
        BufferedImage carImage = null;
        try {
            carImage = ImageIO.read(new File(v.getVehicleImagePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carImage;
    }

    private BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dImg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dImg;
    }
}
