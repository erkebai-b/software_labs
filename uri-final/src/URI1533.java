import java.util.Scanner;

public class URI1533 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int cases = scanner.nextInt();
            int indexV = -1;
            int indexMax = 1;

            if (cases == 0) {
                break;
            }

            int max = 0;
            int value = 0;
            for (int i = 0; i < cases; i++) {
                int suspects = scanner.nextInt();
                if (suspects > max) {
                    value = max;
                    indexV = indexMax;
                    max = suspects;
                    indexMax = i + 1;
                } else if (suspects > value) {
                    value = suspects;
                    indexV = i + 1;
                }
            }
            System.out.println(indexV);
        }
    }
}
