module ColorsGame {

    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;

    opens pl.mvasio.color to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    opens pl.mvasio.controller to javafx.fxml, javafx.graphics;
    opens pl.mvasio.view to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    opens pl.mvasio.properties to javafx.fxml, javafx.graphics;
    opens pl.mvasio to javafx.fxml, javafx.graphics;
    opens pl.mvasio.game to javafx.fxml, javafx.graphics;
}