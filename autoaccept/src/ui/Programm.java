package ui;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Programm {

    public void start() throws Exception {
        // objects
        Robot robot = new Robot();

        Manipulator manipulator = new Manipulator();
        AutoAction aa = new AutoAction();
        // import images

        Path file = Paths.get("src/bilder/Test.png");
        BufferedImage bild = ImageIO.read(file.toFile());

        BufferedImage screenShot = robot
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        // convert to pixel array
        
        int[] b = manipulator.pixels(bild);


        boolean bool = true;
        while (bool) {

            // screenshot aktualisieren
            screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            
            // convert to pixel array
            int[] a = manipulator.pixels(screenShot);

            // ImageIO.write(screenShot, "JPG", new File("src\\ui\\Screenshot" + ".jpg"));
            // manipulator.compare3(a, b2, b, screenShot, bild);
            aa.klick(manipulator.compare2(a, b, screenShot, bild));
          
            Thread.sleep(3000);
        }

    }
}
