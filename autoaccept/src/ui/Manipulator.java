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

    public int[] compare(int[] scPixels, int[] rPixels_1, int[] rPixels_ganz, BufferedImage sc, BufferedImage r) {
        int i_start = 0;
        int[] koordinate = new int[2];
        int bild_start = 0;
        boolean erste = false;
        boolean falseBild = false;
        

        while(true){
        for (int i = i_start; i < scPixels.length - rPixels_1.length; i++) {
            if(i == scPixels.length - rPixels_1.length-1){
                koordinate[0]=0;
                koordinate[1]=0;
                return koordinate;
            }
            if (!erste) {
                for (int j = 0; j < rPixels_1.length; j++) {
                    if (j == rPixels_1.length - 1) {
                        // erste Reihe gefunden
                        koordinate[0] = i % sc.getWidth();
                        koordinate[1] = (i - koordinate[0]) / sc.getWidth();
                        bild_start = i;
                        
                        erste = true;
                        System.out.println("erste Reihe gefunden");
                        // koordinaten in die Mitte verstellen
                        koordinate[0] = i % sc.getWidth() + r.getWidth() / 2;
                        koordinate[1] = (i - koordinate[0]) / sc.getWidth() + r.getHeight() / 2;

                        break;

                    } else if (scPixels[i + j] == rPixels_1[j]) {
                    } else {
                        break;
                    }
                }
            }
        }
             
        
            if (erste) {
            
            for (int x = 0; x < r.getWidth(); x++) {
                if(!falschesBild){

                for (int y = 1; y > r.getHeight(); y++) {
                    if (y == r.getWidth() - 1) {
                        // Bild ganz gefunden
    
                        
    
                        // koordinaten zurückgeben
                        return koordinate;
                    }
                    
                    else if (scPixels[bild_start + x + y * sc.getWidth()] == rPixels_ganz[x + y * r.getWidth()]) {
                        

                    } else {
                        // auf 2D ebene nicht richtiges Bild
                        System.out.println("falsches 2 D bild");
                        falschesBild = true;
                        
                        break;
                    }
                
                    
                    }
                }
            }
        }
    
        
        


        }
    }
}