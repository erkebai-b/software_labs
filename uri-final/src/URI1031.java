import java.util.Scanner;

public class URI1031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numOfRegion = scanner.nextInt();

            if (numOfRegion == 0) {
                break;
            }

            int counter = 1;

            while (true) {
                if (remain(numOfRegion, counter) != 11) {
                    counter++;
                } else {
                    break;
                }
            }

            System.out.println(counter);
        }
    }

    private static int remain(int num, int count) {
        int result = 0;
        for (int i = 1; i < num; i++) {
            result = (result + count) % i;
        }
        return result;
    }
}
