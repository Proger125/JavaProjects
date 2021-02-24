package App;

import java.util.Objects;

import static java.lang.StrictMath.abs;

public class Number {

    private Integer number;
    public Number(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer findGCD(Integer first, Integer second){
        Integer numerator = abs(first);
        Integer denominator = abs(second);
        if (denominator == 0){
            return numerator;
        }else{
            return findGCD(denominator, numerator % denominator);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Double.compare(number1.number, number) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        StringBuilder returnStatement = new StringBuilder(number.toString());
        return returnStatement.toString();
    }
}
