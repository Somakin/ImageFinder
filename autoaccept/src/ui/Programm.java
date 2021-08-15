package ui;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;

public class Programm {

    public void start() throws Exception {
        // objects
        Robot robot = new Robot();

        Manipulator manipulator = new Manipulator();
        AutoAction aa = new AutoAction();
        // import images

        BufferedImage bild = ImageIO.read(new File("C:\\stuff.tower\\code\\newApp\\autoaccept\\src\\bilder\\Test.png"));

        BufferedImage screenShot = robot
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        // convert to pixel array
        
        int[] b = manipulator.pixels(bild);
        int[] b2 = new int[bild.getWidth()];
 

        
        for (int i = 0; i < b2.length; i++) {
            b2[i] = b[i];
            
        
    }

        boolean bool = true;
        while (bool) {

            // screenshot aktualisieren
            screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            
            // convert to pixel array
            int[] a = manipulator.pixels(screenShot);

            // ImageIO.write(screenShot, "JPG", new File("src\\ui\\Screenshot" + ".jpg"));
            // manipulator.compare3(a, b2, b, screenShot, bild);
            aa.klick(manipulator.compare(a, b2, b, screenShot, bild));
          
            Thread.sleep(3000);
        }

    }
}
