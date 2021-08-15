package ui;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public class Manipulator {

    public int[] pixels(BufferedImage image) {
        PixelGrabber grabber;
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        try {
            grabber = new PixelGrabber(image, 0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
            grabber.grabPixels(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pixels;
    }

    public int[] compare(int[] scPixels, int[] rPixels, BufferedImage sc, BufferedImage r) {
        int[] koordinaten = new int[2];

        int xlage = 0;
        int ylage = 0;

        int richtige = 0;
        int fehler = 0;
        double maxfehler = (int) rPixels.length * 0.1; // zugelassene Fehler in %

        boolean istgleich = false;

        for (int i = 0; i < scPixels.length - (sc.getWidth() * r.getHeight()); i++) {

            istgleich = false;
            richtige = 0;
            xlage = 0;
            ylage = 0;
            fehler = 0;

            if (i == (scPixels.length - (sc.getWidth() * r.getHeight())) - 1) {
                
                koordinaten[0] = 0;
                koordinaten[1] = 0;
                return koordinaten;
            } else if (scPixels[i] == rPixels[xlage]) {
                // System.out.println("start i: " + i);
                istgleich = true;
                while (ylage < r.getHeight() && istgleich) {
                    while (xlage < r.getWidth() && istgleich) {
                        if (richtige >= rPixels.length - 1 - (int) maxfehler) {
                            
                            koordinaten[0] = i % sc.getWidth();
                            koordinaten[1] = (i - koordinaten[0]) / sc.getWidth();
                            // koordinaten anpassen
                            koordinaten[0] = koordinaten[0] + r.getWidth() / 2;
                            koordinaten[1] = koordinaten[1] + r.getHeight() / 2;
                            return koordinaten;
                        } else if ((scPixels[i + xlage + ylage * sc.getWidth()] != rPixels[xlage
                                + ylage * r.getWidth()]) && fehler <= (int) maxfehler) {
                            fehler++;
                            richtige++;
                        } else if ((scPixels[i + xlage + ylage * sc.getWidth()] != rPixels[xlage
                                + ylage * r.getWidth()]) && fehler > (int) maxfehler) {
                            istgleich = false;
                        } else {
                            richtige++;
                            // System.out.println("anzahl richtige= " + richtige);

                        }

                        xlage++;
                    }
                    xlage = 0;
                    ylage++;

                }

            }

        }

        koordinaten[0] = 0;
        koordinaten[1] = 0;
        return koordinaten;

    }

}