import java.util.Scanner;

public class URI1743 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] connectors = new int[2][5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                connectors[i][j] = scanner.nextInt();
            }
        }

        for (int j = 0; j < 5; j++) {
            connectors[0][j] ^= 1;

            if (connectors[0][j] != connectors[1][j]) {
                System.out.println("N");
                System.exit(0);
            }
        }

        System.out.println("Y");
    }
}