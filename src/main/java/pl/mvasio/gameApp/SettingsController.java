package pl.mvasio.gameApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class SettingsController extends AppController{

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

    public static final int DEFAULT_COLOR_POOL_SIZE = 6;
    public static final int DEFAULT_EXPECTED_QUANTITY = 3;
    public static final int DEFAULT_ROUNDS_QUANTITY = 6;

    private static int [] colorsPoolSizeOptions = new int[]{
            3,
            4,
            5,
            6,
            7,
            8,
            9
    } ;

    private static int [] expectedQuantityOptions = new int[]{
            2,
            3,
            4,
            5,
            6,
    };

    private static int [] roundsQuantityOptions = new int[]{
            2,
            3,
            4,
            5,
            6,
            7,
            8
    };


    public SettingsController (){
        super(  AppController.colorsPoolSize > 0 ? AppController.colorsPoolSize : SettingsController.DEFAULT_COLOR_POOL_SIZE,
                AppController.expectedQuantity > 0 ? AppController.expectedQuantity : SettingsController.DEFAULT_EXPECTED_QUANTITY,
                AppController.roundsQuantity > 0 ? AppController.roundsQuantity : SettingsController.DEFAULT_ROUNDS_QUANTITY,
                List.of(AppController.defaultColors));
    }

    @FXML
    private void initialize(){
        this.colorsPoolSizeBox.setValue(
                AppController.colorsPoolSize > 0 ? AppController.colorsPoolSize : DEFAULT_COLOR_POOL_SIZE );
        this.expectedQuantityBox.setValue(
                AppController.expectedQuantity > 0 ? AppController.expectedQuantity : DEFAULT_EXPECTED_QUANTITY );
        this.roundsQuantityBox.setValue(
                AppController.roundsQuantity > 0 ? AppController.roundsQuantity : DEFAULT_ROUNDS_QUANTITY );

        this.setBox(colorsPoolSizeBox, colorsPoolSizeOptions);
        this.setBox(expectedQuantityBox, expectedQuantityOptions);
        this.setBox(roundsQuantityBox, roundsQuantityOptions);
    }

    private void setBox ( ChoiceBox<Integer> box, int[] items){
        for ( int i: items){
            box.getItems().add(i);
        }
    }

    @FXML
    void saveSettings(ActionEvent event) {
        AppController.colorsPoolSize = colorsPoolSizeBox.getValue();
        AppController.expectedQuantity = expectedQuantityBox.getValue();
        AppController.roundsQuantity = roundsQuantityBox.getValue();

        try {
            super.switchToStartMenu(event);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(colorsPoolSize + " " + expectedQuantity + " " + roundsQuantity);
    }

    @FXML
    void useDefaultSettings(ActionEvent event) {
        AppController.colorsPoolSize = DEFAULT_COLOR_POOL_SIZE;
        AppController.expectedQuantity = DEFAULT_EXPECTED_QUANTITY;
        AppController.roundsQuantity = DEFAULT_ROUNDS_QUANTITY;

        try {
            super.switchToStartMenu(event);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
