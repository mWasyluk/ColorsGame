package pl.mvasio.colorsPalete;

import javafx.scene.paint.Color;

import java.util.Random;

public class RandomColor  {

    public static Color getRandomColor(){
        return Color.rgb(
                new Random().nextInt(256),
                new Random().nextInt(256),
                new Random().nextInt(256),
                1);
    }

    public static Color [] getRandomColorsArray (int quantity){
        Color [] tmp = new Color[quantity];
        for ( int i = 0 ; i < quantity ; i ++){
            tmp[i] = getRandomColor();
        }
        return tmp;
    }
}
