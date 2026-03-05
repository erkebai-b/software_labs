import java.util.Scanner;

public class URI1087 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
                break;
            }

            int msg;
            if (x1 == x2 && y1 == y2) {
                msg = 0;
            } else if (Math.abs(x2 - x1) == Math.abs(y2 - y1) || x1 == x2 || y1 == y2) {
                msg = 1;
            } else {
                msg = 2;
            }

            System.out.println(msg);
        }
    }
}
