package pl.mvasio.game;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorsGenerator {

    private final List<Color> possibleColors;
    private final List<Color> colorsToGuess;
    private final int COLORS_TO_GUESS_QUANTITY;

    public ColorsGenerator(List<Color> possibleColors, int howManyToGuess) {
        this.possibleColors = possibleColors;
        this.COLORS_TO_GUESS_QUANTITY = howManyToGuess;
        this.colorsToGuess = new ArrayList<>(COLORS_TO_GUESS_QUANTITY);
        createRandoms();
    }

    private void createRandoms(){
        for (int i = 0; i < COLORS_TO_GUESS_QUANTITY
                ; i++) {
            int random = new Random().nextInt(possibleColors.size());
            colorsToGuess.add(possibleColors.get(random));
        }
    }

    public List<Color> getColorsToGuess() {
        return colorsToGuess;
    }
}
