public class Rational {
    private static final char VINCULUM = '/';

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("The denominator can't be equal to zero.");
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        int gcd = MyCommonMath.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        return new Rational(
                numerator * other.denominator + denominator * other.numerator,
                denominator * other.denominator
        );
    }

    public Rational subtract(Rational other) {
        return new Rational(
                numerator * other.denominator - denominator * other.numerator,
                denominator * other.denominator
        );
    }

    public Rational multiply(Rational other) {
        return new Rational(
                numerator * other.numerator,
                denominator * other.denominator
        );
    }

    public Rational divide(Rational other) {
        return new Rational(
                numerator * other.denominator,
                denominator * other.numerator
        );
    }

    public int compareTo(Rational other) {
        return Integer.compare(numerator * other.denominator, denominator * other.numerator);
    }

    public String toString() {
        return denominator == 1 ?
                String.valueOf(numerator) :
                String.format("%d%c%d", numerator, VINCULUM, denominator);
    }

    public static Rational parseRational(String input) {
        Rational result;

        try {
            int vinculumPos = input.indexOf(VINCULUM);
            if (vinculumPos != -1) {
                int numerator = Integer.parseInt(input.substring(0, vinculumPos).trim());
                int denominator = Integer.parseInt(input.substring(vinculumPos + 1).trim());
                result = new Rational(numerator, denominator);
            } else {
                int numerator = Integer.parseInt(input.trim());
                result = new Rational(numerator, 1);
            }
        } catch (NumberFormatException ignored) {
            throw new NumberFormatException(String.format("Can't parse '%s' as input.", input));
        }

        return result;
    }
}
