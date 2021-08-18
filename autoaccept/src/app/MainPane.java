package app;


import javafx.scene.layout.VBox;

public class MainPane extends VBox {

    TopPart top;
    BottomPart bot;
    public MainPane(){
        //init
        top = new TopPart();
        bot = new BottomPart();
        //logic

        //Layout
        getChildren().addAll(top,bot);
    }
    
}
