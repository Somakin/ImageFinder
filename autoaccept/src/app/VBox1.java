package app;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VBox1 extends VBox{

    Button button;
    Label label;

    public VBox1() {

        initializeControls();
        layoutControls();

        


    }

    private void layoutControls() {

    getChildren().addAll(label,button);
    }


    private void initializeControls() {
        button = new Button("test");
        label = new Label("das Label");
    }
    
    
}
