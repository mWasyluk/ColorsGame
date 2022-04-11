package pl.mvasio.game;

import javafx.scene.paint.Color;
import pl.mvasio.color.ColorsGenerator;
import pl.mvasio.properties.GameplayProperties;

import java.util.List;

import static pl.mvasio.game.GameSettings.*;

public class Game {
    private final List<Color> colorsToGuess;

    private int remainingRounds;

    public Game () {
        this.colorsToGuess = ColorsGenerator.getNewColorsToGuessList();
        this.remainingRounds = ROUNDS_QUANTITY;
    }

    public void decreaseRemainingRounds(){
        this.remainingRounds --;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public List<Color> getColorsToGuess() {
        return colorsToGuess;
    }
}
