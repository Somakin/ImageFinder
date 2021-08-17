package app;



import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.Programm;



public class MainPane extends StackPane {

    static volatile boolean bool = true;

    public Button button1;
    public Button button2;
    public Label lable;
    public Button button3;

  

    public MainPane() {

        initializeControls();
        layoutControls();

    }

    private void layoutControls() {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(button1, button2, lable, button3);
        vbox.setAlignment(Pos.CENTER);
        getChildren().addAll(vbox);
        
    }

    private void initializeControls() {
        
        button1 = new Button("Start");
        button2 = new Button("Stop");
        lable = new Label("not searching");
        button3 = new Button("Exit");
    
        

        button1.setOnAction(actionEvent -> {
            
                lable.setText("searching");
                bool = true;

                try {
                    foo();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
                

        });
     

        button2.setOnAction(abbruch -> {
            lable.setText("stopped searching");
            bool = false;
        });
        button3.setOnAction(exit -> {
            System.exit(0);
        });
        
        
            
       
    }

    public void foo() throws Exception {
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {

                    Programm programm = new Programm("Accept.png");
                    
                    while (!programm.getImagefound() && bool) {
                        Programm weitererVersuch = new Programm("Accept.png");
                        weitererVersuch.run();
                        if (weitererVersuch.getImagefound()) {
                            bool = false;
                            
                        }
                    }
                    
                    
                } catch (Exception e) {

                }
            }

        });

        t2.start();

    }

}


