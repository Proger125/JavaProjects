public class BracketsWorker {
    private int openBracketIndex;
    private int closeBracketIndex;
    private int maxBracketsLevel;
    private StringBuilder stringBuilder;


    public int getMaxBracketsLevel(){
        return maxBracketsLevel;
    }

    public BracketsWorker(StringBuilder stringBuilder){
        this.openBracketIndex = 0;
        this.closeBracketIndex = 0;
        this.maxBracketsLevel = 0;
        this.stringBuilder = stringBuilder;
    }
    public String toString(){
        return stringBuilder.toString();
    }
    public void findMaxLevelBrackets(){
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
    public void deleteAllBrackets(){
        int openIndex = -1;
        int closeIndex = -1;
        int i = 0;
        while (i < stringBuilder.length()){
            if (stringBuilder.charAt(i) == '('){
                openIndex = i;
            }
            if (stringBuilder.charAt(i) == ')'){
                if (openIndex != -1){
                    closeIndex = i;
                }
            }
            if (openIndex != -1 && closeIndex != -1){
                stringBuilder.delete(openIndex, closeIndex + 1); // +1 because we should delete last element too
                i = openIndex - 1;
                openIndex = -1;
                closeIndex = -1;
            }
            i++;
        }
    }
}
