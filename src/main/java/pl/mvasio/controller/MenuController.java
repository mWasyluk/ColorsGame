package pl.mvasio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import pl.mvasio.color.ColorsGenerator;
import pl.mvasio.view.Palette;

import java.io.IOException;

import static pl.mvasio.game.GameSettings.*;
import static pl.mvasio.properties.GameplayProperties.*;
import static pl.mvasio.properties.GameScreenProperties.*;

public class MenuController extends GameController {
    @FXML
    private BorderPane palettePane;
    @FXML
    private Button generateColorsButton;
    @FXML
    private Button goToSettingsButton;
    @FXML
    private Button startGameButton;
    @FXML
    private Label aLabel;
    @FXML
    private Label bLabel;
    @FXML
    private Label cLabel;

    private Palette palette;

    public MenuController(){
        this.palette = new Palette(
                DEFAULT_MENU_PALETTE_RADIUS,
                getActualColorsPool(),
                MENU_PALLET_LAYOUT_X,
                MENU_PALLET_LAYOUT_Y);
    }

    public void initialize(){
        this.palette.setPaletteLayout(MENU_PALLET_LAYOUT_X, MENU_PALLET_LAYOUT_Y);
        this.palettePane.getChildren().addAll(this.palette.getPaletteArcs());
        this.initializeLabels(COLORS_POOL_SIZE, COLORS_TO_GUESS_QUANTITY, ROUNDS_QUANTITY);
        this.initializeEventHandlers();
    }

    private void initializeLabels(int colorsPoolSize, int colorsToGuessQuantity, int roundsQuantity){
        this.aLabel.setText(this.aLabel.getText() + colorsPoolSize);
        this.bLabel.setText(this.bLabel.getText() + colorsToGuessQuantity);
        this.cLabel.setText(this.cLabel.getText() + roundsQuantity);
    }

    private void initializeEventHandlers() {
        this.generateColorsButton.addEventHandler(ActionEvent.ACTION, event -> {
            FULL_COLORS_POOL = ColorsGenerator.getRandomColorsList(FULL_COLORS_POOL.size());
            this.palette = new Palette(
                    DEFAULT_MENU_PALETTE_RADIUS,
                    getActualColorsPool(),
                    MENU_PALLET_LAYOUT_X,
                    MENU_PALLET_LAYOUT_Y);
            this.palettePane.getChildren().removeAll();
            this.palettePane.getChildren().addAll(palette.getPaletteArcs());
        });

        this.goToSettingsButton.addEventHandler(ActionEvent.ACTION, event -> {
            try {
                this.switchToSettings(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        this.startGameButton.addEventHandler(ActionEvent.ACTION, event -> {
            try {
                this.switchToGameBoard(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

