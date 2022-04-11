package pl.mvasio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.util.List;

import static pl.mvasio.game.GameSettings.*;
import static pl.mvasio.properties.GameplayProperties.*;

public class SettingsController extends GameController{

    @FXML
    private ChoiceBox<Integer> colorsPoolSizeBox;
    @FXML
    private ChoiceBox<Integer> expectedQuantityBox;
    @FXML
    private ChoiceBox<Integer> roundsQuantityBox;
    @FXML
    private Button defaultSettingsButton;
    @FXML
    private Button saveSettingsButton;

    @FXML
    private void initialize(){
        this.colorsPoolSizeBox.setValue(COLORS_POOL_SIZE);
        this.expectedQuantityBox.setValue(COLORS_TO_GUESS_QUANTITY);
        this.roundsQuantityBox.setValue(ROUNDS_QUANTITY);

        this.initializeOptionsBoxes();
        this.initializeEventHandlers();
    }

    private void initializeOptionsBoxes(){
        this.colorsPoolSizeBox.getItems().addAll(COLORS_POOL_SIZE_OPTIONS);
        this.expectedQuantityBox.getItems().addAll(COLORS_TO_GUESS_QUANTITY_OPTIONS);
        this.roundsQuantityBox.getItems().addAll(ATTEMPTS_QUANTITY_OPTIONS);
    }

    private void initializeEventHandlers() {
        this.defaultSettingsButton.addEventHandler(ActionEvent.ACTION, event -> {
            setDefaultSetting();
            try {
                super.switchToStartMenu(event);
            } catch (IOException e){
                e.printStackTrace();
            }
        });

        this.saveSettingsButton.addEventHandler(ActionEvent.ACTION, event -> {
            COLORS_POOL_SIZE = colorsPoolSizeBox.getValue();
            COLORS_TO_GUESS_QUANTITY = expectedQuantityBox.getValue();
            ROUNDS_QUANTITY = roundsQuantityBox.getValue();
            try {
                super.switchToStartMenu(event);
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }
}
