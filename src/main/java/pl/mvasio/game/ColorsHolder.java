package pl.mvasio.game;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorsHolder {

    public final int COLORS_QUANTITY;
    private List<Color> colors ;

    public ColorsHolder( int colorsQuantity){
        COLORS_QUANTITY = colorsQuantity;
        colors = new ArrayList<>(COLORS_QUANTITY);
    }

    public void addColor(Color color){
        if( colors.size() < COLORS_QUANTITY){
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
