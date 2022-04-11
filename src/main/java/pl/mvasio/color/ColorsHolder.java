package pl.mvasio.color;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorsHolder {

    public final int colorsQuantity;
    private final List<Color> colors ;

    public ColorsHolder( int colorsQuantity){
        this.colorsQuantity = colorsQuantity;
        colors = new ArrayList<>(this.colorsQuantity);
    }

    public void addColor(Color color){
        if( colors.size() < colorsQuantity){
            colors.add(color);
        }
    }

    public void removeColor (int index){
        if ( index >= 0){
            colors.remove(index);
        }
    }

    public void removeAllColors(){
        colors.clear();
    }

    public List<Color> getColors (){
        return colors;
    }

}
