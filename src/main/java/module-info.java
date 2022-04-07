module ColorsGame {

    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;

    opens pl.mvasio.gameApp to javafx.graphics, javafx.fxml;
    opens pl.mvasio.selectedColorsBar to javafx.graphics, javafx.fxml, javafx.base, javafx.controls;
    opens pl.mvasio.colorsPalete to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
}