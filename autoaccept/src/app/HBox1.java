package app;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import logic.Programm;

public class HBox1 extends HBox {

    Button button1;
    Button button2;
    Programm programm = new Programm();

    public HBox1() {

        initializeControls();
        layoutControls();

    }

    private void layoutControls() {

        getChildren().addAll(button1, button2);
    }

    private void initializeControls() {
        button1 = new Button("Start");
        button2 = new Button("Stop");

        button1.setOnAction(actionEvent -> {
            Programm programm = new Programm();

            try {
                programm.start();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        button2.setOnAction(actionEvent -> {
            System.out.println("abbruch");
            System.exit(0);
        });
    }

}
