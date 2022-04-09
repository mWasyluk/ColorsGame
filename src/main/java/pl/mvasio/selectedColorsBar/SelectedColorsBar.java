package pl.mvasio.selectedColorsBar;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pl.mvasio.circles.EffectedCircle;

import java.util.ArrayList;
import java.util.List;

public class SelectedColorsBar extends HBox {

    private final int circlesQuantity;
    private final double radius;
    private List<EffectedCircle> circles;

    public SelectedColorsBar(int circlesQuantity, double radius) {
        this.circlesQuantity = circlesQuantity;
        this.radius = radius;
        this.createCircles();
        this.setSpacing(9);
        this.getChildren().addAll(circles);
        this.setAlignment(Pos.CENTER);
    }

    public void setColors(List<Color> colors){
        unselectAll();

        if ( colors.size() > 0)
            for ( int i = 0; i < colors.size(); i++){
                circles.get(i).setFill(colors.get(i));
            }
    }

    private void createCircles(){
        List <EffectedCircle> circles = new ArrayList<>(circlesQuantity);

        for ( int i = 0 ; i < circlesQuantity ; i++){
            circles.add(new EffectedCircle(radius));
        }

        this.circles = circles;
    }

    public void unselectAll(){
        circles.forEach(EffectedCircle::setDefaultFill);
    }
}
