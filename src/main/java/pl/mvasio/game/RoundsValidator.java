package pl.mvasio.game;

import javafx.scene.paint.Color;

import java.util.*;

public class RoundsValidator {

    private final List<Color> expectedColors;
    private ValidationResultMap resultMap;

    public RoundsValidator(List<Color> expectedColors) {
        this.expectedColors = new ArrayList<>(expectedColors);
    }

    public void validateWith ( List <Color> selectedColors ){
        this.resultMap = new ValidationResultMap();

        for (int i = 0; i < selectedColors.size(); i++){
            if (this.expectedColors.get(i) != null && selectedColors.get(i).equals(this.expectedColors.get(i)) ) {
                this.resultMap.addCorrect(i);
            }
        }
        for (int i = 0; i < selectedColors.size(); i++) {
            if (!selectedColors.get(i).equals(this.expectedColors.get(i))){
                for (int j = 0; j < this.expectedColors.size(); j++) {
                    if (selectedColors.get(i).equals(this.expectedColors.get(j)) && this.resultMap.get(j) == null) {
                        this.resultMap.addMisplaced(j);
                        break;
                    }
                }
            }
        }
        this.resultMap.groupResult();
    }

    public ValidationResultMap getResultMap(){
        return this.resultMap;
    }
}
