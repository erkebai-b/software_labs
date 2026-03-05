import java.util.Scanner;

public class URI1237 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String w1 = scanner.nextLine();
            String w2 = scanner.nextLine();

            String bigger;
            String smaller;

            if (w1.length() > w2.length()) {
                bigger = w1;
                smaller = w2;
            } else {
                bigger = w2;
                smaller = w1;
            }

            int max = 0;
            for (int i = 0; i < smaller.length(); i++) {
                for (int k = i; k < smaller.length(); k++) {
                    String subs = smaller.substring(i, k + 1);
                    if (bigger.contains(subs)) {
                        if (subs.length() > max) {
                            max = subs.length();
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }
}
