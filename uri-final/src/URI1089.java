import java.util.Scanner;

public class URI1089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int cases = scanner.nextInt();

            if (cases == 0) {
                break;
            }

            int[] magnitudes = new int[cases];
            for (int i = 0; i < cases; i++) {
                magnitudes[i] = scanner.nextInt();
            }

            int count = 0;
            if (cases == 2) {
                if (magnitudes[0] != magnitudes[1]) {
                    count = 2;
                }
            } else {
                for (int i = 0; i < cases; i++) {
                    if (i != 0 && i != cases - 1) {
                        if (magnitudes[i - 1] < magnitudes[i] && magnitudes[i + 1] < magnitudes[i]) {
                            count++;
                        }
                        if (magnitudes[i - 1] > magnitudes[i] && magnitudes[i + 1] > magnitudes[i]) {
                            count++;
                        }
                    }
                }

                if (magnitudes[0] > magnitudes[cases - 1] && magnitudes[0] > magnitudes[1] ||
                        magnitudes[0] < magnitudes[cases - 1] && magnitudes[0] < magnitudes[1]) {
                    count++;
                }
                if (magnitudes[cases - 1] > magnitudes[cases - 2] && magnitudes[cases - 1] > magnitudes[0] ||
                        magnitudes[cases - 1] < magnitudes[cases - 2] && magnitudes[cases - 1] < magnitudes[0]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}