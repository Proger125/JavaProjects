public class StringWorker {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder(args[0]);
        BracketsWorker bracketsWorker = new BracketsWorker(stringBuilder);
        bracketsWorker.findMaxLevelBrackets();
        int maxBracketsLevel = bracketsWorker.getMaxBracketsLevel();
        bracketsWorker.deleteAllBrackets();
        System.out.println(bracketsWorker.toString());
    }
}
