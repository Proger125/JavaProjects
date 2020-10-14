public class BracketsWorker {
    private StringBuilder stringBuilder;


    public BracketsWorker(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }
    public String toString(){
        return stringBuilder.toString();
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
