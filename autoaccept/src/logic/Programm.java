package logic;

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

        Path file = Paths.get("autoaccept/src/bilder/Moon.png");
        BufferedImage bild = ImageIO.read(file.toFile());

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

            // check for Image
            if (aa.klick(manipulator.compare(a, b, screenShot, bild))) {
                System.out.println("bild gefunden");
                bool = false;
            }

             Thread.sleep(1000);

        }

    }
}
