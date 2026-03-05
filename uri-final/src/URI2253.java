import java.util.Scanner;

public class URI2253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String code = scanner.nextLine();

            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasInvalidChar = false;

            for (char ch : code.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowerCase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else {
                    hasInvalidChar = true;
                }
            }
            if (hasUpperCase && hasLowerCase && hasDigit && !hasInvalidChar
                    && code.length() >= 6 && code.length() <= 32) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");

            }
        }
    }
}
