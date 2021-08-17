package app2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicPane extends Pane{

    Circle circle;

    public GraphicPane(){
        //init
        circle = new Circle(100, 100, 50, Color.AQUAMARINE);
        //logic

        //layout
        getChildren().add(circle);
        setStyle("-fx-background-color: WHEAT");
    }
    
}
