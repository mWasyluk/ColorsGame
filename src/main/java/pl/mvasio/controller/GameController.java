package pl.mvasio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static pl.mvasio.properties.GameScreenProperties.*;

public abstract class GameController {
    protected Parent root;
    protected Stage stage;
    protected Scene scene;

    protected void switchToGameBoard (ActionEvent event) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/BoardScreen.fxml")));
        this.scene = new Scene(this.root, BOARD_WIDTH, BOARD_HEIGHT);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.hide();
        this.stage.setScene(this.scene);
        this.stage.setX((SCREEN_WIDTH - BOARD_WIDTH) / 2);
        this.stage.setY((SCREEN_HEIGHT - BOARD_HEIGHT) / 2);
        this.stage.show();
    }

    protected void switchToStartMenu (ActionEvent event) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/MenuScreen.fxml")));
        this.scene = new Scene(this.root, MENU_WIDTH, MENU_HEIGHT);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.hide();
        this.stage.setScene(this.scene);
        this.stage.setX((SCREEN_WIDTH - MENU_WIDTH) / 2);
        this.stage.setY((SCREEN_HEIGHT - MENU_HEIGHT) / 2);
        this.stage.show();
    }

    protected void switchToSettings (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/SettingsScreen.fxml")));
        scene = new Scene(this.root, SETTINGS_WIDTH, SETTINGS_HEIGHT);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.hide();
        this.stage.setScene(this.scene);
        this.stage.setX((SCREEN_WIDTH - SETTINGS_WIDTH) / 2);
        this.stage.setY((SCREEN_HEIGHT - SETTINGS_HEIGHT) / 2);
        this.stage.show();
    }
}
