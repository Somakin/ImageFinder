package logic;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Programm {

    BufferedImage bild, screenShot;
    int[] a, b;
  

    public Programm() throws Exception {
        // Objects
        
        Manipulator manipulator = new Manipulator();

        Path file = Paths.get("autoaccept/src/bilder/Moon.png");
        // create Images
        this.bild = ImageIO.read(file.toFile());

        // convert to pixelarray
        this.a = manipulator.pixels(bild);

    }

    public boolean isEqual() throws Exception {
        AutoAction aa = new AutoAction();
        Manipulator manipulator = new Manipulator();
        Robot robot = new Robot();

        this.screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        this.b = manipulator.pixels(screenShot);
        
        
        return aa.klick(manipulator.compare(this.b, this.a, this.screenShot, this.bild));

    }

}
