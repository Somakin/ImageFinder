package logic;

import java.awt.event.*;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class AutoAction {

    public void klick(int x, int y) throws Exception {

        int mask = InputEvent.BUTTON1_DOWN_MASK;
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

    }

    public void writeAndEnter(String string) throws Exception {

        StringSelection stringSelection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        //clipboard.setContents(new StringSelection(""), new StringSelection(""));
    }

    
}
