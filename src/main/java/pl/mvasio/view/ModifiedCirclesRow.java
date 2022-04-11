package pl.mvasio.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.mvasio.properties.GameplayProperties;

import java.util.ArrayList;
import java.util.List;

public class ModifiedCirclesRow extends HBox {
    private final List<Circle> circles;
    private double circlesRadius;

    public ModifiedCirclesRow(int quantity, double circlesRadius, double spacing, double padding){
        this.circles = new ArrayList<>(quantity);
        this.circlesRadius = circlesRadius;

        for (int i=0; i < quantity; i++){
            this.circles.add(ModifiedCircle.getModifiedCircle(circlesRadius));
        }
        this.setSpacing(spacing);
        this.setPadding(new Insets(padding));
        this.getChildren().addAll(this.circles);
        this.setAlignment(Pos.CENTER);
    }

    public void setColors(List <Color> colors){
        for (int i = 0; i < colors.size(); i++ ){
            this.circles.get(i).setFill(colors.get(i));
        }
    }

    public void setColorByIndex(int index, Color color){
        this.circles.get(index).setFill(color);
    }

    public void resetAllColorsToDefault(){
        this.circles.forEach( e -> e.setFill(GameplayProperties.DEFAULT_CIRCLE_COLOR) );
    }

    public void resetColorToDefaultByIndex(int index){
        this.circles.get(index).setFill( GameplayProperties.DEFAULT_CIRCLE_COLOR );
    }

    public double getCirclesRadius() {
        return this.circlesRadius;
    }

    public void setCirclesRadius(double circlesRadius) {
        this.circlesRadius = circlesRadius;
    }
}
