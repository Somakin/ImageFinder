package app;

import javafx.scene.layout.HBox;

public class ApplicationUI extends HBox{
    

    VBox1 vBox1;
    VBox1 vBox2;

    public ApplicationUI(){

        initializeControls();
        layoutControls();

        

    }

    private void layoutControls() {

        getChildren().addAll(vBox1,vBox2);
    }

    private void initializeControls() {

        vBox1 = new VBox1();
        vBox2 = new VBox1();

    }
}
