package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
       
        //init scene
        MainPane hBox1 = new MainPane();

        //layout
        stage.setTitle("League Q-Accepter");
        stage.setWidth(300);
        Scene scene = new Scene(hBox1);
        

        //start
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
    
}
