package app;

import io.Champions;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BottomPart extends VBox {

    public volatile boolean inChampSelect;
    public Button enter;
    public TextField championfield;
    public Label beschriftung;
    public Label champLabel;

    public BottomPart() {
        // init
        beschriftung = new Label("Champion präferenz");
        champLabel = new Label("champ not yet chosen");
        championfield = new TextField();
        enter = new Button("lock");
        inChampSelect = false;
        // logic
        enter.setOnAction(event -> {
            try {
                Champions champions = new Champions();
                
                if (champions.getAllChampionsHashSet().contains(championfield.getText())) {
                champLabel.setText("chosen Champ: " + championfield.getText());
                championfield.clear();

                }
                else{champLabel.setText("not a Champion");}
                
            } catch (Exception e) {

                e.printStackTrace();
            }

        });

        // Layout
        HBox hbox = new HBox();
        hbox.getChildren().addAll(championfield, enter);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        getChildren().addAll(beschriftung, hbox, champLabel);
        setAlignment(Pos.BOTTOM_CENTER);
    }

}
