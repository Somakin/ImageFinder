package app;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import logic.ImageFinder;

public class TopPart extends HBox {

    public Button button1;
    public Button button2;
    public static Label label;
    public Button button3;

    boolean gestoppt;

    public TopPart() {

        // init

        button1 = new Button("Start");
        button2 = new Button("Stop");
        label = Beschriftungen.not_Searching;
        button3 = new Button("Exit");
        gestoppt = true;
        // logic

        button1.setOnAction(actionEvent -> {
            gestoppt = false;
            label.setText(Beschriftungen.searching.getText());

            try {
                search();

            } catch (Exception e) {

                e.printStackTrace();
            }

        });

        button2.setOnAction(abbruch -> {
            gestoppt = true;
            label.setText(Beschriftungen.stopped_Searching.getText());

        });
        button3.setOnAction(exit -> {
            System.exit(0);
        });

        // layout
        getChildren().addAll(button1, button2, button3, label);
        setAlignment(Pos.TOP_CENTER);

    }

    public void search() throws Exception {
        Thread t2 = new Thread(new Runnable() {

            public void run() {

                boolean gefunden = false;
                while (!gefunden && !gestoppt) {
                    ImageFinder accept;
                    try {
                        accept = new ImageFinder("Moon.png",10);
                        accept.run();
                        if (accept.getImagefound()) {
                            gefunden = true;
                        }
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }

                System.out.println(BottomPart.champLabel.getText());

                // go to next stage: lock champion
                ImageFinder select;
                try {
                    
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        t2.start();

    }
}
