import java.io.EOFException;
import java.util.Scanner;

public class Problem02 {

    private static BigRational getBigRational(String message, Scanner scanner) throws EOFException {
        BigRational num1 = null;
        do {
            System.out.print(message);

            if (!scanner.hasNextLine()) {
                throw new EOFException();
            }
            String line = scanner.nextLine();
            try {
                num1 = BigRational.parseBigRational(line);
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (num1 == null);

        return num1;
    }

    private static String getOperator(Scanner scanner) throws EOFException {
        String operator = null;
        do {
            System.out.print("Operator: ");
            if (!scanner.hasNextLine()) {
                throw new EOFException();
            }

            String line = scanner.nextLine();
            switch (line) {
                case "+", "-", "*", "/", "<", ">", "=", "!=", "<=", ">=" -> operator = line;
                default -> System.out.printf("Error: '%s' is not a valid operator.%n", line);
            }
        } while (operator == null);

        return operator;
    }

    public static void main(String[] args) {
        System.out.println(
                """
                        Calculator of BigRational Numbers
                        ==============================
                        Press Ctrl/Command-Z/D to exit
                        """
        );

        var scanner = new Scanner(System.in);
        while (true) {
            BigRational num1, num2;
            String operator;
            try {
                num1 = getBigRational("First BigRational: ", scanner);
                operator = getOperator(scanner);
                num2 = getBigRational("Second BigRational: ", scanner);
            } catch (EOFException ignored) {
                break;
            }

            try {
                var result = switch (operator) {
                    case "+" -> num1.add(num2);
                    case "-" -> num1.subtract(num2);
                    case "*" -> num1.multiply(num2);
                    case "/" -> num1.divide(num2);
                    case "<" -> num1.compareTo(num2) < 0;
                    case ">" -> num1.compareTo(num2) > 0;
                    case "=" -> num1.compareTo(num2) == 0;
                    case "!=" -> num1.compareTo(num2) != 0;
                    case "<=" -> num1.compareTo(num2) <= 0;
                    case ">=" -> num1.compareTo(num2) >= 0;
                    default -> throw new RuntimeException("Should never happen");
                };
                System.out.printf("Result: %s %s %s: %s%n", num1, operator, num2, result);
            } catch (ArithmeticException e) {
                System.out.println("Error : Can't divide by zero.");
            }
            System.out.println();
        }
    }
}
