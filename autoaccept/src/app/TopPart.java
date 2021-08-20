package app;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.HBox;
import logic.AutoAction;
import logic.ImageFinder;

public class TopPart extends HBox {

    public Button button1;
    public Button button2;
    public static Label label;
    public Button button3;

    public static volatile double trueX, trueY;

    boolean gestoppt;

    public TopPart() {

        // init

        button1 = new Button("Start");
        button2 = new Button("Stop");
        label = Beschriftungen.not_Searching;
        button3 = new Button("Exit");
        gestoppt = true;
        trueX = 0;
        trueY = 0;

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

                AutoAction bot = new AutoAction();
                ImageFinder acceptQ;
                try {
                    while ((!gestoppt && !(new ImageFinder("inChampSelect.png", 10).getImagefound()))
                            && !(new ImageFinder("Moon.png", 10).getImagefound())
                            || !(new ImageFinder("inChampSelect.png", 10).getImagefound())) {
                        acceptQ = new ImageFinder("Moon.png", 10);
                        if (acceptQ.getImagefound()) {
                            bot.klick(acceptQ.getX(), acceptQ.getY());
                        }

                    }
                    // go to next stage: lock champion
                    ImageFinder champselect = new ImageFinder("inChampSelect.png", 10);
                    trueX = champselect.getX();
                    trueY = champselect.getY();
                    bot.klick((int)trueX -270,(int)trueY);
                    String text = "I PICK: " + BottomPart.champLabel.getText();
                    System.out.println(text);

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        t2.start();

    }
}
