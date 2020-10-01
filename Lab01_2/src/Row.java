public class Row {
    public static void main(String[] args){
        try {
            if (args.length != 2) {
                throw new RowException("You should enter only 2 params");
            }
            double x = Double.parseDouble(args[0]);
            double delta = Double.parseDouble(args[1]);
            if (delta < 0){
                throw new RowException("Your delta should be more the 0");
            }
            double sumOfRow = rowCalculating(x, delta);
            System.out.println(sumOfRow);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    private static double rowCalculating(double x, double delta){
        int k = 1;
        double sumOfRow = 0;
        double currentElement = firstItemCalculating(x, k);
        double nextElement = nextItemCalculating(currentElement, x,k);
        sumOfRow += currentElement;
        while(Math.abs(Math.abs(nextElement) - Math.abs(currentElement)) > delta){
            sumOfRow += nextElement;
            currentElement = nextElement;
            k++;
            nextElement = nextItemCalculating(currentElement,x, k);
        }
        return sumOfRow;
    }
    private static double firstItemCalculating(double x, int k){
        double currentItem = Math.pow((-1), k) * Math.pow(x, k+2) / ((k + 1) * factorial(k + 2));
        return currentItem;
    }
    private static double nextItemCalculating(double previousElement,double x, int k){
        double nextElement = previousElement * (-1) * x * (k + 1) / ((k + 2) * (k + 3));
        return nextElement;
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
