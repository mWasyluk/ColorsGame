package pl.mvasio.selectedColorsBar;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import pl.mvasio.circles.CircleEffect;

public class SelectedColorsBarCircle extends Circle {

    public static final Color DEFAULT_COLOR = Color.rgb(255, 255, 255, 0.6);
    private boolean isSelected;

    public SelectedColorsBarCircle(double radius) {
        super();
        this.setFill(DEFAULT_COLOR);
        this.setRadius(radius);
        this.setEffect(new CircleEffect());
        this.setStrokeType(StrokeType.OUTSIDE);
    this.setStroke(Color.BLACK);
    }

    protected void unselectColor (){
        this.setFill(DEFAULT_COLOR);
        this.setIsSelected(false);
    }

    protected void setIsSelected(boolean b){
        this.isSelected = b;
    }

}
