package pl.mvasio.colorsPalete;

import javafx.scene.Cursor;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeType;

public class MyArc extends Arc {
    private Color color;

    Effect defaultEffect = new PaletteEffect();
    Effect hoverEffect = new PaletteHoverEffect();

    public MyArc(Color color, double length, double startAngle) {
        super();
        this.color = color;

        this.setStartAngle(startAngle);
        this.setLength(length);
        this.setRadiusX(100);
        this.setRadiusY(100);

        this.setView();

        this.setMouseProperties();
    }

    public MyArc ( Color color, double length, double startAngle, double radius){
        this(color, length, startAngle);
        this.setRadiusX(radius);
        this.setRadiusY(radius);
    }

    public Color getColor() {
        return color;
    }

    private void setMouseProperties(){
        this.setCursor(Cursor.HAND);
        this.setOnMouseEntered(e -> {
            this.setEffect(hoverEffect);
        });
        this.setOnMouseExited(e -> {
            this.setEffect(defaultEffect);
        });

    }

    private void setView(){
        this.setFill(color);
        this.setEffect(defaultEffect);
        this.setType(ArcType.ROUND);
        this.setStroke(Color.BLACK);
        this.setStrokeType(StrokeType.INSIDE);
    }
}
