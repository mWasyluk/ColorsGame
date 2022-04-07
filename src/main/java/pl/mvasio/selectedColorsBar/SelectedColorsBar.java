package pl.mvasio.selectedColorsBar;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pl.mvasio.circles.EffectedCircle;

import java.util.List;

public class SelectedColorsBar extends HBox {

    private final int circlesQuantity;
    private double radius;
    private double padding;
    private EffectedCircle [] circles;

    public SelectedColorsBar(int circlesQuantity, double radius, double spacing) {
        this.circlesQuantity = circlesQuantity;
        this.radius = radius;
        this.padding = padding;
        this.createCircles();
        this.setSpacing(9);
        this.getChildren().addAll(circles);
        this.setAlignment(Pos.CENTER);
    }

    public void setColors(List<Color> colors){
        unselectAll();
        if (colors.size() > 0){
            for ( int i = 0; i < colors.size(); i++){
                circles[i].setFill(colors.get(i));
            }
        }
    }

    private void createCircles(){
        EffectedCircle [] circles = new EffectedCircle[circlesQuantity];

        for ( int i = 0 ; i < circles.length ; i++){
            circles[i] = new EffectedCircle(radius);
        }

        this.circles = circles;
    }

    public EffectedCircle[] getCircles(){
        return circles;
    }

//    public void setLayout(double x , double y){
//        for ( int i = 0; i < circles.length; i++){
//            circles[i].setLayoutX(x + (i * (radius * 2 + padding)));
//            circles[i].setLayoutY(y);
//        }
//    }

    public void unselectAll(){
        for ( EffectedCircle c: circles){
            c.setDefaultFill();
        }
    }
}
