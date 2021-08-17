package app2;


import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;


public class MainPane extends StackPane {

    ControlPane controlPane;
    GraphicPane graphicPane;

    public MainPane(){
        //init
        controlPane = new ControlPane();
        graphicPane = new GraphicPane();
        //logic

        //layout
        SplitPane split = new SplitPane();
        split.setDividerPosition(0,0.1);
        split.getItems().addAll(controlPane,graphicPane);

        getChildren().add(split);
    }
    
}
