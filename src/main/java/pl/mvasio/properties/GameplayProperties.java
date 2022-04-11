package pl.mvasio.properties;

import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import pl.mvasio.view.PaletteEffect;

import java.util.List;

public interface GameplayProperties {
    List<Color> DEFAULT_COLORS_POOL = List.of(
            Color.RED, Color.GREEN, Color.CORAL, Color.LIME, Color.PURPLE,
            Color.BLUE, Color.PINK, Color.BURLYWOOD, Color.FLORALWHITE );

    int DEFAULT_COLORS_POOL_SIZE = 6;
    int DEFAULT_COLORS_TO_GUESS_QUANTITY = 3;
    int DEFAULT_ROUNDS_QUANTITY = 6;

    double DEFAULT_MENU_PALETTE_RADIUS = 110;
    double DEFAULT_INGAME_PALETTE_RADIUS = 110;
    double DEFAULT_SELECTED_COLOR_CIRCLE_RADIUS = 15;
    double DEFAULT_SELECTED_COLOR_CIRCLE_SPACING = 9;
    double DEFAULT_SELECTED_COLOR_CIRCLE_PADDING = 0;

    List<Integer> COLORS_POOL_SIZE_OPTIONS = List.of(
            3, 4, 5, 6, 7, 8, 9 );

    List<Integer> COLORS_TO_GUESS_QUANTITY_OPTIONS = List.of(
            2, 3, 4, 5, 6 );

    List<Integer> ATTEMPTS_QUANTITY_OPTIONS = List.of(
            2, 3, 4, 5, 6, 7, 8 );

    Color DEFAULT_CIRCLE_COLOR = Color.rgb(255, 255, 255, 0.6);
    Color DEFAULT_CIRCLE_STROKE_COLOR = Color.rgb(0, 0, 0);
    StrokeType DEFAULT_CIRCLE_STROKE_TYPE = StrokeType.INSIDE;

    Effect PALETTE_DEFAULT_EFFECT = PaletteEffect.getDefaultEffect();
    Effect PALETTE_HOVER_EFFECT = PaletteEffect.getHoverEffect();

    String WINNER_ALERT_HEADER = "Brawo. Udało Ci się odgadnąć sekwencję!";
    String WINNER_ALERT_CONTENT = "Nacisnij 'OK', aby spróbować ponownie.";
    String LOSER_ALERT_HEADER = "Niestety, nie udało Ci się.";
    String LOSER_ALERT_CONTENT = "Nacisnij 'OK', aby spróbować ponownie.";
}
