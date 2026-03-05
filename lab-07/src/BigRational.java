import java.math.BigInteger;

public class BigRational implements MyComparable, Comparable {
    private static final char VINCULUM = '/';

    private final BigInteger numerator;
    private final BigInteger denominator;

    public BigRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.compareTo(BigInteger.ZERO) == 0) {
            throw new ArithmeticException("The denominator can't be equal to zero.");
        }

        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public BigRational add(BigRational other) {
        return new BigRational(
                numerator.multiply(other.denominator).add(denominator.multiply(other.numerator)),
                denominator.multiply(other.denominator)
        );
    }

    public BigRational subtract(BigRational other) {
        return new BigRational(
                numerator.multiply(other.denominator).subtract(denominator.multiply(other.numerator)),
                denominator.multiply(other.denominator)
        );
    }

    public BigRational multiply(BigRational other) {
        return new BigRational(
                numerator.multiply(other.numerator),
                denominator.multiply(other.denominator)
        );
    }

    public BigRational divide(BigRational other) {
        return new BigRational(
                numerator.divide(other.denominator),
                denominator.multiply(other.numerator)
        );
    }

    public int compareTo(BigRational other) {
        return numerator.multiply(other.denominator).compareTo(denominator.multiply(other.numerator));
    }

    @Override
    public int compareTo(Object other) {
        return compareTo((BigRational) other);
    }

    public String toString() {
        return denominator.compareTo(BigInteger.ONE) == 0 ?
                numerator.toString() :
                String.format("%d%c%d", numerator, VINCULUM, denominator);
    }

    public static BigRational parseBigRational(String input) {
        BigRational result;

        try {
            int vinculumPos = input.indexOf(VINCULUM);
            if (vinculumPos != -1) {
                BigInteger numerator = new BigInteger(input.substring(0, vinculumPos).trim());
                BigInteger denominator = new BigInteger(input.substring(vinculumPos + 1).trim());
                result = new BigRational(numerator, denominator);
            } else {
                BigInteger numerator = new BigInteger(input.trim());
                result = new BigRational(numerator, BigInteger.ONE);
            }
        } catch (NumberFormatException ignored) {
            throw new NumberFormatException(String.format("Can't parse '%s' as input.", input));
        }

        return result;
    }
}
