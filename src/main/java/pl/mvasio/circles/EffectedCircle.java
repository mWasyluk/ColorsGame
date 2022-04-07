package pl.mvasio.circles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class EffectedCircle extends Circle {

    public static final Color DEFAULT_COLOR = Color.rgb(255, 255, 255, 0.6);

    public EffectedCircle(double radius) {
        super(radius);
        this.setFill(DEFAULT_COLOR);
        this.setEffect(new CircleEffect());
        this.setStroke(Color.BLACK);
        this.setStrokeType(StrokeType.INSIDE);
    }

    public void setDefaultFill (){
        this.setFill(DEFAULT_COLOR);
    }
}
