package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
       
        //init scene
        HBox1 hBox1 = new HBox1();

        //layout
        stage.setTitle("League Q-Accepter");
        Scene scene = new Scene(hBox1,300,200);
        

        //start
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
    
}
