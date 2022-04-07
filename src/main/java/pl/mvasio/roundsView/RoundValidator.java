package pl.mvasio.roundsView;

import java.util.List;

public class RoundValidator <T> {

    private ResultMap resultMap;

    public RoundValidator( List<T> expected, List <T> selected)  {
        this.validateLists( expected, selected );
    }

    private void validateLists( List<T> expected, List <T> selected ){
        resultMap = new ResultMap(selected.size());

        for ( int i = 0; i < expected.size(); i++){
            if ( expected.get(i).equals( selected.get(i) )){
                resultMap.addCorrect(i);
            }
        }
        for ( int i = 0; i < expected.size(); i++){
            if ( expected.get(i).equals(selected.get(i)) ) {
                continue;
            }
            for ( int j = 0; j < expected.size(); j++ ){
                if ( resultMap.get(j).equals(ResultMap.WRONG) ) {
                    if (expected.get(i).equals(selected.get(j))) {
                        resultMap.addMissed(j);
                        break;
                    }
                }
            }
        }
        resultMap.groupResult();
    }

    public int getQuantityOfCorrectAnswers (){
        return resultMap.getCorrectQuantity();
    }

    public int getQuantityOfMissedAnswers (){
        return resultMap.getMissedQuantity();
    }
}
