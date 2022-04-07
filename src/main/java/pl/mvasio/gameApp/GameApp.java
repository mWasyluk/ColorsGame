package pl.mvasio.gameApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;


public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(Objects.requireNonNull(getClass().getResource("/GameMenu.fxml")));

        stage.setScene(new Scene(root));
        stage.setTitle("Colors Game");
        stage.setResizable(false);
        stage.setX((AppController.SCREEN_WIDTH - AppController.MENU_WIDTH) / 2);
        stage.setY((AppController.SCREEN_HEIGHT - AppController.MENU_HEIGHT) / 2);
        stage.show();

    }

    public static void main (String... args){
        launch(args);
    }
}
