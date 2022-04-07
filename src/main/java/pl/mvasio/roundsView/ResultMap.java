package pl.mvasio.roundsView;

import java.util.*;

public class ResultMap extends HashMap <Integer, String> {

    public final static String CORRECT = "CORRECT";
    public final static String MISSED = "MISSED";
    public final static String WRONG = "WRONG";

    private int correctQuantity;
    private int missedQuantity;

    public ResultMap(int quantity){
        this.implementWithWrong(quantity);
    }

    private void implementWithWrong(int i){
        for ( int j = 0; j < i; j++){
            this.put(j, ResultMap.WRONG);
        }
    }

    public void addCorrect(int index) {
        this.put(index, ResultMap.CORRECT);
    }

    public void addMissed(int index) {
        this.put(index, ResultMap.MISSED);
    }

    public void groupResult(){
        correctQuantity = 0;
        missedQuantity = 0;

        for ( int i = 0; i < this.size(); i++){
            if ( this.get(i).equals(ResultMap.CORRECT)) correctQuantity++;
            else if ( this.get(i).equals(ResultMap.MISSED)) missedQuantity++;
        }
    }

    public int getCorrectQuantity() {
        return correctQuantity;
    }

    public int getMissedQuantity() {
        return missedQuantity;
    }
}
