package pl.mvasio.view;

import javafx.scene.shape.Circle;

import static pl.mvasio.properties.GameplayProperties.*;

public abstract class ModifiedCircle{
    public static Circle getModifiedCircle(double radius) {
        var circle = new Circle(radius);
        circle.setFill(DEFAULT_CIRCLE_COLOR);
        circle.setStroke(DEFAULT_CIRCLE_STROKE_COLOR);
        circle.setStrokeType(DEFAULT_CIRCLE_STROKE_TYPE);
        circle.setEffect(CircleEffect.getCircleEffect());
        return circle;
    }
}
