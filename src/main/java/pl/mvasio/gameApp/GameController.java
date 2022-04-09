package pl.mvasio.gameApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.mvasio.colorsPalete.Palette;
import pl.mvasio.game.ColorsGenerator;
import pl.mvasio.game.NewGame;
import pl.mvasio.roundsView.RoundView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static pl.mvasio.gameApp.GameScreenProperties.*;
import static pl.mvasio.gameApp.GameplayProperties.*;

public abstract class GameController {
    protected Parent root;
    protected Stage stage;
    protected Scene scene;

    protected static int colorsPoolSize;
    protected static int expectedQuantity;
    protected static int roundsQuantity;

    protected List <Color> colorsPool;
    protected List <Color> colorsToGuess;

    protected NewGame game;
    protected Palette palette;

    public GameController(){
        this (  colorsPoolSize > 0 ? colorsPoolSize : DEFAULT_COLOR_POOL_SIZE,
                expectedQuantity > 0 ? expectedQuantity: DEFAULT_EXPECTED_QUANTITY,
                roundsQuantity > 0 ? roundsQuantity : DEFAULT_ROUNDS_QUANTITY );
    }

    public GameController(int poolSize, int expectedQuantity, int roundsQuantity){
        this (poolSize, expectedQuantity, roundsQuantity, DEFAULT_COLORS );
    }

    public GameController(int poolSize, int expectedQuantity, int roundsQuantity, List<Color> colorsPool){
        this ( poolSize, expectedQuantity, roundsQuantity, colorsPool, INGAME_PALETTE_RADIUS);
    }

    public GameController(int poolSize, int expectedQuantity, int roundsQuantity, List<Color> colorsPool, double paletteRadius){
        GameController.colorsPoolSize = poolSize;
        GameController.expectedQuantity = expectedQuantity;
        GameController.roundsQuantity = roundsQuantity;
        Color [] colorsForPalette = new Color[poolSize];
        for ( int i = 0; i < poolSize; i++){
            colorsForPalette[i] = colorsPool.get(i);
        }
        this.colorsPool = List.of(colorsForPalette);
        this.colorsToGuess = new ColorsGenerator( colorsPool , expectedQuantity ).getColorsToGuess();
        this.palette = new Palette(paletteRadius, colorsForPalette);
        RoundView.newGame(roundsQuantity);
        this.game = new NewGame(roundsQuantity, expectedQuantity, colorsPool);
    }

    protected void switchToGameBoard (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/GameScene.fxml")));
        scene = new Scene(root, GAME_SCENE_WIDTH, GAME_SCENE_HEIGHT);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setX((SCREEN_WIDTH - GAME_SCENE_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - GAME_SCENE_HEIGHT) / 2);
        stage.show();
    }

    protected void switchToStartMenu (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/GameMenu.fxml")));
        scene = new Scene(root, MENU_WIDTH, MENU_HEIGHT);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setX((SCREEN_WIDTH - MENU_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - MENU_HEIGHT) / 2);
        stage.show();
    }

    protected void switchToSettings (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/GameSettings.fxml")));
        scene = new Scene(root, SETTINGS_WIDTH, SETTINGS_HEIGHT);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setX((SCREEN_WIDTH - SETTINGS_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - SETTINGS_HEIGHT) / 2);
        stage.show();
    }
}
