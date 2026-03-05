import java.util.Scanner;

public class URI1581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; ++i) {
            boolean english = false;
            int nLanguages = scanner.nextInt();

            String firstLanguage = scanner.next();
            for (int k = 1; k < nLanguages; ++k) {
                String restLanguages = scanner.next();
                if (!restLanguages.equals(firstLanguage)) {
                    english = true;
                }
            }

            if (english) {
                System.out.println("ingles");
            } else {
                System.out.println(firstLanguage);
            }
        }
    }
}
