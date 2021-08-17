package app;


import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox{
    

    HBox1 HBox1;
 

    public ApplicationUI(){

        initializeControls();
        layoutControls();

        

    }

    private void layoutControls() {

        getChildren().addAll(HBox1);
    }

    private void initializeControls() {

        HBox1 = new HBox1();
       

    }
}
