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
    public Label champion;
    public static Label champLabel;

    public BottomPart() {
        // init
        beschriftung = Beschriftungen.champion_präferenz;
        champLabel = Beschriftungen.none;
        champion = Beschriftungen.champion;
        championfield = new TextField();
        enter = new Button("lock");
        inChampSelect = false;
        // logic
        enter.setOnAction(event -> {
            try {
                Champions champions = new Champions();

                if (champions.getAllChampionsHashSet().contains(championfield.getText())) {
                    champLabel.setText(championfield.getText());
                    champion.setText(Beschriftungen.champion.getText());
                    championfield.clear();

                } else {
                    champLabel.setText(Beschriftungen.öb_du_behenderet_besch_hani_gfrogt.getText());
                    champion.setText("");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        });

        // Layout
        HBox hbox = new HBox();
        hbox.getChildren().addAll(championfield, enter);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(champion, champLabel);
        hbox2.setAlignment(Pos.BASELINE_CENTER);
        getChildren().addAll(beschriftung, hbox, hbox2);
        setAlignment(Pos.BOTTOM_CENTER);
    }

}
