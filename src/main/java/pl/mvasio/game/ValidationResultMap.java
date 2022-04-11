package pl.mvasio.game;

import java.util.*;

public class ValidationResultMap extends HashMap <Integer, String> {

    public final static String CORRECT = "CORRECT";
    public final static String MISPLACED = "MISPLACED";

    private int correctSelectionsQuantity = 0;
    private int misplacedSelectionsQuantity = 0;

    public ValidationResultMap(){
    }

    public void addCorrect(int index) {
        this.put(index, ValidationResultMap.CORRECT);
    }

    public void addMisplaced(int index) {
        this.put(index, ValidationResultMap.MISPLACED);
    }

    public void groupResult(){
        this.correctSelectionsQuantity = (int) this.values().stream().filter(e -> e.equals(CORRECT)).count();
        this.misplacedSelectionsQuantity = (int) this.values().stream().filter(e -> e.equals(MISPLACED)).count();
    }

    public int getCorrectSelectionsQuantity() {
        return this.correctSelectionsQuantity;
    }

    public int getMisplacedSelectionsQuantity() {
        return this.misplacedSelectionsQuantity;
    }

    public void setCorrectSelectionsQuantity(int correctSelectionsQuantity) {
        this.correctSelectionsQuantity = correctSelectionsQuantity;
    }

    public void setMisplacedSelectionsQuantity(int misplacedSelectionsQuantity) {
        this.misplacedSelectionsQuantity = misplacedSelectionsQuantity;
    }
}
