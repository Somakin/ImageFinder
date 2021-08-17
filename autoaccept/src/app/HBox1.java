package app;



import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import logic.Programm;



public class HBox1 extends HBox {

    static volatile boolean bool = true;

    public Button button1;
    public Button button2;
    public Label lable;
    public Button button3;

  

    public HBox1() {

        initializeControls();
        layoutControls();

    }

    private void layoutControls() {

        getChildren().addAll(button1, button2, lable, button3);
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

                    Programm programm = new Programm("InQ.png");
                    
                    while (!programm.getImagefound() && bool) {
                        Programm weitererVersuch = new Programm("InQ.png");
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


