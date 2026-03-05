import java.util.Scanner;

public class URI1632 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int count = 1;
            String password = scanner.next();
            for (int j = 0; j < password.length(); j++) {
                char ch = password.charAt(j);
                if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I'
                        || ch == 'o' || ch == 'O' || ch == 's' || ch == 'S') {
                    count *= 3;
                } else {
                    count *= 2;
                }
            }

            System.out.println(count);
        }
    }
}