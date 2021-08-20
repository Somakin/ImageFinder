package logic;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class ImageFinder {

    BufferedImage bild, screenshot;
    Robot robot;
    Manipulator manipulator;
    AutoAction autoaction;
    int[] scPixels, rPixels;
    int x, y;
    double maxfehler_in_Prozent;
    private boolean imagefound;
    private double fehler;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getImagefound() {
        return this.imagefound;
    }

    public void setImagefound(boolean bool) {
        this.imagefound = bool;
    }

    public ImageFinder(String referenzBild, double maxfehler_in_Prozent) throws Exception {
        // objects
        this.robot = new Robot();
        this.manipulator = new Manipulator();
        this.autoaction = new AutoAction();
        // images
        this.screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        this.bild = ImageIO.read(ImageFinder.class.getClassLoader().getResource("bilder/" + referenzBild));
        // images to PixelArray
        this.scPixels = manipulator.pixels(screenshot);
        this.rPixels = manipulator.pixels(bild);

        // fehler
        this.fehler = maxfehler_in_Prozent;
        // int x,y initialize
        Compare compare = new Compare(screenshot, bild, scPixels, rPixels, fehler);

        this.x = compare.getX();
        this.y = compare.getY();

        // boolean constructor
        this.imagefound = compare.isEqual();
    }

}
