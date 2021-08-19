package io;

import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Test {
    public static void main(String[] args){
        
        boolean filenotfound = true;
        String test = "..\\..\\..\\..\\..\\autoaccept\\src\\io\\Moon.png";
        String filestring = "C:\\stuff.tower\\code\\git\\ImageFinder\\autoaccept\\src\\io\\Moon.png";
            //while (filenotfound)
                try {
                    File file = new File(test);
                    
                    String path = file.getPath();
                    System.out.println(path);
                    String absPath = file.getAbsolutePath();
                    System.out.println(absPath);

                    BufferedImage bild = ImageIO.read(file);
                    filenotfound = false;
                    System.out.println("file gefunden");
                } catch (IOException e) {
                    
                    System.out.println("nicht möglich");
                }
            
        
       
            
        
    }
}

