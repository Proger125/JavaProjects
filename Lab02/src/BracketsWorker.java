public class BracketsWorker {
    private int openBracketIndex;
    private int closeBracketIndex;
    private int maxBracketsLevel;



    public int getMaxBracketsLevel(){
        return maxBracketsLevel;
    }

    public BracketsWorker(){
        openBracketIndex = 0;
        closeBracketIndex = 0;
        maxBracketsLevel = 0;
    }
    public void findMaxLevelBrackets(StringBuilder stringBuilder){
        int bracketsLevel = 0;

        for (int i = 0; i < stringBuilder.length(); i++){
            if (stringBuilder.charAt(i) == '('){
                bracketsLevel++;
                boolean check = compareBracketsLevelWithMaxBracketsLevel(bracketsLevel);
                changeMaxBracketsLevel(check, bracketsLevel);
                changeOpenBracketIndex(check, i);
            }
            if (stringBuilder.charAt(i) == ')'){
                boolean check = compareBracketsLevelWithMaxBracketsLevel(bracketsLevel);
                changeCloseBracketIndex(check, i);
                bracketsLevel--;
            }
        }
    }
    private boolean compareBracketsLevelWithMaxBracketsLevel(int bracketsLevel){
        if (bracketsLevel >= maxBracketsLevel){
            return true;
        }
        return false;
    }
    private void changeOpenBracketIndex(boolean flag, int index){
        if (flag){
            openBracketIndex = index;
        }
    }
    private void changeCloseBracketIndex(boolean flag, int index){
        if (flag){
            closeBracketIndex = index;
        }
    }
    private void changeMaxBracketsLevel(boolean flag, int bracketsLevel){
        if (flag){
            maxBracketsLevel = bracketsLevel;
        }
    }
}
