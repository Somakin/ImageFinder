package app2;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicPane extends StackPane{

    private Circle circle;
    private Label label;
    private TextField textfeld;

    public GraphicPane(){
        //init
        circle = new Circle(100, 100, 50, Color.AQUAMARINE);
        label = new Label("Radius: ");
        textfeld = new TextField();
        textfeld.setEditable(true);

        //logic
        

        //layout
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label,textfeld);
        Pane circlePane = new Pane();
        circlePane.getChildren().addAll(circle);
        circlePane.setStyle("-fx-background-color: WHEAT");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox,circlePane);
        VBox.setVgrow(circlePane, Priority.ALWAYS);

        getChildren().addAll(vbox);

        
        
    }
    
}
