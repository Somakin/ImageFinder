package ui;

import java.awt.event.*;
import java.awt.Robot;

public class AutoAction {

    public void klick(int[] xyPosition)throws Exception{

        int x = xyPosition[0];
        int y = xyPosition[1];
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        Robot bot = new Robot();
        if(x > 1){
        bot.mouseMove(x, y);
        bot.mousePress(mask);     
        bot.mouseRelease(mask);
        }
        
    }
    
}
