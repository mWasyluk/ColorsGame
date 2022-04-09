package pl.mvasio.gameApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pl.mvasio.colorsPalete.Palette;
import pl.mvasio.colorsPalete.RandomColor;

import java.io.IOException;
import java.util.List;

import static pl.mvasio.gameApp.GameplayProperties.*;

public class ColorGeneratorController extends GameController {

    @FXML
    private BorderPane palettePane;
    @FXML
    private Button generateColorsButton;
    @FXML
    private Button startGameButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Label aLabel;
    @FXML
    private Label bLabel;
    @FXML
    private Label cLabel;

    public static List<Color> colors;
    private static final double PALETTE_X = 140;
    private static final double PALETTE_Y = 110;
    private static final double PALETTE_RADIUS = 100;

    public ColorGeneratorController(){
        super();
        colors = super.colorsPool;
    }

    @FXML
    public void initialize(){
        palette.setLayout(PALETTE_X,PALETTE_Y);
        palettePane.getChildren().addAll(this.palette.getPalette());
        setLabels(colorsPoolSize, expectedQuantity, roundsQuantity);
    }

    private void setLabels(int v1, int v2, int v3){
        aLabel.setText(aLabel.getText() + v1);
        bLabel.setText(bLabel.getText() + v2);
        cLabel.setText(cLabel.getText() + v3);
    }

    @FXML
    void generateColors(ActionEvent event) {
        while ( !palettePane.getChildren().isEmpty() ) palettePane.getChildren().remove(0);

        Color [] c = RandomColor.getRandomColorsArray( colorsPoolSize > 0 ? colorsPoolSize : DEFAULT_COLOR_POOL_SIZE );
        super.palette.setColors(c);
        colors = List.of(c);
        palettePane.getChildren().setAll(super.palette.getPalette());
        if ( !palettePane.getChildren().isEmpty() ) {
            palettePane.getChildren().removeAll(super.palette.getPalette());
            super.palette = new Palette(PALETTE_RADIUS, palette.getColors());
            super.palette.setLayout(PALETTE_X, PALETTE_Y);
            palettePane.setCenter(super.palette);
        }
    }

    @FXML
    void openSettings(ActionEvent event) {
        try {
            this.switchToSettings(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void startGame(ActionEvent event) {
        try {
            this.switchToGameBoard(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

