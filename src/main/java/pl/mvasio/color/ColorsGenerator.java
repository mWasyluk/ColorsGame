package pl.mvasio.color;

import javafx.scene.paint.Color;
import pl.mvasio.game.GameSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ColorsGenerator {
    public static List<Color> getNewColorsToGuessList() {
        List<Color> tmp = new ArrayList<>(GameSettings.COLORS_TO_GUESS_QUANTITY);
        for (int i = 0; i < GameSettings.COLORS_TO_GUESS_QUANTITY; i++) {
            int random = new Random().nextInt(GameSettings.getActualColorsPool().size());
            tmp.add(GameSettings.getActualColorsPool().get(random));
        }
        return tmp;
    }

    public static Color getRandomColor(){
        return Color.rgb(
                new Random().nextInt(256),
                new Random().nextInt(256),
                new Random().nextInt(256),
                1);
    }

    public static List <Color> getRandomColorsList(int quantity){
        List <Color> tmp = new ArrayList<>(quantity);
        for ( int i = 0 ; i < quantity ; i ++){
            tmp.add(getRandomColor());
        }
        return tmp;
    }
}