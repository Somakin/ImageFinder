package app2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application{
public static void main(String[] args) {
    launch(args);
}
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TestApp");
        

        MainPane mainPane = new MainPane();
        StackPane pane2 = new StackPane();

        Label label = new Label("Test");
        pane2.getChildren().addAll(label);

        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(400);

        stage.show();
        
    }
  
}
