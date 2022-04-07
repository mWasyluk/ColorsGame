package pl.mvasio.game;

import javafx.scene.paint.Color;
import pl.mvasio.roundsView.RoundView;

import java.util.List;

public class NewGame {

    public final int ROUNDS_QUANTITY;
    public final int COLORS_TO_GUESS_QUANTITY;
    public final List<Color> COLORS_POOL;
    public final List<Color> EXPECTED_COLORS;

    private int remainingRounds;
    private ColorsHolder colorsHolder;

    public NewGame(int ROUNDS_QUANTITY, int COLORS_TO_GUESS_QUANTITY, List<Color> COLORS_POOL) {
        this.ROUNDS_QUANTITY = ROUNDS_QUANTITY;
        this.COLORS_TO_GUESS_QUANTITY = COLORS_TO_GUESS_QUANTITY;
        this.COLORS_POOL = COLORS_POOL;
        this.EXPECTED_COLORS = new ColorsGenerator( COLORS_POOL, COLORS_TO_GUESS_QUANTITY ).getColorsToGuess();
        this.remainingRounds = ROUNDS_QUANTITY;
        this.colorsHolder = new ColorsHolder(COLORS_TO_GUESS_QUANTITY);

        RoundView.newGame(ROUNDS_QUANTITY);
    }

    public void nextRound(){
        this.remainingRounds --;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public ColorsHolder getColorsHolder(){
        return this.colorsHolder;
    }

}
