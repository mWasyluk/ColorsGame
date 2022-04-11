package pl.mvasio.properties;

import javafx.stage.Screen;

public interface GameScreenProperties {
    double BOARD_WIDTH = 940;
    double BOARD_HEIGHT = 680;
    double MENU_WIDTH = 550;
    double MENU_HEIGHT = 300;
    double SETTINGS_WIDTH = 600;
    double SETTINGS_HEIGHT = 400;
    double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();
    double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();
    double MENU_PALLET_LAYOUT_X = 140;
    double MENU_PALLET_LAYOUT_Y = 110;
}
