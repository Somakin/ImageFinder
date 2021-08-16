package logic;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Programm {

    BufferedImage bild, screenshot;
    int[] scPixels, rPixels;




    public Programm() throws Exception {
        // objects
        Robot robot = new Robot();
        Manipulator manipulator = new Manipulator();
        // images
        this.screenshot = robot
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        this.bild = ImageIO.read(Paths.get("autoaccept/src/bilder/Moon.png").toFile());
        // images to PixelArray
        this.scPixels = manipulator.pixels(screenshot);
        this.rPixels = manipulator.pixels(bild);
        
        

        

    }
    public void run() throws Exception{
        // objects
        AutoAction autoaction = new AutoAction();
        Compare compare = new Compare(screenshot, bild, scPixels, rPixels);

        if(compare.isEqual()){
            autoaction.klick(compare.getX(),compare.getY());
            System.out.println("bild gefunden");
        }
        else{System.out.println("nicht gefunden");}
    }

}
