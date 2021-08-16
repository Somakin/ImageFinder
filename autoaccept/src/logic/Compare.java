package logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Compare {

    BufferedImage sc, r;
    int[] scPixel, rPixel;
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Compare(BufferedImage sc, BufferedImage r, int[] scPixel, int[] rPixel) throws IOException { // Paths.get("autoaccept/src/bilder/Moon.png")
        this.sc = sc;
        this.r = r;
        this.scPixel = scPixel;
        this.rPixel = rPixel;

        Manipulator manipulator = new Manipulator();
        int[] koordinaten = manipulator.compare(scPixel, rPixel, sc, r);
        this.x = koordinaten[0];
        this.y = koordinaten[1];
    }

    public boolean isEqual() {

        // is equal wenn manipulator koordinaten[] < 0 is
        if (this.getX() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
