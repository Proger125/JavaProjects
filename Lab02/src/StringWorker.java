public class StringWorker {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder(args[0]);
        BracketsWorker bracketsWorker = new BracketsWorker();
        bracketsWorker.findMaxLevelBrackets(stringBuilder);
    }
}
