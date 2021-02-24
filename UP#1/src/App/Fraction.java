package App;

import java.util.Objects;

import static java.lang.StrictMath.abs;

public class Fraction{
    private Number numerator;
    private Number denominator;

    public Fraction(Number numerator, Number denominator) throws MyException {
        if (denominator.getNumber() != 0){
        this.numerator = numerator;
        this.denominator = denominator;
        }else throw new MyException("Dividing by zero");
    }

    private Integer findGCD(Integer first, Integer second){
        Integer numerator = abs(first);
        Integer denominator = abs(second);
        if (denominator == 0){
            return numerator;
        }else{
            return findGCD(denominator, numerator % denominator);
        }
    }

    private void divideByGCD(Integer first, Integer second){
        Integer gcd = findGCD(first,second);
        first /= gcd;
        second /= gcd;
    }


    public Fraction addFraction(Fraction fraction) throws MyException {
        Integer denominator = fraction.denominator.getNumber() * this.denominator.getNumber();
        Integer numerator = this.numerator.getNumber() * fraction.denominator.getNumber() +
                this.denominator.getNumber() * fraction.numerator.getNumber();
        divideByGCD(numerator,denominator);
        Fraction sum = new Fraction(new Number(numerator), new Number(denominator));
        return sum;
    }

    public Fraction substractFraction(Fraction fraction) throws MyException {
        Integer denominator = fraction.denominator.getNumber() * this.denominator.getNumber();
        Integer numerator = this.numerator.getNumber() * fraction.denominator.getNumber() -
                this.denominator.getNumber() * fraction.numerator.getNumber();;
        divideByGCD(numerator, denominator);
        Fraction substraction = new Fraction(new Number(numerator), new Number(denominator));
        return substraction;
    }

    public Fraction multiplicateFraction(Fraction fraction) throws MyException {
        Integer numerator = fraction.numerator.getNumber() * this.numerator.getNumber();
        Integer denominator = fraction.denominator.getNumber() * this.denominator.getNumber();
        divideByGCD(numerator,denominator);
        Fraction multiplication = new Fraction(new Number(numerator), new Number(denominator));
        return multiplication;
    }

    public Fraction divideFraction(Fraction fraction) throws MyException {
            Integer numerator = fraction.denominator.getNumber() * this.numerator.getNumber();
            Integer denominator = fraction.numerator.getNumber() * this.denominator.getNumber();
            divideByGCD(numerator,denominator);
            Fraction quotient = new Fraction(new Number(numerator), new Number(denominator));
            return quotient;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(numerator.toString().concat("/").concat(denominator.toString()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator.equals(fraction.numerator) &&
                denominator.equals(fraction.denominator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
};
