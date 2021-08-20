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

    static volatile boolean gestoppt;
    static volatile boolean ingame;
    static volatile boolean inChampSelect;

    public TopPart() {

        // init

        button1 = new Button("Start");
        button2 = new Button("Stop");
        label = Beschriftungen.not_Searching;
        button3 = new Button("Exit");
        gestoppt = true;
        ingame = false;
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

                AutoAction aa = new AutoAction();

                ImageFinder acceptQ;
                try {
                    while (!ingame) {
                        if ((!gestoppt && !(new ImageFinder("inChampSelect.png", 10).getImagefound()))
                                && !(new ImageFinder("Accept.png", 10).getImagefound())
                                || !(new ImageFinder("inChampSelect.png", 10).getImagefound())) {
                            inChampSelect = false;
                            acceptQ = new ImageFinder("Accept.png", 10);
                            if (acceptQ.getImagefound()) {
                                aa.klick(acceptQ.getX(), acceptQ.getY());
                                inChampSelect = true;
                            }

                        } else if ((new ImageFinder("inChampSelect.png", 10).getImagefound())) {

                            // go to next stage: lock champion
                            ImageFinder champselect = new ImageFinder("inChampSelect.png", 10);
                            trueX = champselect.getX();
                            trueY = champselect.getY();
                            // write in chat
                            aa.klick((int) trueX - 270, (int) trueY);
                            String text = "I PICK: " + BottomPart.champLabel.getText();
                            aa.writeAndEnter(text);
                            // search champ
                            aa.klick((int) trueX + 370, (int) trueY - 580);
                            aa.writeAndEnter(BottomPart.champLabel.getText());
                            // klick on champ
                            Thread.sleep(500);
                            aa.klick((int) trueX - 20, (int) trueY - 520);
                            // lock
                            Thread.sleep(500);
                            aa.klick((int) trueX + 235, (int) trueY - 80);
                            // backup if q gets doged
                            while ((new ImageFinder("inChampSelect.png", 10).getImagefound())) {//TODO: muss anderes bild sein
                                if(!(new ImageFinder("inChampSelect.png", 10).getImagefound()))//TODO: anders bild seon
                                Thread.sleep(2000);
                                if(!(new ImageFinder("inQ.png", 10).getImagefound())){
                                    System.exit(0);
                                }
                            }
                        }
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });

        t2.start();

    }
}
