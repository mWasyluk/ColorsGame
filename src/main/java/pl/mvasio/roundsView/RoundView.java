package pl.mvasio.roundsView;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class RoundView extends HBox {

    private boolean isGuessed = false;
    private HBox selectedColorsView;
    private HBox validationView;

    private final List <Color> expectedColors;
    private final List <Color> selectedColors;

    private static int roundsToEndGame = 0;

    private final static double RADIUS_FOR_BIG_CIRCLE = 30;
    private final static double RADIUS_FOR_LOW_CIRCLE = 5;
    private final static double SPACE_BETWEEN_BIG_CIRCLE = 18;
    private final static double SPACE_BETWEEN_LOW_CIRCLE = 8;
    private final static double PADDING_FOR_BIG_CIRCLE = 10;
    private final static double PADDING_FOR_LOW_CIRCLE = RADIUS_FOR_BIG_CIRCLE + RADIUS_FOR_LOW_CIRCLE;

    public RoundView (List <Color> expectedColors, List <Color> selectedColors){
        super(20);
        this.expectedColors = expectedColors;
        this.selectedColors = selectedColors;

        if ( roundsToEndGame > 0 ) {
            this.createRoundView( );
            this.getChildren().add(selectedColorsView);
            this.getChildren().add(validationView);
            roundsToEndGame --;
        }
    }

    public static void newGame(int rounds){
        roundsToEndGame = rounds;
    }

    private void createRoundView(){
        RoundValidator <Color> validator = new RoundValidator<>(this.expectedColors, this.selectedColors);
        int correct = validator.getQuantityOfCorrectAnswers();
        int missed = validator.getQuantityOfMissedAnswers();
        if ( correct == expectedColors.size()) isGuessed = true;
        List <Color> validationColors = getColorsForValidation(correct, missed);

        this.selectedColorsView = new RowOfCircles(this.selectedColors, RADIUS_FOR_BIG_CIRCLE, SPACE_BETWEEN_BIG_CIRCLE, PADDING_FOR_BIG_CIRCLE);
        this.validationView = new RowOfCircles(validationColors, RADIUS_FOR_LOW_CIRCLE, SPACE_BETWEEN_LOW_CIRCLE, PADDING_FOR_LOW_CIRCLE);
    }

    private List <Color> getColorsForValidation( int correct, int missed){
        int size = this.expectedColors.size();
        int c = correct;
        int m = missed;
        List <Color> list = new ArrayList<>(size);

        while (c > 0) {
            list.add( Color.BLACK );
            c--;
        }
        while ( m > 0 ){
            list.add( Color.GRAY );
            m--;
        }
        while ( size - ( correct + missed ) > 0){
            list.add( Color. WHITE );
            size--;
        }

        return list;
    }

    public static int getRoundsToEndGame() {
        return roundsToEndGame;
    }

    public boolean isGuessed() {
        return isGuessed;
    }
}
