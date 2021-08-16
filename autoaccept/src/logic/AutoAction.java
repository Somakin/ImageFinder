package logic;

import java.awt.event.*;
import java.awt.Robot;



public class AutoAction {
    

    public void klick(int x, int y)throws Exception{

    
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(mask);     
        bot.mouseRelease(mask);
        
    }
    
    
}
