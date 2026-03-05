import java.util.Scanner;

public class URI1329 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int cases = scanner.nextInt();

            if (cases == 0) {
                break;
            }

            int mary = 0;
            int john = 0;

            for (int i = 0; i < cases; i++) {
                int results = scanner.nextInt();
                if (results == 0) {
                    mary++;
                } else {
                    john++;
                }
            }

            System.out.printf("Mary won %d times and John won %d times%n", mary, john);
        }
    }
}
