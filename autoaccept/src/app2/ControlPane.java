package app2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class ControlPane extends StackPane {

    Label sliderwert;
    Slider slider;

    public ControlPane(){
        //init
        sliderwert = new Label("sliderwert");
        slider = new Slider();

        //logic

        //layout
        VBox vbox = new VBox();
        vbox.getChildren().addAll(sliderwert,slider);
        vbox.setAlignment(Pos.CENTER);

        getChildren().addAll(vbox);
    }
}
