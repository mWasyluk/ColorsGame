package pl.mvasio.view;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pl.mvasio.view.ModifiedCirclesRow;

import java.util.ArrayList;
import java.util.List;

public class RoundView extends HBox {
    private final static double VALIDATED_CIRCLE_RADIUS = 30;
    private final static double HINT_CIRCLE_RADIUS = 5;
    private final static double VALIDATED_CIRCLE_SPACING = 18;
    private final static double HINT_CIRCLE_SPACING = 8;
    private final static double VALIDATED_CIRCLE_PADDING = 10;
    private final static double HINT_CIRCLE_PADDING = VALIDATED_CIRCLE_RADIUS + HINT_CIRCLE_RADIUS;

    public RoundView (List<Color> selectedColors, int correctSelections, int misplacedSelections){
        this(selectedColors, correctSelections, misplacedSelections, selectedColors.size() - correctSelections - misplacedSelections);
    }

    public RoundView (List<Color> selectedColors, int correctSelections, int misplacedSelections, int wrongSelections){
        super(20);
        this.getChildren().add(getSelectedColorsView(selectedColors));
        this.getChildren().add(getHintView(correctSelections, misplacedSelections, wrongSelections));
    }

    private ModifiedCirclesRow getSelectedColorsView(List<Color> selectedColors){
        var row = new ModifiedCirclesRow(
                selectedColors.size(),
                VALIDATED_CIRCLE_RADIUS,
                VALIDATED_CIRCLE_SPACING,
                VALIDATED_CIRCLE_PADDING);
        row.setColors(selectedColors);
        return row;
    }

    private ModifiedCirclesRow getHintView (int correct, int misplaced, int wrong){
        List <Color> hintColors = new ArrayList<>(correct + misplaced + wrong);

        for (int i = 0; i < correct; i++) {
            hintColors.add( Color.BLACK );
        }
        for (int i = 0; i < misplaced; i++) {
            hintColors.add( Color.GRAY );
        }
        for (int i = 0; i < wrong; i++) {
            hintColors.add( Color.WHITE );
        }

        var row = new ModifiedCirclesRow(
                hintColors.size(),
                HINT_CIRCLE_RADIUS,
                HINT_CIRCLE_SPACING,
                HINT_CIRCLE_PADDING);
        row.setColors(hintColors);
        return row;
    }
}
