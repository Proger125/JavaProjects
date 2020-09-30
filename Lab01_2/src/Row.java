public class Row {
    public static void main(String[] args){
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException();
            }
            double x = Double.parseDouble(args[0]);
            double delta = Double.parseDouble(args[1]);
            double sumOfRow = rowCalculating(x, delta);
            System.out.println(sumOfRow);
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
    private static double rowCalculating(double x, double delta){
        int k = 1;
        double sumOfRow = 0;
        double currentElement = itemCalculating(x, k);
        k++;
        double nextElement = itemCalculating(x,k);
        sumOfRow += currentElement;
        while(Math.abs(nextElement) - Math.abs(currentElement) > delta){
            sumOfRow += nextElement;
            currentElement = nextElement;
            k++;
            nextElement = itemCalculating(x, k);
        }
        return sumOfRow;
    }
    private static double itemCalculating(double x, int k){
        double currentItem = Math.pow((-1), k) * Math.pow(x, k+2) / ((k + 1) * factorial(k + 2));
        return currentItem;
    }
    private static double factorial(int n){
        int result = 1;
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
