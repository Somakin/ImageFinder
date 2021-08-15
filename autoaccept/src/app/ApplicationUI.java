package app;


import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox{
    

    HBox1 HBox1;
    HBox2 Title;

    public ApplicationUI(){

        initializeControls();
        layoutControls();

        

    }

    private void layoutControls() {

        getChildren().addAll(Title,HBox1);
    }

    private void initializeControls() {

        HBox1 = new HBox1();
        Title = new HBox2();

    }
}
