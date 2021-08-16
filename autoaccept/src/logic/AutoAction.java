package logic;

import java.awt.event.*;
import java.awt.Robot;

public class AutoAction {
    int x,y;

    public boolean klick(int[] xyPosition)throws Exception{

        this.x = xyPosition[0];
        this.y = xyPosition[1];
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        Robot bot = new Robot();
        if(x > 1){
        bot.mouseMove(this.x, this.y);
        bot.mousePress(mask);     
        bot.mouseRelease(mask);
        return true;
        }
        return false;
    }
    public boolean isTrue(){

        return true;
    }
    
}
