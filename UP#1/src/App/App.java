package App;

public class App {
    public static void main(String[] args) {
        Number zero = new Number(0);
        Number one = new Number(1);
        Number two = new Number(2);
        Number six = new Number(6);

        try {
            Fraction fraction = new Fraction(one,two);
            Fraction fraction1 = new Fraction(zero,two);
            Fraction fraction2 = new Fraction(six, one);
            System.out.println(fraction.multiplicateFraction(fraction1).equals(fraction2.multiplicateFraction(fraction1)));
        } catch (MyException e) {
            e.print_message();
        }
    }
}
