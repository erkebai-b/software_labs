import java.util.Scanner;

public class URI1285 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int startNum = scanner.nextInt();
            int endNum = scanner.nextInt();

            boolean ok;
            int count = 0;
            for (int i = startNum; i <= endNum; i++) {
                int[] digits = new int[10];
                int timeLimit = i;
                ok = true;
                while (timeLimit >= 1) {
                    digits[timeLimit % 10]++;
                    timeLimit /= 10;
                }

                for (int j = 0; j < 10; j++) {
                    if (digits[j] > 1) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
