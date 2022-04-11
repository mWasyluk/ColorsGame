package pl.mvasio.game;

import javafx.scene.paint.Color;

import java.util.List;

import static pl.mvasio.properties.GameplayProperties.*;

public class GameSettings  {
    public static int COLORS_POOL_SIZE = DEFAULT_COLORS_POOL_SIZE;
    public static int COLORS_TO_GUESS_QUANTITY = DEFAULT_COLORS_TO_GUESS_QUANTITY;
    public static int ROUNDS_QUANTITY = DEFAULT_ROUNDS_QUANTITY;
    public static List<Color> FULL_COLORS_POOL = DEFAULT_COLORS_POOL;

    public static List<Color> getActualColorsPool(){
        return FULL_COLORS_POOL.subList(0, COLORS_POOL_SIZE);
    }

    public static void setDefaultSetting(){
        COLORS_POOL_SIZE = DEFAULT_COLORS_POOL_SIZE;
        COLORS_TO_GUESS_QUANTITY = DEFAULT_COLORS_TO_GUESS_QUANTITY;
        ROUNDS_QUANTITY = DEFAULT_ROUNDS_QUANTITY;
        FULL_COLORS_POOL = DEFAULT_COLORS_POOL;
    }
}
