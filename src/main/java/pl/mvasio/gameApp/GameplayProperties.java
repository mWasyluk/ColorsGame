package pl.mvasio.gameApp;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Set;

public class GameplayProperties {

    public static final List<Color> DEFAULT_COLORS = List.of(
            Color.RED, Color.GREEN, Color.CORAL, Color.LIME, Color.PURPLE,
            Color.BLUE, Color.PINK, Color.BURLYWOOD, Color.FLORALWHITE );

    public static final int DEFAULT_COLOR_POOL_SIZE = 6;
    public static final int DEFAULT_EXPECTED_QUANTITY = 3;
    public static final int DEFAULT_ROUNDS_QUANTITY = 6;

    public static final double MANU_PALETTE_RADIUS = 110;
    public static final double INGAME_PALETTE_RADIUS = 100;

    public static final Set<Integer> COLORS_POOL_SIZE_OPTIONS = Set.of(
            3, 4, 5, 6, 7, 8, 9 );

    public static final Set<Integer> EXPECTED_COLORS_QUANTITY_OPTIONS = Set.of(
            2, 3, 4, 5, 6 );

    public static final Set<Integer> ROUNDS_QUANTITY_OPTIONS = Set.of(
            2, 3, 4, 5, 6, 7, 8 );

}
