package pl.mvasio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pl.mvasio.view.*;
import pl.mvasio.color.ColorsHolder;
import pl.mvasio.game.Game;
import pl.mvasio.game.RoundsValidator;
import pl.mvasio.view.RoundView;

import java.io.IOException;

import static pl.mvasio.game.GameSettings.getActualColorsPool;
import static pl.mvasio.properties.GameplayProperties.*;
import static pl.mvasio.game.GameSettings.*;

public class BoardController extends GameController {
    @FXML
    private VBox roundsViewPane;
    @FXML
    private BorderPane colorsSelectionPane;
    @FXML
    private Button acceptButton;
    @FXML
    private Button undoButton;
    @FXML
    private Button backToMenuButton;
    @FXML
    private Text remainingRoundsLabel;
    @FXML
    private Text resultInfoText;

    private final Palette colorsPalette;
    private final ColorsHolder colorsHolder;
    private ModifiedCirclesRow selectedCirclesRow;
    private Game game;
    private RoundsValidator roundsValidator;

    public BoardController(){
        this.colorsPalette = new Palette(DEFAULT_INGAME_PALETTE_RADIUS, getActualColorsPool());
        this.colorsHolder = new ColorsHolder(COLORS_TO_GUESS_QUANTITY);
    }

    @FXML
    private void initialize(){
        initializeView();
        initializeEventHandlers();
        this.startNewGame();
    }

    private void initializeView(){
        this.selectedCirclesRow = new ModifiedCirclesRow(
                COLORS_TO_GUESS_QUANTITY,
                DEFAULT_SELECTED_COLOR_CIRCLE_RADIUS,
                DEFAULT_SELECTED_COLOR_CIRCLE_SPACING,
                DEFAULT_SELECTED_COLOR_CIRCLE_PADDING);
        this.colorsSelectionPane.setCenter(this.colorsPalette);
        this.colorsSelectionPane.setBottom(this.selectedCirclesRow);
        this.colorsPalette.setPaletteLayout(this.colorsSelectionPane.getPrefWidth() / 2 , DEFAULT_INGAME_PALETTE_RADIUS);
    }

    private void initializeEventHandlers(){
        this.colorsPalette.setEventHandler(event -> {
            this.colorsHolder.addColor(((ColorPaletteArc)event.getSource()).getColor());
            this.selectedCirclesRow.setColors(this.colorsHolder.getColors());
        });

        this.undoButton.addEventHandler(ActionEvent.ACTION, event -> {
            this.colorsHolder.removeColor(this.colorsHolder.getColors().size() - 1);
            this.selectedCirclesRow.resetColorToDefaultByIndex(this.colorsHolder.getColors().size());
        });

        this.acceptButton.addEventHandler(ActionEvent.ACTION, event -> {
            if (this.colorsHolder.getColors().size() == COLORS_TO_GUESS_QUANTITY) {
                this.roundsValidator.validateWith(this.colorsHolder.getColors());
                RoundView round = new RoundView(
                        this.colorsHolder.getColors(),
                        this.roundsValidator.getResultMap().getCorrectSelectionsQuantity(),
                        this.roundsValidator.getResultMap().getMisplacedSelectionsQuantity()
                );
                this.selectedCirclesRow.resetAllColorsToDefault();
                this.colorsHolder.removeAllColors();
                this.roundsViewPane.getChildren().add(round);
                this.game.decreaseRemainingRounds();
                this.setRemainingRoundsLabel();

                if (this.roundsValidator.getResultMap().getCorrectSelectionsQuantity() == this.game.getColorsToGuess().size()){
                    this.gameWon();
                    this.startNewGame();
                }
                else if ( this.game.getRemainingRounds() <= 0){
                    this.gameLost();
                    this.startNewGame();
                }
            }
        });

        this.backToMenuButton.addEventHandler(ActionEvent.ACTION, event -> {
            try {
                this.switchToStartMenu(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setRemainingRoundsLabel(){
        this.remainingRoundsLabel.setText(
                "Szanse: " + this.game.getRemainingRounds() );
    }

    private void startNewGame(){
        this.roundsViewPane.getChildren().clear();
        this.resultInfoText.setText("");
        this.game = new Game();
        this.roundsValidator = new RoundsValidator(this.game.getColorsToGuess());
        this.setRemainingRoundsLabel();
    }

    private void gameLost(){
        this.resultInfoText.setText("Nie udało Ci się :(");
        this.showInfoAlert(LOSER_ALERT_HEADER, LOSER_ALERT_CONTENT);
    }

    private void gameWon(){
        this.resultInfoText.setText("Wygranko!");
        this.showInfoAlert(WINNER_ALERT_HEADER, WINNER_ALERT_CONTENT);
    }

    private void showInfoAlert(String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.getDialogPane().setContentText(content);
        alert.showAndWait();
    }
}