package pl.mvasio.view;

import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeType;

import static pl.mvasio.properties.GameplayProperties.*;

public class ColorPaletteArc extends Arc {

    public ColorPaletteArc(Color color, double length, double startAngle, double radius){
        super();
        this.setFill(color);
        this.setLength(length);
        this.setStartAngle(startAngle);
        this.setRadiusX(radius);
        this.setRadiusY(radius);
        this.setMouseProperties();
        this.setType(ArcType.ROUND);
        this.setStroke(DEFAULT_CIRCLE_STROKE_COLOR);
        this.setEffect(PALETTE_DEFAULT_EFFECT);
        this.setStrokeType(StrokeType.INSIDE);
    }

    private void setMouseProperties(){
        this.setOnMouseEntered(e -> {
            this.setEffect(PALETTE_HOVER_EFFECT);
            this.setCursor(Cursor.HAND);
        });
        this.setOnMouseExited(e -> {
            this.setEffect(PALETTE_DEFAULT_EFFECT);
            this.setCursor(Cursor.DEFAULT);
        });
    }

    public Color getColor() {
        return (Color) this.getFill();
    }
}
