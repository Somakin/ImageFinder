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

    public ImageFinder(String referenzBild,double maxfehler_in_Prozent) throws Exception {
        // objects
        this.robot = new Robot();
        this.manipulator = new Manipulator();
        this.autoaction = new AutoAction();
        // images
        this.screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        this.bild = ImageIO.read(Paths.get("autoaccept/src/bilder/" + referenzBild).toFile());
        // images to PixelArray
        this.scPixels = manipulator.pixels(screenshot);
        this.rPixels = manipulator.pixels(bild);
        // fehlerquote setzen


        // int x,y initialize
        Compare compare = new Compare(screenshot, bild, scPixels, rPixels,maxfehler_in_Prozent);

        this.x = compare.getX();
        this.y = compare.getY();

        // boolean constructor
        this.imagefound = false;
    }

    public void run() throws Exception {
        // objects
        
            Compare compare = new Compare(screenshot, bild, scPixels, rPixels,maxfehler_in_Prozent);

            this.x = compare.getX();
            this.y = compare.getY();

            if (compare.isEqual()) {

                autoaction.klick(this.x, this.y);
                imagefound = true;

            }
        
    }

}
