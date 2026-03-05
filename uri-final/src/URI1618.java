import java.util.Scanner;

public class URI1618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int ax = scanner.nextInt();
            int ay = scanner.nextInt();
            int bx = scanner.nextInt();
            int by = scanner.nextInt();
            int cx = scanner.nextInt();
            int cy = scanner.nextInt();
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();
            int rx = scanner.nextInt();
            int ry = scanner.nextInt();

            if (rx >= ax && ry >= ay && rx <= bx && ry >= by &&
                    rx >= dx && ry <= dy && rx <= cx && ry <= cy) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
