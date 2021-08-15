package app;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class HBox2 extends HBox{

    Button button;
    Label lable;

    public HBox2() {

        initializeControls();
        layoutControls();

        


    }

    private void layoutControls() {

    getChildren().addAll(lable);
    }


    private void initializeControls() {
        lable = new Label("Autoaccept");
        
        
    }
    
    
}
