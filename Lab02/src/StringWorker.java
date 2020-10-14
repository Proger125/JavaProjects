public class StringWorker {
    public static void main(String[] args){
        try {
            if (args.length != 1) {
                throw new ArrayIndexOutOfBoundsException("You should enter only 1 parameter");
            }
            StringBuilder stringBuilder = new StringBuilder(args[0]);
            BracketsWorker bracketsWorker = new BracketsWorker(stringBuilder);
            bracketsWorker.deleteAllBrackets();
            System.out.println(bracketsWorker.toString());
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
