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
        // TODO Auto-generated method stub
        

        Parent rootPanel = new ApplicationUI();
       

        Scene scene = new Scene(rootPanel);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
    
}
