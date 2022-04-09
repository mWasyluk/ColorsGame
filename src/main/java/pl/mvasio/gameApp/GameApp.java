package pl.mvasio.gameApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

import static pl.mvasio.gameApp.GameScreenProperties.*;



public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GameMenu.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Colors Game");
        stage.setResizable(false);
        stage.setX((SCREEN_WIDTH - MENU_WIDTH) / 2);
        stage.setY((SCREEN_HEIGHT - MENU_HEIGHT) / 2);
        stage.show();

    }

    public static void main (String... args){
        launch(args);
    }
}
