package pl.mvasio.gameApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static pl.mvasio.gameApp.GameplayProperties.*;

public class SettingsController extends GameController {

    @FXML
    private ChoiceBox<Integer> colorsPoolSizeBox;
    @FXML
    private ChoiceBox<Integer> expectedQuantityBox;
    @FXML
    private ChoiceBox<Integer> roundsQuantityBox;
    @FXML
    private Label label;
    @FXML
    private Button defaultSettingsButton;
    @FXML
    private Button saveSettingsButton;

    public SettingsController (){
        super(  GameController.colorsPoolSize > 0 ? GameController.colorsPoolSize : DEFAULT_COLOR_POOL_SIZE,
                GameController.expectedQuantity > 0 ? GameController.expectedQuantity : DEFAULT_EXPECTED_QUANTITY,
                GameController.roundsQuantity > 0 ? GameController.roundsQuantity : DEFAULT_ROUNDS_QUANTITY,
                DEFAULT_COLORS );
    }

    @FXML
    private void initialize(){
        this.colorsPoolSizeBox.setValue(
                GameController.colorsPoolSize > 0 ? GameController.colorsPoolSize : DEFAULT_COLOR_POOL_SIZE );
        this.expectedQuantityBox.setValue(
                GameController.expectedQuantity > 0 ? GameController.expectedQuantity : DEFAULT_EXPECTED_QUANTITY );
        this.roundsQuantityBox.setValue(
                GameController.roundsQuantity > 0 ? GameController.roundsQuantity : DEFAULT_ROUNDS_QUANTITY );

        this.setBox(colorsPoolSizeBox, COLORS_POOL_SIZE_OPTIONS);
        this.setBox(expectedQuantityBox, EXPECTED_COLORS_QUANTITY_OPTIONS);
        this.setBox(roundsQuantityBox, ROUNDS_QUANTITY_OPTIONS);
    }

    private void setBox ( ChoiceBox<Integer> box, Set<Integer> options){
        box.getItems().addAll(options);
    }

    @FXML
    void saveSettings(ActionEvent event) {
        GameController.colorsPoolSize = colorsPoolSizeBox.getValue();
        GameController.expectedQuantity = expectedQuantityBox.getValue();
        GameController.roundsQuantity = roundsQuantityBox.getValue();

        try {
            super.switchToStartMenu(event);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void useDefaultSettings(ActionEvent event) {
        GameController.colorsPoolSize = DEFAULT_COLOR_POOL_SIZE;
        GameController.expectedQuantity = DEFAULT_EXPECTED_QUANTITY;
        GameController.roundsQuantity = DEFAULT_ROUNDS_QUANTITY;

        try {
            super.switchToStartMenu(event);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
