package pl.mvasio.roundsView;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.mvasio.circles.EffectedCircle;

import java.util.List;

public class RowOfCircles extends HBox {

    public RowOfCircles(List<Color> colors, double radius, double spaceBetween) {
        super(spaceBetween);
        this.addColoredCircles(colors, radius);
        this.setPadding(new Insets(10));
    }

    public RowOfCircles(List <Color>  colors, double radius, double spaceBetween, double padding) {
        this(colors, radius, spaceBetween);
        this.setPadding(new Insets(padding));
    }

    private void addColoredCircles(List <Color>  colors, double radius){
        for ( Color c: colors) {
            Circle circle = new EffectedCircle(radius);
            circle.setFill(c);
            this.getChildren().add(circle);
        }
    }
}
